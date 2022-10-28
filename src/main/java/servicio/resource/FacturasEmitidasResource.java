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
import java.util.Date;
import java.util.List;
import servicio.model.SelectItem;
import servicio.busines.SalidasVentaBusinesManager;
import servicio.model.FacturaDosificacion;
import servicio.model.FacturasEmitidas;
import servicio.model.SalidasVenta;
import servicio.model.SalidasVentaBusiness;
import servicio.model.SalidasVentaDetalle;
import servicio.model.SalidasVentaDetalleIngreso;
import servicio.util.Utiles;
import servicio.util.codigocontrol.ControlCode;

/**
 *
 * @author henry
 */
public class FacturasEmitidasResource extends BeanResource {
    Connection con;
    public FacturasEmitidasResource(){
    }
    public FacturasEmitidasResource(Connection con){
        this.con = con;
    }
    
    public  List<FacturasEmitidas> cargarFacturasEmitidas(FacturasEmitidas f) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        List<FacturasEmitidas> facturasEmitidasList =new ArrayList<FacturasEmitidas>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String consulta =   " SELECT f.cod_factura_emitida,f.nro_factura,f.razon_social,f.nit_cliente,f.nro_autorizacion, " +
                                "  f.fecha_factura,f.monto_sub_total,f.monto_descuento,f.monto_total,f.codigo_control, " +
                                "  f.cod_dosificacion,e.cod_estado_registro,e.nombre_estado_registro,monto_iva,f.cod_salida_venta " +
                                " FROM " +
                                "  ventas.facturas_emitidas f inner join public.estados_registro e " +
                                "  on e.cod_estado_registro = f.cod_estado_registro  " +
                                " where 0=0   ";                    
            consulta += " ORDER BY f.cod_factura_emitida DESC LIMIT 10 OFFSET "+f.getFilaInicial()+"  ;";
            
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            facturasEmitidasList.clear();
            while (rs.next())
            {
                FacturasEmitidas f1 = new FacturasEmitidas();
                f1.setCodFacturaEmitida(rs.getInt("cod_factura_emitida"));
                f1.setNroFactura(rs.getInt("nro_factura"));
                f1.setRazonSocial(rs.getString("razon_social"));
                f1.setNitCliente(rs.getString("nit_cliente"));
                f1.setNroAutorizacion(rs.getString("nro_autorizacion"));
                f1.setFechaFactura(sdf.format(rs.getTimestamp("fecha_factura")));
                f1.setMontoSubTotal(rs.getDouble("monto_sub_total"));
                f1.setMontoDescuento(rs.getDouble("monto_descuento"));
                f1.setMontoTotal(rs.getDouble("monto_total"));
                f1.setCodigoControl(rs.getString("codigo_control"));
                f1.getFacturaDosificacion().setCodDosificacion(rs.getInt("cod_dosificacion"));
                f1.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                f1.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                f1.setMontoIva(rs.getDouble("monto_iva"));
                f1.getSalidasVenta().setCodSalidaVenta(rs.getInt("cod_salida_venta"));
                
                
                
                facturasEmitidasList.add(f1);
                
            }
            rs.close();
            statement.close();
            utiles.closeConnection();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return facturasEmitidasList;
    }
    public  int codigoFacturasEmitidas(){
        int codigo=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select nextval('ventas.\"seqFacturasEmitidas\"') cod_facturaEmitida";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codigo = rs.getInt("cod_facturaEmitida");
            }
            
            statement.close();
            utiles.closeConnection();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return codigo;
    }
    public  FacturasEmitidas guardarFacturasEmitidas(FacturasEmitidas f) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            f.setCodFacturaEmitida(this.codigoFacturasEmitidas());
            //Utiles utiles = new Utiles();
            //utiles.getConnection();
            Statement statement = this.con.createStatement();
            String cons = "  INSERT INTO ventas.facturas_emitidas( " +
                            "  cod_factura_emitida, nro_factura,  razon_social,  nit_cliente,  nro_autorizacion,  fecha_factura, " +
                            "  monto_sub_total,  monto_descuento,  monto_total,  codigo_control,  cod_dosificacion,  cod_estado_registro, " +
                            "  cod_salida_venta,monto_iva) " +
                            "VALUES ( '"+f.getCodFacturaEmitida()+"' , '"+f.getNroFactura()+"',  '"+f.getRazonSocial()+"',  '"+f.getNitCliente()+"',  '"+f.getFechaFactura()+"', " +
                            "  '"+f.getFechaFactura()+"',  '"+f.getMontoSubTotal()+"',  '"+f.getMontoDescuento()+"',  '"+f.getMontoTotal()+"',  '"+f.getCodigoControl()+"', " +
                            "  '"+f.getFacturaDosificacion().getCodDosificacion()+"',  '"+f.getEstadosRegistro().getCodEstado()+"',  '"+f.getSalidasVenta().getCodSalidaVenta()+"','"+f.getMontoIva()+"'); ";
            
            
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
        return f;
    }
    public  FacturasEmitidas editarFacturasEmitidas(FacturasEmitidas f) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE  " +
                            "  ventas.facturas_emitidas  " +
                            "  SET  " +
                            "  nro_factura = '"+f.getNroFactura()+"', " +
                            "  razon_social = '"+f.getRazonSocial()+"', " +
                            "  nit_cliente = '"+f.getNitCliente()+"', " +
                            "  nro_autorizacion = '"+f.getNroAutorizacion()+"', " +
                            "  fecha_factura = "+(!f.getFechaFactura().equals("")?"'"+f.getFechaFactura()+"'":"null")+", " +
                            "  monto_sub_total = '"+f.getMontoSubTotal()+"', " +
                            "  monto_descuento = '"+f.getMontoDescuento()+"', " +
                            "  monto_total = '"+f.getMontoTotal()+"', " +
                            "  codigo_control = '"+f.getCodigoControl()+"', " +
                            "  cod_dosificacion = '"+f.getFacturaDosificacion().getCodDosificacion()+"', " +
                            "  cod_estado_registro = '"+f.getEstadosRegistro().getCodEstado()+"', " +
                            "  cod_salida_venta = '"+f.getSalidasVenta().getCodSalidaVenta()+"', " +
                            "  monto_iva = '"+f.getMontoIva()+"' " +
                            "  WHERE  " +
                            "  cod_factura_emitida = '"+f.getCodFacturaEmitida()+"'  ";

            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            //utiles.closeConnection();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error en editarFacturasEmitidas");
        }
        //Utiles.closeConnection();
        return f;
    }
    
    public  List<SelectItem> cargarFacturasEmitidasItem() {
        List<SelectItem> productosList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
                
            
            String query = " select c.cod_ingresos_almacen,c.nro_ingreso_almacen from ingresos_almacen c order by cod_ingreso_almacen ";
                           
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            productosList.clear();
            while (rs.next())
            {
                productosList.add(new SelectItem(rs.getInt("cod_ingresos_almacen"), rs.getString("nro_ingreso_almacen")));
            }
            rs.close();
            //con.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return productosList;
    }
    

    public  FacturasEmitidas buscarFacturasEmitidas(FacturasEmitidas f){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        FacturasEmitidas f1 = new FacturasEmitidas();
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            
            String consulta =   " SELECT f.cod_factura_emitida,f.nro_factura,f.razon_social,f.nit_cliente,f.nro_autorizacion, " +
                                "  f.fecha_factura,f.monto_sub_total,f.monto_descuento,f.monto_total,f.codigo_control, " +
                                "  f.cod_dosificacion,e.cod_estado_registro,e.nombre_estado_registro,f.monto_iva " +
                                " FROM " +
                                "  ventas.facturas_emitidas f inner join public.estados_registro e " +
                                "  on e.cod_estado_registro = f.cod_estado_registro  " +
                                " where 0=0   ";                                
            if(f.getCodFacturaEmitida()!=0){consulta+=" AND f.cod_factura_emitida = '"+f.getCodFacturaEmitida() +"' ";}
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
            {
                
                f1.setCodFacturaEmitida(rs.getInt("cod_factura_emitida"));
                f1.setNroFactura(rs.getInt("nro_factura"));
                f1.setRazonSocial(rs.getString("razon_social"));
                f1.setNitCliente(rs.getString("nit_cliente"));
                f1.setNroAutorizacion(rs.getString("nro_autorizacion"));
                f1.setFechaFactura(sdf.format(rs.getTimestamp("fecha_factura")));
                f1.setMontoSubTotal(rs.getDouble("monto_sub_total"));
                f1.setMontoDescuento(rs.getDouble("monto_descuento"));
                f1.setMontoTotal(rs.getDouble("monto_total"));
                f1.setCodigoControl(rs.getString("codigo_control"));
                f1.getFacturaDosificacion().setCodDosificacion(rs.getInt("cod_dosificacion"));
                f1.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                f1.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                f1.setMontoIva(rs.getDouble("monto_iva"));
                
            }
            rs.close();
            statement.close();
            utiles.closeConnection();
            //con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return f1;
    }
    public  int eliminarFacturasEmitidas(FacturasEmitidas f) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   "  delete from  " +
                            "  ventas.facturas_emitidas  " +                            
                            "  where cod_factura_emitida = '"+f.getCodFacturaEmitida()+"'  ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            //utiles.closeConnection();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error en eliminarFacturasEmitidas");
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int nroFactura(SalidasVenta sa){
        int nroFactura=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select COALESCE(max(f.nro_factura),0)+1 nro_factura  " +
                            "from ventas.facturas_emitidas f  " +
                            "inner join ventas.salidas_venta s on f.cod_salida_venta = s.cod_salida_venta " +
                            "where s.cod_gestion = '"+sa.getGestion().getCodGestion()+"' and s.cod_almacen_venta = '"+sa.getAlmacenesVenta().getCodAlmacenVenta()+"' ";//tiene que ser por tipo documento
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                nroFactura = rs.getInt("nro_factura");
            }
            
            statement.close();
            utiles.closeConnection();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return nroFactura;
    }
    public  FacturasEmitidas generarFactura(SalidasVenta sa) throws Exception{
        
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); //yyyy/MM/dd HH:mm:ss
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        FacturasEmitidas f = new FacturasEmitidas();
        FacturaDosificacionResource fdr = new FacturaDosificacionResource();
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource();
        try {
            //buscamos la emision activa
            FacturaDosificacion fd = new FacturaDosificacion();
            fd.getEstadosRegistro().setCodEstado(1);
            fd.setSucursalVentas(sa.getAlmacenesVenta().getSucursalVentas());
            fd = fdr.buscarFacturaDosificacion(fd);//buscamos la dosificacion activa con la sucursal y gestion
            
            //colocamos los datos a la emision de factura
            f.setNroFactura(nroFactura(sa));//se genera el numero de factura con almacen y gestion
            f.setRazonSocial(sa.getClientes().getNombreCliente());
            f.setNitCliente(sa.getClientes().getNitCliente());
            f.setNroAutorizacion(fd.getNroAutorizacion());
            f.setFacturaDosificacion(fd);
            f.setFechaFactura(sdf.format(new Date()));
            
            SalidasVentaDetalle sd = new SalidasVentaDetalle();
            sd.setSalidasVenta(sa);
            sd= svdr.subTotalSalidaVentaDetalle(sd);
            f.setMontoSubTotal(sd.getMontoSubTotal());
            f.setMontoDescuento(sd.getMontoDescuento());
            f.setMontoTotal(sa.getMontoTotal());//sd.getMontoTotal() aun no esta en base de datos por eso se deduce del mismo objeto detalle
            ControlCode controlCode = new ControlCode();
            f.setCodigoControl(controlCode.generate(f.getNroAutorizacion(), String.valueOf(f.getNroFactura()), f.getNitCliente(), f.getFechaFactura(), f.getMontoTotal().toString(), f.getFacturaDosificacion().getLlaveDosificacion()));
            
            f.getEstadosRegistro().setCodEstado(1);
            f.setSalidasVenta(sa);
            f.setMontoIva(f.getMontoTotal()*0.13f);
            f = this.guardarFacturasEmitidas(f);
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
            f.getError().setCodError(1);
            f.getError().setDescrError(ex.getMessage());
            //throw new Exception(ex.getMessage());
        }
        
        //Utiles.setAutoCommit(true);
        
        return f;
    }
    public  FacturasEmitidas editarFactura(FacturasEmitidas f,SalidasVenta sa) throws Exception{
        
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); //yyyy/MM/dd HH:mm:ss
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        
        
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource();
        try {
            //buscamos la emision activa
            
            
            
            
            //colocamos los datos a la emision de factura
            f.setNroFactura(nroFactura(sa));//se genera el numero de factura con almacen y gestion
            f.setRazonSocial(sa.getClientes().getNombreCliente());
            f.setNitCliente(sa.getClientes().getNitCliente());
            
            
            f.setFechaFactura(sdf.format(new Date()));
            
            SalidasVentaDetalle sd = new SalidasVentaDetalle();
            sd.setSalidasVenta(sa);
            sd= svdr.subTotalSalidaVentaDetalle(sd);
            f.setMontoSubTotal(sd.getMontoSubTotal());
            f.setMontoDescuento(sd.getMontoDescuento());
            f.setMontoTotal(sd.getMontoTotal());
            
            f.getEstadosRegistro().setCodEstado(1);
            f.setSalidasVenta(sa);
            f.setMontoIva(f.getMontoTotal()*0.13f);
            f = this.editarFacturasEmitidas(f);
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
            f.getError().setCodError(1);
            f.getError().setDescrError(ex.getMessage());
            //throw new Exception(ex.getMessage());
        }
        
        //Utiles.setAutoCommit(true);
        
        return f;
    }
    public  SalidasVentaBusiness guardarFacturaEmitidaBusiness(SalidasVentaBusiness s) throws Exception {
        
        
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource(this.con);
        SalidasVentaResource svr = new SalidasVentaResource(this.con);
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource(this.con);
        FacturasEmitidasResource femr = new FacturasEmitidasResource(this.con);
        SalidasVentaDetalleIngresoResource ivdir = new SalidasVentaDetalleIngresoResource(this.con);        
        SalidasVentaBusiness svb = new SalidasVentaBusiness();
        double montoTotal = 0.0;
        
        try {
            s.getSalidasVenta().setCodSalidaVenta(svr.codigoSalidasVenta());
            s.getSalidasVenta().setNroSalidaVenta(svr.nroSalidaVenta(s.getSalidasVenta()));
            svr.guardarSalidasVenta(s.getSalidasVenta());
                
        for(SalidasVentaDetalle sd:s.getSalidasVentaDetalleList()){
            sd.setSalidasVenta(s.getSalidasVenta());
            svdr.guardarSalidasVentaDetalle(sd);
            montoTotal+=sd.getMontoTotal();
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
        s.getSalidasVenta().setMontoTotal(montoTotal);
        femr.generarFactura(s.getSalidasVenta());        
        svb = s;
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        
        }
        
        return svb;
    }
    public  SalidasVentaBusiness editarFacturaEmitidaBusiness(SalidasVentaBusiness s) throws Exception {
        
        
        SalidasVentaDetalleResource svdr = new SalidasVentaDetalleResource(this.con);
        SalidasVentaResource svr = new SalidasVentaResource(this.con);
        IngresosVentaDetalleResource ivdr = new IngresosVentaDetalleResource(this.con);
        FacturasEmitidasResource femr = new FacturasEmitidasResource(this.con);
        SalidasVentaDetalleIngresoResource ivdir = new SalidasVentaDetalleIngresoResource(this.con);        
        SalidasVentaBusiness svb = new SalidasVentaBusiness();
        SalidasVentaBusinesManager svbm = new SalidasVentaBusinesManager(this.con);
        
        try {
            //buscar la factura y editarla
            svbm.editarSalidasVentaBusiness(s);
            FacturasEmitidas fm = new FacturasEmitidas();
            fm.setCodFacturaEmitida(s.getSalidasVenta().getCodFacturaEmitida());
            fm = femr.buscarFacturasEmitidas(fm);
            femr.editarFactura(fm,s.getSalidasVenta());
            svb = s;
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        
        }
        
        return s;
    }
    
    
    
    
    

    
    
}
