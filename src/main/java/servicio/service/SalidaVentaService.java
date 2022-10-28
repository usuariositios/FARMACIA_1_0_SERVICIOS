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
import servicio.busines.SalidasVentaBusinesManager;
import servicio.model.SalidasVenta;
import servicio.model.SalidasVentaBusiness;
import servicio.resource.PersonalResource;
import servicio.resource.SalidasVentaResource;
import servicio.util.Utiles;



/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/salidasVenta")
public class SalidaVentaService {    
    /*/salidasVenta/salidasVenta*/
    @Path("/salidasVenta")
    @GET @Produces("application/json")
    public SalidasVenta salidasVenta() {
        return (new SalidasVenta());
    }
    /*/salidasVenta/cargarSalidasVenta*/
    @POST
    @Path("/cargarSalidasVenta")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SalidasVenta> cargarSalidasVenta(SalidasVenta salidasVenta) throws Exception {
        SalidasVentaResource svr = new SalidasVentaResource();
        return svr.cargarSalidasVenta(salidasVenta);
    }
    /*/salidasVenta/guardarSalidasVenta*/
    @POST
    @Path("/guardarSalidasVenta")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarSalidasVenta(SalidasVenta salidasVenta) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SalidasVentaResource svr = new SalidasVentaResource(utiles.getCon());
        svr.guardarSalidasVenta(salidasVenta);
        utiles.closeConnection();
    }
    /*/salidasVenta/codigoSalidasVenta*/
    @Path("/codigoSalidasVenta")
    @GET    
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String codigoSalidasVenta() {
        SalidasVentaResource svr = new SalidasVentaResource();
        return String.valueOf(svr.codigoSalidasVenta());
    }
    /*/salidasVenta/editarSalidasVenta*/
    @POST
    @Path("/editarSalidasVenta")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarSalidasVenta(SalidasVenta salidasVenta) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();        
        SalidasVentaResource svr = new SalidasVentaResource(utiles.getCon());
        svr.editarSalidasVenta(salidasVenta);
        utiles.closeConnection();
    }
    /*/salidasVenta/eliminarSalidaVenta*/
    @POST
    @Path("/eliminarSalidaVenta")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarSalidaVenta(SalidasVenta salidasVenta) {
        
    }
    /*/salidasVenta/nroSalidaVenta*/
    @POST
    @Path("/nroSalidaVenta")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String nroSalidaVenta(SalidasVenta ia) throws Exception {        
        SalidasVentaResource svr = new SalidasVentaResource();
        return String.valueOf(svr.nroSalidaVenta(ia));
    }
    
    /*/salidasVenta/guardarSalidasVenta*/
    @POST
    @Path("/guardarSalidasVentaBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SalidasVentaBusiness guardarSalidasVentaBusiness(SalidasVentaBusiness salidasVenta) throws Exception {
        SalidasVentaBusiness svb = new SalidasVentaBusiness();
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        try{
            
            SalidasVentaBusinesManager svbm = new SalidasVentaBusinesManager(utiles.getCon());
            svb = svbm.guardarSalidasVentaBusiness(salidasVenta);
            utiles.getCon().commit();
            utiles.setAutoCommit(true);
        }catch(Exception ex){
            ex.printStackTrace();
            utiles.getCon().rollback();
            throw new Exception(ex.getMessage());
        }
        utiles.closeConnection();
        return svb;
    }
    /*/salidasVenta/guardarSalidasVenta*/
    @POST
    @Path("/editarSalidasVentaBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarSalidasVentaBusiness(SalidasVentaBusiness salidasVenta) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        
        try{
            SalidasVentaBusinesManager svbm = new SalidasVentaBusinesManager(utiles.getCon());
            svbm.editarSalidasVentaBusiness(salidasVenta);
            utiles.getCon().commit();
            utiles.setAutoCommit(true);
        }catch(Exception ex){ex.printStackTrace();
            utiles.getCon().rollback();
            throw new Exception(ex.getMessage());
        }
        utiles.closeConnection();
        
    }
    @POST
    @Path("/eliminarSalidasVentaBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarSalidasVentaBusiness(SalidasVentaBusiness salidasVenta) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        try{
            SalidasVentaBusinesManager svbm = new SalidasVentaBusinesManager(utiles.getCon());
            svbm.eliminarSalidasVentaBusiness(salidasVenta);
            utiles.getCon().commit();
            utiles.setAutoCommit(true);
        }catch(Exception ex){ex.printStackTrace();        
            utiles.getCon().rollback();
            throw new Exception(ex.getMessage());
        }
        utiles.closeConnection();        
        
    }
    @POST
    @Path("/buscarSalidasVenta")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SalidasVenta buscarSalidasVenta(SalidasVenta salidasVenta) throws Exception {
        SalidasVentaResource svr = new SalidasVentaResource();
        return svr.buscarSalidasVenta(salidasVenta);
    }
    
    @POST
    @Path("/anularSalidasVentaBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void anularSalidasVentaBusiness(SalidasVentaBusiness salidasVenta) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        try{
            SalidasVentaBusinesManager svbm = new SalidasVentaBusinesManager(utiles.getCon());
            svbm.anularSalidasVentaBusiness(salidasVenta);
            utiles.getCon().commit();
            utiles.setAutoCommit(true);
        }catch(Exception ex){ex.printStackTrace();        
            utiles.getCon().rollback();
            throw new Exception(ex.getMessage());
        }
        utiles.closeConnection();        
        
    }
    
}
