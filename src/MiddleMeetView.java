import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class MiddleMeetView extends JFrame {

    JPanel west, center;


    private JLabel place1 = new JLabel("Ort 1");
    private JTextField start = new JTextField(20);
    private JTextField region1 = new JTextField(20);
    private JLabel place2 = new JLabel("Ort 2");
    private JTextField finish = new JTextField(20);
    private JTextField region2 = new JTextField(20);
    private JLabel result = new JLabel("Ergebnis");
    private JTextField calculatedMeetpoint = new JTextField(20);
    private JTextField calculatedKm = new JTextField(20);
    private JTextField calculatedTime = new JTextField(20);
    private JButton calculateButton = new JButton("Berechne MiddleMeet");



    public MiddleMeetView() {

        MiddleMeetModelTest mm = new MiddleMeetModelTest();
        MiddleMeetController mc = new MiddleMeetController(this,mm);


        //create panels
        west = new JPanel(new GridLayout(15, 1));
        center = new JPanel();

        this.add(west, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);



        String img;
        final String INTRO = "/img/intro.jpg";
        final String ERROR = "/img/error.jpg";
        final String MAP = "/img/snapshotGoogleMaps.jpg";


        //Switch Case einbauen
        img = MAP;


        ImageIcon background = new ImageIcon(getClass().getResource(img));
        JLabel L3 = new JLabel(background);

        //Properties
        result.setFont(new Font ("Default", Font.BOLD, 18));
        calculatedMeetpoint.setEditable(false);
        calculatedKm.setEditable(false);
        calculatedTime.setEditable(false);

        //Elements added
        west.add(place1);
        west.add(start);
        west.add(region1);
        west.add(place2);
        west.add(finish);
        west.add(region2);
        west.add(Box.createVerticalStrut(20));
        west.add(new JSeparator(SwingConstants.HORIZONTAL));
        west.add(result);
        west.add(calculatedMeetpoint);
        west.add(calculatedKm);
        west.add(calculatedTime);
        west.add(new JSeparator(SwingConstants.HORIZONTAL));
        west.add(calculateButton);
        center.add(L3);

        //Margins
        west.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


    }
    
    public String getStart(){

        return start.getText();
    }

    public String getRegion1(){
        return region1.getText();
    }

    public String getFinish(){
        return finish.getText();
    }
    
    public String getRegion2(){
        return region2.getText();
    }

    //SETTER
    public void setMeetpoint(String meetpoint){
        calculatedMeetpoint.setText(meetpoint);
    }

    public void setKm(String km){
        calculatedKm.setText(km);
    }

    public void setTime(String time){
        calculatedTime.setText(time);
    }



    void addCalculateListener(ActionListener listenForCalcButton) {

        calculateButton.addActionListener(listenForCalcButton);
    }

    void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this, errorMessage);

    }

}