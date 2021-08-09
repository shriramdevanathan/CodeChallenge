package com.ram.oracleassignment.core;

import com.ram.oracleassignment.algo.NumberRecursiveSplitterAlgorithm;
import com.ram.oracleassignment.algo.PermutationCombinationAlgorithm;
import com.ram.oracleassignment.algo.PhoneAlgorithm;
import com.ram.oracleassignment.utils.FileUtils;
import com.ram.oracleassignment.utils.StringUtils;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author shriramdevanathan
 */
public class PhoneNumberDelegate {

    private static final Logger LOGGER = Logger.getLogger(PhoneNumberDelegate.class.getName());


    private static String dictionaryAvailable;
    private static DictionaryResource dic = null;
    private List<List<String>> consolidatedOutput = new ArrayList<>();

    public PhoneNumberDelegate(String path) {
        this.dictionaryAvailable = path;
    }

    public List<List<String>> getConsolidatedOutput() {
        return consolidatedOutput;
    }

    public void addToOutput(List<String> output) {
        this.consolidatedOutput.add(output);
    }

    public void initDictionary(){
//        LOGGER.info("Initializing dictionary");
        try {
            dic = StringUtils.isEmpty(dictionaryAvailable) ?
                        DictionaryResource.getDefault() :
                        DictionaryResource.getFromProvided(dictionaryAvailable);
        }
        catch(FileNotFoundException e) {
            throw new IllegalArgumentException("Dictionary path does not exist");
        }
    }

    public void algoDelegate(String algo, String... filePaths)  {
        algo = StringUtils.isEmpty(algo) ? "recursive-back" : algo;

        PhoneAlgorithm algo1 = algo.equalsIgnoreCase("recursive-back") ?
                new NumberRecursiveSplitterAlgorithm(dic):
                new PermutationCombinationAlgorithm(dic);

        /***
         * If no files are produced, STDIN
         */
        if(filePaths.length == 0) {
            String input = "";
            do {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter the phone number(q for quit): ");
                input = scan.next();
                if(!"q".equalsIgnoreCase(input)) {
                    List<String> consolidatedOutput1 = new ArrayList<>();
                    List<String> consolidatedOutput2 = new ArrayList<>();
                    algo1.implement(consolidatedOutput1, input);
                    System.out.println(StringUtils.separateStringbyNewLine(consolidatedOutput1));
                }
            } while(!"q".equalsIgnoreCase(input));
            return;
        }

        /**
         * else proceed to get from file
         */
        FileUtils fr = new FileUtils();
        //Iterate through every file for phone numbers

        List<List<String>> output = new ArrayList<>();
        Stream.of(filePaths)
                .map(fr::readFromFile)
                .map(StringUtils::cleanNumbers)
                .filter(Objects::nonNull)
                .forEach(a -> a.forEach(item -> {
                    List<String> phoneNumbersList = new ArrayList<>();
                    algo1.implement(phoneNumbersList, item);
                    addToOutput(phoneNumbersList);
//                    System.out.println(StringUtils.separateStringbyNewLine(phoneNumbersList));
                }));

    }

    public void output() {
        //Can chose to output whatever and however we want
        consolidatedOutput.stream().map(StringUtils::separateStringbyNewLine).forEach(System.out::println);
    }


}
