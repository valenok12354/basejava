package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void save(Resume resume) {
        if (count < storage.length) {
            if (getIndex(resume.getUuid()) == -1) {
                storage[count] = resume;
                count++;
            } else {
                System.out.println("Resume exist");
            }
        } else {
            System.out.println("There is no disk space");
        }
    }

    public void update(Resume resume) {
        int i = getIndex(resume.getUuid());
        if (i != -1) {
            storage[i] = resume;
        } else {
            System.out.println("Resume doesn't exist");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            System.out.println("No resume found");
            return null;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        storage[index] = storage[count - 1];
        storage[count - 1] = null;
        count--;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}

