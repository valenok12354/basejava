package com.company.webapp.storage;

import com.company.webapp.exception.ExistStorageException;
import com.company.webapp.exception.StorageException;
import com.company.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected int size = 0;
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected abstract void inputElement(Resume resume, int index);

    protected abstract void deletedElement(int index);

    @Override
    protected Integer getSearchKey(String uuid) {
        return 0;
    }

    @Override
    protected Resume doGet(Object index) {
        return storage[(int) index];
    }

    @Override
    protected void doUpdate(Object index, Resume resume) {
        storage[(int) index] = resume;
    }

    @Override
    protected void doDelte(Object index) {
        deletedElement((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected void doSave(Object index, Resume resume) {
        if ((int) index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            inputElement(resume, (int) index);
            size++;
        }
    }

    @Override
    public int size() {
        return size;
    }
}
