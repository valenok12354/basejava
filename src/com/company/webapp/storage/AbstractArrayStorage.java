package com.company.webapp.storage;

import com.company.webapp.model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("Resume doesn't exist");
        }
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > 0) {
            System.out.println("Resume exist");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("There is no disk space");
        } else {
            inputElement(resume, index);
            size++;
        }
    }

    protected abstract void inputElement(Resume resume, int index);

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("No resume found");
        } else {
            deletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract void deletedElement(int index);

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);

}
