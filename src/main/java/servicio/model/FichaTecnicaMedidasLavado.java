/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author OSCAR VALDIVIA
 */
public class FichaTecnicaMedidasLavado extends bean{
    FichaTecnicaProducto fichaTecnicaProducto = new FichaTecnicaProducto();
    EspecificacionFichaTecnica especificacionFichaTecnica = new EspecificacionFichaTecnica();
    Medida medidaInferior = new Medida();
    Medida medidaSuperior = new Medida();
    double medida3 = 0.0;
    Medida codMedida3 = new Medida();
    double medida4 = 0.0;
    Medida codMedida4 = new Medida();
    double medida6 = 0.0;
    Medida codMedida6 = new Medida();
    double medida8 = 0.0;
    Medida codMedida8 = new Medida();
    double medida10 = 0.0;
    Medida codMedida10 = new Medida();
    double medida12 = 0.0;
    Medida codMedida12 = new Medida();
    double medida14 = 0.0;
    Medida codMedida14 = new Medida();
    double medidaS = 0.0;
    Medida codMedidaS = new Medida();
    double medidaM = 0.0;
    Medida codMedidaM = new Medida();
    double medidaL = 0.0;
    Medida codMedidaL = new Medida();
    double medidaXL = 0.0;
    Medida codMedidaXL = new Medida();
    double medidaXXL = 0.0;
    Medida codMedidaXXL = new Medida();
    TiposEspecificacion tiposEspecificacion = new TiposEspecificacion();

    public FichaTecnicaProducto getFichaTecnicaProducto() {
        return fichaTecnicaProducto;
    }

    public void setFichaTecnicaProducto(FichaTecnicaProducto fichaTecnicaProducto) {
        this.fichaTecnicaProducto = fichaTecnicaProducto;
    }

    public EspecificacionFichaTecnica getEspecificacionFichaTecnica() {
        return especificacionFichaTecnica;
    }

    public void setEspecificacionFichaTecnica(EspecificacionFichaTecnica especificacionFichaTecnica) {
        this.especificacionFichaTecnica = especificacionFichaTecnica;
    }

    public Medida getMedidaInferior() {
        return medidaInferior;
    }

    public void setMedidaInferior(Medida medidaInferior) {
        this.medidaInferior = medidaInferior;
    }

    public Medida getMedidaSuperior() {
        return medidaSuperior;
    }

    public void setMedidaSuperior(Medida medidaSuperior) {
        this.medidaSuperior = medidaSuperior;
    }

    public double getMedida3() {
        return medida3;
    }

    public void setMedida3(double medida3) {
        this.medida3 = medida3;
    }

    public Medida getCodMedida3() {
        return codMedida3;
    }

    public void setCodMedida3(Medida codMedida3) {
        this.codMedida3 = codMedida3;
    }

    public double getMedida4() {
        return medida4;
    }

    public void setMedida4(double medida4) {
        this.medida4 = medida4;
    }

    public Medida getCodMedida4() {
        return codMedida4;
    }

    public void setCodMedida4(Medida codMedida4) {
        this.codMedida4 = codMedida4;
    }

    public double getMedida6() {
        return medida6;
    }

    public void setMedida6(double medida6) {
        this.medida6 = medida6;
    }

    public Medida getCodMedida6() {
        return codMedida6;
    }

    public void setCodMedida6(Medida codMedida6) {
        this.codMedida6 = codMedida6;
    }

    

    public double getMedida8() {
        return medida8;
    }

    public void setMedida8(double medida8) {
        this.medida8 = medida8;
    }

    public Medida getCodMedida8() {
        return codMedida8;
    }

    public void setCodMedida8(Medida codMedida8) {
        this.codMedida8 = codMedida8;
    }

    public double getMedida10() {
        return medida10;
    }

    public void setMedida10(double medida10) {
        this.medida10 = medida10;
    }

    public Medida getCodMedida10() {
        return codMedida10;
    }

    public void setCodMedida10(Medida codMedida10) {
        this.codMedida10 = codMedida10;
    }

    public double getMedida12() {
        return medida12;
    }

    public void setMedida12(double medida12) {
        this.medida12 = medida12;
    }

    public Medida getCodMedida12() {
        return codMedida12;
    }

    public void setCodMedida12(Medida codMedida12) {
        this.codMedida12 = codMedida12;
    }

    public double getMedida14() {
        return medida14;
    }

    public void setMedida14(double medida14) {
        this.medida14 = medida14;
    }

    public Medida getCodMedida14() {
        return codMedida14;
    }

    public void setCodMedida14(Medida codMedida14) {
        this.codMedida14 = codMedida14;
    }

    public double getMedidaS() {
        return medidaS;
    }

    public void setMedidaS(double medidaS) {
        this.medidaS = medidaS;
    }

    public Medida getCodMedidaS() {
        return codMedidaS;
    }

    public void setCodMedidaS(Medida codMedidaS) {
        this.codMedidaS = codMedidaS;
    }

    public double getMedidaM() {
        return medidaM;
    }

    public void setMedidaM(double medidaM) {
        this.medidaM = medidaM;
    }

    public Medida getCodMedidaM() {
        return codMedidaM;
    }

    public void setCodMedidaM(Medida codMedidaM) {
        this.codMedidaM = codMedidaM;
    }

    public double getMedidaL() {
        return medidaL;
    }

    public void setMedidaL(double medidaL) {
        this.medidaL = medidaL;
    }

    public Medida getCodMedidaL() {
        return codMedidaL;
    }

    public void setCodMedidaL(Medida codMedidaL) {
        this.codMedidaL = codMedidaL;
    }

    public double getMedidaXL() {
        return medidaXL;
    }

    public void setMedidaXL(double medidaXL) {
        this.medidaXL = medidaXL;
    }

    public Medida getCodMedidaXL() {
        return codMedidaXL;
    }

    public void setCodMedidaXL(Medida codMedidaXL) {
        this.codMedidaXL = codMedidaXL;
    }

    public double getMedidaXXL() {
        return medidaXXL;
    }

    public void setMedidaXXL(double medidaXXL) {
        this.medidaXXL = medidaXXL;
    }

    public Medida getCodMedidaXXL() {
        return codMedidaXXL;
    }

    public void setCodMedidaXXL(Medida codMedidaXXL) {
        this.codMedidaXXL = codMedidaXXL;
    }

    public TiposEspecificacion getTiposEspecificacion() {
        return tiposEspecificacion;
    }

    public void setTiposEspecificacion(TiposEspecificacion tiposEspecificacion) {
        this.tiposEspecificacion = tiposEspecificacion;
    }
    
    
   
    
    
}
