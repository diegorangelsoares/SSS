/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.View;

import br.com.sss.Control.ControllerArquivo;
import br.com.sss.Control.ControllerGeral;
import br.com.sss.Control.GeraData;
import br.com.sss.Control.MensagemErro;
import br.com.sss.Control.Negocio;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

/**
 *
 * @author DIEGO
 */
public class JanelaConsultaErros extends javax.swing.JInternalFrame {

    JanelaDesignNimbus janelaDesign = new JanelaDesignNimbus();
    MensagemErro mensagemErro = new MensagemErro();
    ControllerArquivo arquivo  = new ControllerArquivo();
    Negocio negocio = new Negocio();
    GeraData geraData = new GeraData();
    
    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaConsultaErros() {
        initComponents();
        super.setTitle("DSistema");
        super.setResizable(false);
        //super.setLocationRelativeTo(null);
        
        arquivo.verificaSeTemArquivoNomes();
        PreencheNomes();
        negocio.preencheMesSeguienteAoIniciarJanela(this);
        
        campoBanco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                verificaBancoPreenchido();
            }
        });
        
        try {
            campoDataInicio.setDate(new SimpleDateFormat("dd/MM/yy").parse(geraData.RetornaDataAtual()));
            campoDataFim.setDate(new SimpleDateFormat("dd/MM/yy").parse(geraData.RetornaDataAtual()));
        } catch (ParseException ex) {
            //Logger.getLogger(JanelaContasAReceber.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Adicionar funcao de perder foco pra recalcular os valores de desconto
        campoUsuarioErro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                verificaUsuario();
            }
        });
        
        jTabbedPane1.setEnabledAt(0, false);
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(2, false);
        jTabbedPane1.setEnabledAt(3, true);
        jTabbedPane1.setSelectedComponent(jPanel7);
        
    }
    
    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);   
    }
    
    
    public void verificaUsuario(){
        String usuario = (String) campoUsuarioErro.getSelectedItem();
        if (usuario.equals("INFOMED") || usuario.equals("SUP_INFOMED") || usuario.equals("INFOINSTALL")){
            campoPerfilErros.setSelectedItem(" ");
            botaoPesquisaErros.requestFocus();
        }else{
            if (usuario.equals("INFO_ATEND_") || usuario.equals("TISS_ATEND_") || usuario.equals("REMOTE_ATEND_") || usuario.equals("PTU_ATEND_")){
                String perfil = (String) campoPerfilErros.getSelectedItem();
                if (perfil.equals("")){
                    campoPerfilErros.setSelectedItem("255");
                }
            }
        }
        
    }
    
    public void verificaBancoPreenchido(){
        String banc = (String) campoBanco.getSelectedItem();
        
        if (banc.equals("Oracle")){
            jLabel6.setVisible(true);
            campoServicoBanco.setVisible(true);
        }
        if (banc.equals("Mysql")){
            jLabel6.setVisible(false);
            campoServicoBanco.setVisible(false);
        }
    }
    
    public void PreencheNomes(){
        apagaDadosDaTabela(tabelaColaboradores);
        try { 
            FileReader arq = new FileReader("c:\\DSistema\\Nomes.dr");
            BufferedReader lerArq = new BufferedReader(arq);  
            String linha = lerArq.readLine();
            while (linha != null) {
                if (!linha.equals("")){
                    javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabelaColaboradores.getModel();
                    dtm.addRow(new Object[]{linha}); 
                }
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close(); 
            } catch (IOException e) { 
                //XXXXXXXXXXXXXXXnull, "Caminho do BD não encontrado ou Computador não configurado!");
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Arquivo nomes.ini não encontrato ou com problemas!", "Falta informação","erro");
            }
    }
    
    public void apagaDadosDaTabela(JTable tabela){
        //Pega o total de linhas da tabela
            int totalDeLinhas = tabela.getModel().getRowCount(); 
            javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabela.getModel();
            //Verifica se o total de linhas é zero
            if (totalDeLinhas == 0) {
                //Não existe nenhum produto na OS
            }else
            //Existe tabela e tem que percorrer pra deletar as linhas
            {
                //Enquanto total de linhas for diferente de zero a função remove a linha
                while (0 != totalDeLinhas ){                   
                    dtm.removeRow(0);
                    totalDeLinhas = totalDeLinhas -1;
                }
            }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaSorteio = new javax.swing.JTable();
        botaoSortear = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        campoMes = new javax.swing.JComboBox<>();
        campoAno = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        campoNomeColaborador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaColaboradores = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        campoEnderecoBanco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoBanco = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        campoUsuarioBanco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoSenhaBanco = new javax.swing.JPasswordField();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        campoServicoBanco = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        botaoPesquisaErros = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaErros = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        campoDataInicio = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        campoDataFim = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        campoErro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campoUsuarioErro = new javax.swing.JComboBox<>();
        campoPerfilErros = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        campoQuantidadeRegistros = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        botaoPesquisaErros1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        tabelaSorteio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia do Mês", "Dia da Semana", "Colaborador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaSorteio);
        if (tabelaSorteio.getColumnModel().getColumnCount() > 0) {
            tabelaSorteio.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaSorteio.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelaSorteio.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        botaoSortear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoSortear.setText("Sortear");
        botaoSortear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSortearActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Escolha o período", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        campoMes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO" }));

        campoAno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 0, 0));
        jButton3.setText("Sair");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoSortear, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSortear, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sorteio", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Cadastro de colaborador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        campoNomeColaborador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome");

        botaoCadastrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoExcluir.setForeground(new java.awt.Color(255, 0, 0));
        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botaoCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoExcluir))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 416, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNomeColaborador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoExcluir)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoCadastrar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tabelaColaboradores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaColaboradores);
        if (tabelaColaboradores.getColumnModel().getColumnCount() > 0) {
            tabelaColaboradores.getColumnModel().getColumn(0).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastro", jPanel2);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Configurações de BD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        campoEnderecoBanco.setText("10.20.100.23");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Endereço do Servidor");

        campoBanco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoBanco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oracle", "Mysql" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("BD");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Salvar");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Usuário");

        campoUsuarioBanco.setText("sup_infomed");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Senha");

        campoSenhaBanco.setText("gps$$$");

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Teste");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Serviço");

        campoServicoBanco.setText("ATEND");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addComponent(campoEnderecoBanco)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoUsuarioBanco, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSenhaBanco)
                    .addComponent(campoServicoBanco, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoEnderecoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoUsuarioBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoSenhaBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoServicoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Configuração", jPanel5);

        botaoPesquisaErros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoPesquisaErros.setText("Consulta");
        botaoPesquisaErros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisaErrosActionPerformed(evt);
            }
        });

        tabelaErros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Usuário", "Erro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabelaErros);
        if (tabelaErros.getColumnModel().getColumnCount() > 0) {
            tabelaErros.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaErros.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelaErros.getColumnModel().getColumn(2).setPreferredWidth(400);
        }

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        campoDataInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("à");

        campoDataFim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Usuário");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Erro");

        campoUsuarioErro.setEditable(true);
        campoUsuarioErro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "INFO_ATEND_", "TISS_ATEND_", "REMOTE_ATEND_", "PTU_ATEND_", "SUP_INFOMED", "INFOINSTALL" }));

        campoPerfilErros.setEditable(true);
        campoPerfilErros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "255", "266", "974", "460", "461", "462" }));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Perfil");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addComponent(campoUsuarioErro, 0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(campoPerfilErros, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(campoErro, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDataFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoErro)
                    .addComponent(jLabel27)
                    .addComponent(campoUsuarioErro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoPerfilErros)))
        );

        campoQuantidadeRegistros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        campoQuantidadeRegistros.setModel(new javax.swing.SpinnerNumberModel(20, 1, 40, 1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Quantidade de registros");

        botaoPesquisaErros1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoPesquisaErros1.setText("Sair");
        botaoPesquisaErros1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisaErros1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoPesquisaErros1)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(botaoPesquisaErros)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoQuantidadeRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane4)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoPesquisaErros)
                    .addComponent(campoQuantidadeRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoPesquisaErros1)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta Erros", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        //apagaDadosDaTabela(jTable);
        if (campoNomeColaborador.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Digite o nome para cadastrar!");
        
        }else{
            if (negocio.RetornaSeJaExisteNome(campoNomeColaborador.getText()) == false){
                arquivo.cadastraNoArquivo(campoNomeColaborador.getText());
                javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabelaColaboradores.getModel();
                dtm.addRow(new Object[]{campoNomeColaborador.getText()});   
                campoNomeColaborador.setText("");
            }
        }
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        int linhaSelecionada = tabelaColaboradores.getSelectedRow();
        String Nomecliente = (String) tabelaColaboradores.getValueAt(linhaSelecionada, 0);
        int[] l = tabelaColaboradores.getSelectedRows();
        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabelaColaboradores.getModel();
        for(int i = (l.length-1); i >= 0; --i){
            arquivo.removerNoArquivo(Nomecliente);
            dtm.removeRow(l[i]);
        }
        this.campoNomeColaborador.requestFocus();
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoSortearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSortearActionPerformed
        apagaDadosDaTabela(tabelaSorteio);
        Negocio negocio = new Negocio();
        String mes = (String) campoMes.getSelectedItem();
        String ano = (String) campoAno.getSelectedItem();
        int quantidadeDeDias = negocio.preencheSabadosDomingos(mes, ano,tabelaSorteio);
        ArrayList<String> nomes = arquivo.RetornaNomes();
        nomes = negocio.RetornaSorteioDosNomes(nomes);
        nomes = negocio.completaNomesComMesmaQuantidadesDeDias(quantidadeDeDias,nomes);
        int totalDeLinhas = tabelaSorteio.getModel().getRowCount();
        if (totalDeLinhas < 1){
            //sem nada na grade
        }else{
            int linha =0;
            while (linha < totalDeLinhas ){        
                tabelaSorteio.setValueAt(nomes.get(linha),linha, 2);
                linha++;
            }
            
        }
        negocio.SalvarSorteio(mes, ano, tabelaSorteio);
        
        
    }//GEN-LAST:event_botaoSortearActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (campoUsuarioBanco.getText().equals("") ||  campoSenhaBanco.getText().equals("") ||  campoEnderecoBanco.getText().equals("") || campoServicoBanco.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nenhuma campo pode ficar em branco (Caminho, usuário, senha e serviço)!");
        }else{
            ControllerGeral co = new ControllerGeral();
            String banco = (String) campoBanco.getSelectedItem();        
            co.verificaConexaoOracle(banco,"1521",campoUsuarioBanco.getText(), campoSenhaBanco.getText(), campoEnderecoBanco.getText(), campoServicoBanco.getText());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void botaoPesquisaErrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisaErrosActionPerformed
        /**
        TISS_ATEND_255
        INFOINSTALL
        INFO_ATEND_255
        SUP_INFOMED
        REMOTE_ATEND_255
        PTU_ATEND_255
         */
        verificaUsuario();
        apagaDadosDaTabela(tabelaErros);
        Date data1 = campoDataInicio.getDate();
        Date data2 = campoDataFim.getDate();
        String data11 = "";
        String data22 = "";
        ControllerGeral co = new ControllerGeral();
        if ((data1 == null) || (data2 == null)){
            //XXXXXXXXXXXXXXXXXnull, "Coloque o período de datas para visualisar!");
            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Informe o período para visualisar!", "Falta informação","erro");
        }else{
            data11 = DateFormat.getDateInstance().format(data1);
            data22 = DateFormat.getDateInstance().format(data2);
            co.consultaErros(this,data11,data22);
        }
        
    }//GEN-LAST:event_botaoPesquisaErrosActionPerformed

    private void botaoPesquisaErros1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisaErros1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botaoPesquisaErros1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaConsultaErros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaConsultaErros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaConsultaErros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaConsultaErros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaConsultaErros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoPesquisaErros;
    private javax.swing.JButton botaoPesquisaErros1;
    private javax.swing.JButton botaoSortear;
    public javax.swing.JComboBox<String> campoAno;
    public javax.swing.JComboBox<String> campoBanco;
    public com.toedter.calendar.JDateChooser campoDataFim;
    public com.toedter.calendar.JDateChooser campoDataInicio;
    public javax.swing.JTextField campoEnderecoBanco;
    public javax.swing.JTextField campoErro;
    public javax.swing.JComboBox<String> campoMes;
    private javax.swing.JTextField campoNomeColaborador;
    public javax.swing.JComboBox<String> campoPerfilErros;
    public javax.swing.JSpinner campoQuantidadeRegistros;
    public javax.swing.JPasswordField campoSenhaBanco;
    public javax.swing.JTextField campoServicoBanco;
    public javax.swing.JTextField campoUsuarioBanco;
    public javax.swing.JComboBox<String> campoUsuarioErro;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTable tabelaColaboradores;
    public javax.swing.JTable tabelaErros;
    private javax.swing.JTable tabelaSorteio;
    // End of variables declaration//GEN-END:variables
}
