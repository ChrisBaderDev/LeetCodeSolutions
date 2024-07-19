package Solutions;

import com.sun.source.tree.Tree;

import java.util.*;

public class C17_LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        HashMap<Character, String> letterNumberMap = new HashMap<>();
        letterNumberMap.put('2',"abc");
        letterNumberMap.put('3',"def");
        letterNumberMap.put('4',"ghi");
        letterNumberMap.put('5',"jkl");
        letterNumberMap.put('6',"mno");
        letterNumberMap.put('7',"pqrs");
        letterNumberMap.put('8',"tuv");
        letterNumberMap.put('9',"wxyz");

        List<String> combinations = new ArrayList<>();
        combinations.add("");
        for(int i = 0; i < digits.length(); i++) {
            List<String> newCombinations = new ArrayList<>();
            String letters = letterNumberMap.get(digits.charAt(i));

            for(String combination : combinations) {
                for(int j = 0; j < letters.length(); j++) {
                    newCombinations.add(combination + letters.charAt(j));
                }
            }

            combinations = newCombinations;
        }

        return combinations;
    }

    public List<String> letterCombinationsV2(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        HashMap<Character, String> letterNumberMap = new HashMap<>();
        letterNumberMap.put('2', "abc");
        letterNumberMap.put('3', "def");
        letterNumberMap.put('4', "ghi");
        letterNumberMap.put('5', "jkl");
        letterNumberMap.put('6', "mno");
        letterNumberMap.put('7', "pqrs");
        letterNumberMap.put('8', "tuv");
        letterNumberMap.put('9', "wxyz");

        List<String> combinations = new ArrayList<>();
        backtrackV2(combinations, letterNumberMap, digits, "", 0);
        return combinations;
    }

    private void backtrackV2(List<String> combinations,
                           HashMap<Character, String> letterNumberMap,
                           String digits,
                           String currentCombination,
                           int combinationLength) {
        if (combinationLength == digits.length()) {
            combinations.add(currentCombination);
            return;
        }

        String letters = letterNumberMap.get(digits.charAt(combinationLength));
        for (int i = 0; i < letters.length(); i++) {
            backtrackV2(combinations,
                    letterNumberMap,
                    digits,
                    currentCombination + letters.charAt(i),
                    combinationLength + 1);
        }
    }



    private static final Map<Character, String> LETTER_NUMBER_MAP = new HashMap<>();
    static {
        LETTER_NUMBER_MAP.put('2', "abc");
        LETTER_NUMBER_MAP.put('3', "def");
        LETTER_NUMBER_MAP.put('4', "ghi");
        LETTER_NUMBER_MAP.put('5', "jkl");
        LETTER_NUMBER_MAP.put('6', "mno");
        LETTER_NUMBER_MAP.put('7', "pqrs");
        LETTER_NUMBER_MAP.put('8', "tuv");
        LETTER_NUMBER_MAP.put('9', "wxyz");
    }

    public List<String> letterCombinationsV3(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> combinations = new ArrayList<>();
        StringBuilder currentCombination = new StringBuilder();
        backtrackV3(combinations, digits, currentCombination, 0);
        return combinations;
    }

    private void backtrackV3(List<String> combinations,
                           String digits,
                           StringBuilder currentCombination,
                           int combinationLength) {
        if (combinationLength == digits.length()) {
            combinations.add(currentCombination.toString());
            return;
        }

        String letters = LETTER_NUMBER_MAP.get(digits.charAt(combinationLength));
        for (int i = 0; i < letters.length(); i++) {
            currentCombination.append(letters.charAt(i));
            backtrackV3(combinations, digits, currentCombination, combinationLength + 1);
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }
}
