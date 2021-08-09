package com.ram.oracleassignment;

import com.ram.oracleassignment.core.PhoneNumberDelegate;
import com.ram.oracleassignment.utils.StringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shriramdevanathan
 */
public class Main {

    private static final String DICTIONARY_MANUAL = "dic.file";
    private static final String ALGORITHM_TO_FOLLOW = "algo";



    public static void main(String[] args) {

        //1. Load up the dictionary
        String dictionaryAvailable = System.getProperty(DICTIONARY_MANUAL);
        String algorithm = System.getProperty(ALGORITHM_TO_FOLLOW);

        PhoneNumberDelegate delegate = new PhoneNumberDelegate(dictionaryAvailable);
        delegate.initDictionary();

        //2. Initiate phone number recursive logic
        delegate.algoDelegate(algorithm, args);

        //3. print the output
        delegate.output();

        System.exit(0);

    }
}
