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
public class DevolucionesBusiness {
    Devoluciones devoluciones = new Devoluciones();
    List<DevolucionesDetalle> devolucionesDetalleList = new ArrayList<DevolucionesDetalle>();

    public Devoluciones getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(Devoluciones devoluciones) {
        this.devoluciones = devoluciones;
    }

    public List<DevolucionesDetalle> getDevolucionesDetalleList() {
        return devolucionesDetalleList;
    }

    public void setDevolucionesDetalleList(List<DevolucionesDetalle> devolucionesDetalleList) {
        this.devolucionesDetalleList = devolucionesDetalleList;
    }
    
    
    
}
