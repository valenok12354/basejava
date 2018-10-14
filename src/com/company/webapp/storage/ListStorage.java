package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> listStorage = new ArrayList<>();

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (listStorage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clearDifferentTypes() {
        listStorage.clear();
    }

    @Override
    public void deleteDiffrentCollections(String uuid) {
        listStorage.remove(getIndex(uuid));
    }

    @Override
    public void saveDifferentCollections(Resume resume) {
        listStorage.add(resume);
    }

    @Override
    protected Resume getDifferentTypes(String uuid) {
        return listStorage.get(getIndex(uuid));
    }

    @Override
    public void getAllTypes() {
        for (int i = 0; i < size; i++) {
            storage[i] = listStorage.get(i);
        }
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        listStorage.set(index, resume);
    }
}