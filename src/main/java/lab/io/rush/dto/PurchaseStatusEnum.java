package lab.io.rush.dto;

public enum PurchaseStatusEnum {
	NOT_ENOUGH(201, "¿â´æ²»×ã£¡"), 
	PURCHASE_FAIL(202, "ÇÀ¹ºÊ§°Ü£¡"), 
	MORE_THAN_NUM(203, "¹ºÂòÆ±Êý³¬³ö¶¨¶î£¡"), 
	PURCHASE_ERROR(204, "ÇÀ¹º´íÎó£¡"), 
	SUCCESS(101, "ÇÀ¹º³É¹¦£¡");

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
