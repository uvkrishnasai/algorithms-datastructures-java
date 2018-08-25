package datastructures.math;

/**
 * Created by Krishna on 5/22/16.
 *
 * A armstrong number is a number such that the sum of the cubes of its digits is equal to the number itself.
 * 1pow3 + 5pow3 + 3pow3 = 1 + 125 + 27 = 153.
 *
 */
public class ArmstrongNumber {

    // Mine == JMSE
    public static boolean isArmstrong(long num) {
        int sumOfCubes = 0;

        long numTemp = num;
        while (numTemp > 0) {
            long digit = numTemp%10;
            sumOfCubes += digit * digit * digit;
            numTemp = numTemp/10;
        }

        if (num == sumOfCubes)
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(153L));
    }

}
