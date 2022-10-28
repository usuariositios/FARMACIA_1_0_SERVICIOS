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

import servicio.model.AlmacenesVenta;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class AlmacenesResource {
    Connection con;
    public AlmacenesResource(){
    }
    public AlmacenesResource(Connection con){
        this.con = con;
    }
    public  List<AlmacenesVenta> cargarAlmacenes(AlmacenesVenta a) {
        List<AlmacenesVenta> listAlmacenes =new ArrayList<AlmacenesVenta>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = "SELECT   a.cod_almacen_venta,  a.nombre_almacen_venta,  e.cod_estado_registro,e.nombre_estado_registro,  s.cod_sucursal,s.nombre_sucursal  " +
                            "FROM " +
                            "  ventas.almacenes_venta a " +
                            "  inner join public.estados_registro e on e.cod_estado_registro = a.cod_estado_registro " +
                            "  inner join ventas.sucursal_ventas s on s.cod_sucursal = a.cod_sucursal_venta "
                         + " where 0=0 ";
            if(a.getSucursalVentas().getCodSucursal()!=0){query+=" and a.cod_sucursal_venta = '"+a.getSucursalVentas().getCodSucursal()+"'  ";}
            query +=" order by  a.nombre_almacen_venta ";
            System.out.println("consulta " +query);
            

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listAlmacenes.clear();
            while (rs.next())
            {
                AlmacenesVenta  e = new AlmacenesVenta();
                e.setCodAlmacenVenta(rs.getInt("cod_almacen_venta"));                
                e.setNombreAlmacenVenta(rs.getString("nombre_almacen_venta"));
                e.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                e.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                e.getSucursalVentas().setCodSucursal(rs.getInt("cod_sucursal"));
                e.getSucursalVentas().setNombreSucursal(rs.getString("nombre_sucursal"));
                
                listAlmacenes.add(e);
            }
            rs.close();
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return listAlmacenes;
    }
    public  int guardarAlmacen(AlmacenesVenta e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String 
            cons = " INSERT INTO ventas.almacenes_venta(cod_almacen_venta,  nombre_almacen_venta, cod_estado_registro,cod_sucursal_venta)" +
                   " VALUES ((select nextval('almacenes.\"seqAlmacenes\"')),  '"+e.getNombreAlmacenVenta()+"', '"+e.getEstadosRegistro().getCodEstado()+"','"+e.getSucursalVentas().getCodSucursal()+"');";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //connection.close();
            //utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public int codCiudad(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarAlmacen(AlmacenesVenta e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            Statement statement = utiles.getCon().createStatement();
            String cons = "UPDATE ventas.almacenes_venta " +
                    "   SET  nombre_almacen_venta='"+e.getNombreAlmacenVenta()+"',  " +
                    "       cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"',"
                    + " cod_sucursal_venta = '"+e.getSucursalVentas().getCodSucursal()+"'  " +
                    " WHERE cod_almacen_venta='"+e.getCodAlmacenVenta()+"';";
            
                    
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        
        return guardado;
    }
    public  int eliminarAlmacen(AlmacenesVenta e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = " delete from ventas.almacenes_venta where cod_almacen_venta = '"+e.getCodAlmacenVenta()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  List<SelectItem> cargarAlmacenItem() {
        List<SelectItem> cargoList =new ArrayList<SelectItem>();
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_cargo,nombre_cargo from cargo";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            cargoList.clear();
            while (rs.next())
            {
                cargoList.add(new SelectItem(rs.getInt("cod_cargo"), rs.getString("nombre_cargo")));
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
        return cargoList;
    }
    
}
