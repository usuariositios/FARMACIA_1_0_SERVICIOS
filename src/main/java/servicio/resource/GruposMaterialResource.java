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

import servicio.model.GruposMaterial;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class GruposMaterialResource {
    public  List<SelectItem> cargarGruposMaterialItem(GruposMaterial t) {
        List<SelectItem> tiposIngresoAlmacenList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_grupo,nombre_grupo from almacenes.grupos_material where 0=0";
            if(t.getCapitulosMaterial().getCodCapituloMaterial()!=0){query+=" AND cod_capitulo = '"+t.getCapitulosMaterial().getCodCapituloMaterial()+"' ";}
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposIngresoAlmacenList.clear();
            while (rs.next())
            {
                tiposIngresoAlmacenList.add(new SelectItem(rs.getInt("cod_grupo"), rs.getString("nombre_grupo")));
            }
            rs.close();
            statement.close();
            //con.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return tiposIngresoAlmacenList;
    }
    public  List<GruposMaterial> cargarGruposMaterial(GruposMaterial t) {
        List<GruposMaterial> listGruposMaterial =new ArrayList<GruposMaterial>();
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
            listGruposMaterial.clear();
            while (rs.next())
            {
                GruposMaterial r =  new GruposMaterial();
                r.setCodGrupoMaterial(rs.getInt("cod_tipo_ingreso_almacen"));
                r.setNombreGrupoMaterial(rs.getString("nombre_tipo_ingreso_almacen"));
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listGruposMaterial.add(r);
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
        return listGruposMaterial;
    }
    public  int guardarGruposMaterial(GruposMaterial e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            //String cons = "INSERT INTO almacenes.tipos_ingreso_almacen(cod_tipo_ingreso_almacen, nombre_tipo_ingreso_almacen, obs_tipo_ingreso_almacen, " +
            //        " cod_estado_registro) " +
            //        " VALUES ((select nextval('almacenes.\"seqGruposMaterial\"')), '"+e.getNombreGrupoMaterial()+"', '"+e.getObsGrupoMaterial()+"', " +
            //        "         '"+e.getEstadosRegistro().getCodEstado()+"');";
            String cons=""; 
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
    public int codTipoComposicionProducto(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarGruposMaterial(GruposMaterial e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons =   " UPDATE almacenes.tipos_ingreso_almacen" +
                            " SET  nombre_tipo_ingreso_almacen='"+e.getNombreGrupoMaterial()+"', " +
                            " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_ingreso_almacen='"+e.getCodGrupoMaterial()+"' ; ";
            
                    
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
    public  int eliminarGruposMaterial(GruposMaterial e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = " delete from almacenes.tipos_ingreso_almacen where cod_tipo_ingreso_almacen = '"+e.getCodGrupoMaterial()+"' ";
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
