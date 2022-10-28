/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class ActividadesTipoProducto extends bean{
    TiposProductoSemiterminado tiposProductoSemiterminado = new TiposProductoSemiterminado();
    ActividadesProduccion actividadesProduccion = new ActividadesProduccion();
    int orden=0;
    double horasHombre = 0.0;
    double horasMaquina = 0.0;
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public TiposProductoSemiterminado getTiposProductoSemiterminado() {
        return tiposProductoSemiterminado;
    }

    public void setTiposProductoSemiterminado(TiposProductoSemiterminado tiposProductoSemiterminado) {
        this.tiposProductoSemiterminado = tiposProductoSemiterminado;
    }

    public ActividadesProduccion getActividadesProduccion() {
        return actividadesProduccion;
    }

    public void setActividadesProduccion(ActividadesProduccion actividadesProduccion) {
        this.actividadesProduccion = actividadesProduccion;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public double getHorasHombre() {
        return horasHombre;
    }

    public void setHorasHombre(double horasHombre) {
        this.horasHombre = horasHombre;
    }

    public double getHorasMaquina() {
        return horasMaquina;
    }

    public void setHorasMaquina(double horasMaquina) {
        this.horasMaquina = horasMaquina;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
