/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class OrdenesCompra extends bean {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
    int codOrdenCompra = 0;
    int nroOrdenCompra = 0;
    double tiempoEntrega = 0.0;
    Monedas monedas = new Monedas();
    String fechaEmision = sdf.format(new Date());
    String fechaAprobacion = sdf.format(new Date());
    Proveedores proveedores = new Proveedores();
    TiposCompra tiposCompra = new TiposCompra();
    TiposTransporte tiposTransporte = new TiposTransporte();
    Gestion gestiones = new Gestion();
    
    TiposPago tiposPago = new TiposPago();
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    EstadosOrdenCompra estadosOrdenCompra = new EstadosOrdenCompra();
    double montoAnticipo = 0.0;
    String fechaEntrega = sdf.format(new Date());
    
    
    
    

    public int getCodOrdenCompra() {
        return codOrdenCompra;
    }

    public void setCodOrdenCompra(int codOrdenCompra) {
        this.codOrdenCompra = codOrdenCompra;
    }

    public int getNroOrdenCompra() {
        return nroOrdenCompra;
    }

    public void setNroOrdenCompra(int nroOrdenCompra) {
        this.nroOrdenCompra = nroOrdenCompra;
    }

    public double getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(double tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public Monedas getMonedas() {
        return monedas;
    }

    public void setMonedas(Monedas monedas) {
        this.monedas = monedas;
    }

   

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public TiposCompra getTiposCompra() {
        return tiposCompra;
    }

    public void setTiposCompra(TiposCompra tiposCompra) {
        this.tiposCompra = tiposCompra;
    }

    public TiposTransporte getTiposTransporte() {
        return tiposTransporte;
    }

    public void setTiposTransporte(TiposTransporte tiposTransporte) {
        this.tiposTransporte = tiposTransporte;
    }

    public TiposPago getTiposPago() {
        return tiposPago;
    }

    public void setTiposPago(TiposPago tiposPago) {
        this.tiposPago = tiposPago;
    }

    public Gestion getGestiones() {
        return gestiones;
    }

    public void setGestiones(Gestion gestiones) {
        this.gestiones = gestiones;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public EstadosOrdenCompra getEstadosOrdenCompra() {
        return estadosOrdenCompra;
    }

    public void setEstadosOrdenCompra(EstadosOrdenCompra estadosOrdenCompra) {
        this.estadosOrdenCompra = estadosOrdenCompra;
    }

    

    public double getMontoAnticipo() {
        return montoAnticipo;
    }

    public void setMontoAnticipo(double montoAnticipo) {
        this.montoAnticipo = montoAnticipo;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(String fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

   
    

   
    
    
    
}
