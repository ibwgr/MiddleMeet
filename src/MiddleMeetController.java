import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MiddleMeetController {

    private MiddleMeetView mv;
    //private MiddleMeetModel mm;


    public MiddleMeetController(MiddleMeetView mv) {
        this.mv = mv;


        this.mv.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {



            String start;
            String region1;
            String finish;
            String region2;
            ImageIcon icon;
            String status;
            final String apiKey = "AIzaSyDBzdyeHTvujz4KRSvwO5qsrZ-FTCpaNTk";


            start = mv.getStart();
            region1 = mv.getRegion1();
            finish = mv.getFinish();
            region2 = mv.getRegion2();
            MiddleMeetModel mm = new MiddleMeetModel(start, region1, finish, region2);
            status = mm.getStatus();
            icon = mm.getIcon(status);
            mv.setIcon(icon);
            System.out.println(icon);


            mm.getDistance(start, region1, finish, region2, apiKey);
            mv.setMeetpoint(mm.getCalculatedMeetpoint());

            mv.setKm(mm.getCalculatedKm());

            mv.setTime(mm.getCalculatedTime());

            System.out.println(start);
            System.out.println(region1);
            System.out.println(finish);
            System.out.println(region2);

        }
    }
}


