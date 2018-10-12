package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected List<Resume> storage = new ArrayList<>();
    protected int size = 0;

    @Override
    public void clear() {
        storage.clear();
        size = 0;
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        storage.set(index, resume);
    }

    @Override
    public void save(Resume resume) {
        storage.add(resume);
        size++;
    }

    @Override
    public Resume get(String uuid) {
        return storage.get(getIndex(uuid));
    }

    @Override
    public void delete(String uuid) {
        storage.remove(getIndex(uuid));
        size--;
    }

    @Override
    public Resume[] getAll() {
        Resume[] arrResume = new Resume[AbstractArrayStorage.STORAGE_LIMIT];
        for (int i = 0; i < size; i++) {
            arrResume[i] = storage.get(i);
        }
        return Arrays.copyOfRange(arrResume, 0, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}