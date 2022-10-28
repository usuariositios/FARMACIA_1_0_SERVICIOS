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
import javax.naming.InitialContext;
import javax.sql.DataSource;
import servicio.model.EstadosIngresoVenta;
import servicio.model.Pais;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class EstadoIngresoAlmacenResource {
    public  List<EstadosIngresoVenta> cargarEstadosIngresoAlmacen() {
        List<EstadosIngresoVenta> listEstadosIngresoAlmacen =new ArrayList<EstadosIngresoVenta>();
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " SELECT e.cod_estado_ingreso_almacen, e.nombre_estado_ingreso_almacen " +
                           " FROM almacenes.estados_ingreso_almacen e; ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listEstadosIngresoAlmacen.clear();
            while (rs.next())
            {
                EstadosIngresoVenta e = new EstadosIngresoVenta();
                e.setCodEstadoIngresoVenta(rs.getInt("cod_estado_ingreso_almacen"));
                e.setNombreEstadoIngresoVenta(rs.getString("nombre_estado_ingreso_almacen"));                
                listEstadosIngresoAlmacen.add(e);
            }
            rs.close();
            statement.close();
            utiles.closeConnection();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return listEstadosIngresoAlmacen;
    }
    public  List<SelectItem> cargarEstadosIngresoAlmacenItem() {
        List<SelectItem> estList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT e.cod_estado_ingreso_almacen, e.nombre_estado_ingreso_almacen " +
                           " FROM almacenes.estados_ingreso_almacen e; ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            estList.clear();
            while (rs.next())
            {
                estList.add(new SelectItem(rs.getInt("cod_estado_ingreso_almacen"), rs.getString("nombre_estado_ingreso_almacen")));
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
        return estList;
    }
   
    public  int guardarEstadosIngresoAlmacen(EstadosIngresoVenta gs){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = " ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            utiles.closeConnection();
            //connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int codCiudad(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarEstadosIngresoAlmacen(EstadosIngresoVenta e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "  ";
            
                    
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
    public  int eliminarEstadosIngresoAlmacen(EstadosIngresoVenta e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "  ";
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
    
}
