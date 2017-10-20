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
import modelos.Cotizacion;
import programas.Conexion;

/**
 *
 * @author Mauro
 */
public class CotizacionControlador {
    
    
    public static ResultSet consultaLista() throws SQLException {
        String seleccion = "SELECT  to_char(tc_fec_cot,'dd-MM-yyyy') as tc_fec_cot, tc_cot_mon, usuar_oper, fec_oper, hora_oper, operacion FROM cotizacion order by date_part('year',tc_fec_cot) desc";
        Conexion con = new Conexion();
        PreparedStatement ps = con.con.prepareStatement(seleccion);
        ResultSet rs = ps.executeQuery();
        return rs;
    }    
    
    
    
    public static Cotizacion recCtz(String fec){        
        Cotizacion res = null;
        Conexion con = new Conexion();        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.con.prepareStatement("SELECT  to_char(tc_fec_cot,'dd-MM-yyyy') as tc_fec_cot, tc_cot_mon, usuar_oper, fec_oper, hora_oper, operacion FROM cotizacion where  to_char(tc_fec_cot,'dd-MM-yyyy') = ?  ");
            ps.setString(1, fec);
            rs = ps.executeQuery();        
            if(rs.next()){
                    res = new Cotizacion(rs.getString("tc_fec_cot"),rs.getDouble("tc_cot_mon"),rs.getString("usuar_oper"),rs.getString("fec_oper"),rs.getString("hora_oper"),rs.getString("operacion"));
            }            
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return res;
    }        
    
    public static String addCotiza(Cotizacion cot){

        String res = "No se pudo Registrar Cotizacion";
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{

            ps = con.con.prepareStatement("select count(*) as cant from cotizacion where to_char(tc_fec_cot,'dd-MM-yyyy') = ?  ");
            ps.setString(1, cot.getTc_fec_cot());
            rs = ps.executeQuery();

            if(rs.next()){
                if(rs.getInt("cant")>0){
                    res = "Ya existe el registro";
                }else{
                    ps = con.con.prepareStatement("INSERT INTO cotizacion VALUES (to_date(?,'YYYY-MM-DD'), ?, ?, to_date(?,'YYYY-MM-DD'), ?, ?)");
                    ps.setString(1, cot.getTc_fec_cot());
                    ps.setDouble(2, cot.getTc_cot_mon());
                    ps.setString(3, cot.getUsuar_oper());
                    ps.setString(4, cot.getFec_oper());
                    ps.setString(5, cot.getHora_oper());
                    ps.setString(6, cot.getOperacion());
                    ps.execute();        
                    res = "";                       
                }             
            }             
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }    
    
    
    public static String modiCtz(Cotizacion cot){

        String res = "No se pudo Modificar Cotizacion";
        Conexion con = new Conexion();
        PreparedStatement ps = null;

        try{

                ps = con.con.prepareStatement("UPDATE cotizacion SET  tc_cot_mon=?, usuar_oper=?, fec_oper=to_date(?,'YYYY-MM-DD'), hora_oper=?, operacion=? WHERE tc_fec_cot = ? ");
                ps.setDouble(1, cot.getTc_cot_mon());
                ps.setString(2, cot.getUsuar_oper());
                ps.setString(3, cot.getFec_oper());
                ps.setString(4, cot.getHora_oper());
                ps.setString(5, cot.getOperacion());
                ps.setString(6, cot.getTc_fec_cot());
                ps.execute();        
                res = "";                               
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }        
    
    public static String eliCoti(String fec){
        String res = "No se pudo Eliminar Cotizacion";
        Conexion con = new Conexion();
        PreparedStatement ps = null;         
        String dia = fec.substring(0, 2);
        String mes = fec.substring(3,5);
        String anho = fec.substring(6, 10);
        String fechaV = anho + "-" + mes + "-" + dia;              
        
        try{
            ps = con.con.prepareStatement("delete from cotizacion where to_char(tc_fec_cot,'dd-MM-yyyy') = ? ");
            ps.setString(1, fechaV);
            ps.execute();
            res = "";
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }           
        
    
}
