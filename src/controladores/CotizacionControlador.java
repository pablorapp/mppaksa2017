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
import modelos.Origen;
import modelos.Cotizacion;
import programas.Conexion;

/**
 *
 * @author Mauro
 */
public class CotizacionControlador {
    
    
    public static ResultSet consultaLista() throws SQLException {
        String seleccion = "SELECT tc_fec_cot, tc_cot_mon, usuar_oper, fec_oper, hora_oper, operacion FROM cotizacion order by tc_fec_cot desc";
        Conexion con = new Conexion();
        PreparedStatement ps = con.con.prepareStatement(seleccion);
        ResultSet rs = ps.executeQuery();
        return rs;
    }    
    
    
    
    public static Origen recOri(int cod){        
        Origen res = null;
        Conexion con = new Conexion();        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.con.prepareStatement("SELECT ori_codigo, ori_descri, ori_telef, ori_contac, fec_oper, usuar_oper, hora_oper, operacion FROM origen where  ori_codigo = "+cod+"  ");
            rs = ps.executeQuery();        
            if(rs.next()){
                    res = new Origen(rs.getInt("ori_codigo"),rs.getString("ori_descri"),rs.getString("ori_telef"),rs.getString("ori_contac"),rs.getString("fec_oper"),rs.getString("usuar_oper"),rs.getString("hora_oper"),rs.getString("operacion"));
            }                    
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return res;
    }        
    
    public static String adMerc(Origen tar){

        String res = "No se pudo Registrar Origen";
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{

            ps = con.con.prepareStatement("select count(*) as cant from origen where ori_codigo = ?  ");
            ps.setInt(1, tar.getOri_codigo());
            rs = ps.executeQuery();

            if(rs.next()){
                if(rs.getInt("cant")>0){
                    res = "Ya existe el registro";
                }else{
                    ps = con.con.prepareStatement("INSERT INTO origen VALUES (?, ?, ?, ?, to_date(?,'YYYY-MM-DD'), ?, ?, ?)");
                    ps.setInt(1, tar.getOri_codigo());
                    ps.setString(2, tar.getOri_descri());
                    ps.setString(3, tar.getOri_telef());
                    ps.setString(4, tar.getOri_contac());
                    ps.setString(5, tar.getFec_oper());
                    ps.setString(6, tar.getUsuar_oper());
                    ps.setString(7, tar.getHora_oper());
                    ps.setString(8, tar.getOperacion());
                    ps.execute();        
                    res = "";                       
                }             
            }             
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }    
    
    
    public static String modiOri(Origen cng){

        String res = "No se pudo Modificar Origen";
        Conexion con = new Conexion();
        PreparedStatement ps = null;

        try{

                ps = con.con.prepareStatement("UPDATE origen SET ori_descri=?, ori_telef=?, ori_contac=?, fec_oper=to_date(?,'YYYY-MM-DD'), usuar_oper=?, hora_oper=?, operacion=?  WHERE ori_codigo = ? ");
                ps.setString(1, cng.getOri_descri());
                ps.setString(2, cng.getOri_telef());
                ps.setString(3, cng.getOri_contac());
                ps.setString(4, cng.getFec_oper());
                ps.setString(5, cng.getUsuar_oper());
                ps.setString(6, cng.getHora_oper());
                ps.setString(7, cng.getOperacion());
                ps.setInt(8, cng.getOri_codigo());
                ps.execute();        
                res = "";                               
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }        
    
    public static String eliOri(int cod){
        String res = "No se pudo Eliminar Origen";
        Conexion con = new Conexion();
        PreparedStatement ps = null;         
        
        try{
            ps = con.con.prepareStatement("delete from origen WHERE ori_codigo = ? ");
            ps.setInt(1, cod);
            ps.execute();
            res = "";
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }           
        
    
}
