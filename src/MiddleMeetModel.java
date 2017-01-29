import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.*;

public class MiddleMeetModel {

    private ImageIcon icon;
    private String newStatus;
    private String newEndAddress;
    private String newDuration;
    private String newDistance;


    public MiddleMeetModel(String start, String region1, String finish, String region2) throws Exception {

        //Google Developers API-Key für Anfragen bei Google Maps: AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk
        String apiKey = "AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk";

        //Umlaut parsen, damit der ausgegebene Https-Link auf der Konsole zu Testzwecken genutzt werden kann.
        //Die Google Maps API kann direkt mit den Umlauten arbeiten, ohne dass diese geparsed werden müssen.
        UmlautParser umlautParser = new UmlautParser();

        String startOhneUmlaut = umlautParser.replaceUmlaut(start);
        String region1OhneUmlaut = umlautParser.replaceUmlaut(region1);
        String finishOhneUmlaut = umlautParser.replaceUmlaut(finish);
        String region2OhneUmlaut = umlautParser.replaceUmlaut(region2);
        //Konsolenausgabe, damit der Link zur Analyse der Route genutzt werden kann
        System.out.println(calculateRoute(startOhneUmlaut, region1OhneUmlaut, finishOhneUmlaut, region2OhneUmlaut, apiKey));

        //**************************************************************************************************************
        //neues Objekt der Klasse Geocoding erzeugen, um die Koordinaten und Namen der Orte auszugeben
        Geocoding geocoding = new Geocoding();
        //Längen- und Breitengrad für den Startpunkt aus Geocoding auslesen
        Double[] geocodingReslutStart = geocoding.geocoding(start, region1, apiKey);
        Double latStart = geocodingReslutStart[0];
        Double lngStart = geocodingReslutStart[1];
        //Längen- und Breitengrad für den Endpunkt aus Geocoding auslesen
        Double[] geocodingReslutFinish = geocoding.geocoding(finish, region2, apiKey);
        Double latFinish = geocodingReslutFinish[0];
        Double lngFinish = geocodingReslutFinish[1];

        //den geografischen Mittelpunkt über die Methode midPoint berechnen
        String midPoint = midPoint(latStart, lngStart, latFinish, lngFinish);

        //mit dem umgekehrten Geocoding den Ortsnamen und das Land ermitteln, in dem der berechnete Mittelpunkt liegt
        String[] geocdingInverseResult = geocoding.geocodingInverse(midPoint, apiKey);
        String midPointPlace = geocdingInverseResult[0];
        String midpointCounty = geocdingInverseResult[1];
        //**************************************************************************************************************

        //**************************************************************************************************************
        //Nach dem der geografische Mittelpunkt berechent wurde, sollen nun noch die Zeit und die Distanz,
        //sowie der Name des Ortes ermittelt werden.

        //Route vom Startpunkt zum berechneten Mittelpunkt anfragen
        String routeToMidPoint = calculateRoute(start, region1, midPointPlace, midpointCounty, apiKey);

        //URL für das Einlesen des JSON vorbereiten
        String urlForJSONParser = routeToMidPoint;

        //neues Objekt der Klasse JSON Parsers erzeugen, und die URL übergeben
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = jsonParser.getJSONFromUrl(urlForJSONParser);

        //die notwendigen Daten aus dem JSON Object auslesen
        JSONArray arrayRoutes = jsonObject.getJSONArray("routes");
        JSONObject objectRoutes = (JSONObject) arrayRoutes.get(0);
        JSONArray arrayLegs = objectRoutes.getJSONArray("legs");
        JSONObject objectLegs = (JSONObject) arrayLegs.get(0);
        JSONObject objectDistance = (JSONObject) objectLegs.get("distance");
        String distance = objectDistance.getString("text"); //die Distanz als String auslesen
        JSONObject objectDuration = (JSONObject) objectLegs.get("duration");
        String duration = objectDuration.getString("text"); //die Dauer als String auslesen
        String endAddress = objectLegs.getString("end_address"); //die Ziel-Adresse als String auslesen

        //Status der Anfrage abholen
        String status = jsonObject.getString("status");

        //Ausgabe der Ergebnisse auf der Konsole
        System.out.println("Treffpunkt: " +endAddress);
        System.out.println("Zeit bis zum Treffpunkt: " +duration);
        System.out.println("Distanz bis zum Treffpunkt: " +distance);
        System.out.println("Status der Anfrage: " + status);

        //Variablen den private Variablen zuweisen
        newDuration = duration;
        newDistance = distance;
        newEndAddress = endAddress;
        newStatus = status;
        //**************************************************************************************************************

        //**************************************************************************************************************
        //neues Objekt der Klasse Snapshoter erzeugen
        Snapshoter snapshoter = new Snapshoter();
        //Snapshot mit den drei Stecknadeln für Start-, End- und Mittelpunkt erstellen
        snapshoter.snapshot(start, finish, midPointPlace, apiKey);
        //**************************************************************************************************************
    }


    //Die nachfolgende Methode berechnet den geografischen Mittelpunkt zwischen zwei Punkten,
    //die der Methode mit Längen- und Breitengrad übergeben werden.
    public static String midPoint(double lat1, double lng1, double lat2, double lng2) {

        //Geodaten von Grad ins Bogenmass umrechnen (Kreis ist 2xPI)
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        lng1 = Math.toRadians(lng1);
        lng2 = Math.toRadians(lng2);

        //Differenz der beiden Längengrade bilden
        double differenceLng = (lng2 - lng1);

        //Mittelpunkt der beiden Punkte berechnen
        double x = Math.cos(lat2) * Math.cos(differenceLng);
        double y = Math.cos(lat2) * Math.sin(differenceLng);
        double resultLat = Math.atan2(Math.sin(lat1) + Math.sin(lat2), Math.sqrt((Math.cos(lat1) + x) * (Math.cos(lat1) + x) + y * y));
        double resultLng = lng1 + Math.atan2(y, Math.cos(lat1) + x);

        //für die Ausgabe wird auf Grad (Kreis 360Grad) zurück gerechnet
        //die Rückgabe erfolgt in einem String, der die Längen- und Breitengrade durch ein Komma getrennt beinhaltet
        String geographicMidpoint = (Math.toDegrees(resultLat) + "," + Math.toDegrees(resultLng));

        return geographicMidpoint;
    }


    //Anfrage für Route an Google Maps API mit eingegebenem Start- und Ziel-Ort
    public static String calculateRoute(String start, String region1, String finish, String region2, String apiKey) {
        String urlString = "https://maps.googleapis.com/maps/api/directions/json"
                + "?origin=" + start
                + "&region=" + region1
                + "&destination=" + finish
                + "&region=" + region2
                + "+&language=de"
                + "&key=" + apiKey;
        return urlString;
    }

    //Status für GUI ermitteln
    public ImageIcon getIcon(String status) {
        newStatus = status;

        if (newStatus.equals("OK")) {
            icon = new ImageIcon("img/snapshotGoogleMaps.jpg");
        } else {
            icon = new ImageIcon(getClass().getResource("img/error.jpg"));
        }
        return icon;
    }

    //GETTER für Controller Klasse
    public String getStatus() {
        return newStatus;
    }

    public String getCalculatedMeetpoint() {
        return newEndAddress;
    }

    public String getCalculatedKm() {
        return newDistance;
    }

    public String getCalculatedTime() {
        return newDuration;
    }
}


