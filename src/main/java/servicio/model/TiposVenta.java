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
public class TiposVenta {
    int codTipoVenta = 0;
    String nombreTipoVenta = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodTipoVenta() {
        return codTipoVenta;
    }

    public void setCodTipoVenta(int codTipoVenta) {
        this.codTipoVenta = codTipoVenta;
    }

    public String getNombreTipoVenta() {
        return nombreTipoVenta;
    }

    public void setNombreTipoVenta(String nombreTipoVenta) {
        this.nombreTipoVenta = nombreTipoVenta;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
}
