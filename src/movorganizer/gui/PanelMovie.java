/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movorganizer.gui;

import db.entities.Movie;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Hexe
 */
public class PanelMovie extends JPanel{

    Movie movie;
    
    public PanelMovie(Movie m) {
        setName (m.toString());
        System.out.println("Creando panel para pelí: "+m);
        movie = m;
        setBorder(new LineBorder (Color.BLACK, 1, true));
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblNombre = new JLabel(m.toString());
        add (lblNombre);
        setSize(lblNombre.getSize());
        setPreferredSize(lblNombre.getSize());
    }
    
    
}
