package lab.io.rush.service.impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import lab.io.rush.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	private BlockingQueue<SimpleMailMessage> messageQueue;
	private Thread thread;

	public EmailServiceImpl() {
		messageQueue = new LinkedBlockingQueue<>();
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					SimpleMailMessage message;
					try {
						message = messageQueue.take();
						mailSender.send(message);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	@Override
	public boolean sendEmail(String email, String title, String content) {
		SimpleMailMessage message = createMessage(email, title, content);
		try {
			messageQueue.put(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private SimpleMailMessage createMessage(String email, String title,
			String content) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom("hfut_caoqunying@163.com");
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject(title);
		simpleMailMessage.setText(content);
		return simpleMailMessage;
	}
}
