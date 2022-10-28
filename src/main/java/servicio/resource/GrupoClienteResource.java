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


import servicio.model.GruposCliente;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class GrupoClienteResource {
    Connection con;
    public GrupoClienteResource(){
    }
    public GrupoClienteResource(Connection con){
        this.con = con;
    }
    public  List<GruposCliente> cargarGruposCliente(GruposCliente gr) {
        List<GruposCliente> listGruposCliente =new ArrayList<GruposCliente>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " SELECT  g.cod_grupo_cliente, g.nombre_grupo_cliente, g.cod_estado_registro, e.nombre_estado_registro "
                    + " FROM  public.grupo_cliente g"
                    + " inner join estados_registro e on e.cod_estado_registro = g.cod_estado_registro where 0=0";
                    if(!gr.getNombreGrupoCliente().trim().equals("")){query+=" AND g.nombre_grupo_cliente like '%"+gr.getNombreGrupoCliente() +"%' ";}
                    if(gr.getEstadosRegistro().getCodEstado()!=0){query+=" AND e.cod_estado_registro = '"+gr.getEstadosRegistro().getCodEstado() +"' ";}
                    query += "order by g.nombre_grupo_cliente asc;";
            
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listGruposCliente.clear();
            while (rs.next())
            {
                GruposCliente  g = new GruposCliente();
                g.setCodGrupoCliente(rs.getInt("cod_grupo_cliente"));
                g.setNombreGrupoCliente(rs.getString("nombre_grupo_cliente"));
                g.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                g.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listGruposCliente.add(g);
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
        return listGruposCliente;
    }
    public  int guardarGrupoCliente(GruposCliente g){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String 
            
            cons = " INSERT INTO public.grupo_cliente(  cod_grupo_cliente,  nombre_grupo_cliente,  cod_estado_registro) " +
                   " VALUES (  (select nextval('public.\"seqGrupoProducto\"')),  '"+g.getNombreGrupoCliente()+"',  '"+g.getEstadosRegistro().getCodEstado()+"'); ";
            
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
    public  int editarGrupoCliente(GruposCliente g){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE public.grupo_cliente " +
                            " SET nombre_grupo_cliente = '"+g.getNombreGrupoCliente()+"'," +
                            " cod_estado_registro = '"+g.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_grupo_cliente = '"+g.getCodGrupoCliente()+"' ; ";
            
                    
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
    public  int eliminarGrupoCliente(GruposCliente e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from public.grupo_cliente where cod_grupo_cliente = '"+e.getCodGrupoCliente()+"' ";
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
    public  List<SelectItem> cargarGrupoClienteItem() {
        List<SelectItem> grupoProductoList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_grupo_cliente,nombre_grupo_cliente from public.grupo_cliente order by nombre_grupo_cliente asc  ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            grupoProductoList.clear();
            while (rs.next())
            {
                grupoProductoList.add(new SelectItem(rs.getInt("cod_grupo_cliente"), rs.getString("nombre_grupo_cliente")));
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
        return grupoProductoList;
    }
    
}
