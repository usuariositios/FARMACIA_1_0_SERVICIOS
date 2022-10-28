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
import servicio.model.TiposPago;
import servicio.resource.TiposPagoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposPagoResource
 */

@Path("/tiposPago")
public class TiposPagoService {    
    @Path("/tiposPago")
    @GET @Produces("application/json")
    public TiposPago tiposPago() {
        return (new TiposPago());
    }
    @Path("/cargarTiposPagoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposPagoItem() {
        TiposPagoResource tpr = new TiposPagoResource();
        return tpr.cargarTiposPagoItem();
    }
    @Path("/cargarTiposPago")
    @GET @Produces("application/json")
    public List<TiposPago> cargarTiposPago() {
        TiposPagoResource tpr = new TiposPagoResource();
        return tpr.cargarTiposPago(new TiposPago());
    }
    @POST
    @Path("/guardarTiposPago")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposPago(TiposPago tiposPago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposPagoResource tpr = new TiposPagoResource(utiles.getCon());
        tpr.guardarTiposPago(tiposPago);
        utiles.closeConnection();
        
    }
    @Path("/codigoTiposPago")
    @GET @Produces("application/json")
    public String codigoTiposPago() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposPago")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposPago(TiposPago tiposPago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposPagoResource tpr = new TiposPagoResource(utiles.getCon());
        tpr.editarTiposPago(tiposPago);
    }
    @POST
    @Path("/eliminarTiposPago")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposPago(TiposPago tiposPago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposPagoResource tpr = new TiposPagoResource(utiles.getCon());
        tpr.eliminarTiposPago(tiposPago);
        utiles.closeConnection();
    }
    
}
