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
    protected Integer getIndex(String uuid) {
        return 0;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume get(String uuid) {
        Integer index = getIndex(uuid);
        NotNullCheck(uuid);
        return storage[index];
    }

    @Override
    public void update(Resume resume) {
        Integer index = getIndex(resume.getUuid());
        NotNullCheck(resume.getUuid());
        storage[index] = resume;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public void save(Resume resume) {
        Integer index = getIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            inputElement(resume, index);
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        Integer index = getIndex(uuid);
        NotNullCheck(uuid);
        deletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

}
