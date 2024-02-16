package Solutions;

import java.util.LinkedList;
import java.util.List;

public class C6_ZigZagConversion {

    public static String convert(String s, int numRows) {
        boolean travelDown = false;
        int height = 0;
        Character[][] zigzagField = new Character[numRows][s.length()];
        for (int i = 0; i < s.length(); i++) {
            zigzagField[height][i] = s.charAt(i);
            if (height == 0 || height == numRows - 1) {
                travelDown = !travelDown;               // switch direction
            }
            height += travelDown ? 1 : -1;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (zigzagField[i][j] != null) {
                    builder.append(zigzagField[i][j]);
                }
            }
        }
        return builder.toString();
    }

    public static String convertV2(String s, int numRows) {
        List<StringBuilder> rows = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int height = 0;
        boolean travelDown = false;
        for (int i = 0; i < s.length(); i++) {
            if (height == 0 || height == numRows - 1) travelDown = !travelDown;
            rows.get(height).append(s.charAt(i));
            height += travelDown ? 1 : -1;
        }
        StringBuilder solutionBuilder = new StringBuilder();
        for (StringBuilder builder : rows) {
            solutionBuilder.append(builder);
        }
        return solutionBuilder.toString();
    }
}
