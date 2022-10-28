package servicio.model;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author henry
 */
@XmlRootElement
public class ManagedStart {
    
    List<Empresas> empresaList = new ArrayList<Empresas>();
    SessionData sessionData = new SessionData();
    Usuario usuario = new Usuario();
    UsuarioPersonal usuarioPersonal = new UsuarioPersonal();
    String mensaje = "";
    int loggin = 0;
    
    List<AlmacenesVenta> almacenesList = new ArrayList<AlmacenesVenta>();//seleccion de almacen
    
    

    public SessionData getSessionData() {
        return sessionData;
    }

    public void setSessionData(SessionData sessionData) {
        this.sessionData = sessionData;
    }
    

    public List<Empresas> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresas> empresaList) {
        this.empresaList = empresaList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioPersonal getUsuarioPersonal() {
        return usuarioPersonal;
    }

    public void setUsuarioPersonal(UsuarioPersonal usuarioPersonal) {
        this.usuarioPersonal = usuarioPersonal;
    }

    public List<AlmacenesVenta> getAlmacenesList() {
        return almacenesList;
    }

    public void setAlmacenesList(List<AlmacenesVenta> almacenesList) {
        this.almacenesList = almacenesList;
    }
    /**
     * Creates a new instance of ManagedStart
     */
    public ManagedStart() {
    }
    
    
}
