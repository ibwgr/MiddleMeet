import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;


public class MiddleMeetController {

    private MiddleMeetView mv;
    //private MiddleMeetModel mm;


    public MiddleMeetController(MiddleMeetView mv) {
        this.mv = mv;


        this.mv.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            SwingUtilities.updateComponentTreeUI(mv);
            mv.center.revalidate();
            mv.center.validate();
            mv.center.repaint();


            String start;
            String region1;
            String finish;
            String region2;
            ImageIcon icon;
            String status;


            start = mv.getStart();
            start = start.replace(" ", ""); //Leerschläge entfernen
            region1 = mv.getRegion1();
            region1 = region1.replace(" ", ""); //Leerschläge entfernen
            finish = mv.getFinish();
            finish = finish.replace(" ", ""); //Leerschläge entfernen
            region2 = mv.getRegion2();
            region2 = region2.replace(" ", ""); //Leerschläge entfernen
            MiddleMeetModel mm = null;
            try {
                mm = new MiddleMeetModel(start, region1, finish, region2);
            } catch (Exception e1) {
                status = "ERROR";
                icon = new ImageIcon(getClass().getResource("img/error.jpg"));
                mv.setIcon(icon);
                e1.printStackTrace();
            }
            status = mm.getStatus();
            icon = mm.getIcon(status);

            mv.setIcon(icon);


            //mm.getDistance(start, region1, finish, region2, apiKey);
            mv.setMeetpoint(mm.getCalculatedMeetpoint());

            mv.setKm(mm.getCalculatedKm());

            mv.setTime(mm.getCalculatedTime());

            //System.out.println(start);
            //System.out.println(region1);
            //System.out.println(finish);
            //System.out.println(region2);
        }
    }
}


