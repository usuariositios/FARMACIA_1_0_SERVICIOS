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
public class AlmacenesVenta extends bean {
    int codAlmacenVenta = 0;
    Filiales filiales = new Filiales();
    String nombreAlmacenVenta = "";
    String obsAlmacen = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();
    SucursalVentas sucursalVentas = new SucursalVentas();

    public int getCodAlmacenVenta() {
        return codAlmacenVenta;
    }

    public void setCodAlmacenVenta(int codAlmacenVenta) {
        this.codAlmacenVenta = codAlmacenVenta;
    }

    public Filiales getFiliales() {
        return filiales;
    }

    public void setFiliales(Filiales filiales) {
        this.filiales = filiales;
    }

    public String getNombreAlmacenVenta() {
        return nombreAlmacenVenta;
    }

    public void setNombreAlmacenVenta(String nombreAlmacenVenta) {
        this.nombreAlmacenVenta = nombreAlmacenVenta;
    }

    public String getObsAlmacen() {
        return obsAlmacen;
    }

    public void setObsAlmacen(String obsAlmacen) {
        this.obsAlmacen = obsAlmacen;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public SucursalVentas getSucursalVentas() {
        return sucursalVentas;
    }

    public void setSucursalVentas(SucursalVentas sucursalVentas) {
        this.sucursalVentas = sucursalVentas;
    }
    
    
            
    
}
