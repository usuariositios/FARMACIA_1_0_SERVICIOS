/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class CapitulosMaterial {
    int codCapituloMaterial = 0;
    String nombreCapituloMaterial = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodCapituloMaterial() {
        return codCapituloMaterial;
    }

    public void setCodCapituloMaterial(int codCapituloMaterial) {
        this.codCapituloMaterial = codCapituloMaterial;
    }

    public String getNombreCapituloMaterial() {
        return nombreCapituloMaterial;
    }

    public void setNombreCapituloMaterial(String nombreCapituloMaterial) {
        this.nombreCapituloMaterial = nombreCapituloMaterial;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
            
    
    
    
}
