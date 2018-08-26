package syntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Sample Input
 * 5
 * 1 -2 4 -5 1
 *
 * Sample Output
 * 9
 */
public class SubArray {

    public static void main(String[] args) {
        /* Java 8 Practise. */
        Scanner scan = new Scanner(System.in);
        int[] arr = IntStream.range(0, scan.nextInt()).map(i -> scan.nextInt()).toArray();
        long cnt = IntStream.range(0,arr.length).mapToObj(i -> {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for(int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                list.add(new Integer(sum));
            }
            return list.toArray(new Integer[list.size()]);
        })
                .flatMap(x -> Arrays.stream(x))
                .filter(x -> x < 0)
                .count();
        System.out.println(cnt);
    }
}
