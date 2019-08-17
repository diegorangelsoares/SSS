package br.com.sss.Control;

import br.com.sss.Control.MensagemErro;
import br.com.sss.EMail.DrMail;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.dropbox.core.*;
import java.io.*;
import java.util.Locale;

/**
 *
 * @author Diego Rangel  
 */

public class AtualizarSistema {
    
        ControllerGeral co = new ControllerGeral();
        GeraData dataAtual = new GeraData();
        DrMail email = new DrMail();
        MensagemErro mensagemErro = new MensagemErro();
        
        String token = "joWcm9dS1RAAAAAAAAAEAgXd4Vn3gE04mbNTFrN8A7XpEoQdfxoqGPP7hCF4cVhT";
    
        public void criaPastaRelatorios (String novoDiretorio){  
            String nomeDiretorio = null;   
            String separador = java.io.File.separator;   
            try {       
                 nomeDiretorio = "C:" + separador + novoDiretorio;   
                 if (!new File(nomeDiretorio).exists()) { // Verifica se o diretório existe.   
                     (new File(nomeDiretorio)).mkdir();   // Cria o diretório   
                 }   
            } catch (Exception ex) {   
                 mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro ao criar o diretório de Atualizações - " + ex.toString(),"Falta Informação","erro");
            }  
        } 
    
	public void baixaVersao() {
                criaPastaRelatorios("AtualizacaoDSistema");
	        try{                        
                        //Fazendo conexão e criando Client Dropbox
                        DbxClient dbClient;
                        DbxRequestConfig config = new DbxRequestConfig("DSistema",Locale.getDefault().toString());
                        dbClient = new DbxClient(config, token);                        

                        //download do Jar na pasta do DropBox
                        String destino = "C:/AtualizacaoDSistema/DSistema.jar";
                        String dropBoxFile = "/DSistema.jar";
                        try{
                            File f = new File(dropBoxFile);
                            FileOutputStream outputStream = new FileOutputStream(destino);
                            DbxEntry.File downloadedFile = dbClient.getFile( dropBoxFile , null, outputStream );
                            outputStream.close();
                        } catch (Exception e) {
                            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro ao baixar Versão Atualizada! Erro: "+e.getMessage(),"Falta Informação","erro");
                            //System.out.print(e);
                        }
                        
                        copiaVersaoParaPastaDoSistema32bitsAtualizador();
                        //copiaVersaoParaPastaDoSistema64bitsAtualizador();
                        apagaPastaAtualizacaoDSistema();
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Versão atualizada com Sucesso!","Sucesso","ok");
		}
		catch (FileNotFoundException e){
                        //JOptionPane.showMessageDialog(null, "Arquivo não encontrado. Causa: " + e.getMessage());
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não existe versão atualizada! DSistema1","Falta Informação","erro");
		}
		catch (MalformedURLException e){
                        //JOptionPane.showMessageDialog(null, "Erro na formação da URL. Causa: " + e.getMessage());
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não existe versão atualizada! DSistema2","Falta Informação","erro");
		}
		catch (IOException e){
                        //JOptionPane.showMessageDialog(null, "Erro de entrada/saida de dados. Causa: " + e.getMessage());
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não existe versão atualizada! DSistema3","Falta Informação","erro");
		}	
	}
        
        public void baixarArquivoDaRaiz(String nomeDoArquivo) {

                        apagaArquivoDaPastaDSistema(nomeDoArquivo);
                        //Fazendo conexão e criando Client Dropbox
                        DbxClient dbClient;
                        DbxRequestConfig config = new DbxRequestConfig("DSistema",Locale.getDefault().toString());
                        dbClient = new DbxClient(config, token);                        

                        //download do arquivo na pasta do DropBox
                        String destino = "C:/DSistema/"+nomeDoArquivo;
                        String dropBoxFile = "/ARQUIVOS/"+nomeDoArquivo;
                        try{
                            File f = new File(dropBoxFile);
                            FileOutputStream outputStream = new FileOutputStream(destino);
                            DbxEntry.File downloadedFile = dbClient.getFile( dropBoxFile , null, outputStream );
                            outputStream.close();
                        } catch (Exception e) {
                            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Erro ao baixar arquivo no Dropbox! Erro: "+e.getMessage(),"Falta Informação","erro");
                            //System.out.print(e);
                        }
                        //JOptionPane.showMessageDialog(null, "Arquivo atualizado com Sucesso!");
			
	}
        
        public void baixaAmmyy() {                
	        try{                        
                        //Fazendo conexão e criando Client Dropbox
                        DbxClient dbClient;
                        DbxRequestConfig config = new DbxRequestConfig("DSistema",Locale.getDefault().toString());
                        dbClient = new DbxClient(config, token);                        

                        //download do Jar na pasta do DropBox
                        String destino = "C:/DSistema/Ammyy.exe";
                        String dropBoxFile = "/Ammyy.exe";
                        try{
                            File f = new File(dropBoxFile);
                            FileOutputStream outputStream = new FileOutputStream(destino);
                            DbxEntry.File downloadedFile = dbClient.getFile( dropBoxFile , null, outputStream );
                            outputStream.close();
                        } catch (Exception e) {
                            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Erro ao baixar Ammyy! Erro: "+e.getMessage(),"Falta Informação","erro");
                            //System.out.print(e);
                        }
                        
                        copiaVersaoParaPastaDoSistema32bitsAtualizador();
                        //copiaVersaoParaPastaDoSistema64bitsAtualizador();
                        apagaPastaAtualizacaoDSistema();
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Ammyy baixado com Sucesso!","Sucesso","ok");
                        try {   
                            Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start", "C:\\DSistema\\AMMYY.EXE"});
                       } catch (Exception ex) {   
                            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso(ex.toString(),"Falta Informação","erro"); 
                       }
		}
		catch (FileNotFoundException e){
                        //JOptionPane.showMessageDialog(null, "Arquivo não encontrado. Causa: " + e.getMessage());
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não existe versão atualizada! DSistema1","Falta Informação","erro");
		}
		catch (MalformedURLException e){
                        //JOptionPane.showMessageDialog(null, "Erro na formação da URL. Causa: " + e.getMessage());
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não existe versão atualizada! DSistema2","Falta Informação","erro");
		}
		catch (IOException e){
                        //JOptionPane.showMessageDialog(null, "Erro de entrada/saida de dados. Causa: " + e.getMessage());
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não existe versão atualizada! DSistema3","Falta Informação","erro");
		}	
	}
        
        public void deletaArquivoDoDropBox(){
            //Fazendo conexão e criando Client Dropbox
                        DbxClient dbClient;
                        DbxRequestConfig config = new DbxRequestConfig("DSistema",Locale.getDefault().toString());
                        dbClient = new DbxClient(config, token);                        

                        //download do Jar na pasta do DropBox
                        String dropBoxFile = "/VersaoImediata.ini";
                        try{
                            File f = new File(dropBoxFile);
                            dbClient.delete(dropBoxFile);
                        } catch (Exception e) {
                            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Erro deletar arquivo! Erro: "+e.getMessage(),"Falta Informação","erro");
                        } 
        }
        
        public void baixaArquivoNovaVersaoINIpublicado(){
                    //Fazendo conexão e criando Client Dropbox
                        DbxClient dbClient;
                        try{
                            DbxRequestConfig config = new DbxRequestConfig("DSistema",Locale.getDefault().toString());
                            dbClient = new DbxClient(config, token);                        

                            //download do Jar na pasta do DropBox
                            String destino = "C:/DSistema/VersaoNova.ini";
                            String dropBoxFile = "/NovaVersao.ini";
                        
                            File f = new File(dropBoxFile);
                            FileOutputStream outputStream = new FileOutputStream(destino);
                            DbxEntry.File downloadedFile = dbClient.getFile( dropBoxFile , null, outputStream );
                            outputStream.close();
                        } catch (Exception e) {
                            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Erro ao baixar aquivo de verificaçao de atualização! Erro: "+e.getMessage(),"Falta Informação","erro");
                            //System.out.print(e);
                        }
        }
        
        public void baixaArquivoVersaoImediataINIpublicado(){
                    //Fazendo conexão e criando Client Dropbox
                        DbxClient dbClient;
                        try{
                            DbxRequestConfig config = new DbxRequestConfig("DSistema",Locale.getDefault().toString());
                            dbClient = new DbxClient(config, token);                        

                            //download do Jar na pasta do DropBox
                            String destino = "C:/DSistema/VersaoImediata.ini";
                            String dropBoxFile = "/VersaoImediata.ini";
                        
                            File f = new File(dropBoxFile);
                            FileOutputStream outputStream = new FileOutputStream(destino);
                            DbxEntry.File downloadedFile = dbClient.getFile( dropBoxFile , null, outputStream );
                            outputStream.close();
                        } catch (Exception e) {
                            //JOptionPane.showMessageDialog(null, "Erro ao baixar aquivo de verificação de atualização! Erro: "+e.getMessage());
                            //System.out.print(e);
                        }
        }
        
        public boolean verificaSeTemArquivoVersaoImediataINI(){
            File arquivo = new File("C:/DSistema/VersaoImediata.ini"); // ajfilho é uma pasta!
            if (!arquivo.exists()) {
               //JOptionPane.showMessageDialog(null, "Diretório não existe!");
               return false;
            } else {
               //JOptionPane.showMessageDialog(null, "Diretório já existente!");
               return true;
            }
    }
        
        public boolean verificaSeTemArquivoNaPastaDDistema(String nomeArquivo){
            File arquivo = new File("C:/DSistema/"+nomeArquivo); // ajfilho é uma pasta!
            if (!arquivo.exists()) {
               //JOptionPane.showMessageDialog(null, "Diretório não existe!");
               return false;
            } else {
               //JOptionPane.showMessageDialog(null, "Diretório já existente!");
               return true;
            }
    }
        
    public boolean verificaSeTemAmmyyEXE(){
            File arquivo = new File("C:/DSistema/Ammyy.exe"); // ajfilho é uma pasta!
            if (!arquivo.exists()) {
               //JOptionPane.showMessageDialog(null, "Diretório não existe!");
               return false;
            } else {
               //JOptionPane.showMessageDialog(null, "Diretório já existente!");
               return true;
            }
    }
    
    public void deletaArquivoVersaoImediataINI(){
        File arquivo = new File("C:/DSistema/VersaoImediata.ini"); // ajfilho é uma pasta!
        arquivo.delete();    
    }    

    public void atualizaVersaoManual(){
        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Sistema vai baixar a versão mais atualizada!","Sucesso","ok");
        baixaVersao();
        //deletaArquivoVersaoImediataINI();
        //deletaArquivoDoDropBox();
        //co.deleteArquivoUsuarioLogado();
        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Sistema Atualizado com Sucesso!","Sucesso","ok");
        //System.exit(0);
    }
   
        public void verificaSeTemVersaoNova() {
                //criaPastaRelatorios("AtualizacaoDSistema");
//	        
//                        baixaArquivoNovaVersaoINIpublicado();
//                        
////                        String versaoSalvoNoBancoDeDados = co.retornaVersaoNoBAncoDeDados();
//                        String versaoSalvoNoArquivo = retornaVersaoDoArquivoNovaVersaoTXT();
//                        versaoSalvoNoBancoDeDados = versaoSalvoNoBancoDeDados.replace(".","");
//                        versaoSalvoNoArquivo = versaoSalvoNoArquivo.replace(".","");
//                        if (versaoSalvoNoArquivo.equals("")){
//                            versaoSalvoNoArquivo="0";
//                        }
//                        int versaoSalvoNoBancoDeDadosInteiro = Integer.parseInt(versaoSalvoNoBancoDeDados);
//                        int versaoSalvoNoArquivoInteiro = Integer.parseInt(versaoSalvoNoArquivo);
//                        if (versaoSalvoNoBancoDeDadosInteiro< versaoSalvoNoArquivoInteiro){                        
//                            int Confirm = JOptionPane.showConfirmDialog(null,"Existe uma nova versão disponivel do DSistema, deseja atualizar agora?","Sim ou Não", JOptionPane.YES_NO_OPTION);
//                            if (Confirm == 0){
//                                //JOptionPane.showMessageDialog(null, "Ativar FUNÇAO para baixar versao!");
//                                baixaVersao();
//                            }
//                        }else{
//                            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não existe nova versão disponível!","Sucesso","ok");
//                        }
		
			
	}
        
        public String retornaVersaoDoArquivoNovaVersaoTXT(){        
            try { 
                FileReader arq = new FileReader("c:\\DSistema\\VersaoNova.ini");
                BufferedReader lerArq = new BufferedReader(arq); 
                String linha = lerArq.readLine(); 
                arq.close(); 
                return linha;
            } catch (IOException e) { 
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Arquivo VersaoNova.txt não encontrado!","Falta Informação","erro");
                return "0";
            } 
    }
        
        public String retornaVersaoDoArquivoVersaoImediataINI(){        
            try { 
                FileReader arq = new FileReader("c:\\DSistema\\VersaoImediata.ini");
                BufferedReader lerArq = new BufferedReader(arq); 
                String linha = lerArq.readLine(); 
                arq.close(); 
                return linha;
            } catch (IOException e) { 
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Arquivo VersaoImediata.ini não encontrado!","Falta Informação","erro");
                return "0";
            } 
    }
        
        public void baixaAtualizador() {
                
                criaPastaRelatorios("AtualizacaoDSistema");
	        try{
                        File file = new File("C:\\AtualizacaoDSistema\\AtualizacaoDSistema.jar");
			//File file = new File("google.gif");
			OutputStream out = new FileOutputStream(file, false);
			URL url = new URL("ftp://diegorangel.ddns.net/UPDATE/DSistema.jar");
			URLConnection conn = url.openConnection();
			InputStream in = conn.getInputStream();
			int i=0;
			while ((i = in.read()) != -1){
				out.write(i);
			}
			in.close();
			out.close();
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Versão baixada com Sucesso!","Sucesso","ok");
                        //try {   
                        //    Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start", "C:\\AtualizacaoDSistema\\AtualizacaoDSistema.jar"});
                        //} catch (Exception ex) {   
                        //     //JOptionPane.showMessageDialog(null,"Erro",ex.toString(),JOptionPane.ERROR_MESSAGE);   
                        //}
		}
		catch (FileNotFoundException e){
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Arquivo não encontrado. Causa: " + e.getMessage(),"Falta Informação","erro");
		}
		catch (MalformedURLException e){
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Erro na formação da URL. Causa: " + e.getMessage(),"Falta Informação","erro");
		}
		catch (IOException e){
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Erro de entrada/saida de dados. Causa: " + e.getMessage(),"Falta Informação","erro");
		}
	}
        
        File arquivoOrigemAtualizador = new File ("C:\\AtualizacaoDSistema\\DSistema.jar");
        File pastaDestino32Atualizador = new File ("C:\\DSistema\\DSistema.jar");
        File pastaDestino64Atualizador = new File ("C:\\DSistema\\DSistema.jar");
        //COPIAR A VERSAO PARA A PASTA ONDE O SISTEMA ESTA INSTALADA
        public void copiaVersaoParaPastaDoSistema32bitsAtualizador() throws IOException{
                if (pastaDestino32Atualizador.exists())
                    pastaDestino32Atualizador.delete();
                FileChannel sourceChannel = null;
                FileChannel destinationChannel = null;
                try {
                    sourceChannel = new FileInputStream(arquivoOrigemAtualizador).getChannel();
                    destinationChannel = new FileOutputStream(pastaDestino32Atualizador).getChannel();
                    sourceChannel.transferTo(0, sourceChannel.size(),destinationChannel);
                } finally {
                    if (sourceChannel != null && sourceChannel.isOpen())
                        sourceChannel.close();
                    if (destinationChannel != null && destinationChannel.isOpen())
                        destinationChannel.close();
               }
        }
        
        public void copiaVersaoParaPastaDoSistema() throws IOException{
                if (pastaDestino32Atualizador.exists())
                    pastaDestino32Atualizador.delete();
                FileChannel sourceChannel = null;
                FileChannel destinationChannel = null;
                try {
                    sourceChannel = new FileInputStream(arquivoOrigemAtualizador).getChannel();
                    destinationChannel = new FileOutputStream(pastaDestino32Atualizador).getChannel();
                    sourceChannel.transferTo(0, sourceChannel.size(),destinationChannel);
                } finally {
                    if (sourceChannel != null && sourceChannel.isOpen())
                        sourceChannel.close();
                    if (destinationChannel != null && destinationChannel.isOpen())
                        destinationChannel.close();
               }
        }
        
        public void copiaVersaoParaPastaDoSistema64bitsAtualizador() throws IOException{
                if (pastaDestino64Atualizador.exists())
                    pastaDestino64Atualizador.delete();
                FileChannel sourceChannel = null;
                FileChannel destinationChannel = null;
                try {
                    sourceChannel = new FileInputStream(arquivoOrigemAtualizador).getChannel();
                    destinationChannel = new FileOutputStream(pastaDestino64Atualizador).getChannel();
                    sourceChannel.transferTo(0, sourceChannel.size(),destinationChannel);
                } finally {
                    if (sourceChannel != null && sourceChannel.isOpen())
                        sourceChannel.close();
                    if (destinationChannel != null && destinationChannel.isOpen())
                        destinationChannel.close();
               }
        }
        
        public String verificaDataModificacao(String nomeDoArquivo){
            File arquivo = new File(nomeDoArquivo);
            //File arquivo = new File("c:/arquivo.txt");
            //DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");   
            DateFormat formatData = new SimpleDateFormat("yyMMddMMHH"); 
            String data = formatData.format(new Date(arquivo.lastModified()));
            return data;
        }
        
        File arquivoOrigem = new File ("C:/Dropbox/DSistema.jar");
        File pastaDestino32 = new File ("C:/DSistema/DSistema.jar");
        File pastaDestino64 = new File ("C:/DSistema/DSistema.jar");
        //COPIAR A VERSAO PARA A PASTA ONDE O SISTEMA ESTA INSTALADA
        public void copiaVersaoParaPastaDoSistema32bits() throws IOException{
                if (pastaDestino32.exists())
                    pastaDestino32.delete();
                FileChannel sourceChannel = null;
                FileChannel destinationChannel = null;
                try {
                    sourceChannel = new FileInputStream(arquivoOrigem).getChannel();
                    destinationChannel = new FileOutputStream(pastaDestino32).getChannel();
                    sourceChannel.transferTo(0, sourceChannel.size(),destinationChannel);
                } finally {
                    if (sourceChannel != null && sourceChannel.isOpen())
                        sourceChannel.close();
                    if (destinationChannel != null && destinationChannel.isOpen())
                        destinationChannel.close();
               }
        }
        
        public void copiaVersaoParaPastaDoSistema64bits() throws IOException{
                if (pastaDestino64.exists())
                    pastaDestino64.delete();
                FileChannel sourceChannel = null;
                FileChannel destinationChannel = null;
                try {
                    sourceChannel = new FileInputStream(arquivoOrigem).getChannel();
                    destinationChannel = new FileOutputStream(pastaDestino64).getChannel();
                    sourceChannel.transferTo(0, sourceChannel.size(),destinationChannel);
                } finally {
                    if (sourceChannel != null && sourceChannel.isOpen())
                        sourceChannel.close();
                    if (destinationChannel != null && destinationChannel.isOpen())
                        destinationChannel.close();
               }
        }

        File PastaAtualizacao = new File("C:/AtualizacaoDSistema");
        public void apagaPastaAtualizacaoDSistema(){
            deleteVersaoDaPastaAtualizacao(PastaAtualizacao);
            //Codigo abaixo delete a pasta
            boolean success = (new File("C:/AtualizacaoDSistema")).delete();
            if (success == true){
                //JOptionPane.showMessageDialog(null, "Arquivos excluidos com Sucesso!");
            }else{
                //JOptionPane.showMessageDialog(null, "Não excluiu!");
            }

        }
        
        public void apagaArquivoDaPastaDSistema (String nomeDoArquivo){
            //Codigo abaixo delete a pasta
            boolean success = (new File("C:/DSistema/"+nomeDoArquivo)).delete();
            if (success == true){
                //JOptionPane.showMessageDialog(null, "Arquivos excluidos com Sucesso!");
            }else{
                //JOptionPane.showMessageDialog(null, "Não excluiu!");
            }

        }

        public boolean deleteVersaoDaPastaAtualizacao(File PastaAtualizacao) {

            if (PastaAtualizacao.isDirectory()) {
                String[] children = PastaAtualizacao.list();
                for (int i=0; i<children.length; i++) { 
                   boolean success = deleteVersaoDaPastaAtualizacao(new File(PastaAtualizacao, children[i]));
                    if (!success) {
                        return false;
                    }
                }
            }
            // Agora o diretório está vazio, restando apenas deletá-lo.
            return PastaAtualizacao.delete();
        }
        
        public boolean verificaSeVersaoDoDropEhMaisNova (String arquivoDoDrop, String arquivoDoSistema){
            File arquivoDrop = new File(arquivoDoDrop);
            File arquivoSistema = new File(arquivoDoSistema);
            //File arquivo = new File("c:/arquivo.txt");
            //DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");   
            DateFormat formatData = new SimpleDateFormat("yyMMddHHmmss"); 
            String dataDrop = formatData.format(new Date(arquivoDrop.lastModified()));
            String dataSistema = formatData.format(new Date(arquivoSistema.lastModified()));
            double dataDro = Double.parseDouble(dataDrop);
            double dataSis = Double.parseDouble(dataSistema);
            if (dataDro > dataSis){
                return true;
            }else{
                return false;
            }          
        }
    
        public boolean verificaSeDropBoxExiste(){
            File diretorio = new File("C:/Dropbox"); // ajfilho é uma pasta!
            if (!diretorio.exists()) {
               //JOptionPane.showMessageDialog(null, "Diretório não existe!");
               return false;
            } else {
               //JOptionPane.showMessageDialog(null, "Diretório já existente!");
               return true;
            }
        }
        
        public boolean verificaSeTemPasta64bits(){
            File diretorio = new File("C:/Program Files (x86)"); // ajfilho é uma pasta!
            if (!diretorio.exists()) {
               //JOptionPane.showMessageDialog(null, "Diretório não existe!");
               return false;
            } else {
               //JOptionPane.showMessageDialog(null, "Diretório já existente!");
               return true;
            }
        }
        
        public void VerificaVersaoDropboxEatualiza(){
            //Verifica se tem dropbox instalado
            if (verificaSeDropBoxExiste() == false){
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "DropBox não instalado! Não há como verificar versões!","Falta Informação","erro");
            }else{
                //Verificar se o windows é 64 bits
                if (verificaSeTemPasta64bits() == true){
                    //O windows é 64 bits -> comparar executaveis
                    //Verificar se versao do drop é mais nova
                    if (verificaSeVersaoDoDropEhMaisNova("C:/Dropbox/VERSAO/DSistema.jar", "C:/Program Files (x86)/DSistema/DSistema.jar") == true){
                        //Versao do drop é mais nova ->>> Fazer copia do drop para pasta do sistema
                        try {
                            copiaVersaoParaPastaDoSistema64bits();
                            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Atualização ocorrida com Sucesso!","Sucesso","ok");
                        } catch (IOException ex) {
                            //Logger.getLogger(AtualizarSistema.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        //Versão está atualizada
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Versão já está atualizada!","Sucesso","ok");
                    }
                }else{
                    //O windows é 32 bits -> comparar executaveis
                    if (verificaSeVersaoDoDropEhMaisNova("C:/Dropbox/VERSAO/DSistema.jar", "C:/Program Files/DSistema/DSistema.jar") == true){
                        //Versao do drop é mais nova ->>> Fazer copia do drop para pasta do sistema
                        try {
                            copiaVersaoParaPastaDoSistema32bits();
                            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Atualização ocorrida com Sucesso!","Sucesso","ok");
                        } catch (IOException ex) {
                            //Logger.getLogger(AtualizarSistema.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        //Versão está atualizada
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Versão já está atualizada!","Sucesso","ok");
                    }
                }
            }
        }
        
        public void verificaDiferencaDeVersaoDoTScomServidor(){
////            String versaoServidor = co.retornaVersaoNoBAncoDeDados();
//            String versaoDoSistemaInstalado = co.versaoSistema;
//            versaoServidor = versaoServidor.replace(".","");
//            versaoDoSistemaInstalado = versaoDoSistemaInstalado.replace(".","");
//            int versaoServidorINT = Integer.parseInt(versaoServidor);
//            int versaoDoSistemaInstaladoINT = Integer.parseInt(versaoDoSistemaInstalado);
//            if (versaoServidorINT > versaoDoSistemaInstaladoINT){
//                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Versão do sistema está menor que o servidor, este terminal precisar ser atualizado!","Sucesso","ok");
//                //FAZER PROCEDIMENTO DE ATUALIZAR TS
//                atualizaVersaoManual();
//            }       
        }
        
        public int comparaDatas(Date data1, Date data2){
            return data1.compareTo(data2);
        }
        
        public void verificaVersaoDoTerminal(){
            String caminhoServidor = "";
            FileReader arq;
            try {
                arq = new FileReader("c:\\DSistema\\CaminhoBD.ini");
                BufferedReader lerArq = new BufferedReader(arq); 
                String linha = lerArq.readLine(); 
                caminhoServidor = linha;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AtualizarSistema.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AtualizarSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!caminhoServidor.equals("localhost")){
                //computador nao e o servidor, tem que verificar a modificacao para copiar   
                String caminhoServidorArquivo = "\\"+caminhoServidor+"\\DSistema\\DSistema.jar";
                String caminhoTerminalArquivo = "C:\\DSistema\\DSistema.jar";
                String dataModificacaoDoTerminal = verificaDataModificacao("C:\\DSistema\\DSistema.jar");
                String dataModificacaoDoServidor = verificaDataModificacao("\\"+caminhoServidor+"\\DSistema\\DSistema.jar");
                
                Date dataModificacao1 = dataAtual.transformaDatadigitadaEmDate(dataModificacaoDoTerminal);
                Date dataModificacao2 = dataAtual.transformaDatadigitadaEmDate(dataModificacaoDoServidor);
                int diferencaEntreAsDatasEmDias = comparaDatas(dataModificacao1,dataModificacao2);
                //JOptionPane.showMessageDialog(null, "A diferença entre as 2 datas digitadas é:"+comparaDatas(dataModificacao1,dataModificacao2));
                if (diferencaEntreAsDatasEmDias > 0){
                    //JOptionPane.showMessageDialog(null, "Versão Precisa ser atualizada");
                    //Fazer procedimento de copiar arquivo do servidor para o terminal
                    File arquivoOrigem = new File (caminhoServidorArquivo);
                    File arquivoDestino = new File (caminhoTerminalArquivo);
                    try {
                        copiaArquivo(arquivoOrigem,arquivoDestino);
                    } catch (IOException ex) {
                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível copiar o arquivo! - Erro:"+ex.getMessage(),"Falta Informação","erro");
                        //Logger.getLogger(AtualizarSistema.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }else{
                    //Nao precisa copiar o arquivo
                    //JOptionPane.showMessageDialog(null, "Versão local atualizada");
                }
            }
            
        }
        
        public void copiaArquivo(File origem, File destination) throws IOException {
            if (destination.exists())
                destination.delete();
            FileChannel sourceChannel = null;
            FileChannel destinationChannel = null;
            try {
                sourceChannel = new FileInputStream(origem).getChannel();
                destinationChannel = new FileOutputStream(destination).getChannel();
                sourceChannel.transferTo(0, sourceChannel.size(),
                        destinationChannel);
            } finally {
                if (sourceChannel != null && sourceChannel.isOpen())
                    sourceChannel.close();
                if (destinationChannel != null && destinationChannel.isOpen())
                    destinationChannel.close();
           }
       }
    
}
