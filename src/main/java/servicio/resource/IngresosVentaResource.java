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
import javax.naming.InitialContext;
import javax.sql.DataSource;
import servicio.model.Clientes;
import servicio.model.IngresosVenta;
import servicio.model.PlanCuentas;
import servicio.model.ManagedStart;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class IngresosVentaResource extends BeanResource {
    Connection con;
    public IngresosVentaResource(){
    }
    public IngresosVentaResource(Connection con){
        this.con = con;
    }
    
    public  List<IngresosVenta> cargarIngresosVenta(IngresosVenta ia) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        List<IngresosVenta> ingresosVentaList =new ArrayList<IngresosVenta>();
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try {
            
            

            
            String consulta =  " SELECT ia.cod_almacen_venta,ia.cod_ingreso_venta,ia.nro_ingreso_venta,ia.con_iva,nro_factura_proveedor, " +
                                "  ia.fecha_ingreso_venta,  ia.tipo_cambio,  ia.cod_tipo_fuente_pago,tf.nombre_tipo_fuente_pago,  tdi.cod_campo cod_tipo_ingreso_venta,tdi.nombre_campo nombre_tipo_ingreso_venta, " +
                                "  ia.cod_proveedor,pr.nombre_proveedor,  ia.glosa,  ia.cod_personal_autoriza,pe.nombres_personal nombres_personal_autoriza,  ia.cod_personal_recibe,"+
                                "  pe1.nombres_personal nombres_personal_recibe,ia.cod_estado_registro,er.nombre_estado_registro,"+
                                "  ia.cod_orden_compra, ia.cod_gestion,g.nombre_gestion,tde.cod_campo cod_estado_ingreso_venta,tde.nombre_campo nombre_estado_ingreso_venta,ia.cod_libro_compras,"+
                                "  ia.cod_recibo,td.cod_tipo_documento,td.nombre_tipo_documento,rc.nro_recibo,lc.nro_factura " +
                                "  FROM " +
                                "  ventas.ingresos_venta ia " +
                                "  inner join ventas.tabla_detalle tdi on tdi.cod_campo = ia.cod_tipo_ingreso_venta "+
                                "  inner join ventas.tabla ti on tdi.cod_tabla = ti.cod_tabla and ti.nombre_tabla = 'TIPOS_INGRESO_VENTA' " +
                                "  inner join public.estados_registro er on er.cod_estado_registro = ia.cod_estado_registro " +
                                "  inner join ventas.tabla_detalle tde on ia.cod_estado_ingreso_venta = tde.cod_campo " +
                                "  inner join ventas.tabla te on tde.cod_tabla = te.cod_tabla and te.nombre_tabla = 'ESTADOS_INGRESO_VENTA' " +
                                "  left outer join ventas.tipos_fuente_pago tf on tf.cod_tipo_fuente_pago = ia.cod_tipo_fuente_pago " +
                                "  left outer join public.proveedores pr on pr.cod_proveedor = ia.cod_proveedor " +
                                "  left outer join public.personal pe on pe.cod_personal = ia.cod_personal_autoriza " +
                                "  left outer join public.personal pe1 on pe1.cod_personal = ia.cod_personal_recibe " +
                                "  left outer join public.gestiones g on g.cod_gestion = ia.cod_gestion " +
                                "  left outer join public.tipos_documento td on td.cod_tipo_documento = ia.cod_tipo_documento " +
                                "  left outer join cont.recibos_compra rc on rc.cod_recibo = ia.cod_recibo " +
                                "  left outer join cont.libro_compras lc on lc.cod_libro_compras = ia.cod_libro_compras " +
                                " where 0=0 and ia.cod_almacen_venta = '"+ia.getAlmacenesVenta().getCodAlmacenVenta()+"' and ia.cod_gestion = '"+ia.getGestion().getCodGestion()+"'  ";
                    if(ia.getNroIngresoVenta()!=0){consulta+=" AND ia.nro_ingreso_venta = '"+ia.getNroIngresoVenta() +"' ";}
                    if(ia.getAlmacenesVenta().getCodAlmacenVenta() !=0){consulta+=" AND ia.cod_almacen_venta = '"+ia.getAlmacenesVenta().getCodAlmacenVenta()+"' ";}
                    if(!ia.getNroFacturaProveedor().equals("")){consulta+=" AND ia.nro_factura_proveedor = '"+ia.getNroFacturaProveedor()+"' ";}
                    if(ia.getProveedores().getCodProveedor()!=0){consulta+=" AND ia.cod_proveedor = '"+ia.getProveedores().getCodProveedor()+"' ";}
                    if(!ia.getFechaIngresoVentaInicio().equals("") && !ia.getFechaIngresoVentaFinal().equals("")){consulta+=" AND ia.fecha_ingreso_venta between '"+ia.getFechaIngresoVentaInicio()+"' and '"+ia.getFechaIngresoVentaFinal()+"' ";}
                    if(ia.getEstadosIngresoVenta().getCodEstadoIngresoVenta()!=0){consulta+=" AND ia.cod_estado_ingreso_venta = '"+ia.getEstadosIngresoVenta().getCodEstadoIngresoVenta()+"' ";}
                    if(ia.getTiposIngresoVenta().getCodTipoIngresoVenta() !=0){consulta+=" AND ia.cod_tipo_ingreso_venta = '"+ia.getTiposIngresoVenta().getCodTipoIngresoVenta()+"' ";}
                    
                    consulta += " ORDER BY ia.cod_ingreso_venta DESC LIMIT 10 OFFSET "+ia.getFilaInicial()+"  ;";
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            ingresosVentaList.clear();
            while (rs.next())
            {
                IngresosVenta i = new IngresosVenta();
                i.getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                i.setCodIngresoVenta(rs.getInt("cod_ingreso_venta"));
                i.setNroIngresoVenta(rs.getInt("nro_ingreso_venta"));
                i.setConIva(rs.getInt("con_iva"));
                i.setNroFacturaProveedor(rs.getString("nro_factura_proveedor"));
                i.setFechaIngresoVenta(sdf1.format(rs.getTimestamp("fecha_ingreso_venta")));                
                i.setTipoCambio(rs.getDouble("tipo_cambio"));
                i.getTiposFuentePago().setCodTipoFuentePago(rs.getInt("cod_tipo_fuente_pago"));
                i.getTiposFuentePago().setNombreTipoFuentePago(rs.getString("nombre_tipo_fuente_pago"));
                i.getTiposIngresoVenta().setCodTipoIngresoVenta(rs.getInt("cod_tipo_ingreso_venta"));
                i.getTiposIngresoVenta().setNombreTipoIngresoVenta(rs.getString("nombre_tipo_ingreso_venta"));
                i.getProveedores().setCodProveedor(rs.getInt("cod_proveedor"));
                i.getProveedores().setNombreProveedor(rs.getString("nombre_proveedor"));
                i.setGlosa(rs.getString("glosa"));
                i.getPersonalAutoriza().setCodPersonal(rs.getInt("cod_personal_autoriza"));
                i.getPersonalAutoriza().setNombrePersonal(rs.getString("nombres_personal_autoriza"));
                
                i.getPersonalRecibe().setCodPersonal(rs.getInt("cod_personal_recibe"));
                i.getPersonalRecibe().setNombrePersonal(rs.getString("nombres_personal_recibe"));
                i.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                i.getOrdenesCompra().setCodOrdenCompra(rs.getInt("cod_orden_compra"));
                i.getGestion().setCodGestion(rs.getInt("cod_gestion"));
                i.getGestion().setNombreGestion(rs.getString("nombre_gestion"));
                i.getEstadosIngresoVenta().setCodEstadoIngresoVenta(rs.getInt("cod_estado_ingreso_venta"));
                i.getEstadosIngresoVenta().setNombreEstadoIngresoVenta(rs.getString("nombre_estado_ingreso_venta"));
                i.setCodLibroCompras(rs.getInt("cod_libro_compras"));
                i.setCodReciboCompras(rs.getInt("cod_recibo"));
                i.getTiposDocumento().setCodTipoDocumento(rs.getInt("cod_tipo_documento"));
                i.getTiposDocumento().setNombreTipoDocumento(rs.getString("nombre_tipo_documento"));
                i.getLibroCompras().setNroFactura(rs.getString("nro_factura"));
                i.getReciboCompras().setNroRecibo(rs.getString("nro_recibo"));                
                ingresosVentaList.add(i);
            }
            rs.close();
            statement.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return ingresosVentaList;
    }
    public  int codigoIngresosVenta(){
        int codProductoSemiterminado=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select nextval('ventas.\"seqIngresosVenta\"') cod_ingresosVenta";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codProductoSemiterminado = rs.getInt("cod_ingresosVenta");
            }
            
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return codProductoSemiterminado;
    }
    public  int guardarIngresosVenta(IngresosVenta i) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " INSERT INTO  " +
                            "  ventas.ingresos_venta " +
                            "(  cod_almacen_venta,  cod_ingreso_venta,  nro_ingreso_venta,  con_iva,  nro_factura_proveedor,  fecha_ingreso_venta,  tipo_cambio,  cod_tipo_fuente_pago, " +
                            "  cod_tipo_ingreso_venta,  cod_proveedor,  glosa,  cod_personal_autoriza,  cod_personal_recibe,  cod_estado_registro,  cod_gestion,  cod_estado_ingreso_venta, " +
                            "  cod_orden_compra,cod_libro_compras,cod_recibo,cod_tipo_documento) " +
                            "VALUES ( '"+i.getAlmacenesVenta().getCodAlmacenVenta()+"',  '"+i.getCodIngresoVenta()+"',  '"+i.getNroIngresoVenta()+"',  '"+i.getConIva()+"',  '"+i.getNroFacturaProveedor()+"',  '"+i.getFechaIngresoVenta()+"',  '"+i.getTipoCambio()+"',  '"+i.getTiposFuentePago().getCodTipoFuentePago()+"', " +
                            "  '"+i.getTiposIngresoVenta().getCodTipoIngresoVenta()+"',  '"+i.getProveedores().getCodProveedor()+"',  '"+i.getGlosa()+"',  '"+i.getPersonalAutoriza().getCodPersonal()+"',  '"+i.getPersonalRecibe().getCodPersonal()+"',  '"+i.getEstadosRegistro().getCodEstado()+"', "+
                            "  '"+i.getGestion().getCodGestion()+"',  '"+i.getEstadosIngresoVenta().getCodEstadoIngresoVenta()+"',  '"+i.getOrdenesCompra().getCodOrdenCompra()+"','"+i.getCodLibroCompras()+"','"+i.getCodReciboCompras()+"','"+i.getTiposDocumento().getCodTipoDocumento()+"'); ";
            
            
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
    public  int editarIngresosVenta(IngresosVenta i) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE  " +
                            "  ventas.ingresos_venta  " +
                            "  SET  " +
                            "  con_iva = '"+i.getConIva()+"', " +
                            "  nro_factura_proveedor = '"+i.getNroFacturaProveedor()+"', " +
                            "  fecha_ingreso_venta = '"+i.getFechaIngresoVenta()+"', " +
                            "  tipo_cambio = '"+i.getTipoCambio()+"', " +
                            "  cod_tipo_fuente_pago = '"+i.getTiposFuentePago().getCodTipoFuentePago()+"', " +
                            "  cod_tipo_ingreso_venta = '"+i.getTiposIngresoVenta().getCodTipoIngresoVenta()+"', " +
                            "  cod_proveedor = '"+i.getProveedores().getCodProveedor()+"', " +
                            "  glosa = '"+i.getGlosa()+"', " +
                            "  cod_personal_autoriza = '"+i.getPersonalAutoriza().getCodPersonal()+"', " +
                            "  cod_personal_recibe = '"+i.getPersonalRecibe().getCodPersonal()+"', " +
                            "  cod_estado_registro = '"+i.getEstadosRegistro().getCodEstado()+"', " +
                            "  cod_gestion = '"+i.getGestion().getCodGestion()+"', " +
                            "  cod_estado_ingreso_venta = '"+i.getEstadosIngresoVenta().getCodEstadoIngresoVenta()+"', " +
                            "  cod_orden_compra = '"+i.getOrdenesCompra().getCodOrdenCompra()+"',"+
                            "  cod_libro_compras = '"+i.getLibroCompras().getCodLibroCompras()+"'," +
                            "  cod_recibo = '"+i.getReciboCompras().getCodRecibo()+"',"+
                            "  cod_tipo_documento = '"+i.getTiposDocumento().getCodTipoDocumento()+"'" +
                            "  WHERE  cod_almacen_venta = '"+i.getAlmacenesVenta().getCodAlmacenVenta()+"' "+
                            "  and cod_ingreso_venta = '"+i.getCodIngresoVenta()+"' and nro_ingreso_venta = '"+i.getNroIngresoVenta()+"'  ";

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
    
    public  List<SelectItem> cargarIngresosVentaItem() {
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
            //con.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return productosList;
    }
    
    public  int nroIngresoVenta(IngresosVenta ia){
        int nroIngresoAlmacen=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select COALESCE(max(nro_ingreso_venta),0)+1 nro_ingreso_venta from ventas.ingresos_venta i where i.cod_gestion = '"+ia.getGestion().getCodGestion()+"' and i.cod_almacen_venta = '"+ia.getAlmacenesVenta().getCodAlmacenVenta()+"' ";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                nroIngresoAlmacen = rs.getInt("nro_ingreso_venta");
            }
            
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return nroIngresoAlmacen;
    }
    
    public  IngresosVenta buscarIngresosVenta1(IngresosVenta ct) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        IngresosVenta i = new IngresosVenta();
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try {
            
            
            Statement st = utiles.getCon().createStatement();
            String consulta =  " SELECT ia.cod_almacen_venta,ia.cod_ingreso_venta,ia.nro_ingreso_venta,ia.con_iva,nro_factura_proveedor, " +
                                "  ia.fecha_ingreso_venta,  ia.tipo_cambio,  ia.cod_tipo_fuente_pago,tf.nombre_tipo_fuente_pago,  ia.cod_tipo_ingreso_venta,ti.nombre_tipo_ingreso_venta, " +
                                "  ia.cod_proveedor,pr.nombre_proveedor,  ia.glosa,  ia.cod_personal_autoriza,pe.nombres_personal nombre_personal_autoriza,  ia.cod_personal_recibe,"+
                                "  pe1.nombres_personal nombres_personal_recibe,ia.cod_estado_registro,er.nombre_estado_registro,ia.cod_libro_compras,ia.cod_recibo,"+
                                "  td.cod_tipo_documento,td.nombre_tipo_documento,rc.nro_recibo,lc.nro_factura " +
                                "  FROM " +
                                "  ventas.ingresos_venta ia " +
                                "  left outer join ventas.tipos_fuente_pago tf on tf.cod_tipo_fuente_pago = ia.cod_tipo_fuente_pago " +
                                "  left outer join almacenes.tipos_ingreso_venta ti on ti.cod_tipo_ingreso_venta = ia.cod_tipo_ingreso_venta " +
                                "  left outer join public.proveedores pr on pr.cod_proveedor = ia.cod_proveedor " +
                                "  left outer join public.personal pe on pe.cod_personal = ia.cod_personal_autoriza " +
                                "  left outer join public.personal pe1 on pe1.cod_personal = ia.cod_personal_recibe " +
                                "  left outer join public.tipos_documento td on td.cod_tipo_documento = ia.cod_tipo_documento "+
                                "  left outer join cont.recibos_compra rc on rc.cod_recibo = ia.cod_recibo " +
                                "  left outer join cont.libro_compras lc on lc.cod_libro_compras = ia.cod_libro_compras " +
                                "  inner join public.estados_registro er on er.cod_estado_registro = ia.cod_estado_registro " +
                                " where 0=0 and ia.cod_almacen_venta = '"+ct.getAlmacenesVenta().getCodAlmacenVenta()+"' and ia.cod_gestion = '"+ct.getGestion().getCodGestion()+"'  ";
                    if(ct.getEstadosIngresoVenta().getCodEstadoIngresoVenta()!=0){consulta+=" AND ia.cod_estado_ingreso_venta = '"+ct.getEstadosIngresoVenta().getCodEstadoIngresoVenta()+"' ";}
                    if(ct.getNroIngresoVenta()!=0){consulta+=" AND ia.nro_ingreso_venta = '"+ct.getNroIngresoVenta() +"' ";}
                    if(ct.getAlmacenesVenta().getCodAlmacenVenta() !=0){consulta+=" AND ia.cod_almacen_venta = '"+ct.getAlmacenesVenta().getCodAlmacenVenta()+"' ";}
                    if(ct.getCodIngresoVenta() !=0){consulta+=" AND ia.cod_ingreso_venta = '"+ct.getCodIngresoVenta()+"' ";}
                    consulta += " ORDER BY ia.cod_ingreso_venta DESC LIMIT 10 OFFSET "+ct.getFilaInicial()+"  ;";
            
                        
                    
            
            
            System.out.println("cons " + consulta);
            ResultSet rs = st.executeQuery(consulta);
            if(rs.next()){
                i.getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                i.setCodIngresoVenta(rs.getInt("cod_ingreso_venta"));
                i.setNroIngresoVenta(rs.getInt("nro_ingreso_venta"));
                i.setConIva(rs.getInt("con_iva"));
                i.setNroFacturaProveedor(rs.getString("nro_factura_proveedor"));
                i.setFechaIngresoVenta(sdf1.format(rs.getTimestamp("fecha_ingreso_venta")));                
                i.setTipoCambio(rs.getDouble("tipo_cambio"));
                i.getTiposFuentePago().setCodTipoFuentePago(rs.getInt("cod_tipo_fuente_pago"));
                i.getTiposFuentePago().setNombreTipoFuentePago(rs.getString("nombre_tipo_fuente_pago"));
                i.getTiposIngresoVenta().setCodTipoIngresoVenta(rs.getInt("cod_tipo_ingreso_venta"));
                i.getTiposIngresoVenta().setNombreTipoIngresoVenta(rs.getString("nombre_tipo_ingreso_venta"));
                i.getProveedores().setCodProveedor(rs.getInt("cod_proveedor"));
                i.getProveedores().setNombreProveedor(rs.getString("nombre_proveedor"));
                i.setGlosa(rs.getString("glosa"));
                i.getPersonalAutoriza().setCodPersonal(rs.getInt("cod_personal_autoriza"));
                i.getPersonalAutoriza().setNombrePersonal(rs.getString("nombre_personal_autoriza"));
                
                i.getPersonalRecibe().setCodPersonal(rs.getInt("cod_personal_recibe"));
                i.getPersonalRecibe().setNombrePersonal(rs.getString("nombre_personal_recibe"));
                i.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                i.getOrdenesCompra().setCodOrdenCompra(rs.getInt("cod_orden_compra"));
                i.getGestion().setCodGestion(rs.getInt("cod_gestion"));
                i.getGestion().setNombreGestion(rs.getString("nombre_gestion"));
                i.getEstadosIngresoVenta().setCodEstadoIngresoVenta(rs.getInt("cod_estado_ingreso_venta"));
                i.getEstadosIngresoVenta().setNombreEstadoIngresoVenta(rs.getString("nombre_estado_ingreso_venta"));
                i.setCodLibroCompras(rs.getInt("cod_libro_compras"));
                i.setCodReciboCompras(rs.getInt("cod_recibo"));
                i.getTiposDocumento().setCodTipoDocumento(rs.getInt("cod_tipo_documento"));
                i.getTiposDocumento().setNombreTipoDocumento(rs.getString("nombre_tipo_documento"));
                i.getLibroCompras().setNroFactura(rs.getString("nro_factura"));
                i.getReciboCompras().setNroRecibo(rs.getString("nro_recibo"));
            }
            
            st.close();
            //con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        utiles.closeConnection();
        //Utiles.closeConnection();
        return i;
    }
    public  int eliminarIngresosVenta(IngresosVenta i) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   "  delete from  " +
                            "  ventas.ingresos_venta  " +                            
                            "  where cod_ingreso_venta = '"+i.getCodIngresoVenta()+"' and nro_ingreso_venta = '"+i.getNroIngresoVenta()+"'  ";
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
    
    public  IngresosVenta buscarIngresosVenta(IngresosVenta ia) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        IngresosVenta ingresoVenta = new IngresosVenta();
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try {
            
            

            
            String consulta =  " SELECT ia.cod_almacen_venta,ia.cod_ingreso_venta,ia.nro_ingreso_venta,ia.con_iva,nro_factura_proveedor, " +
                                "  ia.fecha_ingreso_venta,  ia.tipo_cambio,  ia.cod_tipo_fuente_pago,tf.nombre_tipo_fuente_pago,  tdi.cod_campo cod_tipo_ingreso_venta,tdi.nombre_campo nombre_tipo_ingreso_venta, " +
                                "  ia.cod_proveedor,pr.nombre_proveedor,  ia.glosa,  ia.cod_personal_autoriza,pe.nombres_personal nombres_personal_autoriza,  ia.cod_personal_recibe,"+
                                "  pe1.nombres_personal nombres_personal_recibe,ia.cod_estado_registro,er.nombre_estado_registro,"+
                                "  ia.cod_orden_compra, ia.cod_gestion,g.nombre_gestion,tde.cod_campo cod_estado_ingreso_venta,tde.nombre_campo nombre_estado_ingreso_venta,ia.cod_libro_compras,"+
                                "  ia.cod_recibo,td.cod_tipo_documento,td.nombre_tipo_documento,rc.nro_recibo,lc.nro_factura " +
                                "  FROM " +
                                "  ventas.ingresos_venta ia " +
                                "  left outer join ventas.tipos_fuente_pago tf on tf.cod_tipo_fuente_pago = ia.cod_tipo_fuente_pago " +
                                "  inner join ventas.tabla_detalle tdi on tdi.cod_campo = ia.cod_tipo_ingreso_venta "+
                                "  inner join ventas.tabla ti on tdi.cod_tabla = ti.cod_tabla and ti.nombre_tabla = 'TIPOS_INGRESO_VENTA' " +
                                "  left outer join public.proveedores pr on pr.cod_proveedor = ia.cod_proveedor " +
                                "  left outer join public.personal pe on pe.cod_personal = ia.cod_personal_autoriza " +
                                "  left outer join public.personal pe1 on pe1.cod_personal = ia.cod_personal_recibe " +
                                "  left outer join public.gestiones g on g.cod_gestion = ia.cod_gestion " +
                                "  left outer join public.tipos_documento td on td.cod_tipo_documento = ia.cod_tipo_documento " +
                                "  left outer join cont.recibos_compra rc on rc.cod_recibo = ia.cod_recibo " +
                                "  left outer join cont.libro_compras lc on lc.cod_libro_compras = ia.cod_libro_compras " +
                                "  inner join public.estados_registro er on er.cod_estado_registro = ia.cod_estado_registro " +
                                "  left outer join ventas.tabla_detalle tde on ia.cod_estado_ingreso_venta = tde.cod_campo " +
                                "  inner join ventas.tabla te on tde.cod_tabla = te.cod_tabla and te.nombre_tabla = 'ESTADOS_INGRESO_VENTA' " +
                    
                                " where 0=0 and ia.cod_almacen_venta = '"+ia.getAlmacenesVenta().getCodAlmacenVenta()+"' and ia.cod_gestion = '"+ia.getGestion().getCodGestion()+"'  ";
                    if(ia.getNroIngresoVenta()!=0){consulta+=" AND ia.nro_ingreso_venta = '"+ia.getNroIngresoVenta() +"' ";}
                    if(ia.getAlmacenesVenta().getCodAlmacenVenta() !=0){consulta+=" AND ia.cod_almacen_venta = '"+ia.getAlmacenesVenta().getCodAlmacenVenta()+"' ";}
                    if(!ia.getNroFacturaProveedor().equals("")){consulta+=" AND ia.nro_factura_proveedor = '"+ia.getNroFacturaProveedor()+"' ";}                    
                    if(ia.getEstadosIngresoVenta().getCodEstadoIngresoVenta()!=0){consulta+=" AND ia.cod_estado_ingreso_venta = '"+ia.getEstadosIngresoVenta().getCodEstadoIngresoVenta()+"' ";}
                    
                    consulta += " ORDER BY ia.cod_ingreso_venta DESC LIMIT 10 OFFSET "+ia.getFilaInicial()+"  ;";
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
            {
                
                ingresoVenta.getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                ingresoVenta.setCodIngresoVenta(rs.getInt("cod_ingreso_venta"));
                ingresoVenta.setNroIngresoVenta(rs.getInt("nro_ingreso_venta"));
                ingresoVenta.setConIva(rs.getInt("con_iva"));
                ingresoVenta.setNroFacturaProveedor(rs.getString("nro_factura_proveedor"));
                ingresoVenta.setFechaIngresoVenta(sdf1.format(rs.getTimestamp("fecha_ingreso_venta")));                
                ingresoVenta.setTipoCambio(rs.getDouble("tipo_cambio"));
                ingresoVenta.getTiposFuentePago().setCodTipoFuentePago(rs.getInt("cod_tipo_fuente_pago"));
                ingresoVenta.getTiposFuentePago().setNombreTipoFuentePago(rs.getString("nombre_tipo_fuente_pago"));
                ingresoVenta.getTiposIngresoVenta().setCodTipoIngresoVenta(rs.getInt("cod_tipo_ingreso_venta"));
                ingresoVenta.getTiposIngresoVenta().setNombreTipoIngresoVenta(rs.getString("nombre_tipo_ingreso_venta"));
                ingresoVenta.getProveedores().setCodProveedor(rs.getInt("cod_proveedor"));
                ingresoVenta.getProveedores().setNombreProveedor(rs.getString("nombre_proveedor"));
                ingresoVenta.setGlosa(rs.getString("glosa"));
                ingresoVenta.getPersonalAutoriza().setCodPersonal(rs.getInt("cod_personal_autoriza"));
                ingresoVenta.getPersonalAutoriza().setNombrePersonal(rs.getString("nombres_personal_autoriza"));
                
                ingresoVenta.getPersonalRecibe().setCodPersonal(rs.getInt("cod_personal_recibe"));
                ingresoVenta.getPersonalRecibe().setNombrePersonal(rs.getString("nombres_personal_recibe"));
                ingresoVenta.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                ingresoVenta.getOrdenesCompra().setCodOrdenCompra(rs.getInt("cod_orden_compra"));
                ingresoVenta.getGestion().setCodGestion(rs.getInt("cod_gestion"));
                ingresoVenta.getGestion().setNombreGestion(rs.getString("nombre_gestion"));
                ingresoVenta.getEstadosIngresoVenta().setCodEstadoIngresoVenta(rs.getInt("cod_estado_ingreso_venta"));
                ingresoVenta.getEstadosIngresoVenta().setNombreEstadoIngresoVenta(rs.getString("nombre_estado_ingreso_venta"));
                ingresoVenta.setCodLibroCompras(rs.getInt("cod_libro_compras"));
                ingresoVenta.setCodReciboCompras(rs.getInt("cod_recibo"));
                ingresoVenta.getTiposDocumento().setCodTipoDocumento(rs.getInt("cod_tipo_documento"));
                ingresoVenta.getTiposDocumento().setNombreTipoDocumento(rs.getString("nombre_tipo_documento"));
                ingresoVenta.getLibroCompras().setNroFactura(rs.getString("nro_factura"));
                ingresoVenta.getReciboCompras().setNroRecibo(rs.getString("nro_recibo"));                
  
            }
            rs.close();
            statement.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        utiles.closeConnection();
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return ingresoVenta;
    }

    
    
}
