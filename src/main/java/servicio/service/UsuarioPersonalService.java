/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.util.List;
import servicio.model.SelectItem;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import servicio.model.UsuarioPersonal;
import servicio.resource.UsuarioPersonalResource;

/**
 *
 * @author Computer
 * reflejar los metodos del UsuarioPersonalResource
 */

@Path("/usuarioPersonal")
public class UsuarioPersonalService {    
    @Path("/usuarioPersonal")
    @GET @Produces("application/json")
    public UsuarioPersonal personal() {
        return (new UsuarioPersonal());
    }    
    @Path("/cargarUsuarioPersonal")
    @POST @Produces("application/json")
    public List<UsuarioPersonal> cargarUsuarioPersonal() {
        UsuarioPersonalResource upr = new UsuarioPersonalResource();
        return upr.cargarUsuarioPersonales(new UsuarioPersonal());
    }
    @POST
    @Path("/guardarUsuarioPersonal")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarUsuarioPersonal(UsuarioPersonal personal) {
        UsuarioPersonalResource upr = new UsuarioPersonalResource();
        upr.guardarUsuarioPersonal(personal);
    }
    @Path("/codigoUsuarioPersonal")
    @GET @Produces("application/json")
    public String codigoUsuarioPersonal() {
        UsuarioPersonalResource upr = new UsuarioPersonalResource();
        return String.valueOf(upr.codigoUsuarioPersonal());
    }
    @POST
    @Path("/buscarUsuarioPersonal")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public UsuarioPersonal buscarUsuarioPersonal(UsuarioPersonal personal) {
        UsuarioPersonalResource upr = new UsuarioPersonalResource();
        return upr.buscarUsuarioPersonal(personal);
    }
    /*@POST
    @Path("/editarUsuarioPersonal")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarUsuarioPersonal(UsuarioPersonal personal) {
        UsuarioPersonalResource.editarUsuarioPersonal(personal);
    }
    @POST
    @Path("/eliminarUsuarioPersonal")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarUsuarioPersonal(UsuarioPersonal personal) {
        UsuarioPersonalResource.eliminarUsuarioPersonal(personal);
    }*/
    
}
