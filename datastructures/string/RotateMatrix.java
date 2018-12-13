package datastructures.string;

import java.util.Arrays;

/**
 * Cracking the coding interview: 1.7
 * Rotate Matrix:
 * Image represented by NxN matrix
 * each pixel in the image is 4 bytes
 * Rotate the image by 90 degrees
 * Inplace rotation
 */
public class RotateMatrix {

    public static void main(String[] args) {

        // Prepare test data.
        int[][] matrix = new int[5][5];
        int count = 0;
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = ++count;
            }
        }

        // Print matrix before
        printMatrix(matrix);

        // solution
        rotate(matrix);

        // Print matrix after
        printMatrix(matrix);
    }

    /**
     * 1,1 -> 1,4 => row = col; col = abs(row - length + 1)
     * 1,4 -> 4,4
     * 4,4 -> 4,1
     * 4,1 -> 1,1
     * @param matrix
     * @return
     */
    private static void rotate(int[][] matrix) {
        // rotate only half rows because the other half is already taken care.
        for(int row = 0; row < matrix.length/2; row++) {
            // rotate until col reaches length-row-1 because the others are already taken care
            for(int col = row; col < matrix[0].length-row-1; col++) {
                push(matrix, col, Math.abs(row - matrix.length+1), matrix[row][col], row, col);
            }
        }
    }

    /**
     * Push value using recursion.
     * @param matrix
     * @param currRow
     * @param currCol
     * @param value
     * @param row
     * @param col
     */
    private static void push(int[][] matrix, int currRow, int currCol, int value, int row, int col) {

        int temp = matrix[currRow][currCol];
        matrix[currRow][currCol] = value;

        if (currRow == row && currCol == col)
            return;

        push(matrix, currCol, Math.abs(currRow - matrix.length+1), temp, row, col);
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("------------------------------");
        Arrays.stream(matrix).forEach(row -> {
            Arrays.stream(row).forEach(i-> System.out.print(String.format("| %02d |", i)));
            System.out.println();
        });
        System.out.println("------------------------------");
    }
}
