package com.atguigu.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot04TaskApplicationTests {

	@Autowired
	JavaMailSenderImpl mailSender;

	@Test
	public void contextLoads() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		//邮件设置
		simpleMailMessage.setSubject("通知-今晚开会");
		simpleMailMessage.setText("今晚7:30开会");
		simpleMailMessage.setTo("lxmjava101@163.com");
		simpleMailMessage.setFrom("1003527652@qq.com");
		mailSender.send(simpleMailMessage);
	}

	@Test
	public void test02() throws Exception {
		//1、创建一个复杂的消息邮件
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		//邮件设置
		helper.setSubject("通知-今晚开会2");
		helper.setText("<b style='color:red'>今晚7:30开会</b>",true);
		helper.setTo("lxmjava101@163.com");
		helper.setFrom("1003527652@qq.com");

		//上传文件
		helper.addAttachment("1.png",new File("C:\\Users\\Administrator\\Desktop\\1.png"));
		helper.addAttachment("2.jpg",new File("C:\\Users\\Administrator\\Desktop\\2.jpg"));
		mailSender.send(mimeMessage);
	}
}
