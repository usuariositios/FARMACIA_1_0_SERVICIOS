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
import servicio.model.OrdenesCompra;
import servicio.model.OrdenesCompraDetalle;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class OrdenCompraDetalleResource {
    Connection con;
    public OrdenCompraDetalleResource(){
    }
    public OrdenCompraDetalleResource(Connection con){
        this.con = con;
    }
    public  List<OrdenesCompraDetalle> cargarOrdenesCompraDetalle(OrdenesCompra o) {
        List<OrdenesCompraDetalle> ordenesCompraDetalleList =new ArrayList<OrdenesCompraDetalle>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
            
            String consulta =   " select o.cod_orden_compra,m.cod_material,m.nombre_material,o.cantidad_neta, " +
                                " u.cod_unidad_medida,u.nombre_unidad_medida,u.abreviatura,o.precio_unitario,o.precio_total,o.descripcion,tp.cod_tipo_pago,tp.nombre_tipo_pago,pr.cod_proveedor,pr.nombre_proveedor,"+
                                " p.cod_producto,p.nombre_producto,o.cod_tipo_envase, o.nro_lote,o.fecha_fabricacion,o.fecha_vencimiento  " +
                                " from ordenes_compra_detalle o " +                    
                                " left outer join public.materiales m on m.cod_material = o.cod_material "+
                                " left outer join public.unidades_medida u on u.cod_unidad_medida = o.cod_unidad_medida "+
                                " left outer join public.tipos_pago tp on tp.cod_tipo_pago = o.cod_tipo_pago "+
                                " left outer join public.proveedores pr on pr.cod_proveedor = o.cod_proveedor " +
                                " left outer join public.productos p on p.cod_producto = o.cod_producto  " +
                                " where o.cod_orden_compra = '"+o.getCodOrdenCompra()+"' order by m.nombre_material asc ";
            System.out.println("consulta " +consulta);
            
            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            ordenesCompraDetalleList.clear();
            while (rs.next())
            {
                OrdenesCompraDetalle oc = new OrdenesCompraDetalle();
                oc.getOrdenesCompra().setCodOrdenCompra(rs.getInt("cod_orden_compra"));
                oc.getMateriales().setCodMaterial(rs.getInt("cod_material"));
                oc.getMateriales().setNombreMaterial(rs.getString("nombre_material"));
                oc.setCantidadNeta(rs.getDouble("cantidad_neta"));
                oc.getUnidadesMedida().setCodUnidadMedida(rs.getInt("cod_unidad_medida"));
                oc.getUnidadesMedida().setNombreUnidadMedida(rs.getString("nombre_unidad_medida"));
                oc.getUnidadesMedida().setAbreviatura(rs.getString("abreviatura"));
                oc.setPrecioUnitario(rs.getDouble("precio_unitario"));
                oc.setPrecioTotal(rs.getDouble("precio_total"));
                oc.setDescripcion(rs.getString("descripcion"));
                oc.getProveedores().setCodProveedor(rs.getInt("cod_proveedor"));
                oc.getProveedores().setNombreProveedor(rs.getString("nombre_proveedor"));
                oc.getTiposPago().setCodTipoPago(rs.getInt("cod_tipo_pago"));
                oc.getTiposPago().setNombreTipoPago(rs.getString("nombre_tipo_pago"));
                oc.getProductos().setCodProducto(rs.getInt("cod_producto"));
                oc.getProductos().setNombreProducto(rs.getString("nombre_producto"));
                oc.getTiposEnvase().setCodTipoEnvase(rs.getInt("cod_tipo_envase"));
                oc.setNroLote(rs.getString("nro_lote"));
                oc.setFechaFabricacion(sdf1.format(rs.getTimestamp("fecha_fabricacion")));
                oc.setFechaVencimiento(sdf1.format(rs.getTimestamp("fecha_vencimiento")));
                
                ordenesCompraDetalleList.add(oc);
                
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
        return ordenesCompraDetalleList;
    }
    public  int codigoOrdenCompraDetalle(OrdenesCompra o){
        int codDetalle=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select COALESCE(max(c.cod_detalle),0)+1 cod_detalle from cotizacion_detalle c where c.cod_cotizacion = '"+o.getCodOrdenCompra()+"'";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codDetalle = rs.getInt("cod_detalle");
            }
            
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return codDetalle;
    }
    public  int guardarOrdenesCompraDetalle(OrdenesCompraDetalle o){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons =   "  INSERT INTO ordenes_compra_detalle( " +
                            " cod_orden_compra, cod_material, cantidad_neta, cod_unidad_medida,  " +
                            " precio_unitario, cantidad_ingreso_almacen, precio_total, descripcion,cod_tipo_pago,cod_proveedor,cod_producto,cod_tipo_envase,nro_lote,fecha_fabricacion,fecha_vencimiento) " +
                            " VALUES ('"+o.getOrdenesCompra().getCodOrdenCompra()+"', '"+o.getMateriales().getCodMaterial()+"', '"+o.getCantidadNeta()+"',"+
                            " '"+o.getUnidadesMedida().getCodUnidadMedida()+"','"+o.getPrecioUnitario()+"' , '"+o.getCantidadIngresoAlmacen()+"', '"+o.getPrecioTotal()+"', "+
                            " '"+o.getDescripcion()+"','"+o.getTiposPago().getCodTipoPago()+"','"+o.getProveedores().getCodProveedor()+"','"+o.getProductos().getCodProducto()+"'"
                    + ",'"+o.getTiposEnvase().getCodTipoEnvase()+"','"+o.getNroLote()+"','"+o.getFechaFabricacion()+"','"+o.getFechaVencimiento()+"' ); ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
    public  int editarOrdenesCompraDetalle(OrdenesCompraDetalle o,OrdenesCompraDetalle oc){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            
            String cons =   " UPDATE ordenes_compra_detalle " +
                            " SET  cod_material='"+oc.getMateriales().getCodMaterial()+"', cantidad_neta='"+oc.getCantidadNeta()+"',"+
                            " cod_unidad_medida='"+oc.getUnidadesMedida().getCodUnidadMedida()+"',  " +
                            " precio_unitario='"+oc.getPrecioUnitario()+"', cantidad_ingreso_almacen='"+oc.getCantidadIngresoAlmacen()+"'"+
                            ", precio_total='"+oc.getPrecioTotal()+"',  " +
                            " descripcion='"+oc.getDescripcion()+"',"
                    + "cod_tipo_pago='"+oc.getTiposPago().getCodTipoPago()+"',"
                    + "cod_proveedor = '"+oc.getProveedores().getCodProveedor()+"',"
                    + "cod_tipo_envase = '"+oc.getTiposEnvase().getCodTipoEnvase()+"',"
                    + "nro_lote = '"+oc.getNroLote()+"',"
                    
                    + "fecha_fabricacion = '"+oc.getFechaFabricacion()+"',"
                    + "fecha_vencimiento = '"+oc.getFechaVencimiento()+"' "+                            
                            " WHERE cod_orden_compra='"+o.getOrdenesCompra().getCodOrdenCompra()+"' and cod_material='"+o.getMateriales().getCodMaterial()+"' and cod_producto = '"+oc.getProductos().getCodProducto()+"' ";
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int borraOrdenesCompraDetalle(OrdenesCompraDetalle o){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            
            String cons =   " delete from ordenes_compra_detalle " +
                            " WHERE cod_orden_compra ='"+o.getOrdenesCompra().getCodOrdenCompra()+"' ";
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
    
}
