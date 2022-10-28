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
import servicio.model.IngresosVenta;
import servicio.model.SalidasVentaDetalleIngreso;

import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class SalidasVentaDetalleIngresoResource extends BeanResource {
    
    Connection con;
    public SalidasVentaDetalleIngresoResource(){
    }
    public SalidasVentaDetalleIngresoResource(Connection con){
        this.con = con;
    }
    
    public  List<SalidasVentaDetalleIngreso> cargarSalidasVentaDetalleIngreso(SalidasVentaDetalleIngreso s) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        List<SalidasVentaDetalleIngreso> salidasVentaList =new ArrayList<SalidasVentaDetalleIngreso>();
        try {
            //tiene que cargar ingresos venta detalle estado
            
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
                    
            String consulta =   " SELECT ia.fecha_ingreso_venta,ia.nro_ingreso_venta,i.cod_almacen_venta,  i.cod_ingreso_venta,  i.cod_producto,  i.cant_ingreso,  i.total_monto,  i.precio_unitario,  i.costo_unitario, " +
                                " i.sub_total_monto,  i.cod_estado_registro,  i.cant_restante,i.glosa,u.cod_unidad_medida,u.nombre_unidad_medida,sadi.cant_sacar,sadi.cod_salida_venta " +
                                " FROM ventas.salidas_venta_detalle_ingreso sadi " +
                                " inner join ventas.ingresos_venta_detalle i on sadi.cod_ingreso_venta = i.cod_ingreso_venta and sadi.cod_producto = i.cod_producto " +
                                " inner join ventas.ingresos_venta ia on ia.cod_ingreso_venta = i.cod_ingreso_venta " +
                                " inner join public.unidades_medida u on u.cod_unidad_medida = i.cod_unidad_medida " +
                                " where 0 = 0 " +
                                " and ia.cod_almacen_venta = '"+s.getIngresosVentaDetalle().getIngresosVenta().getAlmacenesVenta().getCodAlmacenVenta()+"' " +
                                " and i.cod_producto = '"+s.getIngresosVentaDetalle().getProductos().getCodProducto()+"' " +
                                " and sadi.cod_salida_venta ='"+s.getSalidasVentaDetalle().getSalidasVenta().getCodSalidaVenta()+"' " +
                                " and ia.cod_estado_registro = 1 " +
                                " order by ia.fecha_ingreso_venta, ia.nro_ingreso_venta ";
            
            consulta =  " SELECT ia.fecha_ingreso_venta,ia.nro_ingreso_venta,i.cod_almacen_venta,  i.cod_ingreso_venta,  i.cod_producto,  i.cant_ingreso,   " +
                        " i.total_monto,  i.precio_unitario,  i.costo_unitario,   i.sub_total_monto,  i.cod_estado_registro,i.cant_restante,i.glosa, " +
                        " u.cod_unidad_medida,u.nombre_unidad_medida,coalesce(sadi.cant_sacar,0) cant_sacar,sadi.cod_salida_venta,i.cod_tipo_envase, i.nro_lote,i.fecha_fabricacion,i.fecha_vencimiento    " +
                        " FROM ventas.ingresos_venta_detalle i    " +
                        " inner join ventas.ingresos_venta ia on ia.cod_ingreso_venta = i.cod_ingreso_venta    " +
                        " inner join public.unidades_medida u on u.cod_unidad_medida = i.cod_unidad_medida " +
                        " inner join ventas.salidas_venta_detalle_ingreso sadi on sadi.cod_ingreso_venta = i.cod_ingreso_venta and sadi.cod_producto = i.cod_producto "+
                        " and sadi.cod_salida_venta = '"+s.getSalidasVentaDetalle().getSalidasVenta().getCodSalidaVenta()+"'   " +
                        " where 0 = 0    " +
                        " and ia.cod_almacen_venta = '"+s.getIngresosVentaDetalle().getIngresosVenta().getAlmacenesVenta().getCodAlmacenVenta()+"'   "; //s.getIngresosVentaDetalle().getIngresosVenta().getAlmacenesVenta().getCodAlmacenVenta()
                        if(s.getIngresosVentaDetalle().getProductos().getCodProducto()>0)
                        {
                            consulta += " and i.cod_producto = '"+s.getIngresosVentaDetalle().getProductos().getCodProducto()+"' ";
                        }
                        consulta +=" and ia.cod_estado_registro = 1     " +
                        " order by ia.fecha_ingreso_venta, ia.nro_ingreso_venta ";

            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            salidasVentaList.clear();
            while (rs.next())
            {
                SalidasVentaDetalleIngreso sadi = new SalidasVentaDetalleIngreso();
                sadi.getIngresosVentaDetalle().getIngresosVenta().setFechaIngresoVenta(sdf.format(rs.getTimestamp("fecha_ingreso_venta")));
                sadi.getIngresosVentaDetalle().getIngresosVenta().setNroIngresoVenta(rs.getInt("nro_ingreso_venta"));
                sadi.getIngresosVentaDetalle().getIngresosVenta().getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                sadi.getIngresosVentaDetalle().getIngresosVenta().setCodIngresoVenta(rs.getInt("cod_ingreso_venta"));
                sadi.getIngresosVentaDetalle().getProductos().setCodProducto(rs.getInt("cod_producto"));
                sadi.getIngresosVentaDetalle().setCantIngreso(rs.getDouble("cant_ingreso"));
                sadi.getIngresosVentaDetalle().setTotalMonto(rs.getDouble("total_monto"));
                sadi.getIngresosVentaDetalle().setPrecioUnitario(rs.getDouble("precio_unitario"));
                sadi.getIngresosVentaDetalle().setCostoUnitario(rs.getDouble("costo_unitario"));
                sadi.getIngresosVentaDetalle().setSubTotalMonto(rs.getDouble("sub_total_monto"));
                sadi.getIngresosVentaDetalle().getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                sadi.getIngresosVentaDetalle().setCantRestante(rs.getDouble("cant_restante"));
                sadi.getIngresosVentaDetalle().setGlosa(rs.getString("glosa"));
                sadi.getIngresosVentaDetalle().getUnidadesMedida().setCodUnidadMedida(rs.getInt("cod_unidad_medida"));
                sadi.getIngresosVentaDetalle().getUnidadesMedida().setNombreUnidadMedida(rs.getString("nombre_unidad_medida"));
                
                sadi.getIngresosVentaDetalle().getTiposEnvase().setCodTipoEnvase(rs.getInt("cod_tipo_envase"));
                sadi.getIngresosVentaDetalle().setNroLote(rs.getString("nro_lote"));
                sadi.getIngresosVentaDetalle().setFechaFabricacion(rs.getTimestamp("fecha_fabricacion")!=null?sdf.format(rs.getTimestamp("fecha_fabricacion")):"");
                sadi.getIngresosVentaDetalle().setFechaVencimiento(rs.getTimestamp("fecha_vencimiento")!=null?sdf.format(rs.getTimestamp("fecha_vencimiento")):"");
                
                
                sadi.setCantSacar(rs.getDouble("cant_sacar"));
                sadi.getSalidasVentaDetalle().getSalidasVenta().setCodSalidaVenta(rs.getInt("cod_salida_venta"));
                
                salidasVentaList.add(sadi);
                
            }
            rs.close();
            statement.close();
            //con.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new java.lang.Error(e.getMessage());
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return salidasVentaList;
    }
    
    public  int guardarSalidasVentaDetalleIngreso(SalidasVentaDetalleIngreso s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " INSERT INTO " +
                          " ventas.salidas_venta_detalle_ingreso " +
                          "( cod_salida_venta,  cod_salida_venta_detalle,  cod_producto,  cod_ingreso_venta,  cod_ingreso_venta_detalle,  cod_estado_registro,cant_sacar) " +
                          " VALUES (  '"+s.getSalidasVentaDetalle().getSalidasVenta().getCodSalidaVenta()+"',  '0',  '"+s.getSalidasVentaDetalle().getProductos().getCodProducto()+"',  '"+s.getIngresosVentaDetalle().getIngresosVenta().getCodIngresoVenta()+"',  '0',  1,'"+s.getCantSacar()+"') ";
            
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            //utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int editarSalidasVentaDetalleIngreso(SalidasVentaDetalleIngreso s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =" update ventas.salidas_venta_detalle_ingreso set cant_sacar = '"+s.getCantSacar()+"' "
                    + " where cod_ingreso_venta= '"+s.getIngresosVentaDetalle().getIngresosVenta().getCodIngresoVenta()+"'"                    
                    + " and cod_salida_venta= '"+s.getSalidasVentaDetalle().getSalidasVenta().getCodSalidaVenta()+"' "                    
                    + " and cod_producto = '"+s.getIngresosVentaDetalle().getProductos().getCodProducto()+"'  ";            

            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            //utiles.closeConnection();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());            
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
    public  double cantidadRestanteMaterial(SalidasVentaDetalleIngreso s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons =   "  ;";
            
            
            

            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            utiles.closeConnection();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error en editarSalidasAlmacen");
        }
        //Utiles.closeConnection();
        return guardado;
    }

    public  double cantidadRestanteIngresoVentaDetalleEstado(SalidasVentaDetalleIngreso s){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        double cantidadRestante = 0.0;
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement st = utiles.getCon().createStatement();
            String consulta = " ";
                        
            
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
    public  List<SalidasVentaDetalleIngreso> etiquetasSalidaVentaDetalleIngreso(SalidasVentaDetalleIngreso s)throws Exception{
        List<SalidasVentaDetalleIngreso> salidaAlmacenDetalleIngresoList =new ArrayList<SalidasVentaDetalleIngreso>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        double cantidadRestante = 0.0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            //Statement st = utiles.getCon().createStatement();
            String consulta =   "  SELECT ia.fecha_ingreso_venta,ia.nro_ingreso_venta,i.cod_almacen_venta,  i.cod_ingreso_venta,  i.cod_producto,  i.cant_ingreso,  i.total_monto,  i.precio_unitario,  i.costo_unitario, " +
                                "  i.sub_total_monto,  i.cod_estado_registro,  i.cant_restante,i.glosa,u.cod_unidad_medida,u.nombre_unidad_medida,i.cod_tipo_envase, i.nro_lote,i.fecha_fabricacion,i.fecha_vencimiento " +
                                "  FROM ventas.ingresos_venta_detalle i " +
                                "  inner join ventas.ingresos_venta ia on ia.cod_ingreso_venta = i.cod_ingreso_venta " +
                                "  left outer join public.unidades_medida u on u.cod_unidad_medida = i.cod_unidad_medida " +
                                "  where 0 = 0 " +
                                "  and ia.cod_almacen_venta = '"+s.getIngresosVentaDetalle().getIngresosVenta().getAlmacenesVenta().getCodAlmacenVenta()+"' " +
                                "  and i.cod_producto = '"+s.getIngresosVentaDetalle().getProductos().getCodProducto()+"' " +
                                "  and ia.cod_estado_registro = 1 " +
                                "  and  i.cant_restante >0 " +
                                "  order by i.fecha_vencimiento asc ";
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            salidaAlmacenDetalleIngresoList.clear();
            while (rs.next())
            {
                SalidasVentaDetalleIngreso sa = new SalidasVentaDetalleIngreso();
                sa.getIngresosVentaDetalle().getIngresosVenta().setFechaIngresoVenta(sdf.format(rs.getTimestamp("fecha_ingreso_venta")));
                sa.getIngresosVentaDetalle().getIngresosVenta().setNroIngresoVenta(rs.getInt("nro_ingreso_venta"));
                sa.getIngresosVentaDetalle().getIngresosVenta().getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                sa.getIngresosVentaDetalle().getIngresosVenta().setCodIngresoVenta(rs.getInt("cod_ingreso_venta"));
                sa.getIngresosVentaDetalle().getProductos().setCodProducto(rs.getInt("cod_producto"));
                sa.getIngresosVentaDetalle().setCantIngreso(rs.getDouble("cant_ingreso"));
                sa.getIngresosVentaDetalle().setTotalMonto(rs.getDouble("total_monto"));
                sa.getIngresosVentaDetalle().setPrecioUnitario(rs.getDouble("precio_unitario"));
                sa.getIngresosVentaDetalle().setCostoUnitario(rs.getDouble("costo_unitario"));
                sa.getIngresosVentaDetalle().setSubTotalMonto(rs.getDouble("sub_total_monto"));
                sa.getIngresosVentaDetalle().setCantRestante(rs.getDouble("cant_restante"));
                sa.getIngresosVentaDetalle().getUnidadesMedida().setCodUnidadMedida(rs.getInt("cod_unidad_medida"));
                sa.getIngresosVentaDetalle().getUnidadesMedida().setNombreUnidadMedida(rs.getString("nombre_unidad_medida"));
                sa.getIngresosVentaDetalle().getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                sa.getIngresosVentaDetalle().setGlosa(rs.getString("glosa"));
                sa.getIngresosVentaDetalle().getTiposEnvase().setCodTipoEnvase(rs.getInt("cod_tipo_envase"));
                sa.getIngresosVentaDetalle().setNroLote(rs.getString("nro_lote"));
                sa.getIngresosVentaDetalle().setFechaFabricacion(rs.getTimestamp("fecha_fabricacion")!=null?sdf.format(rs.getTimestamp("fecha_fabricacion")):"");
                sa.getIngresosVentaDetalle().setFechaVencimiento(rs.getTimestamp("fecha_vencimiento")!=null?sdf.format(rs.getTimestamp("fecha_vencimiento")):"");
                
                
                
                salidaAlmacenDetalleIngresoList.add(sa);
            }
            rs.close();
            statement.close();
            //con.close();
            utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error en editarSalidasAlmacen");
        }
        //Utiles.closeConnection();
        return salidaAlmacenDetalleIngresoList;
    }
    
    public  int borrarSalidasVentaDetalleIngreso(SalidasVentaDetalleIngreso s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            //Statement statement = this.con.createStatement();
            
            String cons =   " delete from " +
                            " ventas.salidas_venta_detalle_ingreso " +                            
                            " WHERE 0=0  ";
            
            
            if(s.getIngresosVentaDetalle().getIngresosVenta().getCodIngresoVenta()!=0){cons+= " and cod_ingreso_venta = '"+s.getIngresosVentaDetalle().getIngresosVenta().getCodIngresoVenta()+"' ";};
            if(s.getSalidasVentaDetalle().getSalidasVenta().getCodSalidaVenta()!=0){cons+= " and cod_salida_venta = '"+s.getSalidasVentaDetalle().getSalidasVenta().getCodSalidaVenta()+"' ";};
            if(s.getSalidasVentaDetalle().getProductos().getCodProducto()!=0){cons+= " and cod_producto = '"+s.getSalidasVentaDetalle().getProductos().getCodProducto()+"' ";};
            PreparedStatement statement = this.con.prepareStatement(cons);
            System.out.println("cons " + cons);
            //guardado = statement.executeUpdate(cons);            
            statement.execute();
            System.out.println(guardado);
            
            statement.close();
            //con.close();
            //utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        //Utiles.closeConnection();
        return guardado;
    }
    //buscar salidas de un ingreso venta
    public  List<SalidasVentaDetalleIngreso> buscarSalidasVentaDetalleIngreso(SalidasVentaDetalleIngreso svdi) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        List<SalidasVentaDetalleIngreso> salidasAlmacenList =new ArrayList<SalidasVentaDetalleIngreso>();
        try {
            //tiene que cargar ingresos venta detalle estado
            
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
                    
            String consulta =   " select sa.cod_salida_venta,sa.cod_almacen_venta,sa.cod_gestion,sa.nro_salida_venta,sa.fecha_salida_venta,"+
                                " sa.cod_tipo_salida_venta,sa.cod_cliente,sa.cod_estado_salida_venta "+
                                " from ventas.ingresos_venta ia " +
                                " inner join ventas.salidas_venta_detalle_ingreso sadi on sadi.cod_ingreso_venta = ia.cod_ingreso_venta " +
                                " inner join ventas.salidas_venta sa on sa.cod_salida_venta = sadi.cod_salida_venta and sa.cod_estado_salida_venta=1 and sadi.cant_sacar>0 " +//revisar
                                " where 0=0 ";
            if(svdi.getIngresosVentaDetalle().getIngresosVenta().getCodIngresoVenta()!=0){
                consulta += " and ia.cod_ingreso_venta = '"+svdi.getIngresosVentaDetalle().getIngresosVenta().getCodIngresoVenta()+"' ";
            }
            if(svdi.getSalidasVentaDetalle().getSalidasVenta().getCodSalidaVenta()!=0){
                consulta += " and sadi.cod_salida_venta = '"+svdi.getSalidasVentaDetalle().getSalidasVenta().getCodSalidaVenta()+"' ";
            }
                    
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            salidasAlmacenList.clear();
            while (rs.next())
            {
                SalidasVentaDetalleIngreso sadi = new SalidasVentaDetalleIngreso();
                sadi.getSalidasVentaDetalle().getSalidasVenta().setCodSalidaVenta(rs.getInt("cod_salida_venta"));
                sadi.getSalidasVentaDetalle().getSalidasVenta().getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                sadi.getSalidasVentaDetalle().getSalidasVenta().getGestion().setCodGestion(rs.getInt("cod_gestion"));
                sadi.getSalidasVentaDetalle().getSalidasVenta().setNroSalidaVenta(rs.getInt("nro_salida_venta"));
                
                sadi.getSalidasVentaDetalle().getSalidasVenta().setFechaSalidaVenta(sdf.format(rs.getTimestamp("fecha_salida_venta")));
                sadi.getSalidasVentaDetalle().getSalidasVenta().getTiposSalidaVenta().setCodTipoSalidaVenta(rs.getInt("cod_tipo_salida_venta"));
                sadi.getSalidasVentaDetalle().getSalidasVenta().getClientes().setCodCliente(rs.getInt("cod_cliente"));
                sadi.getSalidasVentaDetalle().getSalidasVenta().getEstadosSalidaVenta().setCodEstadoSalidaVenta(rs.getInt("cod_estado_salida_venta"));
                
                
                
                
                salidasAlmacenList.add(sadi);
                
            }
            rs.close();
            statement.close();
            //con.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error en editarSalidasAlmacen");
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return salidasAlmacenList;
    }
    
    
}
