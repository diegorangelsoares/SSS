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
public class Versao {
    
    public int id;
    public String versao;
    public String dataVersao;

    public Versao(int id, String versao, String dataVersao) {
        this.id = id;
        this.versao = versao;
        this.dataVersao = dataVersao;
    }

    public int getId() {
        return id;
    }

    public String getVersao() {
        return versao;
    }

    public String getDataVersao() {
        return dataVersao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public void setDataVersao(String dataVersao) {
        this.dataVersao = dataVersao;
    }
    
}
