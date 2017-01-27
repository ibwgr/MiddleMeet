import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class MiddleMeetView extends JFrame {

    //Constructor

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
    //private ImageIcon icon;
    private String status;
    private String calculatedStatus;




    public MiddleMeetView() {



        MiddleMeetModelTest mm = new MiddleMeetModelTest();
        MiddleMeetController mc = new MiddleMeetController(this,mm);


        //create panels
        west = new JPanel(new GridLayout(15, 1));
        center = new JPanel();

        this.add(west, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);


        //String status = "dvdf";


        /*final String DEFAULT = "/img/intro.jpg";
        final String ERROR = "/img/error.jpg";
        final String OK = "/img/snapshotGoogleMaps.jpg";*/


        //Switch Case einbauen

        /*String img;*/

        /*final String INTRO = "/img/intro.jpg";
        final String ERROR = "/img/error.jpg";
        final String MAP = "/img/snapshotGoogleMaps.jpg";

        img = MAP;*/

        ImageIcon background = new ImageIcon(getClass().getResource(mm.getStatus()));
        JLabel L3 = new JLabel(background);


       /* JLabel L3 = new JLabel();
        L3.setIcon(icon);*/


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

    public String getStatus(){
        return status;
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

   public void setStatus(String status){
        calculatedStatus = status;
   }



    void addCalculateListener(ActionListener listenForCalcButton) {

        calculateButton.addActionListener(listenForCalcButton);
    }

    void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this, errorMessage);

    }




    //http://stackoverflow.com/questions/20411215/cannot-update-java-swing-imageicon



}