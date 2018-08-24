package org.practice.programs.intermediate;

public class SortedLinkedList {
	
	Node first;
	
	public SortedLinkedList(){
	}
	
	public void add(int element){
		if (first == null) {
			first = new Node(element);
		}
		else{
			Node previous = null;
			Node current = first;
			while(current != null){
				if (element > current.value) {
					previous = current;
					current = current.ref;
					continue;
				}
				break;
			}
			Node newNode = new Node(element);
			if(previous != null)
				previous.ref = newNode;
			newNode.ref = current;
		}
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
		return returnNode;
	}
	
	public Node deleteFirst(){
		if (first == null)
			throw new RuntimeException("list is empty");
		Node returnNode = first;
		first = first.ref;
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
		SortedLinkedList ll = new SortedLinkedList();
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
