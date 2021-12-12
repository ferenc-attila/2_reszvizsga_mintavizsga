package simpleowlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        for (String actual : numberOfOwls) {
            if (actual.startsWith(county)) {
                return getValue(actual);
            }
        }
        throw new IllegalArgumentException("No such county in Hungary!");
    }

    public int getNumberOfAllOwls() {
        int result = 0;
        for (String actual : numberOfOwls) {
            result += getValue(actual);
        }
        return result;
    }

    private int getValue(String actual) {
        String[] data = actual.split("=");
        return Integer.parseInt(data[1]);
    }
}
