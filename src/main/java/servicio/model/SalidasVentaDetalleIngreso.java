/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Computer
 */
@XmlRootElement
public class SalidasVentaDetalleIngreso {
    //@JsonIgnore
    @JsonbTransient //hay recursividad
    SalidasVentaDetalle salidasVentaDetalle = new SalidasVentaDetalle();
    IngresosVentaDetalle ingresosVentaDetalle = new IngresosVentaDetalle();    
    double cantSacar = 0.0;//cantidad vendida
    double cantRetornado = 0.0;//cantidad Retorno

    public SalidasVentaDetalle getSalidasVentaDetalle() {
        return salidasVentaDetalle;
    }

    public void setSalidasVentaDetalle(SalidasVentaDetalle salidasVentaDetalle) {
        this.salidasVentaDetalle = salidasVentaDetalle;
    }

    public IngresosVentaDetalle getIngresosVentaDetalle() {
        return ingresosVentaDetalle;
    }

    public void setIngresosVentaDetalle(IngresosVentaDetalle ingresosVentaDetalle) {
        this.ingresosVentaDetalle = ingresosVentaDetalle;
    }

    public double getCantSacar() {
        return cantSacar;
    }

    public void setCantSacar(double cantSacar) {
        this.cantSacar = cantSacar;
    }

    public double getCantRetornado() {
        return cantRetornado;
    }

    public void setCantRetornado(double cantRetornado) {
        this.cantRetornado = cantRetornado;
    }

    
   

    

   
    
    
    
    
    
    
    
    
    
    
    
    
}
