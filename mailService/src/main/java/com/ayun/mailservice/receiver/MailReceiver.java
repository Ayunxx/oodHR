package com.ayun.mailservice.receiver;

import com.oodhr.admin.entity.EmployeeEntity;
import com.oodhr.admin.entity.MailConstants;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;

/**
 * @auther Ayun
 * @date 2022/9/3 13:46
 */
public class MailReceiver {

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    MailProperties mailProperties;
    @Autowired
    TemplateEngine templateEngine;
    @Autowired
    StringRedisTemplate redisTemplate;

    @RabbitListener(queues = MailConstants.MAIL_QUEUE_NAME)
    public void handler(Message message, Channel channel) throws IOException {
        EmployeeEntity employee = (EmployeeEntity)message.getPayload();
        MessageHeaders headers = message.getHeaders();
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        String msgId = (String) headers.get("spring_returned_message_correlation");
        if (redisTemplate.opsForHash().entries("mail_log").containsKey(msgId)) {
            //redis ???????????? key????????????????????????????????????
            channel.basicAck(tag, false);//?????????????????????
        }
        //???????????????????????????
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);
        try {
            helper.setTo(employee.getEmail());
            helper.setFrom(mailProperties.getUsername());
            helper.setSubject("????????????");
            helper.setSentDate(new Date());
            Context context = new Context();
            context.setVariable("name", employee.getEmpName());
            context.setVariable("posName", employee.getPosname());
            context.setVariable("joblevelName", employee.getJoblevelname());
            context.setVariable("departmentName", employee.getDepartmentname());
            String mail = templateEngine.process("mail", context);
            helper.setText(mail, true);
            javaMailSender.send(msg);
            redisTemplate.opsForHash().put("mail_log", msgId, "ayun");
            channel.basicAck(tag, false);
            System.out.println("????????????");
        } catch (MessagingException e) {
            channel.basicNack(tag, false, true);
            e.printStackTrace();
            System.out.println("????????????");
        }

    }
}
