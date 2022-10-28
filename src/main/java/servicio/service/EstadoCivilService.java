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
import servicio.resource.EstadoCivilResource;


/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/estadoCivil")
public class EstadoCivilService {
    
    @Path("/cargarEstadoCivilItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarEstadoCivilItem() {
        EstadoCivilResource ecr = new EstadoCivilResource();
        return ecr.cargarEstadoCivilItem();
    }
    
}
