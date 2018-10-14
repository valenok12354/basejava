package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    public void clearDifferentTypes() {
        mapStorage.clear();
    }

    @Override
    public void deleteDiffrentCollections(String uuid) {
        mapStorage.remove(uuid);
    }

    @Override
    public void saveDifferentCollections(Resume resume) {
        mapStorage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getDifferentTypes(String uuid) {
        return mapStorage.get(uuid);
    }

    @Override
    public void getAllTypes() {
        Set<Resume> treeSet = new TreeSet<>();
        for (Map.Entry<String, Resume> entry : mapStorage.entrySet()) {
            treeSet.add(entry.getValue());
            storage = treeSet.toArray(new Resume[treeSet.size()]);
        }
    }

    @Override
    public void update(Resume resume) {
        saveDifferentCollections(resume);
    }
}