package com.company.webapp.storage;

import com.company.webapp.storage.serializer.JsonStreamSerializer;

public class JsonPathStorageTest extends AbstractStorageTest {

    public JsonPathStorageTest() {
        super(new PathStorage("C:\\WTF", new JsonStreamSerializer()));
    }
}