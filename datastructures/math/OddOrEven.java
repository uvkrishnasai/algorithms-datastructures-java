package datastructures.math;

/**
 * Created by Krishna on 6/11/16.
 *
 *
 * if last digit in binary format of a number is 1 - even
 * if last digit in binary format of a number is 0 - odd
 *
 */
public class OddOrEven {

    public static boolean isEven(int number) {
        if((number & 1) == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isEven(2));
        System.out.println(isEven(7));
        System.out.println(isEven(14));
        System.out.println(isEven(29));
        System.out.println(isEven(86));
    }

}
