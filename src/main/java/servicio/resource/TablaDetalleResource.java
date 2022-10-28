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
import servicio.model.TablaDetalle;
import servicio.model.TiposProveedor;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TablaDetalleResource {
    Connection con;
    public TablaDetalleResource(){
    }
    public TablaDetalleResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarTablaDetalleItem(TablaDetalle td) {
        List<SelectItem> itemList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query =  " select td.cod_campo,td.nombre_campo" +
                            " from ventas.tabla t" +
                            " inner join ventas.tabla_detalle td on t.cod_tabla = td.cod_tabla" +
                            " where t.nombre_tabla = '"+td.getTabla().getNombreTabla()+"' order by td.cod_campo";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            itemList.clear();
            while (rs.next())
            {
                itemList.add(new SelectItem(rs.getInt("cod_campo"), rs.getString("nombre_campo")));
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
    public  List<TablaDetalle> cargarTablaDetalle(TablaDetalle t) {
        List<TablaDetalle> listTablaDetalle =new ArrayList<TablaDetalle>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            String query =  " select td.cod_tabla,td.cod_campo,td.nombre_campo,td.valor_char_campo,td.valor_number_campo,td.valor_date_campo,td.descripcion_campo " +
                            " from ventas.tabla t " +
                            " inner join ventas.tabla_detalle td on t.cod_tabla = td.cod_tabla " +
                            " where t.nombre_tabla = '"+t.getTabla().getNombreTabla()+"' order by td.cod_campo asc "; 
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTablaDetalle.clear();
            while (rs.next())
            {
                TablaDetalle td = new TablaDetalle();
                td.getTabla().setCodTabla(rs.getInt("cod_tabla"));
                td.setCodCampo(rs.getInt("cod_campo"));
                td.setNombreCampo(rs.getString("nombre_campo"));
                td.setValorCharCampo(rs.getString("valor_char_campo"));
                td.setValorNumberCampo(rs.getDouble("valor_number_campo"));
                td.setValorDateCampo(rs.getTimestamp("valor_date_campo")!=null?sdf.format(rs.getTimestamp("valor_date_campo")):"");
                td.setDescripcionCampo(rs.getString("descripcion_campo"));
                
                listTablaDetalle.add(td);
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
        return listTablaDetalle;
    }
    public  int guardarTablaDetalle(TablaDetalle td){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 1;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = "";
            
            cons =   " INSERT INTO ventas.tabla_detalle " +
                            " (cod_tabla,  cod_campo,  nombre_campo,valor_char_campo,valor_number_campo,valor_date_campo,descripcion_campo) " +
                            " VALUES ('"+td.getTabla().getCodTabla()+"',(select max(cod_campo)+1 from ventas.tabla_detalle where cod_tabla = '"+td.getTabla().getCodTabla()+"' ), '"+td.getNombreCampo()+"', '"+td.getValorCharCampo()+"','"+td.getValorNumberCampo()+"',"+(td.getValorDateCampo().equals("")?"null":"'"+ td.getValorDateCampo()+"'") +",'"+td.getDescripcionCampo()+"');";
            
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
    public  int guardarTablaDetalle1(List<TablaDetalle> tdList){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 1;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = "";
            for(TablaDetalle td:tdList){
            cons =   " INSERT INTO ventas.tabla_detalle " +
                            " (cod_tabla,  cod_campo,  nombre_campo,valor_char_campo,valor_number_campo,valor_date_campo,descripcion_campo) " +
                            " VALUES ('"+td.getTabla().getCodTabla()+"',(select nextval('ventas.\"seqCodCampo\"')), '"+td.getNombreCampo()+"', '"+td.getValorCharCampo()+"','"+td.getValorNumberCampo()+"','"+td.getValorDateCampo()+"','"+td.getDescripcionCampo()+"');";
            
            System.out.println("cons " + cons);
            guardado = guardado* statement.executeUpdate(cons);
            }
            
            statement.close();
            //connection.close();
            //utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int editarTablaDetalle(TablaDetalle td){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 1;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String  cons = "";
            
                cons =   " UPDATE ventas.tabla_detalle " +
                            " SET nombre_campo='"+td.getNombreCampo()+"', "+
                            " valor_char_campo='"+td.getValorCharCampo()+"', " +
                            " valor_number_campo='"+td.getValorNumberCampo()+"', " +
                            " valor_date_campo="+(td.getValorDateCampo().trim().equals("")?"null":"'"+td.getValorDateCampo()+"'")+", " +
                            " descripcion_campo='"+td.getDescripcionCampo()+"' " +
                            " WHERE cod_tabla='"+td.getTabla().getCodTabla()+"'  "+
                            " and cod_campo='"+td.getCodCampo()+"' ; ";
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
    public  int editarTablaDetalle1(List<TablaDetalle> tdList){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 1;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String  cons = "";
            for(TablaDetalle td: tdList){
                cons =   " UPDATE ventas.tabla_detalle " +
                            " SET nombre_campo='"+td.getNombreCampo()+"', "+
                            " valor_char_campo='"+td.getValorCharCampo()+"', " +
                            " valor_number_campo='"+td.getValorNumberCampo()+"', " +
                            " valor_date_campo="+(td.getValorDateCampo().trim().equals("")?"null":"'"+td.getValorDateCampo()+"'")+", " +
                            " descripcion_campo='"+td.getDescripcionCampo()+"' " +
                            " WHERE cod_tabla='"+td.getTabla().getCodTabla()+"'  "+
                            " and cod_campo='"+td.getCodCampo()+"' ; ";
            System.out.println("cons " + cons);
            guardado = guardado * statement.executeUpdate(cons);//cuando no se guarde alguno devuelve cero
            }
            statement.close();
            //connection.close();
            //utiles.closeConnection();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int eliminarTablaDetalle(TablaDetalle t){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from public.tipos_proveedor where cod_tipo_proveedor = '"+t.getCodCampo()+"' ";
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
