package Solutions;

public class C10_RegularExpressionMatching {

    // Recursive Approach
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String input, String pattern, int textIndex, int patternIndex) {
        // This is our base case, it is called when we have exhausted the pattern
        if (patternIndex == pattern.length()) {
            return textIndex == input.length();
        }

        // Check if the current characters match or if the pattern char is '.', which also results in a match.
        boolean firstMatch = (textIndex < input.length()
                && (pattern.charAt(patternIndex) == input.charAt(textIndex)
                || pattern.charAt(patternIndex) == '.'));

        // Handle case with '*'
        if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
            // Proceed two characters ahead in the pattern, or check next character in the text if it matches the current pattern char
            return (isMatch(input, pattern, textIndex, patternIndex + 2) ||
                    (firstMatch && isMatch(input, pattern, textIndex + 1, patternIndex)));
        } else {
            return firstMatch && isMatch(input, pattern, textIndex + 1, patternIndex + 1);
        }
    }

    // Dynamic Programming Approach
    public boolean isMatchV2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // This is again our base case. It means, that an empty string, matches an empty pattern.
        dp[0][0] = true;

        // Patterns like a*, a*b*, a*b*c*, a*b*c*d*, and so on, match an empty string.
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char currentS = s.charAt(i - 1);
                char currentP = p.charAt(j - 1);

                if (currentP == '.' || currentP == currentS) {
                    // Here we match either the character values of have a match with '.', which matches every char.
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currentP == '*') {
                    // Here we handle the case of no occurrences, as the * metacharacter allows that.
                    dp[i][j] = dp[i][j - 2]; // '*' as zero occurrence
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == currentS) {
                        // Here we handle the case of one or more occurrences of the metacharacter operator
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
