/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class EstadosOrdenProduccion {
    int codEstadoOrdenProduccion = 0;
    String nombreEstadoOrdenProduccion = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    String codigosEstadoOrdenProduccion = "0";//para filtrar la oredn de produccion de acuerdo a unos determinados estados

    public int getCodEstadoOrdenProduccion() {
        return codEstadoOrdenProduccion;
    }

    public void setCodEstadoOrdenProduccion(int codEstadoOrdenProduccion) {
        this.codEstadoOrdenProduccion = codEstadoOrdenProduccion;
    }

    public String getNombreEstadoOrdenProduccion() {
        return nombreEstadoOrdenProduccion;
    }

    public void setNombreEstadoOrdenProduccion(String nombreEstadoOrdenProduccion) {
        this.nombreEstadoOrdenProduccion = nombreEstadoOrdenProduccion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public String getCodigosEstadoOrdenProduccion() {
        return codigosEstadoOrdenProduccion;
    }

    public void setCodigosEstadoOrdenProduccion(String codigosEstadoOrdenProduccion) {
        this.codigosEstadoOrdenProduccion = codigosEstadoOrdenProduccion;
    }
    
    
    
    
}
