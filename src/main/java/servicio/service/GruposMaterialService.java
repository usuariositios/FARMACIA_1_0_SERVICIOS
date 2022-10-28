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
import servicio.model.GruposMaterial;
import servicio.resource.GruposMaterialResource;

/**
 *
 * @author Computer
 * reflejar los metodos del GruposMaterialResource
 */

@Path("/gruposMaterial")
public class GruposMaterialService {    
    /*@Path("/gruposMaterial")
    @GET @Produces("application/json")
    public GruposMaterial gruposMaterial() {
        return (new GruposMaterial());
    }
    @Path("/cargarGruposMaterialItem")
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SelectItem> cargarGruposMaterialItem(GruposMaterial gruposMaterial) {
        return GruposMaterialResource.cargarGruposMaterialItem(gruposMaterial);//new GruposMaterial()
    }
    @Path("/cargarGruposMaterial")
    @GET @Produces("application/json")
    public List<GruposMaterial> cargarGruposMaterial() {
        return GruposMaterialResource.cargarGruposMaterial(new GruposMaterial());
    }
    @POST
    @Path("/guardarGruposMaterial")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarGruposMaterial(GruposMaterial gruposMaterial) {
        GruposMaterialResource.guardarGruposMaterial(gruposMaterial);
    }
    @Path("/codigoGruposMaterial")
    @GET @Produces("application/json")
    public String codigoGruposMaterial() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarGruposMaterial")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarGruposMaterial(GruposMaterial gruposMaterial) {
        GruposMaterialResource.editarGruposMaterial(gruposMaterial);
    }
    @POST
    @Path("/eliminarGruposMaterial")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarGruposMaterial(GruposMaterial gruposMaterial) {
        GruposMaterialResource.eliminarGruposMaterial(gruposMaterial);
    }*/
    
}
