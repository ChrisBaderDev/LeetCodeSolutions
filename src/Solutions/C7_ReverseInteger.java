package Solutions;

public class C7_ReverseInteger {

    public static int reverse(int x) {
        int upperBound = (int) Math.pow(2, 31)  - 1;
        int lowerBound = (int) -Math.pow(2, 31);

        String xString = String.valueOf(x);
        String yString = "";
        for(int i = 0; i < xString.length(); i++) {
            yString += xString.charAt(xString.length() - 1 - i);
        }
        if(x < 0) {
            yString = yString.substring(0, yString.length() - 1);
            yString = "-" + yString;
        }
        int y = 0;
        try {
            y = Integer.parseInt(yString);
        } catch (NumberFormatException e) {
            return 0;
        }
        if(y > upperBound || y < lowerBound) {
            return 0;
        }
        return y;
    }

    public static int reverseV2(int x) {
        int y = 0;
        int xAbs = Math.abs(x);

        while(xAbs > 0) {
            int lastDigit = xAbs % 10;
            y = y + 10 * lastDigit;
            xAbs /= 10;
            if(y == Integer.MAX_VALUE) return 0;
        }
        return x < 0 ? y * (-1) : y;
    }
}
