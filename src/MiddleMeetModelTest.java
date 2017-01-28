import android.provider.ContactsContract;

import javax.swing.*;

/**
 * Created by Patrick Stoffel on 07.01.2017.
 */

public class MiddleMeetModelTest  {


    private String halftime;
    private String km;
    private String time;
    private String calculatedMeetpoint;
    private String calculatedKm;
    private String calculatedTime;
    private String calculatedStatus;


    private String apiKey = "AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk";          //Google Developers API-Key: AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk

    //String apiKey;
    String start;
    String region1;
    String finish;
    String region2;
    String status = "OK";
    String imgPath;
    ImageIcon icon;




    //Umlaut parsen, damit der Https-Link zu Testzwecken genutzt werden kann
    //Die Google Maps API kann direkt mit den Umlauten arbeiten, ohne dass diese geparsed werden müssen
   /* UmlautParser umlautParser = new UmlautParser();

    String startOhneUmlaut = umlautParser.replaceUmlaut(start);
    String region1OhneUmlaut = umlautParser.replaceUmlaut(region1);
    String finishOhneUmlaut = umlautParser.replaceUmlaut(finish);
    String region2OhneUmlaut = umlautParser.replaceUmlaut(region2);
*/
    //System.out.println(calculateRoute(startOhneUmlaut, region1OhneUmlaut, finishOhneUmlaut, region2OhneUmlaut, apiKey));

       // System.out.println(

   // getDistance(start, region1, finish, region2, apiKey));


    //Adresse formatiert ausgeben mit geocoding-Methode
    Geocoding geocoding = new Geocoding();



    {
        Double[] geocodingReslutStart = new Double[0];
        try {
            geocodingReslutStart = geocoding.geocoding(start, region1, apiKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Double latStart = (Double) geocodingReslutStart[0];
        Double lngStart = (Double) geocodingReslutStart[1];

        Double[] geocodingReslutFinish = new Double[0];
        try {
            geocodingReslutFinish = geocoding.geocoding(finish, region2, apiKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Double latFinish = (Double) geocodingReslutFinish[0];
        Double lngFinish = (Double) geocodingReslutFinish[1];

        System.out.println(latStart);
        System.out.println(lngStart);
        System.out.println(latFinish);
        System.out.println(lngFinish);

    }






        /*

        //Die url von Google Maps mit den Routendaten erstellen, damit anschliessend das JSON geparsed werden kann
        String urlForJSONParser = (calculateRoute(start, region1, finish, region2, apiKey));

        JSONParser jsonParser = new JSONParser();
        JSONObject object = jsonParser.getJSONFromUrl(urlForJSONParser);

        //Die totale Zeit in Sekunden aus dem JSON String auslesen
        JSONArray arrayRoutes = object.getJSONArray("routes");
        JSONObject objectRoutes = (JSONObject) arrayRoutes.get(0);
        JSONArray arrayLegs = objectRoutes.getJSONArray("legs");
        JSONObject objectLegs = (JSONObject) arrayLegs.get(0);
        JSONObject objectDuration = (JSONObject) objectLegs.get("duration");
        int durationValue = (int) objectDuration.get("value");

        //Halbe Zeit berechnenen
        int halftime = durationValue / 2;

        //Ort resp. Verzweigung auf der Route finden, die in der nähe der halben Zeit des Weges liegt
        JSONArray arraySteps = objectLegs.getJSONArray("steps");

        int durationValueHalftime = 0;
        int durationValueHalftimeOld = 0;
        int stepJSON = 0;

        for (int i = 0; durationValueHalftime < halftime; i++) {
            durationValueHalftimeOld = durationValueHalftime;
            JSONObject objectSteps = (JSONObject) arraySteps.get(i);
            JSONObject objectDurationSetp = (JSONObject) objectSteps.get("duration");
            int durationValueStep = (int) objectDurationSetp.get("value");
            durationValueHalftime = durationValueStep + durationValueHalftimeOld;
            stepJSON = i;
        }

        //Ausgabe der Koordinaten des Ortes, bei dem man sich ungefähr nach Halbzeit befindet
        JSONObject objectEndLocation = (JSONObject) arraySteps.get(stepJSON);
        JSONObject objectEndLocationGeo = (JSONObject) objectEndLocation.get("end_location");
        double lat = (double) objectEndLocationGeo.get("lat");
        double lng = (double) objectEndLocationGeo.get("lng");

        String meetingPoint = new String();
        meetingPoint = (+lat + "," + lng);

        //neues Objekt der Klasse Geocoding erzeugen
        Geocoding geocoding = new Geocoding();

        try {
            geocoding.geocodingInvers(meetingPoint, apiKey);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //neues Objekt der Klasse Snapshoter erzeugen
        Snapshoter snapshoter = new Snapshoter();
        //Snapshot mit den drei Stecknadeln erstellen
        try {
            snapshoter.snapshot(start,finish,meetingPoint,apiKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    //Anfrage für Route an Google Maps API mit eingegebenem Start- und Ziel-Ort

/*    public static String calculateRoute(String start, String region1, String finish, String region2, String apiKey) {
        String urlString = "https://maps.googleapis.com/maps/api/directions/json"
                + "?origin=" + start
                + "&region=" + region1
                + "&destination=" + finish
                + "&region=" + region2
                + "&key=" + apiKey;
        return urlString;
    }*/

    public static String getDistance(String start, String region1, String finish, String region2, String apiKey) {
        String urlString = "https://maps.googleapis.com/maps/api/distancematrix/json"
                + "?origins=" + start
                + "&region=" + region1
                + "&destinations=" + finish
                + "&region=" + region2
                + "&key=" + apiKey;
        return urlString;
    }

   public ImageIcon getIcon(String status) {
        switch (status) {
            case "OK": icon = new ImageIcon(getClass().getResource("/img/snapshotGoogleMaps.jpg")) ;
                break;
            case "ERROR": icon = new ImageIcon(getClass().getResource("/img/error.jpg"));
                break;
            default: icon = new ImageIcon(getClass().getResource("/img/intro.jpg"));
                break;

        }
        return icon;
    }

    public String getCalculatedMeetpoint() {
        return calculatedMeetpoint;
    }

    public String getCalculatedKm() {
        return calculatedKm;
    }

    public String getCalculatedTime() {
        return calculatedTime;
    }

    public String getStatus() {
        return status;
    }

   /* public String getImgPath() {
        return imgPath;
    }*/

}


