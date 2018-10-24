package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume doGet(Object index) {
        return mapStorage.get((String) index);
    }

    @Override
    protected void doUpdate(Object index, Resume resume) {
        mapStorage.put((String) index, resume);
    }

    @Override
    protected void doSave(Object index, Resume resume) {
        mapStorage.put((String) index, resume);
    }

    @Override
    protected void doDelete(Object index) {
        mapStorage.remove((String) index);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return mapStorage.containsKey((String) searchKey);
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumes = new ArrayList<>(mapStorage.values());
        resumes.sort(Comparator.comparing(Resume::getUuid));
        return resumes;
    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}