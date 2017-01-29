import org.junit.Assert;
import org.junit.Test;

public class MiddleMeetModelTest {

    @Test
    //Test für die Methode zur berechnung des geografischen Mittelpunktes zwischen zeit Punkten
    //die berechneten Koordinaten sollen in einem String zurück kommen (durch ein Komma getrennt)
    public void calculateGeographicMidPoint() throws Exception {
        MiddleMeetModel middleMeetModel = new MiddleMeetModel("Chur","Schweiz","Sargans","Schweiz");

        String resultTestMidPoint = middleMeetModel.midPoint(46.850475,9.532648,47.047912,9.441185);

        String expectetResult = "46.94920260417916,9.487000845898871";

        Assert.assertEquals(expectetResult, resultTestMidPoint);
    }

    @Test
    //Test für die Methode calcuateRoute
    public void getUrlLinkForGoogleMapsAPI() throws Exception {
        MiddleMeetModel middleMeetModel = new MiddleMeetModel("Chur","Schweiz","Sargans","Schweiz");

        //Anfrage für Route
        String resultUrl = middleMeetModel.calculateRoute("Chur","Schweiz","Sargans","Schweiz","AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk");

        //erwartete URL für Google Maps
        String expectetUrl = "https://maps.googleapis.com/maps/api/directions/json?" +
                "origin=Chur&region=Schweiz" +
                "&destination=Sargans&region=Schweiz+" +
                "&language=de" +
                "&key=AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk";

        Assert.assertEquals(expectetUrl,resultUrl);
    }
}