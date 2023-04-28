/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.pet.dogui.resources;

import br.unipar.pet.dogui.model.ErroValidacao;
import br.unipar.pet.dogui.model.Pet;
import br.unipar.pet.dogui.service.PetService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author Vinicius
 */
@Path("pet")
public class PetResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert (Pet pet){
        
        try{
            
            PetService service = new PetService();
            
            return Response.ok(service.insert(pet)).build();
            
        } catch (Exception ex){
            
            return Response.serverError().entity(
                new ErroValidacao(ex.getMessage())).build();
            
        }
        
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Pet pet){
        
        try {
            
            PetService service = new PetService();
            
            return Response.ok(service.update(pet)).build();
            
        } catch (Exception ex) {
            
            return Response.serverError().entity(
                new ErroValidacao(ex.getMessage())).build();
            
        }
        
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        
        try {
            
            PetService service = new PetService();
            service.delete(id);
            
            return Response.ok().build();
            
        } catch (Exception ex) {
            return Response.serverError().entity(
                new ErroValidacao(ex.getMessage())).build();
        }
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response findbyId(@PathParam("id") int id){
        
        try {
            
            PetService service = new PetService();
            return Response.ok(service.findById(id)).build();
            
        } catch (Exception ex) {
            return Response.serverError().entity(
                new ErroValidacao(ex.getMessage())).build();
            
        }
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            
            PetService service = new PetService();
            return Response.ok(service.findByAll()).build();
            
        } catch (Exception ex) {
            return Response.serverError().entity(
                new ErroValidacao(ex.getMessage())).build();
        }
    }
    
    @GET
    @Path("filter")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllWithParameters(@QueryParam("descricao") String descricao) {
        
        try {
            
            PetService service = new PetService();
            return Response.ok(service.findWithParameters(descricao)).build();
            
        } catch (Exception ex) {
            return Response.serverError().entity(
                new ErroValidacao(ex.getMessage())).build();
        }
    }
    
}
