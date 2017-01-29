import javax.swing.*;


public class MiddleMeet {

    public static void main(String[] args) {
        MiddleMeetView mv = new MiddleMeetView();

        mv.setTitle("MiddleMeet");
        mv.setSize(1050, 680);
        mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mv.setVisible(true);
    }
}