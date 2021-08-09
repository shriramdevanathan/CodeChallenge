package com.ram.oracleassignment;

import com.ram.oracleassignment.core.DictionaryResource;
import org.junit.Before;
import java.util.ArrayList;
import java.util.List;


public class CommonFunctions {

    public static DictionaryResource dictionaryDefault;
    public static DictionaryResource dictionaryProvided;
    public static DictionaryResource dictionaryEmpty;


    @Before
    public void loadDefaultDic() {
        dictionaryDefault = DictionaryResource.getDefault();
    }

    @Before
    public  void loadProvidedDic()  {
        try {
            String path = CommonFunctions.class.getResource("/com/ram/oracleassignment/core/dictionary/defaultdictionary.txt").getPath();
            dictionaryProvided = DictionaryResource.getFromProvided(path);
        }
        catch(Exception e) {
            throw new IllegalArgumentException("Could not load provided dictionary");
        }
    }

    @Before
    public void loadEmptyDic() {
        try {
            String path = CommonFunctions.class.getResource("/com/ram/oracleassignment/core/dictionary/emptydic.txt").getPath();
            dictionaryEmpty = DictionaryResource.getFromProvided(path);
        }
        catch(Exception e) {
            throw new IllegalArgumentException("dictionary is empty");
        }
    }

    protected List<String> singleDigitInputValid() {

        List<String> expected = new ArrayList<>();
        expected.add("A");
        expected.add("B");
        expected.add("C");

        return expected;
    }

    protected List<String> doubleDigitInputRefactorValid(){
        List<String> expected = new ArrayList<>();
        expected.add("AA");expected.add("A-A");
        expected.add("AB");expected.add("A-B");
        expected.add("AC");expected.add("A-C");
        expected.add("BA");expected.add("B-A");
        expected.add("BB");expected.add("B-B");
        expected.add("BC");expected.add("B-C");
        expected.add("CA");expected.add("C-A");
        expected.add("CB");expected.add("C-B");
        expected.add("CC");expected.add("C-C");

        return expected;
    }

    protected List<String> singleDigitInputInValid() {

        List<String> expected = new ArrayList<>();
        expected.add("G");
        expected.add("H");
        expected.add("I");

        return expected;
    }

    protected List<String> doubleDigitInputRefactorInValid(){
        List<String> expected = new ArrayList<>();
        expected.add("DD");expected.add("D-D");
        expected.add("BD");expected.add("B-D");

        return expected;
    }


}