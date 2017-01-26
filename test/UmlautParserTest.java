/**
 * Created by Patrick Stoffel on 22.01.2017.
 */

import org.junit.Assert;
import org.junit.Test;


public class UmlautParserTest {

    //Methode zum ersetzten aller Umlaute (ä,ö,ü) damit der https-link zu Testzwecken brauchbar ist
    @Test
    public void replaceUmlauteInUrl() {
        UmlautParser p = new UmlautParser();

        String resultTest1 = p.replaceUmlaut("Ö,Ä,Ü,ä,ö,ü");

        Assert.assertEquals("OE,AE,UE,ae,oe,ue", resultTest1);

        String resultTest2 = p.replaceUmlaut("Zürich");

        Assert.assertEquals("Zuerich", resultTest2);

        String resultTest3 = p.replaceUmlaut("Übung");

        Assert.assertEquals("Uebung", resultTest3);

        String resultTest4 = p.replaceUmlaut("ÜBUNG");

        Assert.assertEquals("UEBUNG", resultTest4);
    }
}
