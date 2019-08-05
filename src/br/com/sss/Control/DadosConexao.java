/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

/**
 *
 * @author Diego Rangel  
 */
public class DadosConexao {

    public String Driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost:3309/receitas"; 
    public String usuario = "root";
    public String senha = "123456";

    public String getDriver() {
        return Driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setDriver(String Driver) {
        this.Driver = Driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
