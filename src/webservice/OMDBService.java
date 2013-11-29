/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import db.entities.Movie;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
/**
 *
 * @author Hexe
 */
public class OMDBService implements WebService{

    final static String urlString =  "http://www.omdbapi.com/?";            
    URL url;

    public OMDBService()  {
        try {
            url = new URL (urlString);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(ex);
        }
    }

    @Override
    public Movie getMovie(String id) {
        return null;
    }

    @Override
    public List<Movie> findMovies(String find) {
        List <Movie> movies = new LinkedList<>();
        SAXBuilder builder = new SAXBuilder();
        try {            
            Document document = (Document) builder.build(url.openStream());
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("Movie");

            for (int i = 0; i < list.size(); i++) {

                Movie m = new Movie ();                
                Element node = (Element) list.get(i);

                m.setName(node.getChildText("Title"));
                m.setYear(node.getChildText("Year"));
                m.setImdb(node.getChildText("imdbID"));
                
                movies.add(m);
            }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al buscar la película en internet", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(ex);
        }   
        return movies;
    }
    
    
    
}
