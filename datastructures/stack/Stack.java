package datastructures.stack;

/**
 * Created by Krishna on 6/12/16.
 */
public class Stack<T> {

    public T[] stack;
    private int currentIndex = -1;

    public Stack(int length)
    {
        this.stack = (T[])new Object[length];
    }

    public void push(T element) {
        stack[++currentIndex] = element;
    }

    public T pop(){
        if (currentIndex == -1)
            throw new RuntimeException("Stack is Empty");
        return stack[currentIndex--];
    }

    public boolean isStackEmpty(){
        return currentIndex==-1;
    }

    public boolean isStackFull() {
        return (currentIndex == stack.length-1);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(5); // Creation of Stack

        System.out.println(stack.isStackEmpty());
        System.out.println(stack.isStackFull());

        stack.push(11);
        stack.push(21);
        stack.push(31);
        stack.push(41);
        stack.push(51);

        System.out.println(stack.isStackEmpty());
        System.out.println(stack.isStackFull());

        System.out.print("Popped items: ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");

        System.out.print(stack.pop()+" ");
    }

}
