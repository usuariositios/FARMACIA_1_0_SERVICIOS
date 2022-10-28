/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.sql.Connection;
import java.util.List;
 

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import servicio.model.DevolucionesDetalle;
import servicio.resource.AlmacenesResource;

import servicio.resource.DevolucionDetalleResource;
import servicio.util.Utiles;



/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/devolucionDetalle")
public class DevolucionDetalleService {
    /*/DevolucionDetalle/DevolucionDetalle*/
    @Path("/devolucionDetalle")
    @GET @Produces("application/json")
    public DevolucionesDetalle DevolucionDetalle() {
        return (new DevolucionesDetalle());
    }
    /*/DevolucionDetalle/cargarDevolucionDetalle*/
    @POST
    @Path("/cargarDevolucionDetalle")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<DevolucionesDetalle> cargarDevolucionDetalle(DevolucionesDetalle DevolucionesDetalle) {
        DevolucionDetalleResource ddr = new DevolucionDetalleResource();
        return ddr.cargarDevolucionesDetalle(DevolucionesDetalle);
    }
    @POST
    @Path("/buscarDevolucionDetalle")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public DevolucionesDetalle buscarDevolucionDetalle(DevolucionesDetalle DevolucionDetalle) {
        DevolucionDetalleResource ddr = new DevolucionDetalleResource();
        return ddr.buscarDevolucionesDetalle(DevolucionDetalle);
    }
    /*/DevolucionDetalle/guardarDevolucionDetalle*/
    @POST
    @Path("/guardarDevolucionDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarDevolucionDetalle(DevolucionesDetalle DevolucionDetalle) {
        try {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        DevolucionDetalleResource ddr = new DevolucionDetalleResource(utiles.getCon());

        ddr.guardarDevolucionesDetalle(DevolucionDetalle);
        utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*/DevolucionDetalle/editarDevolucionDetalle*/
    @POST
    @Path("/editarDevolucionDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarDevolucionDetalle(DevolucionesDetalle DevolucionDetalle) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        DevolucionDetalleResource ddr = new DevolucionDetalleResource(utiles.getCon());
        ddr.editarDevolucionesDetalle(DevolucionDetalle);
        utiles.closeConnection();
    }
    /*/DevolucionDetalle/eliminarIngresoVenta*/
    @POST
    @Path("/eliminarIngresoVenta")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarIngresoVenta(DevolucionesDetalle DevolucionDetalle) {
        
    }
   
    
}
