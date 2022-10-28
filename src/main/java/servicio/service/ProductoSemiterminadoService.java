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
import servicio.model.ProductoSemiterminado;
import servicio.model.SelectItem;
import servicio.resource.ProductoSemiterminadoResource;



/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/productoSemiterminado")
public class ProductoSemiterminadoService {    
    /*
    @Path("/productoSemiterminado")
    @GET @Produces("application/json")
    public ProductoSemiterminado productoSemiterminado() {
        return (new ProductoSemiterminado());
    }
    
    @POST
    @Path("/cargarProductoSemiterminado")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<ProductoSemiterminado> cargarProductoSemiterminado(ProductoSemiterminado productoSemiterminado) {
        return ProductoSemiterminadoResource.cargarProductoSemiterminado(productoSemiterminado);
    }
    
    @GET
    @Path("/cargarProductoSemiterminadoItem")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<SelectItem> cargarProductoSemiterminadoItem() {
        return ProductoSemiterminadoResource.cargarProductoSemiterminadoItem();
    }
    
    @POST
    @Path("/guardarProductoSemiterminado")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarProductoSemiterminado(ProductoSemiterminado productoSemiterminado) throws Exception {
        ProductoSemiterminadoResource.guardarProductoSemiterminado(productoSemiterminado);
    }
    
    @Path("/codigoProductoSemiterminado")
    @GET    
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String codigoProductoSemiterminado() {
        return String.valueOf(ProductoSemiterminadoResource.codigoProductoSemiterminado());
    }
    
    @POST
    @Path("/editarProductoSemiterminado")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarProductoSemiterminado(ProductoSemiterminado productoSemiterminado) throws Exception{
        ProductoSemiterminadoResource.editarProductoSemiterminado(productoSemiterminado);
    }
    
    @POST
    @Path("/eliminarSalidaAlmacen")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarSalidaAlmacen(ProductoSemiterminado productoSemiterminado) {
        
    }    
    */
}
