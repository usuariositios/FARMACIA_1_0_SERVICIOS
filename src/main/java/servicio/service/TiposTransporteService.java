/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.util.List;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import servicio.model.SelectItem;


import servicio.resource.TiposTransporteResource;

/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/tiposTransporte")
public class TiposTransporteService {
    @Path("/cargarTiposTransporteItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposTransporteItem() {
        TiposTransporteResource ttr = new TiposTransporteResource();
        return ttr.cargarTiposTransporteItem();
    }
}
