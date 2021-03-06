package com.company.webapp.storage;

import com.company.webapp.ResumeTestData;
import com.company.webapp.exception.ExistStorageException;
import com.company.webapp.exception.NotExistStorageException;
import com.company.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AbstractStorageTest {
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_5 = "uuid5";

    private static final Resume resume1 = ResumeTestData.getInstance(UUID_1, "A");
    private static final Resume resume2 = ResumeTestData.getInstance(UUID_2, "B");
    private static final Resume resume3 = ResumeTestData.getInstance(UUID_3, "C");
    private static final Resume resume4 = ResumeTestData.getInstance(UUID_4, "D");

    AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume updateResume = new Resume(UUID_1, "E");
        storage.update(updateResume);
        assertEquals(updateResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        Resume updateResume = new Resume(UUID_4, "F");
        storage.update(updateResume);
    }

    @Test
    public void save() {
        storage.save(resume4);
        assertEquals(resume4, storage.get(resume4.getUuid()));
        assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(resume3);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_4);
    }

    @Test
    public void getAllSorted() {
        List<Resume> resumeExpected = new ArrayList<>(Arrays.asList(resume1, resume2, resume3));
        List<Resume> resumeActual = storage.getAllSorted();
        assertEquals(resumeExpected, resumeActual);
        assertEquals(3, resumeActual.size());
    }

    @Test
    public void get() {
        assertEquals(resume1, storage.get(resume1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(UUID_4);
    }

    @Test
    public void resumeTestDataEquals() {
        Resume resume5 = ResumeTestData.getInstance(UUID_5, "AAA");
        assertEquals(resume5, resume5);
    }
}