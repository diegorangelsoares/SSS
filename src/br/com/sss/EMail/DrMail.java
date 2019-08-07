
package br.com.sss.EMail;

/**
 *
 * @author Diego Rangel  
 */

import br.com.sss.model.Empresa;
import br.com.sss.Control.GeraTXT;
import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class DrMail
{   
        public String emailOrigem = "rangelsoftwares@hotmail.com";
        public String senhaEmailOrigem = "Lua123!!";
       
        GeraTXT GeradorTXT = new GeraTXT();
        
        public void EnviarDeVersaoAtualizada (String nomeCliente, String email, String mensagem, String assunto,Empresa em) {
            /**  
            if (!em.getEmailDeEnvio().equals("rangelsoftwares@hotmail.com") || !em.getEmailDeEnvio().equals("")){
                  emailOrigem = em.getEmailDeEnvio();
                  senhaEmailOrigem = em.getSenhaEmail();
            }
            */
            
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Hotmail */
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.live.com");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            
            String TextoDoEmail = "Mensagem enviada por: "+nomeCliente+" \n\n"+mensagem+"\n\nAss.: "+nomeCliente+"\nEmail: "+email;

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   //return new PasswordAuthentication("rangelsoftwares@gmail.com", "SenhaDoEmail");
                                   return new PasswordAuthentication(emailOrigem, senhaEmailOrigem);
                             }
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(emailOrigem)); //Remetente

                  message.setRecipients(Message.RecipientType.TO, 
                                    InternetAddress.parse("diegorangeljpa@gmail.com")); //Destinatário(s)
                  message.setSubject(assunto);//Assunto
                  message.setText(TextoDoEmail); //Texto da sugestão
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
                  //JOptionPane.showMessageDialog(null, "E-Mail enviada com Sucesso!");
                  //System.out.println("Feito!!!");

             } catch (MessagingException e) {
                  GeradorTXT.GeraTxtDeErro("Erro ao enviar email - " + e.getMessage());
            }
      }
      
      public void EnviarEmailDeCliente (String nomeCliente, String email, String mensagem, String assunto,Empresa em) {
            /**  
            if (!em.getEmailDeEnvio().equals("rangelsoftwares@hotmail.com") || !em.getEmailDeEnvio().equals("")){
                  emailOrigem = em.getEmailDeEnvio();
                  senhaEmailOrigem = em.getSenhaEmail();
            }
            */ 
            
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Hotmail */
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.live.com");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            
            String TextoDoEmail = "Mensagem enviada por: "+nomeCliente+" \n\n"+mensagem+"\n\nAss.: "+nomeCliente+"\nEmail: "+email;

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   //return new PasswordAuthentication("rangelsoftwares@gmail.com", "SenhaDoEmail");
                                   return new PasswordAuthentication(emailOrigem, senhaEmailOrigem);
                             }
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(emailOrigem)); //Remetente

                  message.setRecipients(Message.RecipientType.TO, 
                                    InternetAddress.parse("diegorangeljpa@gmail.com")); //Destinatário(s)
                  message.setSubject(assunto);//Assunto
                  message.setText(TextoDoEmail); //Texto da sugestão
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
                  JOptionPane.showMessageDialog(null, "E-Mail enviada com Sucesso!");
                  //System.out.println("Feito!!!");

             } catch (MessagingException e) {
                  GeradorTXT.GeraTxtDeErro("Erro ao enviar email - " + e.getMessage());
            }
      }
      
      public void EnviarEmailConsultaMarcada (String nomePaciente, String email, String dataDaConsulta,String horaDaConsulta, String assunto,Empresa em) {
            //if (!em.getEmailDeEnvio().equals("rangelsoftwares@hotmail.com") || !em.getEmailDeEnvio().equals("")){
            //    emailOrigem = em.getEmailDeEnvio();
            //    senhaEmailOrigem = em.getSenhaEmail();
            //}
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Hotmail */
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.live.com");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            
            String TextoDoEmail = "Mensagem enviada por: "+em.getNome()+" \n\nVocê tem uma consulta marcada em nosso consultório no dia "+dataDaConsulta+" no horário "+horaDaConsulta+"\n\nAss.: "+em.getNome()+"\nEmail: "+em.getEmail()+"\nTelefone: "+em.getTelefone_fixo()+"\nCelular: "+em.getCelular();

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   //return new PasswordAuthentication("rangelsoftwares@gmail.com", "SenhaDoEmail");
                                   return new PasswordAuthentication(emailOrigem, senhaEmailOrigem);
                             }
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(emailOrigem)); //Remetente

                  //message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("diegorangeljpa@gmail.com")); //Destinatário(s)
                  message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email)); //Destinatário(s)
                  message.setSubject(assunto);//Assunto
                  message.setText(TextoDoEmail); //Texto da sugestão
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
                  JOptionPane.showMessageDialog(null, "E-Mail enviada com Sucesso!");
                  //System.out.println("Feito!!!");

             } catch (MessagingException e) {
                  GeradorTXT.GeraTxtDeErro("Erro ao enviar email - " + e.getMessage());
            }
      }
      
      public void enviarEmailDoErro(String nomeCliente, String assunto,String caminhoAnexo,String versaoDsistema){
          if (verificaSeTemArquivoTesteINI() == false){    
            //if (!em.getEmailDeEnvio().equals("rangelsoftwares@hotmail.com") || !em.getEmailDeEnvio().equals("")){
            //      emailOrigem = em.getEmailDeEnvio();
            //      senhaEmailOrigem = em.getSenhaEmail();
            //  }
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Hotmail */
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.live.com");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            
            String TextoDoEmail = "Erro enviado por: "+nomeCliente+" \n\n Registro de Erro em Anexo\n\nVersão do sistema: "+versaoDsistema;

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   //return new PasswordAuthentication("rangelsoftwares@gmail.com", "SenhaDoEmail");
                                   return new PasswordAuthentication(emailOrigem, senhaEmailOrigem);
                             }
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {
                // cria a primeira parte da mensagem
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setText(TextoDoEmail);

                // cria a segunda parte da mensage
                MimeBodyPart mbp2 = new MimeBodyPart();

                // anexa o arquivo na mensagem
                FileDataSource fds = new FileDataSource(caminhoAnexo);
                mbp2.setDataHandler(new DataHandler(fds));
                mbp2.setFileName(fds.getName());

                // cria a Multipart
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                mp.addBodyPart(mbp2);

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(emailOrigem)); //Remetente

                  message.setRecipients(Message.RecipientType.TO, 
                                    InternetAddress.parse("diegorangeljpa@gmail.com")); //Destinatário(s)
                  message.setSubject(assunto);//Assunto
                          
                  // adiciona a Multipart na mensagem
                  message.setContent(mp);
                  
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
                  JOptionPane.showMessageDialog(null, "Erro enviado para o desenvolvedor com Sucesso!");

             } catch (MessagingException e) {
                  GeradorTXT.GeraTxtDeErro("Erro ao enviar email - " + e.getMessage());
             }
            }else{
                try {   
                 Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",caminhoAnexo});
                } catch (Exception ex) {   
                     GeradorTXT.GeraTxtDeErro("Erro ao enviar email - " + ex.getMessage());
                }
        }
          
      }
      
      public void enviarEmailDosXmlsGerados (String nomeCliente, String assunto,String caminhoAnexo,Empresa em, String emailDestino){
          if (verificaSeTemArquivoTesteINI() == false){    
            //if (!em.getEmailDeEnvio().equals("rangelsoftwares@hotmail.com") || !em.getEmailDeEnvio().equals("")){
            //      emailOrigem = em.getEmailDeEnvio();
            //      senhaEmailOrigem = em.getSenhaEmail();
            //  }
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Hotmail */
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.live.com");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            
            String TextoDoEmail = "Segue em anexo os arquivos XMLs da empresa "+em.getNome()+" \n\n E-mail automático do sistema.\nPor Favor não responda.\n\nPara responder envie e-mail para : "+em.getEmail();

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   //return new PasswordAuthentication("rangelsoftwares@gmail.com", "SenhaDoEmail");
                                   return new PasswordAuthentication(emailOrigem, senhaEmailOrigem);
                             }
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {
                // cria a primeira parte da mensagem
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setText(TextoDoEmail);

                // cria a segunda parte da mensage
                MimeBodyPart mbp2 = new MimeBodyPart();

                // anexa o arquivo na mensagem
                FileDataSource fds = new FileDataSource(caminhoAnexo);
                mbp2.setDataHandler(new DataHandler(fds));
                mbp2.setFileName(fds.getName());

                // cria a Multipart
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                mp.addBodyPart(mbp2);

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(emailOrigem)); //Remetente

                  message.setRecipients(Message.RecipientType.TO, 
                                    InternetAddress.parse(emailDestino)); //Destinatário(s)
                  message.setSubject(assunto);//Assunto
                          
                  // adiciona a Multipart na mensagem
                  message.setContent(mp);
                  
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
                  JOptionPane.showMessageDialog(null, "E-mail de xml enviado com Sucesso!");

             } catch (MessagingException e) {
                  GeradorTXT.GeraTxtDeErro("Erro ao enviar email - " + e.getMessage());
             }
            }else{
            try {   
             Runtime.getRuntime().exec (new String[]{"cmd.exe", "/c", "start",caminhoAnexo});
            } catch (Exception ex) {   
                 GeradorTXT.GeraTxtDeErro("Erro ao enviar email - " + ex.getMessage());
            }
        }
          
      }
      
      public void enviarEmailDoErroSemAnexo(String nomeCliente, String Texto,String textoDoErro,Empresa em){
          
          //email.enviarEmailDoErroSemAnexo(nomeEmpresaPadrao,textoDoEmailDeErro, nomeDoArquivo,em);
          
            //if (!em.getEmailDeEnvio().equals("rangelsoftwares@hotmail.com") || !em.getEmailDeEnvio().equals("")){
            //      emailOrigem = em.getEmailDeEnvio();
            //      senhaEmailOrigem = em.getSenhaEmail();
            //  }
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Hotmail */
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.live.com");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            
            String TextoDoEmail = Texto+"\n\nEmail enviado pelo cliente: "+em.getNome();

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   //return new PasswordAuthentication("rangelsoftwares@gmail.com", "SenhaDoEmail");
                                   return new PasswordAuthentication(emailOrigem, senhaEmailOrigem);
                             }
                        });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {
                // cria a primeira parte da mensagem
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setText(TextoDoEmail);

                // cria a segunda parte da mensage
                MimeBodyPart mbp2 = new MimeBodyPart();

                // anexa o arquivo na mensagem
                //FileDataSource fds = new FileDataSource(caminhoAnexo);
                //mbp2.setDataHandler(new DataHandler(fds));
                //mbp2.setFileName(fds.getName());

                // cria a Multipart
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                mp.addBodyPart(mbp2);

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(emailOrigem)); //Remetente

                  message.setRecipients(Message.RecipientType.TO, 
                                    InternetAddress.parse("diegorangeljpa@gmail.com")); //Destinatário(s)
                  message.setSubject("Erro de Sistema");//Assunto
                          
                  // adiciona a Multipart na mensagem
                  message.setContent(mp);
                  
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
                  JOptionPane.showMessageDialog(null, "Erro enviado para o desenvolvedor com Sucesso!");

             } catch (MessagingException e) {
                  GeradorTXT.GeraTxtDeErro("Erro ao enviar email - " + e.getMessage());
            }
          
      }
      
      public void enviarOrcamentoPorEmailComAnexo(String nomeCliente, String assunto,String caminhoAnexo, String emailDoCliente,String nomeEmpresa,Empresa em){
            //if (!em.getEmailDeEnvio().equals("rangelsoftwares@hotmail.com") || !em.getEmailDeEnvio().equals("")){
            //    emailOrigem = em.getEmailDeEnvio();
            //    senhaEmailOrigem = em.getSenhaEmail();
            //}
            Properties props = new Properties();
            // Parâmetros de conexão com servidor Hotmail 
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.live.com");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            
            String TextoDoEmail = "";
            if (nomeEmpresa.equals("Jacob")){
                TextoDoEmail = nomeCliente+",\n\nVocê está recebendo um Orçamento conforme solicitado.\n\nSegue no anexo o pdf do orçamento.\n\nAtenciosamente.\n\n";
            }else{
                TextoDoEmail = "Você está recebendo um Orçamento conforme solicitado.\n\nSegue no anexo o pdf do orçamento.\n\nAtenciosamente.";
            }
            
            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   //return new PasswordAuthentication("rangelsoftwares@gçamentomail.com", "SenhaDoEmail");
                                   return new PasswordAuthentication(emailOrigem, senhaEmailOrigem);
                             }
                        });

            // Ativa Debug para sessão 
            session.setDebug(true);
            try {
                // cria a primeira parte da mensagem
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setText(TextoDoEmail);
                // cria a segunda parte da mensage
                MimeBodyPart mbp2 = new MimeBodyPart();
                // anexa o arquivo na mensagem
                FileDataSource fds = new FileDataSource(caminhoAnexo);
                mbp2.setDataHandler(new DataHandler(fds));
                mbp2.setFileName(fds.getName());
                // cria a Multipart
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                mp.addBodyPart(mbp2);
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(emailOrigem)); //Remetente
                  message.setRecipients(Message.RecipientType.TO, 
                  InternetAddress.parse(emailDoCliente)); //Destinatário(s)
                  message.setSubject(assunto);//Assunto
                  // adiciona a Multipart na mensagem
                  message.setContent(mp);
                  //Método para enviar a mensagem criada
                  Transport.send(message);
                  JOptionPane.showMessageDialog(null, "Orçamento enviado para o email do cliente!");

             } catch (MessagingException e) {
                  GeradorTXT.GeraTxtDeErro("Erro ao enviar email - " + e.getMessage());
             }
      }
      
      public void enviarPedidoPorEmailComAnexo(String nomeCliente, String assunto,String caminhoAnexo, String emailDoCliente,String nomeEmpresa,Empresa em){
            //if (!em.getEmailDeEnvio().equals("rangelsoftwares@hotmail.com") || !em.getEmailDeEnvio().equals("")){
            //    emailOrigem = em.getEmailDeEnvio();
            //    senhaEmailOrigem = em.getSenhaEmail();
            //}
            Properties props = new Properties();
            // Parâmetros de conexão com servidor Hotmail 
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.live.com");
            props.put("mail.smtp.socketFactory.port", "587");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            
            String TextoDoEmail = "";
            if (nomeEmpresa.equals("Jacob")){
                TextoDoEmail = nomeCliente+",\n\nVocê está recebendo um Pedido conforme solicitado.\n\nSegue no anexo o pdf do pedido.\n\nAtenciosamente.\n\n";
            }else{
                TextoDoEmail = "Você está recebendo um Pedido conforme solicitado.\n\nSegue no anexo o pdf do pedido.\n\nAtenciosamente.";
            }
            
            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   //return new PasswordAuthentication("rangelsoftwares@gçamentomail.com", "SenhaDoEmail");
                                   return new PasswordAuthentication(emailOrigem, senhaEmailOrigem);
                             }
                        });

            // Ativa Debug para sessão 
            session.setDebug(true);
            try {
                // cria a primeira parte da mensagem
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setText(TextoDoEmail);
                // cria a segunda parte da mensage
                MimeBodyPart mbp2 = new MimeBodyPart();
                // anexa o arquivo na mensagem
                FileDataSource fds = new FileDataSource(caminhoAnexo);
                mbp2.setDataHandler(new DataHandler(fds));
                mbp2.setFileName(fds.getName());
                // cria a Multipart
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                mp.addBodyPart(mbp2);
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(emailOrigem)); //Remetente
                  message.setRecipients(Message.RecipientType.TO, 
                  InternetAddress.parse(emailDoCliente)); //Destinatário(s)
                  message.setSubject(assunto);//Assunto
                  // adiciona a Multipart na mensagem
                  message.setContent(mp);
                  //Método para enviar a mensagem criada
                  Transport.send(message);
                  JOptionPane.showMessageDialog(null, "Pedido enviado para o email do cliente!");

             } catch (MessagingException e) {
                  GeradorTXT.GeraTxtDeErro("Erro ao enviar email - " + e.getMessage());
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
      
}
