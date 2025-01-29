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
 * @author Henry
 */
public class CajaChicaBusiness {
    CajaChica cajaChica = new CajaChica();
    List<CajaChicaDetalle> cajaChicaDetalleList = new ArrayList<CajaChicaDetalle>();

    public CajaChica getCajaChica() {
        return cajaChica;
    }

    public void setCajaChica(CajaChica cajaChica) {
        this.cajaChica = cajaChica;
    }

    public List<CajaChicaDetalle> getCajaChicaDetalleList() {
        return cajaChicaDetalleList;
    }

    public void setCajaChicaDetalleList(List<CajaChicaDetalle> cajaChicaDetalleList) {
        this.cajaChicaDetalleList = cajaChicaDetalleList;
    }
    
    
    
    
}
