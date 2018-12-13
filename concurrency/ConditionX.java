package concurrency;

/**
 * A java.util.concurrent.locks.Condition interface provides a thread ability to suspend its execution,
 * until the given condition is true.
 *
 * A Condition object is necessarily bound to a Lock and to be obtained using the newCondition() method.
 *
 * Important methods:
 * -> await : Causes the current thread to wait until it is signalled or interrupted.
 * -> signal : Wakes up one waiting thread.
 * -> signalAll : Wakes up all waiting threads.
 *
 * create condition: lock.newCondition()
 */
public class ConditionX {

}
