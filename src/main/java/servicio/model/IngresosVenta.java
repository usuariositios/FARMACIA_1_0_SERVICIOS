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
public class IngresosVenta extends bean{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
    AlmacenesVenta almacenesVenta = new AlmacenesVenta();
    int codIngresoVenta = 0;
    int nroIngresoVenta = 0;
    int conIva = 0;
    String nroFacturaProveedor = "";
    String fechaIngresoVenta = sdf.format(new Date());
    Double tipoCambio = 0.0;
    TiposFuentePago tiposFuentePago = new TiposFuentePago();
    TiposIngresoVenta tiposIngresoVenta = new TiposIngresoVenta();
    Proveedores proveedores = new Proveedores();
    String glosa = "";
    Personal personalAutoriza = new Personal();
    Personal personalRecibe = new Personal();
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    Gestion gestion = new Gestion();
    EstadosIngresoVenta estadosIngresoVenta = new EstadosIngresoVenta();
    OrdenesCompra ordenesCompra = new OrdenesCompra();
    String fechaIngresoVentaInicio = sdf.format(new Date());
    String fechaIngresoVentaFinal = sdf.format(new Date());
    int codLibroCompras = 0;//libro de compras de contabilidad (nota: debido a que esta en un servicio externo se guardara la referencia de la tabla)
    int codReciboCompras = 0;
    TiposDocumento tiposDocumento = new TiposDocumento();
    LibroCompras libroCompras = new LibroCompras();
    ReciboCompras reciboCompras = new ReciboCompras();
    
    
    
    
    

    public AlmacenesVenta getAlmacenesVenta() {
        return almacenesVenta;
    }

    public void setAlmacenesVenta(AlmacenesVenta almacenesVenta) {
        this.almacenesVenta = almacenesVenta;
    }

    public int getCodIngresoVenta() {
        return codIngresoVenta;
    }

    public void setCodIngresoVenta(int codIngresoVenta) {
        this.codIngresoVenta = codIngresoVenta;
    }

    public int getNroIngresoVenta() {
        return nroIngresoVenta;
    }

    public void setNroIngresoVenta(int nroIngresoVenta) {
        this.nroIngresoVenta = nroIngresoVenta;
    }

    public int getConIva() {
        return conIva;
    }

    public void setConIva(int conIva) {
        this.conIva = conIva;
    }

    public String getNroFacturaProveedor() {
        return nroFacturaProveedor;
    }

    public void setNroFacturaProveedor(String nroFacturaProveedor) {
        this.nroFacturaProveedor = nroFacturaProveedor;
    }

    public String getFechaIngresoVenta() {
        return fechaIngresoVenta;
    }

    public void setFechaIngresoVenta(String fechaIngresoVenta) {
        this.fechaIngresoVenta = fechaIngresoVenta;
    }

    public Double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public TiposFuentePago getTiposFuentePago() {
        return tiposFuentePago;
    }

    public void setTiposFuentePago(TiposFuentePago tiposFuentePago) {
        this.tiposFuentePago = tiposFuentePago;
    }

    public TiposIngresoVenta getTiposIngresoVenta() {
        return tiposIngresoVenta;
    }

    public void setTiposIngresoVenta(TiposIngresoVenta tiposIngresoVenta) {
        this.tiposIngresoVenta = tiposIngresoVenta;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
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

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

   

    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }

    public EstadosIngresoVenta getEstadosIngresoVenta() {
        return estadosIngresoVenta;
    }

    public void setEstadosIngresoVenta(EstadosIngresoVenta estadosIngresoVenta) {
        this.estadosIngresoVenta = estadosIngresoVenta;
    }

    public OrdenesCompra getOrdenesCompra() {
        return ordenesCompra;
    }

    public void setOrdenesCompra(OrdenesCompra ordenesCompra) {
        this.ordenesCompra = ordenesCompra;
    }

    public String getFechaIngresoVentaInicio() {
        return fechaIngresoVentaInicio;
    }

    public void setFechaIngresoVentaInicio(String fechaIngresoVentaInicio) {
        this.fechaIngresoVentaInicio = fechaIngresoVentaInicio;
    }

    public String getFechaIngresoVentaFinal() {
        return fechaIngresoVentaFinal;
    }

    public void setFechaIngresoVentaFinal(String fechaIngresoVentaFinal) {
        this.fechaIngresoVentaFinal = fechaIngresoVentaFinal;
    }

    public int getCodLibroCompras() {
        return codLibroCompras;
    }

    public void setCodLibroCompras(int codLibroCompras) {
        this.codLibroCompras = codLibroCompras;
    }

    public int getCodReciboCompras() {
        return codReciboCompras;
    }

    public void setCodReciboCompras(int codReciboCompras) {
        this.codReciboCompras = codReciboCompras;
    }

    public TiposDocumento getTiposDocumento() {
        return tiposDocumento;
    }

    public void setTiposDocumento(TiposDocumento tiposDocumento) {
        this.tiposDocumento = tiposDocumento;
    }

    public LibroCompras getLibroCompras() {
        return libroCompras;
    }

    public void setLibroCompras(LibroCompras libroCompras) {
        this.libroCompras = libroCompras;
    }

    public ReciboCompras getReciboCompras() {
        return reciboCompras;
    }

    public void setReciboCompras(ReciboCompras reciboCompras) {
        this.reciboCompras = reciboCompras;
    }
    
    
    
    
    

    
}
