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

public class Alerta {
    
    public int id;
    public String de;
    public String para;
    public String titulo;
    public String texto;
    public String data;
    public String hora;
    public String status;
    public String confirmada;
    public String id_alerta_origem;
    public String statusEnviada;
    public String Integrado;
    public String DataIntegracao;

    public Alerta(int id, String de, String para, String titulo, String texto, String data, String hora, String status, String confirmada, String id_alerta_origem,String statusEnviada,String Integrado,String DataIntegracao) {
        this.id = id;
        this.de = de;
        this.para = para;
        this.titulo = titulo;
        this.texto = texto;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.confirmada = confirmada;
        this.id_alerta_origem = id_alerta_origem;
        this.statusEnviada = statusEnviada;
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

    public String getDe() {
        return de;
    }

    public String getPara() {
        return para;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getStatus() {
        return status;
    }

    public String getConfirmada() {
        return confirmada;
    }

    public String getId_alerta_origem() {
        return id_alerta_origem;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setConfirmada(String confirmada) {
        this.confirmada = confirmada;
    }

    public void setId_alerta_origem(String id_alerta_origem) {
        this.id_alerta_origem = id_alerta_origem;
    }

    public String getStatusEnviada() {
        return statusEnviada;
    }

    public void setStatusEnviada(String statusEnviada) {
        this.statusEnviada = statusEnviada;
    }
    
    
    
}
