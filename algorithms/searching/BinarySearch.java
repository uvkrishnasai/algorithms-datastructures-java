package algorithms.searching;

public class BinarySearch {
	
	public int[] elements;
	private int size;
	private int index;
	
	public BinarySearch(int size){
		this.size = size;
		elements = new int[size];
	}
	
	public void insert(int element){
		elements[index] = element;
		for (int j = index; j >0; j--) {
			if (elements[j] < elements[j-1]) {
				swap(j, j-1);
			}else{
				break;
			}
		}
		index++;
	}
	
	public void swap(int a, int b){
		int temp = elements[a];
		elements[a] = elements[b];
		elements[b] = temp;
	}
	
	public void search(int searchElement){
		int lower = 0;
		int upper = size-1;
		System.out.println(binarySearchRecursive(searchElement, lower, upper));
	}
	
	public int binarySearchRecursive(int key, int lower, int upper){
		int mid = (lower+upper)/2;
		if (elements[mid] == key) {
			return mid;
		}
		else if(lower > upper) {
			return -1;
		}
		else if(key > elements[mid]){
			lower = mid+1;
			return binarySearchRecursive(key, lower, upper);
		}
		else if(key < elements[mid]){
			upper = mid-1;
			return binarySearchRecursive(key, lower, upper);
		}else{
			return -1;
		}
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch(5);
		bs.insert(13);
		bs.insert(22);
		bs.insert(47);
		bs.insert(10);
		bs.insert(1);
		for (int i : bs.elements) {
			System.out.println(i);
		}
		bs.search(47);
	}

}
