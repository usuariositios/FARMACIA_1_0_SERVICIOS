/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class EstadosIngresoVenta {
    int codEstadoIngresoVenta =0;
    String nombreEstadoIngresoVenta = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodEstadoIngresoVenta() {
        return codEstadoIngresoVenta;
    }

    public void setCodEstadoIngresoVenta(int codEstadoIngresoVenta) {
        this.codEstadoIngresoVenta = codEstadoIngresoVenta;
    }

    public String getNombreEstadoIngresoVenta() {
        return nombreEstadoIngresoVenta;
    }

    public void setNombreEstadoIngresoVenta(String nombreEstadoIngresoVenta) {
        this.nombreEstadoIngresoVenta = nombreEstadoIngresoVenta;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
}
