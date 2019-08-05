/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

import br.com.model.Protocolo;
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
        
        List<Protocolo> protocolos = null;
        protocolos = protocoloController.buscaProtocolosSimples(j.campoNomeProduto1.getText());
        if (protocolos == null){
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum protocolo com estas informações!");
        }else{
            for (int i = 0; i < protocolos.size(); i++) {
                javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)j.tabelaProcotolos.getModel();
                dtm.addRow(new Object[]{protocolos.get(i).getProtocolo(), protocolos.get(i).getCliente(), protocolos.get(i).getResumo()}); 
            }
             
        }
        
    }
    
}
