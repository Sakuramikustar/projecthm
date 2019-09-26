package cn.ph.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class EmailUtill {
    @Autowired
    JavaMailSenderImpl emailSender;
    @Value("${email.username}")
    private String username;

    //@Async
    public void sendMail(String sendTo,String title,String content) throws Exception{
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);//发送人
        mailMessage.setTo(sendTo);//收件人
        mailMessage.setSubject(title);//标题
        mailMessage.setText(content);//内容

        emailSender.send(mailMessage);

    }
}
