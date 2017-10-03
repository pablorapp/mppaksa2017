/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import programas.Conexion;

/**
 *
 * @author Mauro
 */
public class TarifasControlador {
    
    public static ResultSet consultaLista() throws SQLException {
        String seleccion = "SELECT tt_cod_cab, tt_codigo, tt_tarifa1, tt_tarifa2, tt_tarifa3, tt_observ, tt_abrevia, tt_des_for, tt_des_fob, tt_agrupar, tt_con_fec, usuar_oper FROM tarifa order by tt_cod_cab,tt_codigo";
        Conexion con = new Conexion();

        PreparedStatement ps = con.con.prepareStatement(seleccion);

        ResultSet rs = ps.executeQuery();

        return rs;
    }    
    
    public static ArrayList<String> consulta() throws SQLException {
        Conexion con = new Conexion();    
        String seleccion = "SELECT tt_cod_cab, tt_codigo FROM tarifa order by tt_cod_cab,tt_codigo";
        PreparedStatement ps = con.con.prepareStatement(seleccion);
        ArrayList<String> ls = new ArrayList<>();

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            ls.add(rs.getString("tt_cod_cab")+"-"+rs.getString("tt_codigo"));
        }
    return ls;
    }    
    
}
