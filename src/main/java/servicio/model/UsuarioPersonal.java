/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HENRY VALDIVIA
 */

@XmlRootElement
public class UsuarioPersonal {
    int codProyecto = 0;
    Personal personal = new Personal();
    Perfil perfil = new Perfil();
    String nombreUsuario = "";
    String passwordUsuario = "";
    AlmacenesVenta almacenesVenta = new AlmacenesVenta();
    Empresas empresas = new Empresas();
    SucursalVentas sucursalVentas = new SucursalVentas();
    Gestion gestion = new Gestion();
    

    public int getCodProyecto() {
        return codProyecto;
    }

    public void setCodProyecto(int codProyecto) {
        this.codProyecto = codProyecto;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public AlmacenesVenta getAlmacenesVenta() {
        return almacenesVenta;
    }

    public void setAlmacenesVenta(AlmacenesVenta almacenesVenta) {
        this.almacenesVenta = almacenesVenta;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public SucursalVentas getSucursalVentas() {
        return sucursalVentas;
    }

    public void setSucursalVentas(SucursalVentas sucursalVentas) {
        this.sucursalVentas = sucursalVentas;
    }

    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }
    
    
    
    
}
