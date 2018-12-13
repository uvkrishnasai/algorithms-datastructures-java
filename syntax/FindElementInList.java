package syntax;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Link: https://www.hackerrank.com/challenges/java-arraylist/problem
 *
 * Sample Input
 * 5
 * 5 41 77 74 22 44
 * 1 12
 * 4 37 34 36 52
 * 0
 * 3 20 22 33
 * 5
 * 1 3
 * 3 4
 * 3 1
 * 4 3
 * 5 5
 *
 * Sample Output
 * 74
 * 52
 * 37
 * ERROR!
 * ERROR!
 */
public class FindElementInList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<int[]> list = IntStream
                .range(0, scan.nextInt())
                .mapToObj(i -> IntStream
                        .range(0, scan.nextInt())
                        .map(j -> scan.nextInt())
                        .toArray()
                )
                .collect(Collectors.toList());

        /*list.stream().forEach(
            i -> System.out.println(Arrays.stream(i).mapToObj(j -> String.valueOf(j))
            .collect(Collectors.joining(", ", "(", ")")))
        );*/

        IntStream.range(0, scan.nextInt()).forEach(i -> {
            int x = scan.nextInt()-1;
            int y = scan.nextInt()-1;
            System.out.println(
                    (x >= 0 && x < list.size())
                            ? (y >= 0 && y < list.get(x).length) ? Integer.toString(list.get(x)[y]) : "ERROR!"
                            : "ERROR!"
            );
        });
    }
}
