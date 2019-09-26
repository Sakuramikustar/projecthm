import cn.ph.utils.EmailUtill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.internet.MimeMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class testmail {
//    @Autowired
//    EmailUtill emailUtill;
    @Autowired
    JavaMailSenderImpl emailSender;

    @Value("${email.username}")
    private String username;

    //简单邮件
    @Test
    public void SimpleMailMessage() throws Exception{
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);//        发送人
        mailMessage.setTo("434900310@qq.com");//          收件人
        mailMessage.setSubject("233");//               标题
        mailMessage.setText("233");            //            内容
        emailSender.send(mailMessage);
    }
    //html文件
    @Test
    public void htmlMailMessage() {
        MimeMessage mimeMsg = emailSender.createMimeMessage();
        try {
            String html = "<h1>233</h1>";
            MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true);
            helper.setTo(username);
            helper.setFrom("434900310@qq.com");
            helper.setSubject("233");
            helper.setText(html, true);
            emailSender.send(mimeMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
