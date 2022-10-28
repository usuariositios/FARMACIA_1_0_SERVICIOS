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
import servicio.model.OrdenesCompra;
import servicio.model.OrdenesCompraDetalle;
import servicio.resource.OrdenCompraDetalleResource;
import servicio.util.Utiles;



/**
 *
 * @author Computer
 * reflejar los metodos del OrdenesCompraDetalleResource
 */

@Path("/ordenesCompraDetalle")
public class OrdenesCompraDetalleService {
    /*/ordenesCompraDetalle/ordenesCompraDetalle*/
    @Path("/ordenesCompraDetalle")
    @GET @Produces("application/json")
    public OrdenesCompraDetalle ordenesCompraDetalle() {
        return (new OrdenesCompraDetalle());
    }
    
    @POST
    @Path("/cargarOrdenesCompraDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<OrdenesCompraDetalle> cargarOrdenesCompraDetalle(OrdenesCompra ordenesCompra) {
        OrdenCompraDetalleResource ocdr = new OrdenCompraDetalleResource();
        return ocdr.cargarOrdenesCompraDetalle(ordenesCompra);
    }
    
    @POST
    @Path("/guardarOrdenesCompraDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarOrdenesCompraDetalle(OrdenesCompraDetalle ordenesCompraDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        OrdenCompraDetalleResource ocdr = new OrdenCompraDetalleResource(utiles.getCon());
        ocdr.guardarOrdenesCompraDetalle(ordenesCompraDetalle);
        utiles.closeConnection();
    }
    
    @Path("/codigoOrdenesCompraDetalle")
    @GET @Produces("application/json")
    public String codigoOrdenesCompraDetalle() {
        return "0";
    }
    
    @POST
    @Path("/editarOrdenesCompraDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarOrdenesCompraDetalle(OrdenesCompraDetalle ordenesCompraDetalle) {
        
    }
    
    @POST
    @Path("/borraOrdenesCompraDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void borraOrdenesCompraDetalle(OrdenesCompraDetalle ordenesCompraDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        OrdenCompraDetalleResource ocdr = new OrdenCompraDetalleResource(utiles.getCon());
        ocdr.borraOrdenesCompraDetalle(ordenesCompraDetalle);
        utiles.closeConnection();
    }
    
    
}
