
package br.com.sss.Control;

import br.com.sss.Control.MensagemErro;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Rangel
 */

public class ArquivoConfiguracao {
    
    GeraData dataAtual = new GeraData();
    GeraHora horaAtual = new GeraHora();
    
    public String nomeSistemaOperacional = "WINDOWS";
    
    MensagemErro mensagemErro = new MensagemErro();
    
    public ArquivoConfiguracao(){
        criaPastaDentroDoDSistema("NFE");
    }
    
    public String verificaSistemaOperacional(){
        nomeSistemaOperacional = System.getProperty("os.name").toUpperCase();
        return nomeSistemaOperacional;
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
                 mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro ao criar o diretório DSistema" + ex.toString(),"Falta Informação","erro");
            } 
        }else{
            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("O sistema operacional não é Windows","Falta Informação","erro");
        }
    }
    
    public void criaArquivoConfig (String perfil, String Usuario){
        String caminhoBD = "localhost";
            
            //renovar nova sequencia colocando o escolhido no inicio
            String nomeDoArquivo = "c:\\DSistema\\Config.ini";
            BufferedWriter buffWrite = null; 
            try {                
                buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));
                int linha = 0;
                while (linha<8) {
                    if (linha==0){
                        buffWrite.write("CAMINHOBD=="+caminhoBD);
                        buffWrite.newLine();
                    }
                    if (linha==1){
                        buffWrite.write("PERFIL=="+perfil);
                        buffWrite.newLine();
                    }
                    if (linha==2){
                        buffWrite.write("DATA_ULTIMA_ABERTURA=="+dataAtual.RetornaDataAtual());
                        buffWrite.newLine();
                    }
                    if (linha==3){
                        buffWrite.write("HORA_ULTIMA_ABERTURA=="+horaAtual.RetornaHoraAtual());
                        buffWrite.newLine();
                    }
                    if (linha==4){
                        buffWrite.write("USUARIO_LOGADO=="+Usuario);
                        buffWrite.newLine();
                    }
                    if (linha==5){
                        buffWrite.write("CERTIFICADO=="+"");
                        buffWrite.newLine();
                    }
                    if (linha==6){
                        buffWrite.write("SENHA_CERTIFICADO=="+"");
                        buffWrite.newLine();
                    }
                    if (linha==6){
                        buffWrite.write("BANCO=="+"Mysql");
                        buffWrite.newLine();
                    }
                    linha++;
                }
                buffWrite.close();
            } catch (IOException ex) {
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O Windows não deixou criar o arquivo Config.ini!","Falta Informação","erro");
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
             mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro ao criar o diretório" + ex.toString(),"Falta Informação","erro");  
        }  
    } 
    
    public void criaArquivoConfiguracaoNFE (String CNPJ){            
            //renovar nova sequencia colocando o escolhido no inicio
            criaPastaRelatorios("NFE");
            String nomeDoArquivo = "c:\\DSistema\\NFE\\ConfiguracaoNFE.ini";
            BufferedWriter buffWrite = null; 
            try {                
                buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));
                int linha = 0;
                while (linha<6) {
                    if (linha==0){
                        buffWrite.write("CNPJ=="+CNPJ);
                        buffWrite.newLine();
                    }
                    if (linha==1){
                        buffWrite.write("CAMINHO_CERTIFICADO==");
                        buffWrite.newLine();
                    }
                    if (linha==2){
                        buffWrite.write("SENHA_CERTIFICADO==");
                        buffWrite.newLine();
                    }
                    if (linha==3){
                        buffWrite.write("TIPO_CERTIFICADO==");
                        buffWrite.newLine();
                    }
                    if (linha==4){
                        buffWrite.write("CSC==");
                        buffWrite.newLine();
                    }
                    if (linha==5){
                        buffWrite.write("ID_TOKEN==");
                        buffWrite.newLine();
                    }
                    linha++;
                }
                buffWrite.close();
            } catch (IOException ex) {
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O Windows não deixou criar o arquivo ConfiguracaoNFE.ini!","Falta Informação","erro");
            }
            
    }
    
    public String retornaCaminhoBDnoConfig() throws IOException {
        String caminho = "localhost";    
        try{
                String arquivo = "C:/DSistema/Config.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                /**                 
                CAMINHOBD==
                PERFIL==
                DATA_ULTIMA_ABERTURA==
                HORA_ULTIMA_ABERTURA==
                USUARIO_LOGADO==    
                CERTIFICADO==
                SENHA_CERTIFICADO==
                */                
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 0){
                        caminho = linha;
                    }
                    contadorLinha++;
                }    
                reader.close(); 
                caminho = caminho.replace("CAMINHOBD==", "");
                return caminho;
            }catch(IOException ex){
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!","Falta Informação","erro");
                //criaArquivoConfig(caminhoServidor,em.getPerfil() );
                return caminho;
            }
    }
    
    public String retornaBancoDoConfig() throws IOException {
        String caminho = "localhost";    
        try{
                String arquivo = "C:/DSistema/Config.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                /**                 
                CAMINHOBD==
                PERFIL==
                DATA_ULTIMA_ABERTURA==
                HORA_ULTIMA_ABERTURA==
                USUARIO_LOGADO==    
                CERTIFICADO==
                SENHA_CERTIFICADO==
                */                
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 7){
                        caminho = linha;
                    }
                    contadorLinha++;
                }    
                reader.close(); 
                caminho = caminho.replace("BANCO==", "");
                return caminho;
            }catch(IOException ex){
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!","Falta Informação","erro");
                //criaArquivoConfig(caminhoServidor,em.getPerfil() );
                return caminho;
            }
    }
    
    public String retornaCaminhoBancoDeDadosNoCaminhoNDIni(){
        String caminhoServidor = "";           
            //Sistema operacional é windows
            try { 
                FileReader arq = new FileReader("c:\\DSistema\\CaminhoBD.ini");
                BufferedReader lerArq = new BufferedReader(arq); 
                String linha = lerArq.readLine(); 
                caminhoServidor = linha;
                arq.close(); 
                } catch (IOException e) { 
                    //JOptionPane.showMessageDialog(null,"Caminho do BD não encontrado ou Computador não configurado!\n\n"
                    //                                 + "Computador será reconhecido como Servidor!");
            } 
        return caminhoServidor;
    }
    
    public String retornaPerfilnoConfig() throws IOException {
        String perfil = "";    
        try{
                String arquivo = "C:/DSistema/Config.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                /**                 
                CAMINHOBD==
                PERFIL==
                DATA_ULTIMA_ABERTURA==
                HORA_ULTIMA_ABERTURA==
                USUARIO_LOGADO==    
                CERTIFICADO==
                SENHA_CERTIFICADO==                 
                */                
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 1){
                        perfil = linha;
                    }
                    contadorLinha++;
                }    
                reader.close(); 
                perfil = perfil.replace("PERFIL==", "");
                return perfil;
            }catch(IOException ex){
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!","Falta Informação","erro");
                //criaArquivoConfig(caminhoServidor,em.getPerfil() );
                return perfil;
            }
    }
    
    public String retornaUsuarioLogadoNoConfig() throws IOException {
        String usuario = "";    
        try{
                String arquivo = "C:/DSistema/Config.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                /**                 
                CAMINHOBD==
                PERFIL==
                DATA_ULTIMA_ABERTURA==
                HORA_ULTIMA_ABERTURA==
                USUARIO_LOGADO==    
                CERTIFICADO==
                SENHA_CERTIFICADO==               
                */                
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 4){
                        usuario = linha;
                    }
                    contadorLinha++;
                }    
                reader.close(); 
                usuario = usuario.replace("USUARIO_LOGADO==", "");
                return usuario;
            }catch(IOException ex){
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!","Falta Informação","erro");
                //criaArquivoConfig(caminhoServidor,em.getPerfil() );
                return usuario;
            }
    }
    
    public String retornaHoraUltimaAberturaNoConfig() throws IOException {
        String hora = "";    
        try{
                String arquivo = "C:/DSistema/Config.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                /**                 
                CAMINHOBD==
                PERFIL==
                DATA_ULTIMA_ABERTURA==
                HORA_ULTIMA_ABERTURA==
                USUARIO_LOGADO==    
                CERTIFICADO==
                SENHA_CERTIFICADO==                
                */                
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 3){
                            hora = linha;
                    }
                    contadorLinha++;
                }    
                reader.close(); 
                hora = hora.replace("HORA_ULTIMA_ABERTURA==", "");
                return hora;
            }catch(IOException ex){
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!","Falta Informação","erro");
                //criaArquivoConfig(caminhoServidor,em.getPerfil() );
                return hora;
            }
    }
    
    public String retornaDataUltimaAberturaNoConfig() throws IOException {
        String data = "";    
        try{
                String arquivo = "C:/DSistema/Config.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                /**                 
                CAMINHOBD==
                PERFIL==
                DATA_ULTIMA_ABERTURA==
                HORA_ULTIMA_ABERTURA==
                USUARIO_LOGADO==    
                CERTIFICADO==
                SENHA_CERTIFICADO==                 
                */                
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 2){
                            data = linha;
                    }
                    contadorLinha++;
                }    
                reader.close(); 
                data = data.replace("DATA_ULTIMA_ABERTURA==", "");
                return data;
            }catch(IOException ex){
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!","Falta Informação","erro");
                //criaArquivoConfig(caminhoServidor,em.getPerfil() );
                return data;
            }
    }
    
    public boolean verificaSeTemArquivoConfigIni(){
            File arquivo = new File("C:/DSistema/Config.ini"); // ajfilho é uma pasta!
            if (!arquivo.exists()) {
               //JOptionPane.showMessageDialog(null, "Diretório não existe!");
               return false;
            } else {
               //JOptionPane.showMessageDialog(null, "Diretório já existente!");
               return true;
            }
    }
    
    public boolean verificaSeArquivoConfigEstaCorreto () throws IOException {
            boolean estaCorreto = true;
            try{
                String arquivo = "C:\\DSistema\\Config.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                /**                 
                CAMINHOBD==
                PERFIL==
                DATA_ULTIMA_ABERTURA==
                HORA_ULTIMA_ABERTURA==
                USUARIO_LOGADO==    
                CERTIFICADO==
                SENHA_CERTIFICADO==                 
                */  
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 0){
                        if (!linha.contains("CAMINHOBD==")){
                            estaCorreto = true;                   
                        }
                    }
                    //Confere a segunda linha - integrado
                    if (contadorLinha == 1){
                        if (!linha.contains("PERFIL==")){
                            return false;
                        }
                    }
                    //Confere a terceira linha - VerificouAtualizacao
                    if (contadorLinha == 2){
                        if (!linha.contains("DATA_ULTIMA_ABERTURA==")){
                            return false;
                        }
                    }
                    //Confere a quarta linha - Atualizado
                    if (contadorLinha == 3){
                        if (!linha.contains("HORA_ULTIMA_ABERTURA==")){
                            return false;
                        }
                    }
                    //Confere a quinta linha - Perfil
                    if (contadorLinha == 4){
                        if (!linha.contains("USUARIO_LOGADO==")){
                            return false;
                        }
                    }
                    if (contadorLinha == 5){
                        if (!linha.contains("CERTIFICADO==")){
                            return false;
                        }
                    } 
                    if (contadorLinha == 6){
                        if (!linha.contains("SENHA_CERTIFICADO==")){
                            return false;
                        }
                    } 
                    contadorLinha++;
                }    
                reader.close();            
                return estaCorreto;
            }catch(IOException ex){
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível localizar o arquivo Config.ini!","Falta Informação","erro");
                return estaCorreto;
            }
    }
    
    public void apagaArquivoConfigIni(){
            //Codigo abaixo delete a pasta
            boolean success = (new File("C:/DSistema/Config.ini")).delete();
            if (success == true){
                //JOptionPane.showMessageDialog(null, "Arquivos excluidos com Sucesso!");
            }else{
                //JOptionPane.showMessageDialog(null, "Não excluiu!");
            }

    }
    
    
    public void alteraLinha(String palavraAntiga, String palavraNova) throws IOException {
        String caminhoBD = retornaCaminhoBDnoConfig();
        String perfil = retornaPerfilnoConfig();
        String data = retornaDataUltimaAberturaNoConfig();
        String hora = retornaHoraUltimaAberturaNoConfig();
        String usuario = retornaUsuarioLogadoNoConfig();
        
        /**
        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O caminho salvo no config é:"+caminhoBD);
        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O perfil salvo no config é:"+perfil);
        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O data salvo no config é:"+data);
        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O hora salvo no config é:"+hora);
        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O usuario salvo no config é:"+usuario);
        */ 
        
        String caminhoBD1 = "CAMINHOBD=="+caminhoBD;
        String perfil1 = "PERFIL=="+perfil;
        String data1 = "DATA_ULTIMA_ABERTURA=="+data;
        String hora1 = "HORA_ULTIMA_ABERTURA=="+hora;
        String usuario1 = "USUARIO_LOGADO=="+usuario;
        
            //renovar nova sequencia colocando o escolhido no inicio
            String nomeDoArquivo = "c:\\DSistema\\Config.ini";
            BufferedWriter buffWrite = null; 
            try {                
                buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));
                int linha = 0;
                /**                 
                CAMINHOBD==
                PERFIL==
                DATA_ULTIMA_ABERTURA==
                HORA_ULTIMA_ABERTURA==
                USUARIO_LOGADO==                  
                */
                while (linha<5) {
                    if (linha==0){
                        if (caminhoBD1.contains(palavraAntiga)){
                            buffWrite.write("CAMINHOBD=="+palavraNova);
                            buffWrite.newLine();
                        }else{
                            buffWrite.write("CAMINHOBD=="+caminhoBD);
                            buffWrite.newLine();
                        }
                    }
                    if (linha==1){
                        if (perfil1.contains(palavraAntiga)){
                            buffWrite.write("PERFIL=="+palavraNova);
                            buffWrite.newLine();
                        }else{
                            buffWrite.write("PERFIL=="+perfil);
                            buffWrite.newLine();
                        }
                    }
                    if (linha==2){
                        if (data1.contains(palavraAntiga)){
                            buffWrite.write("DATA_ULTIMA_ABERTURA=="+palavraNova);
                            buffWrite.newLine();
                        }else{
                            buffWrite.write("DATA_ULTIMA_ABERTURA=="+data);
                            buffWrite.newLine();
                        }
                    }
                    if (linha==3){
                        if (hora1.contains(palavraAntiga)){
                            buffWrite.write("HORA_ULTIMA_ABERTURA=="+palavraNova);
                            buffWrite.newLine();
                        }else{
                            buffWrite.write("HORA_ULTIMA_ABERTURA=="+hora);
                            buffWrite.newLine();
                        }
                    }
                    if (linha==4){
                        if (usuario1.contains(palavraAntiga)){
                            buffWrite.write("USUARIO_LOGADO=="+palavraNova);
                            buffWrite.newLine();
                        }else{
                            buffWrite.write("USUARIO_LOGADO=="+usuario);
                            buffWrite.newLine();
                        }
                    }
                    linha++;
                }
                buffWrite.close();
                //JOptionPane.showMessageDialog(null, "Config atualizado!");
            } catch (IOException ex) {
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "O Windows não deixou modificar o arquivo Config.ini!","Falta Informação","erro");
            }
        
    }
    
    public boolean verificaSeTemArquivoConfiguracaoNFE(String CNPJ){
            File arquivo = new File("C:/DSistema/NFE/ConfiguracaoNFE.ini"); // ajfilho é uma pasta!
            if (!arquivo.exists()) {
               //JOptionPane.showMessageDialog(null, "Diretório não existe!");
                criaArquivoConfiguracaoNFE(CNPJ);
               return false;
            } else {
               //JOptionPane.showMessageDialog(null, "Diretório já existente!");
               return true;
            }
    }
    
    public String retornaCaminhoCertificadonoConfig() throws IOException {
        String caminho = "";    
        try{
                String arquivo = "C:/DSistema/NFE/ConfiguracaoNFE.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                /**                 
                CNPJ==
                CAMINHO_CERTIFICADO==
                SENHA_CERTIFICADO==
                TIPO_CERTIFICADO==
                CSC==
                */                
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 1){
                        caminho = linha;
                    }
                    contadorLinha++;
                }    
                reader.close(); 
                caminho = caminho.replace("CAMINHO_CERTIFICADO==", "");
                return caminho;
            }catch(IOException ex){
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!","Falta Informação","erro");
                verificaSeTemArquivoConfiguracaoNFE("");
                return caminho;
            }
    }
    
    public String retornaSenhaCertificadonoConfig() throws IOException {
        String senha = "";    
        try{
                String arquivo = "C:/DSistema/NFE/ConfiguracaoNFE.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                /**                 
                CNPJ==
                CAMINHO_CERTIFICADO==
                SENHA_CERTIFICADO==
                TIPO_CERTIFICADO==
                CSC==
                */                
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 2){
                        senha = linha;
                    }
                    contadorLinha++;
                }    
                reader.close(); 
                senha = senha.replace("SENHA_CERTIFICADO==", "");
                return senha;
            }catch(IOException ex){
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!","Falta Informação","erro");
                verificaSeTemArquivoConfiguracaoNFE("");
                return senha;
            }
    }
    
    public String retornaCSCnoConfig() throws IOException {
        String csc = "";    
        try{
                String arquivo = "C:/DSistema/NFE/ConfiguracaoNFE.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                /**                 
                CNPJ==
                CAMINHO_CERTIFICADO==
                SENHA_CERTIFICADO==
                TIPO_CERTIFICADO==
                CSC==
                */                
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 4){
                        csc = linha;
                    }
                    contadorLinha++;
                }    
                reader.close(); 
                csc = csc.replace("CSC==", "");
                return csc;
            }catch(IOException ex){
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!","Falta Informação","erro");
                verificaSeTemArquivoConfiguracaoNFE("");
                return csc;
            }
    }
    
    public String retornaIdTokennoConfig() throws IOException {
        String idToken = "";    
        try{
                String arquivo = "C:/DSistema/NFE/ConfiguracaoNFE.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                /**                 
                CNPJ==
                CAMINHO_CERTIFICADO==
                SENHA_CERTIFICADO==
                TIPO_CERTIFICADO==
                CSC==
                ID_TOKEN==
                */                
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 5){
                        idToken = linha;
                    }
                    contadorLinha++;
                }    
                reader.close(); 
                idToken = idToken.replace("ID_TOKEN==", "");
                return idToken;
            }catch(IOException ex){
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!","Falta Informação","erro");
                verificaSeTemArquivoConfiguracaoNFE("");
                return idToken;
            }
    }
    
    public String retornaNomeDoComputador(){
        String nomePC = "";
        try {
            nomePC = InetAddress.getLocalHost().getHostName();
            //System.out.println(InetAddress.getLocalHost().getHostName());
            //System.out.println(InetAddress.getLocalHost().getHostAddress());
          } catch (UnknownHostException e) {
            e.printStackTrace();
          }
        return nomePC;
    }
    
    public String retornaIpDoComputador(){
        String ipPC = "";
        try {
            ipPC = InetAddress.getLocalHost().getHostAddress();
            //System.out.println(InetAddress.getLocalHost().getHostName());
            //System.out.println(InetAddress.getLocalHost().getHostAddress());
          } catch (UnknownHostException e) {
            e.printStackTrace();
          }
        return ipPC;
    }
    
    public ArrayList<String> RetornaNomes(){
        ArrayList<String> nomes = new ArrayList<String>();
        try { 
            FileReader arq = new FileReader("c:\\DSistema\\Nomes.dr");
            BufferedReader lerArq = new BufferedReader(arq);  
            String linha = lerArq.readLine();
            while (linha != null) {
                if (!linha.equals("")){
                    nomes.add(linha); 
                }
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close(); 
            } catch (IOException e) { 
                //XXXXXXXXXXXXXXXnull, "Caminho do BD não encontrado ou Computador não configurado!");
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Arquivo nomes.ini não encontrato ou com problemas!", "Falta informação","erro");
            }
        return nomes;
    }
    
    public void cadastraNoArquivo(String NomeNovo){
        ArrayList<String> Nomes = RetornaNomes();
        Nomes.add(NomeNovo);
        String nomeDoArquivo = "c:\\DSistema\\Nomes.dr";
        File f = new File(nomeDoArquivo);
        f.delete();
        BufferedWriter buffWrite = null;
        try {
            buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));
            for (int i = 0; i < Nomes.size(); i++) {
                buffWrite.write((String) Nomes.get(i));
                buffWrite.newLine();
            }
            buffWrite.close();
        } catch (IOException ex) {
            //XXXXXXXXXXXXXXXnull, "O Windows não deixou criar o arquivo do Caminho BD!");
            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("O Windows não deixou alterar Nomes.dr!", "Falta informação","erro");
        } 
    }
    
    public void removerNoArquivo(String NomeNovo){
        ArrayList<String> Nomes = RetornaNomes();
        Nomes.remove(NomeNovo);
        String nomeDoArquivo = "c:\\DSistema\\Nomes.dr";
        File f = new File(nomeDoArquivo);
        f.delete();
        BufferedWriter buffWrite = null;
        try {
            buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));
            for (int i = 0; i < Nomes.size(); i++) {
                buffWrite.write((String) Nomes.get(i));
                buffWrite.newLine();
            }
            buffWrite.close();
        } catch (IOException ex) {
            //XXXXXXXXXXXXXXXnull, "O Windows não deixou criar o arquivo do Caminho BD!");
            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("O Windows não deixou alterar Nomes.dr!", "Falta informação","erro");
        } 
    }
    
}
