/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workers;

import db.entities.Movie;
import java.net.URL;
import java.util.List;
import javax.swing.SwingWorker;
import movorganizer.gui.PanelBusqueda;
import movorganizer.gui.PanelMovie;
import webservice.OMDBService;
import webservice.WebService;

/**
 *
 * @author Hexe
 */
public class BuscaMovie extends SwingWorker<PanelBusqueda, Movie> {

    PanelBusqueda panelBusqueda;
    Movie movieToFind;
    List <Movie> lista;
    String query;
    public BuscaMovie(PanelBusqueda panelBusqueda, Movie get) {
        this.panelBusqueda = panelBusqueda;
        movieToFind = get;
    }

    @Override
    protected PanelBusqueda doInBackground() throws Exception {
        WebService service =  new OMDBService();
        String ruta = movieToFind.getPath();
        String fileSeparator = System.getProperty("file.separator");
        ruta = ruta.substring(ruta.lastIndexOf(fileSeparator)+1);        
        String [] chunks = ruta.split("[\\W]");
        query = "";
        for (int i = 0; i<chunks.length && i<3; i++){
            query += chunks[i];
        }
        lista = service.findMovies(ruta);        
        return panelBusqueda;
    }

    @Override
    protected void done() {
        panelBusqueda.getTxtBusca().setText(query);
        for (Movie m : lista){
            panelBusqueda.add(new PanelMovie(m));
        }
        panelBusqueda.revalidate();
    }
    
    
}
