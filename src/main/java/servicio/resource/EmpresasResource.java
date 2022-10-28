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

import servicio.model.Empresas;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class EmpresasResource {
    Connection con;
    public EmpresasResource(){
    }
    public EmpresasResource(Connection con){
        this.con = con;
    }
    public  List<Empresas> cargarEmpresas(Empresas emp) {
        List<Empresas> listEmpresas =new ArrayList<Empresas>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = " SELECT e.cod_empresa,e.nombre_empresa,e.ruc,e.cod_estado_registro,er.nombre_estado_registro, " +
                            "e.direccion, e.telefono, e.cod_ciudad,c.nombre_ciudad, e.nombre_impuesto,  "+
                            "e.porcentaje_impuesto, e.cod_moneda,m.nombre_moneda, e.logotipo_empresa " +
                            "FROM " +
                            "public.empresa e " +
                            "inner join public.estados_registro er on er.cod_estado_registro = e.cod_estado_registro " +
                            "inner join public.ciudad c on c.cod_ciudad = e.cod_ciudad " +
                            "inner join public.monedas m on m.cod_moneda = e.cod_moneda where 0=0 ";
            if(!emp.getNombreEmpresa().trim().equals("")){query+=" AND e.nombre_empresa like '%"+emp.getNombreEmpresa() +"%' ";}
            if(!emp.getRuc().trim().equals("")){query+=" AND e.ruc like '%"+emp.getRuc() +"%' ";}
            if(!emp.getDireccion().trim().equals("")){query+=" AND e.direccion like '%"+emp.getDireccion() +"%' ";}
            if(emp.getCiudad().getCodCiudad()!=0){query+=" AND e.cod_ciudad = '"+emp.getCiudad().getCodCiudad() +"' ";}
            
            query +=" order by e.cod_empresa;";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listEmpresas.clear();
            while (rs.next())
            {
                Empresas  e = new Empresas();
                e.setCodEmpresa(rs.getInt("cod_empresa"));
                e.setNombreEmpresa(rs.getString("nombre_empresa"));
                e.setRuc(rs.getString("ruc"));
                e.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                e.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                e.setDireccion(rs.getString("direccion"));
                e.setTelefono(rs.getString("telefono"));
                e.getCiudad().setCodCiudad(rs.getInt("cod_ciudad"));
                e.getCiudad().setNombreCiudad(rs.getString("nombre_ciudad"));
                e.setNombreImpuesto(rs.getString("nombre_impuesto"));
                e.setPorcentajeImpuesto(rs.getDouble("porcentaje_impuesto"));
                e.getMoneda().setCodMoneda(rs.getInt("cod_moneda"));
                e.getMoneda().setNombreMoneda(rs.getString("nombre_moneda"));
                e.setLogotipoEmpresa(rs.getString("logotipo_empresa"));//estara guardado en base 64
                listEmpresas.add(e);
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
        return listEmpresas;
    }
    public  int guardarEmpresa(Empresas e){//la imagen vendra codificada en base 64
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String 
            
            cons = " INSERT INTO public.empresa ( cod_empresa,nombre_empresa, ruc,  cod_estado_registro,  direccion,  telefono,  cod_ciudad,  nombre_impuesto,  porcentaje_impuesto,  cod_moneda,  logotipo_empresa) " +
                   " VALUES ((select nextval('public.\"seqEmpresa\"')),'"+e.getNombreEmpresa()+"', '"+e.getRuc()+"', '"+e.getEstadosRegistro().getCodEstado()+"',  '"+e.getDireccion()+"',  '"+e.getTelefono()+"',  '"+e.getCiudad().getCodCiudad()+"',  '"+e.getNombreImpuesto()+"',  '"+e.getPorcentajeImpuesto()+"',  '"+e.getMoneda().getCodMoneda()+"',  '"+e.getLogotipoEmpresa()+"'); ";
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //utiles.closeConnection();
            //connection.close();
            
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
    public  int editarEmpresa(Empresas e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE public.empresa SET " +
                            "  nombre_empresa = '"+e.getNombreEmpresa()+"'," +
                            "  ruc = '"+e.getRuc()+"'," +
                            "  cod_estado_registro = '"+e.getEstadosRegistro().getCodEstado()+"'," +
                            "  direccion = '"+e.getDireccion()+"'," +
                            "  telefono = '"+e.getTelefono()+"'," +
                            "  cod_ciudad = '"+e.getCiudad().getCodCiudad()+"'," +
                            "  nombre_impuesto = '"+e.getNombreImpuesto()+"'," +
                            "  porcentaje_impuesto = '"+e.getPorcentajeImpuesto()+"'," +
                            "  cod_moneda = '"+e.getMoneda().getCodMoneda()+"'," +
                            "  logotipo_empresa = '"+e.getLogotipoEmpresa()+"'" +
                            "  WHERE " +
                            "  cod_empresa = '"+e.getCodEmpresa()+"';";
            
                    
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //utiles.closeConnection();
            //connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int eliminarEmpresa(Empresas e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from public.empresa where cod_empresa = '"+e.getCodEmpresa()+"' ";
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
    public  List<SelectItem> cargarEmpresaItem() {
        List<SelectItem> cargoList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_empresa,nombre_empresa from public.empresa";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            cargoList.clear();
            while (rs.next())
            {
                cargoList.add(new SelectItem(rs.getInt("cod_empresa"), rs.getString("nombre_empresa")));
            }
            rs.close();
            utiles.closeConnection();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return cargoList;
    }
    
    
}
