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

import servicio.model.SelectItem;
import servicio.resource.CargoResource;


/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/cargo")
public class CargoService {
    @Path("/cargarCargoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarCargoItem() {
        CargoResource cr = new CargoResource();
        return cr.cargarCargoItem();
    }
}
