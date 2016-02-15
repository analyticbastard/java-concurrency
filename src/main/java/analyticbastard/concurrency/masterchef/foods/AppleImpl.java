package analyticbastard.concurrency.masterchef.foods;

import analyticbastard.concurrency.core.foods.FoodApple;

/**
 * Created by Javier on 2/14/2016.
 */
public class AppleImpl extends FoodApple {
    public AppleImpl(String type, String chefName) {
        super(type, chefName);
    }

    @Override
    public String sayHowItTasted() {
        return "The apple is fine.";
    }
}
