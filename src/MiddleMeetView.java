import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class MiddleMeetView extends JFrame {


    public ImageIcon icon;
    public JLabel L3 = new JLabel();
    JPanel west, center;
    private int columns = 12;
    private JLabel place1 = new JLabel("Ort 1");
    private JLabel startL1 = new JLabel("Ort");
    private JLabel startL2 = new JLabel("Ort");
    private JLabel regionL1 = new JLabel("Land");
    private JLabel regionL2 = new JLabel("Land");
    private JTextField start = new JTextField(columns);
    private JTextField region1 = new JTextField(columns);
    private JLabel place2 = new JLabel("Ort 2");
    private JTextField finish = new JTextField(columns);
    private JTextField region2 = new JTextField(columns);
    private JLabel result = new JLabel("Ergebnis");
    private JLabel meetpoint = new JLabel("Meeting Point");
    private JTextField calculatedMeetpoint = new JTextField(columns);
    private JLabel kmL = new JLabel("KM bis Meeting Point");
    private JTextField calculatedKm = new JTextField(columns);
    private JLabel timeL = new JLabel("Zeit bis Meeting point");
    private JTextField calculatedTime = new JTextField(columns);
    private JButton calculateButton = new JButton("Berechne MiddleMeet");
    private Font title = new Font("Default", Font.BOLD, 18);


    //Constructor
    public MiddleMeetView() {


        MiddleMeetModelTest mm = new MiddleMeetModelTest();
        MiddleMeetController mc = new MiddleMeetController(this, mm);

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/intro.jpg"));


        //create panels
        west = new JPanel(new GridLayout(13, 2));
        center = new JPanel();

        this.add(west, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);


        L3.setIcon(icon);


        //Properties
        place1.setFont(title);
        place2.setFont(title);
        result.setFont(title);
        calculatedMeetpoint.setEditable(false);
        calculatedKm.setEditable(false);
        calculatedTime.setEditable(false);

        //Elements added
        west.add(place1);
        west.add(new JLabel());
        west.add(startL1);
        west.add(start);
        west.add(regionL1);
        west.add(region1);
        west.add(place2);
        west.add(new JLabel());
        west.add(startL2);
        west.add(finish);
        west.add(regionL2);
        west.add(region2);
        west.add(Box.createVerticalStrut(20));
        west.add(new JSeparator(SwingConstants.HORIZONTAL));
        west.add(result);
        west.add(new JLabel());
        west.add(meetpoint);
        west.add(calculatedMeetpoint);
        west.add(kmL);
        west.add(calculatedKm);
        west.add(timeL);
        west.add(calculatedTime);
        west.add(new JSeparator(SwingConstants.HORIZONTAL));
        west.add(Box.createVerticalStrut(20));
        west.add(calculateButton);
        center.add(L3);


        //add margins to border layout
        west.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }


    //GETTER
    public String getStart() {

        return start.getText();
    }

    public String getRegion1() {
        return region1.getText();
    }

    public String getFinish() {
        return finish.getText();
    }

    public String getRegion2() {
        return region2.getText();
    }


    //SETTER
    public void setMeetpoint(String meetpoint) {
        calculatedMeetpoint.setText(meetpoint);
    }

    public void setKm(String km) {
        calculatedKm.setText(km);
    }

    public void setTime(String time) {
        calculatedTime.setText(time);
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
        L3.setIcon(icon);
    }


    void addCalculateListener(ActionListener listenForCalcButton) {

        calculateButton.addActionListener(listenForCalcButton);
    }
}