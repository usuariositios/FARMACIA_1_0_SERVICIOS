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
import servicio.model.Materiales;
import servicio.model.SelectItem;
import servicio.resource.MaterialesResource;

/**
 *
 * @author Computer
 * reflejar los metodos del MaterialesResource
 */

@Path("/materiales")
public class MaterialesService {
    
    /*@Path("/materiales")
    @GET @Produces("application/json")
    public Materiales materiales() {
        return (new Materiales());
    }
    @Path("/cargarMaterialesItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarMaterialesItem() {
        return MaterialesResource.cargarMaterialesItem(new Materiales());
    }
    @POST
    @Path("/cargarMateriales")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Materiales> cargarMateriales(Materiales m) {
        //Materiales m = new Materiales();
        //m.getGruposMaterial().setCodGrupoMaterial(2);
        return MaterialesResource.cargarMateriales(m);
    }
    @POST
    @Path("/guardarMateriales")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarMateriales(Materiales materiales) {
        MaterialesResource.guardarMateriales(materiales);
    }
    //@Path("/codigoMateriales")
    //@GET @Produces("application/json")
    //public String codigoMateriales() {
    //    return String.valueOf(MaterialesResource.codigoMateriales());
    //}
    @POST
    @Path("/editarMaterial")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarMateriales(Materiales materiales) {
        MaterialesResource.editarMaterial(materiales);
    }
    @POST
    @Path("/eliminarMaterial")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarMateriales(Materiales materiales) {
        MaterialesResource.eliminarMaterial(materiales);
    }*/
    
}
