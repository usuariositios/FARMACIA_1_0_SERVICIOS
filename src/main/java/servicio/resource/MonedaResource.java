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
import javax.naming.InitialContext;
import javax.sql.DataSource;
import servicio.model.Moneda;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class MonedaResource {
    
    Connection con;
    public MonedaResource(){
    }
    public MonedaResource(Connection con){
        this.con = con;
    }
    public  List<Moneda> cargarMonedas() {
        List<Moneda> listMoneda =new ArrayList<Moneda>();
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " SELECT cod_moneda, nombre_moneda "+
                           " FROM " +
                           " public.monedas ;";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listMoneda.clear();
            while (rs.next())
            {
                Moneda m = new Moneda();
                m.setCodMoneda(rs.getInt("cod_moneda"));
                m.setNombreMoneda(rs.getString("nombre_moneda"));                
                listMoneda.add(m);
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
        return listMoneda;
    }
    public  List<SelectItem> cargarMonedasItem() {
        List<SelectItem> estList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_moneda, nombre_moneda "+
                           " FROM " +
                           " public.monedas ; ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            estList.clear();
            while (rs.next())
            {
                estList.add(new SelectItem(rs.getInt("cod_moneda"), rs.getString("nombre_moneda")));
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
        return estList;
    }
    public  int guardarMoneda(Moneda m){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " INSERT INTO public.monedas( cod_moneda, nombre_moneda)" +
                          "  VALUES ((select nextval('public.\"seqMoneda\"')),  '"+m.getNombreMoneda()+"'); ";
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
    public  int editarMoneda(Moneda m){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE  " +
                            "  public.monedas  " +
                            "  SET  " +                            
                            "  nombre_moneda = '"+m.getNombreMoneda()+"' " +
                            "  WHERE  " +
                            "  cod_moneda = '"+m.getCodMoneda()+"' ";
            
                    
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
    public  int eliminarMoneda(Moneda e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from public.monedas where cod_moneda = '"+e.getCodMoneda()+"' ";
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