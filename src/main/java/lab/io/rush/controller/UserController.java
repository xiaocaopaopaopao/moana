package lab.io.rush.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.io.rush.dto.UserStatusDto;
import lab.io.rush.dto.UserStatusEnum;
import lab.io.rush.model.User;
import lab.io.rush.service.UserService;
import lab.io.rush.util.ResponseHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 用户服务Web接口
 * @author cqy
 * @data 2017年1月6日 上午11:34:35
 */
@Controller
@RequestMapping("/user")
public class UserController extends MultiActionController {

	@Autowired
	private UserService userService;

	/**
	 * 注册接口
	 * @param email 邮箱
	 * @param password 密码
	 */
	@RequestMapping(value = { "/register.do" }, method = { RequestMethod.POST })
	public void register(HttpServletResponse response,
			@RequestParam("email") String email,
			@RequestParam("password") String password) {
		UserStatusDto userStatusDto = null;
		try {
			// 检查邮箱是否已经被注册
			boolean isReg = userService.isUserRegistered(email);
			if (isReg)
				userStatusDto = new UserStatusDto(UserStatusEnum.EMAIL_EXIT);
			else {
				User user = new User();
				user.setUsername(email);
				user.setPassword(password);
				user.setEmail(email);
				user.setRegisterTime(new Timestamp(new Date().getTime()));
				// 注册用户
				userStatusDto = userService.register(user);
			}
		} catch (Exception e) {
			if(userStatusDto == null)
				userStatusDto = new UserStatusDto(UserStatusEnum.REGISTER_ERROR);
			e.printStackTrace();
		}
		//返回
		new ResponseHelper().send(response, userStatusDto);
	}

	/**
	 * 登录接口
	 * @param session 当前session对象 
	 * @param email 邮箱
	 * @param password 密码
	 */
	@RequestMapping(value = { "/login.do" }, method = { RequestMethod.POST })
	public void login(HttpSession session, HttpServletResponse response,
			@RequestParam("email") String email,
			@RequestParam("password") String password) {
		UserStatusDto userStatusDto = null;
		try {
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			// 用户登录
			User u = userService.login(user);
			if (u != null) {
				user.setUid(u.getUid());
				user.setEmail(email);
				user.setPassword(null);
				session.setAttribute("user", user);
				userStatusDto = new UserStatusDto(UserStatusEnum.LOGIN_SUCCESS);
			} else
				userStatusDto = new UserStatusDto(UserStatusEnum.LOGIN_FAIL);
		} catch (Exception e) {
			if(userStatusDto == null)
				userStatusDto = new UserStatusDto(UserStatusEnum.LOGIN_ERROR);
			e.printStackTrace();
		}
		//返回
		new ResponseHelper().send(response, userStatusDto);
	}

	/**
	 * 登出接口
	 * @param session 当前session对象
	 */
	@RequestMapping(value = { "/logout.do" }, method = { RequestMethod.GET })
	public void logout(HttpSession session, HttpServletResponse response) {
		UserStatusDto userStatusDto = null;
		if(session.getAttribute("user") != null){
			session.removeAttribute("user");
			userStatusDto = new UserStatusDto(UserStatusEnum.LOGOUT_SUCCESS);
		}else
			userStatusDto = new UserStatusDto(UserStatusEnum.USER_NO_LOGIN);
		//返回
		new ResponseHelper().send(response, userStatusDto);
	}
}
