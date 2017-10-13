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
public class Feriados {
    
    String tf_fec_nh;
    String tf_descrip;
    String usuar_oper;
    String fec_oper;
    String hora_oper;
    String operacion;
    
    public Feriados(String tf_fec_nh,String tf_descrip,String usuar_oper,String fec_oper,String hora_oper,String operacion){
        this.tf_fec_nh = tf_fec_nh;
        this.tf_descrip = tf_descrip;
        this.usuar_oper = usuar_oper;
        this.fec_oper = fec_oper;
        this.hora_oper = hora_oper;
        this.operacion = operacion;
    }

    public String getTf_fec_nh() {
        return tf_fec_nh;
    }

    public void setTf_fec_nh(String tf_fec_nh) {
        this.tf_fec_nh = tf_fec_nh;
    }

    public String getTf_descrip() {
        return tf_descrip;
    }

    public void setTf_descrip(String tf_descrip) {
        this.tf_descrip = tf_descrip;
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
