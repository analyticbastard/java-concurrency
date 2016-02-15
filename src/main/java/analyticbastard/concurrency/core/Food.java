package analyticbastard.concurrency.core;

/**
 * Created by Javier on 2/14/2016.
 */
public abstract class Food {
    final String type;
    private final String chefName;

    public Food(String type, String chefName) {
        this.type = type;
        this.chefName = chefName;
    }

    public String getType() {
        return type;
    }

    public String getChefName() {
        return chefName;
    }

    public abstract String sayHowItTasted();
}
