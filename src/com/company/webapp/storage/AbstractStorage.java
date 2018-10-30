package com.company.webapp.storage;

import com.company.webapp.exception.ExistStorageException;
import com.company.webapp.exception.NotExistStorageException;
import com.company.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected static final Comparator<Resume> COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    protected abstract SK getSearchKey(String uuid);

    protected abstract Resume doGet(SK index);

    protected abstract void doUpdate(SK index, Resume resume);

    protected abstract void doSave(SK index, Resume resume);

    protected abstract void doDelete(SK index);

    protected abstract boolean isExist(SK searchKey);

    public abstract List<Resume> getList();

    @Override
    public Resume get(String uuid) {
        //LOG.info("get " + uuid);
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return doGet(searchKey);
    }

    @Override
    public void update(Resume resume) {
        //LOG.info("update " + resume);
        SK searchKey = getSearchKey(resume.getUuid());
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            doUpdate(searchKey, resume);
        }
    }

    @Override
    public void save(Resume resume) {
       // LOG.info("save " + resume);
        SK searchKey = getSearchKey(resume.getUuid());
        if (isExist(searchKey)) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            doSave(searchKey, resume);
        }
    }

    @Override
    public List<Resume> getAllSorted() {
        //LOG.info("getAllSorted ");
        List<Resume> list = getList();
        list.sort(COMPARATOR);
        return list;
    }

    @Override
    public void delete(String uuid) {
        //LOG.info("delete " + uuid);
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        doDelete(searchKey);
    }


}
