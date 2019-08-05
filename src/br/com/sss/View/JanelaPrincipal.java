package br.com.sss.View;

import br.com.model.Empresa;
import br.com.sss.Control.AtualizarSistema;
import br.com.sss.Control.ArquivoConfiguracao;
import br.com.sss.Control.CaminhoImagem;
import br.com.sss.Control.Clean;
import br.com.sss.Control.Conexao;
import br.com.sss.Control.MensagemErro;
import br.com.sss.Control.DadosConexao;
import br.com.sss.Control.GeraData;
import static com.itextpdf.text.Annotation.URL;
import br.com.sss.ireport.Ireport;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;
import static org.xhtmlrenderer.util.XRLog.layout;

/**
 *  @author Diego Rangel
 */


public class JanelaPrincipal extends javax.swing.JFrame {
        
    Conexao co = new Conexao();
    GeraData dataAtual = new GeraData();
    String resultadoAutorizacao;
    CaminhoImagem caminhoImagemIcone = new CaminhoImagem();
    AtualizarSistema at = new AtualizarSistema();
    Clean limpar = new Clean();
    Ireport ireport = new Ireport();    
    ArquivoConfiguracao arquivoConfiguracao = new ArquivoConfiguracao();    
    public String usuarioRodape = "";    
    public String ativadoPerfilDeConsulta = "false";    
    private FlowLayout layout;
    private Container container;
    MensagemErro mensagemErro = new MensagemErro();
    
    /**
     * Creates new form JanelaPrincipal
     */
    
    public JanelaPrincipal() {
        initComponents();
        super.setTitle("Protocolos - BuscaFácil");
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        super.setExtendedState(super.MAXIMIZED_BOTH);
        super.setDefaultCloseOperation(super.EXIT_ON_CLOSE);
        super.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); 
        
        //Verifica o caminho do banco de dados salvo no caminhoBD.txt   
//        co.VerificaCaminhoDoBancoDeDados(co);
        
        //empresaSalvaNoBD = co.retornaDadosDaEmpresa();        
                
                
        //co.VerificaStatusBanco(this);
        campoStatus.setText("Status: Ok!");
        
        //Coloca a data atual no campo data da tela
        campoData.setText(dataAtual.RetornaDataAtual());
        
        //Preenche o número da versão na tela inicial
        campoVersao.setText("Versão: 1.0.0.1");
        
        //Verifica a licença e preenche a validade em dias
        
     
       
                
        //Coloca o papel de parede conforme perfil salvo no banco
//        co.mudaPapelDeParedePeloPerfil(this,empresaSalvaNoBD.getPerfil());
        //Coloca a logo DR na tela principal
//        co.colocaLogoDrNaTelaPrincipal(this,empresaSalv|aNoBD.getPerfil());
       
        //Muda icone da Janela
        URL url = this.getClass().getResource(caminhoImagemIcone.getCaminhoJanelaPrincipal());
//        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
//        this.setIconImage(imagemTitulo); 
        
        areaTrabalho.requestFocus();
        
        //Verifica as configuracoes das abas e ativa/desativa
        //co.VerificaConfiguracaoDeJanela(this);
//        
//        //Inicia a thread de mensagem
//        Thread clockThread = new Thread(new ThreadDeMensagens(), "Clock thread1");  
//        clockThread.setDaemon(true);  
//        clockThread.start(); 
//        
//        //Inicia a thread de mensagem
//        Thread clockThread2 = new Thread(new ThreadDeMensagensTitulo(), "Clock thread2");  
//        clockThread2.setDaemon(true);  
//        clockThread2.start(); 
        
        //Inicia a thread de mensagem de usuário
        //Thread clockThread3 = new Thread(new ThreadDeAlerta(), "Clock thread3");  
        //clockThread3.setDaemon(true);  
        //clockThread3.start(); 
        
        
       
        
        //Verifica o perfil pra habilitar o menu windows (desligar e reiniciar)
//        verificaPerfilParaAtivarMenuWindows();        
            
        //Ajusta para resolucao da tela
//        pegarResolucao();
        
        //centralizar papel de parede
        //campoLogomarca.setHorizontalAlignment(SwingConstants.CENTER);
        
        /**
        // obter dimensões do pai  
        int larguraPai   = areaTrabalho.getWidth();  
        int alturaPai    = areaTrabalho.getHeight();  
        // obter dimensões do filho  
        int larguraFilho = campoLogomarca.getWidth();  
        int alturaFilho  = campoLogomarca.getWidth();  
        // calcular novas coordenadas do filho  
        int novoX        = (larguraPai - larguraFilho) / 2;  
        int novoY        = (alturaPai - alturaFilho) / 2;  
        // centralizar filho  
        campoLogomarca.setLocation(novoX, novoY);  
        */
               
       
    }
    
   
    
    //Verifica a resolucao da tela e ajusta
    private void pegarResolucao() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension dimensao = t.getScreenSize();
        this.setSize((dimensao.width + 5), (dimensao.height - 38));
    }

    //Cria uma trhead de mensagem para a barra de status " PROPAGANDA "
    private class ThreadDeMensagens implements Runnable {
        String mensagem = "diegorangeljpa@gmail.com";
        int quantidadeLoop = 0;
        int vezesDoLoop = 0;
        String sentido = "direito";
        int contador = 0;
        public void run() {  
            try {  
                while (true) {
                    EventQueue.invokeLater(new Runnable() {  
                        public void run() {  
                            //Faz a acao 
                            if(sentido.equals("direito")){
                                campoMensagem.setText(mensagem);
                                mensagem = " "+mensagem;
                                quantidadeLoop ++;
                                if (quantidadeLoop == 60){
                                    quantidadeLoop = 0;
                                    //mensagem = "diegorangeljpa@gmail.com";
                                    sentido = "esquerdo";
                                }
                            }else{
                                mensagem = mensagem.substring(1);
                                campoMensagem.setText(mensagem);
                                //mensagem = " "+mensagem;
                                quantidadeLoop ++;
                                contador++;
                                if (quantidadeLoop == 60){
                                    quantidadeLoop = 0;
                                    contador = 0;
                                    if (mensagem.equals("diegorangeljpa@gmail.com")){
                                        mensagem = "(83) 99611-7574";
                                    }else{
                                    if (mensagem.equals("(83) 99611-7574")){    
                                        mensagem = "dsistema.com.br";
                                    }else{
                                    if (mensagem.equals("dsistema.com.br")){    
                                        mensagem = "diegorangeljpa@gmail.com";
                                    }    
                                    }
                                    }
                                    sentido = "direito";
                                }
                            }   
                        }  
                    });  
                    Thread.sleep(100);  
                }  
            }  
            catch (InterruptedException e) {  
            }  
        }  
    }
    

    
    //Cria uma trhead de mensagem para a barra de status " PROPAGANDA "
    private class ThreadDeMensagensTitulo implements Runnable {
        String mensagem1 = "DSistema - diegorangeljpa@gmail.com";
        int quantidadeLoop1 = 0;
        int vezesDoLoop1 = 0;
        String sentido1 = "direito";
        int contador1 = 0;
        public void run() {  
            try {  
                while (true) {
                    EventQueue.invokeLater(new Runnable() {  
                        public void run() {  
                            //Faz a acao 
                            if(sentido1.equals("direito")){
                                mudaTituloDaJanela(mensagem1);
                                mensagem1 = " "+mensagem1;
                                quantidadeLoop1 ++;
                                if (quantidadeLoop1 == 300){
                                    quantidadeLoop1 = 0;
                                    //mensagem = "diegorangeljpa@gmail.com";
                                    sentido1 = "esquerdo";
                                }
                            }else{
                                mensagem1 = mensagem1.substring(1);
                                mudaTituloDaJanela(mensagem1);
                                //mensagem = " "+mensagem;
                                quantidadeLoop1 ++;
                                contador1++;
                                if (quantidadeLoop1 == 300){
                                    quantidadeLoop1 = 0;
                                    contador1 = 0;
                                    if (mensagem1.equals("DSistema - diegorangeljpa@gmail.com")){
                                        mensagem1 = "DSistema - (83) 99611-7574";
                                    }else{
                                    if (mensagem1.equals("DSistema - (83) 99611-7574")){    
                                        mensagem1 = "DSistema - dsistema.com.br";
                                    }else{
                                    if (mensagem1.equals("DSistema - dsistema.com.br")){    
                                        mensagem1 = "DSistema - diegorangeljpa@gmail.com";
                                    }    
                                    }
                                    }
                                    sentido1 = "direito";
                                }
                            }   
                        }  
                    });  
                    Thread.sleep(100);   //padrao em 100
                }  
            }  
            catch (InterruptedException e) {  
            }  
        }  
    }

   
    public void mudaTituloDaJanela(String mensagem1){
        this.setTitle(mensagem1);
    }
    
    public void exibeOcultaJanelaInterna(JInternalFrame j){
        if (j.isVisible()){
            //Faça nada, pois janela já aberta
        }
        j.setVisible(true);
    }
    
    public void abreJanelaClienteDialogo(){        
//        if (empresaSalvaNoBD.getPerfil().equals("OticaMG")){
//            JanelaCadastraClienteOtica JanelaClienteOtica = new JanelaCadastraClienteOtica();
//            areaTrabalho.add(JanelaClienteOtica);
//            if (JanelaClienteOtica.isVisible()){
//                //Faça nada, pois janela já aberta
//            }
//            JanelaClienteOtica.setVisible(true);
//            JanelaClienteOtica.setPosicao();
//        }else{ 
//            if (empresaSalvaNoBD.getPerfil().equals("MOTOTAXI")){
//                    JanelaCadastraClienteMotoTaxi JanelaClienteMotoTaxi = new JanelaCadastraClienteMotoTaxi();
//                    areaTrabalho.add(JanelaClienteMotoTaxi);
//                    if (JanelaClienteMotoTaxi.isVisible()){
//                        //Faça nada, pois janela já aberta
//                    }
//                    JanelaClienteMotoTaxi.setVisible(true);
//                    JanelaClienteMotoTaxi.setPosicao();
//                }else{ 
//                    JanelaCadastraCliente JanelaCliente = new JanelaCadastraCliente();
//                    areaTrabalho.add(JanelaCliente);
//                    JanelaCliente.setVisible(true);
//                    JanelaCliente.setPosicao();
//                    limpar.apagaCamposCliente(JanelaCliente);
//                    co.preencheVendedoresJanelaCliente(JanelaCliente.campoVendedor);
//                    JanelaCliente.AbaPrincipal.setSelectedComponent(JanelaCliente.jPanel7);
//        }
//        }
        
        
    }
    
  
    
    public void abreJanelaJInternalFrameNoDesktopPane(JInternalFrame janela){
        areaTrabalho.add(janela);
        
        if (janela.isVisible()){
            //Faça nada, pois janela já aberta
        }
        janela.setVisible(true);
        //deixar janela no centro
        Dimension d = janela.getDesktopPane().getSize();  
        janela.setLocation((d.width - janela.getSize().width) / 2, (d.height - janela.getSize().height) / 2);
        //janela.setPosicao();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areaTrabalho = new javax.swing.JDesktopPane();
        painelStatus = new javax.swing.JPanel();
        campoStatus = new javax.swing.JTextField();
        campoPerfil = new javax.swing.JTextField();
        campoData = new javax.swing.JTextField();
        campoVersao = new javax.swing.JTextField();
        campoNomePerfil = new javax.swing.JTextField();
        campoNomeUsuario = new javax.swing.JTextField();
        campoLicenca = new javax.swing.JTextField();
        campoMensagem = new javax.swing.JTextField();
        campoCaminhoBanco = new javax.swing.JTextField();
        campoLogomarca = new javax.swing.JLabel();
        campoLogoDR = new javax.swing.JLabel();
        painelSuperior3 = new javax.swing.JPanel();
        botaoBuscar = new javax.swing.JButton();
        botaoUsuario = new javax.swing.JButton();
        botaoAtalhoRelatorios = new javax.swing.JButton();
        botaoBotao3 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuAgendamentos = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuReiniciar = new javax.swing.JMenuItem();
        menuDesligar = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        menuCadastros = new javax.swing.JMenu();
        menuProduto = new javax.swing.JMenuItem();
        menuGrupo = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        menurelatoriosGerais = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuFerramentas = new javax.swing.JMenu();
        menuConfig = new javax.swing.JMenuItem();
        menuGraficos = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        MenuAjuda = new javax.swing.JMenuItem();
        menuAtualizacao = new javax.swing.JMenuItem();
        menuAvisos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaTrabalho.setBackground(new java.awt.Color(153, 153, 153));
        areaTrabalho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                areaTrabalhoMouseClicked(evt);
            }
        });
        areaTrabalho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                areaTrabalhoKeyPressed(evt);
            }
        });

        campoStatus.setEditable(false);
        campoStatus.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        campoStatus.setText("Status: ?");

        campoPerfil.setEditable(false);
        campoPerfil.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        campoData.setEditable(false);
        campoData.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        campoData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoData.setText("Data");

        campoVersao.setEditable(false);
        campoVersao.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        campoVersao.setText("Versão: 0.0");

        campoNomePerfil.setEditable(false);
        campoNomePerfil.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        campoNomePerfil.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoNomePerfil.setText("Perfil:");

        campoNomeUsuario.setEditable(false);
        campoNomeUsuario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        campoNomeUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoNomeUsuario.setText("Usuário:");

        campoLicenca.setEditable(false);
        campoLicenca.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        campoLicenca.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoLicenca.setText("Licença:");

        campoMensagem.setEditable(false);
        campoMensagem.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        campoMensagem.setForeground(new java.awt.Color(0, 0, 153));
        campoMensagem.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        campoMensagem.setText("DSistema - dsistema.com.br");

        campoCaminhoBanco.setEditable(false);
        campoCaminhoBanco.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        javax.swing.GroupLayout painelStatusLayout = new javax.swing.GroupLayout(painelStatus);
        painelStatus.setLayout(painelStatusLayout);
        painelStatusLayout.setHorizontalGroup(
            painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoCaminhoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoLicenca, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNomePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoVersao, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        painelStatusLayout.setVerticalGroup(
            painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelStatusLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(painelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoVersao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNomePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoLicenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCaminhoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        campoLogomarca.setBackground(new java.awt.Color(153, 153, 153));
        campoLogomarca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        campoLogomarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoLogomarcaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campoLogomarcaMouseEntered(evt);
            }
        });
        campoLogomarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoLogomarcaKeyPressed(evt);
            }
        });

        campoLogoDR.setBackground(new java.awt.Color(153, 153, 153));
        campoLogoDR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        painelSuperior3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botaoBuscar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        botaoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sss/Imagem/icone_pesquisar.png"))); // NOI18N
        botaoBuscar.setText("Busca");
        botaoBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarActionPerformed(evt);
            }
        });

        botaoUsuario.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        botaoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sss/Imagem/icone_paciente.png"))); // NOI18N
        botaoUsuario.setText("Usuário");
        botaoUsuario.setEnabled(false);
        botaoUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoUsuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoUsuarioActionPerformed(evt);
            }
        });

        botaoAtalhoRelatorios.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        botaoAtalhoRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sss/Imagem/icone_impressao3.png"))); // NOI18N
        botaoAtalhoRelatorios.setText("Relatórios");
        botaoAtalhoRelatorios.setEnabled(false);
        botaoAtalhoRelatorios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoAtalhoRelatorios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoAtalhoRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtalhoRelatoriosActionPerformed(evt);
            }
        });

        botaoBotao3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        botaoBotao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sss/Imagem/icone_power_40x40.png"))); // NOI18N
        botaoBotao3.setText("Sair");
        botaoBotao3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoBotao3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoBotao3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBotao3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelSuperior3Layout = new javax.swing.GroupLayout(painelSuperior3);
        painelSuperior3.setLayout(painelSuperior3Layout);
        painelSuperior3Layout.setHorizontalGroup(
            painelSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperior3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(botaoBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoAtalhoRelatorios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoBotao3)
                .addContainerGap())
        );
        painelSuperior3Layout.setVerticalGroup(
            painelSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelSuperior3Layout.createSequentialGroup()
                .addGroup(painelSuperior3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(botaoAtalhoRelatorios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoBotao3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        areaTrabalho.setLayer(painelStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);
        areaTrabalho.setLayer(campoLogomarca, javax.swing.JLayeredPane.DEFAULT_LAYER);
        areaTrabalho.setLayer(campoLogoDR, javax.swing.JLayeredPane.DEFAULT_LAYER);
        areaTrabalho.setLayer(painelSuperior3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout areaTrabalhoLayout = new javax.swing.GroupLayout(areaTrabalho);
        areaTrabalho.setLayout(areaTrabalhoLayout);
        areaTrabalhoLayout.setHorizontalGroup(
            areaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelSuperior3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, areaTrabalhoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoLogoDR, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addComponent(campoLogomarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        areaTrabalhoLayout.setVerticalGroup(
            areaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(areaTrabalhoLayout.createSequentialGroup()
                .addComponent(painelSuperior3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(campoLogomarca, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoLogoDR, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        menuArquivo.setText("Arquivo");
        menuArquivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuAgendamentos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuAgendamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuAgendamentos.setText("Agendamentos");
        menuAgendamentos.setEnabled(false);
        menuAgendamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgendamentosActionPerformed(evt);
            }
        });
        menuArquivo.add(menuAgendamentos);

        jMenu1.setText("Windows");
        jMenu1.setEnabled(false);
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuReiniciar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuReiniciar.setText("Reiniciar Computador");
        menuReiniciar.setEnabled(false);
        menuReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReiniciarActionPerformed(evt);
            }
        });
        jMenu1.add(menuReiniciar);

        menuDesligar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuDesligar.setText("Desligar Computador");
        menuDesligar.setEnabled(false);
        menuDesligar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDesligarActionPerformed(evt);
            }
        });
        jMenu1.add(menuDesligar);

        menuArquivo.add(jMenu1);

        menuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuArquivo.add(menuSair);

        jMenuBar2.add(menuArquivo);

        menuCadastros.setText("Cadastros");
        menuCadastros.setEnabled(false);
        menuCadastros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuProduto.setText("Produtos");
        menuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProdutoActionPerformed(evt);
            }
        });
        menuCadastros.add(menuProduto);

        menuGrupo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        menuGrupo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuGrupo.setText("Grupos de produtos");
        menuGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGrupoActionPerformed(evt);
            }
        });
        menuCadastros.add(menuGrupo);

        menuUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        menuUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuUsuario.setText("Usuários");
        menuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuarioActionPerformed(evt);
            }
        });
        menuCadastros.add(menuUsuario);

        jMenuBar2.add(menuCadastros);

        menuRelatorios.setText("Relatórios");
        menuRelatorios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menurelatoriosGerais.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menurelatoriosGerais.setText("Relatórios Gerais");
        menurelatoriosGerais.setEnabled(false);
        menurelatoriosGerais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menurelatoriosGeraisActionPerformed(evt);
            }
        });
        menuRelatorios.add(menurelatoriosGerais);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem2.setText("Consulta Erros");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuRelatorios.add(jMenuItem2);

        jMenuBar2.add(menuRelatorios);

        menuFerramentas.setText("Ferramentas");
        menuFerramentas.setEnabled(false);
        menuFerramentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        menuConfig.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuConfig.setText("Configurações");
        menuConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConfigActionPerformed(evt);
            }
        });
        menuFerramentas.add(menuConfig);

        menuGraficos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuGraficos.setText("Gráficos");
        menuGraficos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGraficosActionPerformed(evt);
            }
        });
        menuFerramentas.add(menuGraficos);

        jMenuBar2.add(menuFerramentas);

        menuAjuda.setText("Ajuda");
        menuAjuda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        MenuAjuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        MenuAjuda.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuAjuda.setText("Obter Ajuda");
        MenuAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAjudaActionPerformed(evt);
            }
        });
        menuAjuda.add(MenuAjuda);

        menuAtualizacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuAtualizacao.setText("Verificar Atualização");
        menuAtualizacao.setEnabled(false);
        menuAtualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAtualizacaoActionPerformed(evt);
            }
        });
        menuAjuda.add(menuAtualizacao);

        menuAvisos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuAvisos.setText("Avisos");
        menuAvisos.setEnabled(false);
        menuAvisos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAvisosMouseClicked(evt);
            }
        });
        menuAvisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAvisosActionPerformed(evt);
            }
        });
        menuAjuda.add(menuAvisos);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setText("Reiniciar Tela Principal");
        jMenuItem1.setEnabled(false);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuAjuda.add(jMenuItem1);

        jMenuBar2.add(menuAjuda);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(areaTrabalho)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(areaTrabalho)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void menuConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConfigActionPerformed
        JanelaConfiguracao JanelaConfiguracao = new JanelaConfiguracao();
        areaTrabalho.add(JanelaConfiguracao);
        JanelaConfiguracao.setVisible(true);
        JanelaConfiguracao.setPosicao();
    }//GEN-LAST:event_menuConfigActionPerformed

    private void MenuAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAjudaActionPerformed
        JanelaAjuda JanelaAjuda = new JanelaAjuda();
        areaTrabalho.add(JanelaAjuda);
        JanelaAjuda.setVisible(true);
        JanelaAjuda.setPosicao();
    }//GEN-LAST:event_MenuAjudaActionPerformed

    private void menuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuarioActionPerformed
//        JanelaCadastraUsuario JanelaUsuario = new JanelaCadastraUsuario();
//        areaTrabalho.add(JanelaUsuario);
//        JanelaUsuario.setVisible(true);
//        JanelaUsuario.setPosicao();
    }//GEN-LAST:event_menuUsuarioActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        int Confirm = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair do sistema?","Sim ou Não", JOptionPane.YES_NO_OPTION);
        if (Confirm == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProdutoActionPerformed
        /**
        if (JanelaProduto.isVisible()){
            //Faça nada, pois janela já aberta
        }
        JanelaProduto.setVisible(true);
        JanelaProduto.setPosicao();
        */
    }//GEN-LAST:event_menuProdutoActionPerformed

    private void menuGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGrupoActionPerformed
//        JanelaCadastraGrupo JanelaGrupo = new JanelaCadastraGrupo();
//        areaTrabalho.add(JanelaGrupo);
//        JanelaGrupo.setVisible(true);
//        JanelaGrupo.setPosicao();
    }//GEN-LAST:event_menuGrupoActionPerformed

    private void menurelatoriosGeraisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menurelatoriosGeraisActionPerformed
        JanelaRelatoriosGerais JanelaRelatorios = new JanelaRelatoriosGerais();
        areaTrabalho.add(JanelaRelatorios);
        JanelaRelatorios.setVisible(true);
        JanelaRelatorios.setPosicao();
    }//GEN-LAST:event_menurelatoriosGeraisActionPerformed

    private void campoLogomarcaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoLogomarcaMouseEntered
        //areaTrabalho.setToolTipText("diegorangeljpa@gmail.com  (83) 99611-7574");
    }//GEN-LAST:event_campoLogomarcaMouseEntered

    private void areaTrabalhoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTrabalhoKeyPressed
        /**
        if (perfil != 4){
            //Funcao ao pressionar tecla
            if (evt.getKeyCode() == KeyEvent.VK_F7){
                if ((painelEsquerdo.isVisible()) || (painelDireito.isVisible())){
                    //Ja esta habilitado
                    painelEsquerdo.setVisible(false);
                    painelDireito.setVisible(false);
                }else{
                    painelEsquerdo.setVisible(true);
                    painelDireito.setVisible(true);
                } 
            }
        }
        */ 
    }//GEN-LAST:event_areaTrabalhoKeyPressed

    private void campoLogomarcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoLogomarcaKeyPressed
        /**
        if (perfil != 4){
            //Funcao ao pressionar tecla
            if (evt.getKeyCode() == KeyEvent.VK_F7){
                if ((painelEsquerdo.isVisible()) || (painelDireito.isVisible())){
                    //Ja esta habilitado
                    painelEsquerdo.setVisible(false);
                    painelDireito.setVisible(false);
                }else{
                    painelEsquerdo.setVisible(true);
                    painelDireito.setVisible(true);
                } 
            }
        }
        */ 
        
    }//GEN-LAST:event_campoLogomarcaKeyPressed

    private void campoLogomarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoLogomarcaMouseClicked
        areaTrabalho.requestFocus();
    }//GEN-LAST:event_campoLogomarcaMouseClicked

    private void areaTrabalhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaTrabalhoMouseClicked
        areaTrabalho.requestFocus();
    }//GEN-LAST:event_areaTrabalhoMouseClicked

    private void menuAgendamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgendamentosActionPerformed
        
    }//GEN-LAST:event_menuAgendamentosActionPerformed

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarActionPerformed
        JanelaPesquisaProtocolo janelaCadastroPaciente = new JanelaPesquisaProtocolo();
        areaTrabalho.add(janelaCadastroPaciente);
        janelaCadastroPaciente.setVisible(true);
        janelaCadastroPaciente.setPosicao();
    }//GEN-LAST:event_botaoBuscarActionPerformed

    private void botaoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoUsuarioActionPerformed
//        JanelaCadastroPaciente janelaCadastroPaciente = new JanelaCadastroPaciente();
//        areaTrabalho.add(janelaCadastroPaciente);
//        janelaCadastroPaciente.setVisible(true);
//        janelaCadastroPaciente.setPosicao();
        
    }//GEN-LAST:event_botaoUsuarioActionPerformed

    private void botaoAtalhoRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtalhoRelatoriosActionPerformed
        JanelaRelatoriosGerais JanelaRelatorios = new JanelaRelatoriosGerais();
        areaTrabalho.add(JanelaRelatorios);
        JanelaRelatorios.setVisible(true);
        JanelaRelatorios.setPosicao();
    }//GEN-LAST:event_botaoAtalhoRelatoriosActionPerformed

    private void botaoBotao3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBotao3ActionPerformed
        int Confirm = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair do sistema?","Sim ou Não", JOptionPane.YES_NO_OPTION);
        if (Confirm == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_botaoBotao3ActionPerformed

    private void menuAvisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAvisosActionPerformed
       
    }//GEN-LAST:event_menuAvisosActionPerformed

    private void menuAvisosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAvisosMouseClicked
       
    }//GEN-LAST:event_menuAvisosMouseClicked

    private void menuAtualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAtualizacaoActionPerformed
        JanelaAtualizacaoDialogo jc = new JanelaAtualizacaoDialogo(null, rootPaneCheckingEnabled);
        jc.show();
    }//GEN-LAST:event_menuAtualizacaoActionPerformed

    private void menuDesligarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDesligarActionPerformed
        int Confirm = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja desligar o computador?","Sim ou Não", JOptionPane.YES_NO_OPTION);
        if (Confirm == 0){
            try { 
                Process exec = Runtime.getRuntime().exec("init 0");
            } catch (IOException ex) {
                //Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_menuDesligarActionPerformed

    private void menuReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReiniciarActionPerformed
        int Confirm = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja reiniciar o computador?","Sim ou Não", JOptionPane.YES_NO_OPTION);
        if (Confirm == 0){
            //JOptionPane.showMessageDialog(null, "O Computador não pode ser reiniciado!");
            try {   
             Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start", "shutdown -r -t 0"});
            } catch (Exception ex) {   
                 //XXXXXXXXXXXXXXXXXnull,"Erro",ex.toString(),JOptionPane.ERROR_MESSAGE);   
            }
        }
    }//GEN-LAST:event_menuReiniciarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JanelaPrincipal j = new JanelaPrincipal();
        //Chama a tela principal                                     
        j.campoNomeUsuario.setText(campoNomeUsuario.getText());
        //j.usuarioRodape = nomeUsuario;
        co.criaArquivoUsuarioLogado(campoNomeUsuario.getText());
        j.show();
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuGraficosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGraficosActionPerformed
        JanelaLoginAutorizacaoDialogo jc = new JanelaLoginAutorizacaoDialogo(null, rootPaneCheckingEnabled);
        jc.numeroDaPermissao = 8;
        String usuario = campoNomeUsuario.getText();
        usuario = usuario.replace("Usuário: ","");
        jc.campoUsuario.setText(usuario);
        jc.show();
        if (jc.resultadoAutorizacao == true){  
            JanelaGraficosDialogo jcc = new JanelaGraficosDialogo(null, rootPaneCheckingEnabled);
            jcc.show();
        }
    }//GEN-LAST:event_menuGraficosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        JanelaConsultaErros janelaCadastroPaciente = new JanelaConsultaErros();
        areaTrabalho.add(janelaCadastroPaciente);
        janelaCadastroPaciente.setVisible(true);
        janelaCadastroPaciente.setPosicao();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem MenuAjuda;
    public javax.swing.JDesktopPane areaTrabalho;
    public javax.swing.JButton botaoAtalhoRelatorios;
    public javax.swing.JButton botaoBotao3;
    public javax.swing.JButton botaoBuscar;
    public javax.swing.JButton botaoUsuario;
    public javax.swing.JTextField campoCaminhoBanco;
    public javax.swing.JTextField campoData;
    public javax.swing.JTextField campoLicenca;
    public javax.swing.JLabel campoLogoDR;
    public javax.swing.JLabel campoLogomarca;
    public javax.swing.JTextField campoMensagem;
    public javax.swing.JTextField campoNomePerfil;
    public javax.swing.JTextField campoNomeUsuario;
    public javax.swing.JTextField campoPerfil;
    public javax.swing.JTextField campoStatus;
    public javax.swing.JTextField campoVersao;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JMenuItem menuAgendamentos;
    public javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    public javax.swing.JMenuItem menuAtualizacao;
    public javax.swing.JMenuItem menuAvisos;
    public javax.swing.JMenu menuCadastros;
    public javax.swing.JMenuItem menuConfig;
    private javax.swing.JMenuItem menuDesligar;
    public javax.swing.JMenu menuFerramentas;
    public javax.swing.JMenuItem menuGraficos;
    public javax.swing.JMenuItem menuGrupo;
    public javax.swing.JMenuItem menuProduto;
    private javax.swing.JMenuItem menuReiniciar;
    public javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenuItem menuSair;
    public javax.swing.JMenuItem menuUsuario;
    public javax.swing.JMenuItem menurelatoriosGerais;
    private javax.swing.JPanel painelStatus;
    public javax.swing.JPanel painelSuperior3;
    // End of variables declaration//GEN-END:variables
}
