/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author henry
 */
public class PlanCuentas extends bean {
    int codPlanCuenta = 0;
    String cuenta = "";
    String nombreCuenta = "";
    TiposCuenta tiposCuenta = new TiposCuenta();
    Moneda moneda = new Moneda();
    String descripcion = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodPlanCuenta() {
        return codPlanCuenta;
    }

    public void setCodPlanCuenta(int codPlanCuenta) {
        this.codPlanCuenta = codPlanCuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public TiposCuenta getTiposCuenta() {
        return tiposCuenta;
    }

    public void setTiposCuenta(TiposCuenta tiposCuenta) {
        this.tiposCuenta = tiposCuenta;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }
    
    
    
    
}
