package syntax;

import java.util.Scanner;
import java.util.stream.IntStream;

public class StringReverse {

    // Java 8 Practice.
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        boolean match = IntStream.range(0, A.length()/2).allMatch(i -> A.charAt(i) == A.charAt(A.length()-i-1));
        System.out.println(match ? "Yes" : "No");
    }
}
