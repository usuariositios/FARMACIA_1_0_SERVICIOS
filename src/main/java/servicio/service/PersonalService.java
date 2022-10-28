/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.util.List;
 

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import servicio.model.Personal;
import servicio.model.SelectItem;
import servicio.resource.PersonalResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/personal")
public class PersonalService {
    @GET
    @Path("/factorial")
    public String factorial(@QueryParam("base") long base) {

        return Long.toString(5*base);
    }
    @Path("/personal")
    @GET @Produces("application/json")
    public Personal personal() {
        return (new Personal());
    }
    @Path("/cargarPersonalItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarPersonalItem() {
        PersonalResource pr = new PersonalResource();
        return pr.cargarPersonalItem();
    }
    @Path("/cargarPersonal")
    @GET @Produces("application/json")
    public List<Personal> cargarPersonal() {
        PersonalResource pr = new PersonalResource();
        return pr.cargarPersonal(new Personal());
    }
    @POST
    @Path("/guardarPersonal")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarPersonal(Personal personal) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        PersonalResource pr = new PersonalResource(utiles.getCon());
        pr.guardarPersonal(personal);
        utiles.closeConnection();
    }
    @Path("/codigoPersonal")
    @GET @Produces("application/json")
    public String codigoPersonal() {
        PersonalResource pr = new PersonalResource();
        return String.valueOf(pr.codigoPersonal());
    }
    @POST
    @Path("/editarPersonal")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarPersonal(Personal personal) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        PersonalResource pr = new PersonalResource(utiles.getCon());
        pr.editarPersonal(personal);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarPersonal")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarPersonal(Personal personal) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        PersonalResource pr = new PersonalResource(utiles.getCon());
        pr.eliminarPersonal(personal);
        utiles.closeConnection();
    }
    
}
