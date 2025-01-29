/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class Productos extends bean{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
    int codProducto = 0;
    String nombreProducto = "";
    String descripcionProducto = "";
    GruposProducto grupoProducto = new GruposProducto();
    Double impuestoProducto = 0.0;
    Proveedores proveedores1 = new Proveedores();
    Proveedores proveedores2 = new Proveedores();
    String descripcionCortaProducto = "";
    Double stockMinimo = 0.0;
    Double stockMaximo = 0.0;
    int avisoStockMinimo = 0;
    String fechaRegistro = sdf.format(new Date());
    EmpaqueExterno empaqueExterno = new EmpaqueExterno();
    double cantidadPorCaja = 0.0;
    String observaciones = "";
    double precioCompra = 0.0;
    double precioAlmacen = 0.0;
    double precioVenta = 0.0;
    double precioIva = 0.0;
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    String sinCodProducto ="";
    UnidadesMedida unidadesMedida = new UnidadesMedida();
    SubGruposProducto subGruposProducto = new SubGruposProducto();
    UnidadesMedida unidadesMedidaCompra = new UnidadesMedida();
    double cantPCompraVenta = 0.0;
    String codigoProducto = "";
    double porcentajeDescuentoMaximo = 0.0;
    String codBarrasProducto = "";
    String imagenProducto="";
    Laboratorio laboratorio = new Laboratorio();
    double precioCompraBlister = 0.0;
    double precioVentaBlister = 0.0;
    double cantUnidadesBlister = 0.0;
    
    double precioCompraCaja = 0.0;
    double precioVentaCaja = 0.0;
    double cantUnidadesCaja = 0.0;
    
    PresentacionesProducto presentacionesProducto = new PresentacionesProducto();
    CategoriaProducto categoriaProducto = new CategoriaProducto();
    AccionTerapeutica accionTerapeutica = new AccionTerapeutica();
    String principioActivo = "";
    int psicotropico = 0;
    String ubicacion = "";
    FormaFarmaceutica formaFarmaceutica = new FormaFarmaceutica();
    NombreGenerico nombreGenerico = new NombreGenerico();
    
    
    
    

    
    
    
    
    
    
    
    
    

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public GruposProducto getGrupoProducto() {
        return grupoProducto;
    }

    public void setGrupoProducto(GruposProducto grupoProducto) {
        this.grupoProducto = grupoProducto;
    }

    public Double getImpuestoProducto() {
        return impuestoProducto;
    }

    public void setImpuestoProducto(Double impuestoProducto) {
        this.impuestoProducto = impuestoProducto;
    }

    public Proveedores getProveedores1() {
        return proveedores1;
    }

    public void setProveedores1(Proveedores proveedores1) {
        this.proveedores1 = proveedores1;
    }

    public Proveedores getProveedores2() {
        return proveedores2;
    }

    public void setProveedores2(Proveedores proveedores2) {
        this.proveedores2 = proveedores2;
    }

    public String getDescripcionCortaProducto() {
        return descripcionCortaProducto;
    }

    public void setDescripcionCortaProducto(String descripcionCortaProducto) {
        this.descripcionCortaProducto = descripcionCortaProducto;
    }

    public Double getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Double stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Double getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(Double stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public int getAvisoStockMinimo() {
        return avisoStockMinimo;
    }

    public void setAvisoStockMinimo(int avisoStockMinimo) {
        this.avisoStockMinimo = avisoStockMinimo;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    
    public EmpaqueExterno getEmpaqueExterno() {
        return empaqueExterno;
    }

    public void setEmpaqueExterno(EmpaqueExterno empaqueExterno) {
        this.empaqueExterno = empaqueExterno;
    }

    

    public double getCantidadPorCaja() {
        return cantidadPorCaja;
    }

    public void setCantidadPorCaja(double cantidadPorCaja) {
        this.cantidadPorCaja = cantidadPorCaja;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioAlmacen() {
        return precioAlmacen;
    }

    public void setPrecioAlmacen(double precioAlmacen) {
        this.precioAlmacen = precioAlmacen;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    

    public double getPrecioIva() {
        return precioIva;
    }

    public void setPrecioIva(double precioIva) {
        this.precioIva = precioIva;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public String getSinCodProducto() {
        return sinCodProducto;
    }

    public void setSinCodProducto(String sinCodProducto) {
        this.sinCodProducto = sinCodProducto;
    }

    public UnidadesMedida getUnidadesMedida() {
        return unidadesMedida;
    }

    public void setUnidadesMedida(UnidadesMedida unidadesMedida) {
        this.unidadesMedida = unidadesMedida;
    }

    public SubGruposProducto getSubGruposProducto() {
        return subGruposProducto;
    }

    public void setSubGruposProducto(SubGruposProducto subGruposProducto) {
        this.subGruposProducto = subGruposProducto;
    }

    public UnidadesMedida getUnidadesMedidaCompra() {
        return unidadesMedidaCompra;
    }

    public void setUnidadesMedidaCompra(UnidadesMedida unidadesMedidaCompra) {
        this.unidadesMedidaCompra = unidadesMedidaCompra;
    }


    public double getCantPCompraVenta() {
        return cantPCompraVenta;
    }

    public void setCantPCompraVenta(double cantPCompraVenta) {
        this.cantPCompraVenta = cantPCompraVenta;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public double getPorcentajeDescuentoMaximo() {
        return porcentajeDescuentoMaximo;
    }

    public void setPorcentajeDescuentoMaximo(double porcentajeDescuentoMaximo) {
        this.porcentajeDescuentoMaximo = porcentajeDescuentoMaximo;
    }

    public String getCodBarrasProducto() {
        return codBarrasProducto;
    }

    public void setCodBarrasProducto(String codBarrasProducto) {
        this.codBarrasProducto = codBarrasProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    
    
    

    public double getPrecioCompraBlister() {
        return precioCompraBlister;
    }

    public void setPrecioCompraBlister(double precioCompraBlister) {
        this.precioCompraBlister = precioCompraBlister;
    }

    public double getPrecioVentaBlister() {
        return precioVentaBlister;
    }

    public void setPrecioVentaBlister(double precioVentaBlister) {
        this.precioVentaBlister = precioVentaBlister;
    }

    public double getCantUnidadesBlister() {
        return cantUnidadesBlister;
    }

    public void setCantUnidadesBlister(double cantUnidadesBlister) {
        this.cantUnidadesBlister = cantUnidadesBlister;
    }

    public double getPrecioCompraCaja() {
        return precioCompraCaja;
    }

    public void setPrecioCompraCaja(double precioCompraCaja) {
        this.precioCompraCaja = precioCompraCaja;
    }

    public double getPrecioVentaCaja() {
        return precioVentaCaja;
    }

    public void setPrecioVentaCaja(double precioVentaCaja) {
        this.precioVentaCaja = precioVentaCaja;
    }

    public double getCantUnidadesCaja() {
        return cantUnidadesCaja;
    }

    public void setCantUnidadesCaja(double cantUnidadesCaja) {
        this.cantUnidadesCaja = cantUnidadesCaja;
    }

    public PresentacionesProducto getPresentacionesProducto() {
        return presentacionesProducto;
    }

    public void setPresentacionesProducto(PresentacionesProducto presentacionesProducto) {
        this.presentacionesProducto = presentacionesProducto;
    }
    
    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public AccionTerapeutica getAccionTerapeutica() {
        return accionTerapeutica;
    }

    public void setAccionTerapeutica(AccionTerapeutica accionTerapeutica) {
        this.accionTerapeutica = accionTerapeutica;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public int getPsicotropico() {
        return psicotropico;
    }

    public void setPsicotropico(int psicotropico) {
        this.psicotropico = psicotropico;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public FormaFarmaceutica getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(FormaFarmaceutica formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public NombreGenerico getNombreGenerico() {
        return nombreGenerico;
    }

    public void setNombreGenerico(NombreGenerico nombreGenerico) {
        this.nombreGenerico = nombreGenerico;
    }
    
    

    
    
    
}
