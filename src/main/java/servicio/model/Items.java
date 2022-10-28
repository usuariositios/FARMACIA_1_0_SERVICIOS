/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.util.Date;

/**
 *
 * @author henry
 */
public class Items {
    
    private int codItem = 0;
    private String nombreItem = "";
    private String observacion = "";
    Date fechaCreacion = new Date();
    EstadosRegistro codEstado = new EstadosRegistro();
    public Items() {
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadosRegistro getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(EstadosRegistro codEstado) {
        this.codEstado = codEstado;
    }

    
    
}
