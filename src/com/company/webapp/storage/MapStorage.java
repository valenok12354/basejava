package com.company.webapp.storage;

import com.company.webapp.exception.ExistStorageException;
import com.company.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected String getIndex(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public void delete(String uuid) {
        mapStorage.remove(uuid);
    }

    @Override
    public void save(Resume resume) {
        String index = getIndex(resume.getUuid());
        for (Map.Entry<String, Resume> entry : mapStorage.entrySet()) {
            if (entry.getValue().equals(resume)) {
                throw new ExistStorageException(resume.getUuid());
            }
        }
        mapStorage.put(index, resume);
    }

    @Override
    public Resume get(String uuid) {
        String index = getIndex(uuid);
        NotNullCheck(uuid);
        return mapStorage.get(index);

    }

    @Override
    public void update(Resume resume) {
        String index = getIndex(resume.getUuid());
        NotNullCheck(resume.getUuid());
        mapStorage.put(index, resume);
    }

    @Override
    public Resume[] getAll() {
        Set<Resume> treeSet = new TreeSet<>();
        for (Map.Entry<String, Resume> entry : mapStorage.entrySet()) {
            treeSet.add(entry.getValue());
        }
        return treeSet.toArray(new Resume[treeSet.size()]);
    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}