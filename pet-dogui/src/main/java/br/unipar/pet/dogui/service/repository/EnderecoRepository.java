/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.pet.dogui.service.repository;

import br.unipar.pet.dogui.model.Endereco;
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
public class EnderecoRepository {
    
    private static final String INSERT
            = "INSERT INTO endereco (nome_rua, complemento, ds_bairro, nr_casa, nr_cep, st_ativo) VALUES(?, ?, ?, ?, ?, ?);";
    private static final String UPDATE
            = "UPDATE endereco SET nome_rua= ?, complemento= ?, ds_bairro= ?, nr_casa= ?, nr_cep= ?, st_ativo= ?;";
    private static final String DELETE
            = "UPDATE endereco SET status= false WHERE id= ? ;";
    private static final String FIND_BY_ID
            = "SELECT id, nome_rua, complemento, ds_bairro, nr_casa, nr_cep, st_ativo FROM endereco where id = ?;";
    private static final String FIND_ALL
            = "SELECT id, nome_rua, complemento, ds_bairro, nr_casa, nr_cep, st_ativo FROM endereco";
    
    public Endereco insert(Endereco endereco) throws SQLException {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            conn = new ConnectionFactory().getConnection();
            
            ps = conn.prepareStatement(INSERT,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, endereco.getNomeRua());
            ps.setString(2, endereco.getComplemento());
            ps.setString(3, endereco.getDsBairro());
            ps.setInt(4, endereco.getNrCasa());
            ps.setString(5, endereco.getNrCep());
            ps.setBoolean(6, endereco.isStAtivo());
            
            rs = ps.getGeneratedKeys();
            
            rs.next();
            endereco.setId(rs.getInt(1));
            
        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return endereco;
        
    }
    
    public ArrayList<Endereco> findAll() throws SQLException {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Endereco> listaResultado = new ArrayList<>();
        
        try {
            
            conn = new ConnectionFactory().getConnection();
            
            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Endereco endereco = new Endereco();
                endereco.setNomeRua("nome_rua");
                endereco.setComplemento("complemento");
                endereco.setDsBairro("ds_bairro");
                endereco.setNrCasa("nr_casa");
                endereco.setNrCep("nr_cep");
                endereco.isStAtivo();
                
                listaResultado.add(endereco);
                
            }
            
        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
        
        return listaResultado;
        
    }
    
    public ArrayList<Endereco> findWithParameters(String descricao) throws SQLException {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Endereco> listaResultado = new ArrayList<>();
        
        try {
            
            conn = new ConnectionFactory().getConnection();
            
            ps = conn.prepareStatement(FIND_ALL + " where ds_bairro like '%"+descricao+"%'");
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Endereco endereco = new Endereco();
                endereco.setNomeRua("nome_rua");
                endereco.setComplemento("complemento");
                endereco.setDsBairro("ds_bairro");
                endereco.setNrCasa("nr_casa");
                endereco.setNrCep("nr_cep");
                endereco.isStAtivo();
                
                listaResultado.add(endereco);
                
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
    
    public void delete (int id) throws SQLException {
        
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
    
    public Endereco update (Endereco endereco) throws SQLException {
        
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            
            conn = new ConnectionFactory().getConnection();
            
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, endereco.getNomeRua());
            ps.setString(2, endereco.getComplemento());
            ps.setString(3, endereco.getDsBairro());
            ps.setInt(4, endereco.getNrCasa());
            ps.setString(5, endereco.getNrCep());
            ps.setBoolean(6, endereco.isStAtivo());
            ps.execute();
            
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return endereco;
        
    }
    
    public Endereco findById(int id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Endereco resultado = new Endereco();
        
        try {
            
            conn = new ConnectionFactory().getConnection();
            
            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                resultado.setNomeRua(rs.getString("nome_rua"));
                resultado.setComplemento("complemento");
                resultado.setDsBairro("ds_bairro");
                resultado.setNrCasa("nr_casa");
                resultado.setNrCep("nr_cep");
                
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
