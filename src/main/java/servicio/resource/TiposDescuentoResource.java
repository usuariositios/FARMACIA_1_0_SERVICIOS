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
import servicio.model.TiposDescuento;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposDescuentoResource {
    Connection con;
    public TiposDescuentoResource(){
    }
    public TiposDescuentoResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarTiposDescuentoItem() {
        List<SelectItem> tiposDescuentoList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_tipo_descuento,nombre_tipo_descuento from ventas.tipos_descuento";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposDescuentoList.clear();
            while (rs.next())
            {
                tiposDescuentoList.add(new SelectItem(rs.getInt("cod_tipo_descuento"), rs.getString("nombre_tipo_descuento")));
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
        return tiposDescuentoList;
    }
    public  List<TiposDescuento> cargarTiposDescuento(TiposDescuento t) {
        List<TiposDescuento> listTiposDescuento =new ArrayList<TiposDescuento>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " SELECT t.cod_tipo_descuento, t.nombre_tipo_descuento,"
                         + " e.cod_estado_registro, e.nombre_estado_registro "+
                           " FROM ventas.tipos_descuento t "+
                           " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposDescuento.clear();
            while (rs.next())
            {
                TiposDescuento r =  new TiposDescuento();
                r.setCodTipoDescuento(rs.getInt("cod_tipo_descuento"));
                r.setNombreTipoDescuento(rs.getString("nombre_tipo_descuento"));
                
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listTiposDescuento.add(r);
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
        return listTiposDescuento;
    }
    public  int guardarTiposDescuento(TiposDescuento e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = "INSERT INTO ventas.tipos_descuento(cod_tipo_descuento, nombre_tipo_descuento, " +
                    " cod_estado_registro) " +
                    " VALUES ((select nextval('public.\"seqTiposDescuento\"')), '"+e.getNombreTipoDescuento()+"','"+e.getEstadosRegistro().getCodEstado()+"');";
            
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
    public  int editarTiposDescuento(TiposDescuento e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE almacenes.tipos_descuento" +
                            " SET  nombre_tipo_descuento='"+e.getNombreTipoDescuento()+"', " +                            
                            " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_descuento='"+e.getCodTipoDescuento()+"' ; ";
            
                    
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
    public  int eliminarTiposDescuento(TiposDescuento e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from ventas.tipos_descuento where cod_tipo_descuento = '"+e.getCodTipoDescuento()+"' ";
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
