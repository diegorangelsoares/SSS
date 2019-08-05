package br.com.sss.Control;

import java.io.File; 
import java.io.IOException; 
import jxl.Cell; 
import jxl.Sheet; 
import jxl.Workbook; 
import jxl.read.biff.BiffException;


/**
 *
 * @author Diego Rangel  
 */

public class LerExcel {
    
    
//    public void lerPlanilhaEjogarNaTabela(String caminhoPlanilha, JanelaIntegracaoWeb j)      throws BiffException, IOException      {
//        
//        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)j.tabelaProdutos.getModel();
//        
//        /**         
//         * Carrega a planilha         
//        */         
//        Workbook workbook = Workbook.getWorkbook(new File(caminhoPlanilha));         
//        /**         * Aqui feito o controle de qual aba do xls          
//         * sera realiza a leitura dos dados         
//         */         
//        Sheet sheet = workbook.getSheet(0);         
//        
//        /**         
//         * Numero de linhas com dados do xls         
//         */
//        
//        int linhas = sheet.getRows();
//        int linha = 0;
//        while (linha < linhas)
//        {             
//            Cell celula1 = sheet.getCell(0, linha);             
//            Cell celula2 = sheet.getCell(1, linha);             
//            Cell celula3 = sheet.getCell(10, linha);   
//            
//            dtm.addRow(new Object[]{celula1.getContents(),celula2.getContents(),celula3.getContents()});
//            //System.out.println("Conteudo da celula 1: " +celula1.getContents());             
//            //System.out.println("Conteudo da celula 2: " +celula2.getContents());             
//            //System.out.println("Conteudo da celula 3: " +celula3.getContents()+"\n");   
//            linha++;
//        }     
//    }

}
