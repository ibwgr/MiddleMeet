import javax.swing.*;

/**
 * Created by Cla on 22.01.2017.
 */
public class MiddleMeetModelTest {

    private String calculationMeedpoint;
    private String calculationKm;
    private String calculationTime;


    //********************   Meetpoint
    public void addCalculationMeetpoint(String start, String finish) {
        calculationMeedpoint = "Dudenhofen";
    }

    public String getCalculationMeedpoint() {
        return calculationMeedpoint;
    }

    //*******************    KM
    public void addCalculationKm(String start, String finish) {
        calculationKm = "1000km";
    }


    public String getCalculationKm() {
        return calculationKm;
    }


    //****************    Time
    public void addCalculationTime(String start, String finish) {
        calculationTime = "25min";
    }


    public String getCalculationTime() {
        return calculationTime;
    }
}
