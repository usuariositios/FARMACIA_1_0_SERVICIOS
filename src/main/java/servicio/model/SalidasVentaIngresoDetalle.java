/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class SalidasVentaIngresoDetalle {    
    SalidasVentaDetalle salidasAlmacenDetalle = new SalidasVentaDetalle();
    Productos productos = new Productos();
    IngresosVentaDetalle ingresosAlmacenDetalle = new IngresosVentaDetalle();
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public SalidasVentaDetalle getSalidasAlmacenDetalle() {
        return salidasAlmacenDetalle;
    }

    public void setSalidasAlmacenDetalle(SalidasVentaDetalle salidasAlmacenDetalle) {
        this.salidasAlmacenDetalle = salidasAlmacenDetalle;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public IngresosVentaDetalle getIngresosAlmacenDetalle() {
        return ingresosAlmacenDetalle;
    }

    public void setIngresosAlmacenDetalle(IngresosVentaDetalle ingresosAlmacenDetalle) {
        this.ingresosAlmacenDetalle = ingresosAlmacenDetalle;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
            
    
}
