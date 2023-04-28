/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.pet.dogui.service.repository;

import br.unipar.pet.dogui.model.Pet;
import br.unipar.pet.dogui.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class PetRepository {
    
    private static final String INSERT
            = "INSERT INTO pet (nome, dono, genero, peso, porte) VALUES(?, ?, ?, ?, ?);";
    private static final String UPDATE
            = "UPDATE pet SET nome= ?, dono= ?, genero= ?, peso= ?, porte= ?;";
    private static final String DELETE
            = "UPDATE pet SET status= false WHERE id= ?;";
    private static final String FIND_BY_ID
            = "SELECT id, nome, dono, genero, peso, porte FROM pet where id= ?;";
    private static final String FIND_ALL
            = "SELECT id, nome, dono, genero, peso, porte FROM pet";
    
    public Pet insert(Pet pet) throws SQLException {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            conn = new ConnectionFactory().getConnection();
            
            ps = conn.prepareStatement(INSERT,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pet.getNome());
            ps.setString(2, pet.getDono().getNome());
            ps.setString(3, pet.getGenero().name());
            ps.setDouble(4, pet.getPeso());
            ps.setString(5, pet.getPorte().name());
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            
            rs.next();
            pet.setId(rs.getInt(1));
            
        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return pet;
        
    }
    
    public ArrayList<Pet> findAll() throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pet> listaResultado = new ArrayList<>();
        
        try {
            
            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Pet pet = new Pet();
                pet.setNome("nome");
                pet.setDono("dono");
                pet.setGenero("genero");
                pet.setPeso("peso");
                pet.setPorte("porte");
                
                listaResultado.add(pet);
                
            }
            
        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return listaResultado;
    
}
    
    public ArrayList<Pet> findWithParameters(String descricao) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pet> listaResultado = new ArrayList<>();
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_ALL + 
                    " where ds_servico like '%"+descricao+"%'");
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Pet pet = new Pet();
                pet.setNome("nome");
                pet.setDono("dono");
                pet.setGenero("genero");
                pet.setPeso("peso");
                pet.setPorte("porte");
                
                listaResultado.add(pet);
            }

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return listaResultado;

    }
    
    public void delete(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.execute();

        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

    }
    
    public Pet update(Pet pet) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, pet.getNome());
            ps.setString(2, pet.getDono().getNome());
            ps.setString(3, pet.getGenero().name());
            ps.setDouble(4, pet.getPeso());
            ps.setString(5, pet.getPorte().name());
            ps.execute();

        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

        return pet;
        
    }
    
    public Pet findById(int id) throws SQLException {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pet resultado = new Pet();
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                resultado.setNome((rs.getString("nome")));
                resultado.setDono((rs.getString("dono")));
                resultado.setDono((rs.getString("genero")));
                resultado.setPeso((rs.getDouble("peso")));
                resultado.setPorte((rs.getString("porte")));
                
                
            }

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return resultado;

    }
    
    
}