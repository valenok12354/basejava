package com.company.webapp;

import com.company.webapp.model.Resume;
import com.company.webapp.storage.SortedArrayStorage;
import com.company.webapp.storage.Storage;

public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume resume1 = new Resume("uuid1","");
        Resume resume2 = new Resume("uuid2","");
        Resume resume3 = new Resume("uuid3","");

        ARRAY_STORAGE.save(resume1);
        ARRAY_STORAGE.save(resume2);
        ARRAY_STORAGE.save(resume3);

        ARRAY_STORAGE.update(resume1);
        System.out.println("Update resume: " + ARRAY_STORAGE.get(resume1.getUuid()));

        System.out.println("Get r1: " + ARRAY_STORAGE.get(resume1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        printAll();
        ARRAY_STORAGE.delete(resume1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
