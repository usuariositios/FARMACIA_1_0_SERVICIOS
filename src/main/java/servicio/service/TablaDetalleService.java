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
import servicio.model.TablaDetalle;
import servicio.resource.TablaDetalleResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TablaDetalleResource
 */

@Path("/tablaDetalle")
public class TablaDetalleService {    
    @Path("/tablaDetalle")
    @GET @Produces("application/json")
    public TablaDetalle tablaDetalle() {
        return (new TablaDetalle());
    }
    @POST
    @Path("/cargarTablaDetalleItem")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SelectItem> cargarTablaDetalleItem(TablaDetalle td) {
        TablaDetalleResource tdr = new TablaDetalleResource();
        return tdr.cargarTablaDetalleItem(td);
    }
    
    @POST
    @Path("/cargarTablaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<TablaDetalle> cargarTablaDetalle(TablaDetalle p) {
        TablaDetalleResource tdr = new TablaDetalleResource();
        return tdr.cargarTablaDetalle(p);
    }
    @POST
    @Path("/guardarTablaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public int guardarTablaDetalle(TablaDetalle td) throws Exception  {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TablaDetalleResource tdr = new TablaDetalleResource(utiles.getCon());
        int resp = tdr.guardarTablaDetalle(td);
        utiles.closeConnection();
        return resp;
    }
    @POST
    @Path("/guardarTablaDetalle1")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public int guardarTablaDetalle1(List<TablaDetalle> tdList) throws Exception  {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TablaDetalleResource tdr = new TablaDetalleResource(utiles.getCon());
        int resp = tdr.guardarTablaDetalle1(tdList);
        utiles.closeConnection();
        return resp;
    }
    
    @POST
    @Path("/editarTablaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public int editarTablaDetalle(TablaDetalle td) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TablaDetalleResource tdr = new TablaDetalleResource(utiles.getCon());
        int resp = tdr.editarTablaDetalle(td);
        utiles.closeConnection();
        return resp;
    }
    @POST
    @Path("/editarTablaDetalle1")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public int editarTablaDetalle1(List<TablaDetalle> tdList) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TablaDetalleResource tdr = new TablaDetalleResource(utiles.getCon());
        int resp = tdr.editarTablaDetalle1(tdList);
        utiles.closeConnection();
        return resp;
    }
    @POST
    @Path("/eliminarTablaDetalle")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTablaDetalle(TablaDetalle td) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TablaDetalleResource tdr = new TablaDetalleResource(utiles.getCon());
        tdr.eliminarTablaDetalle(td);
        utiles.closeConnection();
    }
    
}
