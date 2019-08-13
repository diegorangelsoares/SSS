package br.com.sss.View;

import br.com.sss.model.Empresa;
import br.com.sss.Control.CaminhoImagem;
import br.com.sss.Control.Conexao;
import br.com.sss.Control.GeraData;
import br.com.sss.Control.GeradorPDF;
import br.com.sss.Control.ZiparPasta;
import br.com.sss.Control.MensagemErro;
import br.com.sss.EMail.DrMail;
//import com.itextpdf.text.DocumentException;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Rangel  
 */

public class JanelaRelatoriosGerais extends javax.swing.JInternalFrame {

    CaminhoImagem caminhoImagemIcone = new CaminhoImagem();
    GeradorPDF geraPDF = new GeradorPDF();
    GeraData dataAtual = new GeraData();
    Conexao co = new Conexao();
    GeradorPDF geradorPDFFull = new GeradorPDF();
    ZiparPasta ziparPasta = new ZiparPasta();
    DrMail enviaEmail = new DrMail();
    MensagemErro mensagemErro = new MensagemErro();
    
    /**
     * Creates new form JanelaRelatoriosGerais
     */
    
    public JanelaRelatoriosGerais() {
        initComponents();
        super.setTitle("Relatórios");
        super.setResizable(true);
        //super.setLocationRelativeTo(null);
        //Verifica o caminho do banco de dados salvo no caminhoBD.txt
        co.VerificaCaminhoDoBancoDeDados(co);
        
        //Muda icone da Janela interna
        setFrameIcon(new ImageIcon(this.getClass().getResource(caminhoImagemIcone.getCaminho())));
                
//        ButtonGroup grupo = new ButtonGroup(); 
//        grupo.add(caixaMarcarPendente);
//        grupo.add(caixaMarcarConcluido);
//        caixaMarcarConcluido.setSelected(true);
//        
//        ButtonGroup grupoRelatorio = new ButtonGroup(); 
//        grupoRelatorio.add(caixaMarcarTodosProdutos);
//        grupoRelatorio.add(caixaMarcarTodosPrecoMaisEstoque);
//        caixaMarcarTodosProdutos.setSelected(true);
//        
//        ButtonGroup grupoReceber = new ButtonGroup(); 
//        grupoReceber.add(caixaMarcarReceberEmAberta);
//        grupoReceber.add(caixaMarcarReceberRecebida);
//        grupoReceber.add(caixaMarcarReceberCancelada);
//        grupoReceber.add(caixaMarcarReceberTodas);
//        caixaMarcarReceberEmAberta.setSelected(true);
//        
//        ButtonGroup grupoPagar = new ButtonGroup(); 
//        grupoPagar.add(caixaMarcarPagarEmAberta);
//        grupoPagar.add(caixaMarcarPagarPago);
//        grupoPagar.add(caixaMarcarPagarCancelada);
//        grupoPagar.add(caixaMarcarPagarTodas);
//        caixaMarcarPagarEmAberta.setSelected(true);
//        
//        ButtonGroup grupoConsulta = new ButtonGroup(); 
//        grupoConsulta.add(caixaMarcarMarcada);
//        grupoConsulta.add(caixaMarcarEmAberto);
//        grupoConsulta.add(caixaMarcarCancelada);
//        grupoConsulta.add(caixaMarcarConsultaConcluida);
//        grupoConsulta.add(caixaMarcarTodas);
//        caixaMarcarConsultaConcluida.setSelected(true);
//        
//        campoDataInicioNFE.setDateFormatString("dd/MM/yy");
//        campoDataFimNFE.setDateFormatString("dd/MM/yy");
//        
//        campoDataInicioVendas.setDateFormatString("dd/MM/yy");
//        campoDataFimVendas.setDateFormatString("dd/MM/yy");
//        campoDataInicioVendasComissao.setDateFormatString("dd/MM/yy");
//        campoDataFimVendasComissao.setDateFormatString("dd/MM/yy");
//        campoDataInicioVendas1.setDateFormatString("dd/MM/yy");
//        campoDataFimVendas1.setDateFormatString("dd/MM/yy");
//        campoDataInicioVendas2.setDateFormatString("dd/MM/yy");
//        campoDataFimVendas2.setDateFormatString("dd/MM/yy");
//        campoDataInicioVendas3.setDateFormatString("dd/MM/yy");
//        campoDataFimVendas3.setDateFormatString("dd/MM/yy");
//        campoDataInicioVendas4.setDateFormatString("dd/MM/yy");
//        campoDataFimVendas4.setDateFormatString("dd/MM/yy");
//        campoDataInicioVendasComissao1.setDateFormatString("dd/MM/yy");
//        campoDataFimVendasComissao1.setDateFormatString("dd/MM/yy");
//        campoDataPesquisa1.setDateFormatString("dd/MM/yy");
//        campoDataPesquisa2.setDateFormatString("dd/MM/yy");
//        
//        campoDataInicioVendas5.setDateFormatString("dd/MM/yy");
//        campoDataFimVendas5.setDateFormatString("dd/MM/yy");
        
        /**
         * 
        guias
        0 - clientes
        1 - produtos
        2 - Fornecedores
        3 - Usuarios
        4 - Vendas
        5 - Receber
        6 - Pagar
        7 - OS
        8 - Fluxo financeiro
        9 - diversos
        10 - consultas 
        
         */
        
//        campoAno.setSelectedItem(dataAtual.RetornaAnoAtualYYYY());
        
        
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

        jPanel1 = new javax.swing.JPanel();
        AbaPrincipal = new javax.swing.JTabbedPane();
        painelCliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        caixaMarcarTodosCliente = new javax.swing.JCheckBox();
        botaoVisualizarRelatorioCliente = new javax.swing.JButton();
        botaoVisualizarRelatorioCliente1 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        campoMesAniversario = new javax.swing.JComboBox();
        painelUsuario = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        caixaMarcarTodosUsuarios = new javax.swing.JCheckBox();
        botaoVisualizarUsuarios = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        AbaPrincipal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AbaPrincipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AbaPrincipalKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatórios relacionado a clientes");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        caixaMarcarTodosCliente.setText("Relação completa");

        botaoVisualizarRelatorioCliente.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        botaoVisualizarRelatorioCliente.setText("Visualizar Relação");
        botaoVisualizarRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVisualizarRelatorioClienteActionPerformed(evt);
            }
        });

        botaoVisualizarRelatorioCliente1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botaoVisualizarRelatorioCliente1.setText("Aniversariantes");
        botaoVisualizarRelatorioCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVisualizarRelatorioCliente1ActionPerformed(evt);
            }
        });

        jLabel37.setText("Mes do aniversário");

        campoMesAniversario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        campoMesAniversario.setMinimumSize(new java.awt.Dimension(28, 22));
        campoMesAniversario.setPreferredSize(new java.awt.Dimension(28, 22));
        campoMesAniversario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoMesAniversarioMouseClicked(evt);
            }
        });
        campoMesAniversario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMesAniversarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoVisualizarRelatorioCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(botaoVisualizarRelatorioCliente)
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(caixaMarcarTodosCliente)
                .addGap(72, 72, 72))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(campoMesAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(caixaMarcarTodosCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoVisualizarRelatorioCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoMesAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(botaoVisualizarRelatorioCliente1)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelClienteLayout = new javax.swing.GroupLayout(painelCliente);
        painelCliente.setLayout(painelClienteLayout);
        painelClienteLayout.setHorizontalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelClienteLayout.setVerticalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        //if (em.getPerfil().equals("TICIANO") || em.getPerfil().equals("consultorio")){
            //    AbaPrincipal.addTab("-", painelVenda);
            //}else{

            AbaPrincipal.addTab("Clientes", painelCliente);
            //}

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        caixaMarcarTodosUsuarios.setText("Todos");

        botaoVisualizarUsuarios.setText("Visualizar Relação");
        botaoVisualizarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVisualizarUsuariosActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Relação dos Usuários");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(caixaMarcarTodosUsuarios)
                .addGap(81, 81, 81))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(botaoVisualizarUsuarios)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(caixaMarcarTodosUsuarios)
                .addGap(20, 20, 20)
                .addComponent(botaoVisualizarUsuarios)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Relatórios relacionado a usuários do sistema");

        javax.swing.GroupLayout painelUsuarioLayout = new javax.swing.GroupLayout(painelUsuario);
        painelUsuario.setLayout(painelUsuarioLayout);
        painelUsuarioLayout.setHorizontalGroup(
            painelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(painelUsuarioLayout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );
        painelUsuarioLayout.setVerticalGroup(
            painelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        AbaPrincipal.addTab("Usuários", painelUsuario);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Relatórios");

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoSair)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AbaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AbaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSair)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVisualizarRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVisualizarRelatorioClienteActionPerformed
        
    }//GEN-LAST:event_botaoVisualizarRelatorioClienteActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoVisualizarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVisualizarUsuariosActionPerformed
      
    }//GEN-LAST:event_botaoVisualizarUsuariosActionPerformed

    private void AbaPrincipalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AbaPrincipalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.setVisible(false);
        }
    }//GEN-LAST:event_AbaPrincipalKeyPressed

    private void botaoVisualizarRelatorioCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVisualizarRelatorioCliente1ActionPerformed
       
    }//GEN-LAST:event_botaoVisualizarRelatorioCliente1ActionPerformed

    private void campoMesAniversarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoMesAniversarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMesAniversarioMouseClicked

    private void campoMesAniversarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMesAniversarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMesAniversarioActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaRelatoriosGerais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatoriosGerais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatoriosGerais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatoriosGerais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaRelatoriosGerais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane AbaPrincipal;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoVisualizarRelatorioCliente;
    private javax.swing.JButton botaoVisualizarRelatorioCliente1;
    private javax.swing.JButton botaoVisualizarUsuarios;
    private javax.swing.JCheckBox caixaMarcarTodosCliente;
    private javax.swing.JCheckBox caixaMarcarTodosUsuarios;
    public javax.swing.JComboBox campoMesAniversario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel painelCliente;
    private javax.swing.JPanel painelUsuario;
    // End of variables declaration//GEN-END:variables
}
