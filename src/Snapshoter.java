/**
 * Created by Patrick Stoffel on 22.01.2017.
 */

import java.io.*;
import java.net.URL;

public class Snapshoter {

    //Snapshot aus Google Maps erstellen
    public void snapshot(String start, String finish, String middle, String apiKey) throws IOException {
        String urlStaticMapsAPI = "https://maps.googleapis.com/maps/api/staticmap?="
                +"&markers=color:blue%7Clabel:S%7C" +start //blaue Stecknadel 'S' auf Start-Position setzten
                +"&markers=color:red%7Clabel:E%7C" +finish //rote Stecknadel 'E' auf End-Position setzten
                +"&markers=color:green%7Clabel:M%7C" +middle //grüne Stecknadel 'M' auf Mittel-Position setzten
                +"&size=320x320&scale=2&maptype=roadmap" //Grösse des Snapshots bestimmen
                +"+&language=de"
                +"&key=" +apiKey;

        //angeforderter Snapshot von der Google Maps URL einlesen
        //und lokal als .jpg abspeichern
        URL urlInputStream = new URL(urlStaticMapsAPI);
        InputStream inputStream = urlInputStream.openStream();
        OutputStream outputStream = new FileOutputStream("img/snapshotGoogleMaps.jpg");
        byte[] bytes = new byte[2048];
        int length;
        while ((length = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, length);
        }
        //Streams schliessen
        inputStream.close();
        outputStream.close();
    }
}
