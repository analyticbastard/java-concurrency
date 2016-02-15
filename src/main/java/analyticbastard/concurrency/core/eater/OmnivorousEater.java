package analyticbastard.concurrency.core.eater;

import analyticbastard.concurrency.core.Tray;

/**
 * Created by Javier on 2/14/2016.
 */
public class OmnivorousEater extends Eater {

    public OmnivorousEater(MasterEater eater, Tray tray) {
        super(eater, tray);
    }

    @Override
    public void consume() {
        eater.consume(tray);
    }
}
