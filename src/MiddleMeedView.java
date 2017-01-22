import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;

public class MiddleMeedView extends JFrame {
    public MiddleMeedView() {

        //Objects
        JPanel center = new JPanel();
        JPanel west = new JPanel();
        JButton B1 = new JButton("OK");

        JLabel L1 = new JLabel("Ort 1");
        JTextField ort1 = new JTextField("",20);
        ort1.setToolTipText("Ort");
        JTextField land1 = new JTextField();
        land1.setToolTipText("Land");

        JLabel L2 = new JLabel("Ort 2");
        JTextField ort2 = new JTextField();
        ort2.setToolTipText("Ort");
        JTextField land2 = new JTextField();
        land2.setToolTipText("Land");

        JLabel L3 = new JLabel("CENTER");
        BorderLayout B = new BorderLayout();
        GridLayout G = new GridLayout(10,0);
        JFrame F = new JFrame();

        //Properties

        F.setLayout(B);
        west.setLayout(G);
        west.add(L1);
        west.add(ort1);
        west.add(land1);
        west.add(L2);
        west.add(ort2);
        west.add(land2);

        //Margins
        west.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(west, B.WEST);
        add(center, B.CENTER);


    }

    public static void main(String[] args) {
        MiddleMeedView m = new MiddleMeedView();
        m.setSize(800, 600);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m.setVisible(true);
    }
}