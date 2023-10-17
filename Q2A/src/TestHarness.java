/**A program that tests sorting algorithms and puts the created array into a txt file, and the sorted array into another
 * Tests if array is properly sorted
 * Details in console and in sorted text file
 *
 *@version 1.0 (Oct 15th, 2023)
 *@author Steve Mastrokalos   */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestHarness {

    FileWriter writer;
    File output;
    static final String FIRSTOUTPUT = "input_array.txt";
    static final String SECONDOUTPUT = "tested_sorted_array.txt";
    Random rand = new Random();

    TestHarness(){
        setUpWriter(FIRSTOUTPUT);

        int[] randArray = createRandomArray(rand.nextInt((int)Math.pow(2, 16)));
        output(randArray);

        endWriter();
        setUpWriter(SECONDOUTPUT);

        int[] sortedArray = SortingAlgorithm.SortArray(randArray);
        testArrayIsSorted(sortedArray);
        endWriter();
        return;
    }

    /**Checks if integer array is sorted from least to greatest
     *
     * @param array Array to check if it is sorted
     * @return  returns if the array was sorted
     */
    boolean testArrayIsSorted(int[] array){
        boolean errorFree = true;
        int errorCounter = 0;
        String[] errorLog = new String[50];

        for(int i = 0; i < array.length; i++)  //Iterates through array and checks if each element is greater or equal to the previous element
        {
            output(i+":  \t" + array[i]);

            if(i > 0 && array[i] < array[i-1])  //If the current element is less than the previous element, the system will scream it out in red
            {
                output(errorLog[errorCounter] = "\u001B[31m" + "Element " + i + " (" + array[i] + ") is less than element " + (i-1)+ " (" + array[i-1] +   ")\u001B[0m");
                errorFree = false;
                errorCounter++;
            }
        }

        //Outputs the number of errors if there were any, and then returns if there were any errors
        if(!errorFree)
        {
            System.out.println("\u001B[31m" + "\n\nThere was at least " + errorCounter + " error(s). Please look for the locations in the sorted array\n\n" + "\u001B[0m");
            for(int i = 0; i < errorCounter; i++)   System.out.println(errorLog[i]);
        }else
        {
            System.out.println("\u001B[32m" + "There were no errors" + "\u001B[0m");
        }
        return errorFree;
    }

    /**Creates a random array of inputted size to be run through the sorting algorithm as a test.
     * each element of the array is a random integer of
     *
     * @param size
     * @return
     */
    int[] createRandomArray(int size){
        int[] temp = new int[size];
        for(int i = 0; i < size; i++) temp[i] = randomInt();
        return temp;
    }

    /**Creates a random integer of any possible integer value.
     *
     * @return  A random integer of any possible integer value
     */
    int randomInt(){
        int temp = rand.nextInt();
        if(rand.nextBoolean())  return temp;
        return -temp;
    }

    /**Sets up the file writer with the given file name
     *
     * @param fileName Name of the output file
     */
    void setUpWriter(String fileName) {
        try {
            output = new File(fileName);
            writer = new FileWriter(fileName);
        }catch (IOException e){
            System.out.println("error in creating the file");
        }
    }

    /**Closes the writer when you're done with it
     *
     */
    void endWriter(){
        try {
            writer.flush();
            writer.close();
        }catch (IOException e){
            System.out.println("The Writer must be used before it can be ended");
        }
    }

    /**Outputs each element of given array to the output file
     * Each element gets its own line
     * Prints in array order (element 0, element 1, element 2, etc.,)
     * Only works on full arrays
     *
     * @param array
     */
    void output(int[] array){
        for(int i = 0; i < array.length; i++) {
            output(Integer.toString(array[i]));
        }
    }

    /**Outputs the inputted parameter to output file
     *
     * @param out output
     */
    void output(String out) {
        try {
            writer.write(out + "\n");
        }catch (IOException e){
            System.out.println("help im on fire");
        }
    }

    //does the runny programmy thing
    public static void main(String[] args) throws IOException {TestHarness t = new TestHarness();}
}
