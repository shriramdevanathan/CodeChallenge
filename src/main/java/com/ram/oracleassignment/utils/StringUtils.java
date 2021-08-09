package com.ram.oracleassignment.utils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author shriramdevanathan
 */
public class StringUtils {

    public static String EMPTY_STRING = "";

    private StringUtils() {
    }

    /**
     * @param value
     * @return
     */
    public static boolean isEmpty(final String value) {
        return (value == null || value.isEmpty() || value.trim().isEmpty());
    }


    public static String separateStringbyNewLine(List<String> strings) {
        return String.join("\n", strings);
    }

    /**
     * clears word from punctuation marks etc. And standardizes to lowercase
     * @param phoneNumber
     * @return
     */
    public static String cleanWord(String phoneNumber) {
        return isEmpty(phoneNumber) ? null : phoneNumber.replaceAll("\\p{P}", "").toLowerCase();
        //return isEmpty(phoneNumber) ? null : phoneNumber.replaceAll("[^0-9]", "").toLowerCase();
    }

    /**
     * Replaces all non-numeric to blank
     * @param phoneNumber
     * @return
     */
    public static String cleanNumber(String phoneNumber) {
        //return isEmpty(phoneNumber) ? null : phoneNumber.replaceAll("\\p{P}", "").toLowerCase();
        return isEmpty(phoneNumber) ? null : phoneNumber.replaceAll("[^0-9]", "").toLowerCase();
    }

    public static Set<String> cleanNumbers(final Set<String> phoneNumbers) {
        return phoneNumbers.stream()
                .map(StringUtils::cleanNumber)
                .collect(Collectors.toSet());
    }

}