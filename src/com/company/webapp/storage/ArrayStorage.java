package com.company.webapp.storage;

import com.company.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void inputElement(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected void deletedElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void deleteDiffrentCollections(String uuid) {

    }

    @Override
    protected void saveDifferentCollections(Resume r) {

    }

    @Override
    protected Resume getDifferentTypes(String uuid) {
        return null;
    }

    @Override
    public void getAllTypes() {

    }
}

