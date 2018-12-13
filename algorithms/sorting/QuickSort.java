package algorithms.sorting;

/**
 * Quick sort
 */
public class QuickSort {

	static void sort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}

	private static void sort(int[] arr, int start, int end) {
		int ind = partition(arr, start, end);

		// sort left half
		if (start < ind-1) {
			sort(arr, start, ind-1);
		}

		// sort right half
		if (ind < end) {
			sort(arr, ind, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end]; // pick a pivot

		while(start < end) {
			while (arr[start] < pivot) // find elem that should be on right
				start++;

			while (pivot < arr[end]) // find elem that should on left
				end--;

			if(start < end) { // swap left and right
				swap(arr, start, end);
				start++;
				end--;
			}
		}

		return start;
	}

	private static void swap(int[] arr, int ind1, int ind2) {
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] arr = new int[] { 21, 1, 31, 51, 41, 91, 61, 32, 36, 93};
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
