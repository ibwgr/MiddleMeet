/**
 * Created by Patrick Stoffel on 20.01.2017.
 */

import org.junit.Assert;
import org.junit.Test;

public class GeocodingTest {

    @Test
    //Test, ob die geocoding Methode die richtigen Längen- und Breitengrade zurückliefert
    public void getGeocodingValues() throws Exception {
        Geocoding geocoding = new Geocoding();

        Double[] arrayExpectedResult = new Double[2];
        arrayExpectedResult[0] = 47.11255000000001;
        arrayExpectedResult[1] = 9.27914;

            Double[] arrayFromGeocoding;
            arrayFromGeocoding = geocoding.geocoding("Mols", "Schweiz", "AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk");

            Assert.assertArrayEquals(arrayExpectedResult, arrayFromGeocoding);
    }

    @Test
    //Test, ob die geocodingInverse Methode den richtigen Ortsnamen zurückliefert
    public void getGeocodingAddress() throws Exception {
        Geocoding geocoding = new Geocoding();

        String[] arrayExpectedResult = new String[2];
        arrayExpectedResult[0] = "Walenstadt";
        arrayExpectedResult[1] = "Schweiz";

            String[] arrayFromGeocoding;
            arrayFromGeocoding = geocoding.geocodingInverse("47.12398,9.27914", "AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk");

            Assert.assertArrayEquals(arrayExpectedResult, arrayFromGeocoding);
    }
}
