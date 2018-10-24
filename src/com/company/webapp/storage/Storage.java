package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.List;

public interface Storage {

    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    //Resume[] getAll();
//  return List sorted by name
    List<Resume> getAllSorted();

    int size();
}
