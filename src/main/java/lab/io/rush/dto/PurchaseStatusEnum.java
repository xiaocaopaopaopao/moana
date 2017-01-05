package lab.io.rush.dto;

public enum PurchaseStatusEnum {
	NOT_ENOUGH(-3, "¿â´æ²»×ã£¡"), 
	PURCHASE_FAIL(-2, "ÇÀ¹ºÊ§°Ü£¡"), 
	REPEAT_PURCHASE(-1, "ÖØ¸´ÇÀ¹º£¡"), 
	PURCHASE_ERROR(0, "ÇÀ¹º´íÎó£¡"), 
	SUCCESS(1, "ÇÀ¹º³É¹¦£¡");

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
