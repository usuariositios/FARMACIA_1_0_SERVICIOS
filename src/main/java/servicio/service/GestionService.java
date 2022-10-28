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
import javax.ws.rs.core.MediaType;
import servicio.model.Gestion;
import servicio.model.SelectItem;
import servicio.resource.GestionResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del GestionResource
 */

@Path("/gestion")
public class GestionService {    
    @Path("/gestion")
    @GET @Produces("application/json")
    public Gestion gestion() {
        return (new Gestion());
    }    
    @Path("/cargarGestion")
    @GET @Produces("application/json")
    public List<Gestion> cargarGestion() {
        GestionResource gr = new GestionResource();
        return gr.cargarGestiones();
    }
    @Path("/cargarGestionItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarGestionItem() {
        GestionResource gr = new GestionResource();
        return gr.cargarGestionItem();
    }
    @POST
    @Path("/guardarGestion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarGestion(Gestion gestion) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        GestionResource gr = new GestionResource(utiles.getCon());
        gr.guardarGestion(gestion);
        utiles.closeConnection();
    }
    @POST
    @Path("/editarGestion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarGestion(Gestion gestion) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        GestionResource gr = new GestionResource(utiles.getCon());
        gr.editarGestion(gestion);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarGestion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarGestion(Gestion gestion) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        GestionResource gr = new GestionResource(utiles.getCon());
        gr.eliminarGestion(gestion);
        utiles.closeConnection();
    }
    @GET
    @Path("/gestionActiva")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Gestion gestionActiva() {
        GestionResource gr = new GestionResource();
        return gr.gestionActiva();
    }
    
}
