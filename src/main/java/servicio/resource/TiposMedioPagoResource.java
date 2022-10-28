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
import servicio.model.SelectItem;
import servicio.model.TiposMedioPago;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposMedioPagoResource {
    Connection con;
    public TiposMedioPagoResource(){
    }
    public TiposMedioPagoResource(Connection con){
        this.con = con;
    }    
    public  List<SelectItem> cargarTiposMedioPagoItem() {
        List<SelectItem> tiposMedioPagoList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_tipo_medio_pago,nombre_tipo_medio_pago from public.tipos_medio_pago";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposMedioPagoList.clear();
            while (rs.next())
            {
                tiposMedioPagoList.add(new SelectItem(rs.getInt("cod_tipo_medio_pago"), rs.getString("nombre_tipo_medio_pago")));
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
        return tiposMedioPagoList;
    }
    public  List<TiposMedioPago> cargarTiposMedioPago(TiposMedioPago t) {
        List<TiposMedioPago> listTiposMedioPago =new ArrayList<TiposMedioPago>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " SELECT t.cod_tipo_medio_pago, t.nombre_tipo_medio_pago,"
                         + " e.cod_estado_registro, e.nombre_estado_registro "+
                           " FROM public.tipos_medio_pago t "+
                           " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposMedioPago.clear();
            while (rs.next())
            {
                TiposMedioPago r =  new TiposMedioPago();
                r.setCodTipoMedioPago(rs.getInt("cod_tipo_medio_pago"));
                r.setNombreTipoMedioPago(rs.getString("nombre_tipo_medio_pago"));
                
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listTiposMedioPago.add(r);
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
        return listTiposMedioPago;
    }
    public  int guardarTiposMedioPago(TiposMedioPago e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = "INSERT INTO public.tipos_medio_pago(cod_tipo_medio_pago, nombre_tipo_medio_pago, " +
                    " cod_estado_registro) " +
                    " VALUES ((select nextval('public.\"seqTiposMedioPago\"')), '"+e.getNombreTipoMedioPago()+"','"+e.getEstadosRegistro().getCodEstado()+"');";
            
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
    public int codTipoComposicionProducto(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarTiposMedioPago(TiposMedioPago e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE almacenes.tipos_medio_pago" +
                            " SET  nombre_tipo_medio_pago='"+e.getNombreTipoMedioPago()+"', " +                            
                            " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_medio_pago='"+e.getCodTipoMedioPago()+"' ; ";
            
                    
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
    public  int eliminarTiposMedioPago(TiposMedioPago e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from public.tipos_medio_pago where cod_tipo_medio_pago = '"+e.getCodTipoMedioPago()+"' ";
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
