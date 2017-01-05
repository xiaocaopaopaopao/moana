package lab.io.rush.service;

public interface EmailService {

	boolean sendEmail(String toEmail, String title, String content);
}
