import Solutions.C12_IntegerToRoman;
import Solutions.C14_LongestCommonPrefix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        C12_IntegerToRoman c12 = new C12_IntegerToRoman();
        System.out.println(c12.intToRoman(1234));
        System.out.println(c12.intToRomanV2(1234));
    }
}