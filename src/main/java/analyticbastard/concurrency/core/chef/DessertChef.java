package analyticbastard.concurrency.core.chef;

import analyticbastard.concurrency.core.Tray;

/**
 * Created by Javier on 2/14/2016.
 */
public class DessertChef extends Chef {
    public DessertChef(MasterChef chef, Tray tray) {
        super(chef, tray);
    }

    @Override
    public void cook() {
        chef.cook(tray);
    }

    @Override
    public boolean doneCooking() {
        return chef.doneCooking();
    }
}
