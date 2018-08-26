package syntax;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Sample Input
 * 13
 *
 * Sample Output
 * prime
 */
public class PrimalityTest {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BigInteger n = scanner.nextBigInteger();
        System.out.println(n.compareTo(new BigInteger("1")) > 0 && n.isProbablePrime(100) ? "prime" : "not prime");
        scanner.close();
    }
}
