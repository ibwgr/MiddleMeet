/**
 * Created by Cla on 22.01.2017.
 */
public class MiddleMeetModelTest {

    private String calculatedMeetpoint;
    private String calculationKm;
    private String calculationTime;


    //********************   Meetpoint

    public void calculateMeetpoint(String start) {
        calculatedMeetpoint = start + " Meetpoint";
    }

    public String getCalculatedMeetpoint(){
        return calculatedMeetpoint;
    }

}
