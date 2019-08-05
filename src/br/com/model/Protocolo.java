/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author DIEGO
 */
public class Protocolo {
    
    int id;
    String protocolo;
    String sistema;
    String recurso;
    String pessoa;
    String resumo;
    String versao ;
    String dataentrada;
    String sms;
    String classificacao;
    String situacao;
    String responsavel;
    String cliente;
    String sla;
    String useralteracao;
    String homologar;
    String ultimaalteracao;
    String prazoentrega;
    String atend;
    String atendente;
    String prazosla;

    public Protocolo() {
    }

    public Protocolo(int id,String protocolo, String sistema, String recurso, String pessoa, String resumo, String versao, String dataentrada, String sms, String classificacao, String situacao, String responsavel, String cliente, String sla, String useralteracao, String homologar, String ultimaalteracao, String prazoentrega, String atend, String atendente, String prazosla) {
        this.id = id;
        this.protocolo = protocolo;
        this.sistema = sistema;
        this.recurso = recurso;
        this.pessoa = pessoa;
        this.resumo = resumo;
        this.versao = versao;
        this.dataentrada = dataentrada;
        this.sms = sms;
        this.classificacao = classificacao;
        this.situacao = situacao;
        this.responsavel = responsavel;
        this.cliente = cliente;
        this.sla = sla;
        this.useralteracao = useralteracao;
        this.homologar = homologar;
        this.ultimaalteracao = ultimaalteracao;
        this.prazoentrega = prazoentrega;
        this.atend = atend;
        this.atendente = atendente;
        this.prazosla = prazosla;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(String dataentrada) {
        this.dataentrada = dataentrada;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getSla() {
        return sla;
    }

    public void setSla(String sla) {
        this.sla = sla;
    }

    public String getUseralteracao() {
        return useralteracao;
    }

    public void setUseralteracao(String useralteracao) {
        this.useralteracao = useralteracao;
    }

    public String getHomologar() {
        return homologar;
    }

    public void setHomologar(String homologar) {
        this.homologar = homologar;
    }

    public String getUltimaalteracao() {
        return ultimaalteracao;
    }

    public void setUltimaalteracao(String ultimaalteracao) {
        this.ultimaalteracao = ultimaalteracao;
    }

    public String getPrazoentrega() {
        return prazoentrega;
    }

    public void setPrazoentrega(String prazoentrega) {
        this.prazoentrega = prazoentrega;
    }

    public String getAtend() {
        return atend;
    }

    public void setAtend(String atend) {
        this.atend = atend;
    }

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public String getPrazosla() {
        return prazosla;
    }

    public void setPrazosla(String prazosla) {
        this.prazosla = prazosla;
    }
    
    
    
}
