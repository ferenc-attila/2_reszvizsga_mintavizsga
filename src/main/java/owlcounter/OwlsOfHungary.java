package owlcounter;

import java.util.ArrayList;
import java.util.List;

public class OwlsOfHungary {

    private List<OwlsPerCounty> owlsOfHungary = new ArrayList<>();

    public void addCountyData(OwlsPerCounty countyData) {
        owlsOfHungary.add(countyData);
    }

    public List<OwlsPerCounty> getOwlsOfHungary() {
        return new ArrayList<>(owlsOfHungary);
    }
}
