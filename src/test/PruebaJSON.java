/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.Set;
import javax.json.Json;
import javax.json.stream.JsonParser;

/**
 *
 * @author Hexe
 */
public class PruebaJSON {

    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException, IOException {

        String string = "http://api.rottentomatoes.com/api/public/v1.0/movies.json?"
                + "apikey=" + config.Config.RottenTomatoesAPIKey
                + "&q=" + URLEncoder.encode("Star wars", "UTF-8").toString();

        System.out.println(string);
        URL url = new URL(string);
        Scanner sc = new Scanner(url.openStream());
        String content = "";
        while (sc.hasNext()) {
            content += sc.nextLine();
        }
        JsonParser parser = Json.createParser(new StringReader(content));
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            System.out.println(event);
            switch (event) {
                case START_ARRAY:
                case END_ARRAY:
                case START_OBJECT:
                case END_OBJECT:
                case VALUE_FALSE:
                case VALUE_NULL:
                case VALUE_TRUE:
                    System.out.println(event.toString());
                    break;
                case KEY_NAME:
                    System.out.print(event.toString() + " "
                            + parser.getString() + " - ");
                    break;
                case VALUE_STRING:
                case VALUE_NUMBER:
                    System.out.println(event.toString() + " "
                            + parser.getString());
                    break;
            }
        }
////        System.out.println(content);
//        JSONObject jobj = new JSONObject(content);
//        Set <String> keys = jobj.keySet();
//        JSONArray movies = jobj.getJSONArray("movies");
//        
//        movies.get(0)
    }
}
