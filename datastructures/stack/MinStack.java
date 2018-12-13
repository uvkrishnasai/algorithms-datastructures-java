package datastructures.stack;

/**
 * Cracking the coding interview: 3.2
 * Stack Min: Push, Pop, Min should all operate in O(1) time.
 */
public class MinStack extends Stack {

    private Stack stack;

    public MinStack() {
        this.stack = new Stack();
    }

    public void push(int elem) {
        // if element < prev element, push the element into new stack
        if (this.node == null || elem <= this.node.value) {
            stack.push(elem);
        }

        super.push(elem);
    }

    @Override
    public int pop() {
        assert size > 0 : "Stack is empty";

        if(this.node.value == this.stack.peek()) {
            this.stack.pop();
        }

        return super.pop();
    }

    public int min() {
        return this.stack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        assert stack.size == 0;

        stack.push(11);
        assert stack.size == 1;
        assert stack.peek() == 11;
        assert stack.min() == 11;

        stack.push(4);
        assert stack.size == 2;
        assert stack.peek() == 4;
        assert stack.min() == 4;

        stack.push(6);
        assert stack.size == 3;
        assert stack.peek() == 6;
        assert stack.min() == 4;

        assert stack.pop() == 6;
        assert stack.size == 2;
        assert stack.peek() == 4;
        assert stack.min() == 4;

        stack.push(7);
        assert stack.size == 3;
        assert stack.peek() == 7;
        assert stack.min() == 4;

        stack.push(12);
        assert stack.size == 4;
        assert stack.peek() == 12;
        assert stack.min() == 4;

        assert stack.pop() == 12;
        assert stack.pop() == 7;
        assert stack.pop() == 4;
        assert stack.size == 1;
        assert stack.min() == 11;

        assert stack.pop() == 11;
        assert stack.isEmpty();
    }
}
