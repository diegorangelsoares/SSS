/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.model;

/**
 *
 * @author DIEGO
 */
public class Mensagem {
    
    public int id;
    public String protocolo;
    public String data;
    public String recurso;
    public String mensagem;

    public Mensagem(int id, String protocolo, String data, String recurso, String mensagem) {
        this.id = id;
        this.protocolo = protocolo;
        this.data = data;
        this.recurso = recurso;
        this.mensagem = mensagem;
    }

    public Mensagem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    /**
    select mens.protocolo,
       mens.data,
       mens.recurso,
       mens.mensagem 
       from info_atend_255.tmp_siscon prot, info_atend_255.tmp_siscon_mensagens mens
       where prot.protocolo = mens.protocolo
       and prot.protocolo = 1641153;
       */ 
    
}
