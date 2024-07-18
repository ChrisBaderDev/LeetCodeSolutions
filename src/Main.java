import Solutions.C12_IntegerToRoman;
import Solutions.C13_RomanToInteger;
import Solutions.C14_LongestCommonPrefix;
import Solutions.C16_3SumClosest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        C16_3SumClosest c163SumClosest = new C16_3SumClosest();
        System.out.println(c163SumClosest.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }
}