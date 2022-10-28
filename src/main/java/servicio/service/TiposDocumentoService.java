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
import servicio.model.SelectItem;
import servicio.model.TiposDocumento;
import servicio.resource.TiposDocumentoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del TiposDocumentoResource
 */

@Path("/tiposDocumento")
public class TiposDocumentoService {
    @Path("/tiposDocumento")
    @GET @Produces("application/json")
    public TiposDocumento tiposDocumento() {
        return (new TiposDocumento());
    }
    @Path("/cargarTiposDocumentoItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarTiposDocumentoItem() {
        TiposDocumentoResource tdr = new TiposDocumentoResource();
        return tdr.cargarTiposDocumentoItem();
    }
    @Path("/cargarTiposDocumento")
    @GET @Produces("application/json")
    public List<TiposDocumento> cargarTiposDocumento() {
        TiposDocumentoResource tdr = new TiposDocumentoResource();
        return tdr.cargarTiposDocumento(new TiposDocumento());
    }
    @POST
    @Path("/guardarTiposDocumento")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarTiposDocumento(TiposDocumento tiposDocumento) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposDocumentoResource tdr = new TiposDocumentoResource(utiles.getCon());
        tdr.guardarTiposDocumento(tiposDocumento);
        utiles.closeConnection();
    }
    @Path("/codigoTiposDocumento")
    @GET @Produces("application/json")
    public String codigoTiposDocumento() {
        return String.valueOf("0");
    }
    @POST
    @Path("/editarTiposDocumento")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarTiposDocumento(TiposDocumento tiposDocumento) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposDocumentoResource tdr = new TiposDocumentoResource(utiles.getCon());
        tdr.editarTiposDocumento(tiposDocumento);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarTiposDocumento")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarTiposDocumento(TiposDocumento tiposDocumento) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        TiposDocumentoResource tdr = new TiposDocumentoResource(utiles.getCon());
        tdr.eliminarTiposDocumento(tiposDocumento);
        utiles.closeConnection();
    }
    
}
