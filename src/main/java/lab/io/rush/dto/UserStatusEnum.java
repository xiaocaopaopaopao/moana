package lab.io.rush.dto;


public enum UserStatusEnum {
	REGISTER_SUCCESS(101, "×¢²á³É¹¦£¡"),
	EMAIL_EXIT(102, "ÓÊÏäÒÑ¾­×¢²á£¡"), 
	REGISTER_FAIL(103, "×¢²áÊ§°Ü£¡"),
	REGISTER_ERROR(104, "×¢²á´íÎó£¡"),
	LOGIN_SUCCESS(201,"µÇÂ¼³É¹¦£¡"),
	LOGIN_FAIL(202, "µÇÂ¼Ê§°Ü£¡"),
	LOGIN_ERROR(203, "µÇÂ¼´íÎó£¡"),
	LOGOUT_SUCCESS(301,"µÇ³ö³É¹¦£¡"),
	LOGOUT_FAIL(302,"µÇ³öÊ§°Ü£¡"),
	LOGOUT_ERROR(303,"µÇ³ö´íÎó£¡");

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
