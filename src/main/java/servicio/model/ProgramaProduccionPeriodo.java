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
public class ProgramaProduccionPeriodo extends bean{
    int codProgramaProd = 0;
    String nombreProgramaProd = "";
    String Observaciones = "";
    EstadosProgramaProduccion estadosProgramaProduccion = new EstadosProgramaProduccion();
    Date fechaInicio = new Date();
    Date fechaFinal = new Date();

    public int getCodProgramaProd() {
        return codProgramaProd;
    }

    public void setCodProgramaProd(int codProgramaProd) {
        this.codProgramaProd = codProgramaProd;
    }

    public String getNombreProgramaProd() {
        return nombreProgramaProd;
    }

    public void setNombreProgramaProd(String nombreProgramaProd) {
        this.nombreProgramaProd = nombreProgramaProd;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public EstadosProgramaProduccion getEstadosProgramaProduccion() {
        return estadosProgramaProduccion;
    }

    public void setEstadosProgramaProduccion(EstadosProgramaProduccion estadosProgramaProduccion) {
        this.estadosProgramaProduccion = estadosProgramaProduccion;
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
    
    
    
}
