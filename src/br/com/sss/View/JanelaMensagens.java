/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.View;

import br.com.sss.Control.CaminhoImagem;
import br.com.sss.Control.Clean;
import br.com.sss.Control.Conexao;
import br.com.sss.Control.TextAreaCellRenderer;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author DIEGO
 */
public class JanelaMensagens extends javax.swing.JDialog {

    CaminhoImagem caminhoImagemIcone = new CaminhoImagem();
    Clean limpar = new Clean();
    Conexao co = new Conexao();
    StringBuilder str = new StringBuilder();
    String texto = "Boa tarde, \n Segue os dados conforme solicitado. \n ajsndkjansdkjas \n Att \n";
    public int alturaDaLinha = 100;
    
    /**
     * Creates new form JanelaMensagens2
     */
    public JanelaMensagens(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        super.setTitle("Mensagens");
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        
         //colocar barra de rolagem na tabela
//        tabelaMensagens.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        
//        tabelaMensagens.setColumnSelectionAllowed(true);  
//        tabelaMensagens.setRowSelectionAllowed(true);
        
//        co.atualizaGrupoNaJanelaAlteracao(this);

        tabelaMensagens.setRowHeight(alturaDaLinha); 
        str.append("<html>");
        str.append(texto.replaceAll("\n","<br>"));
        str.append("</html>");

        str.toString();
        /**
        tabelaMensagens.setValueAt("12/08/2019", 0, 0);
        tabelaMensagens.setValueAt("12/08/2019", 1, 0);
        tabelaMensagens.setValueAt("12/08/2019", 2, 0);
        tabelaMensagens.setValueAt("12/08/2019", 3, 0);
        
        tabelaMensagens.setValueAt("Diego", 0, 1);
        tabelaMensagens.setValueAt("Unimed", 1, 1);
        tabelaMensagens.setValueAt("Diego", 2, 1);
        tabelaMensagens.setValueAt("Unimed", 3, 1);
        
        tabelaMensagens.setValueAt("Unimed", 0, 2);
        tabelaMensagens.setValueAt("Diego", 1, 2);
        tabelaMensagens.setValueAt("Unimed", 2, 2);
        tabelaMensagens.setValueAt("Diego", 3, 2);
        
        //MEnsagens
        tabelaMensagens.setValueAt(str.toString(), 0, 3);
        tabelaMensagens.setValueAt(str.toString(), 1, 3);
        tabelaMensagens.setValueAt(str.toString(), 2, 3);
        tabelaMensagens.setValueAt(str.toString(), 3, 3);
        * */
        
        tabelaMensagens.getColumnModel().getColumn(3).setWidth(100);
//        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        campoProtocolo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        botaoSair = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaMensagens = new javax.swing.JTable();
        botaoMais = new javax.swing.JButton();
        botaoMenos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        campoProtocolo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoProtocolo.setEnabled(false);
        campoProtocolo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoProtocoloKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Protocolo");

        botaoSair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        tabelaMensagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data", "De", "Para", "Mensagem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaMensagens);
        if (tabelaMensagens.getColumnModel().getColumnCount() > 0) {
            tabelaMensagens.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaMensagens.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabelaMensagens.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabelaMensagens.getColumnModel().getColumn(3).setPreferredWidth(400);
        }

        botaoMais.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoMais.setForeground(new java.awt.Color(0, 204, 0));
        botaoMais.setText("+");
        botaoMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMaisActionPerformed(evt);
            }
        });

        botaoMenos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botaoMenos.setForeground(new java.awt.Color(255, 0, 0));
        botaoMenos.setText("-");
        botaoMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMenosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(campoProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoMais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoMenos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(8, 8, 8)
                .addComponent(campoProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botaoMais)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoMenos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoProtocoloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoProtocoloKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if (campoProtocolo.getText().equals("")){
                //                campoNomeProduto1.requestFocus();
            }
        }
    }//GEN-LAST:event_campoProtocoloKeyPressed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMaisActionPerformed
        if (alturaDaLinha > 400){
            //nao aumente mais

        }else{
            alturaDaLinha = alturaDaLinha + 10;
            tabelaMensagens.setRowHeight(alturaDaLinha);
        }
    }//GEN-LAST:event_botaoMaisActionPerformed

    private void botaoMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMenosActionPerformed
        if (alturaDaLinha < 20){
            //nao aumente mais

        }else{
            alturaDaLinha = alturaDaLinha - 10;
            tabelaMensagens.setRowHeight(alturaDaLinha);
        }
    }//GEN-LAST:event_botaoMenosActionPerformed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.setVisible(false);
        }
    }//GEN-LAST:event_jPanel2KeyPressed

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
            java.util.logging.Logger.getLogger(JanelaMensagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaMensagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaMensagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaMensagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaMensagens dialog = new JanelaMensagens(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoMais;
    private javax.swing.JButton botaoMenos;
    private javax.swing.JButton botaoSair;
    public javax.swing.JTextField campoProtocolo;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaMensagens;
    // End of variables declaration//GEN-END:variables
}