package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {

	private int[] queue;
	
	private int getPivotIndex(int queueSize){
		return queueSize/2;
	}
	
	private int getIndex(int[] queue, int element){
		for (int i = 0; i < queue.length; i++) {
			if(queue[i] == element){
				return i;
			}
		}
		return 0;
	}
	
	private void swap(int index1, int index2, int[] queue) {
		int temp = queue[index1];
		queue[index1] = queue[index2];
		queue[index2] = temp;
	}
	
	private void partitionAndCombine(int[] queue){
		int pivotIndex = getPivotIndex(queue.length);
		int pivot = queue[pivotIndex];
		int[] subQueue1;
		int[] subQueue2;
		outer: for (int i = 0; i < queue.length; i++) {
			int iElement = queue[i];
			
			if (iElement < pivot) {
				continue;
			} else {
				for (int j = i+1; j <= queue.length; j++) {
					if(j==queue.length) {
						if(iElement != pivot) 
							swap(i, pivotIndex, queue);
						break outer;
					}
					int jElement = queue[j];
					if (jElement < pivot) {
						swap(i, j, queue);
						break;
					}
				}
			}
		}
		
		pivotIndex = getIndex(queue, pivot);
		if(pivotIndex > 1) {
			subQueue1 = Arrays.copyOfRange(queue, 0, pivotIndex);
			partitionAndCombine(subQueue1);
			System.arraycopy(subQueue1, 0, queue, 0, subQueue1.length);
		}
		if(queue.length - pivotIndex - 1 > 1) {
			subQueue2 = Arrays.copyOfRange(queue, pivotIndex+1, queue.length);
			partitionAndCombine(subQueue2);
			System.arraycopy(subQueue2, 0, queue, pivotIndex+1, subQueue2.length);
		}
			
	}
	
	public void sort() {
		partitionAndCombine(queue);
	}
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		qs.queue = new int[] {77, 32, 55, 56, 75, 11, 89, 8, 4, 5, 1, 90};
		qs.sort();
		for (int element : qs.queue) {
			System.out.print(element + ",");
		}
		
	}

}
