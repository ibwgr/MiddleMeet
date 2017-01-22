/**
 * Created by Patrick Stoffel on 22.01.2017.
 */

import java.io.*;
import java.net.URL;

public class Snapshoter {

    //Google Maps Snapshot mit Stecknadeln auf den relevanten Orten erstellen
    public String snapshot(String start, String finish, String middle, String apiKey) throws IOException {

        String result = "";
        String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?="
                + "&markers=color:blue%7Clabel:S%7C"
                + start
                + "&markers=color:red%7Clabel:E%7C"
                + finish
                + "&markers=color:green%7Clabel:M%7C"
                + middle
                + "&size=320x320&scale=2&maptype=roadmap"
                +"&key="
                +apiKey;
        String destinationFile = "src/img/snapshotGoogleMaps.jpg";

        //angeforderter Snapshot von der Google Maps URL einlesen
        //und lokal als File abspeicern (snapshotGoogleMaps.jpg)
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);
        byte[] b = new byte[2048];
        int length;
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }
        is.close();
        os.close();
        return result;
    }
}
