package com.company.webapp.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        ArrayStorageTest.class,
        MapUuidStorageTest.class,
        MapResumeStorageTest.class,
        ListStorageTest.class,
        SortedArrayStorageTest.class

})

public class SuiteTestClass {
}


