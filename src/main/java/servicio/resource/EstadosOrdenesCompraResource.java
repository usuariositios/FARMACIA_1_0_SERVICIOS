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
import servicio.model.EstadosOrdenCompra;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class EstadosOrdenesCompraResource {
    /*
    public static List<EstadosOrdenCompra> cargarEstadosOrdenCompra() {
        List<EstadosOrdenCompra> listEstadosOrdenCompra =new ArrayList<EstadosOrdenCompra>();
        try {
            
            Connection connection = Utiles.getConnection();

            
            String query = " select e.cod_estado_orden_compra,e.nombre_estado_orden_compra,er.cod_estado_registro,er.nombre_estado_registro "+
                           " from public.estados_orden_compra e inner join public.estados_registro er" +
                           "  e.cod_estado_registro = er.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listEstadosOrdenCompra.clear();
            while (rs.next())
            {
                EstadosOrdenCompra  e = new EstadosOrdenCompra();
                e.setCodEstadoOrdenCompra(rs.getInt("cod_estado_orden_compra"));
                e.setNombreEstadoOrdenCompra(rs.getString("nombre_estado_orden_compra"));
                e.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                e.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listEstadosOrdenCompra.add(e);
            }
            rs.close();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return listEstadosOrdenCompra;
    }
    public static List<SelectItem> cargarEstadosOrdenCompraItem() {
        List<SelectItem> listEstadosOrdenCompra =new ArrayList<SelectItem>();
        try {
            
            Connection connection = Utiles.getConnection();

            
            String query = " select e.cod_estado_orden_compra,e.nombre_estado_orden_compra "+
                           " from public.estados_orden_compra e ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listEstadosOrdenCompra.clear();
            while (rs.next())
            {
                SelectItem  e = new SelectItem();
                e.setCodItem(rs.getInt("cod_estado_orden_compra"));
                e.setNombreItem(rs.getString("nombre_estado_orden_compra"));                
                
                listEstadosOrdenCompra.add(e);
            }
            rs.close();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return listEstadosOrdenCompra;
    }
    */
    
}
