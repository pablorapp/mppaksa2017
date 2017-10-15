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
public class Actas {
    int ma_nro_act;//nro de acta
    String ma_hora;//hora del acta
    String ma_fec_act;// fecha del acta
    int ma_mic_dta;//MIC del acta
    int ma_cod_des;//ni idea nunca se uso
    int ma_cod_cab;// creo que es origen
    int ma_cod_tar;//codigo de tarifa
    int ma_cod_con;// codigo de consignatario
    int ma_cod_mer;// codigo de mercaderia
    String ma_cod_per;// null 
    int ma_nro_ing;// nro de ingreso 1 o 2
    int ma_no_inga;// es cero
    String ma_salida;// null
    String ma_des_con;// null
    double ma_val_fot;// valor fob
    String ma_des_mer;// descripcion de merca
    String ma_marcar;// marca de factura
    String ma_serie; // null
    int ma_nro_fac; // nro de factura
    int ma_nro_fa1; // o
    String ma_fec_fac; // fecha de Factura
    String ma_hor_fac; // hora de Factu
    int ma_numerar; // ni idea pero son numeros chicos que se repiten
    int ma_con_dia;// 0
    int ma_monto; //?????
    double ma_cotisa; //cambio
    String ma_des_tar;// null
    String ma_bol_sal; // boleta de Salida,
    double ma_ext_fot; // 0
    String ma_orden; //null
    int ma_imp_res;//0
    double ma_suma;// gravada
    int ma_sumtp; //0
    double ma_iva;//iva
    int ma_ivatp;//0
    String ma_tipo;//null
    String ma_transfe;//null
    int ma_cantid;//0
    int ma_cod_tra;//0
    String ma_dir_tra;//null
    String ma_des_tra;//null
    String ma_tel_tra;//null
    String ma_ruc_tra;//null
    String usuar_oper;//usuario
    String fec_oper;//fecha de operacion
    String hora_oper;//hora d operacion
    String operacion;// operacion A
    String ma_ver_con;//null
    String observa;//null

    public Actas(int ma_nro_act, String ma_hora, String ma_fec_act, int ma_mic_dta, int ma_cod_des, int ma_cod_cab, int ma_cod_tar, int ma_cod_con, int ma_cod_mer, String ma_cod_per, int ma_nro_ing, int ma_no_inga, String ma_salida, String ma_des_con, double ma_val_fot, String ma_des_mer, String ma_marcar, String ma_serie, int ma_nro_fac, int ma_nro_fa1, String ma_fec_fac, String ma_hor_fac, int ma_numerar, int ma_con_dia, int ma_monto, double ma_cotisa, String ma_des_tar, String ma_bol_sal, double ma_ext_fot, String ma_orden, int ma_imp_res, double ma_suma, int ma_sumtp, double ma_iva, int ma_ivatp, String ma_tipo, String ma_transfe, int ma_cantid, int ma_cod_tra, String ma_dir_tra, String ma_des_tra, String ma_tel_tra, String ma_ruc_tra, String usuar_oper, String fec_oper, String hora_oper, String operacion, String ma_ver_con, String observa) {
        this.ma_nro_act = ma_nro_act;
        this.ma_hora = ma_hora;
        this.ma_fec_act = ma_fec_act;
        this.ma_mic_dta = ma_mic_dta;
        this.ma_cod_des = ma_cod_des;
        this.ma_cod_cab = ma_cod_cab;
        this.ma_cod_tar = ma_cod_tar;
        this.ma_cod_con = ma_cod_con;
        this.ma_cod_mer = ma_cod_mer;
        this.ma_cod_per = ma_cod_per;
        this.ma_nro_ing = ma_nro_ing;
        this.ma_no_inga = ma_no_inga;
        this.ma_salida = ma_salida;
        this.ma_des_con = ma_des_con;
        this.ma_val_fot = ma_val_fot;
        this.ma_des_mer = ma_des_mer;
        this.ma_marcar = ma_marcar;
        this.ma_serie = ma_serie;
        this.ma_nro_fac = ma_nro_fac;
        this.ma_nro_fa1 = ma_nro_fa1;
        this.ma_fec_fac = ma_fec_fac;
        this.ma_hor_fac = ma_hor_fac;
        this.ma_numerar = ma_numerar;
        this.ma_con_dia = ma_con_dia;
        this.ma_monto = ma_monto;
        this.ma_cotisa = ma_cotisa;
        this.ma_des_tar = ma_des_tar;
        this.ma_bol_sal = ma_bol_sal;
        this.ma_ext_fot = ma_ext_fot;
        this.ma_orden = ma_orden;
        this.ma_imp_res = ma_imp_res;
        this.ma_suma = ma_suma;
        this.ma_sumtp = ma_sumtp;
        this.ma_iva = ma_iva;
        this.ma_ivatp = ma_ivatp;
        this.ma_tipo = ma_tipo;
        this.ma_transfe = ma_transfe;
        this.ma_cantid = ma_cantid;
        this.ma_cod_tra = ma_cod_tra;
        this.ma_dir_tra = ma_dir_tra;
        this.ma_des_tra = ma_des_tra;
        this.ma_tel_tra = ma_tel_tra;
        this.ma_ruc_tra = ma_ruc_tra;
        this.usuar_oper = usuar_oper;
        this.fec_oper = fec_oper;
        this.hora_oper = hora_oper;
        this.operacion = operacion;
        this.ma_ver_con = ma_ver_con;
        this.observa = observa;
    }

    public int getMa_nro_act() {
        return ma_nro_act;
    }

    public void setMa_nro_act(int ma_nro_act) {
        this.ma_nro_act = ma_nro_act;
    }

    public String getMa_hora() {
        return ma_hora;
    }

    public void setMa_hora(String ma_hora) {
        this.ma_hora = ma_hora;
    }

    public String getMa_fec_act() {
        return ma_fec_act;
    }

    public void setMa_fec_act(String ma_fec_act) {
        this.ma_fec_act = ma_fec_act;
    }

    public int getMa_mic_dta() {
        return ma_mic_dta;
    }

    public void setMa_mic_dta(int ma_mic_dta) {
        this.ma_mic_dta = ma_mic_dta;
    }

    public int getMa_cod_des() {
        return ma_cod_des;
    }

    public void setMa_cod_des(int ma_cod_des) {
        this.ma_cod_des = ma_cod_des;
    }

    public int getMa_cod_cab() {
        return ma_cod_cab;
    }

    public void setMa_cod_cab(int ma_cod_cab) {
        this.ma_cod_cab = ma_cod_cab;
    }

    public int getMa_cod_tar() {
        return ma_cod_tar;
    }

    public void setMa_cod_tar(int ma_cod_tar) {
        this.ma_cod_tar = ma_cod_tar;
    }

    public int getMa_cod_con() {
        return ma_cod_con;
    }

    public void setMa_cod_con(int ma_cod_con) {
        this.ma_cod_con = ma_cod_con;
    }

    public int getMa_cod_mer() {
        return ma_cod_mer;
    }

    public void setMa_cod_mer(int ma_cod_mer) {
        this.ma_cod_mer = ma_cod_mer;
    }

    public String getMa_cod_per() {
        return ma_cod_per;
    }

    public void setMa_cod_per(String ma_cod_per) {
        this.ma_cod_per = ma_cod_per;
    }

    public int getMa_nro_ing() {
        return ma_nro_ing;
    }

    public void setMa_nro_ing(int ma_nro_ing) {
        this.ma_nro_ing = ma_nro_ing;
    }

    public int getMa_no_inga() {
        return ma_no_inga;
    }

    public void setMa_no_inga(int ma_no_inga) {
        this.ma_no_inga = ma_no_inga;
    }

    public String getMa_salida() {
        return ma_salida;
    }

    public void setMa_salida(String ma_salida) {
        this.ma_salida = ma_salida;
    }

    public String getMa_des_con() {
        return ma_des_con;
    }

    public void setMa_des_con(String ma_des_con) {
        this.ma_des_con = ma_des_con;
    }

    public double getMa_val_fot() {
        return ma_val_fot;
    }

    public void setMa_val_fot(double ma_val_fot) {
        this.ma_val_fot = ma_val_fot;
    }

    public String getMa_des_mer() {
        return ma_des_mer;
    }

    public void setMa_des_mer(String ma_des_mer) {
        this.ma_des_mer = ma_des_mer;
    }

    public String getMa_marcar() {
        return ma_marcar;
    }

    public void setMa_marcar(String ma_marcar) {
        this.ma_marcar = ma_marcar;
    }

    public String getMa_serie() {
        return ma_serie;
    }

    public void setMa_serie(String ma_serie) {
        this.ma_serie = ma_serie;
    }

    public int getMa_nro_fac() {
        return ma_nro_fac;
    }

    public void setMa_nro_fac(int ma_nro_fac) {
        this.ma_nro_fac = ma_nro_fac;
    }

    public int getMa_nro_fa1() {
        return ma_nro_fa1;
    }

    public void setMa_nro_fa1(int ma_nro_fa1) {
        this.ma_nro_fa1 = ma_nro_fa1;
    }

    public String getMa_fec_fac() {
        return ma_fec_fac;
    }

    public void setMa_fec_fac(String ma_fec_fac) {
        this.ma_fec_fac = ma_fec_fac;
    }

    public String getMa_hor_fac() {
        return ma_hor_fac;
    }

    public void setMa_hor_fac(String ma_hor_fac) {
        this.ma_hor_fac = ma_hor_fac;
    }

    public int getMa_numerar() {
        return ma_numerar;
    }

    public void setMa_numerar(int ma_numerar) {
        this.ma_numerar = ma_numerar;
    }

    public int getMa_con_dia() {
        return ma_con_dia;
    }

    public void setMa_con_dia(int ma_con_dia) {
        this.ma_con_dia = ma_con_dia;
    }

    public int getMa_monto() {
        return ma_monto;
    }

    public void setMa_monto(int ma_monto) {
        this.ma_monto = ma_monto;
    }

    public double getMa_cotisa() {
        return ma_cotisa;
    }

    public void setMa_cotisa(double ma_cotisa) {
        this.ma_cotisa = ma_cotisa;
    }

    public String getMa_des_tar() {
        return ma_des_tar;
    }

    public void setMa_des_tar(String ma_des_tar) {
        this.ma_des_tar = ma_des_tar;
    }

    public String getMa_bol_sal() {
        return ma_bol_sal;
    }

    public void setMa_bol_sal(String ma_bol_sal) {
        this.ma_bol_sal = ma_bol_sal;
    }

    public double getMa_ext_fot() {
        return ma_ext_fot;
    }

    public void setMa_ext_fot(double ma_ext_fot) {
        this.ma_ext_fot = ma_ext_fot;
    }

    public String getMa_orden() {
        return ma_orden;
    }

    public void setMa_orden(String ma_orden) {
        this.ma_orden = ma_orden;
    }

    public int getMa_imp_res() {
        return ma_imp_res;
    }

    public void setMa_imp_res(int ma_imp_res) {
        this.ma_imp_res = ma_imp_res;
    }

    public double getMa_suma() {
        return ma_suma;
    }

    public void setMa_suma(double ma_suma) {
        this.ma_suma = ma_suma;
    }

    public int getMa_sumtp() {
        return ma_sumtp;
    }

    public void setMa_sumtp(int ma_sumtp) {
        this.ma_sumtp = ma_sumtp;
    }

    public double getMa_iva() {
        return ma_iva;
    }

    public void setMa_iva(double ma_iva) {
        this.ma_iva = ma_iva;
    }

    public int getMa_ivatp() {
        return ma_ivatp;
    }

    public void setMa_ivatp(int ma_ivatp) {
        this.ma_ivatp = ma_ivatp;
    }

    public String getMa_tipo() {
        return ma_tipo;
    }

    public void setMa_tipo(String ma_tipo) {
        this.ma_tipo = ma_tipo;
    }

    public String getMa_transfe() {
        return ma_transfe;
    }

    public void setMa_transfe(String ma_transfe) {
        this.ma_transfe = ma_transfe;
    }

    public int getMa_cantid() {
        return ma_cantid;
    }

    public void setMa_cantid(int ma_cantid) {
        this.ma_cantid = ma_cantid;
    }

    public int getMa_cod_tra() {
        return ma_cod_tra;
    }

    public void setMa_cod_tra(int ma_cod_tra) {
        this.ma_cod_tra = ma_cod_tra;
    }

    public String getMa_dir_tra() {
        return ma_dir_tra;
    }

    public void setMa_dir_tra(String ma_dir_tra) {
        this.ma_dir_tra = ma_dir_tra;
    }

    public String getMa_des_tra() {
        return ma_des_tra;
    }

    public void setMa_des_tra(String ma_des_tra) {
        this.ma_des_tra = ma_des_tra;
    }

    public String getMa_tel_tra() {
        return ma_tel_tra;
    }

    public void setMa_tel_tra(String ma_tel_tra) {
        this.ma_tel_tra = ma_tel_tra;
    }

    public String getMa_ruc_tra() {
        return ma_ruc_tra;
    }

    public void setMa_ruc_tra(String ma_ruc_tra) {
        this.ma_ruc_tra = ma_ruc_tra;
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

    public String getMa_ver_con() {
        return ma_ver_con;
    }

    public void setMa_ver_con(String ma_ver_con) {
        this.ma_ver_con = ma_ver_con;
    }

    public String getObserva() {
        return observa;
    }

    public void setObserva(String observa) {
        this.observa = observa;
    }
    
}
