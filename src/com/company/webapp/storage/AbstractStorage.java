package com.company.webapp.storage;

import com.company.webapp.exception.ExistStorageException;
import com.company.webapp.exception.NotExistStorageException;
import com.company.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {
    //private static Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected static final Comparator<Resume> COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    protected abstract SK getSearchKey(String uuid);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doUpdate(SK searchKey, Resume resume);

    protected abstract void doSave(SK searchKey, Resume resume);

    protected abstract void doDelete(SK searchKey);

    protected abstract boolean isExist(SK searchKey);

    public abstract List<Resume> getList();

    private SK notExistMethod(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK existMethod(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    @Override
    public Resume get(String uuid) {
        //LOG.info("get " + uuid);
        SK searchKey = notExistMethod(uuid);
        return doGet(searchKey);
    }

    @Override
    public void update(Resume resume) {
        //LOG.info("update " + resume);
        SK searchKey = notExistMethod(resume.getUuid());
        doUpdate(searchKey, resume);

    }

    @Override
    public void save(Resume resume) {
        // LOG.info("save " + resume);
        SK searchKey = existMethod(resume.getUuid());
        doSave(searchKey, resume);

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
        SK searchKey = notExistMethod(uuid);
        doDelete(searchKey);
    }


}
