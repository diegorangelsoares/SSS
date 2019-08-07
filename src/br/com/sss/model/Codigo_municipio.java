/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sss.model;

/**
 *
 * @author Diego Rangel  
 */
public class Codigo_municipio {
    
    public int id;
    public String cidade;
    public String estado ;
    public String codigo_municipio;

    public Codigo_municipio(int id, String cidade, String estado, String codigo_municipio) {
        this.id = id;
        this.cidade = cidade;
        this.estado = estado;
        this.codigo_municipio = codigo_municipio;
    }

    public int getId() {
        return id;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCodigo_municipio() {
        return codigo_municipio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCodigo_municipio(String codigo_municipio) {
        this.codigo_municipio = codigo_municipio;
    }
    
    
    
    
}
