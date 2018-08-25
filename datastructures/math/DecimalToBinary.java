package datastructures.math;

/**
 * Created by Krishna on 6/11/16.
 */
public class DecimalToBinary {

    //JMSE
    public static String convertToBinary(int decimal) {
        String binary = null;
        while(decimal > 0) {
            if (binary == null)
                binary = String.valueOf(decimal%2);
            else
                binary = decimal%2 + binary;
            decimal /= 2;
        }
        return binary;
    }

    public static void main(String[] args) {
        System.out.println(convertToBinary(14));
        System.out.println(convertToBinary(15));
    }

}
