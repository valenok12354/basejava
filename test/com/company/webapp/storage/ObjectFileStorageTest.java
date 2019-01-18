package com.company.webapp.storage;

import com.company.webapp.storage.serializer.ObjectStreamStorage;

import java.io.File;

public class ObjectFileStorageTest extends AbstractStorageTest {
    public ObjectFileStorageTest() {
        super(new FileStorage(new File("C:\\WTF"), new ObjectStreamStorage()));
    }
}