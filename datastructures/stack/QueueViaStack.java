package datastructures.stack;

/**
 * Cracking the coding interview: 3.4
 * Implement a queue using 2 stacks
 */
public class QueueViaStack {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        assert q.isEmpty() : "Queue is not empty when initialized";
        
        q.add(5); q.add(2); q.add(8); q.add(3);
        assert q.size == 4 : "Expected size: 4, Actual: " + q.size;

        assert q.remove() == 5;
        assert q.size == 3;
        assert q.peek() == 2;
        assert q.remove() == 2;
        assert q.remove() == 8;
        assert q.remove() == 3;
        assert q.isEmpty();
    }

    /**
     * Queue using 2 stacks
     */
    static class MyQueue {

        public int size = 0;

        private Stack stack1;
        private Stack stack2;

        MyQueue() {
            stack1 = new Stack();
            stack2 = new Stack();
        }

        void add(int i) {
            stack1.push(i);
            size++;
        }

        boolean isEmpty() {
            return size == 0;
        }

        int remove() {

            assert !isEmpty();

            size--;

            if (stack2.isEmpty())
                if (stack1.size == 1)
                    return stack1.pop();
                else
                    copyOver();

            return stack2.pop();
        }

        int peek() {
            assert !isEmpty();

            if (stack2.isEmpty())
                if (stack1.size == 1)
                    return stack1.peek(); // return the element if the size of q is 1
                else
                    copyOver(); // copy all the elements from stack 1 to stack 2 is stack 2 is empty.

            return stack2.peek(); // always return the elem from stack2 if exists
        }

        void copyOver() {
            Stack.Node node = stack1.node;
            while(node != null) {
                stack2.push(stack1.pop());
                node = stack1.node;
            }

        }
    }
}
