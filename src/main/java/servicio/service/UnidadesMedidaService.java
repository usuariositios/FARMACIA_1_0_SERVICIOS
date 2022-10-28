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
import servicio.model.UnidadesMedida;
import servicio.resource.TiposSalidaAlmacenResource;
import servicio.resource.UnidadesMedidaResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del UnidadesMedidaResource
 */

@Path("/unidadesMedida")
public class UnidadesMedidaService {    
    @Path("/unidadesMedida")
    @GET @Produces("application/json")
    public UnidadesMedida unidadesMedida() {
        return (new UnidadesMedida());
    }
    @Path("/cargarUnidadesMedidaItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarUnidadesMedidaItem() {
        UnidadesMedidaResource umr = new UnidadesMedidaResource();
        return umr.cargarUnidadesMedidaItem();
    }
    @Path("/cargarUnidadesMedida")
    @GET @Produces("application/json")
    public List<UnidadesMedida> cargarUnidadesMedida() {
        UnidadesMedidaResource umr = new UnidadesMedidaResource();
        return umr.cargarUnidadesMedida(new UnidadesMedida());
    }
    @POST
    @Path("/guardarUnidadesMedida")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarUnidadesMedida(UnidadesMedida unidadesMedida) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        UnidadesMedidaResource umr = new UnidadesMedidaResource(utiles.getCon());
        umr.guardarUnidadesMedida(unidadesMedida);
        utiles.closeConnection();
    }
    @Path("/codigoUnidadesMedida")
    @GET @Produces("application/json")
    public String codigoUnidadesMedida() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarUnidadesMedida")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarUnidadesMedida(UnidadesMedida unidadesMedida) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        UnidadesMedidaResource umr = new UnidadesMedidaResource(utiles.getCon());
        umr.editarUnidadesMedida(unidadesMedida);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarUnidadesMedida")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarUnidadesMedida(UnidadesMedida unidadesMedida) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        UnidadesMedidaResource umr = new UnidadesMedidaResource(utiles.getCon());
        umr.eliminarUnidadesMedida(unidadesMedida);
        utiles.closeConnection();
    }
    
}
