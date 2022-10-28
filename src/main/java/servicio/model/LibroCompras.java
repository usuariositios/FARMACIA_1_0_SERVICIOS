/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author HENRY
 */
public class LibroCompras extends bean {
    int codLibroCompras = 0;
    
    Proveedores proveedores = new Proveedores();
    String nroFactura = "";
    String nroOrden = "";
    String fechaLibro = "";
    Double totalFactura = 0.0;
    Double ice = 0.0;
    Double importesExcentos = 0.0;
    Double importeCreditoFiscal = 0.0;
    String nroAutorizacion = "";
    
    String nroPoliza = "";
    int codCajaChica = 0;
    int codCajaChicaDetalle = 0;
    int codRendicion = 0;
    int codRendicionDetalle = 0;
    Double importeNoSujetoCreditoFiscal = 0.0;
    Double descuentosBonificaciones = 0.0;
    String codigoControl = "";
    
    String DUI = "";
    String especificacion = "";    
    int nroDUI = 0;    
    int numero = 0;
    Double importeSubTotal = 0.0;
    Double importeBaseCreditoFiscal = 0.0;
    String fechaLibro2 = "";
    Double importePagado = 0.0;
    
    
    

    public int getCodLibroCompras() {
        return codLibroCompras;
    }

    public void setCodLibroCompras(int codLibroCompras) {
        this.codLibroCompras = codLibroCompras;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }
    
    

   

    

   

    public String getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(String nroOrden) {
        this.nroOrden = nroOrden;
    }

    public String getFechaLibro() {
        return fechaLibro;
    }

    public void setFechaLibro(String fechaLibro) {
        this.fechaLibro = fechaLibro;
    }

    public Double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(Double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Double getIce() {
        return ice;
    }

    public void setIce(Double ice) {
        this.ice = ice;
    }

    public Double getImportesExcentos() {
        return importesExcentos;
    }

    public void setImportesExcentos(Double importesExcentos) {
        this.importesExcentos = importesExcentos;
    }

    public Double getImporteCreditoFiscal() {
        return importeCreditoFiscal;
    }

    public void setImporteCreditoFiscal(Double importeCreditoFiscal) {
        this.importeCreditoFiscal = importeCreditoFiscal;
    }

   

    public String getNroAutorizacion() {
        return nroAutorizacion;
    }

    public void setNroAutorizacion(String nroAutorizacion) {
        this.nroAutorizacion = nroAutorizacion;
    }

    

    public String getNroPoliza() {
        return nroPoliza;
    }

    public void setNroPoliza(String nroPoliza) {
        this.nroPoliza = nroPoliza;
    }

    public int getCodCajaChica() {
        return codCajaChica;
    }

    public void setCodCajaChica(int codCajaChica) {
        this.codCajaChica = codCajaChica;
    }

    public int getCodCajaChicaDetalle() {
        return codCajaChicaDetalle;
    }

    public void setCodCajaChicaDetalle(int codCajaChicaDetalle) {
        this.codCajaChicaDetalle = codCajaChicaDetalle;
    }

    public int getCodRendicion() {
        return codRendicion;
    }

    public void setCodRendicion(int codRendicion) {
        this.codRendicion = codRendicion;
    }

    public int getCodRendicionDetalle() {
        return codRendicionDetalle;
    }

    public void setCodRendicionDetalle(int codRendicionDetalle) {
        this.codRendicionDetalle = codRendicionDetalle;
    }

    public Double getImporteNoSujetoCreditoFiscal() {
        return importeNoSujetoCreditoFiscal;
    }

    public void setImporteNoSujetoCreditoFiscal(Double importeNoSujetoCreditoFiscal) {
        this.importeNoSujetoCreditoFiscal = importeNoSujetoCreditoFiscal;
    }

    public Double getDescuentosBonificaciones() {
        return descuentosBonificaciones;
    }

    public void setDescuentosBonificaciones(Double descuentosBonificaciones) {
        this.descuentosBonificaciones = descuentosBonificaciones;
    }

    public String getCodigoControl() {
        return codigoControl;
    }

    public void setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public int getNroDUI() {
        return nroDUI;
    }

    public void setNroDUI(int nroDUI) {
        this.nroDUI = nroDUI;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Double getImporteSubTotal() {
        return importeSubTotal;
    }

    public void setImporteSubTotal(Double importeSubTotal) {
        this.importeSubTotal = importeSubTotal;
    }
   
    public Double getImporteBaseCreditoFiscal() {
        return importeBaseCreditoFiscal;
    }

    public void setImporteBaseCreditoFiscal(Double importeBaseCreditoFiscal) {
        this.importeBaseCreditoFiscal = importeBaseCreditoFiscal;
    }

    public String getFechaLibro2() {
        return fechaLibro2;
    }

    public void setFechaLibro2(String fechaLibro2) {
        this.fechaLibro2 = fechaLibro2;
    }

    public Double getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(Double importePagado) {
        this.importePagado = importePagado;
    }

    
    
    
    
    
    
}
