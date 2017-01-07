package lab.io.rush.dao;

import org.springframework.cache.annotation.Cacheable;

import lab.io.rush.model.User;

/**
 * �û��������ݲ�ӿ�
 * @author cqy
 * @data 2017��1��6�� ����11:13:03
 */
public interface UserDao {

	/**
	 * �����û���¼
	 * @param user �û�����
	 * @return ������
	 */
	boolean insert(User user);
	
	/**
	 * �����û���Ų����û�
	 * @param uid �û����
	 * @return �û�����
	 */
	@Cacheable(value = "User", key = "'User-id:'+#uid")
	User selectById(String uid);

	/**
	 * ������������û�
	 * @param email ����
	 * @return �û�����
	 */
	@Cacheable(value = "User", key = "'User-email:'+#email")
	User selectByEmail(String email);

	/**
	 * �����������������û�
	 * @param email ����
	 * @param password ����
	 * @return �û�����
	 */
	@Cacheable(value = "User", key = "'User-email-password:'+#email+'-'+#password")
	User selectByEmailAndPassword(String email, String password);
}
