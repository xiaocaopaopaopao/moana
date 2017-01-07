package lab.io.rush.dto;

/**
 * 用户状态枚举
 * @author cqy
 * @data 2017年1月6日 上午11:44:07
 */
public enum UserStatusEnum {
	REGISTER_SUCCESS(101, "注册成功！"),
	EMAIL_EXIT(102, "邮箱已经注册！"), 
	REGISTER_FAIL(103, "注册失败！"),
	REGISTER_ERROR(104, "系统异常,注册失败！"),
	LOGIN_SUCCESS(201,"登录成功！"),
	LOGIN_FAIL(202, "登录失败！"),
	LOGIN_ERROR(203, "系统异常,登录失败！"),
	LOGOUT_SUCCESS(301,"登出成功！"),
	USER_NO_LOGIN(302,"您未登录！");

	private int code;
	private String message;

	private UserStatusEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
