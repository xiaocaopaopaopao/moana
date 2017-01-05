package lab.io.rush.dto;

public enum PurchaseStatusEnum {
	NOT_ENOUGH(201, "库存不足！"), 
	PURCHASE_FAIL(202, "抢购失败！"), 
	MORE_THAN_NUM(203, "购买票数超出定额！"), 
	PURCHASE_ERROR(204, "抢购错误！"), 
	SUCCESS(101, "抢购成功！我们将以邮件方式通知您。");

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
