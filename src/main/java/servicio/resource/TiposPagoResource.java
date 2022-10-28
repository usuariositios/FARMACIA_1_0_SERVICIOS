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
import servicio.model.TiposPago;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposPagoResource {
    Connection con;
    public TiposPagoResource(){
    }
    public TiposPagoResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarTiposPagoItem() {
        List<SelectItem> tiposPagoList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_tipo_pago,nombre_tipo_pago from public.tipos_pago";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposPagoList.clear();
            while (rs.next())
            {
                tiposPagoList.add(new SelectItem(rs.getInt("cod_tipo_pago"), rs.getString("nombre_tipo_pago")));
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
        return tiposPagoList;
    }
    public  List<TiposPago> cargarTiposPago(TiposPago t) {
        List<TiposPago> listTiposPago =new ArrayList<TiposPago>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " SELECT t.cod_tipo_pago, t.nombre_tipo_pago,"
                         + " e.cod_estado_registro, e.nombre_estado_registro "+
                           " FROM public.tipos_pago t "+
                           " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposPago.clear();
            while (rs.next())
            {
                TiposPago r =  new TiposPago();
                r.setCodTipoPago(rs.getInt("cod_tipo_pago"));
                r.setNombreTipoPago(rs.getString("nombre_tipo_pago"));
                
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listTiposPago.add(r);
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
        return listTiposPago;
    }
    public  int guardarTiposPago(TiposPago e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = "INSERT INTO public.tipos_pago(cod_tipo_pago, nombre_tipo_pago, " +
                    " porcentaje_anticipo ,cod_estado_registro) " +
                    " VALUES ((select nextval('public.\"seqTiposPago\"')), '"+e.getNombreTipoPago()+"','"+e.getPorcentajeAnticipo()+"','"+e.getEstadosRegistro().getCodEstado()+"');";
            
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
    public  int editarTiposPago(TiposPago e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE almacenes.tipos_pago" +
                            " SET  nombre_tipo_pago='"+e.getNombreTipoPago()+"', " +
                            " porcentaje_anticipo='"+e.getPorcentajeAnticipo()+"', " +
                            " cod_estado_registro='"+e.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_pago='"+e.getCodTipoPago()+"' ; ";
            
                    
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
    public  int eliminarTiposPago(TiposPago e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from public.tipos_pago where cod_tipo_pago = '"+e.getCodTipoPago()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //utiles.closeConnection();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ////Utiles.closeConnection();
        return guardado;
    }
}
