package com.company.webapp.storage;

import com.company.webapp.storage.serializer.DataStreamSerializer;

public class DataPathStorageTest extends AbstractStorageTest {

    public DataPathStorageTest() {
        super(new PathStorage("C:\\WTF", new DataStreamSerializer()));
    }
}