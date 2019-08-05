/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import sun.security.util.Password;

/**
 *
 * @author Diego Rangel  
 */
public class Usuario {
    
    public int id;
    public String nome;
    public String cargo;
    public String telefone;
    public String cpf;
    public String senha;
    public String dica;
    public String Integrado;
    public String DataIntegracao;    
    public String rg;
    public String celular;
    public String salario;
    public String email;
    public String StatusCadastro;

    public Usuario(int id, String nome, String cargo, String telefone, String cpf, String senha, String dica, String Integrado, String DataIntegracao, String rg, String celular, String salario, String email, String StatusCadastro) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
        this.cpf = cpf;
        this.senha = senha;
        this.dica = dica;
        this.Integrado = Integrado;
        this.DataIntegracao = DataIntegracao;
        this.rg = rg;
        this.celular = celular;
        this.salario = salario;
        this.email = email;
        this.StatusCadastro = StatusCadastro;
    }

    public String getStatusCadastro() {
        return StatusCadastro;
    }

    public void setStatusCadastro(String StatusCadastro) {
        this.StatusCadastro = StatusCadastro;
    }

    
    
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public String getIntegrado() {
        return Integrado;
    }

    public String getDataIntegracao() {
        return DataIntegracao;
    }

    public void setIntegrado(String Integrado) {
        this.Integrado = Integrado;
    }

    public void setDataIntegracao(String DataIntegracao) {
        this.DataIntegracao = DataIntegracao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }
    
    
    
}
