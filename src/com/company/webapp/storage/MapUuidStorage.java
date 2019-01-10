package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.io.InputStream;
import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String searchKey) {
        return mapStorage.containsKey(searchKey);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return mapStorage.get(searchKey);
    }

    @Override
    protected void doUpdate(Resume resume, String searchKey) {
        mapStorage.put(searchKey, resume);
    }

    @Override
    protected void doSave(Resume resume, String searchKey) {
        mapStorage.put(searchKey, resume);
    }

    @Override
    protected void doDelete(String searchKey) {
        mapStorage.remove(searchKey);
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