package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class MapResumeStorage extends AbstractStorage<Resume> {
//    private Map<String, Resume> map = new HashMap<>();
//
//    @Override
//    protected Resume getSearchKey(String uuid) {
//        return map.get(uuid);
//    }
//
//    @Override
//    protected boolean isExist(Resume resume) {
//        return resume != null;
//    }
//
//    @Override
//    protected Resume doGet(Resume resume) {
//        return resume;
//    }
//
//    @Override
//    protected void doUpdate(Resume searchKey, Resume resume) {
//        map.put(resume.getUuid(), resume);
//    }
//
//    @Override
//    protected void doSave(Resume searchKey, Resume resume) {
//        map.put(searchKey.getUuid(), resume);
//    }
//
//    @Override
//    protected void doDelete(Resume searchKey) {
//        map.remove(searchKey.getUuid());
//    }
//
//    @Override
//    public void clear() {
//        map.clear();
//    }
//
//    @Override
//    public List<Resume> getList() {
//        return new ArrayList<>(map.values());
//    }
//
//    @Override
//    public int size() {
//        return map.size();
//    }
//}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
    }

    @Override
    protected void doDelete(Resume resume) {
        map.remove(resume.getUuid());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getList() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}