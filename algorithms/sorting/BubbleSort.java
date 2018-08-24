package org.practice.sorting;

/**
 * Created by Krishna on 5/20/16.
 * Average and worst case complexity of bubble sort is O(n2)
 * Best case: Rabbit example {5 1 2 3 4}  O(n)
 * Worst case: Turtle example {2 3 4 5 1} O(n2)
 * Stable and adaptive
 *
 * Compare each pair of adjacent elements from the beginning
 * if they are in reverse order
 * swap them (If at least 1 swap has been done repeat step1)
 * e.g: {5, 1, 12, -5, 16, -10, -4, 6, 14, 2, 30, -1}
 */
public class BubbleSort {

    public void sort(int[] array) {
        boolean swapped = true;
        int j=0;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length-j; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    private void swap(int[] array, int a, int b) {
        int p = array[a];
        array[a] = array[b];
        array[b] = p;
    }

    public static void main(String[] args) {
        int[] array = {5, 1, 12, -5, 16, -10, -4, 6, 14, 2, 30, -1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        for (int z:array) {
            System.out.print(z + " ");
        }

    }

}
