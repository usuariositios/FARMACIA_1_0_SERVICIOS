/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class EnvasesTerciarios {
    int codEnvaseTerciario = 0;
    String nombreEnvaseTerciario = "";
    String obsEnvaseTerciario = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodEnvaseTerciario() {
        return codEnvaseTerciario;
    }

    public void setCodEnvaseTerciario(int codEnvaseTerciario) {
        this.codEnvaseTerciario = codEnvaseTerciario;
    }

    public String getNombreEnvaseTerciario() {
        return nombreEnvaseTerciario;
    }

    public void setNombreEnvaseTerciario(String nombreEnvaseTerciario) {
        this.nombreEnvaseTerciario = nombreEnvaseTerciario;
    }

    public String getObsEnvaseTerciario() {
        return obsEnvaseTerciario;
    }

    public void setObsEnvaseTerciario(String obsEnvaseTerciario) {
        this.obsEnvaseTerciario = obsEnvaseTerciario;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
            
}
