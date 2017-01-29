/**
 * Created by Patrick Stoffel on 22.01.2017.
 */

import org.junit.Assert;
import org.junit.Test;


public class UmlautParserTest {

    @Test
    //Methode zum ersetzten aller Umlaute (ä,ö,ü) damit der https-link zu Testzwecken brauchbar ist
    public void replaceUmlauteInUrl() {
        UmlautParser p = new UmlautParser();

        //Test für die alle Gross- und Kleinbuchstaben (einzeln)
        String resultTest1 = p.replaceUmlaut("Ö,Ä,Ü,ä,ö,ü");

        Assert.assertEquals("OE,AE,UE,ae,oe,ue", resultTest1);

        //Test für Kleinbuchstaben im Wort
        String resultTest2 = p.replaceUmlaut("Zürich");

        Assert.assertEquals("Zuerich", resultTest2);

        //Test für Grossbuchstaben im Wort
        String resultTest3 = p.replaceUmlaut("ÜBUNG");

        Assert.assertEquals("UEBUNG", resultTest3);
    }
}
