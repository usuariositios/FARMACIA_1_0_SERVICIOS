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
import servicio.model.Ciudad;

import servicio.model.Pais;
import servicio.model.SelectItem;
import servicio.resource.CiudadResource;



/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/ciudad")
public class CiudadService {
    
    @Path("/ciudad")
    @GET @Produces({MediaType.APPLICATION_JSON})
    public Ciudad ciudad() {
        return (new Ciudad());
    }
          
    @Path("/cargarCiudadItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarCiudadItem() {
        CiudadResource cr = new CiudadResource();
        return cr.cargarCiudadItem(new Pais());
    }
    @Path("/cargarCiudad")
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SelectItem> cargarCiudad(Ciudad c) {
        CiudadResource cr = new CiudadResource();
        return cr.cargarCiudadItem(c.getPais());
    }
}
