/**A program that flips upper and lowercases in a string
 *
 *@version 1.0 (Oct 16th, 2023)
 *@author Steve Mastrokalos   */

import static java.lang.Character.*;

public class UpperLower {
    public static String processString(String input_str) {
        String output_str = "";;
        for(int i =0; i < input_str.length(); i++) {
            char c = input_str.charAt(i);
            if (isUpperCase(c)) {
                output_str += toLowerCase(c);
            } else if (isDigit(c)) {
                output_str += c;
                output_str += c;
            } else {
                output_str += toUpperCase(c);
            }
        }
        return output_str;
    }

    public static String expectedProcessedString(String input_str) {
        String output_str = "";;
        for(int i =0; i < input_str.length(); i++) {
            char c = input_str.charAt(i);
            if (isUpperCase(c)) {
                output_str += toLowerCase(c);
            } else if (isDigit(c)) {
                output_str += c;
            } else {
                output_str += toUpperCase(c);
            }
        }
        return output_str;
    }
}
