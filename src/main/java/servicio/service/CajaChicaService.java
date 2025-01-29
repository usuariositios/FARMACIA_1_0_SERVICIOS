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
import servicio.model.CajaChica;
import servicio.resource.CajaChicaResource;
import servicio.util.Utiles;

/**
 *
 * @author Henry
 * reflejar los metodos del CajaChicaResource
 */

@Path("/cajaChica")
public class CajaChicaService {
    @Path("/cajaChica")
    @GET 
    @Produces("application/json")
    public CajaChica cajaChica() {
        return (new CajaChica());
    }
    @Path("/cargarCajaChicaItem")
    @GET 
    @Produces("application/json")
    public List<SelectItem> cargarCajaChicaItem(){
        CajaChicaResource c = new CajaChicaResource();
        return c.cargarCajaChicaItem();
    }
    @POST
    @Path("/cargarCajaChica")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<CajaChica> cargarCajaChica(CajaChica cajaChica) {
        CajaChicaResource c = new CajaChicaResource();
        return c.cargarCajaChica(cajaChica);
    }
    @POST
    @Path("/guardarCajaChica")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarCajaChica(CajaChica cajaChica) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        CajaChicaResource c = new CajaChicaResource(utiles.getCon());
        c.guardarCajaChica(cajaChica);
        utiles.closeConnection();
    }
    @POST
    @Path("/editarCajaChica")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarCajaChica(CajaChica cajaChica) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        CajaChicaResource c = new CajaChicaResource(utiles.getCon());
        c.editarCajaChica(cajaChica);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarCajaChica")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarCajaChica(CajaChica cajaChica) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        CajaChicaResource c = new CajaChicaResource(utiles.getCon());
        c.eliminarCajaChica(cajaChica);
        utiles.closeConnection();
    }
    
}
