/**
 * Created by Patrick Stoffel on 20.01.2017.
 */

import java.io.*;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class JSONParser {

    static InputStream inputStream = null;
    static JSONObject jsonObject = null;
    static String jsonString = "";

    //Konstruktor
    public JSONParser() {
    }

    public JSONObject getJSONFromUrl(String url) throws IOException {

        //URL für das Einlesen des JSON vorbereiten
        URL urlScanner = new URL(url);

        //Hier wird nun aus der Google Maps Geocoding API URL jede Linie eingelesen
        Scanner scanner = new Scanner(urlScanner.openStream());
        String stringJSON = new String();
        while (scanner.hasNext()) stringJSON += scanner.nextLine();
        scanner.close();

        //Ein JSON Object bilden mit dem eingelesenen String aus der Google Maps Geocoding API URL
        JSONObject jsonObject = new JSONObject(stringJSON);

        return jsonObject;
    }
}