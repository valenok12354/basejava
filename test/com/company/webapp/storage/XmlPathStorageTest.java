package com.company.webapp.storage;

import com.company.webapp.storage.serializer.XmlStreamSerializer;

public class XmlPathStorageTest extends AbstractStorageTest {
    public XmlPathStorageTest() {
        super(new PathStorage("C:\\WTF", new XmlStreamSerializer()));
    }
}
