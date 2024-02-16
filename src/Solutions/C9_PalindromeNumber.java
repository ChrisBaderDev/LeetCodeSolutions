package Solutions;

public class C9_PalindromeNumber {

    // The naive approach
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // The mathematical approach
    public boolean isPalindromeV2(int x) {
        int z = x;
        int reversed = 0;
        while(x > 0) {
            int lastDigit = x % 10;
            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }
        return reversed == z;
    }
}
