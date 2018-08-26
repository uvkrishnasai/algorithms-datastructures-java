package syntax;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Link: https://www.hackerrank.com/challenges/java-string-compare/problem
 *
 * Sample Input 0
 *
 * welcometojava
 * 3
 * Sample Output 0
 *
 * ava
 * wel
 */
public class SubStringComparisions {

    /**
     * Java 8 practise
     */
    public static String getSmallestAndLargest(String s, int k) {

        List<String> sList = Stream.iterate(0, i -> i + 1)
                .limit(s.length()-k+1)
                .map(i -> s.substring(i, i+k))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        return sList.get(0) + "\n" + sList.get(sList.size()-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(getSmallestAndLargest(s, k));
    }

}
