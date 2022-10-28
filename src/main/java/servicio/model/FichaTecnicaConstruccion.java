/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class FichaTecnicaConstruccion extends bean{
    FichaTecnicaProducto fichaTecnicaProducto = new FichaTecnicaProducto();
    PartesProducto partesProducto = new PartesProducto();
    String descripcionPuntada = "";
    String descripcion = "";

    public FichaTecnicaProducto getFichaTecnicaProducto() {
        return fichaTecnicaProducto;
    }

    public void setFichaTecnicaProducto(FichaTecnicaProducto fichaTecnicaProducto) {
        this.fichaTecnicaProducto = fichaTecnicaProducto;
    }

    
    public PartesProducto getPartesProducto() {
        return partesProducto;
    }

    public void setPartesProducto(PartesProducto partesProducto) {
        this.partesProducto = partesProducto;
    }

    public String getDescripcionPuntada() {
        return descripcionPuntada;
    }

    public void setDescripcionPuntada(String descripcionPuntada) {
        this.descripcionPuntada = descripcionPuntada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
