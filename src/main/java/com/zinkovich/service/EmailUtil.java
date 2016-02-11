package com.zinkovich.service;

import com.sun.mail.smtp.SMTPTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by jrzinkovich on 2/10/16.
 */
public class EmailUtil {


    public static void sendFromGMail(String emailTo, String subject, String body) {
        final String GMAIL_USERNAME = "jennifer.zinkovich@gmail.com";
        final String GMAIL_PASSWORD = "UrmysunshineBaxBailey@";
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", GMAIL_USERNAME);
        props.put("mail.smtp.password", GMAIL_PASSWORD);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", 465);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");

        String[] to = {emailTo};

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(GMAIL_USERNAME));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);

            Transport transport = session.getTransport("smtps");
            transport.connect(host, 465, GMAIL_USERNAME, GMAIL_PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
