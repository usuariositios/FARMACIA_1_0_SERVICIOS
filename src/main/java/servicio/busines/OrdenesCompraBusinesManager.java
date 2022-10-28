/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.busines;

import java.util.List;
import servicio.model.IngresosAlmacenDetalleEstado;
import servicio.model.OrdenesCompraBusines;
import servicio.model.IngresosVentaDetalle;
import servicio.model.OrdenesCompraDetalle;
import servicio.resource.IngresosVentaDetalleResource;
import servicio.resource.IngresosVentaResource;
import servicio.resource.OrdenCompraDetalleResource;
import servicio.resource.OrdenesCompraResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 */
public class OrdenesCompraBusinesManager {
    public boolean guardarOrdenesCompraBusines(OrdenesCompraBusines s) {
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            OrdenesCompraResource ocr = new OrdenesCompraResource(utiles.getCon());
            OrdenCompraDetalleResource ocdr = new OrdenCompraDetalleResource(utiles.getCon());
            s.getOrdenesCompra().setCodOrdenCompra(ocr.codigoOrdenCompra());
            ocr.guardarOrdenesCompra(s.getOrdenesCompra());


            for(OrdenesCompraDetalle ocd:s.getOrdenesCompraDetalleList()){
                ocd.setOrdenesCompra(s.getOrdenesCompra());
                ocdr.guardarOrdenesCompraDetalle(ocd);
            }
            utiles.closeConnection();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public  boolean editarOrdenesCompraBusines(OrdenesCompraBusines ocb) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        try {
        OrdenesCompraDetalle ocd = new OrdenesCompraDetalle();
        ocd.setOrdenesCompra(ocb.getOrdenesCompra());
        OrdenCompraDetalleResource ocdr = new OrdenCompraDetalleResource(utiles.getCon());
        OrdenesCompraResource ocr = new OrdenesCompraResource(utiles.getCon());
        ocdr.borraOrdenesCompraDetalle(ocd);
        
        ocr.editarOrdenesCompra(ocb.getOrdenesCompra());
        
        for(OrdenesCompraDetalle od:ocb.getOrdenesCompraDetalleList()){
            od.setOrdenesCompra(ocb.getOrdenesCompra());
            ocdr.guardarOrdenesCompraDetalle(od);            
        }
        
        utiles.getCon().commit();
        utiles.getCon().setAutoCommit(true);
        
        
        } catch (Exception e) {
            e.printStackTrace();
            utiles.rollback();
        
            return false;
        }
        utiles.closeConnection();
        
        return true;
    }
    public  boolean eliminarOrdenesCompraBusines(OrdenesCompraBusines ocb) {
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            OrdenCompraDetalleResource ocdr = new OrdenCompraDetalleResource(utiles.getCon());
            OrdenesCompraResource ocr = new OrdenesCompraResource(utiles.getCon());
            OrdenesCompraDetalle ocd = new OrdenesCompraDetalle();
            ocd.setOrdenesCompra(ocb.getOrdenesCompra());
            ocdr.borraOrdenesCompraDetalle(ocd);
            ocr.eliminarOrdenesCompra(ocb.getOrdenesCompra());
            
            utiles.closeConnection();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
