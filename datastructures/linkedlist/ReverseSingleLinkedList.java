package datastructures.linkedlist;

public class ReverseSingleLinkedList {
	
	Node first;
	
	public ReverseSingleLinkedList(){
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
	}
	
	public void reverse(){
		if (first == null) {
			throw new RuntimeException("list is empty");
		}
		
		Node previousNode = null;
		Node currentNode = first;
		Node nextNode = first;
		
		while(nextNode != null){
			nextNode=nextNode.ref;
            currentNode.ref=previousNode;
            previousNode=currentNode; 
            currentNode=nextNode; 
		}
		
		first = previousNode;
		
	}
	
	//mine
	public void reverse1(){
		if (first == null) {
			throw new RuntimeException("list is empty");
		}
		Node prev = null;
		Node curr = first;
		Node next = first;
		while(next != null) {
			next = curr.ref;
			curr.ref = prev;
			prev = curr;
			curr = next;
		}
		first = prev;
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
		ReverseSingleLinkedList ll = new ReverseSingleLinkedList();
		ll.add(4);
		ll.add(34);
		ll.add(33);
		ll.add(26);
		System.out.println(ll.remove(33));
		System.out.println("--------");
		ll.add(40);
		ll.add(0);
		ll.displayList();
		System.out.println("--------");
		ll.reverse1();
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
