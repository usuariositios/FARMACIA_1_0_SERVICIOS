/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author HENRY
 */
public class SucursalVentas {
    int codSucursal = 0;
    String nombreSucursal = "";
    String direccionSucursal ="";
    String telefonoSucursal = "";
    String emailSucursal = "";
    String representante = "";
    String logotipoSucursal = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    Empresas empresas = new Empresas();

    public int getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(int codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
    }

    public String getTelefonoSucursal() {
        return telefonoSucursal;
    }

    public void setTelefonoSucursal(String telefonoSucursal) {
        this.telefonoSucursal = telefonoSucursal;
    }

    public String getEmailSucursal() {
        return emailSucursal;
    }

    public void setEmailSucursal(String emailSucursal) {
        this.emailSucursal = emailSucursal;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getLogotipoSucursal() {
        return logotipoSucursal;
    }

    public void setLogotipoSucursal(String logotipoSucursal) {
        this.logotipoSucursal = logotipoSucursal;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }
    
    
    
}
