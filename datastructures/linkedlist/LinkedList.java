package datastructures.linkedlist;

/**
 * Used to solve linked list problems.
 */
public class LinkedList {

    Node head;
    Node tail;
    public int size = 0;

    static class Node{
        Integer value;
        Node next;

        Node(Integer value) {
            this.value = value;
        }
    }

    /**
     * Add elem to the linked list.
     * @param value
     */
    public Node add(Integer value) {

        // initialize node
        Node node = new Node(value);
        return add(node);
    }

    /**
     * Add elem to the linked list.
     * @param node
     */
    public Node add(Node node) {

        // initialize node
        size++;

        // set head and tail to node when head is null
        if(head == null) {
            head = node;
            tail = node;
            return node;
        }

        // iterate from head till tail
        tail.next = node;
        tail = node;

        return node;
    }

    /**
     * Remove node from the linked list.
     * @param node
     */
    public void remove(Node node) {

        // if head is null, list is empty
        if(head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        size--;

        // if head is node
        if(head == node) {
            // if head has next, point head to next.
            if(head.next != null) {
                head = head.next;
            } else { // else set head and tail to null as there is only one node.
                head = null;
                tail = null;
            }
            return;
        }

        // remove the node if it is not head
        Node curr = head.next;
        Node prev = head;
        while(true) {

            if(curr == node) {
                prev.next = curr.next;

                // if node is tail, remove and point tail to prev node.
                if(curr == tail) {
                    tail = prev;
                }

                break;
            }

            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        assert ll.head == null;
        assert ll.tail == null;
        assert ll.size == 0 : "size of linked list is: " + ll.size;

        ll.add(2);
        assert ll.head.value == 2;
        assert ll.tail.value == 2;
        assert ll.size == 1 : "size of linked list is: " + ll.size;

        ll.add(4);
        assert ll.head.value == 2;
        assert ll.tail.value == 4;
        assert ll.size == 2 : "size of linked list is: " + ll.size;

        Node node = ll.add(2);
        assert ll.head.value == 2;
        assert ll.tail.value == 2;
        assert ll.size == 3 : "size of linked list is: " + ll.size;

        ll.remove(ll.head);
        assert ll.head.value == 4;
        assert ll.tail.value == 2;
        assert ll.size == 2 : "size of linked list is: " + ll.size;

        ll.add(5);
        assert ll.head.value == 4;
        assert ll.tail.value == 5;
        assert ll.size == 3 : "size of linked list is: " + ll.size;

        ll.remove(ll.tail);
        assert ll.head.value == 4;
        assert ll.tail.value == 2;
        assert ll.size == 2 : "size of linked list is: " + ll.size;

        ll.remove(node);
        assert ll.head.value == 4;
        assert ll.tail.value == 4;
        assert ll.size == 1 : "size of linked list is: " + ll.size;

    }

}
