/**
 * Created by Patrick Stoffel on 20.01.2017.
 */

import javafx.util.Pair;
import org.json.JSONObject;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Geocoding {

    //Ziel-Adresse formatiert ausgeben anhand Ortsnamen (Geocoding)
    public Double[] geocoding (String addr, String region, String apiKey) throws Exception {

        // URL aufbauen
        String linkGeocodingAddr = "https://maps.googleapis.com/maps/api/geocode/json?"
                + "address="
                + addr
                + "&region="
                + region
                + "&key="
                + apiKey;
        //linkGeocodingAddr += URLEncoder.encode(addr, "UTF-8");
        URL url = new URL(linkGeocodingAddr);
        System.out.println(linkGeocodingAddr);

        // aus aufgebauter URL lesen
        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext()) str += scan.nextLine();
        scan.close();

        // JSON Object bilden
        JSONObject obj = new JSONObject(str);
        if (!obj.getString("status").equals("OK")) ; //return linkGeocodingAddr;

        // erstes Objekt im JSON Array ausgaben (formatierte Adresse)
        JSONObject res = obj.getJSONArray("results").getJSONObject(0);
        //System.out.println(res.getString("formatted_address"));
        JSONObject loc = res.getJSONObject("geometry").getJSONObject("location");
        //String latlngGeocoding = (+loc.getDouble("lat") + "," + loc.getDouble("lng"));
        Double lat = +loc.getDouble("lat");
        Double lng = +loc.getDouble("lng");
        //System.out.println(latlngGeocoding);

        Double[] arrayResult = new Double[2];
        lat = arrayResult[0];
        lng = arrayResult[1];

        return arrayResult;
    }


    //Ziel-Adresse formatiert ausgeben anhand Geodaten (Umgekehrtes Geocoding)
    public String geocodingInvers(String latlng, String apiKey) throws Exception {

        String result = "";

        // URL aufbauen
        String linkGeocodingLatLng = "https://maps.googleapis.com/maps/api/geocode/json?"
                + "latlng="
                + latlng
                +"&key="
                +apiKey;
        linkGeocodingLatLng += URLEncoder.encode(latlng, "UTF-8");
        URL url = new URL(linkGeocodingLatLng);

        // aus aufgebauter URL lesen
        Scanner scan = new Scanner(url.openStream());
        String str = new String();
        while (scan.hasNext()) str += scan.nextLine();
        scan.close();

        // JSON Object bilden
        JSONObject obj = new JSONObject(str);
        if (!obj.getString("status").equals("OK")) return linkGeocodingLatLng;

        // erstes Objekt im JSON Array ausgaben (formatierte Adresse)
        JSONObject res = obj.getJSONArray("results").getJSONObject(0);
        //System.out.println(res.getString("formatted_address"));
        JSONObject loc = res.getJSONObject("geometry").getJSONObject("location");
        String latlngGeocodingInvers = (+loc.getDouble("lat") + "," + loc.getDouble("lng"));
        //System.out.println(latlngGeocodingInvers);

        return result;
    }
}
