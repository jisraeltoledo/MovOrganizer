/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movorganizer.gui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Hexe
 */
public class IMDBQueryPanel extends JPanel{

    URL webService;
    public IMDBQueryPanel() {
        try {
            webService = new URL ("http://mymovieapi.com/");
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectarse al servicio web");
        }                        
        
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    
    
    
}
