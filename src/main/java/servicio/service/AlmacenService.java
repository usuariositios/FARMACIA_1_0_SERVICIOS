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
import javax.ws.rs.core.MediaType;
import servicio.model.AlmacenesVenta;
import servicio.resource.AlmacenesResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del AlmacenesResource
 */

@Path("/almacenes")
public class AlmacenService {    
    @Path("/almacenes")
    @GET @Produces({MediaType.APPLICATION_JSON})
    public AlmacenesVenta almacenes() {
        return (new AlmacenesVenta());
    }
    @Path("/cargarAlmacenesItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarAlmacenesItem() {
        AlmacenesResource ar = new AlmacenesResource();
        return ar.cargarAlmacenItem();
    }
    @POST
    @Path("/cargarAlmacenes")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<AlmacenesVenta> cargarAlmacenes(AlmacenesVenta a) {
        AlmacenesResource ar = new AlmacenesResource();
        return ar.cargarAlmacenes(a);
    }
    @POST
    @Path("/guardarAlmacenes")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarAlmacenes(AlmacenesVenta almacenes) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        AlmacenesResource ar = new AlmacenesResource(utiles.getCon());
        ar.guardarAlmacen(almacenes);
        utiles.closeConnection();
    }    
    @POST
    @Path("/editarAlmacenes")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarAlmacenes(AlmacenesVenta almacenes) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        AlmacenesResource ar = new AlmacenesResource(utiles.getCon());
        ar.editarAlmacen(almacenes);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarAlmacenes")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarAlmacenes(AlmacenesVenta almacenes) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        AlmacenesResource ar = new AlmacenesResource(utiles.getCon());
        ar.eliminarAlmacen(almacenes);
        utiles.closeConnection();
    }
    
}
