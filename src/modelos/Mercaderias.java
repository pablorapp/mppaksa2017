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
public class Mercaderias {

int tm_codigo;
String tm_descrip;
String usuar_oper;
String fec_oper;
String hora_oper;
String operacion;

public Mercaderias(int tm_codigo,String tm_descrip,String usuar_oper,String fec_oper,String hora_oper,String operacion){
    this.tm_codigo = tm_codigo;
    this.tm_descrip = tm_descrip;
    this.usuar_oper = usuar_oper;
    this.fec_oper = fec_oper;
    this.hora_oper = hora_oper;
    this.operacion = operacion;
}

    public int getTm_codigo() {
        return tm_codigo;
    }

    public void setTm_codigo(int tm_codigo) {
        this.tm_codigo = tm_codigo;
    }

    public String getTm_descrip() {
        return tm_descrip;
    }

    public void setTm_descrip(String tm_descrip) {
        this.tm_descrip = tm_descrip;
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
