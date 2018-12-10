package com.company.webapp.storage;

import com.company.webapp.exception.StorageException;
import com.company.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    protected abstract void doWrite(Resume resume, File file) throws IOException;

    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    protected abstract Resume doRead(File file);

    @Override
    protected Resume doGet(File file) {
        return doRead(file);
    }


    @Override
    public List<Resume> getList() {
        List<Resume> list = new ArrayList<>();
        File[] files = directory.listFiles();
        for (int i = 0; i < directory.listFiles().length; i++) {
            list.add(doGet(files[i]));
        }
        return list;
    }

    @Override
    protected void doUpdate(File file, Resume resume) {
        try {
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected void doSave(File file, Resume resume) {
        try {
            file.createNewFile();
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected void doDelete(File file) {
        file.delete();
    }

    @Override
    public void clear() {
        for (File file : directory.listFiles())
            if (file.isDirectory()) {
                clear();
            } else file.delete();
    }

    @Override
    public int size() {
        try {
            return directory.list().length;
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        File[] files = directory.listFiles();
        List<Resume> list = new ArrayList();

        for (File file : files) {
            list.add(doRead(file));
        }
        return list;
    }

}
