/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

import br.com.sss.model.Mensagem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
public class MensagemController {
    
    String enderecoBanco = "10.20.100.23";
    String servicoBanco = "ATEND";
    String usuarioBanco = "sup_infomed";
    String senhaBanco = "gps$$$";
    
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
                    String dataImportacao = "";
                    //Não pegar linha 0
                    if (contadorLinha != 0){     
                        //System.out.println("Tamanho: "+column.length);
                            System.out.println("Carregando informações do combustivel "+contadorLinha+", aguarde..!");
                        //Com 11 colunas 
                        //if (column.length == 11){
                            //contadorTamanho11++;
                            String protocolo = column[0];
                            String data = column[1];
                            String recurso = column[2];
                            String mensagem = column[3];
                            Mensagem me = new Mensagem(0, protocolo, data, recurso, mensagem);
                            mensagens.add(me);
                           
                        //}
//                        if (column.length == 12){
//                            //contadorTamanho12++;
//                            String regiao = column[0];
//                            String estado = column[1];
//                            String municipio = column[2];
//                            String revenda = column[3];
//                            String instalacao = column[5];
//                            String produto = column[6];
//                            String dataDaColeta = column[7];
//                            String valoDaCompra = column[8];
//                            String ValorDaVenda = column[9];
//                            String unidadeDeMedida = column[10].replace(" / litro", "");
//                            String bandeira = column[11];  
//                            Combustivel combustivel = new Combustivel(0, regiao, estado, municipio, revenda, instalacao, produto, dataDaColeta, valoDaCompra, ValorDaVenda, unidadeDeMedida, bandeira,dataImportacao);
//                            combustiveis.add(combustivel);
//                            //Imprime no console para teste
//    //                        System.out.println("Tamanho 12");
//    //	                System.out.println("Regiao: " + combustivel.getRegiao() + "\nestado: " + combustivel.getEstado() + "\nmunicipio: "+ combustivel.getMunicipio()+ "\nrevenda: "+ combustivel.getRevenda()+ "\ninstalacao: "+ combustivel.getInstalacao()
//    //	                 +"\nproduto: " + combustivel.getProduto() + "\ndataDaColeta: " + combustivel.getDataDaColeta() + "\nvalorDaCompra: "+ combustivel.getValoDaCompra()+ "\nValorDaVenda: "+ combustivel.getValorDaVenda()+ "\nunidadeDeMedida: "+ combustivel.getUnidadeDeMedida()
//    //	                 +"\nbandeira: " + combustivel.getBandeira() + "\ndataImportacao: " + combustivel.getDataImportacao()+"\n");
//                        }
//                        if (column.length == 13){
//                            //contadorTamanho13++;
//                            String regiao = column[0];
//                            String estado = column[1];
//                            String municipio = column[2];
//                            String revenda = column[3];
//                            String instalacao = column[6];
//                            String produto = column[7];
//                            String dataDaColeta = column[8];
//                            String valoDaCompra = column[9];
//                            String ValorDaVenda = column[10];
//                            String unidadeDeMedida = column[11].replace(" / litro", "");
//                            String bandeira = column[12];  
//                            Combustivel combustivel = new Combustivel(0, regiao, estado, municipio, revenda, instalacao, produto, dataDaColeta, valoDaCompra, ValorDaVenda, unidadeDeMedida, bandeira,dataImportacao);
//                            combustiveis.add(combustivel);
//                            //Imprime no console para teste
//    //                        System.out.println("Tamanho 13");
//    //	                System.out.println("Regiao: " + combustivel.getRegiao() + "\nestado: " + combustivel.getEstado() + "\nmunicipio: "+ combustivel.getMunicipio()+ "\nrevenda: "+ combustivel.getRevenda()+ "\ninstalacao: "+ combustivel.getInstalacao()
//    //	                 +"\nproduto: " + combustivel.getProduto() + "\ndataDaColeta: " + combustivel.getDataDaColeta() + "\nvalorDaCompra: "+ combustivel.getValoDaCompra()+ "\nValorDaVenda: "+ combustivel.getValorDaVenda()+ "\nunidadeDeMedida: "+ combustivel.getUnidadeDeMedida()
//    //	                 +"\nbandeira: " + combustivel.getBandeira() + "\ndataImportacao: " + combustivel.getDataImportacao()+"\n");
//                        }
//                        if (column.length == 17){
//                            //contadorTamanho17++;
//                            String regiao = column[0];
//                            String estado = column[1];
//                            String municipio = column[2];
//                            String revenda = column[3] + " "+column[4] + " "+column[5];
//                            String instalacao = column[10];
//                            String produto = column[11];
//                            String dataDaColeta = column[12];
//                            String valoDaCompra = column[13];
//                            String ValorDaVenda = column[14];
//                            String unidadeDeMedida = column[15].replace(" / litro", "");
//                            String bandeira = column[16];
//                            Combustivel combustivel = new Combustivel(0, regiao, estado, municipio, revenda, instalacao, produto, dataDaColeta, valoDaCompra, ValorDaVenda, unidadeDeMedida, bandeira,dataImportacao);
//                            combustiveis.add(combustivel);
//                            //Imprime no console para teste
//    //                        System.out.println("Tamanho 17");
//    //	                System.out.println("Regiao: " + combustivel.getRegiao() + "\nestado: " + combustivel.getEstado() + "\nmunicipio: "+ combustivel.getMunicipio()+ "\nrevenda: "+ combustivel.getRevenda()+ "\ninstalacao: "+ combustivel.getInstalacao()
//    //	                 +"\nproduto: " + combustivel.getProduto() + "\ndataDaColeta: " + combustivel.getDataDaColeta() + "\nvalorDaCompra: "+ combustivel.getValoDaCompra()+ "\nValorDaVenda: "+ combustivel.getValorDaVenda()+ "\nunidadeDeMedida: "+ combustivel.getUnidadeDeMedida()
//    //	                 +"\nbandeira: " + combustivel.getBandeira() + "\ndataImportacao: " + combustivel.getDataImportacao()+"\n");
//                        }
                    }
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
        
    public void InserirMensagens(List<Mensagem> mensagens, String tabela){              
        OracleDataSource ods;
        for (int i = 0; i < mensagens.size(); i++) {
                    
//                    mensagens.get(i).getProtocolo()
//                            , mensagens.get(i).getData()
//                                    , mensagens.get(i).getRecurso()
//                                            ,mensagens.get(i).getMensagem()}); 
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
    
    /*
    
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
    
    
    
    */
    
    
    
}
