/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.util.List;
import servicio.model.SelectItem;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import servicio.model.CajaChicaDetalle;
import servicio.resource.CajaChicaDetalleResource;
import servicio.util.Utiles;

/**
 *
 * @author Henry
 * reflejar los metodos del CajaChicaDetalleResource
 */

@Path("/cajaChicaDetalle")
public class CajaChicaDetalleService {
    @Path("/cajaChicaDetalle")
    @GET 
    @Produces("application/json")
    public CajaChicaDetalle cajaChicaDetalle() {
        return (new CajaChicaDetalle());
    }
    @Path("/cargarCajaChicaDetalleItem")
    @GET 
    @Produces("application/json")
    public List<SelectItem> cargarCajaChicaDetalleItem(){
        CajaChicaDetalleResource c = new CajaChicaDetalleResource();
        return c.cargarCajaChicaDetalleItem();
    }
    @POST
    @Path("/cargarCajaChicaDetalle")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<CajaChicaDetalle> cargarCajaChicaDetalle(CajaChicaDetalle cajaChicaDetalle) {
        CajaChicaDetalleResource c = new CajaChicaDetalleResource();
        return c.cargarCajaChicaDetalle(cajaChicaDetalle);
    }
    @POST
    @Path("/guardarCajaChicaDetalle")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarCajaChicaDetalle(CajaChicaDetalle cajaChicaDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        CajaChicaDetalleResource c = new CajaChicaDetalleResource(utiles.getCon());
        c.guardarCajaChicaDetalle(cajaChicaDetalle);
        utiles.closeConnection();
    }
    @POST
    @Path("/editarCajaChicaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarCajaChicaDetalle(CajaChicaDetalle cajaChicaDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        CajaChicaDetalleResource c = new CajaChicaDetalleResource(utiles.getCon());
        c.editarCajaChicaDetalle(cajaChicaDetalle);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarCajaChicaDetalle")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarCajaChicaDetalle(CajaChicaDetalle cajaChicaDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        CajaChicaDetalleResource c = new CajaChicaDetalleResource(utiles.getCon());
        c.eliminarCajaChicaDetalle(cajaChicaDetalle);
        utiles.closeConnection();
    }
    
}
