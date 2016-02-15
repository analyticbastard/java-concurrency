package analyticbastard.concurrency.core.chef;

import analyticbastard.concurrency.core.Food;
import analyticbastard.concurrency.core.Tray;

/**
 * Created by Javier on 2/14/2016.
 */
public abstract class MasterChef {
    protected final String name;

    protected MasterChef(String name) {
        this.name = name;
    }

    public abstract Food prepareFood();

    public abstract void cook(Tray tray);

    public abstract boolean doneCooking();
}
