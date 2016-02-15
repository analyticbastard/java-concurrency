package analyticbastard.concurrency.factories;

import analyticbastard.concurrency.core.Tray;
import analyticbastard.concurrency.core.chef.Chef;
import analyticbastard.concurrency.core.chef.DessertChef;
import analyticbastard.concurrency.core.chef.MasterChef;
import analyticbastard.concurrency.masterchef.chef.MasterChefImpl;

/**
 * Created by Javier on 2/15/2016.
 */
public class ChefFactory {
    private static ChefFactory chefFactory;

    private final Tray tray;

    public ChefFactory(Tray tray) {
        this.tray = tray;
    }

    public Chef getChef(String name, int maxFoods, long time) {
        MasterChef masterChef = new MasterChefImpl(name, maxFoods, time);
        return new DessertChef(masterChef, tray);
    }

    public static ChefFactory getInstance() {
        if (chefFactory == null) {
            chefFactory = new ChefFactory(TrayAccessor.getTray());
        }

        return chefFactory;
    }
}
