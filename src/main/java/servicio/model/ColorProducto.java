/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class ColorProducto extends bean {
    int codColorProducto = 0;
    String nombreColorProducto = "";

    public int getCodColorProducto() {
        return codColorProducto;
    }

    public void setCodColorProducto(int codColorProducto) {
        this.codColorProducto = codColorProducto;
    }

    public String getNombreColorProducto() {
        return nombreColorProducto;
    }

    public void setNombreColorProducto(String nombreColorProducto) {
        this.nombreColorProducto = nombreColorProducto;
    }
    
    
    
}
