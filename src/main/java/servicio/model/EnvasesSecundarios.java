/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class EnvasesSecundarios {
    int codEnvaseSecundario = 0;
    String nombreEnvaseSecundario = "";
    String obsEnvaseSecundario = "";
    EstadosRegistro  estadosRegistro = new EstadosRegistro();

    public int getCodEnvaseSecundario() {
        return codEnvaseSecundario;
    }

    public void setCodEnvaseSecundario(int codEnvaseSecundario) {
        this.codEnvaseSecundario = codEnvaseSecundario;
    }

    public String getNombreEnvaseSecundario() {
        return nombreEnvaseSecundario;
    }

    public void setNombreEnvaseSecundario(String nombreEnvaseSecundario) {
        this.nombreEnvaseSecundario = nombreEnvaseSecundario;
    }

    public String getObsEnvaseSecundario() {
        return obsEnvaseSecundario;
    }

    public void setObsEnvaseSecundario(String obsEnvaseSecundario) {
        this.obsEnvaseSecundario = obsEnvaseSecundario;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
            
    
}
