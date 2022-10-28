/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class OrdenesCompraDetalle extends bean {
    OrdenesCompra ordenesCompra = new OrdenesCompra();
    Materiales materiales = new Materiales();
    double cantidadNeta = 0.0;
    UnidadesMedida unidadesMedida = new UnidadesMedida();
    double precioUnitario = 0.0;
    double cantidadIngresoAlmacen = 0.0;
    double precioTotal = 0.0;
    String descripcion = "";
    Proveedores proveedores = new Proveedores();
    TiposCompra tiposCompra = new TiposCompra();
    TiposPago tiposPago = new TiposPago();
    Productos productos = new Productos();
    String nroLote = "";
    TiposEnvase tiposEnvase = new TiposEnvase();
    String fechaFabricacion = "";
    String fechaVencimiento = "";
    

    public OrdenesCompra getOrdenesCompra() {
        return ordenesCompra;
    }

    public void setOrdenesCompra(OrdenesCompra ordenesCompra) {
        this.ordenesCompra = ordenesCompra;
    }

    public Materiales getMateriales() {
        return materiales;
    }

    public void setMateriales(Materiales materiales) {
        this.materiales = materiales;
    }

    public double getCantidadNeta() {
        return cantidadNeta;
    }

    public void setCantidadNeta(double cantidadNeta) {
        this.cantidadNeta = cantidadNeta;
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

    public double getCantidadIngresoAlmacen() {
        return cantidadIngresoAlmacen;
    }

    public void setCantidadIngresoAlmacen(double cantidadIngresoAlmacen) {
        this.cantidadIngresoAlmacen = cantidadIngresoAlmacen;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public TiposPago getTiposPago() {
        return tiposPago;
    }

    public void setTiposPago(TiposPago tiposPago) {
        this.tiposPago = tiposPago;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
    public String getNroLote() {
        return nroLote;
    }

    public void setNroLote(String nroLote) {
        this.nroLote = nroLote;
    }

    public TiposEnvase getTiposEnvase() {
        return tiposEnvase;
    }

    public void setTiposEnvase(TiposEnvase tiposEnvase) {
        this.tiposEnvase = tiposEnvase;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    
    
    
    
    
    
    
    
    
}
