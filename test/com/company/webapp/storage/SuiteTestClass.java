package com.company.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        SortedArrayStorageTest.class,
        ArrayStorageTest.class,
        MapUuidStorageTest.class,
        ListStorageTest.class
})

public class SuiteTestClass {
}


