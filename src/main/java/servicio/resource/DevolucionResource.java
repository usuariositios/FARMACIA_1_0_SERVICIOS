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


import servicio.model.Devoluciones;
import servicio.model.DevolucionesBusiness;
import servicio.model.DevolucionesDetalle;
import servicio.model.SelectItem;
import servicio.util.Utiles;



/**
 *
 * @author henry
 */
public class DevolucionResource {
    Connection con=null;
    
    public DevolucionResource(Connection con){
        this.con = con;
    }
    
    public DevolucionResource(){
    }
    
    
    public  List<Devoluciones> cargarDevolucion(Devoluciones d) {
        List<Devoluciones> personalList =new ArrayList<Devoluciones>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query =  " SELECT d.cod_devolucion,  d.nro_devolucion,  d.cod_formulario_dev,  d.cod_almacen,  d.cod_salida_venta,  c.cod_cliente,c.nombre_cliente, " +
                            " d.cod_factura_emitida,  d.fecha_devolucion,  d.cod_gestion,  d.cod_estado_devolucion,  d.obs_devolucion,  d.cod_estado_registro " +
                            " FROM ventas.devoluciones d " +
                            " inner join ventas.salidas_venta s on s.cod_salida_venta = d.cod_salida_venta " +
                            " inner join public.devoluciones c on c.cod_cliente = d.cod_cliente " +
                            " inner join public.estados_registro e on e.cod_estado_registro = d.cod_estado_registro  where 0=0 ";
            if(d.getCodDevolucion()>0){query+=" AND d.cod_devolucion LIKE '"+d.getCodDevolucion()+"' ";}
            
            query += " ORDER BY  c.nombre_cliente asc";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            personalList.clear();
            while (rs.next())
            {
                Devoluciones d1 = new Devoluciones();
                d1.setCodDevolucion(rs.getInt("cod_devolucion"));
                d1.setNroDevolucion(rs.getInt("nro_devolucion"));
                d1.setCodFormularioDev(rs.getInt("cod_formulario_dev"));
                d1.getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                d1.getSalidasVenta().setCodSalidaVenta(rs.getInt("cod_salida_venta"));
                d1.getClientes().setCodCliente(rs.getInt("cod_cliente"));
                d1.getClientes().setNombreCliente(rs.getString("nombre_cliente"));
                d1.getFacturasEmitidas().setCodFacturaEmitida(rs.getInt("cod_factura_emitida"));
                d1.setFechaDevolucion(sdf.format(rs.getTimestamp("cod_factura_emitida")));
                d1.getGestion().setCodGestion(rs.getInt("cod_gestion"));
                d1.getEstadosDevolucion().setCodEstadoDevolucion(rs.getInt("cod_estado_devolucion"));
                d1.setObsDevolucion(rs.getString("obs_devolucion"));
                d1.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                
                personalList.add(d1);
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
        return personalList;
    }
    public  int guardarDevolucion(Devoluciones d) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            //Utiles utiles = new Utiles();utiles.getConnection();
            
            Statement st = this.con.createStatement();
            
            String cons = " INSERT INTO   ventas.devoluciones " +
                            "( cod_devolucion,  nro_devolucion,  cod_formulario_dev,  cod_almacen_venta,  cod_salida_venta,  cod_cliente, " +
                            "  cod_factura_emitida,  fecha_devolucion,  cod_gestion,  cod_estado_devolucion,  obs_devolucion, " +
                            "  cod_estado_registro) " +
                            "VALUES ( '"+d.getCodDevolucion()+"',  '"+d.getNroDevolucion()+"',  '"+d.getCodFormularioDev()+"',  '"+d.getAlmacenesVenta().getCodAlmacenVenta()+"',  '"+d.getSalidasVenta().getCodSalidaVenta()+"', " +
                            "  '"+d.getClientes().getCodCliente()+"',  '"+d.getFacturasEmitidas().getCodFacturaEmitida()+"',  '"+d.getFechaDevolucion()+"',  '"+d.getGestion().getCodGestion()+"',  '"+d.getEstadosDevolucion().getCodEstadoDevolucion()+"',  '"+d.getObsDevolucion()+"', " +
                            "  '"+d.getEstadosRegistro().getCodEstado()+"'); ";
            System.out.println("cons " + cons);
            guardado = st.executeUpdate(cons);
            
            st.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int codigoDevolucion(){
        int codDevolucion=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select nextval('ventas.\"seqDevolucion\"') cod_devolucion";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codDevolucion = rs.getInt("cod_devolucion");
            }
            
            statement.close();
            utiles.closeConnection();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return codDevolucion;
    }
    public  int editarDevolucion(Devoluciones d){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " UPDATE  " +
                            "  ventas.devoluciones  " +
                            " SET  " +
                            "  nro_devolucion = '"+d.getNroDevolucion()+"', " +
                            "  cod_formulario_dev = '"+d.getCodFormularioDev()+"', " +
                            "  cod_almacen_venta = '"+d.getAlmacenesVenta().getCodAlmacenVenta()+"', " +
                            "  cod_salida_venta = '"+d.getSalidasVenta().getCodSalidaVenta()+"', " +
                            "  cod_cliente = '"+d.getClientes().getCodCliente()+"', " +
                            "  cod_factura_emitida = '"+d.getFacturasEmitidas().getCodFacturaEmitida()+"', " +
                            "  fecha_devolucion = '"+d.getFechaDevolucion()+"', " +
                            "  cod_gestion = '"+d.getGestion().getCodGestion()+"', " +
                            "  cod_estado_devolucion = '"+d.getEstadosDevolucion().getCodEstadoDevolucion()+"', " +
                            "  obs_devolucion = '"+d.getObsDevolucion()+"', " +
                            "  cod_estado_registro = '"+d.getEstadosRegistro().getCodEstado()+"' " +
                            " WHERE  " +
                            "  cod_devolucion = '"+d.getCodDevolucion()+"' ";
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //utiles.closeConnection();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int nroDevolucion(Devoluciones d){
        int nroDevolucion=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select COALESCE(max(nro_devolucion),0)+1 nro_devolucion from ventas.devoluciones d where d.cod_gestion = '"+d.getGestion().getCodGestion()+"' and d.cod_almacen_venta = '"+d.getAlmacenesVenta().getCodAlmacenVenta()+"' ";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                nroDevolucion = rs.getInt("nro_devolucion");
            }
            
            statement.close();
            utiles.closeConnection();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return nroDevolucion;
    }
    public  int eliminarDevolucion(Devoluciones p) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = " delete from ventas.devoluciones where cod_devolucion = '"+p.getCodDevolucion()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            utiles.closeConnection();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
    public  List<SelectItem> cargarDevolucionItem(Devoluciones c) {
        List<SelectItem> clienteList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_devolucion, nombre_devolucion "
                    + " from ventas.devoluciones order by cod_cliente  ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            clienteList.clear();
            while (rs.next())
            {
                clienteList.add(new SelectItem(rs.getInt("cod_cliente"), rs.getString("nombre_cliente")));
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
        return clienteList;
    }
    
    public  Devoluciones buscarDevolucion(Devoluciones d) {
        Devoluciones dl = new Devoluciones();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query =  " SELECT d.cod_devolucion,  d.nro_devolucion,  d.cod_formulario_dev,  d.cod_almacen,  d.cod_salida_venta,  c.cod_cliente,c.nombre_cliente, " +
                            " d.cod_factura_emitida,  d.fecha_devolucion,  d.cod_gestion,  d.cod_estado_devolucion,  d.obs_devolucion,  d.cod_estado_registro " +
                            " FROM ventas.devoluciones d " +
                            " inner join ventas.salidas_venta s on s.cod_salida_venta = d.cod_salida_venta " +
                            " inner join public.devoluciones c on c.cod_cliente = d.cod_cliente " +
                            " inner join public.estados_registro e on e.cod_estado_registro = d.cod_estado_registro  where 0=0 ";
            if(d.getCodDevolucion()>0){query+=" AND d.cod_devolucion LIKE '"+d.getCodDevolucion()+"' ";}
            
            query += " ORDER BY  c.nombre_cliente asc";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
            {
                Devoluciones d1 = new Devoluciones();
                d1.setCodDevolucion(rs.getInt("cod_devolucion"));
                d1.setNroDevolucion(rs.getInt("nro_devolucion"));
                d1.setCodFormularioDev(rs.getInt("cod_formulario_dev"));
                d1.getAlmacenesVenta().setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));
                d1.getSalidasVenta().setCodSalidaVenta(rs.getInt("cod_salida_venta"));
                d1.getClientes().setCodCliente(rs.getInt("cod_cliente"));
                d1.getClientes().setNombreCliente(rs.getString("nombre_cliente"));
                d1.getFacturasEmitidas().setCodFacturaEmitida(rs.getInt("cod_factura_emitida"));
                d1.setFechaDevolucion(sdf.format(rs.getTimestamp("cod_factura_emitida")));
                d1.getGestion().setCodGestion(rs.getInt("cod_gestion"));
                d1.getEstadosDevolucion().setCodEstadoDevolucion(rs.getInt("cod_estado_devolucion"));
                d1.setObsDevolucion(rs.getString("obs_devolucion"));
                d1.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));                
                
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
        return dl;
    }
    
    public  DevolucionesBusiness guardarDevolucionBusiness(DevolucionesBusiness s) {
        //Utiles.setAutoCommit(false);
        try{
        Utiles utiles = new Utiles();
        utiles.getConnection();
        try {
            
            //try (final Connection con = Utiles.getConnections()) {
                // Operations using the instance
                utiles.getCon().setAutoCommit(false);
                this.con = utiles.getCon();//asignar la conexion por referencia
                s.getDevoluciones().setCodDevolucion(this.codigoDevolucion());
                this.guardarDevolucion(s.getDevoluciones());
        
                DevolucionDetalleResource devolucionDetalleResource = new DevolucionDetalleResource(utiles.getCon());
        for(DevolucionesDetalle sd:s.getDevolucionesDetalleList()){
            sd.setDevoluciones(s.getDevoluciones());
            devolucionDetalleResource.guardarDevolucionesDetalle(sd);
        }
        utiles.getCon().commit();
        utiles.getCon().setAutoCommit(true);
        //con.close();        
            //}
        utiles.closeConnection();
            
        //Utiles.commit();
        } catch (Exception e) {
            utiles.rollback();
            e.printStackTrace();
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        //Utiles.setAutoCommit(true);
        return s;
    }
    
}
