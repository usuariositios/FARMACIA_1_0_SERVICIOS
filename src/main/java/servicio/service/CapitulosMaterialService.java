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
import servicio.model.CapitulosMaterial;
import servicio.resource.CapitulosMaterialResource;

/**
 *
 * @author Computer
 * reflejar los metodos del CapitulosMaterialResource
 */

@Path("/capitulosMaterial")
public class CapitulosMaterialService {
    /*@Path("/capitulosMaterial")
    @GET @Produces("application/json")
    public CapitulosMaterial capitulosMaterial() {
        return (new CapitulosMaterial());
    }
    @Path("/cargarCapitulosMaterialItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarCapitulosMaterialItem() {
        return CapitulosMaterialResource.cargarCapitulosMaterialItem();
    }
    @Path("/cargarCapitulosMaterial")
    @GET @Produces("application/json")
    public List<CapitulosMaterial> cargarCapitulosMaterial() {
        return CapitulosMaterialResource.cargarCapitulosMaterial(new CapitulosMaterial());
    }
    @POST
    @Path("/guardarCapitulosMaterial")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarCapitulosMaterial(CapitulosMaterial capitulosMaterial) {
        CapitulosMaterialResource.guardarCapitulosMaterial(capitulosMaterial);
    }
    @Path("/codigoCapitulosMaterial")
    @GET @Produces("application/json")
    public String codigoCapitulosMaterial() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarCapitulosMaterial")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarCapitulosMaterial(CapitulosMaterial capitulosMaterial) {
        CapitulosMaterialResource.editarCapitulosMaterial(capitulosMaterial);
    }
    @POST
    @Path("/eliminarCapitulosMaterial")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarCapitulosMaterial(CapitulosMaterial capitulosMaterial) {
        CapitulosMaterialResource.eliminarCapitulosMaterial(capitulosMaterial);
    }*/
    
}
