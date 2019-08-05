/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sss.Control;

import br.com.sss.View.JanelaDeAlerta;

/**
 *
 * @author DSISTEMA
 */
public class MensagemErro {
    
    public MensagemErro(){
        
    }
    
    
    /**Método para exibir alerta personalizado
     * @param  texto String - Texto descrevendo o alerta
     * @param  titulo String - Título do alerta
     * @param  tipo String - Tipo de alerta, se é um erro ou é mensagem de OK (passando ok ou erro))
     * @return void
     */
    public void abrirAlertaDeOperacaoFeitaComSucesso(String texto, String titulo, String tipo){
            JanelaDeAlerta jc = new JanelaDeAlerta(null, true);
            jc.campoMensagem.setText(texto);
            jc.setTitle(titulo);
            if (tipo.equals("ok")){
                //muda imagem
                jc.campoImagem.setBackground(new java.awt.Color(0, 0, 0));
                jc.campoImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jc.campoImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/be.com.sss.Imagem/icone_ok.png")));
                //campoImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource(caminhoLogoMarca)));
                jc.campoImagem.setText("");
            }
            if (tipo.equals("erro")){
                //muda imagem
                jc.campoImagem.setBackground(new java.awt.Color(0, 0, 0));
                jc.campoImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jc.campoImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/be.com.sss.Imagem/icone_erro.png")));
                //campoImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource(caminhoLogoMarca)));
                jc.campoImagem.setText("");
            }
            jc.show();
    }
    
    
}
