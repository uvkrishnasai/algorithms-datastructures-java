package org.practice.programs.beginner;

/**
 * Created by Krishna on 6/12/16.
 */
public class BubbleSort<T extends Comparable<T>>{

    public T[] array;

    public BubbleSort(T[] array) {
        this.array = array;
    }

    public void sort(){
        if (array.length <= 1)
            return;

        // every outer iteration places the tallest man at the end
        for (int i = array.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (this.array[j].compareTo(this.array[j+1]) > 0)
                    swap(j, j+1);
            }
        }

    }

    public void swap(int indx1, int indx2) {
        T tempElement = this.array[indx1];
        this.array[indx1] = this.array[indx2];
        this.array[indx2] = tempElement;
    }

    public static void main(String[] args) {

        Integer[] intArray  = new Integer[]{ 21, 1, 31, 51, 41, 91, 61, 32, 36, 93}; // creation of array

        BubbleSort<Integer> bSort = new BubbleSort<Integer>(intArray);

        bSort.sort();

        for (int i = 0; i < bSort.array.length; i++) {
            System.out.print(bSort.array[i] +" ");
        }
    }


}
