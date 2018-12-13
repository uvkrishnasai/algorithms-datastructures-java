package concurrency;

/**
 * Concurrency Models:
 *
 * 1. Parallel Workers
 *      -> Delegating distributes the incoming jobs to different workers.
 *
 * 2. Assembly Line / Reactive / Event driven
 *      -> Each worker only performs a part of the full job.
 *      -> When that part is finished the worker forwards the job to the next worker.
 *      -> Each worker is running in its own thread, and shares no state with other workers.
 *      -> This is also sometime referred to as a shared nothing concurrency model.
 *
 * 3. Functional programming
 *      -> All parameters passed to this function are copied,
 *         so no entity outside the receiving function can manipulate the data.
 *      -> This copying is essential to avoid race conditions on the shared data.
 *      -> This makes the functional execution similar to an atomic operation.
 *      -> Each function call can be executed independently of any other function call.
 *
 *
 * Same Threading:
 *      Same threaded system do not share state.
 *      There is no shared memory which the threads access memory concurrently.
 *
 * Multi-threading can be implemented the following ways:
 *      -> Extend Thread class
 *      -> Implement Runnable interface
 *
 */
public class ThreadX {

    public class Thread1 extends Thread {

        @Override
        public void run() {
            System.out.println("Thread One invoked");
        }
    }

    public class Thread2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread Two invoked");
        }
    }

    public static void main(String[] args) {

        ThreadX thisObj = new ThreadX();

        Thread1 threadOne = thisObj.new Thread1();
        threadOne.start();

        Thread threadTwo = new Thread(thisObj.new Thread2());
        threadTwo.start();

        Thread threadThree = new Thread(() -> System.out.println("Thread Three invoked"));
        threadThree.start();

    }
}
