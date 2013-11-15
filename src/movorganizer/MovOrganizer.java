/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movorganizer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import movorganizer.gui.MainGui;

/**
 *
 * @author Hexe
 */
public class MovOrganizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame ventana = new JFrame("Movie Organizer");
                ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                ventana.setContentPane(new MainGui());
                ventana.pack ();
                ventana.setVisible(true);
            }
        });
        
   }
}
