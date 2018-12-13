package datastructures.linkedlist;

/**
 * Cracking the coding interview: 2.1
 * Remove Duplicates from unsorted linked list.
 *
 */
public class RemoveDups {

    public static void main(String[] args) {
        
        DoubleLinkedList ll = new DoubleLinkedList();
        ll.add(2);ll.add(4);ll.add(5);ll.add(2);ll.add(6);ll.add(5);
        
        removeDuplicates(ll);

        assert ll.size == 4 : "Expected size 4 but found " + ll.size;
        assert ll.head.value == 2;
        assert ll.head.next.value == 4;
        assert ll.head.next.next.value == 5;
        assert ll.head.next.next.next.value == 6;
        assert ll.tail.value == 6;
    }

    /**
     * Removes duplicates in a linked list inplace.
     * Time Complexity - O(n^2)
     * Space Complexity - O(n)
     *
     * To achieve O(n) time complexity, use Hashset. Trade off is space complexity which is O(n).
     * @param ll double linked list
     */
    private static void removeDuplicates(DoubleLinkedList ll) {
        if(ll.size == 0)
            return;

        DoubleLinkedList.Node curr = ll.head;
        do {

            DoubleLinkedList.Node next = curr.next;
            while(next != null) {
                if(curr.value.equals(next.value)) {
                    ll.remove(next);
                }
                next = next.next;
            }

            curr = curr.next;

        } while(curr != null);
    }

}
