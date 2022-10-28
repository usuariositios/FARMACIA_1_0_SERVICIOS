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
public class FichaTecnicaProducto extends bean{
    int codFichaTecnica = 0;
    ProductoSemiterminado productoSemiterminado = new ProductoSemiterminado();
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    String direccionPresentacion = "";
    String direccionMaterialesColores = "";
    String direccionConstruccion = "";
    String direccionMedidasAntesLavar = "";
    String direccionMedidasDespuesLavar = "";
    OrdenProduccion ordenProduccion = new OrdenProduccion();
    Date fechaActualizacionPresentacion = new Date();
    Date fechaActualizacionMaterialesColores = new Date();
    Date fechaActualizacionConstruccion = new Date();
    Date fechaActualizacionMedidasAntesLavar = new Date();
    Date fechaActualizacionMedidasDespuesLavar = new Date();
    String direccionEmpaque = "";
    String direccionTiempos = "";
    Date fechaActualizacionEmpaque = new Date();
    Date fechaActualizacionTiempos = new Date();
    String direccionArtes = "";
    Date fechaActualizacionArtes = new Date();
    String scroll = "";//variable para mover el scroll
    
    
    
    
    
    

    public int getCodFichaTecnica() {
        return codFichaTecnica;
    }

    public void setCodFichaTecnica(int codFichaTecnica) {
        this.codFichaTecnica = codFichaTecnica;
    }

    public ProductoSemiterminado getProductoSemiterminado() {
        return productoSemiterminado;
    }

    public void setProductoSemiterminado(ProductoSemiterminado productoSemiterminado) {
        this.productoSemiterminado = productoSemiterminado;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public String getDireccionPresentacion() {
        return direccionPresentacion;
    }

    public void setDireccionPresentacion(String direccionPresentacion) {
        this.direccionPresentacion = direccionPresentacion;
    }

    public String getDireccionMaterialesColores() {
        return direccionMaterialesColores;
    }

    public void setDireccionMaterialesColores(String direccionMaterialesColores) {
        this.direccionMaterialesColores = direccionMaterialesColores;
    }

    public String getDireccionConstruccion() {
        return direccionConstruccion;
    }

    public void setDireccionConstruccion(String direccionConstruccion) {
        this.direccionConstruccion = direccionConstruccion;
    }

    public String getDireccionMedidasAntesLavar() {
        return direccionMedidasAntesLavar;
    }

    public void setDireccionMedidasAntesLavar(String direccionMedidasAntesLavar) {
        this.direccionMedidasAntesLavar = direccionMedidasAntesLavar;
    }

    public String getDireccionMedidasDespuesLavar() {
        return direccionMedidasDespuesLavar;
    }

    public void setDireccionMedidasDespuesLavar(String direccionMedidasDespuesLavar) {
        this.direccionMedidasDespuesLavar = direccionMedidasDespuesLavar;
    }

    public OrdenProduccion getOrdenProduccion() {
        return ordenProduccion;
    }

    public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
        this.ordenProduccion = ordenProduccion;
    }

    public Date getFechaActualizacionPresentacion() {
        return fechaActualizacionPresentacion;
    }

    public void setFechaActualizacionPresentacion(Date fechaActualizacionPresentacion) {
        this.fechaActualizacionPresentacion = fechaActualizacionPresentacion;
    }

    public Date getFechaActualizacionMaterialesColores() {
        return fechaActualizacionMaterialesColores;
    }

    public void setFechaActualizacionMaterialesColores(Date fechaActualizacionMaterialesColores) {
        this.fechaActualizacionMaterialesColores = fechaActualizacionMaterialesColores;
    }

    public Date getFechaActualizacionConstruccion() {
        return fechaActualizacionConstruccion;
    }

    public void setFechaActualizacionConstruccion(Date fechaActualizacionConstruccion) {
        this.fechaActualizacionConstruccion = fechaActualizacionConstruccion;
    }

    public Date getFechaActualizacionMedidasAntesLavar() {
        return fechaActualizacionMedidasAntesLavar;
    }

    public void setFechaActualizacionMedidasAntesLavar(Date fechaActualizacionMedidasAntesLavar) {
        this.fechaActualizacionMedidasAntesLavar = fechaActualizacionMedidasAntesLavar;
    }

    public Date getFechaActualizacionMedidasDespuesLavar() {
        return fechaActualizacionMedidasDespuesLavar;
    }

    public void setFechaActualizacionMedidasDespuesLavar(Date fechaActualizacionMedidasDespuesLavar) {
        this.fechaActualizacionMedidasDespuesLavar = fechaActualizacionMedidasDespuesLavar;
    }

    public String getDireccionEmpaque() {
        return direccionEmpaque;
    }

    public void setDireccionEmpaque(String direccionEmpaque) {
        this.direccionEmpaque = direccionEmpaque;
    }

    public String getDireccionTiempos() {
        return direccionTiempos;
    }

    public void setDireccionTiempos(String direccionTiempos) {
        this.direccionTiempos = direccionTiempos;
    }

    public Date getFechaActualizacionEmpaque() {
        return fechaActualizacionEmpaque;
    }

    public void setFechaActualizacionEmpaque(Date fechaActualizacionEmpaque) {
        this.fechaActualizacionEmpaque = fechaActualizacionEmpaque;
    }

    public Date getFechaActualizacionTiempos() {
        return fechaActualizacionTiempos;
    }

    public void setFechaActualizacionTiempos(Date fechaActualizacionTiempos) {
        this.fechaActualizacionTiempos = fechaActualizacionTiempos;
    }

    public String getDireccionArtes() {
        return direccionArtes;
    }

    public void setDireccionArtes(String direccionArtes) {
        this.direccionArtes = direccionArtes;
    }

    public Date getFechaActualizacionArtes() {
        return fechaActualizacionArtes;
    }

    public void setFechaActualizacionArtes(Date fechaActualizacionArtes) {
        this.fechaActualizacionArtes = fechaActualizacionArtes;
    }

    public String getScroll() {
        return scroll;
    }

    public void setScroll(String scroll) {
        this.scroll = scroll;
    }

    

   
    
    
    
    

   
    
    

    
    
    
    
}
