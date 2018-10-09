package com.company.webapp.storage;

import com.company.webapp.exception.NotExistStorageException;
import com.company.webapp.exception.StorageException;
import com.company.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractArrayStorageTest extends Assert {
    private Storage storage;
    private Storage storage1; // just dummy array for the testing
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage, Storage storage1) {
        this.storage = storage;
        this.storage1 = storage1;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        assertArrayEquals(storage1.getAll(), storage.getAll());
    }

    @Test
    public void update() {
        storage.update(new Resume(UUID_1));
        assertEquals(UUID_1, storage.get(UUID_1).getUuid());
    }

    @Test
    public void save() {
        String UUID_4 = "uuid4";
        storage.save(new Resume("uuid4"));
        assertEquals(UUID_4, storage.get(UUID_4).getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        assertEquals(null, storage.get(UUID_1).getUuid());
    }

    @Test
    public void getAll() {
        Resume[] resume = new Resume[]{new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        assertArrayEquals(resume, storage.getAll());
    }

    @Test
    public void get() {
        assertEquals(UUID_1, storage.get(UUID_1).getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = StorageException.class)
    public void storageExceptionTest() {
        try {
            for (int i = 3; i < storage.size(); i++) {
                storage.save(new Resume("uuid" + i));
            }
        } catch (Exception e) {
            fail("ERROR CAUGHT, PLEASE CHANGE THE TEST CASE");
        }
        storage.save(new Resume("uuid" + storage.size()));
    }
}