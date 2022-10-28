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
import servicio.model.Moneda;
import servicio.resource.MonedaResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del MonedaResource
 */

@Path("/moneda")
public class MonedaService {
    @Path("/moneda")
    @GET @Produces("application/json")
    public Moneda moneda() {
        return (new Moneda());
    }
    @Path("/cargarMoneda")
    @GET @Produces("application/json")
    public List<Moneda> cargarMoneda() {
        MonedaResource mr = new MonedaResource();
        return mr.cargarMonedas();
    }
    @Path("/cargarMonedasItem")
    @GET @Produces("application/json")
    public List<servicio.model.SelectItem> cargarMonedasItem() {
        MonedaResource mr = new MonedaResource();
        return mr.cargarMonedasItem();
    }
    @POST
    @Path("/guardarMoneda")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarMoneda(Moneda moneda) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        MonedaResource mr = new MonedaResource(utiles.getCon());        
        mr.guardarMoneda(moneda);
        utiles.closeConnection();
    }    
    @POST
    @Path("/editarMoneda")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarMoneda(Moneda moneda) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        MonedaResource mr = new MonedaResource(utiles.getCon());
        mr.editarMoneda(moneda);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarMoneda")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarMoneda(Moneda moneda) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        MonedaResource mr = new MonedaResource(utiles.getCon());
        mr.eliminarMoneda(moneda);
        utiles.closeConnection();
    }    
    
}
