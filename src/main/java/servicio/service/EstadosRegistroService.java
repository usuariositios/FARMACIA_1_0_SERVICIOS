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
import servicio.model.EstadosRegistro;
import servicio.resource.CargoResource;
import servicio.resource.EstadoRegistroResource;

/**
 *
 * @author Computer
 * reflejar los metodos del EstadosRegistroResource
 */

@Path("/estadosRegistro")
public class EstadosRegistroService {
    @Path("/estadosRegistro")
    @GET @Produces("application/json")
    public EstadosRegistro estadosRegistro() {
        return (new EstadosRegistro());
    }
    @Path("/cargarEstadosRegistroItem")
    @GET @Produces("application/json")
    public List<servicio.model.SelectItem> cargarEstadosRegistroItem() {
        EstadoRegistroResource err = new EstadoRegistroResource();
        return err.cargarEstadosRegistroItem();
    }
    @Path("/cargarEstadosRegistro")
    @GET @Produces("application/json")
    public List<EstadosRegistro> cargarEstadosRegistro() {
        EstadoRegistroResource err = new EstadoRegistroResource();
        return err.cargarEstadosRegistro();
    }
    @POST
    @Path("/guardarEstadosRegistro")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarEstadosRegistro(EstadosRegistro estadosRegistro) {
        //EstadosRegistroResource.guardarEstadosRegistro(estadosRegistro);
    }    
    @POST
    @Path("/editarEstadosRegistro")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarEstadosRegistro(EstadosRegistro estadosRegistro) {
        //EstadosRegistroResource.editarEstadosRegistro(estadosRegistro);
    }
    @POST
    @Path("/eliminarEstadosRegistro")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarEstadosRegistro(EstadosRegistro estadosRegistro) {
        //EstadosRegistroResource.eliminarEstadosRegistro(estadosRegistro);
    }    
    
}
