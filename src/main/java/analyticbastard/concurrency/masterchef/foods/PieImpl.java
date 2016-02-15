package analyticbastard.concurrency.masterchef.foods;

import analyticbastard.concurrency.core.foods.FoodPie;

/**
 * Created by Javier on 2/14/2016.
 */
public class PieImpl extends FoodPie {
    public PieImpl(String type, String chefName) {
        super(type, chefName);
    }

    @Override
    public String sayHowItTasted() {
        return "The pie is delicious!";
    }
}
