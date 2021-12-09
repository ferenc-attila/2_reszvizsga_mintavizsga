package aquarium;

public class Clownfish extends Fish{

    public Clownfish(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public void feed() {
        growWeight(1);
    }

    @Override
    public boolean hasMemoryLoss() {
        return false;
    }
}
