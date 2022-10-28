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
import servicio.model.SelectItem;
import servicio.model.Tabla;
import servicio.resource.TablaResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TablaResource
 */

@Path("/tabla")
public class TablaService {
    @Path("/tabla")
    @GET @Produces("application/json")
    public Tabla tabla() {
        return (new Tabla());
    }
    @POST
    @Path("/cargarTablaItem")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SelectItem> cargarTablaItem(Tabla td) {
        TablaResource tdr = new TablaResource();
        return tdr.cargarTablaItem(td);
    }
    
    @POST
    @Path("/cargarTabla")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Tabla> cargarTabla(Tabla p) {
        TablaResource tdr = new TablaResource();
        return tdr.cargarTabla(p);
    }
    @POST
    @Path("/guardarTabla")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public int guardarTabla(Tabla tabla) throws Exception  {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TablaResource tdr = new TablaResource(utiles.getCon());
        int resp = tdr.guardarTabla(tabla);
        utiles.closeConnection();
        return resp;
    }
    
    @POST
    @Path("/editarTabla")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public int editarTabla(Tabla tabla) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TablaResource tdr = new TablaResource(utiles.getCon());
        int resp = tdr.editarTabla(tabla);
        utiles.closeConnection();
        return resp;
    }
    @POST
    @Path("/eliminarTabla")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTabla(Tabla td) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TablaResource tdr = new TablaResource(utiles.getCon());
        tdr.eliminarTabla(td);
        utiles.closeConnection();
    }
    
}
