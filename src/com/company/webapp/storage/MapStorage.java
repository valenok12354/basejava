package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapStorage extends AbstractStorage {
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
    protected void doDelte(Object index) {
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