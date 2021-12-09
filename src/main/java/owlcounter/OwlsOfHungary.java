package owlcounter;

import java.util.ArrayList;
import java.util.List;

public class OwlsOfHungary {

    private List<OwlsPerCounty> owlsPerCounties = new ArrayList<>();

    public void addCountyData(OwlsPerCounty countyData) {
        owlsPerCounties.add(countyData);
    }

    public List<OwlsPerCounty> getOwlsPerCounties() {
        return new ArrayList<>(owlsPerCounties);
    }
}
