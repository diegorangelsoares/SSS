package br.com.sss.ireport;

import br.com.sss.Control.CaminhoImagem;
import br.com.sss.Control.Conexao;
import br.com.sss.Control.MensagemErro;
//import View.JanelaConsultaMedica;
//import it.businesslogic.ireport.connection.JRXMLDataSource;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.faces.context.FaceContext;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JRExporter;
//import net.sf.jasperreports.engine.JRExporterParameter;
//import net.sf.jasperreports.engine.JRResultSetDataSource;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperPrintManager;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.JasperRunManager;
//import net.sf.jasperreports.engine.data.JRXmlDataSource;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.view.JasperViewer;
//import org.jdom2.Document;
import org.xml.sax.SAXException;

//import javax.servlet.http.HttpServletResponse;   

/**
 * @author Diego Rangel  
 */

public class Ireport {
    
        Conexao co = new Conexao();
        CaminhoImagem caminhoImagemIcone = new CaminhoImagem();
        MensagemErro mensagemErro = new MensagemErro();
        
        public Ireport() {
        }
        
//        public void gerar( String layout , String id, int idMedico) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( layout );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//                
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                "     tab_receitamedica.`id` AS tab_receitamedica_id,\n" +
//                "     tab_receitamedica.`nomePaciente` AS tab_receitamedica_nomePaciente,\n" +
//                "     tab_receitamedica.`nomeMedico` AS tab_receitamedica_nomeMedico,\n" +
//                "     tab_receitamedica.`descricao` AS tab_receitamedica_descricao,\n" +
//                "     tab_receitamedica.`dataReceita` AS tab_receitamedica_dataReceita,\n" +
//                "     tab_receitamedica.`comControle` AS tab_receitamedica_comControle,\n" +
//                "     tab_medicamento_receita.`id` AS tab_medicamento_receita_id,\n" +
//                "     tab_medicamento_receita.`id_receita` AS tab_medicamento_receita_id_receita,\n" +
//                "     tab_medicamento_receita.`medicamento` AS tab_medicamento_receita_medicamento,\n" +
//                "     tab_medicamento_receita.`medida` AS tab_medicamento_receita_medida,\n" +
//                "     tab_medicamento_receita.`quantidade` AS tab_medicamento_receita_quantidade,\n" +
//                "     tab_medicamento_receita.`posologia` AS tab_medicamento_receita_posologia\n" +
//                "FROM\n" +
//                "     `tab_empresa` tab_empresa,\n" +
//                "     `tab_receitamedica` tab_receitamedica,\n" +
//                "     `tab_medicamento_receita` tab_medicamento_receita\n" +
//                "WHERE\n" +
//                "     tab_empresa.id = '1'\n" +
//                " AND tab_receitamedica.id = '2'\n" +
//                " AND tab_medicamento_receita.id_receita = '2'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//                //impressao.set
//                
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Impressão");
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//                
//                
//        }
//        
//        public void gerarReceitaMedica( String caminhoIreport , String id, String idMedico) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                "     tab_medicamento_receita.`id` AS tab_medicamento_receita_id,\n" +
//                "     tab_medicamento_receita.`id_receita` AS tab_medicamento_receita_id_receita,\n" +
//                "     tab_medicamento_receita.`medicamento` AS tab_medicamento_receita_medicamento,\n" +
//                "     tab_medicamento_receita.`medida` AS tab_medicamento_receita_medida,\n" +
//                "     tab_medicamento_receita.`quantidade` AS tab_medicamento_receita_quantidade,\n" +
//                "     tab_medicamento_receita.`posologia` AS tab_medicamento_receita_posologia,\n" +
//                "     tab_medicamento_receita.`uso` AS tab_medicamento_receita_uso,\n" +
//                "     tab_receitamedica.`id` AS tab_receitamedica_id,\n" +
//                "     tab_receitamedica.`nomePaciente` AS tab_receitamedica_nomePaciente,\n" +
//                "     tab_receitamedica.`nomeMedico` AS tab_receitamedica_nomeMedico,\n" +
//                "     tab_receitamedica.`descricao` AS tab_receitamedica_descricao,\n" +
//                "     tab_receitamedica.`dataReceita` AS tab_receitamedica_dataReceita,\n" +
//                "     tab_receitamedica.`comControle` AS tab_receitamedica_comControle,\n" +
//                "     tab_receitamedica.`uso` AS tab_receitamedica_uso\n" +
//                "FROM\n" +
//                "     `tab_empresa` tab_empresa,\n" +
//                "     `tab_medicamento_receita` tab_medicamento_receita,\n" +
//                "     `tab_receitamedica` tab_receitamedica\n" +
//                "WHERE\n" +
//                "      tab_medicamento_receita.id_receita='"+id+"'\n" +
//                "and   tab_empresa.id='1'\n" +
//                "and   tab_receitamedica.id='"+id+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir Receita");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//        }
//        
//        public void gerarReceitaMedicaComControle( String caminhoIreport , String id, String idMedico,String nomeMedico) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                "     tab_receitamedica.`id` AS tab_receitamedica_id,\n" +
//                "     tab_receitamedica.`nomePaciente` AS tab_receitamedica_nomePaciente,\n" +
//                "     tab_receitamedica.`nomeMedico` AS tab_receitamedica_nomeMedico,\n" +
//                "     tab_receitamedica.`descricao` AS tab_receitamedica_descricao,\n" +
//                "     tab_receitamedica.`dataReceita` AS tab_receitamedica_dataReceita,\n" +
//                "     tab_receitamedica.`comControle` AS tab_receitamedica_comControle,\n" +
//                "     tab_medicamento_receita.`id` AS tab_medicamento_receita_id,\n" +
//                "     tab_medicamento_receita.`id_receita` AS tab_medicamento_receita_id_receita,\n" +
//                "     tab_medicamento_receita.`medicamento` AS tab_medicamento_receita_medicamento,\n" +
//                "     tab_medicamento_receita.`medida` AS tab_medicamento_receita_medida,\n" +
//                "     tab_medicamento_receita.`quantidade` AS tab_medicamento_receita_quantidade,\n" +
//                "     tab_medicamento_receita.`posologia` AS tab_medicamento_receita_posologia,\n" +
//                "     tab_receitamedica.`uso` AS tab_receitamedica_uso,\n" +
//                "     tab_medicamento_receita.`uso` AS tab_medicamento_receita_uso,\n" +
//                "     tab_medico.`id` AS tab_medico_id,\n" +
//                "     tab_medico.`nome` AS tab_medico_nome,\n" +
//                "     tab_medico.`cpf` AS tab_medico_cpf,\n" +
//                "     tab_medico.`dataNascimento` AS tab_medico_dataNascimento,\n" +
//                "     tab_medico.`cro` AS tab_medico_cro,\n" +
//                "     tab_medico.`rua` AS tab_medico_rua,\n" +
//                "     tab_medico.`numero` AS tab_medico_numero,\n" +
//                "     tab_medico.`telefone` AS tab_medico_telefone,\n" +
//                "     tab_medico.`celular` AS tab_medico_celular,\n" +
//                "     tab_medico.`bairro` AS tab_medico_bairro,\n" +
//                "     tab_medico.`uf` AS tab_medico_uf,\n" +
//                "     tab_medico.`cidade` AS tab_medico_cidade,\n" +
//                "     tab_medico.`cep` AS tab_medico_cep\n" +
//                "FROM\n" +
//                "     `tab_empresa` tab_empresa,\n" +
//                "     `tab_receitamedica` tab_receitamedica,\n" +
//                "     `tab_medicamento_receita` tab_medicamento_receita,\n" +
//                "     `tab_medico` tab_medico\n" +
//                "WHERE\n" +
//                "     tab_receitamedica.id = '"+id+"'\n" +
//                " AND tab_medicamento_receita.id_receita = '"+id+"'\n" +
//                " AND tab_medico.nome = '"+nomeMedico+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir Receita");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//        }
// 
//        public void gerarFichaPaciente( String caminhoIreport , String id_paciente, String idMedico) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                    "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                    "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                    "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                    "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                    "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                    "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                    "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                    "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                    "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                    "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                    "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                    "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                    "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                    "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                    "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                    "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                    "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                    "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                    "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                    "     tab_medico.`id` AS tab_medico_id,\n" +
//                    "     tab_medico.`nome` AS tab_medico_nome,\n" +
//                    "     tab_medico.`cpf` AS tab_medico_cpf,\n" +
//                    "     tab_medico.`dataNascimento` AS tab_medico_dataNascimento,\n" +
//                    "     tab_medico.`cro` AS tab_medico_cro,\n" +
//                    "     tab_medico.`rua` AS tab_medico_rua,\n" +
//                    "     tab_medico.`numero` AS tab_medico_numero,\n" +
//                    "     tab_medico.`telefone` AS tab_medico_telefone,\n" +
//                    "     tab_medico.`celular` AS tab_medico_celular,\n" +
//                    "     tab_medico.`bairro` AS tab_medico_bairro,\n" +
//                    "     tab_medico.`uf` AS tab_medico_uf,\n" +
//                    "     tab_medico.`cidade` AS tab_medico_cidade,\n" +
//                    "     tab_medico.`cep` AS tab_medico_cep,\n" +
//                    "     tab_paciente.`id` AS tab_paciente_id,\n" +
//                    "     tab_paciente.`nome` AS tab_paciente_nome,\n" +
//                    "     tab_paciente.`rua` AS tab_paciente_rua,\n" +
//                    "     tab_paciente.`numero` AS tab_paciente_numero,\n" +
//                    "     tab_paciente.`telefone` AS tab_paciente_telefone,\n" +
//                    "     tab_paciente.`celular` AS tab_paciente_celular,\n" +
//                    "     tab_paciente.`bairro` AS tab_paciente_bairro,\n" +
//                    "     tab_paciente.`cidade` AS tab_paciente_cidade,\n" +
//                    "     tab_paciente.`estado` AS tab_paciente_estado,\n" +
//                    "     tab_paciente.`cep` AS tab_paciente_cep,\n" +
//                    "     tab_paciente.`cpf` AS tab_paciente_cpf,\n" +
//                    "     tab_paciente.`historico` AS tab_paciente_historico,\n" +
//                    "     tab_paciente.`email` AS tab_paciente_email,\n" +
//                    "     tab_paciente.`observacao` AS tab_paciente_observacao,\n" +
//                    "     tab_paciente.`dataNascimento` AS tab_paciente_dataNascimento,\n" +
//                    "     tab_paciente.`alergico` AS tab_paciente_alergico\n" +
//                    "FROM\n" +
//                    "     `tab_empresa` tab_empresa,\n" +
//                    "     `tab_medico` tab_medico,\n" +
//                    "     `tab_paciente` tab_paciente\n" +
//                    "where\n" +
//                    "      tab_empresa.id='1'\n" +
//                    "AND\n" +
//                    "      tab_medico.id='"+idMedico+"'\n" +
//                    "AND\n" +
//                    "      tab_paciente.id='"+id_paciente+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir ficha de orçamento");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//        }
//        
//        public void gerarFichaPacientePreenchida( String caminhoIreport , String id_paciente, String id_fichaPaciente) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                "     tab_paciente.`id` AS tab_paciente_id,\n" +
//                "     tab_paciente.`nome` AS tab_paciente_nome,\n" +
//                "     tab_paciente.`rua` AS tab_paciente_rua,\n" +
//                "     tab_paciente.`numero` AS tab_paciente_numero,\n" +
//                "     tab_paciente.`telefone` AS tab_paciente_telefone,\n" +
//                "     tab_paciente.`celular` AS tab_paciente_celular,\n" +
//                "     tab_paciente.`bairro` AS tab_paciente_bairro,\n" +
//                "     tab_paciente.`cidade` AS tab_paciente_cidade,\n" +
//                "     tab_paciente.`estado` AS tab_paciente_estado,\n" +
//                "     tab_paciente.`cep` AS tab_paciente_cep,\n" +
//                "     tab_paciente.`cpf` AS tab_paciente_cpf,\n" +
//                "     tab_paciente.`historico` AS tab_paciente_historico,\n" +
//                "     tab_paciente.`email` AS tab_paciente_email,\n" +
//                "     tab_paciente.`observacao` AS tab_paciente_observacao,\n" +
//                "     tab_paciente.`dataNascimento` AS tab_paciente_dataNascimento,\n" +
//                "     tab_paciente.`alergico` AS tab_paciente_alergico,\n" +
//                "     tab_paciente.`estadoCivil` AS tab_paciente_estadoCivil,\n" +
//                "     tab_paciente.`sexo` AS tab_paciente_sexo,\n" +
//                "     tab_paciente.`rg` AS tab_paciente_rg,\n" +
//                "     tab_paciente.`profissao` AS tab_paciente_profissao,\n" +
//                "     tab_paciente.`emissor` AS tab_paciente_emissor,\n" +
//                "     tab_ficha_paciente.`id` AS tab_ficha_paciente_id,\n" +
//                "     tab_ficha_paciente.`id_paciente` AS tab_ficha_paciente_id_paciente,\n" +
//                "     tab_ficha_paciente.`nomePaciente` AS tab_ficha_paciente_nomePaciente,\n" +
//                "     tab_ficha_paciente.`cpfPaciente` AS tab_ficha_paciente_cpfPaciente,\n" +
//                "     tab_ficha_paciente.`motivoConsulta` AS tab_ficha_paciente_motivoConsulta,\n" +
//                "     tab_ficha_paciente.`historicoDoencaAtual` AS tab_ficha_paciente_historicoDoencaAtual,\n" +
//                "     tab_ficha_paciente.`sobTratamentoMedico` AS tab_ficha_paciente_sobTratamentoMedico,\n" +
//                "     tab_ficha_paciente.`tomandoMedicamento` AS tab_ficha_paciente_tomandoMedicamento,\n" +
//                "     tab_ficha_paciente.`medicamentoTomando` AS tab_ficha_paciente_medicamentoTomando,\n" +
//                "     tab_ficha_paciente.`casoDeDiabetes` AS tab_ficha_paciente_casoDeDiabetes,\n" +
//                "     tab_ficha_paciente.`qualGrauParentesco` AS tab_ficha_paciente_qualGrauParentesco,\n" +
//                "     tab_ficha_paciente.`senteMuitaSede` AS tab_ficha_paciente_senteMuitaSede,\n" +
//                "     tab_ficha_paciente.`urinaComMuitaFrequencia` AS tab_ficha_paciente_urinaComMuitaFrequencia,\n" +
//                "     tab_ficha_paciente.`feridasDemoramSicatrizar` AS tab_ficha_paciente_feridasDemoramSicatrizar,\n" +
//                "     tab_ficha_paciente.`temTossePersistente` AS tab_ficha_paciente_temTossePersistente,\n" +
//                "     tab_ficha_paciente.`escarrouSanque` AS tab_ficha_paciente_escarrouSanque,\n" +
//                "     tab_ficha_paciente.`costumaTerFebre` AS tab_ficha_paciente_costumaTerFebre,\n" +
//                "     tab_ficha_paciente.`jaTomouAnestesia` AS tab_ficha_paciente_jaTomouAnestesia,\n" +
//                "     tab_ficha_paciente.`teveReacaoAnestesia` AS tab_ficha_paciente_teveReacaoAnestesia,\n" +
//                "     tab_ficha_paciente.`temAlergia` AS tab_ficha_paciente_temAlergia,\n" +
//                "     tab_ficha_paciente.`alergiaAque` AS tab_ficha_paciente_alergiaAque,\n" +
//                "     tab_ficha_paciente.`temProblemaCoracao` AS tab_ficha_paciente_temProblemaCoracao,\n" +
//                "     tab_ficha_paciente.`senteCoracaoBaterRapido` AS tab_ficha_paciente_senteCoracaoBaterRapido,\n" +
//                "     tab_ficha_paciente.`costumaTerPernasInchadas` AS tab_ficha_paciente_costumaTerPernasInchadas,\n" +
//                "     tab_ficha_paciente.`faltaDeAr` AS tab_ficha_paciente_faltaDeAr,\n" +
//                "     tab_ficha_paciente.`teveHemoragia` AS tab_ficha_paciente_teveHemoragia,\n" +
//                "     tab_ficha_paciente.`teveTransfusao` AS tab_ficha_paciente_teveTransfusao,\n" +
//                "     tab_ficha_paciente.`algumProblemaImportante` AS tab_ficha_paciente_algumProblemaImportante,\n" +
//                "     tab_ficha_paciente.`qualProblemaImportante` AS tab_ficha_paciente_qualProblemaImportante,\n" +
//                "     tab_ficha_paciente.`gravida` AS tab_ficha_paciente_gravida,\n" +
//                "     tab_ficha_paciente.`algumMetodoContraceptivo` AS tab_ficha_paciente_algumMetodoContraceptivo,\n" +
//                "     tab_ficha_paciente.`amamentando` AS tab_ficha_paciente_amamentando,\n" +
//                "     tab_ficha_paciente.`assistidoPorAlgumMedico` AS tab_ficha_paciente_assistidoPorAlgumMedico,\n" +
//                "     tab_ficha_paciente.`foiHospitalizadoEm5anos` AS tab_ficha_paciente_foiHospitalizadoEm5anos,\n" +
//                "     tab_ficha_paciente.`fezExamesEm2anos` AS tab_ficha_paciente_fezExamesEm2anos,\n" +
//                "     tab_ficha_paciente.`atendidoPorPsicologo` AS tab_ficha_paciente_atendidoPorPsicologo,\n" +
//                "     tab_ficha_paciente.`perdeuGanhou10kilos` AS tab_ficha_paciente_perdeuGanhou10kilos,\n" +
//                "     tab_ficha_paciente.`vacinado` AS tab_ficha_paciente_vacinado,\n" +
//                "     tab_ficha_paciente.`qualVacina` AS tab_ficha_paciente_qualVacina,\n" +
//                "     tab_ficha_paciente.`sangramentoGengival` AS tab_ficha_paciente_sangramentoGengival,\n" +
//                "     tab_ficha_paciente.`tratamentoPeriodontal` AS tab_ficha_paciente_tratamentoPeriodontal,\n" +
//                "     tab_ficha_paciente.`tratamentoEndodontico` AS tab_ficha_paciente_tratamentoEndodontico,\n" +
//                "     tab_ficha_paciente.`protese` AS tab_ficha_paciente_protese,\n" +
//                "     tab_ficha_paciente.`tempoProtese` AS tab_ficha_paciente_tempoProtese,\n" +
//                "     tab_ficha_paciente.`aparelhoOdontologico` AS tab_ficha_paciente_aparelhoOdontologico,\n" +
//                "     tab_ficha_paciente.`tempoAparelhoOdontologico` AS tab_ficha_paciente_tempoAparelhoOdontologico,\n" +
//                "     tab_ficha_paciente.`mauHalito` AS tab_ficha_paciente_mauHalito,\n" +
//                "     tab_ficha_paciente.`higieneBucalPalito` AS tab_ficha_paciente_higieneBucalPalito,\n" +
//                "     tab_ficha_paciente.`higieneBucalFioDental` AS tab_ficha_paciente_higieneBucalFioDental,\n" +
//                "     tab_ficha_paciente.`higieneBucalEscova` AS tab_ficha_paciente_higieneBucalEscova,\n" +
//                "     tab_ficha_paciente.`higieneBucalDentifricio` AS tab_ficha_paciente_higieneBucalDentifricio,\n" +
//                "     tab_ficha_paciente.`higieneBucalAntisseptico` AS tab_ficha_paciente_higieneBucalAntisseptico,\n" +
//                "     tab_ficha_paciente.`higieneBucalFluor` AS tab_ficha_paciente_higieneBucalFluor,\n" +
//                "     tab_ficha_paciente.`patologiaCardiaca` AS tab_ficha_paciente_patologiaCardiaca,\n" +
//                "     tab_ficha_paciente.`patologiaAngina` AS tab_ficha_paciente_patologiaAngina,\n" +
//                "     tab_ficha_paciente.`patologiaAtaqueCardiaco` AS tab_ficha_paciente_patologiaAtaqueCardiaco,\n" +
//                "     tab_ficha_paciente.`patologiaInsuficienciaCardiaca` AS tab_ficha_paciente_patologiaInsuficienciaCardiaca,\n" +
//                "     tab_ficha_paciente.`patologiaSoproCardiaco` AS tab_ficha_paciente_patologiaSoproCardiaco,\n" +
//                "     tab_ficha_paciente.`patologiaAlteracaoRitmoCardiaco` AS tab_ficha_paciente_patologiaAlteracaoRitmoCardiaco,\n" +
//                "     tab_ficha_paciente.`patologiaPressaoAlta` AS tab_ficha_paciente_patologiaPressaoAlta,\n" +
//                "     tab_ficha_paciente.`patologiaPressaoBaixa` AS tab_ficha_paciente_patologiaPressaoBaixa,\n" +
//                "     tab_ficha_paciente.`patologiaDerrame` AS tab_ficha_paciente_patologiaDerrame,\n" +
//                "     tab_ficha_paciente.`patologiaArterisclerose` AS tab_ficha_paciente_patologiaArterisclerose,\n" +
//                "     tab_ficha_paciente.`patologiaTrombose` AS tab_ficha_paciente_patologiaTrombose,\n" +
//                "     tab_ficha_paciente.`patologiaEmbolia` AS tab_ficha_paciente_patologiaEmbolia,\n" +
//                "     tab_ficha_paciente.`patologiaProblemasNeurologicos` AS tab_ficha_paciente_patologiaProblemasNeurologicos,\n" +
//                "     tab_ficha_paciente.`patologiaVertigens` AS tab_ficha_paciente_patologiaVertigens,\n" +
//                "     tab_ficha_paciente.`patologiaEpilepsia` AS tab_ficha_paciente_patologiaEpilepsia,\n" +
//                "     tab_ficha_paciente.`patologiaDoencasPsiquicas` AS tab_ficha_paciente_patologiaDoencasPsiquicas,\n" +
//                "     tab_ficha_paciente.`patologiaDepressao` AS tab_ficha_paciente_patologiaDepressao,\n" +
//                "     tab_ficha_paciente.`patologiaEnxaqueca` AS tab_ficha_paciente_patologiaEnxaqueca,\n" +
//                "     tab_ficha_paciente.`patologiaProblemasVisuais` AS tab_ficha_paciente_patologiaProblemasVisuais,\n" +
//                "     tab_ficha_paciente.`patologiaGlaucoma` AS tab_ficha_paciente_patologiaGlaucoma,\n" +
//                "     tab_ficha_paciente.`patologiaSurdez` AS tab_ficha_paciente_patologiaSurdez,\n" +
//                "     tab_ficha_paciente.`patologiaAsma` AS tab_ficha_paciente_patologiaAsma,\n" +
//                "     tab_ficha_paciente.`patologiaTuberculose` AS tab_ficha_paciente_patologiaTuberculose,\n" +
//                "     tab_ficha_paciente.`patologiaSinusite` AS tab_ficha_paciente_patologiaSinusite,\n" +
//                "     tab_ficha_paciente.`patologiaTumores` AS tab_ficha_paciente_patologiaTumores,\n" +
//                "     tab_ficha_paciente.`patologiaLeucemia` AS tab_ficha_paciente_patologiaLeucemia,\n" +
//                "     tab_ficha_paciente.`patologiaQuimioterapia` AS tab_ficha_paciente_patologiaQuimioterapia,\n" +
//                "     tab_ficha_paciente.`patologiaTransplante` AS tab_ficha_paciente_patologiaTransplante,\n" +
//                "     tab_ficha_paciente.`patologiaTireoide` AS tab_ficha_paciente_patologiaTireoide,\n" +
//                "     tab_ficha_paciente.`patologiaDiabetes` AS tab_ficha_paciente_patologiaDiabetes,\n" +
//                "     tab_ficha_paciente.`patologiaHepatite` AS tab_ficha_paciente_patologiaHepatite,\n" +
//                "     tab_ficha_paciente.`patologiaCirrose` AS tab_ficha_paciente_patologiaCirrose,\n" +
//                "     tab_ficha_paciente.`patologiaPatologiaRenal` AS tab_ficha_paciente_patologiaPatologiaRenal,\n" +
//                "     tab_ficha_paciente.`patologiaHemodialise` AS tab_ficha_paciente_patologiaHemodialise,\n" +
//                "     tab_ficha_paciente.`patologiaAnemia` AS tab_ficha_paciente_patologiaAnemia,\n" +
//                "     tab_ficha_paciente.`patologiaGastrite` AS tab_ficha_paciente_patologiaGastrite,\n" +
//                "     tab_ficha_paciente.`patologiaDoencasOssos` AS tab_ficha_paciente_patologiaDoencasOssos,\n" +
//                "     tab_ficha_paciente.`patologiaDificuldadeLocomocao` AS tab_ficha_paciente_patologiaDificuldadeLocomocao,\n" +
//                "     tab_ficha_paciente.`patologiaReumatismo` AS tab_ficha_paciente_patologiaReumatismo,\n" +
//                "     tab_ficha_paciente.`patologiaRebreReumatica` AS tab_ficha_paciente_patologiaRebreReumatica,\n" +
//                "     tab_ficha_paciente.`patologiaArtrite` AS tab_ficha_paciente_patologiaArtrite,\n" +
//                "     tab_ficha_paciente.`patologiaGota` AS tab_ficha_paciente_patologiaGota,\n" +
//                "     tab_ficha_paciente.`patologiaAids` AS tab_ficha_paciente_patologiaAids,\n" +
//                "     tab_ficha_paciente.`patologiaOutras` AS tab_ficha_paciente_patologiaOutras,\n" +
//                "     tab_ficha_paciente.`patologiaRespotaOutras` AS tab_ficha_paciente_patologiaRespotaOutras,\n" +
//                "     tab_ficha_paciente.`habitosOnicofagia` AS tab_ficha_paciente_habitosOnicofagia,\n" +
//                "     tab_ficha_paciente.`habitosOnicofagiaResposta` AS tab_ficha_paciente_habitosOnicofagiaResposta,\n" +
//                "     tab_ficha_paciente.`habitosTabagista` AS tab_ficha_paciente_habitosTabagista,\n" +
//                "     tab_ficha_paciente.`habitosTabagistaResposta` AS tab_ficha_paciente_habitosTabagistaResposta,\n" +
//                "     tab_ficha_paciente.`habitosEtilista` AS tab_ficha_paciente_habitosEtilista,\n" +
//                "     tab_ficha_paciente.`habitosEtilistaResposta` AS tab_ficha_paciente_habitosEtilistaResposta,\n" +
//                "     tab_ficha_paciente.`habitosDroga` AS tab_ficha_paciente_habitosDroga,\n" +
//                "     tab_ficha_paciente.`habitosDrogaResposta` AS tab_ficha_paciente_habitosDrogaResposta,\n" +
//                "     tab_ficha_paciente.`exameFisicoPressao` AS tab_ficha_paciente_exameFisicoPressao,\n" +
//                "     tab_ficha_paciente.`exameFisicoExtrabucal` AS tab_ficha_paciente_exameFisicoExtrabucal,\n" +
//                "     tab_ficha_paciente.`exameFisicoCadeiasLinfaticas` AS tab_ficha_paciente_exameFisicoCadeiasLinfaticas,\n" +
//                "     tab_ficha_paciente.`exameFisicoIntrabucal` AS tab_ficha_paciente_exameFisicoIntrabucal,\n" +
//                "     tab_ficha_paciente.`exameFisicoObsComplementares` AS tab_ficha_paciente_exameFisicoObsComplementares,\n" +
//                "     tab_ficha_paciente.`exameFisicoHipoteseDiagnostico` AS tab_ficha_paciente_exameFisicoHipoteseDiagnostico,\n" +
//                "     tab_ficha_paciente.`exameFisicoExamesComplementares` AS tab_ficha_paciente_exameFisicoExamesComplementares,\n" +
//                "     tab_ficha_paciente.`exameFisicoDiagnosticoFinal` AS tab_ficha_paciente_exameFisicoDiagnosticoFinal,\n" +
//                "     tab_ficha_paciente.`dataInclusao` AS tab_ficha_paciente_dataInclusao,\n" +
//                "     tab_ficha_paciente.`dataAlteracao` AS tab_ficha_paciente_dataAlteracao,\n" +
//                "     tab_ficha_paciente.`dataUltimaConsulta` AS tab_ficha_paciente_dataUltimaConsulta,\n" +
//                "     tab_ficha_paciente.`FezCirurgia` AS tab_ficha_paciente_FezCirurgia,\n" +
//                "     tab_ficha_paciente.`QualCirurgia` AS tab_ficha_paciente_QualCirurgia\n" +
//                "FROM\n" +
//                "     `tab_paciente` tab_paciente,\n" +
//                "     `tab_ficha_paciente` tab_ficha_paciente\n" +
//                "WHERE\n" +
//                    "     tab_paciente.id = '"+id_paciente+"'\n" +
//                    "AND  tab_ficha_paciente.id = '"+id_fichaPaciente+"'";                
//                               
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir Ficha do Paciente");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//        }
//        
//        public void gerarRelatorioEmBranco( String caminhoIreport ) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                "     tab_empresa.`email` AS tab_empresa_email\n" +
//                "\n" +
//                "FROM\n" +
//                "     `tab_empresa` tab_empresa\n" +
//                "WHERE\n" +
//                "      tab_empresa.id='1'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//        }
//        
//        public void gerarRelatorioEditavel( String caminhoIreport , String id_relatorio) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                "     tab_relatorio_editavel.`id` AS tab_relatorio_editavel_id,\n" +
//                "     tab_relatorio_editavel.`titulo` AS tab_relatorio_editavel_titulo,\n" +
//                "     tab_relatorio_editavel.`texto` AS tab_relatorio_editavel_texto\n" +
//                "FROM\n" +
//                "     `tab_empresa` tab_empresa,\n" +
//                "     `tab_relatorio_editavel` tab_relatorio_editavel\n" +
//                "WHERE\n" +
//                "     tab_empresa.id = '1'\n" +
//                "AND tab_relatorio_editavel.id = '"+id_relatorio+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//        }
//        
//        public void gerarAtestado( String caminhoIreport , String idatestado, String idMedico) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                    "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                    "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                    "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                    "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                    "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                    "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                    "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                    "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                    "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                    "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                    "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                    "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                    "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                    "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                    "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                    "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                    "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                    "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                    "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                    "     tab_atestado.`id` AS tab_atestado_id,\n" +
//                    "     tab_atestado.`medico` AS tab_atestado_medico,\n" +
//                    "     tab_atestado.`paciente` AS tab_atestado_paciente,\n" +
//                    "     tab_atestado.`tipo` AS tab_atestado_tipo,\n" +
//                    "     tab_atestado.`cid` AS tab_atestado_cid,\n" +
//                    "     tab_atestado.`quantidadeDias` AS tab_atestado_quantidadeDias,\n" +
//                    "     tab_atestado.`data` AS tab_atestado_data,\n" +
//                    "     tab_atestado.`horaInicial` AS tab_atestado_horaInicial,\n" +
//                    "     tab_atestado.`horaFinal` AS tab_atestado_horaFinal,\n" +
//                    "     tab_medico.`id` AS tab_medico_id,\n" +
//                    "     tab_medico.`nome` AS tab_medico_nome,\n" +
//                    "     tab_medico.`cpf` AS tab_medico_cpf,\n" +
//                    "     tab_medico.`dataNascimento` AS tab_medico_dataNascimento,\n" +
//                    "     tab_medico.`cro` AS tab_medico_cro,\n" +
//                    "     tab_medico.`rua` AS tab_medico_rua,\n" +
//                    "     tab_medico.`numero` AS tab_medico_numero,\n" +
//                    "     tab_medico.`telefone` AS tab_medico_telefone,\n" +
//                    "     tab_medico.`celular` AS tab_medico_celular,\n" +
//                    "     tab_medico.`bairro` AS tab_medico_bairro,\n" +
//                    "     tab_medico.`uf` AS tab_medico_uf,\n" +
//                    "     tab_medico.`cidade` AS tab_medico_cidade,\n" +
//                    "     tab_medico.`cep` AS tab_medico_cep\n" +
//                    "FROM\n" +
//                    "     `tab_empresa` tab_empresa,\n" +
//                    "     `tab_atestado` tab_atestado,\n" +
//                    "     `tab_medico` tab_medico\n" +
//                    "where\n" +
//                    "     tab_medico.id='1'\n" +
//                    "AND  tab_atestado.id='"+idatestado+"'\n" +
//                    "AND  tab_empresa.id='1'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir Atestado");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//        }
//        
//        public void gerarCarne( String caminhoIreport ,String dataGerado,String idCliente,String valorDaPArcela,String quantidadeDeParcelas) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                                "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                                "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                                "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                                "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                                "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                                "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                                "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                                "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                                "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                                "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                                "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                                "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                                "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                                "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                                "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                                "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                                "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                                "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                                "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                                "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                                "     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//                                "     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//                                "     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//                                "     tab_cliente.`id` AS tab_cliente_id,\n" +
//                                "     tab_cliente.`nome` AS tab_cliente_nome,\n" +
//                                "     tab_cliente.`endereco` AS tab_cliente_endereco,\n" +
//                                "     tab_cliente.`bairro` AS tab_cliente_bairro,\n" +
//                                "     tab_cliente.`cidade` AS tab_cliente_cidade,\n" +
//                                "     tab_cliente.`estado` AS tab_cliente_estado,\n" +
//                                "     tab_cliente.`cep` AS tab_cliente_cep,\n" +
//                                "     tab_cliente.`cnpj` AS tab_cliente_cnpj,\n" +
//                                "     tab_cliente.`telefone` AS tab_cliente_telefone,\n" +
//                                "     tab_cliente.`numero` AS tab_cliente_numero,\n" +
//                                "     tab_cliente.`observacao` AS tab_cliente_observacao,\n" +
//                                "     tab_cliente.`matricula` AS tab_cliente_matricula,\n" +
//                                "     tab_cliente.`email` AS tab_cliente_email,\n" +
//                                "     tab_cliente.`apto` AS tab_cliente_apto,\n" +
//                                "     tab_cliente.`pai` AS tab_cliente_pai,\n" +
//                                "     tab_cliente.`mae` AS tab_cliente_mae,\n" +
//                                "     tab_cliente.`tel_trabalho` AS tab_cliente_tel_trabalho,\n" +
//                                "     tab_cliente.`data_nascimento` AS tab_cliente_data_nascimento,\n" +
//                                "     tab_cliente.`codigo_municipio` AS tab_cliente_codigo_municipio,\n" +
//                                "     tab_cliente.`insc_estadual` AS tab_cliente_insc_estadual,\n" +
//                                "     tab_cliente.`descricaoContrato` AS tab_cliente_descricaoContrato,\n" +
//                                "     tab_cliente.`valorInstalacao` AS tab_cliente_valorInstalacao,\n" +
//                                "     tab_cliente.`valorMensalidade` AS tab_cliente_valorMensalidade,\n" +
//                                "     tab_cliente.`numeroDeMensalidades` AS tab_cliente_numeroDeMensalidades,\n" +
//                                "     tab_cliente.`vencimentoMensalidade` AS tab_cliente_vencimentoMensalidade,\n" +
//                                "     tab_cliente.`celular` AS tab_cliente_celular,\n" +
//                                "     tab_cliente.`razao` AS tab_cliente_razao,\n" +
//                                "     tab_cliente.`Integrado` AS tab_cliente_Integrado,\n" +
//                                "     tab_cliente.`DataIntegracao` AS tab_cliente_DataIntegracao,\n" +
//                                "     tab_cliente.`Profissao` AS tab_cliente_Profissao,\n" +
//                                "     tab_cliente.`Sexo` AS tab_cliente_Sexo,\n" +
//                                "     tab_cliente.`RendaFamiliar` AS tab_cliente_RendaFamiliar,\n" +
//                                "     tab_cliente.`Vendedor` AS tab_cliente_Vendedor,\n" +
//                                "     tab_cliente.`Loteamento` AS tab_cliente_Loteamento,\n" +
//                                "     tab_cliente.`EnderecoLoteamento` AS tab_cliente_EnderecoLoteamento,\n" +
//                                "     tab_cliente.`RegistroLoteamento` AS tab_cliente_RegistroLoteamento,\n" +
//                                "     tab_cliente.`Quadra` AS tab_cliente_Quadra,\n" +
//                                "     tab_cliente.`Lote` AS tab_cliente_Lote,\n" +
//                                "     tab_cliente.`NumeroContrato` AS tab_cliente_NumeroContrato,\n" +
//                                "     tab_cliente.`Area` AS tab_cliente_Area,\n" +
//                                "     tab_cliente.`Medicoes` AS tab_cliente_Medicoes,\n" +
//                                "     tab_cliente.`ValorDaCompra` AS tab_cliente_ValorDaCompra,\n" +
//                                "     tab_cliente.`ValorEntrada` AS tab_cliente_ValorEntrada,\n" +
//                                "     tab_cliente.`PrimeiraParcela` AS tab_cliente_PrimeiraParcela,\n" +
//                                "     tab_cliente.`SegundaParcela` AS tab_cliente_SegundaParcela,\n" +
//                                "     tab_cliente.`TerceiraParcela` AS tab_cliente_TerceiraParcela,\n" +
//                                "     tab_cliente.`QuartaParcela` AS tab_cliente_QuartaParcela,\n" +
//                                "     tab_cliente.`QuantidadeDeParcelas` AS tab_cliente_QuantidadeDeParcelas,\n" +
//                                "     tab_cliente.`ValorDaParcela` AS tab_cliente_ValorDaParcela,\n" +
//                                "     tab_cliente.`DiaVencimento` AS tab_cliente_DiaVencimento,\n" +
//                                "     tab_cliente.`SituacaoPagamento` AS tab_cliente_SituacaoPagamento,\n" +
//                                "     tab_cliente.`DataContrato` AS tab_cliente_DataContrato,\n" +
//                                "     tab_cliente.`EstadoCivil` AS tab_cliente_EstadoCivil,\n" +
//                                "     tab_cliente.`RuaCobranca` AS tab_cliente_RuaCobranca,\n" +
//                                "     tab_cliente.`NumeroCobranca` AS tab_cliente_NumeroCobranca,\n" +
//                                "     tab_cliente.`BairroCobranca` AS tab_cliente_BairroCobranca,\n" +
//                                "     tab_cliente.`CidadeCobranca` AS tab_cliente_CidadeCobranca,\n" +
//                                "     tab_cliente.`UfCobranca` AS tab_cliente_UfCobranca,\n" +
//                                "     tab_cliente.`CEPCobranca` AS tab_cliente_CEPCobranca,\n" +
//                                "     tab_cliente.`NomeConjugue` AS tab_cliente_NomeConjugue,\n" +
//                                "     tab_cliente.`IdentidadeConjugue` AS tab_cliente_IdentidadeConjugue,\n" +
//                                "     tab_cliente.`ProfissaoConjugue` AS tab_cliente_ProfissaoConjugue,\n" +
//                                "     tab_cliente.`NascimentoConjugue` AS tab_cliente_NascimentoConjugue,\n" +
//                                "     tab_cliente.`CPFConjugue` AS tab_cliente_CPFConjugue,\n" +
//                                "     tab_cliente.`dataInicioDaUtilizacaoDoSistema` AS tab_cliente_dataInicioDaUtilizacaoDoSistema,\n" +
//                                "     tab_cliente.`Perfil` AS tab_cliente_Perfil,\n" +
//                                "     tab_cliente.`Graduacao` AS tab_cliente_Graduacao,\n" +
//                                "     tab_cliente.`QuantidadeDeGraus` AS tab_cliente_QuantidadeDeGraus,\n" +
//                                "     tab_cliente.`Tipo` AS tab_cliente_Tipo,\n" +
//                                "     tab_cliente.`Idade` AS tab_cliente_Idade,\n" +
//                                "     tab_carne.`id` AS tab_carne_id,\n" +
//                                "     tab_carne.`idCliente` AS tab_carne_idCliente,\n" +
//                                "     tab_carne.`NomeCliente` AS tab_carne_NomeCliente,\n" +
//                                "     tab_carne.`NumeroContrato` AS tab_carne_NumeroContrato,\n" +
//                                "     tab_carne.`REgistro` AS tab_carne_REgistro,\n" +
//                                "     tab_carne.`QuantidadeParcelas` AS tab_carne_QuantidadeParcelas,\n" +
//                                "     tab_carne.`textoDoCarne` AS tab_carne_textoDoCarne,\n" +
//                                "     tab_carne.`Sequencia` AS tab_carne_Sequencia,\n" +
//                                "     tab_carne.`ValorParcela` AS tab_carne_ValorParcela,\n" +
//                                "     tab_carne.`Vencimento` AS tab_carne_Vencimento,\n" +
//                                "     tab_carne.`DiaVencimento` AS tab_carne_DiaVencimento,\n" +
//                                "     tab_carne.`PrimeiroVencimento` AS tab_carne_PrimeiroVencimento,\n" +
//                                "     tab_carne.`QuantosDiasParaProximaParcela` AS tab_carne_QuantosDiasParaProximaParcela,\n" +
//                                "     tab_carne.`dataGerado` AS tab_carne_dataGerado,\n" +
//                                "     tab_carne.`Situacao` AS tab_carne_Situacao\n" +
//                                "FROM\n" +
//                                "     `tab_empresa` tab_empresa,\n" +
//                                "     `tab_cliente` tab_cliente,\n" +
//                                "     `tab_carne` tab_carne\n" +
//                                "where\n" +
//                                "	tab_empresa.id='1' and\n" +
//                                "	tab_cliente.id='"+idCliente+"' and\n" +
//                                "	tab_carne.idCliente='"+idCliente+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir Carnê");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                //viewer.setAlwaysOnTop(true);
//                viewer.show();
//        }
//        
//        public void gerarCarneContasReceber( String caminhoIreport ,String idCliente) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//"     tab_empresa.`id` AS tab_empresa_id,\n" +
//"     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//"     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//"     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//"     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//"     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//"     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//"     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//"     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//"     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//"     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//"     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//"     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//"     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//"     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//"     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//"     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//"     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//"     tab_empresa.`email` AS tab_empresa_email,\n" +
//"     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//"     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//"     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//"     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//"     tab_cliente.`id` AS tab_cliente_id,\n" +
//"     tab_cliente.`nome` AS tab_cliente_nome,\n" +
//"     tab_cliente.`endereco` AS tab_cliente_endereco,\n" +
//"     tab_cliente.`bairro` AS tab_cliente_bairro,\n" +
//"     tab_cliente.`cidade` AS tab_cliente_cidade,\n" +
//"     tab_cliente.`estado` AS tab_cliente_estado,\n" +
//"     tab_cliente.`cep` AS tab_cliente_cep,\n" +
//"     tab_cliente.`cnpj` AS tab_cliente_cnpj,\n" +
//"     tab_cliente.`telefone` AS tab_cliente_telefone,\n" +
//"     tab_cliente.`numero` AS tab_cliente_numero,\n" +
//"     tab_cliente.`observacao` AS tab_cliente_observacao,\n" +
//"     tab_cliente.`matricula` AS tab_cliente_matricula,\n" +
//"     tab_cliente.`email` AS tab_cliente_email,\n" +
//"     tab_cliente.`apto` AS tab_cliente_apto,\n" +
//"     tab_cliente.`pai` AS tab_cliente_pai,\n" +
//"     tab_cliente.`mae` AS tab_cliente_mae,\n" +
//"     tab_cliente.`tel_trabalho` AS tab_cliente_tel_trabalho,\n" +
//"     tab_cliente.`data_nascimento` AS tab_cliente_data_nascimento,\n" +
//"     tab_cliente.`codigo_municipio` AS tab_cliente_codigo_municipio,\n" +
//"     tab_cliente.`insc_estadual` AS tab_cliente_insc_estadual,\n" +
//"     tab_cliente.`descricaoContrato` AS tab_cliente_descricaoContrato,\n" +
//"     tab_cliente.`valorInstalacao` AS tab_cliente_valorInstalacao,\n" +
//"     tab_cliente.`valorMensalidade` AS tab_cliente_valorMensalidade,\n" +
//"     tab_cliente.`numeroDeMensalidades` AS tab_cliente_numeroDeMensalidades,\n" +
//"     tab_cliente.`vencimentoMensalidade` AS tab_cliente_vencimentoMensalidade,\n" +
//"     tab_cliente.`celular` AS tab_cliente_celular,\n" +
//"     tab_cliente.`razao` AS tab_cliente_razao,\n" +
//"     tab_cliente.`Integrado` AS tab_cliente_Integrado,\n" +
//"     tab_cliente.`DataIntegracao` AS tab_cliente_DataIntegracao,\n" +
//"     tab_cliente.`Profissao` AS tab_cliente_Profissao,\n" +
//"     tab_cliente.`Sexo` AS tab_cliente_Sexo,\n" +
//"     tab_cliente.`RendaFamiliar` AS tab_cliente_RendaFamiliar,\n" +
//"     tab_cliente.`Vendedor` AS tab_cliente_Vendedor,\n" +
//"     tab_cliente.`Loteamento` AS tab_cliente_Loteamento,\n" +
//"     tab_cliente.`EnderecoLoteamento` AS tab_cliente_EnderecoLoteamento,\n" +
//"     tab_cliente.`RegistroLoteamento` AS tab_cliente_RegistroLoteamento,\n" +
//"     tab_cliente.`Quadra` AS tab_cliente_Quadra,\n" +
//"     tab_cliente.`Lote` AS tab_cliente_Lote,\n" +
//"     tab_cliente.`NumeroContrato` AS tab_cliente_NumeroContrato,\n" +
//"     tab_cliente.`Area` AS tab_cliente_Area,\n" +
//"     tab_cliente.`Medicoes` AS tab_cliente_Medicoes,\n" +
//"     tab_cliente.`ValorDaCompra` AS tab_cliente_ValorDaCompra,\n" +
//"     tab_cliente.`ValorEntrada` AS tab_cliente_ValorEntrada,\n" +
//"     tab_cliente.`PrimeiraParcela` AS tab_cliente_PrimeiraParcela,\n" +
//"     tab_cliente.`SegundaParcela` AS tab_cliente_SegundaParcela,\n" +
//"     tab_cliente.`TerceiraParcela` AS tab_cliente_TerceiraParcela,\n" +
//"     tab_cliente.`QuartaParcela` AS tab_cliente_QuartaParcela,\n" +
//"     tab_cliente.`QuantidadeDeParcelas` AS tab_cliente_QuantidadeDeParcelas,\n" +
//"     tab_cliente.`ValorDaParcela` AS tab_cliente_ValorDaParcela,\n" +
//"     tab_cliente.`DiaVencimento` AS tab_cliente_DiaVencimento,\n" +
//"     tab_cliente.`SituacaoPagamento` AS tab_cliente_SituacaoPagamento,\n" +
//"     tab_cliente.`DataContrato` AS tab_cliente_DataContrato,\n" +
//"     tab_cliente.`EstadoCivil` AS tab_cliente_EstadoCivil,\n" +
//"     tab_cliente.`RuaCobranca` AS tab_cliente_RuaCobranca,\n" +
//"     tab_cliente.`NumeroCobranca` AS tab_cliente_NumeroCobranca,\n" +
//"     tab_cliente.`BairroCobranca` AS tab_cliente_BairroCobranca,\n" +
//"     tab_cliente.`CidadeCobranca` AS tab_cliente_CidadeCobranca,\n" +
//"     tab_cliente.`UfCobranca` AS tab_cliente_UfCobranca,\n" +
//"     tab_cliente.`CEPCobranca` AS tab_cliente_CEPCobranca,\n" +
//"     tab_cliente.`NomeConjugue` AS tab_cliente_NomeConjugue,\n" +
//"     tab_cliente.`IdentidadeConjugue` AS tab_cliente_IdentidadeConjugue,\n" +
//"     tab_cliente.`ProfissaoConjugue` AS tab_cliente_ProfissaoConjugue,\n" +
//"     tab_cliente.`NascimentoConjugue` AS tab_cliente_NascimentoConjugue,\n" +
//"     tab_cliente.`CPFConjugue` AS tab_cliente_CPFConjugue,\n" +
//"     tab_cliente.`dataInicioDaUtilizacaoDoSistema` AS tab_cliente_dataInicioDaUtilizacaoDoSistema,\n" +
//"     tab_cliente.`Perfil` AS tab_cliente_Perfil,\n" +
//"     tab_cliente.`Graduacao` AS tab_cliente_Graduacao,\n" +
//"     tab_cliente.`QuantidadeDeGraus` AS tab_cliente_QuantidadeDeGraus,\n" +
//"     tab_cliente.`Tipo` AS tab_cliente_Tipo,\n" +
//"     tab_cliente.`Idade` AS tab_cliente_Idade,\n" +
//"     tab_carne.`id` AS tab_carne_id,\n" +
//"     tab_carne.`idCliente` AS tab_carne_idCliente,\n" +
//"     tab_carne.`NomeCliente` AS tab_carne_NomeCliente,\n" +
//"     tab_carne.`NumeroContrato` AS tab_carne_NumeroContrato,\n" +
//"     tab_carne.`REgistro` AS tab_carne_REgistro,\n" +
//"     tab_carne.`QuantidadeParcelas` AS tab_carne_QuantidadeParcelas,\n" +
//"     tab_carne.`textoDoCarne` AS tab_carne_textoDoCarne,\n" +
//"     tab_carne.`Sequencia` AS tab_carne_Sequencia,\n" +
//"     tab_carne.`ValorParcela` AS tab_carne_ValorParcela,\n" +
//"     tab_carne.`Vencimento` AS tab_carne_Vencimento,\n" +
//"     tab_carne.`DiaVencimento` AS tab_carne_DiaVencimento,\n" +
//"     tab_carne.`PrimeiroVencimento` AS tab_carne_PrimeiroVencimento,\n" +
//"     tab_carne.`QuantosDiasParaProximaParcela` AS tab_carne_QuantosDiasParaProximaParcela,\n" +
//"     tab_carne.`dataGerado` AS tab_carne_dataGerado,\n" +
//"     tab_carne.`Situacao` AS tab_carne_Situacao\n" +
//"FROM\n" +
//"     `tab_empresa` tab_empresa,\n" +
//"     `tab_cliente` tab_cliente,\n" +
//"     `tab_carne` tab_carne\n" +
//"where\n" +
//"	tab_empresa.id='1' and\n" +
//"	tab_cliente.id='"+idCliente+"' and\n" +
//"	tab_carne.idCliente='"+idCliente+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir Carnê");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                //viewer.setAlwaysOnTop(true);
//                viewer.show();
//        }
//        
//        public void gerarContrato( String caminhoIreport,String idCliente) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                        "     tab_cliente.`id` AS tab_cliente_id,\n" +
//                        "     tab_cliente.`nome` AS tab_cliente_nome,\n" +
//                        "     tab_cliente.`endereco` AS tab_cliente_endereco,\n" +
//                        "     tab_cliente.`bairro` AS tab_cliente_bairro,\n" +
//                        "     tab_cliente.`cidade` AS tab_cliente_cidade,\n" +
//                        "     tab_cliente.`estado` AS tab_cliente_estado,\n" +
//                        "     tab_cliente.`cep` AS tab_cliente_cep,\n" +
//                        "     tab_cliente.`cnpj` AS tab_cliente_cnpj,\n" +
//                        "     tab_cliente.`telefone` AS tab_cliente_telefone,\n" +
//                        "     tab_cliente.`numero` AS tab_cliente_numero,\n" +
//                        "     tab_cliente.`observacao` AS tab_cliente_observacao,\n" +
//                        "     tab_cliente.`matricula` AS tab_cliente_matricula,\n" +
//                        "     tab_cliente.`email` AS tab_cliente_email,\n" +
//                        "     tab_cliente.`apto` AS tab_cliente_apto,\n" +
//                        "     tab_cliente.`pai` AS tab_cliente_pai,\n" +
//                        "     tab_cliente.`mae` AS tab_cliente_mae,\n" +
//                        "     tab_cliente.`tel_trabalho` AS tab_cliente_tel_trabalho,\n" +
//                        "     tab_cliente.`data_nascimento` AS tab_cliente_data_nascimento,\n" +
//                        "     tab_cliente.`codigo_municipio` AS tab_cliente_codigo_municipio,\n" +
//                        "     tab_cliente.`insc_estadual` AS tab_cliente_insc_estadual,\n" +
//                        "     tab_cliente.`descricaoContrato` AS tab_cliente_descricaoContrato,\n" +
//                        "     tab_cliente.`valorInstalacao` AS tab_cliente_valorInstalacao,\n" +
//                        "     tab_cliente.`valorMensalidade` AS tab_cliente_valorMensalidade,\n" +
//                        "     tab_cliente.`numeroDeMensalidades` AS tab_cliente_numeroDeMensalidades,\n" +
//                        "     tab_cliente.`vencimentoMensalidade` AS tab_cliente_vencimentoMensalidade,\n" +
//                        "     tab_cliente.`celular` AS tab_cliente_celular,\n" +
//                        "     tab_cliente.`razao` AS tab_cliente_razao,\n" +
//                        "     tab_cliente.`Integrado` AS tab_cliente_Integrado,\n" +
//                        "     tab_cliente.`DataIntegracao` AS tab_cliente_DataIntegracao,\n" +
//                        "     tab_cliente.`Profissao` AS tab_cliente_Profissao,\n" +
//                        "     tab_cliente.`Sexo` AS tab_cliente_Sexo,\n" +
//                        "     tab_cliente.`RendaFamiliar` AS tab_cliente_RendaFamiliar,\n" +
//                        "     tab_cliente.`Vendedor` AS tab_cliente_Vendedor,\n" +
//                        "     tab_cliente.`Loteamento` AS tab_cliente_Loteamento,\n" +
//                        "     tab_cliente.`EnderecoLoteamento` AS tab_cliente_EnderecoLoteamento,\n" +
//                        "     tab_cliente.`RegistroLoteamento` AS tab_cliente_RegistroLoteamento,\n" +
//                        "     tab_cliente.`Quadra` AS tab_cliente_Quadra,\n" +
//                        "     tab_cliente.`Lote` AS tab_cliente_Lote,\n" +
//                        "     tab_cliente.`NumeroContrato` AS tab_cliente_NumeroContrato,\n" +
//                        "     tab_cliente.`Area` AS tab_cliente_Area,\n" +
//                        "     tab_cliente.`Medicoes` AS tab_cliente_Medicoes,\n" +
//                        "     tab_cliente.`ValorDaCompra` AS tab_cliente_ValorDaCompra,\n" +
//                        "     tab_cliente.`ValorEntrada` AS tab_cliente_ValorEntrada,\n" +
//                        "     tab_cliente.`PrimeiraParcela` AS tab_cliente_PrimeiraParcela,\n" +
//                        "     tab_cliente.`SegundaParcela` AS tab_cliente_SegundaParcela,\n" +
//                        "     tab_cliente.`TerceiraParcela` AS tab_cliente_TerceiraParcela,\n" +
//                        "     tab_cliente.`QuartaParcela` AS tab_cliente_QuartaParcela,\n" +
//                        "     tab_cliente.`QuantidadeDeParcelas` AS tab_cliente_QuantidadeDeParcelas,\n" +
//                        "     tab_cliente.`ValorDaParcela` AS tab_cliente_ValorDaParcela,\n" +
//                        "     tab_cliente.`DiaVencimento` AS tab_cliente_DiaVencimento,\n" +
//                        "     tab_cliente.`SituacaoPagamento` AS tab_cliente_SituacaoPagamento,\n" +
//                        "     tab_cliente.`DataContrato` AS tab_cliente_DataContrato,\n" +
//                        "     tab_cliente.`EstadoCivil` AS tab_cliente_EstadoCivil,\n" +
//                        "     tab_cliente.`RuaCobranca` AS tab_cliente_RuaCobranca,\n" +
//                        "     tab_cliente.`NumeroCobranca` AS tab_cliente_NumeroCobranca,\n" +
//                        "     tab_cliente.`BairroCobranca` AS tab_cliente_BairroCobranca,\n" +
//                        "     tab_cliente.`CidadeCobranca` AS tab_cliente_CidadeCobranca,\n" +
//                        "     tab_cliente.`UfCobranca` AS tab_cliente_UfCobranca,\n" +
//                        "     tab_cliente.`CEPCobranca` AS tab_cliente_CEPCobranca,\n" +
//                        "     tab_cliente.`NomeConjugue` AS tab_cliente_NomeConjugue,\n" +
//                        "     tab_cliente.`IdentidadeConjugue` AS tab_cliente_IdentidadeConjugue,\n" +
//                        "     tab_cliente.`ProfissaoConjugue` AS tab_cliente_ProfissaoConjugue,\n" +
//                        "     tab_cliente.`NascimentoConjugue` AS tab_cliente_NascimentoConjugue,\n" +
//                        "     tab_cliente.`CPFConjugue` AS tab_cliente_CPFConjugue,\n" +
//                        "     tab_cliente.`dataInicioDaUtilizacaoDoSistema` AS tab_cliente_dataInicioDaUtilizacaoDoSistema,\n" +
//                        "     tab_cliente.`Perfil` AS tab_cliente_Perfil,\n" +
//                        "     tab_cliente.`Graduacao` AS tab_cliente_Graduacao,\n" +
//                        "     tab_cliente.`QuantidadeDeGraus` AS tab_cliente_QuantidadeDeGraus,\n" +
//                        "     tab_cliente.`Tipo` AS tab_cliente_Tipo,\n" +
//                        "     tab_cliente.`Idade` AS tab_cliente_Idade,\n" +
//                        "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                        "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                        "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                        "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                        "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                        "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                        "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                        "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                        "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                        "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                        "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                        "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                        "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                        "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                        "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                        "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                        "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                        "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                        "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                        "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                        "     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//                        "     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//                        "     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//                        "     tab_cliente.`Nacionalidade` AS tab_cliente_Nacionalidade,\n" +
//                        "     tab_cliente.`NacionalidadeConugue` AS tab_cliente_NacionalidadeConugue,\n" +
//                        "     tab_cliente.`TelefoneConjugue` AS tab_cliente_TelefoneConjugue,\n" +
//                        "     tab_cliente.`ValorDaCompraPorExtenso` AS tab_cliente_ValorDaCompraPorExtenso,\n" +
//                        "     tab_cliente.`DataDoContratoPorExtenso` AS tab_cliente_DataDoContratoPorExtenso,\n" +
//                        "     tab_cliente.`DescricaoFrente` AS tab_cliente_DescricaoFrente,\n" +
//                        "     tab_cliente.`DescricaoFundos` AS tab_cliente_DescricaoFundos,\n" +
//                        "     tab_cliente.`MedicaoFrente` AS tab_cliente_MedicaoFrente,\n" +
//                        "     tab_cliente.`MedicaoFundos` AS tab_cliente_MedicaoFundos,\n" +
//                        "     tab_cliente.`DescricaoLD` AS tab_cliente_DescricaoLD,\n" +
//                        "     tab_cliente.`DescricaoLE` AS tab_cliente_DescricaoLE,\n" +
//                        "     tab_cliente.`MedicaoLD` AS tab_cliente_MedicaoLD,\n" +
//                        "     tab_cliente.`MedicaoLE` AS tab_cliente_MedicaoLE,\n" +
//                        "     tab_cliente.`TotalParcelado` AS tab_cliente_TotalParcelado,\n" +
//                        "     tab_confiruracao.`id` AS tab_confiruracao_id,\n" +
//                        "     tab_confiruracao.`nomeConfiguracao` AS tab_confiruracao_nomeConfiguracao,\n" +
//                        "     tab_confiruracao.`descricaoConfiguracao` AS tab_confiruracao_descricaoConfiguracao,\n" +
//                        "     tab_confiruracao.`habilitado` AS tab_confiruracao_habilitado,\n" +
//                        "     tab_confiruracao.`tamanhoFontePedido` AS tab_confiruracao_tamanhoFontePedido,\n" +
//                        "     tab_confiruracao.`mensagemOrcamento` AS tab_confiruracao_mensagemOrcamento,\n" +
//                        "     tab_confiruracao.`mensagemPedido` AS tab_confiruracao_mensagemPedido,\n" +
//                        "     tab_confiruracao.`mensagemNFCE` AS tab_confiruracao_mensagemNFCE,\n" +
//                        "     tab_confiruracao.`mensagemNFE` AS tab_confiruracao_mensagemNFE,\n" +
//                        "     tab_confiruracao.`valorImpostos` AS tab_confiruracao_valorImpostos,\n" +
//                        "     tab_confiruracao.`valorDespesa` AS tab_confiruracao_valorDespesa,\n" +
//                        "     tab_confiruracao.`valorMarkup` AS tab_confiruracao_valorMarkup,\n" +
//                        "     tab_confiruracao.`tipoPrecificacao` AS tab_confiruracao_tipoPrecificacao,\n" +
//                        "     tab_confiruracao.`ativaTelaAviso` AS tab_confiruracao_ativaTelaAviso,\n" +
//                        "     tab_confiruracao.`Integrado` AS tab_confiruracao_Integrado,\n" +
//                        "     tab_confiruracao.`DataIntegracao` AS tab_confiruracao_DataIntegracao,\n" +
//                        "     tab_confiruracao.`valorComissao` AS tab_confiruracao_valorComissao,\n" +
//                        "     tab_confiruracao.`DataConclusaoLoteamento` AS tab_confiruracao_DataConclusaoLoteamento,\n" +
//                        "     tab_cliente_add.`id` AS tab_cliente_add_id,\n" +
//                        "     tab_cliente_add.`IdCliente` AS tab_cliente_add_IdCliente,\n" +
//                        "     tab_cliente_add.`FormaPagamento` AS tab_cliente_add_FormaPagamento,\n" +
//                        "     tab_cliente_add.`VencimentoDoSinal` AS tab_cliente_add_VencimentoDoSinal,\n" +
//                        "     tab_cliente_add.`VencimentoDaPrimeiraParcela` AS tab_cliente_add_VencimentoDaPrimeiraParcela,\n" +
//                        "     tab_cliente_add.`TotalDeParcelasIntercaladas` AS tab_cliente_add_TotalDeParcelasIntercaladas,\n" +
//                        "     tab_cliente_add.`VencimentoDasParcelasIntercaladas` AS tab_cliente_add_VencimentoDasParcelasIntercaladas,\n" +
//                        "     tab_cliente_add.`ValorReajuste` AS tab_cliente_add_ValorReajuste,\n" +
//                        "     tab_cliente_add.`ValorINPCAnual` AS tab_cliente_add_ValorINPCAnual,\n" +
//                        "     tab_cliente_add.`OutraFormaDePagamento` AS tab_cliente_add_OutraFormaDePagamento,\n" +
//                        "     tab_cliente_add.`Avista` AS tab_cliente_add_Avista,\n" +
//                        "     tab_cliente_add.`APrazo` AS tab_cliente_add_APrazo,\n" +
//                        "     tab_cliente_add.`ValorTotalIntercaladas` AS tab_cliente_add_ValorTotalIntercaladas\n" +
//                        "FROM\n" +
//                        "     `tab_cliente` tab_cliente,\n" +
//                        "     `tab_empresa` tab_empresa,\n" +
//                        "     `tab_confiruracao` tab_confiruracao,\n" +
//                        "     `tab_cliente_add` tab_cliente_add\n" +
//                        "WHERE tab_cliente.id='"+idCliente+"' and tab_cliente_add.IdCliente = '"+idCliente+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir Contrato");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                //viewer.setAlwaysOnTop(true);
//                viewer.show();
//                
//                /**
//                byte[] pdf = JasperRunManager.runReportToPdf(caminhoIreport, parametros, jrRS);
//                //Retorna um fluxo para enviar dados ao navegador
//                FacesContext facesContext = (FacesContext) FacesContext.getCurrentInstance();
//                facesContext.getExternalContext().getResponce();
//                HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
//                try {
//                    //response.setContentType("application/pdf");
//                    //response.setHeader("Content-disposition","attachment;filename=relatorio.pdf");
//                    ServletOutputStream servletOutputStream = response.getOutputStream();
//                } catch (IOException ex) {
//                    Logger.getLogger(Ireport.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//                ServletOutputStream out = null;
//                try {
//                    out = response.getOutputStream();
//                } catch (IOException ex) {
//                    Logger.getLogger(Ireport.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                //Informar ao navegador que o que vai ser enviado é um pdf
//                response.setContentType("application/pdf");
//                try {
//                    //Mostra o arquivo no navegador
//                    out.write(pdf);
//                } catch (IOException ex) {
//                    Logger.getLogger(Ireport.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                */
//                //return viewer;
//                
//                
//                
//        }
//        
//        public void gerarRelacaoDeCliente( String caminhoIreport) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                        "     tab_cliente.`id` AS tab_cliente_id,\n" +
//                        "     tab_cliente.`nome` AS tab_cliente_nome,\n" +
//                        "     tab_cliente.`endereco` AS tab_cliente_endereco,\n" +
//                        "     tab_cliente.`bairro` AS tab_cliente_bairro,\n" +
//                        "     tab_cliente.`cidade` AS tab_cliente_cidade,\n" +
//                        "     tab_cliente.`estado` AS tab_cliente_estado,\n" +
//                        "     tab_cliente.`cep` AS tab_cliente_cep,\n" +
//                        "     tab_cliente.`cnpj` AS tab_cliente_cnpj,\n" +
//                        "     tab_cliente.`telefone` AS tab_cliente_telefone,\n" +
//                        "     tab_cliente.`numero` AS tab_cliente_numero,\n" +
//                        "     tab_cliente.`observacao` AS tab_cliente_observacao,\n" +
//                        "     tab_cliente.`matricula` AS tab_cliente_matricula,\n" +
//                        "     tab_cliente.`email` AS tab_cliente_email,\n" +
//                        "     tab_cliente.`apto` AS tab_cliente_apto,\n" +
//                        "     tab_cliente.`pai` AS tab_cliente_pai,\n" +
//                        "     tab_cliente.`mae` AS tab_cliente_mae,\n" +
//                        "     tab_cliente.`tel_trabalho` AS tab_cliente_tel_trabalho,\n" +
//                        "     tab_cliente.`data_nascimento` AS tab_cliente_data_nascimento,\n" +
//                        "     tab_cliente.`codigo_municipio` AS tab_cliente_codigo_municipio,\n" +
//                        "     tab_cliente.`insc_estadual` AS tab_cliente_insc_estadual,\n" +
//                        "     tab_cliente.`descricaoContrato` AS tab_cliente_descricaoContrato,\n" +
//                        "     tab_cliente.`valorInstalacao` AS tab_cliente_valorInstalacao,\n" +
//                        "     tab_cliente.`valorMensalidade` AS tab_cliente_valorMensalidade,\n" +
//                        "     tab_cliente.`numeroDeMensalidades` AS tab_cliente_numeroDeMensalidades,\n" +
//                        "     tab_cliente.`vencimentoMensalidade` AS tab_cliente_vencimentoMensalidade,\n" +
//                        "     tab_cliente.`celular` AS tab_cliente_celular,\n" +
//                        "     tab_cliente.`razao` AS tab_cliente_razao,\n" +
//                        "     tab_cliente.`Integrado` AS tab_cliente_Integrado,\n" +
//                        "     tab_cliente.`DataIntegracao` AS tab_cliente_DataIntegracao,\n" +
//                        "     tab_cliente.`Profissao` AS tab_cliente_Profissao,\n" +
//                        "     tab_cliente.`Sexo` AS tab_cliente_Sexo,\n" +
//                        "     tab_cliente.`RendaFamiliar` AS tab_cliente_RendaFamiliar,\n" +
//                        "     tab_cliente.`Vendedor` AS tab_cliente_Vendedor,\n" +
//                        "     tab_cliente.`Loteamento` AS tab_cliente_Loteamento,\n" +
//                        "     tab_cliente.`EnderecoLoteamento` AS tab_cliente_EnderecoLoteamento,\n" +
//                        "     tab_cliente.`RegistroLoteamento` AS tab_cliente_RegistroLoteamento,\n" +
//                        "     tab_cliente.`Quadra` AS tab_cliente_Quadra,\n" +
//                        "     tab_cliente.`Lote` AS tab_cliente_Lote,\n" +
//                        "     tab_cliente.`NumeroContrato` AS tab_cliente_NumeroContrato,\n" +
//                        "     tab_cliente.`Area` AS tab_cliente_Area,\n" +
//                        "     tab_cliente.`Medicoes` AS tab_cliente_Medicoes,\n" +
//                        "     tab_cliente.`ValorDaCompra` AS tab_cliente_ValorDaCompra,\n" +
//                        "     tab_cliente.`ValorEntrada` AS tab_cliente_ValorEntrada,\n" +
//                        "     tab_cliente.`PrimeiraParcela` AS tab_cliente_PrimeiraParcela,\n" +
//                        "     tab_cliente.`SegundaParcela` AS tab_cliente_SegundaParcela,\n" +
//                        "     tab_cliente.`TerceiraParcela` AS tab_cliente_TerceiraParcela,\n" +
//                        "     tab_cliente.`QuartaParcela` AS tab_cliente_QuartaParcela,\n" +
//                        "     tab_cliente.`QuantidadeDeParcelas` AS tab_cliente_QuantidadeDeParcelas,\n" +
//                        "     tab_cliente.`ValorDaParcela` AS tab_cliente_ValorDaParcela,\n" +
//                        "     tab_cliente.`DiaVencimento` AS tab_cliente_DiaVencimento,\n" +
//                        "     tab_cliente.`SituacaoPagamento` AS tab_cliente_SituacaoPagamento,\n" +
//                        "     tab_cliente.`DataContrato` AS tab_cliente_DataContrato,\n" +
//                        "     tab_cliente.`EstadoCivil` AS tab_cliente_EstadoCivil,\n" +
//                        "     tab_cliente.`RuaCobranca` AS tab_cliente_RuaCobranca,\n" +
//                        "     tab_cliente.`NumeroCobranca` AS tab_cliente_NumeroCobranca,\n" +
//                        "     tab_cliente.`BairroCobranca` AS tab_cliente_BairroCobranca,\n" +
//                        "     tab_cliente.`CidadeCobranca` AS tab_cliente_CidadeCobranca,\n" +
//                        "     tab_cliente.`UfCobranca` AS tab_cliente_UfCobranca,\n" +
//                        "     tab_cliente.`CEPCobranca` AS tab_cliente_CEPCobranca,\n" +
//                        "     tab_cliente.`NomeConjugue` AS tab_cliente_NomeConjugue,\n" +
//                        "     tab_cliente.`IdentidadeConjugue` AS tab_cliente_IdentidadeConjugue,\n" +
//                        "     tab_cliente.`ProfissaoConjugue` AS tab_cliente_ProfissaoConjugue,\n" +
//                        "     tab_cliente.`NascimentoConjugue` AS tab_cliente_NascimentoConjugue,\n" +
//                        "     tab_cliente.`CPFConjugue` AS tab_cliente_CPFConjugue,\n" +
//                        "     tab_cliente.`dataInicioDaUtilizacaoDoSistema` AS tab_cliente_dataInicioDaUtilizacaoDoSistema,\n" +
//                        "     tab_cliente.`Perfil` AS tab_cliente_Perfil,\n" +
//                        "     tab_cliente.`Graduacao` AS tab_cliente_Graduacao,\n" +
//                        "     tab_cliente.`QuantidadeDeGraus` AS tab_cliente_QuantidadeDeGraus,\n" +
//                        "     tab_cliente.`Tipo` AS tab_cliente_Tipo,\n" +
//                        "     tab_cliente.`Idade` AS tab_cliente_Idade,\n" +
//                        "     tab_cliente.`Nacionalidade` AS tab_cliente_Nacionalidade,\n" +
//                        "     tab_cliente.`NacionalidadeConugue` AS tab_cliente_NacionalidadeConugue,\n" +
//                        "     tab_cliente.`TelefoneConjugue` AS tab_cliente_TelefoneConjugue,\n" +
//                        "     tab_cliente.`ValorDaCompraPorExtenso` AS tab_cliente_ValorDaCompraPorExtenso,\n" +
//                        "     tab_cliente.`DataDoContratoPorExtenso` AS tab_cliente_DataDoContratoPorExtenso,\n" +
//                        "     tab_cliente.`DescricaoFrente` AS tab_cliente_DescricaoFrente,\n" +
//                        "     tab_cliente.`DescricaoFundos` AS tab_cliente_DescricaoFundos,\n" +
//                        "     tab_cliente.`MedicaoFrente` AS tab_cliente_MedicaoFrente,\n" +
//                        "     tab_cliente.`MedicaoFundos` AS tab_cliente_MedicaoFundos,\n" +
//                        "     tab_cliente.`DescricaoLD` AS tab_cliente_DescricaoLD,\n" +
//                        "     tab_cliente.`DescricaoLE` AS tab_cliente_DescricaoLE,\n" +
//                        "     tab_cliente.`MedicaoLD` AS tab_cliente_MedicaoLD,\n" +
//                        "     tab_cliente.`MedicaoLE` AS tab_cliente_MedicaoLE,\n" +
//                        "     tab_cliente.`TotalParcelado` AS tab_cliente_TotalParcelado\n" +
//                        "FROM\n" +
//                        "     `tab_cliente` tab_cliente";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Relação de Clientes");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                //viewer.setAlwaysOnTop(true);
//                viewer.show();
//                
//                
//                
//                
//        }
//        
//        public void gerarImpressaoNFe( String caminhoIreport, String idNFE) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                        "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                        "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                        "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                        "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                        "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                        "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                        "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                        "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                        "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                        "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                        "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                        "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                        "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                        "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                        "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                        "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                        "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                        "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                        "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                        "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                        "     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//                        "     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//                        "     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//                        "     tab_versao.`id` AS tab_versao_id,\n" +
//                        "     tab_versao.`versao` AS tab_versao_versao,\n" +
//                        "     tab_nota_fiscal_lancamento.`id` AS tab_nota_fiscal_lancamento_id,\n" +
//                        "     tab_nota_fiscal_lancamento.`NumeroNF` AS tab_nota_fiscal_lancamento_NumeroNF,\n" +
//                        "     tab_nota_fiscal_lancamento.`TipoLancamento` AS tab_nota_fiscal_lancamento_TipoLancamento,\n" +
//                        "     tab_nota_fiscal_lancamento.`Status` AS tab_nota_fiscal_lancamento_Status,\n" +
//                        "     tab_nota_fiscal_lancamento.`CFOP` AS tab_nota_fiscal_lancamento_CFOP,\n" +
//                        "     tab_nota_fiscal_lancamento.`Serie` AS tab_nota_fiscal_lancamento_Serie,\n" +
//                        "     tab_nota_fiscal_lancamento.`Modelo` AS tab_nota_fiscal_lancamento_Modelo,\n" +
//                        "     tab_nota_fiscal_lancamento.`idFornecedor` AS tab_nota_fiscal_lancamento_idFornecedor,\n" +
//                        "     tab_nota_fiscal_lancamento.`NomeFornecedor` AS tab_nota_fiscal_lancamento_NomeFornecedor,\n" +
//                        "     tab_nota_fiscal_lancamento.`razao` AS tab_nota_fiscal_lancamento_razao,\n" +
//                        "     tab_nota_fiscal_lancamento.`endereco` AS tab_nota_fiscal_lancamento_endereco,\n" +
//                        "     tab_nota_fiscal_lancamento.`bairro` AS tab_nota_fiscal_lancamento_bairro,\n" +
//                        "     tab_nota_fiscal_lancamento.`cidade` AS tab_nota_fiscal_lancamento_cidade,\n" +
//                        "     tab_nota_fiscal_lancamento.`estado` AS tab_nota_fiscal_lancamento_estado,\n" +
//                        "     tab_nota_fiscal_lancamento.`cep` AS tab_nota_fiscal_lancamento_cep,\n" +
//                        "     tab_nota_fiscal_lancamento.`cnpj` AS tab_nota_fiscal_lancamento_cnpj,\n" +
//                        "     tab_nota_fiscal_lancamento.`telefone` AS tab_nota_fiscal_lancamento_telefone,\n" +
//                        "     tab_nota_fiscal_lancamento.`numero` AS tab_nota_fiscal_lancamento_numero,\n" +
//                        "     tab_nota_fiscal_lancamento.`email` AS tab_nota_fiscal_lancamento_email,\n" +
//                        "     tab_nota_fiscal_lancamento.`complemento` AS tab_nota_fiscal_lancamento_complemento,\n" +
//                        "     tab_nota_fiscal_lancamento.`TotalProdutos` AS tab_nota_fiscal_lancamento_TotalProdutos,\n" +
//                        "     tab_nota_fiscal_lancamento.`TotalImpostos` AS tab_nota_fiscal_lancamento_TotalImpostos,\n" +
//                        "     tab_nota_fiscal_lancamento.`TotalAdicionais` AS tab_nota_fiscal_lancamento_TotalAdicionais,\n" +
//                        "     tab_nota_fiscal_lancamento.`TotalNF` AS tab_nota_fiscal_lancamento_TotalNF,\n" +
//                        "     tab_nota_fiscal_lancamento.`PlacaCarro` AS tab_nota_fiscal_lancamento_PlacaCarro,\n" +
//                        "     tab_nota_fiscal_lancamento.`Motorista` AS tab_nota_fiscal_lancamento_Motorista,\n" +
//                        "     tab_nota_fiscal_lancamento.`idTransportadora` AS tab_nota_fiscal_lancamento_idTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`NomeTransportadora` AS tab_nota_fiscal_lancamento_NomeTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`razaoTransportadora` AS tab_nota_fiscal_lancamento_razaoTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`enderecoTransportadora` AS tab_nota_fiscal_lancamento_enderecoTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`bairroTransportadora` AS tab_nota_fiscal_lancamento_bairroTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`cidadeTransportadora` AS tab_nota_fiscal_lancamento_cidadeTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`estadoTransportadora` AS tab_nota_fiscal_lancamento_estadoTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`cepTransportadora` AS tab_nota_fiscal_lancamento_cepTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`cnpjTransportadora` AS tab_nota_fiscal_lancamento_cnpjTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`telefoneTransportadora` AS tab_nota_fiscal_lancamento_telefoneTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`numeroTransportadora` AS tab_nota_fiscal_lancamento_numeroTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`emailTransportadora` AS tab_nota_fiscal_lancamento_emailTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`complementoTransportadora` AS tab_nota_fiscal_lancamento_complementoTransportadora,\n" +
//                        "     tab_nota_fiscal_lancamento.`dataInclusao` AS tab_nota_fiscal_lancamento_dataInclusao,\n" +
//                        "     tab_nota_fiscal_lancamento.`horaInclusao` AS tab_nota_fiscal_lancamento_horaInclusao,\n" +
//                        "     tab_nota_fiscal_lancamento.`chaveAcesso` AS tab_nota_fiscal_lancamento_chaveAcesso,\n" +
//                        "     tab_nota_fiscal_lancamento.`Integrado` AS tab_nota_fiscal_lancamento_Integrado,\n" +
//                        "     tab_nota_fiscal_lancamento.`DataIntegracao` AS tab_nota_fiscal_lancamento_DataIntegracao\n" +
//                        "FROM\n" +
//                        "     `tab_empresa` tab_empresa,\n" +
//                        "     `tab_versao` tab_versao,\n" +
//                        "     `tab_nota_fiscal_lancamento` tab_nota_fiscal_lancamento\n" +
//                        "where \n" +
//                        "     tab_nota_fiscal_lancamento.id='"+idNFE+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Impressão de NFe");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                //viewer.setAlwaysOnTop(true);
//                viewer.show();
//                
//                
//                
//                
//        }
//        
//        public void gerarOSgrafica( String caminhoIreport , String id_OS, String id_cliente) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                "     tab_ordemdeservicografica.`id` AS tab_ordemdeservicografica_id,\n" +
//                "     tab_ordemdeservicografica.`NomeCliente` AS tab_ordemdeservicografica_NomeCliente,\n" +
//                "     tab_ordemdeservicografica.`IDCliente` AS tab_ordemdeservicografica_IDCliente,\n" +
//                "     tab_ordemdeservicografica.`CPFCliente` AS tab_ordemdeservicografica_CPFCliente,\n" +
//                "     tab_ordemdeservicografica.`TelefoneCliente` AS tab_ordemdeservicografica_TelefoneCliente,\n" +
//                "     tab_ordemdeservicografica.`Responsavel` AS tab_ordemdeservicografica_Responsavel,\n" +
//                "     tab_ordemdeservicografica.`IdOrdemServico` AS tab_ordemdeservicografica_IdOrdemServico,\n" +
//                "     tab_ordemdeservicografica.`Motivo` AS tab_ordemdeservicografica_Motivo,\n" +
//                "     tab_ordemdeservicografica.`Status` AS tab_ordemdeservicografica_Status,\n" +
//                "     tab_ordemdeservicografica.`DataInclusao` AS tab_ordemdeservicografica_DataInclusao,\n" +
//                "     tab_ordemdeservicografica.`DataInclusaoSemBarra` AS tab_ordemdeservicografica_DataInclusaoSemBarra,\n" +
//                "     tab_ordemdeservicografica.`DataAlteracao` AS tab_ordemdeservicografica_DataAlteracao,\n" +
//                "     tab_ordemdeservicografica.`DataConclusao` AS tab_ordemdeservicografica_DataConclusao,\n" +
//                "     tab_ordemdeservicografica.`ObsCliente` AS tab_ordemdeservicografica_ObsCliente,\n" +
//                "     tab_ordemdeservicografica.`ValorServico` AS tab_ordemdeservicografica_ValorServico,\n" +
//                "     tab_ordemdeservicografica.`ValorTotalProdutos` AS tab_ordemdeservicografica_ValorTotalProdutos,\n" +
//                "     tab_ordemdeservicografica.`ValorTotalGeral` AS tab_ordemdeservicografica_ValorTotalGeral,\n" +
//                "     tab_ordemdeservicografica.`FormaPagamento` AS tab_ordemdeservicografica_FormaPagamento,\n" +
//                "     tab_ordemdeservicografica.`DataPagamento` AS tab_ordemdeservicografica_DataPagamento,\n" +
//                "     tab_ordemdeservicografica.`ObsPagamento` AS tab_ordemdeservicografica_ObsPagamento,\n" +
//                "     tab_ordemdeservicografica.`NumeroNF` AS tab_ordemdeservicografica_NumeroNF,\n" +
//                "     tab_servico_ordemdeservicografica.`id` AS tab_servico_ordemdeservicografica_id,\n" +
//                "     tab_servico_ordemdeservicografica.`id_ordemDeSErvico` AS tab_servico_ordemdeservicografica_id_ordemDeSErvico,\n" +
//                "     tab_servico_ordemdeservicografica.`servico` AS tab_servico_ordemdeservicografica_servico,\n" +
//                "     tab_servico_ordemdeservicografica.`medida` AS tab_servico_ordemdeservicografica_medida,\n" +
//                "     tab_servico_ordemdeservicografica.`numeroTalao` AS tab_servico_ordemdeservicografica_numeroTalao,\n" +
//                "     tab_servico_ordemdeservicografica.`material` AS tab_servico_ordemdeservicografica_material,\n" +
//                "     tab_servico_ordemdeservicografica.`quantidade` AS tab_servico_ordemdeservicografica_quantidade,\n" +
//                "     tab_servico_ordemdeservicografica.`preco` AS tab_servico_ordemdeservicografica_preco,\n" +
//                "     tab_cliente.`id` AS tab_cliente_id,\n" +
//                "     tab_cliente.`nome` AS tab_cliente_nome,\n" +
//                "     tab_cliente.`endereco` AS tab_cliente_endereco,\n" +
//                "     tab_cliente.`bairro` AS tab_cliente_bairro,\n" +
//                "     tab_cliente.`cidade` AS tab_cliente_cidade,\n" +
//                "     tab_cliente.`estado` AS tab_cliente_estado,\n" +
//                "     tab_cliente.`cep` AS tab_cliente_cep,\n" +
//                "     tab_cliente.`cnpj` AS tab_cliente_cnpj,\n" +
//                "     tab_cliente.`telefone` AS tab_cliente_telefone,\n" +
//                "     tab_cliente.`numero` AS tab_cliente_numero,\n" +
//                "     tab_cliente.`observacao` AS tab_cliente_observacao,\n" +
//                "     tab_cliente.`matricula` AS tab_cliente_matricula,\n" +
//                "     tab_cliente.`email` AS tab_cliente_email,\n" +
//                "     tab_cliente.`apto` AS tab_cliente_apto,\n" +
//                "     tab_cliente.`pai` AS tab_cliente_pai,\n" +
//                "     tab_cliente.`mae` AS tab_cliente_mae,\n" +
//                "     tab_cliente.`tel_trabalho` AS tab_cliente_tel_trabalho,\n" +
//                "     tab_cliente.`data_nascimento` AS tab_cliente_data_nascimento,\n" +
//                "     tab_cliente.`codigo_municipio` AS tab_cliente_codigo_municipio,\n" +
//                "     tab_cliente.`insc_estadual` AS tab_cliente_insc_estadual,\n" +
//                "     tab_cliente.`descricaoContrato` AS tab_cliente_descricaoContrato,\n" +
//                "     tab_cliente.`valorInstalacao` AS tab_cliente_valorInstalacao,\n" +
//                "     tab_cliente.`valorMensalidade` AS tab_cliente_valorMensalidade,\n" +
//                "     tab_cliente.`numeroDeMensalidades` AS tab_cliente_numeroDeMensalidades,\n" +
//                "     tab_cliente.`vencimentoMensalidade` AS tab_cliente_vencimentoMensalidade,\n" +
//                "     tab_cliente.`celular` AS tab_cliente_celular,\n" +
//                "     tab_cliente.`razao` AS tab_cliente_razao,\n" +
//                "     tab_servico_ordemdeservicografica.`TipoTalao` AS tab_servico_ordemdeservicografica_TipoTalao\n" +
//                "FROM\n" +
//                "     `tab_empresa` tab_empresa,\n" +
//                "     `tab_ordemdeservicografica` tab_ordemdeservicografica,\n" +
//                "     `tab_servico_ordemdeservicografica` tab_servico_ordemdeservicografica,\n" +
//                "     `tab_cliente` tab_cliente\n" +
//                "WHERE\n" +
//                "     tab_empresa.id = '1'\n" +
//                " AND tab_ordemdeservicografica.id = '"+id_OS+"'\n" +
//                " AND tab_servico_ordemdeservicografica.id_ordemDeSErvico = '"+id_OS+"'\n" +
//                " AND tab_cliente.id = '"+id_cliente+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir OS");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//        }
//        
//        public void gerarOSotica( String caminhoIreport , String id_OS) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//"     tab_empresa.`id` AS tab_empresa_id,\n" +
//"     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//"     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//"     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//"     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//"     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//"     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//"     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//"     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//"     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//"     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//"     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//"     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//"     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//"     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//"     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//"     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//"     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//"     tab_empresa.`email` AS tab_empresa_email,\n" +
//"     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//"     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//"     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//"     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//"     tab_ordem_servico_otica.`id` AS tab_ordem_servico_otica_id,\n" +
//"     tab_ordem_servico_otica.`IdCliente` AS tab_ordem_servico_otica_IdCliente,\n" +
//"     tab_ordem_servico_otica.`NomeCliente` AS tab_ordem_servico_otica_NomeCliente,\n" +
//"     tab_ordem_servico_otica.`CPFCliente` AS tab_ordem_servico_otica_CPFCliente,\n" +
//"     tab_ordem_servico_otica.`DataEntrada` AS tab_ordem_servico_otica_DataEntrada,\n" +
//"     tab_ordem_servico_otica.`HoraEntrada` AS tab_ordem_servico_otica_HoraEntrada,\n" +
//"     tab_ordem_servico_otica.`DataEntrega` AS tab_ordem_servico_otica_DataEntrega,\n" +
//"     tab_ordem_servico_otica.`HoraEntrega` AS tab_ordem_servico_otica_HoraEntrega,\n" +
//"     tab_ordem_servico_otica.`Otica` AS tab_ordem_servico_otica_Otica,\n" +
//"     tab_ordem_servico_otica.`Contato` AS tab_ordem_servico_otica_Contato,\n" +
//"     tab_ordem_servico_otica.`Telefone` AS tab_ordem_servico_otica_Telefone,\n" +
//"     tab_ordem_servico_otica.`TipoDeLente` AS tab_ordem_servico_otica_TipoDeLente,\n" +
//"     tab_ordem_servico_otica.`Coloracao` AS tab_ordem_servico_otica_Coloracao,\n" +
//"     tab_ordem_servico_otica.`Tratamentos` AS tab_ordem_servico_otica_Tratamentos,\n" +
//"     tab_ordem_servico_otica.`Observacao` AS tab_ordem_servico_otica_Observacao,\n" +
//"     tab_ordem_servico_otica.`ProfissionalResponsavel` AS tab_ordem_servico_otica_ProfissionalResponsavel,\n" +
//"     tab_ordem_servico_otica.`ReceitaValidaAte` AS tab_ordem_servico_otica_ReceitaValidaAte,\n" +
//"     tab_ordem_servico_otica.`Laboratorio` AS tab_ordem_servico_otica_Laboratorio,\n" +
//"     tab_ordem_servico_otica.`LocalDeMontagem` AS tab_ordem_servico_otica_LocalDeMontagem,\n" +
//"     tab_ordem_servico_otica.`ClientePossuiReceita` AS tab_ordem_servico_otica_ClientePossuiReceita,\n" +
//"     tab_ordem_servico_otica.`NomeProduto` AS tab_ordem_servico_otica_NomeProduto,\n" +
//"     tab_ordem_servico_otica.`QuantidadeProduto` AS tab_ordem_servico_otica_QuantidadeProduto,\n" +
//"     tab_ordem_servico_otica.`ReferenciaProduto` AS tab_ordem_servico_otica_ReferenciaProduto,\n" +
//"     tab_ordem_servico_otica.`ValorProduto` AS tab_ordem_servico_otica_ValorProduto,\n" +
//"     tab_ordem_servico_otica.`LenteTipo` AS tab_ordem_servico_otica_LenteTipo,\n" +
//"     tab_ordem_servico_otica.`LenteMaterial` AS tab_ordem_servico_otica_LenteMaterial,\n" +
//"     tab_ordem_servico_otica.`LenteColoracao` AS tab_ordem_servico_otica_LenteColoracao,\n" +
//"     tab_ordem_servico_otica.`LenteDescricao` AS tab_ordem_servico_otica_LenteDescricao,\n" +
//"     tab_ordem_servico_otica.`LenteTratamentoAplicado` AS tab_ordem_servico_otica_LenteTratamentoAplicado,\n" +
//"     tab_ordem_servico_otica.`ArmacaoPropria` AS tab_ordem_servico_otica_ArmacaoPropria,\n" +
//"     tab_ordem_servico_otica.`ArmacaoSegue` AS tab_ordem_servico_otica_ArmacaoSegue,\n" +
//"     tab_ordem_servico_otica.`ArmacaoTipo` AS tab_ordem_servico_otica_ArmacaoTipo,\n" +
//"     tab_ordem_servico_otica.`ArmacaoArmacaoAro` AS tab_ordem_servico_otica_ArmacaoArmacaoAro,\n" +
//"     tab_ordem_servico_otica.`ArmacaoPonte` AS tab_ordem_servico_otica_ArmacaoPonte,\n" +
//"     tab_ordem_servico_otica.`ArmacaoMaiorDiagonal` AS tab_ordem_servico_otica_ArmacaoMaiorDiagonal,\n" +
//"     tab_ordem_servico_otica.`ArmacaoAlturaVertical` AS tab_ordem_servico_otica_ArmacaoAlturaVertical,\n" +
//"     tab_ordem_servico_otica.`LongeOdEsf` AS tab_ordem_servico_otica_LongeOdEsf,\n" +
//"     tab_ordem_servico_otica.`LongeOeEsf` AS tab_ordem_servico_otica_LongeOeEsf,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoEsf` AS tab_ordem_servico_otica_LongeAdicaoEsf,\n" +
//"     tab_ordem_servico_otica.`LongeOdCil` AS tab_ordem_servico_otica_LongeOdCil,\n" +
//"     tab_ordem_servico_otica.`LongeOeCil` AS tab_ordem_servico_otica_LongeOeCil,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoCil` AS tab_ordem_servico_otica_LongeAdicaoCil,\n" +
//"     tab_ordem_servico_otica.`LongeOdEixo` AS tab_ordem_servico_otica_LongeOdEixo,\n" +
//"     tab_ordem_servico_otica.`LongeOeEixo` AS tab_ordem_servico_otica_LongeOeEixo,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoEixo` AS tab_ordem_servico_otica_LongeAdicaoEixo,\n" +
//"     tab_ordem_servico_otica.`LongeOdDP` AS tab_ordem_servico_otica_LongeOdDP,\n" +
//"     tab_ordem_servico_otica.`LongeOeDP` AS tab_ordem_servico_otica_LongeOeDP,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoDP` AS tab_ordem_servico_otica_LongeAdicaoDP,\n" +
//"     tab_ordem_servico_otica.`LongeOdAltura` AS tab_ordem_servico_otica_LongeOdAltura,\n" +
//"     tab_ordem_servico_otica.`LongeOeAltura` AS tab_ordem_servico_otica_LongeOeAltura,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoAltura` AS tab_ordem_servico_otica_LongeAdicaoAltura,\n" +
//"     tab_ordem_servico_otica.`PertoOdEsf` AS tab_ordem_servico_otica_PertoOdEsf,\n" +
//"     tab_ordem_servico_otica.`PertoOeEsf` AS tab_ordem_servico_otica_PertoOeEsf,\n" +
//"     tab_ordem_servico_otica.`PertoOdCil` AS tab_ordem_servico_otica_PertoOdCil,\n" +
//"     tab_ordem_servico_otica.`PertoOeCil` AS tab_ordem_servico_otica_PertoOeCil,\n" +
//"     tab_ordem_servico_otica.`PertoOdEixo` AS tab_ordem_servico_otica_PertoOdEixo,\n" +
//"     tab_ordem_servico_otica.`PertoOeEixo` AS tab_ordem_servico_otica_PertoOeEixo,\n" +
//"     tab_ordem_servico_otica.`PertoOdDP` AS tab_ordem_servico_otica_PertoOdDP,\n" +
//"     tab_ordem_servico_otica.`PertoOeDP` AS tab_ordem_servico_otica_PertoOeDP,\n" +
//"     tab_ordem_servico_otica.`PertoOdAltura` AS tab_ordem_servico_otica_PertoOdAltura,\n" +
//"     tab_ordem_servico_otica.`PertoOeAltura` AS tab_ordem_servico_otica_PertoOeAltura,\n" +
//"     tab_ordem_servico_otica.`RecebidoPor` AS tab_ordem_servico_otica_RecebidoPor,\n" +
//"     tab_ordem_servico_otica.`ValorTotalDaOrdemDeServico` AS tab_ordem_servico_otica_ValorTotalDaOrdemDeServico,\n" +
//"     tab_ordem_servico_otica.`ValorDoSinal` AS tab_ordem_servico_otica_ValorDoSinal,\n" +
//"     tab_ordem_servico_otica.`ValorRestante` AS tab_ordem_servico_otica_ValorRestante,\n" +
//"     tab_ordem_servico_otica.`FormaDePagamento` AS tab_ordem_servico_otica_FormaDePagamento,\n" +
//"     tab_produto_ordem_de_servico.`id` AS tab_produto_ordem_de_servico_id,\n" +
//"     tab_produto_ordem_de_servico.`id_ordem_de_servico` AS tab_produto_ordem_de_servico_id_ordem_de_servico,\n" +
//"     tab_produto_ordem_de_servico.`cod_produto` AS tab_produto_ordem_de_servico_cod_produto,\n" +
//"     tab_produto_ordem_de_servico.`produto` AS tab_produto_ordem_de_servico_produto,\n" +
//"     tab_produto_ordem_de_servico.`preco` AS tab_produto_ordem_de_servico_preco,\n" +
//"     tab_produto_ordem_de_servico.`quantidade_pedido` AS tab_produto_ordem_de_servico_quantidade_pedido,\n" +
//"     tab_produto_ordem_de_servico.`desconto_unitario` AS tab_produto_ordem_de_servico_desconto_unitario,\n" +
//"     tab_produto_ordem_de_servico.`Integrado` AS tab_produto_ordem_de_servico_Integrado,\n" +
//"     tab_produto_ordem_de_servico.`DataIntegracao` AS tab_produto_ordem_de_servico_DataIntegracao,\n" +
//"     tab_ordem_servico_otica.`ValorTotalDosProdutos` AS tab_ordem_servico_otica_ValorTotalDosProdutos,\n" +
//"     tab_ordem_servico_otica.`ValorTotalDosServicos` AS tab_ordem_servico_otica_ValorTotalDosServicos,\n" +
//"     tab_ordem_servico_otica.`ServicoEfetuado` AS tab_ordem_servico_otica_ServicoEfetuado,\n" +
//"     tab_ordem_servico_otica.`ValorDinheiro` AS tab_ordem_servico_otica_ValorDinheiro,\n" +
//"     tab_ordem_servico_otica.`ValorCartao` AS tab_ordem_servico_otica_ValorCartao,\n" +
//"     tab_ordem_servico_otica.`TipoCartao` AS tab_ordem_servico_otica_TipoCartao,\n" +
//"     tab_ordem_servico_otica.`ValorCheque` AS tab_ordem_servico_otica_ValorCheque,\n" +
//"     tab_ordem_servico_otica.`ValorAReceber` AS tab_ordem_servico_otica_ValorAReceber,\n" +
//"     tab_ordem_servico_otica.`ValorTroco` AS tab_ordem_servico_otica_ValorTroco,\n" +
//"     tab_ordem_servico_otica.`Status` AS tab_ordem_servico_otica_Status,\n" +
//"     tab_ordem_servico_otica.`LenteMaterialTrivex` AS tab_ordem_servico_otica_LenteMaterialTrivex,\n" +
//"     tab_ordem_servico_otica.`LenteMaterialPolicarbonato` AS tab_ordem_servico_otica_LenteMaterialPolicarbonato,\n" +
//"     tab_ordem_servico_otica.`LenteMaterialResina` AS tab_ordem_servico_otica_LenteMaterialResina,\n" +
//"     tab_ordem_servico_otica.`LenteTipoPronta` AS tab_ordem_servico_otica_LenteTipoPronta,\n" +
//"     tab_ordem_servico_otica.`LenteTipoSurfacada` AS tab_ordem_servico_otica_LenteTipoSurfacada,\n" +
//"     tab_ordem_servico_otica.`LocalDeMontagemLoja` AS tab_ordem_servico_otica_LocalDeMontagemLoja,\n" +
//"     tab_ordem_servico_otica.`LocalDeMontagemLaboratorio` AS tab_ordem_servico_otica_LocalDeMontagemLaboratorio,\n" +
//"     tab_ordem_servico_otica.`PossuiReceitaSim` AS tab_ordem_servico_otica_PossuiReceitaSim,\n" +
//"     tab_ordem_servico_otica.`PossuiReceitaNao` AS tab_ordem_servico_otica_PossuiReceitaNao,\n" +
//"     tab_ordem_servico_otica.`PossuiArmacaoSim` AS tab_ordem_servico_otica_PossuiArmacaoSim,\n" +
//"     tab_ordem_servico_otica.`PossuiArmacaoNao` AS tab_ordem_servico_otica_PossuiArmacaoNao,\n" +
//"     tab_ordem_servico_otica.`DataEntradaSemBarras` AS tab_ordem_servico_otica_DataEntradaSemBarras,\n" +
//"     tab_ordem_servico_otica.`LenteMaterialCristal` AS tab_ordem_servico_otica_LenteMaterialCristal\n" +
//"FROM\n" +
//"     `tab_empresa` tab_empresa,\n" +
//"     `tab_ordem_servico_otica` tab_ordem_servico_otica,\n" +
//"     `tab_produto_ordem_de_servico` tab_produto_ordem_de_servico\n" +
//"WHERE\n" +
//                            "      tab_ordem_servico_otica.id='"+id_OS+"'\n" +
//                            "AND   tab_produto_ordem_de_servico.id_ordem_de_servico='"+id_OS+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir OS");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//        }
//        
//        public void gerarOSoticaPagamento( String caminhoIreport , String id_OS) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//"     tab_empresa.`id` AS tab_empresa_id,\n" +
//"     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//"     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//"     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//"     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//"     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//"     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//"     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//"     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//"     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//"     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//"     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//"     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//"     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//"     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//"     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//"     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//"     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//"     tab_empresa.`email` AS tab_empresa_email,\n" +
//"     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//"     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//"     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//"     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//"     tab_ordem_servico_otica.`id` AS tab_ordem_servico_otica_id,\n" +
//"     tab_ordem_servico_otica.`IdCliente` AS tab_ordem_servico_otica_IdCliente,\n" +
//"     tab_ordem_servico_otica.`NomeCliente` AS tab_ordem_servico_otica_NomeCliente,\n" +
//"     tab_ordem_servico_otica.`CPFCliente` AS tab_ordem_servico_otica_CPFCliente,\n" +
//"     tab_ordem_servico_otica.`DataEntrada` AS tab_ordem_servico_otica_DataEntrada,\n" +
//"     tab_ordem_servico_otica.`HoraEntrada` AS tab_ordem_servico_otica_HoraEntrada,\n" +
//"     tab_ordem_servico_otica.`DataEntrega` AS tab_ordem_servico_otica_DataEntrega,\n" +
//"     tab_ordem_servico_otica.`HoraEntrega` AS tab_ordem_servico_otica_HoraEntrega,\n" +
//"     tab_ordem_servico_otica.`Otica` AS tab_ordem_servico_otica_Otica,\n" +
//"     tab_ordem_servico_otica.`Contato` AS tab_ordem_servico_otica_Contato,\n" +
//"     tab_ordem_servico_otica.`Telefone` AS tab_ordem_servico_otica_Telefone,\n" +
//"     tab_ordem_servico_otica.`TipoDeLente` AS tab_ordem_servico_otica_TipoDeLente,\n" +
//"     tab_ordem_servico_otica.`Coloracao` AS tab_ordem_servico_otica_Coloracao,\n" +
//"     tab_ordem_servico_otica.`Tratamentos` AS tab_ordem_servico_otica_Tratamentos,\n" +
//"     tab_ordem_servico_otica.`Observacao` AS tab_ordem_servico_otica_Observacao,\n" +
//"     tab_ordem_servico_otica.`ProfissionalResponsavel` AS tab_ordem_servico_otica_ProfissionalResponsavel,\n" +
//"     tab_ordem_servico_otica.`ReceitaValidaAte` AS tab_ordem_servico_otica_ReceitaValidaAte,\n" +
//"     tab_ordem_servico_otica.`Laboratorio` AS tab_ordem_servico_otica_Laboratorio,\n" +
//"     tab_ordem_servico_otica.`LocalDeMontagem` AS tab_ordem_servico_otica_LocalDeMontagem,\n" +
//"     tab_ordem_servico_otica.`ClientePossuiReceita` AS tab_ordem_servico_otica_ClientePossuiReceita,\n" +
//"     tab_ordem_servico_otica.`NomeProduto` AS tab_ordem_servico_otica_NomeProduto,\n" +
//"     tab_ordem_servico_otica.`QuantidadeProduto` AS tab_ordem_servico_otica_QuantidadeProduto,\n" +
//"     tab_ordem_servico_otica.`ReferenciaProduto` AS tab_ordem_servico_otica_ReferenciaProduto,\n" +
//"     tab_ordem_servico_otica.`ValorProduto` AS tab_ordem_servico_otica_ValorProduto,\n" +
//"     tab_ordem_servico_otica.`LenteTipo` AS tab_ordem_servico_otica_LenteTipo,\n" +
//"     tab_ordem_servico_otica.`LenteMaterial` AS tab_ordem_servico_otica_LenteMaterial,\n" +
//"     tab_ordem_servico_otica.`LenteColoracao` AS tab_ordem_servico_otica_LenteColoracao,\n" +
//"     tab_ordem_servico_otica.`LenteDescricao` AS tab_ordem_servico_otica_LenteDescricao,\n" +
//"     tab_ordem_servico_otica.`LenteTratamentoAplicado` AS tab_ordem_servico_otica_LenteTratamentoAplicado,\n" +
//"     tab_ordem_servico_otica.`ArmacaoPropria` AS tab_ordem_servico_otica_ArmacaoPropria,\n" +
//"     tab_ordem_servico_otica.`ArmacaoSegue` AS tab_ordem_servico_otica_ArmacaoSegue,\n" +
//"     tab_ordem_servico_otica.`ArmacaoTipo` AS tab_ordem_servico_otica_ArmacaoTipo,\n" +
//"     tab_ordem_servico_otica.`ArmacaoArmacaoAro` AS tab_ordem_servico_otica_ArmacaoArmacaoAro,\n" +
//"     tab_ordem_servico_otica.`ArmacaoPonte` AS tab_ordem_servico_otica_ArmacaoPonte,\n" +
//"     tab_ordem_servico_otica.`ArmacaoMaiorDiagonal` AS tab_ordem_servico_otica_ArmacaoMaiorDiagonal,\n" +
//"     tab_ordem_servico_otica.`ArmacaoAlturaVertical` AS tab_ordem_servico_otica_ArmacaoAlturaVertical,\n" +
//"     tab_ordem_servico_otica.`LongeOdEsf` AS tab_ordem_servico_otica_LongeOdEsf,\n" +
//"     tab_ordem_servico_otica.`LongeOeEsf` AS tab_ordem_servico_otica_LongeOeEsf,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoEsf` AS tab_ordem_servico_otica_LongeAdicaoEsf,\n" +
//"     tab_ordem_servico_otica.`LongeOdCil` AS tab_ordem_servico_otica_LongeOdCil,\n" +
//"     tab_ordem_servico_otica.`LongeOeCil` AS tab_ordem_servico_otica_LongeOeCil,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoCil` AS tab_ordem_servico_otica_LongeAdicaoCil,\n" +
//"     tab_ordem_servico_otica.`LongeOdEixo` AS tab_ordem_servico_otica_LongeOdEixo,\n" +
//"     tab_ordem_servico_otica.`LongeOeEixo` AS tab_ordem_servico_otica_LongeOeEixo,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoEixo` AS tab_ordem_servico_otica_LongeAdicaoEixo,\n" +
//"     tab_ordem_servico_otica.`LongeOdDP` AS tab_ordem_servico_otica_LongeOdDP,\n" +
//"     tab_ordem_servico_otica.`LongeOeDP` AS tab_ordem_servico_otica_LongeOeDP,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoDP` AS tab_ordem_servico_otica_LongeAdicaoDP,\n" +
//"     tab_ordem_servico_otica.`LongeOdAltura` AS tab_ordem_servico_otica_LongeOdAltura,\n" +
//"     tab_ordem_servico_otica.`LongeOeAltura` AS tab_ordem_servico_otica_LongeOeAltura,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoAltura` AS tab_ordem_servico_otica_LongeAdicaoAltura,\n" +
//"     tab_ordem_servico_otica.`PertoOdEsf` AS tab_ordem_servico_otica_PertoOdEsf,\n" +
//"     tab_ordem_servico_otica.`PertoOeEsf` AS tab_ordem_servico_otica_PertoOeEsf,\n" +
//"     tab_ordem_servico_otica.`PertoOdCil` AS tab_ordem_servico_otica_PertoOdCil,\n" +
//"     tab_ordem_servico_otica.`PertoOeCil` AS tab_ordem_servico_otica_PertoOeCil,\n" +
//"     tab_ordem_servico_otica.`PertoOdEixo` AS tab_ordem_servico_otica_PertoOdEixo,\n" +
//"     tab_ordem_servico_otica.`PertoOeEixo` AS tab_ordem_servico_otica_PertoOeEixo,\n" +
//"     tab_ordem_servico_otica.`PertoOdDP` AS tab_ordem_servico_otica_PertoOdDP,\n" +
//"     tab_ordem_servico_otica.`PertoOeDP` AS tab_ordem_servico_otica_PertoOeDP,\n" +
//"     tab_ordem_servico_otica.`PertoOdAltura` AS tab_ordem_servico_otica_PertoOdAltura,\n" +
//"     tab_ordem_servico_otica.`PertoOeAltura` AS tab_ordem_servico_otica_PertoOeAltura,\n" +
//"     tab_ordem_servico_otica.`RecebidoPor` AS tab_ordem_servico_otica_RecebidoPor,\n" +
//"     tab_ordem_servico_otica.`ValorTotalDaOrdemDeServico` AS tab_ordem_servico_otica_ValorTotalDaOrdemDeServico,\n" +
//"     tab_ordem_servico_otica.`ValorDoSinal` AS tab_ordem_servico_otica_ValorDoSinal,\n" +
//"     tab_ordem_servico_otica.`ValorRestante` AS tab_ordem_servico_otica_ValorRestante,\n" +
//"     tab_ordem_servico_otica.`FormaDePagamento` AS tab_ordem_servico_otica_FormaDePagamento,\n" +
//"     tab_ordem_servico_otica.`ValorTotalDosProdutos` AS tab_ordem_servico_otica_ValorTotalDosProdutos,\n" +
//"     tab_ordem_servico_otica.`ValorTotalDosServicos` AS tab_ordem_servico_otica_ValorTotalDosServicos,\n" +
//"     tab_ordem_servico_otica.`ServicoEfetuado` AS tab_ordem_servico_otica_ServicoEfetuado,\n" +
//"     tab_ordem_servico_otica.`ValorDinheiro` AS tab_ordem_servico_otica_ValorDinheiro,\n" +
//"     tab_ordem_servico_otica.`ValorCartao` AS tab_ordem_servico_otica_ValorCartao,\n" +
//"     tab_ordem_servico_otica.`TipoCartao` AS tab_ordem_servico_otica_TipoCartao,\n" +
//"     tab_ordem_servico_otica.`ValorCheque` AS tab_ordem_servico_otica_ValorCheque,\n" +
//"     tab_ordem_servico_otica.`ValorAReceber` AS tab_ordem_servico_otica_ValorAReceber,\n" +
//"     tab_ordem_servico_otica.`ValorTroco` AS tab_ordem_servico_otica_ValorTroco,\n" +
//"     tab_ordem_servico_otica.`Status` AS tab_ordem_servico_otica_Status,\n" +
//"     tab_ordem_servico_otica.`LenteMaterialTrivex` AS tab_ordem_servico_otica_LenteMaterialTrivex,\n" +
//"     tab_ordem_servico_otica.`LenteMaterialPolicarbonato` AS tab_ordem_servico_otica_LenteMaterialPolicarbonato,\n" +
//"     tab_ordem_servico_otica.`LenteMaterialResina` AS tab_ordem_servico_otica_LenteMaterialResina,\n" +
//"     tab_ordem_servico_otica.`LenteTipoPronta` AS tab_ordem_servico_otica_LenteTipoPronta,\n" +
//"     tab_ordem_servico_otica.`LenteTipoSurfacada` AS tab_ordem_servico_otica_LenteTipoSurfacada,\n" +
//"     tab_ordem_servico_otica.`LocalDeMontagemLoja` AS tab_ordem_servico_otica_LocalDeMontagemLoja,\n" +
//"     tab_ordem_servico_otica.`LocalDeMontagemLaboratorio` AS tab_ordem_servico_otica_LocalDeMontagemLaboratorio,\n" +
//"     tab_ordem_servico_otica.`PossuiReceitaSim` AS tab_ordem_servico_otica_PossuiReceitaSim,\n" +
//"     tab_ordem_servico_otica.`PossuiReceitaNao` AS tab_ordem_servico_otica_PossuiReceitaNao,\n" +
//"     tab_ordem_servico_otica.`PossuiArmacaoSim` AS tab_ordem_servico_otica_PossuiArmacaoSim,\n" +
//"     tab_ordem_servico_otica.`PossuiArmacaoNao` AS tab_ordem_servico_otica_PossuiArmacaoNao,\n" +
//"     tab_ordem_servico_otica.`DataEntradaSemBarras` AS tab_ordem_servico_otica_DataEntradaSemBarras,\n" +
//"     tab_ordem_servico_otica.`LenteMaterialCristal` AS tab_ordem_servico_otica_LenteMaterialCristal\n" +
//"FROM\n" +
//"     `tab_empresa` tab_empresa,\n" +
//"     `tab_ordem_servico_otica` tab_ordem_servico_otica\n" +
//"WHERE\n" +
//                            "      tab_ordem_servico_otica.id='"+id_OS+"'" ;
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir OS");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//        }
//        
//        public void gerarOSoticaSemProdutos( String caminhoIreport , String id_OS) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//"     tab_empresa.`id` AS tab_empresa_id,\n" +
//"     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//"     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//"     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//"     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//"     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//"     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//"     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//"     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//"     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//"     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//"     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//"     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//"     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//"     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//"     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//"     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//"     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//"     tab_empresa.`email` AS tab_empresa_email,\n" +
//"     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//"     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//"     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//"     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//"     tab_ordem_servico_otica.`id` AS tab_ordem_servico_otica_id,\n" +
//"     tab_ordem_servico_otica.`IdCliente` AS tab_ordem_servico_otica_IdCliente,\n" +
//"     tab_ordem_servico_otica.`NomeCliente` AS tab_ordem_servico_otica_NomeCliente,\n" +
//"     tab_ordem_servico_otica.`CPFCliente` AS tab_ordem_servico_otica_CPFCliente,\n" +
//"     tab_ordem_servico_otica.`DataEntrada` AS tab_ordem_servico_otica_DataEntrada,\n" +
//"     tab_ordem_servico_otica.`HoraEntrada` AS tab_ordem_servico_otica_HoraEntrada,\n" +
//"     tab_ordem_servico_otica.`DataEntrega` AS tab_ordem_servico_otica_DataEntrega,\n" +
//"     tab_ordem_servico_otica.`HoraEntrega` AS tab_ordem_servico_otica_HoraEntrega,\n" +
//"     tab_ordem_servico_otica.`Otica` AS tab_ordem_servico_otica_Otica,\n" +
//"     tab_ordem_servico_otica.`Contato` AS tab_ordem_servico_otica_Contato,\n" +
//"     tab_ordem_servico_otica.`Telefone` AS tab_ordem_servico_otica_Telefone,\n" +
//"     tab_ordem_servico_otica.`TipoDeLente` AS tab_ordem_servico_otica_TipoDeLente,\n" +
//"     tab_ordem_servico_otica.`Coloracao` AS tab_ordem_servico_otica_Coloracao,\n" +
//"     tab_ordem_servico_otica.`Tratamentos` AS tab_ordem_servico_otica_Tratamentos,\n" +
//"     tab_ordem_servico_otica.`Observacao` AS tab_ordem_servico_otica_Observacao,\n" +
//"     tab_ordem_servico_otica.`ProfissionalResponsavel` AS tab_ordem_servico_otica_ProfissionalResponsavel,\n" +
//"     tab_ordem_servico_otica.`ReceitaValidaAte` AS tab_ordem_servico_otica_ReceitaValidaAte,\n" +
//"     tab_ordem_servico_otica.`Laboratorio` AS tab_ordem_servico_otica_Laboratorio,\n" +
//"     tab_ordem_servico_otica.`LocalDeMontagem` AS tab_ordem_servico_otica_LocalDeMontagem,\n" +
//"     tab_ordem_servico_otica.`ClientePossuiReceita` AS tab_ordem_servico_otica_ClientePossuiReceita,\n" +
//"     tab_ordem_servico_otica.`NomeProduto` AS tab_ordem_servico_otica_NomeProduto,\n" +
//"     tab_ordem_servico_otica.`QuantidadeProduto` AS tab_ordem_servico_otica_QuantidadeProduto,\n" +
//"     tab_ordem_servico_otica.`ReferenciaProduto` AS tab_ordem_servico_otica_ReferenciaProduto,\n" +
//"     tab_ordem_servico_otica.`ValorProduto` AS tab_ordem_servico_otica_ValorProduto,\n" +
//"     tab_ordem_servico_otica.`LenteTipo` AS tab_ordem_servico_otica_LenteTipo,\n" +
//"     tab_ordem_servico_otica.`LenteMaterial` AS tab_ordem_servico_otica_LenteMaterial,\n" +
//"     tab_ordem_servico_otica.`LenteColoracao` AS tab_ordem_servico_otica_LenteColoracao,\n" +
//"     tab_ordem_servico_otica.`LenteDescricao` AS tab_ordem_servico_otica_LenteDescricao,\n" +
//"     tab_ordem_servico_otica.`LenteTratamentoAplicado` AS tab_ordem_servico_otica_LenteTratamentoAplicado,\n" +
//"     tab_ordem_servico_otica.`ArmacaoPropria` AS tab_ordem_servico_otica_ArmacaoPropria,\n" +
//"     tab_ordem_servico_otica.`ArmacaoSegue` AS tab_ordem_servico_otica_ArmacaoSegue,\n" +
//"     tab_ordem_servico_otica.`ArmacaoTipo` AS tab_ordem_servico_otica_ArmacaoTipo,\n" +
//"     tab_ordem_servico_otica.`ArmacaoArmacaoAro` AS tab_ordem_servico_otica_ArmacaoArmacaoAro,\n" +
//"     tab_ordem_servico_otica.`ArmacaoPonte` AS tab_ordem_servico_otica_ArmacaoPonte,\n" +
//"     tab_ordem_servico_otica.`ArmacaoMaiorDiagonal` AS tab_ordem_servico_otica_ArmacaoMaiorDiagonal,\n" +
//"     tab_ordem_servico_otica.`ArmacaoAlturaVertical` AS tab_ordem_servico_otica_ArmacaoAlturaVertical,\n" +
//"     tab_ordem_servico_otica.`LongeOdEsf` AS tab_ordem_servico_otica_LongeOdEsf,\n" +
//"     tab_ordem_servico_otica.`LongeOeEsf` AS tab_ordem_servico_otica_LongeOeEsf,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoEsf` AS tab_ordem_servico_otica_LongeAdicaoEsf,\n" +
//"     tab_ordem_servico_otica.`LongeOdCil` AS tab_ordem_servico_otica_LongeOdCil,\n" +
//"     tab_ordem_servico_otica.`LongeOeCil` AS tab_ordem_servico_otica_LongeOeCil,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoCil` AS tab_ordem_servico_otica_LongeAdicaoCil,\n" +
//"     tab_ordem_servico_otica.`LongeOdEixo` AS tab_ordem_servico_otica_LongeOdEixo,\n" +
//"     tab_ordem_servico_otica.`LongeOeEixo` AS tab_ordem_servico_otica_LongeOeEixo,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoEixo` AS tab_ordem_servico_otica_LongeAdicaoEixo,\n" +
//"     tab_ordem_servico_otica.`LongeOdDP` AS tab_ordem_servico_otica_LongeOdDP,\n" +
//"     tab_ordem_servico_otica.`LongeOeDP` AS tab_ordem_servico_otica_LongeOeDP,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoDP` AS tab_ordem_servico_otica_LongeAdicaoDP,\n" +
//"     tab_ordem_servico_otica.`LongeOdAltura` AS tab_ordem_servico_otica_LongeOdAltura,\n" +
//"     tab_ordem_servico_otica.`LongeOeAltura` AS tab_ordem_servico_otica_LongeOeAltura,\n" +
//"     tab_ordem_servico_otica.`LongeAdicaoAltura` AS tab_ordem_servico_otica_LongeAdicaoAltura,\n" +
//"     tab_ordem_servico_otica.`PertoOdEsf` AS tab_ordem_servico_otica_PertoOdEsf,\n" +
//"     tab_ordem_servico_otica.`PertoOeEsf` AS tab_ordem_servico_otica_PertoOeEsf,\n" +
//"     tab_ordem_servico_otica.`PertoOdCil` AS tab_ordem_servico_otica_PertoOdCil,\n" +
//"     tab_ordem_servico_otica.`PertoOeCil` AS tab_ordem_servico_otica_PertoOeCil,\n" +
//"     tab_ordem_servico_otica.`PertoOdEixo` AS tab_ordem_servico_otica_PertoOdEixo,\n" +
//"     tab_ordem_servico_otica.`PertoOeEixo` AS tab_ordem_servico_otica_PertoOeEixo,\n" +
//"     tab_ordem_servico_otica.`PertoOdDP` AS tab_ordem_servico_otica_PertoOdDP,\n" +
//"     tab_ordem_servico_otica.`PertoOeDP` AS tab_ordem_servico_otica_PertoOeDP,\n" +
//"     tab_ordem_servico_otica.`PertoOdAltura` AS tab_ordem_servico_otica_PertoOdAltura,\n" +
//"     tab_ordem_servico_otica.`PertoOeAltura` AS tab_ordem_servico_otica_PertoOeAltura,\n" +
//"     tab_ordem_servico_otica.`RecebidoPor` AS tab_ordem_servico_otica_RecebidoPor,\n" +
//"     tab_ordem_servico_otica.`ValorTotalDaOrdemDeServico` AS tab_ordem_servico_otica_ValorTotalDaOrdemDeServico,\n" +
//"     tab_ordem_servico_otica.`ValorDoSinal` AS tab_ordem_servico_otica_ValorDoSinal,\n" +
//"     tab_ordem_servico_otica.`ValorRestante` AS tab_ordem_servico_otica_ValorRestante,\n" +
//"     tab_ordem_servico_otica.`FormaDePagamento` AS tab_ordem_servico_otica_FormaDePagamento,\n" +
//"     tab_ordem_servico_otica.`ValorTotalDosProdutos` AS tab_ordem_servico_otica_ValorTotalDosProdutos,\n" +
//"     tab_ordem_servico_otica.`ValorTotalDosServicos` AS tab_ordem_servico_otica_ValorTotalDosServicos,\n" +
//"     tab_ordem_servico_otica.`ServicoEfetuado` AS tab_ordem_servico_otica_ServicoEfetuado,\n" +
//"     tab_ordem_servico_otica.`ValorDinheiro` AS tab_ordem_servico_otica_ValorDinheiro,\n" +
//"     tab_ordem_servico_otica.`ValorCartao` AS tab_ordem_servico_otica_ValorCartao,\n" +
//"     tab_ordem_servico_otica.`TipoCartao` AS tab_ordem_servico_otica_TipoCartao,\n" +
//"     tab_ordem_servico_otica.`ValorCheque` AS tab_ordem_servico_otica_ValorCheque,\n" +
//"     tab_ordem_servico_otica.`ValorAReceber` AS tab_ordem_servico_otica_ValorAReceber,\n" +
//"     tab_ordem_servico_otica.`ValorTroco` AS tab_ordem_servico_otica_ValorTroco,\n" +
//"     tab_ordem_servico_otica.`Status` AS tab_ordem_servico_otica_Status,\n" +
//"     tab_ordem_servico_otica.`LenteMaterialTrivex` AS tab_ordem_servico_otica_LenteMaterialTrivex,\n" +
//"     tab_ordem_servico_otica.`LenteMaterialPolicarbonato` AS tab_ordem_servico_otica_LenteMaterialPolicarbonato,\n" +
//"     tab_ordem_servico_otica.`LenteMaterialResina` AS tab_ordem_servico_otica_LenteMaterialResina,\n" +
//"     tab_ordem_servico_otica.`LenteTipoPronta` AS tab_ordem_servico_otica_LenteTipoPronta,\n" +
//"     tab_ordem_servico_otica.`LenteTipoSurfacada` AS tab_ordem_servico_otica_LenteTipoSurfacada,\n" +
//"     tab_ordem_servico_otica.`LocalDeMontagemLoja` AS tab_ordem_servico_otica_LocalDeMontagemLoja,\n" +
//"     tab_ordem_servico_otica.`LocalDeMontagemLaboratorio` AS tab_ordem_servico_otica_LocalDeMontagemLaboratorio,\n" +
//"     tab_ordem_servico_otica.`PossuiReceitaSim` AS tab_ordem_servico_otica_PossuiReceitaSim,\n" +
//"     tab_ordem_servico_otica.`PossuiReceitaNao` AS tab_ordem_servico_otica_PossuiReceitaNao,\n" +
//"     tab_ordem_servico_otica.`PossuiArmacaoSim` AS tab_ordem_servico_otica_PossuiArmacaoSim,\n" +
//"     tab_ordem_servico_otica.`PossuiArmacaoNao` AS tab_ordem_servico_otica_PossuiArmacaoNao,\n" +
//"     tab_ordem_servico_otica.`DataEntradaSemBarras` AS tab_ordem_servico_otica_DataEntradaSemBarras,\n" +
//"     tab_ordem_servico_otica.`LenteMaterialCristal` AS tab_ordem_servico_otica_LenteMaterialCristal\n" +
//"FROM\n" +
//"     `tab_empresa` tab_empresa,\n" +
//"     `tab_ordem_servico_otica` tab_ordem_servico_otica\n" +
//"WHERE\n" +
//                            "      tab_ordem_servico_otica.id='"+id_OS+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir OS");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//        }
//        
//        public void geraReceita(String idreceita, String medico, boolean comControle, String perfil){
//            //para perfil de ticiano
//            if (perfil.equals("TICIANO")){
//                try {
//                
//                if (comControle == true){
//                        gerarReceitaMedicaComControle("C:\\DSistema\\receita_controle.jrxml",idreceita,"1",medico);
//                    }else{
//                        gerarReceitaMedica("C:\\DSistema\\receita.jrxml",idreceita,"1");
//                    }
//                    } catch (JRException ex) {
//                            //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (SQLException ex) {
//                            //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (ClassNotFoundException ex) {
//                            //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//            }
//            //para perfil de clinica
//            if (perfil.equals("consultorio")){
//                try {
//                
//                if (comControle == true){
//                        gerarReceitaMedicaComControle("C:\\DSistema\\receita_controle_clinica.jrxml",idreceita,"1",medico);
//                    }else{
//                        gerarReceitaMedica("C:\\DSistema\\receita_clinica.jrxml",idreceita,"1");
//                    }
//                    } catch (JRException ex) {
//                            //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (SQLException ex) {
//                            //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (ClassNotFoundException ex) {
//                            //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//            }
//            
//            
//        }
//        
//        public void geraAtestado(String tipo, String idUltimoAtestado, String perfil){
//            //verifica perfil para imprimir personalizado    
//            if (perfil.equals("TICIANO")){
//                    if (tipo.equals("presenca")){                        
//                        try{
//                                gerarAtestado("C:\\DSistema\\AtestadoComparecimento.jrxml",idUltimoAtestado,"1");
//                            } catch (JRException ex) {
//                                    //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                            } catch (SQLException ex) {
//                                    //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                            } catch (ClassNotFoundException ex) {
//                                    //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                            }                        
//                    }else{
//                        try{
//                           gerarAtestado("C:\\DSistema\\Atestado.jrxml",idUltimoAtestado,"1");
//                        } catch (JRException ex) {
//                                //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (SQLException ex) {
//                                //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (ClassNotFoundException ex) {
//                                //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
//                //entra no perfil de consultorio
//                if (perfil.equals("consultorio")){
//                    if (tipo.equals("presenca")){                        
//                        try{
//                                gerarAtestado("C:\\DSistema\\AtestadoComparecimento_clinica.jrxml",idUltimoAtestado,"1");
//                            } catch (JRException ex) {
//                                    //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                            } catch (SQLException ex) {
//                                    //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                            } catch (ClassNotFoundException ex) {
//                                    //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                            }                        
//                    }else{
//                        try{
//                           gerarAtestado("C:\\DSistema\\Atestado_clinica.jrxml",idUltimoAtestado,"1");
//                        } catch (JRException ex) {
//                                //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (SQLException ex) {
//                                //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                        } catch (ClassNotFoundException ex) {
//                                //Logger.getLogger(JanelaConsultaMedica.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
//        }
//        
//        public void gerarImpresaoNFE(String caminhoIreport,String IdLancamento, String IdVersao) throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load(caminhoIreport);
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//"     tab_empresa.`id` AS tab_empresa_id,\n" +
//"     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//"     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//"     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//"     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//"     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//"     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//"     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//"     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//"     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//"     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//"     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//"     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//"     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//"     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//"     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//"     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//"     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//"     tab_empresa.`email` AS tab_empresa_email,\n" +
//"     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//"     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//"     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//"     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//"     tab_versao.`id` AS tab_versao_id,\n" +
//"     tab_versao.`versao` AS tab_versao_versao,\n" +
//"     tab_nota_fiscal_lancamento.`id` AS tab_nota_fiscal_lancamento_id,\n" +
//"     tab_nota_fiscal_lancamento.`NumeroNF` AS tab_nota_fiscal_lancamento_NumeroNF,\n" +
//"     tab_nota_fiscal_lancamento.`TipoLancamento` AS tab_nota_fiscal_lancamento_TipoLancamento,\n" +
//"     tab_nota_fiscal_lancamento.`Status` AS tab_nota_fiscal_lancamento_Status,\n" +
//"     tab_nota_fiscal_lancamento.`CFOP` AS tab_nota_fiscal_lancamento_CFOP,\n" +
//"     tab_nota_fiscal_lancamento.`Serie` AS tab_nota_fiscal_lancamento_Serie,\n" +
//"     tab_nota_fiscal_lancamento.`Modelo` AS tab_nota_fiscal_lancamento_Modelo,\n" +
//"     tab_nota_fiscal_lancamento.`idFornecedor` AS tab_nota_fiscal_lancamento_idFornecedor,\n" +
//"     tab_nota_fiscal_lancamento.`NomeFornecedor` AS tab_nota_fiscal_lancamento_NomeFornecedor,\n" +
//"     tab_nota_fiscal_lancamento.`razao` AS tab_nota_fiscal_lancamento_razao,\n" +
//"     tab_nota_fiscal_lancamento.`endereco` AS tab_nota_fiscal_lancamento_endereco,\n" +
//"     tab_nota_fiscal_lancamento.`bairro` AS tab_nota_fiscal_lancamento_bairro,\n" +
//"     tab_nota_fiscal_lancamento.`cidade` AS tab_nota_fiscal_lancamento_cidade,\n" +
//"     tab_nota_fiscal_lancamento.`estado` AS tab_nota_fiscal_lancamento_estado,\n" +
//"     tab_nota_fiscal_lancamento.`cep` AS tab_nota_fiscal_lancamento_cep,\n" +
//"     tab_nota_fiscal_lancamento.`cnpj` AS tab_nota_fiscal_lancamento_cnpj,\n" +
//"     tab_nota_fiscal_lancamento.`telefone` AS tab_nota_fiscal_lancamento_telefone,\n" +
//"     tab_nota_fiscal_lancamento.`numero` AS tab_nota_fiscal_lancamento_numero,\n" +
//"     tab_nota_fiscal_lancamento.`email` AS tab_nota_fiscal_lancamento_email,\n" +
//"     tab_nota_fiscal_lancamento.`complemento` AS tab_nota_fiscal_lancamento_complemento,\n" +
//"     tab_nota_fiscal_lancamento.`TotalProdutos` AS tab_nota_fiscal_lancamento_TotalProdutos,\n" +
//"     tab_nota_fiscal_lancamento.`TotalImpostos` AS tab_nota_fiscal_lancamento_TotalImpostos,\n" +
//"     tab_nota_fiscal_lancamento.`TotalAdicionais` AS tab_nota_fiscal_lancamento_TotalAdicionais,\n" +
//"     tab_nota_fiscal_lancamento.`TotalNF` AS tab_nota_fiscal_lancamento_TotalNF,\n" +
//"     tab_nota_fiscal_lancamento.`PlacaCarro` AS tab_nota_fiscal_lancamento_PlacaCarro,\n" +
//"     tab_nota_fiscal_lancamento.`Motorista` AS tab_nota_fiscal_lancamento_Motorista,\n" +
//"     tab_nota_fiscal_lancamento.`idTransportadora` AS tab_nota_fiscal_lancamento_idTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`NomeTransportadora` AS tab_nota_fiscal_lancamento_NomeTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`razaoTransportadora` AS tab_nota_fiscal_lancamento_razaoTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`enderecoTransportadora` AS tab_nota_fiscal_lancamento_enderecoTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`bairroTransportadora` AS tab_nota_fiscal_lancamento_bairroTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`cidadeTransportadora` AS tab_nota_fiscal_lancamento_cidadeTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`estadoTransportadora` AS tab_nota_fiscal_lancamento_estadoTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`cepTransportadora` AS tab_nota_fiscal_lancamento_cepTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`cnpjTransportadora` AS tab_nota_fiscal_lancamento_cnpjTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`telefoneTransportadora` AS tab_nota_fiscal_lancamento_telefoneTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`numeroTransportadora` AS tab_nota_fiscal_lancamento_numeroTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`emailTransportadora` AS tab_nota_fiscal_lancamento_emailTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`complementoTransportadora` AS tab_nota_fiscal_lancamento_complementoTransportadora,\n" +
//"     tab_nota_fiscal_lancamento.`dataInclusao` AS tab_nota_fiscal_lancamento_dataInclusao,\n" +
//"     tab_nota_fiscal_lancamento.`horaInclusao` AS tab_nota_fiscal_lancamento_horaInclusao,\n" +
//"     tab_nota_fiscal_lancamento.`chaveAcesso` AS tab_nota_fiscal_lancamento_chaveAcesso,\n" +
//"     tab_nota_fiscal_lancamento.`Integrado` AS tab_nota_fiscal_lancamento_Integrado,\n" +
//"     tab_nota_fiscal_lancamento.`DataIntegracao` AS tab_nota_fiscal_lancamento_DataIntegracao,\n" +
//"     tab_nota_fiscal_lancamento.`NfeDeEntrada` AS tab_nota_fiscal_lancamento_NfeDeEntrada,\n" +
//"     tab_nota_fiscal_lancamento.`NfeDeSaida` AS tab_nota_fiscal_lancamento_NfeDeSaida,\n" +
//"     tab_nota_fiscal_lancamento.`NaturezaDaOperacao` AS tab_nota_fiscal_lancamento_NaturezaDaOperacao,\n" +
//"     tab_nota_fiscal_lancamento.`ProtocoloDeAutorizacaoDeUso` AS tab_nota_fiscal_lancamento_ProtocoloDeAutorizacaoDeUso,\n" +
//"     tab_nota_fiscal_lancamento.`InscricaoEstadualOrigem` AS tab_nota_fiscal_lancamento_InscricaoEstadualOrigem,\n" +
//"     tab_nota_fiscal_lancamento.`InscricaoEstadualSubstOrigem` AS tab_nota_fiscal_lancamento_InscricaoEstadualSubstOrigem,\n" +
//"     tab_nota_fiscal_lancamento.`CNPJOrigem` AS tab_nota_fiscal_lancamento_CNPJOrigem,\n" +
//"     tab_nota_fiscal_lancamento.`NomeDestinatario` AS tab_nota_fiscal_lancamento_NomeDestinatario,\n" +
//"     tab_nota_fiscal_lancamento.`CNPJDestinatario` AS tab_nota_fiscal_lancamento_CNPJDestinatario,\n" +
//"     tab_nota_fiscal_lancamento.`EnderecoDestinatario` AS tab_nota_fiscal_lancamento_EnderecoDestinatario,\n" +
//"     tab_nota_fiscal_lancamento.`NumeroDestinatario` AS tab_nota_fiscal_lancamento_NumeroDestinatario,\n" +
//"     tab_nota_fiscal_lancamento.`BairroDestinatario` AS tab_nota_fiscal_lancamento_BairroDestinatario,\n" +
//"     tab_nota_fiscal_lancamento.`CEPDestinatario` AS tab_nota_fiscal_lancamento_CEPDestinatario,\n" +
//"     tab_nota_fiscal_lancamento.`CidadeDestinatario` AS tab_nota_fiscal_lancamento_CidadeDestinatario,\n" +
//"     tab_nota_fiscal_lancamento.`TelefoneDestinatario` AS tab_nota_fiscal_lancamento_TelefoneDestinatario,\n" +
//"     tab_nota_fiscal_lancamento.`EstadoDestinatario` AS tab_nota_fiscal_lancamento_EstadoDestinatario,\n" +
//"     tab_nota_fiscal_lancamento.`InscricaoEstadualDestinatario` AS tab_nota_fiscal_lancamento_InscricaoEstadualDestinatario,\n" +
//"     tab_nota_fiscal_lancamento.`DataDaNota` AS tab_nota_fiscal_lancamento_DataDaNota,\n" +
//"     tab_nota_fiscal_lancamento.`DataSaidaDaNota` AS tab_nota_fiscal_lancamento_DataSaidaDaNota,\n" +
//"     tab_nota_fiscal_lancamento.`HoraDaNota` AS tab_nota_fiscal_lancamento_HoraDaNota,\n" +
//"     tab_nota_fiscal_lancamento.`FormaDePagamentoFaturaDuplicata` AS tab_nota_fiscal_lancamento_FormaDePagamentoFaturaDuplicata,\n" +
//"     tab_nota_fiscal_lancamento.`BaseDeCalculoICMS` AS tab_nota_fiscal_lancamento_BaseDeCalculoICMS,\n" +
//"     tab_nota_fiscal_lancamento.`ValorDoICMS` AS tab_nota_fiscal_lancamento_ValorDoICMS,\n" +
//"     tab_nota_fiscal_lancamento.`BaseDeCalculoDeSubstituicao` AS tab_nota_fiscal_lancamento_BaseDeCalculoDeSubstituicao,\n" +
//"     tab_nota_fiscal_lancamento.`ValorDaSubstituicao` AS tab_nota_fiscal_lancamento_ValorDaSubstituicao,\n" +
//"     tab_nota_fiscal_lancamento.`ValorFrete` AS tab_nota_fiscal_lancamento_ValorFrete,\n" +
//"     tab_nota_fiscal_lancamento.`ValorDoSeguro` AS tab_nota_fiscal_lancamento_ValorDoSeguro,\n" +
//"     tab_nota_fiscal_lancamento.`ValorDesconto` AS tab_nota_fiscal_lancamento_ValorDesconto,\n" +
//"     tab_nota_fiscal_lancamento.`ValorOutrasDespesas` AS tab_nota_fiscal_lancamento_ValorOutrasDespesas,\n" +
//"     tab_nota_fiscal_lancamento.`ValorIPI` AS tab_nota_fiscal_lancamento_ValorIPI,\n" +
//"     tab_nota_fiscal_lancamento.`ValorTotalDosProduto` AS tab_nota_fiscal_lancamento_ValorTotalDosProduto,\n" +
//"     tab_nota_fiscal_lancamento.`ValorTotalDaNota` AS tab_nota_fiscal_lancamento_ValorTotalDaNota,\n" +
//"     tab_nota_fiscal_lancamento.`QuantidadeVolume` AS tab_nota_fiscal_lancamento_QuantidadeVolume,\n" +
//"     tab_nota_fiscal_lancamento.`EspecieVolume` AS tab_nota_fiscal_lancamento_EspecieVolume,\n" +
//"     tab_nota_fiscal_lancamento.`MarcaVolume` AS tab_nota_fiscal_lancamento_MarcaVolume,\n" +
//"     tab_nota_fiscal_lancamento.`Numeracao` AS tab_nota_fiscal_lancamento_Numeracao,\n" +
//"     tab_nota_fiscal_lancamento.`ValorTotalDosServicos` AS tab_nota_fiscal_lancamento_ValorTotalDosServicos,\n" +
//"     tab_nota_fiscal_lancamento.`BaseCalculoISSQN` AS tab_nota_fiscal_lancamento_BaseCalculoISSQN,\n" +
//"     tab_nota_fiscal_lancamento.`ValorISSQN` AS tab_nota_fiscal_lancamento_ValorISSQN,\n" +
//"     tab_nota_fiscal_lancamento.`PesoBruto` AS tab_nota_fiscal_lancamento_PesoBruto,\n" +
//"     tab_nota_fiscal_lancamento.`PesoLiquido` AS tab_nota_fiscal_lancamento_PesoLiquido,\n" +
//"     tab_nota_fiscal_lancamento.`InscicaoMunicipalISSQN` AS tab_nota_fiscal_lancamento_InscicaoMunicipalISSQN,\n" +
//"     tab_nota_fiscal_lancamento.`MotivoRejeicao` AS tab_nota_fiscal_lancamento_MotivoRejeicao,\n" +
//"     tab_nota_fiscal_lancamento.`DadosAdicionais` AS tab_nota_fiscal_lancamento_DadosAdicionais,\n" +
//"     tab_nota_fiscal_lancamento.`BCipi` AS tab_nota_fiscal_lancamento_BCipi,\n" +
//"     tab_nota_fiscal_lancamento.`BCpis` AS tab_nota_fiscal_lancamento_BCpis,\n" +
//"     tab_nota_fiscal_lancamento.`ValorPIS` AS tab_nota_fiscal_lancamento_ValorPIS,\n" +
//"     tab_nota_fiscal_lancamento.`BCcofins` AS tab_nota_fiscal_lancamento_BCcofins,\n" +
//"     tab_nota_fiscal_lancamento.`ValorCofins` AS tab_nota_fiscal_lancamento_ValorCofins,\n" +
//"     tab_nota_fiscal_lancamento.`IdLoteEnvioNFE` AS tab_nota_fiscal_lancamento_IdLoteEnvioNFE,\n" +
//"     tab_produtonfesaida.`ID` AS tab_produtonfesaida_ID,\n" +
//"     tab_produtonfesaida.`IdLancamento` AS tab_produtonfesaida_IdLancamento,\n" +
//"     tab_produtonfesaida.`DataLancamento` AS tab_produtonfesaida_DataLancamento,\n" +
//"     tab_produtonfesaida.`NumeroNF` AS tab_produtonfesaida_NumeroNF,\n" +
//"     tab_produtonfesaida.`ChaveAcessoNFE` AS tab_produtonfesaida_ChaveAcessoNFE,\n" +
//"     tab_produtonfesaida.`Det` AS tab_produtonfesaida_Det,\n" +
//"     tab_produtonfesaida.`cProd` AS tab_produtonfesaida_cProd,\n" +
//"     tab_produtonfesaida.`cean` AS tab_produtonfesaida_cean,\n" +
//"     tab_produtonfesaida.`xProd` AS tab_produtonfesaida_xProd,\n" +
//"     tab_produtonfesaida.`ncm` AS tab_produtonfesaida_ncm,\n" +
//"     tab_produtonfesaida.`nve` AS tab_produtonfesaida_nve,\n" +
//"     tab_produtonfesaida.`cest` AS tab_produtonfesaida_cest,\n" +
//"     tab_produtonfesaida.`extipi` AS tab_produtonfesaida_extipi,\n" +
//"     tab_produtonfesaida.`cfop` AS tab_produtonfesaida_cfop,\n" +
//"     tab_produtonfesaida.`uCom` AS tab_produtonfesaida_uCom,\n" +
//"     tab_produtonfesaida.`qCom` AS tab_produtonfesaida_qCom,\n" +
//"     tab_produtonfesaida.`vUnCom` AS tab_produtonfesaida_vUnCom,\n" +
//"     tab_produtonfesaida.`vProd` AS tab_produtonfesaida_vProd,\n" +
//"     tab_produtonfesaida.`ceanTrib` AS tab_produtonfesaida_ceanTrib,\n" +
//"     tab_produtonfesaida.`uTrib` AS tab_produtonfesaida_uTrib,\n" +
//"     tab_produtonfesaida.`qTrib` AS tab_produtonfesaida_qTrib,\n" +
//"     tab_produtonfesaida.`vUnTrib` AS tab_produtonfesaida_vUnTrib,\n" +
//"     tab_produtonfesaida.`vFrete` AS tab_produtonfesaida_vFrete,\n" +
//"     tab_produtonfesaida.`vSeg` AS tab_produtonfesaida_vSeg,\n" +
//"     tab_produtonfesaida.`vDesc` AS tab_produtonfesaida_vDesc,\n" +
//"     tab_produtonfesaida.`vOutro` AS tab_produtonfesaida_vOutro,\n" +
//"     tab_produtonfesaida.`indTot` AS tab_produtonfesaida_indTot,\n" +
//"     tab_produtonfesaida.`di` AS tab_produtonfesaida_di,\n" +
//"     tab_produtonfesaida.`detExport` AS tab_produtonfesaida_detExport,\n" +
//"     tab_produtonfesaida.`xPed` AS tab_produtonfesaida_xPed,\n" +
//"     tab_produtonfesaida.`nItemPed` AS tab_produtonfesaida_nItemPed,\n" +
//"     tab_produtonfesaida.`nfci` AS tab_produtonfesaida_nfci,\n" +
//"     tab_produtonfesaida.`veicProd` AS tab_produtonfesaida_veicProd,\n" +
//"     tab_produtonfesaida.`med` AS tab_produtonfesaida_med,\n" +
//"     tab_produtonfesaida.`arma` AS tab_produtonfesaida_arma,\n" +
//"     tab_produtonfesaida.`comb` AS tab_produtonfesaida_comb,\n" +
//"     tab_produtonfesaida.`nrecopi` AS tab_produtonfesaida_nrecopi,\n" +
//"     tab_produtonfesaida.`CSOSN` AS tab_produtonfesaida_CSOSN,\n" +
//"     tab_produtonfesaida.`Origem` AS tab_produtonfesaida_Origem,\n" +
//"     tab_nota_fiscal_lancamento.`dataEnvioParaSefaz` AS tab_nota_fiscal_lancamento_dataEnvioParaSefaz,\n" +
//"     tab_nota_fiscal_lancamento.`NumeroPedido` AS tab_nota_fiscal_lancamento_NumeroPedido,\n" +
//"     tab_nota_fiscal_lancamento.`DataDaNotaSemBarras` AS tab_nota_fiscal_lancamento_DataDaNotaSemBarras,\n" +
//"     tab_nota_fiscal_lancamento.`ChaveAcessoSemNFe` AS tab_nota_fiscal_lancamento_ChaveAcessoSemNFe,\n" +
//"     tab_produtonfesaida.`ValorDescontoUnitario` AS tab_produtonfesaida_ValorDescontoUnitario,\n" +
//"     tab_produtonfesaida.`CSTUnitario` AS tab_produtonfesaida_CSTUnitario,\n" +
//"     tab_produtonfesaida.`BCicmsUnitario` AS tab_produtonfesaida_BCicmsUnitario,\n" +
//"     tab_produtonfesaida.`ValorICMSUnitario` AS tab_produtonfesaida_ValorICMSUnitario,\n" +
//"     tab_produtonfesaida.`ValorAliquotaICMSUnitario` AS tab_produtonfesaida_ValorAliquotaICMSUnitario,\n" +
//"     tab_produtonfesaida.`ValorIPIUnitario` AS tab_produtonfesaida_ValorIPIUnitario,\n" +
//"     tab_produtonfesaida.`ValorAliquotaIPIUnitario` AS tab_produtonfesaida_ValorAliquotaIPIUnitario\n" +
//"FROM\n" +
//"     `tab_empresa` tab_empresa,\n" +
//"     `tab_versao` tab_versao,\n" +
//"     `tab_nota_fiscal_lancamento` tab_nota_fiscal_lancamento,\n" +
//"     `tab_produtonfesaida` tab_produtonfesaida\n" +
//"WHERE\n" +
//                            "      tab_versao.id='"+IdVersao+"'\n" +
//                            "and   tab_nota_fiscal_lancamento.id='"+IdLancamento+"'\n" +
//                            "and   tab_produtonfesaida.IdLancamento='"+IdLancamento+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir NF-e");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//        }
//        
//        public void imprimirNFCE(String idLancamento, String numeroPedido) throws JRException , SQLException, ClassNotFoundException {
//                
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                
//                String query = "SELECT\n" +
//                            "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                            "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                            "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                            "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                            "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                            "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                            "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                            "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                            "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                            "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                            "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                            "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                            "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                            "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                            "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                            "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                            "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                            "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                            "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                            "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                            "     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//                            "     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//                            "     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//                            "     tab_nota_fiscal_lancamento.`id` AS tab_nota_fiscal_lancamento_id,\n" +
//                            "     tab_nota_fiscal_lancamento.`NumeroNF` AS tab_nota_fiscal_lancamento_NumeroNF,\n" +
//                            "     tab_nota_fiscal_lancamento.`TipoLancamento` AS tab_nota_fiscal_lancamento_TipoLancamento,\n" +
//                            "     tab_nota_fiscal_lancamento.`Status` AS tab_nota_fiscal_lancamento_Status,\n" +
//                            "     tab_nota_fiscal_lancamento.`CFOP` AS tab_nota_fiscal_lancamento_CFOP,\n" +
//                            "     tab_nota_fiscal_lancamento.`Serie` AS tab_nota_fiscal_lancamento_Serie,\n" +
//                            "     tab_nota_fiscal_lancamento.`Modelo` AS tab_nota_fiscal_lancamento_Modelo,\n" +
//                            "     tab_nota_fiscal_lancamento.`idFornecedor` AS tab_nota_fiscal_lancamento_idFornecedor,\n" +
//                            "     tab_nota_fiscal_lancamento.`NomeFornecedor` AS tab_nota_fiscal_lancamento_NomeFornecedor,\n" +
//                            "     tab_nota_fiscal_lancamento.`razao` AS tab_nota_fiscal_lancamento_razao,\n" +
//                            "     tab_nota_fiscal_lancamento.`endereco` AS tab_nota_fiscal_lancamento_endereco,\n" +
//                            "     tab_nota_fiscal_lancamento.`bairro` AS tab_nota_fiscal_lancamento_bairro,\n" +
//                            "     tab_nota_fiscal_lancamento.`cidade` AS tab_nota_fiscal_lancamento_cidade,\n" +
//                            "     tab_nota_fiscal_lancamento.`estado` AS tab_nota_fiscal_lancamento_estado,\n" +
//                            "     tab_nota_fiscal_lancamento.`cep` AS tab_nota_fiscal_lancamento_cep,\n" +
//                            "     tab_nota_fiscal_lancamento.`cnpj` AS tab_nota_fiscal_lancamento_cnpj,\n" +
//                            "     tab_nota_fiscal_lancamento.`telefone` AS tab_nota_fiscal_lancamento_telefone,\n" +
//                            "     tab_nota_fiscal_lancamento.`numero` AS tab_nota_fiscal_lancamento_numero,\n" +
//                            "     tab_nota_fiscal_lancamento.`email` AS tab_nota_fiscal_lancamento_email,\n" +
//                            "     tab_nota_fiscal_lancamento.`complemento` AS tab_nota_fiscal_lancamento_complemento,\n" +
//                            "     tab_nota_fiscal_lancamento.`TotalProdutos` AS tab_nota_fiscal_lancamento_TotalProdutos,\n" +
//                            "     tab_nota_fiscal_lancamento.`TotalImpostos` AS tab_nota_fiscal_lancamento_TotalImpostos,\n" +
//                            "     tab_nota_fiscal_lancamento.`TotalAdicionais` AS tab_nota_fiscal_lancamento_TotalAdicionais,\n" +
//                            "     tab_nota_fiscal_lancamento.`TotalNF` AS tab_nota_fiscal_lancamento_TotalNF,\n" +
//                            "     tab_nota_fiscal_lancamento.`PlacaCarro` AS tab_nota_fiscal_lancamento_PlacaCarro,\n" +
//                            "     tab_nota_fiscal_lancamento.`Motorista` AS tab_nota_fiscal_lancamento_Motorista,\n" +
//                            "     tab_nota_fiscal_lancamento.`idTransportadora` AS tab_nota_fiscal_lancamento_idTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`NomeTransportadora` AS tab_nota_fiscal_lancamento_NomeTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`razaoTransportadora` AS tab_nota_fiscal_lancamento_razaoTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`enderecoTransportadora` AS tab_nota_fiscal_lancamento_enderecoTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`bairroTransportadora` AS tab_nota_fiscal_lancamento_bairroTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`cidadeTransportadora` AS tab_nota_fiscal_lancamento_cidadeTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`estadoTransportadora` AS tab_nota_fiscal_lancamento_estadoTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`cepTransportadora` AS tab_nota_fiscal_lancamento_cepTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`cnpjTransportadora` AS tab_nota_fiscal_lancamento_cnpjTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`telefoneTransportadora` AS tab_nota_fiscal_lancamento_telefoneTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`numeroTransportadora` AS tab_nota_fiscal_lancamento_numeroTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`emailTransportadora` AS tab_nota_fiscal_lancamento_emailTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`complementoTransportadora` AS tab_nota_fiscal_lancamento_complementoTransportadora,\n" +
//                            "     tab_nota_fiscal_lancamento.`dataInclusao` AS tab_nota_fiscal_lancamento_dataInclusao,\n" +
//                            "     tab_nota_fiscal_lancamento.`horaInclusao` AS tab_nota_fiscal_lancamento_horaInclusao,\n" +
//                            "     tab_nota_fiscal_lancamento.`chaveAcesso` AS tab_nota_fiscal_lancamento_chaveAcesso,\n" +
//                            "     tab_nota_fiscal_lancamento.`Integrado` AS tab_nota_fiscal_lancamento_Integrado,\n" +
//                            "     tab_nota_fiscal_lancamento.`DataIntegracao` AS tab_nota_fiscal_lancamento_DataIntegracao,\n" +
//                            "     tab_nota_fiscal_lancamento.`NfeDeEntrada` AS tab_nota_fiscal_lancamento_NfeDeEntrada,\n" +
//                            "     tab_nota_fiscal_lancamento.`NfeDeSaida` AS tab_nota_fiscal_lancamento_NfeDeSaida,\n" +
//                            "     tab_nota_fiscal_lancamento.`NaturezaDaOperacao` AS tab_nota_fiscal_lancamento_NaturezaDaOperacao,\n" +
//                            "     tab_nota_fiscal_lancamento.`ProtocoloDeAutorizacaoDeUso` AS tab_nota_fiscal_lancamento_ProtocoloDeAutorizacaoDeUso,\n" +
//                            "     tab_nota_fiscal_lancamento.`InscricaoEstadualOrigem` AS tab_nota_fiscal_lancamento_InscricaoEstadualOrigem,\n" +
//                            "     tab_nota_fiscal_lancamento.`InscricaoEstadualSubstOrigem` AS tab_nota_fiscal_lancamento_InscricaoEstadualSubstOrigem,\n" +
//                            "     tab_nota_fiscal_lancamento.`CNPJOrigem` AS tab_nota_fiscal_lancamento_CNPJOrigem,\n" +
//                            "     tab_nota_fiscal_lancamento.`NomeDestinatario` AS tab_nota_fiscal_lancamento_NomeDestinatario,\n" +
//                            "     tab_nota_fiscal_lancamento.`CNPJDestinatario` AS tab_nota_fiscal_lancamento_CNPJDestinatario,\n" +
//                            "     tab_nota_fiscal_lancamento.`EnderecoDestinatario` AS tab_nota_fiscal_lancamento_EnderecoDestinatario,\n" +
//                            "     tab_nota_fiscal_lancamento.`NumeroDestinatario` AS tab_nota_fiscal_lancamento_NumeroDestinatario,\n" +
//                            "     tab_nota_fiscal_lancamento.`BairroDestinatario` AS tab_nota_fiscal_lancamento_BairroDestinatario,\n" +
//                            "     tab_nota_fiscal_lancamento.`CEPDestinatario` AS tab_nota_fiscal_lancamento_CEPDestinatario,\n" +
//                            "     tab_nota_fiscal_lancamento.`CidadeDestinatario` AS tab_nota_fiscal_lancamento_CidadeDestinatario,\n" +
//                            "     tab_nota_fiscal_lancamento.`TelefoneDestinatario` AS tab_nota_fiscal_lancamento_TelefoneDestinatario,\n" +
//                            "     tab_nota_fiscal_lancamento.`EstadoDestinatario` AS tab_nota_fiscal_lancamento_EstadoDestinatario,\n" +
//                            "     tab_nota_fiscal_lancamento.`InscricaoEstadualDestinatario` AS tab_nota_fiscal_lancamento_InscricaoEstadualDestinatario,\n" +
//                            "     tab_nota_fiscal_lancamento.`DataDaNota` AS tab_nota_fiscal_lancamento_DataDaNota,\n" +
//                            "     tab_nota_fiscal_lancamento.`DataSaidaDaNota` AS tab_nota_fiscal_lancamento_DataSaidaDaNota,\n" +
//                            "     tab_nota_fiscal_lancamento.`HoraDaNota` AS tab_nota_fiscal_lancamento_HoraDaNota,\n" +
//                            "     tab_nota_fiscal_lancamento.`FormaDePagamentoFaturaDuplicata` AS tab_nota_fiscal_lancamento_FormaDePagamentoFaturaDuplicata,\n" +
//                            "     tab_nota_fiscal_lancamento.`BaseDeCalculoICMS` AS tab_nota_fiscal_lancamento_BaseDeCalculoICMS,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorDoICMS` AS tab_nota_fiscal_lancamento_ValorDoICMS,\n" +
//                            "     tab_nota_fiscal_lancamento.`BaseDeCalculoDeSubstituicao` AS tab_nota_fiscal_lancamento_BaseDeCalculoDeSubstituicao,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorDaSubstituicao` AS tab_nota_fiscal_lancamento_ValorDaSubstituicao,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorFrete` AS tab_nota_fiscal_lancamento_ValorFrete,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorDoSeguro` AS tab_nota_fiscal_lancamento_ValorDoSeguro,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorDesconto` AS tab_nota_fiscal_lancamento_ValorDesconto,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorOutrasDespesas` AS tab_nota_fiscal_lancamento_ValorOutrasDespesas,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorIPI` AS tab_nota_fiscal_lancamento_ValorIPI,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorTotalDosProduto` AS tab_nota_fiscal_lancamento_ValorTotalDosProduto,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorTotalDaNota` AS tab_nota_fiscal_lancamento_ValorTotalDaNota,\n" +
//                            "     tab_nota_fiscal_lancamento.`QuantidadeVolume` AS tab_nota_fiscal_lancamento_QuantidadeVolume,\n" +
//                            "     tab_nota_fiscal_lancamento.`EspecieVolume` AS tab_nota_fiscal_lancamento_EspecieVolume,\n" +
//                            "     tab_nota_fiscal_lancamento.`MarcaVolume` AS tab_nota_fiscal_lancamento_MarcaVolume,\n" +
//                            "     tab_nota_fiscal_lancamento.`Numeracao` AS tab_nota_fiscal_lancamento_Numeracao,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorTotalDosServicos` AS tab_nota_fiscal_lancamento_ValorTotalDosServicos,\n" +
//                            "     tab_nota_fiscal_lancamento.`BaseCalculoISSQN` AS tab_nota_fiscal_lancamento_BaseCalculoISSQN,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorISSQN` AS tab_nota_fiscal_lancamento_ValorISSQN,\n" +
//                            "     tab_nota_fiscal_lancamento.`PesoBruto` AS tab_nota_fiscal_lancamento_PesoBruto,\n" +
//                            "     tab_nota_fiscal_lancamento.`PesoLiquido` AS tab_nota_fiscal_lancamento_PesoLiquido,\n" +
//                            "     tab_nota_fiscal_lancamento.`InscicaoMunicipalISSQN` AS tab_nota_fiscal_lancamento_InscicaoMunicipalISSQN,\n" +
//                            "     tab_nota_fiscal_lancamento.`MotivoRejeicao` AS tab_nota_fiscal_lancamento_MotivoRejeicao,\n" +
//                            "     tab_nota_fiscal_lancamento.`DadosAdicionais` AS tab_nota_fiscal_lancamento_DadosAdicionais,\n" +
//                            "     tab_nota_fiscal_lancamento.`BCipi` AS tab_nota_fiscal_lancamento_BCipi,\n" +
//                            "     tab_nota_fiscal_lancamento.`BCpis` AS tab_nota_fiscal_lancamento_BCpis,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorPIS` AS tab_nota_fiscal_lancamento_ValorPIS,\n" +
//                            "     tab_nota_fiscal_lancamento.`BCcofins` AS tab_nota_fiscal_lancamento_BCcofins,\n" +
//                            "     tab_nota_fiscal_lancamento.`ValorCofins` AS tab_nota_fiscal_lancamento_ValorCofins,\n" +
//                            "     tab_nota_fiscal_lancamento.`IdLoteEnvioNFE` AS tab_nota_fiscal_lancamento_IdLoteEnvioNFE,\n" +
//                            "     tab_nota_fiscal_lancamento.`dataEnvioParaSefaz` AS tab_nota_fiscal_lancamento_dataEnvioParaSefaz,\n" +
//                            "     tab_nota_fiscal_lancamento.`NumeroPedido` AS tab_nota_fiscal_lancamento_NumeroPedido,\n" +
//                            "     tab_nota_fiscal_lancamento.`DataDaNotaSemBarras` AS tab_nota_fiscal_lancamento_DataDaNotaSemBarras,\n" +
//                            "     tab_nota_fiscal_lancamento.`ChaveAcessoSemNFe` AS tab_nota_fiscal_lancamento_ChaveAcessoSemNFe,\n" +
//                            "     tab_nota_fiscal_lancamento.`conteudoXML` AS tab_nota_fiscal_lancamento_conteudoXML,\n" +
//                            "     tab_produtonfesaida.`ID` AS tab_produtonfesaida_ID,\n" +
//                            "     tab_produtonfesaida.`IdLancamento` AS tab_produtonfesaida_IdLancamento,\n" +
//                            "     tab_produtonfesaida.`DataLancamento` AS tab_produtonfesaida_DataLancamento,\n" +
//                            "     tab_produtonfesaida.`NumeroNF` AS tab_produtonfesaida_NumeroNF,\n" +
//                            "     tab_produtonfesaida.`ChaveAcessoNFE` AS tab_produtonfesaida_ChaveAcessoNFE,\n" +
//                            "     tab_produtonfesaida.`Det` AS tab_produtonfesaida_Det,\n" +
//                            "     tab_produtonfesaida.`cProd` AS tab_produtonfesaida_cProd,\n" +
//                            "     tab_produtonfesaida.`cean` AS tab_produtonfesaida_cean,\n" +
//                            "     tab_produtonfesaida.`xProd` AS tab_produtonfesaida_xProd,\n" +
//                            "     tab_produtonfesaida.`ncm` AS tab_produtonfesaida_ncm,\n" +
//                            "     tab_produtonfesaida.`nve` AS tab_produtonfesaida_nve,\n" +
//                            "     tab_produtonfesaida.`cest` AS tab_produtonfesaida_cest,\n" +
//                            "     tab_produtonfesaida.`extipi` AS tab_produtonfesaida_extipi,\n" +
//                            "     tab_produtonfesaida.`cfop` AS tab_produtonfesaida_cfop,\n" +
//                            "     tab_produtonfesaida.`uCom` AS tab_produtonfesaida_uCom,\n" +
//                            "     tab_produtonfesaida.`qCom` AS tab_produtonfesaida_qCom,\n" +
//                            "     tab_produtonfesaida.`vUnCom` AS tab_produtonfesaida_vUnCom,\n" +
//                            "     tab_produtonfesaida.`vProd` AS tab_produtonfesaida_vProd,\n" +
//                            "     tab_produtonfesaida.`ceanTrib` AS tab_produtonfesaida_ceanTrib,\n" +
//                            "     tab_produtonfesaida.`uTrib` AS tab_produtonfesaida_uTrib,\n" +
//                            "     tab_produtonfesaida.`qTrib` AS tab_produtonfesaida_qTrib,\n" +
//                            "     tab_produtonfesaida.`vUnTrib` AS tab_produtonfesaida_vUnTrib,\n" +
//                            "     tab_produtonfesaida.`vFrete` AS tab_produtonfesaida_vFrete,\n" +
//                            "     tab_produtonfesaida.`vSeg` AS tab_produtonfesaida_vSeg,\n" +
//                            "     tab_produtonfesaida.`vDesc` AS tab_produtonfesaida_vDesc,\n" +
//                            "     tab_produtonfesaida.`vOutro` AS tab_produtonfesaida_vOutro,\n" +
//                            "     tab_produtonfesaida.`indTot` AS tab_produtonfesaida_indTot,\n" +
//                            "     tab_produtonfesaida.`di` AS tab_produtonfesaida_di,\n" +
//                            "     tab_produtonfesaida.`detExport` AS tab_produtonfesaida_detExport,\n" +
//                            "     tab_produtonfesaida.`xPed` AS tab_produtonfesaida_xPed,\n" +
//                            "     tab_produtonfesaida.`nItemPed` AS tab_produtonfesaida_nItemPed,\n" +
//                            "     tab_produtonfesaida.`nfci` AS tab_produtonfesaida_nfci,\n" +
//                            "     tab_produtonfesaida.`veicProd` AS tab_produtonfesaida_veicProd,\n" +
//                            "     tab_produtonfesaida.`med` AS tab_produtonfesaida_med,\n" +
//                            "     tab_produtonfesaida.`arma` AS tab_produtonfesaida_arma,\n" +
//                            "     tab_produtonfesaida.`comb` AS tab_produtonfesaida_comb,\n" +
//                            "     tab_produtonfesaida.`nrecopi` AS tab_produtonfesaida_nrecopi,\n" +
//                            "     tab_produtonfesaida.`CSOSN` AS tab_produtonfesaida_CSOSN,\n" +
//                            "     tab_produtonfesaida.`Origem` AS tab_produtonfesaida_Origem,\n" +
//                            "     tab_produtonfesaida.`ValorDescontoUnitario` AS tab_produtonfesaida_ValorDescontoUnitario,\n" +
//                            "     tab_produtonfesaida.`CSTUnitario` AS tab_produtonfesaida_CSTUnitario,\n" +
//                            "     tab_produtonfesaida.`BCicmsUnitario` AS tab_produtonfesaida_BCicmsUnitario,\n" +
//                            "     tab_produtonfesaida.`ValorICMSUnitario` AS tab_produtonfesaida_ValorICMSUnitario,\n" +
//                            "     tab_produtonfesaida.`ValorIPIUnitario` AS tab_produtonfesaida_ValorIPIUnitario,\n" +
//                            "     tab_produtonfesaida.`ValorAliquotaICMSUnitario` AS tab_produtonfesaida_ValorAliquotaICMSUnitario,\n" +
//                            "     tab_produtonfesaida.`ValorAliquotaIPIUnitario` AS tab_produtonfesaida_ValorAliquotaIPIUnitario,\n" +
//                            "     tab_nota_fiscal_lancamento.`StatusImpressao` AS tab_nota_fiscal_lancamento_StatusImpressao,\n" +
//                            "     tab_nota_fiscal_lancamento.`QRCode` AS tab_nota_fiscal_lancamento_QRCode,\n" +
//                            "     tab_pedido.`id` AS tab_pedido_id,\n" +
//                            "     tab_pedido.`IDCliente` AS tab_pedido_IDCliente,\n" +
//                            "     tab_pedido.`NomeCliente` AS tab_pedido_NomeCliente,\n" +
//                            "     tab_pedido.`Desconto` AS tab_pedido_Desconto,\n" +
//                            "     tab_pedido.`ValorTotal` AS tab_pedido_ValorTotal,\n" +
//                            "     tab_pedido.`FormaPagamento` AS tab_pedido_FormaPagamento,\n" +
//                            "     tab_pedido.`ValorAVista` AS tab_pedido_ValorAVista,\n" +
//                            "     tab_pedido.`ValorCartao` AS tab_pedido_ValorCartao,\n" +
//                            "     tab_pedido.`TipoCreditoCartao` AS tab_pedido_TipoCreditoCartao,\n" +
//                            "     tab_pedido.`NumeroParcelasCartao` AS tab_pedido_NumeroParcelasCartao,\n" +
//                            "     tab_pedido.`BandeiraCartao` AS tab_pedido_BandeiraCartao,\n" +
//                            "     tab_pedido.`ValorCheque` AS tab_pedido_ValorCheque,\n" +
//                            "     tab_pedido.`ValorParcelado` AS tab_pedido_ValorParcelado,\n" +
//                            "     tab_pedido.`NumeroParcelasPacelado` AS tab_pedido_NumeroParcelasPacelado,\n" +
//                            "     tab_pedido.`ValorParcelaPacelado` AS tab_pedido_ValorParcelaPacelado,\n" +
//                            "     tab_pedido.`VencimentoPacelado` AS tab_pedido_VencimentoPacelado,\n" +
//                            "     tab_pedido.`DataInclusao` AS tab_pedido_DataInclusao,\n" +
//                            "     tab_pedido.`HoraInclusao` AS tab_pedido_HoraInclusao,\n" +
//                            "     tab_pedido.`Status` AS tab_pedido_Status,\n" +
//                            "     tab_pedido.`TipoParcelado` AS tab_pedido_TipoParcelado,\n" +
//                            "     tab_pedido.`DataInclusaoSemBarras` AS tab_pedido_DataInclusaoSemBarras,\n" +
//                            "     tab_pedido.`troco` AS tab_pedido_troco,\n" +
//                            "     tab_pedido.`numeroOrcamento` AS tab_pedido_numeroOrcamento,\n" +
//                            "     tab_pedido.`numeroPreVenda` AS tab_pedido_numeroPreVenda,\n" +
//                            "     tab_pedido.`numeroNF` AS tab_pedido_numeroNF,\n" +
//                            "     tab_pedido.`ValorDoCreditoUsado` AS tab_pedido_ValorDoCreditoUsado,\n" +
//                            "     tab_pedido.`observacao` AS tab_pedido_observacao,\n" +
//                            "     tab_pedido.`usuario` AS tab_pedido_usuario,\n" +
//                            "     tab_pedido.`vendedor` AS tab_pedido_vendedor,\n" +
//                            "     tab_pedido.`Integrado` AS tab_pedido_Integrado,\n" +
//                            "     tab_pedido.`DataIntegracao` AS tab_pedido_DataIntegracao,\n" +
//                            "     tab_nota_fiscal_lancamento.`TipoTransmissao` AS tab_nota_fiscal_lancamento_TipoTransmissao,\n" +
//                            "     tab_nota_fiscal_lancamento.`informacaoDeImposto` AS tab_nota_fiscal_lancamento_informacaoDeImposto\n" +
//                            "FROM\n" +
//                            "     `tab_empresa` tab_empresa,\n" +
//                            "     `tab_nota_fiscal_lancamento` tab_nota_fiscal_lancamento,\n" +
//                            "     `tab_produtonfesaida` tab_produtonfesaida,\n" +
//                            "     `tab_pedido` tab_pedido\n" +
//                            "WHERE\n" +
//                            "     tab_empresa.id = '1'\n" +
//                            " AND tab_nota_fiscal_lancamento.id = '"+idLancamento+"'\n" +
//                            " AND tab_produtonfesaida.IdLancamento = '"+idLancamento+"'\n" +
//                            " AND tab_pedido.id = '"+numeroPedido+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                //JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//                
//                JasperFillManager.fillReportToFile("C:\\DSistema\\NFE\\NFCe.jasper", parametros,jrRS);
//                
//                //Vizualiza
//                //JasperViewer.viewReport("C:\\DSistema\\NFE\\NFCe.jrprint",false,false);
//                
//                //Imprime printReport(endereco\relatorio,false);
//                JasperPrintManager.printReport("C:\\DSistema\\NFE\\NFCe.jrprint",false);
//                 
//                
//        }
//        
//
//        public void imprimirPedido48 (String idPedido) throws JRException , SQLException, ClassNotFoundException {
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();                
//                String query = "SELECT\n" +
//                            "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                            "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                            "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                            "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                            "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                            "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                            "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                            "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                            "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                            "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                            "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                            "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                            "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                            "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                            "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                            "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                            "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                            "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                            "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                            "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                            "     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//                            "     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//                            "     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//                            "     tab_pedido.`id` AS tab_pedido_id,\n" +
//                            "     tab_pedido.`IDCliente` AS tab_pedido_IDCliente,\n" +
//                            "     tab_pedido.`NomeCliente` AS tab_pedido_NomeCliente,\n" +
//                            "     tab_pedido.`Desconto` AS tab_pedido_Desconto,\n" +
//                            "     tab_pedido.`ValorTotal` AS tab_pedido_ValorTotal,\n" +
//                            "     tab_pedido.`FormaPagamento` AS tab_pedido_FormaPagamento,\n" +
//                            "     tab_pedido.`ValorAVista` AS tab_pedido_ValorAVista,\n" +
//                            "     tab_pedido.`ValorCartao` AS tab_pedido_ValorCartao,\n" +
//                            "     tab_pedido.`TipoCreditoCartao` AS tab_pedido_TipoCreditoCartao,\n" +
//                            "     tab_pedido.`NumeroParcelasCartao` AS tab_pedido_NumeroParcelasCartao,\n" +
//                            "     tab_pedido.`BandeiraCartao` AS tab_pedido_BandeiraCartao,\n" +
//                            "     tab_pedido.`ValorCheque` AS tab_pedido_ValorCheque,\n" +
//                            "     tab_pedido.`ValorParcelado` AS tab_pedido_ValorParcelado,\n" +
//                            "     tab_pedido.`NumeroParcelasPacelado` AS tab_pedido_NumeroParcelasPacelado,\n" +
//                            "     tab_pedido.`ValorParcelaPacelado` AS tab_pedido_ValorParcelaPacelado,\n" +
//                            "     tab_pedido.`VencimentoPacelado` AS tab_pedido_VencimentoPacelado,\n" +
//                            "     tab_pedido.`DataInclusao` AS tab_pedido_DataInclusao,\n" +
//                            "     tab_pedido.`HoraInclusao` AS tab_pedido_HoraInclusao,\n" +
//                            "     tab_pedido.`Status` AS tab_pedido_Status,\n" +
//                            "     tab_pedido.`TipoParcelado` AS tab_pedido_TipoParcelado,\n" +
//                            "     tab_pedido.`DataInclusaoSemBarras` AS tab_pedido_DataInclusaoSemBarras,\n" +
//                            "     tab_pedido.`troco` AS tab_pedido_troco,\n" +
//                            "     tab_pedido.`numeroOrcamento` AS tab_pedido_numeroOrcamento,\n" +
//                            "     tab_pedido.`numeroPreVenda` AS tab_pedido_numeroPreVenda,\n" +
//                            "     tab_pedido.`numeroNF` AS tab_pedido_numeroNF,\n" +
//                            "     tab_pedido.`ValorDoCreditoUsado` AS tab_pedido_ValorDoCreditoUsado,\n" +
//                            "     tab_pedido.`observacao` AS tab_pedido_observacao,\n" +
//                            "     tab_pedido.`usuario` AS tab_pedido_usuario,\n" +
//                            "     tab_pedido.`vendedor` AS tab_pedido_vendedor,\n" +
//                            "     tab_pedido.`Integrado` AS tab_pedido_Integrado,\n" +
//                            "     tab_pedido.`DataIntegracao` AS tab_pedido_DataIntegracao,\n" +
//                            "     tab_produto_pedido.`id` AS tab_produto_pedido_id,\n" +
//                            "     tab_produto_pedido.`id_pedido` AS tab_produto_pedido_id_pedido,\n" +
//                            "     tab_produto_pedido.`cod_produto` AS tab_produto_pedido_cod_produto,\n" +
//                            "     tab_produto_pedido.`produto` AS tab_produto_pedido_produto,\n" +
//                            "     tab_produto_pedido.`preco` AS tab_produto_pedido_preco,\n" +
//                            "     tab_produto_pedido.`quantidade_pedido` AS tab_produto_pedido_quantidade_pedido,\n" +
//                            "     tab_produto_pedido.`desconto_unitario` AS tab_produto_pedido_desconto_unitario,\n" +
//                            "     tab_produto_pedido.`referenciaProduto` AS tab_produto_pedido_referenciaProduto,\n" +
//                            "     tab_produto_pedido.`Integrado` AS tab_produto_pedido_Integrado,\n" +
//                            "     tab_produto_pedido.`DataIntegracao` AS tab_produto_pedido_DataIntegracao\n" +
//                            "FROM\n" +
//                            "     `tab_empresa` tab_empresa,\n" +
//                            "     `tab_pedido` tab_pedido,\n" +
//                            "     `tab_produto_pedido` tab_produto_pedido\n" +
//                            "WHERE\n" +
//                            "     tab_empresa.id = '1'\n" +
//                            "AND tab_pedido.id = '"+idPedido+"'\n" +
//                            "AND tab_produto_pedido.id_pedido = '"+idPedido+"'";
//                
//                
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                /**
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                //JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//                
//                JasperFillManager.fillReportToFile("C:\\DSistema\\Pedido48.jasper", parametros,jrRS);
//                
//                //Vizualiza
//                JasperViewer.viewReport("C:\\DSistema\\Pedido48.jrxml",false,false);
//                
//                //Imprime printReport(endereco\relatorio,false);
//                JasperPrintManager.printReport("C:\\DSistema\\Pedido48.jrxml",false);
//                */
//                
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                
//                //Emteste
//                 JasperDesign desenho = JRXmlLoader.load( "C:\\DSistema\\Pedido48.jrxml" );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//                
//                //executa o relatório
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir Pedido");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(1.00f);
//                viewer.show(); 
//                
//        }
//        
//        public void testeGerarRelatorioPARA_GERAR_JR_PRINT()  throws JRException, SQLException {
//            
//            //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();                
//                String query = "SELECT\n" +
//                            "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                            "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                            "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                            "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                            "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                            "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                            "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                            "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                            "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                            "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                            "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                            "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                            "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                            "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                            "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                            "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                            "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                            "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                            "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                            "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                            "     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//                            "     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//                            "     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//                            "     tab_pedido.`id` AS tab_pedido_id,\n" +
//                            "     tab_pedido.`IDCliente` AS tab_pedido_IDCliente,\n" +
//                            "     tab_pedido.`NomeCliente` AS tab_pedido_NomeCliente,\n" +
//                            "     tab_pedido.`Desconto` AS tab_pedido_Desconto,\n" +
//                            "     tab_pedido.`ValorTotal` AS tab_pedido_ValorTotal,\n" +
//                            "     tab_pedido.`FormaPagamento` AS tab_pedido_FormaPagamento,\n" +
//                            "     tab_pedido.`ValorAVista` AS tab_pedido_ValorAVista,\n" +
//                            "     tab_pedido.`ValorCartao` AS tab_pedido_ValorCartao,\n" +
//                            "     tab_pedido.`TipoCreditoCartao` AS tab_pedido_TipoCreditoCartao,\n" +
//                            "     tab_pedido.`NumeroParcelasCartao` AS tab_pedido_NumeroParcelasCartao,\n" +
//                            "     tab_pedido.`BandeiraCartao` AS tab_pedido_BandeiraCartao,\n" +
//                            "     tab_pedido.`ValorCheque` AS tab_pedido_ValorCheque,\n" +
//                            "     tab_pedido.`ValorParcelado` AS tab_pedido_ValorParcelado,\n" +
//                            "     tab_pedido.`NumeroParcelasPacelado` AS tab_pedido_NumeroParcelasPacelado,\n" +
//                            "     tab_pedido.`ValorParcelaPacelado` AS tab_pedido_ValorParcelaPacelado,\n" +
//                            "     tab_pedido.`VencimentoPacelado` AS tab_pedido_VencimentoPacelado,\n" +
//                            "     tab_pedido.`DataInclusao` AS tab_pedido_DataInclusao,\n" +
//                            "     tab_pedido.`HoraInclusao` AS tab_pedido_HoraInclusao,\n" +
//                            "     tab_pedido.`Status` AS tab_pedido_Status,\n" +
//                            "     tab_pedido.`TipoParcelado` AS tab_pedido_TipoParcelado,\n" +
//                            "     tab_pedido.`DataInclusaoSemBarras` AS tab_pedido_DataInclusaoSemBarras,\n" +
//                            "     tab_pedido.`troco` AS tab_pedido_troco,\n" +
//                            "     tab_pedido.`numeroOrcamento` AS tab_pedido_numeroOrcamento,\n" +
//                            "     tab_pedido.`numeroPreVenda` AS tab_pedido_numeroPreVenda,\n" +
//                            "     tab_pedido.`numeroNF` AS tab_pedido_numeroNF,\n" +
//                            "     tab_pedido.`ValorDoCreditoUsado` AS tab_pedido_ValorDoCreditoUsado,\n" +
//                            "     tab_pedido.`observacao` AS tab_pedido_observacao,\n" +
//                            "     tab_pedido.`usuario` AS tab_pedido_usuario,\n" +
//                            "     tab_pedido.`vendedor` AS tab_pedido_vendedor,\n" +
//                            "     tab_pedido.`Integrado` AS tab_pedido_Integrado,\n" +
//                            "     tab_pedido.`DataIntegracao` AS tab_pedido_DataIntegracao,\n" +
//                            "     tab_produto_pedido.`id` AS tab_produto_pedido_id,\n" +
//                            "     tab_produto_pedido.`id_pedido` AS tab_produto_pedido_id_pedido,\n" +
//                            "     tab_produto_pedido.`cod_produto` AS tab_produto_pedido_cod_produto,\n" +
//                            "     tab_produto_pedido.`produto` AS tab_produto_pedido_produto,\n" +
//                            "     tab_produto_pedido.`preco` AS tab_produto_pedido_preco,\n" +
//                            "     tab_produto_pedido.`quantidade_pedido` AS tab_produto_pedido_quantidade_pedido,\n" +
//                            "     tab_produto_pedido.`desconto_unitario` AS tab_produto_pedido_desconto_unitario,\n" +
//                            "     tab_produto_pedido.`referenciaProduto` AS tab_produto_pedido_referenciaProduto,\n" +
//                            "     tab_produto_pedido.`Integrado` AS tab_produto_pedido_Integrado,\n" +
//                            "     tab_produto_pedido.`DataIntegracao` AS tab_produto_pedido_DataIntegracao\n" +
//                            "FROM\n" +
//                            "     `tab_empresa` tab_empresa,\n" +
//                            "     `tab_pedido` tab_pedido,\n" +
//                            "     `tab_produto_pedido` tab_produto_pedido\n" +
//                            "WHERE\n" +
//                            "     tab_empresa.id = '1'\n" +
//                            "AND tab_pedido.id = '80'\n" +
//                            "AND tab_produto_pedido.id_pedido = '80'";
//                
//                
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( "C:\\DSistema\\Pedido48.jasper" );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//                
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//                
//                JasperFillManager.fillReportToFile("C:\\DSistema\\Pedido48.jasper", parametros,jrRS);
//                
//                //Vizualiza
//                //JasperViewer.viewReport("C:\\DSistema\\NFE\\NFCe.jrprint",false,false);
//                
//                //Imprime printReport(endereco\relatorio,false);
//                //JasperPrintManager.printReport("C:\\DSistema\\Pedido48.jrprint",false);
//
//        }
//        
//            public void gerarJrPrint (){
//                try{
//                    Statement stm = co.AbreConexaoBanco();                
//                    String query = "SELECT\n" +
//                            "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                            "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                            "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                            "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                            "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                            "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                            "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                            "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                            "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                            "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                            "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                            "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                            "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                            "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                            "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                            "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                            "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                            "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                            "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                            "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                            "     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//                            "     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//                            "     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//                            "     tab_pedido.`id` AS tab_pedido_id,\n" +
//                            "     tab_pedido.`IDCliente` AS tab_pedido_IDCliente,\n" +
//                            "     tab_pedido.`NomeCliente` AS tab_pedido_NomeCliente,\n" +
//                            "     tab_pedido.`Desconto` AS tab_pedido_Desconto,\n" +
//                            "     tab_pedido.`ValorTotal` AS tab_pedido_ValorTotal,\n" +
//                            "     tab_pedido.`FormaPagamento` AS tab_pedido_FormaPagamento,\n" +
//                            "     tab_pedido.`ValorAVista` AS tab_pedido_ValorAVista,\n" +
//                            "     tab_pedido.`ValorCartao` AS tab_pedido_ValorCartao,\n" +
//                            "     tab_pedido.`TipoCreditoCartao` AS tab_pedido_TipoCreditoCartao,\n" +
//                            "     tab_pedido.`NumeroParcelasCartao` AS tab_pedido_NumeroParcelasCartao,\n" +
//                            "     tab_pedido.`BandeiraCartao` AS tab_pedido_BandeiraCartao,\n" +
//                            "     tab_pedido.`ValorCheque` AS tab_pedido_ValorCheque,\n" +
//                            "     tab_pedido.`ValorParcelado` AS tab_pedido_ValorParcelado,\n" +
//                            "     tab_pedido.`NumeroParcelasPacelado` AS tab_pedido_NumeroParcelasPacelado,\n" +
//                            "     tab_pedido.`ValorParcelaPacelado` AS tab_pedido_ValorParcelaPacelado,\n" +
//                            "     tab_pedido.`VencimentoPacelado` AS tab_pedido_VencimentoPacelado,\n" +
//                            "     tab_pedido.`DataInclusao` AS tab_pedido_DataInclusao,\n" +
//                            "     tab_pedido.`HoraInclusao` AS tab_pedido_HoraInclusao,\n" +
//                            "     tab_pedido.`Status` AS tab_pedido_Status,\n" +
//                            "     tab_pedido.`TipoParcelado` AS tab_pedido_TipoParcelado,\n" +
//                            "     tab_pedido.`DataInclusaoSemBarras` AS tab_pedido_DataInclusaoSemBarras,\n" +
//                            "     tab_pedido.`troco` AS tab_pedido_troco,\n" +
//                            "     tab_pedido.`numeroOrcamento` AS tab_pedido_numeroOrcamento,\n" +
//                            "     tab_pedido.`numeroPreVenda` AS tab_pedido_numeroPreVenda,\n" +
//                            "     tab_pedido.`numeroNF` AS tab_pedido_numeroNF,\n" +
//                            "     tab_pedido.`ValorDoCreditoUsado` AS tab_pedido_ValorDoCreditoUsado,\n" +
//                            "     tab_pedido.`observacao` AS tab_pedido_observacao,\n" +
//                            "     tab_pedido.`usuario` AS tab_pedido_usuario,\n" +
//                            "     tab_pedido.`vendedor` AS tab_pedido_vendedor,\n" +
//                            "     tab_pedido.`Integrado` AS tab_pedido_Integrado,\n" +
//                            "     tab_pedido.`DataIntegracao` AS tab_pedido_DataIntegracao,\n" +
//                            "     tab_produto_pedido.`id` AS tab_produto_pedido_id,\n" +
//                            "     tab_produto_pedido.`id_pedido` AS tab_produto_pedido_id_pedido,\n" +
//                            "     tab_produto_pedido.`cod_produto` AS tab_produto_pedido_cod_produto,\n" +
//                            "     tab_produto_pedido.`produto` AS tab_produto_pedido_produto,\n" +
//                            "     tab_produto_pedido.`preco` AS tab_produto_pedido_preco,\n" +
//                            "     tab_produto_pedido.`quantidade_pedido` AS tab_produto_pedido_quantidade_pedido,\n" +
//                            "     tab_produto_pedido.`desconto_unitario` AS tab_produto_pedido_desconto_unitario,\n" +
//                            "     tab_produto_pedido.`referenciaProduto` AS tab_produto_pedido_referenciaProduto,\n" +
//                            "     tab_produto_pedido.`Integrado` AS tab_produto_pedido_Integrado,\n" +
//                            "     tab_produto_pedido.`DataIntegracao` AS tab_produto_pedido_DataIntegracao\n" +
//                            "FROM\n" +
//                            "     `tab_empresa` tab_empresa,\n" +
//                            "     `tab_pedido` tab_pedido,\n" +
//                            "     `tab_produto_pedido` tab_produto_pedido\n" +
//                            "WHERE\n" +
//                            "     tab_empresa.id = '1'\n" +
//                            "AND tab_pedido.id = '80'\n" +
//                            "AND tab_produto_pedido.id_pedido = '80'";
//                        //você ira colocar aqui, sua pesquisa so banco de dados
//                        ResultSet rs = stm.executeQuery( query );
//                        JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//                        Map parameters = new HashMap();
//                        JasperFillManager.fillReportToFile("C:\\DSistema\\Pedido48.jasper", parameters, jrRS);
//                        //Exportação para pdf
//                        long start = System.currentTimeMillis();
//                        JasperExportManager.exportReportToPdfFile("C:\\DSistema\\Pedido48.jrprint");
//                        System.err.println("PDF creation time : " + (System.currentTimeMillis() - start));
//                    }catch(Exception e){
//                        System.out.println("Database error!");
//                        e.printStackTrace();
//                    }
//        }
//        
//        public void MandarImpressaoIreportDiretoParaImpressoraPadrao() throws JRException , SQLException, ClassNotFoundException {
//                //gerando o jasper design
//                //JasperDesign desenho = JRXmlLoader.load( "C:\\DSistema\\RelatorioTeste.jrxml" );
//
//                //compila o relatório
//                //JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                
//                String query = "SELECT\n" +
//                "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                "     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//                "     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//                "     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao\n" +
//                "FROM\n" +
//                "     `tab_empresa` tab_empresa";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                //JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//                
//                JasperFillManager.fillReportToFile("C:\\DSistema\\RelatorioTeste.jasper", parametros,jrRS);
//
//                //Vizualiza
//                //JasperViewer.viewReport("C:\\DSistema\\RelatorioTeste.jrprint",false,false);
//                
//                //Imprime printReport(endereco\relatorio,false);
//                //JasperPrintManager.printReport("C:\\DSistema\\RelatorioTeste.jrprint",false);
//                 
//                
//                
//        }
//        
//        public void mandarImpresssaoParaImpressora() throws JRException, SQLException {
//            
//            Statement stm = co.AbreConexaoBanco();
//                
//                String query = "SELECT\n" +
//                "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                "     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//                "     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//                "     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao\n" +
//                "FROM\n" +
//                "     `tab_empresa` tab_empresa";
//            
//            ResultSet rs = stm.executeQuery( query );
//            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
//            Map parameters = new HashMap();
//
//            JasperFillManager.fillReportToFile("C:\\DSistema\\RelatorioTeste.jasper", parameters,jrRS);
//
//            //Vizualiza
//            JasperViewer.viewReport("C:\\DSistema\\RelatorioTeste.jrprint",false,false);
//
//            //Imprime printReport(endereco\relatorio,false);
//            JasperPrintManager.printReport("C:\\DSistema\\RelatorioTeste.jrprint",false);
//            
//        }
//        
//        public String imprimePedidoNoIreport( String caminhoIreport , String idPedido, String idCliente) throws JRException , SQLException, ClassNotFoundException {
//                
//                String nomeDoArquivoPdf = "";
//            
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                "     tab_empresa.`TipoServidor` AS tab_empresa_TipoServidor,\n" +
//                "     tab_empresa.`Integrado` AS tab_empresa_Integrado,\n" +
//                "     tab_empresa.`DataIntegracao` AS tab_empresa_DataIntegracao,\n" +
//                "     tab_pedido.`id` AS tab_pedido_id,\n" +
//                "     tab_pedido.`IDCliente` AS tab_pedido_IDCliente,\n" +
//                "     tab_pedido.`NomeCliente` AS tab_pedido_NomeCliente,\n" +
//                "     tab_pedido.`Desconto` AS tab_pedido_Desconto,\n" +
//                "     tab_pedido.`ValorTotal` AS tab_pedido_ValorTotal,\n" +
//                "     tab_pedido.`FormaPagamento` AS tab_pedido_FormaPagamento,\n" +
//                "     tab_pedido.`ValorAVista` AS tab_pedido_ValorAVista,\n" +
//                "     tab_pedido.`ValorCartao` AS tab_pedido_ValorCartao,\n" +
//                "     tab_pedido.`TipoCreditoCartao` AS tab_pedido_TipoCreditoCartao,\n" +
//                "     tab_pedido.`NumeroParcelasCartao` AS tab_pedido_NumeroParcelasCartao,\n" +
//                "     tab_pedido.`BandeiraCartao` AS tab_pedido_BandeiraCartao,\n" +
//                "     tab_pedido.`ValorCheque` AS tab_pedido_ValorCheque,\n" +
//                "     tab_pedido.`ValorParcelado` AS tab_pedido_ValorParcelado,\n" +
//                "     tab_pedido.`NumeroParcelasPacelado` AS tab_pedido_NumeroParcelasPacelado,\n" +
//                "     tab_pedido.`ValorParcelaPacelado` AS tab_pedido_ValorParcelaPacelado,\n" +
//                "     tab_pedido.`VencimentoPacelado` AS tab_pedido_VencimentoPacelado,\n" +
//                "     tab_pedido.`DataInclusao` AS tab_pedido_DataInclusao,\n" +
//                "     tab_pedido.`HoraInclusao` AS tab_pedido_HoraInclusao,\n" +
//                "     tab_pedido.`Status` AS tab_pedido_Status,\n" +
//                "     tab_pedido.`TipoParcelado` AS tab_pedido_TipoParcelado,\n" +
//                "     tab_pedido.`DataInclusaoSemBarras` AS tab_pedido_DataInclusaoSemBarras,\n" +
//                "     tab_pedido.`troco` AS tab_pedido_troco,\n" +
//                "     tab_pedido.`numeroOrcamento` AS tab_pedido_numeroOrcamento,\n" +
//                "     tab_pedido.`numeroPreVenda` AS tab_pedido_numeroPreVenda,\n" +
//                "     tab_pedido.`numeroNF` AS tab_pedido_numeroNF,\n" +
//                "     tab_pedido.`ValorDoCreditoUsado` AS tab_pedido_ValorDoCreditoUsado,\n" +
//                "     tab_pedido.`observacao` AS tab_pedido_observacao,\n" +
//                "     tab_pedido.`usuario` AS tab_pedido_usuario,\n" +
//                "     tab_pedido.`vendedor` AS tab_pedido_vendedor,\n" +
//                "     tab_pedido.`Integrado` AS tab_pedido_Integrado,\n" +
//                "     tab_pedido.`DataIntegracao` AS tab_pedido_DataIntegracao,\n" +
//                "     tab_produto_pedido.`id` AS tab_produto_pedido_id,\n" +
//                "     tab_produto_pedido.`id_pedido` AS tab_produto_pedido_id_pedido,\n" +
//                "     tab_produto_pedido.`cod_produto` AS tab_produto_pedido_cod_produto,\n" +
//                "     tab_produto_pedido.`produto` AS tab_produto_pedido_produto,\n" +
//                "     tab_produto_pedido.`preco` AS tab_produto_pedido_preco,\n" +
//                "     tab_produto_pedido.`quantidade_pedido` AS tab_produto_pedido_quantidade_pedido,\n" +
//                "     tab_produto_pedido.`desconto_unitario` AS tab_produto_pedido_desconto_unitario,\n" +
//                "     tab_produto_pedido.`referenciaProduto` AS tab_produto_pedido_referenciaProduto,\n" +
//                "     tab_produto_pedido.`Integrado` AS tab_produto_pedido_Integrado,\n" +
//                "     tab_produto_pedido.`DataIntegracao` AS tab_produto_pedido_DataIntegracao,\n" +
//                "     tab_cliente.`id` AS tab_cliente_id,\n" +
//                "     tab_cliente.`nome` AS tab_cliente_nome,\n" +
//                "     tab_cliente.`endereco` AS tab_cliente_endereco,\n" +
//                "     tab_cliente.`bairro` AS tab_cliente_bairro,\n" +
//                "     tab_cliente.`cidade` AS tab_cliente_cidade,\n" +
//                "     tab_cliente.`estado` AS tab_cliente_estado,\n" +
//                "     tab_cliente.`cep` AS tab_cliente_cep,\n" +
//                "     tab_cliente.`cnpj` AS tab_cliente_cnpj,\n" +
//                "     tab_cliente.`telefone` AS tab_cliente_telefone,\n" +
//                "     tab_cliente.`numero` AS tab_cliente_numero,\n" +
//                "     tab_cliente.`observacao` AS tab_cliente_observacao,\n" +
//                "     tab_cliente.`matricula` AS tab_cliente_matricula,\n" +
//                "     tab_cliente.`email` AS tab_cliente_email,\n" +
//                "     tab_cliente.`apto` AS tab_cliente_apto,\n" +
//                "     tab_cliente.`pai` AS tab_cliente_pai,\n" +
//                "     tab_cliente.`mae` AS tab_cliente_mae,\n" +
//                "     tab_cliente.`tel_trabalho` AS tab_cliente_tel_trabalho,\n" +
//                "     tab_cliente.`data_nascimento` AS tab_cliente_data_nascimento,\n" +
//                "     tab_cliente.`codigo_municipio` AS tab_cliente_codigo_municipio,\n" +
//                "     tab_cliente.`insc_estadual` AS tab_cliente_insc_estadual,\n" +
//                "     tab_cliente.`descricaoContrato` AS tab_cliente_descricaoContrato,\n" +
//                "     tab_cliente.`valorInstalacao` AS tab_cliente_valorInstalacao,\n" +
//                "     tab_cliente.`valorMensalidade` AS tab_cliente_valorMensalidade,\n" +
//                "     tab_cliente.`numeroDeMensalidades` AS tab_cliente_numeroDeMensalidades,\n" +
//                "     tab_cliente.`vencimentoMensalidade` AS tab_cliente_vencimentoMensalidade,\n" +
//                "     tab_cliente.`celular` AS tab_cliente_celular,\n" +
//                "     tab_cliente.`razao` AS tab_cliente_razao,\n" +
//                "     tab_cliente.`Integrado` AS tab_cliente_Integrado,\n" +
//                "     tab_cliente.`DataIntegracao` AS tab_cliente_DataIntegracao,\n" +
//                "     tab_cliente.`Profissao` AS tab_cliente_Profissao,\n" +
//                "     tab_cliente.`Sexo` AS tab_cliente_Sexo,\n" +
//                "     tab_cliente.`RendaFamiliar` AS tab_cliente_RendaFamiliar,\n" +
//                "     tab_cliente.`Vendedor` AS tab_cliente_Vendedor,\n" +
//                "     tab_cliente.`Loteamento` AS tab_cliente_Loteamento,\n" +
//                "     tab_cliente.`EnderecoLoteamento` AS tab_cliente_EnderecoLoteamento,\n" +
//                "     tab_cliente.`RegistroLoteamento` AS tab_cliente_RegistroLoteamento,\n" +
//                "     tab_cliente.`Quadra` AS tab_cliente_Quadra,\n" +
//                "     tab_cliente.`Lote` AS tab_cliente_Lote,\n" +
//                "     tab_cliente.`NumeroContrato` AS tab_cliente_NumeroContrato,\n" +
//                "     tab_cliente.`Area` AS tab_cliente_Area,\n" +
//                "     tab_cliente.`Medicoes` AS tab_cliente_Medicoes,\n" +
//                "     tab_cliente.`ValorDaCompra` AS tab_cliente_ValorDaCompra,\n" +
//                "     tab_cliente.`ValorEntrada` AS tab_cliente_ValorEntrada,\n" +
//                "     tab_cliente.`PrimeiraParcela` AS tab_cliente_PrimeiraParcela,\n" +
//                "     tab_cliente.`SegundaParcela` AS tab_cliente_SegundaParcela,\n" +
//                "     tab_cliente.`TerceiraParcela` AS tab_cliente_TerceiraParcela,\n" +
//                "     tab_cliente.`QuartaParcela` AS tab_cliente_QuartaParcela,\n" +
//                "     tab_cliente.`QuantidadeDeParcelas` AS tab_cliente_QuantidadeDeParcelas,\n" +
//                "     tab_cliente.`ValorDaParcela` AS tab_cliente_ValorDaParcela,\n" +
//                "     tab_cliente.`DiaVencimento` AS tab_cliente_DiaVencimento,\n" +
//                "     tab_cliente.`SituacaoPagamento` AS tab_cliente_SituacaoPagamento,\n" +
//                "     tab_cliente.`DataContrato` AS tab_cliente_DataContrato,\n" +
//                "     tab_cliente.`EstadoCivil` AS tab_cliente_EstadoCivil,\n" +
//                "     tab_cliente.`RuaCobranca` AS tab_cliente_RuaCobranca,\n" +
//                "     tab_cliente.`NumeroCobranca` AS tab_cliente_NumeroCobranca,\n" +
//                "     tab_cliente.`BairroCobranca` AS tab_cliente_BairroCobranca,\n" +
//                "     tab_cliente.`CidadeCobranca` AS tab_cliente_CidadeCobranca,\n" +
//                "     tab_cliente.`UfCobranca` AS tab_cliente_UfCobranca,\n" +
//                "     tab_cliente.`CEPCobranca` AS tab_cliente_CEPCobranca,\n" +
//                "     tab_cliente.`NomeConjugue` AS tab_cliente_NomeConjugue,\n" +
//                "     tab_cliente.`IdentidadeConjugue` AS tab_cliente_IdentidadeConjugue,\n" +
//                "     tab_cliente.`ProfissaoConjugue` AS tab_cliente_ProfissaoConjugue,\n" +
//                "     tab_cliente.`NascimentoConjugue` AS tab_cliente_NascimentoConjugue,\n" +
//                "     tab_cliente.`CPFConjugue` AS tab_cliente_CPFConjugue,\n" +
//                "     tab_cliente.`dataInicioDaUtilizacaoDoSistema` AS tab_cliente_dataInicioDaUtilizacaoDoSistema,\n" +
//                "     tab_cliente.`Perfil` AS tab_cliente_Perfil,\n" +
//                "     tab_cliente.`Graduacao` AS tab_cliente_Graduacao,\n" +
//                "     tab_cliente.`QuantidadeDeGraus` AS tab_cliente_QuantidadeDeGraus,\n" +
//                "     tab_cliente.`Tipo` AS tab_cliente_Tipo,\n" +
//                "     tab_cliente.`Idade` AS tab_cliente_Idade,\n" +
//                "     tab_cliente.`Nacionalidade` AS tab_cliente_Nacionalidade,\n" +
//                "     tab_cliente.`NacionalidadeConugue` AS tab_cliente_NacionalidadeConugue,\n" +
//                "     tab_cliente.`TelefoneConjugue` AS tab_cliente_TelefoneConjugue,\n" +
//                "     tab_cliente.`ValorDaCompraPorExtenso` AS tab_cliente_ValorDaCompraPorExtenso,\n" +
//                "     tab_cliente.`DataDoContratoPorExtenso` AS tab_cliente_DataDoContratoPorExtenso,\n" +
//                "     tab_cliente.`DescricaoFrente` AS tab_cliente_DescricaoFrente,\n" +
//                "     tab_cliente.`DescricaoFundos` AS tab_cliente_DescricaoFundos,\n" +
//                "     tab_cliente.`MedicaoFrente` AS tab_cliente_MedicaoFrente,\n" +
//                "     tab_cliente.`MedicaoFundos` AS tab_cliente_MedicaoFundos,\n" +
//                "     tab_cliente.`DescricaoLD` AS tab_cliente_DescricaoLD,\n" +
//                "     tab_cliente.`DescricaoLE` AS tab_cliente_DescricaoLE,\n" +
//                "     tab_cliente.`MedicaoLD` AS tab_cliente_MedicaoLD,\n" +
//                "     tab_cliente.`MedicaoLE` AS tab_cliente_MedicaoLE,\n" +
//                "     tab_cliente.`TotalParcelado` AS tab_cliente_TotalParcelado,\n" +
//                "     tab_pedido.`DescontoEmPorcentagem` AS tab_pedido_DescontoEmPorcentagem\n" +
//                "FROM\n" +
//                "     `tab_empresa` tab_empresa,\n" +
//                "     `tab_pedido` tab_pedido,\n" +
//                "     `tab_produto_pedido` tab_produto_pedido,\n" +
//                "     `tab_cliente` tab_cliente\n" +
//                "WHERE\n" +
//                "     tab_empresa.id = '1'\n" +
//                " AND tab_pedido.id = '"+idPedido+"'\n" +
//                " and tab_produto_pedido.id_pedido = '"+idPedido+"'\n" +
//                "AND  tab_cliente.id='"+idCliente+"'";
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//                
//                //fazer salvar o pdf e guardar
//                nomeDoArquivoPdf = co.dataAtual.RetornaDataAtualSemBarra()+co.horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
//                JasperExportManager.exportReportToPdfFile(impressao,nomeDoArquivoPdf);
//                File file = new File(nomeDoArquivoPdf);
//                //Desktop.getDesktop.open(file);
//                        
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir Pedido");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//                
//                return nomeDoArquivoPdf;
//        }
//        
//        public String ImprimeOsImport (String caminhoIreport ,String IdOS, String idCliente) throws JRException , SQLException, ClassNotFoundException {
//                String nomeDoArquivoPdf = "";
//            
//                //gerando o jasper design
//                JasperDesign desenho = JRXmlLoader.load( caminhoIreport );
//
//                //compila o relatório
//                JasperReport relatorio = JasperCompileManager.compileReport( desenho );
//
//                //estabelece conexão
//                Statement stm = co.AbreConexaoBanco();
//                //String query = "select * from tab_receitamedica";
//                String query = "SELECT\n" +
//                "     tab_empresa.`id` AS tab_empresa_id,\n" +
//                "     tab_empresa.`nome` AS tab_empresa_nome,\n" +
//                "     tab_empresa.`razao` AS tab_empresa_razao,\n" +
//                "     tab_empresa.`endereco` AS tab_empresa_endereco,\n" +
//                "     tab_empresa.`numero` AS tab_empresa_numero,\n" +
//                "     tab_empresa.`bairro` AS tab_empresa_bairro,\n" +
//                "     tab_empresa.`cidade` AS tab_empresa_cidade,\n" +
//                "     tab_empresa.`estado` AS tab_empresa_estado,\n" +
//                "     tab_empresa.`cep` AS tab_empresa_cep,\n" +
//                "     tab_empresa.`cnpj` AS tab_empresa_cnpj,\n" +
//                "     tab_empresa.`insc_estadual` AS tab_empresa_insc_estadual,\n" +
//                "     tab_empresa.`telefone_fixo` AS tab_empresa_telefone_fixo,\n" +
//                "     tab_empresa.`data_nascimento` AS tab_empresa_data_nascimento,\n" +
//                "     tab_empresa.`telefone_movel` AS tab_empresa_telefone_movel,\n" +
//                "     tab_empresa.`perfil` AS tab_empresa_perfil,\n" +
//                "     tab_empresa.`provedorEmail` AS tab_empresa_provedorEmail,\n" +
//                "     tab_empresa.`EmailDeEnvio` AS tab_empresa_EmailDeEnvio,\n" +
//                "     tab_empresa.`SenhaEmail` AS tab_empresa_SenhaEmail,\n" +
//                "     tab_empresa.`email` AS tab_empresa_email,\n" +
//                "     tab_empresa.`celular` AS tab_empresa_celular,\n" +
//                "     tab_cliente.`id` AS tab_cliente_id,\n" +
//                "     tab_cliente.`nome` AS tab_cliente_nome,\n" +
//                "     tab_cliente.`endereco` AS tab_cliente_endereco,\n" +
//                "     tab_cliente.`bairro` AS tab_cliente_bairro,\n" +
//                "     tab_cliente.`cidade` AS tab_cliente_cidade,\n" +
//                "     tab_cliente.`estado` AS tab_cliente_estado,\n" +
//                "     tab_cliente.`cep` AS tab_cliente_cep,\n" +
//                "     tab_cliente.`cnpj` AS tab_cliente_cnpj,\n" +
//                "     tab_cliente.`telefone` AS tab_cliente_telefone,\n" +
//                "     tab_cliente.`numero` AS tab_cliente_numero,\n" +
//                "     tab_cliente.`observacao` AS tab_cliente_observacao,\n" +
//                "     tab_cliente.`matricula` AS tab_cliente_matricula,\n" +
//                "     tab_cliente.`email` AS tab_cliente_email,\n" +
//                "     tab_cliente.`apto` AS tab_cliente_apto,\n" +
//                "     tab_cliente.`pai` AS tab_cliente_pai,\n" +
//                "     tab_cliente.`mae` AS tab_cliente_mae,\n" +
//                "     tab_cliente.`tel_trabalho` AS tab_cliente_tel_trabalho,\n" +
//                "     tab_cliente.`data_nascimento` AS tab_cliente_data_nascimento,\n" +
//                "     tab_cliente.`codigo_municipio` AS tab_cliente_codigo_municipio,\n" +
//                "     tab_cliente.`insc_estadual` AS tab_cliente_insc_estadual,\n" +
//                "     tab_cliente.`descricaoContrato` AS tab_cliente_descricaoContrato,\n" +
//                "     tab_cliente.`valorInstalacao` AS tab_cliente_valorInstalacao,\n" +
//                "     tab_cliente.`valorMensalidade` AS tab_cliente_valorMensalidade,\n" +
//                "     tab_cliente.`numeroDeMensalidades` AS tab_cliente_numeroDeMensalidades,\n" +
//                "     tab_cliente.`vencimentoMensalidade` AS tab_cliente_vencimentoMensalidade,\n" +
//                "     tab_cliente.`celular` AS tab_cliente_celular,\n" +
//                "     tab_cliente.`razao` AS tab_cliente_razao,\n" +
//                "     tab_ordem_de_servico.`id` AS tab_ordem_de_servico_id,\n" +
//                "     tab_ordem_de_servico.`NomeCliente` AS tab_ordem_de_servico_NomeCliente,\n" +
//                "     tab_ordem_de_servico.`IDCliente` AS tab_ordem_de_servico_IDCliente,\n" +
//                "     tab_ordem_de_servico.`CPFCliente` AS tab_ordem_de_servico_CPFCliente,\n" +
//                "     tab_ordem_de_servico.`TelefoneCliente` AS tab_ordem_de_servico_TelefoneCliente,\n" +
//                "     tab_ordem_de_servico.`Responsavel` AS tab_ordem_de_servico_Responsavel,\n" +
//                "     tab_ordem_de_servico.`IdOrdemServico` AS tab_ordem_de_servico_IdOrdemServico,\n" +
//                "     tab_ordem_de_servico.`Motivo` AS tab_ordem_de_servico_Motivo,\n" +
//                "     tab_ordem_de_servico.`Status` AS tab_ordem_de_servico_Status,\n" +
//                "     tab_ordem_de_servico.`NomeEquipamento` AS tab_ordem_de_servico_NomeEquipamento,\n" +
//                "     tab_ordem_de_servico.`AcessoriosEquipamento` AS tab_ordem_de_servico_AcessoriosEquipamento,\n" +
//                "     tab_ordem_de_servico.`DataInclusao` AS tab_ordem_de_servico_DataInclusao,\n" +
//                "     tab_ordem_de_servico.`DataAlteracao` AS tab_ordem_de_servico_DataAlteracao,\n" +
//                "     tab_ordem_de_servico.`DataConclusao` AS tab_ordem_de_servico_DataConclusao,\n" +
//                "     tab_ordem_de_servico.`RelatoCliente` AS tab_ordem_de_servico_RelatoCliente,\n" +
//                "     tab_ordem_de_servico.`ObsCliente` AS tab_ordem_de_servico_ObsCliente,\n" +
//                "     tab_ordem_de_servico.`ServicoEfetuado` AS tab_ordem_de_servico_ServicoEfetuado,\n" +
//                "     tab_ordem_de_servico.`ObsServico` AS tab_ordem_de_servico_ObsServico,\n" +
//                "     tab_ordem_de_servico.`ValorServico` AS tab_ordem_de_servico_ValorServico,\n" +
//                "     tab_ordem_de_servico.`ValorTotalProdutos` AS tab_ordem_de_servico_ValorTotalProdutos,\n" +
//                "     tab_ordem_de_servico.`ValorTotalGeral` AS tab_ordem_de_servico_ValorTotalGeral,\n" +
//                "     tab_ordem_de_servico.`FormaPagamento` AS tab_ordem_de_servico_FormaPagamento,\n" +
//                "     tab_ordem_de_servico.`DataPagamento` AS tab_ordem_de_servico_DataPagamento,\n" +
//                "     tab_ordem_de_servico.`ObsPagamento` AS tab_ordem_de_servico_ObsPagamento,\n" +
//                "     tab_ordem_de_servico.`NumeroDeSerie` AS tab_ordem_de_servico_NumeroDeSerie,\n" +
//                "     tab_ordem_de_servico.`Marca` AS tab_ordem_de_servico_Marca,\n" +
//                "     tab_ordem_de_servico.`Modelo` AS tab_ordem_de_servico_Modelo,\n" +
//                "     tab_ordem_de_servico.`NumeroNF` AS tab_ordem_de_servico_NumeroNF,\n" +
//                "     tab_ordem_de_servico.`DataDaCompra` AS tab_ordem_de_servico_DataDaCompra,\n" +
//                "     tab_ordem_de_servico.`DataInclusaoSemBarra` AS tab_ordem_de_servico_DataInclusaoSemBarra,\n" +
//                "     tab_ordem_de_servico.`Integrado` AS tab_ordem_de_servico_Integrado,\n" +
//                "     tab_ordem_de_servico.`DataIntegracao` AS tab_ordem_de_servico_DataIntegracao,\n" +
//                "     tab_ordem_de_servico.`NomeComputador` AS tab_ordem_de_servico_NomeComputador,\n" +
//                "     tab_produto_ordem_de_servico.`id` AS tab_produto_ordem_de_servico_id,\n" +
//                "     tab_produto_ordem_de_servico.`id_ordem_de_servico` AS tab_produto_ordem_de_servico_id_ordem_de_servico,\n" +
//                "     tab_produto_ordem_de_servico.`cod_produto` AS tab_produto_ordem_de_servico_cod_produto,\n" +
//                "     tab_produto_ordem_de_servico.`produto` AS tab_produto_ordem_de_servico_produto,\n" +
//                "     tab_produto_ordem_de_servico.`preco` AS tab_produto_ordem_de_servico_preco,\n" +
//                "     tab_produto_ordem_de_servico.`quantidade_pedido` AS tab_produto_ordem_de_servico_quantidade_pedido,\n" +
//                "     tab_produto_ordem_de_servico.`desconto_unitario` AS tab_produto_ordem_de_servico_desconto_unitario,\n" +
//                "     tab_produto_ordem_de_servico.`Integrado` AS tab_produto_ordem_de_servico_Integrado,\n" +
//                "     tab_produto_ordem_de_servico.`DataIntegracao` AS tab_produto_ordem_de_servico_DataIntegracao,\n" +
//                "     tab_cliente.`Integrado` AS tab_cliente_Integrado,\n" +
//                "     tab_cliente.`DataIntegracao` AS tab_cliente_DataIntegracao,\n" +
//                "     tab_cliente.`Profissao` AS tab_cliente_Profissao,\n" +
//                "     tab_cliente.`Sexo` AS tab_cliente_Sexo,\n" +
//                "     tab_cliente.`RendaFamiliar` AS tab_cliente_RendaFamiliar,\n" +
//                "     tab_cliente.`Vendedor` AS tab_cliente_Vendedor,\n" +
//                "     tab_cliente.`Loteamento` AS tab_cliente_Loteamento,\n" +
//                "     tab_cliente.`EnderecoLoteamento` AS tab_cliente_EnderecoLoteamento,\n" +
//                "     tab_cliente.`RegistroLoteamento` AS tab_cliente_RegistroLoteamento,\n" +
//                "     tab_cliente.`Quadra` AS tab_cliente_Quadra,\n" +
//                "     tab_cliente.`Lote` AS tab_cliente_Lote,\n" +
//                "     tab_cliente.`NumeroContrato` AS tab_cliente_NumeroContrato,\n" +
//                "     tab_cliente.`Area` AS tab_cliente_Area,\n" +
//                "     tab_cliente.`Medicoes` AS tab_cliente_Medicoes,\n" +
//                "     tab_cliente.`ValorDaCompra` AS tab_cliente_ValorDaCompra,\n" +
//                "     tab_cliente.`ValorEntrada` AS tab_cliente_ValorEntrada,\n" +
//                "     tab_cliente.`PrimeiraParcela` AS tab_cliente_PrimeiraParcela,\n" +
//                "     tab_cliente.`SegundaParcela` AS tab_cliente_SegundaParcela,\n" +
//                "     tab_cliente.`TerceiraParcela` AS tab_cliente_TerceiraParcela,\n" +
//                "     tab_cliente.`QuartaParcela` AS tab_cliente_QuartaParcela,\n" +
//                "     tab_cliente.`QuantidadeDeParcelas` AS tab_cliente_QuantidadeDeParcelas,\n" +
//                "     tab_cliente.`ValorDaParcela` AS tab_cliente_ValorDaParcela,\n" +
//                "     tab_cliente.`DiaVencimento` AS tab_cliente_DiaVencimento,\n" +
//                "     tab_cliente.`SituacaoPagamento` AS tab_cliente_SituacaoPagamento,\n" +
//                "     tab_cliente.`DataContrato` AS tab_cliente_DataContrato,\n" +
//                "     tab_cliente.`EstadoCivil` AS tab_cliente_EstadoCivil,\n" +
//                "     tab_cliente.`RuaCobranca` AS tab_cliente_RuaCobranca,\n" +
//                "     tab_cliente.`NumeroCobranca` AS tab_cliente_NumeroCobranca,\n" +
//                "     tab_cliente.`BairroCobranca` AS tab_cliente_BairroCobranca,\n" +
//                "     tab_cliente.`CidadeCobranca` AS tab_cliente_CidadeCobranca,\n" +
//                "     tab_cliente.`UfCobranca` AS tab_cliente_UfCobranca,\n" +
//                "     tab_cliente.`CEPCobranca` AS tab_cliente_CEPCobranca,\n" +
//                "     tab_cliente.`NomeConjugue` AS tab_cliente_NomeConjugue,\n" +
//                "     tab_cliente.`IdentidadeConjugue` AS tab_cliente_IdentidadeConjugue,\n" +
//                "     tab_cliente.`ProfissaoConjugue` AS tab_cliente_ProfissaoConjugue,\n" +
//                "     tab_cliente.`NascimentoConjugue` AS tab_cliente_NascimentoConjugue,\n" +
//                "     tab_cliente.`CPFConjugue` AS tab_cliente_CPFConjugue,\n" +
//                "     tab_cliente.`dataInicioDaUtilizacaoDoSistema` AS tab_cliente_dataInicioDaUtilizacaoDoSistema,\n" +
//                "     tab_cliente.`Perfil` AS tab_cliente_Perfil,\n" +
//                "     tab_cliente.`Graduacao` AS tab_cliente_Graduacao,\n" +
//                "     tab_cliente.`QuantidadeDeGraus` AS tab_cliente_QuantidadeDeGraus,\n" +
//                "     tab_cliente.`Tipo` AS tab_cliente_Tipo,\n" +
//                "     tab_cliente.`Idade` AS tab_cliente_Idade,\n" +
//                "     tab_cliente.`Nacionalidade` AS tab_cliente_Nacionalidade,\n" +
//                "     tab_cliente.`NacionalidadeConugue` AS tab_cliente_NacionalidadeConugue,\n" +
//                "     tab_cliente.`TelefoneConjugue` AS tab_cliente_TelefoneConjugue,\n" +
//                "     tab_cliente.`ValorDaCompraPorExtenso` AS tab_cliente_ValorDaCompraPorExtenso,\n" +
//                "     tab_cliente.`DataDoContratoPorExtenso` AS tab_cliente_DataDoContratoPorExtenso,\n" +
//                "     tab_cliente.`DescricaoFrente` AS tab_cliente_DescricaoFrente,\n" +
//                "     tab_cliente.`DescricaoFundos` AS tab_cliente_DescricaoFundos,\n" +
//                "     tab_cliente.`MedicaoFrente` AS tab_cliente_MedicaoFrente,\n" +
//                "     tab_cliente.`MedicaoFundos` AS tab_cliente_MedicaoFundos,\n" +
//                "     tab_cliente.`DescricaoLD` AS tab_cliente_DescricaoLD,\n" +
//                "     tab_cliente.`DescricaoLE` AS tab_cliente_DescricaoLE,\n" +
//                "     tab_cliente.`MedicaoLD` AS tab_cliente_MedicaoLD,\n" +
//                "     tab_cliente.`MedicaoLE` AS tab_cliente_MedicaoLE,\n" +
//                "     tab_cliente.`TotalParcelado` AS tab_cliente_TotalParcelado,\n" +
//                "     tab_cliente.`StatusCadastro` AS tab_cliente_StatusCadastro\n" +
//                "FROM\n" +
//                "     `tab_empresa` tab_empresa,\n" +
//                "     `tab_cliente` tab_cliente,\n" +
//                "     `tab_ordem_de_servico` tab_ordem_de_servico,\n" +
//                "     `tab_produto_ordem_de_servico` tab_produto_ordem_de_servico\n" +
//                "WHERE\n" +
//                "     tab_empresa.id = '1'\n" +
//                " AND tab_ordem_de_servico.id = '"+IdOS+"'\n" +
//                " AND tab_produto_ordem_de_servico.id_ordem_de_servico = '"+IdOS+"'\n" +
//                " AND tab_cliente.id = '"+idCliente+"'";
//                
//                
//                ResultSet rs = stm.executeQuery( query );
//
//                //implementação da interface JRDataSource para DataSource ResultSet
//                JRResultSetDataSource jrRS = new JRResultSetDataSource( rs );
//
//                //executa o relatório
//                Map parametros = new HashMap();
//                parametros.put("nota", new Double(10));
//                JasperPrint impressao = JasperFillManager.fillReport( relatorio , parametros, jrRS );
//                
//                //fazer salvar o pdf e guardar
//                nomeDoArquivoPdf = co.dataAtual.RetornaDataAtualSemBarra()+co.horaAtual.RetornaHoraAtualHoraMinutoSegundoSemPontos()+".pdf";
//                JasperExportManager.exportReportToPdfFile(impressao,nomeDoArquivoPdf);
//                File file = new File(nomeDoArquivoPdf);
//                //Desktop.getDesktop.open(file);
//                        
//                //exibe o resultado
//                JasperViewer viewer = new JasperViewer( impressao , false );
//                viewer.setTitle("Imprimir OS");
//                URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//                Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//                viewer.setIconImage(imagemTitulo);
//                viewer.setZoomRatio(0.75f);
//                viewer.show();
//                
//                return nomeDoArquivoPdf;
//        }
//        
//    
}
