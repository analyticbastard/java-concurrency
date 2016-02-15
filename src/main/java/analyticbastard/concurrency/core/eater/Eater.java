package analyticbastard.concurrency.core.eater;

import analyticbastard.concurrency.core.Tray;

/**
 * Created by Javier on 2/14/2016.
 */
public abstract class Eater {
    final MasterEater eater;

    final Tray tray;

    protected Eater(MasterEater eater, Tray tray) {
        this.eater = eater;
        this.tray = tray;
    }

    public abstract void consume();
}
