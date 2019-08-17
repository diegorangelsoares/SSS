/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

import br.com.sss.EMail.DrMail;
import br.com.sss.model.Protocolo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author DIEGO
 */
public class ProtocoloController {
    
    String enderecoBanco = "10.20.100.23";
    String servicoBanco = "ATEND";
    String usuarioBanco = "sup_infomed";
    String senhaBanco = "gps$$$";
    public GeraTXT GeradorTXT = new GeraTXT();
    MensagemErro mensagemErro = new MensagemErro();
    public DrMail email = new DrMail();
    
    public Connection con1;
    
    ControllerArquivo arquivoConfiguracao = new ControllerArquivo();
    
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
            Logger.getLogger(ControllerGeral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List buscaProtocolosComOperadoraComAtendente( String TextoParaPesquisar, String Operadora, String Atendente){
        TextoParaPesquisar = TextoParaPesquisar.toUpperCase();
        Operadora = Operadora.toUpperCase();
        Atendente = Atendente.toUpperCase();
        List<Protocolo> protocolosPequisados = new ArrayList<Protocolo>();
            OracleDataSource ods;
            int quantidadeRegistros = 10;
            TextoParaPesquisar = TextoParaPesquisar.replace(" ", "%");
            //jdbc:oracle:thin:@//"+caminho+":1521/XE
            try {
                ods = new OracleDataSource();
                String porta = "1521";
                ods.setURL("jdbc:oracle:thin:@//"+enderecoBanco+":"+porta+"/"+servicoBanco+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
                ods.setUser(usuarioBanco); // [nome do usuário]
                ods.setPassword(senhaBanco); // [senha]
                Connection conn = ods.getConnection();
                //JOptionPane.showMessageDialog(null, "Antes do select");
                //PreparedStatement stmt = conn.prepareStatement("select * from info_atend_255.tmp_siscon where protocolo=1641048 order by 1 desc");  and ROWNUM <= 5
                PreparedStatement stmt = conn.prepareStatement("select * from info_atend_255.tmp_siscon prot where upper(prot.resumo) like '%"+TextoParaPesquisar+"%' and upper(prot.cliente) like '%"+Operadora+"%' and upper(prot.atendente) like '%"+Atendente+"%' order by 1 desc");
          
                ResultSet rs = stmt.executeQuery();
                //Preenche os dados no formulario
                //JOptionPane.showMessageDialog(null, "Antes do while");
                while (rs.next()){
                    String PROTOCOLO = rs.getString("PROTOCOLO");
                    String SISTEMA = rs.getString("SISTEMA");
                    String RECURSO = rs.getString("RECURSO");
                    String PESSOA = rs.getString("PESSOA");
                    String RESUMO = rs.getString("RESUMO");
                    String VERSAO = rs.getString("VERSAO");
                    String DATAENTRADA = rs.getString("DATAENTRADA");
                    String SMS = rs.getString("SMS");
                    String CLASSIFICACAO = rs.getString("CLASSIFICACAO");
                    String SITUACAO = rs.getString("SITUACAO");
                    String RESPONSAVEL = rs.getString("RESPONSAVEL");
                    String CLIENTE = rs.getString("CLIENTE");
                    String SLA = rs.getString("SLA");
                    String USERALTERACAO = rs.getString("USERALTERACAO");
                    String HOMOLOGAR = rs.getString("HOMOLOGAR");
                    String ULTIMAALTERACAO = rs.getString("ULTIMAALTERACAO");
                    String PRAZOENTREGA = rs.getString("PRAZOENTREGA");
                    String ATEND = rs.getString("ATEND");
                    String ATENDENTE = rs.getString("ATENDENTE");
                    String PRAZOSLA = rs.getString("PRAZOSLA");
                    Protocolo protocolo = new Protocolo(0,PROTOCOLO,SISTEMA,RECURSO,PESSOA,RESUMO,VERSAO,DATAENTRADA,SMS,CLASSIFICACAO,SITUACAO,RESPONSAVEL,CLIENTE,SLA,USERALTERACAO,HOMOLOGAR,ULTIMAALTERACAO,PRAZOENTREGA,ATEND,ATENDENTE,PRAZOSLA);
                    protocolosPequisados.add(protocolo);
                }
                //JOptionPane.showMessageDialog(null, "Fim do while");
                //FechaConexaoBanco(conn);
                //JOptionPane.showMessageDialog(null, "Fechou conexao");
            }catch( SQLException e){ //trata os erros SQL
                //Logger.getLogger(ControllerGeral.class.getName()).log(Level.SEVERE, null, e);
//                JOptionPane.showMessageDialog(null,"Erro:\n\n"
//                                                 + e.getMessage());
                criaArquivoErroEEnviaEmail(e, "buscaProtocolosComOperadoraComAtendente");
            }    
            //JOptionPane.showMessageDialog(null, "fim antes do return");
            return protocolosPequisados;
    }
    
    public List buscaProtocolosSimples( String TextoParaPesquisar){
        TextoParaPesquisar = TextoParaPesquisar.toUpperCase();
        List<Protocolo> protocolosPequisados = new ArrayList<Protocolo>();
            OracleDataSource ods;
            int quantidadeRegistros = 10;
            TextoParaPesquisar = TextoParaPesquisar.replace(" ", "%");
            //jdbc:oracle:thin:@//"+caminho+":1521/XE
            try {
                ods = new OracleDataSource();
                String porta = "1521";
                ods.setURL("jdbc:oracle:thin:@//"+enderecoBanco+":"+porta+"/"+servicoBanco+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
                ods.setUser(usuarioBanco); // [nome do usuário]
                ods.setPassword(senhaBanco); // [senha]
                Connection conn = ods.getConnection();
                //JOptionPane.showMessageDialog(null, "Antes do select");
                //PreparedStatement stmt = conn.prepareStatement("select * from info_atend_255.tmp_siscon where protocolo=1641048 order by 1 desc");  and ROWNUM <= 5
                PreparedStatement stmt = conn.prepareStatement("select * from info_atend_255.tmp_siscon prot where upper(prot.resumo) like '%"+TextoParaPesquisar+"%' order by 1 desc");
          
                ResultSet rs = stmt.executeQuery();
                //Preenche os dados no formulario
                //JOptionPane.showMessageDialog(null, "Antes do while");
                while (rs.next()){
                    String PROTOCOLO = rs.getString("PROTOCOLO");
                    String SISTEMA = rs.getString("SISTEMA");
                    String RECURSO = rs.getString("RECURSO");
                    String PESSOA = rs.getString("PESSOA");
                    String RESUMO = rs.getString("RESUMO");
                    String VERSAO = rs.getString("VERSAO");
                    String DATAENTRADA = rs.getString("DATAENTRADA");
                    String SMS = rs.getString("SMS");
                    String CLASSIFICACAO = rs.getString("CLASSIFICACAO");
                    String SITUACAO = rs.getString("SITUACAO");
                    String RESPONSAVEL = rs.getString("RESPONSAVEL");
                    String CLIENTE = rs.getString("CLIENTE");
                    String SLA = rs.getString("SLA");
                    String USERALTERACAO = rs.getString("USERALTERACAO");
                    String HOMOLOGAR = rs.getString("HOMOLOGAR");
                    String ULTIMAALTERACAO = rs.getString("ULTIMAALTERACAO");
                    String PRAZOENTREGA = rs.getString("PRAZOENTREGA");
                    String ATEND = rs.getString("ATEND");
                    String ATENDENTE = rs.getString("ATENDENTE");
                    String PRAZOSLA = rs.getString("PRAZOSLA");
                    Protocolo protocolo = new Protocolo(0,PROTOCOLO,SISTEMA,RECURSO,PESSOA,RESUMO,VERSAO,DATAENTRADA,SMS,CLASSIFICACAO,SITUACAO,RESPONSAVEL,CLIENTE,SLA,USERALTERACAO,HOMOLOGAR,ULTIMAALTERACAO,PRAZOENTREGA,ATEND,ATENDENTE,PRAZOSLA);
                    protocolosPequisados.add(protocolo);
                }
                //JOptionPane.showMessageDialog(null, "Fim do while");
                //FechaConexaoBanco(conn);
                //JOptionPane.showMessageDialog(null, "Fechou conexao");
            }catch( SQLException e){ //trata os erros SQL
                //Logger.getLogger(ControllerGeral.class.getName()).log(Level.SEVERE, null, e);
//                JOptionPane.showMessageDialog(null,"Erro:\n\n"
//                                                 + e.getMessage());
                criaArquivoErroEEnviaEmail(e, "buscaProtocolosSimples");
            }    
            //JOptionPane.showMessageDialog(null, "fim antes do return");
            return protocolosPequisados;
    }
    
    public List buscaProtocolosDinamico( String TextoParaPesquisar, String mensagem, String Operadora, String Atendente){
        TextoParaPesquisar = TextoParaPesquisar.toUpperCase();
        Operadora = Operadora.toUpperCase();
        Atendente = Atendente.toUpperCase();
        String where = retornaWhereParaQeuisarVarios(TextoParaPesquisar);
        if (where.equals("")){
            
        }
        String whereMensagem = retornaWhereParaMensagens(mensagem);
        //String query = "select * from info_atend_255.tmp_siscon prot "+where+" order by 1 desc";
        
        String query = "select distinct(prot.protocolo) , prot.DATAENTRADA, prot.cliente, prot.resumo \n" +
                    "       from info_atend_255.tmp_siscon prot, info_atend_255.tmp_siscon_mensagens mens\n" +
                    "       where prot.protocolo = mens.protocolo "
                  + " and upper(prot.cliente) like '%"+Operadora+"%' " +
                    "       and upper(prot.Atendente) like '%"+Atendente+"%'"
                  + "" + where + " " + whereMensagem + " group by prot.protocolo, prot.DATAENTRADA, prot.cliente, prot.resumo";
        
        //arquivoConfiguracao.criArquivoDeSelect(query);
        System.out.println("SQL da consulta: "+query);
        //JOptionPane.showMessageDialog(null, "SQL da consulta: "+query);
        List<Protocolo> protocolosPequisados = new ArrayList<Protocolo>();
            OracleDataSource ods;
            int quantidadeRegistros = 10;
            //TextoParaPesquisar = TextoParaPesquisar.replace(" ", "%");
            //jdbc:oracle:thin:@//"+caminho+":1521/XE
            try {
                ods = new OracleDataSource();
                String porta = "1521";
                ods.setURL("jdbc:oracle:thin:@//"+enderecoBanco+":"+porta+"/"+servicoBanco+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
                ods.setUser(usuarioBanco); // [nome do usuário]
                ods.setPassword(senhaBanco); // [senha]
                Connection conn = ods.getConnection();
                
                PreparedStatement stmt = conn.prepareStatement(query);
          
                ResultSet rs = stmt.executeQuery();
                //Preenche os dados no formulario
                //JOptionPane.showMessageDialog(null, "Antes do while");
                while (rs.next()){
                    String PROTOCOLO = rs.getString("PROTOCOLO");
                    //String SISTEMA = rs.getString("SISTEMA");
//                    String RECURSO = rs.getString("RECURSO");
//                    String PESSOA = rs.getString("PESSOA");
                    String RESUMO = rs.getString("RESUMO");
//                    String VERSAO = rs.getString("VERSAO");
                    String DATAENTRADA = rs.getString("DATAENTRADA");
//                    String SMS = rs.getString("SMS");
//                    String CLASSIFICACAO = rs.getString("CLASSIFICACAO");
//                    String SITUACAO = rs.getString("SITUACAO");
//                    String RESPONSAVEL = rs.getString("RESPONSAVEL");
                    String CLIENTE = rs.getString("CLIENTE");
//                    String SLA = rs.getString("SLA");
//                    String USERALTERACAO = rs.getString("USERALTERACAO");
//                    String HOMOLOGAR = rs.getString("HOMOLOGAR");
//                    String ULTIMAALTERACAO = rs.getString("ULTIMAALTERACAO");
//                    String PRAZOENTREGA = rs.getString("PRAZOENTREGA");
//                    String ATEND = rs.getString("ATEND");
//                    String ATENDENTE = rs.getString("ATENDENTE");
//                    String PRAZOSLA = rs.getString("PRAZOSLA");
                    Protocolo protocolo = new Protocolo(0,PROTOCOLO,"","","",RESUMO,"",DATAENTRADA,"","","","",CLIENTE,"","","","","","","","");
                    protocolosPequisados.add(protocolo);
                }
                //JOptionPane.showMessageDialog(null, "Fim do while");
                //FechaConexaoBanco(conn);
                //JOptionPane.showMessageDialog(null, "Fechou conexao");
            }catch( SQLException e){ //trata os erros SQL
                //Logger.getLogger(ControllerGeral.class.getName()).log(Level.SEVERE, null, e);
//                JOptionPane.showMessageDialog(null,"Erro:\n\n"
//                                                 + e.getMessage());
                criaArquivoErroEEnviaEmail(e, "buscaProtocolosDinamico");
            }    
            //JOptionPane.showMessageDialog(null, "fim antes do return");
            return protocolosPequisados;
    }
    
    public List buscaProtocolosDinamicoSemMensagens( String TextoParaPesquisar, String Operadora, String Atendente){
        TextoParaPesquisar = TextoParaPesquisar.toUpperCase();
        Operadora = Operadora.toUpperCase();
        Atendente = Atendente.toUpperCase();
        String where = retornaWhereParaQeuisarVarios(TextoParaPesquisar);
        if (where.equals("")){
            
        }
        //String whereMensagem = retornaWhereParaMensagens(mensagem);
        //String query = "select * from info_atend_255.tmp_siscon prot "+where+" order by 1 desc";
        
        String query = "select distinct(prot.protocolo) , prot.DATAENTRADA, prot.cliente, prot.resumo \n" +
                    "       from info_atend_255.tmp_siscon prot\n" +
                    "       where  "
                  + "  upper(prot.cliente) like '%"+Operadora+"%' " +
                    "       and upper(prot.Atendente) like '%"+Atendente+"%'"
                  + "" + where + "  group by prot.protocolo, prot.DATAENTRADA, prot.cliente, prot.resumo";
        
        //arquivoConfiguracao.criArquivoDeSelect(query);
        System.out.println("SQL da consulta: "+query);
        //JOptionPane.showMessageDialog(null, "SQL da consulta: "+query);
        List<Protocolo> protocolosPequisados = new ArrayList<Protocolo>();
            OracleDataSource ods;
            int quantidadeRegistros = 10;
            //TextoParaPesquisar = TextoParaPesquisar.replace(" ", "%");
            //jdbc:oracle:thin:@//"+caminho+":1521/XE
            try {
                ods = new OracleDataSource();
                String porta = "1521";
                ods.setURL("jdbc:oracle:thin:@//"+enderecoBanco+":"+porta+"/"+servicoBanco+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
                ods.setUser(usuarioBanco); // [nome do usuário]
                ods.setPassword(senhaBanco); // [senha]
                Connection conn = ods.getConnection();
                
                PreparedStatement stmt = conn.prepareStatement(query);
          
                ResultSet rs = stmt.executeQuery();
                //Preenche os dados no formulario
                //JOptionPane.showMessageDialog(null, "Antes do while");
                while (rs.next()){
                    String PROTOCOLO = rs.getString("PROTOCOLO");
                    //String SISTEMA = rs.getString("SISTEMA");
//                    String RECURSO = rs.getString("RECURSO");
//                    String PESSOA = rs.getString("PESSOA");
                    String RESUMO = rs.getString("RESUMO");
//                    String VERSAO = rs.getString("VERSAO");
                    String DATAENTRADA = rs.getString("DATAENTRADA");
//                    String SMS = rs.getString("SMS");
//                    String CLASSIFICACAO = rs.getString("CLASSIFICACAO");
//                    String SITUACAO = rs.getString("SITUACAO");
//                    String RESPONSAVEL = rs.getString("RESPONSAVEL");
                    String CLIENTE = rs.getString("CLIENTE");
//                    String SLA = rs.getString("SLA");
//                    String USERALTERACAO = rs.getString("USERALTERACAO");
//                    String HOMOLOGAR = rs.getString("HOMOLOGAR");
//                    String ULTIMAALTERACAO = rs.getString("ULTIMAALTERACAO");
//                    String PRAZOENTREGA = rs.getString("PRAZOENTREGA");
//                    String ATEND = rs.getString("ATEND");
//                    String ATENDENTE = rs.getString("ATENDENTE");
//                    String PRAZOSLA = rs.getString("PRAZOSLA");
                    Protocolo protocolo = new Protocolo(0,PROTOCOLO,"","","",RESUMO,"",DATAENTRADA,"","","","",CLIENTE,"","","","","","","","");
                    protocolosPequisados.add(protocolo);
                }
                //JOptionPane.showMessageDialog(null, "Fim do while");
                //FechaConexaoBanco(conn);
                //JOptionPane.showMessageDialog(null, "Fechou conexao");
            }catch( SQLException e){ //trata os erros SQL
                //Logger.getLogger(ControllerGeral.class.getName()).log(Level.SEVERE, null, e);
//                JOptionPane.showMessageDialog(null,"Erro:\n\n"
//                                                 + e.getMessage());
                criaArquivoErroEEnviaEmail(e, "buscaProtocolosDinamicoSemMensagens");
            }    
            //JOptionPane.showMessageDialog(null, "fim antes do return");
            return protocolosPequisados;
    }
    
    public List retornaAtendentesDosProtocolos(){
        List<String> atendentes = new ArrayList<String>();
            OracleDataSource ods;
            try {
                ods = new OracleDataSource();
                String porta = "1521";
                ods.setURL("jdbc:oracle:thin:@//"+enderecoBanco+":"+porta+"/"+servicoBanco+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
                ods.setUser(usuarioBanco); // [nome do usuário]
                ods.setPassword(senhaBanco); // [senha]
                Connection conn = ods.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select distinct( atendente) from info_atend_255.tmp_siscon s order by atendente");
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    String atendente = rs.getString("atendente");                    
                    atendentes.add(atendente);
                }
            }catch( SQLException e){ //trata os erros SQL
                //Logger.getLogger(ControllerGeral.class.getName()).log(Level.SEVERE, null, e);
//                JOptionPane.showMessageDialog(null,"Erro:\n\n"
//                                                 + e.getMessage());
                criaArquivoErroEEnviaEmail(e, "retornaAtendentesDosProtocolos");
            }    
            return atendentes;
    }
    
    public List retornaOperadorasDosProtocolos(){
        List<String> clientes = new ArrayList<String>();
            OracleDataSource ods;
            try {
                ods = new OracleDataSource();
                String porta = "1521";
                ods.setURL("jdbc:oracle:thin:@//"+enderecoBanco+":"+porta+"/"+servicoBanco+""); // jdbc:oracle:thin@//[nome do host]:[porta]/[nome do serviço de BD]
                ods.setUser(usuarioBanco); // [nome do usuário]
                ods.setPassword(senhaBanco); // [senha]
                Connection conn = ods.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select distinct( cliente) from info_atend_255.tmp_siscon s order by cliente");
                ResultSet rs = stmt.executeQuery();
                while (rs.next()){
                    String cliente = rs.getString("cliente");                    
                    clientes.add(cliente);
                }
            }catch( SQLException e){ //trata os erros SQL
                //Logger.getLogger(ControllerGeral.class.getName()).log(Level.SEVERE, null, e);
//                JOptionPane.showMessageDialog(null,"Erro:\n\n"
//                                                 + e.getMessage());
                criaArquivoErroEEnviaEmail(e, "retornaOperadorasDosProtocolos");
            }    
            return clientes;
    }
    
    public String retornaWhereParaQeuisarVarios(String textoDigitado){
        
        String where  = "";
        
        //textoDigitado = "Tiss diego Recife";
        String[] palavras = textoDigitado.split(" "); //cria array com palavra da frase
        List <String> termosParaPesquisar = new ArrayList<String>();
         
        String maiorPalavra = "";
        for (String palavra : palavras) {
            termosParaPesquisar.add("AND UPPER(prot.resumo) LIKE '%"+palavra+"%'");
        }
        
        if (termosParaPesquisar == null){
            //System.out.println("Não digitou nada!");
        }else{
            for (int i = 0; i < termosParaPesquisar.size(); i++) {
                //System.out.println("Termo: "+termosParaPesquisar.get(i));
            }
        }

        if (palavras.length == 1){
            where = " "+ termosParaPesquisar.get(0);//.replace("AND ", "");
            System.out.println("Where : "+where);
        }else{
            //where = " where ";
            for (int i = 0; i < termosParaPesquisar.size(); i++) {
                if (i == 0){
                    where = where + termosParaPesquisar.get(i);//.replace("AND ", "");
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
    
    public String retornaWhereParaMensagens (String textoDigitado){
        
        String where  = "";
        
        //textoDigitado = "Tiss diego Recife";
        String[] palavras = textoDigitado.split(" "); //cria array com palavra da frase
        List <String> termosParaPesquisar = new ArrayList<String>();
         
        String maiorPalavra = "";
        for (String palavra : palavras) {
            termosParaPesquisar.add("AND UPPER(mens.mensagem) LIKE '%"+palavra+"%'");
        }
        
        if (termosParaPesquisar == null){
            //System.out.println("Não digitou nada!");
        }else{
            for (int i = 0; i < termosParaPesquisar.size(); i++) {
                //System.out.println("Termo: "+termosParaPesquisar.get(i));
            }
        }

        if (palavras.length == 1){
            where = "  "+ termosParaPesquisar.get(0);//.replace("AND ", "");
            System.out.println("Where : "+where);
        }else{
            //where = " where ";
            for (int i = 0; i < termosParaPesquisar.size(); i++) {
                if (i == 0){
                    where = where + termosParaPesquisar.get(i);//.replace("AND ", "");
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
    
    public void criaArquivoErroEEnviaEmail(SQLException ex, String nomeFuncao){
        String nomeDoArquivo = GeradorTXT.GeraTxtDeErro("Erro Cmdo SQL " + ex.getMessage()+" Ao "+nomeFuncao);
        String textoDoEmailDeErro = "Erro no Comando SQL: " + ex.getMessage()+" Ao executar a função: "+nomeFuncao+"\n\nVersão do Sistema: "+"1.0.0.1";
        //mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso( "Erro - Contate o desenvolvedor!");
        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Erro - Contate o desenvolvedor!", "Desculpe-me pelo Erro","erro");
        //email.enviarEmailDoErro("INFOMED","Registro de erro do sistema" , nomeDoArquivo,"1.0.0.1");
    }
    
    
}
