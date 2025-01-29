/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import servicio.model.IngresosVenta;
import servicio.model.IngresosVentaDetalle;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class IngresosVentaDetalleResource {
    Connection con;
    public IngresosVentaDetalleResource(){
    }
    public IngresosVentaDetalleResource(Connection con){
        this.con = con;
    }
    
    public  List<IngresosVentaDetalle> cargarIngresosVentaDetalle(IngresosVenta i) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        List<IngresosVentaDetalle> ingresosAlmacenDetalleList =new ArrayList<IngresosVentaDetalle>();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String consulta =   " SELECT i.cod_almacen_venta,  i.cod_ingreso_venta,  i.cod_producto,pr.nombre_producto,  i.cant_ingreso, "
                    + " i.total_monto,  i.precio_compra,  i.precio_venta,  i.sub_total_monto,  i.cod_estado_registro,e.nombre_estado_registro,"
                    + "i.cant_restante,u.cod_unidad_medida,u.nombre_unidad_medida,"
                    + "i.cod_tipo_envase, i.nro_lote,i.fecha_fabricacion,i.fecha_vencimiento,tdp.cod_campo cod_laboratorio,tdp.nombre_campo nombre_laboratorio,p.principio_activo,"
                    + " tda.cod_campo cod_accion_terapeutica,tda.nombre_campo nombre_accion_terapeutica,i.porcentaje_descuento " +
                                "  FROM ventas.ingresos_venta_detalle i "
                    + "  inner join public.productos p on p.cod_producto = i.cod_producto"
                    
                    + "  left outer join  (select tdp1.* from ventas.tabla_detalle tdp1  "+
                      "  inner join ventas.tabla tp on tdp1.cod_tabla = tp.cod_tabla and tp.nombre_tabla = 'LABORATORIOS') tdp on tdp.cod_campo = p.cod_laboratorio " +
                    
                      "  left outer join (select tda1.* from ventas.tabla_detalle tda1  "+
                      "  inner join ventas.tabla ta on tda1.cod_tabla = ta.cod_tabla and ta.nombre_tabla = 'ACCION_TERAPEUTICA') tda on tda.cod_campo = p.cod_accion_terapeutica " +
                    
                                "  left outer join public.productos pr on pr.cod_producto = i.cod_producto " +
                                "  left outer join public.estados_registro e on e.cod_estado_registro = i.cod_estado_registro " +
                                "  left outer join public.unidades_medida u on u.cod_unidad_medida =  i.cod_unidad_medida "+
                                "  where i.cod_ingreso_venta = '"+i.getCodIngresoVenta()+"' and i.cod_almacen_venta = '"+i.getAlmacenesVenta().getCodAlmacenVenta()+"'";
            
            
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            ingresosAlmacenDetalleList.clear();
            while (rs.next())
            {
                IngresosVentaDetalle id = new IngresosVentaDetalle();
                id.getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                id.getIngresosVenta().setCodIngresoVenta(rs.getInt("cod_ingreso_venta"));
                id.getProductos().setCodProducto(rs.getInt("cod_producto"));
                id.getProductos().setNombreProducto(rs.getString("nombre_producto"));
                id.setCantIngreso(rs.getDouble("cant_ingreso"));
                id.setTotalMonto(rs.getDouble("total_monto"));
                id.setPrecioCompra(rs.getDouble("precio_compra"));
                id.setPrecioVenta(rs.getDouble("precio_venta"));
                id.setTotalMonto(rs.getDouble("total_monto"));
                id.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                id.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                id.setCantRestante(rs.getDouble("cant_restante"));
                id.getUnidadesMedida().setCodUnidadMedida(rs.getInt("cod_unidad_medida"));
                id.getUnidadesMedida().setNombreUnidadMedida(rs.getString("nombre_unidad_medida"));
                id.setSubTotalMonto(rs.getDouble("sub_total_monto"));
                
                
                
                id.getTiposEnvase().setCodTipoEnvase(rs.getInt("cod_tipo_envase"));
                id.setNroLote(rs.getString("nro_lote"));
                id.setFechaFabricacion(rs.getTimestamp("fecha_fabricacion")!=null?sdf.format(rs.getTimestamp("fecha_fabricacion")):"");
                id.setFechaVencimiento(rs.getTimestamp("fecha_vencimiento")!=null?sdf.format(rs.getTimestamp("fecha_vencimiento")):"");
                id.getProductos().getLaboratorio().setCodLaboratorio(rs.getInt("cod_laboratorio"));
                id.getProductos().getLaboratorio().setNombreLaboratorio(rs.getString("nombre_laboratorio"));
                id.getProductos().getUnidadesMedida().setCodUnidadMedida(rs.getInt("cod_unidad_medida"));
                id.getProductos().getUnidadesMedida().setNombreUnidadMedida(rs.getString("cod_unidad_medida"));
                id.getProductos().setPrincipioActivo(rs.getString("principio_activo"));
                id.getProductos().getAccionTerapeutica().setCodAccionTerapeutica(rs.getInt("cod_accion_terapeutica"));
                id.getProductos().getAccionTerapeutica().setNombreAccionTerapeutica(rs.getString("nombre_accion_terapeutica"));
                id.setPorcentajeDescuento(rs.getDouble("porcentaje_descuento"));
                
                
                
                ingresosAlmacenDetalleList.add(id);
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
        return ingresosAlmacenDetalleList;
    }
    public  int codigoIngresosVentaDetalle(IngresosVenta c){
        int codDetalle=0;
        try {
            Utiles utiles = new Utiles();utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select COALESCE(max(c.cod_detalle),0)+1 cod_detalle from cotizacion_detalle c where c.cod_cotizacion = '"+c.getCodIngresoVenta()+"'";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codDetalle = rs.getInt("cod_detalle");
            }
            
            statement.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return codDetalle;
    }
    public  int guardarIngresosVentaDetalle(IngresosVentaDetalle i) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =  " INSERT INTO  " +
                            "  ventas.ingresos_venta_detalle " +
                            "( cod_almacen_venta,  cod_ingreso_venta,  cod_producto,  cant_ingreso,  total_monto,  "
                    + "precio_compra,  precio_venta,  sub_total_monto,  cod_estado_registro,cant_restante,cod_unidad_medida,cod_tipo_envase,nro_lote,fecha_fabricacion,fecha_vencimiento,porcentaje_descuento ) " +
                            "VALUES (  '"+i.getIngresosVenta().getAlmacenesVenta().getCodAlmacenVenta()+"',  '"+i.getIngresosVenta().getCodIngresoVenta()+"', "
                    + " '"+i.getProductos().getCodProducto()+"',  '"+i.getCantIngreso()+"',  '"+i.getTotalMonto()+"',  '"+i.getPrecioCompra()+"',  "
                    + "'"+i.getPrecioVenta()+"',  '"+i.getSubTotalMonto()+"',  '"+i.getEstadosRegistro().getCodEstado()+"','"+i.getCantRestante()+"',"
                    + "'"+i.getUnidadesMedida().getCodUnidadMedida()+"','"+i.getTiposEnvase().getCodTipoEnvase()+"','"+i.getNroLote()+"','"+i.getFechaFabricacion()+"','"+i.getFechaVencimiento()+"','"+i.getPorcentajeDescuento()+"'); ";

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
    
    public  int editarIngresosVentaDetalle(IngresosVentaDetalle i)throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            //Statement statement = this.con.createStatement();
            
            String cons =   " UPDATE  " +
                            "  ventas.ingresos_venta_detalle  " +
                            " SET  " +
                            "  cant_ingreso = ?, " +
                            "  total_monto = ?, " +
                            "  precio_compra = ?, " +
                            "  precio_venta = ?, " +
                            "  sub_total_monto = ?, " +
                            "  cod_estado_registro = ?,"+
                            "  cant_restante= ?, "
                            + "cod_tipo_envase = ?,"
                            + "fecha_fabricacion = "+(!i.getFechaFabricacion().equals("")?"'"+i.getFechaFabricacion()+"'":"null")+","
                            + "fecha_vencimiento = "+(!i.getFechaVencimiento().equals("")?"'"+i.getFechaVencimiento()+"'":"null")+","
                            + "porcentaje_descuento = ? "+                            
                            " WHERE  " +                            
                            " cod_ingreso_venta = ?    " +
                            " and cod_producto = ? ";
            System.out.println("cons "+cons+" " + i.getCantIngreso() + " " + i.getTotalMonto() + " " + i.getTotalMonto() + " " + i.getPrecioCompra() + " " + i.getPrecioVenta() + " " + i.getSubTotalMonto()+" " + i.getEstadosRegistro().getCodEstado()+" " + i.getCantRestante() + " " + i.getIngresosVenta().getCodIngresoVenta()+ " " + i.getProductos().getCodProducto()+" "+i.getFechaFabricacion()+" "+i.getFechaVencimiento());
            PreparedStatement statement = this.con.prepareStatement(cons);
            statement.setDouble(1,i.getCantIngreso());
            statement.setDouble(2,i.getTotalMonto());
            statement.setDouble(3,i.getPrecioCompra());
            statement.setDouble(4,i.getPrecioVenta());
            statement.setDouble(5,i.getSubTotalMonto());
            statement.setInt(6,i.getEstadosRegistro().getCodEstado());
            statement.setDouble(7,i.getCantRestante());
            
            statement.setInt(8,i.getTiposEnvase().getCodTipoEnvase());
            statement.setDouble(9,i.getPorcentajeDescuento());
            //Date fechaFabricacion = sdf.parse(i.getFechaFabricacion());
            //Date fechaVencimiento = sdf.parse(i.getFechaVencimiento());
            
            
            //statement.setTimestamp(9,new Timestamp(fechaFabricacion.getTime()));
            //statement.setTimestamp(10,new Timestamp(fechaVencimiento.getTime()));
            
            statement.setInt(10,i.getIngresosVenta().getCodIngresoVenta());
            statement.setInt(11,i.getProductos().getCodProducto());            
            
            
            guardado = statement.execute()==true?1:0;
            
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
    public  int borraIngresosVentaDetalle(IngresosVentaDetalle c) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " delete from ventas.ingresos_venta_detalle" +
                            " WHERE cod_ingreso_venta='"+c.getIngresosVenta().getCodIngresoVenta()+"' ";
            
            
            
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
    
    public  IngresosVentaDetalle buscarIngresosVentaDetalle(IngresosVentaDetalle i){        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        IngresosVentaDetalle id = new IngresosVentaDetalle();
        
        try {
            List<IngresosVentaDetalle> iadList = this.cargarIngresosVentaDetalle(i.getIngresosVenta());
            for(IngresosVentaDetalle ivd :iadList){
                id = ivd;
                break;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return id;
    }
    
    public  double cantProdVencidos(IngresosVentaDetalle i){
        double cantProdVenc=0.0;
        try {
            Utiles utiles = new Utiles();utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String query = " SELECT count(*) cantidad " +
                                " FROM VENTAS.INGRESOS_VENTA_DETALLE IVD " +
                                " INNER JOIN VENTAS.INGRESOS_VENTA IV ON IVD.COD_INGRESO_VENTA = IV.COD_INGRESO_VENTA " +
                                " INNER JOIN PUBLIC.PRODUCTOS P ON P.COD_PRODUCTO = IVD.COD_PRODUCTO " +
                                " INNER JOIN PUBLIC.ESTADOS_REGISTRO E ON E.COD_ESTADO_REGISTRO = IVD.COD_ESTADO_REGISTRO " +
                                " WHERE IVD.FECHA_VENCIMIENTO <= CURRENT_DATE " +
                                "	AND IV.COD_ALMACEN_VENTA = '"+i.getIngresosVenta().getAlmacenesVenta().getCodAlmacenVenta()+"' " +
                                "	AND IVD.CANT_RESTANTE > 0 " +
                                "	AND IV.COD_GESTION = '"+i.getIngresosVenta().getGestion().getCodGestion()+"'  ";
            
            System.out.println("cons " + query);
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                cantProdVenc = rs.getDouble("cantidad");
            }
            
            statement.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return cantProdVenc;
    }
    
    
    
}
