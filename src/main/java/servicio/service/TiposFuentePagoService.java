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
import servicio.model.TiposFuentePago;
import servicio.resource.TiposFuentePagoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposFuentePagoResource
 */

@Path("/tiposFuentePago")
public class TiposFuentePagoService {    
    @Path("/tiposFuentePago")
    @GET @Produces("application/json")
    public TiposFuentePago tiposFuentePago() {
        return (new TiposFuentePago());
    }
    @Path("/cargarTiposFuentePagoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposFuentePagoItem() {
        TiposFuentePagoResource tfpr = new TiposFuentePagoResource();
        return tfpr.cargarTiposFuentePagoItem();
    }
    @Path("/cargarTiposFuentePago")
    @GET @Produces("application/json")
    public List<TiposFuentePago> cargarTiposFuentePago() {
        TiposFuentePagoResource tfpr = new TiposFuentePagoResource();
        return tfpr.cargarTiposFuentePago(new TiposFuentePago());
    }
    @POST
    @Path("/guardarTiposFuentePago")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposFuentePago(TiposFuentePago tiposFuentePago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposFuentePagoResource tfpr = new TiposFuentePagoResource(utiles.getCon());
        tfpr.guardarTiposFuentePago(tiposFuentePago);
        utiles.closeConnection();
    }
    @Path("/codigoTiposFuentePago")
    @GET @Produces("application/json")
    public String codigoTiposFuentePago() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposFuentePago")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposFuentePago(TiposFuentePago tiposFuentePago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposFuentePagoResource tfpr = new TiposFuentePagoResource(utiles.getCon());
        tfpr.editarTiposFuentePago(tiposFuentePago);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarTiposFuentePago")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposFuentePago(TiposFuentePago tiposFuentePago) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposFuentePagoResource tfpr = new TiposFuentePagoResource(utiles.getCon());
        tfpr.eliminarTiposFuentePago(tiposFuentePago);
        utiles.closeConnection();
    }
    
}
