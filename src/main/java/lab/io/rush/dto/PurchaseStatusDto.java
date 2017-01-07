package lab.io.rush.dto;

import org.json.JSONObject;

/**
 * 购票状态DTO
 * @author cqy
 * @data 2017年1月6日 上午11:40:27
 */
public class PurchaseStatusDto implements Dto{
	private boolean status;
	private int code;
	private String message;

	public PurchaseStatusDto(PurchaseStatusEnum statusEnum) {
		this.code = statusEnum.getCode();
		this.message = statusEnum.getMessage();
		if (statusEnum == PurchaseStatusEnum.SUCCESS)
			this.status = true;
		else
			this.status = false;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	@Override
	public JSONObject toJson() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", code);
		jsonObject.put("message", message);
		return jsonObject;
	}
}
