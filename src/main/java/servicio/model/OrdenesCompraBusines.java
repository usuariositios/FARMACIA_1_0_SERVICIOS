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
public class OrdenesCompraBusines {
    OrdenesCompra ordenesCompra = new OrdenesCompra();
    List<OrdenesCompraDetalle> ordenesCompraDetalleList = new ArrayList<OrdenesCompraDetalle>();

    public OrdenesCompra getOrdenesCompra() {
        return ordenesCompra;
    }

    public void setOrdenesCompra(OrdenesCompra ordenesCompra) {
        this.ordenesCompra = ordenesCompra;
    }

    public List<OrdenesCompraDetalle> getOrdenesCompraDetalleList() {
        return ordenesCompraDetalleList;
    }

    public void setOrdenesCompraDetalleList(List<OrdenesCompraDetalle> ordenesCompraDetalleList) {
        this.ordenesCompraDetalleList = ordenesCompraDetalleList;
    }
    
    
}