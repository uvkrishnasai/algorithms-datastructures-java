package datastructures.linkedlist;

/**
 * Cracking the coding interview: 2.4
 * Partition:
 * all value < x should be before all nodes > x
 * x need to be between values less than and greater than x
 */
public class Partition {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(10);ll.add(4);ll.add(5);ll.add(2);ll.add(6);ll.add(5);
        
        int x = 5;
        partition(ll, x);
        
        assert ll.head.value == 4 : "Expected: 4 , Actual: " + ll.head.value;
        assert ll.head.next.value == 2 : "Expected: 4 , Actual: " + ll.head.next.value;
        assert ll.head.next.next.value == 10 : "Expected: 4 , Actual: " + ll.head.next.next.value;
        assert ll.head.next.next.next.value == 5 : "Expected: 4 , Actual: " + ll.head.next.next.next.value;
        assert ll.head.next.next.next.next.value == 6 : "Expected: 4 , Actual: " + ll.head.next.next.next.next.value;
        assert ll.tail.value == 5 : "Expected: 4 , Actual: " + ll.tail.value;
    }

    /**
     * Solution using four pointers.
     * @param ll linked list
     * @param x integer
     */
    private static void partition(LinkedList ll, int x) {

        if (ll.size == 0)
            return;

        LinkedList.Node first = null;
        LinkedList.Node mid = null;
        LinkedList.Node midPlusOne = null;
        LinkedList.Node tail = null;

        LinkedList.Node curr = ll.head;
        while (curr != null) {
            if (curr.value < x){
                if (mid == null) {
                    first = curr;
                    mid = curr;
                } else {
                    mid.next = curr;
                    mid = mid.next;
                }
            } else {
                if (tail == null) {
                    midPlusOne = curr;
                    tail = curr;
                } else {
                    tail.next = curr;
                    tail = tail.next;
                }
            }

            LinkedList.Node next = curr.next;
            curr.next = null;
            curr = next;
        }

        mid.next = midPlusOne;
        ll.head = first;
    }
}
