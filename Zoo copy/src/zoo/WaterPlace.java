package zoo;

public class WaterPlace {
    int water;

    public WaterPlace(int water) {
        this.water = water;
    }

    public void drink(Animal animal) {
        synchronized (this) {
            if (water > 0) {
                water -= 1;
                System.out.println(animal.getAnimalName() + " " + "is drinking");
                System.out.println("Remaining water: " + water);
            } else {
                System.out.println("Out of water!");
            }
        }
    }

    public void checkTrough(ZooKeeper zooKeeper) {
        synchronized (this) {
            if (water == 0) {
                water += 10;
                System.out.println(zooKeeper.getZooKeeperName() + " replenished the water trough!");
            } else {
                System.out.println(zooKeeper.getZooKeeperName() + " checked the water trough!");
            }
        }
    }
}
