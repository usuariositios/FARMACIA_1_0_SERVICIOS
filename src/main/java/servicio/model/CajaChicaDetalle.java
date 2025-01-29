/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Henry
 */
public class CajaChicaDetalle {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
    CajaChica cajaChica = new CajaChica();
    int codCajaChicaDetalle = 0;
    String fechaCajaChicaDetalle = sdf.format(new Date());
    Double montoIngreso = 0.0;
    Double montoEgreso = 0.0;
    Double montoSaldo = 0.0;
    FacturasEmitidas facturasEmitidas = new FacturasEmitidas();
    String descripcion = "";
    
   

    public CajaChica getCajaChica() {
        return cajaChica;
    }

    public void setCajaChica(CajaChica cajaChica) {
        this.cajaChica = cajaChica;
    }

    public int getCodCajaChicaDetalle() {
        return codCajaChicaDetalle;
    }

    public void setCodCajaChicaDetalle(int codCajaChicaDetalle) {
        this.codCajaChicaDetalle = codCajaChicaDetalle;
    }

    public String getFechaCajaChicaDetalle() {
        return fechaCajaChicaDetalle;
    }

    public void setFechaCajaChicaDetalle(String fechaCajaChicaDetalle) {
        this.fechaCajaChicaDetalle = fechaCajaChicaDetalle;
    }

    public Double getMontoIngreso() {
        return montoIngreso;
    }

    public void setMontoIngreso(Double montoIngreso) {
        this.montoIngreso = montoIngreso;
    }

    public Double getMontoEgreso() {
        return montoEgreso;
    }

    public void setMontoEgreso(Double montoEgreso) {
        this.montoEgreso = montoEgreso;
    }
    
     public Double getMontoSaldo() {
        return montoSaldo;
    }

    public void setMontoSaldo(Double montoSaldo) {
        this.montoSaldo = montoSaldo;
    }

    public FacturasEmitidas getFacturasEmitidas() {
        return facturasEmitidas;
    }

    public void setFacturasEmitidas(FacturasEmitidas facturasEmitidas) {
        this.facturasEmitidas = facturasEmitidas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    
    
    
    
}
