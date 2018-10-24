package com.company.webapp.storage;

import com.company.webapp.exception.StorageException;
import com.company.webapp.model.Resume;
import org.junit.Test;

public class AbstractArrayStorageTest extends AbstractStorageTest {

    AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        storage.clear();
        try {
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("uuid" + i, "fullName" + i));
            }
        } catch (StorageException e) {
            fail("ERROR CAUGHT, PLEASE CHANGE THE TEST CASE");
        }
        storage.save(new Resume("uuid" + AbstractArrayStorage.STORAGE_LIMIT, "fullName" + AbstractArrayStorage.STORAGE_LIMIT));
    }
}