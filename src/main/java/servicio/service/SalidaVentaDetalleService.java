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
import servicio.model.SalidasVentaDetalle;
import servicio.resource.SalidasVentaDetalleResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 reflejar los metodos del SalidasVentaDetalleResource
 */

@Path("/salidasVentaDetalle")
public class SalidaVentaDetalleService {
    /*/salidasVentaDetalle/salidasVentaDetalle*/
    @Path("/salidasVentaDetalle")
    @GET @Produces("application/json")
    public SalidasVentaDetalle salidasVentaDetalle() {
        return (new SalidasVentaDetalle());
    }
    /*/salidasVentaDetalle/cargarSalidasVentaDetalle*/
    @POST
    @Path("/cargarSalidasVentaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SalidasVentaDetalle> cargarSalidasVentaDetalle(SalidasVentaDetalle sad) {
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource();
        return svdr.cargarSalidasVentaDetalle(sad);
    }
    /*/salidasVentaDetalle/guardarSalidasVentaDetalle*/
    @POST
    @Path("/guardarSalidasVentaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarSalidasVentaDetalle(SalidasVentaDetalle salidasVentaDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource(utiles.getCon());
        svdr.guardarSalidasVentaDetalle(salidasVentaDetalle);
        utiles.closeConnection();
    }    
    /*/salidasVentaDetalle/editarSalidasVentaDetalle*/
    @POST
    @Path("/editarSalidasVentaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarSalidasVentaDetalle(SalidasVentaDetalle sad) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource(utiles.getCon());
        svdr.editarSalidasVentaDetalle(sad);
        utiles.closeConnection();
    }
    /*/salidasVentaDetalle/borraSalidasVentaDetalle*/
    @POST
    @Path("/borraSalidasVentaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void borraSalidasVentaDetalle(SalidasVentaDetalle salidasVentaDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource(utiles.getCon());
        svdr.borrarSalidasVentaDetalle(salidasVentaDetalle);
        utiles.closeConnection();
    }
    @POST
    @Path("/cantRestanteIngresoVentaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public double cantRestanteIngresoVentaDetalle(SalidasVentaDetalle salidasVentaDetalle) throws Exception {        
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource();
        return svdr.cantRestanteIngresoVentaDetalle(salidasVentaDetalle);
    }
    
}
