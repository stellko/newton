package zoo;

public class WaterPlace {
    int water;

    public WaterPlace(int water) {
        this.water = water;
    }

    public void drink() {
        // TODO: In a synchronized block of code, check if there is any water left, if there is, the animal can drink, decrement food by 1
        // TODO: Log to the console: Who drank, how much water remains, if there is no water: "Out of water!"
    }

    public void checkTrough() {
        // TODO: In a synchronized block of code, the zooKeeper checks if the water trough is empty, if it is, the zooKeeper replenished the water trough, increment water by 5
        // TODO: Log to the console: Who checked the food trough, who replenished the food trough
    }
}
