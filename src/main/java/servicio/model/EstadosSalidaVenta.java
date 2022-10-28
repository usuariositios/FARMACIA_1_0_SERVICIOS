/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class EstadosSalidaVenta {
    int codEstadoSalidaVenta = 0;
    String nombreEstadoSalidaVenta = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodEstadoSalidaVenta() {
        return codEstadoSalidaVenta;
    }

    public void setCodEstadoSalidaVenta(int codEstadoSalidaVenta) {
        this.codEstadoSalidaVenta = codEstadoSalidaVenta;
    }

    public String getNombreEstadoSalidaVenta() {
        return nombreEstadoSalidaVenta;
    }

    public void setNombreEstadoSalidaVenta(String nombreEstadoSalidaVenta) {
        this.nombreEstadoSalidaVenta = nombreEstadoSalidaVenta;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
            
}
