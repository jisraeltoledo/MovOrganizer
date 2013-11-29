/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.entities;

import java.io.File;

/**
 *
 * @author Hexe
 */
public class Movie {
    private Integer id;
    private String path;
    private String md5;
    private String imdb;
    private String name;
    private String release;
    private String imdbrating;
    private String director;
    private String poster;
    private String posteronline;
    private String plot;
    private String actors;
    private String year;
    private String genre;    

    public Movie(File f) {
        this.path = f.getPath();
    }

    public Movie() {
        
    }
    
    

    @Override
    public String toString() {
        if (name == null){
            return path;
        }
        return name +" ["+year+"]";
    }

    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the md5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * @param md5 the md5 to set
     */
    public void setMd5(String md5) {
        this.md5 = md5;
    }

    /**
     * @return the imdb
     */
    public String getImdb() {
        return imdb;
    }

    /**
     * @param imdb the imdb to set
     */
    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the release
     */
    public String getRelease() {
        return release;
    }

    /**
     * @param release the release to set
     */
    public void setRelease(String release) {
        this.release = release;
    }

    /**
     * @return the imdbrating
     */
    public String getImdbrating() {
        return imdbrating;
    }

    /**
     * @param imdbrating the imdbrating to set
     */
    public void setImdbrating(String imdbrating) {
        this.imdbrating = imdbrating;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the poster
     */
    public String getPoster() {
        return poster;
    }

    /**
     * @param poster the poster to set
     */
    public void setPoster(String poster) {
        this.poster = poster;
    }

    /**
     * @return the posteronline
     */
    public String getPosteronline() {
        return posteronline;
    }

    /**
     * @param posteronline the posteronline to set
     */
    public void setPosteronline(String posteronline) {
        this.posteronline = posteronline;
    }

    /**
     * @return the plot
     */
    public String getPlot() {
        return plot;
    }

    /**
     * @param plot the plot to set
     */
    public void setPlot(String plot) {
        this.plot = plot;
    }

    /**
     * @return the actors
     */
    public String getActors() {
        return actors;
    }

    /**
     * @param actors the actors to set
     */
    public void setActors(String actors) {
        this.actors = actors;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
