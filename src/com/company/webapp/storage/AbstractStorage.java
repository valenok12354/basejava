package com.company.webapp.storage;

import com.company.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

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
    public Resume get(String uuid) {
        return null;
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
