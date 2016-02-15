package analyticbastard.concurrency.core.chef;

import analyticbastard.concurrency.core.Tray;

/**
 * Created by Javier on 2/14/2016.
 */
public abstract class Chef {
    final protected MasterChef chef;

    final protected Tray tray;

    protected Chef(MasterChef chef, Tray tray) {
        this.chef = chef;
        this.tray = tray;
    }

    public abstract void cook();

    public abstract boolean doneCooking();
}
