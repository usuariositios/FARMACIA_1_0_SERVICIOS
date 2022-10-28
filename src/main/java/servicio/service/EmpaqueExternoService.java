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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import servicio.model.SelectItem;
import servicio.model.EmpaqueExterno;
import servicio.resource.EmpaqueExternoResource;

/**
 *
 * @author Computer
 * reflejar los metodos del EmpaqueExternoResource
 */

@Path("/empaqueExterno")
public class EmpaqueExternoService {
    /*@Path("/empaqueExterno")
    @GET @Produces("application/json")
    public EmpaqueExterno empaqueExterno() {
        return (new EmpaqueExterno());
    }
    @Path("/cargarEmpaqueExternoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarEmpaqueExternoItem() {
        return EmpaqueExternoResource.cargarEmpaqueExternoItem();
    }
    @Path("/cargarEmpaqueExterno")
    @GET @Produces("application/json")
    public List<EmpaqueExterno> cargarEmpaqueExterno() {
        return EmpaqueExternoResource.cargarEmpaqueExterno(new EmpaqueExterno());
    }
    @POST
    @Path("/guardarEmpaqueExterno")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarEmpaqueExterno(EmpaqueExterno empaqueExterno) {
        EmpaqueExternoResource.guardarEmpaqueExterno(empaqueExterno);
    }
    @Path("/codigoEmpaqueExterno")
    @GET @Produces("application/json")
    public String codigoEmpaqueExterno() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarEmpaqueExterno")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarEmpaqueExterno(EmpaqueExterno empaqueExterno) {
        EmpaqueExternoResource.editarEmpaqueExterno(empaqueExterno);
    }
    @POST
    @Path("/eliminarEmpaqueExterno")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarEmpaqueExterno(EmpaqueExterno empaqueExterno) {
        EmpaqueExternoResource.eliminarEmpaqueExterno(empaqueExterno);
    }*/
    
}
