/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import db.entities.Movie;
import java.util.List;

/**
 *
 * @author Hexe
 */
public interface WebService {
    
    Movie getMovie (String id);
    List<Movie> findMovies (String find);
}
