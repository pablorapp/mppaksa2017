/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Pablo
 */
public class Usuarios {
    
    public static String usuario;
    String usunom;
    String usupass;
    public static void AsignUsu(String usu){
        usuario = usu;
    }
    public Usuarios(String usunom,String usupass){
        this.usunom = usunom;
        this.usupass = usupass;
    }

    public String getUsunom() {
        return usunom;
    }

    public void setUsunom(String usunom) {
        this.usunom = usunom;
    }

    public String getUsupass() {
        return usupass;
    }

    public void setUsupass(String usupass) {
        this.usupass = usupass;
    }
    
}
