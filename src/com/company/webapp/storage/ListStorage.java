package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> listStorage = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (listStorage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return listStorage.get(searchKey);
    }

    @Override
    protected void doUpdate(Integer searchKey, Resume resume) {
        listStorage.set(searchKey, resume);
    }

    @Override
    protected void doSave(Integer searchKey, Resume resume) {
        listStorage.add(resume);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        listStorage.remove(searchKey.intValue());
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public List<Resume> getList() {
        return new ArrayList<>(listStorage);
    }

    @Override
    public int size() {
        return listStorage.size();
    }
}