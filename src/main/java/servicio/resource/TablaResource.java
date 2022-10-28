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
import servicio.model.Tabla;
import servicio.model.Tabla;
import servicio.model.TiposProveedor;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TablaResource {
    Connection con;
    public TablaResource(){
    }
    public TablaResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarTablaItem(Tabla td) {
        List<SelectItem> itemList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query =  " SELECT t.cod_tabla, t.nombre_tabla,t.descripcion_tabla "
                    + " FROM ventas.tabla t where cod_estado_registro = '"+td.getEstadosRegistro().getCodEstado()+"'" +
                      " order by t.cod_tabla ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            itemList.clear();
            while (rs.next())
            {
                itemList.add(new SelectItem(rs.getInt("cod_tabla"), rs.getString("nombre_tabla")));
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
        return itemList;
    }
    public  List<Tabla> cargarTabla(Tabla t) {
        List<Tabla> listTabla =new ArrayList<Tabla>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            String query =  " SELECT cod_tabla, nombre_tabla, descripcion_tabla, cod_estado_registro "
                    + " FROM ventas.tabla  t " +
                            " where t.cod_estado_registro = '"+t.getEstadosRegistro().getCodEstado()+"' order by t.nombre_tabla asc "; 
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTabla.clear();
            while (rs.next())
            {
                Tabla t1 = new Tabla();
                t1.setCodTabla(rs.getInt("cod_tabla"));
                t1.setNombreTabla(rs.getString("nombre_tabla"));
                t1.setDescripcionTabla(rs.getString("descripcion_tabla"));
                t1.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                
                
                listTabla.add(t1);
            }
            //rs.close();
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return listTabla;
    }
    public  int guardarTabla(Tabla t){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 1;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = "";
            
            
            
            cons = " INSERT INTO ventas.tabla ( cod_tabla,  nombre_tabla,  descripcion_tabla,  cod_estado_registro) "
                    + " VALUES ( (select nextval('ventas.\"seqTabla\"')),  '"+t.getNombreTabla()+"',  '"+t.getDescripcionTabla()+"',  '"+t.getEstadosRegistro().getCodEstado()+"' ); ";
            
            System.out.println("cons " + cons);
            guardado = guardado* statement.executeUpdate(cons);
            
            
            statement.close();
            //connection.close();
            //utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }    
    public  int editarTabla(Tabla t){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 1;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String  cons =   "     UPDATE " +
                                "  ventas.tabla " +
                                "  SET " +                                
                                "  nombre_tabla = '"+t.getNombreTabla()+"', " +
                                "  descripcion_tabla = '"+t.getDescripcionTabla()+"', " +
                                "  cod_estado_registro = '"+t.getEstadosRegistro().getCodEstado()+"' " +
                                "  WHERE " +
                                "  cod_tabla = '"+t.getCodTabla()+"' ; ";
            
            System.out.println("cons " + cons);
            guardado = guardado * statement.executeUpdate(cons);//cuando no se guarde alguno devuelve cero
            
            statement.close();
            //connection.close();
            //utiles.closeConnection();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public int eliminarTabla(Tabla t){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " DELETE FROM ventas.tabla WHERE cod_tabla = '"+t.getCodTabla()+"' ";
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
}
