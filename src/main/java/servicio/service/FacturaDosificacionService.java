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
import servicio.model.FacturaDosificacion;
import servicio.model.SelectItem;
import servicio.resource.FacturaDosificacionResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del FacturaDosificacionResource
 */

@Path("/facturaDosificacion")
public class FacturaDosificacionService {    
    @Path("/facturaDosificacion")
    @GET @Produces("application/json")
    public FacturaDosificacion dosificacionFactura() {
        return (new FacturaDosificacion());
    }
    @Path("/cargarFacturaDosificacionItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarFacturaDosificacionItem() {
        FacturaDosificacionResource fdr = new FacturaDosificacionResource();
        return fdr.cargarFacturaDosificacionItem(new FacturaDosificacion());
    }
    @POST
    @Path("/cargarFacturaDosificacion")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<FacturaDosificacion> cargarFacturaDosificacion(FacturaDosificacion fd) {
        FacturaDosificacionResource fdr = new FacturaDosificacionResource();
        return fdr.cargarFacturaDosificacion(fd);
    }
    @POST
    @Path("/guardarFacturaDosificacion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarFacturaDosificacion(FacturaDosificacion fd) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        FacturaDosificacionResource fdr = new FacturaDosificacionResource(utiles.getCon());
        fdr.guardarFacturaDosificacion(fd);
        utiles.closeConnection();
    }
    @Path("/codigoFacturaDosificacion")
    @GET @Produces("application/json")
    public String codigoFacturaDosificacion() {
        FacturaDosificacionResource fdr = new FacturaDosificacionResource();
        return String.valueOf(fdr.codigoFacturaDosificacion());
    }
    @POST
    @Path("/editarFacturaDosificacion")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarFacturaDosificacion(FacturaDosificacion fd) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        FacturaDosificacionResource fdr = new FacturaDosificacionResource(utiles.getCon());
        fdr.editarFacturaDosificacion(fd);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarFacturaDosificacion")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarFacturaDosificacion(FacturaDosificacion fd) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        FacturaDosificacionResource fdr = new FacturaDosificacionResource(utiles.getCon());
        fdr.eliminarFacturaDosificacion(fd);
        utiles.closeConnection();
    }
    @POST
    @Path("/buscarFacturaDosificacion")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public FacturaDosificacion buscarFacturaDosificacion(FacturaDosificacion fd) {
        FacturaDosificacionResource fdr = new FacturaDosificacionResource();
        return fdr.buscarFacturaDosificacion(fd);
    }
    
}
