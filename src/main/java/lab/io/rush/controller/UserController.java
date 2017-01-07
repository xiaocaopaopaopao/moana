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
 * �û�����Web�ӿ�
 * @author cqy
 * @data 2017��1��6�� ����11:34:35
 */
@Controller
@RequestMapping("/user")
public class UserController extends MultiActionController {

	@Autowired
	private UserService userService;

	/**
	 * ע��ӿ�
	 * @param email ����
	 * @param password ����
	 */
	@RequestMapping(value = { "/register.do" }, method = { RequestMethod.POST })
	public void register(HttpServletResponse response,
			@RequestParam("email") String email,
			@RequestParam("password") String password) {
		UserStatusDto userStatusDto = null;
		try {
			// ��������Ƿ��Ѿ���ע��
			boolean isReg = userService.isUserRegistered(email);
			if (isReg)
				userStatusDto = new UserStatusDto(UserStatusEnum.EMAIL_EXIT);
			else {
				User user = new User();
				user.setUsername(email);
				user.setPassword(password);
				user.setEmail(email);
				user.setRegisterTime(new Timestamp(new Date().getTime()));
				// ע���û�
				userStatusDto = userService.register(user);
			}
		} catch (Exception e) {
			if(userStatusDto == null)
				userStatusDto = new UserStatusDto(UserStatusEnum.REGISTER_ERROR);
			e.printStackTrace();
		}
		//����
		new ResponseHelper().send(response, userStatusDto);
	}

	/**
	 * ��¼�ӿ�
	 * @param session ��ǰsession���� 
	 * @param email ����
	 * @param password ����
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
			// �û���¼
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
		//����
		new ResponseHelper().send(response, userStatusDto);
	}

	/**
	 * �ǳ��ӿ�
	 * @param session ��ǰsession����
	 */
	@RequestMapping(value = { "/logout.do" }, method = { RequestMethod.GET })
	public void logout(HttpSession session, HttpServletResponse response) {
		UserStatusDto userStatusDto = null;
		if(session.getAttribute("user") != null){
			session.removeAttribute("user");
			userStatusDto = new UserStatusDto(UserStatusEnum.LOGOUT_SUCCESS);
		}else
			userStatusDto = new UserStatusDto(UserStatusEnum.USER_NO_LOGIN);
		//����
		new ResponseHelper().send(response, userStatusDto);
	}
}
