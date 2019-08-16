/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

import br.com.sss.View.JanelaMensagens;
import br.com.sss.model.Mensagem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DIEGO
 */
public class ControllerJanelaMensagens {
    
    MensagemController mensagemController = new MensagemController();
    
    public void preencheMensagensDoProtocolo(JanelaMensagens j, String protocolo){
        List <Mensagem> mensagens = new ArrayList<Mensagem>();
        mensagens = mensagemController.RetornaMensagensDoProtocolo(protocolo);
        if (mensagens == null){
            //JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum protocolo com estas informações!");
        }else{
            for (int i = 0; i < mensagens.size(); i++) {
                String men = mensagens.get(i).getMensagem();
                StringBuilder str = new StringBuilder();
                j.tabelaMensagens.setRowHeight(100); 
                str.append("<html>");
                str.append(men.replaceAll("\n","<br>"));
                str.append("</html>");
                javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)j.tabelaMensagens.getModel();
                dtm.addRow(new Object[]{mensagens.get(i).getData(), mensagemController.RetornaNomeAtendente(mensagens.get(i).getRecurso()), str.toString()}); 
            }
        }
    }
    
    
    //mensagemController.RetornaNomeAtendente(mensagens.get(i).getRecurso())
    
}
