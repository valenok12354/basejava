package com.company.webapp.storage;

import com.company.webapp.exception.ExistStorageException;
import com.company.webapp.exception.NotExistStorageException;
import com.company.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> mapStorage = new HashMap<>();

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
        String index = resume.getUuid();
        if (index == null) {
            throw new ExistStorageException(index);
        } else mapStorage.put(index, resume);
    }

    @Override
    public Resume get(String uuid) {
        if (uuid == null) {
            throw new NotExistStorageException(uuid);
        } else {
            return mapStorage.get(uuid);
        }
    }

    @Override
    public void update(Resume resume) {
        if (resume.getUuid() != null) {
            mapStorage.put(resume.getUuid(), resume);
        } else throw new NotExistStorageException(resume.getUuid());
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