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
import servicio.model.TiposSalidaVenta;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposSalidaAlmacenResource {
    Connection con;
    public TiposSalidaAlmacenResource(){
    }
    public TiposSalidaAlmacenResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarTiposSalidaAlmacenItem() {
        List<SelectItem> tiposSalidaAlmacenList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_tipo_salida_almacen,nombre_tipo_salida_almacen from almacenes.tipos_salida_almacen";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposSalidaAlmacenList.clear();
            while (rs.next())
            {
                tiposSalidaAlmacenList.add(new SelectItem(rs.getInt("cod_tipo_salida_almacen"), rs.getString("nombre_tipo_salida_almacen")));
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
        return tiposSalidaAlmacenList;
    }
    public  List<TiposSalidaVenta> cargarTiposSalidaAlmacen(TiposSalidaVenta t) {
        List<TiposSalidaVenta> listTiposSalidaAlmacen =new ArrayList<TiposSalidaVenta>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " SELECT t.cod_tipo_salida_almacen, t.nombre_tipo_salida_almacen,t.obs_tipo_salida_almacen,"
                         + " e.cod_estado_registro, e.nombre_estado_registro "+
                           " FROM almacenes.tipos_salida_almacen t "+
                           " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposSalidaAlmacen.clear();
            while (rs.next())
            {
                TiposSalidaVenta r =  new TiposSalidaVenta();
                r.setCodTipoSalidaVenta(rs.getInt("cod_tipo_salida_almacen"));
                r.setNombreTipoSalidaVenta(rs.getString("nombre_tipo_salida_almacen"));
                r.setObsTipoSalidaVenta(rs.getString("obs_tipo_salida_almacen"));
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listTiposSalidaAlmacen.add(r);
            }
            //rs.close();
            statement.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return listTiposSalidaAlmacen;
    }
    public  int guardarTiposSalidaAlmacen(TiposSalidaVenta e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = "INSERT INTO almacenes.tipos_salida_almacen(cod_tipo_salida_almacen, nombre_tipo_salida_almacen, obs_tipo_salida_almacen, " +
                    " cod_estado_registro) " +
                    " VALUES ((select nextval('almacenes.\"seqTiposSalidaAlmacen\"')), '"+e.getNombreTipoSalidaVenta()+"', '"+e.getObsTipoSalidaVenta()+"', " +
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
    public  int editarTiposSalidaAlmacen(TiposSalidaVenta e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE almacenes.tipos_salida_almacen" +
                            " SET  nombre_tipo_salida_almacen='"+e.getNombreTipoSalidaVenta()+"', obs_tipo_salida_almacen='"+e.getObsTipoSalidaVenta()+"', " +
                            " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_salida_almacen='"+e.getCodTipoSalidaVenta()+"' ; ";
            
                    
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
    public  int eliminarTiposSalidaAlmacen(TiposSalidaVenta e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from almacenes.tipos_salida_almacen where cod_tipo_salida_almacen = '"+e.getCodTipoSalidaVenta()+"' ";
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
