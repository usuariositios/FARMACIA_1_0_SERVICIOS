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
public class ActividadesDatosTecnicos extends bean {
    
    ActividadesProduccion actividadesProduccion = new ActividadesProduccion();
    int nroOperarios = 0;
    double horasTrabajo = 0.0;
    Date fechaInicio = new Date();
    Date fechaFinal = new Date();
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    double minutaje = 0.0;
    Personal personal = new Personal();
    

    public ActividadesProduccion getActividadesProduccion() {
        return actividadesProduccion;
    }

    public void setActividadesProduccion(ActividadesProduccion actividadesProduccion) {
        this.actividadesProduccion = actividadesProduccion;
    }

    public int getNroOperarios() {
        return nroOperarios;
    }

    public void setNroOperarios(int nroOperarios) {
        this.nroOperarios = nroOperarios;
    }

    public double getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(double horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public double getMinutaje() {
        return minutaje;
    }

    public void setMinutaje(double minutaje) {
        this.minutaje = minutaje;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    
    
    
    
}
