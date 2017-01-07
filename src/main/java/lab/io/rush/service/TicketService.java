package lab.io.rush.service;

import lab.io.rush.dto.PurchaseStatusDto;

/**
 * Ʊ�����ӿ�
 * @author cqy
 * @data 2017��1��6�� ����11:06:55
 */
public interface TicketService {

	/**
	 * �����Ʊ����
	 * @param tid ��ӰƱ���
	 * @return ��Ʊ����
	 */
	int getTicketNum(String tid);

	/**
	 * ��Ʊ����
	 * @param uid �û����
	 * @param tid ��ӰƱ���
	 * @param num ��������
	 * @return ����״̬
	 */
	PurchaseStatusDto snapMovieTicket(String uid, String tid, int num);
}
