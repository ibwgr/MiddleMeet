/**
 * Created by Patrick Stoffel on 20.01.2017.
 */

import org.json.JSONObject;

public class Geocoding {

    //Die Methode gibt die Geodaten in Form von Längen- und Breitengrad zurück (Geocoding),
    //anhand eines übergebenen Ortsnamen (inkl. Angabe des Landes zur eindeutigen Identifizierung).
    //Das Ganze erfolgt über die Geocoding API von Google Maps
    public Double[] geocoding(String addr, String region, String apiKey) throws Exception {

        //Die URL für die Anfrage bei der Google Maps Geocoding API zusammenbauen
        String urlGeocodingAPI = "https://maps.googleapis.com/maps/api/geocode/json?"
                +"address=" +addr
                +"&region=" +region
                +"+&language=de"
                +"&key=" +apiKey;

        //URL für das Einlesen des JSON vorbereiten
        String urlForJSONParser = urlGeocodingAPI;

        //neues Objekt der Klasse JSON Parsers erzeugen, und die URL übergeben
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = jsonParser.getJSONFromUrl(urlForJSONParser);

        //aus dem JSON Object die gewünschten Daten auslesen
        //in diesem Fall sind das die Werte für Längen- und Breitengrade
        JSONObject results = jsonObject.getJSONArray("results").getJSONObject(0);
        JSONObject location = results.getJSONObject("geometry").getJSONObject("location");
        Double lat = +location.getDouble("lat"); //Breitengrad
        Double lng = +location.getDouble("lng"); //Längengrad

        //die beiden Werte für Längen- und Breitengrad werden in einem Double-Array zurückgegeben
        Double[] arrayResult = new Double[2];
        arrayResult[0] = lat;
        arrayResult[1] = lng;

        return arrayResult;
    }

    //Die Methode gibt einen Ortsnamen (inkl. Land) zurück.
    //Die Rückgabe erfolgt anhand von übergebenen Geodaten (umgekehrtes Geocoding).
    //Das Ganze erfolgt wiederum über die Geocoding API von Google Maps.
    public String[] geocodingInverse(String latlng, String apiKey) throws Exception {

        //Die URL für die Anfrage bei der Google Maps Geocoding API zusammenbauen
        String urlGeocodingAPI = "https://maps.googleapis.com/maps/api/geocode/json?"
                +"latlng=" +latlng
                +"+&language=de"
                +"&key=" +apiKey;

        //URL für das Einlesen des JSON vorbereiten
        String urlForJSONParser = urlGeocodingAPI;

        //neues Objekt der Klasse JSON Parsers erzeugen, und die URL übergeben
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = jsonParser.getJSONFromUrl(urlForJSONParser);

        //aus dem JSON Object die gewünschten Daten auslesen
        //in diesem Fall ist das ein String mit einer formatierten Adresse (z.B. "Chur, Schweiz"
        JSONObject results = jsonObject.getJSONArray("results").getJSONObject(1);
        String formattedAddress = (results.getString("formatted_address"));

        //Für die Rückgabe werden aus dem String alle Leerschläge entfernt.
        //Der String wird bei jedem Komma getrennt, und in ein String-Array geschrieben
        String[] formattedAddressArray = formattedAddress.replace(" ","").split(",");

        return formattedAddressArray;
    }
}
