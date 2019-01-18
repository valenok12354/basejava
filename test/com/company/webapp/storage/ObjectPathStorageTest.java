package com.company.webapp.storage;

import com.company.webapp.storage.serializer.ObjectStreamStorage;

public class ObjectPathStorageTest extends AbstractStorageTest {
    public ObjectPathStorageTest() {
        super(new PathStorage("C:\\WTF", new ObjectStreamStorage()));
    }
}