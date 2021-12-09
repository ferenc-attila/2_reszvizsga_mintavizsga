package aquarium;

public class Tang extends Fish {

    public Tang(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public void feed() {
        growWeight(1);
    }

    @Override
    public boolean hasMemoryLoss() {
        return true;
    }
}
