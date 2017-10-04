/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import programas.Conexion;
/**
 *
 * @author Mauro
 */
public class ConsignatariosControlador {

    public static ResultSet consultaLista() throws SQLException {
        String seleccion = "SELECT cnruc,cnnombre,cndireccion,cntelefono,cncodcab,cncodtar from Consignatario order by cnnombre ";
        Conexion con = new Conexion();
        PreparedStatement ps = con.con.prepareStatement(seleccion);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
}
