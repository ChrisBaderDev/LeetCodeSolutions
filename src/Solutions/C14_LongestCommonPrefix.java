package Solutions;

import java.util.Arrays;

public class C14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        int maxPrefix = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++) {
            maxPrefix = Math.min(maxPrefix, strs[i].length());
        }
        String prefix = "";
        for(int i = 0; i < maxPrefix; i++) {
            for(int j = 0; j < strs.length - 1; j++) {
                if(strs[j].charAt(i) != strs[j+1].charAt(i)) return prefix;
            }
            prefix += strs[0].charAt(i);
        }
        return prefix;
    }


    // Sort Approach
    public String longestCommonPrefixV2(String[] strs) {
        if(strs==null || strs.length==0) return "";
        Arrays.sort(strs);
        StringBuilder lcp = new StringBuilder();
        String start = strs[0];
        String end = strs[strs.length - 1];
        for(int i = 0; i < Math.min(start.length(), end.length()); i++) {
            if(start.charAt(i) != end.charAt(i)) return lcp.toString();
            lcp.append(strs[0].charAt(i));
        }
        return lcp.toString();
    }

    // Reverse Approach
}
