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

import servicio.model.CapitulosMaterial;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class CapitulosMaterialResource {
    /*
    public static List<SelectItem> cargarCapitulosMaterialItem() {
        List<SelectItem> tiposIngresoAlmacenList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            
            String query = "SELECT cod_capitulo,nombre_capitulo from almacenes.capitulos_material";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposIngresoAlmacenList.clear();
            while (rs.next())
            {
                tiposIngresoAlmacenList.add(new SelectItem(rs.getInt("cod_capitulo"), rs.getString("nombre_capitulo")));
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
        return tiposIngresoAlmacenList;
    }
    public static List<CapitulosMaterial> cargarCapitulosMaterial(CapitulosMaterial t) {
        List<CapitulosMaterial> listCapitulosMaterial =new ArrayList<CapitulosMaterial>();
        try {
            
            Utiles utiles = new Utiles();
            
            String query = " SELECT t.cod_tipo_ingreso_almacen, t.nombre_tipo_ingreso_almacen,t.obs_tipo_ingreso_almacen,"
                         + " e.cod_estado_registro, e.nombre_estado_registro "+
                           " FROM almacenes.tipos_ingreso_almacen t "+
                           " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listCapitulosMaterial.clear();
            while (rs.next())
            {
                CapitulosMaterial r =  new CapitulosMaterial();
                r.setCodCapituloMaterial(rs.getInt("cod_tipo_ingreso_almacen"));
                r.setNombreCapituloMaterial(rs.getString("nombre_tipo_ingreso_almacen"));
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listCapitulosMaterial.add(r);
            }
            rs.close();
            statement.close();
            utiles.closeConnection();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return listCapitulosMaterial;
    }
    public static int guardarCapitulosMaterial(CapitulosMaterial e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            Utiles utiles = new Utiles();
            Statement statement = utiles.getCon().createStatement();
            //String cons = "INSERT INTO almacenes.tipos_ingreso_almacen(cod_tipo_ingreso_almacen, nombre_tipo_ingreso_almacen, obs_tipo_ingreso_almacen, " +
            //        " cod_estado_registro) " +
            //        " VALUES ((select nextval('almacenes.\"seqCapitulosMaterial\"')), '"+e.getNombreGrupoMaterial()+"', '"+e.getObsGrupoMaterial()+"', " +
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
    public static int editarCapitulosMaterial(CapitulosMaterial e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Utiles utiles = new Utiles();
            Statement statement = connection.createStatement();
            String cons =   "";
                            " UPDATE almacenes.tipos_ingreso_almacen" +
                            " SET  nombre_tipo_ingreso_almacen='"+e.getNombreGrupoMaterial()+"', " +
                            " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_ingreso_almacen='"+e.getCodGrupoMaterial()+"' ; ";
            
                    
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public static int eliminarCapitulosMaterial(CapitulosMaterial e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Utiles utiles = new Utiles();
            Statement statement = connection.createStatement();
            String cons = " delete from almacenes.tipos_ingreso_almacen where cod_tipo_ingreso_almacen = '' "; //"+e.getCodGrupoMaterial()+"
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
*/
}
