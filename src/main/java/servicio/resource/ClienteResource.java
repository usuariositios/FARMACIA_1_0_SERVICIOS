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


import servicio.model.Clientes;
import servicio.model.SelectItem;
import servicio.util.Utiles;



/**
 *
 * @author henry
 */
public class ClienteResource {
    Connection con;
    public ClienteResource(){
    }
    public ClienteResource(Connection con){
        this.con = con;
    }
    
    public  List<Clientes> cargarCliente(Clientes c) {
        List<Clientes> personalList =new ArrayList<Clientes>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();


            
            String query =  " SELECT c.cod_cliente,  c.nombre_cliente,  c.nit_cliente,  c.direccion_cliente,  c.nro_direccion_cliente,  c.telf_cliente,  c.cel_cliente, " +
                            " c.fax_cliente,  c.email_cliente,  c.nombre_propietario,  c.nombre_representante,  cd.cod_ciudad,cd.nombre_ciudad,  e.cod_estado_registro,e.nombre_estado_registro,"+
                            " gc.cod_grupo_cliente,gc.nombre_grupo_cliente,tc.cod_tipo_descuento,tc.nombre_tipo_descuento " +
                            " FROM  " +
                            " public.clientes c " +
                            " left outer join public.ciudad cd on cd.cod_ciudad = c.cod_ciudad " +
                            " inner join public.estados_registro e on e.cod_estado_registro = c.cod_estado_registro "+
                            " left outer join public.grupo_cliente gc on gc.cod_grupo_cliente = c.cod_grupo_cliente "+
                            " left outer join ventas.tipos_descuento tc on tc.cod_tipo_descuento = c.cod_tipo_descuento  where 0=0 ";
            if(!c.getNombreCliente().equals("")){query+=" AND c.nombre_cliente LIKE '%"+c.getNombreCliente()+"%' ";}
            if(!c.getDireccionCliente().equals("")){query+=" AND c.direccion_cliente like '%"+c.getDireccionCliente()+"%' ";}
            if(c.getCiudad().getCodCiudad()!=0){query+=" AND c.cod_ciudad = '"+c.getCiudad().getCodCiudad()+"' ";}
            if(!c.getTelfCliente().equals("")){query+=" AND c.telf_cliente = '"+c.getTelfCliente()+"' ";}
            if(!c.getEmailCliente().equals("")){query+=" AND c.email_cliente like '%"+c.getEmailCliente()+"%' ";}
            if(!c.getNitCliente().equals("")){query+=" AND c.nit_cliente like '%"+c.getNitCliente()+"%' ";}
            query += " ORDER BY  c.nombre_cliente asc";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            personalList.clear();
            while (rs.next())
            {
                Clientes cl = new Clientes();
                cl.setCodCliente(rs.getInt("cod_cliente"));                
                cl.setNombreCliente(rs.getString("nombre_cliente"));
                cl.setNitCliente(rs.getString("nit_cliente")==null?"":rs.getString("nit_cliente"));
                cl.setDireccionCliente(rs.getString("direccion_cliente")==null?"":rs.getString("direccion_cliente"));
                cl.setNroDireccionCliente(rs.getString("nro_direccion_cliente")==null?"":rs.getString("nro_direccion_cliente"));
                cl.setTelfCliente(rs.getString("telf_cliente")==null?"":rs.getString("telf_cliente"));
                cl.setCelCliente(rs.getString("cel_cliente")==null?"":rs.getString("cel_cliente"));
                cl.setFaxCliente(rs.getString("fax_cliente")==null?"":rs.getString("fax_cliente"));
                cl.setEmailCliente(rs.getString("email_cliente")==null?"":rs.getString("email_cliente"));
                cl.setNombrePropietario(rs.getString("nombre_propietario")==null?"":rs.getString("nombre_propietario"));
                cl.setNombreRepresentante(rs.getString("nombre_representante")==null?"":rs.getString("nombre_representante"));
                cl.getCiudad().setCodCiudad(rs.getInt("cod_ciudad"));
                cl.getCiudad().setNombreCiudad(rs.getString("nombre_ciudad")==null?"":rs.getString("nombre_ciudad"));                
                cl.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                cl.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro")==null?"":rs.getString("nombre_estado_registro"));
                cl.getGruposCliente().setCodGrupoCliente(rs.getInt("cod_grupo_cliente"));
                cl.getGruposCliente().setNombreGrupoCliente(rs.getString("nombre_grupo_cliente")==null?"":rs.getString("nombre_grupo_cliente"));                
                cl.getTiposDescuento().setCodTipoDescuento(rs.getInt("cod_tipo_descuento"));
                cl.getTiposDescuento().setNombreTipoDescuento(rs.getString("nombre_tipo_descuento")==null?"":rs.getString("nombre_tipo_descuento"));
                
                
                
                personalList.add(cl);
            }
                
                
            rs.close();
            statement.close();
            utiles.closeConnection();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return personalList;
    }
    public  int guardarCliente(Clientes c){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/

            Statement st = this.con.createStatement();
            
            String cons = " INSERT INTO  " +
                            "  public.clientes " +
                            "( cod_cliente,  nombre_cliente,  nit_cliente,  direccion_cliente,  nro_direccion_cliente,  telf_cliente,  cel_cliente,  fax_cliente, " +
                            "  email_cliente,  nombre_propietario,  nombre_representante,  cod_ciudad,  cod_estado_registro,cod_grupo_cliente,cod_tipo_descuento) " +
                            " VALUES (  '"+this.codigoCliente()+"',  '"+c.getNombreCliente()+"',  '"+c.getNitCliente()+"',  '"+c.getDireccionCliente()+"',  '"+c.getNroDireccionCliente()+"',  '"+c.getTelfCliente()+"', " +
                            "  '"+c.getCelCliente()+"',  '"+c.getFaxCliente()+"',  '"+c.getEmailCliente()+"',  '"+c.getNombrePropietario()+"',  '"+c.getNombreRepresentante()+"',  '"+c.getCiudad().getCodCiudad()+"',  '"+c.getEstadosRegistro().getCodEstado()+"',"+
                            " '"+c.getGruposCliente().getCodGrupoCliente()+"','"+c.getTiposDescuento().getCodTipoDescuento()+"'  ); ";
            System.out.println("cons " + cons);
            guardado = st.executeUpdate(cons);
            
            st.close();
            
            //utiles.closeConnection();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int codigoCliente(){
        int codCliente=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select COALESCE(max(p.cod_cliente),0)+1 cod_cliente from public.clientes p";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codCliente = rs.getInt("cod_cliente");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
        }
        //Utiles.closeConnection();
        return codCliente;
    }
    public  int editarCliente(Clientes c){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/

            Statement statement = this.con.createStatement();
            String cons = " UPDATE  " +
                            "  public.clientes  " +
                            "  SET  " +
                            "  nombre_cliente = '"+c.getNombreCliente()+"', " +
                            "  nit_cliente = '"+c.getNitCliente()+"', " +
                            "  direccion_cliente = '"+c.getDireccionCliente()+"', " +
                            "  nro_direccion_cliente = '"+c.getNroDireccionCliente()+"', " +
                            "  telf_cliente = '"+c.getTelfCliente()+"', " +
                            "  cel_cliente = '"+c.getCelCliente()+"', " +
                            "  fax_cliente = '"+c.getFaxCliente()+"', " +
                            "  email_cliente = '"+c.getEmailCliente()+"', " +
                            "  nombre_propietario = '"+c.getNombrePropietario()+"', " +
                            "  nombre_representante = '"+c.getNombreRepresentante()+"', " +
                            "  cod_ciudad = '"+c.getCiudad().getCodCiudad()+"', " +
                            "  cod_estado_registro = '"+c.getEstadosRegistro().getCodEstado()+"',"+
                            "  cod_grupo_cliente='"+c.getGruposCliente().getCodGrupoCliente()+"',"+
                            "  cod_tipo_descuento='"+c.getTiposDescuento().getCodTipoDescuento()+"' " +
                            "WHERE  " +
                            "  cod_cliente = '"+c.getCodCliente()+"'; ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //utiles.closeConnection();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int eliminarCliente(Clientes p){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/

            Statement statement = this.con.createStatement();
            String cons = " delete from public.clientes where cod_cliente= '"+p.getCodCliente()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //utiles.closeConnection();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
    public  List<SelectItem> cargarClienteItem(Clientes c) {
        List<SelectItem> clienteList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query = "SELECT cod_cliente, nombre_cliente "                    
                    + " from public.clientes order by nombre_cliente  ";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            clienteList.clear();
            while (rs.next())
            {
                clienteList.add(new SelectItem(rs.getInt("cod_cliente"), rs.getString("nombre_cliente")));
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
        return clienteList;
    }
    
    public  Clientes buscarCliente(Clientes c) {
        Clientes cl = new Clientes();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();


            
            String query =  " SELECT c.cod_cliente,  c.nombre_cliente,  c.nit_cliente,  c.direccion_cliente,  c.nro_direccion_cliente,  c.telf_cliente,  c.cel_cliente, " +
                            " c.fax_cliente,  c.email_cliente,  c.nombre_propietario,  c.nombre_representante,  cd.cod_ciudad,cd.nombre_ciudad,  e.cod_estado_registro,e.nombre_estado_registro,"+
                            " gc.cod_grupo_cliente,gc.nombre_grupo_cliente,tc.cod_tipo_descuento,tc.nombre_tipo_descuento " +
                            " FROM  " +
                            " public.clientes c " +
                            " left outer join public.ciudad cd on cd.cod_ciudad = c.cod_ciudad " +
                            " inner join public.estados_registro e on e.cod_estado_registro = c.cod_estado_registro "+
                            " left outer join public.grupo_cliente gc on gc.cod_grupo_cliente = c.cod_grupo_cliente "+
                            " left outer join ventas.tipos_descuento tc on tc.cod_tipo_descuento = c.cod_tipo_descuento  where 0=0 ";
            if(c.getCodCliente()>0){query+=" AND c.cod_cliente = '"+c.getCodCliente()+"' ";}
            if(!c.getNombreCliente().equals("")){query+=" AND c.nombre_cliente LIKE '%"+c.getNombreCliente()+"%' ";}
            if(!c.getDireccionCliente().equals("")){query+=" AND c.direccion_cliente like '%"+c.getDireccionCliente()+"%' ";}
            if(c.getCiudad().getCodCiudad()!=0){query+=" AND c.cod_ciudad = '"+c.getCiudad().getCodCiudad()+"' ";}
            if(!c.getTelfCliente().equals("")){query+=" AND c.telf_cliente = '"+c.getTelfCliente()+"' ";}
            if(!c.getEmailCliente().equals("")){query+=" AND c.email_cliente like '%"+c.getEmailCliente()+"%' ";}
            if(!c.getNitCliente().equals("")){query+=" AND c.nit_cliente like '%"+c.getNitCliente()+"%' ";}
            query += " ORDER BY  c.nombre_cliente asc";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
            {
                
                cl.setCodCliente(rs.getInt("cod_cliente"));                
                cl.setNombreCliente(rs.getString("nombre_cliente"));
                cl.setNitCliente(rs.getString("nit_cliente"));
                cl.setDireccionCliente(rs.getString("direccion_cliente"));
                cl.setNroDireccionCliente(rs.getString("nro_direccion_cliente"));
                cl.setTelfCliente(rs.getString("telf_cliente"));
                cl.setCelCliente(rs.getString("cel_cliente"));
                cl.setFaxCliente(rs.getString("fax_cliente"));
                cl.setEmailCliente(rs.getString("email_cliente"));
                cl.setNombrePropietario(rs.getString("nombre_propietario"));
                cl.setNombreRepresentante(rs.getString("nombre_representante"));
                cl.getCiudad().setCodCiudad(rs.getInt("cod_ciudad"));
                cl.getCiudad().setNombreCiudad(rs.getString("nombre_ciudad"));                
                cl.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                cl.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                cl.getGruposCliente().setCodGrupoCliente(rs.getInt("cod_grupo_cliente"));
                cl.getGruposCliente().setNombreGrupoCliente(rs.getString("nombre_grupo_cliente"));                
                cl.getTiposDescuento().setCodTipoDescuento(rs.getInt("cod_tipo_descuento"));
                cl.getTiposDescuento().setNombreTipoDescuento(rs.getString("nombre_tipo_descuento"));
                
                
                
                
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
        return cl;
    }
    
}
