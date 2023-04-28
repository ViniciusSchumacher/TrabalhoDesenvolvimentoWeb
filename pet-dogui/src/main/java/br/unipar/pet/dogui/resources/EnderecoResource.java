/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.pet.dogui.resources;

import br.unipar.pet.dogui.model.ErroValidacao;
import br.unipar.pet.dogui.model.Endereco;
import br.unipar.pet.dogui.service.EnderecoService;
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
 * @author vinic
 */
@Path("endereco")
public class EnderecoResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(Endereco endereco) {
        
        try {
            
            EnderecoService service = new EnderecoService();
            
            return Response.ok(service.insert(endereco)).build();
            
        } catch (Exception ex) {
            
            return Response.serverError().entity(
                new ErroValidacao(ex.getMessage())).build();
        }
        
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Endereco endereco){
        
        try {
            
            EnderecoService service = new EnderecoService();
            
            return Response.ok(service.update(endereco)).build();
            
        } catch (Exception ex) {
            
            return Response.serverError().entity(
                    new ErroValidacao(ex.getMessage())).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id){
        
        try {
            
            EnderecoService service = new EnderecoService();
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
    public Response findById(@PathParam("id") int id) {
        
        try {
            
            EnderecoService service = new EnderecoService();
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
            
            EnderecoService service = new EnderecoService();
            return Response.ok(service.findByAll()).build();
            
        } catch (Exception ex) {
            return Response.serverError().entity(
                new ErroValidacao(ex.getMessage())).build();
        }
        
    }
    
    @GET
    @Path("filter")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllWithParameters(@QueryParam("descricao") String descricao){
        
        try{
            
            EnderecoService service = new EnderecoService();
            return Response.ok(service.findWithParameteres(descricao)).build();
            
            
        } catch (Exception ex) {
            return Response.serverError().entity(
                new ErroValidacao(ex.getMessage())).build();
        }
    }
    
    
}

