/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class EspecificacionFichaTecnica extends bean{
    int codEspeficicacion = 0;
    String codigoEspecificacion = "";
    String descripcionEspecificacion = "";
    TiposEspecificacion tiposEspecificacion = new TiposEspecificacion();
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodEspeficicacion() {
        return codEspeficicacion;
    }

    public void setCodEspeficicacion(int codEspeficicacion) {
        this.codEspeficicacion = codEspeficicacion;
    }

    public String getCodigoEspecificacion() {
        return codigoEspecificacion;
    }

    public void setCodigoEspecificacion(String codigoEspecificacion) {
        this.codigoEspecificacion = codigoEspecificacion;
    }

    public String getDescripcionEspecificacion() {
        return descripcionEspecificacion;
    }

    public void setDescripcionEspecificacion(String descripcionEspecificacion) {
        this.descripcionEspecificacion = descripcionEspecificacion;
    }

    public TiposEspecificacion getTiposEspecificacion() {
        return tiposEspecificacion;
    }

    public void setTiposEspecificacion(TiposEspecificacion tiposEspecificacion) {
        this.tiposEspecificacion = tiposEspecificacion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
}
