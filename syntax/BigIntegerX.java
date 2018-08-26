package syntax;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * Sample Input
 * 1234
 * 20
 *
 * Sample Output
 * 1254
 * 24680
 */
public class BigIntegerX {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger sumResult = new BigInteger("0");
        BigInteger mulResult = new BigInteger("1");
        while (scanner.hasNextBigInteger()) {
            BigInteger value = scanner.nextBigInteger();
            sumResult = sumResult.add(value);
            mulResult = mulResult.multiply(value);
        }

        System.out.println(sumResult);
        System.out.println(mulResult);
    }
}
