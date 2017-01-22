

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiddleMeetController {



        private MiddleMeetView mv;
        private MiddleMeetModel mm;
        private ActionListener actionListener;


         /** Konstruktor
         *
         * @param mv - Referenz auf die Repraesentation
         * @param mm - Referenz auf den Controller
         *
*/


        public MiddleMeetController(MiddleMeetView mv, MiddleMeetModel mm) {
            this.mv = mv;
            this.mm = mm;
        }

        public void control(){
            actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    calculate();
                }
            };
            mv.getButton().addActionListener(actionListener);
            System.out.println("well done");

    }

    private void calculate() {
        mm.km();
        mv.setText(Integer.toString(Integer.parseInt(mm.time())));
    }
}

