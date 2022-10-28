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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import servicio.model.EstadosIngresoVenta;
import servicio.resource.CargoResource;
import servicio.resource.EstadoIngresoAlmacenResource;

/**
 *
 * @author Computer
 * reflejar los metodos del EstadosIngresoAlmacenResource
 */

@Path("/estadosIngresoAlmacen")
public class EstadosIngresoAlmacenService {
    @Path("/estadosIngresoAlmacen")
    @GET @Produces("application/json")
    public EstadosIngresoVenta estadosIngresoAlmacen() {
        return (new EstadosIngresoVenta());
    }
    @Path("/cargarEstadosIngresoAlmacenItem")
    @GET @Produces("application/json")
    public List<servicio.model.SelectItem> cargarEstadosIngresoAlmacenItem() {
        EstadoIngresoAlmacenResource eiar = new EstadoIngresoAlmacenResource();
        return eiar.cargarEstadosIngresoAlmacenItem();
    }
    @Path("/cargarEstadosIngresoAlmacen")
    @GET @Produces("application/json")
    public List<EstadosIngresoVenta> cargarEstadosIngresoAlmacen() {
        EstadoIngresoAlmacenResource eiar = new EstadoIngresoAlmacenResource();
        return eiar.cargarEstadosIngresoAlmacen();
    }
    @POST
    @Path("/guardarEstadosIngresoAlmacen")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarEstadosIngresoAlmacen(EstadosIngresoVenta estadosIngresoAlmacen) {
        //EstadosIngresoAlmacenResource.guardarEstadosIngresoAlmacen(estadosIngresoAlmacen);
    }    
    @POST
    @Path("/editarEstadosIngresoAlmacen")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarEstadosIngresoAlmacen(EstadosIngresoVenta estadosIngresoAlmacen) {
        //EstadosIngresoAlmacenResource.editarEstadosIngresoAlmacen(estadosIngresoAlmacen);
    }
    @POST
    @Path("/eliminarEstadosIngresoAlmacen")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarEstadosIngresoAlmacen(EstadosIngresoVenta estadosIngresoAlmacen) {
        //EstadosIngresoAlmacenResource.eliminarEstadosIngresoAlmacen(estadosIngresoAlmacen);
    }    
    
}
