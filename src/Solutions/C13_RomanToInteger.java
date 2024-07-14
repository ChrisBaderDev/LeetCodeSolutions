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
        for(int i = 0; i < s.length(); i++) {
            String single = "" + s.charAt(i);
            String pair = i < s.length() - 1 ? s.charAt(i) + "" + s.charAt(i + 1) : single;
            if(numMap.containsKey(pair)) {
                result += numMap.get(pair);
                i += 1;
            } else {
                result += numMap.get(single);
            }
        }
        return result;
    }

    public int romanToIntV2(String s) {
        HashMap<String, Integer> numMap = new HashMap<>();
        numMap.put("I", 1);
        numMap.put("V", 5);
        numMap.put("X", 10);
        numMap.put("L", 50);
        numMap.put("C", 100);
        numMap.put("D", 500);
        numMap.put("M", 1000);

        int result = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(i == 0) {
                result += numMap.get("" + s.charAt(i));
                return result;
            }
            int x = numMap.get("" + s.charAt(i));
            int y = numMap.get("" + s.charAt(i - 1));
            if(x > y) {                                 // Smaller Number before a bigger number?
                result += (x - y);
                i--;
            } else {
                result += x;
            }
        }
        return result;
    }

    public static int getNumber(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> -1;
        };
    }

    public int romanToIntV3(String s) {
        char[] cs = s.toCharArray();
        int result = 0;
        for(int i = cs.length - 1; i >= 0; i--) {
            if(i == 0) {
                result += getNumber(cs[i]);
                return result;
            }
            int x = getNumber(cs[i]);
            int y = getNumber(cs[i-1]);
            if(x > y) {                                 // Smaller Number before a bigger number?
                result += (x - y);
                i--;
            } else {
                result += x;
            }
        }
        return result;
    }
}
