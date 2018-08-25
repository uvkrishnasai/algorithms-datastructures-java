package datastructures.math;

/**
 * Created by Krishna on 5/22/16.
 */
public class ReverseNumber {

    //my Code
    public int reverse(int integer) {
        int newInt = 0;
        while (integer > 9) {
            newInt = (newInt*10) + integer%10;
            integer = integer/10;
        }
        if (integer == 0)
            return newInt;
        else
            return newInt*10+integer;
    }

    //jmse Code
    public int reverseJmse(int integer) {
        int newInt = 0;
        while (integer > 0) {
            newInt = (newInt*10) + integer%10;
            integer = integer/10;
        }
        return newInt;
    }

    public static void main(String[] args) {
        ReverseNumber rn = new ReverseNumber();
        System.out.println(rn.reverse(5));
        System.out.println(rn.reverseJmse(5));
    }
}
