package com.ram.oracleassignment.core;

import com.ram.oracleassignment.utils.StringUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author shriramdevanathan
 * Source for dictionary : https://github.com/first20hours/google-10000-english/blob/master/google-10000-english-no-swears.txt
 */
public class DictionaryResource {

    private final Logger LOGGER = Logger.getLogger(Dictionary.class.getName());
    private final String DEFAULT_DICTIONARY_PATH = "com.ram.oracleassignment/core/defaultdictionary.txt";
    private final Set<String> words = new HashSet<>();
    private static DictionaryResource defaultInstance;

    /**
     * default dictionary
     */
    private DictionaryResource() {
        InputStream dict = getClass().getClassLoader().getResourceAsStream(DEFAULT_DICTIONARY_PATH);
        loadDictionary(dict);
    }

    private DictionaryResource(String path) throws FileNotFoundException{
        InputStream dict = new FileInputStream(path);
        loadDictionary(dict);
    }


    private void loadDictionary(InputStream dict) {
        LOGGER.fine("loading dictionary START");

        Scanner scanner = new Scanner(dict);

        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            words.add(StringUtils.cleanWord(word));
        }

        LOGGER.fine("loading dictionary END");

//        if (words.size() == 0)
//            throw new IllegalArgumentException("dictionary is empty");
        words.add("");
    }

    /**
     * @return
     */
    public static DictionaryResource getFromProvided(String path) throws FileNotFoundException{
        return new DictionaryResource(path);
    }

    public static DictionaryResource getDefault() {
        if (null == defaultInstance)
            defaultInstance = new DictionaryResource();

        return defaultInstance;
    }

    /**
     * @param key
     * @return
     */
    public boolean search(String key) {
        return words.contains(key.toLowerCase());
    }

    public boolean searchSubString(String key) {
        return words.stream().anyMatch(item -> item.startsWith(key));
    }

    public Set<String> getWords () {
        return words;
    }

    public Set<String> getWordsWithoutBlank () {
        return words.stream().filter(a -> !a.isEmpty()).collect(Collectors.toSet());
    }

    public Map<Integer, String> getNumberEncoding() {
        Map<Integer, String> map = new HashMap<>();
        List<String> digitCharacterMap = Arrays.asList(StringUtils.EMPTY_STRING,StringUtils.EMPTY_STRING,"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
        IntStream.range(0, digitCharacterMap.size()).forEach(a -> {
            map.put(a, digitCharacterMap.get(a));
        });
        return map;
    }
}
