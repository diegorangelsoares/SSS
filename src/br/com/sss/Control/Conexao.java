package br.com.sss.Control;

import br.com.model.Cliente;
import br.com.model.Empresa;
import br.com.model.Grupo;
import br.com.model.Usuario;
import br.com.model.Alerta;
import br.com.sss.EMail.DrMail;
import br.com.sss.View.JanelaPesquisaProtocolo;
import br.com.sss.View.JanelaLoginAutorizacaoDialogo;
import br.com.sss.View.JanelaCadastraProduto;
import br.com.sss.View.JanelaConfiguracao;
import br.com.sss.View.JanelaConsultaErros;
import br.com.sss.View.JanelaGradeProdutos;
import br.com.sss.View.JanelaLogin;
import br.com.sss.View.JanelaPrincipal;
import br.com.sss.View.JanelaRelatoriosGerais;
import br.com.sss.View.JanelaDeAlerta;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxRequestConfig;
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.Writer;
//import com.google.zxing.WriterException;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.DocumentException;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.channels.FileChannel;
import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import sun.misc.FloatingDecimal;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.TableColumn;
import br.com.sss.ireport.Ireport;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import javax.imageio.ImageIO;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JRException;
import oracle.jdbc.pool.OracleDataSource;
import org.mozilla.javascript.regexp.SubString;

    /**
     *  @author Diego Rangel
     *
        NOME DOS PERFILS CRIADOS NO SISTEMA
        
        Jacob
       Nena
        RANGEL
        TICIANO
        Construtora
        Consultorio
        Joias
        Receitas
        grafica
        cadastros (controle de lote)
        zmteam (academia)
        OticaMG
        EMISSORNFE
        EMISSORNFCE
        
        VIDRACARIA
        FOOD
        DELIVERY
        MOTOTAXI
            
        #Consultorio#Jacob#Nena#RANGEL#TICIANO#Construtora#Joias#Receitas#grafica#cadastros#VIDRACARIA#
    */

    public class Conexao {
        
    
    public Clean limpar = new Clean();
    public String Driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost:3309/receitas"; 
    public String usuario = "root";
    public String senha = "123456";
    public String caminhoServidor = "localhost";
    
    public String nomeEmpresaPadrao = "INFOMED";
    
    //variaveis de conexao do oracle
    public String usuarioOracle = "sup_infomed";
    public String senhaOracle = "gps$$$";
    public String urlOracle = "10.20.100.23";
    public String portaOracle = "1521";
    public String servicoOracle = "atend"; 
    
    public String versaoSistema = "4.19.6";
    
    public GeraData dataAtual = new GeraData();
    //public GeradorPDF geradorPDFFull = new GeradorPDF();
    public GeraHora horaAtual = new GeraHora();
    public GeraTXT GeradorTXT = new GeraTXT();
    public VerificaDiferencaEntreDatas verificaDiferencaEntreDatas = new VerificaDiferencaEntreDatas();
    public DrMail email = new DrMail();
    
    CaminhoImagem caminhoImagemIcone = new CaminhoImagem();
    MensagemErro mensagemErro = new MensagemErro();
    
    public String nomeSistemaOperacional = "WINDOWS";
    
    public String ambiente = "2"; // 1- transmissão normal    2 - transmissão em homologação
    
    //token para baixar aquivo do dropbox
    String token = "joWcm9dS1RAAAAAAAAAEAgXd4Vn3gE04mbNTFrN8A7XpEoQdfxoqGPP7hCF4cVhT";
    
    
    ArquivoConfiguracao arquivoConfiguracao = new ArquivoConfiguracao();
    
    public Connection con1;
    
    //CONSTRUTOR PRINCIPAL DA CLASSE
    public Conexao(){
        /**
        VerificaCaminhoDoBancoDeDados(this);        
        em = retornaDadosDaEmpresa();  
        if (verificaSeTemArquivoTesteINI() == true){
            nomeEmpresaPadrao = "SISTEMA TESTE";
        }else{
            nomeEmpresaPadrao = retornaNomeDaEmpresa();
        }
        nomePerfilDaEmpresa = retornaNomeDoPerfilDaEmpresa();
        emp = retornaDadosDaEmpresa();
        ambiente = retornaAmbienteDeTransmissaoNFE();
        */
       
        
    }

    public String getDriver() {
        return Driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setDriver(String Driver) {
        this.Driver = Driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
                Windows
		Mac
		Unix
		Solaris    
    */
    
    /**
    CRIA ARQUIVO NO MAC
    cd /home /franca /documentos
    * @return 
     */
    
    public String verificaSistemaOperacional(){
        nomeSistemaOperacional = System.getProperty("os.name").toUpperCase();
        return nomeSistemaOperacional;
    }
    
    public String DataIntegracao = "";       
        
   

    
    public void criaPastaRelatorios (String novoDiretorio){  
        String nomeDiretorio = null;   
        String separador = java.io.File.separator;   
        try {       
             nomeDiretorio = "C:" + separador + novoDiretorio;   
             if (!new File(nomeDiretorio).exists()) { // Verifica se o diretório existe.   
                 (new File(nomeDiretorio)).mkdir();   // Cria o diretório   
             }   
        } catch (Exception ex) {   
            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro ao criar o diretório","Falta Informação","erro");  
        }  
    } 
    
    public void criaPastaDSistema(){
        String SO = verificaSistemaOperacional();            
        if (SO.contains("WINDOWS")){
            //Sistema operacional é windows
            String nomeDiretorio = null;   
            String separador = java.io.File.separator;   
            try {       
                 nomeDiretorio = "C:" + separador + "DSistema";   
                 if (!new File(nomeDiretorio).exists()) { // Verifica se o diretório existe.   
                     (new File(nomeDiretorio)).mkdir();   // Cria o diretório   
                 }   
            } catch (Exception ex) {   
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro ao criar o diretório DSistema","Falta Informação","erro");
            } 
        }else{
           mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("O sistema operacional não é Windows","Falta Informação","erro"); 
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
                            JOptionPane.showMessageDialog(null,"Erro ao baixar o arquivo "+nomeDoArquivo+" \nErro: "+e.getMessage()+"\n\n"
                                                 + "Solicite o arquivo "+nomeDoArquivo+" ao desenvolvedor!");
                        }			
	}
    
    public void apagaArquivoDaPastaDSistema (String nomeDoArquivo){
            //Codigo abaixo delete a pasta
            boolean success = (new File("C:/DSistema/"+nomeDoArquivo)).delete();
            if (success == true){
                //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Arquivos excluidos com Sucesso!");
            }else{
                //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não excluiu!");
            }

        }
    
    public void criaPastaDentroDoDSistema(String nomePasta){
        String SO = verificaSistemaOperacional();            
        if (SO.contains("WINDOWS")){
            //Sistema operacional é windows
            String nomeDiretorio = null;   
            String separador = java.io.File.separator;   
            try {       
                 nomeDiretorio = "C:" + separador + "DSistema" + separador + nomePasta;   
                 if (!new File(nomeDiretorio).exists()) { // Verifica se o diretório existe.   
                     (new File(nomeDiretorio)).mkdir();   // Cria o diretório   
                 }   
            } catch (Exception ex) {   
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro ao criar o diretório DSistema","Falta Informação","erro");
            } 
        }else{
           mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("O sistema operacional não é Windows","Falta Informação","erro"); 
        }
    }
    
    //criaPastaDSistema()
        //verificaSeTemPastaDSISTEMA

    public void VerificaCaminhoDoBancoDeDados(Conexao c){
        String SO = verificaSistemaOperacional();            
        if (SO.contains("WINDOWS")){
            //Sistema operacional é windows
            try { 
//                if (verificaSeTemPastaDSISTEMA() == false){
//                    criaPastaDSistema();
//                }
                FileReader arq = new FileReader("c:\\DSistema\\CaminhoBD.ini");
                BufferedReader lerArq = new BufferedReader(arq); 
                String linha = lerArq.readLine(); 
                caminhoServidor = linha;
                c.setUrl("jdbc:mysql://"+linha+":3309/receitas");
                arq.close(); 
                } catch (IOException e) { 
                    JOptionPane.showMessageDialog(null,"Caminho do BD não encontrado ou Computador não configurado!\n\n"
                                                     + "Computador será reconhecido como Servidor!");
                    criaNovoCaminhoIniBDComLocalHost();
            } 
        }else{
            //JanelaCadastraClienteDialogo jc = new JanelaCadastraClienteDialogo(parent, modal); //(null, rootPaneCheckingEnabled)
            //jc.show();
            //c.setUrl("jdbc:mysql://"+jc.campoCaminho.getText()+":3309/receitas");
            //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("O sistema operacional não é Windows");  
        }
    }
    
    
    
    public boolean verificaSeTemCaminhoBDini(){
            File diretorio = new File("C:\\DSistema\\CaminhoBD.ini"); // ajfilho é uma pasta!
            if (!diretorio.exists()) {
               //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Diretório não existe!");
               return false;
            } else {
               //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Diretório já existente!");
               return true;
            }
    }
    
    public String retornaCaminhoBDTXT(Conexao c){
        try { 
            FileReader arq = new FileReader("c:\\DSistema\\CaminhoBD.txt");
            BufferedReader lerArq = new BufferedReader(arq); 
            String linha = lerArq.readLine(); 
            arq.close(); 
            return linha;
            } catch (IOException e) { 
               mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Caminho do BD não encontrado ou Computador não configurado!","Falta Informação","erro");
                return "Caminho BD não encontrado!";
            } 
    }
    
    public void criaArquivoErroEEnviaEmail(SQLException ex, String nomeFuncao){
        String nomeDoArquivo = GeradorTXT.GeraTxtDeErro("Erro Cmdo SQL " + ex.getMessage()+" Ao "+nomeFuncao);
        String textoDoEmailDeErro = "Erro no Comando SQL: " + ex.getMessage()+" Ao executar a função: "+nomeFuncao+"\n\nVersão do Sistema: "+versaoSistema;
        //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Erro - Contate o desenvolvedor!");
        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro - Contate o desenvolvedor!", "Desculpe-me pelo Erro","erro");
        email.enviarEmailDoErro(nomeEmpresaPadrao,"Registro de erro do sistema" , nomeDoArquivo,versaoSistema);
    }
    
    public void criaArquivoErroEEnviaEmail(ClassNotFoundException ex, String nomeFuncao){
        String nomeDoArquivo = GeradorTXT.GeraTxtDeErro("Erro Cmdo SQL " + ex.getMessage()+" Ao "+nomeFuncao);
        String textoDoEmailDeErro = "Erro no Comando SQL: " + ex.getMessage()+" Ao executar a função: "+nomeFuncao+"\n\nVersão do Sistema: "+versaoSistema;
        //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Erro - Contate o desenvolvedor!");
       mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro - Contate o desenvolvedor!", "Desculpe-me pelo Erro","erro");
        email.enviarEmailDoErro(nomeEmpresaPadrao,"Registro de erro do sistema" , nomeDoArquivo,versaoSistema);
    }
    
    public void criaArquivoErroEEnviaEmail(JRException ex, String nomeFuncao){
        String nomeDoArquivo = GeradorTXT.GeraTxtDeErro("Erro Cmdo SQL " + ex.getMessage()+" Ao "+nomeFuncao);
        String textoDoEmailDeErro = "Erro no Comando SQL: " + ex.getMessage()+" Ao executar a função: "+nomeFuncao+"\n\nVersão do Sistema: "+versaoSistema;
        //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Erro - Contate o desenvolvedor!");
       mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro - Contate o desenvolvedor!", "Desculpe-me pelo Erro","erro");
        email.enviarEmailDoErro(nomeEmpresaPadrao,"Registro de erro do sistema" , nomeDoArquivo,versaoSistema);
    }
        
    public void criaArquivoErroConversaoEnviaEmail(ParseException ex, String nomeFuncao){
        String nomeDoArquivo = GeradorTXT.GeraTxtDeErro("Erro Cmdo SQL " + ex.getMessage()+" Ao "+nomeFuncao);
        //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Erro - Contate o desenvolvedor!");
       mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro - Contate o desenvolvedor!", "Desculpe-me pelo Erro","erro");
        email.enviarEmailDoErro(nomeEmpresaPadrao,"Registro de erro do sistema" , nomeDoArquivo,versaoSistema);
    }
    
    public String retornaCaminhoBDIni(Conexao c){
        
        try { 
            FileReader arq = new FileReader("c:\\DSistema\\CaminhoBD.ini");
            BufferedReader lerArq = new BufferedReader(arq); 
            String linha = lerArq.readLine(); 
            arq.close(); 
            return linha;
            } catch (IOException e) { 
               mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Caminho do BD não encontrado ou Computador não configurado!","Falta Informação","erro");
                return "Caminho BD não encontrado!";
            } 
    }
    
    public String retornaCaminhoBDConfigDSistemaINI(){        
        try { 
            FileReader arq = new FileReader("c:\\DSistema\\Config.ini");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            while ((linha = lerArq.readLine()) != null){
                if (linha.contains("CaminhoBD==")){
                    linha = linha.replace("CaminhoBD==", "");
                    arq.close();
                    return linha;
                }
            }
            arq.close(); 
            return linha;
            } catch (IOException e) { 
               mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Caminho do BD não encontrado(Config.ini) ou Computador não configurado!","Falta Informação","erro");
                return "Caminho BD não encontrado!";
            } 
    }
    
    public boolean VerificaSeVerificouAtualizacao(){
        try { 
            FileReader arq = new FileReader("c:\\DSistema\\ConfigDSistema.ini");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            while ((linha = lerArq.readLine()) != null){
                if (linha.contains("VerificouAtualizacao==")){
                    if (linha.equals("VerificouAtualizacao==sim")){
                        arq.close();
                        return true;
                    }
                }
            }
            arq.close(); 
            return false;
            } catch (IOException e) { 
               mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Caminho do BD não encontrado ou Computador não configurado!","Falta Informação","erro");
                return false;
            } 
    }
    
    
    
    public void preencheBancosDeDadosSalvosNoArquivoIni(JanelaLogin j){
       // j.campoBanco.removeAllItems();
        try { 
            FileReader arq = new FileReader("c:\\DSistema\\CaminhoBD.ini");
            BufferedReader lerArq = new BufferedReader(arq);  
            String linha = lerArq.readLine();
            while (linha != null) {
                if (!linha.equals("")){
                    //j.campoBanco.addItem(linha);
                }
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close(); 
            } catch (IOException e) { 
               mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Caminho do BD não encontrado ou Computador não configurado!","Falta Informação","erro");
            }
    }
    
    public void organizaSequenciaCaminhoIni(String nomeBancoEscolhido){
        ArrayList<String> Bancos = new ArrayList<String>();
        try { 
            //Ler todos os bancos salvos
            FileReader arq = new FileReader("c:\\DSistema\\CaminhoBD.ini");
            BufferedReader lerArq = new BufferedReader(arq);  
            String linha = lerArq.readLine();
            //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Ate aqui ta ok ");
            Bancos.add(nomeBancoEscolhido); 
            while (linha != null) {
                //Verificar se tem linha em branco ou se é o banco ja escolhido
                if (!linha.equals("") && !linha.equals(nomeBancoEscolhido)){
                    Bancos.add(linha);                    
                }
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            
            //remover o arquivo ini para criar um novo
            String nome = "c:/DSistema/CaminhoBD.ini";  
            File f = new File(nome);  
            f.delete();

            //renovar nova sequencia colocando o escolhido no inicio
            String nomeDoArquivo = "c:\\DSistema\\CaminhoBD.ini";
            BufferedWriter buffWrite = null; 
            try {                
                buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));
                for (int i = 0; i < Bancos.size(); i++) {
                    buffWrite.write((String) Bancos.get(i));
                    buffWrite.newLine();
                }
                buffWrite.close();
            } catch (IOException ex) {
               mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O Windows não deixou criar o arquivo do Caminho BD!","Falta Informação","erro");
            }
            
            arq.close(); 
            } catch (IOException e) { 
               mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Caminho do BD não encontrado ou Computador não configurado!","Falta Informação","erro");
            } 
    }
       
    
    public String retornaConfiguracoesCaminhoBD(int linhaAretornar){
        int vezesDoArquivo = 0;
        String linha = "";
        try { 
            FileReader arq = new FileReader("c:\\DSistema\\CaminhoBD.ini");
            BufferedReader lerArq = new BufferedReader(arq); 
            while (vezesDoArquivo != linhaAretornar){
                linha = lerArq.readLine(); 
                vezesDoArquivo++;
            }
            arq.close(); 
            return linha;
            } catch (IOException e) { 
               mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Caminho do BD não encontrado ou Computador não configurado!","Falta Informação","erro");
                return "";
            } 
    }
    
    public void criaNovoCaminhoIniBDComLocalHost(){
            String nomeDoArquivo = "c:\\DSistema\\CaminhoBD.ini";
            BufferedWriter buffWrite = null; 
            try {
                buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));
                buffWrite.append("localhost\n");
                buffWrite.close();
            } catch (IOException ex) {
               mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O Windows não deixou criar o arquivo do Caminho BD!","Falta Informação","erro");
            }
    }
    
    public void criaConfigDSistemaINI(String caminhoBD,String perfil){
           //renovar nova sequencia colocando o escolhido no inicio
                String nomeDoArquivo = "c:\\DSistema\\ConfigDSistema.ini";
                BufferedWriter buffWrite = null; 
                try {                
                    buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));
                            buffWrite.write("CaminhoBD=="+caminhoBD);
                            buffWrite.newLine();                        
                            buffWrite.write("Integrado==sim");
                            buffWrite.newLine();
                            buffWrite.write("VerificouAtualizacao==sim");
                            buffWrite.newLine();
                            buffWrite.write("Atualizado==sim");
                            buffWrite.newLine();
                            buffWrite.write("Perfil=="+perfil);
                            buffWrite.newLine();
                            buffWrite.write("DataQueAtualizou=="+perfil);
                            buffWrite.newLine();
                            
                    buffWrite.close();
                   mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Arquivo de configuraçao criado com Sucesso!","Sucesso","ok");
                } catch (IOException ex) {
                   mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O Windows não deixou criar o arquivo do Caminho BD!","Sucesso","ok");
                }   
       
    }
    
    public void alteraLinhaArquivoDeConfiguracao (String linhaAalterar , String palavraNova) throws IOException {
            String arquivo = "ConfigDSistema.ini";
            String arquivoTmp = "ConfigDSistema-tmp.ini";

            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
            BufferedReader reader = new BufferedReader(new FileReader(arquivo));

            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains(linhaAalterar)){
                    linha = linhaAalterar+"=="+palavraNova;
                    writer.write(linha + "\n");
                }
            }

            writer.close();        
            reader.close();

            new File(arquivo).delete();
            new File(arquivoTmp).renameTo(new File(arquivo));
    }
    
    public void criaArquivoUsuarioLogado(String nomeUsuario){
            String nomeDoArquivo = "c:\\DSistema\\Usuario.ini";
            BufferedWriter buffWrite = null; 
            String linha = ""; 
        try {
            buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));
            buffWrite.append(nomeUsuario+"\n");
            buffWrite.close();
        } catch (IOException ex) {
           mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O Windows não deixou criar o arquivo do usuario!","Sucesso","ok");
        }
    }
    
    
    public String retornaUsuarioLogadoTXT(){
        
        try { 
            FileReader arq = new FileReader("c:\\DSistema\\Usuario.ini");
            BufferedReader lerArq = new BufferedReader(arq); 
            String linha = lerArq.readLine(); 
            arq.close(); 
            return linha;
            } catch (IOException e) { 
               mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Nao tem usuario logado salvo!","Falta Informação","erro");
                return "";
            } 
    }
    

    public String retornaUsuarioSalvoNoConfig() throws IOException {
        String usuario = "";    
        try{
                String arquivo = "C:/DSistema/Config.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 4){
                        usuario = linha;
                        usuario = usuario.replace("USUARIO_LOGADO==", "");
                        if (!usuario.equals("")){
                            return usuario;
                        }
                    }
                    contadorLinha++;
                }    
                reader.close();                 
            }catch(IOException ex){
                //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!");
                //criaArquivoConfig(caminhoServidor,em.getPerfil() );
                return usuario;
            }
        return usuario;
    }
    
    public static double converterDoubleDoisDecimais(double precoDouble) {  
        DecimalFormat fmt = new DecimalFormat("0.00");        
        String string = fmt.format(precoDouble);  
        String[] part = string.split("[,]");  
        String string2 = part[0]+"."+part[1];  
        double preco = Double.parseDouble(string2);  
        return preco;  
    }  
    
//    public void InserirCliente(Cliente c){              
//            try {
//                String sql = "insert into tab_cliente ( nome, razao,endereco, numero, telefone, bairro, cidade, estado, cep, cnpj, email,observacao,insc_estadual,codigo_municipio,data_nascimento,descricaoContrato,valorInstalacao,valorMensalidade,numeroDeMensalidades,vencimentoMensalidade,celular,matricula,pai,mae,tel_trabalho,Integrado,DataIntegracao,EstadoCivil,Profissao,Sexo,RendaFamiliar,Vendedor,Loteamento,EnderecoLoteamento,RegistroLoteamento,Quadra,Lote,NumeroContrato,Area,Medicoes,ValorDaCompra,ValorEntrada,PrimeiraParcela,SegundaParcela,TerceiraParcela,QuartaParcela,QuantidadeDeParcelas,ValorDaParcela,DiaVencimento,SituacaoPagamento,DataContrato, RuaCobranca, NumeroCobranca, BairroCobranca, CidadeCobranca, UfCobranca, CEPCobranca, NomeConjugue, IdentidadeConjugue, ProfissaoConjugue, NascimentoConjugue, CPFConjugue,DataInicioDaUtilizacaoDoSistema,Perfil,  Graduacao,  QuantidadeDeGraus, Tipo,Idade,Nacionalidade,NacionalidadeConugue,TelefoneConjugue,ValorDaCompraPorExtenso,DataDoContratoPorExtenso,DescricaoFrente,DEscricaoFundos,MedicaoFrente,MedicaoFundos,DescricaoLD,DescricaoLE,MedicaoLD,MedicaoLE,TotalParcelado,StatusCadastro) values ('"+c.getNome()+"','"+c.getRazao()+"','"+c.getRua()+"','"+c.getNumero()+"','"+c.getTelefone()+"','"+c.getBairro()+"','"+c.getCidade()+"','"+c.getEstado()+"','"+c.getCep()+"','"+c.getCnpj()+"','"+c.getEmail()+"','"+c.getObservacao()+"','"+c.getIe()+"','"+c.getCodigo_municipio()+"','"+c.getDataNascimento()+"','"+c.getDescricaoContrato()+"','"+c.getValorInstalacao()+"','"+c.getValorMensalidade()+"','"+c.getNumeroDeMensalidades()+"','"+c.getVencimentoMensalidade()+"','"+c.getCelular()+"','"+c.getMatricula()+"','"+c.getPai()+"','"+c.getMae()+"','"+c.getTel_trabalho()+"','"+c.getIntegrado()+"','"+c.getDataIntegracao()+"','"+c.getEstadoCivil()+"','"+c.getProfissao()+"','"+c.getSexo()+"','"+c.getRendaFamiliar()+"','"+c.getVendedor()+"','"+c.getLoteamento()+"','"+c.getEnderecoLoteamento()+"','"+c.getRegistroLoteamento()+"','"+c.getQuadra()+"','"+c.getLote()+"','"+c.getNumeroContrato()+"','"+c.getArea()+"','"+c.getMedicoes()+"','"+c.getValorDaCompra()+"','"+c.getValorEntrada()+"','"+c.getPrimeiraParcela()+"','"+c.getSegundaParcela()+"','"+c.getTerceiraParcela()+"','"+c.getQuartaParcela()+"','"+c.getQuantidadeDeParcelas()+"','"+c.getValorDaParcela()+"','"+c.getDiaVencimento()+"','"+c.getSituacaoPagamento()+"','"+c.getDataContrato()+"','"+c.getRuaCobranca()+"','"+c.getNumeroCobranca()+"','"+c.getBairroCobranca()+"','"+c.getCidadeCobranca()+"','"+c.getUfCobranca()+"','"+c.getCEPCobranca()+"','"+c.getNomeConjugue()+"','"+c.getIdentidadeConjugue()+"','"+c.getProfissaoConjugue()+"','"+c.getNascimentoConjugue()+"','"+c.getCPFConjugue()+"','"+c.getDataInicioDaUtilizacaoDoSistema()+"','"+c.getPerfil()+"',  '"+c.getGraduacao()+"',  '"+c.getQuantidadeDeGraus()+"', '"+c.getTipo()+"','"+c.getIdade()+"', '"+c.getNacionalidade()+"', '"+c.getNacionalidadeConugue()+"', '"+c.getTelefoneConjugue()+"', '"+c.getValorDaCompraPorExtenso()+"', '"+c.getDataDoContratoPorExtenso()+"', '"+c.getDescricaoFrente()+"', '"+c.getDEscricaoFundos()+"', '"+c.getMedicaoFrente()+"', '"+c.getMedicaoFundos()+"', '"+c.getDescricaoLD()+"', '"+c.getDescricaoLE()+"', '"+c.getMedicaoLD()+"', '"+c.getMedicaoLE()+"', '"+c.getTotalParcelado()+"','')";
//                AbreConexaoBanco().executeUpdate(sql);
//                //Inserir historico
//                String sql2 = "insert into tab_historico_cliente ( nomeCliente, historico,dataMovimento,  horaMovimento, dataSemBarras,Integrado,DataIntegracao) values ('"+c.getNome()+"', 'Inclusão de cliente', '"+dataAtual.RetornaDataAtual()+"', '"+horaAtual.RetornaHoraAtual()+"','"+dataAtual.RetornaDataAtualSemBarra()+"','true','"+horaAtual.RetornaHoraAtual()+"')";
//                AbreConexaoBanco().executeUpdate(sql2);
//                FechaConexaoBanco(con1);
//                if (em.getPerfil().equals("zmteam")){
//                    mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Aluno cadastrado! ","Sucesso","ok");
//                }else{
//                    mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Cliente cadastrado! ","Sucesso","ok");
//                }                  
//            }  catch( SQLException e){ //trata os erros SQL
//                criaArquivoErroEEnviaEmail(e, "InserirCliente");
//            }
//    }
//    

    public String retornaIdDeliveryPelaDataHora(String data, String hora){
        String numero = "";    
        try {  
            String sql = "Select * from tab_delivery where DataInclusao='"+data+"' AND HoraInclusao='"+hora+"'";
            java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
            //Imprime o resultado na tabela
            while (rs.next()){
                numero = rs.getString("id");
            }
            FechaConexaoBanco(con1);
            return numero;
            }catch( SQLException e){ //trata os erros SQL
                criaArquivoErroEEnviaEmail(e, "retornaIdDeliveryPelaDataHora");
                return numero;
            }
    }
    

    public void inserirCaminhoFotoCliente(String idCliente, String NomeCliente, String caminhoImagem,String tamanhoImagem){              
        //caminhoImagem = caminhoImagem.replace("\\","/");
        //caminhoImagem = caminhoImagem.replace("\","/");    
        try {
                String sql = "insert into tab_foto_cliente ( idCliente, NomeCliente, caminhoImagem,tamanhoImagem) values ('"+idCliente+"', '"+NomeCliente+"', '"+caminhoImagem+"','"+tamanhoImagem+"')";
                AbreConexaoBanco().executeUpdate(sql);
                FechaConexaoBanco(con1);
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Foto gravada!","Sucesso","ok");   
            }  catch( SQLException e){ //trata os erros SQL
                criaArquivoErroEEnviaEmail(e, "inserirCaminhoFotoCliente");
            }
    }
    
    public void atualizaCaminhoFotoCliente(String idCliente, String caminhoImagem,String tamanhoImagem){              
            //caminhoImagem = caminhoImagem.replace("\\","/");
            //caminhoImagem = caminhoImagem.replace("\","/");
        try {
                //apaga o caracter # por em branco
                String sql = "UPDATE tab_foto_cliente SET caminhoImagem = '"+caminhoImagem+"', tamanhoImagem='"+tamanhoImagem+"' where idCliente='"+idCliente+"'";
                AbreConexaoBanco().executeUpdate(sql);
                FechaConexaoBanco(con1);
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Foto alterada! ","Sucesso","ok");  
            }  catch( SQLException e){ //trata os erros SQL
                criaArquivoErroEEnviaEmail(e, "atualizaCaminhoFotoCliente");
            }
    }
    
    public String retornaCaminhoFotoCliente (String idCliente){
        String caminhoImagem = "";
        try {  
            String sql = "Select * from tab_foto_cliente where idCliente='"+idCliente+"'";
            java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
            //Imprime o resultado na tabela            
            while (rs.next()) {
                caminhoImagem = rs.getString("caminhoImagem");
                
            }
            FechaConexaoBanco(con1);
            }catch( SQLException e){ //trata os erros SQL
                criaArquivoErroEEnviaEmail(e, "retornaCaminhoFotoCliente");
            } 
        return caminhoImagem;
    }
    
    public boolean retornaSeClientetemFotoSalva (String idCliente){
        try {  
            String sql = "Select * from tab_foto_cliente where idCliente='"+idCliente+"'";
            java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
            //Imprime o resultado na tabela
            String NomePaciente = "";
            while (rs.next()) {
                NomePaciente = rs.getString("NomeCliente");
            }
            FechaConexaoBanco(con1);
            if (!NomePaciente.equals("")){
                return true;
            }else{
                return false;
            }
            }catch( SQLException e){ //trata os erros SQL
                criaArquivoErroEEnviaEmail(e, "retornaSeClientetemFotoSalva");
                return false;
            }    
    }
    
    public void adicionaVIDRACARIAnoTabPermissao(){              
            try {
                //apaga o caracter # por em branco
                String sql = "UPDATE tab_restricao_menu SET perfilQueUtiliza = replace( perfilQueUtiliza, '-', '')";
                AbreConexaoBanco().executeUpdate(sql);
                FechaConexaoBanco(con1);
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Correção ocorrida com Sucesso! ","Sucesso","ok");   
            }  catch( SQLException e){ //trata os erros SQL
                criaArquivoErroEEnviaEmail(e, "replaceTabelaMysql");
            }
    }
    
    public void replaceTabelaMysql(){              
            try {
                //apaga o caracter # por em branco
                String sql = "UPDATE tab_restricao_menu SET perfilQueUtiliza = replace( perfilQueUtiliza, '-', '')";
                AbreConexaoBanco().executeUpdate(sql);
                FechaConexaoBanco(con1);
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Correção ocorrida com Sucesso! ","Sucesso","ok");  
            }  catch( SQLException e){ //trata os erros SQL
                criaArquivoErroEEnviaEmail(e, "replaceTabelaMysql");
            }
    }
    
    
    public void InserirRegistro(String nome){              
            try {
                String sql = "insert into tab_cliente ( nome, razao,endereco) values ('"+nome+"','','')";
                AbreConexaoBanco().executeUpdate(sql);
                FechaConexaoBanco(con1);
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Cadastrado com Sucesso! ","Sucesso","ok");
            }  catch( SQLException e){ //trata os erros SQL
                JOptionPane.showMessageDialog(null,"Erro:\n\n"
                                                 + e.getMessage());
            }
    }
    
    public void alteraRegistro(){              
            try {
                //apaga o caracter # por em branco
                String sql = "UPDATE tab_restricao_menu SET perfilQueUtiliza = replace( perfilQueUtiliza, '-', '')";
                AbreConexaoBanco().executeUpdate(sql);
                FechaConexaoBanco(con1);
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Alterado com Sucesso! ","Sucesso","ok");   
            }  catch( SQLException e){ //trata os erros SQL
                JOptionPane.showMessageDialog(null,"Erro:\n\n"
                                                 + e.getMessage());
            }
    }
    
    public void excluirRegistro (int id, String nome){
            try {
            String sql = "delete from tab_cargo where id='"+id+"' AND nome='"+nome+"'";
            AbreConexaoBanco().executeUpdate(sql);
            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( " Deletado com Sucesso! ","Sucesso","ok");
            FechaConexaoBanco(con1);
            }catch( SQLException e){ //trata os erros SQL
                JOptionPane.showMessageDialog(null,"Erro:\n\n"
                                         + e.getMessage());
            }         
    }
    
    public Statement AbreConexaoBanco(){
        // Ler o JDBC driver
        //VerificaCaminhoDoBancoDeDados(this);
        String driverName = Driver; // MySQL MM JDBC driver
        try {
            Class.forName(driverName);
            // Cria uma conexão com o banco
            con1 = DriverManager.getConnection(url,usuario,senha);
            Statement stmt = con1.createStatement();       //objeto comando sql
            //Retorna a instancia do banco conectado
            return stmt; //Retorna a instancia
        } catch (ClassNotFoundException ex) {
            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Impossível conectar com o banco, verifique o drive do Mysql!","Falta Informação","erro");            
            //Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Impossível localizar o servidor: "+caminhoServidor);
            JOptionPane.showMessageDialog(null,"Impossível localizar o servidor!\n\n"
                                                 + "Possiveis causas/soluções: \n"
                                                 + "- Verifique se o servidor está ligado '"+caminhoServidor+"'\n"
                                                 + "- Verifique a rede (comunicação com o servidor) e tente novamente.\n");
            return null;
        }
    }
    
    public Statement AbreConexaoBancoOracle(){
        OracleDataSource ods;
        try {
            //try {
            ods = new OracleDataSource();
       
        
            ods.setURL("jdbc:oracle:thin:@//"+urlOracle+":"+portaOracle+"/"+servicoOracle+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
            ods.setUser(usuarioOracle); // [nome do usuário]
            ods.setPassword(senhaOracle); // [senha]
            Connection conn = ods.getConnection();
            Statement stmt = con1.createStatement();       //objeto comando sql
            //Retorna a instancia do banco conectado
            return stmt; //Retorna a instancia
            /**
        } catch (ClassNotFoundException ex) {
            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Impossível conectar com o banco Oracle, verifique o drive do Mysql!","Falta Informação","erro");            
            //Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            * */
        } catch (SQLException ex) {
            //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Impossível localizar o servidor: "+caminhoServidor);
            JOptionPane.showMessageDialog(null,"Impossível localizar o servidor!\n\n"
                                                 + "Possiveis causas/soluções: \n"
                                                 + "- Verifique se o servidor Oracle está ligado '"+caminhoServidor+"'\n"
                                                 + "- Verifique a rede (comunicação com o servidor) e tente novamente.\n");
            return null;
        }
        
    }
    
    public void FechaConexaoBanco(Connection con){
        try {
            // fecha conexão com BD
            con1.close();  
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void verificaConexaoOracle(String banco, String porta, String usuario, String senha, String caminho, String servico){
        OracleDataSource ods;
        //jdbc:oracle:thin:@//"+caminho+":1521/XE
        try {
            ods = new OracleDataSource();
        
            ods.setURL("jdbc:oracle:thin:@//"+caminho+":"+porta+"/"+servico+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
            ods.setUser(usuario); // [nome do usuário]
            ods.setPassword(senha); // [senha]
            Connection conn = ods.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT 'Teste' FROM dual");
            ResultSet rslt = stmt.executeQuery();
            JOptionPane.showMessageDialog(null, "Conexão Sucesso!");
            //while (rslt.next()) {
            //  System.out.println(rslt.getString(1));
            //}
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Impossível localizar o banco! Erro:\n\n"
                                                 + ex.getMessage());
        }
        
    }
    
    public void consultaErros( JanelaConsultaErros j, String data1, String data2){
            OracleDataSource ods;
            int quantidadeRegistros = (int) j.campoQuantidadeRegistros.getValue();
            //jdbc:oracle:thin:@//"+caminho+":1521/XE
            try {
                ods = new OracleDataSource();
                String porta = "1521";
                ods.setURL("jdbc:oracle:thin:@//"+j.campoEnderecoBanco.getText()+":"+porta+"/"+j.campoServicoBanco.getText()+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
                ods.setUser(j.campoUsuarioBanco.getText()); // [nome do usuário]
                ods.setPassword(j.campoSenhaBanco.getText()); // [senha]
                Connection conn = ods.getConnection();
                String usuarioErro = (String) j.campoUsuarioErro.getSelectedItem();
                String perfil = (String) j.campoPerfilErros.getSelectedItem();
                usuarioErro = usuarioErro+perfil;
                if (usuario.equals("INFOMED") || usuario.equals("SUP_INFOMED") || usuario.equals("INFOINSTALL")){
                    usuarioErro = (String) j.campoUsuarioErro.getSelectedItem();
                }
                String descricaoErro = j.campoErro.getText().toUpperCase();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM INFO_ATEND_255.INF_ERROS ER WHERE trunc(ER.ERR_DATA_HORA) "
                    + "between '"+data1+"' and '"+data2+"'      and upper(er.err_usuario) like '%"+usuarioErro+"%'      "
                    + "and upper(er.err_programa) like '%"+descricaoErro+"%'       and ROWNUM <= "+quantidadeRegistros+"    order by 1 desc");
          
                ResultSet rs = stmt.executeQuery();
                //Preenche os dados no formulario
                while (rs.next()){
                    String data = rs.getString("err_data_hora");
                    String lastName = rs.getString("err_programa");
                    String mensagem = rs.getString("err_mensagem");
                    String Usuario = rs.getString("err_usuario");
                    javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)j.tabelaErros.getModel();
                    dtm.addRow(new Object[]{data, Usuario, lastName+" - "+mensagem});                
                }
                FechaConexaoBanco(con1);
            }catch( SQLException e){ //trata os erros SQL
                //Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null,"Erro:\n\n"
                                                 + e.getMessage());
            }     
    }
    
    
    
}
