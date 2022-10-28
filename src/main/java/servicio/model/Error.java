/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.model;

/**
 *
 * @author COMPUTER
 */
public class Error {
    int codError = 0;
    String descrError = "";

    public int getCodError() {
        return codError;
    }

    public void setCodError(int codError) {
        this.codError = codError;
    }

    public String getDescrError() {
        return descrError;
    }

    public void setDescrError(String descrError) {
        this.descrError = descrError;
    }
    
    
    
}
