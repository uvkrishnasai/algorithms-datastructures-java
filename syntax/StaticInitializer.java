package syntax;

import java.util.Scanner;

/**
 * Link: https://www.hackerrank.com/challenges/java-static-initializer-block/problem
 * Sample input 1
 * 1
 * 3
 *
 * Sample output 1
 * 3
 *
 * Sample input 2
 * -1
 * 2
 *
 * Sample output 2
 * java.lang.Exception: Breadth and height must be positive
 */
public class StaticInitializer {

    private static boolean flag = calculateArea();
    private static int B;
    private static int H;

    public static boolean calculateArea() {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();

        try {
            if (B <= 0 || H <= 0)
                throw new Exception("Breadth and height must be positive");
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }
}
