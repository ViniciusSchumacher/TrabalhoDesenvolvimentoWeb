/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.pet.dogui.model;

import br.unipar.pet.dogui.model.enums.GeneroEnum;
import br.unipar.pet.dogui.model.enums.PorteEnum;

/**
 *
 * @author andersonbosing
 */
public class Pet {
    
    private int id;
    private String nome;
    private Pessoa dono;
    private GeneroEnum genero;
    private double peso;
    private PorteEnum porte;

    public Pet(int id, String nome, Pessoa dono, GeneroEnum genero, double peso, PorteEnum porte) {
        this.id = id;
        this.nome = nome;
        this.dono = dono;
        this.genero = genero;
        this.peso = peso;
        this.porte = porte;
    }

    public Pet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public PorteEnum getPorte() {
        return porte;
    }

    public void setPorte(PorteEnum porte) {
        this.porte = porte;
    }

    public void setDono(String dono) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setGenero(String genero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setPeso(String peso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setPorte(String porte) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}


