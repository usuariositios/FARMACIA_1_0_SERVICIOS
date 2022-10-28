/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author HENRY VALDIVIA
 */
public class TiposEnvase {
    int codTipoEnvase = 0;
    String nombreTipoEnvase = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoEnvase() {
        return codTipoEnvase;
    }

    public void setCodTipoEnvase(int codTipoEnvase) {
        this.codTipoEnvase = codTipoEnvase;
    }

    public String getNombreTipoEnvase() {
        return nombreTipoEnvase;
    }

    public void setNombreTipoEnvase(String nombreTipoEnvase) {
        this.nombreTipoEnvase = nombreTipoEnvase;
    }

    

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
    
}
