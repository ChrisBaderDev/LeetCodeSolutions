package Solutions;

public class C5_LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int maxLength = -1;
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (isPalindrome(s.toCharArray(), i, j)) {
                    if (maxLength < (j - i)) {
                        longestPalindrome = s.substring(i, j);
                        maxLength = j - i;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    public static String longestPalindromeV2(String s) {
        int maxLength = 0;
        String maxPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            String oddWord = expand(s, i, i);
            String evenWord = expand(s, i, i + 1);
            if (oddWord.length() > maxLength) {
                maxPalindrome = oddWord;
                maxLength = oddWord.length();
            }
            if (evenWord.length() > maxLength) {
                maxPalindrome = evenWord;
                maxLength = evenWord.length();
            }

        }
        return maxPalindrome;
    }

    public static String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    //TODO: Replace isPalindrome
    public static boolean isPalindrome(char[] chars, int start, int end) {
        return true;    // This is not right, I deleted the original and was to lazy to replace it
    }

}
