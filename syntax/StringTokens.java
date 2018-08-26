package syntax;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Link: https://www.hackerrank.com/challenges/java-string-tokens/problem
 *
 * Sample Input
 * He is a very very good boy, isn't he?
 *
 * Sample Output
 * 10
 * He
 * is
 * a
 * very
 * very
 * good
 * boy
 * isn
 * t
 * he
 */
public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();
        s = s.trim();

        if (s.length() == 0)
            System.out.println(0);
        else {
            String[] sSplit = s.split("[!,?._\'@\\s]+");
            System.out.println(
                    Arrays.stream(sSplit)
                            .collect(
                                    Collectors.joining(
                                            "\n",
                                            String.valueOf(sSplit.length) + "\n",
                                            "")
                            )
            );
        }
        scan.close();
    }
}
