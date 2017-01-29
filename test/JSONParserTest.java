import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class JSONParserTest {

    @Test
    public void getJsonObject() {
        JSONParser jsonParser = new JSONParser();

        //einfaches JSON Objekt von Google Maps parsen
        JSONObject result = null;
        try {
            result = jsonParser.getJSONFromUrl("https://maps.googleapis.com/maps/api/directions/json?" +
                    "origin=Mols&region=Schweiz&destination=Walenstadt&region=Schweiz&key=AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //erwartetes JSON Objekt, welches von Google Maps geparsed wurde
        String expected = "{'routes':[{'summary':'Route 3','copyrights':'Map data ©2017 Google'," +
                "'legs':[{'duration':{'text':'5 mins','value':326}," +
                "'start_location':{'lng':9.279131699999999,'lat':47.1126491}," +
                "'distance':{'text':'3.4 km','value':3351}," +
                "'start_address':'Mols, 8885, Switzerland'," +
                "'end_location':{'lng':9.31603,'lat':47.12398}," +
                "'end_address':'Walenstadt, Switzerland'," +
                "'via_waypoint':[],'steps':[{'duration':{'text':'3 mins','value':166},'start_location':{'lng':9.279131699999999,'lat':47.1126491}," +
                "'distance':{'text':'2.8 km','value':2771},'travel_mode':'DRIVING'," +
                "'html_instructions':'Head <b>east<\\/b> on <b>Walenseestrasse<\\/b>/<b>Route 3<\\/b> toward <b>Kirchweg<\\/b><div style=\\'font-size:0.9em\\'>Continue to follow Route 3<\\/div>'," +
                "'end_location':{'lng':9.3122303,'lat':47.12010739999999}," +
                "'polyline':{'points':'aup~Gqisw@?WG}AGcAIwB]_HQ{DGoAC_ACm@?gA?o@@kA@{A?q@Ao@Ck@MaASw@Oi@Q_@[_A]_Ac@iA[s@]k@[]a@U[Qe@U[U_@]SWQa@Kc@Ie@Cg@AcAD}ADeCFqCD{@Du@Hy@XgBXeBLeAD_A@e@@g@Ew@Es@KcAMy@U{ASgAi@sBi@kBoEgOyBiH}@yCaAcDgBcGGQk@kB{@yCW}@s@kEiAqHSwAOuAGo@Ck@Cm@Ai@AW?k@?sA'}}," +
                "{'duration':{'text':'2 mins','value':135},'start_location':{'lng':9.3122303,'lat':47.12010739999999}," +
                "'distance':{'text':'0.5 km','value':492},'travel_mode':'DRIVING'," +
                "'html_instructions':'Turn <b>left<\\/b> onto <b>Bahnhofstrasse<\\/b>'," +
                "'end_location':{'lng':9.3148935,'lat':47.1241339},'maneuver':'turn-left'," +
                "'polyline':{'points':'ucr~Gmxyw@y@Yk@Wa@WiB}@a@Ue@YiAi@aB}@[SgC{A[Qc@WyAyA'}}," +
                "{'duration':{'text':'1 min','value':25},'start_location':{'lng':9.3148935,'lat':47.1241339}," +
                "'distance':{'text':'88 m','value':88},'travel_mode':'DRIVING'," +
                "'html_instructions':'Turn <b>right<\\/b> onto <b>Lindenpl.<\\/b>'," +
                "'end_location':{'lng':9.31603,'lat':47.12398},'maneuver':'turn-right'," +
                "'polyline':{'points':'y|r~Gaizw@FYDYBYBUDs@@kA'}}],'traffic_speed_entry':[]}],'warnings':[],'bounds':{'southwest':{'lng':9.279131699999999,'lat':47.1126491},'northeast':{'lng':9.31603,'lat':47.1241339}}," +
                "'overview_polyline':{'points':'aup~Gqisw@YqH{@kRCuB@{B@mCE{AMaASw@a@iAy@_C_A}B]k@[]}@g@e@U[Us@u@Qa@Kc@MmABaDLwGJqBb@aDf@kDFeBC_BQwBc@uC}@{DqLw`@}EePsAwE}B}Nc@mDK{AG{C?sAy@YmAo@kCsAe@YiAi@}BqAcDmBc@WyAyALs@Fo@F_C'}," +
                "'waypoint_order':[]}],'geocoded_waypoints':[{'types':['colloquial_area','political']," +
                "'geocoder_status':'OK','place_id':'ChIJ6ybs5Fcqm0cR5qQvJu9sf6M'},{'types':['locality','political']," +
                "'geocoder_status':'OK','place_id':'ChIJa8zKKpErm0cRtwHIzbDdQVA'}]," +
                "'status':'OK'}";

        Assert.assertEquals(expected, result.toString().replace("\"", "'"));
    }
}
