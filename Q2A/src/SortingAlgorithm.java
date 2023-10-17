/**A silly, semi functional sorting algorithm made by yours truly
 *
 *@version 1.0 (Oct 15th, 2023)
 *@author Steve Mastrokalos   */

import java.util.Arrays;

public class SortingAlgorithm {

    /** A sorting algorithm that takes in an array of integers of any size and returns a sorted array
     *
     * @param array input array to be sorted
     * @return  sorted array
     */
    public static int[] SortArray(int[] array){
        Arrays.sort(array, 1, array.length-1);
        return array;
    }
}
