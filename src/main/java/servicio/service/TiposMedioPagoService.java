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
import servicio.model.TiposMedioPago;
import servicio.resource.TiposMedioPagoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposMedioPagoResource
 */

@Path("/tiposMedioPago")
public class TiposMedioPagoService {    
    @Path("/tiposMedioPago")
    @GET @Produces("application/json")
    public TiposMedioPago tiposMedioPago() {
        return (new TiposMedioPago());
    }
    @Path("/cargarTiposMedioPagoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposMedioPagoItem() throws Exception {
        
        TiposMedioPagoResource tmpr = new TiposMedioPagoResource();
        return tmpr.cargarTiposMedioPagoItem();
    }
    @Path("/cargarTiposMedioPago")
    @GET @Produces("application/json")
    public List<TiposMedioPago> cargarTiposMedioPago() {
        TiposMedioPagoResource tmpr = new TiposMedioPagoResource();
        return tmpr.cargarTiposMedioPago(new TiposMedioPago());
    }
    @POST
    @Path("/guardarTiposMedioPago")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposMedioPago(TiposMedioPago tiposMedioPago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposMedioPagoResource tmpr = new TiposMedioPagoResource(utiles.getCon());
        tmpr.guardarTiposMedioPago(tiposMedioPago);
        utiles.closeConnection();
    }
    @Path("/codigoTiposMedioPago")
    @GET @Produces("application/json")
    public String codigoTiposMedioPago() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposMedioPago")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposMedioPago(TiposMedioPago tiposMedioPago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposMedioPagoResource tmpr = new TiposMedioPagoResource(utiles.getCon());
        tmpr.editarTiposMedioPago(tiposMedioPago);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarTiposMedioPago")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposMedioPago(TiposMedioPago tiposMedioPago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposMedioPagoResource tmpr = new TiposMedioPagoResource(utiles.getCon());
        tmpr.eliminarTiposMedioPago(tiposMedioPago);
        utiles.closeConnection();
        
    }
    
}
