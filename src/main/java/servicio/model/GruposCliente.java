/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Henry
 */
public class GruposCliente {
    int codGrupoCliente = 0;
    String nombreGrupoCliente = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodGrupoCliente() {
        return codGrupoCliente;
    }

    public void setCodGrupoCliente(int codGrupoCliente) {
        this.codGrupoCliente = codGrupoCliente;
    }

    public String getNombreGrupoCliente() {
        return nombreGrupoCliente;
    }

    public void setNombreGrupoCliente(String nombreGrupoCliente) {
        this.nombreGrupoCliente = nombreGrupoCliente;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
}
