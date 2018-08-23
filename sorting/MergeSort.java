package org.practice.sorting;

import java.util.Arrays;

public class MergeSort {

	private int[] queue;
	
	private int getMidpoint(int queueSize){
		return queueSize/2;
	}
	
	private void divideAndConcur(int[] queue){
		int midPoint = getMidpoint(queue.length);
		int[] subQueue1 = new int[midPoint];
		int[] subQueue2 = new int[queue.length - midPoint];
		

		subQueue1 = subQueue1.length==1? new int[] {queue[midPoint-1]} : Arrays.copyOfRange(queue, 0, midPoint);
		subQueue2 = subQueue2.length==1? new int[] {queue[midPoint]} : Arrays.copyOfRange(queue, midPoint, queue.length);
		
		if (subQueue1.length == 1) {
			if (subQueue2.length == 1) {
				concur(queue, subQueue1, subQueue2);
			}else{
				divideAndConcur(subQueue2);
				concur(queue, subQueue1, subQueue2);
			}
		}else{
			divideAndConcur(subQueue1);
			divideAndConcur(subQueue2);
			concur(queue, subQueue1, subQueue2);
		}
		
	}
	
	private void concur(int[] queue, int[] subQueue1, int[] subQueue2){
		int cnt = 0;
		int startPos = 0;
		
		for (int i = 0; i < subQueue2.length; i++) {
			for (int j = startPos; j < subQueue1.length; j++) {
				if (subQueue2[i] > subQueue1[j]) {
					cnt = pushToQueue(queue, subQueue1[j], cnt);
					startPos = j+1;
				}
			}
			cnt = pushToQueue(queue, subQueue2[i], cnt);
		}
		
		for (int i = startPos; i < subQueue1.length; i++) {
			cnt = pushToQueue(queue, subQueue1[i], cnt);
		}
	}
	
	private int pushToQueue(int[] queue, int element, int index){
		queue[index++] = element;
		return index;
	}
	
	private void sort() {
		divideAndConcur(queue);
	}
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		ms.queue = new int[] {77, 32, 55, 56, 75, 11, 89, 8, 4, 5, 1, 90};
		ms.sort();
		for (int element : ms.queue) {
			System.out.print(element + ",");
		}
	}
	
}
