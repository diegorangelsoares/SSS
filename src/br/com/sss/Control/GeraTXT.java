package br.com.sss.Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Rangel  
 */

public class GeraTXT {

    GeraData dataAtual = new GeraData();
    GeraHora horaAtual = new GeraHora();    

    public String GeraTxtDeErro(String erro){
            criaPastaDentroDoDsistema("Erros");
            String nomeDoArquivo = "c:\\DSistema\\Erros\\RegistroDeErro"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualSemPontos()+".txt";
            BufferedWriter buffWrite = null; 
            String linha = ""; 
            try {
                buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));
                buffWrite.append(erro);
                buffWrite.close();
                return nomeDoArquivo;
            } catch (IOException ex) {
                //Logger.getLogger(JanelaInstalar.class.getName()).log(Level.SEVERE, null, ex);
                return "";
            }         
    } 
    
    public void criaPastaRelatorios (String novoDiretorio){  
        String nomeDiretorio = null;   
        String separador = java.io.File.separator;   
        try {       
             nomeDiretorio = "C:" + separador + novoDiretorio;   
             if (!new File(nomeDiretorio).exists()) { // Verifica se o diretório existe.   
                 (new File(nomeDiretorio)).mkdir();   // Cria o diretório   
             }   
        } catch (Exception ex) {   
             JOptionPane.showMessageDialog(null,"Err","Erro ao criar o diretório" + ex.toString(),JOptionPane.ERROR_MESSAGE);   
        }  
    } 
    
    public void criaPastaDentroDoDsistema (String novoDiretorio){  
        String nomeDiretorio = null;   
        String separador = java.io.File.separator;   
        try {       
             nomeDiretorio = "C:" + separador + "DSistema"+separador+novoDiretorio;   
             if (!new File(nomeDiretorio).exists()) { // Verifica se o diretório existe.   
                 (new File(nomeDiretorio)).mkdir();   // Cria o diretório   
             }   
        } catch (Exception ex) {   
             JOptionPane.showMessageDialog(null,"Err","Erro ao criar o diretório" + ex.toString(),JOptionPane.ERROR_MESSAGE);   
        }  
    } 

 
}
