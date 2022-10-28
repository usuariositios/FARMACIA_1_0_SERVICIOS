/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author OSCAR VALDIVIA
 */
@XmlRootElement

public class Materiales extends bean{
    int codMaterial = 0;
    GruposMaterial gruposMaterial = new GruposMaterial();
    UnidadesMedida unidadesMedida = new UnidadesMedida();
    UnidadesMedida unidadesMedidaCompra = new UnidadesMedida();
    String nombreMaterial = "";
    double stockMinimoMaterial = 0.0;
    double stockMaximoMaterial = 0.0;
    double stockSeguridad = 0.0;
    String color = "";
    String capacidad = "";
    String gramaje = "";
    int materialAlmacen = 0;
    int materialMuestreo = 0;
    double cantidadMinimaMuestreo = 0.0;
    double cantidadMaximaMuestreo = 0.0;
    double costoUnitario = 0.0;
    int materialProduccion = 0;
    String observacion = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    Date fechaRegistro = new Date();
    String codigoMaterial = "";
    int movimientoItem = 0;
    Personal personal = new Personal();
    String excluirMateriales = "";//materiales que se excluiran en la busqueda de materiales
    
    
    
    public int getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(int codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public UnidadesMedida getUnidadesMedida() {
        return unidadesMedida;
    }

    public void setUnidadesMedida(UnidadesMedida unidadesMedida) {
        this.unidadesMedida = unidadesMedida;
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public UnidadesMedida getUnidadesMedidaCompra() {
        return unidadesMedidaCompra;
    }

    public void setUnidadesMedidaCompra(UnidadesMedida unidadesMedidaCompra) {
        this.unidadesMedidaCompra = unidadesMedidaCompra;
    }

    public GruposMaterial getGruposMaterial() {
        return gruposMaterial;
    }

    public void setGruposMaterial(GruposMaterial gruposMaterial) {
        this.gruposMaterial = gruposMaterial;
    }

    public double getStockMinimoMaterial() {
        return stockMinimoMaterial;
    }

    public void setStockMinimoMaterial(double stockMinimoMaterial) {
        this.stockMinimoMaterial = stockMinimoMaterial;
    }

    public double getStockMaximoMaterial() {
        return stockMaximoMaterial;
    }

    public void setStockMaximoMaterial(double stockMaximoMaterial) {
        this.stockMaximoMaterial = stockMaximoMaterial;
    }

    public double getStockSeguridad() {
        return stockSeguridad;
    }

    public void setStockSeguridad(double stockSeguridad) {
        this.stockSeguridad = stockSeguridad;
    }

    public int getMaterialAlmacen() {
        return materialAlmacen;
    }

    public void setMaterialAlmacen(int materialAlmacen) {
        this.materialAlmacen = materialAlmacen;
    }

    public int getMaterialMuestreo() {
        return materialMuestreo;
    }

    public void setMaterialMuestreo(int materialMuestreo) {
        this.materialMuestreo = materialMuestreo;
    }

    public double getCantidadMinimaMuestreo() {
        return cantidadMinimaMuestreo;
    }

    public void setCantidadMinimaMuestreo(double cantidadMinimaMuestreo) {
        this.cantidadMinimaMuestreo = cantidadMinimaMuestreo;
    }

    public double getCantidadMaximaMuestreo() {
        return cantidadMaximaMuestreo;
    }

    public void setCantidadMaximaMuestreo(double cantidadMaximaMuestreo) {
        this.cantidadMaximaMuestreo = cantidadMaximaMuestreo;
    }

    public int getMaterialProduccion() {
        return materialProduccion;
    }

    public void setMaterialProduccion(int materialProduccion) {
        this.materialProduccion = materialProduccion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getGramaje() {
        return gramaje;
    }

    public void setGramaje(String gramaje) {
        this.gramaje = gramaje;
    }

    

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public int getMovimientoItem() {
        return movimientoItem;
    }

    public void setMovimientoItem(int movimientoItem) {
        this.movimientoItem = movimientoItem;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public String getExcluirMateriales() {
        return excluirMateriales;
    }

    public void setExcluirMateriales(String excluirMateriales) {
        this.excluirMateriales = excluirMateriales;
    }

   
    
    
    
    
    
    
    
    
           
    
}
