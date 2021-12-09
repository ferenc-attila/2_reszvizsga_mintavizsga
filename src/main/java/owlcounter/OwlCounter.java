package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OwlCounter {

    private List<String> owls = new ArrayList<>();

    public void readFromFile(Path path) {
        try {
            owls = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int getNumberOfAllOwls() {
        OwlsOfHungary owlsOfHungary = buildOwlsOfHungary();
        int result = 0;
        for (OwlsPerCounty countyData : owlsOfHungary.getOwlsOfHungary()) {
            result += countyData.getNumberOfOwlsInCounty();
        }
        return result;
    }

    public int getNumberOfOwls(String county) {
        OwlsOfHungary owlsOfHungary = buildOwlsOfHungary();
        return checkCounty(county, owlsOfHungary).getNumberOfOwlsInCounty();
    }

    private OwlsOfHungary buildOwlsOfHungary() {
        OwlsOfHungary owlsOfHungary = new OwlsOfHungary();
        for (String row : owls) {
            owlsOfHungary.addCountyData(createCountyData(row));
        }
        return owlsOfHungary;
    }

    private OwlsPerCounty createCountyData(String stringOfCountyData) {
        String[] countyData = stringOfCountyData.split("=");
        return new OwlsPerCounty(countyData[0], Integer.parseInt(countyData[1]));
    }

    private OwlsPerCounty checkCounty(String county, OwlsOfHungary owlsOfHungary) {
        OwlsPerCounty countyData = findOwlsPerCounty(county, owlsOfHungary);
        if (countyData == null) {
            throw new IllegalArgumentException("No such county in Hungary!");
        } else {
            return countyData;
        }
    }

    private OwlsPerCounty findOwlsPerCounty(String county, OwlsOfHungary owlsOfHungary) {
        OwlsPerCounty actual = null;
        for (OwlsPerCounty countyData : owlsOfHungary.getOwlsOfHungary()) {
            if (county.equals(countyData.getCountyName())) {
                actual = countyData;
            }
        }
        return actual;
    }
}
