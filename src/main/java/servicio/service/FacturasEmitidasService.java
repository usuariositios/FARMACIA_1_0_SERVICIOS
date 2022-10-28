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
import servicio.busines.SalidasVentaBusinesManager;
import servicio.model.FacturasEmitidas;
import servicio.model.SalidasVenta;
import servicio.model.SalidasVentaBusiness;
import servicio.resource.FacturasEmitidasResource;
import servicio.resource.SalidasVentaResource;
import servicio.util.Utiles;



/**
 *
 * @author Computer
 * reflejar los metodos del PersonalResource
 */

@Path("/facturasEmitidas")
public class FacturasEmitidasService {    
    /*/facturasEmitidas/facturasEmitidas*/
    @Path("/facturasEmitidas")
    @GET @Produces("application/json")
    public FacturasEmitidas facturasEmitidas() {
        return (new FacturasEmitidas());
    }
    /*/facturasEmitidas/cargarFacturasEmitidas*/
    @POST
    @Path("/cargarFacturasEmitidas")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<FacturasEmitidas> cargarFacturasEmitidas(FacturasEmitidas facturasEmitidas) {
        FacturasEmitidasResource fer = new FacturasEmitidasResource();
        return fer.cargarFacturasEmitidas(facturasEmitidas);
    }
    /*/facturasEmitidas/guardarFacturasEmitidas*/
    @POST
    @Path("/guardarFacturasEmitidas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarFacturasEmitidas(FacturasEmitidas facturasEmitidas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        FacturasEmitidasResource fer = new FacturasEmitidasResource(utiles.getCon());
        fer.guardarFacturasEmitidas(facturasEmitidas);
        utiles.closeConnection();
    }
    /*/facturasEmitidas/codigoFacturasEmitidas*/
    @Path("/codigoFacturasEmitidas")
    @GET    
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String codigoFacturasEmitidas() {
        FacturasEmitidasResource fer = new FacturasEmitidasResource();
        return String.valueOf(fer.codigoFacturasEmitidas());
    }
    /*/facturasEmitidas/editarFacturasEmitidas*/
    @POST
    @Path("/editarFacturasEmitidas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarFacturasEmitidas(FacturasEmitidas facturasEmitidas) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        FacturasEmitidasResource fer = new FacturasEmitidasResource(utiles.getCon());
        fer.editarFacturasEmitidas(facturasEmitidas);
        utiles.closeConnection();
    }
    /*/facturasEmitidas/eliminarFacturasEmitidas*/
    @POST
    @Path("/eliminarFacturasEmitidas")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public int eliminarFacturasEmitidas(FacturasEmitidas f) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        FacturasEmitidasResource fer = new FacturasEmitidasResource(utiles.getCon());
        int resp = fer.eliminarFacturasEmitidas(f);        
        utiles.closeConnection();
        return resp;
    }
    /*/facturasEmitidas/nroFacturasEmitidas*/
    @POST
    @Path("/generarFactura")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public FacturasEmitidas generarFactura(SalidasVenta sa) throws Exception{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        FacturasEmitidas resp = new FacturasEmitidas();
        try{
        FacturasEmitidasResource fer = new FacturasEmitidasResource(utiles.getCon());//dentro la funcion hay un proceso donde se llama la funcion de obtener conexion a base de datos
        resp = fer.generarFactura(sa);
        utiles.getCon().commit();
        utiles.getCon().setAutoCommit(true);        
        }catch(Exception e){
            e.printStackTrace();
            utiles.rollback();
        }
        utiles.closeConnection();
        return resp;
    }
    
    @POST
    @Path("/anularFactura")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void anularFactura(FacturasEmitidas f) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        try{
            FacturasEmitidasResource fr = new FacturasEmitidasResource(utiles.getCon());
            SalidasVentaBusinesManager svbm = new SalidasVentaBusinesManager(utiles.getCon());
            SalidasVentaResource svr = new SalidasVentaResource(utiles.getCon());
            SalidasVentaBusiness svb = new SalidasVentaBusiness();
            SalidasVenta sv = new SalidasVenta();
            f.getSalidasVenta().setFechaSalidaVentaInicio("");
            f.getSalidasVenta().setFechaSalidaVentaFinal("");
            
            sv = svr.buscarSalidasVenta(f.getSalidasVenta());
            
            svb.setSalidasVenta(sv);
            
            
            
            svbm.anularSalidasVentaBusiness(svb);
            //anular factura
            System.out.println("buscar salida venta........>");
            
            f.setSalidasVenta(sv);
            f.getEstadosRegistro().setCodEstado(2);//anulacion de factura
            fr.editarFacturasEmitidas(f);
            //anulacion de amortizaciones
            
            
            utiles.getCon().commit();
            utiles.setAutoCommit(true);
        }catch(Exception ex){ex.printStackTrace();        
            utiles.getCon().rollback();
            throw new Exception(ex.getMessage());
        }
        utiles.closeConnection();        
        
    }
    /*/facturasEmitidas/nroFacturaEmitida*/
    @POST
    @Path("/nroFacturaEmitida")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public int nroSalidaVenta(SalidasVenta sv) throws Exception {        
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        int nroFacturaEmitida = 0;
        try{
            FacturasEmitidasResource fr = new FacturasEmitidasResource(utiles.getCon());            
            nroFacturaEmitida = fr.nroFactura(sv);
            utiles.getCon().commit();
            utiles.setAutoCommit(true);
        }catch(Exception ex){ex.printStackTrace();        
            utiles.getCon().rollback();
            throw new Exception(ex.getMessage());
        }
        utiles.closeConnection();    
        return nroFacturaEmitida;
    }
    @POST
    @Path("/guardarFacturaEmitidaBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SalidasVentaBusiness guardarFacturaEmitidaBusiness(SalidasVentaBusiness s) throws Exception {        
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        SalidasVentaBusiness svb = new SalidasVentaBusiness();
        try{
            FacturasEmitidasResource fr = new FacturasEmitidasResource(utiles.getCon());            
            svb = fr.guardarFacturaEmitidaBusiness(s);
            utiles.getCon().commit();
            utiles.setAutoCommit(true);            
        }catch(Exception ex){ex.printStackTrace();        
            utiles.getCon().rollback();
            throw new Exception(ex.getMessage());
        }
        utiles.closeConnection();    
        return svb;
    }
    @POST
    @Path("/editarFacturaEmitidaBusiness")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public SalidasVentaBusiness editarFacturaEmitidaBusiness(SalidasVentaBusiness s) throws Exception {        
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        SalidasVentaBusiness svb = new SalidasVentaBusiness();
        try{
            FacturasEmitidasResource fr = new FacturasEmitidasResource(utiles.getCon());            
            svb = fr.editarFacturaEmitidaBusiness(s);
            utiles.getCon().commit();
            utiles.setAutoCommit(true);
        }catch(Exception ex){ex.printStackTrace();        
            utiles.getCon().rollback();
            throw new Exception(ex.getMessage());
        }
        utiles.closeConnection();    
        return svb;
    }
    
    
    
}
