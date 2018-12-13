package concurrency;

/**
 * Thread Safety with shared resources:
 *
 *      -> Use Local Variables:
 *          Local variables are stored in each methods own stack.
 *
 *      -> Local Object reference:
 *          All objects are stored in shared heap.
 *          Object created locally never escapes the method it was created in.
 *
 *      -> Object member variable is not thread safe.
 *
 *      -> If a resource is create and disposed within the control of same thread.
 *
 *      -> Making sure that objects shared between the threads are never updated by any of the thread
 *         by making shared objects immutable.
 *
 */
public class ThreadSafety {

    // Using object member variables to increment is not thread safe.
    public Integer count = 0;

    // Using local variable in a method is thread safe.
    public void threadSafeUsingLocalVariable() {
        Integer threadSafeCount = 0;
        threadSafeCount++;
    }

    // Using local object reference in a method is thread safe.
    public void threadSafeUsingObjectReference() {
        ThreadSafety threadSafety = new ThreadSafety();
        threadSafety.increment();
    }

    // Using member variable
    public void increment() {
        count++;
    }

}
