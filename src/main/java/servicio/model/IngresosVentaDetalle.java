/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Computer
 */
@XmlRootElement

public class IngresosVentaDetalle extends bean{
    //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
    AlmacenesVenta almacenesVenta = new AlmacenesVenta();
    IngresosVenta ingresosVenta = new IngresosVenta();
    Productos productos = new Productos();
    Double cantIngreso = 0.0;
    Double totalMonto = 0.0;
    Double precioCompra = 0.0;
    Double precioVenta = 0.0;
    Double subTotalMonto = 0.0;
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    Double cantRestante = 0.0;
    String glosa = "";
    UnidadesMedida unidadesMedida = new UnidadesMedida();
    String nroLote = "";
    TiposEnvase tiposEnvase = new TiposEnvase();
    String fechaFabricacion = "";
    String fechaVencimiento = "";
    Double porcentajeDescuento = 0.0;
    
            
    

   

    public AlmacenesVenta getAlmacenesVenta() {
        return almacenesVenta;
    }

    public void setAlmacenesVenta(AlmacenesVenta almacenesVenta) {
        this.almacenesVenta = almacenesVenta;
    }

    public IngresosVenta getIngresosVenta() {
        return ingresosVenta;
    }

    public void setIngresosVenta(IngresosVenta ingresosVenta) {
        this.ingresosVenta = ingresosVenta;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Double getCantIngreso() {
        return cantIngreso;
    }

    public void setCantIngreso(Double cantIngreso) {
        this.cantIngreso = cantIngreso;
    }

    public Double getTotalMonto() {
        return totalMonto;
    }

    public void setTotalMonto(Double totalMonto) {
        this.totalMonto = totalMonto;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    

    public Double getSubTotalMonto() {
        return subTotalMonto;
    }

    public void setSubTotalMonto(Double subTotalMonto) {
        this.subTotalMonto = subTotalMonto;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public Double getCantRestante() {
        return cantRestante;
    }

    public void setCantRestante(Double cantRestante) {
        this.cantRestante = cantRestante;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public UnidadesMedida getUnidadesMedida() {
        return unidadesMedida;
    }

    public void setUnidadesMedida(UnidadesMedida unidadesMedida) {
        this.unidadesMedida = unidadesMedida;
    }

    public String getNroLote() {
        return nroLote;
    }

    public void setNroLote(String nroLote) {
        this.nroLote = nroLote;
    }

    public TiposEnvase getTiposEnvase() {
        return tiposEnvase;
    }

    public void setTiposEnvase(TiposEnvase tiposEnvase) {
        this.tiposEnvase = tiposEnvase;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
}
