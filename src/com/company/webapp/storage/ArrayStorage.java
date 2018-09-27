package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int count = 0;

    void clear() {
        Arrays.fill(storage, 0, size(), null);
    }

    public void save(Resume r) {
        if (!isExistResume(r)) {
            storage[count] = r;
            count++;
        } else System.out.println("Resume exist");
    }

    private boolean isExistResume(Resume r) {
        return Arrays.asList(storage).contains(r);
    }

    public void update(Resume r) {
        if (isExistResume(r)) {
            storage[Arrays.asList(storage).indexOf(r)] = r;
        } else System.out.println("Resume doesn't exist");
    }

    public Resume get(String uuid) {
        if (isExistUuid(uuid)) {
            for (int i = 0; i < count; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    return storage[i];
                }
            }
        } else System.out.println("Resume doesn't exist");
        return null;
    }

    private boolean isExistUuid(String uuid) {
        return (uuid != null);
    }

    public void delete(String uuid) {
        if (isExistUuid(uuid)) {
            for (int i = 0; i < count; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    System.arraycopy(storage, i + 1, storage, i, storage.length - i - 1);
                    break;
                }
            }
        } else System.out.println("Resume doesn't exist");
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }
}

