/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Computer
 */
@XmlRootElement
public class SalidasVenta extends bean{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    int codSalidaVenta = 0;    
    int nroDocumento = 0;
    String fechaSalidaVenta = sdf.format(new Date());
    Double tipoCambio = 0.0;
    TiposSalidaVenta tiposSalidaVenta = new TiposSalidaVenta();
    Clientes clientes = new Clientes();
    Personal personalAutoriza = new Personal();
    Personal personalRecibe = new Personal();
    String glosa = "";    
    EstadosSalidaVenta estadosSalidaVenta = new EstadosSalidaVenta();
    Gestion gestion = new Gestion();
    AlmacenesVenta almacenesVenta = new AlmacenesVenta();
    int nroSalidaVenta = 0;
    int codFacturaEmitida = 0;
    int nroFactura = 0; 
    Personal personalVenta = new Personal();//encargado
    TiposVenta tiposVenta = new TiposVenta();
    TiposPago tiposPago = new TiposPago();
    String fechaPagoCredito = new String();
    Double montoSubTotal = 0.0; //monto antes de descuentos o rebajas
    Double montoDescuento = 0.0;
    Double montoTotal = 0.0;//monto total a llegar
    Double montoCancelado = 0.0;//monto inicial cancelado
    Double montoAmortizado = 0.0;//monto que se va incrementando hasta que llegue al total
    Double porcDescuento = 0.0;
    Double montoPorCobrar = 0.0;//monto por cobrar pendiente
    int ventaCompleta = 0;//se realizaron todos los pagos
    int conFacturaEmitida = 0;
    TiposDocumento tiposDocumento= new TiposDocumento();
    LibroVentas libroVentas = new LibroVentas();
    String fechaSalidaVentaInicio = sdf.format(new Date());
    String fechaSalidaVentaFinal = sdf.format(new Date());
    
    
    
    
    
    

    public int getCodSalidaVenta() {
        return codSalidaVenta;
    }

    public void setCodSalidaVenta(int codSalidaVenta) {
        this.codSalidaVenta = codSalidaVenta;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getFechaSalidaVenta() {
        return fechaSalidaVenta;
    }

    public void setFechaSalidaVenta(String fechaSalidaVenta) {
        this.fechaSalidaVenta = fechaSalidaVenta;
    }

    public Double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public TiposSalidaVenta getTiposSalidaVenta() {
        return tiposSalidaVenta;
    }

    public void setTiposSalidaVenta(TiposSalidaVenta tiposSalidaVenta) {
        this.tiposSalidaVenta = tiposSalidaVenta;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Personal getPersonalAutoriza() {
        return personalAutoriza;
    }

    public void setPersonalAutoriza(Personal personalAutoriza) {
        this.personalAutoriza = personalAutoriza;
    }

    public Personal getPersonalRecibe() {
        return personalRecibe;
    }

    public void setPersonalRecibe(Personal personalRecibe) {
        this.personalRecibe = personalRecibe;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public EstadosSalidaVenta getEstadosSalidaVenta() {
        return estadosSalidaVenta;
    }

    public void setEstadosSalidaVenta(EstadosSalidaVenta estadosSalidaVenta) {
        this.estadosSalidaVenta = estadosSalidaVenta;
    }

    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }

    public AlmacenesVenta getAlmacenesVenta() {
        return almacenesVenta;
    }

    public void setAlmacenesVenta(AlmacenesVenta almacenesVenta) {
        this.almacenesVenta = almacenesVenta;
    }

    public int getNroSalidaVenta() {
        return nroSalidaVenta;
    }

    public void setNroSalidaVenta(int nroSalidaVenta) {
        this.nroSalidaVenta = nroSalidaVenta;
    }

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

    public TiposVenta getTiposVenta() {
        return tiposVenta;
    }

    public void setTiposVenta(TiposVenta tiposVenta) {
        this.tiposVenta = tiposVenta;
    }


    public Personal getPersonalVenta() {
        return personalVenta;
    }

    public void setPersonalVenta(Personal personalVenta) {
        this.personalVenta = personalVenta;
    }

    public TiposPago getTiposPago() {
        return tiposPago;
    }

    public void setTiposPago(TiposPago tiposPago) {
        this.tiposPago = tiposPago;
    }

    public String getFechaPagoCredito() {
        return fechaPagoCredito;
    }

    public void setFechaPagoCredito(String fechaPagoCredito) {
        this.fechaPagoCredito = fechaPagoCredito;
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

    public Double getMontoCancelado() {
        return montoCancelado;
    }

    public void setMontoCancelado(Double montoCancelado) {
        this.montoCancelado = montoCancelado;
    }

    public Double getMontoAmortizado() {
        return montoAmortizado;
    }

    public void setMontoAmortizado(Double montoAmortizado) {
        this.montoAmortizado = montoAmortizado;
    }

    public Double getMontoPorCobrar() {
        return montoPorCobrar;
    }

    public void setMontoPorCobrar(Double montoPorCobrar) {
        this.montoPorCobrar = montoPorCobrar;
    }

    public Double getPorcDescuento() {
        return porcDescuento;
    }

    public void setPorcDescuento(Double porcDescuento) {
        this.porcDescuento = porcDescuento;
    }

    public int getVentaCompleta() {
        return ventaCompleta;
    }

    public void setVentaCompleta(int ventaCompleta) {
        this.ventaCompleta = ventaCompleta;
    }

    public int getConFacturaEmitida() {
        return conFacturaEmitida;
    }

    public void setConFacturaEmitida(int conFacturaEmitida) {
        this.conFacturaEmitida = conFacturaEmitida;
    }

    public TiposDocumento getTiposDocumento() {
        return tiposDocumento;
    }

    public void setTiposDocumento(TiposDocumento tiposDocumento) {
        this.tiposDocumento = tiposDocumento;
    }

    public LibroVentas getLibroVentas() {
        return libroVentas;
    }

    public void setLibroVentas(LibroVentas libroVentas) {
        this.libroVentas = libroVentas;
    }

    public String getFechaSalidaVentaInicio() {
        return fechaSalidaVentaInicio;
    }

    public void setFechaSalidaVentaInicio(String fechaSalidaVentaInicio) {
        this.fechaSalidaVentaInicio = fechaSalidaVentaInicio;
    }

    public String getFechaSalidaVentaFinal() {
        return fechaSalidaVentaFinal;
    }

    public void setFechaSalidaVentaFinal(String fechaSalidaVentaFinal) {
        this.fechaSalidaVentaFinal = fechaSalidaVentaFinal;
    }

    
    
            
    
    
    
    

    
    
    
    
            
            
}
