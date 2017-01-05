package lab.io.rush.dto;

import org.json.JSONObject;

public class UserStatusDto {
	private boolean status;
	private int code;
	private String message;

	public UserStatusDto(UserStatusEnum statusEnum) {
		this.code = statusEnum.getCode();
		this.message = statusEnum.getMessage();
		if (statusEnum == UserStatusEnum.REGISTER_SUCCESS
				|| statusEnum == UserStatusEnum.LOGIN_SUCCESS
				|| statusEnum == UserStatusEnum.LOGOUT_SUCCESS)
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

	public JSONObject toJson() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", code);
		jsonObject.put("message", message);
		return jsonObject;
	}
}
