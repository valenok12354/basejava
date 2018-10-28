package com.company.webapp.storage;

import com.company.webapp.exception.ExistStorageException;
import com.company.webapp.exception.NotExistStorageException;
import com.company.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

//    protected static final Comparator<Resume> COMPARATOR = (o1, o2) -> {
//        if (!o1.getFullName().equals(o2.getFullName())) {
//            return o1.getFullName().compareTo(o2.getFullName());
//        } else return o1.getUuid().compareTo(o2.getUuid());
//    };

    protected static final Comparator<Resume> COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    protected abstract Object getSearchKey(String uuid);

    protected abstract Resume doGet(Object index);

    protected abstract void doUpdate(Object index, Resume resume);

    protected abstract void doSave(Object index, Resume resume);

    protected abstract void doDelete(Object index);

    protected abstract boolean isExist(Object searchKey);

    public abstract List<Resume> getList();

    @Override
    public Resume get(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return doGet(searchKey);
    }

    @Override
    public void update(Resume resume) {
        Object searchKey = getSearchKey(resume.getUuid());
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            doUpdate(searchKey, resume);
        }
    }

    @Override
    public void save(Resume resume) {
        Object searchKey = getSearchKey(resume.getUuid());
        if (isExist(searchKey)) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            doSave(searchKey, resume);
        }
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getList();
        list.sort(COMPARATOR);
        return list;
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        doDelete(searchKey);
    }


}
