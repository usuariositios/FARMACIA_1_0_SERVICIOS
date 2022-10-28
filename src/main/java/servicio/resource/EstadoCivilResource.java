/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.resource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class EstadoCivilResource {
    public  List<SelectItem> cargarEstadoCivilItem() {
        List<SelectItem> estadoCivilList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_estado_civil,nombre_estado_civil from estado_civil";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            estadoCivilList.clear();
            while (rs.next())
            {
                estadoCivilList.add(new SelectItem(rs.getInt("cod_estado_civil"), rs.getString("nombre_estado_civil")));
            }
            rs.close();
            utiles.closeConnection();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return estadoCivilList;
    }
    
}
