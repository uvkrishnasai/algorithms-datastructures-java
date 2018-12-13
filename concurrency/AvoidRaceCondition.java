package concurrency;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Race condition can be avoided by proper thread synchronization in critical sections.
 */
public class AvoidRaceCondition {

    private Integer count = 0;

    private void increment() {
        synchronized (this.count) {
            this.count += 1;
        }
    }

    /**
     * The output will always be n.
     * @param args
     */
    public static void main(String[] args) {
        AvoidRaceCondition cs = new AvoidRaceCondition();

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
