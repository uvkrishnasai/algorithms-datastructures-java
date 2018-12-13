package datastructures.linkedlist;

/**
 * Double Linked List.
 */
public class DoubleLinkedList {

    Node head;
    Node tail;
    public int size = 0;

    static class Node {
        Integer value;
        Node next;
        Node prev;

        Node(Integer value) {
            this.value = value;
        }
    }

    /**
     * Add elem to the linked list.
     *
     * @param value
     */
    public Node add(Integer value) {

        // initialize node
        Node node = new Node(value);
        size++;

        // set head and tail to node when head is null
        if (head == null) {
            head = node;
            tail = node;
            return node;
        }

        // iterate from head till tail
        node.prev = tail;
        tail.next = node;
        tail = node;

        return node;
    }

    /**
     * Remove node from the linked list.
     *
     * @param node
     */
    public void remove(Node node) {

        // if head is null, list is empty
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        size--;

        // if head is node
        if (head == node) {
            // if head has next, point head to next.
            if (head.next != null) {
                head = head.next;
                head.prev = null;
            } else { // else set head and tail to null as there is only one node.
                head = null;
                tail = null;
            }
            return;
        }

        if(tail == node) {
            tail.prev.next = null;
            tail = tail.prev;
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    public static void main(String[] args) {
        DoubleLinkedList ll = new DoubleLinkedList();

        assert ll.head == null : "head should be null after initialization";
        assert ll.tail == null : "tail should be null after initialization";
        assert ll.size == 0 : "size of linked list is: " + ll.size;

        ll.add(2);
        assert ll.head.value == 2;
        assert ll.tail.value == 2;
        assert ll.head.prev == null : "Always head.prev should be null";
        assert ll.head.next == null : "Expecting head.next to be null";
        assert ll.tail.prev == null : "Expecting tail.prev to be null";
        assert ll.tail.next == null : "Always tail.next should be null";
        assert ll.size == 1 : "size of linked list is: " + ll.size;

        Node node4 = ll.add(4);
        assert ll.head.value == 2;
        assert ll.tail.value == 4;
        assert ll.head.next == ll.tail : "Expecting head.next to be tail";
        assert ll.tail.prev == ll.head : "Expecting tail.prev to be head";
        assert ll.size == 2 : "size of linked list is: " + ll.size;

        Node node2 = ll.add(2);
        assert ll.head.value == 2;
        assert ll.tail.value == 2;
        assert ll.head.prev == null : "Always head.prev should be null";
        assert ll.head.next == node4;
        assert ll.tail.prev == node4;
        assert ll.tail.next == null : "Always tail.next should be null";
        assert ll.size == 3 : "size of linked list is: " + ll.size;

        ll.remove(ll.head);
        assert ll.head.value == 4;
        assert ll.tail.value == 2;
        assert ll.head.prev == null : "Always head.prev should be null";
        assert ll.head.next == node2;
        assert ll.tail.prev == node4;
        assert ll.tail.next == null : "Always tail.next should be null";
        assert ll.size == 2 : "size of linked list is: " + ll.size;

        ll.add(5);
        assert ll.head.value == 4;
        assert ll.tail.value == 5;
        assert ll.tail.prev == node2;
        assert ll.tail.next == null;
        assert ll.tail.prev.next == ll.tail;
        assert ll.size == 3 : "size of linked list is: " + ll.size;

        ll.remove(ll.tail);
        assert ll.head.value == 4;
        assert ll.tail.value == 2;
        assert ll.tail.prev == node4;
        assert ll.tail.next == null : "Always tail.next should be null";
        assert ll.tail.prev.next == node2;
        assert ll.size == 2 : "size of linked list is: " + ll.size;

        ll.remove(node2);
        assert ll.head.value == 4;
        assert ll.tail.value == 4;
        assert ll.head.prev == null : "Always head.prev should be null";
        assert ll.head.next == null;
        assert ll.tail.prev == null;
        assert ll.tail.next == null : "Always tail.next should be null";
        assert ll.size == 1 : "size of linked list is: " + ll.size;
    }

}
