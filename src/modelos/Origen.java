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
public class Origen {
    
    int ori_codigo;
    String ori_descri;
    String ori_telef;
    String ori_contac;
    String fec_oper;
    String usuar_oper;
    String hora_oper;
    String operacion;
    
    public Origen(int ori_codigo,String ori_descri,String ori_telef,String ori_contac,String fec_oper,String usuar_oper,String hora_oper,String operacion){
        this.ori_codigo = ori_codigo;
        this.ori_descri = ori_descri;
        this.ori_telef = ori_telef;
        this.ori_contac = ori_contac;
        this.fec_oper = fec_oper;
        this.usuar_oper = usuar_oper;
        this.hora_oper = hora_oper;
        this.operacion = operacion;
    }

    public int getOri_codigo() {
        return ori_codigo;
    }

    public void setOri_codigo(int ori_codigo) {
        this.ori_codigo = ori_codigo;
    }

    public String getOri_descri() {
        return ori_descri;
    }

    public void setOri_descri(String ori_descri) {
        this.ori_descri = ori_descri;
    }

    public String getOri_telef() {
        return ori_telef;
    }

    public void setOri_telef(String ori_telef) {
        this.ori_telef = ori_telef;
    }

    public String getOri_contac() {
        return ori_contac;
    }

    public void setOri_contac(String ori_contac) {
        this.ori_contac = ori_contac;
    }

    public String getFec_oper() {
        return fec_oper;
    }

    public void setFec_oper(String fec_oper) {
        this.fec_oper = fec_oper;
    }

    public String getUsuar_oper() {
        return usuar_oper;
    }

    public void setUsuar_oper(String usuar_oper) {
        this.usuar_oper = usuar_oper;
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
