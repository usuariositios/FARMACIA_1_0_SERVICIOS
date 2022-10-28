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
import servicio.model.TiposDescuento;
import servicio.resource.TiposDescuentoResource;
import servicio.util.Utiles;

/**
 *
 * @author Henry
 * 
 */

@Path("/tiposDescuento")
public class TiposDescuentoService {    
    @Path("/tiposDescuento")
    @GET @Produces("application/json")
    public TiposDescuento tiposDescuento() {
        return (new TiposDescuento());
    }
    @Path("/cargarTiposDescuentoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposDescuentoItem() {
        TiposDescuentoResource tdr = new TiposDescuentoResource();
        return tdr.cargarTiposDescuentoItem();
    }
    @Path("/cargarTiposDescuento")
    @GET @Produces("application/json")
    public List<TiposDescuento> cargarTiposDescuento() {
        TiposDescuentoResource tdr = new TiposDescuentoResource();
        return tdr.cargarTiposDescuento(new TiposDescuento());
    }
    @POST
    @Path("/guardarTiposDescuento")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposDescuento(TiposDescuento tiposDescuento) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposDescuentoResource tdr = new TiposDescuentoResource(utiles.getCon());
        tdr.guardarTiposDescuento(tiposDescuento);
        utiles.closeConnection();
    }
    @Path("/codigoTiposDescuento")
    @GET @Produces("application/json")
    public String codigoTiposDescuento() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposDescuento")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposDescuento(TiposDescuento tiposDescuento) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposDescuentoResource tdr = new TiposDescuentoResource(utiles.getCon());
        tdr.editarTiposDescuento(tiposDescuento);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarTiposDescuento")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposDescuento(TiposDescuento tiposDescuento) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposDescuentoResource tdr = new TiposDescuentoResource(utiles.getCon());
        tdr.eliminarTiposDescuento(tiposDescuento);
        utiles.closeConnection();
    }
    
}
