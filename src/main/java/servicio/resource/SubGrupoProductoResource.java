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


import servicio.model.SubGruposProducto;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class SubGrupoProductoResource {
    Connection con;
    public SubGrupoProductoResource(){
    }
    public SubGrupoProductoResource(Connection con){
        this.con = con;
    }
    public  List<SubGruposProducto> cargarSubGruposProducto(SubGruposProducto s) {
        List<SubGruposProducto> listSubGruposProducto =new ArrayList<SubGruposProducto>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " SELECT g.cod_grupo_producto,g.nombre_grupo_producto,s.cod_sub_grupo,s.nombre_sub_grupo,s.descripcion,e.cod_estado_registro,e.nombre_estado_registro "+
                           " FROM  " +
                           " public.sub_grupos_producto s" +
                           " left outer join public.grupo_producto g on g.cod_grupo_producto = s.cod_grupo  "+
                           " left outer join public.estados_registro e on e.cod_estado_registro = s.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listSubGruposProducto.clear();
            while (rs.next())
            {
                SubGruposProducto  g = new SubGruposProducto();
                g.getGruposProducto().setCodGrupoProducto(rs.getInt("cod_grupo_producto"));
                g.getGruposProducto().setNombreGrupoProducto(rs.getString("nombre_grupo_producto"));
                g.setCodSubgrupo(rs.getInt("cod_sub_grupo"));
                g.setNombreSubGrupo(rs.getString("nombre_sub_grupo"));
                g.setDescripcion(rs.getString("descripcion"));
                g.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                g.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listSubGruposProducto.add(g);
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
        return listSubGruposProducto;
    }
    public  int guardarSubGrupoProducto(SubGruposProducto g){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String 
            
            cons =  " INSERT INTO  " +
                    " public.sub_grupos_producto " +
                    "(cod_grupo,cod_sub_grupo,nombre_sub_grupo,descripcion,cod_estado_registro) " +
                    " VALUES ('"+g.getGruposProducto().getCodGrupoProducto()+"',(select nextval('public.\"seqSubGrupoProducto\"')),  '"+g.getNombreSubGrupo()+"',  '"+g.getDescripcion()+"',  '"+g.getEstadosRegistro().getCodEstado()+"'); ";
            
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
    public  int editarSubGrupoProducto(SubGruposProducto g){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE  " +
                            " public.sub_grupos_producto  " +
                            " SET  " +
                            " nombre_sub_grupo = '"+g.getNombreSubGrupo()+"', " +
                            " descripcion = '"+g.getDescripcion()+"', " +
                            " cod_estado_registro = '"+g.getEstadosRegistro().getCodEstado()+"'," +
                            " cod_grupo = '"+g.getGruposProducto().getCodGrupoProducto()+"' " +
                            " WHERE " +
                            " cod_sub_grupo = '"+g.getCodSubgrupo()+"' ";
                    
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
    public  int eliminarSubGrupoProducto(SubGruposProducto e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from public.sub_grupos_producto where cod_sub_grupo = '"+e.getCodSubgrupo()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //cod_grupo = '"+e.getGruposProducto().getCodGrupoProducto()+"' and
            //connection.close();
            //utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  List<SelectItem> cargarSubGrupoProductoItem(SubGruposProducto s) {
        List<SelectItem> grupoProductoList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = " SELECT cod_sub_grupo,nombre_sub_grupo from public.sub_grupos_producto where 0=0 ";
                    if(s.getGruposProducto().getCodGrupoProducto() !=0){
                        query +=" and cod_grupo = '"+s.getGruposProducto().getCodGrupoProducto()+"' ";
                    }
                    query +=" order by nombre_sub_grupo asc  ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            grupoProductoList.clear();
            while (rs.next())
            {
                grupoProductoList.add(new SelectItem(rs.getInt("cod_sub_grupo"), rs.getString("nombre_sub_grupo")));
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
        return grupoProductoList;
    }
    
}
