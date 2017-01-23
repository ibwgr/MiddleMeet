/**
 * Created by Cla on 22.01.2017.
 */
public class MiddleMeetModelTest {

    private String calculatedMeetpoint;
    private String calculatedKm;
    private String calculatedTime;


    //********************   Meetpoint

    public void calculateMeetpoint(String start) {
        calculatedMeetpoint = start + " Meetpoint";
    }

    public String getCalculatedMeetpoint(){
        return calculatedMeetpoint;
    }

    //********************   km

    public void calculateKm(String region1) {
        calculatedKm = region1 + " km";
    }

    public String getCalculatedKm(){
        return calculatedKm;
    }

    //********************   Time

    public void calculateTime(String finish) {
        calculatedTime = finish + " time";
    }

    public String getCalculatedTime(){
        return calculatedTime;
    }

}
