package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    protected Map<String, Resume> storage = new HashMap<>();
    protected int size = 0;

    @Override
    public void clear() {
        storage.clear();
        size = 0;
    }

    @Override
    public void update(Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    public void save(Resume resume) {
        storage.put(resume.getUuid(), resume);
        size++;
    }

    @Override
    public Resume get(String uuid) {
        return storage.get(uuid);
    }

    @Override
    public void delete(String uuid) {
        storage.remove(uuid);
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Resume[] getAll() {
        Resume[] mapResume = new Resume[AbstractArrayStorage.STORAGE_LIMIT];
        Set<Resume> hashSet = new HashSet<>();
        for (Map.Entry<String, Resume> entry : storage.entrySet()) {
            hashSet.add(entry.getValue());
            mapResume = hashSet.toArray(new Resume[hashSet.size()]);
            Arrays.sort(mapResume);
        }
        return Arrays.copyOfRange(mapResume, 0, size);
    }

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }
}