package lab.io.rush.dto;

/**
 * 购票状态枚举
 * @author cqy
 * @data 2017年1月6日 上午11:41:55
 */
public enum PurchaseStatusEnum {
	NOT_ENOUGH(201, "库存不足！"), 
	PURCHASE_FAIL(202, "抢购失败！"), 
	MORE_THAN_NUM(203, "您购买电影票数量超出定额！"), 
	PURCHASE_ERROR(204, "系统异常,抢购失败！"), 
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
