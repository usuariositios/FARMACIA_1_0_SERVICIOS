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
public class Tabla {
    int codTabla = 0;
    String nombreTabla ="";
    String descripcionTabla = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    
    
    

    public int getCodTabla() {
        return codTabla;
    }

    public void setCodTabla(int codTabla) {
        this.codTabla = codTabla;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getDescripcionTabla() {
        return descripcionTabla;
    }

    public void setDescripcionTabla(String descripcionTabla) {
        this.descripcionTabla = descripcionTabla;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
    
}
