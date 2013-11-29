/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movorganizer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import workers.AddMovies;

/**
 *
 * @author Hexe
 */
public class MainToolBar extends JToolBar{

    MainGui main;
    JButton addMovies;
    
    public MainToolBar(MainGui gui) {
        main = gui;
        addMovies = new JButton(
                new ImageIcon (
                getClass().getResource("/resources/add32.png")));
        
        addMovies.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    new AddMovies (jfc.getSelectedFile(), main).execute();
                }
            }
        });
        
        add (addMovies);
    }
    
    
}
