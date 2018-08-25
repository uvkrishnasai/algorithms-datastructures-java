package algorithms.sorting;

public class InsertionSort {
	
	public int[] elements;
	private int index;
	private int size;
	
	public InsertionSort(int size) {
		super();
		this.size = size;
		this.index = 0;
		elements = new int[size];
	}
	
	public void insert(int element){
		elements[index++] = element;
	}
	
	public void sort(){
		for (int i = 1; i<index; i++) {
			int j=i;
			while(j>0){
				if (elements[j] < elements[j-1]) {
					swap(j, j-1);
					j--;
				}else{
					break;
				}
			}
		}
	}
	
	private void swap(int a, int b) {
		int temp = elements[a];
		elements[a]=elements[b];
		elements[b] = temp;
	}



	public static void main(String[] args) {
		InsertionSort is = new InsertionSort(5);
		is.insert(3);
		is.insert(2);
		is.insert(4);
		is.insert(0);
		is.insert(1);
		is.sort();
		for (int i : is.elements) {
			System.out.println(i);
		}
	}
	
}
