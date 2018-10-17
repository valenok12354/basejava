package com.company.webapp.storage;

import com.company.webapp.exception.ExistStorageException;
import com.company.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> listStorage = new ArrayList<>();

    @Override
    protected Integer getIndex(String uuid) {
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
        Integer index = getIndex(uuid);
        NotNullCheck(uuid);
        return listStorage.get(index);
    }

    @Override
    public void update(Resume resume) {
        Integer index = getIndex(resume.getUuid());
        NotNullCheck(resume.getUuid());
        listStorage.set(index, resume);
    }

    @Override
    public Resume[] getAll() {
        return listStorage.toArray(new Resume[listStorage.size()]);
    }

    @Override
    public void save(Resume resume) {
        Integer index = getIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else
            listStorage.add(resume);
    }

    @Override
    public void delete(String uuid) {
        Integer index = getIndex(uuid);
        NotNullCheck(uuid);
        listStorage.remove((int) index);
    }

    @Override
    public int size() {
        return listStorage.size();
    }
}