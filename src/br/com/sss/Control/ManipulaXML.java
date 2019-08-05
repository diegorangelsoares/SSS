/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

import java.io.File;  
import java.io.IOException;  
import java.util.Iterator;  
import java.util.List;  
import java.util.logging.Level;  
import java.util.logging.Logger;  
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import java.util.ArrayList;

/**
 *
 * @author Diego Rangel  
 */
public class ManipulaXML {
    
    String resposta = "";
    int linha = 0;
    int quantidadeDeItens = 0;
    
    //public ArrayList<Produto> Produtos = new ArrayList<Produto>();
    
//    public void lerarq(String caminhoArquivo, JTextArea campoResposta, JanelaEntradaDeNFe janela) {
//            
//            //Aqui você informa o nome do arquivo XML.  
//            File f = new File(caminhoArquivo);    
//            //Criamos uma classe SAXBuilder que vai processar o XML  
//            SAXBuilder sb = new SAXBuilder();  
//            //Este documento agora possui toda a estrutura do arquivo.  
//            Document d;  
//            try {  
//                d = sb.build(f);  
//                //Recuperamos o elemento root  
//                Element nfe = d.getRootElement();  
//                //Recuperamos os atributos filhos (Attributes)  
//                List atributes = nfe.getAttributes();  
//                Iterator i_atr = atributes.iterator();  
//                //Iteramos com os atributos filhos  
//                while (i_atr.hasNext()) {  
//                    Attribute atrib = (Attribute) i_atr.next();  
//                    //System.out.println("\nattribute de ("+nfe.getName()+"):"+ atrib.getName()+" - valor: "+atrib.getValue());  
//                    resposta = resposta+"\nattribute de ("+nfe.getName()+"):"+ atrib.getName()+" - valor: "+atrib.getValue()+"\n";
//                }  
//                //Cria as tabelas 
//                //Recuperamos os elementos filhos (children)  
//                List elements1 = nfe.getChildren();  
//                Iterator i1 = elements1.iterator(); 
//                while (i1.hasNext()) {
//                    Element element = (Element) i1.next();  
//                    //System.out.println("element:"+ element.getName());  
//                    //resposta = resposta+"element:"+ element.getName()+"\n";
//                    //JOptionPane.showMessageDialog(null, "Nome do elemento: "+element.getName());
//                    //trataElement(element,janela);
//                    AdicionaAsLinhasDaTabela(element,janela);
//                }
//
//                //Recuperamos os elementos filhos (children)  
//                List elements = nfe.getChildren();  
//                Iterator i = elements.iterator();  
//                //Iteramos com os elementos filhos, e filhos do dos filhos  
//                while (i.hasNext()) {
//                    Element element = (Element) i.next();  
//                    //System.out.println("element:"+ element.getName());  
//                    resposta = resposta+"element:"+ element.getName()+"\n";
//                    //JOptionPane.showMessageDialog(null, "Nome do elemento: "+element.getName());
//                    trataElement(element,janela);
//                }  
//                campoResposta.setText(resposta);
//                janela.campoTotalDeItens.setText(linha+"");
//                
//            } catch (JDOMException ex) {  
//                Logger.getLogger(ManipulaXML.class.getName()).log(Level.SEVERE, null, ex);  
//            } catch (IOException ex) {  
//                Logger.getLogger(ManipulaXML.class.getName()).log(Level.SEVERE, null, ex);  
//            }  
//
//
//        }  

//        public void trataElement(Element element, JanelaEntradaDeNFe janela) {  
//                
//                javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)janela.tabelaProdutos.getModel(); 
//                //dtm.addRow(new Object[]{"","",""});
//                //Recuperamos os atributos filhos (Attributes)  
//                List atributes = element.getAttributes();  
//                Iterator i_atr = atributes.iterator();  
//
//                //Iteramos com os atributos filhos  
//                while (i_atr.hasNext()) {  
//                    Attribute atrib = (Attribute) i_atr.next();  
//                    
//                    //System.out.println("\nattribute de ("+element.getName()+"):"+ atrib.getName()+" - valor: "+atrib.getValue());  
//                    resposta = resposta+"\nattribute de ("+element.getName()+"):"+ atrib.getName()+" - valor: "+atrib.getValue()+"\n";
//                    
//                }  
//                //Recuperamos os elementos filhos (children)  
//                List elements = element.getChildren();  
//                Iterator it = elements.iterator();  
//                
//                //Iteramos com os elementos filhos, e filhos do dos filhos  
//                while (it.hasNext()) {  
//                    
//                    Element el = (Element) it.next(); 
//                    
//                    //System.out.println("element("+element.getName()+"):"+ el.getName()+" - Valor: "+el.getText()); 
//                    resposta = resposta+"element("+element.getName()+"):"+ el.getName()+" - Valor: "+el.getText()+"\n";
//                    
//                    if (element.getName().equals("emit") && el.getName().equals("CNPJ")){
//                        janela.campoCNPJ.setText(el.getText());
//                    }
//                    if (element.getName().equals("emit") && el.getName().equals("xNome")){
//                        janela.campoNomeFornecedor.setText(el.getText());
//                    }
//                    if (element.getName().equals("emit") && el.getName().equals("xFant")){
//                        janela.campoFantasia.setText(el.getText());
//                    }
//                    if (element.getName().equals("enderEmit") && el.getName().equals("xLgr")){
//                        janela.camporua.setText(el.getText());
//                    }
//                    if (element.getName().equals("enderEmit") && el.getName().equals("nro")){
//                        janela.campoNumero.setText(el.getText());
//                    }
//                    if (element.getName().equals("enderEmit") && el.getName().equals("xBairro")){
//                        janela.campoBairro.setText(el.getText());
//                    }
//                    if (element.getName().equals("enderEmit") && el.getName().equals("xMun")){
//                        janela.campoCidade.setText(el.getText());
//                    }
//                    if (element.getName().equals("enderEmit") && el.getName().equals("UF")){
//                        janela.campoUF.setText(el.getText());
//                    }
//                    if (element.getName().equals("enderEmit") && el.getName().equals("CEP")){
//                        janela.campoCEP.setText(el.getText());
//                    }
//                    if (element.getName().equals("enderEmit") && el.getName().equals("fone")){
//                        janela.campoTelefone.setText(el.getText());
//                    }
//                    if (element.getName().equals("emit") && el.getName().equals("IE")){
//                        janela.campoIE.setText(el.getText());
//                    }
//                    //dtm.addRow(new Object[]{"","",""});
//                    if (element.getName().equals("prod") && el.getName().equals("cProd")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 1);
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("cEAN")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 0);
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("xProd")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 2);
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("qCom")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 3);
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("vUnCom")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 4);
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("vProd")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 5);
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("NCM")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 7);
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("uTrib")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 6);
//                    }
//                    if (element.getName().equals("ICMS00") && el.getName().equals("pICMS")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 10);
//                        linha++;
//                    }
//                    
//                    
//                    
//                    //PReenche total da nfe
//                    if (element.getName().equals("ICMSTot") && el.getName().equals("vNF")){
//                        janela.campoTotalDaNFE.setText(el.getText());
//                    }
//                    if (element.getName().equals("infAdic") && el.getName().equals("infAdFisco")){
//                        janela.campoDadosAdicionais.setText(el.getText());
//                    }
//                    if (element.getName().equals("infProt") && el.getName().equals("chNFe")){
//                        janela.campoChaveXMLOrigem.setText(el.getText());
//                    }
//                    
//                    //  aqui voce pode escolher qual(is) campo(s) quer manipular  
//                    if (el.getName().equals("nNF")) {  
//                        //  grava_no_banco de dados(element.getAttributeValue("nNF"));  
//                        //System.out.println("encontrou nNF . . . com valor: "+el.getText());  
//                        resposta = resposta+"encontrou nNF . . . com valor: "+el.getText()+"\n";
//                    }  
//                    
//                    trataElement(el,janela);  
//                    
//                }  
//        }  
//        
//        public int AdicionaAsLinhasDaTabela(Element element, JanelaEntradaDeNFe janela) {  
//                
//                javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)janela.tabelaProdutos.getModel(); 
//                //Recuperamos os atributos filhos (Attributes)  
//                List atributes = element.getAttributes();  
//                Iterator i_atr = atributes.iterator();  
//
//                //Recuperamos os elementos filhos (children)  
//                List elements = element.getChildren();  
//                Iterator it = elements.iterator();  
//                //Iteramos com os elementos filhos, e filhos do dos filhos  
//                while (it.hasNext()) {  
//                    
//                    Element el = (Element) it.next(); 
//                    if (element.getName().equals("prod") && el.getName().equals("cProd")){
//                        //cod = el.getText();
//                        dtm.addRow(new Object[]{"","",""});
//                        quantidadeDeItens++;
//                    }
//                    AdicionaAsLinhasDaTabela(el,janela);  
//                }  
//                return quantidadeDeItens; 
//        }  
        

    
}
