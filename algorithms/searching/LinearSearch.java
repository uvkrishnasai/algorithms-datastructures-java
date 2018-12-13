package algorithms.searching;

/**
 * Created by Krishna on 6/12/16.
 */
public class LinearSearch<T extends Comparable<T>> {

    private T[] array;

    public LinearSearch(T[] array) {
        this.array = array;
    }

    /**
     * Search for the element and return its index.
     * @param element integer
     * @return index if found else return -1
     */
    public int search(T element){
        // iterate through each element and return index if found.
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] intArray  = new Integer[]{ 21, 1, 31, 51, 41, 91, 61, 32, 36, 93}; // creation of array

        LinearSearch<Integer> linearSearch = new LinearSearch<>(intArray);
        assert linearSearch.search(91) == 5;
        assert linearSearch.search(2) == -1;
    }

}
