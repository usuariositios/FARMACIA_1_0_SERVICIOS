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
import servicio.model.SalidasVentaDetalle;
import servicio.model.SalidasVentaDetalleIngreso;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class SalidasVentaDetalleResource extends BeanResource {
    Connection con;
    public SalidasVentaDetalleResource(){
    }
    public SalidasVentaDetalleResource(Connection con){
        this.con = con;
    }
    
    public  List<SalidasVentaDetalle> cargarSalidasVentaDetalle(SalidasVentaDetalle sa) {
        List<SalidasVentaDetalle> salidasAlmacenList =new ArrayList<SalidasVentaDetalle>();
        SalidasVentaDetalleIngresoResource svdir = new SalidasVentaDetalleIngresoResource();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
                    
                    String consulta =   " SELECT  " +
                                        "  sd.cod_salida_venta,sd.cod_producto,p.nombre_producto,sd.cant_salida,sd.costo_unitario,sd.monto_sub_total,sd.cod_estado_registro,e.nombre_estado_registro,u.cod_unidad_medida,u.nombre_unidad_medida,sd.porc_descuento,sd.monto_total " +
                                        "  FROM  " +
                                        "  ventas.salidas_venta_detalle sd " +
                                        "  left outer join public.productos p on p.cod_producto = sd.cod_producto " +
                                        "  left outer join public.estados_registro e on e.cod_estado_registro = sd.cod_estado_registro "+
                                        "  left outer join public.unidades_medida u on u.cod_unidad_medida = sd.cod_unidad_medida " +
                                        "  where sd.cod_salida_venta = '"+sa.getSalidasVenta().getCodSalidaVenta()+"'  ";
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            salidasAlmacenList.clear();
            
            SalidasVentaDetalleIngreso sadi = new SalidasVentaDetalleIngreso();
            sadi.getIngresosVentaDetalle().getIngresosVenta().setAlmacenesVenta(sa.getSalidasVenta().getAlmacenesVenta());
            sadi.getIngresosVentaDetalle().setProductos(sa.getProductos());
            sadi.getSalidasVentaDetalle().setSalidasVenta((sa.getSalidasVenta()));
            while (rs.next())
            {
                SalidasVentaDetalle s = new SalidasVentaDetalle();
                s.getSalidasVenta().setCodSalidaVenta(rs.getInt("cod_salida_venta"));
                s.getProductos().setCodProducto(rs.getInt("cod_producto"));
                s.getProductos().setNombreProducto(rs.getString("nombre_producto"));
                s.setCantSalida(rs.getDouble("cant_salida"));
                s.setCostoUnitario(rs.getDouble("costo_unitario"));
                s.setMontoSubTotal(rs.getDouble("monto_sub_total"));
                s.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                s.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                s.getUnidadesMedida().setCodUnidadMedida(rs.getInt("cod_unidad_medida"));
                s.getUnidadesMedida().setNombreUnidadMedida(rs.getString("nombre_unidad_medida"));
                s.setPorcDescuento(rs.getDouble("porc_descuento"));
                s.setMontoTotal(rs.getDouble("monto_total"));
                sadi.getIngresosVentaDetalle().getProductos().setCodProducto(rs.getInt("cod_producto"));
                
                s.setSalidasVentaDetalleIngresosList(svdir.cargarSalidasVentaDetalleIngreso(sadi));
                
                
                salidasAlmacenList.add(s);                
            }
            rs.close();
            statement.close();
            //con.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return salidasAlmacenList;
    }
    
    public  int guardarSalidasVentaDetalle(SalidasVentaDetalle s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            
            Statement statement = this.con.createStatement();
            String cons =   "  INSERT INTO  " +
                            "  ventas.salidas_venta_detalle " +
                            "  (cod_salida_venta, cod_producto,  cant_salida,  costo_unitario,  monto_sub_total, cod_estado_registro,cod_unidad_medida,porc_descuento,monto_total) " +
                            "  VALUES (  '"+s.getSalidasVenta().getCodSalidaVenta()+"',  '"+s.getProductos().getCodProducto()+"',  '"+s.getCantSalida()+"',  '"+s.getCostoUnitario()+"',  '"+s.getMontoSubTotal()+"',  '"+s.getEstadosRegistro().getCodEstado()+"','"+s.getUnidadesMedida().getCodUnidadMedida()+"','"+s.getPorcDescuento()+"','"+s.getMontoTotal()+"');    ";
            
            
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
    public  int editarSalidasVentaDetalle(SalidasVentaDetalle s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE  " +
                            "  ventas.salidas_venta_detalle  " +
                            "  SET  " +                            
                            "  cant_salida = '"+s.getCantSalida()+"', " +
                            "  costo_unitario = '"+s.getCostoUnitario()+"', " +
                            "  monto_sub_total = '"+s.getMontoSubTotal()+"', " +
                            "  cod_estado_registro = '"+s.getEstadosRegistro().getCodEstado()+"', "+
                            "  cod_unidad_medida = '"+s.getUnidadesMedida().getCodUnidadMedida()+"'," +
                            "  porc_descuento = '"+s.getPorcDescuento()+"'," +
                            "  monto_total = '"+s.getMontoTotal()+"'" +
                            "  WHERE  " +
                            "  cod_salida_venta = '"+s.getSalidasVenta().getCodSalidaVenta()+"' "+
                            "  cod_producto = '"+s.getProductos().getCodProducto()+"' " ;
            

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
    
    public  int borrarSalidasVentaDetalle(SalidasVentaDetalle s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            //Statement statement = this.con.createStatement();
            String cons =   " delete from " +
                            " ventas.salidas_venta_detalle " +                            
                            " WHERE 0=0  ";
                          
            if(s.getProductos().getCodProducto()!=0){cons+= " and cod_producto = '"+s.getProductos().getCodProducto()+"' ";};
            if(s.getSalidasVenta().getCodSalidaVenta()!=0){cons+= " and cod_salida_venta = '"+s.getSalidasVenta().getCodSalidaVenta()+"' ";};
            PreparedStatement statement = this.con.prepareStatement(cons);
            System.out.println("cons " + cons);
            guardado = statement.execute()==true?1:0;

            
            //guardado = statement.executeUpdate(cons);
            
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
    
    public  double cantRestanteIngresoVentaDetalle(SalidasVentaDetalle s){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        double cantidadRestante = 0.0;
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement st = utiles.getCon().createStatement();
            String consulta =   " select sum(id.CANT_RESTANTE) cantidad_r" +
                                " from ventas.INGRESOS_VENTA i, ventas.INGRESOS_VENTA_DETALLE id" +
                                " where i.COD_INGRESO_VENTA=id.COD_INGRESO_VENTA" +
                                " and i.COD_ESTADO_INGRESO_VENTA=1" +
                                " and id.cod_producto='"+s.getProductos().getCodProducto()+"'" +
                                " and id.CANT_RESTANTE>0" +
                                " and i.COD_ALMACEN_VENTA ='"+s.getSalidasVenta().getAlmacenesVenta().getCodAlmacenVenta()+"' ";
                        
            
            System.out.println("cons " + consulta);
            ResultSet rs = st.executeQuery(consulta);
            if(rs.next()){
                cantidadRestante = rs.getDouble("cantidad_r");
            }
            
            st.close();
            //con.close();
            utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return cantidadRestante;
    }
    public  SalidasVentaDetalle subTotalSalidaVentaDetalle(SalidasVentaDetalle sd){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement st = utiles.getCon().createStatement();
            String consulta =   " select sum(sd.monto_sub_total) monto_sub_total,sum(sd.porc_descuento/100*sd.monto_sub_total) monto_descuento, sum(sd.monto_total) monto_total" +
                                " from ventas.salidas_venta_detalle sd where cod_salida_venta = '"+sd.getSalidasVenta().getCodSalidaVenta()+"'  ";
                        
            
            System.out.println("cons " + consulta);
            ResultSet rs = st.executeQuery(consulta);
            if(rs.next()){
                sd.setMontoSubTotal(rs.getDouble("monto_sub_total"));
                sd.setMontoDescuento(rs.getDouble("monto_descuento"));
                sd.setMontoTotal(rs.getDouble("monto_total"));
                
                 
            }
            
            st.close();
            //con.close();
            utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return sd;
    }
    
    
}
