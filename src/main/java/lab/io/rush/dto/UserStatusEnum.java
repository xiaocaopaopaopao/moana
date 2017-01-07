package lab.io.rush.dto;

/**
 * �û�״̬ö��
 * @author cqy
 * @data 2017��1��6�� ����11:44:07
 */
public enum UserStatusEnum {
	REGISTER_SUCCESS(101, "ע��ɹ���"),
	EMAIL_EXIT(102, "�����Ѿ�ע�ᣡ"), 
	REGISTER_FAIL(103, "ע��ʧ�ܣ�"),
	REGISTER_ERROR(104, "ϵͳ�쳣,ע��ʧ�ܣ�"),
	LOGIN_SUCCESS(201,"��¼�ɹ���"),
	LOGIN_FAIL(202, "��¼ʧ�ܣ�"),
	LOGIN_ERROR(203, "ϵͳ�쳣,��¼ʧ�ܣ�"),
	LOGOUT_SUCCESS(301,"�ǳ��ɹ���"),
	USER_NO_LOGIN(302,"��δ��¼��");

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
