import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MiddleMeetView extends JFrame {
    private JButton button;
    private JTextField content;

    public MiddleMeetView() {

        String img;
        final String INTRO = "/img/intro.jpg";
        final String ERROR = "/img/error.jpg";
        final String MAP = "/img/map.jpg";



        //Switch Case einbauen
        img = ERROR;


        //Objects
        JPanel center = new JPanel();
        JPanel west = new JPanel();
        JButton B1 = new JButton("OK");

        JLabel L1 = new JLabel("Ort 1");
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
        content = new JTextField();


        button = new JButton("Berechne MiddleMeet");

        //Set Image Background


        ImageIcon background = new ImageIcon(getClass().getResource(img));
        JLabel L3 = new JLabel(background);


        BorderLayout B = new BorderLayout();
        GridLayout G = new GridLayout(15,0);
        JFrame F = new JFrame();


        //Properties
        LResult.setFont(new Font ("Default", Font.BOLD, 18));

        F.setLayout(B);
        west.setLayout(G);
        west.add(L1);
        west.add(ort1);
        west.add(land1);
        west.add(L2);
        west.add(ort2);
        west.add(land2);
        west.add(Box.createVerticalStrut(20));
        west.add(new JSeparator(SwingConstants.HORIZONTAL));
        west.add(LResult);
        west.add(content);
        west.add(new JSeparator(SwingConstants.HORIZONTAL));
        west.add(button);
        center.add(L3);

        //Margins
        west.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(west, B.WEST);
        add(center, B.CENTER);

    }

    public JButton getButton(){
        return button;
    }

    //Manipulate view with new content
    public void setView(String text){
        content.setText(text);
    }
}