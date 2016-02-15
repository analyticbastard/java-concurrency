package analyticbastard.concurrency.factories;

import analyticbastard.concurrency.core.Food;
import analyticbastard.concurrency.masterchef.foods.AppleImpl;
import analyticbastard.concurrency.masterchef.foods.CarrotImpl;
import analyticbastard.concurrency.masterchef.foods.PieImpl;

import static analyticbastard.concurrency.core.AFoodTypes.IFoodType;

/**
 * Created by Javier on 2/14/2016.
 */
public class FoodFactory {
    public static Food createFood(IFoodType foodType, String chefName) {
        switch (foodType) {
            case APPLE: return new AppleImpl("golden", chefName);
            case PIE: return new PieImpl("chocolate", chefName);
            case CARROT: return new CarrotImpl("small", chefName);
        }
        return null;
    }
}
