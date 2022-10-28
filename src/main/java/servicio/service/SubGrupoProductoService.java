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
import servicio.model.SubGruposProducto;
import servicio.model.SelectItem;
import servicio.resource.GrupoProductoResource;
import servicio.resource.SubGrupoProductoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del SubGruposProductoResource
 */

@Path("/subGruposProducto")
public class SubGrupoProductoService {    
    @Path("/subGruposProducto")
    @GET @Produces("application/json")
    public SubGruposProducto subGruposProducto() {
        return (new SubGruposProducto());
    }    
    @POST
    @Path("/cargarSubGruposProductoItem")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SelectItem> cargarSubGruposProductoItem(SubGruposProducto s) {
        SubGrupoProductoResource spr = new SubGrupoProductoResource();
        return spr.cargarSubGrupoProductoItem(s);
    }
    @POST
    @Path("/cargarSubGruposProducto")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SubGruposProducto> cargarSubGruposProducto(SubGruposProducto subGruposProducto) {
        SubGrupoProductoResource spr = new SubGrupoProductoResource();
        return spr.cargarSubGruposProducto(subGruposProducto);
    }
    @POST
    @Path("/guardarSubGruposProducto")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarSubGruposProducto(SubGruposProducto subGruposProducto) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SubGrupoProductoResource spr = new SubGrupoProductoResource();        
        spr.guardarSubGrupoProducto(subGruposProducto);
        utiles.closeConnection();
    }
    @POST
    @Path("/editarSubGruposProducto")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarSubGruposProducto(SubGruposProducto subGruposProducto) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SubGrupoProductoResource spr = new SubGrupoProductoResource(utiles.getCon());        
        spr.editarSubGrupoProducto(subGruposProducto);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarSubGruposProducto")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarSubGruposProducto(SubGruposProducto subGruposProducto) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SubGrupoProductoResource spr = new SubGrupoProductoResource(utiles.getCon());        
        spr.eliminarSubGrupoProducto(subGruposProducto);
        utiles.closeConnection();
    }
    
}
