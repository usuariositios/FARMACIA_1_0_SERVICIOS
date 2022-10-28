/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class Filiales extends bean {
    int codFilial = 0;
    String nombreFilial = "";
    String obsFilial = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    int codTerritorio = 0;

    public int getCodFilial() {
        return codFilial;
    }

    public void setCodFilial(int codFilial) {
        this.codFilial = codFilial;
    }

    public String getNombreFilial() {
        return nombreFilial;
    }

    public void setNombreFilial(String nombreFilial) {
        this.nombreFilial = nombreFilial;
    }

    public String getObsFilial() {
        return obsFilial;
    }

    public void setObsFilial(String obsFilial) {
        this.obsFilial = obsFilial;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public int getCodTerritorio() {
        return codTerritorio;
    }

    public void setCodTerritorio(int codTerritorio) {
        this.codTerritorio = codTerritorio;
    }
    
    
    
            
}
