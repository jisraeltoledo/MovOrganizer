/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workers;

import db.entities.Movie;
import java.io.File;
import java.util.List;
import java.util.Stack;
import javax.swing.SwingWorker;
import movorganizer.gui.MainGui;
import movorganizer.gui.ModelTableMovie;

/**
 *
 * @author Hexe
 */
public class AddMovies extends SwingWorker<ModelTableMovie, Movie> {

    ModelTableMovie model;
    MainGui gui;
    File dir;

    public AddMovies(File f, MainGui gui) {
        this.model = gui.getMovies();
        dir = f;
        this.gui = gui;
    }    
    
    @Override
    protected ModelTableMovie doInBackground() throws Exception {        
        Stack <File> pila = new Stack<>();
        pila.push(dir);
        
        while (!pila.isEmpty()){
            File d = pila.pop();
            File [] files = d.listFiles();
            for (File f : files){
                if (f.isDirectory())
                    pila.push(f);
                if (f.isFile() && isMovie(f)){
                    Movie m = new Movie (f);
                    publish(m);
                }
            }
        }
        return model;
    }

    @Override
    protected void process(List<Movie> chunks) {
        for (Movie m : chunks){
            System.out.println("Añadiendo"+m);
            model.add(m);
        }
        gui.revalidate();
    }

    

    
    
    private boolean isMovie(File f) {
        if (f.getName().endsWith(".avi") ||
            f.getName().endsWith(".mkv") ||
            f.getName().endsWith(".mov") ||
            f.getName().endsWith(".mp4") ||
            f.getName().endsWith(".mpg") ||
            f.getName().endsWith(".mpeg") ||
            f.getName().endsWith(".rmvb")            
           )
            return true;
        return false;
    }

    
}
