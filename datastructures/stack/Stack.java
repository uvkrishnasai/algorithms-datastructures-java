package datastructures.stack;

/**
 * Created by Krishna on 6/12/16.
 */
public class Stack {

    protected int size = 0;
    protected Node node;

    static class Node {
        int value;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * Push element into stack
     * @param element
     */
    public void push(int element) {
        Node node = new Node(element);

        if (this.node != null) {
            node.prev = this.node;
        }

        this.node = node;
        this.size++;
    }

    public int pop(){
        assert size > 0 : "Stack is empty";

        Node node = this.node;
        this.node = node.prev;

        this.size--;

        return node.value;
    }

    public int peek() {
        assert size > 0 : "Stack is empty";

        return this.node.value;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        assert stack.size == 0;

        stack.push(11);
        assert stack.size == 1;
        assert stack.peek() == 11;

        stack.push(4);
        assert stack.size == 2;
        assert stack.peek() == 4;

        stack.push(6);
        assert stack.size == 3;
        assert stack.peek() == 6;

        assert stack.pop() == 6;
        assert stack.size == 2;
        assert stack.peek() == 4;

        stack.push(7);
        assert stack.size == 3;
        assert stack.peek() == 7;

        stack.push(12);
        assert stack.size == 4;
        assert stack.peek() == 12;

        assert stack.pop() == 12;
        assert stack.pop() == 7;
        assert stack.pop() == 4;
        assert stack.size == 1;

        assert stack.pop() == 11;
        assert stack.isEmpty();
    }

}
