/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class OrdenProduccion extends bean{
    int codOrdenProduccion = 0;
    int codigoOrdenProduccion1 = 0;
    String codigoOrdenProduccion2 = "";
    Cotizacion cotizacion = new Cotizacion();
    ProductoSemiterminado productoSemiterminado = new ProductoSemiterminado();
    Date fechaRegistro = new Date();
    TiposPrioridad tiposPrioridad = new TiposPrioridad();
    int cantidadProductos = 0;
    Date fechaEntrega = new Date();
    EstadosOrdenProduccion estadosOrdenProduccion = new EstadosOrdenProduccion();
    String observacion = "";
    List<OrdenProduccionTallas> ordenProduccionTallasList = new ArrayList<OrdenProduccionTallas>();
    OrdenProduccionDetalleTalla ordenProduccionDetalleTalla = new OrdenProduccionDetalleTalla();
    List<OrdenProduccionActividad> ordenProduccionActividadList = new ArrayList<OrdenProduccionActividad>();
    Personal personal = new Personal();//para buscar la op a que personal se asigno
    int codDetalle = 0;
    Date fechaInicioPersonal = new Date();
    Date fechaFinalPersonal = new Date();
    CotizacionDetalle cotizacionDetalle = new CotizacionDetalle();
    int actvAsignados = 0;
    int actvCumplidos = 0;
    EstadosOrdenProduccionActividad estadosOrdenProduccionActividad = new EstadosOrdenProduccionActividad();//para mostrar el estado a nivel de la actividad asignada
    int actvAsignadosOP = 0;//visualizar las actividades asignadas para la orden de produccion
    int actvCumplidosOP = 0;//visualizar las actividades asignadas para la orden de produccion
    List<OrdenProduccionActividad> ordenProduccionActividadPersonalList = new ArrayList<OrdenProduccionActividad>(); //lista de actividades asignadas por usuario y en la op
    String fichaTecnica = ""; //parametro para op con ficha tecnica
    String fechaRegistro1 = "";//parametro para op con fecha de registro
    
    
    
    

    public int getCodOrdenProduccion() {
        return codOrdenProduccion;
    }

    public void setCodOrdenProduccion(int codOrdenProduccion) {
        this.codOrdenProduccion = codOrdenProduccion;
    }

    public int getCodigoOrdenProduccion1() {
        return codigoOrdenProduccion1;
    }

    public void setCodigoOrdenProduccion1(int codigoOrdenProduccion1) {
        this.codigoOrdenProduccion1 = codigoOrdenProduccion1;
    }

    public String getCodigoOrdenProduccion2() {
        return codigoOrdenProduccion2;
    }

    public void setCodigoOrdenProduccion2(String codigoOrdenProduccion2) {
        this.codigoOrdenProduccion2 = codigoOrdenProduccion2;
    }

    

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public ProductoSemiterminado getProductoSemiterminado() {
        return productoSemiterminado;
    }

    public void setProductoSemiterminado(ProductoSemiterminado productoSemiterminado) {
        this.productoSemiterminado = productoSemiterminado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public TiposPrioridad getTiposPrioridad() {
        return tiposPrioridad;
    }

    public void setTiposPrioridad(TiposPrioridad tiposPrioridad) {
        this.tiposPrioridad = tiposPrioridad;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public EstadosOrdenProduccion getEstadosOrdenProduccion() {
        return estadosOrdenProduccion;
    }

    public void setEstadosOrdenProduccion(EstadosOrdenProduccion estadosOrdenProduccion) {
        this.estadosOrdenProduccion = estadosOrdenProduccion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public List<OrdenProduccionTallas> getOrdenProduccionTallasList() {
        return ordenProduccionTallasList;
    }

    public void setOrdenProduccionTallasList(List<OrdenProduccionTallas> ordenProduccionTallasList) {
        this.ordenProduccionTallasList = ordenProduccionTallasList;
    }

    public OrdenProduccionDetalleTalla getOrdenProduccionDetalleTalla() {
        return ordenProduccionDetalleTalla;
    }

    public void setOrdenProduccionDetalleTalla(OrdenProduccionDetalleTalla ordenProduccionDetalleTalla) {
        this.ordenProduccionDetalleTalla = ordenProduccionDetalleTalla;
    }

    public List<OrdenProduccionActividad> getOrdenProduccionActividadList() {
        return ordenProduccionActividadList;
    }

    public void setOrdenProduccionActividadList(List<OrdenProduccionActividad> ordenProduccionActividadList) {
        this.ordenProduccionActividadList = ordenProduccionActividadList;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public int getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(int codDetalle) {
        this.codDetalle = codDetalle;
    }

    public Date getFechaInicioPersonal() {
        return fechaInicioPersonal;
    }

    public void setFechaInicioPersonal(Date fechaInicioPersonal) {
        this.fechaInicioPersonal = fechaInicioPersonal;
    }

    public Date getFechaFinalPersonal() {
        return fechaFinalPersonal;
    }

    public void setFechaFinalPersonal(Date fechaFinalPersonal) {
        this.fechaFinalPersonal = fechaFinalPersonal;
    }

    public CotizacionDetalle getCotizacionDetalle() {
        return cotizacionDetalle;
    }

    public void setCotizacionDetalle(CotizacionDetalle cotizacionDetalle) {
        this.cotizacionDetalle = cotizacionDetalle;
    }

    public int getActvAsignados() {
        return actvAsignados;
    }

    public void setActvAsignados(int actvAsignados) {
        this.actvAsignados = actvAsignados;
    }

    public int getActvCumplidos() {
        return actvCumplidos;
    }

    public void setActvCumplidos(int actvCumplidos) {
        this.actvCumplidos = actvCumplidos;
    }

    public EstadosOrdenProduccionActividad getEstadosOrdenProduccionActividad() {
        return estadosOrdenProduccionActividad;
    }

    public void setEstadosOrdenProduccionActividad(EstadosOrdenProduccionActividad estadosOrdenProduccionActividad) {
        this.estadosOrdenProduccionActividad = estadosOrdenProduccionActividad;
    }

    public int getActvAsignadosOP() {
        return actvAsignadosOP;
    }

    public void setActvAsignadosOP(int actvAsignadosOP) {
        this.actvAsignadosOP = actvAsignadosOP;
    }

    public int getActvCumplidosOP() {
        return actvCumplidosOP;
    }

    public void setActvCumplidosOP(int actvCumplidosOP) {
        this.actvCumplidosOP = actvCumplidosOP;
    }

    public List<OrdenProduccionActividad> getOrdenProduccionActividadPersonalList() {
        return ordenProduccionActividadPersonalList;
    }

    public void setOrdenProduccionActividadPersonalList(List<OrdenProduccionActividad> ordenProduccionActividadPersonalList) {
        this.ordenProduccionActividadPersonalList = ordenProduccionActividadPersonalList;
    }

    public String getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(String fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }

    public String getFechaRegistro1() {
        return fechaRegistro1;
    }

    public void setFechaRegistro1(String fechaRegistro1) {
        this.fechaRegistro1 = fechaRegistro1;
    }

    
   
   
    
    

    
    

    
    
}
