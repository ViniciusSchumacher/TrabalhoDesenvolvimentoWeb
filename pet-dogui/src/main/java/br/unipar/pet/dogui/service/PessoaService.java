/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.pet.dogui.service;

import br.unipar.pet.dogui.model.Pessoa;
import br.unipar.pet.dogui.service.repository.PessoaRepository;
import java.util.ArrayList;
import javax.ws.rs.core.Response;
/**
 *
 * @author Vinicius
 */
public class PessoaService {
    
    private PessoaRepository repository = new PessoaRepository();
    
    public Pessoa insert(Pessoa pessoa) throws Exception {
        
        validaPessoa(pessoa);
        
        return repository.insert(pessoa);
        
    }
    
    //Verificação somente do nome.
    
    private void validaPessoa(Pessoa pessoa) throws Exception {
        
        if(pessoa.getNome() == null &&
           pessoa.getNome().isEmpty()) {
            throw new Exception("Nome da pessoa não informado.");
        }
        
    }
    
    public Pessoa update(Pessoa pessoa) throws Exception {
        
        validaPessoa(pessoa);
        
        return repository.update(pessoa);
        
    }
    
    public void delete(int id) throws Exception {
        
        repository.delete(id);
        
    }
    
    public Pessoa findById(int id) throws Exception {
        
        return repository.findById(id);
        
    }
    
    public ArrayList<Pessoa> findByAll() throws Exception {
        
        return repository.findAll();
        
    }
    
    public ArrayList<Pessoa> findWithParameters(String descricao) throws Exception {
        
        return repository.findWithParameters(descricao);
    }
    
}
