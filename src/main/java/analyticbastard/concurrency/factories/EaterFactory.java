package analyticbastard.concurrency.factories;

import analyticbastard.concurrency.core.Tray;
import analyticbastard.concurrency.core.eater.Eater;
import analyticbastard.concurrency.core.eater.MasterEater;
import analyticbastard.concurrency.core.eater.OmnivorousEater;
import analyticbastard.concurrency.masterchef.eater.MasterEaterImpl;

/**
 * Created by Javier on 2/15/2016.
 */
public class EaterFactory {
    private static EaterFactory eaterFactory;

    private final Tray tray;

    public EaterFactory(Tray tray) {
        this.tray = tray;
    }

    public Eater getEater(String name, long time) {
        MasterEater masterEater = new MasterEaterImpl(name, time);
        return new OmnivorousEater(masterEater, tray);
    }

    public static EaterFactory getInstance() {
        if (eaterFactory == null) {
            eaterFactory = new EaterFactory(TrayAccessor.getTray());
        }

        return eaterFactory;
    }
}
