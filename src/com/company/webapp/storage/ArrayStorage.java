package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    private Resume[] storage = new Resume[3];
    private int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void save(Resume r) {
        if (count < storage.length) {
            if (existResume(r.getUuid()) == -1) {
                storage[count] = r;
                count++;
            } else {
                System.out.println("Resume exist");
            }
        } else {
            System.out.println("There is no disk space");
        }
    }

    public void update(Resume r) {
        int i = existResume(r.getUuid());
        if (i != -1) {
            System.out.println("updated");
            storage[i] = r;
        } else {
            System.out.println("Resume doesn't exist");
        }
    }

    public Resume get(String uuid) {
        if (existResume(uuid) != -1) {
            return storage[existResume(uuid)];
        } else {
            System.out.println("No resume found");
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, storage.length - i - 1);
                storage[count - 1] = null;
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

    private int existResume(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}

