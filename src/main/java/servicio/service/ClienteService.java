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
import servicio.model.Clientes;
import servicio.model.SelectItem;
import servicio.resource.ClienteResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del ClienteResource
 */

@Path("/cliente")
public class ClienteService {    
    @Path("/cliente")
    @GET @Produces("application/json")
    public Clientes cliente() {
        return (new Clientes());
    }
    @Path("/cargarClienteItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarClienteItem() {
        ClienteResource cr = new ClienteResource();
        return cr.cargarClienteItem(new Clientes());
    }
    @POST
    @Path("/cargarCliente")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Clientes> cargarCliente(Clientes cliente) {
        ClienteResource cr = new ClienteResource();
        return cr.cargarCliente(cliente);
    }
    @POST
    @Path("/guardarCliente")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarCliente(Clientes cliente) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        ClienteResource cr = new ClienteResource(utiles.getCon());
        cr.guardarCliente(cliente);
        utiles.closeConnection();
    }
    @Path("/codigoCliente")
    @GET @Produces("application/json")
    public String codigoCliente() {
        ClienteResource cr = new ClienteResource();
        return String.valueOf(cr.codigoCliente());
    }
    @POST
    @Path("/editarCliente")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarCliente(Clientes cliente) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        ClienteResource cr = new ClienteResource(utiles.getCon());
        cr.editarCliente(cliente);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarCliente")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarCliente(Clientes cliente) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        ClienteResource cr = new ClienteResource(utiles.getCon());
        cr.eliminarCliente(cliente);
        utiles.closeConnection();
    }
    @POST
    @Path("/buscarCliente")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Clientes buscarCliente(Clientes cliente) {
        ClienteResource cr = new ClienteResource();
        return cr.buscarCliente(cliente);
    }
    
}
