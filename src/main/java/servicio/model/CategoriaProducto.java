/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author COMPUTER
 */
public class CategoriaProducto {
    int codCategoriaProducto = 0;
    String nombreCategoriaProducto = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodCategoriaProducto() {
        return codCategoriaProducto;
    }

    public void setCodCategoriaProducto(int codCategoriaProducto) {
        this.codCategoriaProducto = codCategoriaProducto;
    }

    public String getNombreCategoriaProducto() {
        return nombreCategoriaProducto;
    }

    public void setNombreCategoriaProducto(String nombreCategoriaProducto) {
        this.nombreCategoriaProducto = nombreCategoriaProducto;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
}
