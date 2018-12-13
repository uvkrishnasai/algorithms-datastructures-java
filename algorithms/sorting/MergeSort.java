package algorithms.sorting;

import java.util.Arrays;

/**
 * Merge sort
 */
public class MergeSort {

	static void sort(int[] q) {
		divideAndConcur(q);
	}

	/*
	 * Divide the array into haf and concur the 2 halves using merge sort
	 * Recursion
	 */
	private static void divideAndConcur(int[] q){

		int mid = getMidpoint(q.length);
		int[] subQ1 = new int[mid];
		int[] subQ2 = new int[q.length - mid];

		subQ1 = subQ1.length==1? new int[] {q[mid-1]} : Arrays.copyOfRange(q, 0, mid);
		subQ2 = subQ2.length==1? new int[] {q[mid]} : Arrays.copyOfRange(q, mid, q.length);

		if (subQ1.length == 1) {
			if (subQ2.length == 1) {
				concur(q, subQ1, subQ2);
			}else{
				divideAndConcur(subQ2);
				concur(q, subQ1, subQ2);
			}
		}else{
			divideAndConcur(subQ1);
			divideAndConcur(subQ2);
			concur(q, subQ1, subQ2);
		}
	}

	/*
	 * Helper method to get mid point.
	 */
	private static int getMidpoint(int qSize){
		return qSize/2;
	}

	/*
	 * Merge 2 array left and right
	 */
	private static void concur(int[] q, int[] subQ1, int[] subQ2){
		int ind = 0;
		int pos = 0;

		// push all elements of subQ2 into q
		// compare each elem of subQ2 with elements of subQ1 and push elem of subQ1 if it is smaller
		for (int i = 0; i < subQ2.length; i++) {
			for (int j = pos; j < subQ1.length; j++) {
				if (subQ2[i] > subQ1[j]) {
					ind = pushToQueue(q, subQ1[j], ind);
					pos = j+1;
				} else
					break; // smaller elem from subQ1 not found, can jump to next elem in subQ2
			}
			ind = pushToQueue(q, subQ2[i], ind);
		}

		// push all other element of subQ1 which are left from above iteration
		for (int i = pos; i < subQ1.length; i++) {
			ind = pushToQueue(q, subQ1[i], ind);
		}
	}
	
	private static int pushToQueue(int[] q, int elem, int ind){
		q[ind++] = elem;
		return ind;
	}

	public static void main(String[] args) {
		int[] q = new int[] { 21, 1, 31, 51, 41, 91, 61, 32, 36, 90};
		sort(q);

		assert q[0] == 1;
		assert q[1] == 21;
		assert q[2] == 31;
		assert q[3] == 32;
		assert q[4] == 36;
		assert q[5] == 41;
		assert q[6] == 51;
		assert q[7] == 61;
		assert q[8] == 90;
		assert q[9] == 91;
	}
}
