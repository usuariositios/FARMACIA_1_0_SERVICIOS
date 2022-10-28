/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author Computer
 */
public class Devoluciones {
    int codDevolucion = 0;
    int nroDevolucion = 0;
    int codFormularioDev = 0;
    AlmacenesVenta almacenesVenta = new AlmacenesVenta();
    SalidasVenta SalidasVenta = new SalidasVenta();
    Clientes clientes = new Clientes();
    FacturasEmitidas facturasEmitidas = new FacturasEmitidas();
    String fechaDevolucion = "";    
    Gestion gestion = new Gestion();
    EstadosDevolucion estadosDevolucion = new EstadosDevolucion();
    String obsDevolucion = "";
    EstadosRegistro estadosRegistro = new EstadosRegistro();

    public int getCodDevolucion() {
        return codDevolucion;
    }

    public void setCodDevolucion(int codDevolucion) {
        this.codDevolucion = codDevolucion;
    }

    public int getNroDevolucion() {
        return nroDevolucion;
    }

    public void setNroDevolucion(int nroDevolucion) {
        this.nroDevolucion = nroDevolucion;
    }

    public int getCodFormularioDev() {
        return codFormularioDev;
    }

    public void setCodFormularioDev(int codFormularioDev) {
        this.codFormularioDev = codFormularioDev;
    }

    public AlmacenesVenta getAlmacenesVenta() {
        return almacenesVenta;
    }

    public void setAlmacenesVenta(AlmacenesVenta almacenesVenta) {
        this.almacenesVenta = almacenesVenta;
    }

    public SalidasVenta getSalidasVenta() {
        return SalidasVenta;
    }

    public void setSalidasVenta(SalidasVenta SalidasVenta) {
        this.SalidasVenta = SalidasVenta;
    }

    

    public Gestion getGestion() {
        return gestion;
    }

    public void setGestion(Gestion gestion) {
        this.gestion = gestion;
    }

    public EstadosDevolucion getEstadosDevolucion() {
        return estadosDevolucion;
    }

    public void setEstadosDevolucion(EstadosDevolucion estadosDevolucion) {
        this.estadosDevolucion = estadosDevolucion;
    }

    public String getObsDevolucion() {
        return obsDevolucion;
    }

    public void setObsDevolucion(String obsDevolucion) {
        this.obsDevolucion = obsDevolucion;
    }

    public EstadosRegistro getEstadosRegistro() {
        return estadosRegistro;
    }

    public void setEstadosRegistro(EstadosRegistro estadosRegistro) {
        this.estadosRegistro = estadosRegistro;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public FacturasEmitidas getFacturasEmitidas() {
        return facturasEmitidas;
    }

    public void setFacturasEmitidas(FacturasEmitidas facturasEmitidas) {
        this.facturasEmitidas = facturasEmitidas;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
        
    
    
}
