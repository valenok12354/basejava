package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void deletedElement(int index) {
        int changedElement = size - index - 1;
        if (changedElement > 0) {
            System.arraycopy(storage, index + 1, storage, index, changedElement);
        }
    }

    @Override
    protected void inputElement(Resume resume, int index) {
        int indexEl = -index - 1;
        System.arraycopy(storage, indexEl, storage, indexEl + 1, size - indexEl);
        storage[indexEl] = resume;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
