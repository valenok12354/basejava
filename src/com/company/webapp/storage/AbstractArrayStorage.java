package com.company.webapp.storage;

import com.company.webapp.exception.StorageException;
import com.company.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected int size = 0;
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected abstract void inputElement(Resume resume, int index);

    protected abstract void deletedElement(int index);

    @Override
    protected Resume doGet(Object index) {
        return storage[(int) index];
    }

    @Override
    protected void doUpdate(Object index, Resume resume) {
        storage[(int) index] = resume;
    }

    @Override
    protected void doDelete(Object index) {
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
    public List<Resume> getAllSorted() {
        List<Resume> resumes = Arrays.asList(Arrays.copyOfRange(storage, 0, size));
        resumes.sort(Comparator.comparing(Resume::getUuid));
        return resumes;
    }

    @Override
    protected void doSave(Object index, Resume resume) {
        if (size == STORAGE_LIMIT) {
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
