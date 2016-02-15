package analyticbastard.concurrency.core.eater;

import analyticbastard.concurrency.core.Food;
import analyticbastard.concurrency.core.Tray;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Javier on 2/14/2016.
 */
public abstract class MasterEater {
    protected final String name;

    protected final Set<Food> eatenFoods = new HashSet<Food>();

    protected MasterEater(String name) {
        this.name = name;
    }

    public abstract void consume(Tray tray);
}
