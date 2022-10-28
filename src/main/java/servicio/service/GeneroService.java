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
import servicio.model.Personal;
import servicio.model.SelectItem;
import servicio.resource.GeneroResource;


/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/genero")
public class GeneroService {
    
    @Path("/cargarGeneroItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarGeneroItem() {
        GeneroResource gr = new GeneroResource();
        return gr.cargarGeneroItem();
    }
}
