package algorithms.sorting;

/**
 * Created by Krishna on 6/12/16.
 */
public class SelectionSort<T extends Comparable<T>> {

    public T[] array;

    public SelectionSort(T[] array) {
        this.array = array;
    }

    public void sort(){
        if (array.length <= 1)
            return;

        // Every outer iteration will move smallest to the left
        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length-1; j++) {
                if (this.array[minIndex].compareTo(this.array[j]) > 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i)
                swap(i, minIndex);
        }

    }

    public void swap(int indx1, int indx2) {
        T tempElement = this.array[indx1];
        this.array[indx1] = this.array[indx2];
        this.array[indx2] = tempElement;
    }

    public static void main(String[] args) {

        Integer[] intArray  = new Integer[]{ 21, 1, 31, 51, 41, 91, 61, 32, 36, 93}; // creation of array

        SelectionSort<Integer> selectionSort = new SelectionSort<Integer>(intArray);

        selectionSort.sort();

        for (int i = 0; i < selectionSort.array.length; i++) {
            System.out.print(selectionSort.array[i] +" ");
        }
    }

}
