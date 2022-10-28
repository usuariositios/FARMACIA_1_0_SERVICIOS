/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    
    @Path("/cargarCiudadItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarCiudadItem() {
        CiudadResource cr = new CiudadResource();
        return cr.cargarCiudadItem(new Pais());
    }
}
