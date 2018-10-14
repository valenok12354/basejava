package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractStorage implements Storage {
    protected int size = 0;
    protected static final int STORAGE_LIMIT = 10000;
    protected static Resume[] storage = new Resume[STORAGE_LIMIT];

    protected abstract int getIndex(String uuid);

    protected abstract void clearDifferentTypes();

    protected abstract void deleteDiffrentCollections(String uuid);

    protected abstract void saveDifferentCollections(Resume r);

    protected abstract Resume getDifferentTypes(String uuid);

    protected abstract void getAllTypes();

    @Override
    public void clear() {
        clearDifferentTypes();
        size = 0;
    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public void save(Resume r) {
        saveDifferentCollections(r);
        size++;
    }

    @Override
    public Resume get(String uuid) {
        return getDifferentTypes(uuid);
    }

    @Override
    public void delete(String uuid) {
        deleteDiffrentCollections(uuid);
        size--;
    }

    @Override
    public Resume[] getAll() {
        getAllTypes();
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public int size() {
        return size;
    }
}
