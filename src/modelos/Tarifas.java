/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Mauro
 */
public class Tarifas {
    
    int tt_cod_cab;
    int tt_codigo;
    int tt_tarifa1;
    int tt_tarifa2;
    int tt_tarifa3;
    String tt_observ;
    String tt_abrevia;
    String tt_des_for;
    int tt_des_fob;
    String tt_agrupar;
    String tt_con_fec;
    String usuar_oper;
    
    public Tarifas(int tt_cod_cab,int tt_codigo,int tt_tarifa1,int tt_tarifa2,int tt_tarifa3,String tt_observ,String tt_abrevia,String tt_des_for,int tt_des_fob,String tt_agrupar,String tt_con_fec,String usuar_oper){
        this.tt_cod_cab = tt_cod_cab;
        this.tt_codigo = tt_codigo;
        this.tt_tarifa1 = tt_tarifa1;
        this.tt_tarifa2 = tt_tarifa2;
        this.tt_tarifa3 = tt_tarifa3;
        this.tt_observ = tt_observ;
        this.tt_abrevia = tt_abrevia;
        this.tt_des_for = tt_des_for;
        this.tt_des_fob = tt_des_fob;
        this.tt_agrupar = tt_agrupar;
        this.tt_con_fec = tt_con_fec;
        this.usuar_oper = usuar_oper;
    }

    public int getTt_cod_cab() {
        return tt_cod_cab;
    }

    public void setTt_cod_cab(int tt_cod_cab) {
        this.tt_cod_cab = tt_cod_cab;
    }

    public int getTt_codigo() {
        return tt_codigo;
    }

    public void setTt_codigo(int tt_codigo) {
        this.tt_codigo = tt_codigo;
    }

    public int getTt_tarifa1() {
        return tt_tarifa1;
    }

    public void setTt_tarifa1(int tt_tarifa1) {
        this.tt_tarifa1 = tt_tarifa1;
    }

    public int getTt_tarifa2() {
        return tt_tarifa2;
    }

    public void setTt_tarifa2(int tt_tarifa2) {
        this.tt_tarifa2 = tt_tarifa2;
    }

    public int getTt_tarifa3() {
        return tt_tarifa3;
    }

    public void setTt_tarifa3(int tt_tarifa3) {
        this.tt_tarifa3 = tt_tarifa3;
    }

    public String getTt_observ() {
        return tt_observ;
    }

    public void setTt_observ(String tt_observ) {
        this.tt_observ = tt_observ;
    }

    public String getTt_abrevia() {
        return tt_abrevia;
    }

    public void setTt_abrevia(String tt_abrevia) {
        this.tt_abrevia = tt_abrevia;
    }

    public String getTt_des_for() {
        return tt_des_for;
    }

    public void setTt_des_for(String tt_des_for) {
        this.tt_des_for = tt_des_for;
    }

    public int getTt_des_fob() {
        return tt_des_fob;
    }

    public void setTt_des_fob(int tt_des_fob) {
        this.tt_des_fob = tt_des_fob;
    }

    public String getTt_agrupar() {
        return tt_agrupar;
    }

    public void setTt_agrupar(String tt_agrupar) {
        this.tt_agrupar = tt_agrupar;
    }

    public String getTt_con_fec() {
        return tt_con_fec;
    }

    public void setTt_con_fec(String tt_con_fec) {
        this.tt_con_fec = tt_con_fec;
    }

    public String getUsuar_oper() {
        return usuar_oper;
    }

    public void setUsuar_oper(String usuar_oper) {
        this.usuar_oper = usuar_oper;
    }
    
    
    
}
