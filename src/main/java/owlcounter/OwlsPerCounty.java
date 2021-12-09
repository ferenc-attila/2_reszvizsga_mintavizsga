package owlcounter;

public class OwlsPerCounty {

    private String countyName;
    private int numberOfOwlsInCounty;

    public OwlsPerCounty(String countyName, int numberOfOwlsInCounty) {
        this.countyName = countyName;
        this.numberOfOwlsInCounty = numberOfOwlsInCounty;
    }

    public String getCountyName() {
        return countyName;
    }

    public int getNumberOfOwlsInCounty() {
        return numberOfOwlsInCounty;
    }
}
