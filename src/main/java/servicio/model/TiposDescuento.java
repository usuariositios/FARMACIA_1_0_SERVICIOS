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
public class TiposDescuento {
    int codTipoDescuento = 0;
    String nombreTipoDescuento = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoDescuento() {
        return codTipoDescuento;
    }

    public void setCodTipoDescuento(int codTipoDescuento) {
        this.codTipoDescuento = codTipoDescuento;
    }

    public String getNombreTipoDescuento() {
        return nombreTipoDescuento;
    }

    public void setNombreTipoDescuento(String nombreTipoDescuento) {
        this.nombreTipoDescuento = nombreTipoDescuento;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
