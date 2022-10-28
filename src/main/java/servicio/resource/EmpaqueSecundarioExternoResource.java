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

import servicio.model.EmpaqueSecundarioExterno;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class EmpaqueSecundarioExternoResource {
    /*
    public static List<SelectItem> cargarEmpaqueSecundarioExternoItem() {
        List<SelectItem> tiposIngresoAlmacenList =new ArrayList<SelectItem>();
        try {
            
            Connection con = Utiles.getConnection();
            
            String query = "SELECT cod_empaque_secundario_externo,nombre_empaque_secundario_externo from almacenes.empaque_secundario_externo";
            System.out.println("consulta " +query);

            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposIngresoAlmacenList.clear();
            while (rs.next())
            {
                tiposIngresoAlmacenList.add(new SelectItem(rs.getInt("cod_empaque_secundario_externo"), rs.getString("nombre_empaque_secundario_externo")));
            }
            rs.close();
            statement.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return tiposIngresoAlmacenList;
    }
    public static List<EmpaqueSecundarioExterno> cargarEmpaqueSecundarioExterno(EmpaqueSecundarioExterno t) {
        List<EmpaqueSecundarioExterno> listEmpaqueSecundarioExterno =new ArrayList<EmpaqueSecundarioExterno>();
        try {
            Connection connection = Utiles.getConnection();
            
            String query = " SELECT cod_empaque_secundario_externo, nombre_empaque_secundario_externo, " +
                    " obs_empaque_secundario_externo, cod_estado_registro " +
                    " FROM almacenes.empaques_secundario_externo;";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listEmpaqueSecundarioExterno.clear();
            while (rs.next())
            {
                EmpaqueSecundarioExterno r =  new EmpaqueSecundarioExterno();
                r.setCodEmpaqueSecundarioExterno(rs.getInt("cod_empaque_secundario_externo"));
                r.setNombreEmpaqueSecundarioExterno(rs.getString("nombre_empaque_secundario_externo"));
                r.setObsEmpaqueSecundarioExterno(rs.getString("obs_empaque_secundario_externo"));
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listEmpaqueSecundarioExterno.add(r);
            }
            rs.close();
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return listEmpaqueSecundarioExterno;
    }
    public static int guardarEmpaqueSecundarioExterno(EmpaqueSecundarioExterno e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            Connection connection = Utiles.getConnection();
            Statement statement = connection.createStatement();
            String cons = "INSERT INTO almacenes.empaques_secundario_externo(cod_empaque_secundario_externo, nombre_empaque_secundario_externo, obs_empaque_secundario_externo, " +
                    " cod_estado_registro) " +
                    " VALUES ((select nextval('almacenes.\"seqEmpaqueSecundarioExterno\"')), '"+e.getNombreEmpaqueSecundarioExterno()+"', '"+e.getObsEmpaqueSecundarioExterno()+"', " +
                    "         '"+e.getEstadosRegistro().getCodEstado()+"');";
            
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
    public int codTipoComposicionProducto(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public static int editarEmpaqueSecundarioExterno(EmpaqueSecundarioExterno e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Connection connection = Utiles.getConnection();
            Statement statement = connection.createStatement();
            String cons =   " UPDATE almacenes.empaques_secundario_externo" +
                            " SET  nombre_empaque_secundario_externo='"+e.getNombreEmpaqueSecundarioExterno()+"', obs_empaque_secundario_externo='"+e.getObsEmpaqueSecundarioExterno()+"', " +
                            " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_empaque_secundario_externo='"+e.getCodEmpaqueSecundarioExterno()+"' ; ";
                    
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
    public static int eliminarEmpaqueSecundarioExterno(EmpaqueSecundarioExterno e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Connection connection = Utiles.getConnection();
            Statement statement = connection.createStatement();
            String cons = " delete from almacenes.empaques_secundario_externo where cod_empaque_secundario_externo = '"+e.getCodEmpaqueSecundarioExterno()+"' ";
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
