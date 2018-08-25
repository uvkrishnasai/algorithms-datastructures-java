package datastructures.math;

/**
 * Created by Krishna on 6/12/16.
 */
public class BinaryToDecimal {


    //mine
    public static int convertToDecimal(int binary) {
        int decimal = 0;
        int index = 0;
        while(binary > 0) {
            decimal += (binary%10 * Math.pow(2, index));
            binary /= 10;
            index++;
        }
        return decimal;
    }

    public static void main(String[] args) {
        System.out.println(convertToDecimal(1110));
        System.out.println(convertToDecimal(1111));
    }

}
