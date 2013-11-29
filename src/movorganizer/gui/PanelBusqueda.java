/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movorganizer.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Hexe
 */
public class PanelBusqueda extends JPanel{

    private JTextField txtBusca;
    public PanelBusqueda() {        
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension (300, 500));
        txtBusca = new JTextField (20);        
        add (txtBusca);
    }
    
    public void add (PanelMovie newMovie){
        super.add (newMovie);
        revalidate ();
        repaint ();
    }

    public JTextField getTxtBusca() {
        return txtBusca;
    }

    public void setTxtBusca(JTextField txtBusca) {
        this.txtBusca = txtBusca;
    }
    
    
}
