/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class OrdenProduccionPaquetes {
    OrdenProduccion ordenProduccion = new OrdenProduccion();
    int codPaquete=0;
    int cantidadPaquete = 0;
    String codTalla = "";

    public OrdenProduccion getOrdenProduccion() {
        return ordenProduccion;
    }

    public void setOrdenProduccion(OrdenProduccion ordenProduccion) {
        this.ordenProduccion = ordenProduccion;
    }

    public int getCodPaquete() {
        return codPaquete;
    }

    public void setCodPaquete(int codPaquete) {
        this.codPaquete = codPaquete;
    }

    public int getCantidadPaquete() {
        return cantidadPaquete;
    }

    public void setCantidadPaquete(int cantidadPaquete) {
        this.cantidadPaquete = cantidadPaquete;
    }

    public String getCodTalla() {
        return codTalla;
    }

    public void setCodTalla(String codTalla) {
        this.codTalla = codTalla;
    }
    
    
    
    
    
}
