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

public class TiposCompraResource {
    public  List<SelectItem> cargarTiposCompraItem() {
        List<SelectItem> tiposCompraList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_tipo_compra,nombre_tipo_compra from tipos_compra";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposCompraList.clear();
            while (rs.next())
            {
                tiposCompraList.add(new SelectItem(rs.getInt("cod_tipo_compra"), rs.getString("nombre_tipo_compra")));
            }
            rs.close();
            statement.close();
            //con.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return tiposCompraList;
    }
    
}
