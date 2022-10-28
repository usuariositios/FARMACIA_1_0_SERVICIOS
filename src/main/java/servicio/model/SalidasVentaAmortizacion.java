/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author COMPUTER
 */
public class SalidasVentaAmortizacion {
    SalidasVenta salidasVenta = new SalidasVenta();
    int codAmortizacion = 0;
    Double montoAmortizadoAnterior = 0.0;
    String fechaPago = "";
    Double montoPagado = 0.0;

    public SalidasVenta getSalidasVenta() {
        return salidasVenta;
    }

    public void setSalidasVenta(SalidasVenta salidasVenta) {
        this.salidasVenta = salidasVenta;
    }

    public int getCodAmortizacion() {
        return codAmortizacion;
    }

    public void setCodAmortizacion(int codAmortizacion) {
        this.codAmortizacion = codAmortizacion;
    }

    public Double getMontoAmortizadoAnterior() {
        return montoAmortizadoAnterior;
    }

    public void setMontoAmortizadoAnterior(Double montoAmortizadoAnterior) {
        this.montoAmortizadoAnterior = montoAmortizadoAnterior;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(Double montoPagado) {
        this.montoPagado = montoPagado;
    }
    
}
