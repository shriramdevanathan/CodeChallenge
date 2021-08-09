package com.ram.oracleassignment.algo;

import com.ram.oracleassignment.CommonFunctions;
import com.ram.oracleassignment.Main;
import com.ram.oracleassignment.core.PhoneNumberDelegate;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AlgoValidTest extends CommonFunctions{

    private NumberRecursiveSplitterAlgorithm coreAlgoWithDefaultDictionary;
    private NumberRecursiveSplitterAlgorithm coreAlgoWithProvidedDictionary;

    @Before
    public void setUp() {
        this.coreAlgoWithDefaultDictionary = new NumberRecursiveSplitterAlgorithm(dictionaryDefault);
        this.coreAlgoWithProvidedDictionary = new NumberRecursiveSplitterAlgorithm(dictionaryProvided);
    }


    /**
     *   Valid Scenarios
      */

    @Test
    public void testSingleDigit() throws Exception {
        String input = "2";
        List<String> consolidatedOutput = new ArrayList<>();
        coreAlgoWithDefaultDictionary.implement(consolidatedOutput, input);
        assertEquals(singleDigitInputValid(), consolidatedOutput);
        consolidatedOutput = new ArrayList<>();

        coreAlgoWithProvidedDictionary.implement(consolidatedOutput, input);
        assertEquals(singleDigitInputValid(), consolidatedOutput);
    }

    @Test
    public void testDoubleDigit() throws Exception {
        String input = "22";
        List<String> consolidatedOutput = new ArrayList<>();
        coreAlgoWithDefaultDictionary.implement(consolidatedOutput, input);
        assertEquals(doubleDigitInputRefactorValid().size(), consolidatedOutput.size());

        consolidatedOutput = new ArrayList<>();
        coreAlgoWithProvidedDictionary.implement(consolidatedOutput, input);
        assertEquals(doubleDigitInputRefactorValid().size(), consolidatedOutput.size());
    }

    @Test
    public void testActualWords() {
        String input = "2255.63";
        String onePossibleOutcome = "CALL-ME";
        List<String> consolidatedOutput = new ArrayList<>();
        coreAlgoWithDefaultDictionary.implement(consolidatedOutput, input);
        assertTrue(consolidatedOutput.contains(onePossibleOutcome));

        consolidatedOutput = new ArrayList<>();
        coreAlgoWithProvidedDictionary.implement(consolidatedOutput, input);
        assertTrue(consolidatedOutput.contains(onePossibleOutcome));
    }

    @Ignore
    public void testInputFile(){
        String path = CommonFunctions.class.getResource("/com/ram/oracleassignment/core/input/test-input").getPath();

        Main.main(new String[]{path});
        assertTrue(true);
    }

    @Test
    public void testDelegate(){
        String path = CommonFunctions.class.getResource("/com/ram/oracleassignment/core/input/test-input1").getPath();
        String dicPath = CommonFunctions.class.getResource("/com/ram/oracleassignment/core/dictionary/defaultdictionary2.txt").getPath();

        PhoneNumberDelegate del = new PhoneNumberDelegate(dicPath);

        del.initDictionary();

        // Run the algo on test data and test dic
        del.algoDelegate("",path);

        List<String> list1 = new ArrayList<>();
        list1.add("CALL-ME");
        List<String> list2 = new ArrayList<>();
        list2.add("BAT");
        list2.add("BA8");

        assertEquals(del.getConsolidatedOutput().size(), 2);
        assertEquals(del.getConsolidatedOutput().get(0), list1);
        assertTrue(del.getConsolidatedOutput().get(1).containsAll(list2));
    }
}