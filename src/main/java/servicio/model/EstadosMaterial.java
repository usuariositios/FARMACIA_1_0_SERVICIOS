/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class EstadosMaterial {
    int codEstadoMaterial = 0;
    String nombreEstadoMaterial = "";
    String obsEstadoMaterial = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodEstadoMaterial() {
        return codEstadoMaterial;
    }

    public void setCodEstadoMaterial(int codEstadoMaterial) {
        this.codEstadoMaterial = codEstadoMaterial;
    }

    public String getNombreEstadoMaterial() {
        return nombreEstadoMaterial;
    }

    public void setNombreEstadoMaterial(String nombreEstadoMaterial) {
        this.nombreEstadoMaterial = nombreEstadoMaterial;
    }

    public String getObsEstadoMaterial() {
        return obsEstadoMaterial;
    }

    public void setObsEstadoMaterial(String obsEstadoMaterial) {
        this.obsEstadoMaterial = obsEstadoMaterial;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
