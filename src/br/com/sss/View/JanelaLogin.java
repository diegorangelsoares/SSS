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
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Diego Rangel  
 */

public class JanelaLogin extends javax.swing.JFrame {
    
    public ConvertPasswordToMD5 ConverteSenha = new ConvertPasswordToMD5();
    GeraData dataAtual = new GeraData();
    GeraHora horaAtual = new GeraHora();
    
    private FlowLayout layout;
    private Container container;
    
    //Cria uma Janela cliente pra pegar o design configurado na janela de cliente
    JanelaDesignNimbus janelaDesign = new JanelaDesignNimbus();
    
    MensagemErro mensagemErro = new MensagemErro();
    
    /**
     * Creates new form JanelaLogin
     * 
     */
    
    public JanelaLogin() {
        initComponents();
        super.setTitle("Protocolos - Login");
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        
        //PreencheBancos();
        
        //Verifica o caminho do banco de dados salvo no caminhoBD.txt
        //co.VerificaCaminhoDoBancoDeDados(co);

        
        //Muda icone da Janela
        URL url = this.getClass().getResource("/Imagens/ICONE_DR_3.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(imagemTitulo); 
        
//        campoBanco.setVisible(false);
//        labelNomeLoja.setVisible(false);
        
        mensagemErrada.setText(" ");
        //mensagemValidando.setText(" ");
        mensagemErrada.setBackground(Color.red);
        
        //Muda icone da Janela
//        S

        //Deixando o botao entrar no centro
//        layout = new FlowLayout();		//CRIA FLOWLAYOUT
//        container = getContentPane();	//OBTÊM CONTEINER PARA LAYOUT
//        painelBotao.setLayout(layout);	//CONFIGURA O LAYOUT DE FRAME
//        botaoEntrar.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					layout.setAlignment(FlowLayout.CENTER);
//					//REALINHA OS COMPONENTES ANEXADOS
//					layout.layoutContainer(container);					
//				}
//			}
//	);
        
        
        
        //co.replaceTabelaMysql();
        
        //oculta o botao dica de senha
        
        //botaoDica.setToolTipText("Clique para visualizar a dica da senha!");
        
//        try {
//            preencheUltimoUsuarioQueLogou();
//            //if ()
//        } catch (IOException ex) {
//            //Logger.getLogger(JanelaLogin.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        botaoAtualizar.setVisible(false);

        
    }
    
    public void preencheUltimoUsuarioQueLogou() throws IOException {
        String usuario = "";    
        try{
                String arquivo = "C:/DSistema/Config.ini";
                BufferedReader reader = new BufferedReader(new FileReader(arquivo));
                int contadorLinha = 0;
                String linha;
                while ((linha = reader.readLine()) != null) {
                    //Confere a primeira linha - caminho Banco de dados
                    if (contadorLinha == 4){
                        usuario = linha;
                        usuario = usuario.replace("USUARIO_LOGADO==", "");
                        if (!usuario.equals("")){
                            campoUsuario.setText(usuario);
                            campoUsuario.selectAll();
                        }
                    }
                    contadorLinha++;
                }    
                reader.close();                 
            }catch(IOException ex){
                //XXXXXXXXXXXXXXXnull, "Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!");
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Não foi possível localizar o arquivo Config.ini, arquivo vai ser configurado!", "Falta informação","erro");
                //criaArquivoConfig(caminhoServidor,em.getPerfil() );
            }
    }
    
    public void PreencheBancos(){
//        campoBanco.removeAllItems();
        try { 
            FileReader arq = new FileReader("c:\\DSistema\\CaminhoBD.ini");
            BufferedReader lerArq = new BufferedReader(arq);  
            String linha = lerArq.readLine();
            while (linha != null) {
                if (!linha.equals("")){
//                    campoBanco.addItem(linha);
                }
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close(); 
            } catch (IOException e) { 
                //XXXXXXXXXXXXXXXnull, "Caminho do BD não encontrado ou Computador não configurado!");
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Caminho do BD não encontrado ou Computador não configurado!", "Falta informação","erro");
            }
    }
    
    public void organizaSequenciaCaminhoIni(String nomeBancoEscolhido){
        ArrayList<String> Bancos = new ArrayList<String>();
            try { 
                //Ler todos os bancos salvos
                FileReader arq = new FileReader("c:\\DSistema\\CaminhoBD.ini");
                BufferedReader lerArq = new BufferedReader(arq);  
                String linha = lerArq.readLine();
                //JOptionPane.showMessageDialog(null, "Ate aqui ta ok ");
                Bancos.add(nomeBancoEscolhido); 
                while (linha != null) {
                    //Verificar se tem linha em branco ou se é o banco ja escolhido
                    if (!linha.equals("") && !linha.equals(nomeBancoEscolhido)){
                        Bancos.add(linha);                    
                    }
                    linha = lerArq.readLine(); // lê da segunda até a última linha
                }            
                //remover o arquivo ini para criar um novo
                String nome = "c:/DSistema/CaminhoBD.ini";  
                File f = new File(nome);  
                f.delete();
                //renovar nova sequencia colocando o escolhido no inicio
                String nomeDoArquivo = "c:\\DSistema\\CaminhoBD.ini";
                BufferedWriter buffWrite = null; 
                try {                
                    buffWrite = new BufferedWriter(new FileWriter(nomeDoArquivo));
                    for (int i = 0; i < Bancos.size(); i++) {
                        buffWrite.write((String) Bancos.get(i));
                        buffWrite.newLine();
                    }
                    buffWrite.close();
                } catch (IOException ex) {
                    //XXXXXXXXXXXXXXXnull, "O Windows não deixou criar o arquivo do Caminho BD!");
                    mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("O Windows não deixou criar o arquivo do Caminho BD!", "Falta informação","erro");
                }            
                arq.close(); 
            } catch (IOException e) { 
                //XXXXXXXXXXXXXXXnull, "Caminho do BD não encontrado ou Computador não configurado!");
                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Caminho do BD não encontrado ou Computador não configurado!", "Falta informação","erro");
            } 
    }
    
    public void TiraAspaSimplesDoCampo (JTextField campo){
        if (campo.getText().contains("'")){
            campo.setText(campo.getText().replace("'", ""));
        }
    }

    public void TrataEntradaAoApertarNoBotaoEntrar(){
                
                Conexao co = new Conexao();
                ArquivoConfiguracao arquivoConfiguracao = new ArquivoConfiguracao();
                TiraAspaSimplesDoCampo(campoUsuario);
                //VERIFICA CONFIG, CASO NAO TENHA AINDA ELE CRIA
                String usuarioInicial = campoUsuario.getText();
                if (campoUsuario.getText().equals("")){
                    usuarioInicial = "admin";
                }
                //arquivoConfiguracao.verificaArquivoConfiguracao(co,usuarioInicial);                
                //COMEÇA A VALIDAÇÃO DE LOGIN        

                        if (campoUsuario.getText().equals("") || campoSenha.getText().equals("")){
                            //XXXXXXXXXXXXXXXnull, "Digite usuário e senha!");
                            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Digite usuário e senha!", "Falta informação","erro");
                        }else{  
                            campoUsuario.setText(campoUsuario.getText().replace("'", ""));
                            //co.VerificaCaminhoDoBancoDeDados(co);
                            //co.atualizaTabelasDoBancoDeDados();
                            //co.atualizaUsuarioLogado(campoUsuario.getText());
                            String senha = campoSenha.getText();//ConverteSenha.encripta(campoSenha.getText());
//                            boolean resultado = co.ValidaLogin(campoUsuario.getText(), senha, this);
                            String nomePerfil = "MED";
                                //Selecionou alguma empresa
                            boolean respostaDaValidadeLicenca = co.ValidaLicenca();
                            if (respostaDaValidadeLicenca == true){                                
                                if (campoUsuario.getText().equals("INFOMED") || campoSenha.getText().equals("gps974")){
                                    //Abrir a tela carregando                                      
                                    //String id = co.retornaIdUsuario(campoUsuario.getText());
                                    //co.inserirRegistroDeUsuario(id,campoUsuario.getText(),"Usuario logou no sistema",dataAtual.RetornaDataAtual()+" "+horaAtual.RetornaHoraAtual());
                                    JanelaPrincipal jcc = new JanelaPrincipal();
                                    jcc.campoNomeUsuario.setText("Usuário: "+campoUsuario.getText());  
                                    jcc.show();
                                    this.dispose();

                                }else{
                                    mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Usuário ou senha inválido!", "Falta informação","erro");
                                }
                            }else{
                                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Licença venceu na data: "+co.dataValidade+"  Renove-a!", "Falta informação","erro");
                            } 
                    }
            
            
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Colonna MT", 1, 48)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Busca Protocolos");
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
        campoUsuario.setText("INFOMED");
        campoUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoUsuarioFocusGained(evt);
            }
        });
        campoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoUsuarioMouseClicked(evt);
            }
        });
        campoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoUsuarioKeyPressed(evt);
            }
        });

        campoSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoSenha.setText("GPS974");
        campoSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoSenhaFocusGained(evt);
            }
        });
        campoSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoSenhaMouseClicked(evt);
            }
        });
        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoSenhaKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
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
                .addGroup(painelNomeSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(campoSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelNomeSenhaLayout.setVerticalGroup(
            painelNomeSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNomeSenhaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelNomeSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelNomeSenhaLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelNomeSenhaLayout.createSequentialGroup()
                        .addGroup(painelNomeSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelNomeSenhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mensagemErrada, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
            .addComponent(painelNomeSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelNomeSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensagemErrada)
                .addGap(99, 99, 99))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoUsuarioKeyPressed
        if(evt.getKeyCode() == evt.VK_ESCAPE){
            this.dispose();
        }else{
        if((evt.getKeyCode() == evt.VK_ENTER) || (evt.getKeyCode() == evt.VK_TAB)){
            /**
            if (campoUsuario.getText().equals("")){
                //Não digitou nada para pesquisar
            }else{
                campoSenha.requestFocus();
            }
            */ 
            campoSenha.requestFocus();
        }
        //mensagemValidando.setText(" ");
        mensagemErrada.setText(" ");
        }
    }//GEN-LAST:event_campoUsuarioKeyPressed

    private void campoSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoSenhaMouseClicked
        //mensagemValidando.setText(" ");
        mensagemErrada.setText(" ");   
        if (verificaSeTemArquivoTesteINI() == true){
            if (campoUsuario.getText().equals("Admin")){
//                    campoBanco.setVisible(true);
//                    labelNomeLoja.setVisible(true);
                    //campoPerfil.setSelectedItem("Teste");
                    campoSenha.requestFocus();
            }
        }
    }//GEN-LAST:event_campoSenhaMouseClicked

    private void campoSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoSenhaFocusGained
        //mensagemValidando.setText(" ");
        mensagemErrada.setText(" ");   
        if (verificaSeTemArquivoTesteINI() == true){
            if (campoUsuario.getText().equals("Admin")){
//                    campoBanco.setVisible(true);
//                    labelNomeLoja.setVisible(true);
//                    botaoAtualizar.setVisible(true);
                    //campoPerfil.setSelectedItem("Teste");
                    campoSenha.requestFocus();
            }
        }
    }//GEN-LAST:event_campoSenhaFocusGained

    private void campoSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSenhaKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            TrataEntradaAoApertarNoBotaoEntrar();
        }
        
    }//GEN-LAST:event_campoSenhaKeyPressed

    private void campoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoUsuarioMouseClicked
        //mensagemValidando.setText(" ");
        mensagemErrada.setText(" ");
//        campoBanco.setVisible(false);
//        labelNomeLoja.setVisible(false);
        //campoSenha.requestFocus();
    }//GEN-LAST:event_campoUsuarioMouseClicked

    private void campoUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoUsuarioFocusGained
        ////mensagemValidando.setText(" ");
        //mensagemErrada.setText(" ");
//        campoBanco.setVisible(false);
//        labelNomeLoja.setVisible(false);
//        botaoAtualizar.setVisible(false);
        //campoSenha.requestFocus();
    }//GEN-LAST:event_campoUsuarioFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TrataEntradaAoApertarNoBotaoEntrar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            TrataEntradaAoApertarNoBotaoEntrar();
        }
    }//GEN-LAST:event_jButton1KeyPressed

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
            java.util.logging.Logger.getLogger(JanelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField campoSenha;
    public javax.swing.JTextField campoUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel mensagemErrada;
    private javax.swing.JPanel painelNomeSenha;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables

    
}
