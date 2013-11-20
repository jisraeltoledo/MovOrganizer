/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 *
 * @author Hexe
 */
public class PruebaJSON {
    
    public static void main (String [] args) throws MalformedURLException{
        
        String string = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?"
                + "apikey="+config.Config.RottenTomatoesAPIKey
                + "&q="+("Star wars").toString();
        
        System.out.println(string);
        URL url = new URL (string);
        
    }
}
