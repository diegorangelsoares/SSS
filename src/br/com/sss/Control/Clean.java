package br.com.sss.Control;

import br.com.sss.View.JanelaPesquisaProtocolo;
import br.com.sss.View.JanelaCadastraProduto;
import br.com.sss.View.JanelaGradeProdutos;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * 
 * @author Diego Rangel  
 * 
 */

public class Clean {
    
    GeraData dataAtual = new GeraData();
    
    public void apagaDadosDaTabela(JTable tabela){
        //Pega o total de linhas da tabela
            int totalDeLinhas = tabela.getModel().getRowCount(); 
            javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabela.getModel();
            //Verifica se o total de linhas é zero
            if (totalDeLinhas == 0) {
                //Não existe nenhum produto na OS
            }else
            //Existe tabela e tem que percorrer pra deletar as linhas
            {
                //Enquanto total de linhas for diferente de zero a função remove a linha
                while (0 != totalDeLinhas ){                   
                    dtm.removeRow(0);
                    totalDeLinhas = totalDeLinhas -1;
                }
            }
    }
    
    
    
}
