package analyticbastard.concurrency.core.foods;

import analyticbastard.concurrency.core.Food;

/**
 * Created by Javier on 2/14/2016.
 */
public abstract class FoodApple extends Food {
    public FoodApple(String type, String chefName) {
        super("apple " + type, chefName);
    }
}
