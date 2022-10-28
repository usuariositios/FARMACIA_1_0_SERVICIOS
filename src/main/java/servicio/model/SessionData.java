/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author henry
 */
public class SessionData {
    Personal personal = new Personal();
    Empresas empresa = new Empresas();
    UsuarioPersonal usuario = new UsuarioPersonal();
    Gestion gestion = new Gestion();
    AlmacenesVenta almacenes = new AlmacenesVenta();

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

    public UsuarioPersonal getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioPersonal usuario) {
        this.usuario = usuario;
    }

    

    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }

    public AlmacenesVenta getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(AlmacenesVenta almacenes) {
        this.almacenes = almacenes;
    }
    
    
    
    
}
