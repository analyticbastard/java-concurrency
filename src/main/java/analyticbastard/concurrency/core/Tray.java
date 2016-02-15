package analyticbastard.concurrency.core;

/**
 * Created by Javier on 2/14/2016.
 */
public interface Tray {
    boolean serve(Food food);

    Food consume();

    boolean isEmpty();
}
