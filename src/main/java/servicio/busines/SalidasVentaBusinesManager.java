/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.busines;

import java.sql.Connection;
import java.util.List;

import servicio.model.SalidasVentaBusiness;
import servicio.model.SalidasVentaDetalle;
import servicio.model.SalidasVentaDetalleIngreso;
import servicio.resource.FacturasEmitidasResource;
import servicio.resource.IngresosVentaDetalleResource;
import servicio.resource.SalidasVentaDetalleIngresoResource;
import servicio.resource.SalidasVentaDetalleResource;
import servicio.resource.SalidasVentaResource;

/**
 *
 * @author Computer
 */
public class SalidasVentaBusinesManager {
    Connection con;
    public SalidasVentaBusinesManager(){
    }
    public SalidasVentaBusinesManager(Connection con){
        this.con = con;
    }
    public  SalidasVentaBusiness guardarSalidasVentaBusiness(SalidasVentaBusiness s) throws Exception {
        
        
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource(this.con);
        SalidasVentaResource svr = new SalidasVentaResource(this.con);
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource(this.con);
        //FacturasEmitidasResource femr = new FacturasEmitidasResource(this.con);
        SalidasVentaDetalleIngresoResource ivdir = new SalidasVentaDetalleIngresoResource(this.con);        
        SalidasVentaBusiness svb = new SalidasVentaBusiness();
        
        try {
            s.getSalidasVenta().setCodSalidaVenta(svr.codigoSalidasVenta());
            s.getSalidasVenta().setNroSalidaVenta(svr.nroSalidaVenta(s.getSalidasVenta()));
            svr.guardarSalidasVenta(s.getSalidasVenta());
                
        for(SalidasVentaDetalle sd:s.getSalidasVentaDetalleList()){
            sd.setSalidasVenta(s.getSalidasVenta());
            svdr.guardarSalidasVentaDetalle(sd);
            //sd.getIngresosAlmacenDetalle().setCantRestante(sd.getIngresosAlmacenDetalle().getCantRestante()-sd.getCantSalida());
            //IngresosAlmacenDetalleResource.editarIngresosVentaDetalle(sd.getIngresosAlmacenDetalle());
            for(SalidasVentaDetalleIngreso sadi: sd.getSalidasVentaDetalleIngresosList()){
                sadi.setSalidasVentaDetalle(sd);
                if(sadi.getCantSacar()>0){
                    sadi.getIngresosVentaDetalle().setCantRestante(sadi.getIngresosVentaDetalle().getCantRestante()-sadi.getCantSacar());
                    ivdr.editarIngresosVentaDetalle(sadi.getIngresosVentaDetalle());//actualizar ingreso detalle (cant restante)
                    ivdir.guardarSalidasVentaDetalleIngreso(sadi);
                }
            }
        }
        //femr.generarFactura(s.getSalidasVenta());        
        svb = s;
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        
        }
        
        return svb;
    }
    
    public  boolean editarSalidasVentaBusiness(SalidasVentaBusiness s) throws Exception {
        
        SalidasVentaDetalleIngresoResource svdir = new SalidasVentaDetalleIngresoResource(this.con);
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource(this.con);
        SalidasVentaResource svr = new SalidasVentaResource(this.con);
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource(this.con);
        FacturasEmitidasResource femr = new FacturasEmitidasResource(this.con);
        
        try {
        //devolver cantidades para los registros eliminados
        for(SalidasVentaDetalle sd:s.getSalidasVentaDetalleList()){
            if(sd.getEliminar()==1){
            for(SalidasVentaDetalleIngreso sadi:sd.getSalidasVentaDetalleIngresosList()){
                ivdr.editarIngresosVentaDetalle(sadi.getIngresosVentaDetalle());//el detalle salida-ingreso esta relacionado a detalle de ingreso                                
            }
            }
        }
            
        SalidasVentaDetalleIngreso sdi1 = new SalidasVentaDetalleIngreso();
        sdi1.getSalidasVentaDetalle().setSalidasVenta(s.getSalidasVenta());
        svdir.borrarSalidasVentaDetalleIngreso(sdi1);        
        
        SalidasVentaDetalle sd1 = new SalidasVentaDetalle();//borrar datos de detalle salida almcen
        sd1.setSalidasVenta(s.getSalidasVenta());
        svdr.borrarSalidasVentaDetalle(sd1);
        
        
        femr.editarFacturasEmitidas(s.getFacturasEmitidas());
        
        
        svr.editarSalidasVenta(s.getSalidasVenta());        
        
        for(SalidasVentaDetalle sd:s.getSalidasVentaDetalleList()){
            if(sd.getEliminar()==0){
            svdr.guardarSalidasVentaDetalle(sd);
            for(SalidasVentaDetalleIngreso sadi:sd.getSalidasVentaDetalleIngresosList()){
                ivdr.editarIngresosVentaDetalle(sadi.getIngresosVentaDetalle());//el detalle salida-ingreso esta relacionado a detalle de ingreso
                
                sadi.getSalidasVentaDetalle().setSalidasVenta(s.getSalidasVenta());
                sadi.setSalidasVentaDetalle(sd);
                svdir.guardarSalidasVentaDetalleIngreso(sadi);                
            }
            }
        }
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }        
        return true;
    }
    public  boolean eliminarSalidasVentaBusiness(SalidasVentaBusiness sa) throws Exception {
        
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource(this.con);
        SalidasVentaDetalleIngresoResource svdir = new SalidasVentaDetalleIngresoResource(this.con);
        SalidasVentaResource svr = new SalidasVentaResource(this.con);
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource(this.con);
        FacturasEmitidasResource femr = new FacturasEmitidasResource(this.con);
        
        try {
        //retornar la cantidad salida al ingreso
        SalidasVentaDetalle sd1 = new SalidasVentaDetalle();//borrar datos de detalle salida almcen
        sd1.setSalidasVenta(sa.getSalidasVenta());
        
        
        SalidasVentaDetalleIngreso sdi1 = new SalidasVentaDetalleIngreso();
        sdi1.getSalidasVentaDetalle().setSalidasVenta(sa.getSalidasVenta());        
        sdi1.getIngresosVentaDetalle().getIngresosVenta().setAlmacenesVenta(sa.getSalidasVenta().getAlmacenesVenta());
        
        
        
        
        List<SalidasVentaDetalleIngreso> svdiList=  svdir.cargarSalidasVentaDetalleIngreso(sdi1);
        for(SalidasVentaDetalleIngreso svdi : svdiList){
            svdi.getSalidasVentaDetalle().getSalidasVenta().setAlmacenesVenta(sa.getSalidasVenta().getAlmacenesVenta());            
            svdi.getIngresosVentaDetalle().setCantRestante(svdi.getIngresosVentaDetalle().getCantRestante()+svdi.getCantSacar());//retornamos la cantidad restante
            ivdr.editarIngresosVentaDetalle(svdi.getIngresosVentaDetalle());
        }
        svdir.borrarSalidasVentaDetalleIngreso(sdi1);
        svdr.borrarSalidasVentaDetalle(sd1);        
        femr.eliminarFacturasEmitidas(sa.getFacturasEmitidas());
        svr.eliminarSalidasVenta(sa.getSalidasVenta());
        
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
            
        }
        
        return true;
    }
    
    public  boolean anularSalidasVentaBusiness(SalidasVentaBusiness sa) throws Exception {
        
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource(this.con);
        SalidasVentaDetalleIngresoResource svdir = new SalidasVentaDetalleIngresoResource(this.con);
        SalidasVentaResource svr = new SalidasVentaResource(this.con);
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource(this.con);
        
        try {
        //retornar la cantidad salida al ingreso
        SalidasVentaDetalle sd1 = new SalidasVentaDetalle();//borrar datos de detalle salida almcen
        sd1.setSalidasVenta(sa.getSalidasVenta());
        
        
        SalidasVentaDetalleIngreso sdi1 = new SalidasVentaDetalleIngreso();
        sdi1.getSalidasVentaDetalle().setSalidasVenta(sa.getSalidasVenta());        
        sdi1.getIngresosVentaDetalle().getIngresosVenta().setAlmacenesVenta(sa.getSalidasVenta().getAlmacenesVenta());            
        
        List<SalidasVentaDetalleIngreso> svdiList=  svdir.cargarSalidasVentaDetalleIngreso(sdi1);
        for(SalidasVentaDetalleIngreso svdi : svdiList){
            
            svdi.getSalidasVentaDetalle().getSalidasVenta().setAlmacenesVenta(sa.getSalidasVenta().getAlmacenesVenta());            
            svdi.getIngresosVentaDetalle().setCantRestante(svdi.getIngresosVentaDetalle().getCantRestante()+svdi.getCantSacar());//retornamos la cantidad restante
            ivdr.editarIngresosVentaDetalle(svdi.getIngresosVentaDetalle());
            //no sacar ninguna cantidad desde el detalle salida ingreso
            svdi.setCantSacar(0);
            svdir.editarSalidasVentaDetalleIngreso(svdi);
        }
        //svdir.borrarSalidasVentaDetalleIngreso(sdi1);
        //svdr.borrarSalidasVentaDetalle(sd1);        
        //anular la salida almacen
        sa.getSalidasVenta().getEstadosSalidaVenta().setCodEstadoSalidaVenta(2);//anulado
        svr.editarSalidasVenta(sa.getSalidasVenta());
        //svr.eliminarSalidasVenta(sa.getSalidasVenta());
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
            
        }
        
        return true;
    }
}
