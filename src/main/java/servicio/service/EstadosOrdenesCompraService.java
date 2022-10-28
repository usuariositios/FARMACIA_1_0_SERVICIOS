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
import servicio.model.EstadosOrdenCompra;

import servicio.resource.EstadosOrdenesCompraResource;

/**
 *
 * @author Computer
 * reflejar los metodos del EstadosOrdenCompraResource
 */

@Path("/estadosOrdenesCompra")
public class EstadosOrdenesCompraService {
    /*@Path("/estadosOrdenesCompra")
    @GET @Produces("application/json")
    public EstadosOrdenCompra estadosOrdenesCompra() {
        return (new EstadosOrdenCompra());
    }
    @Path("/cargarEstadosOrdenCompraItem")
    @GET @Produces("application/json")
    public List<servicio.model.SelectItem> cargarEstadosOrdenCompraItem() {
        return EstadosOrdenesCompraResource.cargarEstadosOrdenCompraItem();
    }
    @Path("/cargarEstadosOrdenCompra")
    @GET @Produces("application/json")
    public List<EstadosOrdenCompra> cargarEstadosOrdenCompra() {
        return EstadosOrdenesCompraResource.cargarEstadosOrdenCompra();
    }
    @POST
    @Path("/guardarEstadosOrdenCompra")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarEstadosOrdenCompra(EstadosOrdenCompra estadosOrdenesCompra) {
        //EstadosOrdenCompraResource.guardarEstadosOrdenCompra(estadosOrdenesCompra);
    }    
    @POST
    @Path("/editarEstadosOrdenCompra")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarEstadosOrdenCompra(EstadosOrdenCompra estadosOrdenesCompra) {
        //EstadosOrdenCompraResource.editarEstadosOrdenCompra(estadosOrdenesCompra);
    }
    @POST
    @Path("/eliminarEstadosOrdenCompra")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarEstadosOrdenCompra(EstadosOrdenCompra estadosOrdenesCompra) {
        //EstadosOrdenCompraResource.eliminarEstadosOrdenCompra(estadosOrdenesCompra);
    }*/
    
}
