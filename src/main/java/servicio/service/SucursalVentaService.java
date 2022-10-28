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
import servicio.model.SucursalVentas;
import servicio.resource.SucursalVentasResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del SucursalVentasResource
 */

@Path("/sucursalVenta")
public class SucursalVentaService {    
    @Path("/sucursalVenta")
    @GET @Produces("application/json")
    public SucursalVentas sucursalVenta() {
        return (new SucursalVentas());
    }
    @Path("/cargarSucursalVentasItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarSucursalVentasItem() {
        SucursalVentasResource svr = new SucursalVentasResource();
        return svr.cargarSucursalItem();
    }
    @POST
    @Path("/cargarSucursalVentas")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SucursalVentas> cargarSucursalVentas(SucursalVentas sucursalVenta) {
        SucursalVentasResource svr = new SucursalVentasResource();
        return svr.cargarSucursalVentas(sucursalVenta);
    }
    @POST
    @Path("/guardarSucursalVentas")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarSucursalVentas(SucursalVentas sucursalVenta) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        SucursalVentasResource svr = new SucursalVentasResource(utiles.getCon());
        svr.guardarSucursalVentas(sucursalVenta);
        utiles.closeConnection();
    }
    @POST
    @Path("/editarSucursalVentas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarSucursalVentas(SucursalVentas sucursalVenta) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        SucursalVentasResource svr = new SucursalVentasResource(utiles.getCon());
        svr.editarSucursalVentas(sucursalVenta);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarSucursalVentas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarSucursalVentas(SucursalVentas sucursalVenta) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        SucursalVentasResource svr = new SucursalVentasResource(utiles.getCon());
        svr.eliminarSucursalVentas(sucursalVenta);
        utiles.closeConnection();
    }
    
}
