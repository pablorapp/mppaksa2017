/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pablo
 */
public class Conexion {
    String url = "jdbc:postgresql://localhost:5432/paksa";
    public static Connection  conn;
    public Conexion(){
            try {
                if(conn!=null){
                    if(conn.isValid(1000)){
                        Class.forName("org.postgresql.Driver");
                        conn = DriverManager.getConnection(url,  "postgres", "123");
                    }
                }else{
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection(url,  "postgres", "123");
                }
                
            } catch (SQLException e) {
                System.out.println("Ocurrio un error : "+e.getMessage());
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
