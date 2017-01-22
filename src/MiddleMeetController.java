

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiddleMeetController {


    private MiddleMeetView mv;
    private MiddleMeetModelTEMP mm;
    private ActionListener actionListener;
    private String text ="blabla";



    /**
     * Konstruktor
     *
     * @param mv - Referenz auf die Repraesentation
     * @param mm - Referenz auf den Controller
     */


    public MiddleMeetController(MiddleMeetView mv, MiddleMeetModelTEMP mm) {
        this.mv = mv;
        this.mm = mm;
    }

    public void control() {
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                mv.setView("blabla");
            }
        };
        mv.getButton().addActionListener(actionListener);
        System.out.println("well done");

    }

    private void calculate() {
        mm.km();
        mv.setView(text);
        System.out.println("blablaaa");
    }
}

