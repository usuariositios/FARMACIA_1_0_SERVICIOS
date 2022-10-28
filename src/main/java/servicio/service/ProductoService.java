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
import servicio.model.Productos;
import servicio.model.SelectItem;
import servicio.resource.ProductoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del ProductosResource
 */

@Path("/productos")
public class ProductoService {    
    @Path("/productos")
    @GET @Produces("application/json")
    public Productos productos() {
        return (new Productos());
    }
    @Path("/cargarProductosItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarProductosItem() {
        ProductoResource pr = new ProductoResource();
        return pr.cargarProductoItem();
    }
    @POST
    @Path("/cargarProductos")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Productos> cargarProductos(Productos productos) {
        ProductoResource pr = new ProductoResource();
        return pr.cargarProductos(productos);
    }
    @POST
    @Path("/guardarProductos")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarProductos(Productos productos) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        ProductoResource pr = new ProductoResource(utiles.getCon());
        pr.guardarProducto(productos);
        utiles.closeConnection();
    }
    @POST
    @Path("/editarProductos")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarProductos(Productos productos) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        ProductoResource pr = new ProductoResource(utiles.getCon());
        pr.editarProducto(productos);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarProductos")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarProductos(Productos productos) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        ProductoResource pr = new ProductoResource(utiles.getCon());
        pr.eliminarProducto(productos);
        utiles.closeConnection();
    }
    
    @POST
    @Path("/buscarProductos")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Productos buscarProductos(Productos productos) {
        ProductoResource pr = new ProductoResource();
        return pr.buscarProductos(productos);
    }
    
}
