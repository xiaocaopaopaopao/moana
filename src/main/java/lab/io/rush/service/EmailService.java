package lab.io.rush.service;

/**
 * 邮箱服务接口
 * @author cqy
 * @data 2017年1月6日 上午11:10:19
 */
public interface EmailService {

	/**
	 * 发送邮件
	 * @param toEmail 接收邮箱
	 * @param title 邮件标题
	 * @param content 邮件内容
	 * @return 发送结果
	 */
	boolean sendEmail(String toEmail, String title, String content);
}
