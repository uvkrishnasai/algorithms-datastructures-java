package datastructures.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Given an array of integers, calculate the fractions of its elements that are positive, negative, and are zeros.
 * Print the decimal value of each fraction on a new line.
 *
 * Note: This challenge introduces precision problems.
 * The test cases are scaled to six decimal places, though answers with absolute error of up to 10^-4 are acceptable.
 *
 * For example, given the array arr=[1,1,0,-1,-1] there are  elements, two positive, two negative and one zero.
 * Their ratios would be 2/5, 2/5 and 1/5. It should be printed as
 *
 * 0.400000
 * 0.400000
 * 0.200000
 *
 * Link: https://www.hackerrank.com/challenges/plus-minus/problem
 */
public class PlusMinus {

    static void plusMinus(int[] arr) {
        int[] seperatedElements = seperateElementTypes(arr);
        double totalNoOfElements = BigDecimal.valueOf(arr.length).setScale(4, RoundingMode.HALF_UP).doubleValue();
        for(int e: seperatedElements) {
            double e1 = BigDecimal.valueOf(e).setScale(4, RoundingMode.HALF_UP).doubleValue();
            double fraction = e1/totalNoOfElements;
            System.out.println(fraction);
        }
    }

    // create an array with number of positive, negatives and zeros
    private static int[] seperateElementTypes(int[] arr) {
        int noOfPos = 0;
        int noOfNeg = 0;
        int noOfZeros = 0;
        for(int e : arr) {
            if (e > 0) {
                noOfPos++;
            } else if(e < 0) {
                noOfNeg++;
            } else
                noOfZeros++;
        }
        int[] result = {noOfPos, noOfNeg, noOfZeros};
        return result;
    }
}
