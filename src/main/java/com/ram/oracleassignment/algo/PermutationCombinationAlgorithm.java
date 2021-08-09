package com.ram.oracleassignment.algo;

import com.ram.oracleassignment.core.DictionaryResource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shriramdevanathan
 * This algo is incomplete at the moment.
 */
public class PermutationCombinationAlgorithm implements PhoneAlgorithm {


    DictionaryResource dic = null;
    public PermutationCombinationAlgorithm(DictionaryResource dic) {
        this.dic = dic;
    }

    /**
     * My initial idea was to get all possible combination for the given phone number,
     * then do a permutation and combination of the strings themselves, but time complexity would be O(m^n)
     *
     * So resorted to a cleaner recursive solution - backtracking
     * refer to @NumberRecursiveSplitterAlgorithm.java
     * @param number
     * @return List
     */
    public static List<String> getAllCombinations(String number) {
        String[] char_map = new String[] {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        LinkedList<String> output = new LinkedList<>();
        if(number.length() == 0) return output;
        output.add("");

        for(int i=0;i<number.length();i++) {
            int index = Character.getNumericValue(number.charAt(i));
            while(output.peek().length() == i) {
                String perm = output.remove();
                boolean first = true;
                for (char c : char_map[index].toCharArray()) {
//                    if(first) {
//                        if(!dic.searchSubString(perm)){
//                            output.add(perm + c);
//                            break;
//                        }
//                        first = false;
//                    }
                    output.add(perm + c);
                }
            }
        }
        return output;
    }

    private void parseAll(final List<String> consolidated, String sent, String soFar) {
        if(sent.isEmpty()) {
            consolidated.add(soFar);
//            System.out.println(soFar);
            return;
        }
        for(String word : dic.getWordsWithoutBlank()) {
            if(sent.startsWith(word)) {
                parseAll(consolidated, sent.substring(word.length()), soFar + "-" + word);
            }
        }
    }
    @Override
    public void implement(List<String> concatenated, String phoneNumberString) {
        concatenated.addAll(getAllCombinations(phoneNumberString));
        List<List<String>> all = new ArrayList<>();
        List<String> con = new ArrayList<>();
        concatenated.parallelStream().forEach(a -> {
                parseAll(con, a,"");
               // all.add(con);
        });


    }
}
