package com.ram.oracleassignment.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    @Test
    public void testDictionaryInput() {
        String input = "WordWithMixedCaseAnd..%SpecialCharacter%%%";
        String expected = "wordwithmixedcaseandspecialcharacter";
        assertEquals(StringUtils.cleanWord(input), expected);
    }

    @Test
    public void testPhoneInput() {
        String input = "2233asdfaf%%";
        String expected = "2233";
        assertEquals(StringUtils.cleanNumber(input), expected);
    }

    @Test
    public void testPhoneInputs() {
        String input1 = "2233asdfaf%%";
        String input2 = "556asdfasf&*!77";
        Set<String> input = new HashSet<>(Arrays.asList(input1, input2));
        Set<String> expected = new HashSet<>();
        expected.add("2233");
        expected.add("55677");
        Set<String> output = StringUtils.cleanNumbers(input);
        assertEquals(output.size(), expected.size());
        assertTrue(output.containsAll(expected));
    }

}