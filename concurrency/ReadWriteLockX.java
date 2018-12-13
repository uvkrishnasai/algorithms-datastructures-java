package concurrency;

import java.util.HashMap;
import java.util.Map;

/**
 * A java.util.concurrent.locks.ReadWriteLock interface
 * allows multiple threads to read at a time
 * but only one thread can write at a time.
 *
 * Read Access
 *      -> If no threads are writing, and no threads have requested write access.
 *
 * Write Lock
 *      −> If no thread is reading or writing, then one thread can access the write lock.
 */
public interface ReadWriteLockX {
    public void lockRead() throws InterruptedException;
    public void lockWrite() throws InterruptedException;
    public void unlockRead();
    public void unlockWrite();
}

class ReadWriteLockImpl implements ReadWriteLockX {

    private int readers = 0;
    private int writers = 0;
    private int writeRequests = 0;

    /**
     * No threads are writing and no threads have requested write access.
     * @throws InterruptedException
     */
    @Override
    public synchronized void lockRead() throws InterruptedException {
        while (writers > 0 || writeRequests > 0) {
            wait();
        }
        readers++;
    }

    @Override
    public synchronized void unlockRead() {
        readers--;
        notifyAll();
    }

    /**
     * If no thread is reading or writing, then one thread can access the write lock.
     * @throws InterruptedException
     */
    @Override
    public synchronized void lockWrite() throws InterruptedException {
        writeRequests++;

        while (readers > 0 || writers > 0) {
            wait();
        }

        writeRequests--;
        writers++;
    }

    @Override
    public synchronized void unlockWrite() {
        writers--;
        notifyAll();
    }
}

class ReentrantReadWriteLock implements ReadWriteLockX {

    private Map<Thread, Integer> readingThreads = new HashMap<>();

    private int writeAccesses = 0;
    private int writeRequests = 0;
    private Thread writingThread = null;

    /**
     * Acquire lock if
     * calling thread is writer or
     * has no other writer and is a reader or
     * has no writeRequests
     *
     * Once lock acquired, add the calling thread to readingThreads with access count.
     *
     * @throws InterruptedException
     */
    @Override
    public void lockRead() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (!canGrantReadAccess(callingThread)) {
            wait();
        }

        readingThreads.put(callingThread, getReadAccessCount(callingThread)+1);
    }

    /**
     * notify all once removing or decrementing the access count in readingThreads.
     */
    @Override
    public void unlockRead() {
        Thread callingThread = Thread.currentThread();

        if (!isReader(callingThread)) {
            throw new IllegalMonitorStateException("Calling thread does not hold a read lock");
        }

        int accessCount = getReadAccessCount(callingThread);
        if (accessCount == 1)
            readingThreads.remove(callingThread);
        else
            readingThreads.put(callingThread, accessCount-1);

        notifyAll();
    }

    /**
     * Acquire lock if
     * is only reading thread or
     * has no reader and no writing thread or
     * is writer
     *
     * once lock acquired increment write access and set writing thread to current thread.
     *
     * @throws InterruptedException
     */
    @Override
    public void lockWrite() throws InterruptedException {
        writeRequests++;

        Thread callingThread = Thread.currentThread();
        while (!canGrantWriteAccess(callingThread)) {
            wait();
        }

        writeRequests--;
        writeAccesses++;
        writingThread = callingThread;
    }

    @Override
    public void unlockWrite() {
        Thread callingThread = Thread.currentThread();
        if (!isWriter(callingThread))
            throw new IllegalMonitorStateException("Calling thread does not hold the write lock");

        writeAccesses--;
        if (writeAccesses == 0) {
            writingThread = null;
        }
        notifyAll();
    }

    private boolean canGrantReadAccess(Thread callingThread) {
        if (isWriter(callingThread))
            return true;

        if (hasWriter())
            return false;

        if (isReader(callingThread))
            return true;

        if (hasWriteRequests())
            return false;

        return true;
    }

    private boolean canGrantWriteAccess(Thread callingThread) {
        if (isOnlyReader(callingThread))
            return true;

        if (hasReaders())
            return false;

        if (writingThread == null)
            return true;

        if (!isWriter(callingThread))
            return false;

        return true;
    }

    private boolean isReader(Thread callingThread) {
        return readingThreads.get(callingThread) != null;
    }

    private boolean isOnlyReader(Thread callingThread) {
        return readingThreads.size() == 1 && isReader(callingThread);
    }

    private boolean hasReaders() {
        return readingThreads.size() > 0;
    }

    private int getReadAccessCount(Thread callingThread) {
        Integer accessCount = readingThreads.get(callingThread);
        if (accessCount == null)
            return 0;
        return accessCount;
    }

    private boolean isWriter(Thread callingThread) {
        return this.writingThread == callingThread;
    }

    private boolean hasWriter() {
        return writingThread != null;
    }

    private boolean hasWriteRequests() {
        return this.writeRequests > 0;
    }
}
