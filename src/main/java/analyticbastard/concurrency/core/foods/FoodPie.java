package analyticbastard.concurrency.core.foods;

import analyticbastard.concurrency.core.Food;

/**
 * Created by Javier on 2/14/2016.
 */
public abstract class FoodPie extends Food {
    public FoodPie(String type, String chefName) {
        super("pie " + type, chefName);
    }
}
