package lab.io.rush.service;

/**
 * �������ӿ�
 * @author cqy
 * @data 2017��1��6�� ����11:10:19
 */
public interface EmailService {

	/**
	 * �����ʼ�
	 * @param toEmail ��������
	 * @param title �ʼ�����
	 * @param content �ʼ�����
	 * @return ���ͽ��
	 */
	boolean sendEmail(String toEmail, String title, String content);
}
