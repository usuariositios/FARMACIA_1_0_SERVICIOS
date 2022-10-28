/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class ProductoSemiterminado extends bean{
    int codProductoSemiterminado = 0;
    TiposProductoSemiterminado tiposProductoSemiterminado = new TiposProductoSemiterminado();
    ColorProducto colorProducto = new ColorProducto();
    AreasEmpresa areasEmpresa = new AreasEmpresa();
    Double pesoAprox = 0.0;
    EstadosProductoSemiterminado estadosProductoSemiterminado = new EstadosProductoSemiterminado();
    String nombreProductoSemiterminado = "";
    String observacion = "";
    int vidaUtil = 0;
    TiposTela tiposTela = new TiposTela();
    TiposLavado tiposLavado = new TiposLavado();
    String codigoProducto = "";
    String direccionImagen = "";
    
    
    
   

    public int getCodProductoSemiterminado() {
        return codProductoSemiterminado;
    }

    public void setCodProductoSemiterminado(int codProductoSemiterminado) {
        this.codProductoSemiterminado = codProductoSemiterminado;
    }

    public TiposProductoSemiterminado getTiposProductoSemiterminado() {
        return tiposProductoSemiterminado;
    }

    public void setTiposProductoSemiterminado(TiposProductoSemiterminado tiposProductoSemiterminado) {
        this.tiposProductoSemiterminado = tiposProductoSemiterminado;
    }

    public ColorProducto getColorProducto() {
        return colorProducto;
    }

    public void setColorProducto(ColorProducto colorProducto) {
        this.colorProducto = colorProducto;
    }

    public AreasEmpresa getAreasEmpresa() {
        return areasEmpresa;
    }

    public void setAreasEmpresa(AreasEmpresa areasEmpresa) {
        this.areasEmpresa = areasEmpresa;
    }

    public Double getPesoAprox() {
        return pesoAprox;
    }

    public void setPesoAprox(Double pesoAprox) {
        this.pesoAprox = pesoAprox;
    }

    public EstadosProductoSemiterminado getEstadosProductoSemiterminado() {
        return estadosProductoSemiterminado;
    }

    public void setEstadosProductoSemiterminado(EstadosProductoSemiterminado estadosProductoSemiterminado) {
        this.estadosProductoSemiterminado = estadosProductoSemiterminado;
    }

    public String getNombreProductoSemiterminado() {
        return nombreProductoSemiterminado;
    }

    public void setNombreProductoSemiterminado(String nombreProductoSemiterminado) {
        this.nombreProductoSemiterminado = nombreProductoSemiterminado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public TiposTela getTiposTela() {
        return tiposTela;
    }

    public void setTiposTela(TiposTela tiposTela) {
        this.tiposTela = tiposTela;
    }

    public TiposLavado getTiposLavado() {
        return tiposLavado;
    }

    public void setTiposLavado(TiposLavado tiposLavado) {
        this.tiposLavado = tiposLavado;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getDireccionImagen() {
        return direccionImagen;
    }

    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
    }
    
    
    
    

    
    
    
    
    
    
    
    
}
