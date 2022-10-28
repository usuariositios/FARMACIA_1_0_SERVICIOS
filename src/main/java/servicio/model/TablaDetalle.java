/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author COMPUTER
 */
public class TablaDetalle {
    Tabla tabla = new Tabla();
    int codCampo = 0;
    String nombreCampo = "";
    String valorCharCampo = "";
    Double valorNumberCampo = 0.0;
    String valorDateCampo = "";
    String descripcionCampo = "";

    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }

    public int getCodCampo() {
        return codCampo;
    }

    public void setCodCampo(int codCampo) {
        this.codCampo = codCampo;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getValorCharCampo() {
        return valorCharCampo;
    }

    public void setValorCharCampo(String valorCharCampo) {
        this.valorCharCampo = valorCharCampo;
    }

    public Double getValorNumberCampo() {
        return valorNumberCampo;
    }

    public void setValorNumberCampo(Double valorNumberCampo) {
        this.valorNumberCampo = valorNumberCampo;
    }

    public String getValorDateCampo() {
        return valorDateCampo;
    }

    public void setValorDateCampo(String valorDateCampo) {
        this.valorDateCampo = valorDateCampo;
    }

    public String getDescripcionCampo() {
        return descripcionCampo;
    }

    public void setDescripcionCampo(String descripcionCampo) {
        this.descripcionCampo = descripcionCampo;
    }
    
    
    
}
