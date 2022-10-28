/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import servicio.model.SalidasVentaAmortizacion;
import servicio.model.SalidasVentaAmortizacionBusiness;

import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class SalidasVentaAmortizacionResource extends BeanResource {
    Connection con;
    public SalidasVentaAmortizacionResource(){
    }
    public SalidasVentaAmortizacionResource(Connection con){
        this.con = con;
    }
    
    
    public  List<SalidasVentaAmortizacion> cargarSalidasVentaAmortizacion(SalidasVentaAmortizacion sa) {
        List<SalidasVentaAmortizacion> salidasVentaAmortizacionList =new ArrayList<SalidasVentaAmortizacion>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
                    
                    String consulta =   " SELECT cod_salida_venta,  cod_almacen_venta,  cod_gestion,  cod_amortizacion,  monto_amortizado_anterior,  fecha_pago, monto_pagado " +
                                        "  FROM ventas.salidas_venta_amortizacion "+
                                        " where cod_salida_venta = '"+sa.getSalidasVenta().getCodSalidaVenta()+"'"+
                                        " and cod_almacen_venta = '"+sa.getSalidasVenta().getAlmacenesVenta().getCodAlmacenVenta()+"'"+
                                        " and cod_gestion = '"+sa.getSalidasVenta().getGestion().getCodGestion()+"' ";
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            salidasVentaAmortizacionList.clear();
            
            
            
            while (rs.next())
            {
                SalidasVentaAmortizacion s = new SalidasVentaAmortizacion();
                s.getSalidasVenta().setCodSalidaVenta(rs.getInt("cod_salida_venta"));
                s.getSalidasVenta().getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                s.getSalidasVenta().getGestion().setCodGestion(rs.getInt("cod_gestion"));
                s.setCodAmortizacion(rs.getInt("cod_amortizacion"));
                s.setMontoAmortizadoAnterior(rs.getDouble("monto_amortizado_anterior"));
                s.setFechaPago(sdf.format(rs.getTimestamp("fecha_pago")));
                s.setMontoPagado(rs.getDouble("monto_pagado"));
                
                salidasVentaAmortizacionList.add(s);                
            }
            rs.close();
            statement.close();
            //con.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return salidasVentaAmortizacionList;
    }
    
    public  int guardarSalidasVentaAmortizacion(SalidasVentaAmortizacion s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            s.setCodAmortizacion(codAmortizacion(s));
            String cons =   "  INSERT INTO ventas.salidas_venta_amortizacion " +
                            "(cod_salida_venta,  cod_almacen_venta,  cod_gestion,  cod_amortizacion, " +
                            "  monto_amortizado_anterior,  fecha_pago,  monto_pagado) " +
                            "VALUES (  '"+s.getSalidasVenta().getCodSalidaVenta()+"',  '"+s.getSalidasVenta().getAlmacenesVenta().getCodAlmacenVenta()+"',  '"+s.getSalidasVenta().getGestion().getCodGestion()+"',  '"+s.getCodAmortizacion()+"', " +
                            "  '"+s.getMontoAmortizadoAnterior()+"',  '"+s.getFechaPago()+"',  '"+s.getMontoPagado()+"'); ";
            
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            //utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error en guardarSalidasAlmacenDetalle");
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int editarSalidasVentaAmortizacion(SalidasVentaAmortizacion s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE  " +
                            "  ventas.salidas_venta_amortizacion  " +
                            "  SET  " +                            
                            "  monto_amortizado_anterior = '"+s.getMontoAmortizadoAnterior()+"', " +
                            "  fecha_pago = '"+s.getFechaPago()+"', " +
                            "  monto_pagado = '"+s.getMontoPagado()+"' " +
                            "  WHERE  " +                            
                            "  cod_salida_venta = '"+s.getSalidasVenta().getCodSalidaVenta()+"', " +
                            "  cod_almacen_venta = '"+s.getSalidasVenta().getAlmacenesVenta().getCodAlmacenVenta()+"', " +
                            "  cod_gestion = '"+s.getSalidasVenta().getGestion().getCodGestion()+"', " +
                            "  cod_amortizacion = '"+s.getCodAmortizacion()+"' ";
            

            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            //utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error en editarSalidasAlmacen");
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
    public  int borrarSalidasVentaAmortizacion(SalidasVentaAmortizacion s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " delete from " +
                            " ventas.salidas_venta_amortizacion " +                            
                            " WHERE 0=0 "+
                            " and cod_salida_venta = '"+s.getSalidasVenta().getCodSalidaVenta()+"'"+
                            " and cod_almacen_venta = '"+s.getSalidasVenta().getAlmacenesVenta().getCodAlmacenVenta()+"'"+
                            " and cod_gestion = '"+s.getSalidasVenta().getGestion().getCodGestion()+"'";
                            //" and cod_amortizacion = '"+s.getCodAmortizacion()+"' ";
                          
            

            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            //utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error en editarSalidasAlmacen");
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
    public  int codAmortizacion(SalidasVentaAmortizacion sa){
        int codAmortizacion=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select COALESCE(max(cod_amortizacion),0)+1 cod_amortizacion from ventas.salidas_venta_amortizacion i where i.cod_salida_venta = '"+sa.getSalidasVenta().getCodSalidaVenta()+"' and i.cod_almacen_venta = '"+sa.getSalidasVenta().getAlmacenesVenta().getCodAlmacenVenta()+"' and i.cod_gestion = '"+sa.getSalidasVenta().getGestion().getCodGestion()+"' ";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codAmortizacion = rs.getInt("cod_amortizacion");
            }
            
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return codAmortizacion;
    }
    
    public  int guardarSalidaAmortizacionBusiness(SalidasVentaAmortizacionBusiness s) throws Exception{
        int resp = 0;
        Utiles utiles = new Utiles();
        utiles.getConnection();
        utiles.getCon().setAutoCommit(false);
        
        this.con = utiles.getCon();
        SalidasVentaResource svr = new SalidasVentaResource(utiles.getCon());
        try {
        
        SalidasVentaAmortizacion sa = new SalidasVentaAmortizacion();
        sa.setSalidasVenta(s.getSalidasVenta());
        this.borrarSalidasVentaAmortizacion(sa);
        for(SalidasVentaAmortizacion s1:s.getSalidasVentaAmortizacionList()){
            this.guardarSalidasVentaAmortizacion(s1);
        }
        svr.editarSalidasVenta(s.getSalidasVenta());
        utiles.getCon().commit();
        utiles.getCon().setAutoCommit(true);
        resp = 1;        
        } catch (Exception e) {            
            e.printStackTrace();
            resp = 0;
            utiles.getCon().rollback();
        }        
        utiles.closeConnection();        
        return resp;
    }
    
    
    
}
