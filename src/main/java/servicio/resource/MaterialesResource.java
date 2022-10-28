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
import servicio.model.Materiales;
import servicio.model.SelectItem;
import servicio.util.Utiles;

/**
 *
 * @author henry
 */
public class MaterialesResource {
    /*
    public static List<Materiales> cargarMateriales(Materiales material) {
        List<Materiales> materialesList =new ArrayList<Materiales>();
        try {
            
            Connection con = Utiles.getConnection();

            
            String query = "SELECT m.cod_material,m.nombre_material,m.observacion,m.cod_estado_registro,m.fecha_creacion,e.nombre_estado_registro,"
                    + " u.cod_unidad_medida,u.nombre_unidad_medida,u.abreviatura,m.codigo_material,u1.cod_unidad_medida cod_unidad_medida_compra,u1.nombre_unidad_medida nombre_unidad_medida_compra,u1.abreviatura abreviatura_compra"
                    + " FROM materiales m"
                    + " inner join estados_registro e on e.cod_estado_registro = m.cod_estado_registro"
                    + " inner join unidades_medida u on u.cod_unidad_medida = m.cod_unidad_medida"
                    + " left outer join unidades_medida u1 on u1.cod_unidad_medida = m.cod_unidad_medida_compra"
                    + " order by m.nombre_material asc ";
            
            query = " SELECT m.cod_material, g.cod_grupo,g.nombre_grupo, u.cod_unidad_medida,u.nombre_unidad_medida,u.abreviatura, u1.cod_unidad_medida cod_unidad_medida_compra,u1.nombre_unidad_medida nombre_unidad_medida_compra,u1.abreviatura abreviatura_compra, " +
                    "       m.nombre_material, m.stock_maximo_material, m.stock_minimo_material, " +
                    "       m.stock_seguridad, m.funcion_material, m.nombre_comercial_material, " +
                    "       m.peso_asociado, m.cod_unidad_medida_pesoasociado, m.caracteristicas_material, " +
                    "       m.tamanio_material, m.tipo_impresion, m.obs_material, e.cod_estado_registro,e.nombre_estado_registro, " +
                    "       m.acabado, m.color, m.capacidad, m.gramaje, m.material_almacen, m.material_muestreo, " +
                    "       m.cantidad_minimamuestreo, m.cantidad_maximamuestreo, m.material_produccion, " +
                    "       m.cod_grupo_stock_material, m.costo_unitario, m.codigo_antiguo, m.movimiento_item, " +
                    "       m.fecha_de_creacion, m.cod_personal, m.tiempo_reposicion, m.premio, m.cod_tipo_premio_promocional, " +
                    "       m.cod_material_insumo, m.cod_categoria, m.cod_tipo_eventos_promocion, " +
                    "       m.cod_hermes, nombre_ccc,c.cod_capitulo,c.nombre_capitulo " +
                    " FROM almacenes.materiales m "
                  + " inner join almacenes.grupos_material g on g.cod_grupo = m.cod_grupo "
                  + " inner join estados_registro e on e.cod_estado_registro = m.cod_estado_registro"
                  + " inner join unidades_medida u on u.cod_unidad_medida = m.cod_unidad_medida"
                  + " inner join almacenes.capitulos_material c on g.cod_capitulo = c.cod_capitulo "
                  + " left outer join unidades_medida u1 on u1.cod_unidad_medida = m.cod_unidad_medida_compra where 0=0 ";
            if(material.getCodMaterial()!=0){query+=" AND m.cod_material = '"+material.getCodMaterial()+"' ";}
            if(material.getGruposMaterial().getCodGrupoMaterial()!=0){query+=" AND m.cod_grupo = '"+material.getGruposMaterial().getCodGrupoMaterial()+"' ";}
            if(material.getGruposMaterial().getCapitulosMaterial().getCodCapituloMaterial()!=0){query+=" AND g.cod_capitulo = '"+material.getGruposMaterial().getCapitulosMaterial().getCodCapituloMaterial()+"' ";}
            if(!material.getNombreMaterial().trim().equals("")){query+=" AND m.nombre_material like '%"+material.getNombreMaterial().toUpperCase()+"%' ";}
            if(!material.getExcluirMateriales().trim().equals("")){query+=" AND m.cod_material not in ("+material.getExcluirMateriales().trim()+") ";}
            
            System.out.println("consulta " +query);

            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            materialesList.clear();
            while (rs.next())
            {
                Materiales m = new Materiales();
                m.setCodMaterial(rs.getInt("cod_material"));
                m.getGruposMaterial().setCodGrupoMaterial(rs.getInt("cod_grupo"));
                m.getGruposMaterial().setNombreGrupoMaterial(rs.getString("nombre_grupo"));
                m.getUnidadesMedida().setCodUnidadMedida(rs.getInt("cod_unidad_medida"));
                m.getUnidadesMedida().setNombreUnidadMedida(rs.getString("nombre_unidad_medida"));
                m.getUnidadesMedida().setAbreviatura(rs.getString("abreviatura"));
                m.getUnidadesMedidaCompra().setCodUnidadMedida(rs.getInt("cod_unidad_medida_compra"));
                m.getUnidadesMedidaCompra().setNombreUnidadMedida(rs.getString("nombre_unidad_medida_compra"));
                m.getUnidadesMedidaCompra().setAbreviatura(rs.getString("abreviatura_compra"));
                m.setNombreMaterial(rs.getString("nombre_material"));
                m.setStockMaximoMaterial(rs.getDouble("stock_maximo_material"));
                m.setStockMinimoMaterial(rs.getDouble("stock_minimo_material"));
                m.setStockSeguridad(rs.getDouble("stock_seguridad"));
                                
                m.setObservacion(rs.getString("obs_material"));
                m.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                m.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                m.setColor(rs.getString("color"));
                m.setGramaje(rs.getString("gramaje"));
                m.setMaterialMuestreo(rs.getInt("material_muestreo"));
                m.setCantidadMinimaMuestreo(rs.getDouble("cantidad_minimamuestreo"));
                m.setCantidadMaximaMuestreo(rs.getDouble("cantidad_maximamuestreo"));
                m.setMaterialProduccion(rs.getInt("material_produccion"));
                m.setCostoUnitario(rs.getDouble("costo_unitario"));
                m.setMovimientoItem(rs.getInt("movimiento_item"));
                
                m.getGruposMaterial().getCapitulosMaterial().setCodCapituloMaterial(rs.getInt("cod_capitulo"));
                m.getGruposMaterial().getCapitulosMaterial().setNombreCapituloMaterial(rs.getString("nombre_capitulo"));
                
                
                //m.setFechaRegistro(rs.getDate("fecha_creacion"));
                
                //m.setCodigoMaterial(rs.getString("codigo_material"));
                
                materialesList.add(m);
            }
            rs.close();
            statement.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return materialesList;
    }
    public static int guardarMateriales(Materiales m){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Connection con = Utiles.getConnection();
            Statement st = con.createStatement();
            
            String cons = "insert into materiales(cod_material,nombre_material,observacion,cod_estado_registro,fecha_creacion,cod_unidad_medida,codigo_material,cod_unidad_medida_compra)"
                    + " values((select COALESCE(max(cod_material)+1,0) from materiales),'"+m.getNombreMaterial()+"','"+m.getObservacion()+"','"+m.getEstadosRegistro().getCodEstado()+"','"+sdf.format(m.getFechaRegistro())+"',"
                    + " '"+m.getUnidadesMedida().getCodUnidadMedida()+"','"+m.getCodigoMaterial()+"','"+m.getUnidadesMedidaCompra().getCodUnidadMedida()+"') ";
            cons = " INSERT INTO almacenes.materiales(" +
                    "            cod_material, cod_grupo, cod_unidad_medida, cod_unidad_medida_compra, " +
                    "            nombre_material, stock_maximo_material, stock_minimo_material, " +
                    "            stock_seguridad, funcion_material, nombre_comercial_material, " +
                    "            peso_asociado, cod_unidad_medida_pesoasociado, caracteristicas_material, " +
                    "            tamanio_material, tipo_impresion, obs_material, cod_estado_registro, " +
                    "            acabado, color, capacidad, gramaje, material_almacen, material_muestreo, " +
                    "            cantidad_minimamuestreo, cantidad_maximamuestreo, material_produccion, " +
                    "            cod_grupo_stock_material, costo_unitario, codigo_antiguo, movimiento_item, " +
                    "            fecha_de_creacion, cod_personal, tiempo_reposicion, premio, cod_tipo_premio_promocional, " +
                    "            cod_material_insumo, cod_categoria, cod_tipo_eventos_promocion, " +
                    "            cod_hermes, nombre_ccc)" +
                    "    VALUES ('"+m.getCodMaterial()+"', '"+m.getGruposMaterial().getCodGrupoMaterial()+"', '"+m.getUnidadesMedida().getCodUnidadMedida()+"', '"+m.getUnidadesMedidaCompra().getCodUnidadMedida()+"', " +
                    "            '"+m.getNombreMaterial()+"', '"+m.getStockMaximoMaterial()+"', '"+m.getStockMinimoMaterial()+"', " +
                    "            '"+m.getStockSeguridad()+"', null,null , " +
                    "            null, null, null, " +
                    "            null, null, '"+m.getObservacion()+"', '"+m.getEstadosRegistro().getCodEstado()+"', " +
                    "            null, '"+m.getColor()+"', null, '"+m.getGramaje()+"', '"+m.getMaterialAlmacen()+"', '"+m.getMaterialMuestreo()+"', " +
                    "            '"+m.getCantidadMinimaMuestreo()+"', '"+m.getCantidadMaximaMuestreo()+"', '"+m.getMaterialProduccion()+"', " +
                    "            null, '"+m.getCostoUnitario()+"', null, '"+m.getMovimientoItem()+"', " +
                    "            date(), null, null, null, null, " +
                    "            null, null, null, " +
                    "            null, null); ";
            
            System.out.println("cons " + cons);
            guardado = st.executeUpdate(cons);
            
            st.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public static int editarMaterial(Materiales m){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Connection con = Utiles.getConnection();
            Statement statement = con.createStatement();
            String cons = " update materiales set nombre_material = '"+m.getNombreMaterial()+"', observacion = '"+m.getObservacion()+"',cod_estado_registro = '"+m.getEstadosRegistro().getCodEstado()+"'"
                        + ", cod_unidad_medida = '"+m.getUnidadesMedida().getCodUnidadMedida()+"',codigo_material ='"+m.getCodigoMaterial()+"',cod_unidad_medida_compra = '"+m.getUnidadesMedidaCompra().getCodUnidadMedida()+"' where cod_material = '"+m.getCodMaterial()+"' ";
            
            cons =  "   UPDATE almacenes.materiales" +
                    "   SET cod_grupo='"+m.getGruposMaterial().getCodGrupoMaterial()+"', cod_unidad_medida='"+m.getUnidadesMedida().getCodUnidadMedida()+"', cod_unidad_medida_compra='"+m.getUnidadesMedidaCompra().getCodUnidadMedida()+"', " +
                    "       nombre_material='"+m.getNombreMaterial()+"', stock_maximo_material='"+m.getStockMaximoMaterial()+"', stock_minimo_material='"+m.getStockMinimoMaterial()+"', " +
                    "       stock_seguridad='"+m.getStockSeguridad()+"', funcion_material=null, nombre_comercial_material=null, " +
                    "       peso_asociado=null, cod_unidad_medida_pesoasociado=null, caracteristicas_material=null, " +
                    "       tamanio_material=null, tipo_impresion=null, obs_material='"+m.getObservacion()+"', cod_estado_registro='"+m.getEstadosRegistro().getCodEstado()+"', " +
                    "       acabado=null, color='"+m.getColor()+"', capacidad='"+m.getCapacidad()+"', gramaje='"+m.getGramaje()+"', material_almacen='"+m.getMaterialAlmacen()+"', " +
                    "       material_muestreo='"+m.getMaterialMuestreo()+"', cantidad_minimamuestreo='"+m.getCantidadMinimaMuestreo()+"', cantidad_maximamuestreo='"+m.getCantidadMaximaMuestreo()+"', " +
                    "       material_produccion='"+m.getMaterialProduccion()+"', cod_grupo_stock_material=null, costo_unitario='"+m.getCostoUnitario()+"', " +
                    "       codigo_antiguo=null, movimiento_item='"+m.getMovimientoItem()+"', fecha_de_creacion=?, cod_personal='"+m.getPersonal().getCodPersonal()+"', " +
                    "       tiempo_reposicion=null, premio=null, cod_tipo_premio_promocional=null, " +
                    "       cod_material_insumo=null, cod_categoria=null, cod_tipo_eventos_promocion=null, " +
                    "       cod_hermes=null, nombre_ccc=null " +
                    " WHERE cod_material='"+m.getCodMaterial()+"' ;";
            
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            
            statement.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public static int eliminarMaterial(Materiales materiales){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        int guardado = 0;
        try {
            
            Connection con = Utiles.getConnection();
            Statement statement = con.createStatement();
            String cons = " delete from materiales where cod_material = '"+materiales.getCodMaterial()+"' ";
            System.out.println("cons " + cons);
            guardado = statement.executeUpdate(cons);
            statement.close();
            //con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        return guardado;
    }
    public static List<SelectItem> cargarMaterialesItem(Materiales m) {
        List<SelectItem> materialesList =new ArrayList<SelectItem>();
        try {
            Connection con = Utiles.getConnection();
            
            String query = " select cod_material,nombre_material from materiales m where m.cod_estado_registro=1 and m.cod_grupo = '"+m.getGruposMaterial().getCodGrupoMaterial()+"' ";
            
            System.out.println("consulta " +query);

            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            materialesList.clear();
            while (rs.next())
            {
                materialesList.add(new SelectItem(rs.getInt("cod_material"), rs.getString("nombre_material")));
            }
            rs.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return materialesList;
    }
    public static Materiales  buscarMateriales(Materiales m) {
        Materiales materiales = new Materiales();
        try {
            
            Connection con = Utiles.getConnection();

            
            String query =  "  SELECT m.cod_material, m.nombre_material, m.observacion, m.cod_estado_registro,  " +
                            "  m.fecha_creacion, m.cod_unidad_medida, m.codigo_material, m.cod_unidad_medida_compra,u.abreviatura " +
                            "  FROM materiales m "
                          + "  inner join unidades_medida u on u.cod_unidad_medida = m.cod_unidad_medida_compra "
                          + "  where cod_material = '"+m.getCodMaterial()+"'  ";
            
            query = " SELECT m.cod_material, m.cod_grupo, m.cod_unidad_medida, m.cod_unidad_medida_compra, " +
                    "       m.nombre_material, m.stock_maximo_material, m.stock_minimo_material, " +
                    "       m.stock_seguridad, m.funcion_material, m.nombre_comercial_material, " +
                    "       m.peso_asociado, m.cod_unidad_medida_pesoasociado, m.caracteristicas_material, " +
                    "       m.tamanio_material, m.tipo_impresion, m.obs_material, m.cod_estado_registro, " +
                    "       m.acabado, m.color, m.capacidad, m.gramaje, m.material_almacen, m.material_muestreo, " +
                    "       m.cantidad_minimamuestreo, m.cantidad_maximamuestreo, m.material_produccion, " +
                    "       m.cod_grupo_stock_material, m.costo_unitario, m.codigo_antiguo, m.movimiento_item, " +
                    "       m.fecha_de_creacion, m.cod_personal, m.tiempo_reposicion, m.premio, m.cod_tipo_premio_promocional, " +
                    "       m.cod_material_insumo, m.cod_categoria, m.cod_tipo_eventos_promocion, " +
                    "       m.cod_hermes, nombre_ccc,c.cod_capitulo,c.nombre_capitulo " +
                    " FROM almacenes.materiales m "
                  + " inner join almacenes.grupos_material g on g.cod_grupo = m.cod_grupo"
                  + " inner join almacenes.capitulos_material c on g.cod_capitulo = c.cod_capitulo  where 0=0 ";
            if(m.getCodMaterial()!=0){query+=" AND m.cod_material = '"+m.getCodMaterial()+"' ";}
            if(m.getGruposMaterial().getCodGrupoMaterial()!=0){query+=" AND m.cod_grupo = '"+m.getGruposMaterial().getCodGrupoMaterial()+"' ";}
            if(m.getGruposMaterial().getCapitulosMaterial().getCodCapituloMaterial()!=0){query+=" AND g.cod_capitulo = '"+m.getGruposMaterial().getCapitulosMaterial().getCodCapituloMaterial()+"' ";}
            
            System.out.println("consulta " +query);

            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            
            if(rs.next())
            {
                materiales.setCodMaterial(rs.getInt("cod_material"));
                materiales.getGruposMaterial().setCodGrupoMaterial(rs.getInt("cod_grupo"));
                materiales.getUnidadesMedida().setCodUnidadMedida(rs.getInt("cod_unidad_medida"));
                materiales.getUnidadesMedida().setNombreUnidadMedida(rs.getString("nombre_unidad_medida"));
                materiales.getUnidadesMedida().setAbreviatura(rs.getString("abreviatura"));
                materiales.getUnidadesMedidaCompra().setCodUnidadMedida(rs.getInt("cod_unidad_medida_compra"));
                materiales.getUnidadesMedidaCompra().setNombreUnidadMedida(rs.getString("nombre_unidad_medida_compra"));
                materiales.getUnidadesMedidaCompra().setAbreviatura(rs.getString("abreviatura_compra"));
                materiales.setNombreMaterial(rs.getString("nombre_material"));
                materiales.setStockMaximoMaterial(rs.getDouble("stock_maximo_material"));
                materiales.setStockMinimoMaterial(rs.getDouble("stock_minimo_material"));
                materiales.setStockSeguridad(rs.getDouble("stock_seguridad"));
                                
                materiales.setObservacion(rs.getString("observacion"));
                materiales.getEstadosRegistro().setCodEstado(rs.getInt("cod_estado_registro"));
                materiales.getEstadosRegistro().setNombreEstado(rs.getString("nombre_estado_registro"));
                materiales.setColor(rs.getString("color"));
                materiales.setGramaje(rs.getString("gramaje"));
                materiales.setMaterialMuestreo(rs.getInt("material_muestreo"));
                materiales.setCantidadMinimaMuestreo(rs.getDouble("cantidad_minimamuestreo"));
                materiales.setCantidadMaximaMuestreo(rs.getDouble("cantidad_maximamuestreo"));
                materiales.setMaterialProduccion(rs.getInt("material_produccion"));
                materiales.setCostoUnitario(rs.getDouble("costo_unitario"));
                materiales.setMovimientoItem(rs.getInt("movimiento_item"));
                
                
                materiales.setFechaRegistro(rs.getDate("fecha_creacion"));
                
                materiales.setCodigoMaterial(rs.getString("codigo_material"));
                
                materiales.getGruposMaterial().getCapitulosMaterial().setCodCapituloMaterial(rs.getInt("cod_capitulo"));
                materiales.getGruposMaterial().getCapitulosMaterial().setNombreCapituloMaterial(rs.getString("nombre_capitulo"));
                
            }
            rs.close();
            statement.close();
            //con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Utiles.closeConnection();
        //Query q = em.createQuery("select object(i) from Items as i");
        //return q.getResultList();
        return materiales;
    }*/
    
}
