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
import servicio.model.Proveedores;
import servicio.resource.ProveedoresResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del ProveedoresResource
 */

@Path("/proveedores")
public class ProveedoresService {    
    @Path("/proveedores")
    @GET @Produces("application/json")
    public Proveedores proveedores() {
        return (new Proveedores());
    }
    @Path("/cargarProveedoresItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarProveedoresItem() {
        ProveedoresResource pr = new ProveedoresResource();
        return pr.cargarProveedoresItem();
    }
    
    @POST
    @Path("/cargarProveedores")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Proveedores> cargarProveedores(Proveedores p) {
        ProveedoresResource pr = new ProveedoresResource();
        return pr.cargarProveedores(p);
    }
    @POST
    @Path("/guardarProveedores")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarProveedores(Proveedores proveedores) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        ProveedoresResource pr = new ProveedoresResource(utiles.getCon());
        pr.guardarProveedor(proveedores);
        utiles.closeConnection();
    }
    @Path("/codigoProveedor")
    @GET @Produces("application/json")
    public String codigoProveedores() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarProveedores")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarProveedores(Proveedores proveedores) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        ProveedoresResource pr = new ProveedoresResource(utiles.getCon());
        pr.editarProveedor(proveedores);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarProveedores")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarProveedores(Proveedores proveedores) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        ProveedoresResource pr = new ProveedoresResource(utiles.getCon());
        pr.eliminarProveedor(proveedores);
        utiles.closeConnection();
    }
    
}
