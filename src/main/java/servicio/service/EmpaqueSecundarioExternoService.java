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
import servicio.model.EmpaqueSecundarioExterno;
import servicio.resource.EmpaqueSecundarioExternoResource;

/**
 *
 * @author Computer
 * reflejar los metodos del EmpaqueSecundarioExternoResource
 */

@Path("/empaqueSecundarioExterno")
public class EmpaqueSecundarioExternoService {    
    /*@Path("/empaqueSecundarioExterno")
    @GET @Produces("application/json")
    public EmpaqueSecundarioExterno empaqueSecundarioExterno() {
        return (new EmpaqueSecundarioExterno());
    }
    @Path("/cargarEmpaqueSecundarioExternoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarEmpaqueSecundarioExternoItem() {
        return EmpaqueSecundarioExternoResource.cargarEmpaqueSecundarioExternoItem();
    }
    @Path("/cargarEmpaqueSecundarioExterno")
    @GET @Produces("application/json")
    public List<EmpaqueSecundarioExterno> cargarEmpaqueSecundarioExterno() {
        return EmpaqueSecundarioExternoResource.cargarEmpaqueSecundarioExterno(new EmpaqueSecundarioExterno());
    }
    @POST
    @Path("/guardarEmpaqueSecundarioExterno")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarEmpaqueSecundarioExterno(EmpaqueSecundarioExterno empaqueSecundarioExterno) {
        EmpaqueSecundarioExternoResource.guardarEmpaqueSecundarioExterno(empaqueSecundarioExterno);
    }
    @Path("/codigoEmpaqueSecundarioExterno")
    @GET @Produces("application/json")
    public String codigoEmpaqueSecundarioExterno() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarEmpaqueSecundarioExterno")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarEmpaqueSecundarioExterno(EmpaqueSecundarioExterno empaqueSecundarioExterno) {
        EmpaqueSecundarioExternoResource.editarEmpaqueSecundarioExterno(empaqueSecundarioExterno);
    }
    @POST
    @Path("/eliminarEmpaqueSecundarioExterno")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarEmpaqueSecundarioExterno(EmpaqueSecundarioExterno empaqueSecundarioExterno) {
        EmpaqueSecundarioExternoResource.eliminarEmpaqueSecundarioExterno(empaqueSecundarioExterno);
    }*/
    
}
