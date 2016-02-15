package analyticbastard.concurrency.masterchef;

import analyticbastard.concurrency.core.Food;
import analyticbastard.concurrency.core.Tray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javier on 2/15/2016.
 */
public class TrayImpl implements Tray {
    private List<Food> items = new ArrayList<Food>();
    private Object inputLock = new Object();
    private Object outputLock = new Object();


    public boolean serve(Food food) {
        synchronized (inputLock) {
            return items.add(food);
        }
    }

    public Food consume() {
        synchronized (outputLock) {
            return items.isEmpty() ? null : items.remove(0);
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
