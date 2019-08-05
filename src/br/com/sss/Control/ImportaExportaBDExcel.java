
package br.com.sss.Control;

import br.com.sss.View.JanelaConfiguracao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Rangel  
 */
public class ImportaExportaBDExcel {
    
    public Clean limpar = new Clean();
    public Cabecalho te = new Cabecalho();
    public String Driver = "com.mysql.jdbc.Driver";
    public String url = "jdbc:mysql://localhost:3309/receitas"; 
    public String usuario = "root";
    public String senha = "123456";
    GeraTXT GeradorTXT = new GeraTXT();

    public void ImportarExcelParaMysql(String nomeDoArquivo, String nomeDaTabela, String NomeDasColunasDaTabela){       
                    
                    try {  
                    // Ler o JDBC driver  
                    String driverName = Driver; // MySQL MM JDBC driver  
                    Class.forName(driverName);       
                    // Cria uma conexão com o banco  
                    Connection con = DriverManager.getConnection(url,usuario,senha);
                    Statement stmt = con.createStatement();       //objeto comdo sql
                    //Executa o comando sql para inserção no BD
                    String sql = "LOAD DATA LOCAL INFILE 'C:\\"+nomeDoArquivo+".csv' "
                            +    "INTO TABLE "+nomeDaTabela+" "
                            +    "FIELDS TERMINATED BY ';' "
                            //+    "LINES TERMINATED BY ' \r \n ' "
                            +    "LINES TERMINATED BY  "
                            +    NomeDasColunasDaTabela;
                    stmt.executeUpdate(sql);                   
                    JOptionPane.showMessageDialog( null, "Sql importado com Sucesso!");
                    con.close();  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        GeradorTXT.GeraTxtDeErro("Erro Cmdo SQL " + e.getMessage()+" Ao ImportarExcelParaMysql");
                        JOptionPane.showMessageDialog(null, "Erro - Contate o desenvolvedor!");
                    } catch( ClassNotFoundException e){      //trata erros de conexão
                        JOptionPane.showMessageDialog( null, " Driver não encontrado " );
                    }
    }
    
    public void ImportarExcelParaMysqlCodigoMunicipio(){       
                    
                    try {  
                    // Ler o JDBC driver  
                    String driverName = Driver; // MySQL MM JDBC driver  
                    Class.forName(driverName);       
                    // Cria uma conexão com o banco  
                    Connection con = DriverManager.getConnection(url,usuario,senha);
                    Statement stmt = con.createStatement();       //objeto comdo sql
                    //Executa o comando sql para inserção no BD
                    String sql = "LOAD DATA LOCAL INFILE 'C:\\codigo_municipio.csv' "
                            +    "INTO TABLE tab_codigo_municipio "
                            +    "FIELDS TERMINATED BY ';' "
                            //+    "LINES TERMINATED BY ' \r \n ' "
                            +    "LINES TERMINATED BY  '\\r\\n' (cidade, estado, codigo_municipio)";
                    stmt.executeUpdate(sql);                   
                    JOptionPane.showMessageDialog( null, "Sql importado com Sucesso!");
                    con.close();  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        GeradorTXT.GeraTxtDeErro("Erro Cmdo SQL " + e.getMessage()+" Ao ImportarExcelParaMysqlCodigoMunicipio");
                        JOptionPane.showMessageDialog(null, "Erro - Contate o desenvolvedor!");
                    } catch( ClassNotFoundException e){      //trata erros de conexão
                        JOptionPane.showMessageDialog( null, " Driver não encontrado " );
                    }
    }
    
    public void ImportarExcelParaMysqlCID(){       
                    
                    try {  
                    // Ler o JDBC driver  
                    String driverName = Driver; // MySQL MM JDBC driver  
                    Class.forName(driverName);       
                    // Cria uma conexão com o banco  
                    Connection con = DriverManager.getConnection(url,usuario,senha);
                    Statement stmt = con.createStatement();       //objeto comdo sql
                    //Executa o comando sql para inserção no BD
                    String sql = "LOAD DATA LOCAL INFILE 'C:\\TABELA_CID.csv' "
                            +    "INTO TABLE tab_cid "
                            +    "FIELDS TERMINATED BY ';' "
                            //+    "LINES TERMINATED BY ' \r \n ' "
                            +    "LINES TERMINATED BY  '\\r\\n' (cid,descricao,descrabrev)";
                    stmt.executeUpdate(sql);                   
                    JOptionPane.showMessageDialog( null, "Sql importado com Sucesso!");
                    con.close();  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        GeradorTXT.GeraTxtDeErro("Erro Cmdo SQL " + e.getMessage()+" Ao ImportarExcelParaMysqlCodigoMunicipio");
                        JOptionPane.showMessageDialog(null, "Erro - Contate o desenvolvedor!");
                    } catch( ClassNotFoundException e){      //trata erros de conexão
                        JOptionPane.showMessageDialog( null, " Driver não encontrado " );
                    }
    }
    
    public void ImportarExcelParaMysqlMedicamentos(){       
                    
                    try {  
                    // Ler o JDBC driver  
                    String driverName = Driver; // MySQL MM JDBC driver  
                    Class.forName(driverName);       
                    // Cria uma conexão com o banco  
                    Connection con = DriverManager.getConnection(url,usuario,senha);
                    Statement stmt = con.createStatement();       //objeto comdo sql
                    //Executa o comando sql para inserção no BD
                    String sql = "LOAD DATA LOCAL INFILE 'C:\\procedimentos.csv' "
                            +    "INTO TABLE tab_procedimento "
                            +    "FIELDS TERMINATED BY ';' "
                            +    "LINES TERMINATED BY  '\\r\\n' (procedimento ,preco)";
                    stmt.executeUpdate(sql);                   
                    JOptionPane.showMessageDialog( null, "Sql importado com Sucesso!");
                    con.close();  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        GeradorTXT.GeraTxtDeErro("Erro Cmdo SQL " + e.getMessage()+" Ao ImportarExcelParaMysqlMedicamentos");
                        JOptionPane.showMessageDialog(null, "Erro - Contate o desenvolvedor!");
                    } catch( ClassNotFoundException e){      //trata erros de conexão
                        JOptionPane.showMessageDialog( null, " Driver não encontrado " );
                    }
    }
    
    public void ImportarBancoDeDados(){       
                    
                    try {  
                    // Ler o JDBC driver  
                    String driverName = Driver; // MySQL MM JDBC driver  
                    Class.forName(driverName);       
                    // Cria uma conexão com o banco  
                    Connection con = DriverManager.getConnection(url,usuario,senha);
                    Statement stmt = con.createStatement();       //objeto comdo sql
                    //Executa o comando sql para inserção no BD
                    String sql = "LOAD DATA LOCAL INFILE 'C:\\PRODUTOS_JACOB.csv' "
                            +    "INTO TABLE tab_produto "
                            +    "FIELDS TERMINATED BY ';' "
                            //+    "LINES TERMINATED BY ' \r \n ' "
                            +    "LINES TERMINATED BY  '\\r\\n' (id,  codigo,  produto,  preco_fornecedor,  preco_tabela,  margem_tabela,  preco_custo_medio,  minimo_vitrine,  quantidade_estoque,sugestao_preco,lucro)";
                                        
                    stmt.executeUpdate(sql);                   
                    JOptionPane.showMessageDialog( null, "Sql importado com Sucesso!");
                    con.close();  // fecha conexão com BD
                    }  catch( SQLException e){ //trata os erros SQL
                        GeradorTXT.GeraTxtDeErro("Erro Cmdo SQL " + e.getMessage()+" Ao ImportarBancoDeDados");
                        JOptionPane.showMessageDialog(null, "Erro - Contate o desenvolvedor!");
                    } catch( ClassNotFoundException e){      //trata erros de conexão
                        JOptionPane.showMessageDialog( null, " Driver não encontrado " );
                    }
    }
    
    
    

}
