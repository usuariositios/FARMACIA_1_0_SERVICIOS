/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Computer
 */
@XmlRootElement
public class TiposIngresoVenta extends bean{
    int codTipoIngresoVenta = 0;
    String nombreTipoIngresoVenta = "";
    String obsTipoIngresoVenta = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoIngresoVenta() {
        return codTipoIngresoVenta;
    }

    public void setCodTipoIngresoVenta(int codTipoIngresoVenta) {
        this.codTipoIngresoVenta = codTipoIngresoVenta;
    }

    public String getNombreTipoIngresoVenta() {
        return nombreTipoIngresoVenta;
    }

    public void setNombreTipoIngresoVenta(String nombreTipoIngresoVenta) {
        this.nombreTipoIngresoVenta = nombreTipoIngresoVenta;
    }

    public String getObsTipoIngresoVenta() {
        return obsTipoIngresoVenta;
    }

    public void setObsTipoIngresoVenta(String obsTipoIngresoVenta) {
        this.obsTipoIngresoVenta = obsTipoIngresoVenta;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
            
}
