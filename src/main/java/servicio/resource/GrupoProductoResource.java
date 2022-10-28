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


import servicio.model.GruposProducto;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class GrupoProductoResource {
    Connection con;
    public GrupoProductoResource(){
    }
    public GrupoProductoResource(Connection con){
        this.con = con;
    }
    public  List<GruposProducto> cargarGruposProducto(GruposProducto gr) {
        List<GruposProducto> listGruposProducto =new ArrayList<GruposProducto>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " SELECT  g.cod_grupo_producto, g.nombre_grupo_producto, g.cod_estado_registro, e.nombre_estado_registro "
                    + " FROM  public.grupo_producto g"
                    + " inner join estados_registro e on e.cod_estado_registro = g.cod_estado_registro where 0=0";
                    if(!gr.getNombreGrupoProducto().trim().equals("")){query+=" AND g.nombre_grupo_producto like '%"+gr.getNombreGrupoProducto() +"%' ";}
                    if(gr.getEstadosRegistro().getCodEstado()!=0){query+=" AND e.cod_estado_registro = '"+gr.getEstadosRegistro().getCodEstado() +"' ";}
                    query += "order by g.nombre_grupo_producto asc;";
            
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listGruposProducto.clear();
            while (rs.next())
            {
                GruposProducto  g = new GruposProducto();
                g.setCodGrupoProducto(rs.getInt("cod_grupo_producto"));
                g.setNombreGrupoProducto(rs.getString("nombre_grupo_producto"));
                g.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                g.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listGruposProducto.add(g);
            }
            rs.close();
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return listGruposProducto;
    }
    public  int guardarGrupoProducto(GruposProducto g){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String 
            
            cons = " INSERT INTO public.grupo_producto(  cod_grupo_producto,  nombre_grupo_producto,  cod_estado_registro) " +
                   " VALUES (  (select nextval('public.\"seqGrupoProducto\"')),  '"+g.getNombreGrupoProducto()+"',  '"+g.getEstadosRegistro().getCodEstado()+"'); ";
            
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
    public int codCiudad(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarGrupoProducto(GruposProducto g){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE public.grupo_producto " +
                            " SET nombre_grupo_producto = '"+g.getNombreGrupoProducto()+"'," +
                            " cod_estado_registro = '"+g.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_grupo_producto = '"+g.getCodGrupoProducto()+"' ; ";
            
                    
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
    public  int eliminarGrupoProducto(GruposProducto e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from public.grupo_producto where cod_grupo_producto = '"+e.getCodGrupoProducto()+"' ";
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
    public  List<SelectItem> cargarGrupoProductoItem() {
        List<SelectItem> grupoProductoList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_grupo_producto,nombre_grupo_producto from public.grupo_producto order by nombre_grupo_producto asc  ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            grupoProductoList.clear();
            while (rs.next())
            {
                grupoProductoList.add(new SelectItem(rs.getInt("cod_grupo_producto"), rs.getString("nombre_grupo_producto")));
            }
            rs.close();
            //con.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return grupoProductoList;
    }
    
}
