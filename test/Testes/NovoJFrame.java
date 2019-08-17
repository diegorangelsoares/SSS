package Testes;


import br.com.sss.Control.MensagemController;
import br.com.sss.Control.ProtocoloController;
import br.com.sss.model.Mensagem;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Component;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
//import org.hibernate.HibernateException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DIEGO
 */
public class NovoJFrame extends javax.swing.JFrame {

    
    StringBuilder str = new StringBuilder();
    public int alturaDaLinha = 20;
    
    String texto = "Bom dia,\n"
            + "Me passa a conexaoo askjdhaksjhdksajhdk haksjdhka jshd kajshdkajshd kjash dkjash dkjash dkjash kajsh dkjashooo\n"
            + "Att\n"
            + "Diego Rangel"
            ;
    
//    FuncoesTabelaBalanco funcoesTabelaBalanco = new FuncoesTabelaBalanco();
    
    /**
     * Creates new form NovoJFrame
     */
    public NovoJFrame() {
        initComponents();
        
//        try {
//            //        texto = "Bom dia,\n"
////            + "Me passa a conexaooooo\n"
////            + "Att\n"
////            + "Diego Rangel"
////            ;
////        
////        calculaAlturaLinha(texto);
//
////        for (int i = 0; i < jTable.getColumnCount(); i++) {
////                col = jTable.getColumnModel().getColumn(i); col.setCellRenderer(new TextAreaCellRenderer());
////        }  
//
////	jTable1.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
////jTable1.getColumnModel().getColumn(/*índice da tua coluna*/).setCellRenderer(/*----> seu cell renderer aqui <----*/);
//        percorrerArquivo();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(NovoJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
        jTable2.setValueAt(texto, 0, 4);
        jTable2.setValueAt(texto, 1, 4);
        jTable2.setValueAt(texto, 2, 4);
        jTable2.setValueAt(texto, 3, 4);
        jTable2.setValueAt(texto, 4, 4);
        jTable2.setValueAt(texto, 5, 4);
        updateRowHeights();

    }
    
    public void tamanho_colunas() {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();  
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);

        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();  
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);  

        JTableHeader header = jTable2.getTableHeader();   
        header.setPreferredSize(new Dimension(0, 20));   // define a largura do cabeçalho
        TableColumnModel modeloDaColuna = jTable2.getColumnModel();  

        modeloDaColuna.getColumn(0).setCellRenderer(rendererCentro);  
        modeloDaColuna.getColumn(1).setCellRenderer(rendererEsquerda); 
        modeloDaColuna.getColumn(2).setCellRenderer(rendererEsquerda);
        modeloDaColuna.getColumn(3).setCellRenderer(rendererCentro);
        modeloDaColuna.getColumn(4).setCellRenderer(rendererEsquerda);
//        modeloDaColuna.getColumn(5).setCellRenderer(rendererEsquerda);
//        modeloDaColuna.getColumn(6).setCellRenderer(rendererCentro);

        modeloDaColuna.getColumn(0).setMaxWidth(50);  
        modeloDaColuna.getColumn(1).setMaxWidth(350);
        modeloDaColuna.getColumn(2).setMaxWidth(350);
        modeloDaColuna.getColumn(3).setMaxWidth(50);
        modeloDaColuna.getColumn(4).setMaxWidth(200);
//        modeloDaColuna.getColumn(5).setMaxWidth(200);
//        modeloDaColuna.getColumn(6).setMaxWidth(100);
       
}
    
    public void calculaAlturaLinha(String texto){
        String s = texto;
        int pos = -1;
        int contagem = 0;
        while (true) {
            pos = s.indexOf ("\n", pos + 1); 
            if (pos < 0) break;
            contagem++;
            
        }
        System.out.println (contagem);

        //            jTable1.setRowHeight(alturaDaLinha); 
        str.append("<html>");
        str.append(texto.replaceAll("\n","<br>"));
        str.append("</html>");

//        jTable1.setValueAt(str.toString(), 0, 1);
//        jTable1.setValueAt(str.toString(), 1, 1);
//
//        alturaDaLinha = alturaDaLinha *contagem + 10; 
//        jTable1.setRowHeight(alturaDaLinha); 


            
    }
    
    
    public void percorrerArquivo() throws FileNotFoundException{
//            Scanner in = new Scanner(new FileReader("C:\\Users\\DIEGO\\Desktop\\ArquivoTeste.txt"));
//            while (in.hasNextLine()) {
//                String line = in.nextLine();
//                System.out.println(line);
//                javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)jTable1.getModel();
//                dtm.addRow(new Object[]{line}); 
//            }
//        
//        String linha;
//        
//        while ((linha = br.readLine()) != null) {
//             System.out.println(linha);
//        }
//
//        br.close();
    }
    
    private void updateRowHeights() { 
        
        for (int row = 0; row < jTable2.getRowCount(); row++) { 
            int rowHeight = jTable2.getRowHeight(); 
            for (int column = 0; column < jTable2.getColumnCount(); column++) { 
                Component comp = jTable2.prepareRenderer(jTable2.getCellRenderer(row, column), row, column); 
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height); 
            } jTable2.setRowHeight(row, rowHeight); 
        } 
    } 

    
    public boolean verificaSeNumero(String textoo){
        if (textoo.contains("0") || textoo.contains("1") || textoo.contains("2") || textoo.contains("3") || textoo.contains("4") || textoo.contains("5") || textoo.contains("6") || textoo.contains("7") || textoo.contains("8") || textoo.contains("9")){
            return true;
        }else{
            return false;
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

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        campoNomeExcel1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        campoNomeTabela1 = new javax.swing.JTextField();
        botaoImportar4 = new javax.swing.JButton();
        botaoImportar7 = new javax.swing.JButton();
        botaoImportar8 = new javax.swing.JButton();
        campoSeparados = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Importar dados do arquivo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        campoNomeExcel1.setEditable(false);
        campoNomeExcel1.setText("C:\\Users\\DIEGO\\Desktop\\backup_mensagens.txt");

        jLabel8.setText("Nome do arquivo (\\*.csv)");

        jLabel9.setText("Nome da tabela");

        campoNomeTabela1.setText("tmp_siscon_mensagens");

        botaoImportar4.setText("Importar");
        botaoImportar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoImportar4ActionPerformed(evt);
            }
        });

        botaoImportar7.setText("Teste");
        botaoImportar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoImportar7ActionPerformed(evt);
            }
        });

        botaoImportar8.setText("Procurar");
        botaoImportar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoImportar8ActionPerformed(evt);
            }
        });

        campoSeparados.setText(";");

        jLabel10.setText("Separador");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nº", "Coluna 1", "Coluna 2", "Coluna 3", "Título 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(30);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(400);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(campoNomeExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botaoImportar8))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoNomeTabela1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(campoSeparados, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(botaoImportar7)
                                .addGap(36, 36, 36)
                                .addComponent(botaoImportar4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 547, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNomeExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoImportar8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNomeTabela1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSeparados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoImportar4)
                    .addComponent(botaoImportar7)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoImportar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImportar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoImportar4ActionPerformed

    private void botaoImportar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImportar7ActionPerformed
        if (campoNomeExcel1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Escolha o caminho do arquivo!");
        }else{
            if (campoSeparados.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Informe o separador!");
            }else{
                MensagemController mensagemController = new MensagemController();
                List<Mensagem> mensagens = mensagemController.VerArquivoDeMensagensSiscon(campoNomeExcel1.getText(), campoSeparados.getText());
                int contador = 0;
                for (int i = 0; i < mensagens.size(); i++) {
                    //System.out.println("Registro:"+mensagens.get(i).getProtocolo() + "  Linha: "+ contador);
                    contador++;
                    javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)jTable2.getModel();
                    dtm.addRow(new Object[]{i,mensagens.get(i).getProtocolo(), mensagens.get(i).getData(), mensagens.get(i).getRecurso(),mensagens.get(i).getMensagem()});
                }
                System.out.println("Total: "+contador);
                jLabel11.setText("Total carregados: "+contador);
            }
        }
    }//GEN-LAST:event_botaoImportar7ActionPerformed

    private void botaoImportar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoImportar8ActionPerformed
        campoNomeExcel1.setText("");

        try {
            JFileChooser jFileChooser = new JFileChooser();
            int ok = jFileChooser.showOpenDialog(null);
            if (ok == JFileChooser.APPROVE_OPTION) {
                campoNomeExcel1.setText(jFileChooser.getCurrentDirectory().getPath() + "\\" + jFileChooser.getSelectedFile().getName()); // caminho do arquivo
                    //JOptionPane.showMessageDialog(rootPane, "Caminho:"+caminho);
                    //System.out.println(conteudo);
                } else {
                    jFileChooser.cancelSelection();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_botaoImportar8ActionPerformed

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
            java.util.logging.Logger.getLogger(NovoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoImportar4;
    private javax.swing.JButton botaoImportar7;
    private javax.swing.JButton botaoImportar8;
    private javax.swing.JTextField campoNomeExcel1;
    private javax.swing.JTextField campoNomeTabela1;
    private javax.swing.JTextField campoSeparados;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
