/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.busines;

import servicio.model.IngresosVentaBusiness;
import servicio.model.IngresosVentaDetalle;
import servicio.model.SalidasVentaDetalleIngreso;
import servicio.resource.IngresosVentaDetalleResource;
import servicio.resource.IngresosVentaResource;
import servicio.resource.SalidasVentaDetalleIngresoResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 */
public class IngresosVentaBusinesManager {
    public  IngresosVentaBusiness guardarIngresosVentaBusiness(IngresosVentaBusiness s) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        
        IngresosVentaResource ivr = new IngresosVentaResource(utiles.getCon());
        try {
        
        s.getIngresosVenta().setCodIngresoVenta(ivr.codigoIngresosVenta());
        ivr.guardarIngresosVenta(s.getIngresosVenta());
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource(utiles.getCon());        
        for(IngresosVentaDetalle sd:s.getIngresosVentaDetalleList()){
            sd.setIngresosVenta(s.getIngresosVenta());
            ivdr.guardarIngresosVentaDetalle(sd);
        }
        utiles.getCon().commit();
        utiles.getCon().setAutoCommit(true);
        
        } catch (Exception e) {
            utiles.getCon().rollback();
            e.printStackTrace();
        }
        utiles.closeConnection();
        return s;
    }
    
    public  IngresosVentaBusiness editarIngresosVentaBusiness(IngresosVentaBusiness s) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        SalidasVentaDetalleIngresoResource svdir = new SalidasVentaDetalleIngresoResource(utiles.getCon());
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource(utiles.getCon());
        IngresosVentaResource ivr = new IngresosVentaResource(utiles.getCon());
        try {
            
        SalidasVentaDetalleIngreso sadi = new SalidasVentaDetalleIngreso();
        
        sadi.getIngresosVentaDetalle().setIngresosVenta(s.getIngresosVenta());
        svdir.borrarSalidasVentaDetalleIngreso(sadi);//borrar las salidas relacionadas al ingreso venta
        
        
        IngresosVentaDetalle sd1 = new IngresosVentaDetalle();//borrar datos de detalle salida almcen
        sd1.setIngresosVenta(s.getIngresosVenta());
        ivdr.borraIngresosVentaDetalle(sd1);
        
        ivr.editarIngresosVenta(s.getIngresosVenta());
        
        for(IngresosVentaDetalle sd:s.getIngresosVentaDetalleList()){
            sd.setIngresosVenta(s.getIngresosVenta());
            ivdr.guardarIngresosVentaDetalle(sd);
            
        }
        utiles.getCon().commit();
        utiles.getCon().setAutoCommit(true);
        
        } catch (Exception e) {
            e.printStackTrace();
            utiles.getCon().rollback();
        }
        utiles.closeConnection();
        return s;
    }
    public  boolean eliminarIngresosVentaBusiness(IngresosVentaBusiness s) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource(utiles.getCon());
        IngresosVentaResource ivr = new IngresosVentaResource(utiles.getCon());
        try {
        IngresosVentaDetalle sd1 = new IngresosVentaDetalle();//borrar datos de detalle salida almcen
        sd1.setIngresosVenta(s.getIngresosVenta());
        ivdr.borraIngresosVentaDetalle(sd1);
        
        ivr.eliminarIngresosVenta(s.getIngresosVenta());
        
        utiles.getCon().commit();
        utiles.setAutoCommit(true);
        
        } catch (Exception e) {
            e.printStackTrace();
            utiles.getCon().rollback();
        }
        utiles.closeConnection();
        return true;
    }
}
