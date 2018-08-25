package algorithms.searching;

/**
 * Created by Krishna on 6/12/16.
 */
public class LinearSearch<T extends Comparable<T>> {

    public T[] array;

    public LinearSearch(T[] array) {
        this.array = array;
    }

    public void search(T element){

        // Every outer iteration will move smallest to the left
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                System.out.println("Element found at index " + i);
                return;
            }
        }

        System.out.println("Element not found");
    }

    public static void main(String[] args) {

        Integer[] intArray  = new Integer[]{ 21, 1, 31, 51, 41, 91, 61, 32, 36, 93}; // creation of array

        LinearSearch<Integer> linearSearch = new LinearSearch<>(intArray);

        linearSearch.search(91);
//        linearSearch.search(100);

    }

}
