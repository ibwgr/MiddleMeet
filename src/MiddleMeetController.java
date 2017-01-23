import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MiddleMeetController {

    private MiddleMeetView mv;
    private MiddleMeetModelTest mm;


    public MiddleMeetController(MiddleMeetView mv, MiddleMeetModelTest mm) {
        this.mv = mv;
        this.mm = mm;

        this.mv.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String start;
            String region1;
            String finish;
            String region2;

            start = mv.getStart();
            region1 = mv.getRegion1();
            finish = mv.getFinish();
            region2 = mv.getRegion2();

            mm.calculateMeetpoint(start);
            mv.setMeetpoint(mm.getCalculatedMeetpoint());

            mm.calculateKm(region1);
            mv.setKm(mm.getCalculatedKm());

            mm.calculateTime(finish);
            mv.setTime(mm.getCalculatedTime());

            System.out.println(start);
            System.out.println(region1);
            System.out.println(finish);
            System.out.println(region2);


        }
    }
}


