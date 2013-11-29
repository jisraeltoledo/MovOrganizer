/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hexe
 */
public class DAO {
    
    
    
}


class Conexion {
    private static Connection conexion;
    public  static Connection get (){
        try {
            if (conexion != null){
                if (!conexion.isClosed()){
                    return conexion;
                }
            }
                    
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:"+Config.RUTA_DB);
            return conexion;
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexión  a la BD", 
                                          "Error en la conexión", JOptionPane.ERROR_MESSAGE);
            System.err.println (ex);
            return null;
        }
    }
    
}