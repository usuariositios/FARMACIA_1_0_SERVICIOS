/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class ActividadesProduccion extends bean{
    int codActividadProduccion = 0;
    String nombreActividadProduccion = "";
    String observacion = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    boolean externo = false;

    public int getCodActividadProduccion() {
        return codActividadProduccion;
    }

    public void setCodActividadProduccion(int codActividadProduccion) {
        this.codActividadProduccion = codActividadProduccion;
    }

    public String getNombreActividadProduccion() {
        return nombreActividadProduccion;
    }

    public void setNombreActividadProduccion(String nombreActividadProduccion) {
        this.nombreActividadProduccion = nombreActividadProduccion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public boolean isExterno() {
        return externo;
    }

    public void setExterno(boolean externo) {
        this.externo = externo;
    }
    
    

   

    
    
    
}
