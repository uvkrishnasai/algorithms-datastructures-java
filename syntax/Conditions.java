package syntax;

import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class Conditions {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Optional<Integer> opt = Stream
                .of(N)
                .filter(n -> (n % 2 == 0) && ((n >= 2 && n<=5) || (n > 20)))
                .findAny();
        System.out.println(opt.isPresent() ? "Not Weird" : "Weird");
        scanner.close();
    }
}
