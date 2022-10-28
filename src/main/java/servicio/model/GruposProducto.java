/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class GruposProducto extends bean{
    int codGrupoProducto = 0;
    String nombreGrupoProducto = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodGrupoProducto() {
        return codGrupoProducto;
    }

    public void setCodGrupoProducto(int codGrupoProducto) {
        this.codGrupoProducto = codGrupoProducto;
    }

    public String getNombreGrupoProducto() {
        return nombreGrupoProducto;
    }

    public void setNombreGrupoProducto(String nombreGrupoProducto) {
        this.nombreGrupoProducto = nombreGrupoProducto;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
