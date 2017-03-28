package zoo;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Animal extends Thread {
    private int age;
    private String animalName;
    private String sound;
    private FoodPlace foodPlace;
    private WaterPlace waterPlace;
    
    public Animal(int age, String animalName, String sound, FoodPlace foodPlace, WaterPlace waterPlace) {
        this.age = age;
        this.animalName = animalName;
        this.sound = sound;
        this.foodPlace = foodPlace;
        this.waterPlace = waterPlace;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
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
    
    public abstract String doZoo();
    
    @Override
    public void run(){ 
        while(true) {
            try {
                foodPlace.eat(this);
                waterPlace.drink(this);
                sleep(10000);    
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
