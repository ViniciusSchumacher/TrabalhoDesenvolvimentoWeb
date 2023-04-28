/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.pet.dogui.service;

import br.unipar.pet.dogui.model.Endereco;
import br.unipar.pet.dogui.service.repository.EnderecoRepository;
import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class EnderecoService {
    
    private EnderecoRepository repository = new EnderecoRepository();
    
    public Endereco insert (Endereco endereco) throws Exception {
        
        validaEndereco(endereco);
        
        return repository.insert(endereco);
        
    }
    
    //validação somente do nome da rua
    
    private void validaEndereco(Endereco endereco) throws Exception {
        
        if (endereco.getNomeRua() == null && endereco.getNomeRua().isEmpty()){
            throw new Exception("Nome da rua não informado");
        }
        
    }
    
    public Endereco update (Endereco endereco) throws Exception {
        
        validaEndereco(endereco);
        
        return repository.update(endereco);
        
    }
    
    public void delete(int id) throws Exception {
    
        repository.delete(id);
    
    }
    
    public Endereco findById(int id)  throws Exception {
    
        return repository.findById(id);
        
    }
    
    public ArrayList<Endereco> findByAll()  throws Exception {
    
        return repository.findAll();
        
    }
    
    public ArrayList<Endereco> findWithParameteres(String descricao)  throws Exception {
    
        return repository.findWithParameters(descricao);
        
    }
    
}
