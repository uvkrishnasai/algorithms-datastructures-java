package concurrency;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Critical Section:
 *      Running more than one thread inside the same application accessing same resource.
 *
 * Race condition:
 *      Inconsistent result when Multiple threads execute this critical section.
 */
public class CriticalSection {

    private Integer count = 0;

    private void increment() {
        this.count += 1;
    }

    /**
     * The output will not always be n.
     * @param args
     */
    public static void main(String[] args) {
        CriticalSection cs = new CriticalSection();

        List<Thread> threadList = IntStream.range(0, 10000)
                .mapToObj(i -> new Thread(cs::increment))
                .collect(Collectors.toList());

        threadList.forEach(Thread::start);

        threadList.forEach(th -> {
            try {
                th.join();
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        System.out.println(cs.count);
    }

}
