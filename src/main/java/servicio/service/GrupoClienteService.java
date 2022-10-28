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
import servicio.model.GruposCliente;
import servicio.model.SelectItem;
import servicio.resource.GrupoClienteResource;
import servicio.util.Utiles;

/**
 *
 * @author Henry
 * 
 */

@Path("/gruposCliente")
public class GrupoClienteService {    
    @Path("/gruposCliente")
    @GET @Produces("application/json")
    public GruposCliente gruposCliente() {
        return (new GruposCliente());
    }
    @Path("/cargarGruposClienteItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarGruposClienteItem() {
        GrupoClienteResource gcr = new GrupoClienteResource();
        return gcr.cargarGrupoClienteItem();
    }
    @POST
    @Path("/cargarGruposCliente")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<GruposCliente> cargarGruposCliente(GruposCliente gruposCliente) {
        GrupoClienteResource gcr = new GrupoClienteResource();
        return gcr.cargarGruposCliente(gruposCliente);
    }
    @POST
    @Path("/guardarGruposCliente")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarGruposCliente(GruposCliente gruposCliente) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        GrupoClienteResource gcr = new GrupoClienteResource(utiles.getCon());
        gcr.guardarGrupoCliente(gruposCliente);
        utiles.closeConnection();
    }
    @POST
    @Path("/editarGruposCliente")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarGruposCliente(GruposCliente gruposCliente) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        GrupoClienteResource gcr = new GrupoClienteResource(utiles.getCon());
        gcr.editarGrupoCliente(gruposCliente);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarGruposCliente")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarGruposCliente(GruposCliente gruposCliente) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        GrupoClienteResource gcr = new GrupoClienteResource(utiles.getCon());
        gcr.eliminarGrupoCliente(gruposCliente);
        utiles.closeConnection();
    }
    
}
