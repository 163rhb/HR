package org.rhb.mailserver.receiver;

import org.rhb.vhr.model.Employee;
import org.rhb.vhr.model.Hr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class MailReceiver {
    public static final Logger logger = getLogger(MailReceiver.class);

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    MailProperties mailProperties;
    @Autowired
    TemplateEngine templateEngine;

    @RabbitListener(queues = "rhb.mail")
    public void handler(Employee employee)  {
        logger.info(employee.toString());
        //收到消息，发送邮件
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg);
        try {
            mimeMessageHelper.setFrom(mailProperties.getUsername());
            mimeMessageHelper.setTo(employee.getEmail());
            mimeMessageHelper.setSubject("入职欢迎");
            mimeMessageHelper.setSentDate(new Date());
            Context context = new Context();
            context.setVariable("posName", employee.getPosition().getName());
            context.setVariable("name", employee.getName());
            context.setVariable("joblevelName", employee.getJobLevel().getName());
            context.setVariable("departmentName", employee.getDepartment().getName());
            String mail = templateEngine.process("mail", context);
            mimeMessageHelper.setText(mail, true);
            javaMailSender.send(msg);
        }catch (MessagingException e) {
            /*e.printStackTrace();
            logger.error("邮件发送失败："+e.getMessage());*/
        }


    }



}
