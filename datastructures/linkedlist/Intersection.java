package datastructures.linkedlist;

/**
 * Cracking the coding interview: 2.7
 * Determine if 2 linked lists intersect based on reference, not value.
 */
public class Intersection {

    public static void main(String[] args) {

        // prepare data
        LinkedList.Node node = new LinkedList.Node(7);
        node.next = new LinkedList.Node(5);
        node.next.next = new LinkedList.Node(6);

        LinkedList ll = new LinkedList();
        ll.add(2);ll.add(node);

        LinkedList ll2 = new LinkedList();
        ll2.add(8);ll2.add(1);ll2.add(7);ll2.add(3);ll2.add(node);

        // solution
        LinkedList.Node result = findIntersection(ll, ll2);

        assert result != null : "Intersection not found";
        assert result.value == 7 : "expected 7, actual: " + result.value;
        assert result.equals(node) : "result and node are not equal";
    }

    /**
     * Find min length of 2 linkedlists
     * iterate max length linked list until max-min
     * iterate both the linked lists simultaneously and compare the nodes.
     * @param ll
     * @param ll2
     * @return intersection node.
     */
    private static LinkedList.Node findIntersection(LinkedList ll, LinkedList ll2) {

        int len1 = ll.size; // find length if unknown
        int len2 = ll2.size; // find length if unknown

        LinkedList.Node node1 = ll.head;
        LinkedList.Node node2 = ll2.head;

        int minLen = Math.min(len1, len2);

        for(int i = 0; i < len1-minLen; i++)
            node1 = node1.next;

        for(int i = 0; i < len2-minLen; i++)
            node2 = node2.next;

        for(int i = 0; i < minLen; i++) {
            if(node1.equals(node2))
                return node1;
            node1 = node1.next;
            node2 = node2.next;
        }

        return null;
    }
}
