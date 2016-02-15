package analyticbastard.concurrency.masterchef;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Javier on 2/14/2016.
 */
public class MasterSystem {
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static ExecutorService getExecutorService() {
        return executorService;
    }

    public static void pause(long time) {
        try {
            Thread.sleep(time + (int) (Math.random() * 100));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}
