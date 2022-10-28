/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author COMPUTER
 */
@XmlRootElement
public class DevolucionesDetalle {
    Devoluciones devoluciones = new Devoluciones();
    int codDevolucionDetalle = 0;
    Productos productos = new Productos();
    double cantidadDevuelta = 0.0;
    UnidadesMedida unidadesMedida = new UnidadesMedida();
    double precioUnitario = 0.0;
    double precioTotal = 0.0;
    AlmacenesVenta almacenesVenta = new AlmacenesVenta();
    

    public Devoluciones getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(Devoluciones devoluciones) {
        this.devoluciones = devoluciones;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public double getCantidadDevuelta() {
        return cantidadDevuelta;
    }

    public void setCantidadDevuelta(double cantidadDevuelta) {
        this.cantidadDevuelta = cantidadDevuelta;
    }

    public UnidadesMedida getUnidadesMedida() {
        return unidadesMedida;
    }

    public void setUnidadesMedida(UnidadesMedida unidadesMedida) {
        this.unidadesMedida = unidadesMedida;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public AlmacenesVenta getAlmacenesVenta() {
        return almacenesVenta;
    }

    public void setAlmacenesVenta(AlmacenesVenta almacenesVenta) {
        this.almacenesVenta = almacenesVenta;
    }

    public int getCodDevolucionDetalle() {
        return codDevolucionDetalle;
    }

    public void setCodDevolucionDetalle(int codDevolucionDetalle) {
        this.codDevolucionDetalle = codDevolucionDetalle;
    }
    
    
    
    
    
    
}
