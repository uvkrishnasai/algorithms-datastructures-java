package syntax;

import java.util.Scanner;

public class IntToString {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        String s = "";
        if (n >= -100 && n <=100) {
            s = String.valueOf(n);
        }
    }
}
