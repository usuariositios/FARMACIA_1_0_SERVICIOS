/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Computer
 */
@XmlRootElement
public class SalidasVentaBusiness {
    
    SalidasVenta salidasVenta = new SalidasVenta();
    //@JsonbTransient //hay recursividad
    List<SalidasVentaDetalle> salidasVentaDetalleList = new ArrayList<SalidasVentaDetalle>(); 
    
    FacturasEmitidas facturasEmitidas = new FacturasEmitidas();
    
    CajaChica cajaChica = new CajaChica();
    

    public SalidasVenta getSalidasVenta() {
        return salidasVenta;
    }

    public void setSalidasVenta(SalidasVenta salidasVenta) {
        this.salidasVenta = salidasVenta;
    }

    public List<SalidasVentaDetalle> getSalidasVentaDetalleList() {
        return salidasVentaDetalleList;
    }

    public void setSalidasVentaDetalleList(List<SalidasVentaDetalle> salidasVentaDetalleList) {
        this.salidasVentaDetalleList = salidasVentaDetalleList;
    }

    public FacturasEmitidas getFacturasEmitidas() {
        return facturasEmitidas;
    }

    public void setFacturasEmitidas(FacturasEmitidas facturasEmitidas) {
        this.facturasEmitidas = facturasEmitidas;
    }

    public CajaChica getCajaChica() {
        return cajaChica;
    }

    public void setCajaChica(CajaChica cajaChica) {
        this.cajaChica = cajaChica;
    }
    
    
}
