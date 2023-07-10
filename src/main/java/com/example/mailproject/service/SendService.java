package com.example.mailproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class SendService {

    @Autowired
    JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    String sendFrom;

    @Autowired
    Environment env;

    public boolean sendMail() {
        String sendTo = "hghgusrl@naver.com";
        String mailTitle = "Mail Title";
        String mailContent = "Mail Content";

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true,"UTF-8");

                message.setTo(sendTo);
                message.setFrom(sendFrom);
                message.setSubject(mailTitle);
                message.setText(mailContent, true); //ture : html 형식 사용
                //Mail에 img 삽입
                ClassPathResource resource = new ClassPathResource("test.png");
                message.addInline("img", resource.getFile());
            }
        };

        try{
            mailSender.send(preparator);
        } catch (MailException e){
            System.out.println(e);
            return false;
        }
        return true;
    }
}
