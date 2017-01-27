import javax.swing.*;
import java.awt.*;

/**
 * Created by Cla on 22.01.2017.
 */
public class MiddleMeetModelTest {

    private String calculatedMeetpoint;
    private String calculatedKm;
    private String calculatedTime;
    private String calculatedStatus;
    private String status;


    //********************   Meetpoint

    public void calculateMeetpoint(String start) {
        calculatedMeetpoint = start + "Meetpoint";
    }

    public String getCalculatedMeetpoint() {
        return calculatedMeetpoint;
    }

    //********************   km

    public void calculateKm(String region1) {
        calculatedKm = region1 + " km";
    }

    public String getCalculatedKm() {
        return calculatedKm;
    }

    //********************   Time

    public void calculateTime(String finish) {
        calculatedTime = finish + " time";
    }

    public String getCalculatedTime() {
        return calculatedTime;
    }



    public String getStatus() {
        return status;
    }


    //********************   Status

    public void calculateStatus(String status) {

        switch (calculatedStatus) {
            case "OK": status = "/img/snapshotGoogleMaps.jpg";
                break;
            case "ERROR": status = "/img/error.jpg";
                break;
            default: status = "/img/intro.jpg";
                break;
        }
        calculatedStatus = status;
    }
    //********************   Image

    /*public void findImage(ImageIcon background) {
        ImageIcon foundImage = this.foundImage;
    }

    public void findImage(String background) {
        image = img + "bla";
    }

    public String getImage() {
        return image;
    }*/

}
