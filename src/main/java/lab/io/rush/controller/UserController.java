package lab.io.rush.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.io.rush.dto.UserStatusDto;
import lab.io.rush.dto.UserStatusEnum;
import lab.io.rush.model.User;
import lab.io.rush.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@RequestMapping("/user")
public class UserController extends MultiActionController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/register.do" }, method = { RequestMethod.POST })
	public void register(HttpServletResponse response,
			@RequestParam("email") String email,
			@RequestParam("password") String password) {
		UserStatusDto userStatusDto = null;
		PrintWriter out = null;
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
			userStatusDto = new UserStatusDto(UserStatusEnum.REGISTER_ERROR);
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			out = response.getWriter();
			out.write(userStatusDto.toJson().toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}

	@RequestMapping(value = { "/login.do" }, method = { RequestMethod.POST })
	public void login(HttpSession session, HttpServletResponse response,
			@RequestParam("email") String email,
			@RequestParam("password") String password) {
		UserStatusDto userStatusDto = null;
		PrintWriter out = null;
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
			e.printStackTrace();
			userStatusDto = new UserStatusDto(UserStatusEnum.LOGIN_ERROR);
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			out = response.getWriter();
			out.write(userStatusDto.toJson().toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}

	@RequestMapping(value = { "/logout.do" }, method = { RequestMethod.GET })
	public void logout(HttpSession session, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		try {
			session.removeAttribute("user");
			UserStatusDto userStatusDto = new UserStatusDto(
					UserStatusEnum.LOGOUT_SUCCESS);
			response.getWriter().write(userStatusDto.toJson().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
