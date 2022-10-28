/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.service;

/**
 *
 * @author COMPUTER
 */
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
  
@Path("/message")
public class JerseyService
{
    @GET
    public String getMsg()
    {
         return "Hello World !! - Jersey 2";
    }
}