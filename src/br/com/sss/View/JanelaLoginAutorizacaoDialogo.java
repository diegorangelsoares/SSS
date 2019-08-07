
package br.com.sss.View;


import br.com.sss.model.Empresa;
import br.com.sss.model.Usuario;
import br.com.sss.Control.ArquivoConfiguracao;
import br.com.sss.Control.Conexao;
import br.com.sss.Control.ConvertPasswordToMD5;
import br.com.sss.Control.GeraData;
import br.com.sss.Control.GeraHora;
import br.com.sss.Control.MensagemErro;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;  
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Diego Rangel
 */

public class JanelaLoginAutorizacaoDialogo extends javax.swing.JDialog {

    public ConvertPasswordToMD5 ConverteSenha = new ConvertPasswordToMD5();
    //public Conexao co = new Conexao();
    GeraData dataAtual = new GeraData();
    GeraHora horaAtual = new GeraHora();
    MensagemErro mensagemErro = new MensagemErro();
    private FlowLayout layout;
    private Container container;
    
    //Cria uma Janela cliente pra pegar o design configurado na janela de cliente
    JanelaDesignNimbus janelaDesign = new JanelaDesignNimbus();
    
    ArquivoConfiguracao arquivoConfiguracao = new ArquivoConfiguracao();
    
    public int numeroDaPermissao = 1;
    
    public boolean resultadoAutorizacao = false;
    
    /**
     * Creates new form JanelaLoginAutorizacao
     */
    
    public JanelaLoginAutorizacaoDialogo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        super.setTitle("Autorizar");
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        
        
        //Muda icone da Janela
        URL url = this.getClass().getResource("/be.com.sss.Imagem/ICONE_DR_3.png");  
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(imagemTitulo);
        
        //Deixando o botao entrar no centro
        layout = new FlowLayout();		//CRIA FLOWLAYOUT
        container = getContentPane();	//OBTÊM CONTEINER PARA LAYOUT
        painelBotao.setLayout(layout);	//CONFIGURA O LAYOUT DE FRAME
        botaoEntrar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					layout.setAlignment(FlowLayout.CENTER);
					//REALINHA OS COMPONENTES ANEXADOS
					layout.layoutContainer(container);					
				}
			}
	);
        
        mensagemErrada.setText(" ");
        mensagemValidando.setText(" ");
        mensagemErrada.setBackground(Color.red);
        //Ocultar frases
        mensagemErrada.setVisible(false);
        botaoDica.setVisible(false);
        mensagemValidando.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        mensagemErrada = new javax.swing.JLabel();
        painelNomeSenha = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        campoSenha = new javax.swing.JPasswordField();
        botaoDica = new javax.swing.JLabel();
        painelBotao = new javax.swing.JPanel();
        botaoEntrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        mensagemValidando = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Autorizar");
        jLabel3.setToolTipText("");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        mensagemErrada.setForeground(new java.awt.Color(255, 51, 51));
        mensagemErrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensagemErrada.setText("Usuário ou senha inválidos");

        painelNomeSenha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Usuário:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Senha:");

        campoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoUsuarioMouseClicked(evt);
            }
        });
        campoUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoUsuarioFocusGained(evt);
            }
        });
        campoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoUsuarioKeyPressed(evt);
            }
        });

        campoSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoSenhaMouseClicked(evt);
            }
        });
        campoSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoSenhaFocusGained(evt);
            }
        });
        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoSenhaKeyPressed(evt);
            }
        });

        botaoDica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botaoDica.setForeground(new java.awt.Color(255, 0, 0));
        botaoDica.setText("?");
        botaoDica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoDicaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelNomeSenhaLayout = new javax.swing.GroupLayout(painelNomeSenha);
        painelNomeSenha.setLayout(painelNomeSenhaLayout);
        painelNomeSenhaLayout.setHorizontalGroup(
            painelNomeSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNomeSenhaLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(painelNomeSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelNomeSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoSenha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoDica)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        painelNomeSenhaLayout.setVerticalGroup(
            painelNomeSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNomeSenhaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelNomeSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelNomeSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoDica))
                .addContainerGap())
        );

        botaoEntrar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        botaoEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_entrar.png"))); // NOI18N
        botaoEntrar.setText("Autorizar");
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });
        botaoEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEntrarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout painelBotaoLayout = new javax.swing.GroupLayout(painelBotao);
        painelBotao.setLayout(painelBotaoLayout);
        painelBotaoLayout.setHorizontalGroup(
            painelBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotaoLayout.createSequentialGroup()
                .addComponent(botaoEntrar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        painelBotaoLayout.setVerticalGroup(
            painelBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotaoLayout.createSequentialGroup()
                .addComponent(botaoEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        mensagemValidando.setForeground(new java.awt.Color(0, 153, 0));
        mensagemValidando.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensagemValidando.setText("Validando login...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mensagemValidando, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mensagemValidando))
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mensagemErrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelNomeSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelNomeSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensagemErrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoUsuarioMouseClicked
        mensagemValidando.setText(" ");
        mensagemErrada.setText(" ");
        //campoBanco.setVisible(false);
        //labelNomeLoja.setVisible(false);
        //campoSenha.requestFocus();
    }//GEN-LAST:event_campoUsuarioMouseClicked

    private void campoUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoUsuarioFocusGained
        //mensagemValidando.setText(" ");
        //mensagemErrada.setText(" ");
        //campoBanco.setVisible(false);
        //labelNomeLoja.setVisible(false);
        //campoSenha.requestFocus();
    }//GEN-LAST:event_campoUsuarioFocusGained

    private void campoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoUsuarioKeyPressed
        if(evt.getKeyCode() == evt.VK_ESCAPE){
            this.dispose();
        }else{
            if((evt.getKeyCode() == evt.VK_ENTER) || (evt.getKeyCode() == evt.VK_TAB)){
                if (campoUsuario.getText().equals("")){
                    //Não digitou nada para pesquisar
                }else{
                    campoSenha.requestFocus();
                }
            }
            mensagemValidando.setText(" ");
            mensagemErrada.setText(" ");
        }
    }//GEN-LAST:event_campoUsuarioKeyPressed

    private void campoSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoSenhaMouseClicked
        mensagemValidando.setText(" ");
        mensagemErrada.setText(" ");
        if (campoUsuario.getText().equals("Admin")){
            //campoBanco.setVisible(true);
            //labelNomeLoja.setVisible(true);
            campoSenha.requestFocus();
        }
    }//GEN-LAST:event_campoSenhaMouseClicked

    private void campoSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoSenhaFocusGained
        mensagemValidando.setText(" ");
        mensagemErrada.setText(" ");
        if (campoUsuario.getText().equals("Admin")){
            //campoBanco.setVisible(true);
            //labelNomeLoja.setVisible(true);
            campoSenha.requestFocus();
        }

    }//GEN-LAST:event_campoSenhaFocusGained

    private void campoSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSenhaKeyPressed
        if(evt.getKeyCode() == evt.VK_ESCAPE){
            this.dispose();
        }else{if((evt.getKeyCode() == evt.VK_ENTER) || (evt.getKeyCode() == evt.VK_TAB)){
            botaoEntrar.requestFocus();
        }
        mensagemValidando.setText(" ");
        mensagemErrada.setText(" ");
        }
    }//GEN-LAST:event_campoSenhaKeyPressed

    private void botaoDicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoDicaMouseClicked
        Conexao co = new Conexao();
        if (campoUsuario.getText().equals("")){
            //XXXXXXXXXXXXXXXnull, "Digite o nome do usuario para ver a dica da senha!");
            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Digite o nome do usuario para ver a dica da senha!", "Falta informação","erro");
        }else{            
            
        }
    }//GEN-LAST:event_botaoDicaMouseClicked

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        //perfil de grafica abre sem login
       
//        Conexao co = new Conexao();
//
//        //VERIFICA CONFIG, CASO NAO TENHA AINDA ELE CRIA
//        String usuarioInicial = campoUsuario.getText();
//        if (campoUsuario.getText().equals("")){
//            usuarioInicial = "Admin";
//        }
//        arquivoConfiguracao.verificaArquivoConfiguracao(co,usuarioInicial);
//
//        //COMEÇA A VALIDAÇÃO DE LOGIN        
//            botaoDica.setVisible(false);
//            if (campoUsuario.getText().equals("") || campoSenha.getText().equals("")){
//                //XXXXXXXXXXXXXXXnull, "Digite usuário e senha!");
//                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Digite usuário e senha!", "Falta informação","erro");
//            }else{
//                campoUsuario.setText(campoUsuario.getText().replace("'", ""));
//                mensagemValidando.setText("Efetue o login novamente...");
//                String senha = ConverteSenha.encripta(campoSenha.getText());
//                boolean resultado = co.ValidaLoginAutorizacao(campoUsuario.getText(), senha, this);
//                boolean resultadoPermissao = co.VerificaPermissaoDoUsuario(campoUsuario.getText(), senha, numeroDaPermissao);
//                //String nomePerfil = (String) campoBanco.getSelectedItem();
//                //Selecionou alguma empresa
//                if (resultado == true){
//                    if (resultadoPermissao == true){
//                        //Abrir a tela carregando
//                        resultadoAutorizacao = true;
//                        this.dispose();
//                    }else{
//                        //XXXXXXXXXXXXXXXnull, "Você não tem permissão! "+co.retornaDescricaoPermissao(numeroDaPermissao));
//                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Você não tem permissão! "+co.retornaDescricaoPermissao(numeroDaPermissao), "Falta informação","erro");
//                    }
//                }
//            }
        
    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void botaoEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarKeyPressed
//        if(evt.getKeyCode() == evt.VK_ENTER){
//            //perfil de grafica abre sem login
//       
//        Conexao co = new Conexao();
//
//        //VERIFICA CONFIG, CASO NAO TENHA AINDA ELE CRIA
//        String usuarioInicial = campoUsuario.getText();
//        if (campoUsuario.getText().equals("")){
//            usuarioInicial = "Admin";
//        }
//        arquivoConfiguracao.verificaArquivoConfiguracao(co,usuarioInicial);
//
//        //COMEÇA A VALIDAÇÃO DE LOGIN        
//            botaoDica.setVisible(false);
//            if (campoUsuario.getText().equals("") || campoSenha.getText().equals("")){
//                //XXXXXXXXXXXXXXXnull, "Digite usuário e senha!");
//                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Digite usuário e senha!", "Falta informação","erro");
//            }else{
//                mensagemValidando.setText("Efetue o login novamente...");
//                String senha = ConverteSenha.encripta(campoSenha.getText());
//                boolean resultado = co.ValidaLoginAutorizacao(campoUsuario.getText(), senha, this);
//                boolean resultadoPermissao = co.VerificaPermissaoDoUsuario(campoUsuario.getText(), senha, numeroDaPermissao);
//                //String nomePerfil = (String) campoBanco.getSelectedItem();
//                //Selecionou alguma empresa
//                if (resultado == true){
//                    if (resultadoPermissao == true){
//                        //Abrir a tela carregando
//                        resultadoAutorizacao = true;
//                        this.dispose();
//                    }else{
//                        //XXXXXXXXXXXXXXXnull, "Você não tem permissão! "+co.retornaDescricaoPermissao(numeroDaPermissao));
//                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Você não tem permissão! "+co.retornaDescricaoPermissao(numeroDaPermissao), "Falta informação","erro");
//                    }
//                }
//            }
//        }
    }//GEN-LAST:event_botaoEntrarKeyPressed

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
            java.util.logging.Logger.getLogger(JanelaLoginAutorizacaoDialogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaLoginAutorizacaoDialogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaLoginAutorizacaoDialogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaLoginAutorizacaoDialogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaLoginAutorizacaoDialogo dialog = new JanelaLoginAutorizacaoDialogo(new javax.swing.JFrame(), true);
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
    public javax.swing.JLabel botaoDica;
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JPasswordField campoSenha;
    public javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel mensagemErrada;
    public javax.swing.JLabel mensagemValidando;
    private javax.swing.JPanel painelBotao;
    private javax.swing.JPanel painelNomeSenha;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables
}