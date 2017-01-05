package lab.io.rush.dto;

public enum PurchaseStatusEnum {
	NOT_ENOUGH(201, "��治�㣡"), 
	PURCHASE_FAIL(202, "����ʧ�ܣ�"), 
	MORE_THAN_NUM(203, "����Ʊ���������"), 
	PURCHASE_ERROR(204, "��������"), 
	SUCCESS(101, "�����ɹ���");

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
