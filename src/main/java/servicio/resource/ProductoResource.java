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


import servicio.model.Productos;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class ProductoResource {
    Connection con;
    public ProductoResource(){
    }
    public ProductoResource(Connection con){
        this.con = con;
    }
    public  List<Productos> cargarProductos(Productos pr) {
        List<Productos> listProductos =new ArrayList<Productos>();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //yyyy/MM/dd HH:mm:ss
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();

            
            String query =  " SELECT p.cod_producto,p.codigo_producto,p.nombre_producto,p.descripcion_producto,p.cod_grupo_producto,g.nombre_grupo_producto,p.impuesto_producto, " +
                            " p.cod_proveedor1,pr1.nombre_proveedor nombre_proveedor1,p.cod_proveedor2,pr2.nombre_proveedor nombre_proveedor2,p.descripcion_corta_producto,p.stock_minimo,p.stock_maximo,p.aviso_stock_minimo, " +
                            " p.fecha_registro,p.cod_empaque_externo,e.nombre_empaque_externo,p.cantidad_por_caja,p.observaciones,p.precio_compra,p.precio_almacen, " +
                            " p.precio_tienda,p.precio_iva,p.cod_estado_registro,er.nombre_estado_registro,u.cod_unidad_medida,u.nombre_unidad_medida,sg.cod_sub_grupo,sg.nombre_sub_grupo,uv.cod_unidad_medida cod_unidad_medida_compra,"+
                            " uv.nombre_unidad_medida nombre_unidad_medida_compra,p.cant_p_compra_venta,p.porc_desc_max,p.cod_barras_producto,imagen_producto,"+
                    
                            " p.cod_forma_farmaceutica,ff.nombre_campo nombre_forma_farmaceutica, p.cod_accion_terapeutica, at.nombre_campo nombre_accion_terapeutica, "+
                            " p.cod_laboratorio,lab.nombre_campo nombre_laboratorio , p.precio_compra_blister, p.precio_venta_blister, p.cant_unidades_blister, p.precio_compra_caja, p.precio_venta_caja, p.cant_unidades_caja,p.cod_presentacion"
                    + " ,pp.nombre_campo nombre_presentacion ,p.principio_activo,p.psicotropico,p.ubicacion,p.cod_nombre_generico,cp.nombre_campo nombre_categoria,ng.nombre_campo descripcionNombreGenerico " +
                            " FROM " +
                            " public.productos p " +                            
                            " inner join public.estados_registro er on er.cod_estado_registro = p.cod_estado_registro " +
                            " inner join public.unidades_medida u on u.cod_unidad_medida = p.cod_unidad_medida " +
                    
                            " left outer join ( select tdfm.* from ventas.tabla_detalle tdfm  " +
                            " INNER JOIN ventas.tabla tfm ON tdfm.cod_tabla = tfm.cod_tabla AND tfm.nombre_tabla = 'FORMA_FARMACEUTICA' ) ff on ff.cod_campo = p.cod_forma_farmaceutica " +
                    
                            " left outer join ( select tda.* from ventas.tabla_detalle tda  " +
                            " INNER JOIN ventas.tabla ta ON tda.cod_tabla = ta.cod_tabla AND ta.nombre_tabla = 'ACCION_TERAPEUTICA' ) at on at.cod_campo = p.cod_accion_terapeutica " +
                    
                            " left outer join ( select tdl.* from ventas.tabla_detalle tdl " +
                            " INNER JOIN ventas.tabla tl ON tdl.cod_tabla = tl.cod_tabla AND tl.nombre_tabla = 'LABORATORIOS' ) lab on lab.cod_campo = p.cod_laboratorio " +
                    
                            " left outer join ( select tdp.* from ventas.tabla_detalle tdp  " +
                            " INNER JOIN ventas.tabla tp ON tdp.cod_tabla = tp.cod_tabla AND tp.nombre_tabla = 'PRESENTACIONES_PRODUCTO' ) pp on pp.cod_campo = p.cod_presentacion " +
                    
                            " left outer join ( select tdn.* from ventas.tabla_detalle tdn  " +
                            " INNER JOIN ventas.tabla tp ON tdn.cod_tabla = tp.cod_tabla AND tp.nombre_tabla = 'NOMBRE_GENERICO' ) ng on ng.cod_campo = p.cod_nombre_generico " +
                    
                            " left outer join ( select tdc.* from ventas.tabla_detalle tdc  " +
                            " INNER JOIN ventas.tabla tp ON tdc.cod_tabla = tp.cod_tabla AND tp.nombre_tabla = 'CATEGORIAS_PRODUCTO' ) cp on cp.cod_campo = p.cod_categoria " +
                    
                            
                    
                            " left outer join public.grupo_producto g on g.cod_grupo_producto = p.cod_grupo_producto  " +
                            " left outer join public.proveedores pr1 on pr1.cod_proveedor = p.cod_proveedor1  " +
                            " left outer join public.proveedores pr2 on pr2.cod_proveedor = p.cod_proveedor2 " +
                            
                            " left outer join public.empaque_externo e on e.cod_empaque_externo = p.cod_empaque_externo" +
                            " left outer join public.sub_grupos_producto sg on sg.cod_sub_grupo = p.cod_sub_grupo " +
                            " left outer join public.unidades_medida uv on uv.cod_unidad_medida = p.cod_unidad_medida_compra" +
                            " where 0=0  ";
                            if(!pr.getNombreProducto().trim().equals("")){query+=" AND UPPER(p.nombre_producto) like '%"+pr.getNombreProducto().toUpperCase()+"%' ";}
                            if(pr.getAccionTerapeutica().getCodAccionTerapeutica() !=0){query+=" AND p.cod_accion_terapeutica = '"+pr.getAccionTerapeutica().getCodAccionTerapeutica()+"' ";}
                            if(pr.getPresentacionesProducto().getCodPresentacionProducto() !=0){query+=" AND p.cod_presentacion = '"+pr.getPresentacionesProducto().getCodPresentacionProducto()+"' ";}
                            
                            //if(pr.getProveedores1().getCodProveedor()!=0){query+=" AND p.cod_proveedor1 = '"+pr.getProveedores1().getCodProveedor()+"' ";}
                            if(pr.getUnidadesMedida().getCodUnidadMedida()!=0){query+=" AND p.cod_unidad_medida = '"+pr.getUnidadesMedida().getCodUnidadMedida()+"' ";}
                            if(!pr.getObservaciones().trim().equals("")){query+=" AND UPPER(p.observaciones) like '%"+pr.getObservaciones().toUpperCase()+"%' ";}
                            if(pr.getEstadosRegistro().getCodEstado()!=0){query+=" AND p.cod_estado_registro = '"+pr.getEstadosRegistro().getCodEstado()+"' ";}
                            if(!pr.getCodBarrasProducto().trim().equals("")){query+=" AND p.cod_barras_producto = '"+pr.getCodBarrasProducto()+"' ";}
                            if(!pr.getSinCodProducto().equals("")){query+=" AND p.cod_producto not in ("+pr.getSinCodProducto()+") ";}
                            if(pr.getCodProducto()!=0){query+=" AND p.cod_producto = "+pr.getCodProducto()+"  ";}
                            if(pr.getCategoriaProducto().getCodCategoriaProducto()!=0){query+=" AND p.cod_categoria = "+pr.getCategoriaProducto().getCodCategoriaProducto()+"  ";}
                            query +=" order by p.cod_producto desc ";
                            if(pr.getFilaInicial()>0)
                            {query +=" limit 10 offset "+pr.getFilaInicial();}
                            
            
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            listProductos.clear();
            while (rs.next())
            {
                Productos  p = new Productos();
                p.setCodProducto(rs.getInt("cod_producto"));
                p.setNombreProducto(rs.getString("nombre_producto"));
                p.setDescripcionProducto(rs.getString("descripcion_producto"));
                p.getGrupoProducto().setCodGrupoProducto(rs.getInt("cod_grupo_producto"));
                p.getGrupoProducto().setNombreGrupoProducto(rs.getString("nombre_grupo_producto"));
                p.setImpuestoProducto(rs.getDouble("impuesto_producto"));
                p.getProveedores1().setCodProveedor(rs.getInt("cod_proveedor1"));
                p.getProveedores1().setNombreProveedor(rs.getString("nombre_proveedor1"));
                p.getProveedores2().setCodProveedor(rs.getInt("cod_proveedor2"));
                p.getProveedores2().setNombreProveedor(rs.getString("nombre_proveedor2"));
                p.setDescripcionCortaProducto(rs.getString("descripcion_corta_producto"));
                p.setStockMinimo(rs.getDouble("stock_minimo"));
                p.setStockMaximo(rs.getDouble("stock_maximo"));
                p.setAvisoStockMinimo(rs.getInt("aviso_stock_minimo"));
                p.setFechaRegistro(sdf1.format(rs.getTimestamp("fecha_registro")));                
                p.getEmpaqueExterno().setCodEmpaqueExterno(rs.getInt("cod_empaque_externo"));
                p.getEmpaqueExterno().setNombreEmpaqueExterno(rs.getString("nombre_empaque_externo"));
                p.setCantidadPorCaja(rs.getDouble("cantidad_por_caja"));
                p.setObservaciones(rs.getString("observaciones"));
                p.setPrecioCompra(rs.getDouble("precio_compra"));
                p.setPrecioAlmacen(rs.getDouble("precio_almacen"));
                p.setPrecioTienda(rs.getDouble("precio_tienda"));
                p.setPrecioIva(rs.getDouble("precio_iva"));
                p.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                p.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                p.getUnidadesMedida().setCodUnidadMedida(rs.getInt("cod_unidad_medida"));
                p.getUnidadesMedida().setNombreUnidadMedida(rs.getString("nombre_unidad_medida"));
                p.getSubGruposProducto().setCodSubgrupo(rs.getInt("cod_sub_grupo"));
                p.getSubGruposProducto().setNombreSubGrupo(rs.getString("nombre_sub_grupo"));
                p.getUnidadesMedidaCompra().setCodUnidadMedida(rs.getInt("cod_unidad_medida_compra"));
                p.getUnidadesMedidaCompra().setNombreUnidadMedida(rs.getString("nombre_unidad_medida_compra"));
                p.setCantPCompraVenta(rs.getDouble("cant_p_compra_venta"));//factor de conversion por cada unidad de compra 1kilo -> 100 metros de algo y asi
                p.setPorcentajeDescuentoMaximo(rs.getDouble("porc_desc_max"));
                p.setCodigoProducto(rs.getString("codigo_producto"));
                p.setCodBarrasProducto(rs.getString("cod_barras_producto"));
                p.setImagenProducto(rs.getString("imagen_producto"));
                
                
                //p.getCategoriaProducto().setCodCategoriaProducto(rs.getInt("cod_categoria"));
                p.getCategoriaProducto().setNombreCategoriaProducto(rs.getString("nombre_categoria"));
                p.getAccionTerapeutica().setCodAccionTerapeutica(rs.getInt("cod_accion_terapeutica"));
                p.getAccionTerapeutica().setNombreAccionTerapeutica(rs.getString("cod_accion_terapeutica"));
                p.getLaboratorio().setCodLaboratorio(rs.getInt("cod_laboratorio"));
                p.getLaboratorio().setNombreLaboratorio(rs.getString("nombre_laboratorio"));
                p.setPrecioCompraBlister(rs.getDouble("precio_compra_blister"));
                p.setPrecioVentaBlister(rs.getDouble("precio_venta_blister"));
                p.setCantUnidadesBlister(rs.getDouble("cant_unidades_blister"));
                p.setPrecioCompraCaja(rs.getDouble("precio_compra_caja"));
                p.setPrecioVentaCaja(rs.getDouble("precio_venta_caja"));
                p.setCantUnidadesCaja(rs.getDouble("cant_unidades_caja"));
                /*principio_activo,psicotropico,ubicacion*/
                p.getPresentacionesProducto().setCodPresentacionProducto(rs.getInt("cod_presentacion"));
                p.getPresentacionesProducto().setNombrePresentacionProducto(rs.getString("nombre_presentacion"));
                p.setPrincipioActivo(rs.getString("principio_activo"));
                p.setPsicotropico(rs.getInt("psicotropico"));
                p.setUbicacion(rs.getString("ubicacion"));
                p.getFormaFarmaceutica().setCodFormaFarmaceutica(rs.getInt("cod_forma_farmaceutica"));
                p.getFormaFarmaceutica().setNombreFormaFarmaceutica(rs.getString("nombre_forma_farmaceutica"));
                p.getNombreGenerico().setCodNombreGenerico(rs.getInt("cod_nombre_generico"));
                p.getNombreGenerico().setDescripcionNombreGenerico(rs.getString("descripcionNombreGenerico"));
                
                listProductos.add(p);
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
        return listProductos;
    }
    public  int guardarProducto(Productos p){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
           
            /*Utiles utiles = new Utiles();
            utiles.getConnection();
             '"+sdf.format(p.getFechaRegistro())+"'*/
            Statement statement = this.con.createStatement();
            String cons =  " INSERT INTO  public.productos " +
                    "(cod_producto,  nombre_producto,  descripcion_producto,  cod_grupo_producto,  impuesto_producto,  cod_proveedor1, " +
                    " cod_proveedor2,  descripcion_corta_producto,  stock_minimo,  stock_maximo,  aviso_stock_minimo, " +
                    " fecha_registro, cod_empaque_externo,  cantidad_por_caja,  observaciones,  precio_compra, " +
                    " precio_almacen, precio_tienda,  precio_iva,  cod_estado_registro,cod_unidad_medida,cod_sub_grupo,cod_unidad_medida_compra,cant_p_compra_venta,porc_desc_max,codigo_producto,cod_barras_producto,imagen_producto,"+
                    " cod_categoria, cod_accion_terapeutica,cod_laboratorio, precio_compra_blister, precio_venta_blister, cant_unidades_blister, precio_compra_caja, precio_venta_caja, cant_unidades_caja,cod_presentacion,principio_activo,psicotropico,ubicacion,cod_nombre_generico,cod_forma_farmaceutica ) " +
                    " VALUES (  (select nextval('public.\"seqProducto\"')),  '"+p.getNombreProducto()+"',  '"+p.getDescripcionProducto()+"',  '"+p.getGrupoProducto().getCodGrupoProducto()+"',  '"+p.getImpuestoProducto()+"', " +
                    " '"+p.getProveedores1().getCodProveedor()+"',  '"+p.getProveedores2().getCodProveedor()+"',  '"+p.getDescripcionCortaProducto()+"',  '"+p.getStockMinimo()+"',  '"+p.getStockMaximo()+"', " +
                    " '"+p.getAvisoStockMinimo()+"', CURRENT_DATE ,  '"+p.getEmpaqueExterno().getCodEmpaqueExterno()+"',  '"+p.getCantidadPorCaja()+"',  '"+p.getObservaciones()+"', " +
                    " '"+p.getPrecioCompra()+"',  '"+p.getPrecioAlmacen()+"',  '"+p.getPrecioTienda()+"',  '"+p.getPrecioIva()+"',  '"+p.getEstadosRegistro().getCodEstado()+"','"+p.getUnidadesMedida().getCodUnidadMedida()+"','"+p.getSubGruposProducto().getCodSubgrupo()+"',"+
                    " '"+p.getUnidadesMedidaCompra().getCodUnidadMedida()+"','"+p.getCantPCompraVenta()+"','"+p.getPorcentajeDescuentoMaximo()+"','"+p.getCodigoProducto()+"','"+p.getCodBarrasProducto()+"','"+p.getImagenProducto()+"',"+
                    " '"+p.getCategoriaProducto().getCodCategoriaProducto()+"','"+p.getAccionTerapeutica().getCodAccionTerapeutica()+"','"+p.getLaboratorio().getCodLaboratorio()+"','"+p.getPrecioCompraBlister()+"','"+p.getPrecioVentaBlister()+"','"+p.getCantUnidadesBlister()+"',"
                    + "'"+p.getPrecioCompraCaja()+"','"+p.getPrecioVentaCaja()+"','"+p.getCantUnidadesCaja()+"','"+p.getPresentacionesProducto().getCodPresentacionProducto()+"','"+p.getPrincipioActivo()+"','"+p.getPsicotropico()+"','"+p.getUbicacion()+"',"
                    + "'"+p.getNombreGenerico().getCodNombreGenerico()+"','"+p.getFormaFarmaceutica().getCodFormaFarmaceutica()+"'); ";
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            System.out.println("guardado " + guardado);
            
            statement.close();
            //connection.close();
            //utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return guardado;
    }
    public int codCiudad(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }
    public  int editarProducto(Productos p){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            /*Utiles utiles = new Utiles();
            utiles.getConnection();*/
            Statement statement = this.con.createStatement();
            String cons =   " UPDATE public.productos  " +
                            " SET  " +
                            "  nombre_producto = '"+p.getNombreProducto()+"', " +
                            "  descripcion_producto = '"+p.getDescripcionProducto()+"', " +
                            "  cod_grupo_producto = '"+p.getGrupoProducto().getCodGrupoProducto()+"', " +
                            "  impuesto_producto = '"+p.getImpuestoProducto()+"', " +
                            "  cod_proveedor1 = '"+p.getProveedores1().getCodProveedor()+"', " +
                            "  cod_proveedor2 = '"+p.getProveedores2().getCodProveedor()+"', " +
                            "  descripcion_corta_producto = '"+p.getDescripcionCortaProducto()+"', " +
                            "  stock_minimo = '"+p.getStockMinimo()+"', " +
                            "  stock_maximo = '"+p.getStockMaximo()+"', " +
                            "  aviso_stock_minimo = '"+p.getAvisoStockMinimo()+"', " +
                            //"  fecha_registro = '"+sdf.format(p.getFechaRegistro())+"', " +
                            "  cod_empaque_externo = '"+p.getEmpaqueExterno().getCodEmpaqueExterno()+"', " +
                            "  cantidad_por_caja = '"+p.getCantidadPorCaja()+"', " +
                            "  observaciones = '"+p.getObservaciones()+"', " +
                            "  precio_compra = '"+p.getPrecioCompra()+"', " +
                            "  precio_almacen = '"+p.getPrecioAlmacen()+"', " +
                            "  precio_tienda = '"+p.getPrecioTienda()+"', " +
                            "  precio_iva = '"+p.getPrecioIva()+"', " +
                            "  cod_estado_registro = '"+p.getEstadosRegistro().getCodEstado()+"',"+
                            "  cod_unidad_medida = '"+p.getUnidadesMedida().getCodUnidadMedida()+"',"+
                            "  cod_sub_grupo = '"+p.getSubGruposProducto().getCodSubgrupo()+"', " +
                            "  cod_unidad_medida_compra = '"+p.getUnidadesMedidaCompra().getCodUnidadMedida()+"', " +
                            "  cant_p_compra_venta = '"+p.getCantPCompraVenta()+"',"+
                            "  porc_desc_max='"+p.getPorcentajeDescuentoMaximo()+"',"+
                            "  codigo_producto='"+p.getCodigoProducto()+"',"+
                            "  cod_barras_producto = '"+p.getCodBarrasProducto()+"',"+
                            "  imagen_producto = '"+p.getImagenProducto()+"',"+
                            "  cod_categoria = '"+p.getCategoriaProducto().getCodCategoriaProducto()+"', "+
                            "  cod_accion_terapeutica = '"+p.getAccionTerapeutica().getCodAccionTerapeutica()+"', "+
                            "  cod_laboratorio = '"+p.getLaboratorio().getCodLaboratorio()+"', "+
                            "  precio_compra_blister='"+p.getPrecioCompraBlister()+"', "+
                            "  precio_venta_blister='"+p.getPrecioVentaBlister()+"', "+
                            "  cant_unidades_blister='"+p.getCantUnidadesBlister()+"', "+
                            "  precio_compra_caja='"+p.getPrecioCompraCaja()+"', "+
                            "  precio_venta_caja='"+p.getPrecioVentaCaja()+"', "+
                            "  cant_unidades_caja='"+p.getCantUnidadesCaja()+"', "+
                            "  cod_presentacion='"+p.getPresentacionesProducto().getCodPresentacionProducto()+"', "+
                            "  principio_activo = '"+p.getPrincipioActivo()+"'," +
                            "  psicotropico = '"+p.getPsicotropico()+"'," +
                            "  ubicacion = '"+p.getUbicacion()+"'," +
                            "  cod_nombre_generico = '"+p.getNombreGenerico().getCodNombreGenerico()+"'," +
                            "  cod_forma_farmaceutica = '"+p.getFormaFarmaceutica().getCodFormaFarmaceutica()+"'" +
                            "  WHERE  " +
                            "  cod_producto = '"+p.getCodProducto()+"' " +
                            ";  ";
            
                    
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //connection.close();
            //utiles.closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return guardado;
    }
    public  int eliminarProducto(Productos e){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            Statement statement = utiles.getCon().createStatement();
            String cons = " delete from public.productos where cod_producto = '"+e.getCodProducto()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return guardado;
    }
    public  List<SelectItem> cargarProductoItem() {
        List<SelectItem> productoList =new ArrayList<SelectItem>();
        try {
            
            Utiles utiles = new Utiles();
            utiles.getConnection();
            
            String query = "SELECT cod_producto,nombre_producto from public.productos";
            System.out.println("consulta " +query);

            PreparedStatement statement = utiles.getCon().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            productoList.clear();
            while (rs.next())
            {
                productoList.add(new SelectItem(rs.getInt("cod_producto"), rs.getString("nombre_producto")));
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
        return productoList;
    }
    
    public  Productos buscarProductos(Productos pr) {
        Productos  p = new Productos();
        try {
            List<Productos> listProductos = this.cargarProductos(pr);
            for(Productos pr1:listProductos){
                p = pr1;
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return p;
    }
    
}
