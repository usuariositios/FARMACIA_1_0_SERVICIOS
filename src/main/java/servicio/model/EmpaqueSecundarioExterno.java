/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class EmpaqueSecundarioExterno {
    int codEmpaqueSecundarioExterno = 0;
    String nombreEmpaqueSecundarioExterno ="";
    String obsEmpaqueSecundarioExterno ="";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    

    public int getCodEmpaqueSecundarioExterno() {
        return codEmpaqueSecundarioExterno;
    }

    public void setCodEmpaqueSecundarioExterno(int codEmpaqueSecundarioExterno) {
        this.codEmpaqueSecundarioExterno = codEmpaqueSecundarioExterno;
    }

    public String getNombreEmpaqueSecundarioExterno() {
        return nombreEmpaqueSecundarioExterno;
    }

    public void setNombreEmpaqueSecundarioExterno(String nombreEmpaqueSecundarioExterno) {
        this.nombreEmpaqueSecundarioExterno = nombreEmpaqueSecundarioExterno;
    }

    public String getObsEmpaqueSecundarioExterno() {
        return obsEmpaqueSecundarioExterno;
    }

    public void setObsEmpaqueSecundarioExterno(String obsEmpaqueSecundarioExterno) {
        this.obsEmpaqueSecundarioExterno = obsEmpaqueSecundarioExterno;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
}
