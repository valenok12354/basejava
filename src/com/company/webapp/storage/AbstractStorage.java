package com.company.webapp.storage;

import com.company.webapp.exception.NotExistStorageException;
import com.company.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getIndex(String uuid);

    void NotNullCheck(String uuid) {
        if (getIndex(uuid) == null) {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public void clear() {
    }

    @Override
    public void update(Resume r) {
    }

    @Override
    public void save(Resume r) {
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
