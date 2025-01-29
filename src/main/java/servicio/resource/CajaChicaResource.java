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

import servicio.model.CajaChica;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class CajaChicaResource {
    Connection con;
    public CajaChicaResource(){
    }
    public CajaChicaResource(Connection con){
        this.con = con;
    }
    public  List<CajaChica> cargarCajaChica(CajaChica c) {
        List<CajaChica> listCajaChica =new ArrayList<CajaChica>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //yyyy/MM/dd HH:mm:ss
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query =  " select c.cod_caja_chica , c.fecha_turno ,	p.cod_personal,p.nombres_personal, c.monto_inicial, "
                          + " monto_ingresos,monto_egresos,monto_saldo ,c.cod_estado_apertura, ea.nombre_campo nombre_estado_apertura,c.cod_caja, cj.nombre_campo nombre_caja " +
                            " from ventas.caja_chica c " +
                            " inner join public.personal p on p.cod_personal = c.cod_personal " +
                            " left outer join ( select td.* from ventas.tabla_detalle td "
                            + "  INNER JOIN ventas.tabla t ON td.cod_tabla = t.cod_tabla AND t.nombre_tabla = 'ESTADOS_APERTURA' ) ea on ea.cod_campo = c.cod_estado_apertura "+
                            " left outer join ( select td.* from ventas.tabla_detalle td "
                            + "  INNER JOIN ventas.tabla t ON td.cod_tabla = t.cod_tabla AND t.nombre_tabla = 'CAJA' ) cj on cj.cod_campo = c.cod_caja "
                    
                    + "where 0=0 ";
            
            if(c.getPersonal().getCodPersonal()!=0){query+=" AND p.cod_personal = '"+c.getPersonal().getCodPersonal()+"' ";}
            if(c.getEstadoApertura().getCodApertura()!=0){query+=" AND c.cod_estado_apertura = '"+c.getEstadoApertura().getCodApertura()+"' ";}
            
            query +=" order by c.cod_caja_chica,c.fecha_turno desc LIMIT 10 OFFSET "+c.getFilaInicial()+";";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listCajaChica.clear();
            while (rs.next())
            {
                CajaChica  c1 = new CajaChica();
                c1.setCodCajaChica(rs.getInt("cod_caja_chica"));
                c1.setFechaTurno(sdf.format(rs.getTimestamp("fecha_turno")));
                c1.getPersonal().setCodPersonal(rs.getInt("cod_personal"));
                c1.getPersonal().setNombrePersonal(rs.getString("nombres_personal"));
                c1.setMontoInicial(rs.getDouble("monto_inicial"));
                c1.setMontoIngresos(rs.getDouble("monto_ingresos"));
                c1.setMontoEgresos(rs.getDouble("monto_egresos"));
                c1.setMontoSaldo(rs.getDouble("monto_saldo"));
                c1.getCaja().setCodCaja(rs.getInt("cod_caja"));
                c1.getCaja().setNombreCaja(rs.getString("nombre_caja"));
                c1.getEstadoApertura().setCodApertura(rs.getInt("cod_estado_apertura"));
                c1.getEstadoApertura().setNombreApertura(rs.getString("nombre_estado_apertura"));
                listCajaChica.add(c1);
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
        return listCajaChica;
    }
    public  int guardarCajaChica(CajaChica c){//la imagen vendra codificada en base 64
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String 
            
            cons = " INSERT INTO ventas.caja_chica(cod_caja_chica, fecha_turno, cod_personal, monto_inicial,monto_ingresos,monto_egresos,monto_saldo,cod_caja, cod_estado_apertura) " +
                   " VALUES ((select nextval('public.\"seqCajaChica\"')),'"+c.getFechaTurno()+"', '"+c.getPersonal().getCodPersonal()+"', '"+c.getMontoInicial()+"',  '"+c.getMontoIngresos()+"',  '"+c.getMontoEgresos()+"',  '"+c.getMontoSaldo()+"','"+c.getCaja().getCodCaja()+"' , '"+c.getEstadoApertura().getCodApertura()+"'); ";
            
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
    public  int editarCajaChica(CajaChica c){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   "   UPDATE ventas.caja_chica " +
                            "   SET fecha_turno='"+c.getFechaTurno()+"', "
                            + " cod_personal='"+c.getPersonal().getCodPersonal()+"', "
                            + " monto_inicial='"+c.getMontoInicial()+"', "
                            + " monto_ingresos='"+c.getMontoIngresos()+"', "
                            + " monto_egresos='"+c.getMontoEgresos()+"', "
                            + " monto_saldo='"+c.getMontoSaldo()+"', "
                            + " cod_caja='"+c.getCaja().getCodCaja()+"', "
                            + " cod_estado_apertura='"+c.getEstadoApertura().getCodApertura()+"' " +
                              " WHERE " +
                              " cod_caja_chica='"+c.getCodCajaChica()+"';";
            
                    
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
    public  int eliminarCajaChica(CajaChica e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = this.con.createStatement();
            String cons = " delete from public.empresa where cod_empresa = '"+e.getCodCajaChica()+"' ";
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
    public  List<SelectItem> cargarCajaChicaItem() {
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
