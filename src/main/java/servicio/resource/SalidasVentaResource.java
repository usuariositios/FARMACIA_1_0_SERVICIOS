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
import servicio.model.SalidasVenta;
import servicio.model.ManagedStart;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class SalidasVentaResource extends BeanResource {
    Connection con;
    public SalidasVentaResource(){
    }
    public SalidasVentaResource(Connection con){
        this.con = con;
    }
    
    public  List<SalidasVenta> cargarSalidasVenta(SalidasVenta sa) throws Exception {
        List<SalidasVenta> salidasVentaList =new ArrayList<SalidasVenta>();
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
            
            
                    
                    String consulta =   "  SELECT s.cod_salida_venta, a.cod_almacen_venta,a.nombre_almacen_venta,  s.cod_gestion,g.nombre_gestion,  s.nro_salida_venta,  s.nro_documento,  s.fecha_salida_venta," +
                                        "  s.tipo_cambio,  s.cod_tipo_salida_venta,t.nombre_tipo_salida_venta,  s.cod_cliente,c.nombre_cliente,c.nit_cliente,  s.cod_personal_autoriza,p.nombres_personal nombre_personal_autoriza,  s.cod_personal_recibe,p2.nombres_personal nombre_personal_recibe," +
                                        "  s.glosa,s.cod_estado_salida_venta, e.nombre_estado_salida_venta,td.cod_tipo_descuento, td.nombre_tipo_descuento, "+
                                        "  f.cod_factura_emitida,f.nro_factura,f.venta_cancelada " +
                                        "  FROM" +
                                        "  ventas.salidas_venta s" +
                                        "  left outer join ventas.almacenes_venta a on a.cod_almacen_venta = s.cod_almacen_venta" +
                                        "  left outer join public.gestiones g on g.cod_gestion = s.cod_gestion" +
                                        "  left outer join ventas.tipos_salida_venta t on t.cod_tipo_salida_venta = s.cod_tipo_salida_venta" +
                                        "  left outer join public.clientes c on c.cod_cliente = s.cod_cliente" +
                                        "  left outer join public.personal p on p.cod_personal = s.cod_personal_autoriza" +
                                        "  left outer join public.personal p2 on p2.cod_personal = s.cod_personal_recibe" +
                                        "  left outer join ventas.estados_salidas_venta e on e.cod_estado_salida_venta = s.cod_estado_salida_venta "+
                                        "  left outer join ventas.tipos_descuento td on td.cod_tipo_descuento = c.cod_tipo_descuento "+
                                        "  left outer join ventas.facturas_emitidas f on f.cod_salida_venta = s.cod_salida_venta and f.cod_estado_registro = 1 "
                                        + " where 0=0 and s.cod_almacen_venta = '"+sa.getAlmacenesVenta().getCodAlmacenVenta()+"' and s.cod_gestion = '"+sa.getGestion().getCodGestion()+"'  "
                                        + " ORDER BY s.cod_salida_venta DESC LIMIT 10 OFFSET "+sa.getFilaInicial()+"  ;";
                                        
            consulta =  " SELECT " +
                        "        s.cod_salida_venta                         , tda.cod_almacen_venta            , tda.nombre_almacen_venta      , " +
                        "        s.cod_gestion                              ,  g.nombre_gestion                           ,  s.nro_salida_venta                         , " +
                        "        s.nro_documento                            , s.fecha_salida_venta                       ,   s.tipo_cambio                              , " +
                        "        tds.cod_campo cod_tipo_salida_venta                    , tds.nombre_campo nombre_tipo_salida_venta                 ,   s.cod_cliente                              , " +
                        "        c.nombre_cliente                           ,  c.nit_cliente                              ,  s.cod_personal_autoriza                    , " +
                        "        p.nombres_personal nombre_personal_autoriza,  s.cod_personal_recibe                      ,  p2.nombres_personal nombre_personal_recibe , " +
                        "        s.glosa                                    ,  tde.cod_campo cod_estado_salida_venta                  ,  tde.nombre_campo nombre_estado_salida_venta               , " +
                        "        td.cod_tipo_descuento                      ,  td.nombre_tipo_descuento                   ,    f.cod_factura_emitida                      , " +
                        "        f.nro_factura,s.cod_personal_venta,s.cod_tipo_venta,tdv.nombre_campo nombre_tipo_venta,s.cod_tipo_pago,s.fecha_pago_credito,s.monto_sub_total,"+
                        "        s.monto_descuento,s.monto_total,s.monto_cancelado,s.monto_amortizado,s.monto_por_cobrar,s.venta_completa,td1.cod_tipo_documento,td1.nombre_tipo_documento,s.cod_libro_ventas " +
                        "FROM " +                        
                        " ventas.salidas_venta s " +
                        " inner join ventas.almacenes_venta tda ON  tda.cod_almacen_venta = s.cod_almacen_venta  " +                        
                        "inner join ventas.tabla_detalle tds ON  tds.cod_campo = s.cod_tipo_salida_venta " +
                        "INNER JOIN ventas.tabla ts ON tds.cod_tabla   = ts.cod_tabla AND     ts.nombre_tabla = 'TIPOS_SALIDA_VENTA' " +
                        "inner join ventas.tabla_detalle tde ON  tde.cod_campo = s.cod_estado_salida_venta " +
                        "INNER JOIN ventas.tabla te ON tde.cod_tabla   = te.cod_tabla AND     te.nombre_tabla = 'ESTADOS_SALIDA_VENTA' " +
                        "inner join ventas.tabla_detalle tdv ON  tdv.cod_campo = s.cod_tipo_venta " +
                        "INNER JOIN ventas.tabla tv ON tdv.cod_tabla   = tv.cod_tabla AND     tv.nombre_tabla = 'TIPOS_VENTA' " +
                        "LEFT OUTER JOIN public.gestiones g ON g.cod_gestion = s.cod_gestion " +
                        "LEFT OUTER JOIN public.clientes c ON c.cod_cliente = s.cod_cliente " +
                        "LEFT OUTER JOIN public.personal p ON p.cod_personal = s.cod_personal_autoriza " +
                        "LEFT OUTER JOIN public.personal p2 ON p2.cod_personal = s.cod_personal_recibe " +
                        "LEFT OUTER JOIN ventas.tipos_descuento td ON td.cod_tipo_descuento = c.cod_tipo_descuento " +
                        "LEFT OUTER JOIN ventas.facturas_emitidas f ON f.cod_salida_venta    = s.cod_salida_venta AND     f.cod_estado_registro = 1 " +
                        "LEFT OUTER JOIN public.tipos_documento td1 ON td1.cod_tipo_documento = s.cod_tipo_documento "+
                        "WHERE 0=0 " +
                        "AND     s.cod_almacen_venta = '"+sa.getAlmacenesVenta().getCodAlmacenVenta()+"' " +
                        "AND     s.cod_gestion       = '"+sa.getGestion().getCodGestion()+"' ";
                        if(sa.getNroSalidaVenta()!=0){consulta+=" AND s.nro_salida_venta = '"+sa.getNroSalidaVenta() +"' ";}
                        if(sa.getNroFactura()!=0){consulta+=" AND f.nro_factura = '"+sa.getNroFactura() +"' ";}
                        if(sa.getClientes().getCodCliente()!=0){consulta+=" AND s.cod_cliente = '"+sa.getClientes().getCodCliente() +"' ";}
                        if(sa.getEstadosSalidaVenta().getCodEstadoSalidaVenta()!=0){consulta+=" AND s.cod_estado_salida_venta = '"+sa.getEstadosSalidaVenta().getCodEstadoSalidaVenta() +"' ";}
                        if(sa.getVentaCompleta()!=0){consulta+=" AND s.venta_completa = '"+sa.getVentaCompleta() +"' ";}
                        if(sa.getConFacturaEmitida()!=0){consulta+=" AND f.cod_factura_emitida > 0 ";}
                        if(!sa.getFechaSalidaVentaInicio().equals("") && !sa.getFechaSalidaVentaFinal().equals("")){consulta+=" AND s.fecha_salida_venta between '"+sa.getFechaSalidaVentaInicio()+"' and '"+sa.getFechaSalidaVentaFinal()+"' ";}
                        consulta +="ORDER BY s.cod_salida_venta DESC LIMIT 10 OFFSET "+sa.getFilaInicial()+"  ";
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            salidasVentaList.clear();
            while (rs.next())
            {
                SalidasVenta s = new SalidasVenta();
                
                s.setCodSalidaVenta(rs.getInt("cod_salida_venta"));
                s.getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                s.getAlmacenesVenta().setNombreAlmacenVenta(rs.getString("nombre_almacen_venta"));
                s.getGestion().setCodGestion(rs.getInt("cod_gestion"));
                s.getGestion().setNombreGestion(rs.getString("nombre_gestion"));                
                s.setNroSalidaVenta(rs.getInt("nro_salida_venta"));
                s.setNroDocumento(rs.getInt("nro_documento"));
                s.setFechaSalidaVenta(sdf.format(rs.getTimestamp("fecha_salida_venta")));
                s.setTipoCambio(rs.getDouble("tipo_cambio"));
                s.getTiposSalidaVenta().setCodTipoSalidaVenta(rs.getInt("cod_tipo_salida_venta"));
                s.getTiposSalidaVenta().setNombreTipoSalidaVenta(rs.getString("nombre_tipo_salida_venta"));
                s.getClientes().setCodCliente(rs.getInt("cod_cliente"));
                s.getClientes().setNombreCliente(rs.getString("nombre_cliente"));
                s.getClientes().setNitCliente(rs.getString("nit_cliente"));
                s.getPersonalAutoriza().setCodPersonal(rs.getInt("cod_personal_autoriza"));
                s.getPersonalAutoriza().setNombrePersonal(rs.getString("nombre_personal_autoriza"));
                s.getPersonalRecibe().setCodPersonal(rs.getInt("cod_personal_recibe"));
                s.getPersonalRecibe().setNombrePersonal(rs.getString("nombre_personal_recibe"));
                s.setGlosa(rs.getString("glosa"));
                s.getEstadosSalidaVenta().setCodEstadoSalidaVenta(rs.getInt("cod_estado_salida_venta"));
                s.getEstadosSalidaVenta().setNombreEstadoSalidaVenta(rs.getString("nombre_estado_salida_venta"));
                s.getClientes().getTiposDescuento().setCodTipoDescuento(rs.getInt("cod_tipo_descuento"));
                s.getClientes().getTiposDescuento().setNombreTipoDescuento(rs.getString("nombre_tipo_descuento"));
                s.setCodFacturaEmitida(rs.getInt("cod_factura_emitida"));
                s.setNroFactura(rs.getInt("nro_factura"));
                
                s.getPersonalVenta().setCodPersonal(rs.getInt("cod_personal_venta"));
                s.getTiposVenta().setCodTipoVenta(rs.getInt("cod_tipo_venta"));
                s.getTiposVenta().setNombreTipoVenta(rs.getString("nombre_tipo_venta"));
                s.getTiposPago().setCodTipoPago(rs.getInt("cod_tipo_pago"));
                s.setFechaPagoCredito(rs.getTimestamp("fecha_pago_credito")!=null?sdf.format(rs.getTimestamp("fecha_pago_credito")):"");
                s.setMontoSubTotal(rs.getDouble("monto_sub_total"));
                s.setMontoDescuento(rs.getDouble("monto_descuento"));
                s.setMontoTotal(rs.getDouble("monto_total"));
                s.setMontoCancelado(rs.getDouble("monto_cancelado"));
                s.setMontoAmortizado(rs.getDouble("monto_amortizado"));
                s.setMontoPorCobrar(rs.getDouble("monto_por_cobrar"));
                s.setVentaCompleta(rs.getInt("venta_completa"));
                s.getTiposDocumento().setCodTipoDocumento(rs.getInt("cod_tipo_documento"));
                s.getTiposDocumento().setNombreTipoDocumento(rs.getString("nombre_tipo_documento"));
                s.getLibroVentas().setCodLibroVentas(rs.getInt("cod_libro_ventas"));
                
                
                salidasVentaList.add(s);
                
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
        return salidasVentaList;
    }
    public  int codigoSalidasVenta(){
        int codSalidaAlmacen=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select nextval('ventas.\"seqSalidasVenta\"') cod_salidaVenta";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codSalidaAlmacen = rs.getInt("cod_salidaVenta");
            }
            
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return codSalidaAlmacen;
    }
    public  int guardarSalidasVenta(SalidasVenta s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = "   INSERT INTO  " +
                            "  ventas.salidas_venta " +
                            "(  cod_salida_venta,  cod_almacen_venta,  cod_gestion,  nro_salida_venta,  nro_documento,  fecha_salida_venta,  tipo_cambio, " +
                            "  cod_tipo_salida_venta,  cod_cliente,  cod_personal_autoriza,  cod_personal_recibe,  glosa,  cod_estado_salida_venta,"+
                            "  cod_personal_venta,cod_tipo_venta,cod_tipo_pago,fecha_pago_credito,monto_sub_total,monto_descuento,monto_total,monto_cancelado,"+
                            "  monto_amortizado,monto_por_cobrar,venta_completa,cod_tipo_documento,cod_libro_ventas) " +
                            "VALUES (  '"+s.getCodSalidaVenta()+"',  '"+s.getAlmacenesVenta().getCodAlmacenVenta()+"',  '"+s.getGestion().getCodGestion()+"',  '"+s.getNroSalidaVenta()+"',  '"+s.getNroDocumento()+"',  '"+s.getFechaSalidaVenta()+"', " +
                                    "  '"+s.getTipoCambio()+"',  '"+s.getTiposSalidaVenta().getCodTipoSalidaVenta()+"',  '"+s.getClientes().getCodCliente()+"',  '"+s.getPersonalAutoriza().getCodPersonal()+"',  '"+s.getPersonalRecibe().getCodPersonal()+"',  '"+s.getGlosa()+"',  '"+s.getEstadosSalidaVenta().getCodEstadoSalidaVenta()+"',"+
                                    "  '"+s.getPersonalVenta().getCodPersonal()+"','"+s.getTiposVenta().getCodTipoVenta()+"','"+s.getTiposPago().getCodTipoPago()+"','"+s.getFechaPagoCredito()+"','"+s.getMontoSubTotal()+"','"+s.getMontoDescuento()+"','"+s.getMontoTotal()+"','"+s.getMontoCancelado()+"','"+s.getMontoAmortizado()+"',"+
                                    "  '"+s.getMontoPorCobrar()+"','"+s.getVentaCompleta()+"','"+s.getTiposDocumento().getCodTipoDocumento()+"','"+s.getLibroVentas().getCodLibroVentas()+"' ); ";
            
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            //utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error en guardarSalidasAlmacen");
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int editarSalidasVenta(SalidasVenta s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE  " +
                            "  ventas.salidas_venta  " +
                            "  SET  " +                            
                            "  nro_salida_venta = '"+s.getNroSalidaVenta()+"', " +
                            "  nro_documento = '"+s.getNroDocumento()+"', " +
                            "  fecha_salida_venta = '"+s.getFechaSalidaVenta()+"', " +
                            "  tipo_cambio = '"+s.getTipoCambio()+"', " +
                            "  cod_tipo_salida_venta = '"+s.getTiposSalidaVenta().getCodTipoSalidaVenta()+"', " +
                            "  cod_cliente = '"+s.getClientes().getCodCliente()+"', " +
                            "  cod_personal_autoriza = '"+s.getPersonalAutoriza().getCodPersonal()+"', " +
                            "  cod_personal_recibe = '"+s.getPersonalRecibe().getCodigoPersonal()+"', " +
                            "  glosa = '"+s.getGlosa()+"', " +
                            "  cod_estado_salida_venta = '"+s.getEstadosSalidaVenta().getCodEstadoSalidaVenta()+"',"+
                            "  cod_personal_venta = '"+s.getPersonalVenta().getCodPersonal()+"', " +
                            "  cod_tipo_venta='"+s.getTiposVenta().getCodTipoVenta()+"', " +
                            "  cod_tipo_pago='"+s.getTiposPago().getCodTipoPago()+"', " +
                            "  fecha_pago_credito='"+s.getFechaPagoCredito()+"', " +
                            "  monto_sub_total='"+s.getMontoSubTotal()+"', " +
                            "  monto_descuento='"+s.getMontoDescuento()+"', " +
                            "  monto_total='"+s.getMontoTotal()+"', " +
                            "  monto_cancelado='"+s.getMontoCancelado()+"', " +
                            "  monto_amortizado='"+s.getMontoAmortizado()+"', " +
                            "  monto_por_cobrar='"+s.getMontoPorCobrar()+"',"+
                            "  venta_completa='"+s.getVentaCompleta()+"'," +
                            "  cod_tipo_documento = '"+s.getTiposDocumento().getCodTipoDocumento()+"',"+
                            "  cod_libro_ventas = '"+s.getLibroVentas().getCodLibroVentas()+"'"+
                            " WHERE cod_salida_venta='"+s.getCodSalidaVenta()+"' and  cod_almacen_venta = '"+s.getAlmacenesVenta().getCodAlmacenVenta()+"' and cod_gestion = '"+s.getGestion().getCodGestion()+"' ";
            

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
    
    public  List<SelectItem> cargarSalidasVentaItem() {
        List<SelectItem> salidaAlmacenList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " select c.cod_salida_venta,c.nro_salida_venta from ventas.salidas_venta c order by cod_salida_venta ";
                           
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            salidaAlmacenList.clear();
            while (rs.next())
            {
                salidaAlmacenList.add(new SelectItem(rs.getInt("cod_salida_venta"), rs.getString("nro_salida_venta")));
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
        return salidaAlmacenList;
    }
    
    public  int nroSalidaVenta(SalidasVenta sa){
        int nroSalidaAlmacen=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select COALESCE(max(nro_salida_venta),0)+1 nro_salida_venta from ventas.salidas_venta i where i.cod_gestion = '"+sa.getGestion().getCodGestion()+"' and i.cod_almacen_venta = '"+sa.getAlmacenesVenta().getCodAlmacenVenta()+"' ";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                nroSalidaAlmacen = rs.getInt("nro_salida_venta");
            }
            
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return nroSalidaAlmacen;
    }
    
    public  SalidasVenta buscarSalidasVenta(SalidasVenta sa) throws Exception {
        
        SalidasVenta s = new SalidasVenta();
        Utiles utiles = new Utiles();
        utiles.getConnection();
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
            
            
                    
                    String consulta =  " SELECT " +
                        "        s.cod_salida_venta                         , tda.cod_almacen_venta            , tda.nombre_almacen_venta      , " +
                        "        s.cod_gestion                              ,  g.nombre_gestion                           ,  s.nro_salida_venta                         , " +
                        "        s.nro_documento                            , s.fecha_salida_venta                       ,   s.tipo_cambio                              , " +
                        "        tds.cod_campo cod_tipo_salida_venta                    , tds.nombre_campo nombre_tipo_salida_venta                 ,   s.cod_cliente                              , " +
                        "        c.nombre_cliente                           ,  c.nit_cliente                              ,  s.cod_personal_autoriza                    , " +
                        "        p.nombres_personal nombre_personal_autoriza,  s.cod_personal_recibe                      ,  p2.nombres_personal nombre_personal_recibe , " +
                        "        s.glosa                                    ,  tde.cod_campo cod_estado_salida_venta                  ,  tde.nombre_campo nombre_estado_salida_venta               , " +
                        "        td.cod_tipo_descuento                      ,  td.nombre_tipo_descuento                   ,    f.cod_factura_emitida                      , " +
                        "        f.nro_factura,s.cod_personal_venta,s.cod_tipo_venta,tdv.nombre_campo nombre_tipo_venta,s.cod_tipo_pago,s.fecha_pago_credito,s.monto_sub_total,"+
                        "        s.monto_descuento,s.monto_total,s.monto_cancelado,s.monto_amortizado,s.monto_por_cobrar,s.venta_completa,td1.cod_tipo_documento,td1.nombre_tipo_documento,s.cod_libro_ventas " +
                        "FROM " +                        
                        " ventas.salidas_venta s " +
                        " inner join ventas.almacenes_venta tda ON  tda.cod_almacen_venta = s.cod_almacen_venta  " +                        
                        "inner join ventas.tabla_detalle tds ON  tds.cod_campo = s.cod_tipo_salida_venta " +
                        "INNER JOIN ventas.tabla ts ON tds.cod_tabla   = ts.cod_tabla AND     ts.nombre_tabla = 'TIPOS_SALIDA_VENTA' " +
                        "inner join ventas.tabla_detalle tde ON  tde.cod_campo = s.cod_estado_salida_venta " +
                        "INNER JOIN ventas.tabla te ON tde.cod_tabla   = te.cod_tabla AND     te.nombre_tabla = 'ESTADOS_SALIDA_VENTA' " +
                        "inner join ventas.tabla_detalle tdv ON  tdv.cod_campo = s.cod_tipo_venta " +
                        "INNER JOIN ventas.tabla tv ON tdv.cod_tabla   = tv.cod_tabla AND     tv.nombre_tabla = 'TIPOS_VENTA' " +
                        "LEFT OUTER JOIN public.gestiones g ON g.cod_gestion = s.cod_gestion " +
                        "LEFT OUTER JOIN public.clientes c ON c.cod_cliente = s.cod_cliente " +
                        "LEFT OUTER JOIN public.personal p ON p.cod_personal = s.cod_personal_autoriza " +
                        "LEFT OUTER JOIN public.personal p2 ON p2.cod_personal = s.cod_personal_recibe " +
                        "LEFT OUTER JOIN ventas.tipos_descuento td ON td.cod_tipo_descuento = c.cod_tipo_descuento " +
                        "LEFT OUTER JOIN ventas.facturas_emitidas f ON f.cod_salida_venta    = s.cod_salida_venta AND     f.cod_estado_registro = 1 " +
                        "LEFT OUTER JOIN public.tipos_documento td1 ON td1.cod_tipo_documento = s.cod_tipo_documento "+
                        "WHERE 0=0 ";
                        if(sa.getAlmacenesVenta().getCodAlmacenVenta()>0){consulta+="AND s.cod_almacen_venta = '"+sa.getAlmacenesVenta().getCodAlmacenVenta()+"' ";}
                        if(sa.getGestion().getCodGestion()>0){consulta += "AND     s.cod_gestion       = '"+sa.getGestion().getCodGestion()+"' ";}
                        if(sa.getNroSalidaVenta()!=0){consulta+=" AND s.nro_salida_venta = '"+sa.getNroSalidaVenta() +"' ";}
                        if(sa.getNroFactura()!=0){consulta+=" AND f.nro_factura = '"+sa.getNroFactura() +"' ";}
                        if(sa.getClientes().getCodCliente()!=0){consulta+=" AND s.cod_cliente = '"+sa.getClientes().getCodCliente() +"' ";}
                        if(sa.getEstadosSalidaVenta().getCodEstadoSalidaVenta()!=0){consulta+=" AND s.cod_estado_salida_venta = '"+sa.getEstadosSalidaVenta().getCodEstadoSalidaVenta() +"' ";}
                        if(sa.getVentaCompleta()!=0){consulta+=" AND s.venta_completa = '"+sa.getVentaCompleta() +"' ";}
                        if(sa.getConFacturaEmitida()!=0){consulta+=" AND f.cod_factura_emitida > 0 ";}
                        if(!sa.getFechaSalidaVentaInicio().equals("") && !sa.getFechaSalidaVentaFinal().equals("")){consulta+=" AND s.fecha_salida_venta between '"+sa.getFechaSalidaVentaInicio()+"' and '"+sa.getFechaSalidaVentaFinal()+"' ";}
                        if(sa.getCodSalidaVenta()>0 ){consulta+=" AND s.cod_salida_venta = '"+sa.getCodSalidaVenta()+"'  ";}
                        consulta +=" ORDER BY s.cod_salida_venta DESC LIMIT 10 OFFSET "+sa.getFilaInicial()+"  ";
            
            System.out.println("consulta " +consulta);

            PreparedStatement statement = utiles.getCon().prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next())
            {
                
                
                s.setCodSalidaVenta(rs.getInt("cod_salida_venta"));
                s.getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                s.getAlmacenesVenta().setNombreAlmacenVenta(rs.getString("nombre_almacen_venta"));
                s.getGestion().setCodGestion(rs.getInt("cod_gestion"));
                s.getGestion().setNombreGestion(rs.getString("nombre_gestion"));                
                s.setNroSalidaVenta(rs.getInt("nro_salida_venta"));
                s.setNroDocumento(rs.getInt("nro_documento"));
                s.setFechaSalidaVenta(sdf.format(rs.getTimestamp("fecha_salida_venta")));
                s.setTipoCambio(rs.getDouble("tipo_cambio"));
                s.getTiposSalidaVenta().setCodTipoSalidaVenta(rs.getInt("cod_tipo_salida_venta"));
                s.getTiposSalidaVenta().setNombreTipoSalidaVenta(rs.getString("nombre_tipo_salida_venta"));
                s.getClientes().setCodCliente(rs.getInt("cod_cliente"));
                s.getClientes().setNombreCliente(rs.getString("nombre_cliente"));
                s.getClientes().setNitCliente(rs.getString("nit_cliente"));
                s.getPersonalAutoriza().setCodPersonal(rs.getInt("cod_personal_autoriza"));
                s.getPersonalAutoriza().setNombrePersonal(rs.getString("nombre_personal_autoriza"));
                s.getPersonalRecibe().setCodPersonal(rs.getInt("cod_personal_recibe"));
                s.getPersonalRecibe().setNombrePersonal(rs.getString("nombre_personal_recibe"));
                s.setGlosa(rs.getString("glosa"));
                s.getEstadosSalidaVenta().setCodEstadoSalidaVenta(rs.getInt("cod_estado_salida_venta"));
                s.getEstadosSalidaVenta().setNombreEstadoSalidaVenta(rs.getString("nombre_estado_salida_venta"));
                s.getClientes().getTiposDescuento().setCodTipoDescuento(rs.getInt("cod_tipo_descuento"));
                s.getClientes().getTiposDescuento().setNombreTipoDescuento(rs.getString("nombre_tipo_descuento"));
                s.setCodFacturaEmitida(rs.getInt("cod_factura_emitida"));
                s.setNroFactura(rs.getInt("nro_factura"));
                
                s.getPersonalVenta().setCodPersonal(rs.getInt("cod_personal_venta"));
                s.getTiposVenta().setCodTipoVenta(rs.getInt("cod_tipo_venta"));
                s.getTiposVenta().setNombreTipoVenta(rs.getString("nombre_tipo_venta"));
                s.getTiposPago().setCodTipoPago(rs.getInt("cod_tipo_pago"));
                s.setFechaPagoCredito(rs.getTimestamp("fecha_pago_credito")!=null?sdf.format(rs.getTimestamp("fecha_pago_credito")):"");
                s.setMontoSubTotal(rs.getDouble("monto_sub_total"));
                s.setMontoDescuento(rs.getDouble("monto_descuento"));
                s.setMontoTotal(rs.getDouble("monto_total"));
                s.setMontoCancelado(rs.getDouble("monto_cancelado"));
                s.setMontoAmortizado(rs.getDouble("monto_amortizado"));
                s.setMontoPorCobrar(rs.getDouble("monto_por_cobrar"));
                s.setVentaCompleta(rs.getInt("venta_completa"));
                s.getTiposDocumento().setCodTipoDocumento(rs.getInt("cod_tipo_documento"));
                s.getTiposDocumento().setNombreTipoDocumento(rs.getString("nombre_tipo_documento"));
                s.getLibroVentas().setCodLibroVentas(rs.getInt("cod_libro_ventas"));
                
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
        return s;
    }
    
    
    public  int eliminarSalidasVenta(SalidasVenta s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            
            //Statement statement = utiles.getCon().createStatement();
            String cons =  " delete from ventas.salidas_venta " +                    
                    " WHERE cod_salida_venta='"+s.getCodSalidaVenta()+"' ;";            
            PreparedStatement statement = this.con.prepareStatement(cons);
            System.out.println("cons " + cons);
            //guardado = statement.executeUpdate(cons);
            
            //con.close();
            guardado = statement.execute()==true?1:0;
            statement.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error en eliminarSalidasVenta");
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
    
    

    
    
}
