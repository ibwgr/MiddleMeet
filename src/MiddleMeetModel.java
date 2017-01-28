/**
 * Created by Patrick Stoffel on 07.01.2017.
 */

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URLDecoder;

public class MiddleMeetModel {


    private String halftime;
    private String km;
    private String time;


    public static void main(String[] args) {

        String apiKey = "AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk";          //Google Developers API-Key: AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk

        String start = "Bern";
        String region1 = "Schweiz";
        String finish = "Chur";
        String region2 = "Schweiz";


        //Umlaut parsen, damit der Https-Link zu Testzwecken genutzt werden kann
        //Die Google Maps API kann direkt mit den Umlauten arbeiten, ohne dass diese geparsed werden müssen
        UmlautParser umlautParser = new UmlautParser();

        String startOhneUmlaut = umlautParser.replaceUmlaut(start);
        String region1OhneUmlaut = umlautParser.replaceUmlaut(region1);
        String finishOhneUmlaut = umlautParser.replaceUmlaut(finish);
        String region2OhneUmlaut = umlautParser.replaceUmlaut(region2);

        //System.out.println(calculateRoute(startOhneUmlaut, region1OhneUmlaut, finishOhneUmlaut, region2OhneUmlaut, apiKey));

        //System.out.println(getDistance(start, region1, finish, region2, apiKey));


        //Adresse formatiert ausgeben mit geocoding-Methode
        Geocoding geocoding = new Geocoding();
        try {
            Double[] geocodingReslutStart = geocoding.geocoding(start, region1, apiKey);
            Double latStart = geocodingReslutStart[0];
            Double lngStart = geocodingReslutStart[1];

            Double[] geocodingReslutFinish = geocoding.geocoding(finish, region2, apiKey);
            Double latFinish = geocodingReslutFinish[0];
            Double lngFinish = geocodingReslutFinish[1];

            //Mittelpunkt berechnet
            String mittelpunkt = midPoint(latStart, lngStart, latFinish, lngFinish);
            //System.out.println("Mittelpunkt (berechnet): " +mittelpunkt);

            String[] geocdingInverseResult = geocoding.geocodingInverse(mittelpunkt, apiKey);
            String midpointCity = geocdingInverseResult[0];
            String midpointCounty = geocdingInverseResult[1];


            //Route zum Mittelpunkt berechnen
            String distanceMidpoint = getDistance(start, region1, midpointCity, midpointCounty, apiKey);
            //System.out.println("url für JSONparser: " +distanceMidpoint);

            //Die url von Google Maps mit den Routendaten erstellen, damit anschliessend das JSON geparsed werden kann
            String urlForJSONParser = distanceMidpoint;

            JSONParser jsonParser = new JSONParser();
            JSONObject object = jsonParser.getJSONFromUrl(urlForJSONParser);

            //Endadresse abholen
            JSONArray destAddr = object.getJSONArray("destination_addresses");
            String destination = destAddr.getString(0);
            String destinationDecode = new String(destination.getBytes("iso-8859-1"), "UTF-8");

            //Status abholen
            String status = object.getString("status");

            //************************************************************************
            String timeMidpoint = calculateRoute(start, region1, midpointCity, midpointCounty, apiKey);

            //Die url von Google Maps mit den Routendaten erstellen, damit anschliessend das JSON geparsed werden kann
            String urlForJSONParser2 = timeMidpoint;

            JSONParser jsonParser2 = new JSONParser();
            JSONObject object2 = jsonParser2.getJSONFromUrl(urlForJSONParser2);

            //Die totale Zeit in Sekunden aus dem JSON String auslesen
            JSONArray arrayRoutes = object2.getJSONArray("routes");
            JSONObject objectRoutes = (JSONObject) arrayRoutes.get(0);
            JSONArray arrayLegs = objectRoutes.getJSONArray("legs");
            JSONObject objectLegs = (JSONObject) arrayLegs.get(0);
            JSONObject objectDistance = (JSONObject) objectLegs.get("distance");
            String distance = objectDistance.getString("text");
            JSONObject objectDuration = (JSONObject) objectLegs.get("duration");
            String duration = objectDuration.getString("text");

            System.out.println("Zeit bis zum Treffpunkt: " +duration);
            System.out.println("Distanz zum Mittelpunk: " +distance);
            System.out.println("Mittelpunkt: " +destinationDecode);
            System.out.println("Status: " +status);

        //Ort resp. Verzweigung auf der Route finden, die in der nähe der halben Zeit des Weges liegt
        JSONArray arraySteps = objectLegs.getJSONArray("steps");

            //************************************************************************
            //neues Objekt der Klasse Snapshoter erzeugen
            Snapshoter snapshoter = new Snapshoter();
            //Snapshot mit den drei Stecknadeln erstellen
            try {
                snapshoter.snapshot(start,finish,midpointCity,apiKey);
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Die nachfolgende Methode berechnet den geografischen Mittelpunkt zwischen zwei Punkten,
    //die der Methode mit Längen- und Breitengrad übergeben werden.
    public static String midPoint(double lat1,double lng1,double lat2,double lng2) {

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
                +"?origin=" +start
                +"&region=" +region1
                +"&destination=" +finish
                +"&region=" +region2
                +"+&language=de"
                +"&key=" +apiKey;
        return urlString;
    }

    public static String getDistance(String start, String region1, String finish, String region2, String apiKey) {
        String urlString = "https://maps.googleapis.com/maps/api/distancematrix/json"
                +"?origins=" +start
                +"&region=" +region1
                +"&destinations=" +finish
                +"&region=" +region2
                +"+&language=de"
                +"&key=" +apiKey;
        return urlString;
    }
}


