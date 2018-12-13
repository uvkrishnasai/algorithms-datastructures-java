package algorithms.sorting;

/**
 * Insertion Sort:
 * Works the way we sort playing cards with our hands.
 *
 */
public class InsertionSort {

	/**
	 * Pick an element and insert it into sorted sequence.
	 * @param elements int array
	 */
	static void sort(int[] elements){
		for (int i = 0; i < elements.length; i++) {
			for(int j = i; j > 0; j--) { // go back from i to 0, swap if necessary
				if (elements[j] > elements[j-1])
					break;
				swap(elements, j, j-1);
			}
		}
	}
	
	private static void swap(int[] elements, int a, int b) {
		int temp = elements[a];
		elements[a]=elements[b];
		elements[b] = temp;
	}



	public static void main(String[] args) {
		int[] arr  = new int[]{ 21, 1, 31, 51, 41, 91, 61, 32, 36, 93};
		sort(arr);

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
