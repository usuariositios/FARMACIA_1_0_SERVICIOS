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
public class CajaChica extends bean {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
    int codCajaChica = 0;
    String fechaTurno = sdf.format(new Date());
    Personal personal = new Personal();
    Double montoInicial = 0.0;
    Double montoIngresos = 0.0;
    Double montoEgresos = 0.0;
    Double montoSaldo = 0.0;
    Caja caja = new Caja();
    EstadoApertura estadoApertura = new EstadoApertura();
    
    public int getCodCajaChica() {
        return codCajaChica;
    }

    public void setCodCajaChica(int codCajaChica) {
        this.codCajaChica = codCajaChica;
    }

    public String getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(String fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(Double montoInicial) {
        this.montoInicial = montoInicial;
    }

    

    public Double getMontoIngresos() {
        return montoIngresos;
    }

    public void setMontoIngresos(Double montoIngresos) {
        this.montoIngresos = montoIngresos;
    }

    public Double getMontoEgresos() {
        return montoEgresos;
    }

    public void setMontoEgresos(Double montoEgresos) {
        this.montoEgresos = montoEgresos;
    }

    public Double getMontoSaldo() {
        return montoSaldo;
    }

    public void setMontoSaldo(Double montoSaldo) {
        this.montoSaldo = montoSaldo;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }
    
    public EstadoApertura getEstadoApertura() {
        return estadoApertura;
    }

    public void setEstadoApertura(EstadoApertura estadoApertura) {
        this.estadoApertura = estadoApertura;
    }
    
}
