/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Computer
 */
public class IngresosVentaBusiness {
    IngresosVenta ingresosVenta = new IngresosVenta();
    List<IngresosVentaDetalle> ingresosVentaDetalleList = new ArrayList<IngresosVentaDetalle>();

    public IngresosVenta getIngresosVenta() {
        return ingresosVenta;
    }

    public void setIngresosVenta(IngresosVenta ingresosVenta) {
        this.ingresosVenta = ingresosVenta;
    }

    public List<IngresosVentaDetalle> getIngresosVentaDetalleList() {
        return ingresosVentaDetalleList;
    }

    public void setIngresosVentaDetalleList(List<IngresosVentaDetalle> ingresosVentaDetalleList) {
        this.ingresosVentaDetalleList = ingresosVentaDetalleList;
    }
    
    
    
    
    
    
    
}
