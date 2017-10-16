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
import modelos.Consignatarios;
import programas.Conexion;
/**
 *
 * @author Mauro
 */
public class ConsignatariosControlador {

    public static ResultSet consultaLista() throws SQLException {
        String seleccion = "SELECT consig_id,cnruc,cnnombre,cndireccion,cntelefono,cncodcab,cncodtar from Consignatario order by cnnombre ";
        Conexion con = new Conexion();
        PreparedStatement ps = con.con.prepareStatement(seleccion);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public static Consignatarios recConsig(int cod){        
        Consignatarios res = null;
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.con.prepareStatement("select cncodigo,cnnombre, cnabrevia, cndireccion, cntelefono, cnruc, cnusuario, to_char(cnfecent,'yyyy-MM-dd') as cnfecent, cnhoraent,"
                            + " cnoperacion, cncodcab, cncodtar, cncodmer,consig_id from consignatario where consig_id = "+cod+"  ");
            rs = ps.executeQuery();        
            if(rs.next()){
                    res = new Consignatarios(rs.getInt("cncodigo"),rs.getString("cnnombre"),rs.getString("cnabrevia"),rs.getString("cndireccion"),rs.getString("cntelefono")
                    , rs.getString("cnruc"),rs.getString("cnusuario"), rs.getString("cnfecent"), rs.getString("cnhoraent"), rs.getString("cnoperacion"), rs.getInt("cncodcab")
                    , rs.getInt("cncodtar"), rs.getInt("cncodmer"), rs.getInt("consig_id"));
            }                    
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return res;
    }
    
    public static String adConsig(Consignatarios cng){

        String res = "No se pudo Registrar Consignatario";
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;

        try{
            ps = con.con.prepareStatement("select max(cncodigo) + 1 as max from consignatario");
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt("max");  
            }

            ps = con.con.prepareStatement("select count(*) as cant from consignatario where consig_id = " +id+" ");
            rs = ps.executeQuery();

            if(rs.next()){
                if(rs.getInt("cant")>0){
                    res = "Ya existe el registro";
                }else{
                    ps = con.con.prepareStatement("INSERT INTO consignatario(cncodigo,cnnombre, cnabrevia, cndireccion, cntelefono, cnruc, cnusuario, cnfecent, cnhoraent,"
                            + " cnoperacion, cncodcab, cncodtar, cncodmer,consig_id)VALUES (?, ?, ?, ?, ?, ?, ?, to_date(?,'YYYY-MM-DD'), ?, ?, ?, ?, ?,?)");
                    ps.setInt(1, id);
                    ps.setString(2, cng.getCnnombre());
                    ps.setString(3, cng.getCnabrevia());
                    ps.setString(4, cng.getCndireccion());
                    ps.setString(5, cng.getCntelefono());
                    ps.setString(6, cng.getCnruc());
                    ps.setString(7, cng.getCnusuario());                    
                    ps.setString(8, cng.getCnfecent());
                    ps.setString(9, cng.getCnhoraent());
                    ps.setString(10, cng.getCnoperacion());
                    ps.setInt(11, cng.getCncodcab());
                    ps.setInt(12, cng.getCncodtar());
                    ps.setInt(13, cng.getCncodmer());
                    ps.setInt(14, id);
                    ps.execute();        
                    res = "";                       
                }             
            }             
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public static String modiConsig(Consignatarios cng){

        String res = "No se pudo Modificar Consignatario";
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = cng.getConsig_id();

        try{

                ps = con.con.prepareStatement("UPDATE consignatario SET cncodigo=?, cnnombre=?, cnabrevia=?, cndireccion=?, cntelefono=?, cnruc=?, cnusuario=?, cnfecent=to_date(?,'YYYY-MM-DD'), cnhoraent=?, cnoperacion=?, cncodcab=?, cncodtar=?, cncodmer=?, consig_id=? WHERE consig_id = " +cng.getConsig_id()+"  ");
                ps.setInt(1, id);
                ps.setString(2, cng.getCnnombre());
                ps.setString(3, cng.getCnabrevia());
                ps.setString(4, cng.getCndireccion());
                ps.setString(5, cng.getCntelefono());
                ps.setString(6, cng.getCnruc());
                ps.setString(7, cng.getCnusuario());                    
                ps.setString(8, cng.getCnfecent());
                ps.setString(9, cng.getCnhoraent());
                ps.setString(10, cng.getCnoperacion());
                ps.setInt(11, cng.getCncodcab());
                ps.setInt(12, cng.getCncodtar());
                ps.setInt(13, cng.getCncodmer());
                ps.setInt(14, id);
                ps.execute();        
                res = "";                               
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    public static String eliConsig(int cod){
        String res = "No se pudo Eliminar Consignatario";
        Conexion con = new Conexion();
        PreparedStatement ps = null;     
        
        try{
            ps = con.con.prepareStatement("delete from consignatario where consig_id = ?");
            ps.setInt(1, cod);
            ps.execute();
            res = "";
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }    
    
    public static String RecCng(int cod){
        Conexion con = new Conexion();  
        PreparedStatement ps;
        ResultSet rs;
        String codt = "";        
        
        try{            
            ps = con.con.prepareStatement("select cncodcab,cncodtar from consignatario where consig_id = "+cod+"");
            rs = ps.executeQuery();
            if(rs.next()){
                int codcab = rs.getInt("cncodcab");
                int codtar = rs.getInt("cncodtar");
                codt = codcab+"-"+codtar;
            }            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return codt;
    }
    
    
}
