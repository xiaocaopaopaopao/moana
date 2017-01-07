package lab.io.rush.service;

import lab.io.rush.dto.UserStatusDto;
import lab.io.rush.model.User;

/**
 * 用户服务层接口
 * @author cqy
 * @data 2017年1月6日 上午11:00:13
 */
public interface UserService {
	
	/**
	 * 登录方法
	 * @param user 用户临时对象
	 * @return 用户对象
	 */
	User login(User user);
	
	/**
	 * 注册方法
	 * @param user 用户临时对象
	 * @return 注册状态
	 */
	UserStatusDto register(User user);
	
	/**
	 * 检查用户名是否已注册
	 * @param username 用户名
	 * @return 检查结果
	 */
	boolean isUserRegistered(String username);
}
