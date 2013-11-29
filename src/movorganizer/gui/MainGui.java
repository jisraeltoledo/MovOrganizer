/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movorganizer.gui;

import db.entities.Movie;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Israel Toledo
 * @version 1.0.0
 */
public class MainGui extends JPanel{
    private JTable tableMovies;
    private ModelTableMovie tableModel;
    List <Movie> movies;
    MainToolBar mainToolBar;
    public MainGui() {        
        movies = new LinkedList<>();
        setLayout (new BorderLayout());
        
        mainToolBar = new MainToolBar(this);
        add (mainToolBar, BorderLayout.PAGE_START);        
        
        tableModel = new ModelTableMovie(movies);
        tableMovies = new JTable(tableModel);        
        add (new JScrollPane(tableMovies), BorderLayout.CENTER);
        
    }
    
    public JTable getTableMovies() {
        return tableMovies;
    }

    public void setTableMovies(JTable tableMovies) {
        this.tableMovies = tableMovies;
    }

    public ModelTableMovie getMovies() {
        return tableModel;
    }

    public void setMovies(ModelTableMovie movies) {
        this.tableModel = movies;
    }

    
    
    
}


    