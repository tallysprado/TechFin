package login.utils;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author root
 */
public class Email {

    public void sendEmail(int t, String email) {
        this.email(t, email);
    }

    private static void email(int t, String email) {

        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        // Get a Properties object
        Properties props = System.getProperties();

        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        final String username = "tallysprado@alu.ufc.br";//
        final String password = "SiliconValley!123";
        try {
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            // -- Create a new message --
            Message msg = new MimeMessage(session);

            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress("tallys.prado@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email, false));
            msg.setSubject("TOKEN FINTECHONOLIGAS D++");
            msg.setText(String.valueOf(t));
            msg.setSentDate(new Date());

            Transport.send(msg);
            System.out.println("Sucesso!");
        } catch (MessagingException e) {
            System.out.println("Falha no engano: " + e);
        }
    }

    public void sendAttachEmail(String to, String subject, String body, String attach) {
        Properties p = getProps();
        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);
        MimeBodyPart mbp = new MimeBodyPart();
        try {
            // "de" e "para"!!
            msg.setFrom(new InternetAddress("tallysprado@alu.ufc.br"));
            
            msg.setRecipients(Message.RecipientType.TO, to);
            msg.setSentDate(new Date());
            msg.setSubject(subject);
            msg.setText(body);
            //enviando anexo
            DataSource fds = new FileDataSource(attach);
            mbp.setDisposition(Part.ATTACHMENT);
            mbp.setDataHandler(new DataHandler(fds));
            mbp.setFileName(fds.getName());
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp);
            msg.setContent(mp);
            // enviando mensagem
            Transport.send(msg);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Enviado com sucesso!");
    }
    
    private static Properties getProps() {
        Properties p = new Properties();
        p.put("mail.transport.protocol", "smtp");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.auth", "true");
        return p;
    }
    
    
 
}

class SMTPAuthenticator extends javax.mail.Authenticator {

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("tallysprado@alu.ufc.br", "SiliconValley!123");
    }

}
