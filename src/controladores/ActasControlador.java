/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.PreparedStatement;
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
    public static List<Actas> recListActaTbl(Object year){
        List<Actas> acts = new ArrayList<>();
        Conexion conn = new Conexion();
        try {
            Statement stm = conn.con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT ma_nro_act, ma_hora, to_char(ma_fec_act,'dd-MM-yyyy') as ma_fec_act, ma_nro_ing\n" +
                        "	FROM public.actas where date_part('year',ma_fec_act) = "+year+"  \n" +
                        "    Group by ma_nro_act, ma_hora, ma_fec_act, ma_nro_ing\n" +
                        "    order by date_part('year',ma_fec_act) DESC,date_part('month',ma_fec_act) DESC,date_part('day',ma_fec_act) DESC,ma_fec_act DESC");
            while(rs.next()){
                acts.add(new Actas(rs.getInt("ma_nro_act"), rs.getString("ma_hora"), rs.getString("ma_fec_act"), 0, 0
                        , 0, 0, 0, 0, "", rs.getInt("ma_nro_ing"), 0, "", "", 0, "", "", "", 0, 0, "", "", 0, 0, 0, 0, "", "", 0, "", 0, 0, 0, 0, 0, 0, "", 0, 0, "", "", "", "", "", "", "", "", "", ""));
            }
            stm.close();
            rs.close();
        } catch (SQLException e) {
            Logger.getLogger(ActasControlador.class.getName()).log(Level.SEVERE,null,e);
        }
        return acts;
    }
    public static List<Actas> recListActaTbl2(Object year){
        List<Actas> acts = new ArrayList<>();
        Conexion conn = new Conexion();
        try {
            Statement stm = conn.con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT ma_nro_act, ma_hora, to_char(ma_fec_act,'dd-MM-yyyy') as ma_fec_act, ma_nro_ing,ma_mic_dta\n" +
                        "	FROM public.actas where date_part('year',ma_fec_act) = "+year+"  \n" +
                        "    Group by ma_nro_act, ma_hora, ma_fec_act, ma_nro_ing,ma_mic_dta\n" +
                        "    order by date_part('year',ma_fec_act) DESC,date_part('month',ma_fec_act) DESC,date_part('day',ma_fec_act) DESC,ma_fec_act DESC");
            while(rs.next()){
                acts.add(new Actas(rs.getInt("ma_nro_act"), rs.getString("ma_hora"), rs.getString("ma_fec_act"), rs.getInt("ma_mic_dta"), 0
                        , 0, 0, 0, 0, "", rs.getInt("ma_nro_ing"), 0, "", "", 0, "", "", "", 0, 0, "", "", 0, 0, 0, 0, "", "", 0, "", 0, 0, 0, 0, 0, 0, "", 0, 0, "", "", "", "", "", "", "", "", "", ""));
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
                rs = stm.executeQuery("SELECT case when max(nro_acta) is null then 1 else max(nro_acta)+1 end as nro FROM config_doc");
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
    
    public static ArrayList<String> consulta() throws SQLException {
        Conexion con = new Conexion();    
        String seleccion = "SELECT date_part('year',ma_fec_act) as ma_fec_act FROM actas order by date_part('year',ma_fec_act) desc";
        PreparedStatement ps = con.con.prepareStatement(seleccion);
        ArrayList<String> ls = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            ls.add(rs.getString("ma_fec_act"));
        }
    return ls;
    }        
    
    public static String adMerc(List<Actas> list){

        String res = "No se pudo Registrar Acta";
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        int cont = 1;
        try{
            
            for (Actas tar : list) {

                            ps = con.con.prepareStatement("INSERT INTO public.actas(\n" +
        "	ma_nro_act, ma_hora, ma_fec_act, ma_mic_dta, ma_cod_des, ma_cod_cab, ma_cod_tar, ma_cod_con, ma_cod_mer, ma_cod_per, ma_nro_ing, ma_no_inga, ma_salida, ma_des_con, ma_val_fot, ma_des_mer, ma_marcar, ma_serie, ma_nro_fac, ma_nro_fa1, ma_fec_fac, ma_hor_fac, ma_numerar, ma_con_dia, ma_monto, ma_cotisa, ma_des_tar, ma_bol_sal, ma_ext_fot, ma_orden, ma_imp_res, ma_suma, ma_sumtp, ma_iva, ma_ivatp, ma_tipo, ma_transfe, ma_cantid, ma_cod_tra, ma_dir_tra, ma_des_tra, ma_tel_tra, ma_ruc_tra, usuar_oper, fec_oper, hora_oper, operacion, ma_ver_con, observa)\n" +
        "	VALUES (?, ?, to_date(?,'YYYY-MM-DD'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,to_date(?,'YYYY-MM-DD') , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, to_date(?,'YYYY-MM-DD'), ?, ?, ?, ?)");
                            ps.setInt(1, tar.getMa_nro_act());
                            ps.setString(2, tar.getMa_hora());
                            ps.setString(3, tar.getMa_fec_act());
                            ps.setInt(4, tar.getMa_mic_dta());
                            ps.setInt(5, tar.getMa_cod_des());
                            ps.setInt(6, tar.getMa_cod_cab());
                            ps.setInt(7, tar.getMa_cod_tar());
                            ps.setInt(8, tar.getMa_cod_con());
                            ps.setInt(9, tar.getMa_cod_mer());
                            ps.setString(10, tar.getMa_cod_per());
                            ps.setInt(11, tar.getMa_nro_ing());
                            ps.setInt(12, tar.getMa_no_inga());
                            ps.setString(13, tar.getMa_salida());
                            ps.setString(14, tar.getMa_des_con());
                            ps.setDouble(15, tar.getMa_val_fot());
                            ps.setString(16, tar.getMa_des_mer());
                            ps.setString(17, tar.getMa_marcar());
                            ps.setString(18, tar.getMa_serie());
                            ps.setInt(19, tar.getMa_nro_fac());
                            ps.setInt(20, tar.getMa_nro_fa1());
                            ps.setString(21, tar.getMa_fec_fac());
                            ps.setString(22, tar.getMa_hor_fac());
                            ps.setInt(23, cont);
                            ps.setInt(24, tar.getMa_con_dia());
                            ps.setInt(25, tar.getMa_monto());
                            ps.setDouble(26, tar.getMa_cotisa());
                            ps.setString(27, tar.getMa_des_tar());
                            ps.setString(28, tar.getMa_bol_sal());
                            ps.setDouble(29, tar.getMa_ext_fot());
                            ps.setString(30, tar.getMa_orden());
                            ps.setInt(31, tar.getMa_imp_res());
                            ps.setDouble(32, tar.getMa_suma());
                            ps.setDouble(33, tar.getMa_sumtp());
                            ps.setDouble(34, tar.getMa_iva());
                            ps.setDouble(35, tar.getMa_ivatp());
                            ps.setInt(36, tar.getMa_tipo());
                            ps.setString(37, tar.getMa_transfe());
                            ps.setInt(38, tar.getMa_cantid());
                            ps.setInt(39, tar.getMa_cod_tra());
                            ps.setString(40, tar.getMa_dir_tra());
                            ps.setString(41, tar.getMa_des_tra());
                            ps.setString(42, tar.getMa_tel_tra());
                            ps.setString(43, tar.getMa_ruc_tra());

                            ps.setString(44, tar.getUsuar_oper());
                            ps.setString(45, tar.getFec_oper());
                            ps.setString(46, tar.getHora_oper());
                            ps.setString(47, tar.getOperacion());

                            ps.setString(48, tar.getMa_ver_con());
                            ps.setString(49, tar.getObserva());         
                            cont ++;     
            }       
                            ps.execute();        
                            res = "";        
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }       
    
//    public static String modifActa(List<Actas> list,int cod,int pos){
//        String res = "No se pudo Modificar Acta";
//        Conexion con = new Conexion();
//        PreparedStatement ps = null;        
//        int cont = 1;
//        try{
//            
//            for (Actas tar : list) {
//
//                ps = con.con.prepareStatement("UPDATE actas SET ma_hora=?, ma_fec_act=to_date(?,'YYYY-MM-DD'), ma_mic_dta=?, "
//                        + "ma_cod_des=?, ma_cod_cab=?, ma_cod_tar=?, ma_cod_con=?, ma_cod_mer=?, ma_cod_per=?, "
//                        + "ma_nro_ing=?, ma_no_inga=?, ma_salida=?, ma_des_con=?, ma_val_fot=?, ma_des_mer=?, "
//                        + "ma_marcar=?, ma_serie=?, ma_nro_fac=?, ma_nro_fa1=?, ma_fec_fac=to_date(?,'YYYY-MM-DD'), ma_hor_fac=?, ma_numerar=?, "
//                        + "ma_con_dia=?, ma_monto=?, ma_cotisa=?, ma_des_tar=?, ma_bol_sal=?, ma_ext_fot=?, ma_orden=?, "
//                        + "ma_imp_res=?, ma_suma=?, ma_sumtp=?, ma_iva=?, ma_ivatp=?, ma_tipo=?, ma_transfe=?, "
//                        + "ma_cantid=?, ma_cod_tra=?, ma_dir_tra=?, ma_des_tra=?, ma_tel_tra=?, ma_ruc_tra=?, "
//                        + "usuar_oper=?, fec_oper=to_date(?,'YYYY-MM-DD'), hora_oper=?, operacion=?, ma_ver_con=?, observa=? "
//                        + "WHERE ma_nro_act = " + cod +" and ma_numerar=" + pos);
//
//                ps.setString(1, tar.getMa_hora());
//                ps.setString(2, tar.getMa_fec_act());
//                ps.setInt(3, tar.getMa_mic_dta());
//                ps.setInt(4, tar.getMa_cod_des());
//                ps.setInt(5, tar.getMa_cod_cab());
//                ps.setInt(6, tar.getMa_cod_tar());
//                ps.setInt(7, tar.getMa_cod_con());
//                ps.setInt(8, tar.getMa_cod_mer());
//                ps.setString(9, tar.getMa_cod_per());
//                ps.setInt(10, tar.getMa_nro_ing());
//                ps.setInt(11, tar.getMa_no_inga());
//                ps.setString(12, tar.getMa_salida());
//                ps.setString(13, tar.getMa_des_con());
//                ps.setDouble(14, tar.getMa_val_fot());
//                ps.setString(15, tar.getMa_des_mer());
//                ps.setString(16, tar.getMa_marcar());
//                ps.setString(17, tar.getMa_serie());
//                ps.setInt(18, tar.getMa_nro_fac());
//                ps.setInt(19, tar.getMa_nro_fa1());
//                ps.setString(20, tar.getMa_fec_fac());
//                ps.setString(21, tar.getMa_hor_fac());
//                ps.setInt(22, cont);
//                ps.setInt(23, tar.getMa_con_dia());
//                ps.setInt(24, tar.getMa_monto());
//                ps.setDouble(25, tar.getMa_cotisa());
//                ps.setString(26, tar.getMa_des_tar());
//                ps.setString(27, tar.getMa_bol_sal());
//                ps.setDouble(28, tar.getMa_ext_fot());
//                ps.setString(29, tar.getMa_orden());
//                ps.setInt(30, tar.getMa_imp_res());
//                ps.setDouble(31, tar.getMa_suma());
//                ps.setDouble(32, tar.getMa_sumtp());
//                ps.setDouble(33, tar.getMa_iva());
//                ps.setDouble(34, tar.getMa_ivatp());
//                ps.setInt(35, tar.getMa_tipo());
//                ps.setString(36, tar.getMa_transfe());
//                ps.setInt(37, tar.getMa_cantid());
//                ps.setInt(38, tar.getMa_cod_tra());
//                ps.setString(39, tar.getMa_dir_tra());
//                ps.setString(40, tar.getMa_des_tra());
//                ps.setString(41, tar.getMa_tel_tra());
//                ps.setString(42, tar.getMa_ruc_tra());
//                ps.setString(43, tar.getUsuar_oper());
//                ps.setString(44, tar.getFec_oper());
//                ps.setString(45, tar.getHora_oper());
//                ps.setString(46, tar.getOperacion());
//                ps.setString(47, tar.getMa_ver_con());
//                ps.setString(48, tar.getObserva());         
//                cont ++;     
//            }       
//                ps.execute();        
//                res = "";        
//            
//        }catch(SQLException ex){
//            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return res;
//    }

    public static String eliActa(int cod){
        String res = "No se pudo Eliminar Acta";
        Conexion con = new Conexion();
        PreparedStatement ps = null;         
        
        try{
            ps = con.con.prepareStatement("delete from actas where ma_nro_act = ? ");
            ps.setInt(1, cod);
            ps.execute();
            res = "";
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }     
    
    public static ResultSet recCab(int cod){        
        ResultSet res = null;
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        try{
            ps = con.con.prepareStatement("SELECT ma_nro_act, ma_hora, ma_fec_act, ma_nro_ing FROM actas\n" +
                                                                        "where ma_nro_act = "+cod+"\n" +
                                                                        "group by ma_nro_act, ma_hora, ma_fec_act, ma_nro_ing");
            res = ps.executeQuery();                     
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return res;
    }       
    
    
    public static String addconfig(int acta,String fac){
        String res = "No se pudo Registrar Configuración";
        Conexion con = new Conexion();
        PreparedStatement ps = null;        
        ResultSet rs = null;
        
        try{
            ps = con.con.prepareStatement("select count(*) as cant from config_doc where nro_acta = ? or nro_factura = ?");
            ps.setInt(1, acta);
            ps.setString(2, fac);
            rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getInt("cant")>0){
                        ps = con.con.prepareStatement("UPDATE config_doc SET nro_acta=?, nro_factura=?");
                        ps.setInt(1, acta);
                        ps.setString(2, fac);
                        ps.execute();
                        res="";                
                }else{
                    ps = con.con.prepareStatement("INSERT INTO config_doc VALUES (?, ?)");
                    ps.setInt(1, acta);
                    ps.setString(2, fac);
                    ps.execute();
                    res="";                
                }                   
            }
        
        }catch(Exception ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public static boolean modiConfig(int cng){

        boolean res = false;
        Conexion con = new Conexion();
        try{

                PreparedStatement ps = con.con.prepareStatement("UPDATE config_doc SET nro_acta=?  ");
                ps.setInt(1, cng);
                ps.execute();        
                res = true;                               
            
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }        
    
    public static ResultSet consultaLista() throws SQLException {
        String seleccion = "SELECT nro_acta,nro_factura from config_doc ";
        Conexion con = new Conexion();
        PreparedStatement ps = con.con.prepareStatement(seleccion);
        ResultSet rs = ps.executeQuery();
        return rs;
    }    
    
    public static List<Actas> recudet(int cod){       
        List<Actas> res = new ArrayList<>();
        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.con.prepareStatement("SELECT ma_nro_act, ma_hora, ma_fec_act, ma_mic_dta, ma_cod_des, ma_cod_cab, "
                    + "ma_cod_tar, ma_cod_con, ma_cod_mer, ma_cod_per, ma_nro_ing, ma_no_inga, ma_salida, ma_des_con, "
                    + "ma_val_fot, ma_des_mer, Case ma_marcar when '' then 'N' else 'S' end as ma_marcar, ma_serie, ma_nro_fac, ma_nro_fa1, ma_fec_fac, ma_hor_fac, "
                    + "ma_numerar, ma_con_dia, ma_monto, ma_cotisa, ma_des_tar, ma_bol_sal, ma_ext_fot, ma_orden, "
                    + "ma_imp_res, ma_suma, ma_sumtp, ma_iva, ma_ivatp, ma_tipo, ma_transfe, ma_cantid, ma_cod_tra, "
                    + "ma_dir_tra, ma_des_tra, ma_tel_tra, ma_ruc_tra, usuar_oper, fec_oper, hora_oper, operacion, "
                    + "ma_ver_con, observa FROM actas  where ma_nro_act =  "+cod);
            rs = ps.executeQuery();    
            while(rs.next()){                
                res.add(new Actas(rs.getInt("ma_nro_act"), rs.getString("ma_hora"), rs.getString("ma_fec_act"), 
                rs.getInt("ma_mic_dta"), rs.getInt("ma_cod_des"), rs.getInt("ma_cod_cab"), rs.getInt("ma_cod_tar"), 
                rs.getInt("ma_cod_con"), rs.getInt("ma_cod_mer"), rs.getString("ma_cod_per"), rs.getInt("ma_nro_ing"), 
                rs.getInt("ma_no_inga"), rs.getString("ma_salida"), rs.getString("ma_des_con"), rs.getDouble("ma_val_fot"), 
                rs.getString("ma_des_mer"), rs.getString("ma_marcar"), rs.getString("ma_serie"), rs.getInt("ma_nro_fac"), 
                rs.getInt("ma_nro_fa1"), rs.getString("ma_fec_fac"), rs.getString("ma_hor_fac"), rs.getInt("ma_numerar"), 
                rs.getInt("ma_con_dia"), rs.getInt("ma_monto"), rs.getDouble("ma_cotisa"), rs.getString("ma_des_tar"), 
                rs.getString("ma_bol_sal"), rs.getInt("ma_ext_fot"), rs.getString("ma_orden"), rs.getInt("ma_imp_res"), 
                rs.getInt("ma_suma"), rs.getInt("ma_sumtp"), rs.getInt("ma_iva"), rs.getInt("ma_ivatp"), rs.getInt("ma_tipo"), 
                rs.getString("ma_transfe"), rs.getInt("ma_cantid"), rs.getInt("ma_cod_tra"), rs.getString("ma_dir_tra"), 
                rs.getString("ma_des_tra"), rs.getString("ma_tel_tra"), rs.getString("ma_ruc_tra"), rs.getString("usuar_oper"), 
                rs.getString("fec_oper"), rs.getString("hora_oper"), rs.getString("operacion"), rs.getString("ma_ver_con"), 
                rs.getString("observa")));
            }
        }catch(SQLException ex){
            Logger.getLogger(ConsignatariosControlador.class.getName()).log(Level.SEVERE, null, ex);            
        }        
        return res;        
    }
    
}
