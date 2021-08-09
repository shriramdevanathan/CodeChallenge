package com.ram.oracleassignment.algo;

import com.ram.oracleassignment.core.DictionaryResource;
import com.ram.oracleassignment.utils.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author shriramdevanathan
 */
public class NumberRecursiveSplitterAlgorithm implements PhoneAlgorithm{

    private static DictionaryResource dic;

    public NumberRecursiveSplitterAlgorithm(DictionaryResource dictionaryResource) {
        dic = dictionaryResource;
    }

    @Override
    public void implement(final List<String> concatenated, String phoneNumberString) {
        phoneNumberHandlerRecursive(concatenated, StringUtils.cleanNumber(phoneNumberString), false, StringUtils.EMPTY_STRING, StringUtils.EMPTY_STRING);
    }

    /**
     *
     * @param phoneNumberString
     * @param skipped
     * @param res
     * @param pre
     * CORE LOGIC
     *  * 	1. Iterate through each prefix  and search for matching word(s).
     *  *   2. If matching word(s) can be found use them,
     *  * 	3.Make a recursive call to get all combinations of the remaining suffix.
     *  * 	4. Concatenate the matching combinations of the prefix and the suffix.
     *  *
     * Core recursive logic to compute
     */
    protected void phoneNumberHandlerRecursive(List<String> concatenated, final String phoneNumberString, boolean skipped, String res, String pre){
        if(dic == null) {
            throw new IllegalStateException("Dictionary not initialized");
        }
        final Map<Integer, String> digitCharacterMap = dic.getNumberEncoding();

        if ((phoneNumberString == null || phoneNumberString.isEmpty()) || !dic.searchSubString(pre)) {
            if(dic.search(pre) && !res.endsWith("-")) {
                concatenated.add(res.toUpperCase());
            }
            return;
        }

        if(!skipped && dic.search(pre)) {
            boolean noMatchFound = dic.getWords().stream().
                    noneMatch(w ->
                            w.length() == 1 && digitCharacterMap.get(Character.getNumericValue(phoneNumberString.charAt(0))).contains(w));

            if(noMatchFound) {
                phoneNumberHandlerRecursive(concatenated, phoneNumberString.substring(1), true, res  + Character.getNumericValue(phoneNumberString.charAt(0)), "");
            }
            if(res != null && !res.isEmpty()) {
                phoneNumberHandlerRecursive(concatenated, phoneNumberString, true, res + "-" , StringUtils.EMPTY_STRING);
            }
        }

        for(char s : digitCharacterMap.get(Character.getNumericValue(phoneNumberString.charAt(0))).toCharArray()){
            phoneNumberHandlerRecursive(concatenated, phoneNumberString.substring(1), false, res  + s, pre + s);
        }
    }

}
