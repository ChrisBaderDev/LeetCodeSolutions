package Solutions;

import java.util.HashMap;

public class C12_IntegerToRoman {

    // The naive solution
    public String intToRoman(int num) {
        String result = "";
        while(num > 0) {
            if(num - 1000 >= 0) {
                num -= 1000;
                result += "M";
                continue;
            }

            if(num - 900 >= 0) {
                num -= 900;
                result += "CM";
                continue;
            }

            if(num - 500 >= 0) {
                num -= 500;
                result += "D";
                continue;
            }

            if(num - 400 >= 0) {
                num -= 400;
                result += "CD";
                continue;
            }

            if(num - 100 >= 0) {
                num -= 100;
                result += "C";
                continue;
            }

            if(num - 90 >= 0) {
                num -= 90;
                result += "XC";
                continue;
            }

            if(num - 50 >= 0) {
                num -= 50;
                result += "L";
                continue;
            }

            if(num - 40 >= 0) {
                num -= 40;
                result += "XL";
                continue;
            }

            if(num - 10 >= 0) {
                num -= 10;
                result += "X";
                continue;
            }

            if(num - 9 >= 0) {
                num -= 9;
                result += "IX";
                continue;
            }

            if(num - 5 >= 0) {
                num -= 5;
                result += "V";
                continue;
            }

            if(num - 4 >= 0) {
                num -= 4;
                result += "IV";
                continue;
            }

            if(num - 1 >= 0) {
                num -= 1;
                result += "I";
            }
        }
        return result;
    }
}
