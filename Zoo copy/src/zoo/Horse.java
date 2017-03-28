package zoo;

public class Horse extends Animal {

    public Horse(int age, String name, String sound, FoodPlace foodPlace, WaterPlace waterPlace) {
        super(age, name, sound, foodPlace, waterPlace);
    }

    @Override
    public String doZoo() {
        // TODO: Horses tend to say their names before they make their sound
        return this.getSound();
    }
}
