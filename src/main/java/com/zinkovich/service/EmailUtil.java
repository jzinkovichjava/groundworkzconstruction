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

    public static void sendMessage(String to, String subject, String content) throws MessagingException {

        final String username = "info@groundworkzconstruction.com";
        final String password = "Infogwc16@";
        String host = "groundworkzconstruct.ipage.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }


}
