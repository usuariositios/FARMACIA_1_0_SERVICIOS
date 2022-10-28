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


import servicio.model.FacturaDosificacion;
import servicio.model.SelectItem;
import servicio.util.Utiles;



/**
 *
 * @author henry
 */
public class FacturaDosificacionResource {
    Connection con;
    public FacturaDosificacionResource(){
    }
    public FacturaDosificacionResource(Connection con){
        this.con = con;
    }
    
    public  List<FacturaDosificacion> cargarFacturaDosificacion(FacturaDosificacion fd) {
        List<FacturaDosificacion> dosificacionFacturaList =new ArrayList<FacturaDosificacion>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query =  "  SELECT  fd.cod_dosificacion,  fd.nro_factura_inicio,fd.nro_factura_final,fd.nro_autorizacion, " +
                            "  fd.llave_dosificacion,fd.fecha_limite_emision,e.cod_estado_registro,e.nombre_estado_registro " +
                            "  FROM " +
                            "  ventas.facturas_dosificacion fd inner join public.estados_registro e " +
                            "  on fd.cod_estado_registro = e.cod_estado_registro where 0=0 ";
            if(fd.getSucursalVentas().getCodSucursal()!=0){
                query +=" and fd.cod_sucursal = '"+fd.getSucursalVentas().getCodSucursal()+"' ";
            }
            
            query += " ORDER BY  fd.cod_dosificacion asc";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            dosificacionFacturaList.clear();
            while (rs.next())
            {
                FacturaDosificacion fd1 = new FacturaDosificacion();
                fd1.setCodDosificacion(rs.getInt("cod_dosificacion"));
                fd1.setNroFacturaInicio(rs.getInt("nro_factura_inicio"));
                fd1.setNroFacturaFinal(rs.getInt("nro_factura_final"));
                fd1.setNroAutorizacion(rs.getString("nro_autorizacion"));
                fd1.setLlaveDosificacion(rs.getString("llave_dosificacion"));
                fd1.setFechaLimiteEmision(sdf.format(rs.getTimestamp("fecha_limite_emision")));
                fd1.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                fd1.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                dosificacionFacturaList.add(fd1);
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
        return dosificacionFacturaList;
    }
    public  int guardarFacturaDosificacion(FacturaDosificacion fd){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement st = this.con.createStatement();
            fd.setCodDosificacion(codigoFacturaDosificacion());
            
            String cons = "   INSERT INTO  " +
                            "  ventas.facturas_dosificacion (  cod_dosificacion,  nro_factura_inicio,nro_factura_final, nro_autorizacion, llave_dosificacion, fecha_limite_emision, cod_estado_registro,cod_sucursal) " +
                            "VALUES ( '"+fd.getCodDosificacion()+"',  '"+fd.getNroFacturaInicio()+"',  '"+fd.getNroFacturaFinal()+"',  '"+fd.getNroAutorizacion()+"', '"+fd.getLlaveDosificacion()+"',  '"+fd.getFechaLimiteEmision()+"', " +
                            "  '"+fd.getEstadosRegistro().getCodEstado()+"','"+fd.getSucursalVentas().getCodSucursal()+"'); ";
            System.out.println("cons " + cons);
            guardado = st.executeUpdate(cons);
            
            st.close();
            //utiles.closeConnection();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int codigoFacturaDosificacion(){
        int codFacturaDosificacion=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select nextval('ventas.\"seqDosificacionFactura\"') cod_facturaDosificacion";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codFacturaDosificacion = rs.getInt("cod_facturaDosificacion");
            }
            
            statement.close();
            utiles.closeConnection();
            
            //connection.close();
        } catch (Exception e) {
        }
        //Utiles.closeConnection();
        return codFacturaDosificacion;
    }
    public  int editarFacturaDosificacion(FacturaDosificacion fd){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE  " +
                            "  ventas.facturas_dosificacion  " +
                            " SET  " +
                            "  nro_factura_inicio = '"+fd.getNroFacturaInicio()+"', " +
                            "  nro_factura_final = '"+fd.getNroFacturaFinal()+"', " +
                            "  nro_autorizacion = '"+fd.getNroAutorizacion()+"', " +
                            "  llave_dosificacion = '"+fd.getLlaveDosificacion()+"', " +
                            "  fecha_limite_emision = '"+fd.getFechaLimiteEmision()+"', " +
                            "  cod_estado_registro = '"+fd.getEstadosRegistro().getCodEstado()+"',"+
                            "  cod_sucursal = '"+fd.getSucursalVentas().getCodSucursal()+"'" +
                            "WHERE  " +
                            "  cod_dosificacion = '"+fd.getCodDosificacion()+"' ";
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
    public  int eliminarFacturaDosificacion(FacturaDosificacion p){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from ventas.facturas_dosificacion where cod_dosificacion = '"+p.getCodDosificacion()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //con.close();
            //utiles.closeConnection();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
    public  List<SelectItem> cargarFacturaDosificacionItem(FacturaDosificacion c) {
        List<SelectItem> clienteList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_dosificacion, nro_autorizacion "
                    + " from ventas.factura_dosificacion order by cod_dosificacion  ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            clienteList.clear();
            while (rs.next())
            {
                clienteList.add(new SelectItem(rs.getInt("cod_dosificacion"), rs.getString("nro_autorizacion")));
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
        return clienteList;
    }
    
    public  FacturaDosificacion buscarFacturaDosificacion(FacturaDosificacion fd) {
        FacturaDosificacion fd1 = new FacturaDosificacion();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query =  "  SELECT  fd.cod_dosificacion,  fd.nro_factura_inicio,fd.nro_factura_final,fd.nro_autorizacion, " +
                            "  fd.llave_dosificacion,fd.fecha_limite_emision,e.cod_estado_registro,e.nombre_estado_registro " +
                            "  FROM " +
                            "  ventas.facturas_dosificacion fd inner join public.estados_registro e " +
                            "  on fd.cod_estado_registro = e.cod_estado_registro where 0=0 ";
            
            if(fd.getEstadosRegistro().getCodEstado()!=0){query+=" AND fd.cod_estado_registro = '"+fd.getEstadosRegistro().getCodEstado() +"' ";}
            if(fd.getSucursalVentas().getCodSucursal()!=0){
                query +=" and fd.cod_sucursal = '"+fd.getSucursalVentas().getCodSucursal()+"' ";
            }
            query += " ORDER BY  fd.cod_dosificacion asc ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next())
            {
                
                fd1.setCodDosificacion(rs.getInt("cod_dosificacion"));
                fd1.setNroFacturaInicio(rs.getInt("nro_factura_inicio"));
                fd1.setNroFacturaFinal(rs.getInt("nro_factura_final"));
                fd1.setNroAutorizacion(rs.getString("nro_autorizacion"));
                fd1.setLlaveDosificacion(rs.getString("llave_dosificacion"));
                fd1.setFechaLimiteEmision(sdf.format(rs.getTimestamp("fecha_limite_emision")));
                fd1.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                fd1.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                
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
        return fd1;
    }
    
}
