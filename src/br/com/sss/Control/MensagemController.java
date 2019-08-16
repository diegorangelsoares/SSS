/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

import br.com.sss.View.JanelaConfiguracao;
import br.com.sss.model.Mensagem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author DIEGO
 */
public class MensagemController {
    
    String enderecoBanco = "10.20.100.23";
    String servicoBanco = "ATEND";
    String usuarioBanco = "sup_infomed";
    String senhaBanco = "gps$$$";
    
    ArquivoConfiguracao arquivoConfiguracao = new ArquivoConfiguracao();
    public GeraTXT GeradorTXT = new GeraTXT();
    
    MensagemErro mensagemErro = new MensagemErro();
    
    public Connection con1;
    
    public Statement AbreConexaoBancoOracle(){
        OracleDataSource ods;
        try {
            //try {
            ods = new OracleDataSource();
       
        
            ods.setURL("jdbc:oracle:thin:@//"+enderecoBanco+":1521/"+servicoBanco+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
            ods.setUser(usuarioBanco); // [nome do usuário]
            ods.setPassword(senhaBanco); // [senha]
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
                                                 + "- Verifique se o servidor Oracle está ligado '"+enderecoBanco+"'\n"
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
    
    public List RetornaMensagensDoProtocolo( String protocolo){

        List<Mensagem> mensagensDoProtocolo = new ArrayList<Mensagem>();
            OracleDataSource ods;
            //jdbc:oracle:thin:@//"+caminho+":1521/XE
            try {
                ods = new OracleDataSource();
                String porta = "1521";
                ods.setURL("jdbc:oracle:thin:@//"+enderecoBanco+":"+porta+"/"+servicoBanco+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
                ods.setUser(usuarioBanco); // [nome do usuário]
                ods.setPassword(senhaBanco); // [senha]
                Connection conn = ods.getConnection();
                //JOptionPane.showMessageDialog(null, "Antes do select");
                PreparedStatement stmt = conn.prepareStatement("select mens.protocolo,\n" +
                                                        "       mens.data,\n" +
                                                        "       mens.recurso,\n" +
                                                        "       mens.mensagem \n" +
                                                        "       from info_atend_255.tmp_siscon prot, info_atend_255.tmp_siscon_mensagens mens\n" +
                                                        "       where prot.protocolo = mens.protocolo\n" +
                                                        "       and prot.protocolo = "+protocolo +" order by mens.data");
          
                ResultSet rs = stmt.executeQuery();
                //Preenche os dados no formulario
                //JOptionPane.showMessageDialog(null, "Antes do while");
                while (rs.next()){
                    String PROTOCOLO = rs.getString("PROTOCOLO");
                    String data = rs.getString("data");
                    String recurso = rs.getString("recurso");
                    String mensagem = rs.getString("mensagem");
                    Mensagem men = new Mensagem(0, PROTOCOLO, data, recurso, mensagem);
                    mensagensDoProtocolo.add(men);
                }
                //JOptionPane.showMessageDialog(null, "Fim do while");
                //FechaConexaoBanco(conn);
                //JOptionPane.showMessageDialog(null, "Fechou conexao");
            }catch( SQLException e){ //trata os erros SQL
                //Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null,"Erro:\n\n"
                                                 + e.getMessage());
            }    
            //JOptionPane.showMessageDialog(null, "fim antes do return");
            return mensagensDoProtocolo;
    }
    
    public String RetornaNomeAtendente( String recurso){
            String nome = recurso;
            OracleDataSource ods;
            try {
                ods = new OracleDataSource();
                String porta = "1521";
                ods.setURL("jdbc:oracle:thin:@//"+enderecoBanco+":"+porta+"/"+servicoBanco+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
                ods.setUser(usuarioBanco); // [nome do usuário]
                ods.setPassword(senhaBanco); // [senha]
                Connection conn = ods.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from info_atend_255.tmp_siscon_atendente ate\n" +
                                                                    "where ate.recurso="+recurso);
                ResultSet rs = stmt.executeQuery();
                //Preenche os dados no formulario
                while (rs.next()){
                    nome = rs.getString("NOME");
                    
                }
            }catch( SQLException e){ //trata os erros SQL
                JOptionPane.showMessageDialog(null,"Erro ao RetornaNomeAtendente:\n\n"
                                                 + e.getMessage());
            }    
            //JOptionPane.showMessageDialog(null, "fim antes do return");
            return nome;
    }
    
    public String retornaWhereParaQeuisarVarios(String textoDigitado){
        
        String where  = "";
        
        //textoDigitado = "Tiss diego Recife";
         
        String[] palavras = textoDigitado.split(" "); //cria array com palavra da frase
        
        List <String> termosParaPesquisar = new ArrayList<String>();
         
        String maiorPalavra = "";
        for (String palavra : palavras) {
//            if (palavra.length() > maiorPalavra.length()) { //se palavra atual é maior que a última maior palavra?
//                maiorPalavra = palavra;
//            }
            termosParaPesquisar.add("AND UPPER(mens.mensagem) LIKE '%"+palavra+"%'");
            // AND UPPER(prot.resumo) LIKE '%TextoParaPesquisar%' 
        }
        
        if (termosParaPesquisar == null){
            //System.out.println("Não digitou nada!");
        }else{
            for (int i = 0; i < termosParaPesquisar.size(); i++) {
                //System.out.println("Termo: "+termosParaPesquisar.get(i));
            }
        }

        if (palavras.length == 1){
            where = " where "+ termosParaPesquisar.get(0).replace("AND ", "");
            System.out.println("Where : "+where);
        }else{
            where = " where ";
            for (int i = 0; i < termosParaPesquisar.size(); i++) {
                if (i == 0){
                    where = where + termosParaPesquisar.get(i).replace("AND ", "");
                }else{
                    where = where + termosParaPesquisar.get(i);
                }
                
            }
            System.out.println("Where : "+where);
        }
        //Tem que retornar where AND UPPER(prot.resumo) LIKE '%"+palavra+"%'
        System.out.println("Where : "+where);
        return where;
    }
    
    /**Código abaixo lê o arquivo CSV
	* @author Diego Rangel
	* @param  filePath - Caminho do arquivo CSV
	* @param  separatorCSV - Tipo de serparador - Identificardor das colunas Ex.: ; , .
	* @return List <Combustivel> - Lista com todos os registros de combustíveis do arquivo
	*/
	public List <Mensagem> loadCSV (String filePath, String separatorCSV){   
		List <Mensagem> mensagens = new ArrayList<>();
            BufferedReader br = null;
            String line = "";
            try {
                br = new BufferedReader(new FileReader(filePath));
                int contadorLinha = 0;
                while ((line = br.readLine()) != null) {
                    // Usar o separador
                    String[] column = line.split(separatorCSV);           
                    //Não pegar linha 0
                    System.out.println("Tamanho: "+column.length);
                    System.out.println("Carregando informações do arquivo linha "+contadorLinha+", aguarde..!");
                    String trechoInicial = line.substring(0, 1);
                    System.out.println("Trecho inicial: "+trechoInicial);
                    String protocolo = column[0];
                    String data = column[1];
                    String recurso = column[2];
                    String mensagem = column[3];
                    Mensagem me = new Mensagem(0, protocolo, data, recurso, mensagem);
                    mensagens.add(me);
                    System.out.println("Mensagem\nProtocolo: "+me.getProtocolo());
                  
                    
                    contadorLinha++;
                }
                System.out.println("Informações carregadas com sucesso!");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return mensagens;
    }
        
        public List <Mensagem> VerArquivoDeMensagensSiscon (String filePath, String separatorCSV){   
            List <Mensagem> mensagens = new ArrayList<>();
            BufferedReader br = null;

            try { 
                br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MensagemController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MensagemController.class.getName()).log(Level.SEVERE, null, ex);
            }

            String line = "";
            String protocoloAnterior = "";
            try {
                //br = new BufferedReader(new FileReader(filePath));
                //in = new BufferedReader(new FileReader(filePath));
                int contadorLinha = 0;
                while ((line = br.readLine()) != null) {
                    if (contadorLinha != 0){
                        System.out.println("Linha: "+contadorLinha);
                        // Usar o separador
                        String[] column = line.split(separatorCSV);           
                        //Não pegar linha 0
                        //System.out.println("Tamanho: "+column.length);
    //                    if (column.length > 1){
    //                        
    //                    }
                        String trechoInicial = line.substring(0, 0);
                        //System.out.println("Trecho inicial: "+trechoInicial);
                        if (column.length >= 1){
                            //Contem as 4 colunas corretas
                            if (column.length == 4){
//                                System.out.println("Numero da Linha: "+contadorLinha);
//                                System.out.println("Linha: "+line);
                                //if (verificaSeNumero(trechoInicial) == true){
                                //Contem numero, entao eh uma nova mensagem
                                String protocolo = column[0];
                                String data = column[1];
                                String recurso = column[2];
                                String mensagem = column[3];
                                mensagem = mensagem.replace("'", "");
                                Mensagem me = new Mensagem(contadorLinha, protocolo, data, recurso, mensagem);
                                mensagens.add(me);
                                protocoloAnterior = protocolo;
//                                System.out.println("Protocolo adicionado: "+me.getProtocolo());    
                            }
                            //Contem 3 colunas
                            if (column.length == 3){
//                                System.out.println("Numero da Linha: "+contadorLinha);
//                                System.out.println("Linha: "+line);
                                //if (verificaSeNumero(trechoInicial) == true){
                                //Contem numero, entao eh uma nova mensagem
                                String protocolo = column[0];
                                String data = column[1];
                                String recurso = column[2];
                                //String mensagem = column[3];
                                Mensagem me = new Mensagem(contadorLinha, protocolo, data, recurso, "");
                                mensagens.add(me);
                                protocoloAnterior = protocolo;
//                                System.out.println("Protocolo adicionado: "+me.getProtocolo());    
                            }
                            /**else{
                                  editarMensagemAnterior(line,mensagens,protocoloAnterior);
                                  System.out.println("Alterou Protocolo anterior.");
                            } */
                            if (column.length == 1){
                                editarMensagemAnterior(contadorLinha-1,line,mensagens,protocoloAnterior);
//                                System.out.println("Alterou Protocolo anterior.");
                            }
                            
                            

                        }else{
                            //é Continuacao da mensagem anterior
                            editarMensagemAnterior(contadorLinha-1,line,mensagens,protocoloAnterior);
//                            System.out.println("Alterou Protocolo anterior.");
                        }


                    }
                    contadorLinha++;
                    
                }
//                System.out.println("Informações carregadas com sucesso!");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return mensagens;
    }
        
    public void editarMensagemAnterior(int idMensagemAnterior, String mensagem, List<Mensagem> Mens, String protocolo) {
            if (mensagem == null){
                //mensagem veio em branco
            }else{
                boolean encontrou = false;
                //idMensagemAnterior = verificaSeExisteIdDaMensagemAnteriorPAraDecrementar(idMensagemAnterior,Mens);
                while (verificaSeExisteIdDaMensagemAnteriorPAraDecrementar(idMensagemAnterior,Mens) == false || idMensagemAnterior == 0){
                    idMensagemAnterior--;
                }
                for (int i = 0; i < Mens.size(); i++) {
//                    System.out.println("Busca mensagem do id:"+idMensagemAnterior+" para alterar.");
                     if (Mens.get(i).getId() == idMensagemAnterior && Mens.get(i).getProtocolo().equals(protocolo)) {
                          // mesmo identificador, então atualiza os valores
                          Mens.get(i).setMensagem(Mens.get(i).getMensagem() + "\n"+ mensagem.replace("'", ""));
//                          System.out.println("Mensagem: "+Mens.get(i).getMensagem()+" alterada para : "+Mens.get(i).getMensagem() + "\n"+ mensagem);
                          encontrou = true;
                          break;
                     }
                }

                // Caso não encontrar pra atualizar, adiciona na lista como um novo (opcional)
//                if (!encontrou) {
//                    Mens.add(mensagem);
//                }
            }
    }
    
    public boolean verificaSeExisteIdDaMensagemAnteriorPAraDecrementar(int idMensagemAnterior, List<Mensagem> Mens) {
            boolean retorno = false;
            if (idMensagemAnterior == 0){
                retorno = false;
            }else{
                if (Mens == null){
                    //mensagem veio em branco
                    retorno = false;
                }else{
                    boolean encontrou = false;
                    int contador = 0;
                    while (contador < Mens.size()){
                        if (Mens.get(contador).getId() == idMensagemAnterior) {
                            retorno = true;
                        }
                        contador++;
                    }
                    

                }
                
            }
            return retorno;
    }
        
    public boolean verificaSeNumero(String texto){
        if (texto.contains("0") || texto.contains("1") || texto.contains("2") || texto.contains("3") || texto.contains("4") || texto.contains("5") || texto.contains("6") || texto.contains("7") || texto.contains("8") || texto.contains("9")){
            return true;
        }else{
            return false;
        }
    }
        
    public void InserirMensagens(List<Mensagem> mensagens, String tabela){              
        OracleDataSource ods;
        for (int i = 0; i < mensagens.size(); i++) {
            try {
                ods = new OracleDataSource();
                String porta = "1521";
                ods.setURL("jdbc:oracle:thin:@//"+enderecoBanco+":"+porta+"/"+servicoBanco+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
                ods.setUser(usuarioBanco); // [nome do usuário]
                ods.setPassword(senhaBanco); // [senha]
                Connection conn = ods.getConnection();
                //JOptionPane.showMessageDialog(null, "Antes do select");
                String sql = "insert into info_atend_255."+tabela+" (protocolo,data,recurso,mensagem) values ('"+mensagens.get(i).getProtocolo()+"','"+mensagens.get(i).getData()+"','"+mensagens.get(i).getRecurso()+"','"+mensagens.get(i).getMensagem()+"')";
                //JOptionPane.showMessageDialog(null, "Antes do select");
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();              
            }  catch( SQLException e){ //trata os erros SQL
                //criaArquivoErroEEnviaEmail(e, "InserirCliente");
            }
        }
        JOptionPane.showMessageDialog(null, "Fim da inserção");
    }
    
    public void ApagarMensagens(JanelaConfiguracao j){
        try {
                String porta = "1521";
                Connection connection = null;  
                // Load the JDBC driver  
                String driverName = "oracle.jdbc.driver.OracleDriver";  
                Class.forName(driverName);  
                String url = "jdbc:oracle:thin:@" + enderecoBanco + ":" + porta + ":" + servicoBanco;  
                connection = DriverManager.getConnection(url, usuarioBanco, senhaBanco);  

                String sql = "delete INFO_ATEND_255."+j.campoNomeTabela1.getText();
                Statement stmt = connection.createStatement();  
                
                // Execute the insert statement  
                stmt.executeUpdate(sql); 
                connection.commit();
                JOptionPane.showMessageDialog(null, "Mensagens deletadas!");
                
            }  catch( SQLException e){ //trata os erros SQL
                criaArquivoErroEEnviaEmail(e, "ApagarMensagens");
            }   catch (ClassNotFoundException ex) {
                Logger.getLogger(MensagemController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void InserirMensagensDoGride(JanelaConfiguracao j){              
        int totalDeLinhas = j.jTable2.getModel().getRowCount();
        int linha =0;
        String sql = "";
        if (totalDeLinhas < 1){
            //sem nada na grade
            JOptionPane.showMessageDialog(null, "Nada na tabela para importar!");
        }else{
            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
            
            double totalGeral = 0;
            while (linha < totalDeLinhas ){  
            try {
                String porta = "1521";
                Connection connection = null;  
                // Load the JDBC driver  
                String driverName = "oracle.jdbc.driver.OracleDriver";  
                Class.forName(driverName);  
                String url = "jdbc:oracle:thin:@" + enderecoBanco + ":" + porta + ":" + servicoBanco;  
                connection = DriverManager.getConnection(url, usuarioBanco, senhaBanco);  

                //JOptionPane.showMessageDialog(null, "Antes do select");
                String protocolo = (String) j.jTable2.getValueAt(linha, 1);
                if (verificaSeNumero(protocolo) == true){
                    int  prot = Integer.parseInt(protocolo);
                    String data = (String) j.jTable2.getValueAt(linha, 2);
                    String recurso = (String) j.jTable2.getValueAt(linha, 3);
                    int rec = Integer.parseInt(recurso);
                    String mensagem = (String) j.jTable2.getValueAt(linha, 4);
                    mensagem = mensagem.replace("'", "");
                    if (mensagem.length() >= 4000){
                        mensagem = mensagem.substring(0, 3999);
                    }
                    Mensagem m = new Mensagem(0, protocolo, data, recurso, mensagem);
                    sql = "insert into INFO_ATEND_255."+j.campoNomeTabela1.getText()+" values ('"+prot+"',to_date('"+m.getData()+"', 'dd/mm/yyyy hh24:mi:ss'),"+rec+",'"+m.getMensagem()+"')";
                    Statement stmt = connection.createStatement();  

                    // Execute the insert statement  
                    stmt.executeUpdate(sql); 
                    connection.commit();
                    j.jTable2.setValueAt(false, linha, 5);
                }else{
                    j.jTable2.setValueAt(true, linha, 5);
                }
            }  catch( SQLException e){ //trata os erros SQL
                criaArquivoErroEEnviaEmail(e, "InserirMensagensDoGride - Inserindo linha:"+linha+"\n\nSQL: \n"+sql);
            }   catch (ClassNotFoundException ex) {
                Logger.getLogger(MensagemController.class.getName()).log(Level.SEVERE, null, ex);
            }
            linha++;
        }
        JOptionPane.showMessageDialog(null, "Fim da inserção");
        }
    }
    
    public void criaArquivoErroEEnviaEmail(SQLException ex, String nomeFuncao){
        String nomeDoArquivo = GeradorTXT.GeraTxtDeErro("Erro Cmdo SQL " + ex.getMessage()+" Ao "+nomeFuncao);
        String textoDoEmailDeErro = "Erro no Comando SQL: " + ex.getMessage()+" Ao executar a função: "+nomeFuncao+"\n\nVersão do Sistema: "+"1.0.0.1";
        //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Erro - Contate o desenvolvedor!");
        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro - Contate o desenvolvedor!", "Desculpe-me pelo Erro","erro");
        //email.enviarEmailDoErro("INFOMED","Registro de erro do sistema" , nomeDoArquivo,"1.0.0.1");
    }
    

    
    
}
