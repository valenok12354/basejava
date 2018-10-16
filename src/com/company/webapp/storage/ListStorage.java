package com.company.webapp.storage;

import com.company.webapp.exception.ExistStorageException;
import com.company.webapp.exception.NotExistStorageException;
import com.company.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> listStorage = new ArrayList<>();


    private int getIndex(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (listStorage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return listStorage.get(index);
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            listStorage.set(index, resume);
        } else throw new NotExistStorageException(resume.getUuid());

    }

    @Override
    public Resume[] getAll() {
        return listStorage.toArray(new Resume[listStorage.size()]);
    }

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else listStorage.add(resume);
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            listStorage.remove(index);
        }
    }

    @Override
    public int size() {
        return listStorage.size();
    }
}