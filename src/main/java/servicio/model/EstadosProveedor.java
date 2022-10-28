/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class EstadosProveedor {
    int codEstadoProveedor = 0;
    String nombreEstadoProveedor= "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodEstadoProveedor() {
        return codEstadoProveedor;
    }

    public void setCodEstadoProveedor(int codEstadoProveedor) {
        this.codEstadoProveedor = codEstadoProveedor;
    }

    public String getNombreEstadoProveedor() {
        return nombreEstadoProveedor;
    }

    public void setNombreEstadoProveedor(String nombreEstadoProveedor) {
        this.nombreEstadoProveedor = nombreEstadoProveedor;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
   
    
}
