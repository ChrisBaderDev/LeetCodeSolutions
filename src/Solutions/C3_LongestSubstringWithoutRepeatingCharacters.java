package Solutions;

public class C3_LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        // Handle special cases
        if (s.length() <= 1) return s.length();

        // Initialize pointers for the sliding window and create the visited array
        int maxLength = 0;
        boolean[] visited = new boolean[256];
        int left = 0, right = 0;
        while (right < s.length()) {
            if (visited[s.charAt(right)]) {
                while (visited[s.charAt(right)]) {
                    visited[s.charAt(left)] = false;
                    left++;
                }
            }
            visited[s.charAt(right)] = true;
            maxLength = Math.max(maxLength, (right - left + 1));
            right++;
        }
        return maxLength;
    }
}
