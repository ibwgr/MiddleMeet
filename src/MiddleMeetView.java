import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class MiddleMeetView extends JFrame {

    private JLabel place1 = new JLabel("Ort 1");
    private JTextField start = new JTextField(20);
    private JTextField region1 = new JTextField(20);
    private JLabel place2 = new JLabel("Ort 2");
    private JTextField finish = new JTextField(20);
    private JTextField region2 = new JTextField(20);
    private JLabel result = new JLabel("Ergebnis");
    private JTextField meetpoint = new JTextField(20);
    private JTextField km = new JTextField(20);
    private JTextField time = new JTextField(20);
    private JButton calculateButton = new JButton("Berechne MiddleMeet");



    public MiddleMeetView() {

        String img;
        final String INTRO = "/img/intro.jpg";
        final String ERROR = "/img/error.jpg";
        final String MAP = "/img/snapshotGoogleMaps.jpg";

        /*MiddleMeetModel mm = new MiddleMeetModel();
        MiddleMeetController mc = new MiddleMeetController(this, mm);
        */



        //Switch Case einbauen
        img = MAP;


        //Objects
        JPanel center = new JPanel();
        JPanel west = new JPanel();


       /* JLabel L1 = new JLabel("Ort 1");
        JTextField ort1 = new JTextField("",15);
        ort1.setToolTipText("Ort");
        JTextField land1 = new JTextField();
        land1.setToolTipText("Land");

        JLabel L2 = new JLabel("Ort 2");
        JTextField ort2 = new JTextField();
        ort2.setToolTipText("Ort");
        JTextField land2 = new JTextField();
        land2.setToolTipText("Land");

        JLabel LResult = new JLabel("Ergebnis");
       // content = new JTextField();


      //  button = new JButton("Berechne MiddleMeet");

        //Set Image Background

*/
        ImageIcon background = new ImageIcon(getClass().getResource(img));
        JLabel L3 = new JLabel(background);


        BorderLayout B = new BorderLayout();
        GridLayout G = new GridLayout(15,0);
        JFrame F = new JFrame();


        //Properties
        result.setFont(new Font ("Default", Font.BOLD, 18));

        F.setLayout(B);
        west.setLayout(G);
        west.add(place1);
        west.add(start);
        west.add(region1);
        west.add(place2);
        west.add(finish);
        west.add(region2);
        west.add(Box.createVerticalStrut(20));
        west.add(new JSeparator(SwingConstants.HORIZONTAL));
        west.add(result);
        west.add(meetpoint);
        west.add(km);
        west.add(time);
        west.add(new JSeparator(SwingConstants.HORIZONTAL));
        west.add(calculateButton);
        center.add(L3);

        //Margins
        west.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(west, B.WEST);
        add(center, B.CENTER);

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

    public String getMeetpoint(String solution){
        return meetpoint.getText();
    }

    public String getKm(){
        return km.getText();
    }

    public String getTime(){
        return time.getText();
    }


    //SETTER
    public void setCalcSolution(String solution) {
        meetpoint.setText(solution);
    }


    void addCalculateListener(ActionListener listenForCalcButton) {

        calculateButton.addActionListener(listenForCalcButton);
    }

    void displayErrorMessage(String errorMessage){

        JOptionPane.showMessageDialog(this, errorMessage);

    }

}