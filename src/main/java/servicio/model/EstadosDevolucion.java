/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class EstadosDevolucion {
    int codEstadoDevolucion = 0;
    String nombreEstadoDevolucion = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodEstadoDevolucion() {
        return codEstadoDevolucion;
    }

    public void setCodEstadoDevolucion(int codEstadoDevolucion) {
        this.codEstadoDevolucion = codEstadoDevolucion;
    }

    public String getNombreEstadoDevolucion() {
        return nombreEstadoDevolucion;
    }

    public void setNombreEstadoDevolucion(String nombreEstadoDevolucion) {
        this.nombreEstadoDevolucion = nombreEstadoDevolucion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
