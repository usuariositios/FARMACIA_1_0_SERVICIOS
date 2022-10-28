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
import servicio.model.EstadosMaterial;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class EstadosMaterialResource {
    /*
    public static List<EstadosMaterial> cargarEstadosMaterial() {
        List<EstadosMaterial> listEstadosMaterial =new ArrayList<EstadosMaterial>();
        try {
            
            Connection connection = Utiles.getConnection();

            
            String query = " SELECT m.cod_estado_material, m.nombre_estado_material, m.obs_estado_material, " +
                    " m.imagen_estado_material, e.cod_estado_registro,e.nombre_estado_registro " +
                    " FROM almacenes.estados_material m"
                  + " inner join estados_registro e on e.cod_estado_registro = m.cod_estado_registro ;";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listEstadosMaterial.clear();
            while (rs.next())
            {
                EstadosMaterial  e = new EstadosMaterial();
                e.setCodEstadoMaterial(rs.getInt("cod_estado_material"));
                e.setNombreEstadoMaterial(rs.getString("nombre_estado_material"));
                e.setObsEstadoMaterial(rs.getString("obs_estado_material"));
                e.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                e.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listEstadosMaterial.add(e);
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return listEstadosMaterial;
    }
    public static int guardarAlmacen(EstadosMaterial e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            Connection connection = Utiles.getConnection();
            Statement statement = connection.createStatement();
            String cons =  " INSERT INTO almacenes.estados_material( cod_estado_material, nombre_estado_material, obs_estado_material, " +
                    " imagen_estado_material, cod_estado_registro) " +
                    " VALUES ((select nextval('almacenes.\"seqEstadosMaterial\"')), '"+e.getNombreEstadoMaterial()+"', '"+e.getObsEstadoMaterial()+"', null, '"+e.getEstadosRegistro().getCodEstado()+"'); ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            connection.close();
            
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
    public static int editarAlmacen(EstadosMaterial e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Connection connection = Utiles.getConnection();
            Statement statement = connection.createStatement();
            String cons =  " UPDATE almacenes.estados_material " +
                    " SET nombre_estado_material='"+e.getNombreEstadoMaterial()+"', obs_estado_material='"+e.getObsEstadoMaterial()+"', " +
                    " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" + //imagen_estado_material='"+e+"',
                    " WHERE cod_estado_material= '"+e.getCodEstadoMaterial()+"' ;";
            
                    
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public static int eliminarAlmacen(EstadosMaterial e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Connection connection = Utiles.getConnection();
            Statement statement = connection.createStatement();
            String cons = " delete from estados_material where cod_estado_material = '"+e.getCodEstadoMaterial()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
    public static List cargarEstadosMaterialItem() {
        List estadosMaterialList =new ArrayList();
        try {
            
            Connection con = Utiles.getConnection();

            
            String query = " SELECT m.cod_estado_material, m.nombre_estado_material from almacenes.estados_material m";
            System.out.println("consulta " +query);

            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            estadosMaterialList.clear();
            while (rs.next())
            {
                estadosMaterialList.add(new SelectItem(rs.getInt("cod_estado_material"), rs.getString("nombre_estado_material")));
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return estadosMaterialList;
    }
*/
    
}
