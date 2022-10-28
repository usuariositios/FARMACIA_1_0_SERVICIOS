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
import servicio.model.TiposSalidaVenta;
import servicio.resource.TiposSalidaAlmacenResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposSalidaAlmacenResource
 */

@Path("/tiposSalidaAlmacen")
public class TiposSalidaAlmacenService {    
    @Path("/tiposSalidaAlmacen")
    @GET @Produces("application/json")
    public TiposSalidaVenta tiposSalidaAlmacen() {
        return (new TiposSalidaVenta());
    }
    @Path("/cargarTiposSalidaAlmacenItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposSalidaAlmacenItem() {
        TiposSalidaAlmacenResource tsar = new TiposSalidaAlmacenResource();
        return tsar.cargarTiposSalidaAlmacenItem();
    }
    @Path("/cargarTiposSalidaAlmacen")
    @GET @Produces("application/json")
    public List<TiposSalidaVenta> cargarTiposSalidaAlmacen() {
        TiposSalidaAlmacenResource tsar = new TiposSalidaAlmacenResource();
        return tsar.cargarTiposSalidaAlmacen(new TiposSalidaVenta());
    }
    @POST
    @Path("/guardarTiposSalidaAlmacen")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposSalidaAlmacen(TiposSalidaVenta tiposSalidaAlmacen) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposSalidaAlmacenResource tsar = new TiposSalidaAlmacenResource(utiles.getCon());
        tsar.guardarTiposSalidaAlmacen(tiposSalidaAlmacen);
        utiles.closeConnection();
    }
    @Path("/codigoTiposSalidaAlmacen")
    @GET @Produces("application/json")
    public String codigoTiposSalidaAlmacen() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposSalidaAlmacen")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposSalidaAlmacen(TiposSalidaVenta tiposSalidaAlmacen) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposSalidaAlmacenResource tsar = new TiposSalidaAlmacenResource(utiles.getCon());
        tsar.editarTiposSalidaAlmacen(tiposSalidaAlmacen);
        utiles.closeConnection();
        
    }
    @POST
    @Path("/eliminarTiposSalidaAlmacen")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposSalidaAlmacen(TiposSalidaVenta tiposSalidaAlmacen) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposSalidaAlmacenResource tsar = new TiposSalidaAlmacenResource(utiles.getCon());
        tsar.eliminarTiposSalidaAlmacen(tiposSalidaAlmacen);
        utiles.closeConnection();
    }
    
}
