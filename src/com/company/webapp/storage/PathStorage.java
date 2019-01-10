package com.company.webapp.storage;

import com.company.webapp.exception.StorageException;
import com.company.webapp.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PathStorage extends AbstractStorage<Path> implements Strategy {
    private Path directory;

    @Override
    public void doExecute() {
    }

    protected void doWrite(Resume r, OutputStream os) throws IOException {
    }

    protected Resume doRead(InputStream is) throws IOException {
        return null;
    }

    public PathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || (!Files.isWritable(directory))) {
            throw new IllegalArgumentException(dir + " is not directory or is not writale");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        int length;
        if (directory == null) {
            throw new StorageException("Directory read error", null);
        }
        try {
            length = (int) Files.size(directory);
        } catch (IOException e) {
            throw new StorageException("No files in the path ", null);
        }
        return length;
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return Paths.get(directory.toString(), uuid);
    }

    @Override
    protected void doUpdate(Resume r, Path path) {
        try {
            doWrite(r, new BufferedOutputStream(new FileOutputStream(path.toFile())));
        } catch (IOException e) {
            throw new StorageException("Path write error", r.getUuid(), e);
        }
    }

    @Override
    protected boolean isExist(Path path) {
        return Files.isRegularFile(path);
    }

    @Override
    protected void doSave(Resume r, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Couldn't create path " + path, path.getFileName().toString(), e);
        }
        doUpdate(r, path);
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return doRead(new BufferedInputStream(new FileInputStream(path.toFile())));
        } catch (IOException e) {
            throw new StorageException("Path read error", path.getFileName().toString(), e);
        }
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Path delete error", path.getFileName().toString(), e);
        }
    }

    @Override
    public List<Resume> getList() {
        List<Resume> list = new ArrayList<>();
//        try {
//            list = (List<Resume>) Files.list(directory).collect(Collectors.toList());
//        } catch (IOException e) {
//            throw new StorageException("Path delete error", null, e);
//        }
        return list;
    }
}