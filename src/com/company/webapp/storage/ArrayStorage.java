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

    public void save(Resume r) {
        if (count <= storage.length) {
            if (isExistResume(r) == -1) {
                storage[count] = r;
                count++;
            } else {
                System.out.println("Resume exist");
            }
        }
    }

    private int isExistResume(Resume r) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].equals(r)) {
                return Arrays.asList(storage).indexOf(r);
            }
        }
        return -1;
    }

    public void update(Resume r) {
        if (isExistResume(r) != -1) {
            storage[Arrays.asList(storage).indexOf(r)] = r;
        } else {
            System.out.println("Resume doesn't exist");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, storage.length - i - 1);
                storage[count] = null;
                break;
            }
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }
}

