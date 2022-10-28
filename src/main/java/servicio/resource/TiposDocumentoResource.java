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
import servicio.model.TiposDocumento;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class TiposDocumentoResource {
    Connection con;
    public TiposDocumentoResource(){
    }
    public TiposDocumentoResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarTiposDocumentoItem() {
        List<SelectItem> tiposDocumentoList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_tipo_documento,nombre_tipo_documento from public.tipos_documento order by cod_tipo_documento";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            tiposDocumentoList.clear();
            while (rs.next())
            {
                tiposDocumentoList.add(new SelectItem(rs.getInt("cod_tipo_documento"), rs.getString("nombre_tipo_documento")));
            }
            rs.close();
            statement.close();
            utiles.closeConnection();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return tiposDocumentoList;
    }
    public  List<TiposDocumento> cargarTiposDocumento(TiposDocumento t) {
        List<TiposDocumento> listTiposDocumento =new ArrayList<TiposDocumento>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            String query = " SELECT t.cod_tipo_documento, t.nombre_tipo_documento, t.cod_estado_registro, e.nombre_estado_registro " +
                           " FROM public.tipos_documento t "+
                           " inner join public.estados_registro e on e.cod_estado_registro = t.cod_estado_registro ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listTiposDocumento.clear();
            while (rs.next())
            {
                TiposDocumento r =  new TiposDocumento();
                r.setCodTipoDocumento(rs.getInt("cod_tipo_documento"));
                r.setNombreTipoDocumento(rs.getString("nombre_tipo_documento"));                
                r.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                r.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                
                listTiposDocumento.add(r);
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
        return listTiposDocumento;
    }
    public  int guardarTiposDocumento(TiposDocumento t){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " INSERT INTO public.tipos_documento " +
                            " (cod_tipo_documento,  nombre_tipo_documento,  cod_estado_registro) " +
                            " VALUES ((select nextval('public.\"seqTiposDocumento\"')), '"+t.getNombreTipoDocumento()+"', '"+t.getEstadosRegistro().getCodEstado()+"');";
            
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
    public  int editarTiposDocumento(TiposDocumento t){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE public.tipos_documento" +
                            " SET  nombre_tipo_documento='"+t.getNombreTipoDocumento()+"',"+                            
                            " cod_estado_registro='"+t.getEstadosRegistro().getCodEstado()+"'" +
                            " WHERE cod_tipo_documento='"+t.getCodTipoDocumento()+"' ; ";
            
                    
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
    public  int eliminarTiposDocumento(TiposDocumento t){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from public.tipos_documento where cod_tipo_documento = '"+t.getCodTipoDocumento()+"' ";
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
