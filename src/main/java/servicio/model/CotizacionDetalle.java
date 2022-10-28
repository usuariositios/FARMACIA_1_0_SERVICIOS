/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class CotizacionDetalle extends bean{
    Cotizacion cotizacion = new Cotizacion();
    ProductoSemiterminado productoSemiterminado = new ProductoSemiterminado();
    Genero genero = new Genero();
    int cantidadProducto = 0;
    Double precioFob = 0.0;
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    int codDetalle = 0;
    Talla talla = new Talla();
    int[] codTalla;
    Double totalPrecio=0.0;
    OrdenProduccionDetalleTalla ordenProduccionDetalleTalla = new OrdenProduccionDetalleTalla();
    List<CotizacionDetalleTalla> cotizacionDetalleTallaList = new ArrayList<CotizacionDetalleTalla>();
    String observacion = "";
    TiposComposicionProducto tiposComposicionProducto = new TiposComposicionProducto();
    TiposTela tiposTela = new TiposTela();
    ColorProducto colorProducto = new ColorProducto();
    TiposLavado tiposLavado = new TiposLavado();
    Embellecimiento embellecimiento = new Embellecimiento();
    ClienteAreas clienteAreas = new ClienteAreas();
    
    
    

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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    

    public Double getPrecioFob() {
        return precioFob;
    }

    public void setPrecioFob(Double precioFob) {
        this.precioFob = precioFob;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public int getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(int codDetalle) {
        this.codDetalle = codDetalle;
    }

    public Talla getTalla() {
        return talla;
    }

    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    public int[] getCodTalla() {
        return codTalla;
    }

    public void setCodTalla(int[] codTalla) {
        this.codTalla = codTalla;
    }

    public List<CotizacionDetalleTalla> getCotizacionDetalleTallaList() {
        return cotizacionDetalleTallaList;
    }

    public void setCotizacionDetalleTallaList(List<CotizacionDetalleTalla> cotizacionDetalleTallaList) {
        this.cotizacionDetalleTallaList = cotizacionDetalleTallaList;
    }

    public OrdenProduccionDetalleTalla getOrdenProduccionDetalleTalla() {
        return ordenProduccionDetalleTalla;
    }

    public void setOrdenProduccionDetalleTalla(OrdenProduccionDetalleTalla ordenProduccionDetalleTalla) {
        this.ordenProduccionDetalleTalla = ordenProduccionDetalleTalla;
    }

    public Double getTotalPrecio() {
        return totalPrecio;
    }

    public void setTotalPrecio(Double totalPrecio) {
        this.totalPrecio = totalPrecio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public TiposComposicionProducto getTiposComposicionProducto() {
        return tiposComposicionProducto;
    }

    public void setTiposComposicionProducto(TiposComposicionProducto tiposComposicionProducto) {
        this.tiposComposicionProducto = tiposComposicionProducto;
    }

    public TiposTela getTiposTela() {
        return tiposTela;
    }

    public void setTiposTela(TiposTela tiposTela) {
        this.tiposTela = tiposTela;
    }

    public ColorProducto getColorProducto() {
        return colorProducto;
    }

    public void setColorProducto(ColorProducto colorProducto) {
        this.colorProducto = colorProducto;
    }

    public TiposLavado getTiposLavado() {
        return tiposLavado;
    }

    public void setTiposLavado(TiposLavado tiposLavado) {
        this.tiposLavado = tiposLavado;
    }

    public Embellecimiento getEmbellecimiento() {
        return embellecimiento;
    }

    public void setEmbellecimiento(Embellecimiento embellecimiento) {
        this.embellecimiento = embellecimiento;
    }

    public ClienteAreas getClienteAreas() {
        return clienteAreas;
    }

    public void setClienteAreas(ClienteAreas clienteAreas) {
        this.clienteAreas = clienteAreas;
    }

    
    
    
    

    
   
    
    
    
}
