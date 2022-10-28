/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class TiposSalidaVenta {
    int codTipoSalidaVenta = 0;
    String nombreTipoSalidaVenta = "";
    String obsTipoSalidaVenta = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoSalidaVenta() {
        return codTipoSalidaVenta;
    }

    public void setCodTipoSalidaVenta(int codTipoSalidaVenta) {
        this.codTipoSalidaVenta = codTipoSalidaVenta;
    }

    public String getNombreTipoSalidaVenta() {
        return nombreTipoSalidaVenta;
    }

    public void setNombreTipoSalidaVenta(String nombreTipoSalidaVenta) {
        this.nombreTipoSalidaVenta = nombreTipoSalidaVenta;
    }

    public String getObsTipoSalidaVenta() {
        return obsTipoSalidaVenta;
    }

    public void setObsTipoSalidaVenta(String obsTipoSalidaVenta) {
        this.obsTipoSalidaVenta = obsTipoSalidaVenta;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
