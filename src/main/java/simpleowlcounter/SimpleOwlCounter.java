package simpleowlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SimpleOwlCounter {

    private List<String> numberOfOwls;

    public void readFromFile(Path path) {
        try {
            this.numberOfOwls = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int getNumberOfOwls(String county) {
        List<Integer> filtered = new ArrayList<>();
        for (String actual : numberOfOwls) {
            String[] data = actual.split("=");
            if (data[0].equals(county)) {
                filtered.add(Integer.parseInt(data[1]));
            }
        }
        return checkResult(filtered);
    }

    public int getNumberOfAllOwls() {
        int result = 0;
        for (String actual : numberOfOwls) {
            String[] data = actual.split("=");
            result += Integer.parseInt(data[1]);
        }
        return result;
    }

    private int checkResult(List<Integer> filtered) {
        if (!filtered.isEmpty()) {
            return filtered.get(0);
        } else {
            throw new IllegalArgumentException("No such county in Hungary!");
        }
    }
}
