package com.company.webapp.storage;

import com.company.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> SORTED_COMPARATOR = Comparator.comparing(Resume::getUuid);

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
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "");
        return Arrays.binarySearch(storage, 0, size, searchKey, SORTED_COMPARATOR);
    }
}
