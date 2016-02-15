package analyticbastard.concurrency.factories;

import analyticbastard.concurrency.core.Tray;
import analyticbastard.concurrency.masterchef.TrayImpl;

/**
 * Created by Javier on 2/15/2016.
 */
public class TrayAccessor {
    private static Tray tray = new TrayImpl();

    public static Tray getTray() {
        return tray;
    }
}
