package lab.io.rush.dao;

import org.springframework.cache.annotation.Cacheable;

import lab.io.rush.model.User;

/**
 * 用户服务数据层接口
 * @author cqy
 * @data 2017年1月6日 上午11:13:03
 */
public interface UserDao {

	/**
	 * 插入用户记录
	 * @param user 用户对象
	 * @return 插入结果
	 */
	boolean insert(User user);
	
	/**
	 * 根据用户编号查找用户
	 * @param uid 用户编号
	 * @return 用户对象
	 */
	@Cacheable(value = "User", key = "'User-id:'+#uid")
	User selectById(String uid);

	/**
	 * 根据邮箱查找用户
	 * @param email 邮箱
	 * @return 用户对象
	 */
	@Cacheable(value = "User", key = "'User-email:'+#email")
	User selectByEmail(String email);

	/**
	 * 根据邮箱和密码查找用户
	 * @param email 邮箱
	 * @param password 密码
	 * @return 用户对象
	 */
	@Cacheable(value = "User", key = "'User-email-password:'+#email+'-'+#password")
	User selectByEmailAndPassword(String email, String password);
}
