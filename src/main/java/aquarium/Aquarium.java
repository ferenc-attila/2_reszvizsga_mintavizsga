package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    public static final int CAPACITY = 20;
    private List<Fish> fishes = new ArrayList<>();

    public void addFish(Fish fish) {
        if (fishes.size() == CAPACITY / 5) {
            throw new IllegalStateException("Can not add fish because there is no more space.");
        } else {
            fishes.add(fish);
        }
    }

    public void feed() {
        for (Fish fish : fishes) {
            fish.feed();
        }
    }

    public void removeFish(int maxWeight) {
        List<Fish> fishesToRemove = new ArrayList<>();
        for (Fish fish : fishes) {
            if (fish.getWeight() > maxWeight) {
                fishesToRemove.add(fish);
            }
        }
        fishes.removeAll(fishesToRemove);
    }

    public List<String> getStatus() {
        List<String> status = new ArrayList<>();
        for (Fish fish : fishes) {
            status.add(fish.getStatus());
        }
        return status;
    }

    public int getNumberOfFishWithMemoryLoss() {
        int result = 0;
        for (Fish fish : fishes) {
            if (fish.hasMemoryLoss()) {
                result++;
            }
        }
        return result;
    }

    public boolean isThereFishWithGivenColor(String color) {
        boolean result = false;
        for (Fish fish : fishes) {
            if (fish.getColor().equals(color)) {
                return true;
            }
        }
        return result;
    }


    public Fish getSmallestFish() {
        Fish smallestFish = fishes.get(0);
        for (Fish fish : fishes) {
            if (fish.getWeight() < smallestFish.getWeight()) {
                smallestFish = fish;
            }
        }
        return smallestFish;
    }
}
