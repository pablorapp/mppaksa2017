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
public class Consignatarios {
    
    int cncodigo;
    String cnnombre;
    String cnabrevia;
    String cndireccion;
    String cntelefono;
    String cnruc;
    String cnusuario;
    String cnfecent;
    String cnhoraent;
    String cnoperacion;
    int cncodcab;
    int cncodtar;
    int cncodmer;
    
    public Consignatarios(int cncodigo,String cnnombre,String cnabrevia,String cndireccion,String cntelefono,String cnruc,
            String cnusuario,String cnfecent,String cnhoraent,String cnoperacion,int cncodcab,int cncodtar,int cncodmer){
        this.cncodigo = cncodigo;
        this.cnnombre = cnnombre;
        this.cnabrevia = cnabrevia;
        this.cndireccion = cndireccion;
        this.cntelefono = cntelefono;
        this.cnruc = cnruc;
        this.cnusuario = cnusuario;
        this.cnfecent = cnfecent;
        this.cnhoraent = cnhoraent;
        this.cnoperacion = cnoperacion;
        this.cncodcab = cncodcab;
        this.cncodtar = cncodtar;
        this.cncodmer = cncodmer;
    }

    public int getCncodigo() {
        return cncodigo;
    }

    public void setCncodigo(int cncodigo) {
        this.cncodigo = cncodigo;
    }

    public String getCnnombre() {
        return cnnombre;
    }

    public void setCnnombre(String cnnombre) {
        this.cnnombre = cnnombre;
    }

    public String getCnabrevia() {
        return cnabrevia;
    }

    public void setCnabrevia(String cnabrevia) {
        this.cnabrevia = cnabrevia;
    }

    public String getCndireccion() {
        return cndireccion;
    }

    public void setCndireccion(String cndireccion) {
        this.cndireccion = cndireccion;
    }

    public String getCntelefono() {
        return cntelefono;
    }

    public void setCntelefono(String cntelefono) {
        this.cntelefono = cntelefono;
    }

    public String getCnruc() {
        return cnruc;
    }

    public void setCnruc(String cnruc) {
        this.cnruc = cnruc;
    }

    public String getCnusuario() {
        return cnusuario;
    }

    public void setCnusuario(String cnusuario) {
        this.cnusuario = cnusuario;
    }

    public String getCnfecent() {
        return cnfecent;
    }

    public void setCnfecent(String cnfecent) {
        this.cnfecent = cnfecent;
    }

    public String getCnhoraent() {
        return cnhoraent;
    }

    public void setCnhoraent(String cnhoraent) {
        this.cnhoraent = cnhoraent;
    }

    public String getCnoperacion() {
        return cnoperacion;
    }

    public void setCnoperacion(String cnoperacion) {
        this.cnoperacion = cnoperacion;
    }

    public int getCncodcab() {
        return cncodcab;
    }

    public void setCncodcab(int cncodcab) {
        this.cncodcab = cncodcab;
    }

    public int getCncodtar() {
        return cncodtar;
    }

    public void setCncodtar(int cncodtar) {
        this.cncodtar = cncodtar;
    }

    public int getCncodmer() {
        return cncodmer;
    }

    public void setCncodmer(int cncodmer) {
        this.cncodmer = cncodmer;
    }
    
    
    
}
