package algorithms.sorting;

/**
 * Created by Krishna on 6/12/16.
 */
public class BubbleSort<T extends Comparable<T>> {

    public void sort(T[] array){
        if (array.length <= 1)
            return;

        // every outer iteration places the tallest man at the end
        for (int i = array.length-1; i > 0; i--) {
            // compare and swap adjacent elements
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j+1]) > 0)
                    swap(array, j, j+1);
            }
        }

    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr  = new Integer[]{ 21, 1, 31, 51, 41, 91, 61, 32, 36, 93};

        BubbleSort<Integer> bSort = new BubbleSort();
        bSort.sort(arr);

        assert arr[0] == 1;
        assert arr[1] == 21;
        assert arr[2] == 31;
        assert arr[3] == 32;
        assert arr[4] == 36;
        assert arr[5] == 41;
        assert arr[6] == 51;
        assert arr[7] == 61;
        assert arr[8] == 91;
        assert arr[9] == 93;
    }


}
