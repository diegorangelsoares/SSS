

package br.com.sss.View;

import br.com.sss.Control.CaminhoImagem;
import br.com.sss.Control.Clean;
import br.com.sss.Control.Conexao;
import br.com.sss.Control.ControllerJanelaMensagens;
import br.com.sss.Control.ControllerJanelaProtocolos;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

/**
 *
 * @author Diego Rangel  
 */
public class JanelaPesquisaProtocolo extends javax.swing.JInternalFrame {

    CaminhoImagem caminhoImagemIcone = new CaminhoImagem();
    Clean limpar = new Clean();
    Conexao co = new Conexao();
    ControllerJanelaProtocolos controller = new ControllerJanelaProtocolos();
    
    /**
     * Creates new form JanelaAlteracaoProdutos
     */
    public JanelaPesquisaProtocolo() {
        initComponents();
        super.setTitle("Pesquisa Protocolos");
        super.setResizable(true);
        
        //Muda icone da Janela interna
        //setFrameIcon(new ImageIcon(this.getClass().getResource(caminhoImagemIcone.getCaminho())));
        
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setEnabledAt(1, false);
        
        //colocar barra de rolagem na tabela
        //tabelaProcotolos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
//        tabelaProcotolos.setColumnSelectionAllowed(true);  
//        tabelaProcotolos.setRowSelectionAllowed(true);
        
        
//        tabelaProcotolos.setValueAt("1264555", 0, 0);
//        tabelaProcotolos.setValueAt("Unimed", 0, 1);
//        tabelaProcotolos.setValueAt("SIB Flex", 0, 2);
//        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabelaProcotolos.getModel();
//        dtm.addRow(new Object[]{"1264555", "Unimed"}); 
        /**
        tabelaProcotolos.setValueAt("1255445", 1, 0);
        tabelaProcotolos.setValueAt("Unimed", 1, 1);
        tabelaProcotolos.setValueAt("Monitoramento TISS", 1, 2);
        * */
        
//        co.atualizaGrupoNaJanelaAlteracao(this);

        controller.alimentaOperadoras(this);
        controller.alimentaAtendentes(this);
       
    }
    
    public void TrataFuncaoPesquisar(){
        limpar.apagaDadosDaTabela(tabelaProcotolos);
        String atendente = (String) campoAtendente.getSelectedItem();
        String operadora = (String) campoOperadora.getSelectedItem();
        if (atendente == null){
            atendente = "";
        }
        if (operadora == null){
            operadora = "";
        }
        if (campoDescricao.getText().equals("") && campoMensagem.getText().equals("") && atendente.equals("") && operadora.equals("")){
            //JOptionPane.showMessageDialog(null, "Preencha algum campo para pesquisar!");
        }else{ 
            campoDescricao.setText(campoDescricao.getText().toUpperCase());
            campoMensagem.setText(campoMensagem.getText().toUpperCase());
            controller.pesquisaProtocolos(this);
            
        }
    }
    
    public void finalizaJanela(){
        super.dispose();
    }
    
    public  void selectTableCell(int row, int col) {  
        tabelaProcotolos.setRowSelectionInterval(row, row);  
        tabelaProcotolos.setColumnSelectionInterval(col, col);  
    } 
    
    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);   
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
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        campoDescricao = new javax.swing.JTextField();
        botaoPesquisar = new javax.swing.JButton();
        PainelTabelaProdutos1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProcotolos = new javax.swing.JTable();
        botaoSair = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        campoOperadora = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        campoAtendente = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        campoMensagem = new javax.swing.JTextField();
        botaoLimpar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Descrição do assunto");

        campoDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoDescricaoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoDescricaoKeyReleased(evt);
            }
        });

        botaoPesquisar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });
        botaoPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoPesquisarKeyPressed(evt);
            }
        });

        PainelTabelaProdutos1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        tabelaProcotolos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tabelaProcotolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Protocolo", "Data", "Operadora", "Resumo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProcotolos.setColumnSelectionAllowed(true);
        tabelaProcotolos.setSurrendersFocusOnKeystroke(true);
        tabelaProcotolos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProcotolosMouseClicked(evt);
            }
        });
        tabelaProcotolos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaProcotolosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProcotolos);
        tabelaProcotolos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tabelaProcotolos.getColumnModel().getColumnCount() > 0) {
            tabelaProcotolos.getColumnModel().getColumn(0).setResizable(false);
            tabelaProcotolos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaProcotolos.getColumnModel().getColumn(1).setResizable(false);
            tabelaProcotolos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabelaProcotolos.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabelaProcotolos.getColumnModel().getColumn(3).setPreferredWidth(800);
        }

        botaoSair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 51, 0));
        jLabel10.setText("Duplo clique no protocolo para ver as mensagens");

        javax.swing.GroupLayout PainelTabelaProdutos1Layout = new javax.swing.GroupLayout(PainelTabelaProdutos1);
        PainelTabelaProdutos1.setLayout(PainelTabelaProdutos1Layout);
        PainelTabelaProdutos1Layout.setHorizontalGroup(
            PainelTabelaProdutos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTabelaProdutos1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PainelTabelaProdutos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PainelTabelaProdutos1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        PainelTabelaProdutos1Layout.setVerticalGroup(
            PainelTabelaProdutos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelTabelaProdutos1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelTabelaProdutos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Operadora");

        campoOperadora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoOperadora.setSelectedItem("");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Atendente");

        campoAtendente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoAtendente.setSelectedItem("");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Trecho da Mensagem");

        campoMensagem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoMensagem.setToolTipText("Sem pesquisa por mensagens");
        campoMensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoMensagemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoMensagemKeyReleased(evt);
            }
        });

        botaoLimpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });
        botaoLimpar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoLimparKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(campoDescricao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(campoMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(campoOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(campoAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(PainelTabelaProdutos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(campoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisar)
                    .addComponent(botaoLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelTabelaProdutos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Simplificado", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1236, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Avançado", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoDescricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescricaoKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            TrataFuncaoPesquisar();
        }
    }//GEN-LAST:event_campoDescricaoKeyPressed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        TrataFuncaoPesquisar();
        
    }//GEN-LAST:event_botaoPesquisarActionPerformed

    private void botaoPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoPesquisarKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
          controller.pesquisaProtocolos(this);
        }
    }//GEN-LAST:event_botaoPesquisarKeyPressed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.setVisible(false);
        }
    }//GEN-LAST:event_jPanel2KeyPressed

    private void tabelaProcotolosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaProcotolosKeyPressed
        
                
        if(evt.getKeyCode() == evt.VK_F10){
            int linhaSelecionada = tabelaProcotolos.getSelectedRow();
            int colunaSelecinoada = tabelaProcotolos.getSelectedColumn();
            tabelaProcotolos.setValueAt(tabelaProcotolos.getValueAt(linhaSelecionada, colunaSelecinoada), linhaSelecionada+1, colunaSelecinoada);
            
            //tabelaProduto.isCellSelected(linhaSelecionada +3, colunaSelecinoada);
            tabelaProcotolos.requestFocus();
            tabelaProcotolos.setColumnSelectionAllowed(true);  
            tabelaProcotolos.setRowSelectionAllowed(true);  
            tabelaProcotolos.setRowSelectionInterval(linhaSelecionada+1, linhaSelecionada+1);  
            tabelaProcotolos.setColumnSelectionInterval(colunaSelecinoada, colunaSelecinoada); 
            
            /**
            //Seleciona a coluna do meio 
            j.tabelaAgenda.setColumnSelectionAllowed(true);  
            j.tabelaAgenda.setRowSelectionAllowed(true);  
            j.tabelaAgenda.setRowSelectionInterval(0, 0);  
            j.tabelaAgenda.setColumnSelectionInterval(4, 4); 
            */ 
        }
    }//GEN-LAST:event_tabelaProcotolosKeyPressed

    private void tabelaProcotolosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProcotolosMouseClicked
        if (evt.getClickCount() == 2) {
            //JOptionPane.showMessageDialog(null, "Clicou 2 vezes!");
            int linhaSelecionada = tabelaProcotolos.getSelectedRow();
            int colunaSelecionada = 0;
            String Protocolo = (String) tabelaProcotolos.getValueAt(linhaSelecionada, colunaSelecionada);
            //JOptionPane.showMessageDialog(null, "Pegou valor da coluna: "+colunaSelecionada+" Linha: "+linhaSelecionada + " Exibis mensagens do protocolo "+Protocolo);
            if(!Protocolo.equals("")){
                //JOptionPane.showMessageDialog(null, "Criando Janela");
                JanelaMensagens Jpg = new JanelaMensagens(null, rootPaneCheckingEnabled);
                //JOptionPane.showMessageDialog(null, "Janela criada");
                Jpg.campoProtocolo.setText(Protocolo);
                ControllerJanelaMensagens controllerJanelaMensagens = new ControllerJanelaMensagens();
                //JOptionPane.showMessageDialog(null, "Alimentadno as mensagens da Janela");
                controllerJanelaMensagens.preencheMensagensDoProtocolo(Jpg,Protocolo);
                //JOptionPane.showMessageDialog(null, "Abrindo Janela");
                Jpg.show();
            }else{
                JOptionPane.showMessageDialog(null, "Sem Mensagens!");
                        
            }
        }
        
    }//GEN-LAST:event_tabelaProcotolosMouseClicked

    private void campoMensagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMensagemKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            TrataFuncaoPesquisar();
        }
    }//GEN-LAST:event_campoMensagemKeyPressed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        campoDescricao.setText("");
        campoMensagem.setText("");
        campoOperadora.setSelectedItem("");
        campoAtendente.setSelectedItem("");
        limpar.apagaDadosDaTabela(tabelaProcotolos);
        campoDescricao.requestFocus();
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void botaoLimparKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoLimparKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoLimparKeyPressed

    private void campoDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescricaoKeyReleased
        TrataFuncaoPesquisar();
    }//GEN-LAST:event_campoDescricaoKeyReleased

    private void campoMensagemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoMensagemKeyReleased
        TrataFuncaoPesquisar();
    }//GEN-LAST:event_campoMensagemKeyReleased

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
            java.util.logging.Logger.getLogger(JanelaPesquisaProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPesquisaProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPesquisaProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPesquisaProtocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPesquisaProtocolo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel PainelTabelaProdutos1;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoSair;
    public javax.swing.JComboBox campoAtendente;
    public javax.swing.JTextField campoDescricao;
    public javax.swing.JTextField campoMensagem;
    public javax.swing.JComboBox campoOperadora;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JTable tabelaProcotolos;
    // End of variables declaration//GEN-END:variables
}
