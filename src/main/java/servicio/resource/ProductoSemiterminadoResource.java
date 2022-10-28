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
import servicio.model.ProductoSemiterminado;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class ProductoSemiterminadoResource {
    /*
    public static List<ProductoSemiterminado> cargarProductoSemiterminado(ProductoSemiterminado ps) {
        List<ProductoSemiterminado> productosList =new ArrayList<ProductoSemiterminado>();
        try {
            
            Connection connection = Utiles.getConnection();

            
            String query = " SELECT PS.CODIGO_PRODUCTO,PS.COD_PRODUCTO_SEMITERMINADO,AE.COD_AREA_EMPRESA,AE.NOMBRE_AREA_EMPRESA,PS.NOMBRE_PRODUCTO_SEMITERMINADO,T.COD_TIPO_PRODUCTO_SEMITERMINADO,T.NOMBRE_TIPO_PRODUCTO_SEMITERMINADO,"
                         + " CP.COD_COLOR_PRODUCTO,CP.NOMBRE_COLOR_PRODUCTO,PS.PESO_APROX,PS.VIDA_UTIL,PS.OBSERVACION,E.COD_ESTADO_PRODUCTO_SEMITERMINADO,E.NOMBRE_ESTADO_PRODUCTO_SEMITERMINADO,TT.COD_TIPO_TELA,TT.NOMBRE_TIPO_TELA,TL.COD_TIPO_LAVADO,TL.NOMBRE_TIPO_LAVADO,PS.DIRECCION_IMAGEN" +
                           " FROM PRODUCTO_SEMITERMINADO PS" +
                           " LEFT OUTER JOIN TIPOS_PRODUCTO_SEMITERMINADO T ON T.COD_TIPO_PRODUCTO_SEMITERMINADO = PS.COD_TIPO_PRODUCTO_SEMITERMINADO" +
                           " LEFT OUTER JOIN COLOR_PRODUCTO CP ON CP.COD_COLOR_PRODUCTO = PS.COD_COLOR" +
                           " LEFT OUTER JOIN AREAS_EMPRESA AE ON AE.COD_AREA_EMPRESA = PS.COD_AREA_EMPRESA"
                           + " LEFT OUTER JOIN TIPOS_TELA TT ON TT.COD_TIPO_TELA = PS.COD_TIPO_TELA"
                           + " LEFT OUTER JOIN TIPOS_LAVADO TL ON TL.COD_TIPO_LAVADO = PS.COD_TIPO_LAVADO"
                           + " INNER JOIN ESTADOS_PRODUCTO_SEMITERMINADO E ON E.COD_ESTADO_PRODUCTO_SEMITERMINADO = PS.COD_ESTADO_PRODUCTO_SEMITERMINADO"
                           + " ORDER BY PS.NOMBRE_PRODUCTO_SEMITERMINADO ASC";
            System.out.println("consulta " +query);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            productosList.clear();
            while (rs.next())
            {
                ProductoSemiterminado p = new ProductoSemiterminado();
                p.setCodProductoSemiterminado(rs.getInt("cod_producto_semiterminado"));
                p.setNombreProductoSemiterminado(rs.getString("nombre_producto_semiterminado"));
                p.getTiposProductoSemiterminado().setCodTipoProductoSemiterminado(rs.getInt("cod_tipo_producto_semiterminado"));
                p.getTiposProductoSemiterminado().setNombreTipoProductoSemiterminado(rs.getString("nombre_tipo_producto_semiterminado"));
                p.getAreasEmpresa().setCodAreaEmpresa(rs.getInt("cod_area_empresa"));
                p.getAreasEmpresa().setNombreAreaEmpresa(rs.getString("nombre_area_empresa"));
                p.getColorProducto().setCodColorProducto(rs.getInt("cod_color_producto"));
                p.getColorProducto().setNombreColorProducto(rs.getString("nombre_color_producto"));
                p.setPesoAprox(rs.getDouble("peso_aprox"));
                p.setVidaUtil(rs.getInt("vida_util"));
                p.setObservacion(rs.getString("observacion"));
                p.getEstadosProductoSemiterminado().setCodEstadoProductoSemiterminado(rs.getInt("cod_estado_producto_semiterminado"));
                p.getEstadosProductoSemiterminado().setNombreEstadoProductoSemiterminado(rs.getString("nombre_estado_producto_semiterminado"));
                p.getTiposTela().setCodTipoTela(rs.getInt("cod_tipo_tela"));
                p.getTiposTela().setNombreTipoTela(rs.getString("nombre_tipo_tela"));
                p.getTiposLavado().setCodTipoLavado(rs.getInt("cod_tipo_lavado"));
                p.getTiposLavado().setNombreTipoLavado(rs.getString("nombre_tipo_lavado"));
                p.setCodigoProducto(rs.getString("codigo_producto"));
                p.setDireccionImagen(rs.getString("direccion_imagen"));
                
                productosList.add(p);
                
            }
            rs.close();
            statement.close();
            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return productosList;
    }
    public static int codigoProductoSemiterminado(){
        int codProductoSemiterminado=0;
        try {
            Connection connection = Utiles.getConnection();
            Statement statement = connection.createStatement();
            String cons = "select COALESCE(max(p.COD_PRODUCTO_SEMITERMINADO),0)+1 cod_producto_semiterminado from PRODUCTO_SEMITERMINADO p";
            System.out.println("cons " + cons);
            ResultSet rs = statement.executeQuery(cons);
            if(rs.next()){
                codProductoSemiterminado = rs.getInt("cod_producto_semiterminado");
            }
            
            statement.close();
            //connection.close();
        } catch (Exception e) {
        }
        //Utiles.closeConnection();
        return codProductoSemiterminado;
    }
    public static int guardarProductoSemiterminado(ProductoSemiterminado p){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Connection con = Utiles.getConnection();
            Statement statement = con.createStatement();
            String cons = "INSERT INTO  PRODUCTO_SEMITERMINADO(  COD_PRODUCTO_SEMITERMINADO,  COD_TIPO_PRODUCTO_SEMITERMINADO,  COD_COLOR,  COD_AREA_EMPRESA,  PESO_APROX," +
                          " COD_ESTADO_PRODUCTO_SEMITERMINADO,  NOMBRE_PRODUCTO_SEMITERMINADO,  OBSERVACION,  VIDA_UTIL,COD_TIPO_TELA,COD_TIPO_LAVADO,CODIGO_PRODUCTO,DIRECCION_IMAGEN) VALUES (  '"+p.getCodProductoSemiterminado()+"',  '"+p.getTiposProductoSemiterminado().getCodTipoProductoSemiterminado()+"'," +
                          " '"+p.getColorProducto().getCodColorProducto()+"',  '"+p.getAreasEmpresa().getCodAreaEmpresa()+"',  '"+p.getPesoAprox()+"',  '"+p.getEstadosProductoSemiterminado().getCodEstadoProductoSemiterminado()+"',  '"+p.getNombreProductoSemiterminado()+"',  '"+p.getObservacion()+"',  '"+p.getVidaUtil()+"',"
                    + "'"+p.getTiposTela().getCodTipoTela()+"','"+p.getTiposLavado().getCodTipoLavado()+"','"+p.getCodigoProducto()+"','"+p.getDireccionImagen()+"');";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public static int editarProductoSemiterminado(ProductoSemiterminado p){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Connection con = Utiles.getConnection();
            Statement statement = con.createStatement();
            String cons = "  UPDATE PRODUCTO_SEMITERMINADO  " +
                            " SET   COD_TIPO_PRODUCTO_SEMITERMINADO = '"+p.getTiposProductoSemiterminado().getCodTipoProductoSemiterminado()+"'," +
                            "  COD_COLOR = '"+p.getColorProducto().getCodColorProducto()+"'," +
                            "  COD_AREA_EMPRESA = '"+p.getAreasEmpresa().getCodAreaEmpresa()+"'," +
                            "  PESO_APROX = '"+p.getPesoAprox()+"'," +
                            "  COD_ESTADO_PRODUCTO_SEMITERMINADO = '"+p.getEstadosProductoSemiterminado().getCodEstadoProductoSemiterminado()+"'," +
                            "  NOMBRE_PRODUCTO_SEMITERMINADO = '"+p.getNombreProductoSemiterminado()+"'," +
                            "  OBSERVACION = '"+p.getObservacion()+"'," +
                            "  VIDA_UTIL = '"+p.getVidaUtil()+"',"+
                            "  COD_TIPO_TELA ='"+p.getTiposTela().getCodTipoTela()+"',"+
                            " COD_TIPO_LAVADO = '"+p.getTiposLavado().getCodTipoLavado()+"',"
                          + "  CODIGO_PRODUCTO = '"+p.getCodigoProducto()+"',"
                          + " DIRECCION_IMAGEN = '"+p.getDireccionImagen()+"' "+
                            " WHERE " +
                            "  COD_PRODUCTO_SEMITERMINADO = '"+p.getCodProductoSemiterminado()+"'";
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public static List<SelectItem> cargarProductoSemiterminadoItem() {
        List<SelectItem> productoList =new ArrayList<SelectItem>();
        try {
            
            Connection con = Utiles.getConnection();

            
            String query = " select p.COD_PRODUCTO_SEMITERMINADO,p.NOMBRE_PRODUCTO_SEMITERMINADO from produccion.PRODUCTO_SEMITERMINADO p ";
            System.out.println("consulta " +query);

            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            productoList.clear();
            while (rs.next())
            {
                productoList.add(new SelectItem(rs.getInt("COD_PRODUCTO_SEMITERMINADO"), rs.getString("NOMBRE_PRODUCTO_SEMITERMINADO")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        //Utiles.closeConnection();
        return productoList;
    }
    public static int eliminarProductoSemiterminado(ProductoSemiterminado p){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            Connection connection = Utiles.getConnection();
            Statement statement = connection.createStatement();
            String cons = " delete from producto_semiterminado where cod_producto_semiterminado = '"+p.getCodProductoSemiterminado()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //connection.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }*/
    
}
