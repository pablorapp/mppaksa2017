/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import modelos.Actas;
import programas.Conexion;

/**
 *
 * @author Pablo
 */
public class ActasControlador {
    public static List<Actas> recListActaTbl(){
        List<Actas> acts = new ArrayList<>();
        Conexion conn = new Conexion();
        try {
            Statement stm = conn.con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT ma_nro_act, ma_hora, to_char(ma_fec_act,'YYYY-MM-DD') as ma_fec_act, ma_nro_ing\n" +
                        "	FROM public.actas\n" +
                        "    Group by ma_nro_act, ma_hora, ma_fec_act, ma_nro_ing\n" +
                        "    order by ma_nro_act DESC");
            while(rs.next()){
                acts.add(new Actas(rs.getInt("ma_nro_act"), rs.getString("ma_hora"), rs.getString("ma_fec_act"), 0, 0
                        , 0, 0, 0, 0, "", rs.getInt("ma_nro_ing"), 0, "", "", 0, "", "", "", 0, 0, "", "", 0, 0, 0, 0, "", "", 0, "", 0, 0, 0, 0, 0, "", "", 0, 0, "", "", "", "", "", "", "", "", "", ""));
            }
            stm.close();
            rs.close();
        } catch (SQLException e) {
            Logger.getLogger(ActasControlador.class.getName()).log(Level.SEVERE,null,e);
        }
        return acts;
    }
    public static int recUtlNroAct(){
        int nro = 0;
        Conexion conn = new Conexion();
        try {
            ResultSet rs;
            try (Statement stm = conn.con.createStatement()) {
                rs = stm.executeQuery("SELECT case when max(ma_nro_act) is null then 1 else max(ma_nro_act)+1 end as nro FROM actas");
                if(rs.next()){
                    nro = rs.getInt("nro");
                }
                stm.close();
            }
            rs.close();
        } catch (SQLException e) {
            Logger.getLogger(ActasControlador.class.getName()).log(Level.SEVERE,null,e);
        }
        return nro;
    }
}
