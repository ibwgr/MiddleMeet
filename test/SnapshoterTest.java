/**
 * Created by Patrick Stoffel on 22.01.2017.
 */

import org.junit.Assert;
import org.junit.Test;
import java.io.File;

public class SnapshoterTest {

    @Test
    //Testet den Snapshoter anhand einer Anfrage bei Google Static Maps und vergleicht den Snapshot mit einer Referenz
    public void getSnapshotFromGoogleMaps() throws Exception {
        //neues Objekt der Klasse Snapshoter erzeugen
        Snapshoter snapshoter = new Snapshoter();
        //Snapshot mit den Stecknadeln "Chur", "Mols" und "Wangs" anfragen
        snapshoter.snapshot("Chur", "Mols", "7323Wangs", "AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk");

        //Grösse des erzeugten Files auslesen
        File fileTest = new File("src/img/snapshotGoogleMaps.jpg");
        long sizeTestFile = fileTest.length();

        //Grösse des Referenz-Files auslesen
        File fileExpectet = new File("test/img/snapshotGoogleMaps.jpg");
        long sizeFileExpectet = fileExpectet.length();

        Assert.assertEquals(sizeFileExpectet, sizeTestFile);
    }
}
