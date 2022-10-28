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
public class OrdenProduccionActividad extends bean {
    OrdenProduccion ordenProduccion = new OrdenProduccion();
    ActividadesProduccion actividadesProduccion = new ActividadesProduccion();
    int orden = 0;
    Personal personal = new Personal();
    Date fechaInicio = new Date();
    Date fechaFinal = new Date();
    double horasHombre = 0.0;
    String observaciones = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    int conSeguimiento = 0;
    Proveedores proveedor = new Proveedores();
    PlantaProduccion plantaProduccion = new PlantaProduccion();
    int diasRestantesEntrega = 0;
    EstadosOrdenProduccionActividad estadosOrdenProduccionActividad = new EstadosOrdenProduccionActividad();
    OrdenProduccionDetalleTalla ordenProduccionDetalleTalla = new OrdenProduccionDetalleTalla();
    int totalProductos = 0;
    double minutajeProducto = 0.0;
    
    

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

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
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

    public double getHorasHombre() {
        return horasHombre;
    }

    public void setHorasHombre(double horasHombre) {
        this.horasHombre = horasHombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public int getConSeguimiento() {
        return conSeguimiento;
    }

    public void setConSeguimiento(int conSeguimiento) {
        this.conSeguimiento = conSeguimiento;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    public PlantaProduccion getPlantaProduccion() {
        return plantaProduccion;
    }

    public void setPlantaProduccion(PlantaProduccion plantaProduccion) {
        this.plantaProduccion = plantaProduccion;
    }

    public int getDiasRestantesEntrega() {
        return diasRestantesEntrega;
    }

    public void setDiasRestantesEntrega(int diasRestantesEntrega) {
        this.diasRestantesEntrega = diasRestantesEntrega;
    }

    public EstadosOrdenProduccionActividad getEstadosOrdenProduccionActividad() {
        return estadosOrdenProduccionActividad;
    }

    public void setEstadosOrdenProduccionActividad(EstadosOrdenProduccionActividad estadosOrdenProduccionActividad) {
        this.estadosOrdenProduccionActividad = estadosOrdenProduccionActividad;
    }

    public OrdenProduccionDetalleTalla getOrdenProduccionDetalleTalla() {
        return ordenProduccionDetalleTalla;
    }

    public void setOrdenProduccionDetalleTalla(OrdenProduccionDetalleTalla ordenProduccionDetalleTalla) {
        this.ordenProduccionDetalleTalla = ordenProduccionDetalleTalla;
    }

    public int getTotalProductos() {
        return totalProductos;
    }

    public void setTotalProductos(int totalProductos) {
        this.totalProductos = totalProductos;
    }

    public double getMinutajeProducto() {
        return minutajeProducto;
    }

    public void setMinutajeProducto(double minutajeProducto) {
        this.minutajeProducto = minutajeProducto;
    }
    
    
    
    
    
    
    
    
    
    
    
}
