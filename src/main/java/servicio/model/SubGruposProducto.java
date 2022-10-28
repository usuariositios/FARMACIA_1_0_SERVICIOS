/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Computer
 */
@XmlRootElement
public class SubGruposProducto extends bean{
    int codSubgrupo = 0;
    GruposProducto gruposProducto = new GruposProducto();
    String nombreSubGrupo = "";
    String descripcion = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodSubgrupo() {
        return codSubgrupo;
    }

    public void setCodSubgrupo(int codSubgrupo) {
        this.codSubgrupo = codSubgrupo;
    }

    public GruposProducto getGruposProducto() {
        return gruposProducto;
    }

    public void setGruposProducto(GruposProducto gruposProducto) {
        this.gruposProducto = gruposProducto;
    }

    public String getNombreSubGrupo() {
        return nombreSubGrupo;
    }

    public void setNombreSubGrupo(String nombreSubGrupo) {
        this.nombreSubGrupo = nombreSubGrupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
    
}
