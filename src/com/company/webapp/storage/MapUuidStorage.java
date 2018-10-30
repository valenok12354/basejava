package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume doGet(String index) {
        return mapStorage.get(index);
    }

    @Override
    protected void doUpdate(String index, Resume resume) {
        mapStorage.put(index, resume);
    }

    @Override
    protected void doSave(String index, Resume resume) {
        mapStorage.put(index, resume);
    }

    @Override
    protected void doDelete(String index) {
        mapStorage.remove(index);
    }

    @Override
    protected boolean isExist(String searchKey) {
        return mapStorage.containsKey(searchKey);
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public List<Resume> getList() {
        return new ArrayList<>(mapStorage.values());
    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}