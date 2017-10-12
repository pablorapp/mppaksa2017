/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Mercaderias;
import programas.Conexion;

/**
 *
 * @author Mauro
 */
public class MercaderiasControlador {
    
    public static ResultSet consultaLista() throws SQLException {
        String seleccion = "SELECT tm_codigo, tm_descrip, usuar_oper, fec_oper, hora_oper, operacion FROM tmercaderias order by tm_codigo";
        Conexion con = new Conexion();
        PreparedStatement ps = con.con.prepareStatement(seleccion);
        ResultSet rs = ps.executeQuery();
        return rs;
    }    
    
    public static Mercaderias recMerc(int cod){        
        Mercaderias res = null;
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.con.prepareStatement("SELECT tm_codigo, tm_descrip, usuar_oper, to_char(fec_oper,'yyyy-MM-dd') as fec_oper, hora_oper, operacion FROM tmercaderias where  tm_codigo = "+cod+"  ");
            rs = ps.executeQuery();        
            if(rs.next()){
                    res = new Mercaderias(rs.getInt("tm_codigo"),rs.getString("tm_descrip"),rs.getString("usuar_oper"),rs.getString("fec_oper"),rs.getString("hora_oper"),rs.getString("operacion"));
            }                    
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return res;
    }        
    
    public static String adMerc(Mercaderias tar){

        String res = "No se pudo Registrar Mercadería";
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{

            ps = con.con.prepareStatement("select count(*) as cant from tmercaderias where tm_codigo = ?  ");
            ps.setInt(1, tar.getTm_codigo());
            rs = ps.executeQuery();

            if(rs.next()){
                if(rs.getInt("cant")>0){
                    res = "Ya existe el registro";
                }else{
                    ps = con.con.prepareStatement("INSERT INTO tmercaderias VALUES (?, ?, ?, to_date(?,'YYYY-MM-DD'), ?, ?)");
                    ps.setInt(1, tar.getTm_codigo());
                    ps.setString(2, tar.getTm_descrip());
                    ps.setString(3, tar.getUsuar_oper());
                    ps.setString(4, tar.getFec_oper());
                    ps.setString(5, tar.getHora_oper());
                    ps.setString(6, tar.getOperacion());
                    ps.execute();        
                    res = "";                       
                }             
            }             
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }    
    
    
    public static String modiMerc(Mercaderias cng){

        String res = "No se pudo Modificar Mercadería";
        Conexion con = new Conexion();
        PreparedStatement ps = null;

        try{

                ps = con.con.prepareStatement("UPDATE tmercaderias SET tm_descrip=?, usuar_oper=?, fec_oper=to_date(?,'YYYY-MM-DD'), hora_oper=?, operacion=? WHERE tm_codigo = ? ");
                ps.setString(1, cng.getTm_descrip());
                ps.setString(2, cng.getUsuar_oper());
                ps.setString(3, cng.getFec_oper());
                ps.setString(4, cng.getHora_oper());
                ps.setString(5, cng.getOperacion());
                ps.setInt(6, cng.getTm_codigo());
                ps.execute();        
                res = "";                               
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }        
    
    public static String eliMerc(int cod){
        String res = "No se pudo Eliminar Mercadería";
        Conexion con = new Conexion();
        PreparedStatement ps = null;         
        
        try{
            ps = con.con.prepareStatement("delete from tmercaderias WHERE tm_codigo = ? ");
            ps.setInt(1, cod);
            ps.execute();
            res = "";
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }       
    
}
