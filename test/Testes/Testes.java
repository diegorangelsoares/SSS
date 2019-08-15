package Testes;


import br.com.sss.Control.MensagemController;
import br.com.sss.Control.ProtocoloController;
import br.com.sss.Control.ProtocoloController;
import br.com.sss.model.Mensagem;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DIEGO
 */
public class Testes {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        MensagemController mensagemController = new MensagemController();
        List<Mensagem> mensagens = mensagemController.VerArquivoDeMensagensSiscon("C:\\Users\\DIEGO\\Desktop\\backup_mensagens.txt", ";");
        int contador = 0;
        for (int i = 0; i < mensagens.size(); i++) {
            //System.out.println("Registro:"+mensagens.get(i).getProtocolo() + "  Linha: "+ contador);
            contador++;
            //dtm.addRow(new Object[]{i,mensagens.get(i).getProtocolo(), mensagens.get(i).getData(), mensagens.get(i).getRecurso(),mensagens.get(i).getMensagem()});
        }
        System.out.println("Total: "+contador);
    
    }
}
