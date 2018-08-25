package datastructures.matrix;

/**
 * Link: https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
public class DiagnolDifference {

    static int diagonalDifference(int[][] a) {
        int[] diagnolA = new int[a.length];
        int[] diagnolB = new int[a.length];

        int index = 0;
        for (int[] row : a) {
            diagnolA[index] = row[index];
            diagnolB[index] = row[row.length - index -1];
            index++;
        }

        return Math.abs(sumOf(diagnolA) - sumOf(diagnolB));
    }

    private static int sumOf(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }
        return sum;
    }
}
