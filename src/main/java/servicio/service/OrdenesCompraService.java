/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.util.ArrayList;
import java.util.List;
 

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import servicio.busines.OrdenesCompraBusinesManager;
import servicio.model.OrdenesCompra;
import servicio.model.OrdenesCompraBusines;
import servicio.model.SelectItem;
import servicio.resource.OrdenesCompraResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del OrdenesCompraResource
 */

@Path("/ordenesCompra")
public class OrdenesCompraService {    
    @Path("/ordenesCompra")
    @GET 
    @Produces("application/json")
    public OrdenesCompra ordenesCompra() {
        return (new OrdenesCompra());
    }
    @Path("/cargarOrdenesCompraItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarOrdenesCompraItem() throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        OrdenesCompraResource ocr = new OrdenesCompraResource(utiles.getCon());
        List<SelectItem> ocList = new ArrayList<SelectItem>();
        ocList= ocr.cargarOrdenesCompraItem();
        utiles.closeConnection();
        return ocList;
        
    }
    @POST
    @Path("/cargarOrdenesCompra")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<OrdenesCompra> cargarOrdenesCompra(OrdenesCompra ordenesCompra) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        OrdenesCompraResource ocr = new OrdenesCompraResource(utiles.getCon());
        List<OrdenesCompra> ocList = new ArrayList<OrdenesCompra>();
        ocList = ocr.cargarOrdenesCompra(ordenesCompra);
        utiles.closeConnection();
        return ocList;
    }
    @POST
    @Path("/guardarOrdenesCompra")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarOrdenesCompra(OrdenesCompra ordenesCompra) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        OrdenesCompraResource ocr = new OrdenesCompraResource(utiles.getCon());
        ocr.guardarOrdenesCompra(ordenesCompra);
        utiles.closeConnection();
    }
    @POST
    @Path("/editarOrdenesCompra")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarOrdenesCompra(OrdenesCompra ordenesCompra) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        OrdenesCompraResource ocr = new OrdenesCompraResource(utiles.getCon());
        ocr.editarOrdenesCompra(ordenesCompra);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarOrdenesCompra")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarOrdenesCompra(OrdenesCompra ordenesCompra) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        OrdenesCompraResource ocr = new OrdenesCompraResource(utiles.getCon());
        ocr.eliminarOrdenesCompra(ordenesCompra);
        utiles.closeConnection();
    }
    @POST
    @Path("/nroOrdenCompra")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public int nroOrdenCompra(OrdenesCompra ordenesCompra) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        OrdenesCompraResource ocr = new OrdenesCompraResource(utiles.getCon());        
        int nro = ocr.nroOrdenCompra(ordenesCompra);
        utiles.closeConnection();
        return nro;        
    }
    
    
    @POST
    @Path("/guardarOrdenesCompraBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarOrdenesCompraBusiness(OrdenesCompraBusines o) throws Exception {        
        OrdenesCompraBusinesManager ocbmgr = new OrdenesCompraBusinesManager();
        ocbmgr.guardarOrdenesCompraBusines(o);
    }
    
    @POST
    @Path("/editarOrdenesCompraBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarOrdenesCompraBusiness(OrdenesCompraBusines o) throws Exception {
        OrdenesCompraBusinesManager ocbmgr = new OrdenesCompraBusinesManager();
        ocbmgr.editarOrdenesCompraBusines(o);
    }
    @POST
    @Path("/eliminarOrdenesCompraBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarOrdenesCompraBusiness(OrdenesCompraBusines o) throws Exception {
        OrdenesCompraBusinesManager ocbmgr = new OrdenesCompraBusinesManager();        
        ocbmgr.eliminarOrdenesCompraBusines(o);
    }
    
}
