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
import servicio.model.PresentacionesProducto;
import servicio.model.SelectItem;
import servicio.resource.PresentacionesProductoResource;



/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/presentacionesProducto")
public class PresentacionService {    
    /*
    @Path("/presentacionesProducto")
    @GET @Produces("application/json")
    public PresentacionesProducto presentacionesProducto() {
        return (new PresentacionesProducto());
    }
    
    
    @GET
    @Path("/cargarPresentacionesProductoItem")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SelectItem> cargarPresentacionesProductoItem() {
        return PresentacionesProductoResource.cargarPresentacionesProductoItem();
    }
    
    @POST
    @Path("/guardarPresentacionesProducto")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarPresentacionesProducto(PresentacionesProducto presentacionesProducto) throws Exception {
        //PresentacionesProductoResource.guardarPresentacionesProducto(presentacionesProducto);
    }
    
    @Path("/codigoPresentacionesProducto")
    @GET    
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String codigoPresentacionesProducto() {
        //return String.valueOf(PresentacionesProductoResource.codigoPresentacionesProducto());
        return "";
    }
    
    @POST
    @Path("/editarPresentacionesProducto")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarPresentacionesProducto(PresentacionesProducto presentacionesProducto) throws Exception{
        //PresentacionesProductoResource.editarPresentacionesProducto(presentacionesProducto);
    }
    
    @POST
    @Path("/eliminarSalidaAlmacen")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarSalidaAlmacen(PresentacionesProducto presentacionesProducto) {
        
    }    
    */
}
