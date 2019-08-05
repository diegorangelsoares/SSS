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
public class Agendamento {
    
    public int id;
    public String nomeCliente;
    public String telefone;
    public String segmento;
    public String motivo;
    public String funcionario;
    public String observacao;
    public String status;
    public String dataMarcada;
    public String dataMarcadaSemBarras;
    public String horaMarcada;
    public String Integrado;
    public String DataIntegracao;

    public Agendamento(int id, String nomeCliente, String telefone, String segmento, String motivo, String funcionario, String observacao, String status, String dataMarcada, String dataMarcadaSemBarras, String horaMarcada,String Integrado,String DataIntegracao) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.segmento = segmento;
        this.motivo = motivo;
        this.funcionario = funcionario;
        this.observacao = observacao;
        this.status = status;
        this.dataMarcada = dataMarcada;
        this.dataMarcadaSemBarras = dataMarcadaSemBarras;
        this.horaMarcada = horaMarcada;
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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getSegmento() {
        return segmento;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getStatus() {
        return status;
    }

    public String getDataMarcada() {
        return dataMarcada;
    }

    public String getDataMarcadaSemBarras() {
        return dataMarcadaSemBarras;
    }

    public String getHoraMarcada() {
        return horaMarcada;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataMarcada(String dataMarcada) {
        this.dataMarcada = dataMarcada;
    }

    public void setDataMarcadaSemBarras(String dataMarcadaSemBarras) {
        this.dataMarcadaSemBarras = dataMarcadaSemBarras;
    }

    public void setHoraMarcada(String horaMarcada) {
        this.horaMarcada = horaMarcada;
    }
    
    
    
}
