package syntax;

import java.util.Scanner;

/**
 * Link: https://www.hackerrank.com/challenges/java-1d-array/problem
 *
 * Sample Input
 * 4
 * 5 3
 * 0 0 0 0 0
 * 6 5
 * 0 0 0 1 1 1
 * 6 3
 * 0 0 1 1 1 0
 * 3 1
 * 0 1 0
 *
 * Sample Output
 * YES
 * YES
 * NO
 * NO
 */
public class OneDimensionArray {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        game[0] = 1;
        return jump(game, 0, leap);
    }

    public static boolean jump(int[] game, int index, int leap) {
        if (game.length == 0 ||
                index >= game.length ||
                index+leap >= game.length ||
                index + 1 >= game.length) {
            return true;
        }

        if (index > 0 && game[index-1] == 0) {
            game[index-1] = 1;
            if (jump(game, index-1, leap)) return true;
        }

        if (game[index + 1] == 0) {
            game[index+1] = 1;
            if (jump(game, index+1, leap)) return true;
        }

        if (game[index + leap] == 0) {
            game[index+leap] = 1;
            if (jump(game, index+leap, leap)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println(canWin(leap, game) ? "YES" : "NO");
        }
        scan.close();
    }
}
