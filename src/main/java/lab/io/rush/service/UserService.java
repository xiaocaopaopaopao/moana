package lab.io.rush.service;

import lab.io.rush.dto.UserStatusDto;
import lab.io.rush.model.User;

/**
 * �û������ӿ�
 * @author cqy
 * @data 2017��1��6�� ����11:00:13
 */
public interface UserService {
	
	/**
	 * ��¼����
	 * @param user �û���ʱ����
	 * @return �û�����
	 */
	User login(User user);
	
	/**
	 * ע�᷽��
	 * @param user �û���ʱ����
	 * @return ע��״̬
	 */
	UserStatusDto register(User user);
	
	/**
	 * ����û����Ƿ���ע��
	 * @param username �û���
	 * @return �����
	 */
	boolean isUserRegistered(String username);
}
