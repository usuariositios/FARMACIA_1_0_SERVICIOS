/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class FormulaMaestraDetalle extends bean{
    FormulaMaestra formulaMaestra = new FormulaMaestra();
    Materiales materiales = new Materiales();
    Double cantidad = 0.0;
    UnidadesMedida unidadesMedida = new UnidadesMedida();
    TiposMaterialProduccion  tiposMaterialProduccion= new TiposMaterialProduccion();
    Double costoMaterial = 0.0;

    public FormulaMaestra getFormulaMaestra() {
        return formulaMaestra;
    }

    public void setFormulaMaestra(FormulaMaestra formulaMaestra) {
        this.formulaMaestra = formulaMaestra;
    }

    public Materiales getMateriales() {
        return materiales;
    }

    public void setMateriales(Materiales materiales) {
        this.materiales = materiales;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public UnidadesMedida getUnidadesMedida() {
        return unidadesMedida;
    }

    public void setUnidadesMedida(UnidadesMedida unidadesMedida) {
        this.unidadesMedida = unidadesMedida;
    }

    public TiposMaterialProduccion getTiposMaterialProduccion() {
        return tiposMaterialProduccion;
    }

    public void setTiposMaterialProduccion(TiposMaterialProduccion tiposMaterialProduccion) {
        this.tiposMaterialProduccion = tiposMaterialProduccion;
    }

    public Double getCostoMaterial() {
        return costoMaterial;
    }

    public void setCostoMaterial(Double costoMaterial) {
        this.costoMaterial = costoMaterial;
    }
    
    
    
    
    
    
    
    
    
}
