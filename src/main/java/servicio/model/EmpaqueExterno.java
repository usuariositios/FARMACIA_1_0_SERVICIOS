/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class EmpaqueExterno {
    int codEmpaqueExterno = 0;
    String nombreEmpaqueExterno ="";
    String obsEmpaqueExterno ="";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    

    public int getCodEmpaqueExterno() {
        return codEmpaqueExterno;
    }

    public void setCodEmpaqueExterno(int codEmpaqueExterno) {
        this.codEmpaqueExterno = codEmpaqueExterno;
    }

    public String getNombreEmpaqueExterno() {
        return nombreEmpaqueExterno;
    }

    public void setNombreEmpaqueExterno(String nombreEmpaqueExterno) {
        this.nombreEmpaqueExterno = nombreEmpaqueExterno;
    }

    public String getObsEmpaqueExterno() {
        return obsEmpaqueExterno;
    }

    public void setObsEmpaqueExterno(String obsEmpaqueExterno) {
        this.obsEmpaqueExterno = obsEmpaqueExterno;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
}
