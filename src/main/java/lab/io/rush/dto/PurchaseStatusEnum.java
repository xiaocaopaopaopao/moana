package lab.io.rush.dto;

public enum PurchaseStatusEnum {
	NOT_ENOUGH(-3, "��治�㣡"), 
	PURCHASE_FAIL(-2, "����ʧ�ܣ�"), 
	REPEAT_PURCHASE(-1, "�ظ�������"), 
	PURCHASE_ERROR(0, "��������"), 
	SUCCESS(1, "�����ɹ���");

	private int code;
	private String message;

	private PurchaseStatusEnum(int code, String message) {
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
