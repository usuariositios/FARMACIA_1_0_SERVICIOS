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
import java.util.Base64;
import java.util.List;
import servicio.model.SelectItem;

import servicio.model.SucursalVentas;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class SucursalVentasResource {
    Connection con;
    public SucursalVentasResource(){
    }
    public SucursalVentasResource(Connection con){
        this.con = con;
    }
    public  List<SucursalVentas> cargarSucursalVentas(SucursalVentas s) {
        List<SucursalVentas> listSucursalVentas =new ArrayList<SucursalVentas>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query =  " SELECT s.cod_sucursal, s.nombre_sucursal,s.direccion_sucursal,s.telefono_sucursal, s.email_sucursal,  s.representante, " +
                            " s.logotipo_sucursal,  e.cod_estado_registro,e.nombre_estado_registro,  em.cod_empresa,em.nombre_empresa " +
                            " FROM ventas.sucursal_ventas s " +
                            " inner join public.estados_registro e on e.cod_estado_registro = s.cod_estado_registro " +
                            " inner join public.empresa em on em.cod_empresa = s.cod_empresa  where 0=0  ";
            if(!s.getNombreSucursal().trim().equals("")){query+=" AND s.nombre_sucursal like '%"+s.getNombreSucursal() +"%' ";}
            if(s.getEmpresas().getCodEmpresa() !=0){query+=" AND em.cod_empresa = '"+s.getEmpresas().getCodEmpresa()+"' ";}
            
            query +=" order by s.cod_sucursal;";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listSucursalVentas.clear();
            while (rs.next())
            {
                SucursalVentas  e = new SucursalVentas();
                e.setCodSucursal(rs.getInt("cod_sucursal"));
                e.setNombreSucursal(rs.getString("nombre_sucursal"));
                e.setDireccionSucursal(rs.getString("direccion_sucursal"));
                e.setTelefonoSucursal(rs.getString("telefono_sucursal"));
                e.setEmailSucursal(rs.getString("email_sucursal"));
                e.setRepresentante(rs.getString("representante"));
                e.setLogotipoSucursal(rs.getString("logotipo_sucursal"));//estara guardado en base 64
                e.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                e.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                e.getEmpresas().setCodEmpresa(rs.getInt("cod_empresa"));
                e.getEmpresas().setNombreEmpresa(rs.getString("nombre_empresa"));
                
                listSucursalVentas.add(e);
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
        return listSucursalVentas;
    }
    public  int guardarSucursalVentas(SucursalVentas e){//la imagen vendra codificada en base 64
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String 
            
            
            cons =  " INSERT INTO ventas.sucursal_ventas " +
                    " ( cod_sucursal,  nombre_sucursal,  direccion_sucursal,  telefono_sucursal,  email_sucursal,  representante, " +
                    "  logotipo_sucursal,  cod_estado_registro,  cod_empresa) " +
                    " VALUES ((select nextval('ventas.\"seqSucursalVentas\"')) ,  '"+e.getNombreSucursal()+"',  '"+e.getDireccionSucursal()+"',  '"+e.getTelefonoSucursal()+"',  '"+e.getEmailSucursal()+"',  '"+e.getRepresentante()+"', " +
                    "  '"+e.getLogotipoSucursal()+"',  '"+e.getEstadosRegistro().getCodEstado()+"',  '"+e.getEmpresas().getCodEmpresa()+"') ";
            
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
    public int codCiudad(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarSucursalVentas(SucursalVentas e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE  " +
                            "  ventas.sucursal_ventas  " +
                            "  SET  " +                            
                            "  nombre_sucursal = '"+e.getNombreSucursal()+"', " +
                            "  direccion_sucursal = '"+e.getDireccionSucursal()+"', " +
                            "  telefono_sucursal = '"+e.getTelefonoSucursal()+"', " +
                            "  email_sucursal = '"+e.getEmailSucursal()+"', " +
                            "  representante = '"+e.getRepresentante()+"', " +
                            "  logotipo_sucursal = '"+e.getLogotipoSucursal()+"', " +
                            "  cod_estado_registro = '"+e.getEstadosRegistro().getCodEstado()+"', " +
                            "  cod_empresa = '"+e.getEmpresas().getCodEmpresa()+"' " +
                            "  WHERE cod_sucursal = '"+e.getCodSucursal()+"'    ";
            
                    
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
    public  int eliminarSucursalVentas(SucursalVentas e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from public.sucursal where cod_sucursal = '"+e.getCodSucursal()+"' ";
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
    public  List<SelectItem> cargarSucursalItem() {
        List<SelectItem> cargoList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_sucursal,nombre_sucursal from ventas.sucursal_ventas ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            cargoList.clear();
            while (rs.next())
            {
                cargoList.add(new SelectItem(rs.getInt("cod_sucursal"), rs.getString("nombre_sucursal")));
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
        return cargoList;
    }
    
    
}
