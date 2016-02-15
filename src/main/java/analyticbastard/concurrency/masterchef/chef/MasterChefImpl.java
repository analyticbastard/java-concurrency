package analyticbastard.concurrency.masterchef.chef;

import analyticbastard.concurrency.core.AFoodTypes;
import analyticbastard.concurrency.core.Food;
import analyticbastard.concurrency.core.Tray;
import analyticbastard.concurrency.core.chef.MasterChef;
import analyticbastard.concurrency.factories.FoodFactory;
import analyticbastard.concurrency.masterchef.MasterSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by Javier on 2/14/2016.
 */
public class MasterChefImpl extends MasterChef {
    private final int maxFoods;
    private final long time;

    private final List<Future> tasks = new ArrayList<>();

    public MasterChefImpl(String name, int maxFoods, long time) {
        super(name);
        this.maxFoods = maxFoods;
        this.time = time;
    }

    @Override
    public Food prepareFood() {
        AFoodTypes.IFoodType foodType = Math.random() < .33 ? AFoodTypes.IFoodType.APPLE
                : Math.random() < .5 ? AFoodTypes.IFoodType.PIE : AFoodTypes.IFoodType.CARROT;

        return FoodFactory.createFood(foodType, name);
    }

    @Override
    public void cook(final Tray tray) {
        ExecutorService executorService = MasterSystem.getExecutorService();
        for (int i = 0; i<maxFoods; i++){
            final Food food = prepareFood();
            MasterSystem.pause(time);

            Future<?> future = executorService.submit(new Runnable() {
                public void run() {
                    tray.serve(food);
                }
            });

            synchronized (tasks) {
                tasks.add(future);
            }
        }
    }

    @Override
    public boolean doneCooking() {
        synchronized (tasks) {
            for (Future task : tasks) {
                if (!task.isDone()) {
                    return false;
                }
            }
        }

        return true;
    }
}
