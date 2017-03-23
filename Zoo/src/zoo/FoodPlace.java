package zoo;

public class FoodPlace {
    int food;

    public FoodPlace(int food) {
        this.food = food;
    }

    public void eat(Animal animal) {
        // TODO: In a synchronized block of code, check if there is any food left, if there is, decrement food by 1
        // TODO: Log to the console: Who ate, how much food remains, if there is no food: "Out of food!"
    }

    public void checkTrough(ZooKeeper zooKeeper) {
        // TODO: In a synchronized block of code, check if the food trough is empty, if it is, increment food by 5
        // TODO: Log to the console: Who checked the food trough, who replenished the food trough
    }
}
