/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

import br.com.sss.View.JanelaConsultaErros;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author DIEGO
 */
public class Negocio {
    
    GeraData geraData = new GeraData();
    GeraHora geraHora = new GeraHora();
    ArquivoConfiguracao arquivoConfiguracao = new ArquivoConfiguracao();
    MensagemErro mensagemErro = new MensagemErro();
    
    public int preencheSabadosDomingos(String Mes, String Ano, JTable tabela){
        int quantidadeDeDias = 0;
        List<String> datas = new ArrayList<>();
        String mes = "01";
        if (Mes.equals("JANEIRO")){
            mes = "01";
        }
        if (Mes.equals("FEVEREIRO")){
            mes = "02";
        }
        if (Mes.equals("MARÇO")){
            mes = "03";
        }
        if (Mes.equals("ABRIL")){
            mes = "04";
        }
        if (Mes.equals("MAIO")){
            mes = "05";
        }
        if (Mes.equals("JUNHO")){
            mes = "06";
        }
        if (Mes.equals("JULHO")){
            mes = "07";
        }
        if (Mes.equals("AGOSTO")){
            mes = "08";
        }
        if (Mes.equals("SETEMBRO")){
            mes = "09";
        }
        if (Mes.equals("OUTUBRO")){
            mes = "10";
        }
        if (Mes.equals("NOVEMBRO")){
            mes = "11";
        }
        if (Mes.equals("DEZEMBRO")){
            mes = "12";
        }
        int contador = 1;
        String dia = "01";
        while (contador < 32){
            String data = dia +"/"+ mes +"/"+  Ano;
            if (geraData.validaData(data) == true){
                System.out.println(data);
                
                if (geraData.retornaDiaDaSemana(data).equals("Sab")){
                    javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabela.getModel();
                    dtm.addRow(new Object[]{data,"Sábado"});  
                    quantidadeDeDias++;
                }
                if (geraData.retornaDiaDaSemana(data).equals("Dom")){
                    javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabela.getModel();
                    dtm.addRow(new Object[]{data,"Domingo"});  
                    quantidadeDeDias++;
                }
                
                
            }
            contador ++;
            if (contador < 10){
                dia = "0" + contador;
            }else{
                dia = contador+"";
            }
        }
        
        
        return quantidadeDeDias;
    }
    
    public void preencheMesSeguienteAoIniciarJanela(JanelaConsultaErros janela){
        String mes = geraData.RetornaMesAtual();
        String ano = geraData.RetornaAnoAtualYYYY();
        if (mes.equals("01")){
            janela.campoMes.setSelectedItem("FEVEREIRO");
            janela.campoAno.setSelectedItem(ano);
        }
        if (mes.equals("02")){
            janela.campoMes.setSelectedItem("MARÇO");
            janela.campoAno.setSelectedItem(ano);
        }
        if (mes.equals("03")){
            janela.campoMes.setSelectedItem("ABRIL");
            janela.campoAno.setSelectedItem(ano);
        }
        if (mes.equals("04")){
            janela.campoMes.setSelectedItem("MAIO");
            janela.campoAno.setSelectedItem(ano);
        }
        if (mes.equals("05")){
            janela.campoMes.setSelectedItem("JUNHO");
            janela.campoAno.setSelectedItem(ano);
        }
        if (mes.equals("06")){
            janela.campoMes.setSelectedItem("JULHO");
            janela.campoAno.setSelectedItem(ano);
        }
        if (mes.equals("07")){
            janela.campoMes.setSelectedItem("AGOSTO");
            janela.campoAno.setSelectedItem(ano);
        }
        if (mes.equals("08")){
            janela.campoMes.setSelectedItem("SETEMBRO");
            janela.campoAno.setSelectedItem(ano);
        }
        if (mes.equals("09")){
            janela.campoMes.setSelectedItem("OUTUBRO");
            janela.campoAno.setSelectedItem(ano);
        }
        if (mes.equals("10")){
            janela.campoMes.setSelectedItem("NOVEMBRO");
            janela.campoAno.setSelectedItem(ano);
        }
        if (mes.equals("11")){
            janela.campoMes.setSelectedItem("DEZEMBRO");
            janela.campoAno.setSelectedItem(ano);
        }
        if (mes.equals("12")){
            janela.campoMes.setSelectedItem("JANEIRO");
            int anoo = Integer.parseInt(ano);
            anoo++;
            ano = anoo+"";
            janela.campoAno.setSelectedItem(ano);
        }
        
        
    }
    
    
    public ArrayList<String> RetornaSorteioDosNomes (ArrayList<String> nomes) {
        //Embaralha a lista de números
        Collections.shuffle(nomes);

        //Os sorteados agora são os 6 primeiros
        for (int i = 0; i < 6; i++) {
            System.out.println(nomes.get(i));
        }
        return nomes;
    }
    
    public ArrayList<String> completaNomesComMesmaQuantidadesDeDias (int QuantidadesDeDias, ArrayList<String> nomesOriginal){
        ArrayList<String> nomesFinal = nomesOriginal;
        int tamanho = nomesOriginal.size();
        int contador = 0;
        while (QuantidadesDeDias > tamanho){
            nomesFinal.add(nomesOriginal.get(contador));
            tamanho++;
            contador++;
        }
        return nomesFinal;
        
    }
    
    public boolean RetornaSeJaExisteNome(String nome){
        ArrayList<String> nomes = arquivoConfiguracao.RetornaNomes();
        if (nomes.contains(nome))
        {
            JOptionPane.showMessageDialog(null, "Nome já cadastrado!");
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void SalvarSorteio(String mes, String ano, JTable tabela){
            
        String nomeDoArquivo = criaArquivoNomes(mes, ano);
        BufferedWriter buffWrite = null;
        
        int totalDeLinhas = tabela.getModel().getRowCount();
        if (totalDeLinhas < 1){
            //sem nada na grade
        }else{
            int linha = 0;
            try {
                buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));
            
                buffWrite.write("Sorteio"+mes+"-"+ano+"-"+geraData.RetornaDataAtualSemBarra()+geraHora.RetornaHoraAtualSemPontos());
                        buffWrite.newLine();
                    while (linha < totalDeLinhas ){ 
                        buffWrite.write((String) tabela.getValueAt(linha, 0) +" -> "+ (String) tabela.getValueAt(linha, 1)+" -> "+ (String) tabela.getValueAt(linha, 2));
                                buffWrite.newLine();
                        linha++;
                    }
                    buffWrite.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
                    //Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    public String criaArquivoNomes (String mes, String ano){            
            //renovar nova sequencia colocando o escolhido no inicio
            String nomeDoArquivo = "c:\\DSistema\\Sorteio"+mes+"-"+ano+"-"+geraData.RetornaDataAtualSemBarra()+geraHora.RetornaHoraAtualSemPontos()+".dr";
            BufferedWriter buffWrite = null; 
            try {                
                buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));                
                buffWrite.close();
            } catch (IOException ex) {
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O Windows não deixou criar o arquivo Nomes.dr!","Falta Informação","erro");
            }
            return nomeDoArquivo;
            
    }

    
    

    
    
    
}
