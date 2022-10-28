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
public class IngresosAlmacenDetalleEstado {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
    IngresosVenta ingresosAlmacen = new IngresosVenta();
    Materiales materiales = new Materiales();
    EstadosMaterial estadosMaterial = new EstadosMaterial();
    int etiqueta = 0;
    int codEstadoMaterial = 0;
    EmpaqueSecundarioExterno empaqueSecundarioExterno = new EmpaqueSecundarioExterno();
    double cantidadParcial = 0.0;
    double cantidadRestante = 0.0;
    String fechaVencimiento = sdf.format(new Date());
    String loteMaterialProveedor = "";
    String loteInterno = "";
    String fechaManufactura = sdf.format(new Date());
    String fechaReanalisis = sdf.format(new Date());
    String observaciones = "";
    String obsControlCalidad = "";
    String fechaVencimiento1 = sdf.format(new Date());
    String fechaReanalisis1 = sdf.format(new Date());
    String fechaVencimiento2 = sdf.format(new Date());
    String fechaReanalisis2 = sdf.format(new Date());
    double tara = 0.0;
    

    public IngresosVenta getIngresosAlmacen() {
        return ingresosAlmacen;
    }

    public void setIngresosAlmacen(IngresosVenta ingresosAlmacen) {
        this.ingresosAlmacen = ingresosAlmacen;
    }

    public Materiales getMateriales() {
        return materiales;
    }

    public void setMateriales(Materiales materiales) {
        this.materiales = materiales;
    }

    public int getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getCodEstadoMaterial() {
        return codEstadoMaterial;
    }

    public void setCodEstadoMaterial(int codEstadoMaterial) {
        this.codEstadoMaterial = codEstadoMaterial;
    }

    public EmpaqueSecundarioExterno getEmpaqueSecundarioExterno() {
        return empaqueSecundarioExterno;
    }

    public void setEmpaqueSecundarioExterno(EmpaqueSecundarioExterno empaqueSecundarioExterno) {
        this.empaqueSecundarioExterno = empaqueSecundarioExterno;
    }

    public double getTara() {
        return tara;
    }

    public void setTara(double tara) {
        this.tara = tara;
    }

    public double getCantidadParcial() {
        return cantidadParcial;
    }

    public void setCantidadParcial(double cantidadParcial) {
        this.cantidadParcial = cantidadParcial;
    }

    public double getCantidadRestante() {
        return cantidadRestante;
    }

    public void setCantidadRestante(double cantidadRestante) {
        this.cantidadRestante = cantidadRestante;
    }

    

    public String getLoteMaterialProveedor() {
        return loteMaterialProveedor;
    }

    public void setLoteMaterialProveedor(String loteMaterialProveedor) {
        this.loteMaterialProveedor = loteMaterialProveedor;
    }

    public String getLoteInterno() {
        return loteInterno;
    }

    public void setLoteInterno(String loteInterno) {
        this.loteInterno = loteInterno;
    }

    

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObsControlCalidad() {
        return obsControlCalidad;
    }

    public void setObsControlCalidad(String obsControlCalidad) {
        this.obsControlCalidad = obsControlCalidad;
    }

    

    public EstadosMaterial getEstadosMaterial() {
        return estadosMaterial;
    }

    public void setEstadosMaterial(EstadosMaterial estadosMaterial) {
        this.estadosMaterial = estadosMaterial;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaManufactura() {
        return fechaManufactura;
    }

    public void setFechaManufactura(String fechaManufactura) {
        this.fechaManufactura = fechaManufactura;
    }

    public String getFechaReanalisis() {
        return fechaReanalisis;
    }

    public void setFechaReanalisis(String fechaReanalisis) {
        this.fechaReanalisis = fechaReanalisis;
    }

    public String getFechaVencimiento1() {
        return fechaVencimiento1;
    }

    public void setFechaVencimiento1(String fechaVencimiento1) {
        this.fechaVencimiento1 = fechaVencimiento1;
    }

    public String getFechaReanalisis1() {
        return fechaReanalisis1;
    }

    public void setFechaReanalisis1(String fechaReanalisis1) {
        this.fechaReanalisis1 = fechaReanalisis1;
    }

    public String getFechaVencimiento2() {
        return fechaVencimiento2;
    }

    public void setFechaVencimiento2(String fechaVencimiento2) {
        this.fechaVencimiento2 = fechaVencimiento2;
    }

    public String getFechaReanalisis2() {
        return fechaReanalisis2;
    }

    public void setFechaReanalisis2(String fechaReanalisis2) {
        this.fechaReanalisis2 = fechaReanalisis2;
    }
    
    
    
    
    
    
    
            
    
    
    
}
