/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Computer
 */
@XmlRootElement
public class GruposMaterial {
    int codGrupoMaterial = 0;
    String nombreGrupoMaterial = "";
    CapitulosMaterial capitulosMaterial = new CapitulosMaterial();
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodGrupoMaterial() {
        return codGrupoMaterial;
    }

    public void setCodGrupoMaterial(int codGrupoMaterial) {
        this.codGrupoMaterial = codGrupoMaterial;
    }

    public String getNombreGrupoMaterial() {
        return nombreGrupoMaterial;
    }

    public void setNombreGrupoMaterial(String nombreGrupoMaterial) {
        this.nombreGrupoMaterial = nombreGrupoMaterial;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public CapitulosMaterial getCapitulosMaterial() {
        return capitulosMaterial;
    }

    public void setCapitulosMaterial(CapitulosMaterial capitulosMaterial) {
        this.capitulosMaterial = capitulosMaterial;
    }
    
}
