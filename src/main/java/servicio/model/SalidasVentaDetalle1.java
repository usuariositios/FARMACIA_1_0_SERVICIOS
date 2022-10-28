/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;


import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Computer
 */
public class SalidasVentaDetalle1 extends bean{
    SalidasVenta salidasVenta = new SalidasVenta();
    Productos productos = new Productos();
    double cantSalida = 0.0;
    double costoUnitario = 0.0;
    double montoSubTotal = 0.0;
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    UnidadesMedida unidadesMedida = new UnidadesMedida();
    IngresosVentaDetalle ingresosVentaDetalle = new IngresosVentaDetalle();
    
    
    double porcDescuento = 0.0;
    double montoDescuento=0.0;
    double montoTotal = 0.0;
    double cantRetornar = 0.0;//cantidad a retornar a partir de una venta
    int eliminar = 0;//flag que indica si se eliminara la fila detalle
    
    
    
    
    
    
    

    public SalidasVenta getSalidasVenta() {
        return salidasVenta;
    }

    public void setSalidasVenta(SalidasVenta salidasVenta) {
        this.salidasVenta = salidasVenta;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public double getCantSalida() {
        return cantSalida;
    }

    public void setCantSalida(double cantSalida) {
        this.cantSalida = cantSalida;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double getMontoSubTotal() {
        return montoSubTotal;
    }

    public void setMontoSubTotal(double montoSubTotal) {
        this.montoSubTotal = montoSubTotal;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public UnidadesMedida getUnidadesMedida() {
        return unidadesMedida;
    }

    public void setUnidadesMedida(UnidadesMedida unidadesMedida) {
        this.unidadesMedida = unidadesMedida;
    }

    public IngresosVentaDetalle getIngresosVentaDetalle() {
        return ingresosVentaDetalle;
    }

    public void setIngresosVentaDetalle(IngresosVentaDetalle ingresosVentaDetalle) {
        this.ingresosVentaDetalle = ingresosVentaDetalle;
    }

    

    public double getPorcDescuento() {
        return porcDescuento;
    }

    public void setPorcDescuento(double porcDescuento) {
        this.porcDescuento = porcDescuento;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(double montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public double getCantRetornar() {
        return cantRetornar;
    }

    public void setCantRetornar(double cantRetornar) {
        this.cantRetornar = cantRetornar;
    }

    public int getEliminar() {
        return eliminar;
    }

    public void setEliminar(int eliminar) {
        this.eliminar = eliminar;
    }

    
    

    
    
    
}
