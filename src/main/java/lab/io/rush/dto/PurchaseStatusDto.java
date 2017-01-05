package lab.io.rush.dto;

public class PurchaseStatusDto {
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
}
