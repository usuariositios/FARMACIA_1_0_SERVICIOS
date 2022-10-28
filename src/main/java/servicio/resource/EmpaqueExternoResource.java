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

import servicio.model.EmpaqueExterno;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class EmpaqueExternoResource {
    /*
    public static List<SelectItem> cargarEmpaqueExternoItem() {
        List<SelectItem> empaqueExternoList =new ArrayList<SelectItem>();
        try {
            
            Connection con = Utiles.getConnection();
            
            String query = "SELECT cod_empaque_externo,nombre_empaque_externo from public.empaque_externo";
            System.out.println("consulta " +query);

            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            empaqueExternoList.clear();
            while (rs.next())
            {
                empaqueExternoList.add(new SelectItem(rs.getInt("cod_empaque_externo"), rs.getString("nombre_empaque_externo")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return empaqueExternoList;
    }
    public static List<EmpaqueExterno> cargarEmpaqueExterno(EmpaqueExterno t) {
        List<EmpaqueExterno> listEmpaqueExterno =new ArrayList<EmpaqueExterno>();
        try {
            Connection connection = Utiles.getConnection();
            
            String query = " SELECT cod_empaque_externo, nombre_empaque_externo, " +
                    " obs_empaque_externo, cod_estado_registro " +
                    " FROM public.empaque_externo;";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listEmpaqueExterno.clear();
            while (rs.next())
            {
                EmpaqueExterno r =  new EmpaqueExterno();
                r.setCodEmpaqueExterno(rs.getInt("cod_empaque_externo"));
                r.setNombreEmpaqueExterno(rs.getString("nombre_empaque_externo"));
                r.setObsEmpaqueExterno(rs.getString("obs_empaque_externo"));
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listEmpaqueExterno.add(r);
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
        return listEmpaqueExterno;
    }
    public static int guardarEmpaqueExterno(EmpaqueExterno e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            Connection connection = Utiles.getConnection();
            Statement statement = connection.createStatement();
            String cons = "INSERT INTO public.empaque_externo(cod_empaque_externo, nombre_empaque_externo, obs_empaque_externo, " +
                    " cod_estado_registro) " +
                    " VALUES ((select nextval('public.\"seqEmpaqueExterno\"')), '"+e.getNombreEmpaqueExterno()+"', '"+e.getObsEmpaqueExterno()+"', " +
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
    public static int editarEmpaqueExterno(EmpaqueExterno e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Connection connection = Utiles.getConnection();
            Statement statement = connection.createStatement();
            String cons =   " UPDATE public.empaques_externo" +
                            " SET  nombre_empaque_externo='"+e.getNombreEmpaqueExterno()+"', obs_empaque_externo='"+e.getObsEmpaqueExterno()+"', " +
                            " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_empaque_externo='"+e.getCodEmpaqueExterno()+"' ; ";
                    
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
    public static int eliminarEmpaqueExterno(EmpaqueExterno e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Connection connection = Utiles.getConnection();
            Statement statement = connection.createStatement();
            String cons = " delete from public.empaque_externo where cod_empaque_externo = '"+e.getCodEmpaqueExterno()+"' ";
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
