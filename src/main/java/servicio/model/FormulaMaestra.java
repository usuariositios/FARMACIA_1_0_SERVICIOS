/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class FormulaMaestra extends bean{
    ProductoSemiterminado productoSemiterminado = new ProductoSemiterminado();
    int codFormulaMaestra = 0;
    int cantidadLote = 0;

    public ProductoSemiterminado getProductoSemiterminado() {
        return productoSemiterminado;
    }

    public void setProductoSemiterminado(ProductoSemiterminado productoSemiterminado) {
        this.productoSemiterminado = productoSemiterminado;
    }

    public int getCodFormulaMaestra() {
        return codFormulaMaestra;
    }

    public void setCodFormulaMaestra(int codFormulaMaestra) {
        this.codFormulaMaestra = codFormulaMaestra;
    }

    public int getCantidadLote() {
        return cantidadLote;
    }

    public void setCantidadLote(int cantidadLote) {
        this.cantidadLote = cantidadLote;
    }
    
    
    
    
}
