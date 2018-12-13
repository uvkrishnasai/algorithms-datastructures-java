package datastructures.linkedlist;

/**
 * Cracking the coding interview: 2.2
 * Return Kth to last in Single Linked list.
 */
public class KthToLast {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(2);ll.add(4);ll.add(5);ll.add(2);ll.add(6);ll.add(5);

        LinkedList.Node node = find(ll, 3);

        assert node != null;
        assert node.value == 2;
    }

    /**
     * Effective Solution: Solve using runner technique.
     * Alternate Solution is to use recursion.
     * @param ll single linked list
     * @param k steps
     * @return node
     */
    private static LinkedList.Node find(LinkedList ll, int k) {

        assert ll != null : "Linked list cannot be null";
        assert k >= 0 : "k cannot be negative value";

        LinkedList.Node p1 = ll.head;
        LinkedList.Node p2 = ll.head;

        // go k steps forward with p2 pointer.
        for(int i = 0; i < k; i++) {
            p2 = p2.next;
            assert p2 != null : "k cannot be greater than size of linked list";
        }

        // step one step at a time with p1 until p2 reaches end of linked list.
        // when p2 makes length - k steps, p1 makes length - k steps
        // so the steps remaining for p1 => length - (length - k) => k steps
        while(p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1.next;
    }


}
