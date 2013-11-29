/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movorganizer.gui;

import workers.BuscaMovie;
import db.entities.Movie;
import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    PanelBusqueda panelBusqueda;
    public MainGui() {        
        movies = new LinkedList<>();
        setLayout (new BorderLayout());
        
        mainToolBar = new MainToolBar(this);
        add (mainToolBar, BorderLayout.PAGE_START);        
        
        tableModel = new ModelTableMovie(movies);
        tableMovies = new JTable(tableModel);        
        
        tableMovies.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                int idx = tableMovies.getSelectedRow();
                new BuscaMovie (panelBusqueda, movies.get(idx));
            }
        });
        
        add (new JScrollPane(tableMovies), BorderLayout.CENTER);
        
        panelBusqueda = new PanelBusqueda();
        
        add (new JScrollPane(panelBusqueda), BorderLayout.LINE_END);
        
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


    