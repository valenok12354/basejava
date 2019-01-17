package com.company.webapp.storage;

import java.io.File;

public class ObjectPathStorageTest extends AbstractStorageTest {
    public ObjectPathStorageTest() {
        super(new PathStorage("C:\\WTF", new ObjectStreamStorage()));
    }
}