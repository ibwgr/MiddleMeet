/**
 * Created by Patrick Stoffel on 22.01.2017.
 */

public class UmlautParser {

    //Methode zum ersetzten aller Umlaute (ä,ö,ü) damit der https-link zu Testzwecken brauchbar ist
    //die Google Maps API kann mit Umlauten umgehen
    public String replaceUmlaut(String input) {

        //ersetzte alle Kleinbuchstaben (ä,ö,ü zu ae,oe,ue)
        String output = input.replace("ü", "ue")
                .replace("ö", "oe")
                .replace("ä", "ae");

        //ersetzte alle Grossbuchstaben, gefolgt von Grossbuchstaben (Ä,Ö,Ü zu AE,OE,UE)
        output = output.replace("Ü", "UE")
                .replace("Ö", "OE")
                .replace("Ä", "AE");

        return output;
    }
}
