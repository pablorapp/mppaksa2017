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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Cotizacion;
import modelos.Feriados;
import programas.Conexion;

/**
 *
 * @author Mauro
 */
public class FeriadosControlador {
    
    public static ArrayList<String> consulta() throws SQLException {
        Conexion con = new Conexion();    
        String seleccion = "SELECT date_part('year',tf_fec_nh) as tf_fec_nh FROM tferiado order by date_part('year',tf_fec_nh) desc";
        PreparedStatement ps = con.con.prepareStatement(seleccion);
        ArrayList<String> ls = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ls.add(rs.getString("tf_fec_nh"));
        }
    return ls;
    }    
    
    public static ResultSet consultaLista(Object Combo) throws SQLException {
        String seleccion = "SELECT to_char(tf_fec_nh,'dd-MM-yyyy') as tf_fec_nh,tf_descrip FROM tferiado where  date_part('year',tf_fec_nh) = "+Combo+" order by date_part('year',tf_fec_nh) desc";
        Conexion con = new Conexion();
        PreparedStatement ps = con.con.prepareStatement(seleccion);
        ResultSet rs = ps.executeQuery();
        return rs;
    }       
    
    public static Feriados recFer(String fec){        
        Feriados res = null;
        Conexion con = new Conexion();        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.con.prepareStatement("SELECT to_char(tf_fec_nh,'dd-MM-yyyy') as tf_fec_nh, tf_descrip, usuar_oper, fec_oper, hora_oper, operacion FROM tferiado where  to_char(tf_fec_nh,'dd-MM-yyyy') = ?  ");
            ps.setString(1, fec);
            rs = ps.executeQuery();        
            if(rs.next()){
                    res = new Feriados(rs.getString("tf_fec_nh"),rs.getString("tf_descrip"),rs.getString("usuar_oper"),rs.getString("fec_oper"),rs.getString("hora_oper"),rs.getString("operacion"));
            }            
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return res;
    }        
    
    public static String addFeri(Feriados fer){

        String res = "No se pudo Registrar Feriado";
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{

            ps = con.con.prepareStatement("select count(*) as cant from tferiado where to_char(tf_fec_nh,'dd-MM-yyyy') = ?  ");
            ps.setString(1, fer.getTf_fec_nh());
            rs = ps.executeQuery();

            if(rs.next()){
                if(rs.getInt("cant")>0){
                    res = "Ya existe el registro";
                }else{
                    ps = con.con.prepareStatement("INSERT INTO tferiado VALUES (to_date(?,'YYYY-MM-DD'), ?, ?, to_date(?,'YYYY-MM-DD'), ?, ?)");
                    ps.setString(1, fer.getTf_fec_nh());
                    ps.setString(2, fer.getTf_descrip());
                    ps.setString(3, fer.getUsuar_oper());
                    ps.setString(4, fer.getFec_oper());
                    ps.setString(5, fer.getHora_oper());
                    ps.setString(6, fer.getOperacion());
                    ps.execute();        
                    res = "";                       
                }             
            }             
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }    
    
    
    public static String modiFeri(Feriados fer){

        String res = "No se pudo Modificar Feriado";
        Conexion con = new Conexion();
        PreparedStatement ps = null;

        try{

                ps = con.con.prepareStatement("UPDATE tferiado SET  tf_descrip=?, usuar_oper=?, fec_oper=to_date(?,'YYYY-MM-DD'), hora_oper=?, operacion=? where  to_char(tf_fec_nh,'dd-MM-yyyy') = ? ");
                ps.setString(1, fer.getTf_descrip());
                ps.setString(2, fer.getUsuar_oper());
                ps.setString(3, fer.getFec_oper());
                ps.setString(4, fer.getHora_oper());
                ps.setString(5, fer.getOperacion());
                ps.setString(6, fer.getTf_fec_nh());
                ps.execute();        
                res = "";                               
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }        
    
    public static String eliFer(String fec){
        String res = "No se pudo Eliminar Cotizacion";
        Conexion con = new Conexion();
        PreparedStatement ps = null;                 
        
        try{
            ps = con.con.prepareStatement("delete from tferiado where to_char(tf_fec_nh,'dd-MM-yyyy') = ? ");
            ps.setString(1, fec);
            ps.execute();
            res = "";
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }         
    
    
}
