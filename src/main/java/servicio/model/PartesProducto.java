/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class PartesProducto extends bean{
    int codParteProducto = 0;
    String nombreParteProducto = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodParteProducto() {
        return codParteProducto;
    }

    public void setCodParteProducto(int codParteProducto) {
        this.codParteProducto = codParteProducto;
    }

    public String getNombreParteProducto() {
        return nombreParteProducto;
    }

    public void setNombreParteProducto(String nombreParteProducto) {
        this.nombreParteProducto = nombreParteProducto;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
}
