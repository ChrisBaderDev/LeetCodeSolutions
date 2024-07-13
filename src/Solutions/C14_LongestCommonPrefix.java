package Solutions;

public class C14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
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
}
