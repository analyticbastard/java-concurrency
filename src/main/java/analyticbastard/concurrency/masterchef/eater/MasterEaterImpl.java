package analyticbastard.concurrency.masterchef.eater;

import analyticbastard.concurrency.core.Food;
import analyticbastard.concurrency.core.Tray;
import analyticbastard.concurrency.core.eater.MasterEater;
import analyticbastard.concurrency.masterchef.MasterSystem;

import java.util.concurrent.ExecutorService;

/**
 * Created by Javier on 2/14/2016.
 */
public class MasterEaterImpl extends MasterEater {
    private final long time;

    public MasterEaterImpl(String name, long time) {
        super(name);
        this.time = time;
    }

    private void consumeFood(Food food) {
        synchronized (eatenFoods) {
            assert eatenFoods.add(food);
        }
        System.out.println(name + " ate " + food.getType() + " by " + food.getChefName() + ": " + food.sayHowItTasted());
    }

    @Override
    public void consume(final Tray tray) {
        ExecutorService executorService = MasterSystem.getExecutorService();
        while (true) {
            final Food food = tray.consume();
            if (food == null) {
                MasterSystem.pause(time);
                continue;
            } else {
                MasterSystem.pause(time);
            }

            executorService.execute(new Runnable() {
                public void run() {
                    consumeFood(food);
                }
            });
        }
    }
}
