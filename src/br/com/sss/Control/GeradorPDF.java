package br.com.sss.Control;

import br.com.sss.model.Empresa;
import br.com.sss.EMail.DrMail;
//import com.itextpdf.text.BadElementException;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document; 
//import com.itextpdf.text.DocumentException; 
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import static jxl.write.WritableFont.COURIER;
import org.jsoup.Connection.Base;
import static org.jsoup.nodes.Entities.EscapeMode.base;
import sun.font.FontFamily;

/**
 * @author Diego Rangel  
 */

public class GeradorPDF {
    
    GeraData dataAtual = new GeraData();
    GeraHora horaAtual = new GeraHora();
    GeraTXT GeradorTXT = new GeraTXT();
    DataPorExtenso dataPorExtenso = new DataPorExtenso();
    DrMail email = new DrMail();
    
    //public String nomeEmpresaPadrao = retornaNomeDaEmpresa();
    
    public Connection con1;
    
    public Clean limpar = new Clean();
    public Cabecalho te = new Cabecalho();
    public String Driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost:3309/receitas"; 
    public String usuario = "root";
    public String senha = "123456";
    
    public String caminhoServidor = "localhost";
    
    public String nomeSistemaOperacional = "WINDOWS";
    
    String CaminhoSalvarRelatorio = "C:\\DSistema\\Relatorios\\relatorio.pdf";    
    String CaminhoSalvarBalanco = "C:\\DSistema\\Relatorios\\Balanco.pdf";
    String CaminhoSalvarOS = "C:\\DSistema\\Relatorios\\OrdemDeServico.pdf";
    String CaminhoSalvarImpressao = "C:\\DSistema\\Relatorios\\Impressao.pdf";
    
    String URLLogo = "/Imagens/logo.png";
    
    public String nomeEmpresaPadrao = retornaNomeDaEmpresa();
    
    public Empresa em = retornaDadosDaEmpresa();
    
    public GeradorPDF(){
        VerificaCaminhoDoBancoDeDados(this);
        limpar = new Clean();
        Cabecalho te = new Cabecalho();
        Driver = "com.mysql.jdbc.Driver";
        //url = "jdbc:mysql://localhost:3309/receitas"; 
        usuario = "root";
        senha = "123456";

        nomeSistemaOperacional = "WINDOWS";

        CaminhoSalvarRelatorio = "C:\\DSistema\\Relatorios\\relatorio.pdf";    
        CaminhoSalvarBalanco = "C:\\DSistema\\Relatorios\\Balanco.pdf";
        CaminhoSalvarOS = "C:\\DSistema\\Relatorios\\OrdemDeServico.pdf";
        CaminhoSalvarImpressao = "C:\\DSistema\\Relatorios\\Impressao.pdf";

        URLLogo = "/Imagens/logo.png";

        nomeEmpresaPadrao = retornaNomeDaEmpresa();

        em = retornaDadosDaEmpresa();
        
        //criaPastaDentroDoDSistema("Relatorios");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    public void VerificaCaminhoDoBancoDeDados(GeradorPDF c){
        /**
        String SO = verificaSistemaOperacional();            
        if (SO.contains("WINDOWS")){
            //Sistema operacional é windows
            try { 
                
                FileReader arq = new FileReader("c:\\DSistema\\CaminhoBD.ini");
                BufferedReader lerArq = new BufferedReader(arq); 
                String linha = lerArq.readLine(); 
                caminhoServidor = linha;
                c.setUrl("jdbc:mysql://"+linha+":3309/receitas");
                arq.close(); 
                } catch (IOException e) { 
                    JOptionPane.showMessageDialog(null,"Caminho do BD não encontrado ou Computador não configurado!\n\n"
                                                     + "Computador será reconhecido como Servidor!");
                    //criaTxtCaminhoBDComLocalHost();
                    //criaNovoCaminhoIniBDComLocalHost();
            } 
        }else{
            //JanelaCadastraClienteDialogo jc = new JanelaCadastraClienteDialogo(parent, modal); //(null, rootPaneCheckingEnabled)
            //jc.show();
            //c.setUrl("jdbc:mysql://"+jc.campoCaminho.getText()+":3309/receitas");
            //JOptionPane.showMessageDialog(null,"O sistema operacional não é Windows");  
        }
        * */
    }
    
    //Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
     
    //Empresa em = new Empresa (1,"Empresa Teste","Empresa Teste", "", "", "", "", "", "", "", "", "", "", "", "","","","","","","","");
    public void criaArquivoErroEEnviaEmail(SQLException ex, String nomeFuncao){
        String nomeDoArquivo = GeradorTXT.GeraTxtDeErro("Erro Cmdo SQL " + ex.getMessage()+" Ao "+nomeFuncao);
        String textoDoEmailDeErro = "Erro no Comando SQL: " + ex.getMessage()+" Ao executar a função: "+nomeFuncao+"\n\nVersão do Sistema: ";
        JOptionPane.showMessageDialog(null, "Erro - Contate o desenvolvedor!");
        email.enviarEmailDoErro(nomeEmpresaPadrao,"Registro de erro do sistema" , nomeDoArquivo,"");
        //email.enviarEmailDoErroSemAnexo(nomeEmpresaPadrao,textoDoEmailDeErro, nomeDoArquivo,em);
    }
    
    public boolean verificaSeTemArquivoTesteINI(){
            File arquivo = new File("C:/DSistema/SistemaTeste.ini"); // ajfilho é uma pasta!
            if (!arquivo.exists()) {
               //JOptionPane.showMessageDialog(null, "Diretório não existe!");
               return false;
            } else {
               //JOptionPane.showMessageDialog(null, "Diretório já existente!");
               return true;
            }
    }
    
    public Statement AbreConexaoBanco(){
        // Ler o JDBC driver
        String driverName = Driver; // MySQL MM JDBC driver
        try {
            Class.forName(driverName);
            // Cria uma conexão com o banco
            con1 = DriverManager.getConnection(url,usuario,senha);
            Statement stmt = con1.createStatement();       //objeto comando sql
            //Retorna a instancia do banco conectado
            return stmt; //Retorna a instancia
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControllerGeral.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ControllerGeral.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Empresa retornaDadosDaEmpresa(){
        Empresa em = new Empresa(0, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "","","","");
        try {  
            String sql = "Select * from tab_empresa";
            java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
            //Imprime o resultado na tabela
            while (rs.next()){
                String lastId = rs.getString("id");
                String lastNome = rs.getString("nome");
                String lastRazao = rs.getString("razao");
                String lastEndereco = rs.getString("endereco");
                String lastNumero = rs.getString("numero");
                String lastBairro = rs.getString("bairro");
                String lastCidade = rs.getString("cidade");
                String lastEstado = rs.getString("estado");
                String lastCep = rs.getString("cep");
                String lastCnpj = rs.getString("cnpj");
                String lastInscEst = rs.getString("insc_estadual");
                String lastTelFixo = rs.getString("telefone_fixo");
                String lastEmail = rs.getString("email");
                String lastDataNascimento = rs.getString("data_nascimento");
                String lastTelMovel = rs.getString("telefone_movel");
                String lastPerfil = rs.getString("perfil");
                String provedor = rs.getString("provedorEmail");
                String emailenvio = rs.getString("EmailDeEnvio");
                String celular = rs.getString("celular");
                String senhaEmail = rs.getString("SenhaEmail");
                int id = Integer.parseInt(lastId);
                Empresa e = new Empresa(id, lastNome, lastRazao, lastEndereco, lastNumero, lastBairro, lastCidade, lastEstado, lastCep, lastCnpj, lastInscEst, lastTelFixo, lastEmail, lastDataNascimento, lastTelMovel, lastPerfil,provedor,emailenvio,senhaEmail,celular,"","");
                em = e;
            }
            FechaConexaoBanco(con1);
            return em;
            }catch( SQLException e){ //trata os erros SQL
                criaArquivoErroEEnviaEmail(e, "retornaDadosDaEmpresa");
                return em;
            }
    }
   
    public String retornaNomeDaEmpresa (){
        try {
                        String sql = "Select * from tab_empresa where id='1'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        String nomeEmpresa = "";
                        while (rs.next()) {               
                            String lastNome = rs.getString("nome");
                            nomeEmpresa = lastNome;
                        }
                        FechaConexaoBanco(con1);
                        return nomeEmpresa;
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"retornaNomeDaEmpresa");
                        return "";
                    }
    }
    /**
    
    public Empresa retornaEmpresaPadrao(){
                    try { 
                        String sql = "Select * from tab_empresa where id='1'";
                        com.mysql.jdbc.ResultSet rs = (com.mysql.jdbc.ResultSet) AbreConexaoBanco().executeQuery(sql);     
                        Empresa emp = null;
                        while(rs.next()){
                            String lastNome = rs.getString("nome");
                            String lastRazao = rs.getString("razao");
                            String lastEndereco = rs.getString("endereco");
                            String lastNumero = rs.getString("numero");
                            String lastBairro = rs.getString("bairro");
                            String lastCidade = rs.getString("cidade");
                            String lastEstado = rs.getString("estado");
                            String lastCEP = rs.getString("cep");
                            String lastCnpj = rs.getString("cnpj");
                            String lastIE = rs.getString("insc_estadual");
                            String lastTelefoneFixo = rs.getString("telefone_fixo");
                            String lastEmail = rs.getString("email");
                            String lastDataNascimento = rs.getString("data_nascimento");
                            String lastTelefoneMovel = rs.getString("telefone_movel");
                            String lastPerfil = rs.getString("perfil");
                            String provedor = rs.getString("provedorEmail");
                            String emailenvio = rs.getString("EmailDeEnvio");
                            String senhaEmail = rs.getString("SenhaEmail");
                            String celular = rs.getString("celular");
                            Empresa e = new Empresa(0, lastNome, lastRazao, lastEndereco, lastNumero, lastBairro, lastCidade, lastEstado, lastCEP, lastCnpj, lastIE, lastTelefoneFixo, lastEmail, lastDataNascimento, lastTelefoneMovel,lastPerfil,provedor,emailenvio,senhaEmail,celular,"","");
                            emp = e;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD                  
                        return emp;
                        }  catch( SQLException e){ //trata os erros SQL
                                criaArquivoErroEEnviaEmail(e,"retornaEmpresaPadrao");
                        }
                        return null;
    }
    
    public void colocarLogoNoPdf(Document d) throws BadElementException, IOException, DocumentException{
            try {  
            Image figura = Image.getInstance("C:\\logo_pdf.png");
            figura.setAlignment(Element.ALIGN_CENTER);
            Paragraph linha = new Paragraph("");
            d.add(figura);
            d.add(linha);
            }   
            catch(DocumentException de) {
                //GeradorTXT.GeraTxtDeErro("Erro ao colocarLogoNoPdf - "+ de.getMessage()+" - Verifica o logo_pdf.png na unidade c:" );
                //JOptionPane.showMessageDialog(null, "Erro - Contate o desenvolvedor!");
            }
            catch(IOException ioe) {
                //GeradorTXT.GeraTxtDeErro("Erro ao colocarLogoNoPdf - "+ ioe.getMessage()+" - Verifica o logo_pdf.png na unidade c:"  );
                //JOptionPane.showMessageDialog(null, "Erro - Contate o desenvolvedor!");
            }
    }
    
    public void colocarImagemIdentificacaoReceita(Document d, boolean comControle) throws BadElementException, IOException, DocumentException{
            if (comControle == false){
                //Nao coloque imagem de controle na receita
            }else{
                //Montar a tabela
                PdfPTable tabela = criaTabelaDeControleDeREceita();
                d.add(tabela);
            }
    }
    
    public void GerarPdf(String ConteudoReceita, String nomeReceita) {        
        // criação do documento
        Document document = new Document(); 
        try {             
            PdfWriter.getInstance(document, new FileOutputStream(CaminhoSalvarRelatorio)); 
            document.open();
            // adicionando um parágrafo no documento |
            document.add(new Paragraph(ConteudoReceita));
            JOptionPane.showMessageDialog(null, "Impressão gerada com sucesso em PDF");
            Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start", CaminhoSalvarRelatorio});
        }   
            catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();        
    }
    

    public void GerarPdfOs(String Conteudo, String NumeroOS) {       
        // criação do documento
        criaPastaDentroDoDSistema("Relatorios");
        Document document = new Document(); 
        try { 
                PdfWriter.getInstance(document, new FileOutputStream(CaminhoSalvarOS+NumeroOS)); 
                document.open();
                // adicionando um parágrafo no documento |                
                document.add(new Paragraph(Conteudo));
                JOptionPane.showMessageDialog(null, "Impressão gerada com sucesso em PDF");
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start", CaminhoSalvarOS});
            }   
            catch(DocumentException de) {
                System.err.println(de.getMessage());
            }
            catch(IOException ioe) {
                System.err.println(ioe.getMessage());
            }
            document.close();
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

    public void GeraOrdemDeServicoComTabela(Empresa em) throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;         
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                PdfWriter.getInstance(doc, os);  
                doc.open();
                //Cria os textos
                Paragraph ParagrafoEmpresa = new Paragraph("Nome: "+em.getNome()+"\n");
                Paragraph ParagrafoEmpresaCNPJ = new Paragraph("CNPJ: "+em.getCnpj()+"\n");
                Paragraph ParagrafoEmpresaTelefone = new Paragraph("Telefone: "+em.getTelefone_fixo()+"\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linhaObservacao = new Paragraph("Osbservação:");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoOS = new Paragraph("Ordem de serviço: ");
                ParagrafoOS.setAlignment(Element.ALIGN_CENTER);
                Paragraph ParagrafoClienteNome = new Paragraph("Cliente: ");
                Paragraph ParagrafoClienteCPF = new Paragraph("CPF: ");
                Paragraph ParagrafoClienteTelefone = new Paragraph("Telefone: ");
                Paragraph ParagrafoClienteEquip = new Paragraph("Equipamento: ");
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 2.0f, 0.5f, 0.5f });
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Código");
                tabela.addCell("Produto");
                tabela.addCell("Quant");
                tabela.addCell("Preço");
                Paragraph ParagrafoTotal = new Paragraph("Total: ");
                //Adiciona no documento
                colocarLogoNoPdf(doc);
                doc.add(ParagrafoEmpresa);
                doc.add(ParagrafoEmpresaCNPJ);
                doc.add(ParagrafoEmpresaTelefone);
                doc.add(linhaBranca);              
                doc.add(ParagrafoOS);
                doc.add(linhaBranca);
                doc.add(ParagrafoClienteNome);
                doc.add(ParagrafoClienteCPF);
                doc.add(ParagrafoClienteTelefone);
                doc.add(ParagrafoClienteEquip);
                doc.add(linhaBranca);
                doc.add(linhaObservacao);
                doc.add(linhaBranca);  
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);  
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start", nomeDoArquivoPdf});  
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GerarPdfGenerico (String Conteudo) {       
        // criação do documento
        Document document = new Document(); 
        try { 
                PdfWriter.getInstance(document, new FileOutputStream(CaminhoSalvarImpressao)); 
                document.open();
                // adicionando um parágrafo no documento |
                document.add(new Paragraph(Conteudo));
                JOptionPane.showMessageDialog(null, "Impressão gerada com sucesso!!!");
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start", CaminhoSalvarImpressao});
            }   
            catch(DocumentException de) {
                System.err.println(de.getMessage());
            }
            catch(IOException ioe) {
                System.err.println(ioe.getMessage());
            }
            document.close();
    }
    

    
    public void GeraRelatorioClientesEmPDF () throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                //Image img = Image.getInstance("ImagemTeste.jpg");
                //img.setAlignment(Element.ALIGN_CENTER);
                
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("Relação de Clientes\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                
                //
                
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 1.5f, 0.5f, 1.0f });
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("ID");
                tabela.addCell("Cliente");
                tabela.addCell("Telefone");
                tabela.addCell("Email");
                
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_cliente";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID_cliente = rs.getString("id");
                            String lastNome = rs.getString("nome");
                            String lastTelefone = rs.getString("telefone");
                            String lastEmail = rs.getString("email");                            
                            tabela.addCell(lastID_cliente);
                            tabela.addCell(lastNome);
                            tabela.addCell(lastTelefone);
                            tabela.addCell(lastEmail);
                            total = total + 1;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GerarRelatorioClienteEmPdf");
                    } 
                        
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Clientes");    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioAniversariantesEmPDF (String mesAtual) throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String mesExtenso = "";
            if (mesAtual.equals("01")){
                mesExtenso = "Janeiro";
            }
            if (mesAtual.equals("02")){
                mesExtenso = "Fevereiro";
            }
            if (mesAtual.equals("03")){
                mesExtenso = "Março";
            }
            if (mesAtual.equals("04")){
                mesExtenso = "Abril";
            }
            if (mesAtual.equals("05")){
                mesExtenso = "Maio";
            }
            if (mesAtual.equals("06")){
                mesExtenso = "Junho";
            }
            if (mesAtual.equals("07")){
                mesExtenso = "Julho";
            }
            if (mesAtual.equals("08")){
                mesExtenso = "Agosto";
            }
            if (mesAtual.equals("09")){
                mesExtenso = "Setembro";
            }
            if (mesAtual.equals("10")){
                mesExtenso = "Outubro";
            }
            if (mesAtual.equals("11")){
                mesExtenso = "Novembro";
            }
            if (mesAtual.equals("12")){
                mesExtenso = "Dezembro";
            }
            
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                //Image img = Image.getInstance("ImagemTeste.jpg");
                //img.setAlignment(Element.ALIGN_CENTER);
                
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("Relação de Aniversariantes do Mês de "+mesExtenso+"\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                
                //
                
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.2f, 2.0f, 1.0f, 2.0f });
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("ID");
                tabela.addCell("Cliente");
                tabela.addCell("Telefone");
                tabela.addCell("Email");
                
                Connection connection = null;
                //String mesAtual = dataAtual.RetornaMesAtual();
                int mesAtualInteiro = Integer.parseInt(mesAtual);
                //javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)j.tabelaAniversariantes.getModel();
                try {
                    String sql = "Select * from tab_cliente";
                    com.mysql.jdbc.ResultSet rs = (com.mysql.jdbc.ResultSet) AbreConexaoBanco().executeQuery(sql);
                    //Preenche os dados no formulario
                    while (rs.next()){
                        String lastId = rs.getString("id");
                        String lastNomeCliente = rs.getString("nome");
                        String lastDataNascimento = rs.getString("data_nascimento");
                        String lastTelefone = rs.getString("telefone");
                        String lastEmail = rs.getString("email");
                        String dataNova = lastDataNascimento;
                        dataNova = dataNova.replace("/","");
                        dataNova = dataNova.replace(" ","");
                        //JOptionPane.showMessageDialog(null, "Data de nascimento de "+lastNomeCliente+" é "+ lastDataNascimento);
                        if (dataNova.equals("") || lastDataNascimento.equals("") || lastDataNascimento.equals(null)){
                            //Faça nada pois não tem data de nascimento cadastrado
                        }else{
                            //Fazer proedimento de verificar aniversariantes
                            Date d = dataAtual.transformaDatadigitadaEmDate(lastDataNascimento);
                            int mes = (d.getMonth()+1);
                            //JOptionPane.showMessageDialog(null, "O mês do cliente é "+ mes+" e o mês atual é "+mesAtualInteiro);
                            if (mes == mesAtualInteiro){
                                //Preenche a tabela
                                String lastID_cliente = rs.getString("id");
                                String lastNome = rs.getString("nome");
                                String telefone = rs.getString("telefone");
                                String email = rs.getString("email");                            
                                tabela.addCell(lastID_cliente);
                                tabela.addCell(lastNome);
                                tabela.addCell(telefone);
                                tabela.addCell(email);
                                total = total + 1;
                            }
                        }
                    }
                           FechaConexaoBanco(con1);
                }  catch( SQLException e){ //trata os erros SQL
                    criaArquivoErroEEnviaEmail(e, "GerarRelatorioClienteEmPdf");
                } 
                       
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Clientes");    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioClientesLoteamentoEmPDF () throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                //Image img = Image.getInstance("ImagemTeste.jpg");
                //img.setAlignment(Element.ALIGN_CENTER);
                
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("Relação de Clientes\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                
                //
                
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 2.0f, 1.0f, 1.0f, 0.5f, 0.5f, 0.5f });
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Cliente");
                tabela.addCell("Telefone");
                tabela.addCell("Quadra");
                tabela.addCell("Lote");
                tabela.addCell("Area");
                tabela.addCell("Medições");
                
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_cliente";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastNome = rs.getString("nome");
                            String lastTelefone = rs.getString("telefone");
                            String Quadra = rs.getString("Quadra");      
                            String Lote = rs.getString("Lote");      
                            String Area = rs.getString("Area");      
                            String Medicoes = rs.getString("Medicoes");      
                            tabela.addCell(lastNome);
                            tabela.addCell(lastTelefone);
                            tabela.addCell(Quadra);
                            tabela.addCell(Lote);
                            tabela.addCell(Area);
                            tabela.addCell(Medicoes);
                            total = total + 1;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GerarRelatorioClienteEmPdf");
                    } 
                        
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Clientes");    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioPacientesEmPDF () throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                //Image img = Image.getInstance("ImagemTeste.jpg");
                //img.setAlignment(Element.ALIGN_CENTER);                
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("Relação de Pacientes\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);                
                //                
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 1.5f, 0.5f, 1.0f });
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("ID");
                tabela.addCell("Paciente");
                tabela.addCell("Telefone");
                tabela.addCell("Email");                
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_paciente";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID_cliente = rs.getString("id");
                            String lastNome = rs.getString("nome");
                            String lastTelefone = rs.getString("telefone");
                            String lastEmail = rs.getString("email");                            
                            tabela.addCell(lastID_cliente);
                            tabela.addCell(lastNome);
                            tabela.addCell(lastTelefone);
                            tabela.addCell(lastEmail);
                            total = total + 1;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioPacientesEmPdf");
                    }                         
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Pacientes");    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioHistoricoPacientesEmPDF (String nomePaciente) throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                Paragraph ParagrafoInicial = new Paragraph("Historico do Pacientes\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);                   
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 1.5f, 0.5f, 1.0f });
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("ID");
                tabela.addCell("Paciente");
                tabela.addCell("Historico");
                tabela.addCell("Data");                
                Connection connection = null;
                try {
                    String sql = "Select * from tab_atestado where paciente = '"+nomePaciente+"'";
                    String sql2 = "Select * from tab_consulta where nomePaciente = '"+nomePaciente+"'";
                    String sql3 = "Select * from tab_receitamedica where nomePaciente = '"+nomePaciente+"'";
                    //Fazer outros select para pegar historicos do paciente
                    java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                    java.sql.ResultSet rs2 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql2);
                    java.sql.ResultSet rs3 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql3);
                    //Imprime o resultado na tabela
                    while (rs.next()) {
                        String lastId = rs.getString("id");
                        String lastData = rs.getString("data");
                        tabela.addCell(lastId);
                        tabela.addCell(nomePaciente);
                        tabela.addCell("Atestado emitido");
                        tabela.addCell(lastData);
                    }
                    while (rs2.next()) {
                        String lastId = rs2.getString("id");
                        String lastData = rs2.getString("dataDaConsulta");
                        tabela.addCell(lastId);
                        tabela.addCell(nomePaciente);
                        tabela.addCell("Foi realizado uma consulta");
                        tabela.addCell(lastData);
                    }
                    while (rs3.next()) {
                        String lastId = rs3.getString("id");
                        String lastData = rs3.getString("dataReceita");
                        tabela.addCell(lastId);
                        tabela.addCell(nomePaciente);
                        tabela.addCell("Foi emitido uma receita");
                        tabela.addCell(lastData);
                    }
                    FechaConexaoBanco(con1);
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e, "GeraRelatorioHistoricoPacientesEmPDF");
                    }
                    try {
                        String sql = "Select * from tab_paciente";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID_cliente = rs.getString("id");
                            String lastNome = rs.getString("nome");
                            String lastTelefone = rs.getString("telefone");
                            String lastEmail = rs.getString("email");                            
                            tabela.addCell(lastID_cliente);
                            tabela.addCell(lastNome);
                            tabela.addCell(lastTelefone);
                            tabela.addCell(lastEmail);
                            total = total + 1;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioPacientesEmPdf");
                    }                         
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Pacientes");    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioFornecedoresEmPDF () throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                //os = new FileOutputStream(nomeDoArquivoPdf); 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                //Image img = Image.getInstance("ImagemTeste.jpg");
                //img.setAlignment(Element.ALIGN_CENTER);                
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("Relação de Fornecedores\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);                
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 1.5f, 0.5f, 1.0f });
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("ID");
                tabela.addCell("Fornecedor");
                tabela.addCell("Telefone");
                tabela.addCell("Email");                
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_fornecedor";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID_cliente = rs.getString("id");
                            String lastNome = rs.getString("nome");
                            String lastTelefone = rs.getString("telefone");
                            String lastEmail = rs.getString("email");                            
                            tabela.addCell(lastID_cliente);
                            tabela.addCell(lastNome);
                            tabela.addCell(lastTelefone);
                            tabela.addCell(lastEmail);
                            total = total + 1;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    }
                
                    Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Fornecedores");    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioUsuarioEmPDF () throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                //Image img = Image.getInstance("ImagemTeste.jpg");
                //img.setAlignment(Element.ALIGN_CENTER);
                
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("Relação de Usuários\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                
                //
                
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 1.5f, 0.5f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("ID");
                tabela.addCell("Usuario");
                tabela.addCell("Telefone");
                
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_usuario";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID_cliente = rs.getString("id");
                            String lastNome = rs.getString("nome");
                            String lastTelefone = rs.getString("telefone");
                            tabela.addCell(lastID_cliente);
                            tabela.addCell(lastNome);
                            tabela.addCell(lastTelefone);
                            total = total + 1;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioUsuarioEmPdf");
                    }
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Usuários");    
                    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    

    public void GeraRelatorioDeMesasNoPeriodoEmPDF (String dataInicial, String dataFinal, String NomeGarcom) throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR"))); 
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            
            double totalGeral = 0;
            double totalEmAberto = 0;
            double totalConcluido = 0;
            
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                PdfWriter.getInstance(doc, os);  
                doc.open();
                Paragraph ParagrafoInicial = new Paragraph("Relatório de Mesas do Garçom "+NomeGarcom+"\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 1.0f, 1.0f, 1.0f, 1.0f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Nº Mesa");
                tabela.addCell("Data");
                tabela.addCell("Status");
                tabela.addCell("Valor");
                
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_mesa_comanda where StatusMesaComanda<>'RESERVADO' AND Garcom='"+NomeGarcom+"' AND DataInclusaoSemBarras BETWEEN '"+dataInicial+"' AND '"+dataFinal+"'";
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF 
                        while (rs.next()) {
                                //PREENCHE INCIAL DO DIA
                                String NumeroMesa = rs.getString("NumeroMesa");
                                String DataInclusao = rs.getString("DataInclusao");
                                String TotalParcial = rs.getString("TotalParcial");
                                String StatusMesaComanda = rs.getString("StatusMesaComanda");
                                tabela.addCell(NumeroMesa);
                                tabela.addCell(DataInclusao.toUpperCase());
                                tabela.addCell(TotalParcial);
                                tabela.addCell(StatusMesaComanda);
                                //totalCaixaAtual alimentar essa variavel
                                if (StatusMesaComanda.equals("EMABERTO")){
                                    try {
                                        double TotalParcial1 = 0;
                                        TotalParcial1 = df.parse (TotalParcial).doubleValue(); // isto deve dar o número "1234.56"
                                        totalEmAberto = totalEmAberto + TotalParcial1;
                                    } catch (ParseException ex) {
                                           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                if (StatusMesaComanda.equals("PAGO")){
                                    try {
                                        double TotalParcial1 = 0;
                                        TotalParcial1 = df.parse (TotalParcial).doubleValue(); // isto deve dar o número "1234.56"
                                        totalConcluido = totalConcluido + TotalParcial1;
                                    } catch (ParseException ex) {
                                           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                try {
                                        double TotalParcial1 = 0;
                                        TotalParcial1 = df.parse (TotalParcial).doubleValue(); // isto deve dar o número "1234.56"
                                        totalGeral = totalGeral + TotalParcial1;
                                    } catch (ParseException ex) {
                                           Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                    }                                
                        }                        
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioDeMesasNoPeriodoEmPDF");
                    } 
                   
                    JFormattedTextField campoFormatado = new JFormattedTextField();
                campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                    
                String TotalEmAbertoString = df.format (totalEmAberto); // deve retornar a string formatada  
                String TotalConcluidoString = df.format (totalConcluido); // deve retornar a string formatada  
                String TotalGeral = df.format (totalGeral); // deve retornar a string formatada  
                
                campoFormatado.setText(TotalEmAbertoString);
                Paragraph paragrafoTotalEmAberto = new Paragraph("\nValor das Mesas em Aberto: R$ "+campoFormatado.getText());
                campoFormatado.setText(TotalConcluidoString);
                Paragraph paragrafoTotalConcluido = new Paragraph("\nValor das Mesas Concluidas: R$ "+campoFormatado.getText());
                campoFormatado.setText(TotalGeral);
                Paragraph paragrafoTotalGeral = new Paragraph("\nValor Geral das Mesas: R$ "+campoFormatado.getText());
                
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(paragrafoTotalEmAberto);
                doc.add(linhaBranca);
                doc.add(paragrafoTotalConcluido);
                doc.add(linhaBranca);
                doc.add(paragrafoTotalGeral);
                doc.add(linhaBranca);
                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    
    }
    
    public void GeraRelatorioVendasComCustosPeriodoEmPDF (String dataInicial, String dataFinal) throws FileNotFoundException, DocumentException, IOException {  
        Document doc = null; 
        OutputStream os = null;  
        try{
            criaPastaDentroDoDSistema("Relatorios");
            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR"))); 
            
             
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                PdfWriter.getInstance(doc, os);  
                doc.open();
                Paragraph ParagrafoInicial = new Paragraph("Relatório de Produtos com Custos\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.2f, 1.0f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f});
                
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Cod.");
                tabela.addCell("Produto");
                tabela.addCell("Data");
                tabela.addCell("Preço Custo");
                tabela.addCell("Preço Venda");
                tabela.addCell("Desconto");
                tabela.addCell("Preço Vendido");
                tabela.addCell("Resultado");
                
                double totalDeCustos = 0;
                double totalDesontos = 0;
                double totalDeVendidos = 0;
                double totalResultado = 0;
                
                Connection connection = null;
                        String sql = "Select * from tab_pedido where status='Concluido' AND DataInclusaoSemBarras BETWEEN '"+dataInicial+"' AND '"+dataFinal+"'";
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);                        
                        
                        while (rs.next()) {
                                //PREENCHE INCIAL DO DIA
                                String idPedido = rs.getString("id");
                                String DataPedido = rs.getString("DataInclusao");
                                    String sql2 = "Select * from tab_produto_pedido where id_pedido='"+idPedido+"'";
                                    java.sql.ResultSet rs2 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql2);
                                    while (rs2.next()) {
                                            //PREENCHE INCIAL DO DIA
                                            String cod_produto = rs2.getString("cod_produto");
                                            String produto = rs2.getString("produto");
                                            String precoCusto = retornaPrecoCustoProduto(cod_produto);
                                            if (precoCusto.equals("")){
                                                precoCusto = "0";
                                            }
                                            String PrecoVenda = retornaPrecoProduto(cod_produto);
                                            if (PrecoVenda.equals("")){
                                                PrecoVenda = "0";
                                            }
                                            String desconto = rs2.getString("desconto_unitario");
                                            if (desconto.equals("")){
                                                desconto = "0";
                                            }
                                            String preco = rs2.getString("preco");
                                            if (preco.equals("")){
                                                preco = "0";
                                            }
                                            //totalCaixaAtual alimentar essa variavel
                                                double precoCusto1 = 0;
                                                double preco1 = 0;
                                                double resultado1 = 0;
                                                double desconto1 = 0;
                                                
                                                preco1 = df.parse (preco).doubleValue(); // isto deve dar o número "1234.56"
                                                precoCusto1 = df.parse (precoCusto).doubleValue(); // isto deve dar o número "1234.56"
                                                desconto1 = df.parse (desconto).doubleValue(); // isto deve dar o número "1234.56"
                                                
                                                resultado1 = preco1 - precoCusto1;
                                            
                                                totalDeCustos = totalDeCustos+ precoCusto1;
                                                totalDesontos = totalDesontos + desconto1;
                                                totalDeVendidos = totalDeVendidos + preco1;
                                                totalResultado = totalResultado + resultado1;
                                                
                                            String TotalCaixaString = df.format (resultado1); // deve retornar a string formatada  
                                            JFormattedTextField campoFormatado = new JFormattedTextField();
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                                            TotalCaixaString = campoFormatado.getText();
                                            tabela.addCell(cod_produto);
                                            tabela.addCell(produto);
                                            tabela.addCell(DataPedido);
                                            tabela.addCell(precoCusto);
                                            tabela.addCell(PrecoVenda);
                                            tabela.addCell(desconto);
                                            tabela.addCell(preco);
                                            tabela.addCell(TotalCaixaString);
                                    }
                                
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                     
                    Paragraph totais = new Paragraph("Totais:\n");
                    String TotalCaixaString = df.format (totalDeCustos); // deve retornar a string formatada  
                                            JFormattedTextField campoFormatado = new JFormattedTextField();
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                    Paragraph totalDeCustosString = new Paragraph("Total de custos: "+campoFormatado.getText());
                    TotalCaixaString = df.format (totalDesontos); // deve retornar a string formatada  
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                    Paragraph totalDesontosString = new Paragraph("Total de Descontos: "+campoFormatado.getText());
                    TotalCaixaString = df.format (totalDeVendidos); // deve retornar a string formatada  
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                                            TotalCaixaString = campoFormatado.getText();
                    Paragraph totalDeVendidosString = new Paragraph("Total de Vendidos: "+campoFormatado.getText());
                    TotalCaixaString = df.format (totalResultado); // deve retornar a string formatada  
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                                            TotalCaixaString = campoFormatado.getText();
                    Paragraph totalResultadoString = new Paragraph("Total do Resultado: "+campoFormatado.getText());
                    
                //String totall = atualizaTotalPedidosFluxo(j);
                
                //double totalDinheiro = 0;
                //double totalCartao = 0;
                //double totalParcelado = 0;
                //double totalCheque = 0;
                
                //String TotalDinheiroString = df.format (totalDinheiro); // deve retornar a string formatada  
                //String TotalCartaoString = df.format (totalCartao); // deve retornar a string formatada  
                //String TotalParceladoString = df.format (totalParcelado); // deve retornar a string formatada  
                //String TotalChequeString = df.format (totalCheque); // deve retornar a string formatada  
                
               
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                //doc.add(ParagrafoTotalEmCaixa);
                doc.add(linhaBranca);
                
                
                doc.add(totais);
                doc.add(totalDeCustosString);
                doc.add(totalDesontosString);
                doc.add(totalDeVendidosString);
                doc.add(totalResultadoString);
                
                doc.add(linhaBranca);
                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } catch (SQLException ex) {
            Logger.getLogger(GeradorPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GeradorPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
            
    }
    
    public void GeraRelatorioVendasComCustosPeriodoComEstoqueAtualEmPDF (String dataInicial, String dataFinal, Conexao co) throws FileNotFoundException, DocumentException, IOException {  
        Document doc = null; 
        OutputStream os = null;  
        try{
            criaPastaDentroDoDSistema("Relatorios");
            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR"))); 
            
             
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                PdfWriter.getInstance(doc, os);  
                doc.open();
                Paragraph ParagrafoInicial = new Paragraph("Relatório de Produtos com Custos\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.2f, 1.0f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f});
                
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Cod.");
                tabela.addCell("Produto");
                tabela.addCell("Data");
                tabela.addCell("Preço Custo");
                tabela.addCell("Preço Venda");
                tabela.addCell("Desconto");
                tabela.addCell("Preço Vendido");
                tabela.addCell("Resultado");
                tabela.addCell("Est. Atual");
                
                double totalDeCustos = 0;
                double totalDesontos = 0;
                double totalDeVendidos = 0;
                double totalResultado = 0;
                
                Connection connection = null;
                        String sql = "Select * from tab_pedido where status='Concluido' AND DataInclusaoSemBarras BETWEEN '"+dataInicial+"' AND '"+dataFinal+"'";
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);                        
                        
                        while (rs.next()) {
                                //PREENCHE INCIAL DO DIA
                                String idPedido = rs.getString("id");
                                String DataPedido = rs.getString("DataInclusao");
                                    String sql2 = "Select * from tab_produto_pedido where id_pedido='"+idPedido+"'";
                                    java.sql.ResultSet rs2 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql2);
                                    while (rs2.next()) {
                                            //PREENCHE INCIAL DO DIA
                                            String cod_produto = rs2.getString("cod_produto");
                                            String produto = rs2.getString("produto");
                                            String precoCusto = retornaPrecoCustoProduto(cod_produto);
                                            if (precoCusto.equals("")){
                                                precoCusto = "0";
                                            }
                                            String PrecoVenda = retornaPrecoProduto(cod_produto);
                                            if (PrecoVenda.equals("")){
                                                PrecoVenda = "0";
                                            }
                                            String desconto = rs2.getString("desconto_unitario");
                                            if (desconto.equals("")){
                                                desconto = "0";
                                            }
                                            String preco = rs2.getString("preco");
                                            if (preco.equals("")){
                                                preco = "0";
                                            }
                                            //totalCaixaAtual alimentar essa variavel
                                                double precoCusto1 = 0;
                                                double preco1 = 0;
                                                double resultado1 = 0;
                                                double desconto1 = 0;
                                                
                                                preco1 = df.parse (preco).doubleValue(); // isto deve dar o número "1234.56"
                                                precoCusto1 = df.parse (precoCusto).doubleValue(); // isto deve dar o número "1234.56"
                                                desconto1 = df.parse (desconto).doubleValue(); // isto deve dar o número "1234.56"
                                                
                                                resultado1 = preco1 - precoCusto1;
                                            
                                                totalDeCustos = totalDeCustos+ precoCusto1;
                                                totalDesontos = totalDesontos + desconto1;
                                                totalDeVendidos = totalDeVendidos + preco1;
                                                totalResultado = totalResultado + resultado1;
                                                
                                            String TotalCaixaString = df.format (resultado1); // deve retornar a string formatada  
                                            JFormattedTextField campoFormatado = new JFormattedTextField();
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                                            TotalCaixaString = campoFormatado.getText();
                                            tabela.addCell(cod_produto);
                                            tabela.addCell(produto);
                                            tabela.addCell(DataPedido);
                                            tabela.addCell(precoCusto);
                                            tabela.addCell(PrecoVenda);
                                            tabela.addCell(desconto);
                                            tabela.addCell(preco);
                                            tabela.addCell(TotalCaixaString);
//                                            tabela.addCell(co.RetornaQuantidadeEmEstoque(cod_produto));
                                    }                                
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                     
                    Paragraph totais = new Paragraph("Totais:\n");
                    String TotalCaixaString = df.format (totalDeCustos); // deve retornar a string formatada  
                                            JFormattedTextField campoFormatado = new JFormattedTextField();
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                    Paragraph totalDeCustosString = new Paragraph("Total de custos: "+campoFormatado.getText());
                    TotalCaixaString = df.format (totalDesontos); // deve retornar a string formatada  
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                    Paragraph totalDesontosString = new Paragraph("Total de Descontos: "+campoFormatado.getText());
                    TotalCaixaString = df.format (totalDeVendidos); // deve retornar a string formatada  
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                                            TotalCaixaString = campoFormatado.getText();
                    Paragraph totalDeVendidosString = new Paragraph("Total de Vendidos: "+campoFormatado.getText());
                    TotalCaixaString = df.format (totalResultado); // deve retornar a string formatada  
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                                            TotalCaixaString = campoFormatado.getText();
                    Paragraph totalResultadoString = new Paragraph("Total do Resultado: "+campoFormatado.getText());
                    
                //String totall = atualizaTotalPedidosFluxo(j);
                
                //double totalDinheiro = 0;
                //double totalCartao = 0;
                //double totalParcelado = 0;
                //double totalCheque = 0;
                
                //String TotalDinheiroString = df.format (totalDinheiro); // deve retornar a string formatada  
                //String TotalCartaoString = df.format (totalCartao); // deve retornar a string formatada  
                //String TotalParceladoString = df.format (totalParcelado); // deve retornar a string formatada  
                //String TotalChequeString = df.format (totalCheque); // deve retornar a string formatada  
                
               
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                //doc.add(ParagrafoTotalEmCaixa);
                doc.add(linhaBranca);
                
                
                doc.add(totais);
                doc.add(totalDeCustosString);
                doc.add(totalDesontosString);
                doc.add(totalDeVendidosString);
                doc.add(totalResultadoString);
                
                doc.add(linhaBranca);
                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } catch (SQLException ex) {
            Logger.getLogger(GeradorPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GeradorPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
            
    }
    
    public void GeraRelatorioFinanceiroReceberPagarVendas (String dataInicial, String dataFinal) throws FileNotFoundException, DocumentException, IOException {  
        Document doc = null; 
        OutputStream os = null;
        Connection connection = null;
        
        try{
            criaPastaDentroDoDSistema("Relatorios");
            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));             
             
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
                doc = new Document(PageSize.A4, 20, 20, 20, 20);
                os = new FileOutputStream(nomeDoArquivoPdf); 
                PdfWriter.getInstance(doc, os);  
                doc.open();
                Paragraph ParagrafoInicial = new Paragraph("Relatório Financeiro\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                
                Paragraph linhaCentralReceber = new Paragraph("Contas a Receber");
                Paragraph linhaCentralPagar = new Paragraph("Contas a Pagar");
                Paragraph linhaCentralVendas = new Paragraph("Contas a Vendas");
                
                Paragraph linhaCentralReceberTotal = new Paragraph("Total a Receber");
                Paragraph linhaCentralPagarTotal = new Paragraph("Total a Pagar");
                Paragraph linhaCentralVendasTotal = new Paragraph("Total de Vendas");
                
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                //Montar a tabela
                PdfPTable tabelaReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});                
                tabelaReceber.setWidthPercentage(100.0f);
                tabelaReceber.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabelaReceber.addCell("Cliente");
                tabelaReceber.addCell("Valor");
                tabelaReceber.addCell("Vencimento");
                
                PdfPTable tabelaPagar = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});                
                tabelaPagar.setWidthPercentage(100.0f);
                tabelaPagar.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabelaPagar.addCell("Cliente");
                tabelaPagar.addCell("Valor");
                tabelaPagar.addCell("Vencimento");
                
                PdfPTable tabelaVendas = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});                
                tabelaVendas.setWidthPercentage(100.0f);
                tabelaVendas.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabelaVendas.addCell("Cliente");
                tabelaVendas.addCell("Valor");
                tabelaVendas.addCell("Data");
                
                double totalReceber = 0;
                double totalPagar = 0;
                double totalvendas = 0;
                
                //Alimenta a receber
                String sql1 = "Select * from tab_contas_receber where status<>'excluido' AND VencimentoSemBarra BETWEEN '"+dataInicial+"' AND '"+dataFinal+"'";
                java.sql.ResultSet rs1 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql1);                        
                while (rs1.next()) {
                    //PREENCHE INCIAL DO DIA
                    String Vencimento = rs1.getString("Vencimento");
                    String NomeCliente = rs1.getString("NomeCliente");
                    String valor = rs1.getString("valor");
                    //totalCaixaAtual alimentar essa variavel
                    double valor1 = 0;                                               
                    valor1 = df.parse (valor).doubleValue(); // isto deve dar o número "1234.56"                    
                    totalReceber = totalReceber + valor1;
                                                
                    String TotalCaixaString = df.format (valor1); // deve retornar a string formatada  
                    JFormattedTextField campoFormatado = new JFormattedTextField();
                    campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                    campoFormatado.setText(TotalCaixaString);
                    TotalCaixaString = campoFormatado.getText();
                    tabelaReceber.addCell(NomeCliente);
                    tabelaReceber.addCell(TotalCaixaString);
                    tabelaReceber.addCell(Vencimento);                                
                }
                
                //alimenta a pagar
                String sql2 = "Select * from tab_contas_pagar where status<>'excluido' AND VencimentoSemBarra BETWEEN '"+dataInicial+"' AND '"+dataFinal+"'";
                java.sql.ResultSet rs2 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql2);                        
                while (rs2.next()) {
                    //PREENCHE INCIAL DO DIA
                    String DataPedido = rs2.getString("Vencimento");
                    String NomeCliente = rs2.getString("NomeCliente");
                    String valor = rs2.getString("valor");
                    //totalCaixaAtual alimentar essa variavel
                    double valor1 = 0;                                               
                    valor1 = df.parse (valor).doubleValue(); // isto deve dar o número "1234.56"                    
                    totalPagar = totalPagar + valor1;
                                                
                    String TotalCaixaString = df.format (valor1); // deve retornar a string formatada  
                    JFormattedTextField campoFormatado = new JFormattedTextField();
                    campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                    campoFormatado.setText(TotalCaixaString);
                    TotalCaixaString = campoFormatado.getText();
                    tabelaPagar.addCell(NomeCliente);
                    tabelaPagar.addCell(TotalCaixaString);
                    tabelaPagar.addCell(DataPedido);                                
                }
                
                //alimenta as vendas
                String sql3 = "Select * from tab_pedido where status='Concluido' AND DataInclusaoSemBarras BETWEEN '"+dataInicial+"' AND '"+dataFinal+"'";
                java.sql.ResultSet rs3 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql3);                        
                while (rs3.next()) {
                    //PREENCHE INCIAL DO DIA
                    String DataPedido = rs3.getString("DataInclusao");
                    String NomeCliente = rs3.getString("NomeCliente");
                    String ValorTotalPedido = rs3.getString("ValorTotal");
                    //totalCaixaAtual alimentar essa variavel
                    double ValorTotalPedido1 = 0;                                               
                    ValorTotalPedido1 = df.parse (ValorTotalPedido).doubleValue(); // isto deve dar o número "1234.56"                    
                    totalvendas = totalvendas + ValorTotalPedido1;
                                                
                    String TotalCaixaString = df.format (ValorTotalPedido1); // deve retornar a string formatada  
                    JFormattedTextField campoFormatado = new JFormattedTextField();
                    campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                    campoFormatado.setText(TotalCaixaString);
                    TotalCaixaString = campoFormatado.getText();
                    tabelaVendas.addCell(NomeCliente);
                    tabelaVendas.addCell(TotalCaixaString);
                    tabelaVendas.addCell(DataPedido);                                
                }
                
                
                FechaConexaoBanco(con1);  // fecha conexão com BD
                     
                    String TotalCaixaString = df.format (totalReceber); // deve retornar a string formatada  
                                            JFormattedTextField campoFormatado = new JFormattedTextField();
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                    Paragraph totalRecebimentos = new Paragraph("Total de contas a Receber: "+campoFormatado.getText());
                    TotalCaixaString = df.format (totalPagar); // deve retornar a string formatada  
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                    Paragraph TotalPagamentos = new Paragraph("Total de contas a Pagar: "+campoFormatado.getText());
                    TotalCaixaString = df.format (totalvendas); // deve retornar a string formatada  
                                            campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                                            campoFormatado.setText(TotalCaixaString);
                                            TotalCaixaString = campoFormatado.getText();
                    Paragraph totalDeVendidosString = new Paragraph("Total de Vendas: "+campoFormatado.getText());
                    
                    
                
                
               
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaCentralReceber);
                doc.add(linhaBranca);
                doc.add(tabelaReceber);
                doc.add(totalRecebimentos);
                doc.add(linhaBranca);
                doc.add(linhaCentralPagar);
                doc.add(linhaBranca);
                doc.add(tabelaPagar);
                doc.add(TotalPagamentos);
                doc.add(linhaBranca);
                doc.add(linhaCentralVendas);
                doc.add(linhaBranca);
                doc.add(tabelaVendas);
                doc.add(totalDeVendidosString);
                doc.add(linhaBranca);
           
                
                
                doc.add(linhaBranca);
                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } catch (SQLException ex) {
            Logger.getLogger(GeradorPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GeradorPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
            
    }
    
    public void GeraRelatorioDoCaixaEmPDF (String dataInicial) throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR"))); 
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                PdfWriter.getInstance(doc, os);  
                doc.open();
                Paragraph ParagrafoInicial = new Paragraph("Relatório do Caixa\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 1.5f, 0.5f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Nº");
                tabela.addCell("Histórico");
                tabela.addCell("Valor");
                double totalDinheiro = 0;
                double totalCartao = 0;
                double totalParcelado = 0;
                double totalCheque = 0;
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_pedido where status='Concluido' AND DataInclusao = '"+dataInicial+"'";
                        String sql3 = "Select * from tab_conta_caixa where status='Concluido' AND data = '"+dataInicial+"' AND Historico like 'inicial%'";
                        String sql2 = "Select * from tab_conta_caixa where status='Concluido' AND data = '"+dataInicial+"' AND tipoLancamento<>'Inicial do Dia'";
                        String sql4 = "Select * from tab_ordem_servico_otica where Status='CONCLUIDA' AND DataEntrada = '"+dataInicial+"'";
                        java.sql.ResultSet rs2 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql2);
                        java.sql.ResultSet rs3 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql3);
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        java.sql.ResultSet rs4 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql4);
                        //Imprime o resultado no PDF 
                        
                        while (rs3.next()) {
                                //PREENCHE INCIAL DO DIA
                                String idContaINICIAL = rs3.getString("id");
                                String historicoContaINICIAL = rs3.getString("Historico");
                                String valorContaINICIAL = rs3.getString("valor");
                                tabela.addCell(idContaINICIAL);
                                tabela.addCell(historicoContaINICIAL.toUpperCase());
                                tabela.addCell(valorContaINICIAL);
                        }
                        //Preenche os pedidos do dia
                        while (rs.next()) {               
                            String lastID_pedido = rs.getString("id");
                            String lastCliente = rs.getString("NomeCliente");
                            String lastValorTotal = rs.getString("ValorTotal");
                            String lastValorAVista = rs.getString("ValorAVista");
                            String lastValorCheque = rs.getString("ValorCheque");
                            String lastValorParcelado = rs.getString("ValorParcelado");
                            String lastValorCartao = rs.getString("ValorCartao");
                            
                            //Verifica valor digitado a vista para somar
                            if (!lastValorAVista.equals("0,00")){
                                tabela.addCell(lastID_pedido);
                                tabela.addCell("PEDIDO - "+lastCliente.toUpperCase());
                                tabela.addCell(lastValorAVista);
                                try {
                                    double totalDinheiro1;
                                    totalDinheiro1 = df.parse (lastValorAVista).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDinheiro = totalDinheiro + totalDinheiro1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            //Verifica valor digitado cartao para somar
                            if (!lastValorCartao.equals("0,00")){
                                try {
                                    double totalCartao1;
                                    totalCartao1 = df.parse (lastValorCheque).doubleValue(); // isto deve dar o número "1234.56"
                                    totalCartao = totalCartao + totalCartao1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            //Verifica valor digitado cheque para somar
                            if (!lastValorCheque.equals("0,00")){
                                try {
                                    double totalCheque1;
                                    totalCheque1 = df.parse (lastValorCheque).doubleValue(); // isto deve dar o número "1234.56"
                                    totalCheque = totalCheque + totalCheque1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            //Verifica valor digitado cheque para somar
                            if (!lastValorParcelado.equals("0,00")){
                                try {
                                    double totalParcelado1;
                                    totalParcelado1 = df.parse (lastValorCheque).doubleValue(); // isto deve dar o número "1234.56"
                                    totalParcelado = totalParcelado + totalParcelado1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            total = total + 1;
                            double Valor = 0;
                            
                        }
                        double totalDasOS = 0;
                        while (rs4.next()) {
                                //PREENCHE as os do dia
                                String lastid = rs4.getString("id");
                                String lastValorAVista = rs4.getString("ValorDinheiro");
                                String cliente = rs4.getString("NomeCliente");
                                
                                tabela.addCell(lastid);
                                tabela.addCell("OS Nº "+lastid+" - Cliente: "+cliente.toUpperCase());
                                tabela.addCell(lastValorAVista);
                                
                                double lastValorAVista1 = 0;
                                    try {
                                            lastValorAVista1 = df.parse (lastValorAVista).doubleValue(); // isto deve dar o número "1234.56"
                                            totalDinheiro = totalDinheiro + lastValorAVista1;
                                        } catch (ParseException ex) {
                                            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                        }
                        while (rs2.next()) {
                                //PREENCHE AS DESPESAS
                                String idConta = rs2.getString("id");
                                String historicoConta = rs2.getString("Historico");
                                String valorConta = rs2.getString("valor");
                                tabela.addCell(idConta);
                                tabela.addCell(historicoConta.toUpperCase());
                                tabela.addCell(valorConta);
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioVendasPeriodoEmPDF");
                    } 
                //String totall = atualizaTotalPedidosFluxo(j);
                Paragraph ParagrafoTotalEmCaixa = new Paragraph("Total em Caixa");    
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Vendas");    
                Paragraph paragrafoAvista = new Paragraph("\nValor em dinheiro: "+totalDinheiro);
                Paragraph paragrafoCartao = new Paragraph("\nValor em cartão: "+totalCartao);
                Paragraph paragrafoCheque = new Paragraph("\nValor em Cheque: "+totalCheque);
                Paragraph paragrafoParcelado = new Paragraph("\nValor Parcelado: "+totalParcelado);
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotalEmCaixa);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(paragrafoAvista);
                doc.add(paragrafoCartao);
                doc.add(paragrafoCheque);
                doc.add(paragrafoParcelado);
                doc.add(linhaBranca);
                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    
    
    public void GeraRelatorioDeComissaoPorOperadorEmPDF (String dataInicial, String dataFinal, String vendedor, String porcentagemComissao ) throws FileNotFoundException, DocumentException, IOException { 
            criaPastaDentroDoDSistema("Relatorios");
            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR"))); 
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                PdfWriter.getInstance(doc, os);  
                doc.open();
                Paragraph ParagrafoInicial = new Paragraph("Relação de Comissão do Vendedor: "+vendedor+"\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 1.5f, 0.5f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Nº Pe.");
                tabela.addCell("Cliente");
                tabela.addCell("Valor");
                double totalDinheiro = 0;
                double totalCartao = 0;
                double totalParcelado = 0;
                double totalCheque = 0;
                double totalGeralDosPedidos = 0;
                double totalGeralDaComissao = 0;
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_pedido where status='Concluido' AND vendedor='"+vendedor+"' AND DataInclusaoSemBarras BETWEEN '"+dataInicial+"' AND '"+dataFinal+"'";
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF 
                        while (rs.next()) {               
                            String lastID_pedido = rs.getString("id");
                            String lastCliente = rs.getString("NomeCliente");
                            String lastValorTotal = rs.getString("ValorTotal");
                            String lastValorAVista = rs.getString("ValorAVista");
                            String lastValorCheque = rs.getString("ValorCheque");
                            String lastValorParcelado = rs.getString("ValorParcelado");
                            String lastValorCartao = rs.getString("ValorCartao");
                            tabela.addCell(lastID_pedido);
                            tabela.addCell(lastCliente);
                            tabela.addCell(lastValorTotal);
                            
                            //Soma o total dos pedidos
                            try {
                                    double totalPedido = 0;
                                    totalPedido = df.parse (lastValorTotal).doubleValue(); // isto deve dar o número "1234.56"
                                    totalGeralDosPedidos = totalGeralDosPedidos + totalPedido;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            //Verifica valor digitado a vista para somar
                            if (!lastValorAVista.equals("0,00")){
                                try {
                                    double totalDinheiro1;
                                    totalDinheiro1 = df.parse (lastValorAVista).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDinheiro = totalDinheiro + totalDinheiro1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            //Verifica valor digitado cartao para somar
                            if (!lastValorCartao.equals("0,00")){
                                try {
                                    double totalCartao1;
                                    totalCartao1 = df.parse (lastValorCheque).doubleValue(); // isto deve dar o número "1234.56"
                                    totalCartao = totalCartao + totalCartao1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            //Verifica valor digitado cheque para somar
                            if (!lastValorCheque.equals("0,00")){
                                try {
                                    double totalCheque1;
                                    totalCheque1 = df.parse (lastValorCheque).doubleValue(); // isto deve dar o número "1234.56"
                                    totalCheque = totalCheque + totalCheque1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            //Verifica valor digitado cheque para somar
                            if (!lastValorParcelado.equals("0,00")){
                                try {
                                    double totalParcelado1;
                                    totalParcelado1 = df.parse (lastValorCheque).doubleValue(); // isto deve dar o número "1234.56"
                                    totalParcelado = totalParcelado + totalParcelado1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            total = total + 1;
                            double Valor = 0;
                            
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioDeComissaoPorOperadorEmPDF");
                    } 
                    
                    //calcula comissao
                            try {
                                    double porcentagem = 0;
                                    porcentagem = df.parse (porcentagemComissao).doubleValue(); // isto deve dar o número "1234.56"
                                    totalGeralDaComissao = ((totalGeralDosPedidos * porcentagem)/100);
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            String TotalComissaoString = df.format (totalGeralDaComissao); // deve retornar a string "1.234,56"   
                    
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Vendas");    
                Paragraph paragrafoAvista = new Paragraph("\nValor em dinheiro: "+totalDinheiro);
                Paragraph paragrafoCartao = new Paragraph("\nValor em cartão: "+totalCartao);
                Paragraph paragrafoCheque = new Paragraph("\nValor em Cheque: "+totalCheque);
                Paragraph paragrafoParcelado = new Paragraph("\nValor Parcelado: "+totalParcelado);                
                Paragraph ParagrafoTotalComissao = new Paragraph("Total de comissão do vendedor "+vendedor+": R$ "+TotalComissaoString);  
                
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(paragrafoAvista);
                doc.add(paragrafoCartao);
                doc.add(paragrafoCheque);
                doc.add(paragrafoParcelado);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotalComissao);
                doc.add(linhaBranca);
                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioDasConsultasEmPDF (String dataInicial, String dataFinal, String status ) throws FileNotFoundException, DocumentException, IOException { 
            criaPastaDentroDoDSistema("Relatorios");
            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR"))); 
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                PdfWriter.getInstance(doc, os);  
                doc.open();
                Paragraph ParagrafoInicial = new Paragraph("Relatório de Consultas");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 1.5f, 0.5f, 0.5f, 0.5f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Nº");
                tabela.addCell("Paciente");
                tabela.addCell("Data");
                tabela.addCell("Hora");
                tabela.addCell("Valor");
                double totalDinheiro = 0;
                double totalCartao = 0;
                double totalParcelado = 0;
                double totalCheque = 0;
                double totalGeralDosPedidos = 0;
                double totalGeralDaComissao = 0;
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_consulta where status='"+status+"' AND DataSemBarras BETWEEN '"+dataInicial+"' AND '"+dataFinal+"'";
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF 
                        while (rs.next()) {               
                            String lastID = rs.getString("id");
                            String nomePaciente = rs.getString("nomePaciente");
                            String lastValorTotal = rs.getString("valorDaConsulta");
                            String lastValorAVista = rs.getString("ValorAVista");
                            String lastValorParcelado = rs.getString("ValorParcelado");
                            String lastValorCartao = rs.getString("ValorCartao");
                            String dataConsulta = rs.getString("dataDaConsulta");
                            String horaConsulta = rs.getString("horaDaConsulta");
                            tabela.addCell(lastID);
                            tabela.addCell(nomePaciente);
                            tabela.addCell(dataConsulta);
                            tabela.addCell(horaConsulta);
                            tabela.addCell(lastValorTotal);
                            //Soma o total dos pedidos
                            try {
                                    double totalPedido = 0;
                                    totalPedido = df.parse (lastValorTotal).doubleValue(); // isto deve dar o número "1234.56"
                                    totalGeralDosPedidos = totalGeralDosPedidos + totalPedido;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            //Verifica valor digitado a vista para somar
                            if (!lastValorAVista.equals("0,00")){
                                try {
                                    double totalDinheiro1;
                                    totalDinheiro1 = df.parse (lastValorAVista).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDinheiro = totalDinheiro + totalDinheiro1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            //Verifica valor digitado cartao para somar
                            if (!lastValorCartao.equals("0,00")){
                                try {
                                    double totalCartao1;
                                    totalCartao1 = df.parse (lastValorCartao).doubleValue(); // isto deve dar o número "1234.56"
                                    totalCartao = totalCartao + totalCartao1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            //Verifica valor digitado cheque para somar
                            if (!lastValorParcelado.equals("0,00")){
                                try {
                                    double totalParcelado1;
                                    totalParcelado1 = df.parse (lastValorParcelado).doubleValue(); // isto deve dar o número "1234.56"
                                    totalParcelado = totalParcelado + totalParcelado1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            total = total + 1;
                            double Valor = 0;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioDasConsultasEmPDF");
                    } 
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Consulta(s)");    
                Paragraph paragrafoAvista = new Paragraph("\nValor em dinheiro: "+totalDinheiro);
                Paragraph paragrafoCartao = new Paragraph("\nValor em cartão: "+totalCartao);
                Paragraph paragrafoParcelado = new Paragraph("\nValor Parcelado: "+totalParcelado);
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                if (status.equals("concluida")){
                    doc.add(linhaBranca);
                    doc.add(ParagrafoTotal);
                    doc.add(linhaBranca);
                    doc.add(paragrafoAvista);
                    doc.add(paragrafoCartao);
                    doc.add(paragrafoParcelado);
                }
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioDasConsultaTodasEmPDF (String dataInicial, String dataFinal) throws FileNotFoundException, DocumentException, IOException { 
            criaPastaDentroDoDSistema("Relatorios");
            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR"))); 
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                PdfWriter.getInstance(doc, os);  
                doc.open();
                Paragraph ParagrafoInicial = new Paragraph("Relatório de Consultas");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 1.5f, 0.5f, 0.5f, 0.5f, 0.5f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Nº");
                tabela.addCell("Paciente");
                tabela.addCell("Data");
                tabela.addCell("Hora");
                tabela.addCell("Valor");
                tabela.addCell("Status");
                double totalDinheiro = 0;
                double totalCartao = 0;
                double totalParcelado = 0;
                double totalCheque = 0;
                double totalGeralDosPedidos = 0;
                double totalGeralDaComissao = 0;
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_consulta where DataSemBarras BETWEEN '"+dataInicial+"' AND '"+dataFinal+"'";
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF 
                        while (rs.next()) {               
                            String lastID = rs.getString("id");
                            String nomePaciente = rs.getString("nomePaciente");
                            String lastValorTotal = rs.getString("valorDaConsulta");
                            String lastValorAVista = rs.getString("ValorAVista");
                            String lastValorParcelado = rs.getString("ValorParcelado");
                            String lastValorCartao = rs.getString("ValorCartao");
                            String dataConsulta = rs.getString("dataDaConsulta");
                            String horaConsulta = rs.getString("horaDaConsulta");
                            String status = rs.getString("status");
                            tabela.addCell(lastID);
                            tabela.addCell(nomePaciente);
                            tabela.addCell(dataConsulta);
                            tabela.addCell(horaConsulta);
                            tabela.addCell(lastValorTotal);
                            tabela.addCell(status);
                            //Soma o total dos pedidos
                            try {
                                    double totalPedido = 0;
                                    totalPedido = df.parse (lastValorTotal).doubleValue(); // isto deve dar o número "1234.56"
                                    totalGeralDosPedidos = totalGeralDosPedidos + totalPedido;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            //Verifica valor digitado a vista para somar
                            if (!lastValorAVista.equals("0,00")){
                                try {
                                    double totalDinheiro1;
                                    totalDinheiro1 = df.parse (lastValorAVista).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDinheiro = totalDinheiro + totalDinheiro1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            //Verifica valor digitado cartao para somar
                            if (!lastValorCartao.equals("0,00")){
                                try {
                                    double totalCartao1;
                                    totalCartao1 = df.parse (lastValorCartao).doubleValue(); // isto deve dar o número "1234.56"
                                    totalCartao = totalCartao + totalCartao1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            //Verifica valor digitado cheque para somar
                            if (!lastValorParcelado.equals("0,00")){
                                try {
                                    double totalParcelado1;
                                    totalParcelado1 = df.parse (lastValorParcelado).doubleValue(); // isto deve dar o número "1234.56"
                                    totalParcelado = totalParcelado + totalParcelado1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            total = total + 1;
                            double Valor = 0;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioDasConsultaTodasEmPDF");
                    } 
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Consulta(s)");    
                Paragraph paragrafoAvista = new Paragraph("\nValor em dinheiro: "+totalDinheiro);
                Paragraph paragrafoCartao = new Paragraph("\nValor em cartão: "+totalCartao);
                Paragraph paragrafoParcelado = new Paragraph("\nValor Parcelado: "+totalParcelado);
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                    doc.add(linhaBranca);
                    doc.add(ParagrafoTotal);
                    doc.add(linhaBranca);
                    doc.add(paragrafoAvista);
                    doc.add(paragrafoCartao);
                    doc.add(paragrafoParcelado);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraReciboEmPdf (String numeroRecibo) throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph ParagrafoNumeroRecibo = new Paragraph("Recibo: "+numeroRecibo+"\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoNumeroRecibo.setAlignment(Element.ALIGN_CENTER);
                Empresa em = retornaEmpresaPadrao();
                Paragraph dadosDaEmpresa = new Paragraph(em.getNome()+"\n"+em.getEndereco()+" - "+em.getBairro()+" - "+em.getCidade()+" - "+em.getEstado()+"\nTelefone: "+em.getTelefone_fixo()+"  CPF/CNPJ: "+em.getCnpj()+"\n");
                linha.setAlignment(Element.ALIGN_CENTER);
                dadosDaEmpresa.setAlignment(Element.ALIGN_CENTER);
                String num = "";
                String cliente = "";
                String valor = "";
                String valorex = "";
                String descricao = "";
                String uf = "";
                String cidade = "";
                String data = "";
                try {
                        String sql = "Select * from tab_recibo where numeroRecibo='"+numeroRecibo+"'";
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID = rs.getString("numeroRecibo");
                            String lastCliente = rs.getString("nomeCliente");
                            String lastValor = rs.getString("valorEmValor");
                            String lastValorExtenso = rs.getString("valorExtenso");
                            String lastDescricao = rs.getString("descricao");
                            String lastData = rs.getString("data");
                            String lastUf = rs.getString("uf");
                            String lastCidade = rs.getString("cidade");
                            cliente = lastCliente;
                            valor = lastValor;
                            valorex = lastValorExtenso;
                            descricao = lastDescricao;
                            uf = lastUf;
                            cidade = lastCidade;
                            data = lastData;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraReciboEmPDF");
                    } 
                        
                Paragraph textoRecibo = new Paragraph("Recebi(emos) de "+cliente+" a quantia R$ "+valor+" ( "+valorex+") correspondente a "+descricao+", e para clareza firmo(amos) o presente.");
                String dataPorExtenso = dataAtual.RetornaDataPorExtenso(data);
                Paragraph textodataEAssinatura = new Paragraph(cidade+"-"+uf+", "+dataPorExtenso);
                textodataEAssinatura.setAlignment(Element.ALIGN_CENTER);
                Paragraph textoEmpresa = new Paragraph(retornaNomeDaEmpresa());
                textoEmpresa.setAlignment(Element.ALIGN_CENTER);
                Paragraph valor1 = new Paragraph("R$ "+valor);
                valor1.setAlignment(Element.ALIGN_RIGHT);
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc); 
                doc.add(dadosDaEmpresa);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(ParagrafoNumeroRecibo);
                doc.add(linhaBranca);
                doc.add(valor1);
                doc.add(linhaBranca);
                doc.add(textoRecibo);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(textodataEAssinatura);
                doc.add(linha);
                doc.add(textoEmpresa);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioDeProducaoEmPDF (String dataInicial, String dataFinal, String whereData, String whereStatus) throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("Relatório de produção\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);

                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 1.5f, 0.5f, 0.5f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Cód. Prod.");
                tabela.addCell("Produto");
                tabela.addCell("Quant");
                tabela.addCell("Data");
                
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_producao where status='"+whereStatus+"' AND "+whereData+" BETWEEN "+dataInicial+" AND "+dataFinal+"";
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID = rs.getString("cod_produto_final");
                            String lastNomeProduto = rs.getString("nome_produto_final");
                            String lastQuant = rs.getString("quantidade_produzido");
                            String lastData = rs.getString("data_inicio");
                            tabela.addCell(lastID);
                            tabela.addCell(lastNomeProduto);
                            tabela.addCell(lastQuant);
                            tabela.addCell(lastData);
                            total = total + 1;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioDeProducaoEmPDF");
                    } 
                    
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Produtos");    
                    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioProdutosComPrecoEmPDF () throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("Relação de Produtos\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);

                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 2.0f, 0.5f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Cod.");
                tabela.addCell("Produto");
                tabela.addCell("Preço");
                
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_produto";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID_produto = rs.getString("id");
                            String lastProduto = rs.getString("produto");
                            String lastPreco = rs.getString("preco_tabela");
                            tabela.addCell(lastID_produto);
                            tabela.addCell(lastProduto);
                            tabela.addCell(lastPreco);
                            total = total + 1;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioDeProdutosComPrecoEmPDF");
                    } 
                    
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Produtos");    
                    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioProdutosComPrecoEquantidadeEmEstoqueEmPDF () throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("Relação de Produtos\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                
                DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 2.0f, 0.5f, 0.5f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Cod.");
                tabela.addCell("Produto");
                tabela.addCell("Quantidade");
                tabela.addCell("Preço");
                
                double totalComPrecoDeCusto = 0;
                double totalComPrecoDeVenda = 0;
                double totalDeEstoque = 0;
                
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_produto order by produto";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID_produto = rs.getString("id");
                            String lastProduto = rs.getString("produto");
                            String lastPreco = rs.getString("preco_tabela");
                            String preco_fornecedor = rs.getString("preco_fornecedor");
                            String quantidadeEstoque = rs.getString("quantidade_estoque");
                            if (lastPreco.equals("")){
                                lastPreco = "0";
                            }
                            if (preco_fornecedor.equals("")){
                                preco_fornecedor = "0";
                            }
                            if (quantidadeEstoque.equals("")){
                                quantidadeEstoque = "0";
                            }
                            tabela.addCell(lastID_produto);
                            tabela.addCell(lastProduto);
                            tabela.addCell(quantidadeEstoque);
                            tabela.addCell(lastPreco);
                            total = total + 1;
                            
                            double valorDeVenda = 0;
                            double valorDeNF = 0;
                            double estoque = 0;
                            
                            try {
                                    double valorConta1 = 0;
                                    valorDeVenda = df.parse (lastPreco).doubleValue(); // isto deve dar o número "1234.56"
                                    valorDeNF = df.parse (preco_fornecedor).doubleValue(); // isto deve dar o número "1234.56"
                                    estoque = df.parse (quantidadeEstoque).doubleValue(); // isto deve dar o número "1234.56"
                                    totalComPrecoDeVenda = totalComPrecoDeVenda + (valorDeVenda * estoque);
                                    totalComPrecoDeCusto = totalComPrecoDeCusto + (valorDeNF * estoque);
                                    totalDeEstoque = totalDeEstoque + estoque;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioProdutosComPrecoEquantidadeEmEstoqueEmPDF");
                    } 
                    
                    //COLOOCA NO FORMATO DE VIRGULA
                    String TotalEmPrecoDeVenda = df.format (totalComPrecoDeVenda); // deve retornar a string formatada  
                    JFormattedTextField campoFormatado = new JFormattedTextField();
                    campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                    campoFormatado.setText(TotalEmPrecoDeVenda);
                    String totalVendas = campoFormatado.getText();
                    
                    String TotalEmPRecoNF = df.format (totalComPrecoDeCusto); // deve retornar a string formatada  
                    campoFormatado.setText(TotalEmPRecoNF);
                    String totalCustos = campoFormatado.getText();
                    
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Produtos cadastrados \n\nTotal de ítens em estoque: "+totalDeEstoque+"    \n\nTotal de custo R$: "+totalCustos+"   \n\nTotal em estoque R$: "+totalVendas);                    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioProdutosEstoqueCompletoEmPDF () throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("Relação de Produtos\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 2.0f, 0.5f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("ID");
                tabela.addCell("Produto");
                tabela.addCell("Estoque atual");
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_produto";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID_produto = rs.getString("id");
                            String lastProduto = rs.getString("produto");
                            String lastEstoque = rs.getString("quantidade_estoque");
                            tabela.addCell(lastID_produto);
                            tabela.addCell(lastProduto);
                            tabela.addCell(lastEstoque);
                            total = total + 1;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioProdutosEstoqueCompletoEmPDF");
                    } 
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Produtos");    
                    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioProdutosEstoqueCriticoEmPDF () throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("Relação de Produtos com estoque crítico\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 2.0f, 0.5f, 0.5f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("ID");
                tabela.addCell("Produto");
                tabela.addCell("Estoque atual");
                tabela.addCell("Estoque mínimo");
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_produto";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID_produto = rs.getString("id");
                            String lastProduto = rs.getString("produto");
                            String lastEstoque = rs.getString("quantidade_estoque");
                            if (lastEstoque.equals("")){
                                lastEstoque = "0";
                            }
                            String lastMinimo = rs.getString("minimo_vitrine");
                            if (!lastMinimo.equals("") && !lastMinimo.equals("0") && !lastMinimo.equals("0,00")){
                                double lastEstoque1 = 0;
                                double lastMinimo1 = 0;
                                try {
                                    lastEstoque1 = df.parse (lastEstoque).doubleValue(); // isto deve dar o número "1234.56"
                                    lastMinimo1 = df.parse (lastMinimo).doubleValue(); // isto deve dar o número "1234.56"
                                    if (lastEstoque1 < lastMinimo1){
                                        tabela.addCell(lastID_produto);
                                        tabela.addCell(lastProduto);
                                        tabela.addCell(lastEstoque);
                                        tabela.addCell(lastMinimo);
                                        total++;
                                    }
                                    } catch (ParseException ex) {
                                        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                        }  catch( SQLException e){ //trata os erros SQL
                            criaArquivoErroEEnviaEmail(e,"GeraRelatorioProdutosEstoqueCriticoEmPDF");
                        } 
                    
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Produto(s)");    
                    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioProdutosEstoqueZeroEmPDF () throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                //Image img = Image.getInstance("ImagemTeste.jpg");
                //img.setAlignment(Element.ALIGN_CENTER);
                
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("Relação de Produtos\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);

                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 2.0f, 0.5f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("ID");
                tabela.addCell("Produto");
                tabela.addCell("Estoque");
                
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_produto where quantidade_estoque='0' or quantidade_estoque=''";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID_produto = rs.getString("id");
                            String lastProduto = rs.getString("produto");
                            String lastEstoque = rs.getString("quantidade_estoque");
                            tabela.addCell(lastID_produto);
                            tabela.addCell(lastProduto);
                            tabela.addCell(lastEstoque);
                            total = total + 1;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioProdutosEstoqueZeroEmPDF");
                    } 
                
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Produto(s)");    
                    
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);

                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    

    public void GeraRelatorioResumidoContasReceberTodasEmPDF (String dataInicial, String dataFinal) throws FileNotFoundException, DocumentException, IOException {  
            
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação de todas as Contas a receber de "+dataInicial+" até "+dataFinal);

                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoContasReceber.addCell("Cliente");
                tabelaRelacaoContasReceber.addCell("Vencimento");
                tabelaRelacaoContasReceber.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select * from tab_contas_receber where VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            tabelaRelacaoContasReceber.addCell(lastCliente);
                            tabelaRelacaoContasReceber.addCell(lastVencimento);
                            tabelaRelacaoContasReceber.addCell(lastValor);
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;

                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioResumidoContasReceberTodasEmPDF");
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioVisaoGeralEmPDF () throws FileNotFoundException, DocumentException, IOException {  
            String mes = dataAtual.RetornaMesAtual();
            String dataInicial = "01/"+mes+"/"+dataAtual.RetornaAnoAtualYY();
            String dataFinal = "31/"+mes+"/"+dataAtual.RetornaAnoAtualYY();
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            double totalDasContasPagar = 0;
            double totalGeralDasConsultas = 0;
            double totalDinheiro = 0;
            double totalCartao = 0;
            double totalParcelado = 0;
            double total = 0;
            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Visão geral do mês atual");
                
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER); 
                //Preenche os totais de a receber
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_receber where VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                             
                            double Valor = 0;
                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioVisaoGeralEmPDF");
                    } 
                    //Preenche os totais de a pagar
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_pagar where VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            double Valor = 0;
                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasPagar = totalDasContasPagar + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioVisaoGeralEmPDF");
                    }
                    
                    //relaciona as consultas medicas
                    Connection connection = null;
                    try {
                        String sql = "Select * from tab_consulta where status='concluida' AND DataSemBarras BETWEEN '"+dataInicial+"' AND '"+dataFinal+"'";
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF 
                        while (rs.next()) {               
                            String lastID = rs.getString("id");
                            String nomePaciente = rs.getString("nomePaciente");
                            String lastValorTotal = rs.getString("valorDaConsulta");
                            String lastValorAVista = rs.getString("ValorAVista");
                            String lastValorParcelado = rs.getString("ValorParcelado");
                            String lastValorCartao = rs.getString("ValorCartao");
                            String dataConsulta = rs.getString("dataDaConsulta");
                            String horaConsulta = rs.getString("horaDaConsulta");
                            String status = rs.getString("status");
                            
                            //Soma o total dos pedidos
                            try {
                                    double totalPedido = 0;
                                    totalPedido = df.parse (lastValorTotal).doubleValue(); // isto deve dar o número "1234.56"
                                    totalGeralDasConsultas = totalGeralDasConsultas + totalPedido;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            //Verifica valor digitado a vista para somar
                            if (!lastValorAVista.equals("0,00")){
                                try {
                                    double totalDinheiro1;
                                    totalDinheiro1 = df.parse (lastValorAVista).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDinheiro = totalDinheiro + totalDinheiro1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            //Verifica valor digitado cartao para somar
                            if (!lastValorCartao.equals("0,00")){
                                try {
                                    double totalCartao1;
                                    totalCartao1 = df.parse (lastValorCartao).doubleValue(); // isto deve dar o número "1234.56"
                                    totalCartao = totalCartao + totalCartao1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            //Verifica valor digitado cheque para somar
                            if (!lastValorParcelado.equals("0,00")){
                                try {
                                    double totalParcelado1;
                                    totalParcelado1 = df.parse (lastValorParcelado).doubleValue(); // isto deve dar o número "1234.56"
                                    totalParcelado = totalParcelado + totalParcelado1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            total = total + 1;
                            double Valor = 0;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioVisaoGeralEmPDF");
                    } 
                
                    
                Paragraph ParagrafoTotaisAReceber = new Paragraph("Total de contas a receber: "+totalDasContasReceber);
                Paragraph ParagrafoTotaisAPagar = new Paragraph("Total de Contas a pagar: "+totalDasContasPagar);
                Paragraph ParagrafoTotal = new Paragraph("Total de consultas desse mês: "+total);
                Paragraph ParagrafoTotalFrase = new Paragraph("Total de acordo com forma de pagamento");
                Paragraph paragrafoAvista = new Paragraph("\nValor em dinheiro: "+totalDinheiro);
                Paragraph paragrafoCartao = new Paragraph("\nValor em cartão: "+totalCartao);
                Paragraph paragrafoParcelado = new Paragraph("\nValor Parcelado: "+totalParcelado);
                //ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotaisAReceber);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotaisAPagar);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotalFrase);
                doc.add(linhaBranca);
                doc.add(paragrafoAvista);
                doc.add(paragrafoCartao);
                doc.add(paragrafoParcelado);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasReceberEmPDF (String dataInicial, String dataFinal, String status) throws FileNotFoundException, DocumentException, IOException {  
            
            String DinicialSemBarra = dataInicial;
            String DfinalSemBarra = dataFinal;
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação resumida de Contas a receber de "+dataInicial+" até "+dataFinal);

                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoContasReceber.addCell("Cliente");
                tabelaRelacaoContasReceber.addCell("Vencimento");
                tabelaRelacaoContasReceber.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_receber where status='"+status+"' AND VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            tabelaRelacaoContasReceber.addCell(lastCliente);
                            tabelaRelacaoContasReceber.addCell(lastVencimento);
                            tabelaRelacaoContasReceber.addCell(lastValor);
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;

                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioResumidoContasReceberEmPDF");
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasPagarEmPDFcomStatus (String dataInicial, String dataFinal, String status) throws FileNotFoundException, DocumentException, IOException {
            
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação resumida de Contas a pagar de "+dataInicial+" até "+dataFinal);

                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoContasReceber.addCell("Cliente");
                tabelaRelacaoContasReceber.addCell("Vencimento");
                tabelaRelacaoContasReceber.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_pagar where status='"+status+"' AND VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            tabelaRelacaoContasReceber.addCell(lastCliente);
                            tabelaRelacaoContasReceber.addCell(lastVencimento);
                            tabelaRelacaoContasReceber.addCell(lastValor);                                                     
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;
                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioResumidoContasPagarEmPDFcomStatus");
                    }
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasPagarEmPDFtodos (String dataInicial, String dataFinal ) throws FileNotFoundException, DocumentException, IOException {
            
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação de Contas a pagar de "+dataInicial+" até "+dataFinal);

                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoContasReceber.addCell("Cliente");
                tabelaRelacaoContasReceber.addCell("Vencimento");
                tabelaRelacaoContasReceber.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_pagar where VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            tabelaRelacaoContasReceber.addCell(lastCliente);
                            tabelaRelacaoContasReceber.addCell(lastVencimento);
                            tabelaRelacaoContasReceber.addCell(lastValor);
                            
                            
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;

                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioResumidoContasPagarEmPDFTodos");
                    }
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioPrevisaoContasPagarEmPDF (String mes, String ano) throws FileNotFoundException, DocumentException, IOException {  
            
            String mes1 = "";
            if (mes.equals("JANEIRO")){
                mes1 = "01";
            }
            if (mes.equals("FEVEREIRO")){
                mes1 = "02";
            }
            if (mes.equals("MARÇO")){
                mes1 = "03";
            }
            if (mes.equals("ABRIL")){
                mes1 = "04";
            }
            if (mes.equals("MAIO")){
                mes1 = "05";
            }
            if (mes.equals("JUNHO")){
                mes1 = "06";
            }
            if (mes.equals("JULHO")){
                mes1 = "07";
            }
            if (mes.equals("AGOSTO")){
                mes1 = "08";
            }
            if (mes.equals("SETEMBRO")){
                mes1 = "09";
            }
            if (mes.equals("OUTUBRO")){
                mes1 = "10";
            }
            if (mes.equals("NOVEMBRO")){
                mes1 = "11";
            }
            if (mes.equals("DEZEMBRO")){
                mes1 = "12";
            }
            String dataInicial = "01/"+mes1+"/"+ano;
            String dataFinal = "31/"+mes1+"/"+ano;
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação de previsão de Contas a pagar de "+mes+" até "+ano);
                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT); 
                tabelaRelacaoContasReceber.addCell("Cliente");
                tabelaRelacaoContasReceber.addCell("Vencimento");
                tabelaRelacaoContasReceber.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_pagar where VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            tabelaRelacaoContasReceber.addCell(lastCliente);
                            tabelaRelacaoContasReceber.addCell(lastVencimento);
                            tabelaRelacaoContasReceber.addCell(lastValor);
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;

                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasReceberEmPDFResumoPorStatus (String dataInicial, String dataFinal, String status) throws FileNotFoundException, DocumentException, IOException {  
            
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação resumida de Contas a receber de "+dataInicial+" até "+dataFinal);
                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select * from tab_contas_receber where Status='"+status+"' AND VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            String lastValorRecebido = rs.getString("valorRecebido");
                            if (status.equals("recebido")){
                                tabelaRelacaoContasReceber.addCell(lastCliente);
                                tabelaRelacaoContasReceber.addCell(lastVencimento);
                                tabelaRelacaoContasReceber.addCell(lastValorRecebido);

                                DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                                double Valorrecebido = 0;
                                try {
                                    Valorrecebido = df.parse (lastValorRecebido).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDasContasReceber = totalDasContasReceber + Valorrecebido;
                                 } catch (ParseException ex) {
                                        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }else{
                                tabelaRelacaoContasReceber.addCell(lastCliente);
                                tabelaRelacaoContasReceber.addCell(lastVencimento);
                                tabelaRelacaoContasReceber.addCell(lastValor);

                                DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                                double Valor = 0;
                                try {
                                    Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDasContasReceber = totalDasContasReceber + Valor;
                                 } catch (ParseException ex) {
                                        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                //doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasPagarEmPDFResumoPorStatus (String dataInicial, String dataFinal, String status) throws FileNotFoundException, DocumentException, IOException {  
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação resumida de Contas a pagar de "+dataInicial+" até "+dataFinal);
                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_pagar where Status='"+status+"' AND VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            tabelaRelacaoContasReceber.addCell(lastCliente);
                            tabelaRelacaoContasReceber.addCell(lastVencimento);
                            tabelaRelacaoContasReceber.addCell(lastValor);
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;
                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                //doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasReceberEmPDFResumo (String dataInicial, String dataFinal) throws FileNotFoundException, DocumentException, IOException {  
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação resumida de Contas a receber de "+dataInicial+" até "+dataFinal);
                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_receber where VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            tabelaRelacaoContasReceber.addCell(lastCliente);
                            tabelaRelacaoContasReceber.addCell(lastVencimento);
                            tabelaRelacaoContasReceber.addCell(lastValor);                            
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;

                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                //doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasPagarEmPDFResumo (String dataInicial, String dataFinal) throws FileNotFoundException, DocumentException, IOException {  
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação resumida de Contas a pagar de "+dataInicial+" até "+dataFinal);

                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_pagar where VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            tabelaRelacaoContasReceber.addCell(lastCliente);
                            tabelaRelacaoContasReceber.addCell(lastVencimento);
                            tabelaRelacaoContasReceber.addCell(lastValor);
                            
                            
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;

                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                //doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasReceberEmPDFComStatus (String dataInicial, String dataFinal, String status) throws FileNotFoundException, DocumentException, IOException {  
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação Detalhada de Contas a receber de "+dataInicial+" até "+dataFinal);
                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoContasReceber.addCell("Cliente");
                tabelaRelacaoContasReceber.addCell("Vencimento");
                tabelaRelacaoContasReceber.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor,valorRecebido from tab_contas_receber where Status='"+status+"' AND VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            String lastValorRecebido = rs.getString("valorRecebido");
                            if (status.equals("recebido")){
                                tabelaRelacaoContasReceber.addCell(lastCliente);
                                tabelaRelacaoContasReceber.addCell(lastVencimento);
                                tabelaRelacaoContasReceber.addCell(lastValorRecebido);


                                DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                                double Valor = 0;

                                try {
                                    Valor = df.parse (lastValorRecebido).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDasContasReceber = totalDasContasReceber + Valor;
                                } catch (ParseException ex) {
                                        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }else{
                                tabelaRelacaoContasReceber.addCell(lastCliente);
                                tabelaRelacaoContasReceber.addCell(lastVencimento);
                                tabelaRelacaoContasReceber.addCell(lastValor);


                                DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                                double Valor = 0;

                                try {
                                    Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDasContasReceber = totalDasContasReceber + Valor;
                                } catch (ParseException ex) {
                                        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                    
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasPagarEmPDFComStatus (String dataInicial, String dataFinal, String status) throws FileNotFoundException, DocumentException, IOException {  
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação Detalhada de Contas a pagar de "+dataInicial+" até "+dataFinal);
                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoContasReceber.addCell("Cliente");
                tabelaRelacaoContasReceber.addCell("Vencimento");
                tabelaRelacaoContasReceber.addCell("Valor");
                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_pagar where Status='"+status+"' AND VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            tabelaRelacaoContasReceber.addCell(lastCliente);
                            tabelaRelacaoContasReceber.addCell(lastVencimento);
                            tabelaRelacaoContasReceber.addCell(lastValor);
                            
                            
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;

                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasReceberEmPDFPeloClienteDetalhadaPorStatus (String dataInicial, String dataFinal, String nomeCliente, String status) throws FileNotFoundException, DocumentException, IOException {  
            
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação Detalhada de Contas a receber do cliente "+nomeCliente);

                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoContasReceber.addCell("Cliente");
                tabelaRelacaoContasReceber.addCell("Vencimento");
                tabelaRelacaoContasReceber.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor,valorRecebido from tab_contas_receber where NomeCliente='"+nomeCliente+"' AND Status='"+status+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            String lastValoRecebidor = rs.getString("valorRecebido");
                            if (status.equals("recebido")){
                                tabelaRelacaoContasReceber.addCell(lastCliente);
                                tabelaRelacaoContasReceber.addCell(lastVencimento);
                                tabelaRelacaoContasReceber.addCell(lastValoRecebidor);
                                DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                                double Valor = 0;

                                try {
                                    Valor = df.parse (lastValoRecebidor).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDasContasReceber = totalDasContasReceber + Valor;
                                } catch (ParseException ex) {
                                        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }else{
                                tabelaRelacaoContasReceber.addCell(lastCliente);
                                tabelaRelacaoContasReceber.addCell(lastVencimento);
                                tabelaRelacaoContasReceber.addCell(lastValor);                            
                            
                                DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                                double Valor = 0;

                                try {
                                    Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDasContasReceber = totalDasContasReceber + Valor;
                                } catch (ParseException ex) {
                                        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasReceberEmPDFPeloClienteTelaDeCliente (String nomeCliente, String status) throws FileNotFoundException, DocumentException, IOException {  
            
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação de Contas a receber do cliente "+nomeCliente);

                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoContasReceber.addCell("Cliente");
                tabelaRelacaoContasReceber.addCell("Vencimento");
                tabelaRelacaoContasReceber.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select * from tab_contas_receber where NomeCliente='"+nomeCliente+"' AND Status='"+status+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            String lastValoRecebidor = rs.getString("valorRecebido");
                            if (status.equals("recebido")){
                                tabelaRelacaoContasReceber.addCell(lastCliente);
                                tabelaRelacaoContasReceber.addCell(lastVencimento);
                                tabelaRelacaoContasReceber.addCell(lastValoRecebidor);
                                DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                                double Valor = 0;

                                try {
                                    Valor = df.parse (lastValoRecebidor).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDasContasReceber = totalDasContasReceber + Valor;
                                } catch (ParseException ex) {
                                        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }else{
                                tabelaRelacaoContasReceber.addCell(lastCliente);
                                tabelaRelacaoContasReceber.addCell(lastVencimento);
                                tabelaRelacaoContasReceber.addCell(lastValor);                            
                            
                                DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                                double Valor = 0;

                                try {
                                    Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDasContasReceber = totalDasContasReceber + Valor;
                                } catch (ParseException ex) {
                                        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasPagarEmPDFPeloClienteDetalhadaPorStatus (String dataInicial, String dataFinal, String nomeCliente, String status) throws FileNotFoundException, DocumentException, IOException {  
            
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação Detalhada de Contas a receber do cliente "+nomeCliente);

                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoContasReceber.addCell("Cliente");
                tabelaRelacaoContasReceber.addCell("Vencimento");
                tabelaRelacaoContasReceber.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_pagar where NomeCliente='"+nomeCliente+"' AND Status='"+status+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            tabelaRelacaoContasReceber.addCell(lastCliente);
                            tabelaRelacaoContasReceber.addCell(lastVencimento);
                            tabelaRelacaoContasReceber.addCell(lastValor);
                            
                            
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;

                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    }
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasReceberEmPDFPeloClienteDetalhada (String dataInicial, String dataFinal, String nomeCliente) throws FileNotFoundException, DocumentException, IOException {  
            
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação Detalhada de Contas a receber do cliente "+nomeCliente);

                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoContasReceber.addCell("Cliente");
                tabelaRelacaoContasReceber.addCell("Vencimento");
                tabelaRelacaoContasReceber.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_receber where NomeCliente='"+nomeCliente+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            tabelaRelacaoContasReceber.addCell(lastCliente);
                            tabelaRelacaoContasReceber.addCell(lastVencimento);
                            tabelaRelacaoContasReceber.addCell(lastValor);
                            
                            
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;

                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasPagarEmPDFPeloClienteDetalhada (String dataInicial, String dataFinal, String nomeCliente) throws FileNotFoundException, DocumentException, IOException {  
            
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação Detalhada de Contas a receber do cliente "+nomeCliente);

                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasReceber = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                //tabelaRelacaoContasReceber.set
                tabelaRelacaoContasReceber.setWidthPercentage(100.0f);
                tabelaRelacaoContasReceber.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoContasReceber.addCell("Cliente");
                tabelaRelacaoContasReceber.addCell("Vencimento");
                tabelaRelacaoContasReceber.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valor from tab_contas_pagar where NomeCliente='"+nomeCliente+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valor");
                            tabelaRelacaoContasReceber.addCell(lastCliente);
                            tabelaRelacaoContasReceber.addCell(lastVencimento);
                            tabelaRelacaoContasReceber.addCell(lastValor);
                            
                            
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;

                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasReceber);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioResumidoContasPagarEmPDF1 (String dataInicial, String dataFinal) throws FileNotFoundException, DocumentException, IOException {  
            
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                //Image img = Image.getInstance("ImagemTeste.jpg");
                //img.setAlignment(Element.ALIGN_CENTER);
                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação Detalhada de Contas a pagar de "+dataInicial+" até "+dataFinal);

                //Montar a tabela gastos
                PdfPTable tabelaRelacaoContasPagar = new PdfPTable(new float[] { 2.0f, 0.5f, 0.5f});
                tabelaRelacaoContasPagar.setWidthPercentage(100.0f);
                tabelaRelacaoContasPagar.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoContasPagar.addCell("Cliente/Fornecedor");
                tabelaRelacaoContasPagar.addCell("Vencimento");
                tabelaRelacaoContasPagar.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select NomeCliente,Vencimento,valorTotal from tab_contas_pagar where VencimentoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastCliente = rs.getString("NomeCliente");
                            String lastVencimento = rs.getString("Vencimento");
                            String lastValor = rs.getString("valorTotal");
                            tabelaRelacaoContasPagar.addCell(lastCliente);
                            tabelaRelacaoContasPagar.addCell(lastVencimento);
                            tabelaRelacaoContasPagar.addCell(lastValor);
                            
                            
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;

                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das Contas: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoContasPagar);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioOrdemDeServicosEmPDF (String dataInicial, String dataFinal, String Status) throws FileNotFoundException, DocumentException, IOException {  
            
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                //Image img = Image.getInstance("ImagemTeste.jpg");
                //img.setAlignment(Element.ALIGN_CENTER);
                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação das OS de "+dataInicial+" até "+dataFinal);

                //Montar a tabela gastos
                PdfPTable tabelaRelacaoOS = new PdfPTable(new float[] { 0.5f, 1.5f, 1.5f,0.5f});
                tabelaRelacaoOS.setWidthPercentage(100.0f);
                tabelaRelacaoOS.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoOS.addCell("ID");
                tabelaRelacaoOS.addCell("Cliente");
                tabelaRelacaoOS.addCell("Equipamento");
                tabelaRelacaoOS.addCell("Valor");

                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select id,NomeCliente,NomeEquipamento,ValorTotalGeral from tab_ordem_de_servico where Status= '"+Status+"' AND DataInclusaoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID = rs.getString("id");
                            String lastCliente = rs.getString("NomeCliente");
                            String lastEquipamento = rs.getString("NomeEquipamento");
                            String lastValor = rs.getString("ValorTotalGeral");
                            tabelaRelacaoOS.addCell(lastID);
                            tabelaRelacaoOS.addCell(lastCliente);
                            tabelaRelacaoOS.addCell(lastEquipamento);
                            tabelaRelacaoOS.addCell(lastValor);
                            
                            
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;

                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das OS: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  

                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoOS);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioOrdemDeServicosGraficaEmPDF (String dataInicial, String dataFinal, String Status) throws FileNotFoundException, DocumentException, IOException {  
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20);                 //cria a stream de saída                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação das OS de "+dataInicial+" até "+dataFinal);
                //Montar a tabela gastos
                PdfPTable tabelaRelacaoOS = new PdfPTable(new float[] { 0.5f, 1.5f,0.5f});
                tabelaRelacaoOS.setWidthPercentage(100.0f);
                tabelaRelacaoOS.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoOS.addCell("ID");
                tabelaRelacaoOS.addCell("Cliente");
                tabelaRelacaoOS.addCell("Valor");
                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select * from tab_ordemdeservicografica where Status= '"+Status+"' AND DataInclusaoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID = rs.getString("id");
                            String lastCliente = rs.getString("NomeCliente");
                            String lastValor = rs.getString("ValorTotalGeral");
                            tabelaRelacaoOS.addCell(lastID);
                            tabelaRelacaoOS.addCell(lastCliente);
                            tabelaRelacaoOS.addCell(lastValor);                            
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;
                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das OS: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoOS);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioOrdemDeServicosOticaEmPDF (String dataInicial, String dataFinal, String Status) throws FileNotFoundException, DocumentException, IOException {  
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20);                 //cria a stream de saída                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação das OS de "+dataInicial+" até "+dataFinal);
                //Montar a tabela gastos
                PdfPTable tabelaRelacaoOS = new PdfPTable(new float[] { 0.5f, 1.5f,0.5f});
                tabelaRelacaoOS.setWidthPercentage(100.0f);
                tabelaRelacaoOS.setHorizontalAlignment(Element.ALIGN_LEFT);              
                tabelaRelacaoOS.addCell("ID");
                tabelaRelacaoOS.addCell("Cliente");
                tabelaRelacaoOS.addCell("Valor");
                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select * from tab_ordem_servico_otica where Status= '"+Status+"' AND DataEntradaSemBarras BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID = rs.getString("id");
                            String lastCliente = rs.getString("NomeCliente");
                            String lastValor = rs.getString("ValorTotalDaOrdemDeServico");
                            tabelaRelacaoOS.addCell(lastID);
                            tabelaRelacaoOS.addCell(lastCliente);
                            tabelaRelacaoOS.addCell(lastValor);                            
                            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));  
                            double Valor = 0;
                            try {
                                Valor = df.parse (lastValor).doubleValue(); // isto deve dar o número "1234.56"
                                totalDasContasReceber = totalDasContasReceber + Valor;
                             } catch (ParseException ex) {
                                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                    
                //COLOOCA NO FORMATO DE VIRGULA
                DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR"))); 
                String TotalCaixaString = df.format (totalDasContasReceber); // deve retornar a string formatada  
                JFormattedTextField campoFormatado = new JFormattedTextField();
                campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                campoFormatado.setText(TotalCaixaString);
                TotalCaixaString = campoFormatado.getText();
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das OS: "+TotalCaixaString);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(tabelaRelacaoOS);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioOrdemDeServicosGraficaComServicosEmPDF (String dataInicial, String dataFinal, String Status) throws FileNotFoundException, DocumentException, IOException {  
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20);                 //cria a stream de saída                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação das OS de "+dataInicial+" até "+dataFinal);
                
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                //Montar a tabela gastos                
                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select * from tab_ordemdeservicografica where Status= '"+Status+"' AND DataInclusaoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID = rs.getString("id");
                            String lastCliente = rs.getString("NomeCliente");
                            Paragraph ParagrafoClienteOS = new Paragraph("OS: "+lastID+"       Cliente: "+lastCliente);
                            doc.add(ParagrafoClienteOS);
                            //ADICIONAR OS SERVIÇOS NA TABELA  
                            try {
                                String sql2 = "Select * from tab_servico_ordemdeservicografica where id_ordemDeSErvico= '"+lastID+"'";           
                                java.sql.ResultSet rs2 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql2);
                                PdfPTable tabelaServicos = new PdfPTable(new float[] { 1.5f, 1.0f,0.8f,0.8f,1.2f,0.5f});
                                    tabelaServicos.setWidthPercentage(100.0f);
                                    tabelaServicos.setHorizontalAlignment(Element.ALIGN_LEFT); 
                                    //fazendo
                                    tabelaServicos.addCell("Serviço");
                                    tabelaServicos.addCell("Tamanho");
                                    tabelaServicos.addCell("Tipo Talão");
                                    tabelaServicos.addCell("Nº Talão");
                                    tabelaServicos.addCell("Material");
                                    tabelaServicos.addCell("Quant");
                                //Imprime o resultado no PDF
                                while (rs2.next()) {  
                                    String servico = rs2.getString("servico");
                                    String medida = rs2.getString("medida");
                                    String numeroTalao = rs2.getString("numeroTalao");
                                    String material = rs2.getString("material");
                                    String quantidade = rs2.getString("quantidade");
                                    String TipoTalao = rs2.getString("TipoTalao");
                                    tabelaServicos.addCell(servico);
                                    tabelaServicos.addCell(medida);
                                    tabelaServicos.addCell(TipoTalao); 
                                    tabelaServicos.addCell(numeroTalao);
                                    tabelaServicos.addCell(material);
                                    tabelaServicos.addCell(quantidade);   
                                    //ADICIONAR OS SERVIÇOS NA TABELA  
                                    doc.add(tabelaServicos);
                                }
                                FechaConexaoBanco(con1);  // fecha conexão com BD
                            }  catch( SQLException e){ //trata os erros SQL
                                JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                            } 
                            
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das OS: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  
                //---------------------------------------------------------------
                
                doc.add(linhaBranca);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioOrdemDeServicosGraficaComServicosOticaEmPDF (String dataInicial, String dataFinal, String Status) throws FileNotFoundException, DocumentException, IOException {  
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20);                 //cria a stream de saída                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação das OS de "+dataInicial+" até "+dataFinal);
                
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                //Montar a tabela gastos                
                //Preenche os dados da tabela de gastos
                    try {
                        String sql = "Select * from tab_ordem_servico_otica where Status= '"+Status+"' AND DataEntradaSemBarras BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String lastID = rs.getString("id");
                            String lastCliente = rs.getString("NomeCliente");
                            Paragraph ParagrafoClienteOS = new Paragraph("OS: "+lastID+"       Cliente: "+lastCliente);
                            doc.add(ParagrafoClienteOS);
                            //ADICIONAR OS SERVIÇOS NA TABELA  
                            try {
                                String sql2 = "Select * from tab_produto_ordem_de_servico where id_ordem_de_servico= '"+lastID+"'";           
                                java.sql.ResultSet rs2 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql2);
                                PdfPTable tabelaServicos = new PdfPTable(new float[] { 1.5f, 1.0f,0.8f,0.8f,1.2f,0.5f});
                                    tabelaServicos.setWidthPercentage(100.0f);
                                    tabelaServicos.setHorizontalAlignment(Element.ALIGN_LEFT); 
                                    //fazendo
                                    tabelaServicos.addCell("Código Prod.");
                                    tabelaServicos.addCell("Produto");
                                    tabelaServicos.addCell("Quantidade");
                                    tabelaServicos.addCell("Preço");
                                //Imprime o resultado no PDF
                                while (rs2.next()) {  
                                    String cod_produto = rs2.getString("cod_produto");
                                    String produto = rs2.getString("produto");
                                    String preco = rs2.getString("preco");
                                    String quantidade = rs2.getString("quantidade");
                                    tabelaServicos.addCell(cod_produto);
                                    tabelaServicos.addCell(produto);
                                    tabelaServicos.addCell(preco); 
                                    tabelaServicos.addCell(quantidade);  
                                    //ADICIONAR OS SERVIÇOS NA TABELA  
                                    doc.add(tabelaServicos);
                                }
                                FechaConexaoBanco(con1);  // fecha conexão com BD
                            }  catch( SQLException e){ //trata os erros SQL
                                JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                            } 
                            
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                    
                //COLOOCA NO FORMATO DE VIRGULA
                DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR"))); 
                String TotalCaixaString = df.format (totalDasContasReceber); // deve retornar a string formatada  
                JFormattedTextField campoFormatado = new JFormattedTextField();
                campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                campoFormatado.setText(TotalCaixaString);
                TotalCaixaString = campoFormatado.getText();    
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das OS: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  
                //---------------------------------------------------------------
                
                doc.add(linhaBranca);
                doc.add(ParagrafoTotalDasContas);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioOrdemDeServicosGraficaProdutosUtilizadosEmPDF (String dataInicial, String dataFinal) throws FileNotFoundException, DocumentException, IOException {  
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20);                 //cria a stream de saída                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação dos produtos utilizados nas OS de "+dataInicial+" até "+dataFinal);
                
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                //Montar a tabela gastos                
                //Preenche os dados da tabela de gastos
                PdfPTable tabelaServicos = new PdfPTable(new float[] { 1.5f, 0.8f,0.8f});
                tabelaServicos.setWidthPercentage(100.0f);
                tabelaServicos.setHorizontalAlignment(Element.ALIGN_LEFT); 
                                    //fazendo
                tabelaServicos.addCell("Produto");
                tabelaServicos.addCell("Tamanho");
                tabelaServicos.addCell("Quantidade");
                         //tab_ordemdeservicografica 
                try {
                        String sql = "Select * from tab_ordemdeservicografica where DataInclusaoSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {  
                            String id = rs.getString("id");
                            try {
                                String sql2 = "Select * from tab_produtoutilizado_ordemdeservicografica where id_ordemDeSErvico='"+id+"'";           
                                java.sql.ResultSet rs2 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql2);
                                //Imprime o resultado no PDF
                                while (rs2.next()) {               
                                    String produto = rs2.getString("produto");
                                    String tamanho = rs2.getString("tamanho");
                                    String quantidade = rs2.getString("quantidade");
                                    tabelaServicos.addCell(produto);
                                    tabelaServicos.addCell(tamanho);
                                    tabelaServicos.addCell(quantidade); 

                                }
                                FechaConexaoBanco(con1);  // fecha conexão com BD
                            }  catch( SQLException e){ //trata os erros SQL
                                JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                            } 
                    }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                Paragraph ParagrafoTotalDasContas = new Paragraph("Total das OS: "+totalDasContasReceber);
                ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  
                //---------------------------------------------------------------
                
                doc.add(linhaBranca);
                //doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabelaServicos);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public void GeraRelatorioOrdemDeServicosOticaProdutosUtilizadosEmPDF (String dataInicial, String dataFinal) throws FileNotFoundException, DocumentException, IOException {  
            String DinicialSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataInicial);
            String DfinalSemBarra = dataAtual.TransformaDataComBarraEmSemBarra(dataFinal);
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            double totalDasContasReceber = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20);                 //cria a stream de saída                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens                
                //Cria os textos
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                Paragraph ParagrafoInicial = new Paragraph("Relação dos produtos utilizados nas OS de "+dataInicial+" até "+dataFinal);
                
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(linhaBranca);              
                doc.add(ParagrafoInicial);
                //Montar a tabela gastos                
                //Preenche os dados da tabela de gastos
                PdfPTable tabelaServicos = new PdfPTable(new float[] { 1.5f, 0.8f,0.8f});
                tabelaServicos.setWidthPercentage(100.0f);
                tabelaServicos.setHorizontalAlignment(Element.ALIGN_LEFT); 
                                    //fazendo
                tabelaServicos.addCell("Produto");
                tabelaServicos.addCell("Quantidade");
                tabelaServicos.addCell("Preço");
                         //tab_ordemdeservicografica 
                try {
                        String sql = "Select * from tab_ordem_servico_otica where DataEntradaSemBarra BETWEEN '"+DinicialSemBarra+"' AND '"+DfinalSemBarra+"'";           
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {  
                            String id = rs.getString("id");
                            try {
                                String sql2 = "Select * from tab_produto_ordem_de_servico where id_ordem_de_servico='"+id+"'";           
                                java.sql.ResultSet rs2 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql2);
                                //Imprime o resultado no PDF
                                while (rs2.next()) {               
                                    String produto = rs2.getString("produto");
                                    String preço = rs2.getString("preco");
                                    String quantidade = rs2.getString("quantidade_pedido");
                                    tabelaServicos.addCell(produto);
                                    tabelaServicos.addCell(quantidade);
                                    tabelaServicos.addCell(preço); 

                                }
                                FechaConexaoBanco(con1);  // fecha conexão com BD
                            }  catch( SQLException e){ //trata os erros SQL
                                JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                            } 
                    }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        JOptionPane.showMessageDialog(null, "Erro no comando SQL " + e.getMessage() );
                    } 
                
                //Paragraph ParagrafoTotalDasContas = new Paragraph("Total das OS: "+totalDasContasReceber);
                //ParagrafoTotalDasContas.setAlignment(Element.ALIGN_RIGHT);  
                //---------------------------------------------------------------
                
                doc.add(linhaBranca);
                //doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabelaServicos);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    

    

    public void GeraPDFComLOGO () throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Imagens
                //Image img = Image.getInstance("/Imagens/logo.png");
                //img.setAlignment(Element.ALIGN_CENTER);
                
                //Cria os textos
                Paragraph ParagrafoInicial = new Paragraph("LogoMarca abaixo\n");
                Paragraph linhaBranca = new Paragraph("\n");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                    
                //Adiciona no documento
                //Image img = Image.getInstance("/Imagens/Logo.png");
                
                //Image logo = Image.getInstance("/home/gabriel/workspace/iText/src/wehavesciencelogo2.jpeg");
 
                //Alinhamento p/ a esquerda <<<
                //logo.setAlignment(Image.ALIGN_LEFT);
 
                //doc.add(logo);
         
                // Definindo uma fonte, com tamanho 20 e negrito
                //Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
                
                //doc.add(img);               
                doc.add(ParagrafoInicial);
                
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    
    public void testePDF() throws FileNotFoundException, DocumentException, IOException {             
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                
                //TESTE DE FONTE
                Font f3 = new Font(Font.FontFamily.COURIER, 20, 20, BaseColor.BLUE);
                //f3.getCalculatedLeading(1f);
                //f3.setSize(5f);
                
                //Font f = new Font(COURIER, 20, Font.BOLD);
                Font font;
                //font = new Font(FontFamily.COURIER, 20, Font.BOLD);
                
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                Paragraph ParagrafoEmpresa = new Paragraph("Nome: ");
                Paragraph ParagrafoEmpresaCNPJ = new Paragraph("CNPJ: ");
                Paragraph ParagrafoEmpresaTelefone = new Paragraph("Telefone: ");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linhaObservacao = new Paragraph("Osbservação:");
                Paragraph ParagrafoOS = new Paragraph("Ordem de serviço: ");
                ParagrafoOS.setFont(f3);
                ParagrafoOS.setAlignment(Element.ALIGN_CENTER);
                Paragraph ParagrafoClienteNome = new Paragraph("Cliente: ");
                Paragraph ParagrafoClienteCPF = new Paragraph("CPF: ");
                Paragraph ParagrafoClienteTelefone = new Paragraph("Telefone: ");
                Paragraph ParagrafoClienteEquip = new Paragraph("Equipamento: ");
                Paragraph ParagrafoClienteAcesso = new Paragraph("Acessório: ");
                Paragraph ParagrafoClienteRelato = new Paragraph("Relato do Cliente: ");
                Paragraph ParagrafoServicoEfetuado = new Paragraph("Serviço Efetuado: ");
                Paragraph ParagrafoValorServico = new Paragraph("Valor do Serviço: ");
                Paragraph ParagrafoProdutos = new Paragraph("Produtos adicionados na OS:");
                Paragraph ParagrafoTotal = new Paragraph("Total de produtos utilizados na OS: ");
                Paragraph ParagrafoTotalGeral = new Paragraph("Total de produtos + Serviço: ");
                Paragraph ParagrafoFormaPagamento = new Paragraph("Forma de pagamento: ");
                Paragraph ParagrafoData = new Paragraph("Data da inclusão: ");
                ParagrafoData.setFont(f3);
                
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 2.0f, 0.5f, 0.5f });
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Código");
                tabela.addCell("Produto");
                tabela.addCell("Quant");
                tabela.addCell("Preço");
                
                    int vezesDoLup = 0;
                        while (vezesDoLup < 5) {     
                            tabela.addCell("0");
                            tabela.addCell("Produto Teste");
                            tabela.addCell("1,00");
                            tabela.addCell("10");
                            vezesDoLup++;
                        }

                
                //---------------------------------------------------------------
                
                //Adiciona no documento
                colocarLogoNoPdf(doc);
                doc.add(ParagrafoEmpresa);
                doc.add(ParagrafoEmpresaCNPJ);
                doc.add(ParagrafoEmpresaTelefone);
                doc.add(ParagrafoOS);
                doc.add(ParagrafoClienteNome);
                doc.add(ParagrafoClienteCPF);
                doc.add(ParagrafoClienteTelefone);
                doc.add(ParagrafoClienteEquip);
                doc.add(ParagrafoClienteAcesso);
                doc.add(linhaObservacao);
                doc.add(ParagrafoClienteRelato);
                doc.add(ParagrafoServicoEfetuado);
                doc.add(ParagrafoValorServico);
                //Adicionar os produtos no documento
                doc.add(ParagrafoProdutos);
                doc.add(tabela);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);  
                doc.add(ParagrafoTotalGeral);
                doc.add(linhaBranca);
                doc.add(ParagrafoFormaPagamento);
                doc.add(linhaBranca);
                doc.add(ParagrafoData);

                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start", nomeDoArquivoPdf});  
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    
    public PdfPTable criaTabelaDeControleDeREceita(){
        //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 1.9f, 1.9f });
                tabela.setWidthPercentage(80.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabela.addCell("IDENTIFICAÇÃO DO COMPRADOR");
                tabela.addCell("IDENTIFICAÇÃO DO FORNECEDOR");
                tabela.addCell("Nome: ______________________\n"
                             + "____________________________\n"
                             + "Ident.:_______Órg. Emissor_____\n"
                             + "End.:________________________\n"
                             + "____________________________\n"
                             + "Cidade:________________UF:___\n"
                             + "Telefone:_____________________\n"
                             + "");
                tabela.addCell("\n\n\n\n\n"
                             + "   ____________________________\n"
                             + "      ASS. DO FARMACÊUTICO\n"
                             + "      DATA: ____/____/_____    \n");
                
                return tabela;
    }
    
    public void testeGRADE_PDF() throws FileNotFoundException, DocumentException, IOException {             
            criaPastaDentroDoDSistema("Relatorios");
            Document doc = null;
            OutputStream os = null;  
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                
                
                
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                //cria a stream de saída
                os = new FileOutputStream(nomeDoArquivoPdf); 
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                Paragraph ParagrafoEmpresa = new Paragraph("Nome: ");
                Paragraph ParagrafoEmpresaCNPJ = new Paragraph("CNPJ: ");
                Paragraph ParagrafoEmpresaTelefone = new Paragraph("Telefone: ");
                Paragraph branco = new Paragraph(" ");
                
                //Montar a tabela
                PdfPTable tabela = criaTabelaDeControleDeREceita();

                //---------------------------------------------------------------
                
                //Adiciona no documento
                colocarLogoNoPdf(doc);
                doc.add(ParagrafoEmpresa);
                doc.add(ParagrafoEmpresaCNPJ);
                doc.add(ParagrafoEmpresaTelefone);
                doc.add(branco);
                doc.add(branco);
                doc.add(branco);
                doc.add(branco);
                doc.add(tabela);


                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start", nomeDoArquivoPdf});  
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    }
    

    
    public void GeraRelatorioNFEEmitidasEmPDF (String DataInicial, String DataFinal, String modelo) throws FileNotFoundException, DocumentException, IOException {  
            criaPastaDentroDoDSistema("Relatorios");
            String dataInicioSemBarras = dataAtual.TransformaDataComBarraEmSemBarra(DataInicial);
            String dataFinalSemBarras = dataAtual.TransformaDataComBarraEmSemBarra(DataFinal);
            Document doc = null;
            OutputStream os = null;       
            String nomeDoArquivoPdf = "C:\\DSistema\\Relatorios\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                //cria o documento tamanho A4, margens de 2,54cm
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                os = new FileOutputStream(nomeDoArquivoPdf);
                //associa a stream de saída ao 
                PdfWriter.getInstance(doc, os);  
                //abre o documento
                doc.open();
                //Cria os textos
                Paragraph ParagrafoEmpresa = new Paragraph("Relação de NF-e Modelo:"+modelo+" emitidas entre "+DataInicial+" e "+DataFinal+" \n");
                ParagrafoEmpresa.setAlignment(Element.ALIGN_CENTER);
                
                Paragraph linhaBranca = new Paragraph("\n");
                //Paragraph linhaObservacao = new Paragraph("Osbservação:");

                Paragraph linha = new Paragraph("________________________________________");
                linha.setAlignment(Element.ALIGN_CENTER);
                int totalDeNotas = 0;
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.8f,0.8f,0.8f, 2.0f, 0.8f, 2.0f });
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Nº");
                tabela.addCell("Data");
                tabela.addCell("Status");
                tabela.addCell("Destinatário");
                tabela.addCell("Valor");
                tabela.addCell("Chave de Acesso");
                    try {
                        String sql = "Select * from tab_nota_fiscal_lancamento where Modelo='"+modelo+"' AND DataDaNotaSemBarras BETWEEN '"+dataInicioSemBarras+"' AND '"+dataFinalSemBarras+"'";
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF
                        while (rs.next()) {               
                            String NumeroNF = rs.getString("NumeroNF");
                            String DataDaNota = rs.getString("DataDaNota");
                            String Status = rs.getString("Status");
                            String NomeDestinatario = rs.getString("NomeDestinatario");
                            String ValorTotalDaNota = rs.getString("ValorTotalDaNota");
                            String ChaveAcesso = rs.getString("ChaveAcessoSemNFe");
                            tabela.addCell(NumeroNF);
                            tabela.addCell(DataDaNota);
                            tabela.addCell(Status);
                            tabela.addCell(NomeDestinatario);
                            tabela.addCell(ValorTotalDaNota);
                            tabela.addCell(ChaveAcesso);
                            totalDeNotas++;
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioNFEEmitidasEmPDF");
                    }
                    
                    Paragraph ParagrafoTotal = new Paragraph("Total de Notas: "+totalDeNotas);
                    
                //---------------PEGUEI AS FORMAS DE PAGAMENTOS PREENCHIDAS---------------------------
                //Adiciona no documento
                
                colocarLogoNoPdf(doc);
                doc.add(linhaBranca);
                doc.add(ParagrafoEmpresa);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
                } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
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
                 JOptionPane.showMessageDialog(null,"Err","Erro ao criar o diretório DSistema" + ex.toString(),JOptionPane.ERROR_MESSAGE);   
            } 
        }else{
            JOptionPane.showMessageDialog(null,"O sistema operacional não é Windows");   
        }
    }
    
    public void GeraRelatorioDoCaixaEmPDF2 (String dataInicial) throws FileNotFoundException, DocumentException, IOException {  
            criaPastaRelatorios("RelatoriosDSistema");
            DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR"))); 
            Document doc = null;
            OutputStream os = null;   
            int total = 0;
            double totalCaixaAtual = 0;
            double totalDinheiro = 0;
                double totalCartao = 0;
                double totalParcelado = 0;
                double totalCheque = 0;
            String nomeDoArquivoPdf = "C:\\RelatoriosDSistema\\"+dataAtual.RetornaDataAtualSemBarra()+horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
            try {
                doc = new Document(PageSize.A4, 20, 20, 20, 20); 
                os = new FileOutputStream(nomeDoArquivoPdf); 
                PdfWriter.getInstance(doc, os);  
                doc.open();
                Paragraph ParagrafoInicial = new Paragraph("---------- Relatório do Caixa ("+dataInicial+") ----------\n");
                Paragraph linhaBranca = new Paragraph("\n");
                Paragraph linha = new Paragraph("__________________________________________________________________");
                Paragraph linhaPontilhada = new Paragraph("----------------------------------------------------------------------------------------------------------------");
                ParagrafoInicial.setAlignment(Element.ALIGN_CENTER);
                //Montar a tabela
                PdfPTable tabela = new PdfPTable(new float[] { 0.4f, 1.5f, 0.5f});
                tabela.setWidthPercentage(100.0f);
                tabela.setHorizontalAlignment(Element.ALIGN_LEFT);
                tabela.addCell("Nº");
                tabela.addCell("Histórico");
                tabela.addCell("Valor");
                
                Connection connection = null;
                    try {
                        String sql = "Select * from tab_pedido where status='Concluido' AND DataInclusao = '"+dataInicial+"'";
                        String sql3 = "Select * from tab_conta_caixa where status='Concluido' AND data = '"+dataInicial+"' AND Historico like 'inicial%'";
                        String sql2 = "Select * from tab_conta_caixa where status='Concluido' AND data = '"+dataInicial+"' AND tipoLancamento<>'Inicial do Dia'";
                        java.sql.ResultSet rs2 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql2);
                        java.sql.ResultSet rs3 = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql3);
                        java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                        //Imprime o resultado no PDF 
                        
                        while (rs3.next()) {
                                //PREENCHE INCIAL DO DIA
                                String idContaINICIAL = rs3.getString("id");
                                String historicoContaINICIAL = rs3.getString("Historico");
                                String valorContaINICIAL = rs3.getString("valor");
                                tabela.addCell(idContaINICIAL);
                                tabela.addCell(historicoContaINICIAL.toUpperCase());
                                tabela.addCell(valorContaINICIAL);
                                //totalCaixaAtual alimentar essa variavel
                                try {
                                    double valorContaINICIAL1 = 0;
                                    valorContaINICIAL1 = df.parse (valorContaINICIAL).doubleValue(); // isto deve dar o número "1234.56"
                                    totalCaixaAtual = totalCaixaAtual + valorContaINICIAL1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                        }
                        while (rs.next()) {               
                            String lastID_pedido = rs.getString("id");
                            String lastCliente = rs.getString("NomeCliente");
                            String lastValorTotal = rs.getString("ValorTotal");
                            String lastValorAVista = rs.getString("ValorAVista");
                            String lastValorCheque = rs.getString("ValorCheque");
                            String lastValorParcelado = rs.getString("ValorParcelado");
                            String lastValorCartao = rs.getString("ValorCartao");
                            String troco = rs.getString("troco");
                            
                            //Verifica valor digitado a vista para somar
                            if (!lastValorAVista.equals("0,00")){
                                tabela.addCell(lastID_pedido);
                                tabela.addCell("PEDIDO - "+lastCliente.toUpperCase());
                                tabela.addCell(lastValorTotal);
                                try {
                                    double totalDinheiro1;
                                    double troco1;
                                    totalDinheiro1 = df.parse (lastValorAVista).doubleValue(); // isto deve dar o número "1234.56"
                                    troco1 = df.parse (troco).doubleValue(); // isto deve dar o número "1234.56"
                                    totalDinheiro = totalDinheiro + (totalDinheiro1 - troco1);
                                    totalCaixaAtual = totalCaixaAtual + totalDinheiro1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            //Verifica valor digitado cartao para somar
                            if (!lastValorCartao.equals("0,00")){
                                try {
                                    double totalCartao1;
                                    totalCartao1 = df.parse (lastValorCheque).doubleValue(); // isto deve dar o número "1234.56"
                                    totalCartao = totalCartao + totalCartao1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            //Verifica valor digitado cheque para somar
                            if (!lastValorCheque.equals("0,00")){
                                try {
                                    double totalCheque1;
                                    totalCheque1 = df.parse (lastValorCheque).doubleValue(); // isto deve dar o número "1234.56"
                                    totalCheque = totalCheque + totalCheque1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            //Verifica valor digitado cheque para somar
                            if (!lastValorParcelado.equals("0,00")){
                                try {
                                    double totalParcelado1;
                                    totalParcelado1 = df.parse (lastValorCheque).doubleValue(); // isto deve dar o número "1234.56"
                                    totalParcelado = totalParcelado + totalParcelado1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            total = total + 1;
                            double Valor = 0;
                            
                        }
                        while (rs2.next()) {
                                //PREENCHE AS DESPESAS
                                String idConta = rs2.getString("id");
                                String historicoConta = rs2.getString("Historico");
                                String valorConta = rs2.getString("valor");
                                tabela.addCell(idConta);
                                tabela.addCell(historicoConta.toUpperCase());
                                tabela.addCell(valorConta);
                                try {
                                    double valorConta1 = 0;
                                    valorConta1 = df.parse (valorConta).doubleValue(); // isto deve dar o número "1234.56"
                                    totalCaixaAtual = totalCaixaAtual - valorConta1;
                                } catch (ParseException ex) {
                                       Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                                }
                        }
                        FechaConexaoBanco(con1);  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        criaArquivoErroEEnviaEmail(e,"GeraRelatorioVendasPeriodoEmPDF");
                    } 
                    String TotalCaixaString = df.format (totalCaixaAtual); // deve retornar a string formatada  
                JFormattedTextField campoFormatado = new JFormattedTextField();
                campoFormatado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));    
                campoFormatado.setText(TotalCaixaString);
                TotalCaixaString = campoFormatado.getText();
                //String totall = atualizaTotalPedidosFluxo(j);
                
                //double totalDinheiro = 0;
                //double totalCartao = 0;
                //double totalParcelado = 0;
                //double totalCheque = 0;
                
                String TotalDinheiroString = df.format (totalDinheiro); // deve retornar a string formatada  
                String TotalCartaoString = df.format (totalCartao); // deve retornar a string formatada  
                String TotalParceladoString = df.format (totalParcelado); // deve retornar a string formatada  
                String TotalChequeString = df.format (totalCheque); // deve retornar a string formatada  
                
                Paragraph ParagrafoTotalEmCaixa = new Paragraph("Total em Caixa: R$ "+TotalCaixaString);   
                
                Paragraph ParagrafoTotal = new Paragraph("Total: "+total+" Vendas"); 
                ParagrafoTotal.setAlignment(Element.ALIGN_LEFT);
                campoFormatado.setText(TotalDinheiroString);
                Paragraph paragrafoAvista = new Paragraph("\nValor em dinheiro: R$ "+campoFormatado.getText());
                campoFormatado.setText(TotalCartaoString);
                Paragraph paragrafoCartao = new Paragraph("\nValor em cartão: R$ "+campoFormatado.getText());
                campoFormatado.setText(TotalChequeString);
                Paragraph paragrafoCheque = new Paragraph("\nValor em Cheque: R$ "+campoFormatado.getText());
                campoFormatado.setText(TotalParceladoString);
                Paragraph paragrafoParcelado = new Paragraph("\nValor Parcelado: R$ "+campoFormatado.getText());
                
                Paragraph paragrafoTotaisPagamento = new Paragraph("\n-------------------- Totais por forma de pagamento --------------------");
                paragrafoTotaisPagamento.setAlignment(Element.ALIGN_CENTER);
                //---------------------------------------------------------------
                //Adiciona no documento
                colocarLogoNoPdf(doc);             
                doc.add(ParagrafoInicial);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(tabela);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotalEmCaixa);
                doc.add(linhaBranca);
                doc.add(linhaBranca);
                doc.add(ParagrafoTotal);
                doc.add(linhaBranca);
                doc.add(paragrafoTotaisPagamento);
                doc.add(paragrafoAvista);
                doc.add(paragrafoCartao);
                doc.add(paragrafoCheque);
                doc.add(paragrafoParcelado);
                doc.add(linhaBranca);
                  
                Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",nomeDoArquivoPdf});
            } finally {
                if (doc != null) {
                    //fechamento do documento
                    doc.close();
                }
                if (os != null) {
                   //fechamento da stream de saída
                   os.close();                
                }
            }
    } 
    
    public String retornaPrecoCustoProduto (String codigoProduto){
            String preco = "0";
            try {
                String sql = "Select * from tab_produto where id= '"+codigoProduto+"'";
                java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                while (rs.next()){              
                    String lastPreco = rs.getString("preco_custo_medio"); 
                    preco = lastPreco;
                }
                FechaConexaoBanco(con1);
            } catch( SQLException e){ //trata os erros SQL
                criaArquivoErroEEnviaEmail(e, "retornaPrecoCustoProduto");
        }    
            return preco;
    }
    
    public String retornaPrecoProduto (String codigoProduto){
            String preco = "0";
            try {
                String sql = "Select * from tab_produto where id= '"+codigoProduto+"'";
                java.sql.ResultSet rs = (java.sql.ResultSet) AbreConexaoBanco().executeQuery(sql);
                while (rs.next()){              
                    String lastPreco = rs.getString("preco_tabela"); 
                    preco = lastPreco;
                }
                FechaConexaoBanco(con1);
            } catch( SQLException e){ //trata os erros SQL
                criaArquivoErroEEnviaEmail(e, "retornaPrecoProduto");
        }    
            return preco;
    }
    
    */
    
}