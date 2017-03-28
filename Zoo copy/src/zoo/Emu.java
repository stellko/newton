package zoo;

public class Emu extends Animal {
    public Emu(int age, String name, String sound, FoodPlace foodPlace, WaterPlace waterPlace){
        super(age, name, sound, foodPlace, waterPlace);
    }

    @Override
    public String doZoo() {
        // TODO:: Emus always make their sound two times in a row
        return this.getSound();
    }
}
