/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movorganizer.gui;

import db.entities.Movie;
import java.util.LinkedList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Hexe
 */
public class ModelTableMovie extends AbstractTableModel{

    List <Movie> movies;

    public ModelTableMovie(List<Movie> movies) {
        this.movies = movies;
    }    
    
    public void add (Movie m){
        movies.add(m);
        fireTableRowsInserted(movies.size(), movies.size ());
    }
    
    @Override
    public int getRowCount() {
        if (movies == null)
            return 0;
        return movies.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return "Path";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return movies.get (rowIndex).getPath();
    }

}
