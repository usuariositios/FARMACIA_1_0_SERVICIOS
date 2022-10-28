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
import servicio.model.TiposProveedor;
import servicio.model.TiposProveedor;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposProveedorResource {
    Connection con;
    public TiposProveedorResource(){
    }
    public TiposProveedorResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarTiposProveedorItem() {
        List<SelectItem> tiposProveedorList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_tipo_proveedor,nombre_tipo_proveedor from public.tipos_proveedor";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposProveedorList.clear();
            while (rs.next())
            {
                tiposProveedorList.add(new SelectItem(rs.getInt("cod_tipo_proveedor"), rs.getString("nombre_tipo_proveedor")));
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
        return tiposProveedorList;
    }
    public  List<TiposProveedor> cargarTiposProveedor(TiposProveedor t) {
        List<TiposProveedor> listTiposProveedor =new ArrayList<TiposProveedor>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            String query = " SELECT t.cod_tipo_proveedor, t.nombre_tipo_proveedor, t.cod_estado_registro, e.nombre_estado_registro " +
                           " FROM public.tipos_proveedor t "+
                           " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposProveedor.clear();
            while (rs.next())
            {
                TiposProveedor r =  new TiposProveedor();
                r.setCodTipoProveedor(rs.getInt("cod_tipo_proveedor"));
                r.setNombreTipoProveedor(rs.getString("nombre_tipo_proveedor"));                
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listTiposProveedor.add(r);
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
        return listTiposProveedor;
    }
    public  int guardarTiposProveedor(TiposProveedor t){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " INSERT INTO public.tipos_proveedor " +
                            " (cod_tipo_proveedor,  nombre_tipo_proveedor,  cod_estado_registro) " +
                            " VALUES ((select nextval('public.\"seqTiposProveedor\"')), '"+t.getNombreTipoProveedor()+"', '"+t.getEstadosRegistro().getCodEstado()+"');";
            
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
    public  int editarTiposProveedor(TiposProveedor t){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE public.tipos_proveedor" +
                            " SET  nombre_tipo_proveedor='"+t.getNombreTipoProveedor()+"',"+                            
                            " cod_estado_registro='"+t.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_proveedor='"+t.getCodTipoProveedor()+"' ; ";
            
                    
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
    public  int eliminarTiposProveedor(TiposProveedor t){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from public.tipos_proveedor where cod_tipo_proveedor = '"+t.getCodTipoProveedor()+"' ";
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
