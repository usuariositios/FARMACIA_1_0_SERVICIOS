/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.util.Date;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class Cotizacion extends bean{
    int codCotizacion = 0;
    Clientes clientes = new Clientes();
    Date fechaCotizacion = new Date();
    int nroPedido = 0;
    TiposPago tiposPago = new TiposPago();
    int diasEntrega = 0;
    Double montoAnticipo = 0.0;
    EstadosCotizacion estadosCotizacion = new EstadosCotizacion();
    TiposMedioPago tiposMedioPago = new TiposMedioPago();
    Pais pais = new Pais();
    Ciudad ciudad = new Ciudad();
    int emailEnviado = 0;
    Date fechaEntrega = new Date();
    Personal personalRepresentante = new Personal();
    Double montoAuspicio = 0.0;
    int opAsignados = 0;
    int opTerminados = 0;
    Date fechaAprobacion = new Date();
    
    
    
    
    

    public int getCodCotizacion() {
        return codCotizacion;
    }

    public void setCodCotizacion(int codCotizacion) {
        this.codCotizacion = codCotizacion;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Date getFechaCotizacion() {
        return fechaCotizacion;
    }

    public void setFechaCotizacion(Date fechaCotizacion) {
        this.fechaCotizacion = fechaCotizacion;
    }

    public int getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(int nroPedido) {
        this.nroPedido = nroPedido;
    }

    public TiposPago getTiposPago() {
        return tiposPago;
    }

    public void setTiposPago(TiposPago tiposPago) {
        this.tiposPago = tiposPago;
    }

    public int getDiasEntrega() {
        return diasEntrega;
    }

    public void setDiasEntrega(int diasEntrega) {
        this.diasEntrega = diasEntrega;
    }

    public Double getMontoAnticipo() {
        return montoAnticipo;
    }

    public void setMontoAnticipo(Double montoAnticipo) {
        this.montoAnticipo = montoAnticipo;
    }

    public EstadosCotizacion getEstadosCotizacion() {
        return estadosCotizacion;
    }

    public void setEstadosCotizacion(EstadosCotizacion estadosCotizacion) {
        this.estadosCotizacion = estadosCotizacion;
    }

    public TiposMedioPago getTiposMedioPago() {
        return tiposMedioPago;
    }

    public void setTiposMedioPago(TiposMedioPago tiposMedioPago) {
        this.tiposMedioPago = tiposMedioPago;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public int getEmailEnviado() {
        return emailEnviado;
    }

    public void setEmailEnviado(int emailEnviado) {
        this.emailEnviado = emailEnviado;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Personal getPersonalRepresentante() {
        return personalRepresentante;
    }

    public void setPersonalRepresentante(Personal personalRepresentante) {
        this.personalRepresentante = personalRepresentante;
    }

    public Double getMontoAuspicio() {
        return montoAuspicio;
    }

    public void setMontoAuspicio(Double montoAuspicio) {
        this.montoAuspicio = montoAuspicio;
    }

    public int getOpAsignados() {
        return opAsignados;
    }

    public void setOpAsignados(int opAsignados) {
        this.opAsignados = opAsignados;
    }

    public int getOpTerminados() {
        return opTerminados;
    }

    public void setOpTerminados(int opTerminados) {
        this.opTerminados = opTerminados;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
