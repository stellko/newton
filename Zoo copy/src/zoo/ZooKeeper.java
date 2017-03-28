package zoo;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ZooKeeper extends Thread {
    private String zooKeeperName;
    private FoodPlace foodPlace;
    private WaterPlace waterPlace;
    
    public ZooKeeper(String zooKeeperName, FoodPlace foodPlace, WaterPlace waterPlace) {
        this.zooKeeperName = zooKeeperName;
        this.foodPlace = foodPlace;
        this.waterPlace = waterPlace;
    }

    public String getZooKeeperName() {
        return zooKeeperName;
    }

    public void setZooKeeperName(String zooKeeperName) {
        this.zooKeeperName = zooKeeperName;
    }

    public FoodPlace getFoodPlace() {
        return foodPlace;
    }

    public void setFoodPlace(FoodPlace foodPlace) {
        this.foodPlace = foodPlace;
    }

    public WaterPlace getWaterPlace() {
        return waterPlace;
    }

    public void setWaterPlace(WaterPlace waterPlace) {
        this.waterPlace = waterPlace;
    }
     
    @Override
    public void run() {
        while(true){
            try {
                foodPlace.checkTrough(this);
                waterPlace.checkTrough(this);
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ZooKeeper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
