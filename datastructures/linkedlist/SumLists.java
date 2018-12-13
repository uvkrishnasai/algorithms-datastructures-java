package datastructures.linkedlist;

/**
 * Cracking the coding interview: 2.5
 * SumLists:
 * 2 numbers represented by linked list, where each node is a single digit.
 * digits are stored in reverse order.
 * Add the 2 numbers.
 */
public class SumLists {

    public static void main(String[] args) {

        LinkedList ll1 = new LinkedList();
        ll1.add(7);ll1.add(1);ll1.add(6);

        LinkedList ll2 = new LinkedList();
        ll2.add(5);ll2.add(9);ll2.add(2);

        LinkedList result = sum(ll1, ll2);

        assert result != null : "result cannot be null";
        assert result.head.value == 2 : "Expected: 2, Actual: " + result.head.value;
        assert result.head.next.value == 1 : "Expected: 1, Actual: " + result.head.next.value;
        assert result.tail.value == 9 : "Expected: 2, Actual: " + result.tail.value;
    }

    private static LinkedList sum(LinkedList ll1, LinkedList ll2) {
        LinkedList sum = new LinkedList();

        Integer carry = 0;
        LinkedList.Node node1 = ll1.head;
        LinkedList.Node node2 = ll2.head;

        int len = Math.max(ll1.size, ll2.size);

        while (len > 0) {

            int res = carry;

            if(node1 != null) {
                res += node1.value;
                node1 = node1.next;
            }

            if(node2 != null) {
                res += node2.value;
                node2 = node2.next;
            }

            carry = res/10;
            res = res%10;

            sum.add(res);

            len--;
        }

        if (carry > 0)
            sum.add(carry);

        return sum;
    }
}
