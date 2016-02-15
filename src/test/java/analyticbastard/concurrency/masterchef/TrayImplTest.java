package analyticbastard.concurrency.masterchef;

import analyticbastard.concurrency.core.Tray;
import analyticbastard.concurrency.core.chef.Chef;
import analyticbastard.concurrency.core.eater.Eater;
import analyticbastard.concurrency.factories.ChefFactory;
import analyticbastard.concurrency.factories.EaterFactory;
import analyticbastard.concurrency.factories.TrayAccessor;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertTrue;

/**
 * Created by Javier on 2/15/2016.
 */
public class TrayImplTest {
    @Test
    public void run() {
        final Chef chef1 = ChefFactory.getInstance().getChef("Boris", 50, 2);
        final Chef chef2 = ChefFactory.getInstance().getChef("Yannis", 40, 2);
        final Chef chef3 = ChefFactory.getInstance().getChef("Ivan", 30, 2);

        final Eater eater1 = EaterFactory.getInstance().getEater("Lothar", 1);
        final Eater eater2 = EaterFactory.getInstance().getEater("Otto", 1);

        ExecutorService chefsExecutorService = Executors.newFixedThreadPool(3);
        chefsExecutorService.execute(new Runnable() {
            public void run() {
                chef1.cook();
            }
        });
        chefsExecutorService.execute(new Runnable() {
            public void run() {
                chef2.cook();
            }
        });
        chefsExecutorService.execute(new Runnable() {
            public void run() {
                chef3.cook();
            }
        });

        ExecutorService eatersExecutorService = Executors.newFixedThreadPool(2);
        eatersExecutorService.execute(new Runnable() {
            public void run() {
                eater1.consume();
            }
        });
        eatersExecutorService.execute(new Runnable() {
            public void run() {
                eater2.consume();
            }
        });

        MasterSystem.pause(500);

        Tray tray = TrayAccessor.getTray();

        while (!chef1.doneCooking() || !chef2.doneCooking() || !chef3.doneCooking() || !tray.isEmpty()) {
            MasterSystem.pause(200);
        }

        assertTrue(tray.isEmpty());

        MasterSystem.getExecutorService().shutdown();
    }
}