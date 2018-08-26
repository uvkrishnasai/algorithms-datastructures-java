package syntax;

import java.util.Scanner;
import java.util.stream.*;

/**
 * Link: https://www.hackerrank.com/challenges/java-output-formatting/problem
 *
 * Sample Input
 * java 100
 * cpp 65
 * python 50
 *
 * Sample Output
 * ================================
 * java           100
 * cpp            065
 * python         050
 * ================================
 */
public class StringFormatting {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        IntStream
                .rangeClosed(0, 2)
                .forEach(i ->
                        System.out.println(
                                String.format("%-15s", sc.next()) + String.format("%3d", sc.nextInt()).replace(' ','0')
                        ));
        System.out.println("================================");

    }
}
