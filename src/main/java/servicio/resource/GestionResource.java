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
import servicio.model.Gestion;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class GestionResource {
    Connection con;
    public GestionResource(){
    }
    public GestionResource(Connection con){
        this.con = con;
    }
    public  List<Gestion> cargarGestiones() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Gestion> listGestion =new ArrayList<Gestion>();
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " select gs.cod_gestion,gs.nombre_gestion,gs.fecha_inicio,gs.fecha_final,e.cod_estado_registro,e.nombre_estado_registro from gestiones gs inner join estados_registro e on e.cod_estado_registro = gs.cod_estado_registro";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listGestion.clear();
            while (rs.next())
            {
                Gestion gest = new Gestion();
                gest.setCodGestion(rs.getInt("cod_gestion"));
                gest.setNombreGestion(rs.getString("nombre_gestion"));
                gest.setFechaInicio(sdf.format(rs.getTimestamp("fecha_inicio")));
                gest.setFechaFinal(sdf.format(rs.getTimestamp("fecha_final")));
                gest.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                gest.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                listGestion.add(gest);
            }
            rs.close();
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return listGestion;
    }
    public  Gestion gestionActiva() {
        Gestion gest = new Gestion();
        List<Gestion> listGestion =new ArrayList<Gestion>();
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " select cod_gestion,nombre_gestion from gestiones where cod_estado_registro = 1 ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listGestion.clear();
            
            if(rs.next())
            {
                gest.setCodGestion(rs.getInt("cod_gestion"));
                gest.setNombreGestion(rs.getString("nombre_gestion"));
            }
            rs.close();
            statement.close();
            //connection.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return gest;
    }
    public  int guardarGestion(Gestion gs){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " insert into gestiones(cod_gestion,nombre_gestion,fecha_inicio,fecha_final,cod_estado_registro)values((select COALESCE(max(cod_gestion),0)+1 from gestiones),'"+gs.getNombreGestion()+"','"+sdf.format(gs.getFechaInicio())+"','"+sdf.format(gs.getFechaFinal())+"',1) ";
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
    public  int codCiudad(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarGestion(Gestion e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " update gestiones set nombre_gestion = '"+e.getNombreGestion()+"',fecha_inicio='"+sdf.format(e.getFechaInicio())+"',fecha_final= '"+sdf.format(e.getFechaFinal())+"',cod_estado_registro = '"+e.getEstadosRegistro().getCodEstado()+"'"
                    + " where cod_gestion = '"+e.getCodGestion()+"' ";
            
                    
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
    public  int eliminarGestion(Gestion e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from gestiones where cod_gestion = '"+e.getCodGestion()+"' ";
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
    public  List<SelectItem> cargarGestionItem() {
        List<SelectItem> listGestion =new ArrayList<SelectItem>();
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " select gs.cod_gestion,gs.nombre_gestion,gs.fecha_inicio,gs.fecha_final,e.cod_estado_registro,e.nombre_estado_registro "+
                    " from gestiones gs inner join estados_registro e on e.cod_estado_registro = gs.cod_estado_registro "+
                    " order by gs.cod_gestion asc ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listGestion.clear();
            while (rs.next())
            {
                listGestion.add(new SelectItem(rs.getInt("cod_gestion"),rs.getString("nombre_gestion")));
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
        return listGestion;
    }
    
}
