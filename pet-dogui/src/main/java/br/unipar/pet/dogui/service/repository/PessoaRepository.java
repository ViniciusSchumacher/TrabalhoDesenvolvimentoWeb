/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.pet.dogui.service.repository;

import br.unipar.pet.dogui.model.Pessoa;
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
public class PessoaRepository {
    
    private static final String INSERT
            = "INSERT INTO pessoa (nome, listaEnderecos, nrTelefone, email) VALUES(?, ?, ?, ?);";
    private static final String UPDATE
            = "UPDATE pessoa SET nome= ?, listaEnderecos=?, nrTelefone= ?, email = ? " +
              "WHERE id= ? ;";
    private static final String DELETE
            = "UPDATE pessoa SET status= false WHERE id= ? ;";
    private static final String FIND_BY_ID
            = "SELECT id, nome, listaEnderecos, nrTelefone, email FROM pessoa where id = ?;";
    private static final String FIND_ALL
            = "SELECT id, nome, listaEnderecos, nrTelefone, email FROM pessoa";
    
    
    public Pessoa insert(Pessoa pessoa) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
                
        try {
            
            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(INSERT, 
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getListaEnderecos().toString());
            ps.setString(3, pessoa.getNrTelefone());
            ps.setString(4, pessoa.getEmail());
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            
            rs.next();
            pessoa.setId(rs.getInt(1));

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

        return pessoa;
        
    }
    
    public ArrayList<Pessoa> findAll() throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pessoa> listaResultado = new ArrayList<>();
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(rs.getString("nome"));
                pessoa.setListaEnderecos(rs.getString("listaEnderecos"));
                pessoa.setNrTelefone(rs.getString("nrTelefone"));
                pessoa.setEmail(rs.getString("email"));
                
                listaResultado.add(pessoa);
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
    
    public ArrayList<Pessoa> findWithParameters(String descricao) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pessoa> listaResultado = new ArrayList<>();
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_ALL + 
                    " where nome like '%"+descricao+"%'");
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(rs.getString("nome"));
                pessoa.setListaEnderecos(rs.getString("listaEnderecos"));
                pessoa.setNrTelefone(rs.getString("nrTelefone"));
                pessoa.setEmail(rs.getString("email"));
                
                listaResultado.add(pessoa);
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
    
    public Pessoa update(Pessoa pessoa) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getListaEnderecos().toString());
            ps.setString(3, pessoa.getNrTelefone());
            ps.setString(4, pessoa.getEmail());
            ps.executeUpdate();

        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }

        return pessoa;
        
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
    
    public Pessoa findById(int id) throws SQLException {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa = new Pessoa();
                
        try {

            conn = new ConnectionFactory().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                pessoa.setNome(rs.getString("nome"));
                pessoa.setListaEnderecos(rs.getString("listaEnderecos"));
                pessoa.setNrTelefone(rs.getString("nrTelefone"));
                pessoa.setEmail(rs.getString("email"));
                
                
            }

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        
        return pessoa;

    }
    
    
}
