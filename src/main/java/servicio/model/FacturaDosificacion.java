/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author COMPUTER
 */
public class FacturaDosificacion extends bean {
    int codDosificacion = 0;
    int nroFacturaInicio = 0;
    int nroFacturaFinal = 0;
    String nroAutorizacion = "";
    String llaveDosificacion = "";
    String fechaLimiteEmision = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    SucursalVentas sucursalVentas = new SucursalVentas();
    

    public int getCodDosificacion() {
        return codDosificacion;
    }

    public void setCodDosificacion(int codDosificacion) {
        this.codDosificacion = codDosificacion;
    }

    public int getNroFacturaInicio() {
        return nroFacturaInicio;
    }

    public void setNroFacturaInicio(int nroFacturaInicio) {
        this.nroFacturaInicio = nroFacturaInicio;
    }

    public int getNroFacturaFinal() {
        return nroFacturaFinal;
    }

    public void setNroFacturaFinal(int nroFacturaFinal) {
        this.nroFacturaFinal = nroFacturaFinal;
    }

    public String getNroAutorizacion() {
        return nroAutorizacion;
    }

    public void setNroAutorizacion(String nroAutorizacion) {
        this.nroAutorizacion = nroAutorizacion;
    }

    public String getLlaveDosificacion() {
        return llaveDosificacion;
    }

    public void setLlaveDosificacion(String llaveDosificacion) {
        this.llaveDosificacion = llaveDosificacion;
    }

    public String getFechaLimiteEmision() {
        return fechaLimiteEmision;
    }

    public void setFechaLimiteEmision(String fechaLimiteEmision) {
        this.fechaLimiteEmision = fechaLimiteEmision;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public SucursalVentas getSucursalVentas() {
        return sucursalVentas;
    }

    public void setSucursalVentas(SucursalVentas sucursalVentas) {
        this.sucursalVentas = sucursalVentas;
    }
    
    
    
           
    
}
