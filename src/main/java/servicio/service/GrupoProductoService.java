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
import servicio.model.GruposProducto;
import servicio.model.SelectItem;
import servicio.resource.GrupoProductoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del GruposProductoResource
 */

@Path("/gruposProducto")
public class GrupoProductoService {    
    @Path("/gruposProducto")
    @GET @Produces("application/json")
    public GruposProducto gruposProducto() {
        return (new GruposProducto());
    }
    @Path("/cargarGruposProductoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarGruposProductoItem() {
        GrupoProductoResource gpr = new GrupoProductoResource();
        return gpr.cargarGrupoProductoItem();
    }
    @POST
    @Path("/cargarGruposProducto")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<GruposProducto> cargarGruposProducto(GruposProducto gruposProducto) {
        GrupoProductoResource gpr = new GrupoProductoResource();
        return gpr.cargarGruposProducto(gruposProducto);
    }
    @POST
    @Path("/guardarGruposProducto")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarGruposProducto(GruposProducto gruposProducto) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        GrupoProductoResource gpr = new GrupoProductoResource(utiles.getCon());
        gpr.guardarGrupoProducto(gruposProducto);
        utiles.closeConnection();
    }
    @POST
    @Path("/editarGruposProducto")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarGruposProducto(GruposProducto gruposProducto) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        GrupoProductoResource gpr = new GrupoProductoResource(utiles.getCon());
        gpr.editarGrupoProducto(gruposProducto);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarGruposProducto")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarGruposProducto(GruposProducto gruposProducto) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        GrupoProductoResource gpr = new GrupoProductoResource(utiles.getCon());
        gpr.eliminarGrupoProducto(gruposProducto);
        utiles.closeConnection();
    }
    
}
