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
import servicio.model.SelectItem;
import servicio.model.DevolucionesBusiness;
import servicio.model.DevolucionesDetalle;
import servicio.model.IngresosVentaBusiness;
import servicio.model.IngresosVentaDetalle;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class DevolucionDetalleResource extends BeanResource {
    Connection con = null;
    public DevolucionDetalleResource(Connection con){
        this.con = con;
    }    
    public DevolucionDetalleResource(){
    }
    
    public  List<DevolucionesDetalle> cargarDevolucionesDetalle(DevolucionesDetalle ia) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        List<DevolucionesDetalle> ingresosVentaList =new ArrayList<DevolucionesDetalle>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String consulta =   " SELECT dt.cod_devolucion_detalle,dt.cod_devolucion,dt.cod_producto, dt.cantidad_devuelta, " +
                                " dt.cod_unidad_medida,  dt.precio_unitario,  dt.precio_total " +
                                " FROM ventas.devoluciones_detalle dt " +
                                " inner join public.productos p on p.cod_producto = dt.cod_producto " +
                                " inner join public.unidades_medida u on u.cod_unidad_medida = dt.cod_unidad_medida  " +                    
                                " where 0=0 and  dt.cod_devolucion = '"+ia.getDevoluciones().getCodDevolucion()+"' and dt.cod_almacen_venta = '"+ia.getAlmacenesVenta().getCodAlmacenVenta()+"'  ";
                    
                    
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            ingresosVentaList.clear();
            while (rs.next())
            {
                DevolucionesDetalle i = new DevolucionesDetalle();
                i.setCodDevolucionDetalle(rs.getInt("cod_devolucion_detalle"));
                i.getDevoluciones().setCodDevolucion(rs.getInt("cod_devolucion"));
                i.getProductos().setCodProducto(rs.getInt("cod_producto"));
                i.setCantidadDevuelta(rs.getDouble("cantidad_devuelta"));
                i.getUnidadesMedida().setCodUnidadMedida(rs.getInt("cod_unidad_medida"));
                i.setPrecioUnitario(rs.getDouble("precio_unitario"));
                i.setPrecioTotal(rs.getDouble("precio_total"));                
                i.getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                
                ingresosVentaList.add(i);
            }
            rs.close();
            statement.close();
            utiles.closeConnection();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return ingresosVentaList;
    }
    public  int codigoDevolucionesDetalle(){
        int codProductoSemiterminado=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select nextval('ventas.\"seqDevolucionesDetalle\"') cod_ingresosVenta";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codProductoSemiterminado = rs.getInt("cod_ingresosVenta");
            }
            
            statement.close();
            utiles.closeConnection();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return codProductoSemiterminado;
    }
    public  int guardarDevolucionesDetalle(DevolucionesDetalle i) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            
            //Connection con = Utiles.getConnection();
            Statement statement = this.con.createStatement();
            String cons =   " INSERT INTO ventas.devoluciones_detalle " +
                            "(  cod_devolucion_detalle,  cod_devolucion,  cod_producto,  cantidad_devuelta,  cod_unidad_medida,  precio_unitario, " +
                            "  precio_total,  cod_almacen_venta) " +
                            "VALUES ( '"+i.getCodDevolucionDetalle()+"',  '"+i.getDevoluciones().getCodDevolucion()+"',  '"+i.getProductos().getCodProducto()+"',  '"+i.getCantidadDevuelta()+"',  '"+i.getUnidadesMedida().getCodUnidadMedida()+"', " +
                            "  '"+i.getPrecioUnitario()+"',  '"+i.getPrecioTotal()+"',  '"+i.getAlmacenesVenta().getCodAlmacenVenta()+"');  ";
            
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int editarDevolucionesDetalle(DevolucionesDetalle i) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE  " +
                            "  ventas.devoluciones_detalle  " +
                            "  SET  " +                            
                            "  cod_producto = '"+i.getProductos().getCodProducto()+"', " +
                            "  cantidad_devuelta = '"+i.getCantidadDevuelta()+"', " +
                            "  cod_unidad_medida = '"+i.getUnidadesMedida().getCodUnidadMedida()+"', " +
                            "  precio_unitario = '"+i.getPrecioUnitario()+"', " +
                            "  precio_total = '"+i.getPrecioTotal()+"', " +
                            "  cod_almacen_venta = '"+i.getAlmacenesVenta().getCodAlmacenVenta()+"' " +
                            "  WHERE  " +
                            "  cod_devolucion_detalle = '"+i.getCodDevolucionDetalle()+"' and " +
                            "  cod_devolucion = '"+i.getDevoluciones().getCodDevolucion()+"' " ;

            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            //utiles.closeConnection();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error en editarDevolucionesDetalle");
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
    public  List<SelectItem> cargarDevolucionesDetalleItem() {
        List<SelectItem> productosList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " select c.cod_ingresos_venta,c.nro_ingreso_venta from ingresos_venta c order by cod_ingreso_venta ";
                           
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            productosList.clear();
            while (rs.next())
            {
                productosList.add(new SelectItem(rs.getInt("cod_ingresos_venta"), rs.getString("nro_ingreso_venta")));
            }
            rs.close();
            utiles.closeConnection();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return productosList;
    }
    
    
    public  int borraDevolucionesDetalle(DevolucionesDetalle c){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons =   " delete from ventas.devoluciones_detalle " +
                            " WHERE cod_devolucion = '"+c.getDevoluciones().getCodDevolucion()+"' ";
            
            
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            utiles.closeConnection();
            //con.close();            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
    
    
    
    public  DevolucionesDetalle buscarDevolucionesDetalle(DevolucionesDetalle ia) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        DevolucionesDetalle dt = new DevolucionesDetalle();
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String consulta =   " SELECT dt.cod_devolucion_detalle,dt.cod_devolucion,dt.cod_producto, dt.cantidad_devuelta, " +
                                " dt.cod_unidad_medida,  dt.precio_unitario,  dt.precio_total " +
                                " FROM ventas.devoluciones_detalle dt " +
                                " inner join public.productos p on p.cod_producto = dt.cod_producto " +
                                " inner join public.unidades_medida u on u.cod_unidad_medida = dt.cod_unidad_medida  " +                    
                                " where 0=0 and  dt.cod_devolucion = '"+ia.getDevoluciones().getCodDevolucion()+"' and dt.cod_almacen_venta = '"+ia.getAlmacenesVenta().getCodAlmacenVenta()+"'  ";
                    
                    
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
            {
                
                dt.setCodDevolucionDetalle(rs.getInt("cod_devolucion_detalle"));
                dt.getDevoluciones().setCodDevolucion(rs.getInt("cod_devolucion"));
                dt.getProductos().setCodProducto(rs.getInt("cod_producto"));
                dt.setCantidadDevuelta(rs.getDouble("cantidad_devuelta"));
                dt.getUnidadesMedida().setCodUnidadMedida(rs.getInt("cod_unidad_medida"));
                dt.setPrecioUnitario(rs.getDouble("precio_unitario"));
                dt.setPrecioTotal(rs.getDouble("precio_total"));                
                dt.getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));                
                
            }
            rs.close();
            statement.close();
            utiles.closeConnection();
            //con.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return dt;
    }
    
    
    

    
    
}
