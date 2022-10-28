/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class Proveedores extends bean {
    int codProveedor =0;
    String nombreProveedor = "";
    String nitProveedor = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    TiposProveedor tiposProveedor = new TiposProveedor();
    EstadosProveedor estadosProveedor = new EstadosProveedor();
    Moneda moneda = new Moneda();
    TiposPago tiposPago = new TiposPago();
    int diasTerminoPago=0;
    TiposDocumento tiposDocumento = new TiposDocumento();
    Pais pais = new Pais();
    Ciudad ciudadProveedor = new Ciudad();
    String direccionProveedor = "";
    String telefonoProveedor = "";
    String emailProveedor = "";
    String faxProveedor = "";
    String paginaWebProveedor = "";
    String obsProveedor = "";
    String nombreCheque = "";
    TiposMedioPago tiposMedioPago = new TiposMedioPago();

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public TiposProveedor getTiposProveedor() {
        return tiposProveedor;
    }

    public void setTiposProveedor(TiposProveedor tiposProveedor) {
        this.tiposProveedor = tiposProveedor;
    }

    public EstadosProveedor getEstadosProveedor() {
        return estadosProveedor;
    }

    public void setEstadosProveedor(EstadosProveedor estadosProveedor) {
        this.estadosProveedor = estadosProveedor;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public TiposPago getTiposPago() {
        return tiposPago;
    }

    public void setTiposPago(TiposPago tiposPago) {
        this.tiposPago = tiposPago;
    }

    public int getDiasTerminoPago() {
        return diasTerminoPago;
    }

    public void setDiasTerminoPago(int diasTerminoPago) {
        this.diasTerminoPago = diasTerminoPago;
    }

    public TiposDocumento getTiposDocumento() {
        return tiposDocumento;
    }

    public void setTiposDocumento(TiposDocumento tiposDocumento) {
        this.tiposDocumento = tiposDocumento;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Ciudad getCiudadProveedor() {
        return ciudadProveedor;
    }

    public void setCiudadProveedor(Ciudad ciudadProveedor) {
        this.ciudadProveedor = ciudadProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public String getFaxProveedor() {
        return faxProveedor;
    }

    public void setFaxProveedor(String faxProveedor) {
        this.faxProveedor = faxProveedor;
    }

    public String getPaginaWebProveedor() {
        return paginaWebProveedor;
    }

    public void setPaginaWebProveedor(String paginaWebProveedor) {
        this.paginaWebProveedor = paginaWebProveedor;
    }

    public String getObsProveedor() {
        return obsProveedor;
    }

    public void setObsProveedor(String obsProveedor) {
        this.obsProveedor = obsProveedor;
    }

    public String getNombreCheque() {
        return nombreCheque;
    }

    public void setNombreCheque(String nombreCheque) {
        this.nombreCheque = nombreCheque;
    }

    public TiposMedioPago getTiposMedioPago() {
        return tiposMedioPago;
    }

    public void setTiposMedioPago(TiposMedioPago tiposMedioPago) {
        this.tiposMedioPago = tiposMedioPago;
    }
    
    
    
    
    
    
    
    
}
