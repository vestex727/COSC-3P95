/**Delta Debugs the UpperLower class to find the smallest substrings of strings that are misbehaving for
 * UpperLower.processString
 *
 * @version 1.0 (Oct 16th, 2023)
 * @author Steve Mastrokalos   */

import java.io.IOException;

public class DeltaDebug {
    String[] minValuesForBugs;  //String of the smallest bug-causing inputs found
    int bugIndex = 0;           //Number of bugs found, bug array current index
    static final String[] STRINGS_TO_TEST = {"abcdefG1", "CCDDEExy", "1234567b", "8665"};

    /**Tests all given inputs for UpperLower.processString
     *
     */
    DeltaDebug(){
        for(int i = 0; i < STRINGS_TO_TEST.length; i++)
        {
            String temp = STRINGS_TO_TEST[i];
            if(!isBehavingAsIntended(temp)) test(temp);
            else System.out.println("no bugs found in string: " + temp);
            bugIndex = 0;
        }
    }

    /**Tests the UpperLower.processString on given string
     *
     * @param toTest    String to test UpperLower.processString with
     */
    void test(String toTest){

        vUtil.pageBreak();
        minValuesForBugs = new String[toTest.length()];
        deltaDebug(toTest);
        System.out.println(UpperLower.processString(toTest));
        System.out.println(UpperLower.expectedProcessedString(toTest));

        for(int i = 0; i < bugIndex; i++){
            System.out.println(minValuesForBugs[i]);
        }
        if(bugIndex == 0) System.out.println("no bugs found in string");
        System.out.println(vUtil.pageBreak(false));
    }

    /**Finds the smallest possible sub strings that result in bugs
     *
     * Looks if bugs occurre in any strings of size 1, then 2, then 3, etc.,
     *
     * @param input String to find if it results in a bug when thrown through UpperLower
     */
    void deltaDebug(String input){
        int minSize = 1;
        while(bugIndex == 0){
            deltaDebug(input, minSize);
            minSize++;
        }
    }

    /**Takes in a String array of size 2 or more and runs deltaDebug on the first 2 strings in the array
     * For taking 2 halves of a string and deltaDebugging each half
     *
     * @param input Strings to be deltaDebugged
     * @param minSize   Minimum size for a bug to appear
     */
    void deltaDebug(String[] input, int minSize){
        deltaDebug(input[0], minSize);deltaDebug(input[1], minSize);
    }

    /**deltaDebugs inputted string, finds the smallest substrings that result in unexpected behaviour
     *Recursively splits the string in half until the smallest parts with bugs are found
     *
     * @param input     String to find bugs in
     * @param minSize   Minimum size to look for bugs in
     */
    void deltaDebug(String input, int minSize){
        if(isBehavingAsIntended(input)) return; //Backs up recursive search if no bugs are in the remaining string
        if(input.length() < minSize) return;    //Backs up recursive search if we are below the min size
        if(input.length() == minSize && !isBehavingAsIntended(input)){      //records any bugs found if at the minimum size
            minValuesForBugs[bugIndex] = input;
            bugIndex++;
            return;
        }
        else    //If we can split the string more, breaks it into 2 halves and delta debugs each half
        {
            int delta = (int)Math.floor(input.length()/2);
            deltaDebug(halves(input), minSize);
        }
        return;
    }

    /**Splits a string into 2 halves, each put into a 2 element array
     * halves[0] = first half of the string
     * halves[1] =
     *
     * @param input
     * @return
     */
    String[] halves(String input){
        int delta = (int)Math.floor(input.length()/2);
        String front = "";
        String back = "";

        for(int i = 0; i < delta; i++)
        {
            front += input.charAt(i);
        }
        for(int i = delta; i < input.length(); i++){
            back +=input.charAt(i);
        }

        String[] array = {front, back};

        return array;
    }

    /**Returns a boolean value that the program is behaving as expected for the given input
     * True if expected result given
     * False if not
     * @param input String to be run through UpperLower
     * @return  Boolean value of if UpperLower is giving the expected result for the given input.
     */
    boolean isBehavingAsIntended(String input){
        if(UpperLower.processString(input).equals(UpperLower.expectedProcessedString(input))) return true;
        return false;
    }



    //does the runny programmy thing
    public static void main(String[] args) throws IOException {DeltaDebug d = new DeltaDebug();}
}
