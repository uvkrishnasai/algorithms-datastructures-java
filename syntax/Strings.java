package syntax;

import java.util.Scanner;

/**
 * Link: https://www.hackerrank.com/challenges/java-strings-introduction/problem
 *
 * Sample Input 0
 * hello
 * java
 *
 * Sample Output 0
 * 9
 * No
 * Hello Java
 */
public class Strings {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.println(
                A.substring(0,1).toUpperCase() + A.substring(1) + " " +
                        B.substring(0,1).toUpperCase() + B.substring(1));
    }
}
