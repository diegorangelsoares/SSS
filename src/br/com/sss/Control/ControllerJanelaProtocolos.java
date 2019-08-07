/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

import br.com.sss.model.Protocolo;
import br.com.sss.View.JanelaPesquisaProtocolo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class ControllerJanelaProtocolos {
    
    ProtocoloController protocoloController = new ProtocoloController();
    
    public ControllerJanelaProtocolos(){
    }
    
    public void pesquisaProtocolos(JanelaPesquisaProtocolo j){
        String operadora = (String) j.campoOperadora.getSelectedItem();
        String atendente = (String) j.campoAtendente.getSelectedItem();
        if (operadora == null){
            operadora = "";
        }
        if (atendente == null){
            atendente = "";
        }
        List<Protocolo> protocolos = null;
        if (operadora.equals("") && atendente.equals("")){
            protocolos = protocoloController.buscaProtocolosSimples(j.campoDescricao.getText());
        }
        if (!operadora.equals("") && atendente.equals("")){
            protocolos = protocoloController.buscaProtocolosDinamico(j.campoDescricao.getText(), operadora, atendente);
        }
        if (operadora.equals("") && !atendente.equals("")){
            protocolos = protocoloController.buscaProtocolosDinamico(j.campoDescricao.getText(), operadora, atendente);
        }
        if (!operadora.equals("") && !atendente.equals("")){
            protocolos = protocoloController.buscaProtocolosDinamico(j.campoDescricao.getText(), operadora, atendente);
        }
        if (protocolos == null){
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum protocolo com estas informações!");
        }else{
            for (int i = 0; i < protocolos.size(); i++) {
                javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)j.tabelaProcotolos.getModel();
                dtm.addRow(new Object[]{protocolos.get(i).getProtocolo(), protocolos.get(i).getCliente(), protocolos.get(i).getResumo()}); 
            }
             
        }
        
    }
    
    public void alimentaAtendentes(JanelaPesquisaProtocolo j){
        List<String> atendentes = protocoloController.retornaAtendentesDosProtocolos();
        j.campoAtendente.addItem("");
        if (atendentes == null){
            //JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum protocolo com estas informações!");
        }else{
            for (int i = 0; i < atendentes.size(); i++) {
                j.campoAtendente.addItem(atendentes.get(i));
            }
        }       
    } 
    
    public void alimentaOperadoras(JanelaPesquisaProtocolo j){
        List<String> Operadoras = protocoloController.retornaOperadorasDosProtocolos();
        j.campoOperadora.addItem("");
        if (Operadoras == null){
            //JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum protocolo com estas informações!");
        }else{
            for (int i = 0; i < Operadoras.size(); i++) {
                j.campoOperadora.addItem(Operadoras.get(i));
            }
        }       
    } 
    
}
