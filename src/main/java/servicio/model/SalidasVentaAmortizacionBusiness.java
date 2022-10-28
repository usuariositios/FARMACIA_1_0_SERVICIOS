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
 * @author COMPUTER
 */
public class SalidasVentaAmortizacionBusiness {
    SalidasVenta salidasVenta = new SalidasVenta();
    List<SalidasVentaAmortizacion> salidasVentaAmortizacionList = new ArrayList<SalidasVentaAmortizacion>();

    public SalidasVenta getSalidasVenta() {
        return salidasVenta;
    }

    public void setSalidasVenta(SalidasVenta salidasVenta) {
        this.salidasVenta = salidasVenta;
    }

    public List<SalidasVentaAmortizacion> getSalidasVentaAmortizacionList() {
        return salidasVentaAmortizacionList;
    }

    public void setSalidasVentaAmortizacionList(List<SalidasVentaAmortizacion> salidasVentaAmortizacionList) {
        this.salidasVentaAmortizacionList = salidasVentaAmortizacionList;
    }
    
}
