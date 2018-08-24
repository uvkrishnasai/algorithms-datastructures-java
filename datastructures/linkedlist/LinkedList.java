package org.practice.programs.intermediate;

public class LinkedList {
	
	Node first;
	public int length;
	
	public LinkedList(){
	}
	
	public void add(int element){
		if (first == null) {
			first = new Node(element);
		}
		else{
			Node ref = first;
			first = new Node(element);
			first.ref = ref;
		}
		length++;
	}
	
	/**
	 * Not supported in Linked list
	 * @param element
	 */
	public Node remove(int element){
		if (first == null) {
			throw new RuntimeException("list is empty");
		}
		Node returnNode = null;
		Node previous = null;
		Node current = first;
		while(current!=null){
			if (current.value == element) {
				if(previous == null){
					returnNode = first;
					first = current.ref;
				}
				else{
					returnNode = current;
					previous.ref = current.ref;
				}
				break;
			}else{
				previous = current;
				current = current.ref;
			}
			
		}
		length--;
		return returnNode;
	}
	
	public Node deleteFirst(){
		if (first == null)
			throw new RuntimeException("list is empty");
		Node returnNode = first;
		first = first.ref;
		length--;
		return returnNode;
	}
	
	public void displayList(){
		Node temp = first;
		while(temp!=null){
			System.out.println(temp.value + " : " + temp.ref);
			temp=temp.ref;
		}
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add(4);
		ll.add(34);
		ll.add(33);
		ll.add(26);
		System.out.println(ll.remove(33));
		ll.add(40);
		ll.add(0);
		ll.displayList();
	}
	
	public class Node{
		public int value;
		public Node ref;
		public Node(int value) {
			this.value = value;
		}
		@Override
		public String toString() {
			return "Node [value=" + value + ", ref=" + ref + "]";
		}
	}

}
