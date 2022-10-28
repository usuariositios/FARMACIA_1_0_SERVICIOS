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


import servicio.model.Proveedores;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class ProveedoresResource {
    Connection con;
    public ProveedoresResource(){
    }
    public ProveedoresResource(Connection con){
        this.con = con;
    }
    public  List<SelectItem> cargarProveedoresItem() {
        List<SelectItem> proveedoresList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();utiles.getConnection();
            
            String query = "SELECT cod_proveedor,nombre_proveedor from proveedores where cod_estado_proveedor = 1";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            proveedoresList.clear();
            while (rs.next())
            {
                proveedoresList.add(new SelectItem(rs.getInt("cod_proveedor"), rs.getString("nombre_proveedor")));
            }
            rs.close();
            //con.close();
            statement.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return proveedoresList;
    }
    public  List<SelectItem> cargarProveedoresItem(Proveedores p) {
        List<SelectItem> proveedoresList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_proveedor,nombre_proveedor from proveedores where cod_estado_proveedor=1";
                     if(p.getTiposProveedor().getCodTipoProveedor()!=0){query+=" and cod_tipo_proveedor = '"+p.getTiposProveedor().getCodTipoProveedor()+"' ";}
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            proveedoresList.clear();
            while (rs.next())
            {
                proveedoresList.add(new SelectItem(rs.getInt("cod_proveedor"), rs.getString("nombre_proveedor")));
            }
            rs.close();
            statement.close();
            //con.close();
            utiles.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return proveedoresList;
    }
    
    public  List<Proveedores> cargarProveedores(Proveedores pr) {
        List<Proveedores> proveedoresList =new ArrayList<Proveedores>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query =  " SELECT cod_proveedor, nombre_proveedor, nit_proveedor, tp.cod_tipo_proveedor,tp.nombre_tipo_proveedor,  " +
                            " e.cod_estado_proveedor,e.nombre_estado_proveedor, m.cod_moneda,m.nombre_moneda, dias_termino_pago,  " +
                            " t.cod_tipo_documento,t.nombre_tipo_documento, ps.cod_pais,ps.nombre_pais,c.cod_ciudad,c.nombre_ciudad, direccion_proveedor,  " +
                            " telefono_proveedor, email_proveedor, fax_proveedor, pagina_web_proveedor,  " +
                            " obs_proveedor, nombre_cheque, tm.cod_tipo_medio_pago,tm.nombre_tipo_medio_pago,tpg.cod_tipo_pago,tpg.nombre_tipo_pago " +
                            " FROM proveedores p " +
                            "inner join tipos_proveedor tp on tp.cod_tipo_proveedor = p.cod_tipo_proveedor " +
                            "inner join estados_proveedor e on e.cod_estado_proveedor = p.cod_estado_proveedor " +
                            "left outer join monedas m on m.cod_moneda = p.cod_moneda " +
                            "left outer join tipos_documento t on t.cod_tipo_documento = p.cod_tipo_documento " +
                            
                            "left outer join tipos_medio_pago tm on tm.cod_tipo_medio_pago = p.cod_tipo_medio_pago " +
                            "left outer join tipos_pago tpg on tpg.cod_tipo_pago = p.cod_tipo_pago " +
                            "left outer join pais ps on ps.cod_pais = p.cod_pais " +
                            "left outer join ciudad c on c.cod_ciudad = p.cod_ciudad " +
                            " where 0=0 ";
            if(!pr.getNombreProveedor().equals("")){
                query +=" and p.nombre_proveedor like '%"+pr.getNombreProveedor()+"%'" ;
            }
            if(!pr.getNitProveedor().equals("")){
                query +=" and p.nit_proveedor like '%"+pr.getNitProveedor()+"%'" ;
            }
            if(pr.getTiposProveedor().getCodTipoProveedor()!=0){
                query +=" and p.cod_tipo_proveedor = '"+pr.getTiposProveedor().getCodTipoProveedor()+"'" ;
            }
            if(pr.getMoneda().getCodMoneda()!=0){
                query +=" and p.cod_moneda = '"+pr.getMoneda().getCodMoneda()+"'" ;
            }
            if(pr.getCiudadProveedor().getCodCiudad()!=0){
                query +=" and p.cod_ciudad = '"+pr.getCiudadProveedor().getCodCiudad()+"'" ;
            }
            if(!pr.getDireccionProveedor().equals("")){
                query +=" and p.direccion_proveedor like '%"+pr.getDireccionProveedor()+"%'" ;
            }
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            proveedoresList.clear();
            while (rs.next())
            {
                Proveedores p = new Proveedores();
                p.setCodProveedor(rs.getInt("cod_proveedor"));
                p.setNombreProveedor(rs.getString("nombre_proveedor"));
                p.setNitProveedor(rs.getString("nit_proveedor"));
                p.getTiposProveedor().setCodTipoProveedor(rs.getInt("cod_tipo_proveedor"));
                p.getTiposProveedor().setNombreTipoProveedor(rs.getString("nombre_tipo_proveedor"));
                p.getEstadosProveedor().setCodEstadoProveedor(rs.getInt("cod_estado_proveedor"));
                p.getEstadosProveedor().setNombreEstadoProveedor(rs.getString("nombre_estado_proveedor"));
                p.getMoneda().setCodMoneda(rs.getInt("cod_moneda"));
                p.getMoneda().setNombreMoneda(rs.getString("nombre_moneda"));
                p.setDiasTerminoPago(rs.getInt("dias_termino_pago"));
                p.getTiposDocumento().setCodTipoDocumento(rs.getInt("cod_tipo_documento"));
                p.getTiposDocumento().setNombreTipoDocumento(rs.getString("nombre_tipo_documento"));
                p.getPais().setCodPais(rs.getInt("cod_pais"));
                p.getPais().setNombrePais(rs.getString("nombre_pais"));
                p.getCiudadProveedor().setCodCiudad(rs.getInt("cod_ciudad"));
                p.getCiudadProveedor().setNombreCiudad(rs.getString("nombre_ciudad"));
                p.setDireccionProveedor(rs.getString("direccion_proveedor"));
                p.setTelefonoProveedor(rs.getString("telefono_proveedor"));
                p.setEmailProveedor(rs.getString("email_proveedor"));
                p.setFaxProveedor(rs.getString("fax_proveedor"));
                p.setPaginaWebProveedor(rs.getString("pagina_web_proveedor"));
                p.setObsProveedor(rs.getString("obs_proveedor"));
                p.setNombreCheque(rs.getString("nombre_cheque"));
                p.getTiposMedioPago().setCodTipoMedioPago(rs.getInt("cod_tipo_medio_pago"));
                p.getTiposMedioPago().setNombreTipoMedioPago(rs.getString("nombre_tipo_medio_pago"));
                p.getTiposPago().setCodTipoPago(rs.getInt("cod_tipo_pago"));
                p.getTiposPago().setNombreTipoPago(rs.getString("nombre_tipo_pago"));
                proveedoresList.add(p);
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
        return proveedoresList;
    }
    public  int guardarProveedor(Proveedores p){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            
            Statement st = this.con.createStatement();
            p.setCodProveedor(this.codigoProveedor());
            
            String cons = " INSERT INTO proveedores( " +
                            "            cod_proveedor, nombre_proveedor, nit_proveedor, cod_tipo_proveedor,  " +
                            "            cod_estado_proveedor, cod_moneda, cod_tipo_pago, cod_tipo_documento,  " +
                            "            cod_pais, cod_ciudad, direccion_proveedor, telefono_proveedor,  " +
                            "            email_proveedor, fax_proveedor, pagina_web_proveedor, obs_proveedor,  " +
                            "            nombre_cheque, cod_tipo_medio_pago, dias_termino_pago) " +
                            "    VALUES ('"+p.getCodProveedor()+"', '"+p.getNombreProveedor()+"', '"+p.getNitProveedor()+"', '"+p.getTiposProveedor().getCodTipoProveedor()+"',  " +
                            "            '"+p.getEstadosProveedor().getCodEstadoProveedor()+"', '"+p.getMoneda().getCodMoneda()+"', '"+p.getTiposPago().getCodTipoPago()+"', '"+p.getTiposDocumento().getCodTipoDocumento()+"',  " +
                            "            '"+p.getPais().getCodPais()+"', '"+p.getCiudadProveedor().getCodCiudad()+"', '"+p.getDireccionProveedor()+"', '"+p.getTelefonoProveedor()+"',  " +
                            "            '"+p.getEmailProveedor()+"', '"+p.getFaxProveedor()+"', '"+p.getPaginaWebProveedor()+"', '"+p.getObsProveedor()+"',  " +
                            "            '"+p.getNombreCheque()+"', '"+p.getTiposMedioPago().getCodTipoMedioPago()+"', '"+p.getDiasTerminoPago()+"');  ";
            System.out.println("cons " + cons);
            guardado = st.executeUpdate(cons);
            
            st.close();
            //con.close();
            //utiles.closeConnection();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int codigoProveedor(){
        int codProveedor=0;
        try {
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = "select COALESCE(max(p.cod_proveedor),0)+1 cod_proveedor from proveedores p";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codProveedor = rs.getInt("cod_proveedor");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
        }
        //Utiles.closeConnection();
        return codProveedor;
    }
    public  int editarProveedor(Proveedores p){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " UPDATE proveedores " +
                            "   SET  nombre_proveedor='"+p.getNombreProveedor()+"', nit_proveedor='"+p.getNitProveedor()+"', cod_tipo_proveedor='"+p.getTiposProveedor().getCodTipoProveedor()+"',  " +
                            "       cod_estado_proveedor='"+p.getEstadosProveedor().getCodEstadoProveedor()+"', cod_moneda='"+p.getMoneda().getCodMoneda()+"', cod_tipo_pago='"+p.getTiposPago().getCodTipoPago()+"', cod_tipo_documento='"+p.getTiposDocumento().getCodTipoDocumento()+"',  " +
                            "       cod_pais='"+p.getPais().getCodPais()+"', cod_ciudad='"+p.getCiudadProveedor().getCodCiudad()+"', direccion_proveedor='"+p.getDireccionProveedor()+"', telefono_proveedor='"+p.getTelefonoProveedor()+"',  " +
                            "       email_proveedor='"+p.getEmailProveedor()+"', fax_proveedor='"+p.getFaxProveedor()+"', pagina_web_proveedor='"+p.getPaginaWebProveedor()+"', obs_proveedor='"+p.getObsProveedor()+"',  " +
                            "       nombre_cheque='"+p.getNombreCheque()+"', cod_tipo_medio_pago='"+p.getTiposMedioPago().getCodTipoMedioPago()+"', dias_termino_pago='"+p.getDiasTerminoPago()+"' " +
                            " WHERE cod_proveedor='"+p.getCodProveedor()+"'  ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            //utiles.closeConnection();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public  int eliminarProveedor(Proveedores p){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from proveedores where cod_proveedor= '"+p.getCodProveedor()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //con.close();
            //utiles.closeConnection();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    
}
