package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void update(Resume resume) {
        int i = getIndex(resume.getUuid());
        if (i != -1) {
            storage[i] = resume;
        } else {
            System.out.println("Resume doesn't exist");
        }
    }

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            index = -index - 1;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;
        size++;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("No resume found");
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
