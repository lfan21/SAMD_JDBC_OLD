package com.samd.utiles;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

public class Correo {

    private String asunto;
    private String destinatario;
    private String mensaje;

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void enviarCorreo() {

        String emisor = "udesamd@gmail.com";
        String contrasenia = "UDESAMD123456";

        // La configuración para enviar correo
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.user", emisor);
        properties.put("mail.password", contrasenia);

        // Obtener la sesion
        Session session = Session.getInstance(properties, null);

        try {
            // Crear el cuerpo del mensaje
            MimeMessage mimeMessage = new MimeMessage(session);

            // Agregar quien envía el correo
            mimeMessage.setFrom(new InternetAddress(emisor, "SAMD"));

            // Los destinatarios
            InternetAddress internetAddress = new InternetAddress(this.destinatario);

            // Agregar los destinatarios al mensaje
            mimeMessage.setRecipient(Message.RecipientType.TO, internetAddress);

            // Agregar el asunto al correo
            mimeMessage.setSubject(this.asunto);

            // Creo la parte del mensaje
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText(this.mensaje);

            // Crear el multipart para agregar la parte del mensaje anterior
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            // Agregar el multipart al cuerpo del mensaje
            mimeMessage.setContent(multipart);

            // Enviar el mensaje
            Transport transport = session.getTransport("smtp");
            transport.connect(emisor, contrasenia);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }     
    
}
