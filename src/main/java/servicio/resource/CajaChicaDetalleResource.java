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

import servicio.model.CajaChicaDetalle;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class CajaChicaDetalleResource {
    Connection con;
    public CajaChicaDetalleResource(){
    }
    public CajaChicaDetalleResource(Connection con){
        this.con = con;
    }
    public  List<CajaChicaDetalle> cargarCajaChicaDetalle(CajaChicaDetalle cd) {
        List<CajaChicaDetalle> listCajaChicaDetalle =new ArrayList<CajaChicaDetalle>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query =  " select cd.cod_caja_chica ,cd.cod_caja_chica_detalle ,cd.fecha_caja_chica_detalle ,cd.monto_ingreso,cd.monto_egreso ,cd.cod_salida_venta ,cd.descripcion , fm.monto_total " +
                            " from ventas.caja_chica_detalle cd " +
                            " left outer join ventas.salidas_venta s on s.cod_salida_venta = cd.cod_salida_venta  " +
                            " left outer join ventas.facturas_emitidas fm on fm.cod_salida_venta = s.cod_salida_venta where 0=0 "
                          + " and cd.cod_caja_chica = '"+cd.getCajaChica().getCodCajaChica()+"'";
            /*if(!emp.getNombreCajaChicaDetalle().trim().equals("")){query+=" AND e.nombre_empresa like '%"+emp.getNombreCajaChicaDetalle() +"%' ";}
            if(!emp.getRuc().trim().equals("")){query+=" AND e.ruc like '%"+emp.getRuc() +"%' ";}
            if(!emp.getDireccion().trim().equals("")){query+=" AND e.direccion like '%"+emp.getDireccion() +"%' ";}
            if(emp.getCiudad().getCodCiudad()!=0){query+=" AND e.cod_ciudad = '"+emp.getCiudad().getCodCiudad() +"' ";}*/
            
            query +=" order by cd.cod_caja_chica ,cd.cod_caja_chica_detalle,cd.fecha_caja_chica_detalle;";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listCajaChicaDetalle.clear();
            while (rs.next())
            {
                CajaChicaDetalle  c = new CajaChicaDetalle();
                c.getCajaChica().setCodCajaChica(rs.getInt("cod_caja_chica"));                
                c.setCodCajaChicaDetalle(rs.getInt("cod_caja_chica_detalle"));
                c.setFechaCajaChicaDetalle(sdf.format(rs.getTimestamp("fecha_caja_chica_detalle")));                
                c.setMontoIngreso(rs.getDouble("monto_ingreso"));
                c.setMontoEgreso(rs.getDouble("monto_egreso"));
                c.getFacturasEmitidas().getSalidasVenta().setCodSalidaVenta(rs.getInt("cod_salida_venta"));
                c.setDescripcion(rs.getString("descripcion"));
                c.getFacturasEmitidas().setMontoTotal(rs.getDouble("monto_total"));
                
                
                listCajaChicaDetalle.add(c);
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
        return listCajaChicaDetalle;
    }
    public  int guardarCajaChicaDetalle(CajaChicaDetalle c) throws Exception{//la imagen vendra codificada en base 64
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String 
            
            cons =      " INSERT INTO ventas.caja_chica_detalle(cod_caja_chica, cod_caja_chica_detalle, fecha_caja_chica_detalle, monto_ingreso, monto_egreso, cod_salida_venta, descripcion) " +
                        " VALUES ('"+c.getCajaChica().getCodCajaChica()+"', (select coalesce(max(cod_caja_chica_detalle),0)+1 from ventas.caja_chica_detalle where cod_caja_chica = '"+c.getCajaChica().getCodCajaChica()+"' ), '"+c.getFechaCajaChicaDetalle()+"', '"+c.getMontoIngreso()+"', '"+c.getMontoEgreso()+"', '"+c.getFacturasEmitidas().getSalidasVenta().getCodSalidaVenta()+"', '"+c.getDescripcion()+"') ";
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //utiles.closeConnection();
            //connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error en guardarCajaChicaDetalle");
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
    public  int editarCajaChicaDetalle(CajaChicaDetalle e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   "  UPDATE ventas.caja_chica_detalle " +
                        "	SET  fecha_caja_chica_detalle='"+e.getFechaCajaChicaDetalle()+"', "
                      + " monto_ingreso='"+e.getMontoIngreso()+"', "
                      + " monto_egreso='"+e.getMontoEgreso()+"',  "
                    + "   descripcion='"+e.getDescripcion()+"' " +
                        " WHERE cod_caja_chica='"+e.getCajaChica().getCodCajaChica()+"' and"
                      + " cod_caja_chica_detalle = '"+e.getCodCajaChicaDetalle()+"' ";
            
                    
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
    public  int eliminarCajaChicaDetalle(CajaChicaDetalle e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons = " delete from ventas.caja_chica_detalle where cod_caja_chica='"+e.getCajaChica().getCodCajaChica()+"' and cod_caja_chica_detalle = '"+e.getCodCajaChicaDetalle()+"' ";
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
    public  List<SelectItem> cargarCajaChicaDetalleItem() {
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
