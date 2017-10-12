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
import modelos.Tarifas;
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
    
    
    public static Tarifas recTar(int cod,int cod2){        
        Tarifas res = null;
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.con.prepareStatement("select tt_cod_cab, tt_codigo, tt_tarifa1, tt_tarifa2, tt_tarifa3, tt_observ, tt_abrevia, tt_des_for, tt_des_fob, tt_agrupar"
                    + ", tt_con_fec, usuar_oper from tarifa where tt_cod_cab = "+cod+" and  tt_codigo = "+cod2+" ");
            rs = ps.executeQuery();        
            if(rs.next()){
                    res = new Tarifas(rs.getInt("tt_cod_cab"),rs.getInt("tt_codigo"),rs.getInt("tt_tarifa1"),rs.getInt("tt_tarifa2"),rs.getInt("tt_tarifa3"),rs.getString("tt_observ"),
                    rs.getString("tt_abrevia"),rs.getString("tt_des_for"),rs.getInt("tt_des_fob"),rs.getString("tt_agrupar"),rs.getString("tt_con_fec"),rs.getString("usuar_oper"));
            }                    
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return res;
    }    
    

    public static String adConsig(Tarifas tar){

        String res = "No se pudo Registrar Tarifa";
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{

            ps = con.con.prepareStatement("select count(*) as cant from tarifa where tt_cod_cab = " +tar.getTt_cod_cab()+" and tt_codigo = "+tar.getTt_codigo()+"  ");
            rs = ps.executeQuery();

            if(rs.next()){
                if(rs.getInt("cant")>0){
                    res = "Ya existe el registro";
                }else{
                    ps = con.con.prepareStatement("INSERT INTO tarifa VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    ps.setInt(1, tar.getTt_cod_cab());
                    ps.setInt(2, tar.getTt_codigo());
                    ps.setInt(3, tar.getTt_tarifa1());
                    ps.setInt(4, tar.getTt_tarifa2());
                    ps.setInt(5, tar.getTt_tarifa3());
                    ps.setString(6, tar.getTt_observ());
                    ps.setString(7, tar.getTt_abrevia());
                    ps.setString(8, tar.getTt_des_for());
                    ps.setInt(9, tar.getTt_des_fob());
                    ps.setString(10, tar.getTt_agrupar());
                    ps.setString(11, tar.getTt_con_fec());
                    ps.setString(12, tar.getUsuar_oper());
                    ps.execute();        
                    res = "";                       
                }             
            }             
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public static String modiConsig(Tarifas cng){

        String res = "No se pudo Modificar Consignatario";
        Conexion con = new Conexion();
        PreparedStatement ps = null;

        try{

                ps = con.con.prepareStatement("UPDATE tarifa SET tt_tarifa1=?, tt_tarifa2=?, tt_tarifa3=?, tt_observ=?, tt_abrevia=?, tt_des_for=?, tt_des_fob=?, tt_agrupar=?, tt_con_fec=?, usuar_oper=? WHERE  tt_cod_cab = ? and tt_codigo = ? ");
                ps.setInt(1, cng.getTt_tarifa1());
                ps.setInt(2, cng.getTt_tarifa2());
                ps.setInt(3, cng.getTt_tarifa3());
                ps.setString(4, cng.getTt_observ());
                ps.setString(5, cng.getTt_abrevia());
                ps.setString(6, cng.getTt_des_for());
                ps.setInt(7, cng.getTt_des_fob());
                ps.setString(8, cng.getTt_agrupar());
                ps.setString(9, cng.getTt_con_fec());
                ps.setString(10, cng.getUsuar_oper());
                ps.setInt(11, cng.getTt_cod_cab());
                ps.setInt(12, cng.getTt_codigo());
                ps.execute();        
                res = "";                               
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }    
    
    
    public static String eliTarif(String cod){
        String res = "No se pudo Eliminar Tarifa";
        Conexion con = new Conexion();
        PreparedStatement ps = null;     
        int cod1 = Integer.parseInt(cod.split("-")[0]);
        int cod2 = Integer.parseInt(cod.split("-")[1]);        
        
        try{
            ps = con.con.prepareStatement("delete from tarifa WHERE  tt_cod_cab = ? and tt_codigo = ? ");
            ps.setInt(1, cod1);
            ps.setInt(2, cod2);
            ps.execute();
            res = "";
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }        
    
    
}
