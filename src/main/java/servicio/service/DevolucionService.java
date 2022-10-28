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
import servicio.model.Devoluciones;
import servicio.model.DevolucionesBusiness;
import servicio.model.SelectItem;
import servicio.resource.DevolucionResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del DevolucionResource
 */

@Path("/devolucion")
public class DevolucionService {    
    @Path("/devolucion")
    @GET @Produces("application/json")
    public Devoluciones devolucion() {
        return (new Devoluciones());
    }
    @Path("/cargarDevolucionItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarDevolucionItem() {
        DevolucionResource dr = new DevolucionResource();
        return dr.cargarDevolucionItem(new Devoluciones());
    }
    @POST
    @Path("/cargarDevolucion")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Devoluciones> cargarDevolucion(Devoluciones devolucion) {
        DevolucionResource dr = new DevolucionResource();
        return dr.cargarDevolucion(devolucion);
    }
    @POST
    @Path("/guardarDevolucion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarDevolucion(Devoluciones devolucion) throws Exception {
        
            Utiles utiles = new Utiles();
            utiles.getConnection();
            DevolucionResource dr = new DevolucionResource(utiles.getCon());

            dr.guardarDevolucion(devolucion);
            
            utiles.closeConnection();
        
    }
    @Path("/codigoDevolucion")
    @GET @Produces("application/json")
    public String codigoDevolucion() throws Exception {
            DevolucionResource dr = new DevolucionResource();            
        return String.valueOf(dr.codigoDevolucion());
    }
    @POST
    @Path("/editarDevolucion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarDevolucion(Devoluciones devolucion) throws Exception {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            DevolucionResource dr = new DevolucionResource(utiles.getCon());
            dr.editarDevolucion(devolucion);
            utiles.closeConnection();
    }
    @POST
    @Path("/eliminarDevolucion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarDevolucion(Devoluciones devolucion) throws Exception {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            DevolucionResource dr = new DevolucionResource(utiles.getCon());
            dr.eliminarDevolucion(devolucion);
            utiles.closeConnection();
    }
    @POST
    @Path("/buscarDevolucion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Devoluciones buscarDevolucion(Devoluciones devolucion) {
        DevolucionResource dr = new DevolucionResource();
        return dr.buscarDevolucion(devolucion);
    }
    @POST
    @Path("/nroDevolucion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String nroIngresoVenta(Devoluciones d) {
        DevolucionResource dr = new DevolucionResource();
        return String.valueOf(dr.nroDevolucion(d));
    }
    /*/ingresosVenta/guardarIngresosVenta*/
    @POST
    @Path("/guardarDevolucionBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public DevolucionesBusiness guardarDevolucionBusiness(DevolucionesBusiness devolucion) throws Exception {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            DevolucionResource dr = new DevolucionResource(utiles.getCon());
            DevolucionesBusiness db = dr.guardarDevolucionBusiness(devolucion);
            utiles.closeConnection();
            
        return db;
    }
}
