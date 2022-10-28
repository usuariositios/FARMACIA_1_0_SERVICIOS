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
public class AccionTerapeutica {
    int codAccionTerapeutica = 0;
    String nombreAccionTerapeutica = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodAccionTerapeutica() {
        return codAccionTerapeutica;
    }

    public void setCodAccionTerapeutica(int codAccionTerapeutica) {
        this.codAccionTerapeutica = codAccionTerapeutica;
    }

    public String getNombreAccionTerapeutica() {
        return nombreAccionTerapeutica;
    }

    public void setNombreAccionTerapeutica(String nombreAccionTerapeutica) {
        this.nombreAccionTerapeutica = nombreAccionTerapeutica;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
    
}
