/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.util.Date;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class SeguimientoOrdenProduccion extends bean{
    OrdenProduccion ordenProduccion = new OrdenProduccion();
    ActividadesProduccion actividadesProduccion = new ActividadesProduccion();
    Personal personal = new Personal();
    Date fechaInicio = new Date();
    Date fechaFinal = new Date();
    int codSeguimientoOrdenProduccion = 0;
    TiposTareaProduccion tiposTareaProduccion = new TiposTareaProduccion();
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    OrdenProduccionDetalleTalla ordenProduccionDetalleTalla = new OrdenProduccionDetalleTalla();
    Proveedores proveedores = new Proveedores();
    TiposSaldo tiposSaldo = new TiposSaldo();
    String observacion = "";
    TiposObservacionProduccion tiposObservacionProduccion = new TiposObservacionProduccion();
    

    public OrdenProduccion getOrdenProduccion() {
        return ordenProduccion;
    }

    public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
        this.ordenProduccion = ordenProduccion;
    }

    public ActividadesProduccion getActividadesProduccion() {
        return actividadesProduccion;
    }

    public void setActividadesProduccion(ActividadesProduccion actividadesProduccion) {
        this.actividadesProduccion = actividadesProduccion;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

   

   

    public TiposTareaProduccion getTiposTareaProduccion() {
        return tiposTareaProduccion;
    }

    public void setTiposTareaProduccion(TiposTareaProduccion tiposTareaProduccion) {
        this.tiposTareaProduccion = tiposTareaProduccion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public OrdenProduccionDetalleTalla getOrdenProduccionDetalleTalla() {
        return ordenProduccionDetalleTalla;
    }

    public void setOrdenProduccionDetalleTalla(OrdenProduccionDetalleTalla ordenProduccionDetalleTalla) {
        this.ordenProduccionDetalleTalla = ordenProduccionDetalleTalla;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public int getCodSeguimientoOrdenProduccion() {
        return codSeguimientoOrdenProduccion;
    }

    public void setCodSeguimientoOrdenProduccion(int codSeguimientoOrdenProduccion) {
        this.codSeguimientoOrdenProduccion = codSeguimientoOrdenProduccion;
    }

    public TiposSaldo getTiposSaldo() {
        return tiposSaldo;
    }

    public void setTiposSaldo(TiposSaldo tiposSaldo) {
        this.tiposSaldo = tiposSaldo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public TiposObservacionProduccion getTiposObservacionProduccion() {
        return tiposObservacionProduccion;
    }

    public void setTiposObservacionProduccion(TiposObservacionProduccion tiposObservacionProduccion) {
        this.tiposObservacionProduccion = tiposObservacionProduccion;
    }
    
    
    
    
    
    
    
    
    
    
    
}
