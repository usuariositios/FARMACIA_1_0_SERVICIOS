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
import servicio.model.TiposIngresoVenta;
import servicio.resource.TiposIngresoAlmacenResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposIngresoAlmacenResource
 */

@Path("/tiposIngresoAlmacen")
public class TiposIngresoAlmacenService {    
    @Path("/tiposIngresoAlmacen")
    @GET @Produces("application/json")
    public TiposIngresoVenta tiposIngresoAlmacen() {
        return (new TiposIngresoVenta());
    }
    @Path("/cargarTiposIngresoAlmacenItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposIngresoAlmacenItem() {
        TiposIngresoAlmacenResource tiar = new TiposIngresoAlmacenResource();
        return tiar.cargarTiposIngresoAlmacenItem();
    }
    @Path("/cargarTiposIngresoAlmacen")
    @GET @Produces("application/json")
    public List<TiposIngresoVenta> cargarTiposIngresoAlmacen() {
        TiposIngresoAlmacenResource tiar = new TiposIngresoAlmacenResource();
        return tiar.cargarTiposIngresoAlmacen(new TiposIngresoVenta());
    }
    @POST
    @Path("/guardarTiposIngresoAlmacen")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposIngresoAlmacen(TiposIngresoVenta tiposIngresoAlmacen) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposIngresoAlmacenResource tiar = new TiposIngresoAlmacenResource(utiles.getCon());
        tiar.guardarTiposIngresoAlmacen(tiposIngresoAlmacen);
        utiles.closeConnection();
    }
    @Path("/codigoTiposIngresoAlmacen")
    @GET @Produces("application/json")
    public String codigoTiposIngresoAlmacen() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposIngresoAlmacen")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposIngresoAlmacen(TiposIngresoVenta tiposIngresoAlmacen) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposIngresoAlmacenResource tiar = new TiposIngresoAlmacenResource(utiles.getCon());
        tiar.editarTiposIngresoAlmacen(tiposIngresoAlmacen);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarTiposIngresoAlmacen")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposIngresoAlmacen(TiposIngresoVenta tiposIngresoAlmacen) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposIngresoAlmacenResource tiar = new TiposIngresoAlmacenResource(utiles.getCon());
        tiar.eliminarTiposIngresoAlmacen(tiposIngresoAlmacen);
        utiles.closeConnection();
    }
    
}
