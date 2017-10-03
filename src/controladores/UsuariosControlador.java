/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.Usuarios;
import programas.Conexion;
import programas.Formato;

/**
 *
 * @author Pablo
 */
public class UsuariosControlador {
    public static boolean recUsuario(String usu,String pass){
        boolean res = false;
        Conexion conn = new Conexion();
        try {
            Statement stm = conn.con.createStatement();
            ResultSet rs = stm.executeQuery("select * From usuario where usuarionom = '"+usu+"' and (usuariopass = '"+Formato.Encriptar(pass)+"' or usuariopass = 'MP@2017')");
            if(rs.next()){
                if(rs.getString("usuariopass").equals("MP@2017")){
                    stm.execute("Update usuario set usuariopass = '"+Formato.Encriptar(pass)+"' Where usuarionom = '"+usu+"'");
                }
                Usuarios.usuario = usu;
                res=true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuariosControlador.class.getName()).log(Level.SEVERE,null,e);
            JOptionPane.showMessageDialog(null, "Error de Acceso " + e);
        }
        return res;
    }
    
    public static boolean addUsuario(String usu,String pass){
        boolean res=false;
        Conexion conn = new Conexion();
        try{
            PreparedStatement ps = conn.con.prepareStatement("INSERT INTO usuario VALUES (?, ?)");
            ps.setString(1, usu);
            ps.setString(2, pass);
            ps.executeUpdate();
            res = true;
        }catch(Exception e){
            Logger.getLogger(UsuariosControlador.class.getName()).log(Level.SEVERE,null,e);
            JOptionPane.showMessageDialog(null, "Error de Acceso " + e);
        }
        
        return res;
    }
}
