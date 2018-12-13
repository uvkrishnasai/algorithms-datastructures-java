package concurrency;

/**
 * A java.util.concurrent.locks.Lock interface is used
 * as a thread synchronization mechanism similar to synchronized blocks.
 *
 * Guarantee of sequence/ waiting queue
 *      −>  Synchronized block does not provide any guarantee of sequence in which waiting thread will be given access.
 *          Lock interface handles it.
 *
 * Timeout
 *      −>  Synchronized block has no option of timeout if lock is not granted. Lock interface provides such option.
 *
 * Multi method
 *      −>  Synchronized block must be fully contained within a single method
 *          whereas a lock interface's methods lock() and unlock() can be called in different methods.
 *
 * Reentrant lock
 *      ->  ReentrantLock allow threads to enter into lock on a resource more than once.
 *          When the thread first enters into lock, a hold count is set to one.
 *          Before unlocking the thread can re-enter into lock again and every time hold count is incremented by one.
 *          For every unlock request, hold count is decremented by one and when hold count is 0,
 *          the resource is unlocked.
 *
 *          Reentrant Locks also offer a fairness parameter,
 *          by which the lock would abide by the order of the lock request
 *
 *          i.e. after a thread unlocks the resource,
 *          the lock would go to the thread which has been waiting for the longest time.
 *
 *          This fairness mode is set up by passing true to the constructor of the lock.
 */
interface LockX {
    public void lock();
    public boolean tryLock();
    public void unlock();
}

class RenetrantLockX implements LockX {

    int holdCount;
    long threadId;

    public RenetrantLockX() {
        this.holdCount = 0;
    }

    @Override
    public synchronized void lock() {
        if (holdCount == 0) {
            holdCount++;
            threadId = Thread.currentThread().getId();
        } else if (holdCount > 0 && Thread.currentThread().getId() == threadId) {
            holdCount++;
        } else {
            try {
                wait();
                holdCount++;
                threadId = Thread.currentThread().getId();
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }

    }

    @Override
    public synchronized boolean tryLock() {
        if (holdCount == 0) {
            lock();
            return true;
        }
        return false;
    }

    @Override
    public synchronized void unlock() {
        if (holdCount == 0) {
            throw new IllegalMonitorStateException();
        }

        holdCount--;

        if (holdCount == 0) {
            notify();
        }
    }
}
