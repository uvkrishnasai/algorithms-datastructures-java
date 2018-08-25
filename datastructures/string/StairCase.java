package datastructures.string;

/**
 * Consider a staircase of size :
 *
 *    #
 *   ##
 *  ###
 * ####
 * Observe that its base and height are both equal to n, and the image is drawn using # symbols and spaces. The last line is not preceded by any spaces.
 *
 * Write a program that prints a staircase of size n.
 *
 * Link: https://www.hackerrank.com/challenges/staircase/problem
 */
public class StairCase {

    static void staircase(int n) {
        for (int i = 0; i < i+n; i++) {

            int spaces = i;
            int symbols = i+n;

            while (spaces < symbols-1) {
                System.out.print(' ');
                spaces++;
            }

            while (symbols > n-1) {
                System.out.print('#');
                symbols--;
            }

            n--;
        }
    }
}
