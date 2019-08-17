

package br.com.sss.View;

import br.com.sss.Control.CaminhoImagem;
import br.com.sss.Control.Clean;
import br.com.sss.Control.ControllerGeral;
//import br.com.sss.Control.ModificaJanelaPeloPerfil;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import br.com.sss.Control.GeradorPDF;
import br.com.sss.Control.MensagemErro;
//import com.itextpdf.text.DocumentException;
//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Diego Rangel  
 */

public class JanelaCadastraProduto extends javax.swing.JInternalFrame {
    
    CaminhoImagem caminhoImagemIcone = new CaminhoImagem();
    Clean limpar = new Clean();
    ControllerGeral c = new ControllerGeral();
    //public String perfil = "Teste";
    //ModificaJanelaPeloPerfil modificaJanelaPeloPerfil = new ModificaJanelaPeloPerfil();
    GeradorPDF geraPDF = new GeradorPDF();
    MensagemErro mensagemErro = new MensagemErro();
    
    /**
     * Creates new form JanelaCadastraProduto
     */
    
    public JanelaCadastraProduto() {
        initComponents();
        super.setTitle("Cadastro de Produtos");
        super.setResizable(true);
        
        //Verifica o caminho do banco de dados salvo no caminhoBD.txt
        c.VerificaCaminhoDoBancoDeDados(c);
        
        //Muda icone da Janela interna
        setFrameIcon(new ImageIcon(this.getClass().getResource(caminhoImagemIcone.getCaminho())));
//        
//        //Atualiza os grupos e fornecedores 
//        c.atualizaGrupoNaJanela(this);
//        c.atualizaFornecedorNaJanela(this);
//        
//        //Preenche a margem
//        campoMargem.setText(c.RetornaMargemAtualEmInteiro()+"");
//        campoMargem1.setText(c.RetornaMargemAtualEmInteiro()+"");
//        
//        c.PreencheTabelaComposicoes(tabelaComposicoes);
//        
//        //preenche markup
//        campoMarkup.setText(c.RetornaMarkupDesconto());
//        campoMarkup1.setText(c.RetornaMarkupDesconto());
//        
//        //Preencho o imposto salvo no banco
//        campoPrecoNF8.setText(c.RetornaImposto());
//        
//        //Preenche a camissao
//        //campoPrecoNF9.setText(c.RetornaValorDaComissao());
//        
//        //Inicia os campos pra adicionar a materia prima ocultos
//        NomeID.setVisible(false);
//        nomeMateriaPrima.setVisible(false);
//        nomeQuant.setVisible(false);
//        nomeCusto.setVisible(false);
//        campoIDMateriaPrima.setVisible(false);
//        campoNomeMateriaPrima.setVisible(false);
//        campoQuantMateriaPrima.setVisible(false);
//        campoCustoDaMateriaPrima.setVisible(false);
//        
//        //Adicionar funcao de perder foco pra recalcular os valores de desconto
//        campoMargem1.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                calculaPrecoPelaMargem();
//            }
//        });
//        
//        //adicionar funcao para recalcular os custos de chegada
//        //campoPrecoNF2.getText(), campoPrecoNF3.getText(), campoPrecoNF4.getText(), campoPrecoNF5.getText(), campoPrecoNF6.getText()));
//        campoPrecoNF2.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                atualizaValoresDeEntradaDoProduto();
//            }
//        });
//        campoPrecoNF3.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                atualizaValoresDeEntradaDoProduto();
//            }
//        });
//        campoPrecoNF4.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                atualizaValoresDeEntradaDoProduto();
//            }
//        });
//        campoPrecoNF5.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                atualizaValoresDeEntradaDoProduto();
//            }
//        });
//        campoPrecoNF6.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                atualizaValoresDeEntradaDoProduto();
//            }
//        });
//        
//        campoMarkup1.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                atualizaValoresDeEntradaDoProduto();
//                atualizaValoresDeSaidaDoProduto();
//                calculaPrecoPelaMargem();
//            }
//        });
//        
//        
//        
//        //Abrir como perfil de consulta
//        //Verifica validade da licenca
//        String dataVencimentoLicenca = c.retornaValidadeDaLicenca();
//        boolean respostaDaValidadeLicenca = c.ValidaLicenca();
//        if (respostaDaValidadeLicenca == false){
//            JButton botao = new JButton();
//            modificaJanelaPeloPerfil.Desabilita4BotoesParaPerfilDeConsultaNeJanela (botaoCadastrar, botaoAlterar, botaoExcluir, botao);            
//        }
//        
//        habilitaDesabilitaCampoMakupConformeConfiguracaoMarcada();
//        
//        campoMargem1.setText(c.RetornaMargemAtual2()+"");
//        campoMarkup1.setText(c.RetornaMarkupDesconto());
//        
//        //c.verificaFormatoDoPrecoDosProdutos();
//        c.preencheProdutosNoCampoProdutoMae(campoProdutoMae);
//        AutoCompleteDecorator.decorate(campoProdutoMae);
//        
    }
    
    public void GravarStatusDoProdutoInativo(){
        if (campoCodigo.getText().equals("")){
            //JOptionPane.showMessageDialog(rootPane, "Escolha um produto para Ativar/Inativar!");
        }else{
            String status = "ativo";
            if (campoInativo.isSelected()){
                status = "inativo";
            }
            int Confirm2 = JOptionPane.showConfirmDialog(null,"Deseja Ativar/Inativar?","Sim ou Não", JOptionPane.YES_NO_OPTION);
            if (Confirm2 == 0){
//               c.AtivaInativaProduto(campoCodigo.getText(),status);
            }
        } 
    }
    
    public void calculaPrecoPelaMargem(){
        if (campoPrecoImpo2.getText().equals("")){
            //Sem preco NF + impostos
        }else{if (campoPrecoImpo3.getText().equals("")){
                //Sem custos de saida
            }else{if (campoMargem1.getText().equals("")){
                //Sem margem
//                campoSugestao1.setText(c.calculaSugestaoDePrecoPelaMargem(campoPrecoImpo2.getText(),campoPrecoImpo3.getText(),"0,00"));
                }else{
//                campoSugestao1.setText(c.calculaSugestaoDePrecoPelaMargem(campoPrecoImpo2.getText(),campoPrecoImpo3.getText(),campoMargem1.getText()));
            }            
            }            
        }       
        
    }
    
    public void atualizaValoresDeEntradaDoProduto(){
//        campoPrecoImpo2.setText(c.somaValoresImpostosDeEntrada(campoPrecoNF2.getText(), campoPrecoNF3.getText(), campoPrecoNF4.getText(), campoPrecoNF5.getText(), campoPrecoNF6.getText()));
    }
    
    public void atualizaValoresDeSaidaDoProduto(){
//        campoPrecoImpo3.setText(c.somaValoresImpostosDeSaida(campoPrecoNF7.getText(),campoPrecoNF8.getText(),campoPrecoNF9.getText(),campoPrecoNF10.getText(),campoPrecoNF11.getText(),campoPrecoNF12.getText()));
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
        jPanel1 = new javax.swing.JPanel();
        campoDescricaoProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        campoCodigoBarras = new javax.swing.JTextField();
        campoCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoPis = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        campoSituacao = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        campoIcm = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campoNCM = new javax.swing.JTextField();
        botaoExcluir1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        campoUnidade = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        campoEstoque = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        botaoCadastrar = new javax.swing.JButton();
        botaoPesquisa = new javax.swing.JButton();
        botaoAlterar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        campoObs = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        campoFornecedor = new javax.swing.JComboBox();
        campoGrupo = new javax.swing.JComboBox();
        botaoSair = new javax.swing.JButton();
        campoPrecoVenda = new javax.swing.JFormattedTextField();
        campoPrecoNF = new javax.swing.JFormattedTextField();
        campoPrecoImpo = new javax.swing.JFormattedTextField();
        jLabel38 = new javax.swing.JLabel();
        campoPeso = new javax.swing.JFormattedTextField();
        jLabel51 = new javax.swing.JLabel();
        campoReferencia = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        caixaMarcarTodosProdutosEstoque = new javax.swing.JCheckBox();
        botaoRelacaoEstoque = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        caixaMarcarTodosProdutosEstoqueZero = new javax.swing.JCheckBox();
        jPanel19 = new javax.swing.JPanel();
        caixaMarcarEstoqueCritico = new javax.swing.JCheckBox();
        botaoRelacaoEstoque1 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        caixaMarcarTodosProdutos = new javax.swing.JCheckBox();
        botaoRelacaoPreco = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        caixaMarcarTodosPrecoMaisEstoque = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        campoDescricaoProduto1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        campoCodigoBarras1 = new javax.swing.JTextField();
        campoCodigo1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        botaoAlterarAvancado = new javax.swing.JButton();
        botaoLimparAvancado = new javax.swing.JButton();
        botaoSair2 = new javax.swing.JButton();
        campoPrecoVenda1 = new javax.swing.JFormattedTextField();
        jLabel30 = new javax.swing.JLabel();
        campoUltimaNF = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        campoMargem = new javax.swing.JFormattedTextField();
        jLabel33 = new javax.swing.JLabel();
        campoSugestao = new javax.swing.JFormattedTextField();
        jLabel28 = new javax.swing.JLabel();
        campoPrecoNF1 = new javax.swing.JFormattedTextField();
        jLabel29 = new javax.swing.JLabel();
        campoPrecoImpo1 = new javax.swing.JFormattedTextField();
        jLabel39 = new javax.swing.JLabel();
        botaoSugerirPreco = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        campoMarkup = new javax.swing.JFormattedTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        campoPreco2 = new javax.swing.JFormattedTextField();
        jLabel35 = new javax.swing.JLabel();
        campoPreco3 = new javax.swing.JFormattedTextField();
        jLabel36 = new javax.swing.JLabel();
        campoPreco4 = new javax.swing.JFormattedTextField();
        jLabel37 = new javax.swing.JLabel();
        campoEstoqueMinimo = new javax.swing.JFormattedTextField();
        jLabel44 = new javax.swing.JLabel();
        campoLucro = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        campoInativo = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        campoProdutoMae = new javax.swing.JComboBox();
        campoConversor = new javax.swing.JFormattedTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        pesquisarHistorico = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        campoCodigoProdutoHistorico = new javax.swing.JTextField();
        campoNomeProdutoHistorico = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaHistorico = new javax.swing.JTable();
        pesquisarHistorico1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        campoIDProdutoFinal = new javax.swing.JTextField();
        campoNomeProdutoFinal = new javax.swing.JComboBox();
        campoIDMateriaPrima = new javax.swing.JTextField();
        NomeID = new javax.swing.JLabel();
        nomeMateriaPrima = new javax.swing.JLabel();
        nomeQuant = new javax.swing.JLabel();
        campoQuantMateriaPrima = new javax.swing.JFormattedTextField();
        PainelTabelaProdutos = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        botaoExcluiProduto = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        campoCustoTotal2 = new javax.swing.JFormattedTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaComposicoes = new javax.swing.JTable();
        botaoSalvarComposicao = new javax.swing.JButton();
        botaoLimparComposicao = new javax.swing.JButton();
        campoNomeMateriaPrima = new javax.swing.JComboBox();
        nomeCusto = new javax.swing.JLabel();
        campoCustoDaMateriaPrima = new javax.swing.JFormattedTextField();
        botaoLimparComposicao1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        campoDescricaoProduto2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        campoCodigoBarras2 = new javax.swing.JTextField();
        campoCodigo2 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        botaoAlterarAvancado1 = new javax.swing.JButton();
        botaoLimparAvancado1 = new javax.swing.JButton();
        botaoSair3 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        campoMargem1 = new javax.swing.JFormattedTextField();
        jLabel60 = new javax.swing.JLabel();
        campoSugestao1 = new javax.swing.JFormattedTextField();
        botaoSugerirPreco1 = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        campoMarkup1 = new javax.swing.JFormattedTextField();
        jLabel53 = new javax.swing.JLabel();
        campoPrecoVenda2 = new javax.swing.JFormattedTextField();
        jLabel66 = new javax.swing.JLabel();
        campoPreco5 = new javax.swing.JFormattedTextField();
        jLabel67 = new javax.swing.JLabel();
        campoPreco6 = new javax.swing.JFormattedTextField();
        jLabel68 = new javax.swing.JLabel();
        campoPreco7 = new javax.swing.JFormattedTextField();
        jLabel70 = new javax.swing.JLabel();
        campoLucro1 = new javax.swing.JFormattedTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        campoPrecoNF2 = new javax.swing.JFormattedTextField();
        jLabel62 = new javax.swing.JLabel();
        campoPrecoImpo2 = new javax.swing.JFormattedTextField();
        jLabel69 = new javax.swing.JLabel();
        campoPrecoNF3 = new javax.swing.JFormattedTextField();
        jLabel71 = new javax.swing.JLabel();
        campoPrecoNF4 = new javax.swing.JFormattedTextField();
        jLabel72 = new javax.swing.JLabel();
        campoPrecoNF5 = new javax.swing.JFormattedTextField();
        jLabel73 = new javax.swing.JLabel();
        campoPrecoNF6 = new javax.swing.JFormattedTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        campoPrecoNF7 = new javax.swing.JFormattedTextField();
        jLabel65 = new javax.swing.JLabel();
        campoPrecoImpo3 = new javax.swing.JFormattedTextField();
        jLabel74 = new javax.swing.JLabel();
        campoPrecoNF8 = new javax.swing.JFormattedTextField();
        jLabel75 = new javax.swing.JLabel();
        campoPrecoNF9 = new javax.swing.JFormattedTextField();
        jLabel76 = new javax.swing.JLabel();
        campoPrecoNF10 = new javax.swing.JFormattedTextField();
        jLabel77 = new javax.swing.JLabel();
        campoPrecoNF11 = new javax.swing.JFormattedTextField();
        campoPrecoNF12 = new javax.swing.JFormattedTextField();
        jLabel78 = new javax.swing.JLabel();
        CaixaMarcarMakup = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTabbedPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPane1KeyPressed(evt);
            }
        });

        campoDescricaoProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoDescricaoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoDescricaoProdutoKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Descrição");

        campoCodigoBarras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        campoCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Código de barras");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Código interno");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Preço de venda");

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Informações Fiscais");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Pis Cofins");

        campoPis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoPis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01-Oper.Trib.(base de calculo = valor da Oper.aliquota normal (cumulativo/nao cumulativo))", "02-Oper.Trib.(base de calculo = valor da Oper.(aliquota diferenciada))", "03-Oper.Trib.(base de calculo = quantidade vendida x aliquota por unidade de produto)", "04-Oper.Trib.(tributacao monofasica (aliquota zero))", "06-Oper.Trib.(aliquota zero)", "07-Oper.Isenta da Contribuicao", "08-Oper.Sem Incidencia da Contribuicao", "09-Oper.com Suspensao da Contribuicao", "99-Outras Operacoes" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Situação tributária");

        campoSituacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoSituacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "18%", "20%", "27%", "ISENTO", "NÃO INCIDENCIA", "REDUZIDO PARA 11%", "REDUZIDO PARA 5", "6%", "REDUZIDO PARA 7%", "REDUZIDO PARA 8", "8%", "SERVIÇO", "SUBSTITUIÇÃO TRIBUTÁRIA" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("ICM de venda");

        campoIcm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoIcm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoIcmFocusGained(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("NCM");

        campoNCM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        botaoExcluir1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        botaoExcluir1.setText("NCM");
        botaoExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(campoPis, 0, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(campoSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(campoIcm, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(campoNCM, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(botaoExcluir1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoSituacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoIcm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Preço NF");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Preço NF + Imp.");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Unidade de medida");

        campoUnidade.setEditable(true);
        campoUnidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoUnidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UND", "UN", "MT", "M2", "M3", "LT", "KG" }));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Estoque");

        campoEstoque.setEditable(false);
        campoEstoque.setBackground(new java.awt.Color(204, 204, 204));
        campoEstoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Fornecedor");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Grupo");

        botaoCadastrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botaoCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_salvar.png"))); // NOI18N
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoPesquisa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botaoPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_pesquisar.png"))); // NOI18N
        botaoPesquisa.setText("Pesquisar");
        botaoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisaActionPerformed(evt);
            }
        });

        botaoAlterar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botaoAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_alterar.png"))); // NOI18N
        botaoAlterar.setText("Alterar");
        botaoAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarActionPerformed(evt);
            }
        });

        botaoExcluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_excluir.png"))); // NOI18N
        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoLimpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botaoLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_limpar.png"))); // NOI18N
        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Observação");

        campoObs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cód Barras", "Descrição", "Pço Venda", "Pço NF", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProduto);
        if (tabelaProduto.getColumnModel().getColumnCount() > 0) {
            tabelaProduto.getColumnModel().getColumn(0).setPreferredWidth(2);
            tabelaProduto.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabelaProduto.getColumnModel().getColumn(2).setPreferredWidth(300);
            tabelaProduto.getColumnModel().getColumn(3).setPreferredWidth(10);
            tabelaProduto.getColumnModel().getColumn(4).setPreferredWidth(10);
            tabelaProduto.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        campoFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoFornecedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        campoFornecedor.setSelectedItem("");
        campoFornecedor.setToolTipText("");

        campoGrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));
        campoGrupo.setSelectedItem("");
        campoGrupo.setToolTipText("");

        botaoSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botaoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_sair.png"))); // NOI18N
        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        campoPrecoVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoPrecoVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        campoPrecoNF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoPrecoNF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        campoPrecoImpo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoPrecoImpo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Peso da unidade");

        campoPeso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.000"))));
        campoPeso.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        campoPeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Referência");

        campoReferencia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(campoPrecoNF, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(campoPrecoImpo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoObs)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(campoPrecoVenda)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(campoUnidade, 0, 0, Short.MAX_VALUE)
                                        .addGap(391, 391, 391)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel51))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoEstoque)
                            .addComponent(jLabel13)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoPeso)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botaoCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoSair))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(campoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(campoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoDescricaoProduto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCodigoBarras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPrecoVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoUnidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoReferencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPeso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPrecoNF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPrecoImpo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoObs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoEstoque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoFornecedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoGrupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrar)
                    .addComponent(botaoPesquisa)
                    .addComponent(botaoAlterar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoLimpar)
                    .addComponent(botaoSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Produto", jPanel1);

        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        caixaMarcarTodosProdutosEstoque.setText("Relação completa");
        caixaMarcarTodosProdutosEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaMarcarTodosProdutosEstoqueActionPerformed(evt);
            }
        });

        botaoRelacaoEstoque.setText("Visualizar Relação");
        botaoRelacaoEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRelacaoEstoqueActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Relação com estoque");

        caixaMarcarTodosProdutosEstoqueZero.setText("Com estoque zero");
        caixaMarcarTodosProdutosEstoqueZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaMarcarTodosProdutosEstoqueZeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(caixaMarcarTodosProdutosEstoqueZero, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoRelacaoEstoque)
                            .addComponent(caixaMarcarTodosProdutosEstoque))
                        .addGap(0, 45, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(caixaMarcarTodosProdutosEstoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caixaMarcarTodosProdutosEstoqueZero)
                .addGap(21, 21, 21)
                .addComponent(botaoRelacaoEstoque)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        caixaMarcarEstoqueCritico.setText("Relação de produtos com estoque crítico");
        caixaMarcarEstoqueCritico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaMarcarEstoqueCriticoActionPerformed(evt);
            }
        });

        botaoRelacaoEstoque1.setText("Visualizar Relação");
        botaoRelacaoEstoque1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRelacaoEstoque1ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Relação");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoRelacaoEstoque1)
                .addGap(50, 50, 50))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(caixaMarcarEstoqueCritico)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caixaMarcarEstoqueCritico)
                .addGap(45, 45, 45)
                .addComponent(botaoRelacaoEstoque1)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Relatórios relacionado a produtos");

        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        caixaMarcarTodosProdutos.setText("Todos");

        botaoRelacaoPreco.setText("Visualizar Relação");
        botaoRelacaoPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRelacaoPrecoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Relação com preço");

        caixaMarcarTodosPrecoMaisEstoque.setText("Preço + Estoque");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(botaoRelacaoPreco)
                        .addGap(0, 62, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(caixaMarcarTodosPrecoMaisEstoque)
                    .addComponent(caixaMarcarTodosProdutos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(caixaMarcarTodosProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caixaMarcarTodosPrecoMaisEstoque)
                .addGap(21, 21, 21)
                .addComponent(botaoRelacaoPreco)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(263, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Relatórios", jPanel2);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        campoDescricaoProduto1.setBackground(new java.awt.Color(204, 204, 204));
        campoDescricaoProduto1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Descrição");

        campoCodigoBarras1.setBackground(new java.awt.Color(204, 204, 204));
        campoCodigoBarras1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        campoCodigo1.setBackground(new java.awt.Color(204, 204, 204));
        campoCodigo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Código de barras");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Código interno");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Preço de venda");

        botaoAlterarAvancado.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        botaoAlterarAvancado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_alterar.png"))); // NOI18N
        botaoAlterarAvancado.setText("Alterar");
        botaoAlterarAvancado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoAlterarAvancado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoAlterarAvancado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAlterarAvancadoActionPerformed(evt);
            }
        });

        botaoLimparAvancado.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        botaoLimparAvancado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_limpar.png"))); // NOI18N
        botaoLimparAvancado.setText("Limpar");
        botaoLimparAvancado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoLimparAvancado.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoLimparAvancado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparAvancadoActionPerformed(evt);
            }
        });

        botaoSair2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        botaoSair2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_sair.png"))); // NOI18N
        botaoSair2.setText("Sair");
        botaoSair2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botaoSair2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botaoSair2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSair2ActionPerformed(evt);
            }
        });

        campoPrecoVenda1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoPrecoVenda1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Última NF");

        campoUltimaNF.setEditable(false);
        campoUltimaNF.setBackground(new java.awt.Color(204, 204, 204));
        campoUltimaNF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoUltimaNF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Precificação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Margem de lucro");

        campoMargem.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoMargem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Sugestão de Pç");

        campoSugestao.setEditable(false);
        campoSugestao.setBackground(new java.awt.Color(204, 204, 204));
        campoSugestao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoSugestao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Preço NF");

        campoPrecoNF1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoPrecoNF1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Preço NF + Imp.");

        campoPrecoImpo1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoPrecoImpo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("%");

        botaoSugerirPreco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botaoSugerirPreco.setText("Atualizar sugestão Preço");
        botaoSugerirPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSugerirPrecoActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Markup");

        campoMarkup.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoMarkup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("%");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(campoMargem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(campoMarkup, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(campoSugestao)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSugerirPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(campoPrecoNF1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(campoPrecoImpo1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(campoMarkup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(campoMargem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)
                            .addComponent(campoSugestao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoSugerirPreco)
                            .addComponent(campoPrecoNF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPrecoImpo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Preço 2");

        campoPreco2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoPreco2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Preço 3");

        campoPreco3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoPreco3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Preço 4");

        campoPreco4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoPreco4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Est. mínimo");

        campoEstoqueMinimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoEstoqueMinimo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Lucro Previsto");

        campoLucro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        campoLucro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Marque para inativar e altere ->");

        campoInativo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoInativo.setText("Inativo");
        campoInativo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoInativoKeyPressed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Debitar estoque do produto mãe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Produto mãe");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Fator Conversor");

        campoProdutoMae.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        campoConversor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.0000"))));
        campoConversor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(campoProdutoMae, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoConversor, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoProdutoMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoConversor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel26))
                        .addGap(29, 29, 29)))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(botaoAlterarAvancado, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoLimparAvancado, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoSair2))
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDescricaoProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCodigoBarras1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(campoCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(campoUltimaNF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoPrecoVenda1)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel30))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34)
                                    .addComponent(campoPreco2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(campoPreco3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(campoPreco4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(campoLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoInativo))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel44)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoDescricaoProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCodigoBarras1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoPrecoVenda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoPreco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoPreco3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoEstoqueMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPreco4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoUltimaNF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoLucro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoInativo)
                        .addComponent(jLabel23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAlterarAvancado)
                    .addComponent(botaoLimparAvancado)
                    .addComponent(botaoSair2))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Avançado", jPanel4);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Pesquisar histórico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        pesquisarHistorico.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pesquisarHistorico.setText("Pesquisar");
        pesquisarHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarHistoricoActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Código do produto");

        campoCodigoProdutoHistorico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        campoNomeProdutoHistorico.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        campoNomeProdutoHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeProdutoHistoricoActionPerformed(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Nome do Produto");

        tabelaHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Produto", "Histórico", "Cred.", "Deb.", "Estoque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaHistoricoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaHistorico);
        if (tabelaHistorico.getColumnModel().getColumnCount() > 0) {
            tabelaHistorico.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabelaHistorico.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabelaHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabelaHistorico.getColumnModel().getColumn(3).setPreferredWidth(10);
            tabelaHistorico.getColumnModel().getColumn(4).setPreferredWidth(10);
            tabelaHistorico.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        pesquisarHistorico1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pesquisarHistorico1.setText("Limpar");
        pesquisarHistorico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarHistorico1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCodigoProdutoHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNomeProdutoHistorico))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(pesquisarHistorico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pesquisarHistorico1)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(campoCodigoProdutoHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(campoNomeProdutoHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarHistorico)
                    .addComponent(pesquisarHistorico1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(299, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Histórico", jPanel8);

        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel42.setText("ID");

        jLabel43.setText("Produto Final");

        campoIDProdutoFinal.setEditable(false);

        campoNomeProdutoFinal.setEditable(true);

        campoIDMateriaPrima.setEditable(false);
        campoIDMateriaPrima.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoIDMateriaPrimaFocusGained(evt);
            }
        });

        NomeID.setText("ID");

        nomeMateriaPrima.setText("Matéria prima");

        nomeQuant.setText("Quant");

        campoQuantMateriaPrima.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        campoQuantMateriaPrima.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoQuantMateriaPrimaFocusGained(evt);
            }
        });
        campoQuantMateriaPrima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoQuantMateriaPrimaKeyPressed(evt);
            }
        });

        PainelTabelaProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder("Matéria prima"));

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] { },
            new String [] {
                "ID","Matéria prima","Quant"
            }
        )
        {}
    );
    scrollTable.setViewportView(tabelaProdutos);

    botaoExcluiProduto.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
    botaoExcluiProduto.setText("Excluir Produto");
    botaoExcluiProduto.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoExcluiProdutoActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout PainelTabelaProdutosLayout = new javax.swing.GroupLayout(PainelTabelaProdutos);
    PainelTabelaProdutos.setLayout(PainelTabelaProdutosLayout);
    PainelTabelaProdutosLayout.setHorizontalGroup(
        PainelTabelaProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(PainelTabelaProdutosLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(PainelTabelaProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PainelTabelaProdutosLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(botaoExcluiProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PainelTabelaProdutosLayout.createSequentialGroup()
                    .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    PainelTabelaProdutosLayout.setVerticalGroup(
        PainelTabelaProdutosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(PainelTabelaProdutosLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(botaoExcluiProduto)
            .addGap(31, 31, 31))
    );

    jLabel47.setText("Custo");

    campoCustoTotal2.setEditable(false);
    campoCustoTotal2.setBackground(new java.awt.Color(204, 204, 204));
    campoCustoTotal2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####.##"))));
    campoCustoTotal2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoCustoTotal2.setText("0,00");
    campoCustoTotal2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

    jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel48.setText("Composição");

    jLabel49.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
    jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel49.setText("Composições montadas");

    tabelaComposicoes.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
        },
        new String [] {
            "ID", "Produto Final", "Custo"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    tabelaComposicoes.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tabelaComposicoesMouseClicked(evt);
        }
    });
    jScrollPane5.setViewportView(tabelaComposicoes);
    if (tabelaComposicoes.getColumnModel().getColumnCount() > 0) {
        tabelaComposicoes.getColumnModel().getColumn(0).setPreferredWidth(5);
        tabelaComposicoes.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabelaComposicoes.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    botaoSalvarComposicao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    botaoSalvarComposicao.setText("Salvar");
    botaoSalvarComposicao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoSalvarComposicaoActionPerformed(evt);
        }
    });

    botaoLimparComposicao.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    botaoLimparComposicao.setText("Limpar");
    botaoLimparComposicao.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoLimparComposicaoActionPerformed(evt);
        }
    });

    campoNomeMateriaPrima.setEditable(true);

    nomeCusto.setText("Custo");

    campoCustoDaMateriaPrima.setEditable(false);
    campoCustoDaMateriaPrima.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
    campoCustoDaMateriaPrima.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            campoCustoDaMateriaPrimaFocusGained(evt);
        }
    });
    campoCustoDaMateriaPrima.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            campoCustoDaMateriaPrimaKeyPressed(evt);
        }
    });

    botaoLimparComposicao1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
    botaoLimparComposicao1.setText("Habilitar alterações");
    botaoLimparComposicao1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoLimparComposicao1ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addComponent(botaoSalvarComposicao)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(botaoLimparComposicao1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(botaoLimparComposicao, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel47)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(campoCustoTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(PainelTabelaProdutos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campoIDMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NomeID)
                        .addComponent(campoIDProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel43)
                                .addComponent(campoNomeProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nomeMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoNomeMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nomeQuant)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(campoQuantMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nomeCusto)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(campoCustoDaMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGap(56, 56, 56))
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE))
            .addContainerGap())
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addGap(68, 68, 68)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel11Layout.setVerticalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel48)
            .addGap(17, 17, 17)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel42))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoIDProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNomeProdutoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NomeID)
                        .addComponent(nomeMateriaPrima))
                    .addGap(5, 5, 5)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoIDMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNomeMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addComponent(nomeQuant)
                    .addGap(5, 5, 5)
                    .addComponent(campoQuantMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addComponent(nomeCusto)
                    .addGap(5, 5, 5)
                    .addComponent(campoCustoDaMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(PainelTabelaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoCustoTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel47)
                .addComponent(botaoSalvarComposicao)
                .addComponent(botaoLimparComposicao)
                .addComponent(botaoLimparComposicao1))
            .addGap(5, 5, 5)
            .addComponent(jLabel49)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel10Layout.createSequentialGroup()
            .addGap(141, 141, 141)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(275, Short.MAX_VALUE))
    );
    jPanel10Layout.setVerticalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel10Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(5, 5, 5))
    );

    jTabbedPane1.addTab("Composição", jPanel10);

    jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    campoDescricaoProduto2.setBackground(new java.awt.Color(204, 204, 204));
    campoDescricaoProduto2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel31.setText("Descrição");

    campoCodigoBarras2.setBackground(new java.awt.Color(204, 204, 204));
    campoCodigoBarras2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    campoCodigo2.setBackground(new java.awt.Color(204, 204, 204));
    campoCodigo2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel50.setText("Código de barras");

    jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel52.setText("Código interno");

    botaoAlterarAvancado1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
    botaoAlterarAvancado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_alterar.png"))); // NOI18N
    botaoAlterarAvancado1.setText("Alterar");
    botaoAlterarAvancado1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    botaoAlterarAvancado1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    botaoAlterarAvancado1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoAlterarAvancado1ActionPerformed(evt);
        }
    });

    botaoLimparAvancado1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
    botaoLimparAvancado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_limpar.png"))); // NOI18N
    botaoLimparAvancado1.setText("Limpar");
    botaoLimparAvancado1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    botaoLimparAvancado1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    botaoLimparAvancado1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoLimparAvancado1ActionPerformed(evt);
        }
    });

    botaoSair3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
    botaoSair3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br.com.sss.Imagem/icone_sair.png"))); // NOI18N
    botaoSair3.setText("Sair");
    botaoSair3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    botaoSair3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    botaoSair3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoSair3ActionPerformed(evt);
        }
    });

    jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Precificação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

    jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel59.setText("Margem (%)");

    campoMargem1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoMargem1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel60.setText("Sugestão de Pç");

    campoSugestao1.setEditable(false);
    campoSugestao1.setBackground(new java.awt.Color(204, 204, 204));
    campoSugestao1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoSugestao1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoSugestao1.setText("0,00");
    campoSugestao1.setToolTipText("");
    campoSugestao1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    botaoSugerirPreco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    botaoSugerirPreco1.setText("Atualizar sugestão Preço");
    botaoSugerirPreco1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botaoSugerirPreco1ActionPerformed(evt);
        }
    });

    jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel64.setText("Markup (%)");

    campoMarkup1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoMarkup1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel53.setText("Preço de venda");

    campoPrecoVenda2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoVenda2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoVenda2.setText("0,00");
    campoPrecoVenda2.setToolTipText("");
    campoPrecoVenda2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel66.setText("Preço 2");

    campoPreco5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPreco5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPreco5.setText("0,00");
    campoPreco5.setToolTipText("");
    campoPreco5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel67.setText("Preço 3");

    campoPreco6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPreco6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPreco6.setText("0,00");
    campoPreco6.setToolTipText("");
    campoPreco6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel68.setText("Preço 4");

    campoPreco7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPreco7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPreco7.setText("0,00");
    campoPreco7.setToolTipText("");
    campoPreco7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel70.setText("Lucro Previsto");

    campoLucro1.setEditable(false);
    campoLucro1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoLucro1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoLucro1.setText("0,00");
    campoLucro1.setToolTipText("");
    campoLucro1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Custos de chegada"));

    jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel61.setText("Preço NF");

    campoPrecoNF2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoNF2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoNF2.setText("0,00");
    campoPrecoNF2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel62.setText("Preço NF + Imp.");

    campoPrecoImpo2.setEditable(false);
    campoPrecoImpo2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoImpo2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoImpo2.setText("0,00");
    campoPrecoImpo2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel69.setText("Frete (%)");

    campoPrecoNF3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoNF3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoNF3.setText("0,00");
    campoPrecoNF3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel71.setText("IPI (%)");

    campoPrecoNF4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoNF4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoNF4.setText("0,00");
    campoPrecoNF4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel72.setText("ICMS (%)");

    campoPrecoNF5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoNF5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoNF5.setText("0,00");
    campoPrecoNF5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel73.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel73.setText("Juros/Outros (%)");

    campoPrecoNF6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoNF6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoNF6.setText("0,00");
    campoPrecoNF6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
    jPanel14.setLayout(jPanel14Layout);
    jPanel14Layout.setHorizontalGroup(
        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel14Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel61)
                .addComponent(campoPrecoNF2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel69)
                .addComponent(campoPrecoNF3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel71)
                .addComponent(campoPrecoNF4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel72)
                .addComponent(campoPrecoNF5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel73)
                .addComponent(campoPrecoNF6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel62)
                .addComponent(campoPrecoImpo2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );
    jPanel14Layout.setVerticalGroup(
        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel14Layout.createSequentialGroup()
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jLabel61)
                .addComponent(jLabel69)
                .addComponent(jLabel71)
                .addComponent(jLabel72)
                .addComponent(jLabel73)
                .addComponent(jLabel62))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(campoPrecoNF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(campoPrecoNF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(campoPrecoNF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(campoPrecoNF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(campoPrecoNF6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(campoPrecoImpo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(20, Short.MAX_VALUE))
    );

    jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Custos de saída"));

    jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel63.setText("ICMS (%)");

    campoPrecoNF7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoNF7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoNF7.setText("0,00");
    campoPrecoNF7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel65.setText("Total de custos");

    campoPrecoImpo3.setEditable(false);
    campoPrecoImpo3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoImpo3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoImpo3.setText("0,00");
    campoPrecoImpo3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel74.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel74.setText("Impostos (%)");

    campoPrecoNF8.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoNF8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoNF8.setText("0,00");
    campoPrecoNF8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel75.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel75.setText("Comissão (%)");

    campoPrecoNF9.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoNF9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoNF9.setText("0,00");
    campoPrecoNF9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel76.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel76.setText("Despesas (%)");

    campoPrecoNF10.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoNF10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoNF10.setText("0,00");
    campoPrecoNF10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel77.setText("Pis/Cofins (%)");

    campoPrecoNF11.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoNF11.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoNF11.setText("0,00");
    campoPrecoNF11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    campoPrecoNF12.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
    campoPrecoNF12.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    campoPrecoNF12.setText("0,00");
    campoPrecoNF12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    jLabel78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel78.setText("Outros Custos (%)");

    javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
    jPanel16.setLayout(jPanel16Layout);
    jPanel16Layout.setHorizontalGroup(
        jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel16Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(campoPrecoNF7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel74)
                .addComponent(campoPrecoNF8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel75)
                .addComponent(campoPrecoNF9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel76)
                .addComponent(campoPrecoNF10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel77)
                .addComponent(campoPrecoNF11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel78)
                .addComponent(campoPrecoNF12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel65)
                .addComponent(campoPrecoImpo3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
    );
    jPanel16Layout.setVerticalGroup(
        jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel16Layout.createSequentialGroup()
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel63)
                        .addComponent(jLabel74)
                        .addComponent(jLabel75)
                        .addComponent(jLabel76)
                        .addComponent(jLabel77)
                        .addComponent(jLabel65))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(campoPrecoNF7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoPrecoNF8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoPrecoNF9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoPrecoNF10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoPrecoNF11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoPrecoImpo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addComponent(jLabel78)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(campoPrecoNF12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(23, Short.MAX_VALUE))
    );

    CaixaMarcarMakup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    CaixaMarcarMakup.setText("Usar Mackup");
    CaixaMarcarMakup.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            CaixaMarcarMakupMouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
    jPanel15.setLayout(jPanel15Layout);
    jPanel15Layout.setHorizontalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel15Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addComponent(CaixaMarcarMakup)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel59)
                                .addComponent(campoMargem1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel64)
                                .addComponent(campoMarkup1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(campoSugestao1)
                                .addComponent(jLabel60))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(campoPrecoVenda2)
                                .addComponent(jLabel53))
                            .addGap(35, 35, 35)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel66)
                                .addComponent(campoPreco5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel67)
                                .addComponent(campoPreco6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel68)
                                .addComponent(campoPreco7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoLucro1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel70))))
                    .addContainerGap())))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botaoSugerirPreco1)
            .addGap(269, 269, 269))
    );
    jPanel15Layout.setVerticalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(CaixaMarcarMakup)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(7, 7, 7)
            .addComponent(botaoSugerirPreco1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                    .addComponent(jLabel60)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(campoSugestao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPrecoVenda2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPreco5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPreco6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoLucro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                    .addComponent(jLabel68)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(campoPreco7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoMargem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoMarkup1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(48, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
    jPanel13.setLayout(jPanel13Layout);
    jPanel13Layout.setHorizontalGroup(
        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel13Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(botaoAlterarAvancado1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoLimparAvancado1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(botaoSair3))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoDescricaoProduto2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel31))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoCodigoBarras2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel50))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel52)
                                .addComponent(campoCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE))))
    );
    jPanel13Layout.setVerticalGroup(
        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel13Layout.createSequentialGroup()
            .addGap(5, 5, 5)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel31)
                .addComponent(jLabel50)
                .addComponent(jLabel52))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(campoDescricaoProduto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(campoCodigoBarras2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(campoCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(botaoAlterarAvancado1)
                .addComponent(botaoLimparAvancado1)
                .addComponent(botaoSair3))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
    jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel12Layout.createSequentialGroup()
            .addGap(119, 119, 119)
            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(149, Short.MAX_VALUE))
    );
    jPanel12Layout.setVerticalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel12Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jTabbedPane1.addTab("Calcular preço", jPanel12);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jTabbedPane1)
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
//        if (!campoCodigo.getText().equals("")){
//            //JOptionPane.showMessageDialog(this, "Apague o código para cadastrar um novo produto!");
//            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Apague o código para cadastrar um novo produto!", "Falta informação","erro");
//        }else            
//                if (campoDescricaoProduto.getText().equals("")){
//                    //JOptionPane.showMessageDialog(rootPane, "Insera o nome do Produto!");
//                    mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Insera o nome do Produto!", "Falta informação","erro");
//                }else{
//                if (c.retornaSeJaTemProdutoComEsseNome(campoDescricaoProduto.getText()) == true){
//                    //JOptionPane.showMessageDialog(rootPane, "Já existe um produto com essa descrição!");
//                    mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Já existe um produto com essa descrição!", "Falta informação","erro");
//                }else{
//                    if (campoPrecoVenda.getText().equals("")){
//                    //JOptionPane.showMessageDialog(rootPane, "Digite o preço de venda!");
//                    mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Digite o preço de venda!", "Falta informação","erro");
//                }else{
//                    if (campoNCM.getText().equals("")){
//                        //JOptionPane.showMessageDialog(rootPane, "Informe o NCM do produto corretamente!");
//                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Informe o NCM do produto corretamente!", "Falta informação","erro");
//                        campoNCM.requestFocus();
//                        JanelaNCM janelaNCM = new JanelaNCM(null, rootPaneCheckingEnabled);
//                        //preencher a janela NCM com os ncm de produtos
//                        String nomepro = campoDescricaoProduto.getText();
//                        int tamanhoDoNome = nomepro.length();
//                        if (tamanhoDoNome < 6){
//                            nomepro = nomepro.substring(0, tamanhoDoNome);
//                        }else{
//                            nomepro = nomepro.substring(0, 6);
//                        }
//                        limpar.apagaDadosDaTabela(janelaNCM.tabela);
//                        try {
//                            c.verificaNCMlistandoPeloNomeDoProduto(janelaNCM,nomepro);
//                        } catch (IOException ex) {
//                            Logger.getLogger(JanelaCadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        janelaNCM.show();
//                        if (!janelaNCM.NCMSelecionado.equals("")){
//                            campoNCM.setText(janelaNCM.NCMSelecionado);
//                        }
//                    }else{
//                        // Inicia a inserção de dados no banco de dados
//                        String unidadeMedida = (String) campoUnidade.getSelectedItem();
//                        String pis_cofins = (String) campoPis.getSelectedItem();
//                        String situacao_tributaria = (String) campoSituacao.getSelectedItem();
//                        String fornecedor = (String) campoFornecedor.getSelectedItem();
//                        String grupo = (String) campoGrupo.getSelectedItem();
//                        String minimoVitrine = campoEstoqueMinimo.getText();
//                        if (campoEstoqueMinimo.getText().equals("")){
//                            minimoVitrine = "0,00";
//                        }
//                        String ProdutoMae = (String) campoProdutoMae.getSelectedItem();
//                        if (ProdutoMae == null){
//                            ProdutoMae = "";
//                        }
//                        String CodProdutoMae = c.RetornaIDProduto(ProdutoMae);
//                        Produto p = new Produto(0, campoCodigoBarras.getText(), campoDescricaoProduto.getText(), unidadeMedida, situacao_tributaria, campoIcm.getText(), campoNCM.getText(), campoObs.getText(), grupo, c.retiraCasasDecimaisAmaisEmPreco(campoPrecoNF.getText()), campoPrecoVenda.getText(), fornecedor, "", "", "", "", "", "", "", "", "", "", "", "", fornecedor, "", "", "", "", "", "", minimoVitrine, "0", pis_cofins,campoPeso.getText(),campoSugestao.getText(),campoReferencia.getText(),campoLucro.getText(),"false","","","",ProdutoMae, CodProdutoMae,"");
//                        c.InserirProduto(p);
//                        limpar.apagaCamposProduto(this);
//                    }
//                }
//                }
//        }
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    private void botaoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisaActionPerformed
//        limpar.apagaDadosDaTabela(tabelaProduto);
//        String nomeDoProduto = campoDescricaoProduto.getText();
//        String codigoInterno = campoCodigo.getText();
//        String codigoBarras = campoCodigoBarras.getText();
//        String grupo = (String) campoGrupo.getSelectedItem();
//        String fornecedor = (String) campoFornecedor.getSelectedItem();
//        String inativo = "false";
//        if (campoInativo.isSelected()){
//            inativo = "true";
//        }
//        if (!campoInativo.isSelected()){
//            inativo = "false";
//        }
//        c.PesquisaProdutoVariosCampos(codigoInterno,codigoBarras,campoReferencia.getText(),campoDescricaoProduto.getText(),this,inativo);
//        c.mudaCorDaLinhaDaTabelaProdutosSemEstoque(tabelaProduto);
    }//GEN-LAST:event_botaoPesquisaActionPerformed

    private void botaoAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarActionPerformed
//        if (campoDescricaoProduto.getText().equals("")){
//            //JOptionPane.showMessageDialog(rootPane, "Faça antes uma pesquisa!");
//            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Faça antes uma pesquisa!", "Falta informação","erro");
//        }else{
//            if (campoNCM.getText().equals("")){
//                //JOptionPane.showMessageDialog(rootPane, "Informe o NCM do produto corretamente!");
//                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Informe o NCM do produto corretamente!", "Falta informação","erro");
//                campoNCM.requestFocus();
//                JanelaNCM janelaNCM = new JanelaNCM(null, rootPaneCheckingEnabled);
//                //preencher a janela NCM com os ncm de produtos                 
//                String nomepro = campoDescricaoProduto.getText();
//                int tamanhoDoNome = nomepro.length();
//                if (tamanhoDoNome < 6){
//                    nomepro = nomepro.substring(0, tamanhoDoNome);
//                }else{
//                    nomepro = nomepro.substring(0, 6);
//                }
//                limpar.apagaDadosDaTabela(janelaNCM.tabela);
//                try {
//                    c.verificaNCMlistandoPeloNomeDoProduto(janelaNCM,nomepro);
//                } catch (IOException ex) {
//                    Logger.getLogger(JanelaCadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                janelaNCM.show();
//                if (!janelaNCM.NCMSelecionado.equals("")){
//                    campoNCM.setText(janelaNCM.NCMSelecionado);
//                }
//            }else{
//                int id = Integer.parseInt(campoCodigo.getText());
//                String UND = (String) campoUnidade.getSelectedItem();
//                String pis = (String) campoPis.getSelectedItem();
//                String sit_tributaria = (String) campoSituacao.getSelectedItem();
//                String fornecedor = (String) campoFornecedor.getSelectedItem();
//                String grupo = (String) campoGrupo.getSelectedItem();
//                String minimoVitrine = campoEstoqueMinimo.getText();
//                if (campoEstoqueMinimo.getText().equals("")){
//                    minimoVitrine = "0";
//                }
//                String inativo = "false";
//                if (campoInativo.isSelected()){
//                    inativo = "true";
//                }
//                String ProdutoMae = (String) campoProdutoMae.getSelectedItem();
//                if (ProdutoMae == null){
//                    ProdutoMae = "";
//                }
//                String CodProdutoMae = c.RetornaIDProduto(ProdutoMae);
//                campoPrecoImpo1.setText(c.calculaPrecoNFMaisImpostos(campoCodigo.getText()));
//                Produto p = new Produto(id, campoCodigoBarras.getText(), campoDescricaoProduto.getText(), UND, sit_tributaria, campoIcm.getText(), campoNCM.getText(), campoObs.getText(), grupo,  c.retiraCasasDecimaisAmaisEmPreco(campoPrecoNF.getText()), campoPrecoVenda.getText(), fornecedor, "", "", "", "", "", campoPrecoImpo1.getText(), "", "", "", "", "", "", fornecedor, "", "", "", "", "", "", minimoVitrine, "", pis,campoPeso.getText(),campoSugestao.getText(),campoReferencia.getText(),campoLucro.getText(),inativo,"","","",ProdutoMae, CodProdutoMae,"");
//                c.AlteraProduto(p,this);
//                //campoPrecoImpo1.setText(c.calculaPrecoNFMaisImpostos(campoCodigo.getText()));
//            }
//        }
    }//GEN-LAST:event_botaoAlterarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
//        if (campoDescricaoProduto.getText().equals("")){
//            //JOptionPane.showMessageDialog(rootPane, "Faça antes uma pesquisa!");
//            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Faça antes uma pesquisa!", "Falta informação","erro");
//        }else{
//            int Confirm = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja excluir?","Sim ou Não", JOptionPane.YES_NO_OPTION);
//            if (Confirm == 1){
//                //Faça nada, clicou em Não
//            }else{
//                //verifica se tem historico pra ver se pode excluir
//                boolean podeExcluir = c.verificaSepodeExcluirProduto(campoCodigo.getText());
//                if (podeExcluir == true){
//                    int id = Integer.parseInt(campoCodigo.getText());
//                    String UND = (String) campoUnidade.getSelectedItem();
//                    String pis = (String) campoPis.getSelectedItem();
//                    String sit_tributaria = (String) campoSituacao.getSelectedItem();
//                    String fornecedor = (String) campoFornecedor.getSelectedItem();
//                    String grupo = (String) campoGrupo.getSelectedItem();
//                    String ProdutoMae = (String) campoProdutoMae.getSelectedItem();
//                    if (ProdutoMae == null){
//                        ProdutoMae = "";
//                    }
//                    String CodProdutoMae = c.RetornaIDProduto(ProdutoMae);
//                    Produto p = new Produto(id, campoCodigoBarras.getText(), campoDescricaoProduto.getText(), UND, sit_tributaria, campoIcm.getText(), campoNCM.getText(), campoObs.getText(), grupo, campoPrecoNF.getText(), campoPrecoVenda.getText(), fornecedor, "", "", "", "", "", "", "", "", "", "", "", "", fornecedor, "", "", "", "", "", "", "", "", pis,campoPeso.getText(),campoSugestao.getText(),campoReferencia.getText(),campoLucro.getText(),"","","","",ProdutoMae, CodProdutoMae,"");
//                    c.ExcluirProduto(p, this);
//                }else{
//                    int Confirm2 = JOptionPane.showConfirmDialog(null,"Produto não pode ser excluido porque existe histórico, Deseja inativar?","Sim ou Não", JOptionPane.YES_NO_OPTION);
//                    if (Confirm2 == 0){
//                       c.AtivaInativaProduto(campoCodigo.getText(),"inativo");
//                    }
//                }
//            }
//        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
//        limpar.apagaCamposProduto(this);
//        limpar.apagaCamposProdutoAvancado(this);
//        limpar.apagaTabelaProduto(this);
//        limpar.apagaDadosDaTabela(tabelaHistorico);
//        campoMargem.setText(c.RetornaMargemAtualEmInteiro()+"");
//        campoMarkup1.setText(c.RetornaMarkupDesconto());
//        habilitaDesabilitaCampoMakupConformeConfiguracaoMarcada();
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void tabelaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutoMouseClicked
//        int linhaSelecionada = tabelaProduto.getSelectedRow();
//        String ProdutoSelecionado = (String) tabelaProduto.getValueAt(linhaSelecionada, 0);
//        if ((ProdutoSelecionado == "") || (ProdutoSelecionado == null)){
//            //Não selecionou nenhum cliente
//        }else{
//            limpar.apagaCamposProdutoSemGrade(this);
//            limpar.apagaCamposProdutoAvancado(this);
//            limpar.apagaDadosDaTabela(tabelaHistorico);
//            c.preencheFormularioProduto(ProdutoSelecionado, this);
//            atualizaValoresDeEntradaDoProduto();
//            atualizaValoresDeSaidaDoProduto();
//            habilitaDesabilitaCampoMakupConformeConfiguracaoMarcada();
//        }
    }//GEN-LAST:event_tabelaProdutoMouseClicked

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoAlterarAvancadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarAvancadoActionPerformed
//        if (campoDescricaoProduto.getText().equals("")){
//            //JOptionPane.showMessageDialog(rootPane, "Faça antes uma pesquisa!");
//            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Faça antes uma pesquisa!", "Falta informação","erro");
//        }else{
//            int id = Integer.parseInt(campoCodigo.getText());
//            String UND = (String) campoUnidade.getSelectedItem();
//            String pis = (String) campoPis.getSelectedItem();
//            String sit_tributaria = (String) campoSituacao.getSelectedItem();
//            String fornecedor = (String) campoFornecedor.getSelectedItem();
//            String grupo = (String) campoGrupo.getSelectedItem();
//            String minimoVitrine = campoEstoqueMinimo.getText();
//            if (campoEstoqueMinimo.getText().equals("")){
//                minimoVitrine = "0";
//            }
//            String inativo = "false";
//            if (campoInativo.isSelected()){
//                inativo = "true";
//            }
//            campoPrecoImpo1.setText(c.calculaPrecoNFMaisImpostos(campoCodigo.getText()));
//            String ProdutoMae = (String) campoProdutoMae.getSelectedItem();
//                if (ProdutoMae == null){
//                    ProdutoMae = "";
//                }
//                String CodProdutoMae = c.RetornaIDProduto(ProdutoMae);
//            Produto p = new Produto(id, id+"", campoDescricaoProduto.getText(), UND, sit_tributaria, campoIcm.getText(), campoNCM.getText(), campoObs.getText(), grupo, campoPrecoNF.getText(), campoPrecoVenda.getText(), fornecedor, "", "", "", "", "", campoPrecoImpo1.getText(), "", "", "", "", "", "", fornecedor, "", "", "", "", "", "", minimoVitrine, "", pis,campoPeso.getText(),campoSugestao.getText(),campoReferencia.getText(),campoLucro.getText(),inativo,"","","",ProdutoMae, CodProdutoMae,"");
//            c.AlteraProduto(p,this);
//            //campoPrecoImpo1.setText(c.calculaPrecoNFMaisImpostos(campoCodigo.getText()));
//        }
    }//GEN-LAST:event_botaoAlterarAvancadoActionPerformed

    private void botaoLimparAvancadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparAvancadoActionPerformed
//        limpar.apagaCamposProduto(this);
//        limpar.apagaCamposProdutoAvancado(this);
//        campoMargem.setText(c.RetornaMargemAtualEmInteiro()+"");
    }//GEN-LAST:event_botaoLimparAvancadoActionPerformed

    private void botaoSair2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSair2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botaoSair2ActionPerformed

    private void botaoSugerirPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSugerirPrecoActionPerformed
//        if (campoPrecoImpo1.getText().equals("")){
//            //JOptionPane.showMessageDialog(null, "Produto sem o preço do fornecedor + impostos!");
//            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Produto sem o preço do fornecedor + impostos!", "Falta informação","erro");
//        }else{
//            int id = Integer.parseInt(campoCodigo.getText());
//            String UND = (String) campoUnidade.getSelectedItem();
//            String pis = (String) campoPis.getSelectedItem();
//            String sit_tributaria = (String) campoSituacao.getSelectedItem();
//            String fornecedor = (String) campoFornecedor.getSelectedItem();
//            String grupo = (String) campoGrupo.getSelectedItem();
//            String minimoVitrine = campoEstoqueMinimo.getText();
//            if (campoEstoqueMinimo.getText().equals("")){
//                minimoVitrine = "0";
//            }
//            String inativo = "false";
//            if (campoInativo.isSelected()){
//                inativo = "true";
//            }
//            String perf = c.retornaNomeDoPerfilDaEmpresa();
//            String tipoPrecifi = c.RetornaTipoPrecificacao();
//            if (tipoPrecifi.equals("margem")){
//                //calcula pela margem
//                
//                
//            }else{
//                //Calcula pelo markup
//                if (perf.equals("Jacob")){
//                    JOptionPane.showMessageDialog(null, "Em teste a precificação de Jacob!");
//                    String ProdutoMae = (String) campoProdutoMae.getSelectedItem();
//                    if (ProdutoMae == null){
//                        ProdutoMae = "";
//                    }
//                    String CodProdutoMae = c.RetornaIDProduto(ProdutoMae);
//                    Produto p = new Produto(id, id+"", campoDescricaoProduto.getText(), UND, sit_tributaria, campoIcm.getText(), campoNCM.getText(), campoObs.getText(), grupo, campoPrecoNF.getText(), campoPrecoVenda.getText(), fornecedor, "", "", "", "", "", campoPrecoImpo1.getText(), "", "", "", "", "", "", fornecedor, "", "", "", "", "", "", minimoVitrine, "", pis,campoPeso.getText(),campoSugestao.getText(),campoReferencia.getText(),campoLucro.getText(),inativo,"","","",ProdutoMae, CodProdutoMae,"");
//                    campoSugestao.setText(c.calculaSugestaoDePrecoJacob(p));
//                }else{
//                    String resultado = c.calculaSugestaoDePreco(campoPrecoImpo1.getText(),campoMargem.getText());
//                    campoSugestao.setText(resultado);
//                }
//            }
//        }
    }//GEN-LAST:event_botaoSugerirPrecoActionPerformed

    private void pesquisarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarHistoricoActionPerformed
//        if (campoCodigoProdutoHistorico.getText().equals("") && campoNomeProdutoHistorico.getText().equals("")){
//            //JOptionPane.showMessageDialog(null, "Pesquise pelo código ou pelo nome!");
//            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Pesquise pelo código ou pelo nome!", "Falta informação","erro");
//        }else{
//        if (!campoCodigoProdutoHistorico.getText().equals("") && campoNomeProdutoHistorico.getText().equals("")){
//            //Pesquisa pelo codigo
//            limpar.LimpaHistoricoProdutoSoTabela(this);
//            c.PesquisaHistoricoPorCodigo(campoCodigoProdutoHistorico.getText(), this);
//        }else{
//        if (campoCodigoProdutoHistorico.getText().equals("") && !campoNomeProdutoHistorico.getText().equals("")){
//            //Pesquisa pelo nome
//            limpar.LimpaHistoricoProdutoSoTabela(this);
//            c.PesquisaHistoricoPorNome(campoNomeProdutoHistorico.getText(),this);
//        }else{
//        if (!campoCodigoProdutoHistorico.getText().equals("") && !campoNomeProdutoHistorico.getText().equals("")){
//            //Pesquisa pelo nome
//            limpar.LimpaHistoricoProdutoSoTabela(this);
//            c.PesquisaHistoricoPorNome(campoNomeProdutoHistorico.getText(),this);
//        } 
//        }
//        }    
//        }
    }//GEN-LAST:event_pesquisarHistoricoActionPerformed

    private void jTabbedPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            this.setVisible(false);
        }
    }//GEN-LAST:event_jTabbedPane1KeyPressed

    private void campoIDMateriaPrimaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoIDMateriaPrimaFocusGained
//        String NomeProduto = (String) campoNomeProdutoFinal.getSelectedItem();
//        if ((NomeProduto == null) || (NomeProduto == "")){
//            //Ciente em branco
//            this.campoNomeProdutoFinal.requestFocus();
//        }else{
//            String nomePesquisar = (String) campoNomeProdutoFinal.getSelectedItem();
//            c.preencheProdutoFinalTab (nomePesquisar,campoIDProdutoFinal,campoCustoDaMateriaPrima);
//            this.campoNomeMateriaPrima.requestFocus();
//        }
    }//GEN-LAST:event_campoIDMateriaPrimaFocusGained

    private void campoQuantMateriaPrimaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoQuantMateriaPrimaFocusGained

        String NomeProduto = (String) campoNomeMateriaPrima.getSelectedItem();
        if ((NomeProduto == null) || (NomeProduto == "")){
            //Ciente em branco
            this.campoNomeMateriaPrima.requestFocus();
        }else{
            String nomePesquisar = (String) campoNomeMateriaPrima.getSelectedItem();
//            c.preencheProdutoFinalTab (nomePesquisar,campoIDMateriaPrima, campoCustoDaMateriaPrima);
        }

    }//GEN-LAST:event_campoQuantMateriaPrimaFocusGained

    private void campoQuantMateriaPrimaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoQuantMateriaPrimaKeyPressed
//        if (campoIDProdutoFinal.getText().equals("")){
//            //JOptionPane.showMessageDialog(null, "Escolha o produto final que deseja montar a composição!");
//            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Escolha o produto final que deseja montar a composição!", "Falta informação","erro");
//        }else{
//            if (campoQuantMateriaPrima.getText().equals("")){
//                campoQuantMateriaPrima.requestFocus();
//            }else{
//                if(evt.getKeyCode() == evt.VK_ENTER){
//                    if (campoQuantMateriaPrima.getText().equals("0")){
//                        //JOptionPane.showMessageDialog(rootPane, "Quantidade não pode ser zero!");
//                        mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Quantidade não pode ser zero!", "Falta informação","erro");
//                    }else{
//                        String nomeProduto = (String) campoNomeMateriaPrima.getSelectedItem();
//                        if (nomeProduto.equals("")){
//                            ////JOptionPane.showMessageDialog(rootPane, "Pesquise uma matéria prima para adicionar na composição!");
//                            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Pesquise uma matéria prima para adicionar na composição!", "Falta informação","erro");
//                        }else{
//                            if ((campoIDMateriaPrima.getText().equals("")) || (nomeProduto.equals("")))   {
//                                //JOptionPane.showMessageDialog(null, "Pesquise uma matéria prima para adicionar na composição!");
//                                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Pesquise uma matéria prima para adicionar na composição!", "Falta informação","erro");
//                            }else if (campoQuantMateriaPrima.getText().equals("")){
//                                //JOptionPane.showMessageDialog(null, "Digite a quantidade!");
//                                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Digite a quantidade!", "Falta informação","erro");
//                            }else{
//                                javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabelaProdutos.getModel();
//                                dtm.addRow(new Object[]{campoIDMateriaPrima.getText(),nomeProduto,campoQuantMateriaPrima.getText()});
//
//                                //Atualiza custo total
//                                c.atualizaTotalDoCustoNaProdutoFinalNoCadastroDoProduto(this, campoCustoDaMateriaPrima.getText(), campoQuantMateriaPrima.getText());
//
//                                campoIDMateriaPrima.setText("");
//                                campoNomeMateriaPrima.removeAllItems();
//                                campoQuantMateriaPrima.setText("");
//                                campoCustoDaMateriaPrima.setText("");
//                                campoNomeMateriaPrima.requestFocus();
//                            }
//                        }
//                    }
//                }else{if(evt.getKeyCode() == evt.VK_TAB){
//                    campoNomeMateriaPrima.requestFocus();
//                    campoQuantMateriaPrima.requestFocus();
//                }
//            }
//        }
//        }
    }//GEN-LAST:event_campoQuantMateriaPrimaKeyPressed

    private void botaoExcluiProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluiProdutoActionPerformed
        int[] l = tabelaProdutos.getSelectedRows();
        javax.swing.table.DefaultTableModel dtm = (javax.swing.table.DefaultTableModel)tabelaProdutos.getModel();
        for(int i = (l.length-1); i >= 0; --i)
        dtm.removeRow(l[i]);
        this.campoNomeMateriaPrima.requestFocus();
    }//GEN-LAST:event_botaoExcluiProdutoActionPerformed

    private void tabelaComposicoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaComposicoesMouseClicked
//        limpar.apagaCamposComposicao2(this);
//
//        int linhaSelecionada = tabelaComposicoes.getSelectedRow();
//        String ComposicaoSelecionado = (String) tabelaComposicoes.getValueAt(linhaSelecionada, 0);
//
//        if ((ComposicaoSelecionado == "") || (ComposicaoSelecionado == null)){
//            //Não selecionou nenhuma composicao
//        }else{
//            c.PreencheMateriaPrimaDoProdutoFinalNoCadastroDeProduto(ComposicaoSelecionado, this);
//        }

    }//GEN-LAST:event_tabelaComposicoesMouseClicked

    private void botaoSalvarComposicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarComposicaoActionPerformed
//        if (campoIDProdutoFinal.getText().equals("")){
//            //JOptionPane.showMessageDialog(null, "Selecione um produto final!");
//            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Selecione um produto final!", "Falta informação","erro");
//        }else{
//            int totalDeLinhas = tabelaProdutos.getModel().getRowCount();
//            if (totalDeLinhas == 0){
//                // Nao existe nenhum produto adicionado obra
//                //JOptionPane.showMessageDialog(null, "Nenhuma matéria prima adicionada!");
//                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Nenhuma matéria prima adicionada!", "Falta informação","erro");
//            } else {
//                //fazer funcao apagar os gastos para renovar com o da tabela
//                int IDProdutoFinal = Integer.parseInt(campoIDProdutoFinal.getText());
//
//                //Funcões abaixo sendo feitas ainda
//                c.apagaComposicaoDoProduto(IDProdutoFinal+"");
//                c.InserirMateriaPrimaNoProdutoFinalNoCadastroDoProduto(IDProdutoFinal, this);
//                c.PreencheTabelaComposicoes(tabelaComposicoes);
//                //co.salvarCustoDoProdutoFinal(IDProdutoFinal);
//                NomeID.setVisible(false);
//                nomeMateriaPrima.setVisible(false);
//                nomeQuant.setVisible(false);
//                nomeCusto.setVisible(false);
//                campoIDMateriaPrima.setVisible(false);
//                campoNomeMateriaPrima.setVisible(false);
//                campoQuantMateriaPrima.setVisible(false);
//                campoCustoDaMateriaPrima.setVisible(false);
//            }
//        }
    }//GEN-LAST:event_botaoSalvarComposicaoActionPerformed

    private void botaoLimparComposicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparComposicaoActionPerformed
//        limpar.apagaCamposComposicao2(this);
    }//GEN-LAST:event_botaoLimparComposicaoActionPerformed

    private void campoCustoDaMateriaPrimaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCustoDaMateriaPrimaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCustoDaMateriaPrimaFocusGained

    private void campoCustoDaMateriaPrimaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCustoDaMateriaPrimaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCustoDaMateriaPrimaKeyPressed

    private void botaoLimparComposicao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparComposicao1ActionPerformed
        NomeID.setVisible(true);
        nomeMateriaPrima.setVisible(true);
        nomeQuant.setVisible(true);
        nomeCusto.setVisible(true);
        campoIDMateriaPrima.setVisible(true);
        campoNomeMateriaPrima.setVisible(true);
        campoQuantMateriaPrima.setVisible(true);
        campoCustoDaMateriaPrima.setVisible(true);
    }//GEN-LAST:event_botaoLimparComposicao1ActionPerformed

    private void campoIcmFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoIcmFocusGained
        String sit = (String) campoSituacao.getSelectedItem();
        if (sit.equals("18%")){
            campoIcm.setText("18");
        }
    }//GEN-LAST:event_campoIcmFocusGained

    private void campoNomeProdutoHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeProdutoHistoricoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeProdutoHistoricoActionPerformed

    private void tabelaHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaHistoricoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaHistoricoMouseClicked

    private void pesquisarHistorico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarHistorico1ActionPerformed
//        limpar.LimpaHistoricoProduto(this);
    }//GEN-LAST:event_pesquisarHistorico1ActionPerformed

    private void botaoExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluir1ActionPerformed
//        JanelaNCM j = new JanelaNCM(null, rootPaneCheckingEnabled);
//        j.show();
//        if (!j.NCMSelecionado.equals("")){
//            campoNCM.setText(j.NCMSelecionado);
//        }
    }//GEN-LAST:event_botaoExcluir1ActionPerformed

    private void botaoAlterarAvancado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAlterarAvancado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoAlterarAvancado1ActionPerformed

    private void botaoLimparAvancado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparAvancado1ActionPerformed
//        limpar.apagaCamposProduto(this);
//        limpar.apagaCamposProdutoAvancado(this);
//        limpar.apagaTabelaProduto(this);
//        campoMargem.setText(c.RetornaMargemAtualEmInteiro()+"");
//        campoMarkup1.setText(c.RetornaMarkupDesconto());
//        habilitaDesabilitaCampoMakupConformeConfiguracaoMarcada();
    }//GEN-LAST:event_botaoLimparAvancado1ActionPerformed

    private void botaoSair3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSair3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoSair3ActionPerformed

    private void botaoSugerirPreco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSugerirPreco1ActionPerformed
        atualizaValoresDeEntradaDoProduto();
        atualizaValoresDeSaidaDoProduto();
        calculaPrecoPelaMargem();
    }//GEN-LAST:event_botaoSugerirPreco1ActionPerformed

    private void CaixaMarcarMakupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CaixaMarcarMakupMouseClicked
        if (CaixaMarcarMakup.isSelected()){
            jPanel16.setVisible(false);
            campoMargem1.setVisible(false);
            jLabel59.setVisible(false);
            jLabel64.setVisible(true);
            campoMarkup1.setVisible(true);
        }else{
            jPanel16.setVisible(true);
            campoMargem1.setVisible(true);
            jLabel59.setVisible(true);
            jLabel64.setVisible(false);
            campoMarkup1.setVisible(false);
        }
    }//GEN-LAST:event_CaixaMarcarMakupMouseClicked

    private void campoDescricaoProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescricaoProdutoKeyReleased
//        limpar.apagaDadosDaTabela(tabelaProduto);
//        c.PesquisaProdutoPorNome(campoDescricaoProduto.getText(), this, "false");
//        c.mudaCorDaLinhaDaTabelaProdutosSemEstoque(tabelaProduto);
    }//GEN-LAST:event_campoDescricaoProdutoKeyReleased

    private void caixaMarcarTodosProdutosEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaMarcarTodosProdutosEstoqueActionPerformed
        caixaMarcarTodosProdutosEstoqueZero.setSelected(false);
    }//GEN-LAST:event_caixaMarcarTodosProdutosEstoqueActionPerformed

    private void botaoRelacaoEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRelacaoEstoqueActionPerformed
//        if (caixaMarcarTodosProdutosEstoque.isSelected()){
//            try {
//                geraPDF.GeraRelatorioProdutosEstoqueCompletoEmPDF();
//            } catch (DocumentException ex) {
//                Logger.getLogger(JanelaContasAPagar.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(JanelaContasAPagar.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }else{ if (caixaMarcarTodosProdutosEstoqueZero.isSelected()){
//            try {
//                geraPDF.GeraRelatorioProdutosEstoqueZeroEmPDF();
//            } catch (DocumentException ex) {
//                Logger.getLogger(JanelaContasAPagar.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(JanelaContasAPagar.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }else{
//            //JOptionPane.showMessageDialog(null, "Marque uma opção de relatório para visualizar!");
//            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Marque uma opção de relatório para visualizar!", "Falta informação","erro");
//        }
//        }
    }//GEN-LAST:event_botaoRelacaoEstoqueActionPerformed

    private void caixaMarcarTodosProdutosEstoqueZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaMarcarTodosProdutosEstoqueZeroActionPerformed
        caixaMarcarTodosProdutosEstoque.setSelected(false);
    }//GEN-LAST:event_caixaMarcarTodosProdutosEstoqueZeroActionPerformed

    private void caixaMarcarEstoqueCriticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaMarcarEstoqueCriticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixaMarcarEstoqueCriticoActionPerformed

    private void botaoRelacaoEstoque1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRelacaoEstoque1ActionPerformed
//        if (!caixaMarcarEstoqueCritico.isSelected()){
//            //JOptionPane.showMessageDialog(null, "Marque uma opção!");
//            mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Marque uma opção!", "Falta informação","erro");
//        }else{
//            //fazer relatorio de estoque minimo
//            try {
//                geraPDF.GeraRelatorioProdutosEstoqueCriticoEmPDF();
//            } catch (DocumentException ex) {
//                Logger.getLogger(JanelaContasAPagar.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(JanelaContasAPagar.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_botaoRelacaoEstoque1ActionPerformed

    private void botaoRelacaoPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRelacaoPrecoActionPerformed
//        if (caixaMarcarTodosProdutos.isSelected()){
//            try {
//                geraPDF.GeraRelatorioProdutosComPrecoEmPDF();
//            } catch (DocumentException ex) {
//                Logger.getLogger(JanelaContasAPagar.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(JanelaContasAPagar.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }else{
//            if (caixaMarcarTodosPrecoMaisEstoque.isSelected()){
//                try {
//                    geraPDF.GeraRelatorioProdutosComPrecoEquantidadeEmEstoqueEmPDF();
//                } catch (DocumentException ex) {
//                    Logger.getLogger(JanelaContasAPagar.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(JanelaContasAPagar.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }else{
//                //JOptionPane.showMessageDialog(null, "Marque uma opção para abrir o relatório!");
//                mensagemErro.abrirAlertaDeOperacaoFeitaComSucesso("Marque uma opção para abrir o relatório!", "Falta informação","erro");
//            }
//        }

    }//GEN-LAST:event_botaoRelacaoPrecoActionPerformed

    private void campoInativoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoInativoKeyPressed
        GravarStatusDoProdutoInativo();
    }//GEN-LAST:event_campoInativoKeyPressed

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
            java.util.logging.Logger.getLogger(JanelaCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastraProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCadastraProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CaixaMarcarMakup;
    private javax.swing.JLabel NomeID;
    public javax.swing.JPanel PainelTabelaProdutos;
    public javax.swing.JButton botaoAlterar;
    public javax.swing.JButton botaoAlterarAvancado;
    public javax.swing.JButton botaoAlterarAvancado1;
    public javax.swing.JButton botaoCadastrar;
    public javax.swing.JButton botaoExcluiProduto;
    public javax.swing.JButton botaoExcluir;
    public javax.swing.JButton botaoExcluir1;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoLimparAvancado;
    private javax.swing.JButton botaoLimparAvancado1;
    public javax.swing.JButton botaoLimparComposicao;
    public javax.swing.JButton botaoLimparComposicao1;
    private javax.swing.JButton botaoPesquisa;
    private javax.swing.JButton botaoRelacaoEstoque;
    private javax.swing.JButton botaoRelacaoEstoque1;
    private javax.swing.JButton botaoRelacaoPreco;
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton botaoSair2;
    private javax.swing.JButton botaoSair3;
    public javax.swing.JButton botaoSalvarComposicao;
    private javax.swing.JButton botaoSugerirPreco;
    private javax.swing.JButton botaoSugerirPreco1;
    private javax.swing.JCheckBox caixaMarcarEstoqueCritico;
    private javax.swing.JCheckBox caixaMarcarTodosPrecoMaisEstoque;
    private javax.swing.JCheckBox caixaMarcarTodosProdutos;
    private javax.swing.JCheckBox caixaMarcarTodosProdutosEstoque;
    private javax.swing.JCheckBox caixaMarcarTodosProdutosEstoqueZero;
    public javax.swing.JTextField campoCodigo;
    public javax.swing.JTextField campoCodigo1;
    public javax.swing.JTextField campoCodigo2;
    public javax.swing.JTextField campoCodigoBarras;
    public javax.swing.JTextField campoCodigoBarras1;
    public javax.swing.JTextField campoCodigoBarras2;
    public javax.swing.JTextField campoCodigoProdutoHistorico;
    public javax.swing.JFormattedTextField campoConversor;
    public javax.swing.JFormattedTextField campoCustoDaMateriaPrima;
    public javax.swing.JFormattedTextField campoCustoTotal2;
    public javax.swing.JTextField campoDescricaoProduto;
    public javax.swing.JTextField campoDescricaoProduto1;
    public javax.swing.JTextField campoDescricaoProduto2;
    public javax.swing.JTextField campoEstoque;
    public javax.swing.JFormattedTextField campoEstoqueMinimo;
    public javax.swing.JComboBox campoFornecedor;
    public javax.swing.JComboBox campoGrupo;
    public javax.swing.JTextField campoIDMateriaPrima;
    public javax.swing.JTextField campoIDProdutoFinal;
    public javax.swing.JTextField campoIcm;
    public javax.swing.JCheckBox campoInativo;
    public javax.swing.JFormattedTextField campoLucro;
    public javax.swing.JFormattedTextField campoLucro1;
    public javax.swing.JFormattedTextField campoMargem;
    public javax.swing.JFormattedTextField campoMargem1;
    public javax.swing.JFormattedTextField campoMarkup;
    public javax.swing.JFormattedTextField campoMarkup1;
    public javax.swing.JTextField campoNCM;
    public javax.swing.JComboBox campoNomeMateriaPrima;
    public javax.swing.JComboBox campoNomeProdutoFinal;
    public javax.swing.JTextField campoNomeProdutoHistorico;
    public javax.swing.JTextField campoObs;
    public javax.swing.JFormattedTextField campoPeso;
    public javax.swing.JComboBox campoPis;
    public javax.swing.JFormattedTextField campoPreco2;
    public javax.swing.JFormattedTextField campoPreco3;
    public javax.swing.JFormattedTextField campoPreco4;
    public javax.swing.JFormattedTextField campoPreco5;
    public javax.swing.JFormattedTextField campoPreco6;
    public javax.swing.JFormattedTextField campoPreco7;
    public javax.swing.JFormattedTextField campoPrecoImpo;
    public javax.swing.JFormattedTextField campoPrecoImpo1;
    public javax.swing.JFormattedTextField campoPrecoImpo2;
    public javax.swing.JFormattedTextField campoPrecoImpo3;
    public javax.swing.JFormattedTextField campoPrecoNF;
    public javax.swing.JFormattedTextField campoPrecoNF1;
    public javax.swing.JFormattedTextField campoPrecoNF10;
    public javax.swing.JFormattedTextField campoPrecoNF11;
    public javax.swing.JFormattedTextField campoPrecoNF12;
    public javax.swing.JFormattedTextField campoPrecoNF2;
    public javax.swing.JFormattedTextField campoPrecoNF3;
    public javax.swing.JFormattedTextField campoPrecoNF4;
    public javax.swing.JFormattedTextField campoPrecoNF5;
    public javax.swing.JFormattedTextField campoPrecoNF6;
    public javax.swing.JFormattedTextField campoPrecoNF7;
    public javax.swing.JFormattedTextField campoPrecoNF8;
    public javax.swing.JFormattedTextField campoPrecoNF9;
    public javax.swing.JFormattedTextField campoPrecoVenda;
    public javax.swing.JFormattedTextField campoPrecoVenda1;
    public javax.swing.JFormattedTextField campoPrecoVenda2;
    public javax.swing.JComboBox campoProdutoMae;
    public javax.swing.JFormattedTextField campoQuantMateriaPrima;
    public javax.swing.JTextField campoReferencia;
    public javax.swing.JComboBox campoSituacao;
    public javax.swing.JFormattedTextField campoSugestao;
    public javax.swing.JFormattedTextField campoSugestao1;
    public javax.swing.JFormattedTextField campoUltimaNF;
    public javax.swing.JComboBox campoUnidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel nomeCusto;
    private javax.swing.JLabel nomeMateriaPrima;
    private javax.swing.JLabel nomeQuant;
    private javax.swing.JButton pesquisarHistorico;
    private javax.swing.JButton pesquisarHistorico1;
    private javax.swing.JScrollPane scrollTable;
    public javax.swing.JTable tabelaComposicoes;
    public javax.swing.JTable tabelaHistorico;
    public javax.swing.JTable tabelaProduto;
    public javax.swing.JTable tabelaProdutos;
    // End of variables declaration//GEN-END:variables
}
