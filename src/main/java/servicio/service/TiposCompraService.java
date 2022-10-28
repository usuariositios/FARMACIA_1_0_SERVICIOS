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


import servicio.resource.TiposCompraResource;

/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/tiposCompra")
public class TiposCompraService {
    @Path("/cargarTiposCompraItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposCompraItem() {
        TiposCompraResource tcr = new TiposCompraResource();
        return tcr.cargarTiposCompraItem();
    }
}
