/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class TiposProveedor {
    int codTipoProveedor = 0;
    String nombreTipoProveedor = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoProveedor() {
        return codTipoProveedor;
    }

    public void setCodTipoProveedor(int codTipoProveedor) {
        this.codTipoProveedor = codTipoProveedor;
    }

    public String getNombreTipoProveedor() {
        return nombreTipoProveedor;
    }

    public void setNombreTipoProveedor(String nombreTipoProveedor) {
        this.nombreTipoProveedor = nombreTipoProveedor;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
