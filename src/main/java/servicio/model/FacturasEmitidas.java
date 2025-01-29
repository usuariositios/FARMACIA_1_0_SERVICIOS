/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author COMPUTER
 */
public class FacturasEmitidas extends bean{
    int codFacturaEmitida = 0;
    int nroFactura = 0;
    String razonSocial = "";
    String nitCliente = "";
    String nroAutorizacion = "";
    String fechaFactura = "";
    Double montoSubTotal = 0.0;
    Double montoDescuento = 0.0;
    Double montoTotal = 0.0;
    String codigoControl = "";
    FacturaDosificacion facturaDosificacion = new FacturaDosificacion();
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    @JsonIgnore
    SalidasVenta salidasVenta = new SalidasVenta();
    Double montoIva = 0.0;
    Double montoEfectivo = 0.0;
    Double montoVuelto = 0.0;
    TiposPago tiposPago = new TiposPago();
    

    public int getCodFacturaEmitida() {
        return codFacturaEmitida;
    }

    public void setCodFacturaEmitida(int codFacturaEmitida) {
        this.codFacturaEmitida = codFacturaEmitida;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getNroAutorizacion() {
        return nroAutorizacion;
    }

    public void setNroAutorizacion(String nroAutorizacion) {
        this.nroAutorizacion = nroAutorizacion;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Double getMontoSubTotal() {
        return montoSubTotal;
    }

    public void setMontoSubTotal(Double montoSubTotal) {
        this.montoSubTotal = montoSubTotal;
    }

    public Double getMontoDescuento() {
        return montoDescuento;
    }

    public void setMontoDescuento(Double montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getCodigoControl() {
        return codigoControl;
    }

    public void setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
    }

    public FacturaDosificacion getFacturaDosificacion() {
        return facturaDosificacion;
    }

    public void setFacturaDosificacion(FacturaDosificacion facturaDosificacion) {
        this.facturaDosificacion = facturaDosificacion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public SalidasVenta getSalidasVenta() {
        return salidasVenta;
    }

    public void setSalidasVenta(SalidasVenta salidasVenta) {
        this.salidasVenta = salidasVenta;
    }

    public Double getMontoIva() {
        return montoIva;
    }

    public void setMontoIva(Double montoIva) {
        this.montoIva = montoIva;
    }

    public Double getMontoEfectivo() {
        return montoEfectivo;
    }

    public void setMontoEfectivo(Double montoEfectivo) {
        this.montoEfectivo = montoEfectivo;
    }

    public Double getMontoVuelto() {
        return montoVuelto;
    }

    public void setMontoVuelto(Double montoVuelto) {
        this.montoVuelto = montoVuelto;
    }

    public TiposPago getTiposPago() {
        return tiposPago;
    }

    public void setTiposPago(TiposPago tiposPago) {
        this.tiposPago = tiposPago;
    }
    
}
