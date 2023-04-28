/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.pet.dogui.service;

import br.unipar.pet.dogui.model.Pet;
import br.unipar.pet.dogui.service.repository.PetRepository;
import java.util.ArrayList;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vinicius
 */
public class PetService {
    
    private PetRepository repository = new PetRepository();
    
    public Pet insert(Pet pet) throws Exception {
        
        validaPet(pet);
        
        return repository.insert(pet);
        
    }
    
    //validação somente do nome
    
    private void validaPet(Pet pet) throws Exception {
        
        if(pet.getNome() == null &&
           pet.getNome().isEmpty()) {
            throw new Exception("Nome do pet não informado");
        }
        
    }
    
    public Pet update(Pet pet) throws Exception {
        
        validaPet(pet);
        
        return repository.update(pet);
        
    }
    
    public void delete (int id) throws Exception {
        
        repository.delete(id);
        
    }
    
    public Pet findById(int id) throws Exception {
        
        return repository.findById(id);
        
    }
    
    public ArrayList<Pet> findByAll() throws Exception {
        
        return repository.findAll();
        
    }
    
    public ArrayList<Pet> findWithParameters(String descricao) throws Exception {
        
        return repository.findWithParameters(descricao);
    }
    
    
}
