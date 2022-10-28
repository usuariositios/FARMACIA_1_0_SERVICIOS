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
import servicio.model.IngresosVenta;
import servicio.model.SalidasVentaDetalle;
import servicio.model.SalidasVentaDetalleIngreso;
import servicio.resource.SalidasVentaDetalleIngresoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 reflejar los metodos del SalidasVentaDetalleIngresoResource
 */

@Path("/salidasVentaDetalleIngreso")
public class SalidaVentaDetalleIngresoService {
    /*/salidasVentaDetalleIngreso/salidasVentaDetalleIngreso*/
    @Path("/salidasVentaDetalleIngreso")
    @GET @Produces("application/json")
    public SalidasVentaDetalleIngreso salidasVentaDetalleIngreso() {
        return (new SalidasVentaDetalleIngreso());
    }
    /*/salidasVentaDetalleIngreso/cargarSalidasVentaDetalleIngreso*/
    @Path("/cargarSalidasVentaDetalleIngreso")
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SalidasVentaDetalleIngreso> cargarSalidasVentaDetalleIngreso(SalidasVentaDetalleIngreso s) {
        SalidasVentaDetalleIngresoResource svdir = new SalidasVentaDetalleIngresoResource();
        return svdir.cargarSalidasVentaDetalleIngreso(s);
    }
    /*/salidasVentaDetalleIngreso/guardarSalidasVentaDetalleIngreso*/
    @POST
    @Path("/guardarSalidasVentaDetalleIngreso")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarSalidasVentaDetalleIngreso(SalidasVentaDetalleIngreso salidasVentaDetalleIngreso) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SalidasVentaDetalleIngresoResource svdir = new SalidasVentaDetalleIngresoResource(utiles.getCon());
        svdir.guardarSalidasVentaDetalleIngreso(salidasVentaDetalleIngreso);
        utiles.closeConnection();
    }    
    /*/salidasVentaDetalleIngreso/editarSalidasVentaDetalleIngreso*/
    @POST
    @Path("/editarSalidasVentaDetalleIngreso")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarSalidasVentaDetalleIngreso(SalidasVentaDetalleIngreso salidasVentaDetalleIngreso)throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SalidasVentaDetalleIngresoResource svdir = new SalidasVentaDetalleIngresoResource(utiles.getCon());
        svdir.editarSalidasVentaDetalleIngreso(salidasVentaDetalleIngreso);
        utiles.closeConnection();
    }
    /*/salidasVentaDetalleIngreso/borraSalidasVentaDetalleIngreso*/
    @POST
    @Path("/borraSalidasVentaDetalleIngreso")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void borraSalidasVentaDetalleIngreso(SalidasVentaDetalleIngreso salidasVentaDetalleIngreso) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SalidasVentaDetalleIngresoResource svdir = new SalidasVentaDetalleIngresoResource(utiles.getCon());
        svdir.borrarSalidasVentaDetalleIngreso(salidasVentaDetalleIngreso);
        utiles.closeConnection();
    }
    
    /*/salidasVentaDetalleIngreso/cargarSalidasVentaDetalleIngreso*/
    @Path("/etiquetasSalidaVentaDetalleIngreso")
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SalidasVentaDetalleIngreso> etiquetasSalidaVentaDetalleIngreso(SalidasVentaDetalleIngreso s) throws Exception {
        
        SalidasVentaDetalleIngresoResource svdir  = new SalidasVentaDetalleIngresoResource();
        return svdir.etiquetasSalidaVentaDetalleIngreso(s);
    }
    /*/salidasVentaDetalleIngreso/cargarSalidasVentaDetalleIngreso*/
    @Path("/buscarSalidasVentaDetalleIngreso")
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SalidasVentaDetalleIngreso> buscarSalidasVentaDetalleIngreso(SalidasVentaDetalleIngreso i) throws Exception {
        SalidasVentaDetalleIngresoResource svdir  = new SalidasVentaDetalleIngresoResource();
        return svdir.buscarSalidasVentaDetalleIngreso(i);
    }
    
    
}
