package com.ram.oracleassignment.utils;

import com.ram.oracleassignment.CommonFunctions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FileUtilsTest {

    @Test
    public void testPhoneNumberInput() {
        String path = CommonFunctions.class.getResource("/com/ram/oracleassignment/core/input/test-input").getPath();
        assertEquals(new FileUtils().readFromFile(path).size(), 3);
    }

    @Test
    public void testDicInput() {
        String path = CommonFunctions.class.getResource("/com/ram/oracleassignment/core/dictionary/emptydic.txt").getPath();
        assertEquals(new FileUtils().readFromFile(path).size(), 0);
    }
}