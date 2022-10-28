/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

import java.util.List;
import servicio.model.SelectItem;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import servicio.model.Empresas;
import servicio.resource.EmpresasResource;
import servicio.util.Utiles;

/**
 *
 * @author Computer
 * reflejar los metodos del EmpresasResource
 */

@Path("/empresas")
public class EmpresaService {
    @Path("/empresas")
    @GET @Produces("application/json")
    public Empresas empresas() {
        return (new Empresas());
    }
    @Path("/cargarEmpresasItem")
    @GET @Produces("application/json")
    public List<SelectItem> cargarEmpresasItem() {
        EmpresasResource er = new EmpresasResource();
        return er.cargarEmpresaItem();
    }
    @POST
    @Path("/cargarEmpresas")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Empresas> cargarEmpresas(Empresas empresas) {
        EmpresasResource er = new EmpresasResource();
        return er.cargarEmpresas(empresas);
    }
    @POST
    @Path("/guardarEmpresas")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void guardarEmpresas(Empresas empresas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        EmpresasResource er = new EmpresasResource(utiles.getCon());
        er.guardarEmpresa(empresas);
        utiles.closeConnection();
    }
    @POST
    @Path("/editarEmpresas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void editarEmpresas(Empresas empresas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        EmpresasResource er = new EmpresasResource(utiles.getCon());
        er.editarEmpresa(empresas);
        utiles.closeConnection();
    }
    @POST
    @Path("/eliminarEmpresas")    
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void eliminarEmpresas(Empresas empresas) throws Exception {
        Utiles utiles = new Utiles();
        utiles.getConnection();
        EmpresasResource er = new EmpresasResource(utiles.getCon());
        er.eliminarEmpresa(empresas);
        utiles.closeConnection();
    }
    
}
