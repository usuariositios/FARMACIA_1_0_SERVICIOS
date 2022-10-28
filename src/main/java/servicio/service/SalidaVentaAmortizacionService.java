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
import servicio.model.SalidasVentaAmortizacion;
import servicio.model.SalidasVentaAmortizacionBusiness;
import servicio.resource.SalidasVentaAmortizacionResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 reflejar los metodos del SalidasVentaAmortizacionResource
 */

@Path("/salidasVentaAmortizacion")
public class SalidaVentaAmortizacionService {
    /*/salidasVentaAmortizacion/salidasVentaAmortizacion*/
    @Path("/salidasVentaAmortizacion")
    @GET @Produces("application/json")
    public SalidasVentaAmortizacion salidasVentaAmortizacion() {
        return (new SalidasVentaAmortizacion());
    }
    /*/salidasVentaAmortizacion/cargarSalidasVentaAmortizacion*/
    @POST
    @Path("/cargarSalidasVentaAmortizacion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SalidasVentaAmortizacion> cargarSalidasVentaAmortizacion(SalidasVentaAmortizacion sad) {
        SalidasVentaAmortizacionResource svar = new SalidasVentaAmortizacionResource();
        return svar.cargarSalidasVentaAmortizacion(sad);
    }
    /*/salidasVentaAmortizacion/guardarSalidasVentaAmortizacion*/
    @POST
    @Path("/guardarSalidasVentaAmortizacion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarSalidasVentaAmortizacion(SalidasVentaAmortizacion salidasVentaAmortizacion) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SalidasVentaAmortizacionResource svar = new SalidasVentaAmortizacionResource(utiles.getCon());
        svar.guardarSalidasVentaAmortizacion(salidasVentaAmortizacion);
        utiles.closeConnection();
    }    
    /*/salidasVentaAmortizacion/editarSalidasVentaAmortizacion*/
    @POST
    @Path("/editarSalidasVentaAmortizacion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarSalidasVentaAmortizacion(SalidasVentaAmortizacion sad) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SalidasVentaAmortizacionResource svar = new SalidasVentaAmortizacionResource(utiles.getCon());
        svar.editarSalidasVentaAmortizacion(sad);
        utiles.closeConnection();
    }
    /*/salidasVentaAmortizacion/borraSalidasVentaAmortizacion*/
    @POST
    @Path("/borrarSalidasVentaAmortizacion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void borraSalidasVentaAmortizacion(SalidasVentaAmortizacion salidasVentaAmortizacion) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SalidasVentaAmortizacionResource svar = new SalidasVentaAmortizacionResource(utiles.getCon());
        svar.borrarSalidasVentaAmortizacion(salidasVentaAmortizacion);
        utiles.closeConnection();
    }
    @POST
    @Path("/guardarSalidasVentaAmortizacionBusiness")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarSalidasVentaAmortizacionBusiness(SalidasVentaAmortizacionBusiness sb) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SalidasVentaAmortizacionResource svar = new SalidasVentaAmortizacionResource(utiles.getCon());
        svar.guardarSalidaAmortizacionBusiness(sb);
        utiles.closeConnection();
    }

}
