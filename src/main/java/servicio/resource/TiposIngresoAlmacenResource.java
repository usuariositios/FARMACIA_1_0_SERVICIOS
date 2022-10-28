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
import servicio.model.TiposIngresoVenta;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposIngresoAlmacenResource {
    Connection con;
    public TiposIngresoAlmacenResource(){
    }
    public TiposIngresoAlmacenResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarTiposIngresoAlmacenItem() {
        List<SelectItem> tiposIngresoAlmacenList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_tipo_ingreso_almacen,nombre_tipo_ingreso_almacen from almacenes.tipos_ingreso_almacen";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposIngresoAlmacenList.clear();
            while (rs.next())
            {
                tiposIngresoAlmacenList.add(new SelectItem(rs.getInt("cod_tipo_ingreso_almacen"), rs.getString("nombre_tipo_ingreso_almacen")));
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
        return tiposIngresoAlmacenList;
    }
    public  List<TiposIngresoVenta> cargarTiposIngresoAlmacen(TiposIngresoVenta t) {
        List<TiposIngresoVenta> listTiposIngresoAlmacen =new ArrayList<TiposIngresoVenta>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " SELECT t.cod_tipo_ingreso_almacen, t.nombre_tipo_ingreso_almacen,t.obs_tipo_ingreso_almacen,"
                         + " e.cod_estado_registro, e.nombre_estado_registro "+
                           " FROM almacenes.tipos_ingreso_almacen t "+
                           " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposIngresoAlmacen.clear();
            while (rs.next())
            {
                TiposIngresoVenta r =  new TiposIngresoVenta();
                r.setCodTipoIngresoVenta(rs.getInt("cod_tipo_ingreso_almacen"));
                r.setNombreTipoIngresoVenta(rs.getString("nombre_tipo_ingreso_almacen"));
                r.setObsTipoIngresoVenta(rs.getString("obs_tipo_ingreso_almacen"));
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listTiposIngresoAlmacen.add(r);
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
        return listTiposIngresoAlmacen;
    }
    public  int guardarTiposIngresoAlmacen(TiposIngresoVenta e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = "INSERT INTO almacenes.tipos_ingreso_almacen(cod_tipo_ingreso_almacen, nombre_tipo_ingreso_almacen, obs_tipo_ingreso_almacen, " +
                    " cod_estado_registro) " +
                    " VALUES ((select nextval('almacenes.\"seqTiposIngresoAlmacen\"')), '"+e.getNombreTipoIngresoVenta()+"', '"+e.getObsTipoIngresoVenta()+"', " +
                    "         '"+e.getEstadosRegistro().getCodEstado()+"');";
            
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
    public int codTipoComposicionProducto(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarTiposIngresoAlmacen(TiposIngresoVenta e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE almacenes.tipos_ingreso_almacen" +
                            " SET  nombre_tipo_ingreso_almacen='"+e.getNombreTipoIngresoVenta()+"', obs_tipo_ingreso_almacen='"+e.getObsTipoIngresoVenta()+"', " +
                            " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_ingreso_almacen='"+e.getCodTipoIngresoVenta()+"' ; ";
            
                    
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
    public  int eliminarTiposIngresoAlmacen(TiposIngresoVenta e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from almacenes.tipos_ingreso_almacen where cod_tipo_ingreso_almacen = '"+e.getCodTipoIngresoVenta()+"' ";
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
