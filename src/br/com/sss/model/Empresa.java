/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.model;

import java.util.logging.Logger;

/**
 *
 * @author Diego Rangel  
 */
public class Empresa {

        int id;
        String nome;
        String razao;
        String endereco;
        String numero;
        String bairro;
        String cidade;
        String estado;
        String cep;
        String cnpj;
        String insc_estadual;
        String telefone_fixo;
        String email;
        String data_nascimento;
        String telefone_movel;
        String perfil;
        String provedorEmail;
        String EmailDeEnvio;
        String SenhaEmail;
        String celular;
        public String Integrado;
        public String DataIntegracao;

    public Empresa(int id, String nome, String razao, String endereco, String numero, String bairro, String cidade, String estado, String cep, String cnpj, String insc_estadual, String telefone_fixo, String email, String data_nascimento, String telefone_movel,String perfil,String provedorEmail,String EmailDeEnvio,String SenhaEmail,String celular,String Integrado,String DataIntegracao) {
        this.id = id;
        this.nome = nome;
        this.razao = razao;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.cnpj = cnpj;
        this.insc_estadual = insc_estadual;
        this.telefone_fixo = telefone_fixo;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.telefone_movel = telefone_movel;
        this.perfil = perfil;
        this.provedorEmail=provedorEmail;
        this.EmailDeEnvio=EmailDeEnvio;
        this.SenhaEmail=SenhaEmail;
        this.celular = celular;
        this.Integrado = Integrado;
        this.DataIntegracao = DataIntegracao;
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

    public String getRazao() {
        return razao;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getInsc_estadual() {
        return insc_estadual;
    }

    public String getTelefone_fixo() {
        return telefone_fixo;
    }

    public String getEmail() {
        return email;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public String getTelefone_movel() {
        return telefone_movel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setInsc_estadual(String insc_estadual) {
        this.insc_estadual = insc_estadual;
    }

    public void setTelefone_fixo(String telefone_fixo) {
        this.telefone_fixo = telefone_fixo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public void setTelefone_movel(String telefone_movel) {
        this.telefone_movel = telefone_movel;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getProvedorEmail() {
        return provedorEmail;
    }

    public String getEmailDeEnvio() {
        return EmailDeEnvio;
    }

    public String getSenhaEmail() {
        return SenhaEmail;
    }

    public void setProvedorEmail(String provedorEmail) {
        this.provedorEmail = provedorEmail;
    }

    public void setEmailDeEnvio(String EmailDeEnvio) {
        this.EmailDeEnvio = EmailDeEnvio;
    }

    public void setSenhaEmail(String SenhaEmail) {
        this.SenhaEmail = SenhaEmail;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
     
    
        
}
