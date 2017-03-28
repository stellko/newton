package zoo;

public class FoodPlace {

    int food;

    public FoodPlace(int food) {
        this.food = food;
    }

    public void eat(Animal animal) throws InterruptedException {
        synchronized (this) {
            if (food > 0) {
                food -= 1;
                System.out.println(animal.getAnimalName() + " " + "is eating");
                System.out.println("Remaining food: " + food);
            } else {
                System.out.println("Out of food!");
            }
        }
    }

    public void checkTrough(ZooKeeper zooKeeper) {
        synchronized (this) {
            if (food == 0) {
                food += 5;
                System.out.println(zooKeeper.getZooKeeperName() + " replenished the food trough!");
            } else {
                System.out.println(zooKeeper.getZooKeeperName() + " checked the food trough!");
            }
        }
    }
}
