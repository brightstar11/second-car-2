package com.xh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xh.service.MailService;

/**
 *
 * 邮件服务类
 * Created by ASUS on 2018/5/5
 *
 * @Authod Grey Wolf
 */

@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;
        //读取application.properties的内容
         @Value("${spring.mail.username}")
    private String form;
    /**
     * 发送简单邮件
     * @param to 接受者
     * @param subject 主题
     * @param content 内容
     */
    @Override
    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(form);//发起者
        mailMessage.setTo(to);//接受者

    //如果发给多个人的：
     //mailMessage.setTo("1xx.com","2xx.com","3xx.com");    
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        try {
            mailSender.send(mailMessage);
            System.out.println("发送简单邮件");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("发送简单邮件失败");
        }
    }
}