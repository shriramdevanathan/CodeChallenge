package com.ram.oracleassignment.algo;

import com.ram.oracleassignment.CommonFunctions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AlgoInvalidTest extends CommonFunctions{

    private NumberRecursiveSplitterAlgorithm coreAlgoWithDefaultDictionary;
    private NumberRecursiveSplitterAlgorithm coreAlgoWithProvidedDictionary;

    @Before
    public void setUp()  {
        this.coreAlgoWithDefaultDictionary = new NumberRecursiveSplitterAlgorithm(dictionaryDefault);
        this.coreAlgoWithProvidedDictionary = new NumberRecursiveSplitterAlgorithm(dictionaryProvided);
    }

    /**
     * Invalid Scenarios
     */

    @Test
    public void testSingleDigitInvalid() {
        String input = "2";
        List<String> consolidatedOutput = new ArrayList<>();
        coreAlgoWithDefaultDictionary.implement(consolidatedOutput, input);
        assertNotEquals(singleDigitInputInValid(),consolidatedOutput );


        consolidatedOutput = new ArrayList<>();
        coreAlgoWithProvidedDictionary.implement(consolidatedOutput, input);
        assertNotEquals(singleDigitInputInValid(),consolidatedOutput );
    }

    @Test
    public void testDoubleDigitInvalid() {
        String input = "22";
        List<String> consolidatedOutput = new ArrayList<>();
        coreAlgoWithDefaultDictionary.implement(consolidatedOutput, input);
        assertNotEquals(doubleDigitInputRefactorInValid().size(),consolidatedOutput.size() );

        consolidatedOutput = new ArrayList<>();
        coreAlgoWithProvidedDictionary.implement(consolidatedOutput, input);
        assertNotEquals(doubleDigitInputRefactorInValid().size(),consolidatedOutput.size() );
    }
}