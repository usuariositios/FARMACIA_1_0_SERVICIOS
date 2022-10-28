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
import servicio.busines.IngresosVentaBusinesManager;
import servicio.model.IngresosVenta;

import servicio.model.IngresosVentaBusiness;
import servicio.resource.IngresosVentaResource;
import servicio.util.Utiles;



/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/ingresosVenta")
public class IngresoVentaService {
    /*/ingresosVenta/ingresosVenta*/
    @Path("/ingresosVenta")
    @GET @Produces("application/json")
    public IngresosVenta ingresosVenta() {
        return (new IngresosVenta());
    }
    /*/ingresosVenta/cargarIngresosVenta*/
    @POST
    @Path("/cargarIngresosVenta")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<IngresosVenta> cargarIngresosVenta(IngresosVenta ingresosVenta) throws Exception {
        IngresosVentaResource ivr = new IngresosVentaResource();
        return ivr.cargarIngresosVenta(ingresosVenta);
    }
    @POST
    @Path("/buscarIngresosVenta")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public IngresosVenta buscarIngresosVenta(IngresosVenta ingresosVenta) throws Exception {
        IngresosVentaResource ivr = new IngresosVentaResource();
        return ivr.buscarIngresosVenta(ingresosVenta);
    }
    /*/ingresosVenta/guardarIngresosVenta*/
    @POST
    @Path("/guardarIngresosVenta")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarIngresosVenta(IngresosVenta ingresosVenta) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        IngresosVentaResource ivr = new IngresosVentaResource(utiles.getCon());
        ivr.guardarIngresosVenta(ingresosVenta);
        utiles.closeConnection();
    }
    /*/ingresosVenta/codigoIngresosVenta*/
    @Path("/codigoIngresosVenta")
    @GET    
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String codigoIngresosVenta() {
        
        IngresosVentaResource ivr = new IngresosVentaResource();
        return String.valueOf(ivr.codigoIngresosVenta());
    }
    /*/ingresosVenta/editarIngresosVenta*/
    @POST
    @Path("/editarIngresosVenta")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarIngresosVenta(IngresosVenta ingresosVenta) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        IngresosVentaResource ivr = new IngresosVentaResource(utiles.getCon());
        ivr.editarIngresosVenta(ingresosVenta);
        utiles.closeConnection();
    }
    /*/ingresosVenta/eliminarIngresoVenta*/
    @POST
    @Path("/eliminarIngresoVenta")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarIngresoVenta(IngresosVenta ingresosVenta) {
        
    }
    /*/ingresosVenta/nroIngresoVenta*/
    @POST
    @Path("/nroIngresoVenta")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String nroIngresoVenta(IngresosVenta ia) {
        IngresosVentaResource ivr = new IngresosVentaResource();
        return String.valueOf(ivr.nroIngresoVenta(ia));
    }
    
    /*/ingresosVenta/guardarIngresosVenta*/
    @POST
    @Path("/guardarIngresosVentaBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public IngresosVentaBusiness guardarIngresosVentaBusiness(IngresosVentaBusiness ingresosVenta) throws Exception {        
        IngresosVentaBusinesManager ivbm = new IngresosVentaBusinesManager();
        return ivbm.guardarIngresosVentaBusiness(ingresosVenta);
    }
    /*/ingresosVenta/guardarIngresosVenta*/
    @POST
    @Path("/editarIngresosVentaBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public IngresosVentaBusiness editarIngresosVentaBusiness(IngresosVentaBusiness ingresosVenta) throws Exception {        
        IngresosVentaBusinesManager ivbm = new IngresosVentaBusinesManager();
        return ivbm.editarIngresosVentaBusiness(ingresosVenta);
    }
    @POST
    @Path("/eliminarIngresosVentaBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarIngresosVentaBusiness(IngresosVentaBusiness ingresosVenta) throws Exception {        
        IngresosVentaBusinesManager ivbm = new IngresosVentaBusinesManager();
        ivbm.eliminarIngresosVentaBusiness(ingresosVenta);
    }
    
}
