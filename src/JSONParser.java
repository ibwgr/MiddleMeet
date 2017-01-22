/**
 * Created by Patrick Stoffel on 20.01.2017.
 */

import java.io.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;


public class JSONParser {

    static InputStream inputStream = null;
    static JSONObject jsonObject = null;
    static String jsonString = "";

    //Konstruktor
    public JSONParser() {

    }

    public JSONObject getJSONFromUrl(String url) {

        //HTTP request ausführen
        try {
            //DefaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            inputStream = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            //String Zeile für Zeile einlesen
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
                //System.out.println(line);
            }
            inputStream.close();
            jsonString = stringBuilder.toString();

        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " +e.toString());
        }

        // der String wird in ein JSON Object geparsed
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " +e.toString());
            System.out.println("error on parse data in jsonparser.java");
        }

        // gibt den JSON String zurück
        return jsonObject;
    }
}