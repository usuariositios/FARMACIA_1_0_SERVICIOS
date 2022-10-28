/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

//import com.sun.org.apache.bcel.internal.generic.AALOAD;

/**
 *
 * @author Computer
 */
public class PresentacionesProducto {
    int codPresentacionProducto = 0;    
    String nombrePresentacionProducto = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodPresentacionProducto() {
        return codPresentacionProducto;
    }

    public void setCodPresentacionProducto(int codPresentacionProducto) {
        this.codPresentacionProducto = codPresentacionProducto;
    }

    public String getNombrePresentacionProducto() {
        return nombrePresentacionProducto;
    }

    public void setNombrePresentacionProducto(String nombrePresentacionProducto) {
        this.nombrePresentacionProducto = nombrePresentacionProducto;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
            
    
    
    
    
    
    
            
    
}
