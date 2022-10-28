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
import servicio.model.IngresosVenta;
import servicio.model.IngresosVentaDetalle;

import servicio.resource.IngresosVentaDetalleResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 reflejar los metodos del IngresosVentaDetalleResource
 */

@Path("/ingresosVentaDetalle")
public class IngresoVentaDetalleService {
    /*/ingresosVentaDetalle/ingresosVentaDetalle*/
    @Path("/ingresosVentaDetalle")
    @GET @Produces("application/json")
    public IngresosVentaDetalle ingresosVentaDetalle() {
        return (new IngresosVentaDetalle());
    }
    /*/ingresosVentaDetalle/cargarIngresosVentaDetalle*/
    @POST
    @Path("/cargarIngresosVentaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<IngresosVentaDetalle> cargarIngresosVentaDetalle(IngresosVenta ingresoVenta) {
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource();
        return ivdr.cargarIngresosVentaDetalle(ingresoVenta);
    }
    /*/ingresosVentaDetalle/guardarIngresosVentaDetalle*/
    @POST
    @Path("/guardarIngresosVentaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarIngresosVentaDetalle(IngresosVentaDetalle ingresosVentaDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource(utiles.getCon());
        ivdr.guardarIngresosVentaDetalle(ingresosVentaDetalle);
        utiles.closeConnection();
    }
    /*/ingresosVentaDetalle/codigoIngresosVentaDetalle*/
    @Path("/codigoIngresosVentaDetalle")
    @GET @Produces("application/json")
    public String codigoIngresosVentaDetalle() {
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource();
        return String.valueOf(ivdr.codigoIngresosVentaDetalle(new IngresosVenta()));
    }
    /*/ingresosVentaDetalle/editarIngresosVentaDetalle*/
    @POST
    @Path("/editarIngresosVentaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarIngresosVentaDetalle(IngresosVentaDetalle ingresosVentaDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource(utiles.getCon());
        ivdr.editarIngresosVentaDetalle(ingresosVentaDetalle);
        utiles.closeConnection();
    }
    /*/ingresosVentaDetalle/borraIngresosVentaDetalle*/
    @POST
    @Path("/borraIngresosVentaDetalle")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void borraIngresosVentaDetalle(IngresosVentaDetalle ingresosVentaDetalle) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource(utiles.getCon());
        ivdr.borraIngresosVentaDetalle(ingresosVentaDetalle);
        utiles.closeConnection();
    }
    
    @POST
    @Path("/cantProdVencidos")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String cantProdVencidos(IngresosVentaDetalle ingresosVentaDetalle) {
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource();
        return String.valueOf(ivdr.cantProdVencidos(ingresosVentaDetalle));
    }
    
    
}
