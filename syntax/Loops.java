package syntax;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Loop 1:
 * Link: https://www.hackerrank.com/challenges/java-loops-i/problem
 *
 * Sample Input
 * 2
 *
 * Sample Output
 * 2 x 1 = 2
 * 2 x 2 = 4
 * 2 x 3 = 6
 * 2 x 4 = 8
 * 2 x 5 = 10
 * 2 x 6 = 12
 * 2 x 7 = 14
 * 2 x 8 = 16
 * 2 x 9 = 18
 * 2 x 10 = 20
 *
 * Loop 2:
 * Link: https://www.hackerrank.com/challenges/java-loops/problem
 *
 * Sample Input
 * 2
 * 0 2 10
 * 5 3 5
 *
 * Sample Output
 * 2 6 14 30 62 126 254 510 1022 2046
 * 8 14 26 50 98
 */
public class Loops {

    private static final Scanner scanner = new Scanner(System.in);

    private static void loopOne(int N) {
        IntStream.rangeClosed(1,10)
                .forEachOrdered(i ->
                        System.out.println(
                                String.format("%d x %d = %d", N, i, i*N)
                        )
                );
    }

    private static void loopTwo() {
        Scanner in = new Scanner(System.in);
        IntStream.range(0, in.nextInt()).forEachOrdered(i -> {
            Integer[] input = {in.nextInt(), in.nextInt(), in.nextInt()};
            String[] result = {String.valueOf(input[0] + input[1])}; // Bad practice.
            String s = IntStream
                    .range(1, input[2])
                    .mapToObj(n -> result[0] = String.valueOf(Integer.parseInt(result[0]) + (int) Math.pow(2, n) * input[1]))
                    .collect(Collectors.joining(" ", String.valueOf(input[0] + input[1]) + " ", ""));
            System.out.println(s);
        });
        in.close();
    }


    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        loopOne(N);
        scanner.close();

        loopTwo();
    }
}
