package syntax;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * For this problem, we have  types of queries you can perform on a List:
 *
 * Insert y at index x:
 * Insert
 * x y
 *
 * Delete the element at index x:
 * Delete
 * x
 */
public class ListOperations {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = IntStream.range(0, scan.nextInt())
                .mapToObj(i -> new Integer(scan.nextInt()))
                .collect(Collectors.toList());

        scan.nextInt();
        while (scan.hasNextLine()) {
            String action = scan.next();
            if(!action.equals("\n")) {

                if ("Insert".equalsIgnoreCase(action)) {
                    int x = scan.nextInt();
                    Integer y = new Integer(scan.nextInt());
                    list.add(x, y);
                }

                if ("Delete".equalsIgnoreCase(action)) {
                    int x = scan.nextInt();
                    Integer removed = list.remove(x);
                }
            }
        }

        System.out.println(
                list.stream().map(i -> Integer.toString(i)).collect(Collectors.joining(" "))
        );
    }
}
