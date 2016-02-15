package analyticbastard.concurrency.masterchef.foods;

import analyticbastard.concurrency.core.foods.FoodCarrot;

/**
 * Created by Javier on 2/14/2016.
 */
public class CarrotImpl extends FoodCarrot {
    public CarrotImpl(String type, String chefName) {
        super(type, chefName);
    }

    @Override
    public String sayHowItTasted() {
        return "The carrot is not so good :-(";
    }
}
