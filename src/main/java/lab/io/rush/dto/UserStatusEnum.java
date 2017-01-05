package lab.io.rush.dto;


public enum UserStatusEnum {
	REGISTER_SUCCESS(101, "ע��ɹ���"),
	EMAIL_EXIT(102, "�����Ѿ�ע�ᣡ"), 
	REGISTER_FAIL(103, "ע��ʧ�ܣ�"),
	REGISTER_ERROR(104, "ע�����"),
	LOGIN_SUCCESS(201,"��¼�ɹ���"),
	LOGIN_FAIL(202, "��¼ʧ�ܣ�"),
	LOGIN_ERROR(203, "��¼����"),
	LOGOUT_SUCCESS(301,"�ǳ��ɹ���"),
	LOGOUT_FAIL(302,"�ǳ�ʧ�ܣ�"),
	LOGOUT_ERROR(303,"�ǳ�����");

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
