package analyticbastard.concurrency.core.foods;

import analyticbastard.concurrency.core.Food;

/**
 * Created by Javier on 2/14/2016.
 */
public abstract class FoodCarrot extends Food {
    public FoodCarrot(String type, String chefName) {
        super("carrot " + type, chefName);
    }
}
