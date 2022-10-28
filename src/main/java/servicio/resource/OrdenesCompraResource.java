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
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class OrdenesCompraResource extends BeanResource {
    Connection con;
    public OrdenesCompraResource(){
    }
    public OrdenesCompraResource(Connection con){
        this.con = con;
    }
    
    public  List<OrdenesCompra> cargarOrdenesCompra(OrdenesCompra o) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        List<OrdenesCompra> ordenCompraList =new ArrayList<OrdenesCompra>();
        try {
            
            

            
            String consulta =   " select o.nro_orden_compra,o.cod_orden_compra,o.tiempo_entrega,o.fecha_emision,o.fecha_aprobacion, " +
                                " p.cod_proveedor,p.nombre_proveedor,t.cod_tipo_compra,t.nombre_tipo_compra, " +
                                " tp.cod_tipo_transporte,tp.nombre_tipo_transporte,m.cod_moneda,m.nombre_moneda,tg.cod_tipo_pago,tg.nombre_tipo_pago "+
                                " ,e.cod_estado_orden_compra,e.nombre_estado_orden_compra, o.fecha_entrega,o.cod_gestion " +
                                " from public.ordenes_compra o " +
                                " inner join monedas m on m.cod_moneda = o.cod_moneda " +
                                " inner join estados_orden_compra e on e.cod_estado_orden_compra = o.cod_estado_orden_compra "+                                
                                " left outer join proveedores p on p.cod_proveedor = o.cod_proveedor " +
                                " left outer join tipos_transporte tp on tp.cod_tipo_transporte = o.cod_tipo_transporte " +
                                " left outer join tipos_compra t on t.cod_tipo_compra = o.cod_tipo_compra " +
                                " left outer join tipos_pago tg on tg.cod_tipo_pago = o.cod_tipo_pago where 0=0 ";
                                if(o.getCodOrdenCompra()!=0){consulta+=" AND o.cod_orden_compra = '"+o.getCodOrdenCompra()+"' ";}
                                if(o.getEstadosOrdenCompra().getCodEstadoOrdenCompra()!=0){consulta+=" AND o.cod_estado_orden_compra = '"+o.getEstadosOrdenCompra().getCodEstadoOrdenCompra()+"' ";}
                                if(o.getProveedores().getCodProveedor()!=0){consulta+=" AND o.cod_proveedor = '"+o.getProveedores().getCodProveedor()+"' ";}
                                if(o.getGestiones().getCodGestion()!=0){consulta+=" AND o.cod_gestion = '"+o.getGestiones().getCodGestion()+"' ";}
                                consulta +=" ORDER BY o.cod_orden_compra DESC LIMIT 10 OFFSET "+o.getFilaInicial()+" ; ";
                                
            System.out.println("consulta " +consulta);

            PreparedStatement statement = this.con.prepareStatement(consulta);
            ResultSet rs = statement.executeQuery();
            ordenCompraList.clear();
            while (rs.next())
            {
                OrdenesCompra oc = new OrdenesCompra();
                oc.setCodOrdenCompra(rs.getInt("cod_orden_compra"));
                oc.setNroOrdenCompra(rs.getInt("nro_orden_compra"));
                oc.setFechaEmision(sdf1.format(rs.getTimestamp("fecha_emision")));
                oc.setFechaAprobacion(sdf1.format(rs.getTimestamp("fecha_aprobacion")));
                
                
                oc.setTiempoEntrega(rs.getDouble("tiempo_entrega"));
                oc.getProveedores().setCodProveedor(rs.getInt("cod_proveedor"));
                oc.getProveedores().setNombreProveedor(rs.getString("nombre_proveedor"));
                oc.getTiposCompra().setCodTipoCompra(rs.getInt("cod_tipo_compra"));
                oc.getTiposCompra().setNombreTipoCompra(rs.getString("nombre_tipo_compra"));
                oc.getTiposTransporte().setCodTipoTransporte(rs.getInt("cod_tipo_transporte"));
                oc.getTiposTransporte().setNombreTipoTransporte(rs.getString("nombre_tipo_transporte"));
                oc.getTiposPago().setCodTipoPago(rs.getInt("cod_tipo_pago"));
                oc.getTiposPago().setNombreTipoPago(rs.getString("nombre_tipo_pago"));
                oc.getMonedas().setCodMoneda(rs.getInt("cod_moneda"));
                oc.getMonedas().setNombreMoneda(rs.getString("nombre_moneda"));
                oc.getEstadosOrdenCompra().setCodEstadoOrdenCompra(rs.getInt("cod_estado_orden_compra"));
                oc.getEstadosOrdenCompra().setNombreEstadoOrdenCompra(rs.getString("nombre_estado_orden_compra"));
                oc.setFechaEntrega(sdf1.format(rs.getTimestamp("fecha_entrega")));
                oc.getGestiones().setCodGestion(rs.getInt("cod_gestion"));
                
                
                ordenCompraList.add(oc);
            }
            rs.close();
            statement.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return ordenCompraList;
    }
    public  int codigoOrdenCompra(){
        int codOrdenCompra=0;
        
        try {
            
            Statement statement = this.con.createStatement();
            String cons = " select COALESCE(max(o.cod_orden_compra),0)+1 cod_orden_compra from public.ordenes_compra o";
                        
                   
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codOrdenCompra = rs.getInt("cod_orden_compra");
            }
            
            statement.close();
            //connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return codOrdenCompra;
    }
    public  int nroOrdenCompra(OrdenesCompra o){
        int codOrdenCompra=1;//si no hay registros
        
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "select COALESCE(max(o.nro_orden_compra),0)+1 nro_orden_compra from public.ordenes_compra o"
                    + " where cod_gestion = '"+o.getGestiones().getCodGestion()+"' ";
            
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codOrdenCompra = rs.getInt("nro_orden_compra");
            }
            
            statement.close();
            //connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        
        return codOrdenCompra;
    }
    public  int guardarOrdenesCompra(OrdenesCompra o){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons = "  INSERT INTO public.ordenes_compra( cod_orden_compra, nro_orden_compra, tiempo_entrega, cod_moneda,"
                        + "  fecha_emision, fecha_aprobacion, cod_proveedor, cod_tipo_compra, "
                        + "  cod_tipo_transporte, cod_tipo_pago,cod_gestion,cod_estado_orden_compra,"
                        + " cod_orden_produccion,monto_anticipo,fecha_entrega,cod_cotizacion) "
                        + "  VALUES ('"+o.getCodOrdenCompra()+"', '"+o.getNroOrdenCompra()+"', '"+o.getTiempoEntrega()+"', '"+o.getMonedas().getCodMoneda()+"',  " 
                        + "  '"+o.getFechaEmision()+"', '"+o.getFechaAprobacion()+"', '"+o.getProveedores().getCodProveedor()+"', '"+o.getTiposCompra().getCodTipoCompra()+"',"
                        + "  '"+o.getTiposTransporte().getCodTipoTransporte()+"', '"+o.getTiposPago().getCodTipoPago()+"','"+o.getGestiones().getCodGestion()+"','"+o.getEstadosOrdenCompra().getCodEstadoOrdenCompra()+"'"
                        + ",'0','"+o.getMontoAnticipo()+"', '"+o.getFechaEntrega()+"','0'); ";
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
    public  int editarOrdenesCompra(OrdenesCompra o){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE public.ordenes_compra " +
                            " SET tiempo_entrega='"+o.getTiempoEntrega()+"',"+
                            " cod_moneda='"+o.getMonedas().getCodMoneda()+"',  " +
                            " fecha_emision =  '"+o.getFechaEmision()+"', "+
                            " fecha_aprobacion= '"+o.getFechaAprobacion()+"'," +
                            " cod_proveedor='"+o.getProveedores().getCodProveedor()+"', "+
                            " cod_tipo_compra='"+o.getTiposCompra().getCodTipoCompra()+"',  " +
                            " cod_tipo_transporte='"+o.getTiposTransporte().getCodTipoTransporte()+"', "+
                            " cod_tipo_pago='"+o.getTiposPago().getCodTipoPago()+"',"+
                            " cod_orden_produccion = '0'," +
                            " cod_estado_orden_compra = '"+o.getEstadosOrdenCompra().getCodEstadoOrdenCompra()+"',"+
                            " fecha_entrega= '"+o.getFechaEntrega()+"',"+
                            " cod_cotizacion='0' " +
                            " WHERE cod_orden_compra = '"+o.getCodOrdenCompra()+"' ";
            
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
    public  int eliminarOrdenesCompra(OrdenesCompra o){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Statement statement = this.con.createStatement();
             
            
            String cons = " delete from public.ordenes_compra where cod_orden_compra = '"+o.getCodOrdenCompra()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //connection.close();
            
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
    
     public  List<SelectItem> cargarOrdenesCompraItem() {
        List<SelectItem> productoList =new ArrayList<SelectItem>();
        try {
            
            
            
            String query = "SELECT cod_orden_compra,nro_orden_compra from public.ordenes_compra";
            System.out.println("consulta " +query);

            PreparedStatement statement = this.con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            productoList.clear();
            while (rs.next())
            {
                productoList.add(new SelectItem(rs.getInt("cod_orden_compra"), rs.getString("nro_orden_compra")));
            }
            rs.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return productoList;
    }
    
    
    
    
}
