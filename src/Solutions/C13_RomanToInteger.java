package Solutions;

import java.util.HashMap;

public class C13_RomanToInteger {

    // The naive solution
    public int romanToInt(String s) {
        HashMap<String, Integer> numMap = new HashMap<>();
        numMap.put("I", 1);
        numMap.put("V", 5);
        numMap.put("X", 10);
        numMap.put("L", 50);
        numMap.put("C", 100);
        numMap.put("D", 500);
        numMap.put("M", 1000);
        numMap.put("IX", 9);
        numMap.put("IV", 4);
        numMap.put("XL", 40);
        numMap.put("XC", 90);
        numMap.put("CD", 400);
        numMap.put("CM", 900);

        int result = 0;
        // Fill the dictionary
        while (!s.isEmpty()) {
            if (s.length() >= 2) {
                String reducedNumber = s.charAt(0) + "" + s.charAt(1);
                if (numMap.containsKey(reducedNumber)) {
                    result += numMap.get(reducedNumber);
                    s = s.substring(2);
                    continue;
                }
            }
            String number = s.charAt(0) + "";
            if(numMap.containsKey(number)) {
                result += numMap.get(number);
                s = s.substring(1);
            }
        }
        return result;
    }
}
