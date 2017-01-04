package lab.io.rush.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.io.rush.model.User;
import lab.io.rush.service.UserService;
import lab.io.rush.util.StaticVar;

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
		PrintWriter out = null;
		try {
			String result = null;
			out = response.getWriter();
			// 检查邮箱是否已经被注册
			boolean isReg = userService.isUserRegistered(email);
			if (isReg)
				result = StaticVar.EmailIsRegistered;
			else {
				User user = new User();
				user.setUsername(email);
				user.setPassword(password);
				user.setEmail(email);
				user.setRegisterTime(new Timestamp(new Date().getTime()));
				// 注册用户，若成功则返回true，否则返回false
				boolean isRegSucceed = userService.register(user);
				if (isRegSucceed)
					result = StaticVar.RegisterSuccess;
				else
					result = StaticVar.RegisterFailed;
			}
			out.write(result);
		} catch (Exception e) {
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
		PrintWriter out = null;
		try {
			String result = null;
			out = response.getWriter();
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			// 用户登录，若成功则返回true，否则返回false
			User u = userService.login(user);
			if (u != null) {
				u.setPassword(null);
				session.setAttribute("user", user);
				result = StaticVar.LoginSuccess;
			} else
				result = StaticVar.LoginFailed;
			out.write(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}

	@RequestMapping(value = { "/logout.do" }, method = { RequestMethod.GET })
	public void logout(HttpSession session, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			session.removeAttribute("user");
			out = response.getWriter();
			out.write(StaticVar.LogoutSuccess);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}
}
