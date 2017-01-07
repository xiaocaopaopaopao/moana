package lab.io.rush.dto;

/**
 * ��Ʊ״̬ö��
 * @author cqy
 * @data 2017��1��6�� ����11:41:55
 */
public enum PurchaseStatusEnum {
	NOT_ENOUGH(201, "��治�㣡"), 
	PURCHASE_FAIL(202, "����ʧ�ܣ�"), 
	MORE_THAN_NUM(203, "�������ӰƱ�����������"), 
	PURCHASE_ERROR(204, "ϵͳ�쳣,����ʧ�ܣ�"), 
	SUCCESS(101, "�����ɹ������ǽ����ʼ���ʽ֪ͨ����");

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
