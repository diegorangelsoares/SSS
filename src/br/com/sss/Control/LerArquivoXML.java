/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

//import java.io.File;  
//import java.io.IOException;  
//import java.util.ArrayList;
//import java.util.Iterator;  
//import java.util.List;  
//import java.util.logging.Level;  
//import java.util.logging.Logger;  
//import javax.swing.JOptionPane;
//import org.jdom2.Attribute;
//import org.jdom2.Document;
//import org.jdom2.Element;
//import org.jdom2.JDOMException;
//import org.jdom2.input.SAXBuilder;
//
///**
// *
// * @author Diego Rangel
// */
public class LerArquivoXML {
//    
//    public int linha = 0;
//    public int quantidadeDeItens = 0;
//    
//    public int contadorDeLinhas = 0;
//    
//    public GeraData dataAtual = new GeraData();
//    
//    public ArrayList<Produto_NFE> Produtos = new ArrayList<Produto_NFE>();
//    
//    public NotaFiscalLancamento lerarq(String caminhoDoArquivoXML , JanelaEntradaDeNFe janela) {  
//        
//        NotaFiscalLancamento lancamento = new NotaFiscalLancamento(0,"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","");
//        //Aqui você informa o nome do arquivo XML.  
//        File f = new File(caminhoDoArquivoXML);    
//  
//        //Criamos uma classe SAXBuilder que vai processar o XML  
//        SAXBuilder sb = new SAXBuilder();  
//  
//        //Este documento agora possui toda a estrutura do arquivo.  
//        Document d;  
//        try {  
//            d = sb.build(f);  
//            //Recuperamos o elemento root  
//            Element nfe = d.getRootElement();  
//  
//            //Recuperamos os atributos filhos (Attributes)  
//            List atributes = nfe.getAttributes();  
//            Iterator i_atr = atributes.iterator();  
//  
//            //Iteramos com os atributos filhos  
//            while (i_atr.hasNext()) {  
//                Attribute atrib = (Attribute) i_atr.next();  
//                System.out.println("\nattribute de ("+nfe.getName()+"):"+ atrib.getName()+" - valor: "+atrib.getValue());  
//                //System.out.println("\nElemento pai - INICIO DO XML");  
//            }  
//            //Recuperamos os elementos filhos (children)  
//            List elements = nfe.getChildren();  
//            Iterator i = elements.iterator();  
//  
//            //Iteramos com os elementos filhos, e filhos do dos filhos  
//            while (i.hasNext()) {  
//                Element element = (Element) i.next();  
//                System.out.println("element:"+ element.getName());  
//                //System.out.println("\nElemento FILHO - INICIO DO XML"); 
//                trataElement(element, lancamento, janela);  
//            }  
//  
//        } catch (JDOMException ex) {  
//            JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo XML! erro: "+ex.getMessage());
//            Logger.getLogger(LerArquivoXML.class.getName()).log(Level.SEVERE, null, ex);  
//        } catch (IOException ex) {  
//            JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo XML! erro: "+ex.getMessage());
//            Logger.getLogger(LerArquivoXML.class.getName()).log(Level.SEVERE, null, ex);  
//        }  
//        //janela.campoTotalDeItens.setText(linha+"");
//        janela.abaPrincipal.setSelectedComponent(janela.jPanel2);
//        return lancamento;
//        
//    }  
//  
//    public void trataElement(Element element, NotaFiscalLancamento lancamento, JanelaEntradaDeNFe janela) {  
//  
//            //Recuperamos os atributos filhos (Attributes)  
//            List atributes = element.getAttributes();  
//            Iterator i_atr = atributes.iterator();  
//  
//            //Iteramos com os atributos filhos  
//            while (i_atr.hasNext()) {  
//                Attribute atrib = (Attribute) i_atr.next();  
//                System.out.println("\nattribute de ("+element.getName()+"):"+ atrib.getName()+" - valor: "+atrib.getValue());  
//                //grava a chave
//                if (atrib.getName().equals("Id")) {  
//                    lancamento.setChaveAcesso(atrib.getValue());
//                    janela.campoChaveXMLOrigem.setText(atrib.getValue());
//                }
//            }  
//            //Recuperamos os elementos filhos (children)  
//            List elements = element.getChildren();  
//            Iterator it = elements.iterator();  
//
//                //Iteramos com os elementos filhos, e filhos do dos filhos  
//            while (it.hasNext()) {  
//                
//                    Element el = (Element) it.next();  
//                    System.out.println("element("+element.getName()+"):"+ el.getName()+" - Valor: "+el.getText());  
//
//                    //
//                    
//                    //  aqui voce pode escolher qual(is) campo(s) quer manipular  
//                    if (el.getName().equals("natOp")) {  
//                        //  grava no objeto o (element.getAttributeValue("mod"));  
//                        lancamento.setModelo(el.getText());
//                        janela.campoCFOP1.addItem(el.getText());
//                        janela.campoCFOP1.setSelectedItem(el.getText());
//                    }  
//                    if (el.getName().equals("dEmi")) {  
//                        //  grava no objeto o (element.getAttributeValue("mod"));  
//                        lancamento.setModelo(el.getText());
//                        String dataNF = el.getText();
//                        String dataNFcombarra = dataAtual.TransformaDataComTracoEmComBarra(dataNF);
//                        janela.campoDataNFE1.setText(dataNFcombarra);
//                        
//                    }
//                    if (el.getName().equals("mod")) {  
//                        //  grava no objeto o (element.getAttributeValue("mod"));  
//                        lancamento.setModelo(el.getText());
//                        janela.campoModelo1.setText(el.getText());
//                    }  
//                    if (el.getName().equals("serie")) {  
//                        //  grava no objeto o (element.getAttributeValue("serie"));  
//                        lancamento.setSerie(el.getText());
//                        janela.campoSerie1.setText(el.getText());
//                    }
//                    if (el.getName().equals("nNF")) {  
//                        //  grava no objeto o (element.getAttributeValue("nNF"));  
//                        lancamento.setNumeroNF(el.getText());
//                        janela.CampoNumeroNF1.setText(el.getText());
//                    }
//                    if (element.getName().equals("ide") && el.getName().equals("dEmi")){
//                        //janela.campoDataNFE1.setText(el.getText());
//                        //lancamento.setNomeFornecedor(el.getText());
//                    }
//                    /**
//                    if (el.getName().equals("dEmi")) {  
//                        //  grava no objeto o (element.getAttributeValue("nNF"));  
//                        //lancamento.setNumeroNF(el.getText());
//                        //String dataNF = el.getText();
//                        //dataNF = dataAtual.TransformaDataComTracoEmComBarra(dataNF);
//                        //janela.campoDataNFE1.setText(el.getText());
//                    }
//                    */ 
//                    if (element.getName().equals("emit") && el.getName().equals("xNome")){
//                        janela.campoNomeFornecedor.setText(el.getText());
//                        lancamento.setNomeFornecedor(el.getText());
//                    }
//                
//                
//                    if (element.getName().equals("emit") && el.getName().equals("CNPJ")){
//                        janela.campoCNPJ.setText(el.getText());                        
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
//                    
//                    //trataElementProdutos(element, lancamento, janela);
//                    
//                    
//                    
//                    Produto_NFE produto = new Produto_NFE(0,"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","");
//                    //pega os dados de cada produto      
//                    
//                    
//                    if (element.getName().equals("prod") && el.getName().equals("cProd")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 1);
//                        produto.setCean(el.getText());
//                        //Produtos.add(produto);
//                    }
//                    
//                    if (element.getName().equals("prod") && el.getName().equals("cEAN")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 0);
//                        //produto.setcProd(el.getText());
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("xProd")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 2);
//                        //produto.setxProd(el.getText());
//                        //JOptionPane.showMessageDialog(null, "Produto: "+el.getText());
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("qCom")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 3);
//                        //produto.setqCom(el.getText());
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("vUnCom")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 4);
//                        //produto.setvUnCom(el.getText());
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("vProd")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 5);
//                        //produto.setvProd(el.getText());
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("NCM")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 7);
//                        //produto.setNcm(el.getText());
//                    }
//                    if (element.getName().equals("prod") && el.getName().equals("uTrib")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 6);
//                        //produto.setuTrib(el.getText());
//                    }
//                    if (element.getName().equals("ICMS00") && el.getName().equals("pICMS")){
//                        janela.tabelaProdutos.setValueAt(el.getText(), linha, 10);
//                        ////produto.setpicm
//                        //Produtos.add(produto);
//                        linha++;
//                    }
//                    
//                    
//                    
//                    
//                    //PReenche total da nfe
//                    if (element.getName().equals("ICMSTot") && el.getName().equals("vNF")){
//                        janela.campoTotalDaNFE.setText(el.getText());
//                        janela.campoTotalNFE.setText(el.getText());
//                        lancamento.setValorTotalDaNota(el.getText());
//                    }
//                    if (element.getName().equals("infAdic") && el.getName().equals("infAdFisco")){
//                        janela.campoDadosAdicionais.setText(el.getText());
//                        lancamento.setDadosAdicionais(el.getText());
//                    }
//                    if (element.getName().equals("infProt") && el.getName().equals("chNFe")){
//                        janela.campoChaveXMLOrigem.setText(el.getText());
//                        //lancamento.setChaveAcesso(el.getText());
//                    }
//                    
//                
//                trataElement(el,lancamento, janela);  
//            }  
//    }  
//    
//    public void percorreTodoXML(String caminhoDoArquivoXML) {  
//        
//        //Aqui você informa o nome do arquivo XML.  
//        File f = new File(caminhoDoArquivoXML);    
//  
//        //Criamos uma classe SAXBuilder que vai processar o XML  
//        SAXBuilder sb = new SAXBuilder();  
//  
//        //Este documento agora possui toda a estrutura do arquivo.  
//        Document d;  
//        try {  
//            d = sb.build(f);  
//            //Recuperamos o elemento root  
//            Element nfe = d.getRootElement();  
//  
//            //Recuperamos os atributos filhos (Attributes)  
//            List atributes = nfe.getAttributes();  
//            Iterator i_atr = atributes.iterator();  
//  
//            //Iteramos com os atributos filhos  
//            while (i_atr.hasNext()) {  
//                Attribute atrib = (Attribute) i_atr.next();  
//                //System.out.println("\nattribute de ("+nfe.getName()+"):"+ atrib.getName()+" - valor: "+atrib.getValue());  
//                //System.out.println("\nElemento pai - INICIO DO XML");  
//            }  
//            //Recuperamos os elementos filhos (children)  
//            List elements = nfe.getChildren();  
//            Iterator i = elements.iterator();  
//  
//            //Iteramos com os elementos filhos, e filhos do dos filhos  
//            while (i.hasNext()) {  
//                Element element = (Element) i.next();  
//                System.out.println("element:"+ element.getName());  
//                //System.out.println("\nElemento FILHO - INICIO DO XML"); 
//                contaLinhasDoElementoFilhoProduto(element);  
//            }  
//  
//        } catch (JDOMException ex) {  
//            Logger.getLogger(LerArquivoXML.class.getName()).log(Level.SEVERE, null, ex);  
//        } catch (IOException ex) {  
//            Logger.getLogger(LerArquivoXML.class.getName()).log(Level.SEVERE, null, ex);  
//        }  
//        
//    }  
//    
//    public void contaLinhasDoElementoFilhoProduto(Element element) {  
//  
//            //Recuperamos os atributos filhos (Attributes)  
//            List atributes = element.getAttributes();  
//            Iterator i_atr = atributes.iterator();  
//  
//            //Iteramos com os atributos filhos  
//            while (i_atr.hasNext()) {  
//                Attribute atrib = (Attribute) i_atr.next();  
//               
//            }  
//            //Recuperamos os elementos filhos (children)  
//            List elements = element.getChildren();  
//            Iterator it = elements.iterator();  
//
//                //Iteramos com os elementos filhos, e filhos do dos filhos  
//            while (it.hasNext()) {                  
//                    Element el = (Element) it.next();  
//                    //System.out.println("element("+element.getName()+"):"+ el.getName()+" - Valor: "+el.getText());  
//                    //pega os dados de cada produto                        
//                    
//                    if (element.getName().equals("prod") && el.getName().equals("cProd")){
//                        //janela.tabelaProdutos.setValueAt(el.getText(), linha, 1);
//                        contadorDeLinhas++;
//                    }
//                    
//                contaLinhasDoElementoFilhoProduto(el);  
//            }  
//    }  
    
    /**
    public static void main (String[] args) {  
        LerArquivoXML lexml = new LerArquivoXML();  
        NotaFiscalLancamento nf = lexml.lerarq("D:/XML/25131103524990000155550010001540931111029110.xml"); 
         JOptionPane.showMessageDialog(null, "A NF do xml é a : "+nf.getNumeroNF()+" com chave: "+nf.getChaveAcesso());
        
    } 
    */ 
    
}
