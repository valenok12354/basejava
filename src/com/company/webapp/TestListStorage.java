package com.company.webapp;

import com.company.webapp.model.Resume;
import com.company.webapp.storage.ListStorage;
import com.company.webapp.storage.Storage;

public class TestListStorage {
    private static Storage storage = new ListStorage();

    public static void main(String[] args) {

        Resume r1 = new Resume("uuid1","");
        Resume r2 = new Resume("uuid2","");
        Resume r3 = new Resume("uuid3","");

        storage.save(r1);
        storage.save(r2);
        storage.save(r3);

        storage.update(r1);
        System.out.println("Update resume: " + storage.get(r1.getUuid()));

        System.out.println("Get r1: " + storage.get(r1.getUuid()));
        System.out.println("Size: " + storage.size());

        printAll();
        storage.delete(r1.getUuid());
        printAll();
        storage.clear();
        printAll();

        System.out.println("Size: " + storage.size());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : storage.getAllSorted()) {
            System.out.println(r);
        }
    }

}
