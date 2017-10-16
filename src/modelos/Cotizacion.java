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
public class Cotizacion {
    
    String tc_fec_cot;
    Double tc_cot_mon;
    String usuar_oper;
    String fec_oper;
    String hora_oper;
    String operacion;
    
    public Cotizacion(String tc_fec_cot,Double tc_cot_mon,String usuar_oper,String fec_oper,String hora_oper,String operacion){
        this.tc_fec_cot = tc_fec_cot;
        this.tc_cot_mon = tc_cot_mon;
        this.usuar_oper = usuar_oper;
        this.fec_oper  = fec_oper;
        this.hora_oper = hora_oper;
        this.operacion = operacion;
    }


    public String getTc_fec_cot() {
        return tc_fec_cot;
    }

    public void setTc_fec_cot(String tc_fec_cot) {
        this.tc_fec_cot = tc_fec_cot;
    }

    public Double getTc_cot_mon() {
        return tc_cot_mon;
    }

    public void setTc_cot_mon(Double tc_cot_mon) {
        this.tc_cot_mon = tc_cot_mon;
    }

    public String getUsuar_oper() {
        return usuar_oper;
    }

    public void setUsuar_oper(String usuar_oper) {
        this.usuar_oper = usuar_oper;
    }

    public String getFec_oper() {
        return fec_oper;
    }

    public void setFec_oper(String fec_oper) {
        this.fec_oper = fec_oper;
    }

    public String getHora_oper() {
        return hora_oper;
    }

    public void setHora_oper(String hora_oper) {
        this.hora_oper = hora_oper;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    
}
